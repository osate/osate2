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
	
	String Filename ;
	public WriteToFile(String filename){
		Filename = filename;
	}

	/** save a log file of latency values for debugging the path **/
	public void logLine(String outstr){
		// Stream to write file
		FileOutputStream fout;

		try
		{
			boolean exists = (new File(Filename)).exists();

			// Open an output stream
			fout = new FileOutputStream (Filename, true);

			// Print a line of text
			new PrintStream(fout).println (outstr);

			// Close our output stream
			fout.close();		
		}
		// Catches any error conditions
		catch (IOException e)
		{
			System.err.println ("Unable to write to file");
			System.exit(-1);
		}
	}
	/**
	 * Writes content to file in specified path
	 * @param path
	 * @param content
	 */	
	public static void WriteToFile(IPath path, String content){

		if (path != null) {
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			if (file != null) {
				final InputStream input = new ByteArrayInputStream(content.getBytes());
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
	
	
	public static IPath getReportPath(String reporttype, AObject root){
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
	public static void WriteCSVReport(String reporttype, AObject root, String content){
		IPath path = getReportPath(reporttype,root);
		WriteToFile(path,content);
	}



	
}
