import java.awt.*;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.util.Arrays;

//try this on a sphere
public class Assignment9sphere extends MISApplet{

    Geometry sphere = new Geometry();
    Matrix matrix = new Matrix();
    //cylinder.createCylinder(10,10,10);
    Material M = new Material();
    
    
    double focalLength = 10;
    Trapezoid2 trap = new Trapezoid2();
    double[][][] faces;
    //double[][][] faces = new double[4*cylinder.faces.length][2][4];
    //LinearInterpolator LI = new LinearInterpolator();
    //make a material object from which to retrieve ambient, spectral, diffuse, etc.
    ZBuffer zbuffer[][]; 
    int dxr,dxg,dxb,Lxr,Lxg,Lxb,Rx,Lx,dLr,dLg,dLb,dRr,dRg,dRb,Lr,Lg,Lb,Rr,Rg,Rb;
	double dxz,Lxz,dLz,dRz,Lz,Rz;
	int m,k,t;

    public void initialize(){
		zbuffer = new ZBuffer[W][H]; 
		for (int i = 0; i<W; i++)
			for (int j = 0; j<H; j++){
				zbuffer[i][j] = new ZBuffer();
			}	
		
		//m=k=t=10;
		sphere.createSphere(20,20);
    	M = sphere.getMaterial();
    	M.setAmbient(0,0,.2);
        M.setMirrorColor(.5,.5,.5);
        M.setDiffuse(0,0,1);
        M.setSpectral(.5,.5,.5);
        faces = new double[4*sphere.faces.length][8][];
        //faces = transformAndRenderCylinder(cylinder, matrix);
		
	}



    public void initFrame(double time) { // INITIALIZE ONE ANIMATION FRAME
        //convert each face into 4 trapezoids
    	for (int i = 0; i<W; i++)
			for (int j = 0; j<H; j++){				
				zbuffer[i][j].setDepth(-Double.MAX_VALUE);
				zbuffer[i][j].setRGB(200, 0, 50);
			}
    	//m=k=t=10;
        faces = transformAndRenderCylinder(sphere, matrix);
        /*for(int i= 0; i < 4; i++){
			for(int j=0; j <8; j++){
			//System.out.println(tr[i][2][1] +" - "+tr[i][1][1]);
			System.out.println(Arrays.toString(faces[i][j]) + "i: "+i+" j: "+j);
			}
        }*/
        interpolate(faces);
        
    	Matrix m;
		  
		m = sphere.getMatrix();
		m.identity();
		//m.rotateX(Math.PI/4);
		//m.rotateY(time);
		//m.scale(.3, .3, .3);

        //EACH ELEMENT OF FACES IS A TWO BY FOUR ARRAY OF POINTS COMPRISING THE VERTICES OF THE trapezoidTransform
        //faces[i] = {TR, TL, BR, BL};
        //for(int i = 0; i < faces.length; i++){}
    }
//check interpolation
    //try changing interpolate back to original since now phong is <255
	public void interpolate(double[][][] tr){
		//System.out.println(sphere.faces.length);
		for(int k = 0; k <100;k++)
			for(int t = 0; t <8; t++)
				System.out.println(Arrays.toString(tr[k][t])+"k: "+k+"t: "+t);
		//System.out.println(tr[i][0][0]);
		double n;
		for(int i= 0; i < 4*sphere.faces.length; i++){
			//System.out.println(tr[i][0][0]+" "+i);
			n = (int)(tr[i][1][1] - tr[i][2][1]);
			if(n!=0){
			//System.out.println("n: "+n);
			dLr = (int)((tr[i][5][0] - tr[i][6][0]) / n);
			dLg = (int)((tr[i][5][1] - tr[i][6][1]) / n);
			dLb = (int)((tr[i][5][2] - tr[i][6][2]) / n);
			dRr = (int)((tr[i][4][0] - tr[i][7][0]) / n);
			dRg = (int)((tr[i][4][1] - tr[i][7][1]) / n);
			dRb = (int)((tr[i][4][2] - tr[i][7][2]) / n);
			dLz = ((tr[i][5][3] - tr[i][6][3]) / n);	  
			dRz = ((tr[i][4][3] - tr[i][7][3]) / n);	   
			Lr = (int)tr[i][6][0];
			Lg = (int)tr[i][6][1];
			Lb = (int)tr[i][6][2];
			Rr = (int)tr[i][7][0];
			Rg = (int)tr[i][7][1];
			Rb = (int)tr[i][7][2];
			Lz = tr[i][6][3];
			Rz = tr[i][7][3];
			for (int y = (int)tr[i][2][1] ; y <= (int)tr[i][1][1] ; y++) {
				       // INCREMENTALLY UPDATE VALUES ALONG LEFT AND RIGHT EDGES
				Lr += dLr;
				Lg += dLg;
				Lb += dLb;
				Rr += dRr;
				Rg += dRg;
				Rb += dRb;		 
				Lz += dLz;
				Rz += dRz;
				if (tr[i][2][0]>tr[i][1][0])
					Lx = (int)(tr[i][2][0] - (tr[i][2][0]-tr[i][1][0])*(y-tr[i][2][1])/(tr[i][1][1]-tr[i][2][1]));
				else 
					Lx =(int) (tr[i][2][0] + (tr[i][1][0]-tr[i][2][0])*(y-tr[i][2][1])/(tr[i][1][1]-tr[i][2][1]));
				
				if (tr[i][2][0]>tr[i][1][0])
					Rx = (int)(tr[i][3][0] - (tr[i][3][0]-tr[i][0][0])*(y-tr[i][3][1])/(tr[i][0][1]-tr[i][3][1]));
				else 
					Rx = (int)(tr[i][3][0] + (tr[i][0][0]-tr[i][3][0])*(y-tr[i][3][1])/(tr[i][0][1]-tr[i][3][1]));
				
			       // COMPUTE TOTAL NUMBER OF PIXELS ACROSS THIS SCAN LINE
				double m = Rx - Lx;
				//System.out.println(tr[i][0][0]);
				if (m != 0){
					dxr = (int)((Rr - Lr) / m);
					dxg = (int)((Rg - Lg) / m);
					dxb = (int)((Rb - Lb) / m);
					dxz = ((Rz - Lz) / m);
					Lxr = Lr;
					Lxg = Lg;
					Lxb = Lb;
					Lxz = Lz;
				}
				for (int x = (int)Lx ; x < (int)Rx ; x++) {
				          // INCREMENTALLY UPDATE VALUE AT PIXEL
					Lxr += dxr;
					Lxg += dxg;
					Lxb += dxb;
					Lxz += dxz;
					//System.out.println("x: "+x+"y: "+y);
					/*System.out.println(Rx);
					System.out.println(Lxz);*/
					if (x >= 0 && x < W && y >= 0 && y < H && zbuffer[x][y].getDepth() <= Lxz && Lxz < focalLength){
						zbuffer[x][y].setDepth(Lxz);
						zbuffer[x][y].setRGB((int)Lxr, (int)Lxg, (int)Lxb);
						//System.out.println("Lxr: " +Lxr +"Lxg: " + Lxg + "Lxb: "+ Lxb + "Lxz: " + Lxz);
						//System.out.println("x: "+ x+"y: "+y + "Lxz: " + Lxz);
					}
				}
			}
		}
		}
		}
		


