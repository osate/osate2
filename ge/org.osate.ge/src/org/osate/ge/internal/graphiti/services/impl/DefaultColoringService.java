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
package org.osate.ge.internal.graphiti.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.command.AbstractCommand;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.ModalPath;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeBinding;
import org.osate.aadl2.ModeFeature;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.ModeTransitionInstance;
import org.osate.ge.graphics.Color;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.graphiti.diagram.GraphitiAgeDiagram;
import org.osate.ge.internal.graphiti.services.GraphitiService;
import org.osate.ge.internal.query.Queryable;
import org.osate.ge.internal.services.ColoringService;
import org.osate.ge.internal.util.AadlClassifierUtil;
import org.osate.ge.internal.util.AadlFlowSpecificationUtil;
import org.osate.ge.internal.util.AadlFlowSpecificationUtil.FlowSegmentReference;
import org.osate.ge.internal.util.AadlHelper;
import org.osate.ge.internal.util.AadlInstanceObjectUtil;
import org.osate.ge.internal.util.AadlModalElementUtil;

import com.google.common.base.Predicates;

public class DefaultColoringService implements ColoringService {
	private static final Color inSelectedModeColor = new Color(255, 0, 128);
	private static final Color inSelectedFlowColor = Color.DARK_ORANGE.brighter();
	private static final Color inSelectedModeAndFlowColor = Color.CYAN.darker();
	private final GraphitiService graphitiService;
	private final LinkedList<ColoringCalculator> coloringCalculators = new LinkedList<ColoringCalculator>();
	private Queryable modeFeatureContainer;
	private String highlightInModeName;
	private String highlightInModeTransitionName;
	private String highlightFlowImplSpecName;
	private String highlightEndToEndFlowName;
	private Queryable flowsContainerBoc;

	private static interface ColoringCalculator {
		Map<DiagramElement, Color> buildColorMap();
	}

	private class SimpleColoring implements Coloring, ColoringCalculator {
		private final Map<DiagramElement, Color> foregroundColors = new HashMap<>();

		@Override
		public void dispose() {
			coloringCalculators.remove(this);
			refreshColoring(foregroundColors.keySet());
		}

		@Override
		public void setForeground(final DiagramElement de, final Color color) {
			if (color == null) {
				foregroundColors.remove(de);
			} else {
				foregroundColors.put(de, color);
			}

			// Refresh Coloring
			refreshColoring(Collections.singleton(de));
		}

		@Override
		public void clear() {
			final List<DiagramElement> elements = new ArrayList<>(foregroundColors.keySet());
			for (final DiagramElement de : elements) {
				setForeground(de, null);
			}
		}

		@Override
		public Map<DiagramElement, Color> buildColorMap() {
			return Collections.unmodifiableMap(foregroundColors);
		}

		private void refreshColoring(final Collection<DiagramElement> diagramElements) {
			graphitiService.getEditingDomain().getCommandStack().execute(new AbstractCommand() {
				@Override
				protected boolean prepare() {
					return true;
				}

				@Override
				public void execute() {
					// Refresh Coloring
					graphitiService.getGraphitiAgeDiagram().refreshStyle(diagramElements);
				}

				@Override
				public boolean canUndo() {
					return false;
				}

				@Override
				public void redo() {
				}
			});
		}
	};

