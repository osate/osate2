/*
 * Copyright 2013 Carnegie Mellon University
 * 
 * The AADL/DSM Bridge (org.osate.importer.lattix ) (the “Content” or “Material”) 
 * is based upon work funded and supported by the Department of Defense under 
 * Contract No. FA8721-05-C-0003 with Carnegie Mellon University for the operation 
 * of the Software Engineering Institute, a federally funded research and development 
 * center.

 * Any opinions, findings and conclusions or recommendations expressed in this 
 * Material are those of the author(s) and do not necessarily reflect the 
 * views of the United States Department of Defense. 

 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING 
 * INSTITUTE MATERIAL IS FURNISHED ON AN “AS-IS” BASIS. CARNEGIE MELLON 
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
 * Carnegie Mellon® is registered in the U.S. Patent and Trademark 
 * Office by Carnegie Mellon University. 
 * 
 * DM-0000232
 * 
 */

package org.osate.importer.lattix.actions;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.importer.lattix.ldmexporter.LdmExporter;
import org.osate.importer.lattix.vdid.Activator;
import org.osate.ui.actions.AaxlReadOnlyActionAsJob;
import org.osate.ui.dialogs.Dialog;
import org.osgi.framework.Bundle;

public final class DoExportLdm extends AaxlReadOnlyActionAsJob {

	private String outputFile;
	private IWorkbenchWindow window;

	protected Bundle getBundle() {
		return Activator.getDefault().getBundle();
	}

	public String getMarkerType() {
		return "edu.cmu.sei.vdid.dsm.ExcelReportGeneratorObjectMarker";
	}

	protected String getActionName() {
		return "Lattix Exporter";
	}

	public void doAaxlAction(IProgressMonitor monitor, Element obj) {
		boolean canRun;
		Display d;
		final SystemInstance si;

		outputFile = null;

		d = PlatformUI.getWorkbench().getDisplay();

		if (obj instanceof InstanceObject) {
			si = ((InstanceObject) obj).getSystemInstance();
		} else {
			si = null;
		}

		if (si == null) {
			Dialog.showError("DSM Matrix Generator", "Invalid System Instance");
			return;
		}

		Job ldmGenerator = new Job("AADL2LDM") {
			protected IStatus run(IProgressMonitor monitor) {
				monitor.beginTask("Generating LDM file from AADL", 100);

				try {
					LdmExporter.convert(si, outputFile);
				} catch (Exception e) {
					monitor.done();
					return Status.CANCEL_STATUS;
				}

				monitor.done();
				return Status.OK_STATUS;
			}
		};

		d.syncExec(new Runnable() {

			public void run() {
				IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();

				Shell sh = window.getShell();
				FileDialog fd = new FileDialog(sh, SWT.SAVE);
				outputFile = fd.open();
			}
		});

		ldmGenerator.schedule();

	}

	public void dispose() {

	}

	public void init(IWorkbenchWindow window) {
		this.window = window;
	}

}