    public void setPixel(int i, int j, int[] rgb){
        //LinearInterpolator LI = new LinearInterpolator();
    	/*if(zbuffer[i][j].getR()<0)rgb[0] = 0; 
    	else*/ rgb[0] = zbuffer[i][j].getR();
    	/*if(zbuffer[i][j].getG() < 0) rgb[1] = 0;
    	else */rgb[1] = zbuffer[i][j].getG();
    	/*if(zbuffer[i][j].getB() < 0) rgb[2] = 0;
    	else*/ rgb[2] = zbuffer[i][j].getB();

    }
    
    public void viewport(double src[], int dst[]) {
        //src[0] = (focalLength*src[0]/(focalLength-src[2]));
        //src[1] = (focalLength*src[1]/(focalLength-src[2]));
        dst[0] = (int) ( 320  + src[0] * 160);
        dst[1] = (int) (240- src[1] * 160);
     }

   /* void viewport(double src[], int dst[]) { 
	      dst[0] = (int)(0.5 * W  + src[0] * W);
	      dst[1] = (int)(0.5 * H - src[1] * W);
	      System.out.println(W +" "+ H);
	      System.out.println(Arrays.toString(dst));
	      
	   }*/
    
    public void perspective(double a[]){
		a[0] = a[0] * focalLength / (focalLength-a[2]);
		a[1] = a[1] * focalLength / (focalLength-a[2]);
	}

       // int[][] transformedVertices = new int[4][2];
        double[] a = new double[4];
        double[] b = new double[4];
        int[] pa = new int[2];
        int[] pb = new int[2];
        Matrix temp = new Matrix();
        Matrix global = new Matrix();
        Matrix local = new Matrix();
        //
        //double[][][] normal = new double[3][4][];
        //double[] phong = new double[3];
        //For each square there are four trapezoids
        /*double[][][] trapFaces = new double[4][8][];*/
        //double[][][] phong = new double[cylinder.faces.length][4][4]; //for each face there are four phong vectors
        //PHONG INCLUDES THE Z-DEPTH
        //double[][][] tempPhong = new double[cylinder.faces.length][4][3];
        //double[] reflection = new double[3];

