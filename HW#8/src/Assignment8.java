
//IMPLEMENTATION OF INTERSECTION, UNION, AND DIFFERENCE OPERATORS ON THREE CYLINDER AND CUBE OBJECTS, SOME OPTOMIZATION IS DONE BY EXPLICITLY WRITING OUT ALL BINARY OPERATORS
public class Assignment8 extends MISApplet{
	Cylinder cylinder1 = new Cylinder();
	Cube cube1 = new Cube();
	Cylinder cylinderOrigin1 = new Cylinder();
	Cube cubeOrigin1 = new Cube();
	Cylinder cylinder2 = new Cylinder();
	Cube cube2 = new Cube();
	Cylinder cylinderOrigin2 = new Cylinder();
	Cube cubeOrigin2 = new Cube();
	Cylinder cylinder3 = new Cylinder();
	Cube cube3 = new Cube();
	Cylinder cylinderOrigin3 = new Cylinder();
	Cube cubeOrigin3 = new Cube();
	Material material1 = new Material(0.5, 0.5, 0.5, 0.0, 0.8, 0.0, 0.8, 0.0, 0.0, 1.0, .5, .5, .5);
	Material material2 = new Material(0.5, 0.5, 0.5, 0.0, 0.8, 0.0, 0.8, 0.0, 0.0, 1.0, .5, .5, .5);
	private final double Epsilon = 0.001;
	double focalPoint[] = {0, 0, 5};
	double direction[] = new double[3];
	double width, height;
	Light light = new Light(1.0, 1.0, 1.0, .5, .5, .5);;
	boolean init = true;
	double theta;
	double startTime = getTime();
	double time; 

	double getTime() {
		return System.currentTimeMillis() / 1000.0;
	}	
	
	//INITIALIZE THE THREE OBJECTS
	public void myInit(){
		cylinderOrigin1.scale(0.05, 0.05, 0.2);
		cubeOrigin1.scale(0.1, 0.1, 0.1);
		cylinderOrigin2.scale(0.05, 0.05, 0.2);
		cubeOrigin2.scale(0.1, 0.1, 0.1);
		cylinderOrigin3.scale(0.05, 0.05, 0.2);
		cubeOrigin3.scale(0.1, 0.1, 0.1);
	}
	

	
    public void initFrame(double time) { // INITIALIZE ONE ANIMATION FRAME
    	if (init){
    		myInit();
    		init = false;
    	}
		time = getTime() - startTime;
		theta = time/36 * 2 * Math.PI;
    	cube1.copy(cubeOrigin1);
    	cylinder1.copy(cylinderOrigin1);
    	cube2.copy(cubeOrigin2);
    	cylinder2.copy(cylinderOrigin2);
    	cube3.copy(cubeOrigin3);
    	cylinder3.copy(cylinderOrigin3);
    	

    	
 	
    	cube1.translate(.1,.1,0);
    	cylinder1.translate(.1,.1,0);
    	cube1.rotateX(theta);
    	cylinder1.rotateX(theta);
    	cube2.translate(.1,-.2,-.2);
    	cylinder2.translate(.1,-.2,0);
    	cube2.rotateX(theta);
    	cylinder2.rotateX(theta);
    	cube3.translate(-.2,.1,-.2);
    	cylinder3.translate(-.2,.1,0);
    	cube3.rotateX(theta);
    	cylinder3.rotateX(theta);
    	
    	
    	
 
    }
    
    //compute the direction according to x, y and focalPoint position
    public void inverseViewport(int x, int y){
    	width = getWidth();
    	height = getHeight();
    	
		direction[0] = (double)(x - 0.5*width) / (double)width;
		direction[1] = (double)(0.5*height - y) / (double)width;
		direction[2] = -1 * focalPoint[2];
		
		double norm;
		norm = Math.sqrt(direction[0]*direction[0] + direction[1]*direction[1] + direction[2]*direction[2]);
		
		for (int i = 0; i < 3; i++){
			direction[i] /= norm;
		}
    }
    
    //hitting the two objects
    public void traceRayToObjects(Ray r1,Ray r2,Ray r3){
		//hit cube1
		for (int i = 0; i < 6; i++){
			r1.traceRayToPlane(cube1.p[i], i, cube1, null);
			r2.traceRayToPlane(cube2.p[i], i, cube2, null);
			r3.traceRayToPlane(cube3.p[i], i, cube3, null);
		}
		//hit cylinder1
		for (int i = 0; i < 2; i++){
			r1.traceRayToPlane(cylinder1.p[i], i+6, null, cylinder1);
			r2.traceRayToPlane(cylinder2.p[i], i+6, null, cylinder2);
			r3.traceRayToPlane(cylinder3.p[i], i+6, null, cylinder3);
		}
		r1.traceRayToSOS(cylinder1.s, 8, cylinder1);
		r2.traceRayToSOS(cylinder2.s, 8, cylinder2);
		r3.traceRayToSOS(cylinder3.s, 8, cylinder3);
    }
    
    //first sort the two hit lists then do the hitListCube - hitListCylinder
    public void computeHitList(Ray r1,Ray r2,Ray r3){
    	r1.sortHitLists();
    	r1.computeHitListDifference(cube1, cylinder1);
    	r2.sortHitLists();
    	r2.computeHitListIntersection(cube2, cylinder2);
    	r3.sortHitLists();
    	r3.computeHitListUnion(cube3, cylinder3);
    }
    	
