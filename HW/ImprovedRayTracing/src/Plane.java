//MATRIX FOR A PLANE AS DESCRIBED IN CLASS
public class Plane {

		double data[] = new double[4];
		double temp[][] = new double[4][4];
		double temp2[] = new double[4];
		double a, b, c, d;
		
		public void set(int i, double value){data[i] = value;}
		public double get(int i){return data[i];}
		public double[] getData(){return data;}
		
		public Plane getMatrix(){
			return this;
		}
		
		public void copy(Plane p){
			for (int i = 0; i < 4; i++){
				data[i] = p.get(i);
			}
			setCoefficients();
		}
		
		public void setCoefficients(){
			a = data[0];
			b = data[1];
			c = data[2];
			d = data[3];
		}
		
		public Plane(double a, double b, double c, double d){
			data[0] = a;
			data[1] = b;
			data[2] = c;
			data[3] = d;
			
			setCoefficients();
		}
		
		public Plane(Plane p){
			for (int i = 0; i < 4; i++){
				data[i] = p.get(i);
			}
		}
		
	    public void createIdentityData(double dst[][]){
	    	for (int row = 0; row < 4; row++){
	    		for (int col = 0; col < 4; col++){
	    			if(row == col){
	    				dst[row][col] = 1;
	    			}
	    			else{
	    				dst[row][col] = 0;
	    			}
	    		}
	    	}
	    }
	    
	    public void createTranslationData(double x, double y, double z, double dst[][]){
	    	createIdentityData(dst);
	    	dst[0][3] = x;
	    	dst[1][3] = y;
	    	dst[2][3] = z;
	    }
	    
	    public void createXRotationData(double theta, double dst[][]){
	    	createIdentityData(dst);
	    	dst[1][1] = Math.cos(theta);
	    	dst[1][2] = Math.sin(theta) * (-1);
	    	dst[2][1] = Math.sin(theta);
	    	dst[2][2] = Math.cos(theta);
	    }
	    
	    public void createYRotationData(double theta, double dst[][]){
	    	createIdentityData(dst);
	    	dst[0][0] = Math.cos(theta);
	    	dst[0][2] = Math.sin(theta);
	    	dst[2][0] = Math.sin(theta) * (-1);
	    	dst[2][2] = Math.cos(theta);
	    }
	    
	    public void createZRotationData(double theta, double dst[][]){
	    	createIdentityData(dst);
	    	dst[0][0] = Math.cos(theta);
	    	dst[0][1] = Math.sin(theta) * (-1);
	    	dst[1][0] = Math.sin(theta);
	    	dst[1][1] = Math.cos(theta);
	    }
	    
	    public void createScaleData(double x, double y, double z, double dst[][]){
	    	createIdentityData(dst);
	    	dst[0][0] = x;
	    	dst[1][1] = y;
	    	dst[2][2] = z;
	    }

	    public void multiply(double src[][]) {
	    	double matrixInverse[][] = new double[4][4];
	    	MatrixInverter.invert(src, matrixInverse);
	    	for(int i = 0; i < 4; i++){
	    		temp2[i] = data[i];
	    	}
	    	for(int j = 0; j < 4; j++){
	    		data[j] = 0;
	    		for(int i = 0; i < 4; i++){
	    			data[j] += temp2[i] * matrixInverse[i][j];
	    		}
	    	}
	    	setCoefficients();
	    }
	    
	    public void translate(double a, double b, double c){
	    	createTranslationData(a, b, c, temp);
	    	multiply(temp);
	    }
	    
	    public void rotateX(double theta){
	    	createXRotationData(theta, temp);
	    	multiply(temp);
	    }
	    
	    public void rotateY(double theta){
	    	createYRotationData(theta, temp);
	    	multiply(temp);
	    }
	    
	    public void rotateZ(double theta){
	    	createZRotationData(theta, temp);
	    	multiply(temp);
	    }
	    
	    public void scale(double a, double b, double c){
	    	createScaleData(a, b, c, temp);
	    	multiply(temp);
	    }
}