    public double[][][] transformAndRenderCylinder(Geometry shape, Matrix parentMatrix){
        //TRAPS IS A THREE DIMENSIONAL ARRAY, FOR EACH FACE THERE ARE FOUR VECTORS OF LENGTH 2 (X,Y)
        double[][][] traps = new double[4*shape.faces.length][8][];
        double[][][] trapFaces = new double[4][8][];
        double[][] transformedVertices = new double[4][4];
        double[] reflection = new double[3];
        //four normals for each cylindrical face
        double[][][] normal = new double[shape.faces.length][4][3];
        double[][][] tempPhong = new double[shape.faces.length][4][3];
        double[][][] phong = new double[shape.faces.length][4][4];
        /*m=t=7;
        k = 1;*/

        global.identity();
        local.identity();
        temp.identity();
        global.multiply(parentMatrix);
        global.multiply(shape.getMatrix());
        local.multiply(shape.getLocal());
        temp.multiply(global);
        temp.multiply(local);

        a[0] = 0;
        a[1] = 0;
        a[2] = 0;
        a[3] = 0;
        b[0] = 0;
        b[1] = 0;
        b[2] = 0;
        b[3] = 0;
        pa[0] = 0;
        pa[1] = 0;
        pb[0] = 0;
        pb[1] = 0;
       // System.out.println(W + " " + H);
        //System.out.println(shape.faces.length);
        if (shape.vertices != null && shape.faces != null) {
            for (int i = 0 ; i < shape.faces.length ; i++) {
                // Each face composed by four vertices
                for (int j = 0 ; j < 4 ; j++) {
                    	
                        normal[i][j][0] =2*shape.vertices[shape.faces[i][j]][0];
                        normal[i][j][1] = 2* shape.vertices[shape.faces[i][j]][1];
                        normal[i][j][2] =  2* shape.vertices[shape.faces[i][j]][2];
                     //call createTriangles-in this file on each face   and sort the vertices by descending y-value
                    //call createTrapezoid() within the above method to set the vertices of the trapezoid
                    //also within createTriangles you can interpolate each trapezoid
                    double[] surfacePoint = {shape.vertices[shape.faces[i][j]][0],shape.vertices[shape.faces[i][j]][1],shape.vertices[shape.faces[i][j]][2]};
                    //System.out.println(Arrays.toString(tempNormal));
                    //we made the focalLength positive here
                    double[] v = {0,0,focalLength};
                    double[] w = new double[3];
                    w = minus(v,surfacePoint);
                    double[] tempNormal = normalize(normal[i][j]);
                    //System.out.println(Arrays.toString(surfacePoint));
                    reflection = computeReflection(w,surfacePoint,tempNormal);
					tempPhong[i][j] = computePhongShading(M.ambient,M.diffuse,M.spectral,M.specPow, light, reflection,tempNormal);
                    phong[i][j][0] = tempPhong[i][j][0];
                    phong[i][j][1] = tempPhong[i][j][1];
                    phong[i][j][2] = tempPhong[i][j][2];
                    phong[i][j][3] = surfacePoint[2];
                    temp.transform(shape.vertices[shape.faces[i][j]], a);
                    //System.out.println(Arrays.toString(a)+ " "+j);
                    //System.out.println(Arrays.toString(shape.vertices[shape.faces[i][j]])+" "+j);
                    //perspective(a);
                    //System.out.println(Arrays.toString(a)+" "+j);
                    transformedVertices[j] =(double[]) a.clone();
                   
                   // System.out.println(Arrays.toString(pa)+ " "+j);
                    //transformedVertices[j] =(int[]) pa.clone();
                   //System.out.println(Arrays.toString(transformedVertices[j])+"j: "+j);
                    

                }
                trapFaces = createTrapezoid(transformedVertices,phong[i]);
                /*for(int t=0;t<4;t++)
                	for(int k=0;k<8;k++) System.out.println(Arrays.toString(trapFaces[t][k])+ "face: "+t +"element: "+ k ); */
                //double[][][] tempTrapFaces = (double[][][]) trapFaces.clone();
                /*for(int t=0;t<4;t++)
                	for(int k=0;k<8;k++) System.out.println(Arrays.toString(trapFaces[t][k])+ "face: "+t +"element: "+ k );*/
                for(int t=0; t<4;t++){
                for(int k = 0; k <4;k++){
                	
                viewport(trapFaces[t][k],pa );
                trapFaces[t][k][0] = pa[0];
                trapFaces[t][k][1] = pa[1];
                //System.out.println(Arrays.toString(a)+ "face: "+t +"element: "+ k ); 
                }
                }
                /*for(int t=0;t<4;t++)
                	for(int k=4;k<8;k++) 
                		//if(trapFaces[t][k][2] < .7)
                		System.out.println(Arrays.toString(trapFaces[t][k])+ "face: "+t +"element: "+ k ); */
                
             //  }
               /*for(int k = 0; k<4;k++){
                	System.out.println(Arrays.toString(shape.vertices[shape.faces[i][k]]) +" vertex#= "+k + "face#= "+i);
                    //System.out.println(Arrays.toString(transformedVertices[k]) +" vertex#= "+k + "face#= "+i);
            }*/
               // trapFaces = trap.createTrapezoid(transformedVertices,phong[i]);
                
                /*for(int t= 0;t<4; t++){
                	for(int j =0; j<8;j++){
                		System.out.println("trapFaces: "+Arrays.toString(trapFaces[t][j])+" "+t+" "+j);
                	}
                		
                }*/
                
               for(int k = 0; k <8;k++){
                traps[i+3*i][k] = (double[]) trapFaces[0][k].clone();
               /*for(int t =0; t < 4;t++)
                System.out.println("traps: "+Arrays.toString(traps[i+3*i][t])+" "+ t);*/
                traps[i+1 +3*i][k] = (double[]) trapFaces[1][k].clone();
                traps[i+2 +3*i][k] = (double[]) trapFaces[2][k].clone();
                traps[i+3 +3*i][k] = (double[]) trapFaces[3][k].clone();
               /* for(int t =0; t < 4;t++)*/
                /*System.out.println("traps: "+Arrays.toString(traps[i+1+3*i][t])+" "+ t);
                for(int t =0; t < 4;t++)
                System.out.println("traps: "+Arrays.toString(traps[i+2+3*i][t])+" "+ t);
                for(int t =0; t < 4;t++)
                System.out.println("traps: "+Arrays.toString(traps[i+3+3*i][t])+" "+ t);*/
               }
               /*for(int t =0; t < 4;t++)
                   System.out.println("traps: "+Arrays.toString(traps[i+3*i][t])+" "+ t);
               System.out.println("traps: "+Arrays.toString(traps[i+1+3*i][t])+" "+ t);
               for(int t =0; t < 4;t++)
               System.out.println("traps: "+Arrays.toString(traps[i+2+3*i][t])+" "+ t);
               for(int t =0; t < 4;t++)
               System.out.println("traps: "+Arrays.toString(traps[i+3+3*i][t])+" "+ t);*/
            }
        }
        //if first and fourth vertex have same y coordinate the shape is either a parrollelogram or a triangle set TR = vertex0 TL= vertex 3
        //BL = vertex1 TL = vertex2

        for (int i = 0; i < shape.getNumChildren(); ++i) {
        transformAndRenderCylinder(shape.getChild(i), global);
        }

        return traps;
    }

