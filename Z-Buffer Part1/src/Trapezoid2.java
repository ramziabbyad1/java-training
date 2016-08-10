import java.awt.*;
import java.util.Arrays;

public class Trapezoid2{



    int[][] tempArray = new int[4][2];
    int[][] vertex = new int[4][2];

    public int[][] transpose(int[][] v){

    	int[][] temp = new int[v.length][v[0].length];
    	for(int i = 0; i < v.length;i++) 
    		for(int j=0; j < v[0].length;j++) temp[i][j] = v[j][i];

    	return temp;
    }
    
    public void customSort(int[][] vertices,double[][] phong){
        tempArray = vertices;
        int[][] verticesT;
        double[][] tempPhong = phong;
        verticesT = transpose(vertices);
        Arrays.sort(verticesT[1]);

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


    public void makeTriangles(int[][] v,double[][] phong){
    	if(v[1][1] == v[0][1]){	
    		if(v[1][0] <= v[0][0]){
    			int[] temp = (int[]) v[1].clone();
    			v[1] = (int[]) v[0].clone();
    			v[0] = (int[]) temp.clone();
    			
    		}
    	}

    	double[][] tempPhong = new double[4][4];
    	for(int i = 0; i < 4; i++)
    	tempPhong[i] = (double[]) phong[i].clone();
    	if((v[2][0] <= v[3][0] && v[1][0]<=v[0][0]) ||(v[1][0]>=v[0][0] && v[2][0] >= v[3][0])) {
    	a1 = castToDouble(v[0]);
    	b1 = castToDouble(v[1]);
    	c1 = castToDouble(v[2]);
    	
    	a2 = castToDouble(v[0]);
    	b2 = castToDouble(v[2]);
    	c2 = castToDouble(v[3]);
    	
    	phonga1 = (double[])phong[0].clone();
    	phongb1 = (double[])phong[1].clone();
    	phongc1 = (double[])phong[2].clone();
    	
    	phonga2 = (double[])phong[0].clone();
    	phongb2 = (double[])phong[2].clone();
    	phongc2 = (double[])phong[3].clone();
    	
    	}
    	else if((v[2][0] >= v[3][0] && v[1][0]<=v[0][0])){
    		a1 = castToDouble(v[0]);
        	b1 = castToDouble(v[1]);
        	c1 = castToDouble(v[3]);
        	
        	a2 = castToDouble(v[0]);
        	b2 = castToDouble(v[2]);
        	c2 = castToDouble(v[3]);
    		
        	phonga1 =(double[]) phong[0].clone();
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
        	
        	phonga2 =(double[]) phong[1].clone();
        	phongb2 = (double[])phong[2].clone();
        	phongc2 = (double[])phong[3].clone();
    	}
    	
	}
    double[][][] trapFace = new double[4][8][];

    public double[][][] createTrapezoid(int[][] vertices,double[][] tempPhong, Material M){
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
    	//SORT THE ARRAY OF VERTICES BY INCREASING Y-VALUE
    	java.util.Arrays.sort(tempVertices, new java.util.Comparator<int[]>() {
    	    public int compare(int[] a, int[] b) {
    	        return b[1] - a[1];
    	    }
    	});
    	
    	
    			
    	vertices[0][0]=tempVertices[0][0];
    	vertices[0][1]=tempVertices[0][1];
    	vertices[1][0]=tempVertices[1][0];
    	vertices[1][1]=tempVertices[1][1];
    	vertices[2][0]=tempVertices[2][0];
    	vertices[2][1]=tempVertices[2][1];
    	vertices[3][0]=tempVertices[3][0];
    	vertices[3][1]=tempVertices[3][1];
    	phong[0] =(double[]) tempPhong[tempVertices[0][2]].clone();
    	phong[1] = (double[]) tempPhong[tempVertices[1][2]].clone();
    	phong[2] = (double[]) tempPhong[tempVertices[2][2]].clone();
    	phong[3] = (double[]) tempPhong[tempVertices[3][2]].clone();
    	makeTriangles(vertices,phong); //these vertices will already be sorted

    	TL1 = a1;
    	TR1 = a1;
    	phongTL1 = phongTR1 =  phonga1;
    	BR2 = BL2 =  c1;
    	phongBR2 = phongBL2 =  phongc1;
    	
    	TL3 = TR3 =a2;
    	phongTL3 = phongTR3 = phonga2;
    	BR4 = BL4 = c2;
    	phongBR4 = phongBL4 = phongc2;
    	
    	double[] A1 = inverseViewport(a1[0],a1[1],phonga1[3]);
    	double[] B1 = inverseViewport(b1[0],b1[1],phongb1[3]);
    	double[] C1 = inverseViewport(c1[0],c1[1],phongc1[3]);
    	
    	double[] A2 = inverseViewport(a2[0],a2[1],phonga2[3]);
    	double[] B2 = inverseViewport(b2[0],b2[1],phongb2[3]);
    	double[] C2 = inverseViewport(c2[0],c2[1],phongc2[3]);
    	

       if((a1[1]!=c1[1])){
    	   if(((a1[1]>b1[1]) && (c1[1] < a1[1] + ((a1[1]-b1[1])/(a1[0]-b1[0]))*(c1[0]-a1[0])) &&(a1[0]>b1[0])) || (a1[1]>b1[1]) && (c1[1] > a1[1] + ((a1[1]-b1[1])/(a1[0]-b1[0]))*(c1[0]-a1[0])) &&(a1[0]<b1[0])||((a1[1]==b1[1])&&(a1[0] > b1[0]))||((a1[0]==b1[0])&& (c1[0]>b1[0]))){
    		   BR1[0] = /*(int)*/((b1[1] - c1[1])/( a1[1] - c1[1]))*(a1[0] - c1[0]) + c1[0];
               BR1[1] = b1[1];
               BL1 = b1;
               phongBL1 = phongb1;
               if(phongb1[1] != phongc1[1]) phongBR1[3] =((phonga1[3]-phongc1[3])/(A1[1]-C1[1]))*(B1[1] - C1[1]) + phongc1[3];
               else phongBR1[3] = phongb1[3];
               double[] surfacePoint = inverseViewport(BR1[0],BR1[1],phongBR1[3]);
/*               System.out.println("Surface Point: "+ Arrays.toString(surfacePoint));
*/               double[] tempNormal = times(surfacePoint,2);
               double[] v = {0,0,10};
               double[] w = new double[3];
               w = minus(v,surfacePoint);
               double[] reflection = computeReflection(w,surfacePoint,normalize(tempNormal));
               double[] p = computePhongShading(M.ambient,M.diffuse,M.spectral,M.specPow, light, reflection,normalize(tempNormal));
               phongBR1[0] = p[0];
               phongBR1[1] = p[1];
               phongBR1[2] = p[2];
               TR2 = BR1;
               TL2 = BL1;
               
    	   }
    	   else if(((a1[1]>b1[1]) && (c1[1] > a1[1] + ((a1[1]-b1[1])/(a1[0]-b1[0]))*(c1[0]-a1[0])) &&(a1[0]>b1[0])) || ((a1[1]>b1[1]) && (c1[1] < a1[1] + ((a1[1]-b1[1])/(a1[0]-b1[0]))*(c1[0]-a1[0])) &&(a1[0]<b1[0]))||((a1[1]==b1[1])&&(a1[0] < b1[0]))||((a1[0]==b1[0])&& (c1[0]<b1[0]))){
    		   BL1[0] = ((b1[1] - c1[1])/(a1[1] - c1[1]))*(a1[0] - c1[0]) + c1[0];
               BL1[1] = b1[1];
               BR1 = b1;
               phongBR1 = phongb1;

               if(phongb1[1] != phongc1[1])	phongBL1[3] = ((phonga1[3]-phongc1[3])/(A1[1]-C1[1]))*(B1[1] - C1[1]) + phongc1[3];
               else phongBL1[3] = phongb1[3];
               double[] surfacePoint = inverseViewport(BL1[0],BL1[1],phongBL1[3]);
               System.out.println("Surface Point: "+ Arrays.toString(surfacePoint));

               double[] tempNormal = times(surfacePoint,2);
               double[] v = {0,0,10};
               double[] w = new double[3];
               w = minus(v,surfacePoint);
               double[] reflection = computeReflection(w,surfacePoint,normalize(tempNormal));
               double[] p = computePhongShading(M.ambient,M.diffuse,M.spectral,M.specPow, light, reflection,normalize(tempNormal));
               phongBL1[0] = p[0];
               phongBL1[1] = p[1];
               phongBL1[2] = p[2];
               TR2 = BR1;
               TL2 = BL1;
    	   }

       }
       
    	  if((a2[1]!=c2[1])){
    	   if(((a2[1]>b2[1]) && (c2[1] < a2[1] + ((a2[1]-b2[1])/(a2[0]-b2[0]))*(c2[0]-a2[0])) &&(a2[0]>b2[0])) || (a2[1]>b2[1]) && (c2[1] > a2[1] + ((a2[1]-b2[1])/(a2[0]-b2[0]))*(c2[0]-a2[0])) &&(a2[0]<b2[0])||((a2[1]==b2[1])&&(a2[0] > b2[0]))||((a2[0]==b2[0])&& (c2[0]>b2[0]))){
    		   BR3[0] = ((b2[1] - c2[1])/( a2[1] - c2[1]))*(a2[0] - c2[0]) + c2[0];
               BR3[1] = b2[1];
               BL3 = (double[]) b2.clone();
               phongBL3 = (double[]) phongb2.clone();
               phongBR3[3] = ((phonga2[3]-phongc2[3])/(A2[1]-C2[1]))*(B2[1] - C2[1]) + phongc2[3];
               double[] surfacePoint = inverseViewport(BR3[0],BR3[1],phongBR3[3]);
               double[] tempNormal = times(surfacePoint,2);
               double[] v = {0,0,10};
               double[] w = new double[3];
               w = minus(v,surfacePoint);
               double[] reflection = computeReflection(w,surfacePoint,normalize(tempNormal));
               double[] p = computePhongShading(M.ambient,M.diffuse,M.spectral,M.specPow, light, reflection,normalize(tempNormal));
               phongBR3[0] = p[0];
               phongBR3[1] = p[1];
               phongBR3[2] = p[2];
               TR4 = (double[]) BR3.clone();
               TL4 = (double[]) BL3.clone();
               
    	   }
    	   else if(((a2[1]>b2[1]) && (c2[1] > a2[1] + ((a2[1]-b2[1])/(a2[0]-b2[0]))*(c2[0]-a2[0])) &&(a2[0]>b2[0])) || ((a2[1]>b2[1]) && (c2[1] < a2[1] + ((a2[1]-b2[1])/(a2[0]-b2[0]))*(c2[0]-a2[0])) &&(a2[0]<b2[0]))||((a2[1]==b2[1])&&(a2[0] < b2[0]))||((a2[0]==b2[0])&& (c2[0]<b2[0]))){
    		   BL3[0] =((b2[1] - c2[1])/(a2[1] - c2[1]))*(a2[0] - c2[0]) + c2[0];
               BL3[1] = b2[1];
               BR3 = (double[]) b2.clone();
               phongBR3 = (double[]) phongb2.clone();
               phongBL3[3] = ((phonga2[3]-phongc2[3])/(A2[1]-C2[1]))*(B2[1] - C2[1]) + phongc2[3];
               double[] surfacePoint = inverseViewport(BL3[0],BL3[1],phongBL3[3]);
               double[] tempNormal = times(surfacePoint,2);
               double[] v = {0,0,10};
               double[] w = new double[3];
               w = minus(v,surfacePoint);
               double[] reflection = computeReflection(w,surfacePoint,normalize(tempNormal));
               double[] p = computePhongShading(M.ambient,M.diffuse,M.spectral,M.specPow, light, reflection,normalize(tempNormal));
               phongBL3[0] = p[0];
               phongBL3[1] = p[1]; 
              phongBL3[2] = p[2];
               TR4 = (double[]) BR3.clone();
               TL4 = (double[]) BL3.clone();
    	   }
    	 }
       
   
        phongTL2 = phongBL1;
        phongTR2 = phongBR1;


        phongTL4 = phongBL3;
        phongTR4 = phongBR3;


        trapFace[0][0] = (TR1);//(x,y) values
        trapFace[0][1] = (TL1);
        trapFace[0][2] = (BL1);
        trapFace[0][3] = (BR1);
        trapFace[0][4] = phongTR1;//(r,g,b,z) values
        trapFace[0][5] = phongTL1;
        trapFace[0][6] = phongBL1;
        trapFace[0][7] = phongBR1;

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
        
        return trapFace;



    }
    //COMPUTE THE INVERSE OF THE PERSPECTIVE AND VIEWPORT TRANSFORMATIONS
    double[] inversePoints = new double[3];
    public double[] inverseViewport(double px,double py, double z){
    	inversePoints[0] = (px -320)/160;
    	inversePoints[1] = (240 - py)/160;
    	inversePoints[0] = ((10-z)/10)*inversePoints[0];
    	inversePoints[1] = ((10-z)/10)*inversePoints[1];
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
    
   double[][] light = {{0,10,0,.5,.5,.5},{0,-10,0,.5,.5,.5}};/*,{1,0,0,1,1,1},{-1,0,0,1,1,1},{1,1,0,1,1,1}};*/
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
        
        return phong;

    }
}









