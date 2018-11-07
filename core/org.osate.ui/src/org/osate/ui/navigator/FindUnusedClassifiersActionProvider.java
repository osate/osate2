package org.osate.ui.navigator;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonMenuConstants;

public class FindUnusedClassifiersActionProvider extends CommonActionProvider {
//	private static final String ID = "org.eclipse.ui.propertypages.project.reference";
//	private static final String[] ID_LIST = { ID };
//	private static final Object DUMMY_DATA = new Object();

	private final Action findUnusedClassifiersAction;

	public FindUnusedClassifiersActionProvider() {
		findUnusedClassifiersAction = new Action() {
			{
				setText("Find Unused Classifiers in Package");
				setToolTipText("Find all the classifiers in the package that have no references");
			}

			@Override
			public void run() {
				System.out.println("Good morning.");
//				Object[] selectedElements = getActionSite().getStructuredViewer().getStructuredSelection().toArray();
//				if (selectedElements.length == 1) {
//					final Object selection = selectedElements[0];
//					IProject project = null;
//					if (selection instanceof IProject) {
//						project = (IProject) selection;
//					}
//					if (project != null) {
//						PreferencesUtil.createPropertyDialogOn(getActionSite().getViewSite().getShell(), project, ID,
//								ID_LIST, DUMMY_DATA).open();
//					}
//				}
			}
		};
	}

	@Override
	public void fillContextMenu(final IMenuManager aMenu) {
		if (getContext().getSelection().isEmpty()) {
			return;
		}

		if (findUnusedClassifiersAction.isEnabled()) {
			aMenu.insertAfter(ICommonMenuConstants.GROUP_ADDITIONS, findUnusedClassifiersAction);
		}
	}
}