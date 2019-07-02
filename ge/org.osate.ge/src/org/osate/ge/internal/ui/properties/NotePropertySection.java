package org.osate.ge.internal.ui.properties;

import java.util.Objects;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.model.Note;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;
import org.osate.ge.internal.ui.util.UiUtil;
import org.osate.ge.internal.util.DiagramElementUtil;
import org.osate.ge.ui.properties.PropertySectionUtil;

public class NotePropertySection extends AbstractPropertySection {
	public static class Filter implements IFilter {
		@Override
		public boolean select(final Object toTest) {
			return Adapters.adapt(toTest, DiagramElement.class) != null
					&& PropertySectionUtil.isBoCompatible(toTest, Note.class::isInstance);
		}
	}

	private DiagramElement selectedDiagramElement;
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

		noteField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				// Update the embedded business object
				final Note note = getNote();
				if (note != null && !Objects.equals(note.getText(), noteField.getText())) {
					final Note newNote = new Note(note.getId(), noteField.getText());
					final AgeDiagram diagram = DiagramElementUtil.getDiagram(selectedDiagramElement);
					diagram.modify("Modify Note", m -> {
						m.updateBusinessObjectWithSameRelativeReference(selectedDiagramElement, newNote);
					});

					// For the diagram updater to be executed. This is requires for the diagram element's label to be update.
					// Ideally this would be performed automatically but for now, it is not executed since we have not performed an AADL model change.
					final AgeDiagramEditor editor = UiUtil.getActiveDiagramEditor();
					if (editor != null && !editor.isDisposed()) {
						final IDiagramTypeProvider dtp = editor.getDiagramTypeProvider();
						if (dtp != null) {
							final IFeatureProvider fp = dtp.getFeatureProvider();
							if (fp != null) {
								final IUpdateContext updateCtx = new UpdateContext(
										editor.getGraphitiAgeDiagram().getGraphitiDiagram());
								editor.getDiagramBehavior().executeFeature(fp.getUpdateFeature(updateCtx), updateCtx);
							}
						}
					}
				}
			}
		});
	}

	@Override
	public void setInput(final IWorkbenchPart part, final ISelection selection) {
		super.setInput(part, selection);

		// Store the selected diagram element
		DiagramElement newSelectedElement = null;
		if (selection instanceof IStructuredSelection) {
			final IStructuredSelection ss = (IStructuredSelection) selection;
			if (ss.size() == 1) {
				newSelectedElement = Adapters.adapt(ss.getFirstElement(), DiagramElement.class);
			}
		}

		selectedDiagramElement = newSelectedElement;
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
		final Object bo = selectedDiagramElement == null ? null : selectedDiagramElement.getBusinessObject();
		return bo instanceof Note ? (Note) bo : null;
	}
}
