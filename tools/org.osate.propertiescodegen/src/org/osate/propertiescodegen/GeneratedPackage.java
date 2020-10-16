package org.osate.propertiescodegen;

import java.util.List;

public class GeneratedPackage {
	private final String packagePath;
	private final List<GeneratedClass> classes;
	
	public GeneratedPackage(String packagePath, List<GeneratedClass> classes) {
		this.packagePath = packagePath;
		this.classes = classes;
	}
	
	public String getPackagePath() {
		return packagePath;
	}
	
	public List<GeneratedClass> getClasses() {
		return classes;
	}
}