
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
	private Button ftTableBox;
	private boolean isFaultTreeTable = false;
	private FaultTreeType faultTreeType;
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
				"Fault Tree and Trace in graphical view by default, minimal cut sets in table format.\nSelect Error state for composite parts fault tree, Out propagation for flow based fault tree.",
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
		faultTreeBox.setSelection(true);
		mincutsetBox = new Button(container, SWT.RADIO);
		mincutsetBox.setText("Minimal Cut Sets with Computed Probability (Table format)");
		mincutsetBox.setSelection(false);
		faultTraceBox = new Button(container, SWT.RADIO);
		faultTraceBox.setText("Fault Contributor Trace (dependent events marked by *)");
		faultTraceBox.setSelection(false);
		compositePartsBox = new Button(container, SWT.RADIO);
		compositePartsBox.setText("Parts Fault Tree (based on composite error states*)");
		compositePartsBox.setSelection(false);
		ftTableBox = new Button(container, SWT.CHECK);
		ftTableBox.setText("Fault Tree/Trace in Table Format");
		ftTableBox.setSelection(false);
		return area;
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	private void saveInput() {
		value = errorMode.getText();
		isFaultTreeTable = ftTableBox.getSelection();
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

	public boolean isFaultTreeTable() {
		return isFaultTreeTable;
	}

}
