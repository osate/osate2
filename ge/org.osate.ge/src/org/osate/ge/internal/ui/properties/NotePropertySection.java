/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
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
import org.osate.ge.internal.ui.util.InternalPropertySectionUtil;
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

		InternalPropertySectionUtil.setPropertiesHelp(aTabbedPropertySheetPage.getControl());
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
