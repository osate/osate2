package org.osate.ge.internal.ui.properties;

import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.internal.graphiti.diagram.GraphitiAgeDiagram;
import org.osate.ge.internal.model.Note;
import org.osate.ge.internal.services.ActionExecutor.ExecutionMode;
import org.osate.ge.internal.services.AgeAction;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;
import org.osate.ge.internal.ui.util.UiUtil;
import org.osate.ge.ui.properties.PropertySectionUtil;

public class NotePropertySection extends AbstractPropertySection {
	public static class Filter implements IFilter {
		@Override
		public boolean select(final Object toTest) {
			return PropertySectionUtil.isBoCompatible(toTest, Note.class::isInstance);
		}
	}

	private BusinessObjectContext selectedBoc;
	private Text noteField;
	private Button saveBtn;

	@Override
	public boolean shouldUseExtraSpace() {
		return true;
	}

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		final Composite composite = getWidgetFactory().createPlainComposite(parent, SWT.NONE);
		composite.setLayout(GridLayoutFactory.swtDefaults().numColumns(1).create());

		noteField = getWidgetFactory().createText(composite, "", SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
		noteField.setLayoutData(GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true)
				.hint(100, 100).create());

		// Create the button that will update the diagram. This button won't actually do anything because the diagram is updated when the focus is lost.
		// However, it is useful to have it so that the user can easily see the result of the change without without having to change property tabs/selection.
		saveBtn = getWidgetFactory().createButton(composite, "Save", SWT.PUSH);

		noteField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				final Note note = getNote();
				final AgeDiagramEditor editor = UiUtil.getActiveDiagramEditor();

				if (note != null && editor != null && !editor.isDisposed()
						&& !Objects.equals(note.getText(), noteField.getText())) {
					editor.getActionExecutor().execute("Modify Note", ExecutionMode.NORMAL,
							new SetNoteAction(selectedBoc, editor, noteField.getText(), false));
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
			}
		});
	}

	@Override
	public void setInput(final IWorkbenchPart part, final ISelection selection) {
		super.setInput(part, selection);
		final BusinessObjectSelection selectedBos = Adapters.adapt(selection, BusinessObjectSelection.class);
		final List<BusinessObjectContext> bocs = selectedBos.bocStream().collect(Collectors.toList());
		selectedBoc = bocs.size() == 1 ? bocs.get(0) : null;
	}

	@Override
	public void refresh() {
		// Update the note field
		final Note note = getNote();
		noteField.setEnabled(note != null);
		saveBtn.setEnabled(note != null);
		noteField.setText(note == null ? "" : note.getText());
	}

	private Note getNote() {
		final Object bo = selectedBoc.getBusinessObject();
		return bo instanceof Note ? (Note) bo : null;
	}

	private static class SetNoteAction implements AgeAction {
		private final BusinessObjectContext boc;
		private final WeakReference<AgeDiagramEditor> weakEditor;
		private final String newText;
		private final boolean isUndoOrRedo;

		public SetNoteAction(final BusinessObjectContext boc, final AgeDiagramEditor editor, final String newText,
				final boolean isUndoOrRedo) {
			this.boc = Objects.requireNonNull(boc, "boc must not be null");
			this.weakEditor = new WeakReference<>(Objects.requireNonNull(editor, "editor must not be null"));
			this.newText = newText;
			this.isUndoOrRedo = isUndoOrRedo;
		}

		@Override
		public AgeAction execute() {
			final Object bo = boc.getBusinessObject();
			if(!(bo instanceof Note)) {
				return null;
			}

			final AgeDiagramEditor editor = weakEditor.get();
			if (editor == null || editor.isDisposed()) {
				return null;
			}

			final Note note = (Note) bo;
			final String originalText = note.getText();
			note.setText(newText);

			// Just refresh the diagram if an undo or a redo is being performed.
			if (isUndoOrRedo) {
				// Refresh the editor
				editor.setPictogramElementsForSelection(editor.getDiagramBehavior().getSelectedPictogramElements());
				editor.getDiagramBehavior().refresh();
			} else {
				// Otherwise, update the diagram. Run this asynchronously otherwise there can be exceptions when losing focus and switching property tabs at the
				// same time.
				Display.getDefault().asyncExec(() -> {
					if (editor.isDisposed()) {
						return;
					}

					final GraphitiAgeDiagram graphitiAgeDiagram = editor.getGraphitiAgeDiagram();
					if (graphitiAgeDiagram == null) {
						return;
					}

					final org.eclipse.graphiti.mm.pictograms.Diagram graphitiDiagram = editor.getGraphitiAgeDiagram()
							.getGraphitiDiagram();
					if (graphitiDiagram == null) {
						return;
					}

					final IDiagramTypeProvider dtp = editor.getDiagramTypeProvider();
					if (dtp == null) {
						return;
					}

					final IFeatureProvider fp = dtp.getFeatureProvider();
					if (fp == null) {
						return;
					}

					final IUpdateContext uc = new UpdateContext(graphitiDiagram);
					final IUpdateFeature updateFeature = fp.getUpdateFeature(uc);
					if (updateFeature == null) {
						throw new RuntimeException("Unable to retrieve update feature for diagram");
					}

					updateFeature.update(uc);
				});
			}

			return new SetNoteAction(boc, editor, originalText, true);
		}

	};
}