	private class SelectedModeFlowColoringCalculator implements ColoringCalculator {
		@Override
		public Map<DiagramElement, Color> buildColorMap() {
			final Set<DiagramElement> flowSegmentHighlights = new HashSet<>();
			final Set<DiagramElement> inModeHighlightableElements = new HashSet<>();

			// Highlighting ModalElements
			if (modeFeatureContainer != null) {
				if (highlightInModeName != null) {
					if (modeFeatureContainer.getBusinessObject() instanceof ComponentInstance) {
						AadlInstanceObjectUtil.getComponentInstance(modeFeatureContainer).ifPresent(ci -> {
							ci.getModeInstances().stream().filter(mi -> mi.getName().equalsIgnoreCase(highlightInModeName))
							.findAny().ifPresent(selectedModeInstance -> inModeHighlightableElements
									.addAll(getInModeElements(selectedModeInstance, modeFeatureContainer)
											.map(queryable -> (DiagramElement) queryable)
											.collect(Collectors.toList())));
						});
					} else {
						AadlClassifierUtil.getComponentImplementation(modeFeatureContainer).ifPresent(ci -> {
							ci.getAllModes().stream().filter(mode -> mode.getName().equalsIgnoreCase(highlightInModeName))
							.findAny()
							.ifPresent(selectedMode -> inModeHighlightableElements
									.addAll(getInModeElements(selectedMode, modeFeatureContainer)
											.map(queryable -> (DiagramElement) queryable)
											.collect(Collectors.toList())));
						});
					}
				} else if (highlightInModeTransitionName != null) {
					if (modeFeatureContainer.getBusinessObject() instanceof ComponentInstance) {
						AadlInstanceObjectUtil.getComponentInstance(modeFeatureContainer).ifPresent(ci -> {
							ci.getModeTransitionInstances().stream()
							.filter(mi -> mi.getName().equalsIgnoreCase(highlightInModeTransitionName)).findAny()
							.ifPresent(selectedModeInstance -> {
								inModeHighlightableElements
								.addAll(getInModeElements(selectedModeInstance, modeFeatureContainer)
										.map(queryable -> (DiagramElement) queryable)
										.collect(Collectors.toList()));
							});
						});
					} else {
						AadlClassifierUtil.getComponentImplementation(modeFeatureContainer).ifPresent(ci -> {
							ci.getAllModeTransitions().stream()
							.filter(modeTransition -> modeTransition.getName().equalsIgnoreCase(highlightInModeTransitionName))
							.findAny().ifPresent(modeTransition -> {
								inModeHighlightableElements
								.addAll(getInModeElements(modeTransition, modeFeatureContainer)
										.map(queryable -> (DiagramElement) queryable)
										.collect(Collectors.toList()));
							});
						});
					}
				}
			}

			// Highlighting FlowImplemenations and EndToEndFlows
			if (flowsContainerBoc != null) {
				Object container = flowsContainerBoc.getBusinessObject();
				if (container instanceof Subcomponent) {
					final Subcomponent sc = (Subcomponent) flowsContainerBoc.getBusinessObject();
					container = sc.getComponentImplementation();
				}

				if (container instanceof ComponentImplementation) {
					final ComponentImplementation ci = (ComponentImplementation) container;
					if (highlightFlowImplSpecName != null) {
						final Optional<FlowImplementation> highlightFlowImpl = ci.getAllFlowImplementations().stream()
								.filter(fi -> highlightFlowImplSpecName
										.equalsIgnoreCase(fi.getSpecification().getName()))
								.findAny();
						highlightFlowImpl.ifPresent(flowImpl -> {
							final FlowSegmentReference flowSegmentRef = AadlFlowSpecificationUtil
									.createFlowSegmentReference(flowImpl.getSpecification(), flowsContainerBoc);
							// Add initial segment and children
							final Stream<FlowSegmentReference> allFlowSegmentsRefs = Stream
									.concat(Stream.of(flowSegmentRef), getAllChildren(AadlFlowSpecificationUtil
											.findChildren(flowSegmentRef).filter(Predicates.notNull())));
							findAndAddDiagramElements(allFlowSegmentsRefs, flowSegmentHighlights);
						});
					} else if (highlightEndToEndFlowName != null) {
						final Optional<EndToEndFlow> highlightEndToEndFlow = ci.getAllEndToEndFlows().stream()
								.filter(etef -> highlightEndToEndFlowName.equalsIgnoreCase(etef.getName())).findFirst();
						highlightEndToEndFlow.ifPresent(endToEndFlow -> {
							findFlowSegments(endToEndFlow, flowSegmentHighlights);
						});
					}
				} else if (container instanceof ComponentInstance) {
					// ComponentInstances only support EndToEndFlows
					final ComponentInstance ci = (ComponentInstance) container;
					if (highlightEndToEndFlowName != null) {
						final Optional<EndToEndFlowInstance> highlightEndToEndInstance = ci.getEndToEndFlows().stream()
								.filter(etef -> highlightEndToEndFlowName.equalsIgnoreCase(etef.getName())).findFirst();
						highlightEndToEndInstance.ifPresent(endToEndFlow -> {
							findFlowSegments(endToEndFlow, flowSegmentHighlights);
						});
					}
				}
			}

			// Build a mapping between diagram elements and the calculated color
			final Map<DiagramElement, Color> elementToColorMap = new HashMap<>();
			for (final DiagramElement de : inModeHighlightableElements) {
				elementToColorMap.put(de, getInSelectedModeColor());
			}

			for (final DiagramElement de : flowSegmentHighlights) {
				elementToColorMap.put(de, getInSelectedFlowColor());
			}

			// Override previous colors for elements which are in both the mode and the flow
			final Set<DiagramElement> modeAndFlowElements = new HashSet<>(inModeHighlightableElements);
			modeAndFlowElements.retainAll(flowSegmentHighlights);
			for (final DiagramElement de : modeAndFlowElements) {
				elementToColorMap.put(de, getInSelectedModeAndFlowColor());
			}

			return Collections.unmodifiableMap(elementToColorMap);
		}

