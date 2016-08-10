import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

//Geometry class implements methods that create spheres, cylinders, and cubes using a rectangular mesh
public class Geometry
   {


    Material M = new Material();
    double[] normal = new double[3];
    double vertices[][];
    int faces[][];
    double x,y,z;
	int m;
	int n;
	Matrix coeff0 = new Matrix();
	Matrix coeff = new Matrix();
	double a,b,c,d,e,f,g,h,i,j;
	double[][] transformedCube = new double[6][4];
	//Matrix cubeCoeff = new Matrix(6,4);
	double[][] cubeCoeff = {{-1,0,0,-1},{0,-1,0,-1},{0,0,-1,-1},{1,0,0,-1},{0,1,0,-1},{0,0,1,-1}};
	double[] surfaceNormal;
	//shapeID = 0 for a sphere, =1 for a cylinder, = 2 for a cube
	//for cylinder and cube we need to test whether the point belongs to a particular face in order to calculate the normal
	//this can be done assuming we only need to do this test once, and then the matrix transformations will take care of the rest
	int shapeID;
	



    /*public void setCube(){
        for(int i=0; i < 6; i++){
            for(int j = 0; j <4; j++){
                cubeCoeff.set(i,j,tempCube[i][j]);
            }
        }
    }*/
	//double[] cubeNormal = new double[3];

    public void setNormal(double normal1,double normal2,double normal3){
        normal[0] = normal1;
        normal[1] = normal2;
        normal[2] = normal3;
    }



   /* public void uniqueCoeff(){
        double[][] temp = new double[4][4];
        temp = transformedSOS.getData();
        for(int i = 0; i <4;i++){
            for(int j=0; j <4; j++){
                if(i<j) transformedSOS.set(i,j,temp[i][j]+temp[j][i]);
                if(j<i) transformedSOS.set(i,j,0);
            }
        }
    }*/








//Converts from spherical to cartesian coordinates for each component
    public double convertFromSphericalX(double theta, double phi){


	x = Math.cos(theta)*Math.cos(phi);
	return x;


	}


	public double convertFromSphericalY(double theta, double phi){


	y = Math.sin(theta)*Math.cos(phi);
	return y;

	}

	public double convertFromSphericalZ(double theta, double phi){



	z = Math.sin(phi);
	return z;

	}

//Converts from cylindrical to cartesian coordinates
      public double convertFromCylindricalX(double theta, double radius){


	x = radius*Math.cos(theta);
        return x;

	}

	public double convertFromCylindricalY(double theta, double radius){



        y = radius*Math.sin(theta);
	return y;



	}



//creates the sphere object
    public void createSphere(int m, int n){

	double[] theta = new double[m+1];
	double[] phi = new double[n+1];
	vertices = new double[(m+1)*(n+1)][4];
	faces = new int[m*n][4];
	shapeID = 0;


	for(int i = 0; i<=m; i++){ theta[i] = 2*Math.PI*i/m;}

	for(int j = 0; j<=n; j++){ phi[j] = -Math.PI/2 + Math.PI*j/n;}
//initialized the array of vertices
	for (int i = 0; i<=m; i++){

		for(int j = 0; j<=n; j++){


			vertices[i+(m+1)*j][0] = convertFromSphericalX(theta[i], phi[j]);
			vertices[i+(m+1)*j][1] = convertFromSphericalY(theta[i], phi[j]);
			vertices[i+(m+1)*j][2] = convertFromSphericalZ(theta[i], phi[j]);
			vertices[i+(m+1)*j][3] = 1;
		}

	}



	//Faces for a unit sphere
	for(int i=0; i < m;i++){

		for(int j=0; j<n; j++){

			faces[i+m*j][0] = i+(m+1)*j;
			faces[i+m*j][1] = i+(m+1)*j+1;
			faces[i+m*j][2] = i+(m+1)*(j+1)+1;
			faces[i+m*j][3] = i+(m+1)*(j+1);
		}


	}
}
//Creates the Cylinder object by making two endcaps and a tubular body
public void createCylinder(int m, int t, int k){
shapeID = 1;
vertices = new double[(m+1)*(k+1) + 2*(m+1)*(t+1)+1][4];
faces = new int[k*m + 2*m*t +1][4];
double[] theta = new double[m+1];
double[] z = new double[t+1];
double[] r = new double[k+1];


for(int i = 0; i<=m; i++){ theta[i] = 2*Math.PI*i/m;};
for(int j = 0; j<=k; j++){r[j] = (double)j/k;}; 
for(int x = 0; x<=t; x++){z[x] = (1 - ((double)(2*x)/t));}; 
//Make the front endcap with seperate vertices for sharp edges


	for (int i = 0; i<=m; i++){

		for(int j = 0; j<=k; j++){


			vertices[i+(m+1)*j][0] = convertFromCylindricalX(theta[i], r[j]);
			vertices[i+(m+1)*j][1] = convertFromCylindricalY(theta[i], r[j]);
			vertices[i+(m+1)*j][2] = 1;
			vertices[i+(m+1)*j][3] = 1;
		}

	}

	for(int i=0; i < m;i++){

		for(int j=0; j<k; j++){

			faces[i+m*j][0] = i+(m+1)*j;
			faces[i+m*j][1] = i+(m+1)*j+1;
			faces[i+m*j][2] = i+(m+1)*(j+1)+1;
			faces[i+m*j][3] = i+(m+1)*(j+1);
		}


	}

int lag = (m+1)*(k+1)+1;
int lag2 = m*k +1;
//tubular body
		for (int j = 0; j<=t; j++){

		for(int i = 0; i<=m; i++){


			vertices[lag+i+(t+1)*j][0] = convertFromCylindricalX(theta[i], 1);
			vertices[lag+i+(t+1)*j][1] = convertFromCylindricalY(theta[i], 1);
			vertices[lag+i+(t+1)*j][2] = z[j];
			//System.out.println(z[j]);
			vertices[lag+i+(t+1)*j][3] = 1;
		}

	}

	for(int j=0; j < t;j++){

		for(int i=0; i<m; i++){

			faces[lag2+i+t*j][0] = lag +i+(t+1)*j;
			faces[lag2+i+t*j][1] = lag +i+(t+1)*j+1;
			faces[lag2+i+t*j][2] = lag +i+(t+1)*(j+1)+1;
			faces[lag2+i+t*j][3] = lag +i+(t+1)*(j+1);
		}


	}

lag = (m+1)*(k+1)+(m+1)*(t+1)+1;
lag2 = m*k +t*m +1;
//outter endcap with vertices oriented in the counterclockwise direction (seperate vertices used for sharp edges
	for (int i = 0; i<=m; i++){

		for(int j = 0; j<=k; j++){


			vertices[lag+i+(m+1)*j][0] = convertFromCylindricalX(-theta[i], r[j]);
			vertices[lag+i+(m+1)*j][1] = convertFromCylindricalY(-theta[i], r[j]);
			vertices[lag+i+(m+1)*j][2] = -1;
			vertices[lag+i+(m+1)*j][3] = 1;
		}

	}

	for(int i=0; i < m;i++){

		for(int j=0; j<k; j++){

			faces[lag2+i+m*j][0] = lag+i+(m+1)*j;
			faces[lag2+i+m*j][1] = lag+i+(m+1)*j+1;
			faces[lag2+i+m*j][2] = lag+i+(m+1)*(j+1)+1;
			faces[lag2+i+m*j][3] = lag+i+(m+1)*(j+1);
		}


	}



	}


	//the cube has vertices oriented in the counterclockwise direction with the first row being the front face of cube, the second being the back,
	//the third being the top and so on as listed below
	public void createCube() {
		shapeID = 2;
		vertices = new double[][] {

				{1,1,1,1},{-1,1,1,1},{-1,-1,1,1},{1,-1,1,1},  //Front
				{1,1,-1,1},{-1,1,-1,1},{-1,-1,-1,1},{1,-1,-1,1}, //back
				{1,1,1,1},{1,1,-1,1},{-1,1,-1,1},{-1,1,1,1}, //Top
				{1,-1,1,1},{1,-1,-1,1},{-1,-1,-1,1},{-1,-1,1,1}, //Bottom
				{-1,-1,-1,1},{-1,-1,1,1},{-1,1,1,1},{-1,1,-1,1}, //Left
				{1,1,1,1},{1,-1,1,1},{1,-1,-1,1},{1,1,-1,1} //Right

		};
//sharp edges means using seperate vertices
		faces = new int[][] {
				{0,1,2,3},{4,5,6,7},{8,9,10,11},{12,13,14,15},{16,17,18,19},{20,21,22,23}
		};
}



    ArrayList<Geometry> children = new ArrayList<Geometry>();
    Matrix matrix = new Matrix();
    Matrix local = new Matrix();
    Matrix global = new Matrix();
    Geometry parent = null;

    //METHODS FOR HANDLING ANIMATION HIERARCHY

	public Matrix getMatrix() {
		return matrix;
	}

	//public void setHitList(
	//t1 and t2 should be sorted before comparing and should include the shapeID
	// t[][] = {[surfaceID, tmin,(in,out)]; [surfaceID,tmax,(in,out)]}
	double[][] hitList = new double[2][3];
	//if we have a miss compare the first non-negative element so that there is only one comparison
	// the list should contain the smallest non-zero element of t1,t2
    //positive positive  positive negative
	public double[][] compareHitList(double[][] t1, double[][] t2){
        //this is the normal case when ray starts outside and hits both objects
        if(t1[0][1] > 0 && t2[0][1] > 0){
            if(t1[0][1] <= t2[0][1]){
                hitList[0] = t1[0];
                //System.out.println(Arrays.toString(hitList[0]));
                if (t1[1][1] <= t2[0][1] && t1[1][1] >0){
                    hitList[1] = t1[1];
                }
                else if(t2[0][1] > 0){
                hitList[1] = t2[0];
                //System.out.println(Arrays.toString(hitList[1]));
                }
            }
            else{
                hitList[0] = t2[0];
                if(t2[1][1] <= t1[0][1] && t2[1][1]>0) hitList[1] = t2[1];
                else if (t1[1][1]>0) hitList[1] = t1[0];
            }
        }
        else if(t1[0][1] > 0 && t2[0][1] <= 0){
            hitList = t1;
        }
        else if(t1[0][1] <= 0 && t2[0][1] > 0){
            hitList = t2;
        }
        else{
            hitList[0][1] = -1;
            hitList[1][1] = -1;
        }

        //can try two more cases where one or the other is negative (the first index that is), and when both are negative
        //in the first case just take the other vector for otherwise the above algorithm will sort itself out
        //we already covered the second case since we check if smalles value is null
        //System.out.println(Arrays.toString(hitList[0]));
        //System.out.println(Arrays.toString(hitList[1]));
        //System.out.println();
        return hitList;

    }


	public Matrix getGlobal(){
        return global;
    }


	public void add(Geometry child) {
        child.parent = this;
		children.add(child);


	}

    public Matrix getLocal(){

        return local;

    }

    public Material getMaterial(){
        return M;

    }
    double center[] = new double[3];
    public void setCenter(double a, double b, double c){
        center[0] = a;
        center[1] = b;
        center[2] = c;

    }

    double radius;

    public void setRadius(double r){
        //radius = 0;
        radius =  r;
    }


    public double[] getCenter(){
        return center;
    }

    public double getRadius(){
        return radius;
    }

    public Matrix getCoeff0(){
        return coeff;
    }

    public Matrix getCoeff(){
        return coeff0;
    }

    public void setCoeff(double a,double b,double c,double d,double e,double f,double g,double h,double i,double j){
    //WHICH COEFF IS WHICH??  USE THIS AT LINE 167 IN ASSIGNMENT7

    coeff0.set(0,0,a);
    coeff.set(0,0,a);
    coeff0.set(0,1,f);
    coeff.set(0,1,f);
    coeff0.set(0,2,e);
    coeff.set(0,2,e);
    coeff0.set(0,3,g);
    coeff.set(0,3,0);
    coeff0.set(1,0,0);
    coeff.set(1,0,0);
    coeff0.set(1,1,b);
    coeff.set(1,1,b);
    coeff0.set(1,1,b);
    coeff.set(1,1,b);
    coeff0.set(1,3,h);
    coeff.set(1,3,0);
    coeff0.set(2,0,0);
    coeff.set(2,0,0);
    coeff0.set(2,1,0);
    coeff.set(2,1,0);
    coeff0.set(2,2,c);
    coeff.set(2,2,c);
    coeff0.set(2,3,i);
    coeff.set(2,3,0);
    coeff0.set(3,0,0);
    coeff0.set(3,1,0);
    coeff0.set(3,2,0);
    coeff0.set(3,3,j);
    coeff.set(3,3,0);
    }




	public void remove(Geometry child) {
		children.remove(child);
	}

	public int getNumChildren() {
		return children.size();
	}

	public Geometry getChild(int index) {
		return children.get(index);
	}

	public Geometry getParent(){

        return parent;
    }


}
