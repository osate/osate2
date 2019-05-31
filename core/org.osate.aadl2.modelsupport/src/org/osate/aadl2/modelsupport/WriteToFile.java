package org.osate.aadl2.modelsupport;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.aadl2.modelsupport.util.AadlUtil;

/**
 * mechanism to provide a logging capability into csv files
 * has a saved flag to know whether to save since the last save
 * unset by any addOutput method so the file can be saved multiple times.
 * @author phf
 *
 */
public class WriteToFile {

	UnparseText textBuffer;
	String reportFolder;
	String reportType;
	EObject root;
	String fileExtension;
	Boolean saved = false;
	String suffix = null;

	public WriteToFile(String reporttype, EObject root) {
		reportType = reporttype;
		this.root = root;
		textBuffer = new UnparseText();
		fileExtension = "csv";
	}

	public WriteToFile(String reporttype, EObject root, String extension) {
		reportType = reporttype;
		this.root = root;
		textBuffer = new UnparseText();
		fileExtension = extension;
	}

	public WriteToFile(String reportfolder, String reporttype, EObject root) {
		reportFolder = reportfolder;
		reportType = reporttype;
		this.root = root;
		textBuffer = new UnparseText();
		fileExtension = "csv";
	}

	public WriteToFile(String reportfolder, String reporttype, EObject root, String extension) {
		reportFolder = reportfolder;
		reportType = reporttype;
		this.root = root;
		textBuffer = new UnparseText();
		fileExtension = extension;
	}

	public void setReportFolder(String s) {
		reportFolder = s;
	}

	public void setSuffix(String s) {
		suffix = s;
	}

	public void setFileExtension(String fe) {
		fileExtension = fe;
	}

	public void addOutput(String text) {
		textBuffer.addOutput(text);
		saved = false;
	}

	public void addOutputNewline(String text) {
		textBuffer.addOutputNewline(text);
		saved = false;
	}

	/**
	 * placement of file into a report folder with a subfolder for the report type
	 * The file is that of the instance model appended with the report type.
	 * We do this so several csv files (of different report types) can be opened simultaneously
	 * Excel does not like to open files with the same name twice
	 * @param reporttype
	 * @param root
	 * @return
	 */
	protected IPath getReportPath(String reporttype, EObject root) {

		String filename = null;
		reporttype = reporttype.replaceAll(" ", "");
		Resource res = root.eResource();
		URI uri = res.getURI();
		IPath path = OsateResourceUtil.toIFile(uri).getFullPath();
		if (root instanceof InstanceObject) {
			path = path.removeFileExtension();
			filename = path.lastSegment() + "__" + reporttype;
			if (suffix != null) {
				filename = filename + suffix;
			}
			path = path.removeLastSegments(1).append("/reports/" + reporttype + "/" + filename);
		} else {
			filename = path.lastSegment() + reporttype;
			if (suffix != null) {
				filename = filename + suffix;
			}
			path = path.removeLastSegments(1).append("/reports/" + reporttype + "/" + filename);
		}

		path = path.addFileExtension(fileExtension);
		return path;
	}

	public static String getFileName(String reporttype, EObject root) {
		String filename = null;
		reporttype = reporttype.replaceAll(" ", "");
		Resource res = root.eResource();
		URI uri = res.getURI();
		IPath path = OsateResourceUtil.toIFile(uri).getFullPath();
		if (root instanceof InstanceObject) {
			path = path.removeFileExtension();
			filename = path.lastSegment() + "__" + reporttype;
		} else {
			filename = path.lastSegment() + reporttype;
		}

		return filename;
	}

	/**
	 * Writes content as csv report
	 */
	public void saveToFile() {
		saveToFile("");
	}

	/**
	 * Writes content as csv report prefixed with summary text.
	 */
	public void saveToFile(String summary) {
		if (saved) {
			return;
		}
		IPath path = getReportPath(reportType, root);
		if (path != null) {
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			if (file != null) {
				final InputStream input = new ByteArrayInputStream((summary + textBuffer.getParseOutput()).getBytes());
				try {
					if (file.exists()) {
						file.setContents(input, true, true, null);
					} else {
						AadlUtil.makeSureFoldersExist(path);
						file.create(input, true, null);
					}
				} catch (final CoreException e) {
				}
			}
		}
		saved = true;
	}

}