		private void findFlowSegments(final Object endToEndFlow, final Set<DiagramElement> flowSegmentHighlights) {
			final FlowSegmentReference flowSegmentRef = AadlFlowSpecificationUtil
					.createFlowSegmentReference(endToEndFlow, flowsContainerBoc);

			final Stream<FlowSegmentReference> allFlowSegmentsRefs = getAllChildren(
					AadlFlowSpecificationUtil.findChildren(flowSegmentRef).filter(Predicates.notNull()));
			findAndAddDiagramElements(allFlowSegmentsRefs, flowSegmentHighlights);
		}

		/**
		 * Returns a stream of queryables that can be highlighted
		 * @param selectedMode
		 * @param modeFeatureContainer
		 * @return
		 */
		private Stream<Queryable> getInModeElements(
				final NamedElement selectedMode,
				final Queryable modeFeatureContainer) {
			final ModeFeature selectedModeFeature;

			if(selectedMode instanceof ModeFeature) {
				selectedModeFeature = (ModeFeature) selectedMode;
			} else if (selectedMode instanceof ModeInstance) {
				selectedModeFeature = ((ModeInstance) selectedMode).getMode();
			} else if (selectedMode instanceof ModeTransitionInstance) {
				selectedModeFeature = ((ModeTransitionInstance) selectedMode).getModeTransition();
			} else {
				throw new RuntimeException("unsupported mode " + selectedMode.getName());
			}

			return modeFeatureContainer.getChildren().stream().flatMap(child -> {
				final Object childBo = child.getBusinessObject();
				if (AadlModalElementUtil.isModalElementWithContainer(childBo)) {
					if (childBo instanceof ModalPath) {
						final ModalPath mp = (ModalPath) child.getBusinessObject();
						final List<ModeFeature> inModesOrTransitions = AadlModalElementUtil
								.getAllInModesOrTransitions(mp);

						// Check in modes
						if (inModesOrTransitions.isEmpty()
								|| inModesOrTransitions.stream()
								.anyMatch(mf -> AadlHelper.namesMatch(mf, selectedModeFeature))) {
							return Stream.of(child);
						}
					} else if (childBo instanceof ModalElement) {
						final ModalElement me = (ModalElement) childBo;
						if (selectedModeFeature instanceof ModeTransition) {
							// If in all modes, highlight ModalElement and it's children
							return me.getAllInModes().isEmpty()
									? Stream.concat(Stream.of(child),
											getModalElementChildren(getChildrenApplicableToModeHighlighting(child)))
											: Stream.empty();
						}

						// Check for derived modes
						if (me instanceof Subcomponent) {
							final Subcomponent subcomponent = (Subcomponent) me;
							if (isDerived(subcomponent)) {
								// Return
								return getDerivedSubcomponentInModes(selectedModeFeature, child);
							}
						}
						return getInModeElements(selectedModeFeature, me, child);
					} else if (childBo instanceof EndToEndFlowInstance
							|| childBo instanceof FlowSpecificationInstance || childBo instanceof ConnectionReference) {
						final ModalPath modalPath = AadlInstanceObjectUtil.getModalPath(childBo);
						final List<ModeFeature> inModeOrTransitions = AadlModalElementUtil
								.getAllInModesOrTransitions(modalPath);
						if (inModeOrTransitions.isEmpty() || inModeOrTransitions.stream()
								.anyMatch(mi -> AadlHelper.namesMatch(selectedModeFeature, mi))) {
							return Stream.of(child);
						}
					} else if (childBo instanceof ComponentInstance) {
						final ComponentInstance ci = (ComponentInstance) childBo;
						if (selectedModeFeature instanceof ModeTransition) {
							// If in all modes, highlight component instance and it's children
							return ci.getInModes().isEmpty()
									? Stream.concat(Stream.of(child),
											getModalElementChildren(getChildrenApplicableToModeHighlighting(child)))
											: Stream.empty();
						}

						// Check for derived modes
						if (ci.getSubcomponent() instanceof Subcomponent) {
							final Subcomponent subcomponent = (Subcomponent) ci.getSubcomponent();
							if (isDerived(subcomponent)) {
								return getDerivedSubcomponentInModes(selectedModeFeature, child);
							}
						}
						return getInModeElements(selectedModeFeature, ci, child);
					}
				} else if (isApplicableElementToModeHighlighting(child.getBusinessObject())) {
					return Stream.of(child);
				}
				return Stream.empty();
			});
		}

