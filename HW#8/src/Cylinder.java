
public class Cylinder {
	Plane p [] = new Plane[2];
	SecondOrderSurface s;
	
	public Cylinder(Cylinder cy){
		p[0] = cy.p[0];
		p[1] = cy.p[1];
		s = cy.s;
	}
	//CONSTRUCT UNIT CYLINDER
	public Cylinder(){
		
		p[0] = new Plane(0, 0, 1, -1);
		p[1] = new Plane(0, 0, -1, -1);
		s = new SecondOrderSurface(1, 1, 0, 0, 0, 0, 0, 0, 0, -1);
	}
	
	public void copy(Cylinder src){
		p[0].copy(src.p[0]);
		p[1].copy(src.p[1]);
		s.copy(src.s);
	}
	
	//RETURN TRUE OF THE VECTOR IS IN THE SURFACEID'S CORRESPONDING TO CYLINDER
	public boolean inCylinder(double [] v, double [] w, double t, int id){
		double x, y, z;
		x = v[0] + w[0]*t;
		y = v[1] + w[1]*t;
		z = v[2] + w[2]*t;
		
		if (id == 8){
			for (int i = 0; i < 2; i++){
				if (p[i].a*x + p[i].b*y + p[i].c*z + p[i].d > 0){
					return false;
				}
			}
		}
		else if(id == 7){
			if (p[0].a*x + p[0].b*y + p[0].c*z + p[0].d > 0){
				return false;
			}
			if (s.a*x*x + s.b*y*y + s.c*z*z + s.d*y*z + s.e*z*x + s.f*x*y + s.g*x + s.h*y + s.i*z + s.j > 0){
				return false;
			}
		}
		else{
			if (p[1].a*x + p[1].b*y + p[1].c*z + p[1].d > 0){
				return false;
			}
			if (s.a*x*x + s.b*y*y + s.c*z*z + s.d*y*z + s.e*z*x + s.f*x*y + s.g*x + s.h*y + s.i*z + s.j > 0){
				return false;
			}
		}
		
		return true;
	}
	
    public void translate(double a, double b, double c){
    	for (int i = 0; i < 2; i++){
    		p[i].translate(a, b, c);
    	}
    	s.translate(a, b, c);
    }
    
    public void scale(double a, double b, double c){
    	for (int i = 0; i < 2; i++){
    		p[i].scale(a, b, c);
    	}
    	s.scale(a, b, c);
    }
    
    public void rotateX(double theta){
    	for (int i = 0; i < 2; i++){
    		p[i].rotateX(theta);
    	}
    	s.rotateX(theta);
    }
    
    public void rotateY(double theta){
    	for (int i = 0; i < 2; i++){
    		p[i].rotateY(theta);
    	}
    	s.rotateY(theta);
    }
    
    public void rotateZ(double theta){
    	for (int i = 0; i < 2; i++){
    		p[i].rotateZ(theta);
    	}
    	s.rotateZ(theta);
    }
	
}
