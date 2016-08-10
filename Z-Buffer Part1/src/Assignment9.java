import java.awt.*;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.util.Arrays;

//try this on a sphere
public class Assignment9 extends MISApplet{

    Geometry cylinder = new Geometry();
    Matrix matrix = new Matrix();
    //cylinder.createCylinder(10,10,10);
    Material M = new Material();
    
    
    double focalLength = 10;
    Trapezoid trap = new Trapezoid();
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
		cylinder.createCylinder(7,7,1);
    	M = cylinder.getMaterial();
    	M.setAmbient(0,0,.2);
        M.setMirrorColor(.5,.5,.5);
        M.setDiffuse(0,0,1);
        M.setSpectral(.5,.5,.5);
        faces = new double[4*cylinder.faces.length][8][];
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
        faces = transformAndRenderCylinder(cylinder, matrix);
        /*for(int i= 0; i < 4; i++){
			for(int j=0; j <8; j++){
			//System.out.println(tr[i][2][1] +" - "+tr[i][1][1]);
			System.out.println(Arrays.toString(faces[i][j]) + "i: "+i+" j: "+j);
			}
        }*/
        interpolate(faces);
        
    	Matrix m;
		  
		m = cylinder.getMatrix();
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
		double n;
		for(int i= 0; i < 4*cylinder.faces.length; i++){
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
					Lx = (int)(tr[i][2][0] + (tr[i][1][0]-tr[i][2][0])*(y-tr[i][2][1])/(tr[i][1][1]-tr[i][2][1]));
				
				if (tr[i][2][0]>tr[i][1][0])
					Rx = (int)(tr[i][3][0] - (tr[i][3][0]-tr[i][0][0])*(y-tr[i][3][1])/(tr[i][0][1]-tr[i][3][1]));
				else 
					Rx = (int)(tr[i][3][0] + (tr[i][0][0]-tr[i][3][0])*(y-tr[i][3][1])/(tr[i][0][1]-tr[i][3][1]));
				
			       // COMPUTE TOTAL NUMBER OF PIXELS ACROSS THIS SCAN LINE
				double m = Rx - Lx;
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
					if (x >= 0 && x < W && y >= 0 && y < H && zbuffer[x][y].getDepth() < Lxz && Lxz < focalLength){
						zbuffer[x][y].setDepth(Lxz);
						zbuffer[x][y].setRGB((int)Lxr, (int)Lxg, (int)Lxb);
						//System.out.println("Lxr: " +Lxr +"Lxg: " + Lxg + "Lxb: "+ Lxb + "Lxz: " + Lxz);
						System.out.println("x: "+ x+"y: "+y + "Lxz: " + Lxz);
					}
				}
			}
		}
		}
		}
		


    public void setPixel(int i, int j, int[] rgb){
        //LinearInterpolator LI = new LinearInterpolator();
    	rgb[0] = zbuffer[i][j].getR();
		rgb[1] = zbuffer[i][j].getG();
		rgb[2] = zbuffer[i][j].getB();

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
        double[][][] trapFaces = new double[4][8][];
        //double[][][] phong = new double[cylinder.faces.length][4][4]; //for each face there are four phong vectors
        //PHONG INCLUDES THE Z-DEPTH
        //double[][][] tempPhong = new double[cylinder.faces.length][4][3];
        double[] reflection = new double[3];

    public double[][][] transformAndRenderCylinder(Geometry shape, Matrix parentMatrix){
        //TRAPS IS A THREE DIMENSIONAL ARRAY, FOR EACH FACE THERE ARE FOUR VECTORS OF LENGTH 2 (X,Y)
        double[][][] traps = new double[4*shape.faces.length][8][];
        int[][] transformedVertices = new int[4][2];
        //four normals for each cylindrical face
        double[][][] normal = new double[shape.faces.length][4][3];
        double[][][] tempPhong = new double[shape.faces.length][4][3];
        double[][][] phong = new double[shape.faces.length][4][4];
        m=t=7;
        k = 1;

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
                    if(i + i*j <= m + (m+1)*k){ normal[i][j][2] = 1;}
                    else if(i +i*j <= (m+1)*(k+1)+1+m+(t+1)*t){
                        normal[i][j][0] =2*shape.vertices[shape.faces[i][j]][0];
                        normal[i][j][1] = 2* shape.vertices[shape.faces[i][j]][1];
                    }
                    else{
                        normal[i][j][2] = -1;
                    }
                   
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
                    viewport(a, pa);
                   // System.out.println(Arrays.toString(pa)+ " "+j);
                    transformedVertices[j] =(int[]) pa.clone();
                   //System.out.println(Arrays.toString(transformedVertices[j])+"j: "+j);
                    

                }
              /* for(int k = 0; k<4;k++){
                	System.out.println(Arrays.toString(shape.vertices[shape.faces[i][k]]) +" vertex#= "+k + "face#= "+i);
                    System.out.println(Arrays.toString(transformedVertices[k]) +" vertex#= "+k + "face#= "+i);
            }*/
                trapFaces = trap.createTrapezoid(transformedVertices,phong[i]);
                
                /*for(int t= 0;t<4; t++){
                	for(int j =0; j<8;j++){
                		System.out.println("trapFaces: "+Arrays.toString(trapFaces[t][j]));
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
        //System.out.println(Arrays.toString(phong));
        
        return phong;

    }
   
    }
    

