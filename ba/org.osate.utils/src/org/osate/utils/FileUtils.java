/**
 * AADL-BA-FrontEnd
 *
 * Copyright © 2013 TELECOM ParisTech and CNRS
 *
 * TELECOM ParisTech/LTCI
 *
 * Authors: see AUTHORS
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 2.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see
 * https://www.eclipse.org/legal/epl-2.0/
 */

package org.osate.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.osate.workspace.WorkspacePlugin;

import com.google.common.io.Files;

public class FileUtils {
	/**
	 * Provides filter for AADL files (either .aadl or .aadl2).
	 */
	public static class AadlFileFilter implements FileFilter {
		@Override
		public boolean accept(File pathname) {
			String fileName = pathname.getName();

			int i = fileName.lastIndexOf('.');

			String extension = fileName.substring(i + 1, fileName.length());

			return WorkspacePlugin.SOURCE_FILE_EXT.equalsIgnoreCase(extension);
		}
	}

	/**
	 * Recursive copy the given source node to the given destination directory.<BR>
	 * Create destination directory if it doesn't exist.<BR>
	 * Overwriting destination is not permitted. If the given list of node's name
	 * (just file or directory name, not absolute path) is not {@code null},
	 * The nodes from the given source directory, which name appears in the given
	 * list (case not sensitive), will not be copied.
	 *
	 * @param srcFile the given source node
	 * @param destFolder the given destination directory
	 * @param excludedNodeNames list of node's names not copied or {@code null}.
	 * @throws IOException for any read or write errors
	 */
	public static void copyFiles(File srcFile, File destFolder, List<String> excludedNodeNames) throws IOException {
		// Verifications
		byte errorCode = 0;

		if (Aadl2Utils.contains(srcFile.getName(), excludedNodeNames)) {
			return;
		}

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

	/**
	 * Recursive copy the given list of source nodes to the given destination
	 * directory.<BR>
	 * Create destination directory if it doesn't exist.<BR>
	 * Overwriting destination is not permitted. If the given list of node's name
	 * (just file or directory name, not absolute path) is not {@code null},
	 * The nodes from the given source directory, which name appears in the given
	 * list (case not sensitive), will not be copied.
	 *
	 * @param srcFiles the given list of source nodes
	 * @param destFolder the given destination directory
	 * @param excludedNodeNames list of node's names not copied or {@code null}.
	 * @throws IOException for any read or write errors
	 */
	public static void copyFiles(List<File> srcFiles, File destFolder, List<String> excludedNodeNames)
			throws IOException {
		for (File f : srcFiles) {
			FileUtils.copyFiles(f, destFolder, excludedNodeNames);
		}
	}

	public static void copyIntoFile(File inFile, String string2write) throws IOException {
		BufferedWriter out;
		out = new BufferedWriter(new FileWriter(inFile));
		out.write(string2write);
		out.newLine();
		out.close();
	}

	/**
	 * Delete the given File object. If the object represents a directory, it
	 * recursively deletes the directory and its contains.
	 *
	 * @param toBeDelete the given File object.
	 */
	public static void deleteFile(File toBeDelete) {
		delete(toBeDelete, true);
	}

	/**
	 * Delete the contain of the given directory without delete the directory
	 * itself.
	 *
	 * @param directory the given directory
	 */
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

	/**
	 * Create a File object with the given path. It checks if the corresponding
	 * file or directory exists and throws an FileNotFoundException otherwise.
	 * Throw FileNotFoundException if the given String object is {@code null}.
	 *
	 * @param path the given path to a file or a directory
	 * @return the File object
	 * @throws FileNotFoundException if the file or the directory doesn't exist or
	 * if the given String object is {@code null}
	 */
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

	/**
	 * Returns the directory that contains the given file (which have to exist).
	 * If the given object File represents a directory, it
	 * will return the same object. If the given file is in the file system root,
	 * it will throw the NullPointerException.
	 *
	 * @param file the given object File (or a file)
	 * @return the parent directory of the given file
	 * @exception if the given file is in the file system root
	 */
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

	/**
	 * Provides filter for file object that represents a directory.
	 */
	public static class DirectoryFileFilter implements FileFilter {
		@Override
		public boolean accept(File pathname) {
			return pathname.isDirectory();
		}
	}
}