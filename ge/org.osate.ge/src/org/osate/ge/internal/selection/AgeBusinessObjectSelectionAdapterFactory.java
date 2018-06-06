package org.osate.ge.internal.selection;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.jface.viewers.ISelection;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.ui.util.SelectionUtil;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

// Only supports adaptable objects of type ISelection
public class AgeBusinessObjectSelectionAdapterFactory implements IAdapterFactory {
	@Override
	public <T> T getAdapter(final Object adaptableObject, final Class<T> adapterType) {
		final ISelection selection = (ISelection)adaptableObject;

		if (BusinessObjectSelection.class.equals(adapterType)) {
			final Bundle bundle = FrameworkUtil.getBundle(getClass());
			final IEclipseContext context = EclipseContextFactory.getServiceContext(bundle.getBundleContext());
			return adapterType
					.cast(new AgeBusinessObjectSelection(SelectionUtil.getSelectedBusinessObjectContexts(selection),
							context.get(AadlModificationService.class)));
		}

		return null;
	}

	@Override
	public Class<?>[] getAdapterList() {
		return new Class[] { BusinessObjectSelection.class };
	}

}
