/*
 * Copyright 2013 Carnegie Mellon University
 * 
 * The AADL/DSM Bridge (org.osate.importer.lattix ) (the �Content� or �Material�) 
 * is based upon work funded and supported by the Department of Defense under 
 * Contract No. FA8721-05-C-0003 with Carnegie Mellon University for the operation 
 * of the Software Engineering Institute, a federally funded research and development 
 * center.

 * Any opinions, findings and conclusions or recommendations expressed in this 
 * Material are those of the author(s) and do not necessarily reflect the 
 * views of the United States Department of Defense. 

 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING 
 * INSTITUTE MATERIAL IS FURNISHED ON AN �AS-IS� BASIS. CARNEGIE MELLON 
 * UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, 
 * AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR 
 * PURPOSE OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF 
 * THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT MAKE ANY WARRANTY OF 
 * ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT 
 * INFRINGEMENT.
 * 
 * This Material has been approved for public release and unlimited 
 * distribution except as restricted below. 
 * 
 * This Material is provided to you under the terms and conditions of the 
 * Eclipse Public License Version 1.0 ("EPL"). A copy of the EPL is 
 * provided with this Content and is also available at 
 * http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Carnegie Mellon� is registered in the U.S. Patent and Trademark 
 * Office by Carnegie Mellon University. 
 * 
 * DM-0000232
 * 
 */

package org.osate.importer.lattix.handlers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.importer.Utils;
import org.osate.importer.lattix.vdid.ExcelGenerator;
import org.osate.importer.lattix.vdid.MatrixGenerator;
import org.osate.importer.lattix.vdid.MetricsReporter;
import org.osate.ui.dialogs.Dialog;
import org.osate.ui.handlers.AaxlReadOnlyHandlerAsJob;

public final class DoGenerateExcelReport extends AaxlReadOnlyHandlerAsJob {
	private static String path;

	@Override
	public String getMarkerType() {
		return "edu.cmu.sei.vdid.dsm.ExcelReportGeneratorObjectMarker";
	}

	@Override
	protected String getActionName() {
		return "Excel Report Generator";
	}

	protected Resource buildFile(SystemInstance si) {

		URI Instanceuri = si.eResource().getURI();
		URI resourceURI = Instanceuri.trimSegments(1).appendSegment(si.getName());
		resourceURI = resourceURI.appendFileExtension("dsm");
		return OsateResourceUtil.getEmptyAaxl2Resource(resourceURI);
	}

	@Override
	public void doAaxlAction(IProgressMonitor monitor, Element obj) {

		final Display d = PlatformUI.getWorkbench().getDisplay();
		d.syncExec(new Runnable() {
			@Override
			public void run() {
				IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();

				Shell sh = window.getShell();
				FileDialog fd = new FileDialog(sh, SWT.SAVE);
				path = fd.open();
			}
		});

		monitor.beginTask("Generating Excel Report", IProgressMonitor.UNKNOWN);
		List<String> componentList = new ArrayList<String>();

		SystemInstance si;
		si = null;

		if (obj instanceof InstanceObject) {
			si = ((InstanceObject) obj).getSystemInstance();
		}

		if (si == null) {
			Dialog.showInfo("Metrics Reports", "Please choose an instance system");
			return;
		}

		MetricsReporter metricsReporter = new MetricsReporter(monitor, getErrorManager());
//		metricsReporter.defaultTraversalAllDeclarativeModels();
//		
//		
		MatrixGenerator matrixGenerator = new MatrixGenerator(monitor, getErrorManager(), si);
//		matrixGenerator.defaultTraversalAllDeclarativeModels();

		matrixGenerator.defaultTraversal(si);

		metricsReporter.defaultTraversal(si);

		Utils.listComponentsNames(si, componentList);

		try {
			ExcelGenerator.writeReport(path, si, metricsReporter, matrixGenerator, componentList);
		} catch (IOException e) {
			Dialog.showInfo("Excel Report Generator", "Error when trying to write the file");
			monitor.done();
			e.printStackTrace();
			return;
		} catch (Exception e) {
			Dialog.showInfo("Excel Report Generator", "Unknown error");
			monitor.done();
			e.printStackTrace();
			return;
		}

		Dialog.showInfo("Excel Report Generator", "Report Generated");
		monitor.done();

	}
}