        public double[] calculateSurfaceNormal(double[] center, double[] surfacePoint, double radius){

        return normalize(times(minus(surfacePoint, center),(1/radius)));

    }
    public double[] computeReflection(double x[], double surfacepoint[], double surfaceNormal[]){


        return normalize(minus(x, times(surfaceNormal,dot(surfaceNormal,x)*2)));


    }
    
    double[] tempMinus;
    public double[] minus(double[] x,double[] y){
    	
    	tempMinus = new double[x.length];
    	for(int i= 0; i < x.length; i++) tempMinus[i] = x[i]-y[i];
    	return tempMinus;
    
    }
    
    double product;
    public double dot(double x[], double y[]){
        product = 0;

        for (int i = 0; i < x.length; i++) product += x[i]*y[i];

        return product;

    }
    
    double tempResult[] = new double[3];
    public double[] times(double[] x, double y){
        tempResult[0] = 0;
        tempResult[1] = 0;
        tempResult[2] = 0;

        for (int i = 0; i < x.length; i++) tempResult[i] = y*x[i];

        return tempResult;
    }
    
    public double[] normalize(double[] x){
        double[] temp2 = new double[3];
        double norm;
        norm = 0;
        norm = Math.sqrt(dot(x,x));
        if (norm != 0){
        for (int i = 0; i < 3; i++) {
            temp2[i] = x[i]/norm;
        }
          }
        return temp2;


    }
    
