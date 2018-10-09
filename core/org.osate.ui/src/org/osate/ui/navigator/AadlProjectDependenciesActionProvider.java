package org.osate.ui.navigator;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonMenuConstants;

public class AadlProjectDependenciesActionProvider extends CommonActionProvider {
	private static final String ID = "org.eclipse.ui.propertypages.project.reference";
	private static final String[] ID_LIST = { ID };
	private static final Object DUMMY_DATA = new Object();

	private final Action editDependenciesAction;

	public AadlProjectDependenciesActionProvider() {
		editDependenciesAction = new Action() {
			{
				setText("Edit Project Dependencies...");
				setToolTipText("Open the dependencies project property page.");
			}

			@Override
			public void run() {
				Object[] selectedElements = getActionSite().getStructuredViewer().getStructuredSelection().toArray();
				if (selectedElements.length == 1) {
					final Object selection = selectedElements[0];
					IProject project = null;
					if (selection instanceof IProject) {
						project = (IProject) selection;
					} else if (selection instanceof VirtualProjectDependencies) {
						project = ((VirtualProjectDependencies) selection).getProject();
					}
					if (project != null) {
						PreferencesUtil.createPropertyDialogOn(getActionSite().getViewSite().getShell(), project, ID,
								ID_LIST, DUMMY_DATA).open();
					}
//					MessageDialog.openInformation(getActionSite().getViewSite().getShell(), "test", "Hello!");
				}
			}
		};
	}

	@Override
	public void fillContextMenu(final IMenuManager aMenu) {
		if (getContext().getSelection().isEmpty()) {
			return;
		}

		if (editDependenciesAction.isEnabled()) {
			aMenu.insertAfter(ICommonMenuConstants.GROUP_PROPERTIES, editDependenciesAction);
		}
	}
}