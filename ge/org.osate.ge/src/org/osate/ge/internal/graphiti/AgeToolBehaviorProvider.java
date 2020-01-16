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
// Based on OSATE Graphical Editor. Modifications are:
/*
Copyright (c) 2016, Rockwell Collins.
Developed with the sponsorship of Defense Advanced Research Projects Agency (DARPA).

Permission is hereby granted, free of charge, to any person obtaining a copy of this data,
including any software or models in source or binary form, as well as any drawings, specifications,
and documentation (collectively "the Data"), to deal in the Data without restriction, including
without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense,
and/or sell copies of the Data, and to permit persons to whom the Data is furnished to do so,
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or
substantial portions of the Data.

THE DATA IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT
LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
IN NO EVENT SHALL THE AUTHORS, SPONSORS, DEVELOPERS, CONTRIBUTORS, OR COPYRIGHT HOLDERS BE LIABLE
FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
ARISING FROM, OUT OF OR IN CONNECTION WITH THE DATA OR THE USE OR OTHER DEALINGS IN THE DATA.
 */
/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.graphiti;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.IExecutionInfo;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeature;
import org.eclipse.graphiti.features.IFeatureAndContext;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDoubleClickContext;
import org.eclipse.graphiti.features.context.IPictogramElementContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.palette.IPaletteCompartmentEntry;
import org.eclipse.graphiti.palette.IToolEntry;
import org.eclipse.graphiti.palette.impl.ConnectionCreationToolEntry;
import org.eclipse.graphiti.palette.impl.ObjectCreationToolEntry;
import org.eclipse.graphiti.palette.impl.PaletteCompartmentEntry;
import org.eclipse.graphiti.platform.IDiagramBehavior;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
import org.eclipse.graphiti.tb.IContextButtonPadData;
import org.osate.aadl2.Generalization;
import org.osate.ge.internal.Categorized;
import org.osate.ge.internal.graphiti.features.AgeDoubleClickFeature;
import org.osate.ge.internal.graphiti.services.GraphitiService;
import org.osate.ge.internal.services.ActionExecutor.ExecutionMode;
import org.osate.ge.internal.services.ActionService;
import org.osate.ge.internal.services.ActionService.ActionGroup;
import org.osate.ge.internal.services.ExtensionRegistryService.Category;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.ui.editor.AgeDiagramBehavior;

public class AgeToolBehaviorProvider extends DefaultToolBehaviorProvider {
	private final IEclipseContext context;
	private final ExtensionService extensionService;
	private final ActionService actionService;
	private final AgeDoubleClickFeature defaultDoubleClickFeature;
	private final Deque<ActionGroup> actionGroupStack = new LinkedList<>();

	@Inject
	public AgeToolBehaviorProvider(final GraphitiService graphiti, final ExtensionService extensionService,
			final ActionService actionService, final IEclipseContext context) {
		super(graphiti.getDiagramTypeProvider());
		this.extensionService = extensionService;
		this.actionService = Objects.requireNonNull(actionService, "actionService must not be null");
		this.context = context;
		this.defaultDoubleClickFeature = new AgeDoubleClickFeature(getFeatureProvider());
	}

	@Override
	public String getContributorId() {
		return "org.osate.ge.editor.AgeDiagramEditor";
	}

	//Remove context buttons from pictogram elements
	@Override
	public IContextButtonPadData getContextButtonPad(IPictogramElementContext context) {
		return null;
	}

	// Override the business object equality check. This is needed in the case of Generalization because the owner is one of the defining
	// characteristics and is not checked by the default check which uses EcoreUtil.equals().
	@Override
	public boolean equalsBusinessObjects(final Object o1, final Object o2) {
		if(o1 instanceof Generalization) {
			return o1.equals(o2);
		}
		return super.equalsBusinessObjects(o1, o2);
	}

	/**
	 * This is how we provide objects in the context to the editor.
	 */
	@Override
	public Object getAdapter(Class<?> type) {
		if(type == IEclipseContext.class) {
			return context;
		}

		final Object result = context.get(type);
		if(result != null) {
			return result;
		}

		return super.getAdapter(type);
	}

