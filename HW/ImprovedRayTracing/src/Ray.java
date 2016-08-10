import java.util.Vector;

public class Ray {
	Vector<Hit> hitListCube = new Vector<Hit>();//hit list for hitting the cube
	Vector<Hit> hitListCylinder = new Vector<Hit>();//hit list for hitting the cylinder
	Vector<Hit> hitList = new Vector<Hit>();//hit list for the final result
	double [] origin = new double [3];
	double [] direction = new double [3];
	
	public int sizeHitList(){return hitList.size();}

	public Ray(double [] ori, double [] dir){
		for (int i = 0; i < 3; i++){
			origin[i] = ori[i];
			direction[i] = dir[i];
		}
	}
	//called by hitPlane(), add the hit to the hit list according to surface id
	public void addHitPlane(double t, int id, int sign, Plane p){
		if (id >= 0 && id <= 5){
			hitListCube.add(new Hit(t, id, sign));
			hitListCube.get(hitListCube.size() - 1).setCoefficients(p);
		}
		else{
			hitListCylinder.add(new Hit(t, id, sign));
			hitListCylinder.get(hitListCylinder.size() - 1).setCoefficients(p);
		}
	}
	
	//called by hitSurface(), add the hit to the hitListCylinder
	public void addHitSurface(double t, int id, int sign, Surface s){
		hitListCylinder.add(new Hit(t, id, sign));
		hitListCylinder.get(hitListCylinder.size() - 1).setCoefficients(s);
	}
	
	//called by RayTracing2, compute the t of hitting surface[id]
	public void hitPlane(Plane p, int id, Cube c, Cylinder cy){
		double A, B, t;
		int sign;
		boolean inOrOut;
		A = p.a*direction[0] + p.b*direction[1] + p.c*direction[2];
		if (A == 0) {
			return ;
		}
		else{
			B = p.a*origin[0] + p.b*origin[1] + p.c*origin[2] + p.d;
			t = -1 * B / A;
			if (id >= 0 && id <= 5) inOrOut = c.inCube(origin, direction, t, id);
			else inOrOut = cy.inCylinder(origin, direction, t, id);
			if(t > 0 && inOrOut){
				if (m.a*origin[0] + m.b*origin[1] + m.c*origin[2] + m.d >= 0) sign = 1;
				else sign = -1;
				addHitPlane(t, id, sign, m);
			}
		}
	}
	
