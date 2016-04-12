/*
 * <copyright>
 * Copyright  2012-2013 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 */
package org.osate.aadl2.errormodel.analysis.actions;

/**
 * Also, this class implement the following consistency rule from
 * the official documentation:
 * C1, C5, C7, C11, C12
 *
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.WriteToFile;
import org.osate.ui.actions.AaxlReadOnlyActionAsJob;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;
import org.osate.xtext.aadl2.errormodel.util.AnalysisModel;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;
import org.osate.xtext.aadl2.errormodel.util.PropagationPathEnd;
import org.osate.xtext.aadl2.errormodel.util.PropagationPathRecord;

class ComponentSelectionDialog extends Dialog {
	private String message;
	private List<String> selectedComponents;
	private List<String> componentsList;

	public ComponentSelectionDialog(Shell parent, List<String> components) {
		this(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		componentsList = components;

	}

	public ComponentSelectionDialog(Shell parent, int style) {
		super(parent, style);
		setText("Select the components");
		setMessage("Please select the components under investigation:");
		selectedComponents = new ArrayList<String>();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Open the dialog box, display the content and wait for the result from the user
	 * @return The list of modules names selected by the user.
	 */
	public List<String> open() {
		Shell shell = new Shell(getParent(), getStyle());
		shell.setText(getText());
		createContents(shell);
		shell.pack();
		shell.open();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return selectedComponents;
	}

	/**
	* Create all the widgets necessary to create the dialog
	* @param shell
	*/
	private void createContents(final Shell shell) {
		shell.setLayout(new GridLayout(2, true));

		// Show the message
		Label label = new Label(shell, SWT.NONE);
		label.setText(message);
		GridData data = new GridData();
		data.horizontalSpan = 2;
		label.setLayoutData(data);

		final Table table = new Table(shell, SWT.CHECK | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		/**
		 * Add the data to the table. For each
		 * item to be displayed, we create an item with
		 * a text field and a checkbox.
		 */
		for (String moduleName : componentsList) {
			TableItem ti = new TableItem(table, SWT.NONE);
			ti.setText(moduleName);
		}
		data = new GridData(GridData.FILL_HORIZONTAL);
		data.horizontalSpan = 2;
		table.setLayoutData(data);

		/**
		 * The OK button that register the selected
		 * items.
		 */
		Button ok = new Button(shell, SWT.PUSH);
		ok.setText("OK");
		data = new GridData(GridData.FILL_HORIZONTAL);
		ok.setLayoutData(data);
		ok.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				for (TableItem ti : table.getItems()) {
					if (ti.getChecked()) {
						selectedComponents.add(ti.getText());
					}
				}
				shell.close();
			}
		});

		// Create the cancel button and add a handler
		// so that pressing it will set input to null
		Button cancel = new Button(shell, SWT.PUSH);
		cancel.setText("Cancel");
		data = new GridData(GridData.FILL_HORIZONTAL);
		cancel.setLayoutData(data);
		cancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				selectedComponents = null;
				shell.close();
			}
		});

		// Set the OK button as the default, so
		// user can type input and press Enter
		// to dismiss
		shell.setDefaultButton(ok);
	}
}

public final class CutsetAction extends AaxlReadOnlyActionAsJob {
	AnalysisModel model;

	List<String> selectedComponents;

	@Override
	protected String getMarkerType() {
		return "org.osate.aadl2.errormodel.analysis.FaultImpactMarker";
	}

	@Override
	protected String getActionName() {
		return "CutSet";
	}

	protected void reportHeading(WriteToFile report, List<PropagationPathEnd> dests) {
		report.addOutput("Failure injected");

		for (PropagationPathEnd ppe : dests) {
			report.addOutput("," + ppe.getComponentInstance().getName());
			report.addOutput("/" + ppe.getErrorPropagation().getFeatureorPPRef().getFeatureorPP().getName());
		}

		report.addOutput("\n");
	}

	private boolean isAnalyzed(String s) {
		boolean ret;

		ret = false;

		for (String sc : selectedComponents) {
			if (s.equalsIgnoreCase(sc)) {
				ret = true;
			}
		}
		return ret;
	}

	private boolean isAnalyzed(ComponentInstance ci) {
		return isAnalyzed(ci.getName());
	}

	@Override
	public void doAaxlAction(IProgressMonitor monitor, Element obj) {
		final List<String> componentsList;

		monitor.beginTask("Generating Cutset", IProgressMonitor.UNKNOWN);
		List<PropagationPathEnd> sources;
		List<PropagationPathEnd> destinations;
		sources = new ArrayList<PropagationPathEnd>();
		destinations = new ArrayList<PropagationPathEnd>();
		// Get the system instance (if any)
		SystemInstance si;
		if (obj instanceof InstanceObject) {
			si = ((InstanceObject) obj).getSystemInstance();
		} else {
			return;
		}

		WriteToFile report = new WriteToFile("CutSet", si);

		model = new AnalysisModel(si);
		componentsList = new ArrayList<String>();

		for (ComponentInstance tmpi : model.getSubcomponents()) {
			componentsList.add(tmpi.getName());
		}

		final Display d = PlatformUI.getWorkbench().getDisplay();
		d.syncExec(new Runnable() {

			@Override
			public void run() {
				IWorkbenchWindow window;
				Shell sh;
				ComponentSelectionDialog csd;
				window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
				sh = window.getShell();
				csd = new ComponentSelectionDialog(sh, componentsList);
				selectedComponents = csd.open();
			}
		});

//		for (String s : selectedComponents)
//		{
//			OsateDebug.osateDebug("SELECTED" + s);
//		}

		Collection<PropagationPathRecord> pathlist = model.getPropagationPaths();

		for (PropagationPathRecord ppr : pathlist) {
			if (isAnalyzed(ppr.getSrcCI())) {
//				OsateDebug.osateDebug("[SRC] ci=" + ppr.getSrcCI());
				sources.add(ppr.getPathSrc());
			}
			if (isAnalyzed(ppr.getDstCI())) {
				destinations.add(ppr.getPathDst());
			}
		}

		reportHeading(report, destinations);

		for (PropagationPathEnd src : sources) {

			for (TypeToken tt : src.getErrorPropagation().getTypeSet().getTypeTokens()) {
				for (ErrorTypes et : tt.getType()) {

					report.addOutput(src.getComponentInstance().getName());

					report.addOutput(" - " + et.getName());

					ErrorPropagation ep = src.getErrorPropagation();
					report.addOutput(" on " + EMV2Util.getPropagationName(ep));

					for (PropagationPathEnd dst : destinations) {
						report.addOutput(",");
						if (model.impact(src, dst)) {
							report.addOutput(EMV2Util.getPrintName(dst.getErrorPropagation().getTypeSet())
									.replace("{", "").replace("}", "").replace(',', '/'));
						}

					}

					report.addOutput("\n");
				}

			}

		}

		report.saveToFile();

		monitor.done();
	}

}