	@Override
	public ICustomFeature getDoubleClickFeature(final IDoubleClickContext context) {
		return defaultDoubleClickFeature;
	}

	/**
	 * Override of getSelection that checks the shape and containers and returns the first shape with a business object. Allows using active objects without them being
	 * selectable.
	 */
	@Override
	public PictogramElement getSelection(PictogramElement originalPe, PictogramElement[] oldSelection) {
		if(originalPe instanceof ConnectionDecorator) {
		} else if(originalPe instanceof Shape) {
			// Return the first shape that has a business object
			Shape shape = (Shape)originalPe;
			while(shape != null && (getFeatureProvider().getBusinessObjectForPictogramElement(shape) == null)) {
				shape = shape.getContainer();
			}
			return shape;
		}
		return null;
	}

	@Override
	public String getTitleToolTip() {
		final String diagramTitle = getDiagramTypeProvider() == null ? null : getDiagramTypeProvider().getDiagramTitle();
		return diagramTitle == null ? super.getTitleToolTip() : diagramTitle;
	}

	@Override
	public IPaletteCompartmentEntry[] getPalette() {
		final class PaletteCompartments {
			private final ArrayList<PaletteCompartmentEntry> compartments = createCompartmentEntries();
			private ArrayList<PaletteCompartmentEntry> createCompartmentEntries() {
				final ArrayList<PaletteCompartmentEntry> compartmentEntries= new ArrayList<PaletteCompartmentEntry>();
				for(final Category category : extensionService.getCategories()) {
					final PaletteCompartmentEntry newEntry = new PaletteCompartmentEntry(category.getName(), null);
					newEntry.setInitiallyOpen(false);
					compartmentEntries.add(newEntry);
				}

				return compartmentEntries;
			}

			/**
			 * Add the tool entry to the correct category
			 * @param toolEntry the toolEntry to be added to the palette
			 * @param feature the feature that holds which category to which the tool should be added.
			 */
			public void addToolEntry(final IToolEntry toolEntry, final IFeature feature) {
				final Category category = getCategory(feature);
				if(category != null) {
					for(final PaletteCompartmentEntry compartmentEntry : compartments) {
						if(compartmentEntry.getLabel().equals(category.getName())) {
							compartmentEntry.addToolEntry(toolEntry);
						}
					}
				} else {
					//Add to miscellaneous
					compartments.get(compartments.size()-1).addToolEntry(toolEntry);
				}
			}

			/**
			 * Get the category
			 * @param feature
			 * @return the category to which the toolEntry will be added
			 */
			private Category getCategory(final IFeature feature) {
				if(feature instanceof Categorized) {
					return getCategoryById(((Categorized)feature).getCategory());
				} else {
					return null;
				}
			}

			/**
			 * Get the Category based on id
			 * @param id is the compartment/category id
			 * @return the Category
			 */
			private Category getCategoryById(final String id) {
				final List<Category> categories = extensionService.getCategories();
				for(final Category category : categories) {
					if(category.getId().equals(id)) {
						return category;
					}
				}

				return null;
			}

			public void removeEmpty() {
				// Remove empty compartments
				final Iterator<PaletteCompartmentEntry> it = compartments.iterator();
				while(it.hasNext()) {
					final IPaletteCompartmentEntry entry = it.next();
					if(entry.getToolEntries().isEmpty()) {
						it.remove();
					}
				}
			}

			public IPaletteCompartmentEntry[] toArray() {
				return compartments.toArray(new IPaletteCompartmentEntry[compartments.size()]);
			}
		};

		final PaletteCompartments compartments = new PaletteCompartments();
		final IFeatureProvider featureProvider = getFeatureProvider();
		final ICreateConnectionFeature[] createConnectionFeatures = featureProvider.getCreateConnectionFeatures();
		if (createConnectionFeatures.length > 0) {
			for (ICreateConnectionFeature createConnectionFeature : createConnectionFeatures) {
				final ConnectionCreationToolEntry ccTool = new ConnectionCreationToolEntry(
						createConnectionFeature.getCreateName(), createConnectionFeature.getCreateDescription(),
						createConnectionFeature.getCreateImageId(), createConnectionFeature.getCreateLargeImageId());
				ccTool.addCreateConnectionFeature(createConnectionFeature);
				compartments.addToolEntry(ccTool, createConnectionFeature);
			}
		}

		final ICreateFeature[] createFeatures = featureProvider.getCreateFeatures();
		if (createFeatures.length > 0){
			for (ICreateFeature createFeature : createFeatures) {
				final ObjectCreationToolEntry objectCreationToolEntry = new ObjectCreationToolEntry(
						createFeature.getCreateName(), createFeature.getCreateDescription(),
						createFeature.getCreateImageId(), createFeature.getCreateLargeImageId(), createFeature);
				compartments.addToolEntry(objectCreationToolEntry, createFeature);
			}
		}

		compartments.removeEmpty();

		return compartments.toArray();
	}

