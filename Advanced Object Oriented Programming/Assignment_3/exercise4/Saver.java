package exercise4;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Saver {
	/**
	 * 
	 * @param o Object to be converted to XML.
	 * @return String of the object in XML form.
	 */
	public String save(Object o) {
		return saveRecursive(o, 0);
	}

	/**
	 * 
	 * @param o Object to be converted to XML.
	 * @param level Current level of the object.
	 * @return String of the object in XML form.
	 */
	@SuppressWarnings("rawtypes")
	private String saveRecursive(Object o, int level) {
		//If the object is null return nothing
		if (o == null) {
			return "";
		}
		//If the supplied object is an array go through the arraySave method
		if (o.getClass().isArray()) {
			return arraySave((Object[]) o, level);
		}
		String res = "";
		//Indent the correct amount if we're not on the base level
		if (level != 0) {
			res += indent(level * 2 + 1);
		}
		String start = "";
		Class theClass = o.getClass();
		boolean added = false;
		
		//Get the annotations for the class and look for the Element annotation
		Annotation[] annos = theClass.getAnnotations();
		for (Annotation anno : annos) {
			if (anno instanceof Element) {
				//Take the values and names of the element and add them to string
				Element ele = (Element) anno;
				added = true;
				start = ele.name();
				res += "<" + ele.name() + " ";
				for (Field fi : theClass.getDeclaredFields()) {
					if (fi.isAnnotationPresent(ElementField.class)) {
						try {
							fi.setAccessible(true);
							res += fi.getAnnotation(ElementField.class).name() + "=\"" + fi.get(o).toString()
									+ "\", ";
						} catch (IllegalArgumentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				//Remove the comma when we're done adding fields.
				res = res.substring(0, res.length() - 2);
				res += ">\n";
			}
		}
		try {
			for (Method meth : theClass.getMethods()) {
				// checks if MethodInfo annotation is present for the method
				if (meth.isAnnotationPresent(SubElements.class)) {
					try {
						SubElements methodAnno = meth.getAnnotation(SubElements.class);
						//Go down a level on object o:s subElement
						String newLevel = saveRecursive(meth.invoke(o), level + 1);
						if (newLevel != "") {
							added = true;
							res += indent(level * 2 + 2) + "<" + methodAnno.name() + ">\n";
							res += newLevel;
							res += indent(level * 2 + 2) + "</" + methodAnno.name() + ">\n";
						}
					} catch (Throwable ex) {
						ex.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//If we added something usefull to res add the end. Else erase what is on res.
		if(added)
		{
			if (level != 0) {
				res += indent(level * 2 + 1) + "</" + start + ">\n";
			} else {
				res += "</" + start + ">\n";
			}
		}
		else
		{
			res = "";
		}
		return res;
	}

	/**
	 * 
	 * @param level Amount of space to add
	 * @return A string with level*3 amount of spaces
	 */
	private String indent(int level) {
		String res = "";
		for (int i = 0; i < level; i++) {
			res += " ";
		}
		return res;
	}

	/**
	 * 
	 * @param o Array of objects to be converted to XML
	 * @param level Current level of the nested objects
	 * @return String of the nested objects in XML format
	 */
	private String arraySave(Object[] o, int level) {
		String res = "";
		for (int i = 0; i < o.length; i++) {
			res += saveRecursive(o[i], level);
		}
		return res;
	}
}
