
public class Light {
	double [] L = new double [3];
	double [] I = new double [3];
	
	public Light(double x, double y, double z, double r, double g, double b){
		L[0] = x; L[1] = y; L[2] = z;
		I[0] = r; I[1] = g; I[2] = b;
	}
}
