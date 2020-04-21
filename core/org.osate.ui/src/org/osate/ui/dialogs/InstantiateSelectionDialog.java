package org.osate.ui.dialogs;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPersistentPreferenceStore;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.xtext.ui.label.AbstractLabelProvider;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.SystemImplementation;
import org.osate.core.OsateCorePlugin;
import org.osate.ui.UiUtil;

/**
 * @since 3.1
 */
public class InstantiateSelectionDialog extends ElementListSelectionDialog {
	private final boolean systemsOnlyDefault;
	private Button dontShowButton;
	private Button systemsOnlyButton;

	public InstantiateSelectionDialog(final Shell shell, final boolean systemsOnly,
			final List<ComponentImplementation> fromAadl, final List<SystemImplementation> systems) {
		super(shell, new AbstractLabelProvider(UiUtil.getModelElementLabelProvider()) {
			@Override
			public String getText(final Object element) {
				final String original = super.getText(element);
				final String qualifiedName = ((ComponentImplementation) element).getQualifiedName();
				final String classifierCategory = original.substring(0, original.lastIndexOf(' '));
				return qualifiedName + " - " + classifierCategory;
			}
		});
		systemsOnlyDefault = systemsOnly;
		setTitle("Select Component Implementations");
		setMessage("Select the component implementations to instantiate from the selected .aadl files.");
		setElements(fromAadl.toArray());
		setMultipleSelection(true);
		setInitialElementSelections(systemsOnly ? systems : fromAadl);
		setBlockOnOpen(true);
	}

	@Override
	protected Control createDialogArea(final Composite parent) {
		Composite contents = (Composite) super.createDialogArea(parent);

		dontShowButton = new Button(contents, SWT.CHECK);
		dontShowButton.setText("Don't show this dialog again");
		GridData data = new GridData();
		data.grabExcessVerticalSpace = false;
		data.grabExcessHorizontalSpace = true;
		data.horizontalAlignment = GridData.FILL;
		data.verticalAlignment = GridData.BEGINNING;
		dontShowButton.setLayoutData(data);
		dontShowButton.setFont(parent.getFont());

		systemsOnlyButton = new Button(contents, SWT.CHECK);
		systemsOnlyButton.setText("Only systems by default");
		GridData data2 = new GridData();
		data2.grabExcessVerticalSpace = false;
		data2.grabExcessHorizontalSpace = true;
		data2.horizontalAlignment = GridData.FILL;
		data2.verticalAlignment = GridData.BEGINNING;
		systemsOnlyButton.setLayoutData(data2);
		systemsOnlyButton.setFont(parent.getFont());
		systemsOnlyButton.setSelection(systemsOnlyDefault);

		return contents;
	}

	@Override
	protected void okPressed() {
		final IPreferenceStore prefs = OsateCorePlugin.getDefault().getPreferenceStore();
		if (dontShowButton.getSelection()) {
			// User just toggled the "don't show option"
			if (MessageDialog.openQuestion(getShell(), "Confirm change",
					"This results dialog will be hidden in the future.  "
							+ "You can restore it by going to the \"OSATE > Instantiation\" preference pane.  "
							+ "Do you wish to make this change?")) {
				prefs.setValue(OsateCorePlugin.ALWAYS_SHOW_INSTANTIATION_AADL_DIALOG, false);
			}
		}
		prefs.setValue(OsateCorePlugin.ONLY_INSTANTIATE_SYSTEM_IMPLS, systemsOnlyButton.getSelection());
		if (prefs.needsSaving()) {
			final Job saveJob = Job.create("Save preferences", monitor -> {
				try {
					((IPersistentPreferenceStore) prefs).save();
				} catch (final IOException e) {
					Display.getDefault().asyncExec(() -> {
						MessageDialog.openError(getShell(), "Error",
								"There was a problem saving the preferences: " + e.getMessage());
					});
				}
			});
			saveJob.schedule();
		}

		super.okPressed();
	}
}
