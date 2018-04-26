package org.osate.ge.internal.ui.wizards;

import java.util.Objects;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IExecutableExtensionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.osate.ge.internal.services.DiagramService;
import org.osate.ge.internal.services.ExtensionRegistryService;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

public class NewDiagramWizardFactory implements IExecutableExtensionFactory {
	@Override
	public Object create() throws CoreException {
		final Bundle bundle = FrameworkUtil.getBundle(getClass());
		final IEclipseContext context = EclipseContextFactory.getServiceContext(bundle.getBundleContext());
		return new NewDiagramWizard(Objects.requireNonNull(context.get(ExtensionRegistryService.class),
				"Unable to retrieve extension registry service"),
				Objects.requireNonNull(context.get(DiagramService.class), "Unable to retrieve diagram service"));
	}
}