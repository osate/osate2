/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.ui.editor;

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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorPart;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.query.Queryable;
import org.osate.ge.internal.ui.util.UiUtil;
import org.osate.ge.internal.util.AadlClassifierUtil;
import org.osate.ge.internal.util.AadlFlowSpecificationUtil;
import org.osate.ge.internal.util.AadlFlowSpecificationUtil.FlowSegmentReference;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

import com.google.common.base.Predicates;

public class FlowContributionItem extends ComboContributionItem {
	private static final String emptySelectionTxt = "<Flows>";
	private static final String selectedFlowPropertyKey = "org.osate.ge.ui.editor.selectedFlow";
	private static final StandaloneQuery flowContainerQuery = StandaloneQuery.create((rootQuery) -> rootQuery
			.descendants().filter((fa) -> fa.getBusinessObject() instanceof ComponentImplementation
					|| fa.getBusinessObject() instanceof Subcomponent));
	private AgeDiagramEditor editor = null;

	public FlowContributionItem(final String id) {
		super(id);
	}

	@Override
	public boolean isDynamic() {
		return true;
	}

	public final void setActiveEditor(final IEditorPart newEditor) {
		if (editor != newEditor) {
			saveFlowSelection();

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
			editor.setPartProperty(selectedFlowPropertyKey, selectionStr);
		}
	}

	@Override
	protected Control createControl(final Composite parent) {
		final Control control = super.createControl(parent);

		getComboViewer().setLabelProvider(new LabelProvider() {
			@Override
			public String getText(final Object element) {
				@SuppressWarnings("unchecked")
				final Map.Entry<String, HighlightableFlowInfo> entry = (Entry<String, HighlightableFlowInfo>) element;
				final HighlightableFlowInfo highlightableFlow = entry.getValue();

				// Mark as partial if segments are missing from diagram
				if (highlightableFlow.isPartial()) {
					return entry.getKey() + "*";
				}

				return entry.getKey();
			}
		});

		refresh(); // Populate the combo box
		return control;
	}

	private void refresh() {
		final ComboViewer comboViewer = getComboViewer();
		final Map<String, HighlightableFlowInfo> highlightableFlowElements = new TreeMap<>(
				(o1, o2) -> o1.toLowerCase().compareTo(o2.toLowerCase()));
		if (comboViewer != null) {
			final Map.Entry<String, HighlightableFlowInfo> nullMapEntry = new AbstractMap.SimpleEntry<>(
					getNullValueString(), new HighlightableFlowInfo(null, false));
			highlightableFlowElements.put(nullMapEntry.getKey(), nullMapEntry.getValue());
			Object selectedValue = nullMapEntry;
			final String selectedFlowName = editor == null ? null : editor.getPartProperty(selectedFlowPropertyKey);
			// Clear the combo box
			comboViewer.setInput(null);

			if (editor == null) {
				return;
			}

			final AgeDiagram diagram = editor.getAgeDiagram();
			if (diagram != null) {
				final QueryService queryService = ContributionHelper.getQueryService(editor);
				if (queryService != null) {
					// Determine which flows have elements contained in the diagram and whether the flow is partial.
					queryService.getResults(flowContainerQuery, diagram).stream()
					.flatMap(flowContainerQueryable -> AadlClassifierUtil
							.getComponentImplementation(flowContainerQueryable)
							.map(ci -> createFlowSegmentReferences(flowContainerQueryable, ci))
							.orElse(Stream.empty()))
					.map(HighlightableFlowInfo::create).filter(Predicates.notNull())
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

			comboViewer.setSelection(new StructuredSelection(selectedValue));
		}
	}

	private static Stream<FlowSegmentReference> createFlowSegmentReferences(final Queryable flowContainerBoc,
			final ComponentImplementation ci) {
		return Stream
				.concat(ci.getAllEndToEndFlows().stream(),
						ci.getAllFlowImplementations().stream().map(fi -> fi.getSpecification()))
				.distinct().map(flow -> AadlFlowSpecificationUtil.createFlowSegmentReference(flow, flowContainerBoc));
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
		@SuppressWarnings("unchecked")
		final Map.Entry<String, HighlightableFlowInfo> highlightableFlowsMapEntry = (Entry<String, HighlightableFlowInfo>) value;
		final FlowSegmentReference highlightableFlowElement = highlightableFlowsMapEntry
				.getValue().highlightableFlowElement;
		NamedElement flowSegmentElement = null;
		Queryable container = null;
		if (highlightableFlowElement != null) {
			flowSegmentElement = highlightableFlowElement.flowSegmentElement;
			container = highlightableFlowElement.container;
		}

		ContributionHelper.getColoringService(editor).setHighlightedFlow(flowSegmentElement, container);
	}

	@Override
	protected String getNullValueString() {
		return emptySelectionTxt;
	}

	private static class HighlightableFlowInfo {
		private final FlowSegmentReference highlightableFlowElement;
		private final boolean isPartial;

		public HighlightableFlowInfo(final FlowSegmentReference highlightableFlowElement, final boolean isPartial) {
			this.highlightableFlowElement = highlightableFlowElement;
			this.isPartial = isPartial;
		}

		private boolean isPartial() {
			return isPartial;
		}

		public static HighlightableFlowInfo create(final FlowSegmentReference fsr) {
			final FlowSegmentState state = getSegmentState(fsr);
			if (state == FlowSegmentState.EMPTY) {
				return null;
			}
			return new HighlightableFlowInfo(fsr, state == FlowSegmentState.PARTIAL);
		}
	}

	private static enum FlowSegmentState {
		EMPTY, PARTIAL, COMPLETE
	}
}
