

public class Material{

    double ambient[] = new double[3];
    double diffuse[] = new double[3];
    double spectral[] = new double[3];
    double specPow = 100;
    double mirrorColor[] = new double[3];
    double lightSource[] = new double[6];

    public void setLightSource(double x, double y, double z, double r, double g, double b){

        lightSource[0] = x;
        lightSource[1] = y;
        lightSource[2] = z;
        lightSource[3] = r;
        lightSource[4] = g;
        lightSource[5] = b;

    }

    public void setAmbient(double r, double g, double b){

        ambient[0] = r;
        ambient[1] = g;
        ambient[2] = b;

    }

    public double[] getAmbient(){
        return ambient;
    }

    public void setDiffuse(double r, double g, double b){

        diffuse[0] = r;
        diffuse[1] = g;
        diffuse[2] =b;

    }

    public void setSpectral(double r, double g, double b){

        spectral[0] = r;
        spectral[1] = g;
        spectral[2] =b;



    }

    public void setMirrorColor(double r, double g, double b){

        mirrorColor[0] = r;
        mirrorColor[1] = g;
        mirrorColor[2]=b;



    }

}




