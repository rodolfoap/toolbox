import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class GroovyAnalyzer {
	public String text;
	public static void main(String args[]) {
		Method[] methods = String.class.getDeclaredMethods();
		Field[]  fields  = String.class.getDeclaredFields();
		for(Method method : methods) System.out.println("method = " + method.getName()+"="+method.toString());
		for(Field  field  : fields ) System.out.println("field = " +   field.getName()+"="+field.toString());
	}
}
