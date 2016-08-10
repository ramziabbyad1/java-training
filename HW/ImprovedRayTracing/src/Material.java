
public class Material {
	double [] A = new double [3];
	double [] D = new double [3];
	double [] S = new double [3];
	double p;
	double [] mc = new double [3];
	
	public Material(double Ar, double Ag, double Ab, double Dr, double Dg, double Db,
					double Sr, double Sg, double Sb, double p, double mcr, double mcg, double mcb){
		A[0] = Ar; A[1] = Ag; A[2] = Ab;
		D[0] = Dr; D[1] = Dg; D[2] = Db;
		S[0] = Sr; S[1] = Sg; S[2] = Sb;
		this.p = p;
		mc[0] = mcr; mc[1] = mcg; mc[2] = mcb;
	}
}