    double[][] light = {{0,0,1,1,1,1},{0,0,-1,1,1,1},{1,0,0,1,1,1},{-1,0,0,1,1,1},{1,1,0,1,1,1}};
    double lightColor[] = new double[3];
    double lightPosition[] = new double[3];
    public double[] computePhongShading(double ambient[], double diffuse[], double spectral[], double spectralPow,double light[][], double reflection[], double surfaceNormal[]){
        double phong[] = new double[3];
        phong[0] = ambient[0];
        phong[1] = ambient[1];
        phong[2] = ambient[2];

        for (int k = 0; k < 5; k++){
            lightPosition[0] = light[k][0];
            lightPosition[1] = light[k][1];
            lightPosition[2] = light[k][2];

            lightColor[0] = light[k][3];
            lightColor[1]= light[k][4];
            lightColor[2] = light[k][5];

            lightPosition = normalize(lightPosition);

            for (int i=0; i <3; i++) {

                phong[i] = (phong[i] + lightColor[i]*(diffuse[i]*Math.max(dot(lightPosition,surfaceNormal),0) + spectral[i]*Math.pow(Math.max(0,dot(lightPosition,reflection)),spectralPow)));
                
                if (phong[i] >1) phong[i] =1;
            }
        }

        phong[0] =255*phong[0];
        phong[1] =255*phong[1];
        phong[2] =255*phong[2];
       // System.out.println(Arrays.toString(phong));
        
        return phong;

    }
   
    
    
/*double[][][] trapFace = new double[4][8][];
double[] TL1 = new double[3];
double[] TR1 = new double[3];
double[] BL1 = new double[3];
double[] BR1 = new double[3];
double[] TL2 = new double[3];
double[] TR2 = new double[3];
double[] BL2 = new double[3];
double[] BR2 = new double[3];
double[] TL3 = new double[3];
double[] TR3 = new double[3];
double[] BL3 = new double[3];
double[] BR3 = new double[3];
double[] TL4 = new double[3];
double[] TR4 = new double[3];
double[] BL4 = new double[3];
double[] BR4 = new double[3];
double[] phongTL1 = new double[4];
double[] phongTR1 = new double[4];
double[] phongBL1 = new double[4];
double[] phongBR1 = new double[4];
double[] phongTL2 = new double[4];
double[] phongTR2 = new double[4];
double[] phongBL2 = new double[4];
double[] phongBR2 = new double[4];
double[] phongTL3 = new double[4];
double[] phongTR3 = new double[4];
double[] phongBL3 = new double[4];
double[] phongBR3 = new double[4];
double[] phongTL4 = new double[4];
double[] phongTR4 = new double[4];
double[] phongBL4 = new double[4];
double[] phongBR4 = new double[4];*/
double[] a1 = new double[4];
double[] b1 = new double[4];
double[] c1 = new double[4];
double[] a2 = new double[4];
double[] b2 = new double[4];
double[] c2 = new double[4];
double[] phonga1 = new double[4];
double[] phongb1 = new double[4];
double[] phongc1 = new double[4];
double[] phonga2 = new double[4];
double[] phongb2 = new double[4];
double[] phongc2 = new double[4];

//THESE VERTICES SHOULD ALREADY BE TRANSFORMED ACCORDING TO THE VIEWPORT TRANSFORM
//here we are passing an array of vertices for each face (
//CHANGE THIS TO CREATE TRAPEZOID FROM ONE TRIANGLE
public void makeTriangles(double[][] v,double[][] phong){
	//assign vertices according to x order of v
	/*if(v[1][1] == v[0][1]){	
		if(v[1][0] >= v[0][0]){
			int[] temp = (int[]) v[1].clone();
			v[1] = (int[]) v[0].clone();
			v[0] = (int[]) temp.clone();
			
		}
	}*/
	/*if(v[2][1]==v[3][1]){
		if(v[2][0] >= v[3][0]){
			int[] temp = (int[]) v[3].clone();
			v[3] = (int[]) v[2].clone();
			v[2] = (int[]) temp.clone();
			
		}*/
	//}
	
	double[][] tempPhong = new double[4][4];
	for(int i = 0; i < 4; i++)
	tempPhong[i] = (double[]) phong[i].clone();
	if((v[2][0] <= v[3][0] && v[1][0]<=v[0][0])) {
	a1 = castToDouble(v[0]);
	//phong
	b1 = castToDouble(v[1]);
	c1 = castToDouble(v[2]);
	//System.out.println(Arrays.toString(a1));
	
	a2 = castToDouble(v[0]);
	b2 = castToDouble(v[2]);
	c2 = castToDouble(v[3]);
	
	phonga1 = (double[])phong[0].clone();
	phongb1 = (double[])phong[1].clone();
	phongc1 = (double[])phong[2].clone();
	
	phonga2 = (double[])phong[0].clone();
	phongb2 =(double[]) phong[2].clone();
	phongc2 = (double[])phong[3].clone();
	
	}
	else if((v[1][0]>=v[0][0] && v[2][0] >= v[3][0]) || (v[2][0] >= v[3][0] && v[1][0]<=v[0][0])){
		a1 = castToDouble(v[0]);
    	b1 = castToDouble(v[1]);
    	c1 = castToDouble(v[3]);
    	
    	a2 = castToDouble(v[0]);
    	b2 = castToDouble(v[2]);
    	c2 = castToDouble(v[3]);
		
    	phonga1 = (double[])phong[0].clone();
    	phongb1 = (double[])phong[1].clone();
    	phongc1 = (double[])phong[3].clone();
    	
    	phonga2 = (double[])phong[0].clone();
    	phongb2 = (double[])phong[2].clone();
    	phongc2 = (double[])phong[3].clone();
    	
	}
	else if(v[2][0] <= v[3][0] && v[1][0]>=v[0][0]){
		a1 = castToDouble(v[0]);
    	b1 = castToDouble(v[1]);
    	c1 = castToDouble(v[2]);
    	
    	a2 = castToDouble(v[1]);
    	b2 = castToDouble(v[2]);
    	c2 = castToDouble(v[3]);
    	
    	phonga1 = (double[])phong[0].clone();
    	phongb1 = (double[])phong[1].clone();
    	phongc1 = (double[])phong[2].clone();
    	
    	phonga2 = (double[])phong[1].clone();
    	phongb2 =(double[]) phong[2].clone();
    	phongc2 = (double[])phong[3].clone();
	}
	
}

public double[][][] createTrapezoid(double[][] vertices,double[][] tempPhong){
	/*for(int i = 0; i<4;i++)
        System.out.println(Arrays.toString(vertices[i]) +" " + i);*/
	double[][][] trapFace = new double[4][8][];
	double[] TL1 = new double[4];
	double[] TR1 = new double[4];
	double[] BL1 = new double[4];
	double[] BR1 = new double[4];
	double[] TL2 = new double[4];
	double[] TR2 = new double[4];
	double[] BL2 = new double[4];
	double[] BR2 = new double[4];
	double[] TL3 = new double[4];
	double[] TR3 = new double[4];
	double[] BL3 = new double[4];
	double[] BR3 = new double[4];
	double[] TL4 = new double[4];
	double[] TR4 = new double[4];
	double[] BL4 = new double[4];
	double[] BR4 = new double[4];
	double[] phongTL1 = new double[4];
	double[] phongTR1 = new double[4];
	double[] phongBL1 = new double[4];
	double[] phongBR1 = new double[4];
	double[] phongTL2 = new double[4];
	double[] phongTR2 = new double[4];
	double[] phongBL2 = new double[4];
	double[] phongBR2 = new double[4];
	double[] phongTL3 = new double[4];
	double[] phongTR3 = new double[4];
	double[] phongBL3 = new double[4];
	double[] phongBR3 = new double[4];
	double[] phongTL4 = new double[4];
	double[] phongTR4 = new double[4];
	double[] phongBL4 = new double[4];
	double[] phongBR4 = new double[4];
	/*double[] a1 = new double[3];
	double[] b1 = new double[3];
	double[] c1 = new double[3];
	double[] a2 = new double[3];
	double[] b2 = new double[3];
	double[] c2 = new double[3];
	double[] phonga1 = new double[4];
	double[] phongb1 = new double[4];
	double[] phongc1 = new double[4];
	double[] phonga2 = new double[4];
	double[] phongb2 = new double[4];
	double[] phongc2 = new double[4];*/
	
	double[][] tempVertices = new double[4][4];
	double[][] phong = new double[4][4];
	tempVertices[0][0] = vertices[0][0];
	tempVertices[0][1] = vertices[0][1];
	tempVertices[0][2] = vertices[0][2];
	tempVertices[1][0] = vertices[1][0];
	tempVertices[1][1] = vertices[1][1];
	tempVertices[1][2] = vertices[1][2];
	tempVertices[2][0] = vertices[2][0];
	tempVertices[2][1] = vertices[2][1];
	tempVertices[2][2] = vertices[2][2];
	tempVertices[3][0] = vertices[3][0];
	tempVertices[3][1] = vertices[3][1];
	tempVertices[3][2] = vertices[3][2];
	tempVertices[0][3]=0;
	tempVertices[1][3]=1;
	tempVertices[2][3]=2;
	tempVertices[3][3]=3;
	java.util.Arrays.sort(tempVertices, new java.util.Comparator<double[]>() {
	    public int compare(double[] a, double[] b) {
	        return (int)( b[1] - a[1]);
	    }
	  //call makeTriangles on each face of sorted values and take into account the degenerate case of a face which is a triangle
	    //the above method should set (a1,b1,c1) and (a2,b2,c2) -pass them in as empty arrays 
	  // using the vertices of the triangles set the values of the trapezoid vertices (TL, BL, etc)  
	    //remember the vertices are already sorted by increasing y so you just need to know whether the bottom vertex lies to the left
	    //or right of the top vertex
	    //now you can set the 4 trapezoidal faces in the returned array and everything else remains the same.
	  //
	});
	
	
			
	vertices[0][0]=tempVertices[0][0];
	vertices[0][1]=tempVertices[0][1];
	vertices[0][2]=tempVertices[0][2];
	vertices[1][0]=tempVertices[1][0];
	vertices[1][1]=tempVertices[1][1];
	vertices[1][2]=tempVertices[1][2];
	vertices[2][0]=tempVertices[2][0];
	vertices[2][1]=tempVertices[2][1];
	vertices[2][2]=tempVertices[2][2];
	vertices[3][0]=tempVertices[3][0];
	vertices[3][1]=tempVertices[3][1];
	vertices[3][2] =tempVertices[3][2];
	//for(int i= 0; i<4;i++) System.out.println(Arrays.toString(vertices[i]));
	//System.out.println(Arrays.toString(a1));
	/*System.out.println(Arrays.toString(b1));
	System.out.println(Arrays.toString(c1));
	System.out.println(Arrays.toString(a2));
	System.out.println(Arrays.toString(b2));
	System.out.println(Arrays.toString(c2));*/
	phong[0] = tempPhong[(int) tempVertices[0][3]];
	phong[1] = tempPhong[(int)tempVertices[1][3]];
	phong[2] = tempPhong[(int)tempVertices[2][3]];
	phong[3] = tempPhong[(int)tempVertices[3][3]];
	makeTriangles(vertices,phong); //these vertices will already be sorted
	/*phong[0] = tempPhong[tempVertices[0][2]];
	phong[1] = tempPhong[tempVertices[1][2]];
	phong[2] = tempPhong[tempVertices[2][2]];
	phong[3] = tempPhong[tempVertices[3][2]];*/
	TL1 =(double[]) a1.clone();
	//System.out.println("TL1: "+Arrays.toString(TL1));
	TR1 = (double[]) a1.clone();
	phongTL1 =(double[]) phonga1.clone();
	phongTR1 =(double[]) phonga1.clone();
	BR2 = (double[]) c1.clone();
	BL2 = (double[]) c1.clone();
	phongBR2 =(double[]) phongc1.clone();
	phongBL2 = (double[]) phongc1.clone();
	TL3 = (double[]) a2.clone();
	TR3 =(double[]) a2.clone();
	phongTL3 = (double[]) phonga2.clone();
	phongTR3 = (double[]) phonga2.clone();
	BR4 = (double[]) c2.clone();
	BL4 = (double[]) c2.clone();
	phongBR4 =(double[]) phongc2.clone();
	phongTR4 = (double[]) phongc2.clone();
	
	
	

  // if(vertices[0][1]!=vertices[3][1] && vertices[1][1]!=vertices[3][1]){
	   //CONSTRUCT A NORMAL TRAPEZOID
	// System.out.println("a1[1] " + a1[1]+"c1[1] "+c1[1]);
   if((a1[1]!=c1[1])){
	   //System.out.println("a1[1] " + a1[1]+"c1[1] "+c1[1]);
	   if(a1[0] >= b1[0]){
		   //System.out.println("YES");
		   BR1[0] = ((b1[1] - c1[1])/( a1[1] - c1[1]))*(a1[0] - c1[0]) + c1[0];
           BR1[1] = b1[1];
           BR1[2] =  ((b1[1] - c1[1])/( a1[1] - c1[1]))*(a1[2] - c1[2]) + c1[2];
           BL1 = (double[]) b1.clone();
           phongBL1 = (double[]) phongb1.clone();
           //if(BR2[1] == TR1[1])
           //System.out.println(BR2[1] + " "+TR1[1]);
           double[] surfacePoint = {BR1[0],BR1[1],BR1[2]};
           double[] normal = times(surfacePoint,2);
           
           double[] v = {0,0,focalLength};
           double[] w = new double[3];
           w = minus(v,surfacePoint);
           double[] tempNormal = normalize(normal);
         
           double[] reflection = computeReflection(w,surfacePoint,tempNormal);
			double[] newPhong = computePhongShading(M.ambient,M.diffuse,M.spectral,M.specPow, light, reflection,tempNormal);
           phongBR1[0] = newPhong[0];
           phongBR1[1] = newPhong[1];
           phongBR1[2] = newPhong[2];
           phongBR1[3] = surfacePoint[2];
           
           
	   
           TR2 = BR1;
           TL2 = BL1;
           
	   }
	   else{
		   BL1[0] = ((b1[1] - c1[1])/(a1[1] - c1[1]))*(a1[0] - c1[0]) + c1[0];
           BL1[1] = b1[1];
           BL1[2] = ((b1[1] - c1[1])/( a1[1] - c1[1]))*(a1[2] - c1[2]) + c1[2];
           BR1 = (double[]) b1.clone();
           phongBR1 = (double[]) phongb1.clone();
           double[] surfacePoint = {BL1[0],BL1[1],BL1[2]};
           double[] normal = times(surfacePoint,2);
           
           double[] v = {0,0,focalLength};
           double[] w = new double[3];
           w = minus(v,surfacePoint);
           double[] tempNormal = normalize(normal);
         
          double[] reflection = computeReflection(w,surfacePoint,tempNormal);
			double[] newPhong = computePhongShading(M.ambient,M.diffuse,M.spectral,M.specPow, light, reflection,tempNormal);
           phongBL1[0] = newPhong[0];
           phongBL1[1] = newPhong[1];
           phongBL1[2] = newPhong[2];
           phongBL1[3] = surfacePoint[2];
           TR2 = BR1;
           TL2 = BL1;
	   }
   }
	   if((a2[1]!=c2[1])){
	   if(a2[0] >= b2[0]){
		   BR3[0] = ((b2[1] - c2[1])/( a2[1] - c2[1]))*(a2[0] - c2[0]) + c2[0];
           BR3[1] = b2[1];
           BR3[2] = ((b2[1] - c2[1])/( a2[1] - c2[1]))*(a2[2] - c2[2]) + c2[2];
           BL3 = (double[])b2.clone();
           phongBL3 = (double[])phongb2.clone();
           double[] surfacePoint = {BR3[0],BR3[1],BR3[2]};
           double[] normal = times(surfacePoint,2);
           
           double[] v = {0,0,focalLength};
           double[] w = new double[3];
           w = minus(v,surfacePoint);
           double[] tempNormal = normalize(normal);
         
          double[] reflection = computeReflection(w,surfacePoint,tempNormal);
			double[] newPhong = computePhongShading(M.ambient,M.diffuse,M.spectral,M.specPow, light, reflection,tempNormal);
           phongBR3[0] = newPhong[0];
           phongBR3[1] = newPhong[1];
           phongBR3[2] = newPhong[2];
           phongBR3[3] = surfacePoint[2];
           TR4 = BR3;
           TL4 = BL3;
           
	   }
	   else{
		   BL3[0] = ((b2[1] - c2[1])/(a2[1] - c2[1]))*(a2[0] - c2[0]) + c2[0];
           BL3[1] = b2[1];
           BL3[2] = ((b2[1] - c2[1])/( a2[1] - c1[1]))*(a2[2] - c2[2]) + c2[2];
           BR3 = (double[])b2.clone();
           phongBR3 = (double[])phongb2.clone();
           double[] surfacePoint = {BL3[0],BL3[1],BL3[2]};
           double[] normal = times(surfacePoint,2);
           
           double[] v = {0,0,focalLength};
           double[] w = new double[3];
           w = minus(v,surfacePoint);
           double[] tempNormal = normalize(normal);
         
           double[] reflection = computeReflection(w,surfacePoint,tempNormal);
			double[] newPhong = computePhongShading(M.ambient,M.diffuse,M.spectral,M.specPow, light, reflection,tempNormal);
           phongBL3[0] = newPhong[0];
           phongBL3[1] = newPhong[1];
           phongBL3[2] = newPhong[2];
           phongBL3[3] = surfacePoint[2];
           TR4 = BR3;
           TL4 = BL3;
	   }
	   
	   
    
   }
   else{
	   BL1[0] = TL1[0];
	   BL1[1] = TL1[1];
	   BR1[0] = TL1[0];
	   BR1[1] = TL1[1];
	   BL3[0] = TL1[0];
	   BL3[1] = TL1[1];
	   BR3[0] = TL1[0];
	   BR3[1] = TL1[1];
	   phongBL1 = (double[]) phongTL1.clone();
	   phongBR1 = (double[]) phongTL1.clone();
	   phongBL3 = (double[]) phongTL1.clone();
	   phongBR3 = (double[]) phongTL1.clone();
			   
   }

	   
	   
   
    //CLONE ALL THESE OBJECTS

    //TL2= BL1;
    //TR2 = BR1;
    phongTL2 = phongBL1;
    phongTR2 = phongBR1;

    //TR4 = BR3;
    //TL4 = BL3;
    phongTL4 = phongBL3;
    phongTR4 = phongBR3;

    
   /* System.out.println("TR1: "+Arrays.toString(TR1));
    System.out.println("TL1: "+Arrays.toString(TL1));
    System.out.println("BL1: "+Arrays.toString(BL1));
    System.out.println("TR1: "+Arrays.toString(BR1));*/

    trapFace[0][0] = (double[]) TR1.clone();//(x,y) values
    trapFace[0][1] = (double[])TL1.clone();
    trapFace[0][2] = (double[])BL1.clone();
    trapFace[0][3] = (double[])BR1.clone();
    trapFace[0][4] = (double[])phongTR1.clone();//(r,g,b,z) values
    trapFace[0][5] = (double[])phongTL1.clone();
    trapFace[0][6] = (double[])phongBL1.clone();
    trapFace[0][7] = (double[])phongBR1.clone();
    /*System.out.println("trap: "+Arrays.toString(trapFace[0][0]));
    System.out.println("trap: "+Arrays.toString(trapFace[0][1]));
    System.out.println("trap: "+Arrays.toString(trapFace[0][2]));
    System.out.println("trap: "+Arrays.toString(trapFace[0][3]));*/
 /*   System.out.println
    System.out.println(Arrays.toString(trapFace[0][4]));
    System.out.println(Arrays.toString(trapFace[0][5]));
    System.out.println(Arrays.toString(trapFace[0][6]));
    System.out.println(Arrays.toString(trapFace[0][7]));*/

    trapFace[1][0] = (double[]) TR2.clone();
    trapFace[1][1] = (double[]) TL2.clone();
    trapFace[1][2] = (double[]) BL2.clone();
    trapFace[1][3] = (double[]) BR2.clone();
    trapFace[1][4] = (double[]) phongTR2.clone();
    trapFace[1][5] = (double[]) phongTL2.clone();
    trapFace[1][6] = (double[]) phongBL2.clone();
    trapFace[1][7] = (double[]) phongBR2.clone();
      
   /* System.out.println(Arrays.toString(trapFace[1][0]));
    System.out.println(Arrays.toString(trapFace[1][1]));
    System.out.println(Arrays.toString(trapFace[1][2]));
    System.out.println(Arrays.toString(trapFace[1][3]));*/

    trapFace[2][0] = (double[]) TR3.clone();
    trapFace[2][1] = (double[]) TL3.clone();
    trapFace[2][2] = (double[]) BL3.clone();
    trapFace[2][3] = (double[]) BR3.clone();
    trapFace[2][4] = (double[]) phongTR3.clone();
    trapFace[2][5] = (double[]) phongTL3.clone();
    trapFace[2][6] = (double[]) phongBL3.clone();
    trapFace[2][7] = (double[]) phongBR3.clone();

    trapFace[3][0] = (double[]) TR4.clone();
    trapFace[3][1] = (double[]) TL4.clone();
    trapFace[3][2] = (double[]) BL4.clone();
    trapFace[3][3] = (double[]) BR4.clone();
    trapFace[3][4] = (double[]) phongTR4.clone();
    trapFace[3][5] = (double[]) phongTL4.clone();
    trapFace[3][6] = (double[]) phongBL4.clone();
    trapFace[3][7] = (double[]) phongBR4.clone();
    
    /*for(int i=0;i<4;i++)
    	for(int j=0;j<4;j++) System.out.println(Arrays.toString(trapFace[i][j])+ "face: "+i ); */
    
   

    
    return trapFace;



}
public double[] castToDouble(double[] array){
	double[] temp = new double[array.length];
	for(int i = 0; i < array.length;i++) temp[i] =  array[i];
	return temp;
}
}