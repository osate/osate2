package org.osate.ge.ba.util;

import java.util.Objects;
import java.util.Optional;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.osate.aadl2.Abstract;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ba.aadlba.BehaviorState;

public class BehaviorAnnexHandlerUtil {
	private BehaviorAnnexHandlerUtil() {
	}

	/**
	 * Retrieves the diagram context for the selected behavior diagram elements
	 * Will return empty if the selected element is not a behavior diagram element
	 */
	public static Optional<DefaultAnnexSubclause> getBehaviorAnnexDiagramContext(final IEditorPart activeEditor) {
		final ISelection selection = Objects.requireNonNull(SelectionUtil.getCurrentSelection(),
				"ISelection cannot be null");
		return SelectionUtil.getDiagramContext(selection, activeEditor);
	}

	/**
	 * Creates the file name for the behavior annex diagram
	 */
	public static String getFileName(final Classifier classifier, final DefaultAnnexSubclause annexSubclause) {
		final StringBuilder fileName = new StringBuilder(classifier.getQualifiedName().replaceAll("::|:|\\.", "_"));
		fileName.append("_behavior_");
		return fileName.append(classifier.getOwnedAnnexSubclauses().indexOf(annexSubclause)).toString();
	}

	/**
	 * Determine if behavior annex must have a final state.
	 * Note: If final is not set and it is required, an error occurs that causes diagram elements to disappear
	 * @return whether the behavior annex requires a final state
	 */
	public static boolean requiresFinalState(final BehaviorAnnex ba) {
		// Determine if the behavior annex needs a final state based on the containing classifier
		final Classifier classifier = ba.getContainingClassifier();
		return !(classifier instanceof Abstract || classifier instanceof org.osate.aadl2.System)
				&& !ba.getStates().stream().filter(BehaviorState::isFinal).findAny().isPresent();
	}
}
