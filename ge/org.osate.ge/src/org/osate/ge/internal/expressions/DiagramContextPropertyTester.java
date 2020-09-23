package org.osate.ge.internal.expressions;

import java.util.Optional;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.osate.ge.internal.ui.util.SelectionUtil;
import org.osate.ge.internal.ui.util.UiUtil;

public class DiagramContextPropertyTester extends PropertyTester {
	@Override
	public boolean test(final Object receiver, final String property, final Object[] args, final Object expectedValue) {
//		IAadlPropertySource source = (IAadlPropertySource) receiver;
//		System.err.println(source + " source");
//		if ("isDiagramContext".equals(property)) {
//			System.err.println(receiver + " receiver");
//			System.err.println(property + " property");
//			System.err.println(args + " args");
//			System.err.println(expectedValue + " expectedValue");
//			EObject element = source.getNamedElement();
//			while (element != null) {
//				System.err.println(element.getClass().getSimpleName() + " getSimplename");
//				System.err.println(element.getClass().getSuperclass() + " superClass");
//				System.err.println(element.getClass().getCanonicalName() + " cann");
//				System.err.println(element.getClass().getTypeName() + " typeName");
//				for (Class<?> a : element.getClass().getInterfaces()) {
//					if (expectedValue.equals(a.getSimpleName())) {
//						System.err.println("RETURN TRUE");
//						return true;
//					}
//				}
//
//				if (element instanceof Classifier || element instanceof PackageSection
//						|| element instanceof AadlPackage) {
//					System.err.println("TRUE HERE");
//					return true;
//				}
//
//				element = element.eContainer();
//			}
//		}
		System.err.println(property + " propertyBBBBB");
		if ("isDiagramContext".equals(property)) {
			System.err.println(receiver + " receiver");
			// if (receiver instanceof Behaviorann) {
			return getActiveXtextEditor().map(xtextEditor -> {
				final ISelectionProvider selectionProvider = xtextEditor.getSelectionProvider();
				if (selectionProvider == null) {
					return false;
				}

				EObject eObj = SelectionUtil.getEObjectFromSelection(xtextEditor,
						selectionProvider.getSelection());
//				if (eObj instanceof DefaultAnnexSubclause) {
//					eObj = ((DefaultAnnexSubclause) eObj).getParsedAnnexSubclause();
//				}
//
//				if (eObj != null) {
//					System.err.println(eObj.getClass() + " getClass");
//					System.err.println(eObj.eClass() + " eClass");
//					System.err.println(eObj.getClass().getSimpleName() + " simpleName");
//					if (eObj.getClass().getSimpleName().equals("BehaviorAnnexImpl")) {
//						return true;
//					}
//				}

				System.err.println(eObj + " eobj");

				return receiver.equals(eObj);
				// return BehaviorAnnexSelectionUtil.getDiagramContext(selectionProvider.getSelection(), xtextEditor).isPresent();
			}).orElse(false);
			// } else {
			// return BehaviorAnnexSelectionUtil.getActiveEditor()
			// .map(activeEditor -> BehaviorAnnexSelectionUtil.getDiagramContext((ISelection) receiver, activeEditor).orElse(null))
			// .isPresent();
			// }
		}

		return false;
	}

	private static Optional<XtextEditor> getActiveXtextEditor() {
		return UiUtil.getActiveEditor().map(editor -> editor instanceof XtextEditor ? (XtextEditor) editor : null);
	}
}
