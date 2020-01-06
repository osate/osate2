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
package org.osate.aadl2.errormodel.faulttree.handler;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.osate.aadl2.errormodel.FaultTree.FaultTreeType;

public class FTADialog extends TitleAreaDialog {

	private String value;
	java.util.List<String> values;
	private Combo errorMode;
	private Button compositePartsBox;
	private Button faultTreeBox;
	private Button mincutsetBox;
	private Button faultTraceBox;
	private Button graphicViewBox;
	private static boolean isGraphicView = false;
	private static FaultTreeType faultTreeType = FaultTreeType.FAULT_TREE;
	private String target = "";

	public FTADialog(Shell parentShell) {
		super(parentShell);
	}

	public void setValues(java.util.List<String> v) {
		values = v;
	}

	public void setTarget(String targetname) {
		target = targetname;
	}

	@Override
	public void create() {
		super.create();
		setTitle("Fault-Tree Analysis" + (target.isEmpty() ? "" : " for " + target));
		setMessage(
				"Select error state for Parts Fault Tree, out propagation or state for flow based fault tree.",
				IMessageProvider.INFORMATION);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		GridLayout layout = new GridLayout(2, false);

		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		container.setLayout(layout);

		Label labelErrorMode = new Label(container, SWT.NONE);
		labelErrorMode.setText("Select Error State or Outgoing Propagation");

		errorMode = new Combo(container, SWT.READ_ONLY | SWT.BORDER);
		String val[] = new String[values.size()];
		for (int i = 0; i < values.size(); i++) {
			val[i] = values.get(i);
		}
		errorMode.setItems(val);

		errorMode.select(0);
		faultTreeBox = new Button(container, SWT.RADIO);
		faultTreeBox.setText("Fault Tree with Computed Probability");
		faultTreeBox.setSelection(faultTreeType.equals(FaultTreeType.FAULT_TREE));
		mincutsetBox = new Button(container, SWT.RADIO);
		mincutsetBox.setText("Minimal Cut Sets with Computed Probability");
		mincutsetBox.setSelection(faultTreeType.equals(FaultTreeType.MINIMAL_CUT_SET));
		faultTraceBox = new Button(container, SWT.RADIO);
		faultTraceBox.setText("Fault Contributor Trace (dependent events marked by *)");
		faultTraceBox.setSelection(faultTreeType.equals(FaultTreeType.FAULT_TRACE));
		compositePartsBox = new Button(container, SWT.RADIO);
		compositePartsBox.setText("Parts Fault Tree with Computed Probability (composite error states only)");
		compositePartsBox.setSelection(faultTreeType.equals(FaultTreeType.COMPOSITE_PARTS));
		graphicViewBox = new Button(container, SWT.CHECK);
		graphicViewBox.setText("Show in graphical view (default is table view)");
		graphicViewBox.setSelection(isGraphicView);
		return area;
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	private void saveInput() {
		value = errorMode.getText();
		isGraphicView = graphicViewBox.getSelection();
		if (compositePartsBox.getSelection()) {
			faultTreeType = FaultTreeType.COMPOSITE_PARTS;
		} else if (faultTreeBox.getSelection()) {
			faultTreeType = FaultTreeType.FAULT_TREE;
		} else if (mincutsetBox.getSelection()) {
			faultTreeType = FaultTreeType.MINIMAL_CUT_SET;
		} else if (faultTraceBox.getSelection()) {
			faultTreeType = FaultTreeType.FAULT_TRACE;
		}
	}

	@Override
	protected void okPressed() {
		saveInput();
		super.okPressed();
	}

	public String getValue() {
		return value;
	}

	public FaultTreeType getFaultTreeType() {
		return faultTreeType;
	}

	public boolean isGraphicView() {
		return isGraphicView;
	}

}
