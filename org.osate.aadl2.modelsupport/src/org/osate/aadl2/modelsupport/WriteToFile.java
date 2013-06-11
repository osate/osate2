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
	
	UnparseText textBuffer ;
	String reportFolder;
	String reportType;
	EObject root;
	String fileExtension;
	Boolean saved = false;
	String suffix = null;
	
	public WriteToFile(String reporttype, EObject root){
		this.reportType = reporttype;
		this.root = root;
		this.textBuffer = new UnparseText();
		this.fileExtension = "csv";
	}

	public WriteToFile(String reporttype, EObject root, String extension){
		this.reportType = reporttype;
		this.root = root;
		this.textBuffer = new UnparseText();
		this.fileExtension = extension;
	}
	
	public WriteToFile(String reportfolder, String reporttype, EObject root){
		this.reportFolder = reportfolder;
		this.reportType = reporttype;
		this.root = root;
		this.textBuffer = new UnparseText();
		this.fileExtension = "csv";
	}

	public WriteToFile(String reportfolder,String reporttype, EObject root, String extension){
		this.reportFolder = reportfolder;
		this.reportType = reporttype;
		this.root = root;
		this.textBuffer = new UnparseText();
		this.fileExtension = extension;
	}
	
	public void setReportFolder (String s)
	{
		this.reportFolder = s;
	}
	
	public void setSuffix (String s)
	{
		this.suffix = s;
	}
	
	public void setFileExtension (String fe)
	{
		this.fileExtension = fe;
	}
	
	public void addOutput(String text){
		textBuffer.addOutput(text);
		saved = false;
	}
	
	public void addOutputNewline(String text){
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
	protected IPath getReportPath(String reporttype, EObject root){
		reporttype = reporttype.replaceAll(" ", "");
		Resource res = root.eResource();
		URI uri = res.getURI();
		IPath path = OsateResourceUtil.getOsatePath(uri);
		if (root instanceof InstanceObject){
			path = path.removeFileExtension();
			String filename = path.lastSegment()+"__"+reporttype;
			if (this.suffix != null)
			{
				filename = filename + suffix;
			}
			path = path.removeLastSegments(1).append("/reports/"+reporttype+"/"+filename);
		} else {
			String filename = path.lastSegment()+reporttype;
			if (this.suffix != null)
			{
				filename = filename + suffix;
			}
			path = path.removeLastSegments(1).append("/reports/"+reporttype+"/"+filename);
		}

		path = path.addFileExtension(this.fileExtension);
		return path;
	}
	
	
	/**
	 * Writes content as csv report
	 */	
	public void saveToFile(){
		saveToFile("");
	}	
	
	/**
	 * Writes content as csv report prefixed with summary text.
	 */	
	public void saveToFile(String summary){
		if (saved) return;
		IPath path = getReportPath(reportType,root);
		if (path != null) {
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			if (file != null) {
				final InputStream input = new ByteArrayInputStream((summary+textBuffer.getParseOutput()).getBytes());
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
