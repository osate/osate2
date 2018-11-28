package org.osate.analysis.architecture.unusedclassifiers;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonMenuConstants;

public class FindUnusedClassifiersActionProvider extends CommonActionProvider {
	private final Action findUnusedClassifiersAction;

	public FindUnusedClassifiersActionProvider() {
		findUnusedClassifiersAction = new Action() {
			{
				setText("Find Unused Classifiers in Package");
				setToolTipText("Find all the classifiers in the package that have no references");
			}

			@Override
			public void run() {
				FindUnusedClassifiersAnalysis.INSTANCE
						.doIt(getActionSite().getStructuredViewer().getStructuredSelection().toArray());
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