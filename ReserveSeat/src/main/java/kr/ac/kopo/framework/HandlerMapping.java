package kr.ac.kopo.framework;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import kr.ac.kopo.controller.Controller;

public class HandlerMapping {

	private Map<String, Controller> mappings;	
	
	/*
	 * public HandlerMapping() { this("bean.properties"); }
	 * /ReserveSeat/src/main/java/kr/ac/kopo/framework/bean.properties
	 */
	
	public HandlerMapping(String propName) {
//		System.out.println("1");
		if(propName == null) propName = "bean.properties";
//		System.out.println("2");
		mappings = new HashMap<>();
//		System.out.println("3");
		Properties prop = new Properties();
//		System.out.println("4");
		String propLoc = this.getClass().getResource("bean.properties").getPath();
		System.out.println(propLoc);
		
		try (
			InputStream is = new FileInputStream(propLoc);
		){
			prop.load(is);
			Set<Object> keys = prop.keySet();
			for(Object key : keys) {
			//	System.out.println(key.toString() + " : " + prop.getProperty(key.toString()));
				String className = prop.getProperty(key.toString());
				
				Class<?> clz = Class.forName(className);
				Constructor<?> constructor = clz.getConstructor();
				Controller instance = (Controller)constructor.newInstance();
				mappings.put(key.toString(), instance);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

	public Controller getController(String uri) {
		return mappings.get(uri);
	}
	
}
