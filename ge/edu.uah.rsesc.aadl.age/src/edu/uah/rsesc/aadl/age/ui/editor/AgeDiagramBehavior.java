/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package edu.uah.rsesc.aadl.age.ui.editor;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.editor.DefaultPersistencyBehavior;
import org.eclipse.graphiti.ui.editor.DefaultRefreshBehavior;
import org.eclipse.graphiti.ui.editor.DefaultUpdateBehavior;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.graphiti.ui.editor.IDiagramContainerUI;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.NamedElement;
import org.eclipse.core.runtime.IProgressMonitor;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.services.DiagramService;
import edu.uah.rsesc.aadl.age.ui.util.GhostPurger;
import edu.uah.rsesc.aadl.age.ui.xtext.AgeXtextUtil;
import edu.uah.rsesc.aadl.age.util.Log;

import java.util.Map;

public class AgeDiagramBehavior extends DiagramBehavior {
	private final GhostPurger ghostPurger;
	private final DiagramService diagramService;
	
	public AgeDiagramBehavior(final IDiagramContainerUI diagramContainer, final GhostPurger ghostPurger, final DiagramService diagramService) {
		super(diagramContainer);
		this.ghostPurger = ghostPurger;
		this.diagramService = diagramService;
	}	
	
	private IXtextModelListener modelListener = new IXtextModelListener() {
		@Override
		public void modelChanged(final XtextResource resource) {
			if(resource.getContents().size() > 0) {
				final EObject contents = resource.getContents().get(0);
				final Object bo = AadlElementWrapper.unwrap(getDiagramTypeProvider().getFeatureProvider().getBusinessObjectForPictogramElement(getDiagramTypeProvider().getDiagram()));
				if(contents instanceof NamedElement && bo instanceof NamedElement) {
					final NamedElement namedElement = (NamedElement)bo;
					final String resourceContentsName = ((NamedElement)contents).getQualifiedName();
					final AadlPackage relevantPkg = bo instanceof AadlPackage ? (AadlPackage)bo : (AadlPackage)namedElement.getNamespace().getOwner();

					if(resourceContentsName.equalsIgnoreCase(relevantPkg.getQualifiedName())) {
						final Runnable updateDiagramRunnable = new Runnable() {
							public void run() {			
								// Update the entire diagram
								getDiagramTypeProvider().getNotificationService().updatePictogramElements(new PictogramElement[] { getDiagramTypeProvider().getDiagram() });
							}
						};
						
						if(Display.getDefault().getThread() == Thread.currentThread()) {
							Log.info("Updating diagram synchronously - current thread is the display thread");
							updateDiagramRunnable.run();
						} else {
							Log.info("Updating diagram asynchronously - current thread is not the display thread");
							Display.getDefault().asyncExec(updateDiagramRunnable);	
						}
					}
				}
			}					
		}	
	};

	@Override
	protected DefaultUpdateBehavior createUpdateBehavior() {
		return new AgeUpdateBehavior(this);
	}
	
	@Override
	protected DefaultRefreshBehavior createRefreshBehavior() {		
		return new DefaultRefreshBehavior(this) {
			@Override
			protected void autoUpdate() {
				IDiagramTypeProvider diagramTypeProvider = getDiagramTypeProvider();
				Diagram diagram = diagramTypeProvider.getDiagram();
				IFeatureProvider featureProvider = diagramTypeProvider.getFeatureProvider();
				IUpdateContext updateCtx = new UpdateContext(diagram);
				featureProvider.updateIfPossible(updateCtx);
				refresh();
			}
			
			@Override
			public void refresh() {
				// Update the toolbars
				if(getDiagramContainer() instanceof EditorPart) {
					((EditorPart)getDiagramContainer()).getEditorSite().getActionBars().getToolBarManager().update(true);
				}
				
				super.refresh();
			}
		};
	}
	
	public DefaultPersistencyBehavior getPersistencyBehavior() {
		return super.getPersistencyBehavior();
	}
	
	@Override
	protected DefaultPersistencyBehavior createPersistencyBehavior() {
		return new DefaultPersistencyBehavior(this) {
			protected Set<Resource> save(final TransactionalEditingDomain editingDomain, final Map<Resource, Map<?, ?>> saveOptions, final IProgressMonitor monitor) {
				final Diagram diagram = getDiagramTypeProvider().getDiagram();

				// Delete all the ghosts
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {
						ghostPurger.purgeGhosts(diagram);
					}				
				});				
				
				// Save the diagram				
				final Set<Resource> retValue = super.save(editingDomain, saveOptions, monitor);

				// Set the persistent properties
				diagramService.savePersistentProperties(diagram);
				
				return retValue;
			}
		};
	}

	@Override
	protected void registerBusinessObjectsListener() {
		AgeXtextUtil.addModelListener(modelListener);
	}
	
	@Override
	protected void unregisterDiagramResourceSetListener() {
		AgeXtextUtil.removeModelListener(modelListener);
	}
}
