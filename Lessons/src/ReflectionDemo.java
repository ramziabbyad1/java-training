import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;


public class ReflectionDemo {

	public static void main(String[] args) throws ClassNotFoundException {
		//get details of the class at runtime.  good for making your own annotations. annotations are 
		//actually just interfaces
		Class c = Class.forName("Simple");
		System.out.println(c.getName());
		Simple simple = new Simple("Hello",5);
		Class<?> classs = simple.getClass();
		System.out.println(classs);
		Constructor<?>[] constructors = classs.getConstructors();
		System.out.println("No of constructors " + constructors.length);
		Constructor constructor = constructors[0];
		Object obj = null;
		try{
			obj = constructor.newInstance("New String", 10);
			System.out.println(obj);
		}catch(Exception e){
			e.printStackTrace();
		}
		//;like this you can get all details about method
		Class<?>[] parameters = constructor.getParameterTypes();
		for(int i = 0; i < parameters.length; i++){
			System.out.println("Paramters " + parameters[i]);
		}
		Annotation params = constructor.getAnnotation(classs);
		System.out.println("Annotations: " + params);
		
	}

}
