import java.util.Vector;

public class Ray {
	Vector<Hit> hitListCube = new Vector<Hit>();//hit list for hitting the cube
	Vector<Hit> hitListCylinder = new Vector<Hit>();//hit list for hitting the cylinder
	Vector<Hit> hitList = new Vector<Hit>();
	Vector<Hit> hitList1 = new Vector<Hit>();
	Vector<Hit> hitList2 = new Vector<Hit>();
	Vector<Hit> hitList3 = new Vector<Hit>();
	double [] v = new double [3];
	double [] w = new double [3];
	
	public int sizeHitList1(){return hitList1.size();}
	public int sizeHitList2(){return hitList2.size();}
	public int sizeHitList3(){return hitList3.size();}

	public Ray(double [] origin, double [] direction){
		for (int i = 0; i < 3; i++){
			v[i] = origin[i];
			w[i] = direction[i];
		}
	}
	//called by traceRayToPlane(), add the hit to the hit list according to surface id
	public void addHit(double t, int id, int sign, Plane p){
		if (id >= 0 && id <= 5){
			hitListCube.add(new Hit(t, id, sign));
			hitListCube.get(hitListCube.size() - 1).setCoefficients(p);
		}
		else{
			hitListCylinder.add(new Hit(t, id, sign));
			hitListCylinder.get(hitListCylinder.size() - 1).setCoefficients(p);
		}
	}
	
	//called by traceRayToSOS(), add the hit to the hitListCylinder
	public void addHit(double t, int id, int sign, SecondOrderSurface s){
		hitListCylinder.add(new Hit(t, id, sign));
		hitListCylinder.get(hitListCylinder.size() - 1).setCoefficients(s);
	}
	
	//called by RayTracing2, compute the t of hitting surface[id]
	public void traceRayToPlane(Plane p, int id, Cube c, Cylinder cy){
		double A, B, t;
		int sign;
		boolean inOrOut;
		A = p.a*w[0] + p.b*w[1] + p.c*w[2];
		//System.out.println(A);
		if (A == 0) {
			return ;
		}
		else{
			B = p.a*v[0] + p.b*v[1] + p.c*v[2] + p.d;
			t = -1 * B / A;
			//System.out.println(t);
			//System.out.println(id);
			if (id <= 5 && id >= 0) inOrOut = c.inCube(v, w, t, id);
			else inOrOut = cy.inCylinder(v, w, t, id);
			if(t > 0 && inOrOut){
				if (0 <= p.a*v[0] + p.b*v[1] + p.c*v[2] + p.d) sign = 1;
				else sign = -1;
				addHit(t, id, sign, p);
			}
		}
	}
	
	//TRACE RAY TO SECOND ORDER SURFACE
	public void traceRayToSOS(SecondOrderSurface s, int id, Cylinder cy){
		double A, B, C, t1, t2, discriminant;
		int sign1, sign2;
		sign1 = 0;
		sign2 = 0;
		
		A = s.a*w[0]*w[0] + s.b*w[1]*w[1] + s.c*w[2]*w[2] + s.d*w[1]*w[2] + s.e*w[0]*w[2]
		  + s.f*w[0]*w[1];
		B = 2*s.a*v[0]*w[0] + 2*s.b*v[1]*w[1] + 2*s.c*v[2]*w[2]
		  + s.d*(v[1]*w[2] + v[2]*w[1]) + s.e*(v[0]*w[2] + v[2]*w[0]) + s.f*(v[0]*w[1] + v[1]*w[0])
		  + s.g*w[0] + s.h*w[1] + s.i*w[2];
		C = s.a*v[0]*v[0] + s.b*v[1]*v[1] + s.c*v[2]*v[2] + s.d*v[1]*v[2] + s.e*v[0]*v[2] + s.f*v[0]*v[1]
		  + s.g*v[0] + s.h*v[1] + s.i*v[2] + s.j;
		
		discriminant = B*B - 4*A*C;
		if (discriminant <= 0){
			return ;
		}
		else {
			discriminant = Math.sqrt(discriminant);
			t1 = (-1 * B - discriminant) / (2*A);
			t2 = (-1 * B + discriminant) / (2*A);
			if (t2 <= 0){
				return ;
			}
			else if(t1 <= 0){
				sign2 = -1;
			}
			else{
				sign1 = 1;
				sign2 = -1;
			}
			if (t1 > 0 && cy.inCylinder(v, w, t1, id)){
				addHit(t1, 8, sign1, s);
			}
			if (t2 > 0 && cy.inCylinder(v, w, t2, id)){
				addHit(t2, 8, sign2, s);
			}
		}
	}
	
