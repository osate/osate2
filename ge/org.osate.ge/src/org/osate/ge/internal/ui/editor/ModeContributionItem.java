/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.ui.editor;

import java.util.Optional;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Stream;

import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorPart;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.ui.util.UiUtil;
import org.osate.ge.internal.util.AadlClassifierUtil;
import org.osate.ge.internal.util.AadlModalElementUtil;
import org.osate.ge.internal.util.AadlModalElementUtil.ModeFeatureReference;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public class ModeContributionItem extends ComboContributionItem {
	private static final String emptySelectionTxt = "<Modes>";
	private static final String selectedModePropertyKey = "org.osate.ge.ui.editor.selectedMode";
	private static final StandaloneQuery modeContainerQuery = StandaloneQuery.create((rootQuery) -> rootQuery
			.descendants().filter((fa) -> fa.getBusinessObject() instanceof ComponentImplementation
					|| fa.getBusinessObject() instanceof Subcomponent));
	private AgeDiagramEditor editor;

	public ModeContributionItem(final String id) {
		super(id);
	}

	@Override
	public boolean isDynamic() {
		return true;
	}

	public final void setActiveEditor(final IEditorPart newEditor) {
		if (editor != newEditor) {
			saveModeSelection();

			// Update the editor
			if (newEditor instanceof AgeDiagramEditor) {
				this.editor = (AgeDiagramEditor) newEditor;
			} else {
				this.editor = null;
			}

			refresh();
		}
	}

	@Override
	protected void onControlDisposed() {
		saveModeSelection();
		super.onControlDisposed();
	}

	private void saveModeSelection() {
		// Save the current mode selection
		final ComboViewer comboViewer = getComboViewer();
		if (comboViewer != null && editor != null) {
			final Object firstSelection = comboViewer.getStructuredSelection().getFirstElement();
			final ModeFeatureReference mf = (ModeFeatureReference) firstSelection;
			final String selectionStr = firstSelection != null ? (String) mf.getName() : null;
			editor.setPartProperty(selectedModePropertyKey, selectionStr);
		}
	}

	@Override
	protected Control createControl(final Composite parent) {
		final Control control = super.createControl(parent);
		refresh(); // Populate the combo box
		return control;
	}

	private void refresh() {
		final ComboViewer comboViewer = getComboViewer();
		final SortedSet<ModeFeatureReference> modeFeatureReferences = new TreeSet<>(
				(o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
		if (comboViewer != null) {
			final ModeFeatureReference nullValue = AadlModalElementUtil.createModeFeatureReference(getNullValueString(),
					null, null);
			modeFeatureReferences.add(nullValue);
			Object selectedValue = nullValue;
			final String selectedModeName = editor == null ? null : editor.getPartProperty(selectedModePropertyKey);

			// Clear the combo box
			comboViewer.setInput(null);

			if (editor == null) {
				return;
			}

			final AgeDiagram diagram = editor.getAgeDiagram();
			if (diagram != null) {
				final QueryService queryService = ContributionHelper.getQueryService(editor);
				if (queryService != null) {
					queryService.getResults(modeContainerQuery, diagram).stream().flatMap(modeContainer -> {
						// If container contains a modal element
						if (AadlModalElementUtil.getModalElement(modeContainer) != null) {
							// Get qualified modes to add to the drop-down
							return Stream.concat(getModeBindingFeatureReferences((DiagramNode) modeContainer),
									getModeFeatureReferences((DiagramNode) modeContainer));
						}

						return Stream.empty();
					}).forEach(modeFeatureRef -> {
						modeFeatureReferences.add(modeFeatureRef);
					});

// Find ComboViewer selection
					final Optional<ModeFeatureReference> tmpSelectedValue = modeFeatureReferences.stream()
							.filter(tmpKey -> tmpKey.getName().equalsIgnoreCase(selectedModeName))
							.findAny();
					if (tmpSelectedValue.isPresent()) {
						selectedValue = tmpSelectedValue.get();
					}

					comboViewer.setLabelProvider(new LabelProvider() {
						@Override
						public String getText(final Object element) {
							final ModeFeatureReference mf = (ModeFeatureReference) element;
							return mf.getName();
						}
					});

					comboViewer.setInput(modeFeatureReferences);
				}
			}

			comboViewer.setSelection(new StructuredSelection(selectedValue));
		}
	}

	/**
	 * Return a stream of mode feature references that will be added to the drop-down
	 * @param modeContainer
	 * @return
	 */
	private static Stream<ModeFeatureReference> getModeFeatureReferences(final DiagramNode modeContainer) {
		return AadlClassifierUtil.getComponentImplementation(modeContainer)
				.filter(ci -> !ci.getAllModes().isEmpty() || !ci.getAllModeTransitions().isEmpty()).map(ci -> {
					return Stream.concat(ci.getAllModes().stream(), ci.getAllModeTransitions().stream());
				}).orElse(Stream.empty()).map(ob -> {
					final NamedElement ne = ob;
					return createInModeFeatureReference(modeContainer, ne);
				});
	}

	/**
	 * Return a stream of ModeBindings that are mapped to a derived Mode
	 * @param modeContainerParent
	 * @return
	 */
	public static Stream<ModeFeatureReference> getModeBindingFeatureReferences(final DiagramNode modeContainerParent) {
		if (modeContainerParent.getBusinessObject() instanceof Subcomponent) {
			final Subcomponent subcomponent = (Subcomponent) modeContainerParent.getBusinessObject();
			// Filter ModeBindings that have a null derived mode
			return subcomponent.getOwnedModeBindings().stream().filter(mb -> mb.getDerivedMode() != null)
					.map(mb -> createInModeFeatureReference(modeContainerParent, mb.getDerivedMode()));
		}
		return Stream.empty();
	}

	private static ModeFeatureReference createInModeFeatureReference(final DiagramNode parent,
			final NamedElement namedElement) {
		final String modeFeatureName = UiUtil.getPathLabel(parent) + "::" + namedElement.getName();
		return AadlModalElementUtil.createModeFeatureReference(modeFeatureName, namedElement, parent);
	}

	@Override
	protected void onSelection(final Object value) {
		final ModeFeatureReference mf = (ModeFeatureReference) value;
		ContributionHelper.getColoringService(editor).setHighlightedMode(mf.getNamedElement(), mf.getContainer());
	}

	@Override
	protected String getNullValueString() {
		return emptySelectionTxt;
	}
}
