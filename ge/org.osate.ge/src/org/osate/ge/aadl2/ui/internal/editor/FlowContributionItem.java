/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.aadl2.ui.internal.editor;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorPart;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.aadl2.internal.util.AadlClassifierUtil;
import org.osate.ge.aadl2.internal.util.AadlFlowSpecificationUtil;
import org.osate.ge.aadl2.internal.util.AadlFlowSpecificationUtil.FlowSegmentReference;
import org.osate.ge.aadl2.internal.util.AadlInstanceObjectUtil;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.services.ModelChangeNotifier;
import org.osate.ge.internal.services.ModelChangeNotifier.ChangeListener;
import org.osate.ge.internal.ui.editor.ComboContributionItem;
import org.osate.ge.internal.ui.editor.InternalDiagramEditor;
import org.osate.ge.internal.ui.util.UiUtil;
import org.osate.ge.query.ExecutableQuery;
import org.osate.ge.services.QueryService;
import org.osate.ge.swt.SwtUtil;

import com.google.common.base.Objects;
import com.google.common.base.Predicates;

public class FlowContributionItem extends ComboContributionItem {
	public static final String WIDGET_ID_HIGHLIGHT_FLOW = "org.osate.ge.properties.HighlightFlow";
	private static final String EMPTY_SELECTION_TXT = "<Flows>";
	private static final String SELECTED_FLOW_PROPERTY_KEY = "org.osate.ge.ui.editor.selectedFlow";
	private static final ExecutableQuery<Object> FLOW_CONTAINER_QUERY = ExecutableQuery
			.create((rootQuery) -> rootQuery.descendants()
					.filter((fa) -> fa.getBusinessObject() instanceof ComponentImplementation
							|| fa.getBusinessObject() instanceof Subcomponent
							|| fa.getBusinessObject() instanceof ComponentInstance));
	private InternalDiagramEditor editor = null;
	private final ShowFlowContributionItem showFlowContributionItem;
	private final EditFlowContributionItem editFlowContributionItem;
	private final DeleteFlowContributionItem deleteFlowContributionItem;
	private final ModelChangeNotifier modelChangeNotifier;
	private final ChangeListener modelChangeListener = new ChangeListener() {
		@Override
		public void afterModelChangeNotification() {
			refresh();
		}
	};

	public FlowContributionItem(final String id, final ShowFlowContributionItem showFlowImplElements,
			final EditFlowContributionItem editFlowContributionItem,
			final DeleteFlowContributionItem deleteFlowContributionItem,
			final ModelChangeNotifier modelChangeNotifier) {
		super(id);
		this.showFlowContributionItem = showFlowImplElements;
		this.editFlowContributionItem = editFlowContributionItem;
		this.deleteFlowContributionItem = deleteFlowContributionItem;
		this.modelChangeNotifier = modelChangeNotifier;
	}

	@Override
	public boolean isDynamic() {
		return true;
	}

	// Force a fixed width for the combo contribution items. Otherwise the sizes are often incorrect due to the dynamic nature of the control.
	@Override
	protected int computeWidth(Control control) {
		return 310;
	}

	public final void setActiveEditor(final IEditorPart newEditor) {
		if (editor != newEditor) {
			setControlEnabled(newEditor != null);
			if (newEditor == null) {
				modelChangeNotifier.removeChangeListener(modelChangeListener);
			} else if (editor == null) {
				modelChangeNotifier.addChangeListener(modelChangeListener);
			}

			saveFlowSelection();
			editor = newEditor instanceof InternalDiagramEditor ? (InternalDiagramEditor) newEditor : null;
			refresh();
		}
	}

	@Override
	protected void onControlDisposed() {
		saveFlowSelection();
		super.onControlDisposed();
	}

	private void saveFlowSelection() {
		// Save the current mode selection
		final ComboViewer comboViewer = getComboViewer();
		if (comboViewer != null && editor != null) {
			final Object firstSelection = comboViewer.getStructuredSelection().getFirstElement();
			@SuppressWarnings("unchecked")
			final Map.Entry<String, HighlightableFlowInfo> entry = (Map.Entry<String, HighlightableFlowInfo>) firstSelection;
			final String selectionStr = firstSelection != null ? (String) entry.getKey() : null;
			editor.setPartProperty(SELECTED_FLOW_PROPERTY_KEY, selectionStr);
		}
	}

