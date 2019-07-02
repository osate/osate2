package org.osate.internal.ui.properties;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.jface.preference.IPreferenceNode;
import org.eclipse.jface.preference.IPreferencePage;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.jface.preference.PreferenceManager;
import org.eclipse.jface.preference.PreferenceNode;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.PropertyPage;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.core.OsateCorePlugin;
import org.osate.internal.ui.preferences.InstantiationPreferencePage;
import org.osate.ui.OsateUiPlugin;
import org.osgi.service.prefs.BackingStoreException;
import org.osgi.service.prefs.Preferences;

/* NB: The parts of this that synchronized behavior between project properties
 * and workspace preferences are based on the web page
 * <http://www.eclipse.org/articles/Article-Mutatis-mutandis/overlay-pages.html>
 */
public class InstantiationPropertyPage extends PropertyPage {
	private static String BAD_VALUE = "Must be an integer >= 1";

	private Text maxSOMText;
	private Preferences preferences;
	private boolean isValid;

	Button useWorkspaceSettingsButton;
	Button useProjectSettingsButton;
	Button configureButton;

	@Override
	protected Control createContents(final Composite parent) {
		// Get the project
		IProject project = Adapters.adapt(getElement(), IProject.class);
		if (project == null) {
			IResource resource = Adapters.adapt(getElement(), IResource.class);
			Assert.isNotNull(resource, "unable to adapt element to a project"); //$NON-NLS-1$
			project = resource.getProject();
		}

		// Get the project's preferences
		final IScopeContext context = new ProjectScope(project);
		preferences = context.getNode(InstantiateModel.PREFS_QUALIFIER);
		isValid = true;

		// Create the overall composite to fill up
		final Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));

		// Create the buttons for choosing between workspace and project preferences
		final Composite selectionGroup = new Composite(composite, SWT.NONE);
		final GridLayout sgLayout = new GridLayout(2, false);
		sgLayout.marginHeight = 0;
		sgLayout.marginWidth = 0;
		selectionGroup.setLayout(sgLayout);
		selectionGroup.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 2, 1));

		final Composite radioGroup = new Composite(selectionGroup, SWT.NONE);
		radioGroup.setLayout(new GridLayout());
		radioGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		useWorkspaceSettingsButton = new Button(radioGroup, SWT.RADIO);
		useWorkspaceSettingsButton.setText("Use workspace settings");

		useProjectSettingsButton = new Button(radioGroup, SWT.RADIO);
		useProjectSettingsButton.setText("Use project settings");

		configureButton = new Button(selectionGroup, SWT.PUSH);
		configureButton.setText("Configure Workspace Settings ...");

		// Create the actual property field that we want to edit
		final Label label = new Label(composite, SWT.NONE);
		label.setText("Maximum number of system operation modes to generate:");
		label.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false, 1, 1));

		maxSOMText = new Text(composite, SWT.BORDER);
		maxSOMText.setText(Integer.toString(getSOMLimit()));
		maxSOMText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		// Configure button status
		if (useWorkspacePreferences()) {
			useWorkspaceSettingsButton.setSelection(true);
			useProjectSettingsButton.setSelection(false);
			configureButton.setEnabled(true);
			maxSOMText.setEnabled(false);
		} else {
			useWorkspaceSettingsButton.setSelection(false);
			useProjectSettingsButton.setSelection(true);
			configureButton.setEnabled(false);
			maxSOMText.setEnabled(true);
		}

		// Add listeners
		useWorkspaceSettingsButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				configureButton.setEnabled(true);
				maxSOMText.setEnabled(false);
			}
		});
		useProjectSettingsButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				configureButton.setEnabled(false);
				maxSOMText.setEnabled(true);
			}
		});
		configureButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				configureWorkspaceSettings();
			}
		});

		final Text localText = maxSOMText;
		maxSOMText.addModifyListener(event -> {
			final String s = localText.getText();
			try {
				final int v = Integer.parseInt(s);
				if (v < 1) {
					enterErrorState();
				} else {
					clearErrorState();
				}
			} catch (final NumberFormatException e) {
				enterErrorState();
			}
		});

		// return the whole thing
		return composite;
	}

	private int getSOMLimit() {
		return preferences.getInt(InstantiateModel.PREF_SOM_LIMIT, OsateCorePlugin.getDefault().getSOMLimit());
	}

	private boolean useWorkspacePreferences() {
		return preferences.getBoolean(InstantiateModel.PREF_SOM_USE_WORKSPACE, true);
	}

	private void enterErrorState() {
		isValid = false;
		setErrorMessage(BAD_VALUE);
	}

	private void clearErrorState() {
		isValid = true;
		setErrorMessage(null);
	}

	@Override
	public boolean performOk() {
		if (isValid) {
			preferences.putInt(InstantiateModel.PREF_SOM_LIMIT, Integer.parseInt(maxSOMText.getText()));
			preferences.putBoolean(InstantiateModel.PREF_SOM_USE_WORKSPACE, useWorkspaceSettingsButton.getSelection());
			try {
				preferences.flush();
			} catch (final BackingStoreException e) {
				OsateUiPlugin.log(e);
			}

			return true;
		} else {
			return false;
		}
	}

	@Override
	protected void performDefaults() {
		maxSOMText.setText(Integer.toString(OsateCorePlugin.getDefault().getSOMLimit()));

		useWorkspaceSettingsButton.setSelection(true);
		useProjectSettingsButton.setSelection(false);
		configureButton.setEnabled(true);
		maxSOMText.setEnabled(false);

		// Why? Because the default implementation does this
		updateApplyButton();
	}

	private void configureWorkspaceSettings() {
		final IPreferencePage page = new InstantiationPreferencePage();
		page.setTitle(getTitle());
		final IPreferenceNode targetNode = new PreferenceNode("org.osate.ui.preferences.OsateInstantiationPage", page);
		final PreferenceManager manager = new PreferenceManager();
		manager.addToRoot(targetNode);
		final PreferenceDialog dialog = new PreferenceDialog(getControl().getShell(), manager);
		BusyIndicator.showWhile(getControl().getDisplay(), () -> {
			dialog.create();
			dialog.setMessage(targetNode.getLabelText());
			dialog.open();
		});
	}
}
