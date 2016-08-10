
public class Hit {
	double t;
	int surfaceId;
	int sign;//1=into the surface; -1=out of the surface
	double a, b, c, d, e, f, g, h, i, j;
	
	public Hit(double t, int id, int sign){
		this.t = t;
		surfaceId = id;
		this.sign = sign;
	}
	
	public void setCoefficients(Plane p){
		this.a = p.a; this.b = p.b; this.c = p.c; this.d = p.d; this.e = 0; this.f = 0; this.g = 0; this.h = 0; this.i = 0; this.j = 0;
	}
	public void setCoefficients(Surface s){
		this.a = s.a; this.b = s.b; this.c = s.c; this.d = s.d; this.e = s.e; this.f = s.f; this.g = s.g; this.h = s.h; this.i = s.i; this.j = s.j;
	}
	public void setCoefficients(Hit h){
		this.a = h.a; this.b = h.b; this.c = h.c; this.d = h.d; this.e = h.e; this.f = h.f; this.g = h.g; this.h = h.h; this.i = h.i; this.j = h.j;
	}
}