	@Override
	protected Control createControl(final Composite parent) {
		final Control control = super.createControl(parent);
		setControlEnabled(editor != null);

		final ComboViewer comboViewer = getComboViewer();
		comboViewer.getCombo().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				final Object firstSelection = getComboViewer().getStructuredSelection().getFirstElement();
				@SuppressWarnings("unchecked")
				final Map.Entry<String, HighlightableFlowInfo> entry = (Map.Entry<String, HighlightableFlowInfo>) firstSelection;
				showFlowContributionItem.updateShowFlowItem(entry.getValue());
				editFlowContributionItem.updateEditFlowItem(entry.getValue());
				deleteFlowContributionItem.updateDeleteFlowItem(entry.getValue());
			}
		});

		comboViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(final Object element) {
				@SuppressWarnings("unchecked")
				final Map.Entry<String, HighlightableFlowInfo> entry = (Entry<String, HighlightableFlowInfo>) element;
				return entry.getKey();
			}
		});

		SwtUtil.setTestingId(comboViewer.getCombo(), WIDGET_ID_HIGHLIGHT_FLOW);
		refresh(); // Populate the combo box
		return control;
	}

	void refresh() {
		final ComboViewer comboViewer = getComboViewer();
		final Map<String, HighlightableFlowInfo> highlightableFlowElements = new TreeMap<>(
				(o1, o2) -> o1.toLowerCase().compareTo(o2.toLowerCase()));
		if (comboViewer != null) {
			final Map.Entry<String, HighlightableFlowInfo> nullMapEntry = new AbstractMap.SimpleEntry<>(
					getNullValueString(), new HighlightableFlowInfo(null, FlowSegmentState.COMPLETE));
			highlightableFlowElements.put(nullMapEntry.getKey(), nullMapEntry.getValue());
			Map.Entry<String, HighlightableFlowInfo> selectedValue = nullMapEntry;
			final String selectedFlowName = editor == null ? null : editor.getPartProperty(SELECTED_FLOW_PROPERTY_KEY);
			// Clear the combo box
			comboViewer.setInput(null);

			if (editor == null) {
				return;
			}

			final AgeDiagram diagram = editor.getDiagram();
			if (diagram != null) {
				final QueryService queryService = ContributionUtil.getQueryService(editor);
				if (queryService != null) {
					// Determine which flows have elements contained in the diagram and whether the flow is partial.
					queryService.getResults(FLOW_CONTAINER_QUERY, diagram, null)
					.stream()
					.flatMap(flowContainerQueryable -> {
						if (flowContainerQueryable.getBusinessObject() instanceof ComponentInstance) {
							return AadlInstanceObjectUtil
									.getComponentInstance(flowContainerQueryable.getBusinessObjectContext())
									.map(ci -> createFlowSegmentReferences(
											flowContainerQueryable.getBusinessObjectContext(), ci))
									.orElse(Stream.empty());
						} else {
							return AadlClassifierUtil
									.getComponentImplementation(flowContainerQueryable.getBusinessObjectContext())
									.map(ci -> createFlowSegmentReferences(
											flowContainerQueryable.getBusinessObjectContext(), ci))
									.orElse(Stream.empty());
						}
					}).map(HighlightableFlowInfo::create).filter(Predicates.notNull())
					.forEachOrdered(highlightableFlowElement -> {
						highlightableFlowElements.put(
								getName(highlightableFlowElement.highlightableFlowElement),
								highlightableFlowElement);
					});

					// Determine which value should be selected
					final Optional<Entry<String, HighlightableFlowInfo>> tmpSelectedValue = highlightableFlowElements
							.entrySet().stream().filter(entry -> entry.getKey().equalsIgnoreCase(selectedFlowName))
							.findAny();
					if (tmpSelectedValue.isPresent()) {
						selectedValue = tmpSelectedValue.get();
					}

					comboViewer.setInput(highlightableFlowElements.entrySet());
				}
			}

			showFlowContributionItem.updateShowFlowItem(selectedValue.getValue());
			editFlowContributionItem.updateEditFlowItem(selectedValue.getValue());
			deleteFlowContributionItem.updateDeleteFlowItem(selectedValue.getValue());
			final StructuredSelection newSelection = new StructuredSelection(selectedValue);
			if (!Objects.equal(newSelection, comboViewer.getSelection())) {
				comboViewer.setSelection(newSelection);
				onSelection(newSelection.getFirstElement());
			}
		}
	}

	private static Stream<FlowSegmentReference> createFlowSegmentReferences(
			final BusinessObjectContext flowContainerBoc, final ComponentInstance ci) {
		return ci.getEndToEndFlows().stream().filter(f -> f != null).distinct().map(flow -> {
			return AadlFlowSpecificationUtil.createFlowSegmentReference(flow, flowContainerBoc);
		});
	}

	private static Stream<FlowSegmentReference> createFlowSegmentReferences(
			final BusinessObjectContext flowContainerBoc, final ComponentImplementation ci) {
		return Stream
				.concat(ci.getAllEndToEndFlows().stream(),
						ci.getAllFlowImplementations().stream().map(fi -> fi.getSpecification()))
				.filter(f -> f != null).distinct()
				.map(flow -> AadlFlowSpecificationUtil.createFlowSegmentReference(flow, flowContainerBoc));
	}

	private static String getName(final FlowSegmentReference highlightableFlowElement) {
		return UiUtil.getPathLabel((DiagramNode) highlightableFlowElement.container) + "::"
				+ highlightableFlowElement.flowSegmentElement.getName();
	}

	// The state of the flow matches the combined state of the children.
	private static FlowSegmentState getSegmentState(final FlowSegmentReference highlightableFlowElement) {
		return getSegmentStateForChildren(AadlFlowSpecificationUtil.findChildren(highlightableFlowElement));
	}

	// Returns empty if:
	// The stream is empty
	//
	// A flow is partial if:
	// Any of it's children are partial
	private static FlowSegmentState getSegmentStateForChildren(
			final Stream<FlowSegmentReference> highlightableFlowElements) {
		FlowSegmentState state = null;
		for (final FlowSegmentReference highlightableFlowElement : highlightableFlowElements
				.collect(Collectors.toList())) {
			final FlowSegmentState childState = getChildSegmentState(highlightableFlowElement);
			if ((state != null && state != childState) || childState == FlowSegmentState.PARTIAL) {
				state = FlowSegmentState.PARTIAL;
				break;
			} else {
				state = childState;
			}
		}

		return state == null ? FlowSegmentState.EMPTY : state;
	}

	// A flow segment is complete if:
	// It's children are empty, but the flow segment itself is found
	// Otherwise, the state of the flow is that of the children as returned by getSegmentStateForChildren()
	private static FlowSegmentState getChildSegmentState(final FlowSegmentReference highlightableFlowElement) {
		if (highlightableFlowElement == null) {
			return FlowSegmentState.EMPTY;
		}

		final FlowSegmentState childrenState = getSegmentStateForChildren(
				AadlFlowSpecificationUtil.findChildren(highlightableFlowElement));
		if (childrenState == FlowSegmentState.EMPTY
				&& AadlFlowSpecificationUtil.findQueryable(highlightableFlowElement) != null) {
			return FlowSegmentState.COMPLETE;
		}

		return childrenState;
	}

	@Override
	protected void onSelection(final Object value) {
		if (editor != null && !editor.isDisposed() && value != null) {
			@SuppressWarnings("unchecked")
			final Map.Entry<String, HighlightableFlowInfo> highlightableFlowsMapEntry = (Entry<String, HighlightableFlowInfo>) value;
			final FlowSegmentReference highlightableFlowElement = highlightableFlowsMapEntry
					.getValue().highlightableFlowElement;
			NamedElement flowSegmentElement = null;
			BusinessObjectContext container = null;
			if (highlightableFlowElement != null) {
				flowSegmentElement = highlightableFlowElement.flowSegmentElement;
				container = highlightableFlowElement.container;
			}

			ContributionUtil.getColoringService(editor).setHighlightedFlow(flowSegmentElement, container);
		}
	}

	@Override
	protected String getNullValueString() {
		return EMPTY_SELECTION_TXT;
	}

	public static class HighlightableFlowInfo {
		private final FlowSegmentReference highlightableFlowElement;
		private FlowSegmentState state;

		public HighlightableFlowInfo(final FlowSegmentReference highlightableFlowElement) {
			this(highlightableFlowElement, null);
		}

		public HighlightableFlowInfo(final FlowSegmentReference highlightableFlowElement,
				final FlowSegmentState state) {
			this.highlightableFlowElement = highlightableFlowElement;
			this.state = state;

			if (highlightableFlowElement != null
					&& !(this.highlightableFlowElement.container instanceof DiagramElement)) {
				throw new RuntimeException(
						"Flow element container is not a diagram element: " + this.highlightableFlowElement.container);
			}
		}

		public FlowSegmentState getState() {
			if (state == null) {
				this.state = getSegmentState(highlightableFlowElement);
			}
			return state;
		}

		public BusinessObjectContext getContainer() {
			return highlightableFlowElement.container;
		}

		/**
		 * The container's type is checked in the constructor.
		 * @return the diagram element which contains the flow.
		 */
		public DiagramElement getDiagramElementContainer() {
			return (DiagramElement) getContainer();
		}

		public static HighlightableFlowInfo create(final FlowSegmentReference fsr) {
			return new HighlightableFlowInfo(fsr);
		}

		public NamedElement getFlowSegment() {
			return highlightableFlowElement == null ? null : highlightableFlowElement.flowSegmentElement;
		}
	}

	public static enum FlowSegmentState {
		EMPTY, PARTIAL, COMPLETE
	}
}
