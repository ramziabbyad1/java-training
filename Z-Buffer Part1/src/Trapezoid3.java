import java.awt.*;
import java.util.Arrays;

public class Trapezoid3{

    //double[][] trapezoidalFaces = new double [][4];

    //public double[][] transformPolygon(double[][] vertices){}

    int[][] tempArray = new int[4][2];
    int[][] vertex = new int[4][2];
    //RETURNS THE ARRAY OF VERTICES FOR A PARTICULAR FACE SORTED ACCORDING TO INCREASING Y
    //ALSO SORTS THE PHONG ARRAY ACCORDING TO INCREASING Y-VALUE
    //CHECK CUSTOM SORT
    public int[][] transpose(int[][] v){
    	System.out.println(v[0].length);
    	System.out.println(v.length);
    	int[][] temp = new int[v.length][v[0].length];
    	for(int i = 0; i < v.length;i++) 
    		for(int j=0; j < v[0].length;j++) temp[i][j] = v[j][i];
    	//for(int i = 0; i <v[0].length;i++)
    		//v[i] =(int[]) temp[i].clone();
    	return temp;
    }
    
    public void customSort(int[][] vertices,double[][] phong){
        tempArray = vertices;
        int[][] verticesT;
        double[][] tempPhong = phong;
        //in order to sort vertices by y, we need to take the transpose of vertices and select first column
        verticesT = transpose(vertices);
        Arrays.sort(verticesT[1]);
        //vertices = transpose(verticesT);

        for(int i =0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(tempArray[i][1] == verticesT[1][j]){
                    vertex[i] = (int[]) tempArray[j].clone();
                    phong[i] = (double[]) tempPhong[j].clone();
                }
            }
        }
        reverseOrder(vertex);
        reverseOrder(phong);
        vertices =(int[][]) vertex.clone();
    }

    public void reverseOrder(int[][] array){
        int[][] tempArray = new int[4][2];
        int n = 4;
        for(int i =0; i < 4; i++){
            tempArray[i] =(int[]) array[3-i].clone();
        }
        array = (int[][]) tempArray.clone();
    }

    public void reverseOrder(double[][] array){
        double[][] tempArray = new double[4][2];
        int n = 4;
        for(int i =0; i < 4; i++){
            tempArray[i] =(double[]) array[3-i].clone();
        }
        array = (double[][]) tempArray.clone();
    }
    
    public double[] castToDouble(int[] array){
    	double[] temp = new double[array.length];
    	for(int i = 0; i < array.length;i++) temp[i] = (double) array[i];
    	return temp;
    }

    double[][][] trapFace = new double[4][8][];
    double[] TL1 = new double[2];
    double[] TR1 = new double[2];
    double[] BL1 = new double[2];
    double[] BR1 = new double[2];
    double[] TL2 = new double[2];
    double[] TR2 = new double[2];
    double[] BL2 = new double[2];
    double[] BR2 = new double[2];
    double[] TL3 = new double[2];
    double[] TR3 = new double[2];
    double[] BL3 = new double[2];
    double[] BR3 = new double[2];
    double[] TL4 = new double[2];
    double[] TR4 = new double[2];
    double[] BL4 = new double[2];
    double[] BR4 = new double[2];
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
    double[] a1 = new double[2];
    double[] b1 = new double[2];
    double[] c1 = new double[2];
    double[] a2 = new double[2];
    double[] b2 = new double[2];
    double[] c2 = new double[2];
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
    	if(v[1][1] == v[0][1]){	
    		if(v[1][0] >= v[0][0]){
    			double[] temp = (double[]) v[1].clone();
    			v[1] = (double[]) v[0].clone();
    			v[0] = (double[]) temp.clone();
    			
    		}
    	}
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
    	if((v[2][0] <= v[3][0] && v[1][0]<=v[0][0]) ||(v[1][0]>=v[0][0] && v[2][0] >= v[3][0])) {
    	a1 = (double[])v[0].clone();
    	//phong
    	b1 = (double[])v[1].clone();
    	c1 = (double[])v[2].clone();
    	//System.out.println(double)Arrays.toString(double)a1));
    	
    	a2 = (double[])v[0].clone();
    	b2 = (double[])v[2].clone();
    	c2 = (double[])v[3].clone();
    	
    	phonga1 = (double[])phong[0].clone();
    	phongb1 = (double[])phong[1].clone();
    	phongc1 = (double[])phong[2].clone();
    	
    	phonga2 = (double[])phong[0].clone();
    	phongb2 = (double[])phong[2].clone();
    	phongc2 = (double[])phong[3].clone();
    	
    	}
    	else if(/*(v[1][0]>=v[0][0] && v[2][0] >= v[3][0]) || */(v[2][0] >= v[3][0] && v[1][0]<=v[0][0])){
    		a1 = (double[])v[0].clone();
        	b1 = (double[])v[1].clone();
        	c1 = (double[])v[3].clone();
        	
        	a2 = (double[])v[0].clone();
        	b2 = (double[])v[2].clone();
        	c2 = (double[])v[3].clone();
    		
        	phonga1 =(double[]) phong[0].clone();
        	phongb1 = (double[])phong[1].clone();
        	phongc1 = (double[])phong[3].clone();
        	
        	phonga2 = (double[])phong[0].clone();
        	phongb2 = (double[])phong[2].clone();
        	phongc2 = (double[])phong[3].clone();
        	
    	}
    	else if(v[2][0] <= v[3][0] && v[1][0]>=v[0][0]){
    		a1 = (double[])v[0].clone();
        	b1 = (double[])v[1].clone();
        	c1 = (double[])v[2].clone();
        	
        	a2 = (double[])v[1].clone();
        	b2 = (double[])v[2].clone();
        	c2 = (double[])v[3].clone();
        	
        	phonga1 = (double[])phong[0].clone();
        	phongb1 = (double[])phong[1].clone();
        	phongc1 = (double[])phong[2].clone();
        	
        	phonga2 =(double[]) phong[1].clone();
        	phongb2 = (double[])phong[2].clone();
        	phongc2 = (double[])phong[3].clone();
    	}
    	
	}
    
    public double[][][] createTrapezoid(double[][] vertices,double[][] tempPhong, Material M){
    	/*for(int i = 0; i<4;i++)
            System.out.println(Arrays.toString(vertices[i]) +" " + i);*/
    	
    	
    	double[][] tempVertices = new double[4][3];
    	double[][] phong = new double[4][4];
    	tempVertices[0][0] = vertices[0][0];
    	tempVertices[0][1] = vertices[0][1];
    	tempVertices[1][0] = vertices[1][0];
    	tempVertices[1][1] = vertices[1][1];
    	tempVertices[2][0] = vertices[2][0];
    	tempVertices[2][1] = vertices[2][1];
    	tempVertices[3][0] = vertices[3][0];
    	tempVertices[3][1] = vertices[3][1];
    	tempVertices[0][2]=0;
    	tempVertices[1][2]=1;
    	tempVertices[2][2]=2;
    	tempVertices[3][2]=3;
    	java.util.Arrays.sort(tempVertices, new java.util.Comparator<double[]>() {
    	    public int compare(double[] a, double[] b) {
    	        return (int)(b[1] - a[1]);
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
    	vertices[1][0]=tempVertices[1][0];
    	vertices[1][1]=tempVertices[1][1];
    	vertices[2][0]=tempVertices[2][0];
    	vertices[2][1]=tempVertices[2][1];
    	vertices[3][0]=tempVertices[3][0];
    	vertices[3][1]=tempVertices[3][1];
    	phong[0] =(double[]) tempPhong[(int)tempVertices[0][2]].clone();
    	phong[1] = (double[]) tempPhong[(int)tempVertices[1][2]].clone();
    	phong[2] = (double[]) tempPhong[(int)tempVertices[2][2]].clone();
    	phong[3] = (double[]) tempPhong[(int)tempVertices[3][2]].clone();
    	//for(int i=0;i<4;i++) System.out.println(Arrays.toString(vertices[i])+"i:" +i);
    	makeTriangles(vertices,phong); //these vertices will already be sorted
    	/*phong[0] = tempPhong[tempVertices[0][2]];
    	phong[1] = tempPhong[tempVertices[1][2]];
    	phong[2] = tempPhong[tempVertices[2][2]];
    	phong[3] = tempPhong[tempVertices[3][2]];*/
    	TL1 = (double[])a1.clone();
    	TR1 = (double[])a1.clone();
    	phongTL1 = phongTR1 = (double[]) phonga1.clone();
    	BR2 = BL2 = (double[]) c1.clone();
    	phongBR2 = phongBL2 = (double[]) phongc1.clone();
    	
    	TL3 = TR3 =(double[])a2.clone();
    	phongTL3 = phongTR3 = (double[])phonga2.clone();
    	BR4 = BL4 = (double[])c2.clone();
    	phongBR4 = phongBL4 =(double[]) phongc2.clone();
    	
    	
    	

      // if(vertices[0][1]!=vertices[3][1] && vertices[1][1]!=vertices[3][1]){
    	   //CONSTRUCT A NORMAL TRAPEZOID
    	// System.out.println("a1[1] " + a1[1]+"c1[1] "+c1[1]);
    	/*if((a1[1]==c1[1])){ System.out.println("BAD");
    	System.out.println("a1: "+Arrays.toString(a1));
    	System.out.println("b1: "+Arrays.toString(b1));
    	System.out.println("c1: "+Arrays.toString(c1));
    	System.out.println("a2: "+Arrays.toString(a2));
    	System.out.println("b2: "+Arrays.toString(b2));
    	System.out.println("c2: "+Arrays.toString(c2));
    	}*/
       if((a1[1]!=c1[1])){
    	   //System.out.println("a1[1] " + a1[1]+"c1[1] "+c1[1]);
    	   if(a1[0] >= b1[0]){
    		   //System.out.println("YES");
    		   BR1[0] = ((b1[1] - c1[1])/( a1[1] - c1[1]))*(a1[0] - c1[0]) + c1[0];
               BR1[1] = b1[1];
               BL1 = b1;
               phongBL1 = phongb1;
               if(BR2[1] == TR1[1])
               System.out.println(BR2[1] + " "+TR1[1]);
               /*if(BR2[1] != TR1[1]){
               double ty1 = (BR1[1]-TR1[1])/(BR2[1]-TR1[1]); 
               double BR1red = phongTR1[0] + (phongBR2[0]-phongTR1[0])*(ty1);
               double BR1green =phongTR1[1] + (phongBR2[1]-phongTR1[1])*(ty1);
               double BR1blue = phongTR1[2] + (phongBR2[2]-phongTR1[2])*(ty1);*/
               //double tempNormal = {2*BR1[0],2*BR1[1],
               /*phongBR1[0] = 0;
               phongBR1[1] = 0;
               phongBR1[2] = 255;*/
               if(phongb1[1] != phongc1[1])
               phongBR1[3] = ((phonga1[3]-phongc1[3])/(a1[1]-c1[1]))*(b1[1] - c1[1]) + phongc1[3];
               else phongBR1[3] = phongb1[3];
   double[] surfacePoint = {BR1[0],BR1[1],phongBR1[3]};
               double[] tempNormal = times(surfacePoint,2);
               double[] v = {0,0,10};
               double[] w = new double[3];
               w = minus(v,surfacePoint);
               double[] reflection = computeReflection(w,surfacePoint,normalize(tempNormal));
               double[] p = computePhongShading(M.ambient,M.diffuse,M.spectral,M.specPow, light, reflection,tempNormal);
               phongBR1[0] = p[0];
               phongBR1[1] = p[1];
               phongBR1[2] = p[2];
               //System.out.println(Arrays.toString(surfacePoint));
    	   //}
               TR2 = BR1;
               TL2 = BL1;
               
    	   }
    	   else{
    		   BL1[0] = ((b1[1] - c1[1])/(a1[1] - c1[1]))*(a1[0] - c1[0]) + c1[0];
               BL1[1] = b1[1];
               BR1 = b1;
               phongBR1 = phongb1;
              /* double ty1 = (BL1[1]-TL1[1])/(BL2[1]-TL1[1]); 
               double BR1red = phongTL1[0] + (phongBL2[0]-phongTL1[0])*(ty1);
               double BR1green =phongTL1[1] + (phongTL2[1]-phongTL1[1])*(ty1);
               double BR1blue = phongTL1[2] + (phongBL2[2]-phongTL1[2])*(ty1);*/
               /*phongBL1[0] = 0;
               phongBL1[1] = 0;
               phongBL1[2] = 255;*/
               if(phongb1[1] != phongc1[1])
               phongBL1[3] = ((phonga1[3]-phongc1[3])/(a1[1]-c1[1]))*(b1[1] - c1[1]) + phongc1[3];
               else phongBL1[3] = phongb1[3];
               double[] surfacePoint = {BL1[0],BL1[1],phongBL1[3]};
               double[] tempNormal = times(surfacePoint,2);
               double[] v = {0,0,10};
               double[] w = new double[3];
               w = minus(v,surfacePoint);
               double[] reflection = computeReflection(w,surfacePoint,normalize(tempNormal));
               double[] p = computePhongShading(M.ambient,M.diffuse,M.spectral,M.specPow, light, reflection,tempNormal);
               phongBL1[0] = p[0];
               phongBL1[1] = p[1];
               phongBL1[2] = p[2];
              // System.out.println(Arrays.toString(surfacePoint));
               TR2 = BR1;
               TL2 = BL1;
    	   }
       }
       
       /*else{
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
    			   
       }*/
    	  if((a2[1]!=c2[1])){
    	   if(a2[0] >= b2[0]){
    		   BR3[0] = ((b2[1] - c2[1])/( a2[1] - c2[1]))*(a2[0] - c2[0]) + c2[0];
               BR3[1] = b2[1];
               BL3 = b2;
               phongBL3 = phongb2;
               /*double ty1 = (BR3[1]-TR3[1])/(BR4[1]-TR3[1]); 
               double BR1red = phongTR3[0] + (phongBR4[0]-phongTR3[0])*(ty1);
               double BR1green =phongTR3[1] + (phongBR4[1]-phongTR3[1])*(ty1);
               double BR1blue = phongTR3[2] + (phongBR4[2]-phongTR3[2])*(ty1);*/
               /*phongBR3[0] = 0;
               phongBR3[1] = 0;
               phongBR3[2] = 255;*/
               phongBR3[3] = ((phonga2[3]-phongc2[3])/(a2[1]-c2[1]))*(b2[1] - c2[1]) + phongc2[3];
               double[] surfacePoint = {BR3[0],BR3[1],phongBR3[3]};
               double[] tempNormal = times(surfacePoint,2);
               double[] v = {0,0,10};
               double[] w = new double[3];
               w = minus(v,surfacePoint);
               double[] reflection = computeReflection(w,surfacePoint,normalize(tempNormal));
               double[] p = computePhongShading(M.ambient,M.diffuse,M.spectral,M.specPow, light, reflection,tempNormal);
               //System.out.println(Arrays.toString(surfacePoint));
               phongBR3[0] = p[0];
               phongBR3[1] = p[1];
               phongBR3[2] = p[2];
               TR4 = BR3;
               TL4 = BL3;
               
    	   }
    	   else{
    		   BL3[0] = ((b2[1] - c2[1])/(a2[1] - c2[1]))*(a2[0] - c2[0]) + c2[0];
               BL3[1] = b2[1];
               BR3 = b2;
               phongBR3 = phongb2;
             /*  double ty1 = (BL3[1]-TL3[1])/(BL4[1]-TL3[1]); 
               double BR1red = phongTL3[0] + (phongBL4[0]-phongTL3[0])*(ty1);
               double BR1green =phongTL3[1] + (phongTL4[1]-phongTL3[1])*(ty1);
               double BR1blue = phongTL3[2] + (phongBL4[2]-phongTL3[2])*(ty1);*/
               /*phongBL3[0] = 0;
               phongBL3[1] = 0;
               phongBL3[2] = 255;*/
               phongBL3[3] = ((phonga2[3]-phongc2[3])/(a2[1]-c2[1]))*(b2[1] - c2[1]) + phongc2[3];
               double[] surfacePoint = {BL3[0],BL3[1],phongBL3[3]};
               double[] tempNormal = times(surfacePoint,2);
               double[] v = {0,0,10};
               double[] w = new double[3];
               w = minus(v,surfacePoint);
               double[] reflection = computeReflection(w,surfacePoint,normalize(tempNormal));
               double[] p = computePhongShading(M.ambient,M.diffuse,M.spectral,M.specPow, light, reflection,tempNormal);
               phongBL3[0] = p[0];
               phongBL3[1] = p[1]; 
              phongBL3[2] = p[2];
              //System.out.println(Arrays.toString(surfacePoint));
               TR4 = BR3;
               TL4 = BL3;
    	   }
    	   
    	   
    	  }   
       
       /*else{
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
    			   
       }*/
    	  
   
    	   
    	   
       
        //CLONE ALL THESE OBJECTS

        //TL2= BL1;
        //TR2 = BR1;
        phongTL2 = (double[])phongBL1.clone();
        phongTR2 = (double[])phongBR1.clone();

        //TR4 = BR3;
        //TL4 = BL3;
        phongTL4 = (double[])phongBL3.clone();
        phongTR4 = (double[])phongBR3.clone();


        trapFace[0][0] = (TR1);//(x,y) values
        trapFace[0][1] = (TL1);
        trapFace[0][2] = (BL1);
        trapFace[0][3] = (BR1);
        trapFace[0][4] = phongTR1;//(r,g,b,z) values
        trapFace[0][5] = phongTL1;
        trapFace[0][6] = phongBL1;
        trapFace[0][7] = phongBR1;
        
     /*   System.out.println
        System.out.println(Arrays.toString(trapFace[0][4]));
        System.out.println(Arrays.toString(trapFace[0][5]));
        System.out.println(Arrays.toString(trapFace[0][6]));
        System.out.println(Arrays.toString(trapFace[0][7]));*/

        trapFace[1][0] = (TR2);
        trapFace[1][1] = (TL2);
        trapFace[1][2] = (BL2);
        trapFace[1][3] = (BR2);
        trapFace[1][4] = phongTR2;
        trapFace[1][5] = phongTL2;
        trapFace[1][6] = phongBL2;
        trapFace[1][7] = phongBR2;

        trapFace[2][0] = (TR3);
        trapFace[2][1] = (TL3);
        trapFace[2][2] = (BL3);
        trapFace[2][3] = (BR3);
        trapFace[2][4] = phongTR3;
        trapFace[2][5] = phongTL3;
        trapFace[2][6] = phongBL3;
        trapFace[2][7] = phongBR3;

        trapFace[3][0] = (TR4);
        trapFace[3][1] = (TL4);
        trapFace[3][2] = (BL4);
        trapFace[3][3] = (BR4);
        trapFace[3][4] = phongTR4;
        trapFace[3][5] = phongTL4;
        trapFace[3][6] = phongBL4;
        trapFace[3][7] = phongBR4;
        
        for(int i=0;i<4;i++)
        	for(int j=0;j<8;j++)
        		if(trapFace[i][4][3] > 1.0 || trapFace[i][4][3] < -1.0 || trapFace[i][5][3] > 1.0 || trapFace[i][5][3] < -1.0 || trapFace[i][6][3] > 1.0 || trapFace[i][6][3] < -1.0 || trapFace[i][7][3] > 1.0 || trapFace[i][7][3] < -1.0){
        		System.out.println(Arrays.toString(trapFace[i][j])+ "face: "+i ); 
        		}
     //  }

        
        return trapFace;



    }
    double[] inversePoints = new double[3];
    public double[] inverseViewport(double px,double py, double z){
    	inversePoints[0] = (px -320)/160;
    	inversePoints[1] = (240 - py)/160;
    	inversePoints[2] = z;
    	
    	return inversePoints;
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
    
   double[][] light = {{0,10,0,1,1,1},{0,-10,0,1,1,1}};/*,{1,0,0,1,1,1},{-1,0,0,1,1,1},{1,1,0,1,1,1}};*/
    double lightColor[] = new double[3];
    double lightPosition[] = new double[3];
    public double[] computePhongShading(double ambient[], double diffuse[], double spectral[], double spectralPow,double light[][], double reflection[], double surfaceNormal[]){
        double phong[] = new double[3];
        phong[0] = ambient[0];
        phong[1] = ambient[1];
        phong[2] = ambient[2];

        for (int k = 0; k < 2; k++){
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









