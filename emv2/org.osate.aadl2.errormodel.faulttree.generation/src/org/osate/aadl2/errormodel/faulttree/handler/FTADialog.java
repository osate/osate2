
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

public class FTADialog extends TitleAreaDialog {

	private String value;
	java.util.List<String> values;
	private Combo errorMode;
	private Button graphBox;
	private boolean graph;
	private Button optBox;
	private Button cutsetBox;
	private Button basictreeBox;
	private boolean optimize;
	private boolean mincutset;
	private boolean basictree;
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
		setMessage("Select Error state for composite parts fault tree, Out propagation for flow based fault tree.",
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
		labelErrorMode.setText("Error State or Outgoing Propagation");

		errorMode = new Combo(container, SWT.READ_ONLY | SWT.BORDER);
		String val[] = new String[values.size()];
		for (int i = 0; i < values.size(); i++) {
			val[i] = values.get(i);
		}
		errorMode.setItems(val);

		errorMode.select(0);
		basictreeBox = new Button(container, SWT.RADIO);
		basictreeBox.setText("Fault Contributor Trace (dependent events marked by *)");
		basictreeBox.setSelection(true);
		optBox = new Button(container, SWT.RADIO);
		optBox.setText("Fault Tree with Computed Probability");
		optBox.setSelection(false);
		cutsetBox = new Button(container, SWT.RADIO);
		cutsetBox.setText("Minimal Cut Sets with Computed Probability");
		cutsetBox.setSelection(false);
		return area;
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	private void saveInput() {
		value = errorMode.getText();
		if (graphBox == null) {
			graph = false;
		} else {
			optimize = graphBox.getSelection();
		}
		if (optBox == null) {
			optimize = true;
		} else {
			optimize = optBox.getSelection();
		}
		if (cutsetBox == null) {
			mincutset = false;
		} else {
			mincutset = cutsetBox.getSelection();
		}
		if (basictreeBox == null) {
			basictree = true;
		} else {
			basictree = basictreeBox.getSelection();
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

	public boolean getSharedEventsAsGraph() {
		return graph;
	}

	public boolean getTransform() {
		return optimize;
	}

	public boolean getMinCutSet() {
		return mincutset;
	}

	public boolean getBasicTree() {
		return basictree;
	}

}
