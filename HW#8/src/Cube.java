public class Cube {
	Plane p[] = new Plane[6];
	
	public Cube(){
		p[0] = new Plane(-1, 0, 0, -1);
		p[1] = new Plane(1, 0, 0, -1);
		p[2] = new Plane(0, -1, 0, -1);
		p[3] = new Plane(0, 1, 0, -1);
		p[4] = new Plane(0, 0, -1, -1);
		p[5] = new Plane(0, 0, 1, -1);
	}
	
	public Cube(Cube c){
		for (int i = 0; i < 6; i++){
			p[i] = c.p[i];
		}
	}
	
	public void copy(Cube src){
		for (int i = 0; i < 6; i++){
			p[i].copy(src.p[i]);
		}
	}
	

	public boolean inCube(double [] v, double [] w, double t, int id){
		double x, y, z;
		x = v[0] + w[0]*t;
		y = v[1] + w[1]*t;
		z = v[2] + w[2]*t;
		for (int i = 0; i < 6; i++){
			if (i == id) continue;
			if (0 < p[i].a*x + p[i].b*y + p[i].c*z + p[i].d ){
				return false;
			}
		}
		return true;
	}
	
	public void translate(double a, double b, double c){
    	for (int i = 0; i < 6; i++){
    		p[i].translate(a, b, c);
    	}
    }
    
    public void rotateX(double theta){
    	for (int i = 0; i < 6; i++){
    		p[i].rotateX(theta);
    	}
    }
    
    public void rotateY(double theta){
    	for (int i = 0; i < 6; i++){
    		p[i].rotateY(theta);
    	}
    }
    
    public void rotateZ(double theta){
    	for (int i = 0; i < 6; i++){
    		p[i].rotateZ(theta);
    	}
    }
    
    public void scale(double a, double b, double c){
    	for (int i = 0; i < 6; i++){
    		p[i].scale(a, b, c);
    	}
    }
}