	//sorting the two lists hitListCube and hitListCylinder according to the value of t before doing INTERSECTION, UNION or DIFFERENCE
	public void sortHitLists(){
		int size1, size2;
		double tempT;
		int tempID;
		Vector<Hit> tempHitList = new Vector<Hit>();
		
		size1 = hitListCube.size();
		for (int i = 0; i < size1; i++){
			size2 = hitListCube.size();
			tempT = Double.MAX_VALUE;
			tempID = -1;
			for (int j = 0; j < size2; j++){
				if (hitListCube.get(j).t < tempT){
					tempT = hitListCube.get(j).t;
					tempID = j;
				}
			}
			if (tempID == -1) {
				return;
			}
			tempHitList.add(hitListCube.get(tempID));
			hitListCube.remove(tempID);
		}
		for (int i = 0; i < tempHitList.size(); i++){
			hitListCube.add(tempHitList.get(i));
		}
		
		tempHitList.clear();
		size1 = hitListCylinder.size();
		for (int i = 0; i < size1; i++){
			size2 = hitListCylinder.size();
			tempT = Double.MAX_VALUE;
			tempID = -1;
			for (int j = 0; j < size2; j++){
					if (hitListCylinder.get(j).t < tempT){
						tempT = hitListCylinder.get(j).t;
						tempID = j;
					}
			}
			if (tempID == -1) {
				return;
			}
			tempHitList.add(hitListCylinder.get(tempID));
			hitListCylinder.remove(tempID);
		}
		for (int i = 0; i < tempHitList.size(); i++){
			hitListCylinder.add(tempHitList.get(i));
		}
	}
	
	//return true if hit h if it is inside the other geometry (if the hit is on the cube, the other geometry is the cylinder and vice versa)
	public boolean binaryIn(Hit h, Cube c, Cylinder cy){
		if (h.surfaceId >= 6){
			return c.inCube(v, w, h.t, h.surfaceId);
		}
		else{
			return cy.inCylinder(v, w, h.t, h.surfaceId);
		}
	}
	
	//INTERSECTION two hit lists
	public Vector<Hit> INTERSECTION(Vector<Hit> hitList1, Vector<Hit> hitList2, Cube c, Cylinder cy){
		Vector<Hit> outputList = new Vector<Hit>();
		int i = 0;
		int j = 0;
		boolean compare;
		for (int k = 0; k < hitList1.size() + hitList2.size() - 1; k++){
			if (j == hitList2.size()){
				compare = true;
			}
			else if(i == hitList1.size()){
				compare = false;
			}
			else if(hitList1.get(i).t <= hitList2.get(j).t){
				compare = true;
			}
			else{
				compare = false;
			}
			if (compare){
				if (hitList1.get(i).sign == 1 && binaryIn(hitList1.get(i), c, cy)){
					outputList.add(new Hit(hitList1.get(i).t, hitList1.get(i).surfaceId, 1));
					outputList.get(outputList.size() - 1).setCoefficients(hitList1.get(i));
				}
				else if(hitList1.get(i).sign == -1 && binaryIn(hitList1.get(i), c, cy)){
					outputList.add(new Hit(hitList1.get(i).t, hitList1.get(i).surfaceId, -1));
					outputList.get(outputList.size() - 1).setCoefficients(hitList1.get(i));
				}
				i++;
			}
			else{
				if (hitList2.get(j).sign == 1 && binaryIn(hitList2.get(j), c, cy)){
					outputList.add(new Hit(hitList2.get(j).t, hitList2.get(j).surfaceId, 1));
					outputList.get(outputList.size() - 1).setCoefficients(hitList2.get(j));
				}
				else if(hitList2.get(j).sign == -1 && binaryIn(hitList2.get(j), c, cy)){
					outputList.add(new Hit(hitList2.get(j).t, hitList2.get(j).surfaceId, -1));
					outputList.get(outputList.size() - 1).setCoefficients(hitList2.get(j));
				}
				j++;
			}
		}
		return outputList;
	}
	
