
public class Material {
	double [] ambient = new double [3];
	double [] diffuse = new double [3];
	double [] spectral = new double [3];
	double p;
	double [] mirrorColor = new double [3];
	
	public Material(double ambientR, double ambientG, double ambientB, double diffuseR, double diffuseG, double diffuseB,
					double spectralR, double spectralG, double spectralB, double p, double mcR, double mcG, double mcB){
		ambient[0] = ambientR; ambient[1] = ambientG; ambient[2] = ambientB;
		diffuse[0] = diffuseR; diffuse[1] = diffuseG; diffuse[2] = diffuseB;
		spectral[0] = spectralR; spectral[1] = spectralG; spectral[2] = spectralB;
		this.p = p;
		mirrorColor[0] = mcR; mirrorColor[1] = mcG; mirrorColor[2] = mcB;
	}
}

