import java.awt.*;
import java.util.Arrays;

public class Trapezoid{

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

    //THESE VERTICES SHOULD ALREADY BE TRANSFORMED ACCORDING TO THE VIEWPORT TRANSFORM
    //here we are passing an array of vertices for each face (
    //CHANGE THIS TO CREATE TRAPEZOID FROM ONE TRIANGLE
    public double[][][] createTrapezoid(int[][] vertices,double[][] tempPhong){
    	/*for(int i = 0; i<4;i++)
            System.out.println(Arrays.toString(vertices[i]) +" " + i);*/
    	
    	int[][] tempVertices = new int[4][3];
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
    	java.util.Arrays.sort(tempVertices, new java.util.Comparator<int[]>() {
    	    public int compare(int[] a, int[] b) {
    	        return b[1] - a[1];
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
    	phong[0] = tempPhong[tempVertices[0][2]];
    	phong[1] = tempPhong[tempVertices[1][2]];
    	phong[2] = tempPhong[tempVertices[2][2]];
    	phong[3] = tempPhong[tempVertices[3][2]];
    	//for(int i = 0; i <4; i++)  System.out.println(Arrays.toString(vertices[i]));
    	//for(int i = 0; i <4; i++)  System.out.println(Arrays.toString(tempVertices[i]) +" "+i);
    	//for(int i = 0; i <4; i++)  System.out.println(Arrays.toString(phong[i]));*/
        TL1= castToDouble(vertices[0]);
        TR1 = castToDouble(vertices[0]);
        phongTL1 = phong[0];
        phongTR1 = phong[0];
        /*BL2 = castToDouble(vertices[2]);
        BR2 = castToDouble(vertices[2]);*/
        phongBL2 = phong[2];
        phongBR2 = phong[2];
        TL3 = castToDouble(vertices[1]);
        TR3 = castToDouble(vertices[1]);
        phongTL3 = phong[1];
        phongTR3 = phong[1];
        BL4 = castToDouble(vertices[3]);
        BR4 = castToDouble(vertices[3]);
        phongBL4 = phong[3];
        phongBR4 = phong[3];
        /*for(int i = 0; i<4;i++)
        System.out.println(Arrays.toString(vertices[i]) +" " + i);*/

      // if(vertices[0][1]!=vertices[3][1] && vertices[1][1]!=vertices[3][1]){
    	   //CONSTRUCT A NORMAL TRAPEZOID
       if((vertices[0][1]!=vertices[3][1])){
        if(vertices[0][0] >= vertices[1][0]){
            //BL1 = vertices[1];
            //if(vertices[0][1]!=vertices[3][1]){
        	BL2 = castToDouble(vertices[3]);
            BR2 = castToDouble(vertices[3]);
            BL1 = castToDouble(vertices[1]);
            BR1[0] = (((double) vertices[1][1] - (double) vertices[3][1])/((double) vertices[0][1] - (double) vertices[3][1]))*((double) vertices[0][0] - (double) vertices[3][0]) + (double) vertices[3][0];
            BR1[1] = (double) vertices[1][1];
            
            
            /*LinearInterpolator LIred = new LinearInterpolator(vertices[0][1],vertices[2][1],phong[0][0],phong[2][0]);
            LinearInterpolator LIgreen = new LinearInterpolator(vertices[0][1],vertices[2][1],phong[0][1],phong[2][1]);
            LinearInterpolator LIblue = new LinearInterpolator(vertices[0][1],vertices[2][1],phong[0][2],phong[2][2]);
            *//*double r = LIred.interp(BR1[1]);
            double g = LIgreen.interp(BR1[1]);
            double b = LIblue.interp(BR1[1]);*/
            //if(BR4[1] !=TR1[1]){
            double ty1 = (BR1[1]-TR1[1])/(BR4[1]-TR1[1]); 
            double BR1red = phongTR1[0] + (phongBR4[0]-phongTR1[0])*(ty1);
            double BR1green =phongTR1[1] + (phongBR4[1]-phongTR1[1])*(ty1);
            double BR1blue = phongTR1[2] + (phongBR4[2]-phongTR1[2])*(ty1);
            phongBL1 = phong[1];
            phongBR1[0] = BR1red;
            phongBR1[1] = BR1green;
            phongBR1[2] = BR1blue;
            phongBR1[3] = phongBL1[3];
            BL3[0] = (((double) vertices[2][1] - (double) vertices[3][1])/((double) vertices[0][1] - (double) vertices[3][1]))*((double) vertices[0][0] - (double) vertices[3][0]) + (double) vertices[3][0];
            BL3[1] = (double) vertices[2][1];
            /*LinearInterpolator LIred = new LinearInterpolator(vertices[1][1],vertices[3][1],phong[0][0],phong[0][2]);
            LinearInterpolator LIgreen = new LinearInterpolator(vertices[1][1],vertices[3][1],phong[1][0],phong[1][2]);
            LinearInterpolator LIblue = new LinearInterpolator(vertices[1][1],vertices[3][1],phong[2][0],phong[2][2]);
            double r = LIred.interp(BR1[1]);
            double g = LIgreen.interp(BR1[1]);
            double b = LIblue.interp(BR1[1]);*/
            if(BL4[1] != TL3[1])
            ty1 = (BL3[1]- TL3[1])/(BL4[1]-TL3[1]);
            double BL3red = phongTL3[0] + (phongBL4[0]-phongTL3[0])*(ty1);
            double BL3green =phongTL3[1] + (phongBL4[1]-phongTR1[1])*(ty1);
            double BL3blue = phongTL3[2] + (phongBL4[2]-phongTR1[2])*(ty1);
            phongBR3 = phong[2];
           // phongBR1 = phong[1];
            phongBL3[0] = BL3red;
            phongBL3[1] = BL3green;
            phongBL3[2] = BL3blue;
            phongBL3[3] = phongBR3[3];
            BR3 = castToDouble(vertices[2]);

        }
        else{
        	BL2 = castToDouble(vertices[2]);
            BR2 = castToDouble(vertices[2]);
            BL1[0] = (((double) vertices[1][1] - (double) vertices[3][1])/((double) vertices[0][1] - (double) vertices[3][1]))*((double) vertices[0][0] - (double) vertices[3][0]) + (double) vertices[3][0];
            BL1[1] = (double) vertices[1][1];
            BR1 = castToDouble(vertices[1]);
            phongBR1 = phong[1];
            /*LinearInterpolator LIred = new LinearInterpolator(vertices[0][1],vertices[2][1],phong[0][0],phong[0][2]);
            LinearInterpolator LIgreen = new LinearInterpolator(vertices[0][1],vertices[2][1],phong[1][0],phong[1][2]);
            LinearInterpolator LIblue = new LinearInterpolator(vertices[0][1],vertices[2][1],phong[2][0],phong[2][2]);
            double r = LIred.interp(BL1[1]);
            double g = LIgreen.interp(BL1[1]);
            double b = LIblue.interp(BL1[1]);*/
            double ty1 = (BL1[1]-TL1[1])/(BL4[1]-TL1[1]); 
            double BL1red = phongTL1[0] + (phongBL4[0]-phongTL1[0])*(ty1);
            double BL1green =phongTL1[1] + (phongBL4[1]-phongTL1[1])*(ty1);
            double BL1blue = phongTL1[2] + (phongBL4[2]-phongTL1[2])*(ty1);
            phongBR1 = phong[1];
            phongBL1[0] = BL1red;
            phongBL1[1] = BL1green;
            phongBL1[2] = BL1blue;
            phongBL1[3] = phongBR1[3];
            BR3[0] = (((double) vertices[2][1] - (double) vertices[3][1])/((double) vertices[0][1] - (double) vertices[3][1]))*((double) vertices[0][0] - (double) vertices[3][0]) + (double) vertices[3][0];
            BR3[1] = (double) vertices[2][1];
            BL3 = castToDouble(vertices[2]);
            /*LinearInterpolator LIred = new LinearInterpolator(vertices[1][1],vertices[3][1],phong[0][0],phong[0][2]);
            LinearInterpolator LIgreen = new LinearInterpolator(vertices[1][1],vertices[3][1],phong[1][0],phong[1][2]);
            LinearInterpolator LIblue = new LinearInterpolator(vertices[1][1],vertices[3][1],phong[2][0],phong[2][2]);
            double r = LIred.interp(BR3[1]);
            double g = LIgreen.interp(BR3[1]);
            double b = LIblue.interp(BR3[1])*/
            ty1 = (BL3[1]-TR3[1])/(BR4[1]-TL1[1]); 
            double BR3red = phongTR1[0] + (phongBR4[0]-phongTR4[0])*(ty1);
            double BR3green =phongTR1[1] + (phongBR4[1]-phongTR4[1])*(ty1);
            double BR3blue = phongTR1[2] + (phongBR4[2]-phongTR4[2])*(ty1);
            phongBR3[0] = BR3red;
            phongBR3[1] = BR3green;
            phongBR3[2] = BR3blue;
            phongBR3[3] = phongBL3[3];
            phongBL3 = phong[2];


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

        TL2= BL1;
        TR2 = BR1;
        phongTL2 = phongBL1;
        phongTR2 = phongBR1;

        /*BL2 = vertices[2];
        BR2 = vertices[2];
        phongBL2 = phong[2];
        phongBR2 = phong[2];*/

     /*   TL3 = vertices[1];
        TR3 = vertices[1];
        phongTL3 = phong[1];
        phongTR3 = phong[1];*/

        TR4 = BR3;
        TL4 = BL3;
        phongTL4 = phongBL3;
        phongTR4 = phongBR3;

       /* BL4 = vertices[3];
        BR4 = vertices[3];
        phongBL4 = phong[3];
        phongBR4 = phong[3];*/
        //trap face contains 8 numbers for each of the 4 trapezoids that comprise a face of the object
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
        
       /* for(int i=0;i<4;i++)
        	for(int j=0;j<8;j++) System.out.println(Arrays.toString(trapFace[i][j])); */
        
     //  }
       //else{
    	   //TR1=TL1 = vertices[0] = TR2 = TL2
    	   
       //}
        
        return trapFace;



    }
}