	//called by setPixel(x, y) for every x and y returns a color and whether the object was hit
    public boolean computePhong(int rgb[], double v[], double w[]){	
		//ARGUMENTS V AND W ARE PROVIDED BY INVERSEVIEWPORT    	
		Ray ray1 = new Ray(v, w);
		Ray ray2 = new Ray(v, w);
		Ray ray3 = new Ray(v, w);
		traceRayToObjects(ray1,ray2,ray3);
		computeHitList(ray1,ray2,ray3);
		int size1 = ray1.sizeHitList1();
		int size2 = ray2.sizeHitList2();
		int size3 = ray3.sizeHitList3();
		if (size1 == 0 && size2 ==0 && size3 == 0 ) {
			for (int i = 0; i < 3; i++){
				rgb[i] = (int)(light.I[i]*255);
			}
			return false;
		}
		else{
			double [] reflectionVector = new double [3];
			double [] surfaceNormal = new double [3];
			double [] tempNormal = new double [3];
			double [] surfacePoint = new double [3];
			Hit hit1 = new Hit(0, 0, 0);
			Hit hit2 = new Hit(0, 0, 0);
			Hit hit3 = new Hit(0, 0, 0);
			double t1 = 0;
			double t2=0;
			double t3 =0;
			if(size1 ==0){t1 = 0;}
			else{
				hit1 = ray1.hitList1.get(0);
				t1 = hit1.t;
			}
			if(size2 == 0){t2 = 0;}
			else{
				hit2 = ray2.hitList2.get(0);
				t2 = hit2.t;
			}
			if(size3 == 0){hit3.t=0;}
			else{
			hit3 = ray3.hitList3.get(0);
			t3 = hit3.t;
			}
			
			Hit hit = new Hit(0,0,0);
			if( (t1 <= t2 && t1<=t3 && t1>0) ||(t2 == 0 && t3==0) ){hit = hit1;}
			if((t2 <= t1 && t2<=t3 && t2>0) ||(t1==0 && t3==0)){hit = hit2;}
			if((t3<= t1 && t3<=t2 && t3>0) || (t2==0 &t1==0)){hit = hit3;}
			double t = hit.t;
			double x, y, z;
			
			for (int i = 0; i < 3; i++){
				surfacePoint[i] = w[i]*t + v[i];
			}
			x = surfacePoint[0]; y = surfacePoint[1]; z = surfacePoint[2];
			if (hit.surfaceId == 8){
				tempNormal[0] = 2*hit.a*x + hit.e*z + hit.f*y + hit.g;
				tempNormal[1] = 2*hit.b*y + hit.d*z + hit.f*x + hit.h;
				tempNormal[2] = 2*hit.c*z + hit.d*y + hit.e*x + hit.i;
			}
			else{
				tempNormal[0] = hit.a; tempNormal[1] = hit.b; tempNormal[2] = hit.c;
			}
			normalize(tempNormal, surfaceNormal);
			for (int i = 0; i < 3; i++){
				reflectionVector[i] = w[i] - 2*dotProduct(surfaceNormal, w)*surfaceNormal[i];
			}
			double [] vReflected = new double [3];
			double [] wReflected = new double [3];
			int [] rgbReflected = new int [3];
			for (int i = 0; i < 3; i++){
				vReflected[i] = surfacePoint[i] + Epsilon*reflectionVector[i];
				wReflected[i] = reflectionVector[i];
			}

			double [] phong = new double [3];
			Material mat;
			if (hit.surfaceId >= 6) mat = material2;
			else mat = material1;
			for (int i = 0; i < 3; i++){
				phong[i] = mat.ambient[i];
				phong[i] += light.I[i] * (mat.diffuse[i]*dotProduct(light.L, surfaceNormal) + 
							mat.spectral[i]*Math.pow(dotProduct(light.L, reflectionVector), mat.p));
			}
			//IF NOT HIT REFLECT PHONG COLOR
			if (!computePhong(rgbReflected, vReflected, wReflected)){
				for (int i = 0; i < 3; i++){
					rgb[i] = (int)(phong[i]*255);
				}
			}
			else{
				for (int i = 0; i < 3; i++){
					rgb[i] = (int)(phong[i]*(1.0 - mat.mirrorColor[i])*255) + (int)(rgbReflected[i]*mat.mirrorColor[i]);
				}
			}
			return true;
		}
    }
 // SET ONE PIXEL'S COLOR
    public void setPixel(int x, int y, int rgb[]) { 
		inverseViewport(x, y);
		if(!computePhong(rgb, focalPoint, direction)){
			for (int i = 0; i < 3; i++){
				rgb[i] = 100;
			}
		}	
		for (int i = 0; i < 3; i++){
			if (rgb[i] > 255) rgb[i] = 255;
		}
    }
    
	public double dotProduct(double [] x, double [] y){
		return x[0]*y[0] + x[1]*y[1] + x[2]*y[2];
	}
	
	public void normalize(double src[], double dst[]){
		double norm;
		norm = Math.sqrt(src[0]*src[0] + src[1]*src[1] + src[2]*src[2]);
		
		for (int i = 0; i < 3; i++){
			dst[i] = src[i] / norm;
		}
	}
}