	//called by RayTracing2, compute the t of hitting the cylindrical surface
	public void hitSurface(Surface s, int id, Cylinder cy){
		double A, B, C, t1, t2, discriminant;
		int sign1, sign2;
		sign1 = 0;
		sign2 = 0;
		
		A = s.a*direction[0]*direction[0] + s.b*direction[1]*direction[1] + s.c*direction[2]*direction[2] + s.d*direction[1]*direction[2] + s.e*direction[0]*direction[2]
		  + s.f*direction[0]*direction[1];
		B = 2*s.a*origin[0]*direction[0] + 2*s.b*origin[1]*direction[1] + 2*s.c*origin[2]*direction[2]
		  + s.d*(origin[1]*direction[2] + origin[2]*direction[1]) + s.e*(origin[0]*direction[2] + origin[2]*direction[0]) + s.f*(origin[0]*direction[1] + origin[1]*direction[0])
		  + s.g*direction[0] + s.h*direction[1] + s.i*direction[2];
		C = s.a*origin[0]*origin[0] + s.b*origin[1]*origin[1] + s.c*origin[2]*origin[2] + s.d*origin[1]*origin[2] + s.e*origin[0]*origin[2] + s.f*origin[0]*origin[1]
		  + s.g*origin[0] + s.h*origin[1] + s.i*origin[2] + s.j;
		
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
			if (t1 > 0 && cy.inCylinder(origin, direction, t1, id)){
				addHitSurface(t1, 8, sign1, s);
			}
			if (t2 > 0 && cy.inCylinder(origin, direction, t2, id)){
				addHitSurface(t2, 8, sign2, s);
			}
		}
	}
	
	//sorting the two lists hitListCube and hitListCylinder according to the value of t before doing AND, OR or MINUS
	public void sortLists(){
		int size1, size2;
		double tmpT;
		int tmpID;
		Vector<Hit> temp = new Vector<Hit>();
		
		size1 = hitListCube.size();
		for (int i = 0; i < size1; i++){
			size2 = hitListCube.size();
			tmpT = Double.MAX_VALUE;
			tmpID = -1;
			for (int j = 0; j < size2; j++){
				if (hitListCube.get(j).t < tmpT){
					tmpT = hitListCube.get(j).t;
					tmpID = j;
				}
			}
			if (tmpID == -1) {
				System.out.println("error");
				return;
			}
			temp.add(hitListCube.get(tmpID));
			hitListCube.remove(tmpID);
		}
		for (int i = 0; i < temp.size(); i++){
			hitListCube.add(temp.get(i));
		}
		
		temp.clear();
		size1 = hitListCylinder.size();
		for (int i = 0; i < size1; i++){
			size2 = hitListCylinder.size();
			tmpT = Double.MAX_VALUE;
			tmpID = -1;
			for (int j = 0; j < size2; j++){
					if (hitListCylinder.get(j).t < tmpT){
						tmpT = hitListCylinder.get(j).t;
						tmpID = j;
					}
			}
			if (tmpID == -1) {
				System.out.println("error");
				return;
			}
			temp.add(hitListCylinder.get(tmpID));
			hitListCylinder.remove(tmpID);
		}
		for (int i = 0; i < temp.size(); i++){
			hitListCylinder.add(temp.get(i));
		}
	}
	
	//return true if hit h if it is inside the other geometry (if the hit is on the cube, the other geometry is the cylinder and vice versa)
	public boolean binaryIn(Hit h, Cube c, Cylinder cy){
		if (h.surfaceId >= 6){
			return c.inCube(origin, direction, h.t, h.surfaceId);
		}
		else{
			return cy.inCylinder(origin, direction, h.t, h.surfaceId);
		}
	}
	
	//AND two hit lists
	public Vector<Hit> AND(Vector<Hit> l1, Vector<Hit> l2, Cube c, Cylinder cy){
		Vector<Hit> output = new Vector<Hit>();
		int i = 0;
		int j = 0;
		boolean compare1;
		for (int k = 0; k < l1.size() + l2.size() - 1; k++){
			if (j == l2.size()){
				compare1 = true;
			}
			else if(i == l1.size()){
				compare1 = false;
			}
			else if(l1.get(i).t <= l2.get(j).t){
				compare1 = true;
			}
			else{
				compare1 = false;
			}
			if (compare1){
				if (l1.get(i).sign == 1 && binaryIn(l1.get(i), c, cy)){
					output.add(new Hit(l1.get(i).t, l1.get(i).surfaceId, 1));
					output.get(output.size() - 1).setCoefficients(l1.get(i));
				}
				else if(l1.get(i).sign == -1 && binaryIn(l1.get(i), c, cy)){
					output.add(new Hit(l1.get(i).t, l1.get(i).surfaceId, -1));
					output.get(output.size() - 1).setCoefficients(l1.get(i));
				}
				i++;
			}
			else{
				if (l2.get(j).sign == 1 && binaryIn(l2.get(j), c, cy)){
					output.add(new Hit(l2.get(j).t, l2.get(j).surfaceId, 1));
					output.get(output.size() - 1).setCoefficients(l2.get(j));
				}
				else if(l2.get(j).sign == -1 && binaryIn(l2.get(j), c, cy)){
					output.add(new Hit(l2.get(j).t, l2.get(j).surfaceId, -1));
					output.get(output.size() - 1).setCoefficients(l2.get(j));
				}
				j++;
			}
		}
		return output;
	}
	
	//OR two hit lists
	public Vector<Hit> OR(Vector<Hit> l1, Vector<Hit> l2, Cube c, Cylinder cy){
		Vector<Hit> output = new Vector<Hit>();
		int i = 0;
		int j = 0;
		boolean compare1;
		for (int k = 0; k < l1.size() + l2.size() - 1; k++){
			if (j == l2.size()){
				compare1 = true;
			}
			else if(i == l1.size()){
				compare1 = false;
			}
			else if(l1.get(i).t <= l2.get(j).t){
				compare1 = true;
			}
			else{
				compare1 = false;
			}
			if (compare1){
				if (l1.get(i).sign == 1 && !binaryIn(l1.get(i), c, cy)){
					output.add(new Hit(l1.get(i).t, l1.get(i).surfaceId, 1));
					output.get(output.size() - 1).setCoefficients(l1.get(i));
				}
				else if(l1.get(i).sign == -1 && !binaryIn(l1.get(i), c, cy)){
					output.add(new Hit(l1.get(i).t, l1.get(i).surfaceId, -1));
					output.get(output.size() - 1).setCoefficients(l1.get(i));
				}
				i++;
			}
			else{
				if (l2.get(j).sign == 1 && !binaryIn(l2.get(j), c, cy)){
					output.add(new Hit(l2.get(j).t, l2.get(j).surfaceId, 1));
					output.get(output.size() - 1).setCoefficients(l2.get(j));
				}
				else if(l2.get(j).sign == -1 && !binaryIn(l2.get(j), c, cy)){
					output.add(new Hit(l2.get(j).t, l2.get(j).surfaceId, -1));
					output.get(output.size() - 1).setCoefficients(l2.get(j));
				}
				j++;
			}
		}
		return output;
	}
	
	//MINUS two hit lists l1 - l2
	public Vector<Hit> MINUS(Vector<Hit> l1, Vector<Hit> l2, Cube c, Cylinder cy){
		Vector<Hit> output = new Vector<Hit>();
		int i = 0;
		int j = 0;
		boolean compare1;
		for (int k = 0; k < l1.size() + l2.size() - 1; k++){
			if (j == l2.size()){
				compare1 = true;
			}
			else if(i == l1.size()){
				compare1 = false;
			}
			else if(l1.get(i).t <= l2.get(j).t){
				compare1 = true;
			}
			else{
				compare1 = false;
			}
			if (compare1){
				if (l1.get(i).sign == 1 && !binaryIn(l1.get(i), c, cy)){
					output.add(new Hit(l1.get(i).t, l1.get(i).surfaceId, 1));
					output.get(output.size() - 1).setCoefficients(l1.get(i));
				}
				else if(l1.get(i).sign == -1 && !binaryIn(l1.get(i), c, cy)){
					output.add(new Hit(l1.get(i).t, l1.get(i).surfaceId, -1));
					output.get(output.size() - 1).setCoefficients(l1.get(i));
				}
				i++;
			}
			else{
				if (l2.get(j).sign == 1 && binaryIn(l2.get(j), c, cy)){
					output.add(new Hit(l2.get(j).t, l2.get(j).surfaceId, -1));
					output.get(output.size() - 1).setCoefficients(l2.get(j));
				}
				else if(l2.get(j).sign == -1 && binaryIn(l2.get(j), c, cy)){
					output.add(new Hit(l2.get(j).t, l2.get(j).surfaceId, 1));
					output.get(output.size() - 1).setCoefficients(l2.get(j));
				}
				j++;
			}
		}
		return output;
	}
/*	
	public Vector<Hit> NEGATE(Vector<Hit> l){
		Vector<Hit> output = new Vector<Hit>();
		for (int i = 0; i < l.size(); i++){
			output.add(new Hit(l.get(i).t, l.get(i).surfaceId, l.get(i).sign*(-1)));
			output.get(output.size() - 1).setCoefficients(l.get(i));
		}
		return output;
	}
*/
	//edit this part to make the shapes you want to
	public void computeHitList(Cube c, Cylinder cy){
		hitList.clear();
		hitList = MINUS(hitListCube, hitListCylinder, c, cy);
	}


}
