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


public class WriteToFile {
	
	UnparseText textBuffer ;
	String reportType;
	EObject root;
	public WriteToFile(String reporttype, EObject root){
		this.reportType = reporttype;
		this.root = root;
		this.textBuffer = new UnparseText();
	}
	
	public void addOutput(String text){
		textBuffer.addOutput(text);
	}
	
	public void addOutputNewline(String text){
		textBuffer.addOutputNewline(text);
	}
	
	
	protected IPath getReportPath(String reporttype, EObject root){
		Resource res = root.eResource();
		URI uri = res.getURI();
		IPath path = OsateResourceUtil.getOsatePath(uri);
		if (root instanceof InstanceObject){
			String filename = path.lastSegment();
			path = path.removeFileExtension().removeLastSegments(2).append("/reports/"+reporttype+"/"+filename);
		} else {
			String filename = path.lastSegment();
			path = path.removeFileExtension().removeLastSegments(1).append("/reports/"+reporttype+"/"+filename);
		}
		path = path.removeFileExtension().addFileExtension("csv");
		return path;
	}
	
	/**
	 * Writes content as csv report
	 * @param root
	 * @param content
	 */	
	public void saveToFile(){
		IPath path = getReportPath(reportType,root);
		if (path != null) {
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			if (file != null) {
				final InputStream input = new ByteArrayInputStream(textBuffer.getParseOutput().getBytes());
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
	}
	
}
