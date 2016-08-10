//Matrix for second order surface
public class SecondOrderSurface{

		double data[][] = new double[4][4];
		double temp[][] = new double[4][4];
		double temp2[][] = new double[4][4];
		double a, b, c, d, e, f, g, h, i, j;
		
		public void set(int i, int j, double value){data[i][j] = value;}
		public double get(int i, int j){return data[i][j];}
		public double[][] getData(){return data;}
		
		public void setCoefficients(){
			a = data[0][0]; b = data[1][1]; c = data[2][2]; d = data[1][2]; e = data[0][2]; f = data[0][1]; g = data[0][3]; h = data[1][3]; i = data[2][3]; j = data[3][3];
		}
		
		public SecondOrderSurface getMatrix(){
			return this;
		}
		
		//duplicate data from matrix m into this
		public void copy(SecondOrderSurface s){
			for (int i = 0; i < 4; i++){
				for (int j = 0; j < 4; j++){
					data[i][j] = s.get(i, j);
				}
			}
			setCoefficients();
		}
		
		public SecondOrderSurface(double a, double b, double c, double d, double e, double f, double g, double h, double i, double j){
			data[0][0] = a; data[0][1] = f; data[0][2] = e; data[0][3] = g;
			data[1][0] = 0;	data[1][1] = b;	data[1][2] = d;	data[1][3] = h;
			data[2][0] = 0;	data[2][1] = 0;	data[2][2] = c;	data[2][3] = i;
			data[3][0] = 0;	data[3][1] = 0;	data[3][2] = 0;	data[3][3] = j;
			
			setCoefficients();
		}
		
		public SecondOrderSurface(SecondOrderSurface s){
			for (int i = 0; i < 4; i++){
				for (int j = 0; j < 4; j++){
					data[i][j] = s.get(i, j);
				}
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
	    	double inverseMatrix[][] = new double[4][4];
	    	double inverseMatrixTranspose[][] = new double[4][4];
	    	
	    	MatrixInverter.invert(src, inverseMatrix);
	    	MatrixInverter.transpose(inverseMatrix, inverseMatrixTranspose);
	    	
	    	for(int row = 0; row < 4; row++){
	    		for(int col = 0; col < 4; col++){
	    			temp2[row][col] = data[row][col];
	    		}
	    	}
	    	for(int row = 0; row < 4; row++){
	    		for(int col = 0; col < 4; col++){
	    			data[row][col] = 0;
	    			for(int i = 0; i < 4; i++){
	    				data[row][col] += inverseMatrixTranspose[row][i] * temp2[i][col];
	    			}
	    		}
	    	}
	    	for(int row = 0; row < 4; row++){
	    		for(int col = 0; col < 4; col++){
	    			temp2[row][col] = data[row][col];
	    		}
	    	}
	    	for(int row = 0; row < 4; row++){
	    		for(int col = 0; col < 4; col++){
	    			data[row][col] = 0;
	    			for(int k = 0; k < 4; k++){
	    				data[row][col] += temp2[row][k] * inverseMatrix[k][col];
	    			}
	    		}
	    	}
	    	
	    	data[0][1] += data[1][0]; data[1][0] = 0;
	    	data[0][2] += data[2][0]; data[2][0] = 0;
	    	data[0][3] += data[3][0]; data[3][0] = 0;
	    	data[1][2] += data[2][1]; data[2][1] = 0;
	    	data[1][3] += data[3][1]; data[3][1] = 0;
	    	data[2][3] += data[3][2]; data[3][2] = 0;
	    	
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
