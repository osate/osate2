package org.osate.ge.internal.selection;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.osate.aadl2.NamedElement;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.ui.util.SelectionUtil;
import org.osate.ge.internal.ui.xtext.AgeXtextUtil;
import org.osate.xtext.aadl2.ui.propertyview.IAadlPropertySource;
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
			final AadlModificationService modificationService = context.get(AadlModificationService.class);
			if (modificationService == null) {
				return null;
			}

			return adapterType
					.cast(new AgeBusinessObjectSelection(SelectionUtil.getSelectedBusinessObjectContexts(selection),
							modificationService));
		} else if (IAadlPropertySource.class.equals(adapterType) && adaptableObject instanceof IStructuredSelection) {
			final IStructuredSelection ss = (IStructuredSelection) adaptableObject;
			if (ss.getFirstElement() instanceof DiagramElement) {
				final DiagramElement de = (DiagramElement) ss.getFirstElement();
				// If the business object is an AADL Named Element
				if (de.getBusinessObject() instanceof NamedElement) {
					final NamedElement namedElement = (NamedElement) de.getBusinessObject();
					return adapterType.cast(new IAadlPropertySource() {
						private final IXtextDocument document = AgeXtextUtil
								.getDocumentByRootElement(namedElement.getElementRoot());
						private final NamedElement element = namedElement;

						@Override
						public IXtextDocument getDocument() {
							return document;
						}

						@Override
						public NamedElement getNamedElement() {
							return element;
						}
					});
				}
			}
		}

		return null;
	}

	@Override
	public Class<?>[] getAdapterList() {
		return new Class[] { IAadlPropertySource.class, BusinessObjectSelection.class };
	}

}
