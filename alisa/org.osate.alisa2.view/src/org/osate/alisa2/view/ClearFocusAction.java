package org.osate.alisa2.view;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;

public class ClearFocusAction implements IExternalJavaAction {

	@Override
	public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
		FocusManager.getInstance().clearFocus();
	}

	@Override
	public boolean canExecute(Collection<? extends EObject> selections) {
		// TODO: Are there things we don't want focusable?
		return true;
	}

}