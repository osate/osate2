package org.osate.ge.ba;

import java.util.Optional;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.osate.ge.ba.util.SelectionUtil;

public class BehaviorAnnexPropertyTester extends PropertyTester {
	@Override
	public boolean test(final Object receiver, final String property, final Object[] args, final Object expectedValue) {
		if ("isBehaviorAnnexContext".equals(property)) {
			if (receiver instanceof ITextSelection) {
				return getActiveXtextEditor().map(xtextEditor -> {
					final ISelectionProvider selectionProvider = xtextEditor.getSelectionProvider();
					if (selectionProvider == null) {
						return false;
					}

					return SelectionUtil.getDiagramContext(selectionProvider.getSelection(), xtextEditor).isPresent();
				}).orElse(false);
			} else {
				return SelectionUtil.getActiveEditor()
						.map(activeEditor -> SelectionUtil.getDiagramContext((ISelection) receiver, activeEditor).orElse(null))
						.isPresent();
			}
		}

		return false;
	}

	private static Optional<XtextEditor> getActiveXtextEditor() {
		return SelectionUtil.getActiveEditor()
				.map(editor -> editor instanceof XtextEditor ? (XtextEditor) editor : null);
	}
}
