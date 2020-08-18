package org.osate.aadl2.modelsupport;

/**
 * @since 5.0
 * 
 * This class contains constants related to file names, file extensions, and directory names for AADL textual files and
 * instance files.
 */
public final class FileNameConstants {
	public static final String SOURCE_FILE_EXT = "aadl";
	public static final String MODEL_FILE_EXT = "aaxl2";
	public static final String INSTANCE_FILE_EXT = "aaxl2";
	public static final String INSTANCE_MODEL_POSTFIX = "_Instance";
	public static final String AADL_INSTANCES_DIR = "instances";
	
	/**
	 * This is the separator used for qualified package declarations which contain multiple parts. Example package
	 * declaration:
	 * 
	 * <pre>
	 * package a::b::c
	 * public
	 * end a::b::c;
	 * </pre>
	 */
	public static final String AADL_PACKAGE_SEPARATOR = "::";
	
	/**
	 * This is the separator used for package files in which the package name contains multiple parts. Example file
	 * name: {@code a-b-c.aadl}
	 */
	public static final String FILE_PACKAGE_SEPARATOR = "-";
	
	private FileNameConstants() {
	}
}