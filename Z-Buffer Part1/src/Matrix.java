import java.awt.*;
import java.util.Arrays;

public class Matrix {
    double data[][] = new double[4][4];
    double[][] cubeCoeff = {{-1,0,0,-1},{0,-1,0,-1},{0,0,-1,-1},{1,0,0,-1},{0,1,0,-1},{0,0,1,-1}};
    double[][] data1 = new double[6][4];

        Matrix() {
        for(int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if(row == col) {
                    data[row][col] = 1;
                }
                else {
                    data[row][col] = 0;
                }
            }
        }
    }

    Matrix(double i,double j){
        for(int row = 0; row < i; row++) {
            for (int col = 0; col < j; col++) {
                if(row == col) {
                    data1[row][col] = 0;
                }
                else {
                    data1[row][col] = 0;
                }
            }
        }
    }

    public void set(int i, int j, double value) { data[i][j] = value; } // SET ONE VALUE

    public void setCube(int i, int j, double value) { cubeCoeff[i][j] = value; } // SET ONE VALUE

    public double get(int i, int j) { return data[i][j]; }              // GET ONE VALUE

    public void copy(Matrix src) {
        for (int row = 0 ; row < 4 ; row++){
            for (int col = 0 ; col < 4 ; col++){
                data[row][col] = src.get(row,col);
                }
            }
        }

    public double[][] getData(){
        return data;
      }

    public void multiply(Matrix src){
    	 multiply(src.getData());
    	}




    public void identity() {
        for(int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if(row == col) {
                data[row][col] = 1;
             }
                else {
                    data[row][col] = 0;
                }
            }
        }
    }
    //Create Identity
    public void createIdentityData(double dst[][]) {
        for(int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if(row == col) {
                    dst[row][col] = 1;
                }
                else {
                    dst[row][col] = 0;
                }
            }
         }
    }



    public void createTranslationData(double a, double b, double c, double dst[][]) {
        createIdentityData(dst);
        dst[0][3] = a;
        dst[1][3] = b;
        dst[2][3] = c;
    }

    public void createXRotationData(double theta, double dst[][]){
        createIdentityData(dst);
        dst[1][1] = Math.cos(theta);
        dst[2][2] = Math.cos(theta);
        dst[1][2] = -Math.sin(theta);
        dst[2][1] = Math.sin(theta);
    }

    public void createYRotationData(double theta,double dst[][]){
        createIdentityData(dst);
        dst[0][0] = Math.cos(theta);
        dst[0][2] = Math.sin(theta);
        dst[2][0] = -Math.sin(theta);
        dst[2][2] = Math.cos(theta);
    }

    public void createZRotationData(double theta,double dst[][]){
        createIdentityData(dst);
        dst[0][0] = Math.cos(theta);
        dst[0][1] = -Math.sin(theta);
        dst[1][0] = Math.sin(theta);
        dst[1][1] = Math.cos(theta);
    }



    public void createScaleData(double a, double b, double c, double dst[][]){
        dst[0][0] = a;
        dst[1][1] = b;
        dst[2][2] = c;
        dst[3][3] = 1;
    }



    public void multiplyCube(double src[][], double dst[][]){
        for(int i= 0; i <6; i++){
            for(int j = 0; j <4; j++){
                for(int k = 0;k< 4;k++){

                    dst[i][j] += cubeCoeff[i][k]*src[k][j];
                }
            }
        }
    }

    double temp[][] = new double[4][4];

    void multiply(double src[][]) {
        //static double temp[][] = new double[4][4];
        // FIRST COPY MY ORIGINAL DATA TO A TEMPORARY LOCATION

        for (int row = 0 ; row < 4 ; row++){
            for (int col = 0 ; col < 4 ; col++){
            temp[row][col] = data[row][col];
            }
        }

      // USE TEMP TO DO THE MATRIX MULTIPLICATION

        for (int row = 0 ; row < 4 ; row++){
            for (int col = 0 ; col < 4 ; col++) {
                data[row][col] = 0;
                for (int i = 0 ; i < 4 ; i++){
                    data[row][col] += temp[row][i] * src[i][col];
                }
            }
        }
    }

    double temp1[][] = new double[4][4];
    public void translate(double a, double b, double c) {
        createTranslationData(a,b,c,temp1); // CREATE TRANSLATION MATRIX DATA
        multiply(temp1); // MULTIPLY BY THAT MATRIX DATA
    }

    public void rotateX(double theta){
        createXRotationData(theta, temp1);
        multiply(temp1);
    }


    public void rotateY(double theta){
        createYRotationData(theta, temp1);
        multiply(temp1);
    }

    public void rotateZ(double theta){
        createZRotationData(theta, temp1);
        multiply(temp1);
    }

    public void scale(double a, double b, double c){
        createScaleData(a,b,c, temp1);
        multiply(temp1);
    }


    public void printMatrix(Matrix src){
        double[][] temp = new double[4][4];
        temp = src.getData();
        for (int i = 0; i<4; i++){
            System.out.println(Arrays.toString(temp[i]));
        }
    }


    public void transform(double src[], double dst[]) {

        for (int row = 0 ; row < dst.length ; row++) {
            dst[row] = 0;
            for (int i = 0 ; i < src.length ; i++){
                dst[row] += data[row][i] * src[i];

            }
        }
    }

    public void setMatrix(double[][] src){
        for(int i=0; i < 4; i++){
            for(int j = 0; j<4;j++){
                data[i][j] = src[i][j];
            }
        }
    }

    public void setMatrixCube(double[][] src){
        for(int i=0; i < 6; i++){
            for(int j = 0; j<4;j++){
                data1[i][j] = src[i][j];
            }
        }
    }

    public void invert(double src[][], double dst[][]) {

      // COMPUTE ADJOINT COFACTOR MATRIX FOR THE ROTATION/SCALE 3x3 SUBMATRIX

      for (int i = 0 ; i < 3 ; i++)
      for (int j = 0 ; j < 3 ; j++) {
         int iu = (i + 1) % 3, iv = (i + 2) % 3;
         int ju = (j + 1) % 3, jv = (j + 2) % 3;
         dst[j][i] = src[iu][ju] * src[iv][jv] - src[iu][jv] * src[iv][ju];
      }

      // RENORMALIZE BY DETERMINANT TO INVERT ROTATION/SCALE SUBMATRIX

      double det = src[0][0]*dst[0][0] + src[1][0]*dst[0][1] + src[2][0]*dst[0][2];
      for (int i = 0 ; i < 3 ; i++)
      for (int j = 0 ; j < 3 ; j++)
         dst[i][j] /= det;

      // INVERT TRANSLATION

      for (int i = 0 ; i < 3 ; i++)
         dst[i][3] = -dst[i][0]*src[0][3] - dst[i][1]*src[1][3] - dst[i][2]*src[2][3];

      // NO PERSPECTIVE

      for (int i = 0 ; i < 4 ; i++)
         dst[3][i] = i < 3 ? 0 : 1;
   }


    public void createPerspectiveData(double f, double[][] dst) {
        createIdentityData(dst);
        dst[3][2] = -1 / f;
    }

    public void perspective(double f) {
        createPerspectiveData(f, temp1);
        multiply(temp1);
    }

}




