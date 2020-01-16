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
package org.osate.ge.internal.ui.editor;

import java.util.List;
import java.util.Optional;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorPart;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.ui.util.UiUtil;
import org.osate.ge.internal.util.AadlClassifierUtil;
import org.osate.ge.internal.util.AadlInstanceObjectUtil;
import org.osate.ge.internal.util.AadlModalElementUtil;
import org.osate.ge.internal.util.AadlModalElementUtil.ModeFeatureReference;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public class ModeContributionItem extends ComboContributionItem {
	private static final String emptySelectionTxt = "<Modes>";
	private static final String selectedModePropertyKey = "org.osate.ge.ui.editor.selectedMode";
	private static final StandaloneQuery modeContainerQuery = StandaloneQuery
			.create((rootQuery) -> rootQuery.descendants()
					.filter((fa) -> fa.getBusinessObject() instanceof ComponentImplementation
							|| fa.getBusinessObject() instanceof Subcomponent
							|| fa.getBusinessObject() instanceof ComponentInstance));
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
							.filter(tmpKey -> tmpKey.getName().equalsIgnoreCase(selectedModeName)).findAny();
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
		if (modeContainer.getBusinessObject() instanceof ComponentInstance) {
			return AadlInstanceObjectUtil.getComponentInstance(modeContainer)
					.filter(ci -> ci.getComponentClassifier() instanceof ComponentImplementation
							&& (!ci.getModeInstances().isEmpty() || !ci.getModeTransitionInstances().isEmpty()))
					.map(ci -> Stream.concat(ci.getModeInstances().stream(), ci.getModeTransitionInstances().stream()))
					.orElse(Stream.empty()).map(ob -> {
						return createInModeFeatureReference(modeContainer, ob);
					});
		} else {
			return AadlClassifierUtil.getComponentImplementation(modeContainer)
					.filter(ci -> !ci.getAllModes().isEmpty() || !ci.getAllModeTransitions().isEmpty()).map(ci -> {
						return Stream.concat(ci.getAllModes().stream(), ci.getAllModeTransitions().stream());
					}).orElse(Stream.empty()).map(ob -> {
						return createInModeFeatureReference(modeContainer, ob);
					});
		}
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
			return subcomponent.getOwnedModeBindings().stream().filter(mb -> mb.getDerivedMode() != null).map(mb -> {
				return createInModeFeatureReference(modeContainerParent, mb.getDerivedMode());
			});
		} else if (modeContainerParent.getBusinessObject() instanceof ComponentInstance) {
			// Handle derived modes for component instances that are subcomponents
			final ComponentInstance ci = (ComponentInstance) modeContainerParent.getBusinessObject();
			if (ci.getSubcomponent() != null) {
				final Subcomponent subcomponent = ci.getSubcomponent();
				final List<Mode> derivedModes = subcomponent.getOwnedModeBindings().stream()
						.filter(mb -> mb.getDerivedMode() != null).map(mb -> mb.getDerivedMode())
						.collect(Collectors.toList());
				return ci.getModeInstances().stream().filter(mi -> derivedModes.contains(mi.getMode())).map(mi -> {
					return createInModeFeatureReference(modeContainerParent, mi);
				});
			}
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
