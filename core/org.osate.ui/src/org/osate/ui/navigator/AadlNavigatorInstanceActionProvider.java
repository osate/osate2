package org.osate.ui.navigator;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionConstants;
import org.eclipse.ui.navigator.ICommonMenuConstants;
import org.osate.aadl2.Element;
import org.osate.ui.UiUtil;

public class AadlNavigatorInstanceActionProvider extends CommonActionProvider {
	private final Action openFileAction;

	public AadlNavigatorInstanceActionProvider() {
		openFileAction = new Action() {
			{
				setText("&Open");
				setToolTipText("Open in an AADL Instance editor");
			}

			@Override
			public void run() {
				Object[] selectedElements = getActionSite().getStructuredViewer().getStructuredSelection().toArray();
				for (Object selected : selectedElements) {
					if (selected instanceof Element) {
						UiUtil.openEditorToElement((Element) selected);
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

		if (openFileAction.isEnabled()) {
			aMenu.insertAfter(ICommonMenuConstants.GROUP_OPEN, openFileAction);
		}
	}

	@Override
	public void fillActionBars(IActionBars actionBars) {
		super.fillActionBars(actionBars);
		actionBars.setGlobalActionHandler(ICommonActionConstants.OPEN, openFileAction);
	}
}