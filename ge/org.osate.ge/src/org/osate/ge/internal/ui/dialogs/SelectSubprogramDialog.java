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
package org.osate.ge.internal.ui.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.osate.ge.internal.ui.util.ContextHelpUtil;

/**
 * This dialog is used to select the subprogram in order to configure a subprogram call.
 *
 */
public class SelectSubprogramDialog extends TitleAreaDialog {
	private final Model model;
	private ComboViewer contextCmb;
	private ComboViewer subprogramCmb;
	private Object selectedContext; // Valid after the OK button has been selected
	private Object selectedSubprogram; // Valid after the OK button has been selected

	private LabelProvider labelProvider = new LabelProvider() {
		@Override
		public String getText(final Object value) {
			return model.getLabel(value);
		}
	};

	/**
	 * Interface for providing data to the SelectSubprogramDialog class.
	 *
	 */
	public static interface Model {
		// Lists may be read only
		// Null objects are not allowed
		public List<Object> getContexts();
		public List<Object> getSubprograms(final Object context);
		public String getLabel(final Object obj);
	}

	public SelectSubprogramDialog(final Shell parentShell, final Model model) {
		super(parentShell);
		this.model = model;
		setHelpAvailable(true);
		setShellStyle(getShellStyle() | SWT.RESIZE);
	}

	@Override
	protected void configureShell(final Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Select Subprogram");
		newShell.setMinimumSize(650, 190);
	}

	@Override
	public void create() {
		super.create();
		setTitle("Select Subprogram");
		validate();

		ContextHelpUtil.setHelp(getShell(), ContextHelpUtil.SUBPROGRAM_CALL_SEQUENCES);
	}

	@Override
	protected Control createDialogArea(final Composite parent) {
		final Composite area = (Composite)super.createDialogArea(parent);

		final Composite container = new Composite(area, SWT.NONE);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		container.setLayout(new GridLayout(3, false));

		// Context Combo
		final List<Object> contexts = model.getContexts();
		contextCmb = new ComboViewer(container, SWT.DROP_DOWN | SWT.READ_ONLY);
		final GridData contextsCmbGridData = new GridData(SWT.FILL, SWT.BOTTOM, true, false);
		contextsCmbGridData.minimumWidth = 300;
		contextCmb.getControl().setLayoutData(contextsCmbGridData);
		contextCmb.setContentProvider(new ArrayContentProvider());
		contextCmb.setLabelProvider(labelProvider);
		contextCmb.setInput(contexts);
		contextCmb.setComparator(new ViewerComparator());

		// Separator Label
		final Label separatorLabel = new Label(container, SWT.NONE);
		separatorLabel.setLayoutData(new GridData(SWT.CENTER, SWT.BOTTOM, false, false));
		separatorLabel.setText(".");

		// Subprogram Combo
		subprogramCmb = new ComboViewer(container, SWT.DROP_DOWN | SWT.READ_ONLY);
		final GridData subprogramCmbGridData = new GridData(SWT.FILL, SWT.BOTTOM, true, false);
		subprogramCmbGridData.minimumWidth = 300;
		subprogramCmb.getControl().setLayoutData(subprogramCmbGridData);
		subprogramCmb.setContentProvider(new ArrayContentProvider());
		subprogramCmb.setLabelProvider(labelProvider);
		subprogramCmb.setComparator(new ViewerComparator());

		contextCmb.addSelectionChangedListener(event -> {
			if(event.getSelection() instanceof StructuredSelection) {
				final StructuredSelection ss = (StructuredSelection)event.getSelection();
				if(!ss.isEmpty()) {
					subprogramCmb.setInput(model.getSubprograms(ss.getFirstElement()));
				}
			}

			validate();
		});

		subprogramCmb.addSelectionChangedListener(event -> validate());

		// Set the initially selected context to the first one in the (sroted) list
		final Object initialContext = contextCmb.getElementAt(0);
		if(initialContext != null) {
			contextCmb.setSelection(new StructuredSelection(initialContext));
		}

		return area;
	}

	@Override
	public void okPressed() {
		// Store references to the selected items
		final StructuredSelection contextSelection = (StructuredSelection) contextCmb.getSelection();
		final StructuredSelection subprogramSelection = (StructuredSelection) subprogramCmb.getSelection();
		selectedContext = contextSelection.getFirstElement();
		selectedSubprogram = subprogramSelection.getFirstElement();

		super.okPressed();
	}

	private void validate() {
		final Button okButton = getButton(IDialogConstants.OK_ID);
		if(okButton != null) {
			final StructuredSelection subprogramSelection = (StructuredSelection) subprogramCmb.getSelection();
			okButton.setEnabled(!subprogramSelection.isEmpty());
			setMessage(subprogramSelection.isEmpty() ? "No subprogram selected" : "");
		}
	}

	public Object getSelectedContext() {
		return selectedContext;
	}

	public Object getSelectedSubprogram() {
		return selectedSubprogram;
	}

	public static void main (String [] args) {
		final SelectSubprogramDialog dlg = new SelectSubprogramDialog(null, new Model() {
			@Override
			public List<Object> getContexts() {
				final List<Object> retVal = new ArrayList<Object>();
				retVal.add("processor");
				retVal.add("data_type");
				retVal.add("pkg:data_type");
				retVal.add("subcomponent");
				retVal.add("");
				return retVal;
			}

			@Override
			public List<Object> getSubprograms(final Object context) {
				final List<Object> retVal = new ArrayList<Object>();
				if("".equals(context)) {
					retVal.add("sp_inst");
				} else {
					retVal.add("sp1");
					retVal.add("sp2");
				}

				return retVal;
			}

			@Override
			public String getLabel(final Object obj) {
				return obj.toString();
			}

		});
		dlg.open();
	}

}
