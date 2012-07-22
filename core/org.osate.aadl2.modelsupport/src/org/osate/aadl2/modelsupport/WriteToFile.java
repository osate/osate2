package org.osate.aadl2.modelsupport;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.parsesupport.AObject;
import org.osate.workspace.WorkspacePlugin;


public class WriteToFile {
	
	UnparseText textBuffer ;
	IPath path;
	public WriteToFile(String reporttype, EObject root){
		path = getReportPath(reporttype,root);
		textBuffer = new UnparseText();
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
		String s = path.toString();
		s = s.replaceFirst(WorkspacePlugin.AADL_INSTANCES_DIR, "/reports/"+reporttype);
		path = new Path(s);
		path = path.removeFileExtension().addFileExtension("csv");
		return path;
	}
	
	/**
	 * Writes content as csv report
	 * @param root
	 * @param content
	 */	
	public void saveToFile(){

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
