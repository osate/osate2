package org.osate.ge.ba;

import java.util.Optional;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.NamedElement;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.ba.util.BehaviorAnnexSelectionUtil;
import org.osate.xtext.aadl2.ui.propertyview.IAadlPropertySource;

public class SelectionAdapterFactory implements IAdapterFactory {
	@Override
	public <T> T getAdapter(final Object adaptableObject, final Class<T> adapterType) {
		final ISelection selection = (ISelection) adaptableObject;
		System.err.println(adaptableObject + " adaptableObject");
		System.err.println(adapterType + " adapterType");
		System.err.println(selection + " selection");
		if (BusinessObjectSelection.class.equals(adapterType)) {
//			final Bundle bundle = FrameworkUtil.getBundle(getClass());
//			final IEclipseContext context = EclipseContextFactory.getServiceContext(bundle.getBundleContext());
//			final AadlModificationService modificationService = context.get(AadlModificationService.class);
//			if (modificationService == null) {
//				return null;
//			}
//
//			return adapterType.cast(new UiBusinessObjectSelection(
//					SelectionUtil.getSelectedBusinessObjectContexts(selection), modificationService));
		} else if (IAadlPropertySource.class.equals(adapterType) && adaptableObject instanceof IStructuredSelection) {
			System.err.println("AAA");
			// final IStructuredSelection ss = (IStructuredSelection) adaptableObject;
//			if (ss.getFirstElement() instanceof DiagramElement) {
//				final DiagramElement de = (DiagramElement) ss.getFirstElement();
//				// If the business object is an AADL Named Element
//				if (de.getBusinessObject() instanceof NamedElement) {
//					final NamedElement namedElement = (NamedElement) de.getBusinessObject();
//					return adapterType.cast(new IAadlPropertySource() {
//						private final IXtextDocument document = AgeXtextUtil
//								.getDocumentByRootElement(namedElement.getElementRoot());
//						private final NamedElement element = namedElement;
//
//						@Override
//						public IXtextDocument getDocument() {
//							return document;
//						}
//
//						@Override
//						public NamedElement getNamedElement() {
//							return element;
//						}
//					});
//				}
//			}
		} else if (EObject.class.equals(adapterType) && adaptableObject instanceof TextSelection) { // TODO combine this with the other
			// .class.equals above this
			final XtextEditor activeEditor = getActiveXtextEditor().orElse(null);
			if (activeEditor != null && activeEditor.getSelectionProvider() != null) {
				final EObject selectedObject = BehaviorAnnexSelectionUtil
						.getEObjectFromSelection(activeEditor, activeEditor.getSelectionProvider().getSelection());

				System.err.println(selectedObject + " selectedObject");
				if (selectedObject instanceof NamedElement) {
					System.err.println("AAADFDFD");
					final NamedElement namedElement;
					if ((NamedElement) selectedObject instanceof DefaultAnnexSubclause) {
						namedElement = ((DefaultAnnexSubclause) (NamedElement) selectedObject)
								.getParsedAnnexSubclause();
					} else {
						namedElement = (NamedElement) selectedObject;
					}

					if (namedElement instanceof BehaviorAnnex) {
						// This cast is useless
						System.err.println("AAAACast");
						return adapterType.cast(selectedObject);
					}
				}
			}
		}

		return null;
	}

	private static Optional<XtextEditor> getActiveXtextEditor() {
		return BehaviorAnnexSelectionUtil.getActiveEditor()
				.map(editor -> editor instanceof XtextEditor ? (XtextEditor) editor : null);
	}

	@Override
	public Class<?>[] getAdapterList() {
		return new Class[] { EObject.class };
	}
}