	public Vector<Hit> DIFFERENCE(Vector<Hit> hitList1, Vector<Hit> hitList2, Cube c, Cylinder cy){
		Vector<Hit> outputList = new Vector<Hit>();
		int i = 0;
		int j = 0;
		boolean compare;
		for (int k = 0; k < hitList1.size() + hitList2.size() - 1; k++){
			if (j == hitList2.size()){
				compare = true;
			}
			else if(i == hitList1.size()){
				compare = false;
			}
			else if(hitList1.get(i).t <= hitList2.get(j).t){
				compare = true;
			}
			else{
				compare = false;
			}
			if (compare){
				if (hitList1.get(i).sign == 1 && !binaryIn(hitList1.get(i), c, cy)){
					outputList.add(new Hit(hitList1.get(i).t, hitList1.get(i).surfaceId, 1));
					outputList.get(outputList.size() - 1).setCoefficients(hitList1.get(i));
				}
				else if(hitList1.get(i).sign == -1 && !binaryIn(hitList1.get(i), c, cy)){
					outputList.add(new Hit(hitList1.get(i).t, hitList1.get(i).surfaceId, -1));
					outputList.get(outputList.size() - 1).setCoefficients(hitList1.get(i));
				}
				i++;
			}
			else{
				if (hitList2.get(j).sign == 1 && binaryIn(hitList2.get(j), c, cy)){
					outputList.add(new Hit(hitList2.get(j).t, hitList2.get(j).surfaceId, -1));
					outputList.get(outputList.size() - 1).setCoefficients(hitList2.get(j));
				}
				else if(hitList2.get(j).sign == -1 && binaryIn(hitList2.get(j), c, cy)){
					outputList.add(new Hit(hitList2.get(j).t, hitList2.get(j).surfaceId, 1));
					outputList.get(outputList.size() - 1).setCoefficients(hitList2.get(j));
				}
				j++;
			}
		}
		return outputList;
	}
	
	//UNION two hit lists
	public Vector<Hit> UNION(Vector<Hit> hitList1, Vector<Hit> hitList2, Cube c, Cylinder cy){
		Vector<Hit> outputList = new Vector<Hit>();
		int i = 0;
		int j = 0;
		boolean compare;
		for (int k = 0; k < hitList1.size() + hitList2.size() - 1; k++){
			if (j == hitList2.size()){
				compare = true;
			}
			else if(i == hitList1.size()){
				compare = false;
			}
			else if(hitList1.get(i).t <= hitList2.get(j).t){
				compare = true;
			}
			else{
				compare = false;
			}
			if (compare){
				if (hitList1.get(i).sign == 1 && !binaryIn(hitList1.get(i), c, cy)){
					outputList.add(new Hit(hitList1.get(i).t, hitList1.get(i).surfaceId, 1));
					outputList.get(outputList.size() - 1).setCoefficients(hitList1.get(i));
				}
				else if(hitList1.get(i).sign == -1 && !binaryIn(hitList1.get(i), c, cy)){
					outputList.add(new Hit(hitList1.get(i).t, hitList1.get(i).surfaceId, -1));
					outputList.get(outputList.size() - 1).setCoefficients(hitList1.get(i));
				}
				i++;
			}
			else{
				if (hitList2.get(j).sign == 1 && !binaryIn(hitList2.get(j), c, cy)){
					outputList.add(new Hit(hitList2.get(j).t, hitList2.get(j).surfaceId, 1));
					outputList.get(outputList.size() - 1).setCoefficients(hitList2.get(j));
				}
				else if(hitList2.get(j).sign == -1 && !binaryIn(hitList2.get(j), c, cy)){
					outputList.add(new Hit(hitList2.get(j).t, hitList2.get(j).surfaceId, -1));
					outputList.get(outputList.size() - 1).setCoefficients(hitList2.get(j));
				}
				j++;
			}
		}
		return outputList;
	}
	


	public void computeHitListDifference(Cube c, Cylinder cy){
		hitList.clear();
		hitList1.clear();
		hitList1 = DIFFERENCE(hitListCube, hitListCylinder, c, cy);

	}
	
	public void computeHitListIntersection(Cube c, Cylinder cy){
		hitList.clear();
		hitList2.clear();
		hitList2 = INTERSECTION(hitListCube,hitListCylinder,c,cy);
	}
	public void computeHitListUnion(Cube c, Cylinder cy){
		hitList.clear();
		hitList3.clear();
		hitList3 = UNION(hitListCube, hitListCylinder,c,cy);
	}
}
