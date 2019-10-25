package org.osate.alisa2.view;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;

/**
 * Sirius only initializes some variables if it thinks you use them, but its
 * possible to use them in ways it doesn't detect. This class does nothing,
 * but its existence triggers Sirius's initialization of whatever variables
 * are created as part of the associated action.
 *
 * @author sprocter
 *
 */
public class ForceVariableInitializationAction implements IExternalJavaAction {

	@Override
	public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
		// Do literally nothing
	}

	@Override
	public boolean canExecute(Collection<? extends EObject> selections) {
		// Since this isn't shown to the user, it's unclear if this is necessary
		return true;
	}

}
