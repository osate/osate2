package org.osate.propertiescodegen;

public class GeneratedClass {
	private final String fileName;
	private final String contents;
	
	public GeneratedClass(String fileName, String contents) {
		this.fileName = fileName;
		this.contents = contents;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public String getContents() {
		return contents;
	}
}