		private boolean isDerived(Subcomponent subcomponent) {
			return subcomponent.getComponentType() != null && subcomponent.getComponentType().isDerivedModes();
		}

		/**
		 * Determine the highlightable elements of a subcomponent that requires modes.
		 * Subcomponents with a null ModeBinding mapping are in the parent mode if
		 * a mode with the same name is exists in the subcomponent.
		 * @param selectedModeFeature
		 * @param subcompQueryable
		 * @return
		 */
		private Stream<? extends Queryable> getDerivedSubcomponentInModes(final ModeFeature selectedModeFeature,
				final Queryable subcompQueryable) {
			final Subcomponent subcomponent = subcompQueryable.getBusinessObject() instanceof Subcomponent
					? (Subcomponent) subcompQueryable.getBusinessObject()
							: ((ComponentInstance) subcompQueryable.getBusinessObject())
							.getSubcomponent();
					// In all modes
					final List<ModeBinding> modeBindings = AadlModalElementUtil.getAllModeBindings(subcomponent);
					if (modeBindings.isEmpty()) {
						if (subcomponent.getComponentType() == null) {
							return Stream.of(subcompQueryable);
						}

						final Optional<Mode> modeOpt = subcomponent.getComponentType().getAllModes().stream()
								.filter(mode -> AadlHelper.namesMatch(mode, selectedModeFeature)).findAny();
						// Check if mode in subcomponent is also in component type
						if (modeOpt.isPresent()) {
							return Stream.concat(Stream.of(subcompQueryable),
									getInModeElements(modeOpt.get(), subcompQueryable));
						}
					} else {

						// In modes
						// Use derived mode to highlight children. If derived mode is null, find the mode with same name as parent mode
						final Optional<ModeBinding> mbOpt = modeBindings.stream()
								.filter(mb -> AadlHelper.namesMatch(mb.getParentMode(), selectedModeFeature)).findAny();
						if (mbOpt.isPresent()) {
							final ModeBinding mb = mbOpt.get();
							// If derived mode is null, look for parent mode
							final Mode inMode = mb.getDerivedMode() == null ? mb.getParentMode() : mb.getDerivedMode();
							return Stream.concat(Stream.of(subcompQueryable), getInModeElements(inMode, subcompQueryable));
						}
					}

					return Stream.empty();
		}

		/**
		 * Returns a stream of elements that are in the selected mode.
		 * @param mode
		 * @param me
		 * @param container
		 * @return
		 */
		private Stream<Queryable> getInModeElements(final ModeFeature mode, final ModalElement me,
				final Queryable container) {
			final List<Mode> allModes = me.getAllInModes();

			// In all modes
			if (allModes.isEmpty()) {
				return Stream.concat(Stream.of(container), getModalElementChildren(getChildrenApplicableToModeHighlighting(container)));
			}

			// In selected modes
			if (allModes.stream()
					.anyMatch(inMode -> AadlHelper.namesMatch(mode, inMode))) {
				return Stream.concat(Stream.of(container), getModalElementChildren(getChildrenApplicableToModeHighlighting(container)));
			}

			return Stream.empty();
		}

		/**
		 * Returns a stream of elements that are in the selected mode.
		 * @param mode
		 * @param ci
		 * @param container
		 * @return
		 */
		private Stream<Queryable> getInModeElements(final ModeFeature mode, final ComponentInstance ci,
				final Queryable container) {
			final List<ModeInstance> allModes = ci.getInModes();

			// In all modes
			if (allModes.isEmpty()) {
				return Stream.concat(Stream.of(container),
						getModalElementChildren(getChildrenApplicableToModeHighlighting(container)));
			}

			// In selected modes
			if (allModes.stream().anyMatch(inMode -> AadlHelper.namesMatch(mode, inMode))) {
				return Stream.concat(Stream.of(container),
						getModalElementChildren(getChildrenApplicableToModeHighlighting(container)));
			}

			return Stream.empty();
		}

		/**
		 * Recursively highlight children that are not ModeFeatures
		 * @param children
		 * @return a stream of queryables to be highlighted
		 */
		private Stream<Queryable> getModalElementChildren(final Stream<? extends Queryable> children) {
			return children.flatMap(
					child -> Stream.concat(Stream.of(child), getModalElementChildren(getChildrenApplicableToModeHighlighting(child))));
		}

