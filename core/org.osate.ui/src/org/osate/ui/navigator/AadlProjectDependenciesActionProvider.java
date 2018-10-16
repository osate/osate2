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
				setText("Edit Referenced Projects...");
				setToolTipText("Open the project references property page.");
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
					} else if (selection instanceof VirtualProjectNode) {
						project = ((VirtualProjectNode) selection).getParent().getProject();
					}
					if (project != null) {
						PreferencesUtil.createPropertyDialogOn(getActionSite().getViewSite().getShell(), project, ID,
								ID_LIST, DUMMY_DATA).open();
					}
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