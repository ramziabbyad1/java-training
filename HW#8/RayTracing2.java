import java.util.Random;

public class RayTracing2 extends MISApplet{
	Cylinder cylinder = new Cylinder();
	Cube cube = new Cube();
	Cylinder cylinderOrigin = new Cylinder();
	Cube cubeOrigin = new Cube();
	private final double Epsilon = 0.001;
	double camera[] = {0, 0, 5};
	double direction[] = new double[3];
	double width, height;
	Light light = new Light(1.0, 1.0, 1.0, .5, .5, .5);;
	Material mat1 = new Material(0.8, 0.0, 0.0, 0.0, 0.8, 0.0, 0.8, 0.0, 0.0, 1.0, .5, .5, .5);
	Material mat2 = new Material(0.0, 0.8, 0.0, 0.0, 0.8, 0.0, 0.8, 0.0, 0.0, 1.0, .5, .5, .5);
	boolean init = true;
	double startTime = getTime();
	double time, theta;
	Random randomGenerator;
	double myX = 0;
	double myY = 0;
	double xspeed = 0.02;
	double yspeed = 0.02;

	double getTime() {
		return System.currentTimeMillis() / 1000.0;
	}	
	
	//initialize the two objects
	public void myInit(){
		cubeOrigin.scale(0.1, 0.1, 0.1);
		cylinderOrigin.scale(0.05, 0.05, 0.2);
		randomGenerator = new Random((long) getTime());	
	}
	
	//return a random number between 1/200 to 5/200
	public double rand(){
		int result = randomGenerator.nextInt(5) + 1;
		return (double)result / 200;
	}
	
    public void initFrame(double time) { // INITIALIZE ONE ANIMATION FRAME
    	if (init){
    		myInit();
    		init = false;
    	}
		time = getTime() - startTime;
		theta = time/36 * 2 * Math.PI;
    	cube.copy(cubeOrigin);
    	cylinder.copy(cylinderOrigin);
    	
    	myX += xspeed;
    	myY += yspeed;
    	if(myX < -0.2) xspeed = rand();
    	else if(myX > 0.2) xspeed = rand()*-1;
    	if(myY < -0.2) yspeed = rand();
    	else if(myY > 0.2) yspeed = rand()*-1;
    	
    	cube.translate(myX, myY, 0);
    	cylinder.translate(myX, myY, 0);
    	cylinder.translate(0.03*Math.cos(theta*10), 0.03*Math.sin(theta*10), 0);
    	
    	cube.rotateX(theta);
    	cylinder.rotateX(theta);
    	cube.rotateY(theta);
    	cylinder.rotateY(theta);
    	cube.rotateZ(theta);
    	cylinder.rotateZ(theta);
    }
    
    //compute the direction according to x, y and camera position
    public void computeRay(int x, int y){
    	width = getWidth();
    	height = getHeight();
    	
		direction[0] = (double)(x - 0.5*width) / (double)width;
		direction[1] = (double)(0.5*height - y) / (double)width;
		direction[2] = -1 * camera[2];
		
		double norm;
		norm = Math.sqrt(direction[0]*direction[0] + direction[1]*direction[1] + direction[2]*direction[2]);
		
		for (int i = 0; i < 3; i++){
			direction[i] /= norm;
		}
    }
    
    //hitting the two objects
    public void hitObjects(Ray r){
		//hit cube
		for (int i = 0; i < 6; i++){
			r.hitPlane(cube.p[i], i, cube, null);
		}
		//hit cylinder
		for (int i = 0; i < 2; i++){
			r.hitPlane(cylinder.p[i], i+6, null, cylinder);
		}
		r.hitSurface(cylinder.s, 8, cylinder);
    }
    
    //first sort the two hit lists then do the hitListCube - hitListCylinder
    public void computeHitList(Ray r){
    	r.sortLists();
    	r.computeHitList(cube, cylinder);
    }
    
	public double dotProduct(double [] v1, double [] v2){
		return v1[0]*v2[0] + v1[1]*v2[1] + v1[2]*v2[2];
	}
	
	public void normalize(double src[], double dst[]){
		double norm;
		norm = Math.sqrt(src[0]*src[0] + src[1]*src[1] + src[2]*src[2]);
		
		for (int i = 0; i < 3; i++){
			dst[i] = src[i] / norm;
		}
	}
	
	//called by setPixel(x, y) for every x and y
    public boolean computeColor(int rgb[], double v[], double w[]){	
		Ray ray = new Ray(v, w);//v and w are computed from computeRay(x, y)
		hitObjects(ray);
		computeHitList(ray);
		int size = ray.sizeHitList();
		if (size == 0) {//if don't hit anything return the color of light
			for (int i = 0; i < 3; i++){
				rgb[i] = (int)(light.I[i]*255);
			}
			return false;
		}
		else{
			double [] reflectionVector = new double [3];
			double [] surfaceNormal = new double [3];
			double [] surface = new double [3];
			double [] intersect = new double [3];
			Hit hit = ray.hitList.get(0);
			double t = hit.t;
			double x, y, z;
			
			for (int i = 0; i < 3; i++){
				intersect[i] = w[i]*t + v[i];
			}
			x = intersect[0]; y = intersect[1]; z = intersect[2];
			if (hit.surfaceId == 8){
				surface[0] = 2*hit.a*x + hit.e*z + hit.f*y + hit.g;
				surface[1] = 2*hit.b*y + hit.d*z + hit.f*x + hit.h;
				surface[2] = 2*hit.c*z + hit.d*y + hit.e*x + hit.i;
			}
			else{
				surface[0] = hit.a; surface[1] = hit.b; surface[2] = hit.c;
			}
			normalize(surface, surfaceNormal);
			for (int i = 0; i < 3; i++){
				reflectionVector[i] = w[i] - 2*dotProduct(surfaceNormal, w)*surfaceNormal[i];
			}
			double [] reOrigin = new double [3];
			double [] reDirection = new double [3];
			int [] reRGB = new int [3];
			for (int i = 0; i < 3; i++){
				reOrigin[i] = intersect[i] + Epsilon*reflectionVector[i];
				reDirection[i] = reflectionVector[i];
			}

			double [] phong = new double [3];
			Material mat;
			if (hit.surfaceId >= 6) mat = mat2;
			else mat = mat1;
			for (int i = 0; i < 3; i++){
				phong[i] = mat.A[i];
				phong[i] += light.I[i] * (mat.D[i]*dotProduct(light.L, surfaceNormal) + 
							mat.S[i]*Math.pow(dotProduct(light.L, reflectionVector), mat.p));
			}
			if (!computeColor(reRGB, reOrigin, reDirection)){//if the reflection doesn't hit anything, fully reflect the phong color
				for (int i = 0; i < 3; i++){
					rgb[i] = (int)(phong[i]*255);
				}
			}
			else{
				for (int i = 0; i < 3; i++){//the reflection hit something
					rgb[i] = (int)(phong[i]*(1.0 - mat.mc[i])*255) + (int)(reRGB[i]*mat.mc[i]);
				}
			}
			return true;
		}
    }
    
    public void setPixel(int x, int y, int rgb[]) { // SET ONE PIXEL'S COLOR
		computeRay(x, y);
		if(!computeColor(rgb, camera, direction)){//if the ray don't hit anything, set the background as gery color
			for (int i = 0; i < 3; i++){
				rgb[i] = 200;
			}
		}	
		for (int i = 0; i < 3; i++){
			if (rgb[i] > 255) rgb[i] = 255;
		}
    }
}
