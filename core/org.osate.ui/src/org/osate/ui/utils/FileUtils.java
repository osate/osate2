/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
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
package org.osate.ui.utils;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.osate.workspace.WorkspacePlugin;
import org.osgi.framework.Bundle;

import com.google.common.io.Files;

public class FileUtils {

	public static class AadlFileFilter implements FileFilter {
		@Override
		public boolean accept(File pathname) {
			String fileName = pathname.getName();

			int i = fileName.lastIndexOf('.');

			String extension = fileName.substring(i + 1, fileName.length());

			return WorkspacePlugin.SOURCE_FILE_EXT.equalsIgnoreCase(extension)
					|| WorkspacePlugin.SOURCE_FILE_EXT2.equalsIgnoreCase(extension);
		}
	}

	public static void copyFiles(File srcFile, File destFolder, List<String> excludedNodeNames) throws IOException {
		// Verifications
		byte errorCode = 0;

		if (!srcFile.exists()) {
			errorCode += 1;
		}

		if (destFolder.exists() && destFolder.isFile()) {
			errorCode += 10;
		}

		if (errorCode != 0) {
			String errorMsg = "";

			switch (errorCode) {
			case 11:
				errorMsg = "destination is not a directory, can overwrite it and ";
			case 1: {
				errorMsg = "source file doesn't exist";
				break;
			}
			case 10: {
				errorMsg = "destination is not a directory, can overwrite it";
				break;
			}
			}

			throw new IOException(errorMsg);
		}

		if (!destFolder.exists()) {
			destFolder.mkdirs();
		}

		if (srcFile.isDirectory()) {
			for (File inside : srcFile.listFiles()) {
				File newDestFolder = new File(destFolder.getPath() + File.separatorChar + srcFile.getName());
				newDestFolder.mkdir();

				FileUtils.copyFiles(inside, newDestFolder, excludedNodeNames);
			}
		} else {
			File newFile = new File(destFolder.getPath() + File.separatorChar + srcFile.getName());

			Files.copy(srcFile, newFile);
		}
	}

	public static void copyFile(File srcFile, File destFolder) throws IOException {
		// Verifications
		byte errorCode = 0;

		if (!srcFile.exists()) {
			errorCode += 1;
		}

		if (destFolder.exists() && destFolder.isFile()) {
			errorCode += 10;
		}

		if (errorCode != 0) {
			String errorMsg = "";

			switch (errorCode) {
			case 11:
				errorMsg = "destination is not a directory, can overwrite it and ";
			case 1: {
				errorMsg = "source file doesn't exist";
				break;
			}
			case 10: {
				errorMsg = "destination is not a directory, can overwrite it";
				break;
			}
			}

			throw new IOException(errorMsg);
		}

		if (!destFolder.exists()) {
			destFolder.mkdirs();
		}
		File newFile = new File(destFolder.getPath() + File.separatorChar + srcFile.getName());

		Files.copy(srcFile, newFile);

	}

	public static void copyFiles(List<File> srcFiles, File destFolder, List<String> excludedNodeNames)
			throws IOException {
		for (File f : srcFiles) {
			FileUtils.copyFiles(f, destFolder, excludedNodeNames);
		}
	}

	public static void deleteFile(File toBeDelete) {
		delete(toBeDelete, true);
	}

	public static void deleteDirectoryContain(File directory) {
		delete(directory, false);
	}

	private static void delete(File toBeDelete, boolean justTheContain) {
		if (toBeDelete.exists()) {
			if (toBeDelete.isDirectory()) {
				for (File f : toBeDelete.listFiles()) {
					// Recursive call.
					FileUtils.deleteFile(f);
				}
			}

			if (justTheContain) {
				toBeDelete.delete();
			}
		}
	}

	public static File stringToFile(String path) throws FileNotFoundException {
		if (path != null) {
			File result = new File(path);

			if (!result.exists()) {
				throw new FileNotFoundException('\'' + path + "\' is not found");
			} else {
				return result;
			}
		} else {
			throw new FileNotFoundException("the given path is null");
		}
	}

	public static File getContainingDirectory(File file) throws NullPointerException {
		File result = null;

		if (file.isFile()) {
			// Throws NullPointerException if trying to get the parent of the root
			// file system.
			result = new File(file.getAbsoluteFile().getParent());
		} else {
			result = file;
		}

		return result;
	}

	/**
	 * Returns recursively all the sub directories contained in the given directory.
	 * The result set doesn't contain the given directory. If the given File 
	 * object doesn't represent a directory, it returns an empty set.
	 * 
	 * @param directory the given directory or the file object
	 * @return the sub directories of the given directory excepted their parent
	 */
	public static Set<File> getSubDirectories(File directory) {
		Set<File> result = null;

		if (directory.isDirectory()) {
			result = new LinkedHashSet<File>();

			for (File f : directory.listFiles(new DirectoryFileFilter())) {
				result.add(f);
				result.addAll(getSubDirectories(f));
			}
		} else {
			result = Collections.emptySet();
		}

		return result;
	}

	public static class DirectoryFileFilter implements FileFilter {
		@Override
		public boolean accept(File pathname) {
			return pathname.isDirectory();
		}
	}

	public static File getPluginFile(String pluginId, String relativePath) throws Exception {
		File result = null;

		if (Platform.isRunning()) {
			Bundle bundle = Platform.getBundle(pluginId);
			if (bundle == null) {
				throw new Exception("plugin: " + pluginId + " is not found");
			}

			URL rootURL = bundle.getEntry(relativePath);
			if (rootURL == null) {
				throw new Exception("file or directory: " + relativePath + " is not found");
			}

			result = new File(FileLocator.toFileURL(rootURL).getFile());
		}

		return result;
	}
}