/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
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