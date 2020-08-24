package org.osate.ge.ba.handlers;

import java.util.List;
import java.util.function.Function;

import org.eclipse.ui.IEditorPart;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.ba.util.SelectionUtil;

public class BehaviorAnnexHandlerUtil {
	private BehaviorAnnexHandlerUtil() {
	}

	final static Function<Object, Element> findDiagramContextForSelectedObject = (element) -> {
		if ((element instanceof DefaultAnnexSubclause || element instanceof BehaviorAnnex)
				&& "behavior_specification".equalsIgnoreCase(((NamedElement) element).getName())) {
			return (DefaultAnnexSubclause) element;
		}

		return null;
	};

	static Element getAnnexSubclause(final IEditorPart activeEditor) {
		if (activeEditor instanceof XtextEditor) {
			return (Element) SelectionUtil.getDiagramContext(SelectionUtil.getCurrentSelection(), activeEditor,
					findDiagramContextForSelectedObject);
		} else {
			final List<BusinessObjectContext> selectedBusinessObjectContexts = SelectionUtil
					.getSelectedBusinessObjectContexts();
			if (selectedBusinessObjectContexts.size() != 1) {
				throw new RuntimeException("Invalid number of elements selected");
			}

			final Object selectedBo = selectedBusinessObjectContexts.get(0).getBusinessObject();
			return selectedBo instanceof BehaviorAnnex ? (Element) selectedBo : null;
		}
	}

	static String getFileName(final Classifier classifier, Element annexSubclause) {
		if (annexSubclause instanceof BehaviorAnnex) {
			annexSubclause = annexSubclause.getOwner();
		}

		final StringBuilder fileName = new StringBuilder(classifier.getQualifiedName().replaceAll("::|:|\\.", "_"));
		fileName.append("_behavior_");
		return fileName.append(classifier.getOwnedAnnexSubclauses().indexOf(annexSubclause)).toString();
	}
}