		private void findAndAddDiagramElements(final Stream<FlowSegmentReference> flowSegmentRefs,
				final Collection<DiagramElement> flowSegmentHighlights) {
			flowSegmentHighlights.addAll(flowSegmentRefs.filter(Predicates.notNull())
					.map(FlowElement -> (DiagramElement) AadlFlowSpecificationUtil.findQueryable(FlowElement))
					.filter(Predicates.notNull()).collect(Collectors.toSet()));
		}

		/**
		 * Find flow segment references that are visible on diagram and return as stream
		 * @param highlightableFlowElements
		 * @return
		 */
		private Stream<FlowSegmentReference> getAllChildren(
				final Stream<FlowSegmentReference> highlightableFlowElements) {
			return highlightableFlowElements.flatMap(fsr -> {
				return Stream.concat(Stream.of(fsr),
						getAllChildren(AadlFlowSpecificationUtil.findChildren(fsr).filter(Predicates.notNull())));
			});

		}
	};

	public DefaultColoringService(final GraphitiService graphitiService) {
		this.graphitiService = Objects.requireNonNull(graphitiService, "graphitiService must not be null");

		// Add coloring calculator to handle mode and flow behavior. It is contained here to replicate behavior of the highlighting service.
		// In the future this could be moved outside the coloring service
		this.coloringCalculators.add(new SelectedModeFlowColoringCalculator());
	}

	/**
	 * Determine which children should be highlighted.
	 * @param parent
	 * @return stream of child queryables to be highlighted
	 */
	private static Stream<? extends Queryable> getChildrenApplicableToModeHighlighting(final Queryable parent) {
		return parent.getChildren().stream().filter(child -> {
			final Object childBo = child.getBusinessObject();
			return isApplicableElementToModeHighlighting(childBo);
		});
	}

	private static boolean isApplicableElementToModeHighlighting(final Object element) {
		return !(element instanceof ModeFeature || element instanceof ModeInstance
				|| element instanceof ModeTransitionInstance) && element instanceof NamedElement;
	}

	@Override
	public Coloring adjustColors() {
		final SimpleColoring newColoring = new SimpleColoring();
		coloringCalculators.addLast(newColoring);
		return newColoring;
	}

	@Override
	public void setHighlightedMode(final NamedElement highlightInMode, final Queryable modalElementBoc) {
		this.modeFeatureContainer = modalElementBoc;
		highlightInModeName = highlightInMode instanceof Mode || highlightInMode instanceof ModeInstance
				? highlightInMode.getName()
						: null;
				highlightInModeTransitionName = highlightInMode instanceof ModeTransition
						|| highlightInMode instanceof ModeTransitionInstance ? highlightInMode.getName() : null;
						refreshDiagramColoring();
	}

	@Override
	public void setHighlightedFlow(final NamedElement highlightedFlow, final Queryable flowsContainerBoc) {
		this.flowsContainerBoc = flowsContainerBoc;
		highlightFlowImplSpecName = highlightedFlow instanceof FlowSpecification
				? ((FlowSpecification) highlightedFlow).getName()
						: null;
				highlightEndToEndFlowName = highlightedFlow instanceof EndToEndFlow
						|| highlightedFlow instanceof EndToEndFlowInstance ? highlightedFlow.getName() : null;
						refreshDiagramColoring();
	}

	@Override
	public Map<DiagramElement, Color> buildForegroundColorMap() {
		// Determine the appropriate color
		// Build the combined map.
		final Map<DiagramElement, Color> combinedMap = new HashMap<>();
		for (final ColoringCalculator coloring : coloringCalculators) {
			combinedMap.putAll(coloring.buildColorMap());
		}

		return Collections.unmodifiableMap(combinedMap);
	};

	private Color getInSelectedModeColor() {
		return inSelectedModeColor;
	}

	private Color getInSelectedFlowColor() {
		return inSelectedFlowColor;
	}

	private Color getInSelectedModeAndFlowColor() {
		return inSelectedModeAndFlowColor;
	}

	private void refreshDiagramColoring() {
		if (graphitiService.getAgeDiagram() == null) {
			return;
		}

		graphitiService.getEditingDomain().getCommandStack().execute(new AbstractCommand() {
			@Override
			protected boolean prepare() {
				return true;
			}

			@Override
			public void execute() {
				// Refresh Coloring
				final GraphitiAgeDiagram graphitiAgeDiagram = graphitiService.getGraphitiAgeDiagram();
				graphitiAgeDiagram.refreshDiagramStyles();
			}

			@Override
			public boolean canUndo() {
				return false;
			}

			@Override
			public void redo() {
			}
		});
	}
}