	/**
	 * Overrides the mechanism to get the graphics algorithm used to determine the chop box location so that it uses the first graphics algorithm that isn't invisible.
	 * @param pe
	 * @return
	 */
	@Override
	public GraphicsAlgorithm getChopboxAnchorArea(final PictogramElement pe) {
		GraphicsAlgorithm ga = super.getChopboxAnchorArea(pe);
		while(!ga.getFilled() && !ga.getLineVisible() && ga.getGraphicsAlgorithmChildren().size() >= 1) {
			ga = ga.getGraphicsAlgorithmChildren().get(0);
		}

		return ga;
	}

	private static class Wrapper implements Consumer<Runnable> {
		private final WeakReference<TransactionalEditingDomain> weakEditingDomain;

		public Wrapper(final TransactionalEditingDomain editingDomain) {
			weakEditingDomain = new WeakReference<>(editingDomain);
		}

		@Override
		public void accept(final Runnable runnable) {
			final TransactionalEditingDomain editingDomain = weakEditingDomain.get();
			if (editingDomain == null) {
				runnable.run();
			} else {
				editingDomain.getCommandStack().execute(new AbstractCommand() {
					@Override
					protected boolean prepare() {
						return true;
					}

					@Override
					public void execute() {
						runnable.run();
					}

					@Override
					public boolean canUndo() {
						return false;
					}

					@Override
					public void redo() {
					}
				});
				editingDomain.getCommandStack().flush();
			}
		}

	};

	@Override
	public void preExecute(final IExecutionInfo executionInfo) {
		// Determine label for group of actions
		// Only use the wrapper if there is more than one feature executing. If there is only one feature then the wrapper isn't needed.
		// This is a workaround for an issue which causes the update feature to appear in the action stack. The wrapper
		// group created below always executes as using the NORMAL operation mode.
		if (executionInfo.getExecutionList().length > 1) {
			String label = null;
			for (final IFeatureAndContext o : executionInfo.getExecutionList()) {
				final String newLabel = o.getFeature().getName();
				if (label == null) {
					label = newLabel;
				} else if (!Objects.equals(label, newLabel)) {
					label = null;
					break;
				}
			}

			if (label == null) {
				label = "Diagram Modification";
			}

			// Start executing the group
			final ActionGroup group = actionService.beginExecuteGroup(label, ExecutionMode.NORMAL);
			actionGroupStack.push(group);

			// Add wrapper if this is a stop level action group.
			if (actionGroupStack.size() == 1) {
				final IDiagramBehavior behavior = getDiagramTypeProvider()
						.getDiagramBehavior();
				if (behavior instanceof AgeDiagramBehavior) {
					final AgeDiagramBehavior ageDiagramBehavior = (AgeDiagramBehavior) behavior;
					final TransactionalEditingDomain editingDomain = ageDiagramBehavior.getEditingDomain();
					if (editingDomain != null) {
						final Wrapper wrapper = new Wrapper(editingDomain);
						actionService.addUndoWrapper(wrapper);
					}
				}
			}
		} else {
			actionGroupStack.push(null);
		}


		super.preExecute(executionInfo);
	}

	@Override
	public void postExecute(final IExecutionInfo executionInfo) {
		// Stop executing the group
		final ActionGroup group = actionGroupStack.pop();
		if (group != null) {
			actionService.endExecuteGroup(group);
		}

		super.postExecute(executionInfo);
	}

}
