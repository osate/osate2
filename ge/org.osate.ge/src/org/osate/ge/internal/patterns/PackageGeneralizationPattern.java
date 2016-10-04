/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.patterns;

import javax.inject.Inject;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.context.impl.ReconnectionContext;
import org.eclipse.graphiti.func.IReconnection;
import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AbstractImplementation;
import org.osate.aadl2.AbstractType;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.Generalization;
import org.osate.aadl2.GroupExtension;
import org.osate.aadl2.ImplementationExtension;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Namespace;
import org.osate.aadl2.Realization;
import org.osate.aadl2.TypeExtension;
import org.osate.ge.Categories;
import org.osate.ge.internal.AadlElementWrapper;
import org.osate.ge.internal.Categorized;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ColoringService;
import org.osate.ge.internal.services.ConnectionCreationService;
import org.osate.ge.internal.services.ConnectionService;
import org.osate.ge.internal.services.DiagramModificationService;
import org.osate.ge.internal.services.GhostingService;
import org.osate.ge.internal.services.PropertyService;
import org.osate.ge.internal.services.StyleService;
import org.osate.ge.internal.services.UserInputService;
import org.osate.ge.internal.services.AadlModificationService.AbstractModifier;
import org.osate.ge.internal.util.ImageHelper;

public class PackageGeneralizationPattern extends AgeConnectionPattern implements IReconnection, Categorized {
	private final StyleService styleUtil;
	private final AadlModificationService modificationService;
	private final ConnectionCreationService connectionCreationService;
	private final UserInputService userInputService;
	private final DiagramModificationService diagramModService;
	private final BusinessObjectResolutionService bor;

	@Inject
	public PackageGeneralizationPattern(final ColoringService coloringService, final GhostingService ghostingService, final StyleService styleUtil,
			final AadlModificationService modificationService, final ConnectionService connectionService,
			final ConnectionCreationService connectionCreationService, final UserInputService userInputService, 
			final DiagramModificationService diagramModService, final PropertyService propertyService, final BusinessObjectResolutionService bor) {
		super(coloringService, ghostingService, connectionService, propertyService, bor);
		this.styleUtil = styleUtil;
		this.modificationService = modificationService;
		this.connectionCreationService = connectionCreationService;
		this.diagramModService = diagramModService;
		this.userInputService = userInputService;
		this.bor = bor;
	}

	@Override
	public boolean isMainBusinessObjectApplicable(final Object mainBusinessObject) {
		final Object unwrappedObj = AadlElementWrapper.unwrap(mainBusinessObject);
		return (unwrappedObj instanceof Realization || unwrappedObj instanceof TypeExtension
				|| unwrappedObj instanceof ImplementationExtension || unwrappedObj instanceof GroupExtension);
	}

	@Override
	public boolean isPaletteApplicable() {
		final Object diagramBo = bor.getBusinessObjectForPictogramElement(getDiagram());
		return diagramBo instanceof AadlPackage;
	}
	
	@Override
	protected void createDecorators(final Connection connection) {
		connection.getConnectionDecorators().clear();

		// Create the arrow
		final ConnectionDecorator arrowConnectionDecorator = Graphiti.getPeCreateService().createConnectionDecorator(
				connection, false, 1.0, true);
		createArrow(arrowConnectionDecorator, getGeneralizationArrowHeadStyle());
	}

	@Override
	protected void createGraphicsAlgorithm(final Connection connection) {
		final Generalization generalization = getGeneralization(connection);
		final IGaService gaService = Graphiti.getGaService();
		final Polyline polyline = gaService.createPlainPolyline(connection);
		setGraphicsAlgorithmStyle(polyline, generalization);
	}

	private void setGraphicsAlgorithmStyle(final GraphicsAlgorithm ga, final Generalization generalization) {
		final boolean isImplements = generalization instanceof Realization;
		final Style style = isImplements ? getImplementsStyle() : getExtendsStyle();
		ga.setStyle(style);
	}

	private GraphicsAlgorithm createArrow(final GraphicsAlgorithmContainer gaContainer, final Style style) {
		final IGaService gaService = Graphiti.getGaService();
		final GraphicsAlgorithm ga = gaService.createPlainPolygon(gaContainer, new int[] { -15, 10, 0, 0, -15, -10 });
		ga.setStyle(style);
		return ga;
	}

	protected Generalization getGeneralization(final Connection connection) {
		return (Generalization) AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(connection));
	}

	protected void createGraphicsAlgorithmOnUpdate(final Connection connection) {
		final Generalization generalization = (Generalization) AadlElementWrapper
				.unwrap(getBusinessObjectForPictogramElement(connection));
		// CLEAN-UP: As of 8/9/13 updating the graphics algorithm is causing the generalizations to disappear on the 2nd
// update(1st update after the initial load). Unknown cause.
		// First noticed after updating to Kepler. So for now, we just set the style since strictly speaking, recreating
// the graphics algorithm isn't necessary.
		// createGraphicsAlgorithm(connection, generalization);
		setGraphicsAlgorithmStyle(connection.getGraphicsAlgorithm(), generalization);
	}

	@Override
	public String getCreateImageId(){
		final Aadl2Package p = Aadl2Factory.eINSTANCE.getAadl2Package();
		return ImageHelper.getImage(p.getGeneralization().getName());
	}
	@Override
	public String getCreateName() {
		return "Extension";
	}
	
	@Override
	public boolean canCreate(final ICreateConnectionContext context) {
		if (context.getSourceAnchor() == null || context.getTargetAnchor() == null) {
			return false;
		}

		// Get the business objects for the source and destination shapes
		final Object srcBo = getShapeBusinessObject(context.getSourceAnchor());
		final Object dstBo = getShapeBusinessObject(context.getTargetAnchor());

		return areSrcAndDestCompatible(srcBo, dstBo);
	}

	private boolean areSrcAndDestCompatible(final Object srcBo, final Object dstBo) {
		// Ensure they are valid and are not the same
		if (srcBo == null || dstBo == null || bor.areBusinessObjectsEqual(srcBo, dstBo)) {
			return false;
		}

		// Rules:
		// Abstract types can be extended by any type.
		// Types can be extended by other types in their category
		// Implementations can extend other implementations with same category and abstract implementation in some
// cases.
		// Feature Group Types can extend other feature group types
		if (srcBo instanceof ComponentType) {
			return dstBo instanceof AbstractType || dstBo.getClass() == srcBo.getClass();
		} else if (srcBo instanceof ComponentImplementation) {
			return dstBo instanceof AbstractImplementation || dstBo.getClass() == srcBo.getClass();
		} else if (srcBo instanceof FeatureGroupType) {
			return dstBo instanceof FeatureGroupType;
		}

		return false;
	}

	@Override
	public boolean canStartConnection(final ICreateConnectionContext context) {
		final Anchor anchor = context.getSourceAnchor();
		if (anchor == null) {
			return false;
		}

		// Determine whether it is a valid starting object
		final Object bo = getShapeBusinessObject(anchor);
		if (bo instanceof ComponentType) {
			final ComponentType ct = (ComponentType) bo;
			return ct.getOwnedExtension() == null;
		} else if (bo instanceof ComponentImplementation) {
			final ComponentImplementation ci = (ComponentImplementation) bo;
			return ci.getOwnedExtension() == null;
		} else if (bo instanceof FeatureGroupType) {
			final FeatureGroupType fgt = (FeatureGroupType) bo;
			return fgt.getOwnedExtension() == null;
		}

		return false;
	}

	private Object getShapeBusinessObject(final Anchor anchor) {
		return bor.getBusinessObjectForPictogramElement(anchor.getParent());
	}

	@Override
	public Connection create(final ICreateConnectionContext context) {
		// Get the business objects for the source and destination shapes
		final NamedElement srcEl = (NamedElement) getShapeBusinessObject(context.getSourceAnchor());
		final URI dstElUri = EcoreUtil.getURI((EObject) getShapeBusinessObject(context.getTargetAnchor()));

		// Make the modification
		final Generalization generalization = modificationService.modify(srcEl,
				new AbstractModifier<NamedElement, Generalization>() {
					private DiagramModificationService.Modification diagramMod = null;
			
					@Override
					public Generalization modify(final Resource resource, final NamedElement srcEl) {
						final EObject dstEl = resource.getResourceSet().getEObject(dstElUri, true);
						
						Generalization result = null;
						
						if (srcEl instanceof ComponentType) {
							final ComponentType ct = (ComponentType) srcEl;
							final TypeExtension te = ct.createOwnedExtension();
							te.setExtended((ComponentType) dstEl);
							result = te;
						} else if (srcEl instanceof ComponentImplementation) {
							final ComponentImplementation ci = (ComponentImplementation) srcEl;
							final ImplementationExtension ie = ci.createOwnedExtension();
							ie.setExtended((ComponentImplementation) dstEl);
							result = ie;
						} else if (srcEl instanceof FeatureGroupType) {
							final FeatureGroupType fgt = (FeatureGroupType) srcEl;
							final GroupExtension ge = fgt.createOwnedExtension();
							ge.setExtended((FeatureGroupType) dstEl);
							result = ge;
						}

						if(result != null) {
							// Handle diagram updates
				 			diagramMod = diagramModService.startModification();
				 			diagramMod.markOpenLinkagesAsDirty(srcEl);
						}
						return result;
					}
					
			 		@Override
					public void beforeCommit(final Resource resource, final NamedElement srcEl, final Generalization generalization) {
			 			if(diagramMod != null) {
			 				diagramMod.commit();
			 			}
					}
				});

		// Create/Get the connection
		if (generalization == null) {
			return null;
		}

		final Connection connection = connectionCreationService.createUpdateConnection(getDiagram(), generalization);
		return connection;
	}

	@Override
	public boolean canDelete(final IDeleteContext context) {
		final Object bo = bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
		if(bo instanceof TypeExtension || bo instanceof ImplementationExtension || bo instanceof GroupExtension) {
			final Generalization generalization = (Generalization)bo;
			final Classifier ownerClasisifer = (Classifier)generalization.getContainingClassifier();
			if(ownerClasisifer != null) {
		    	final Namespace ns = ownerClasisifer.getNamespace();
		    	final AadlPackage pkg = getDiagramPackage();
		    	return ns != null && ns.getOwner() == pkg;
			}
		}
		
		return false;
	}

	@Override
	public void delete(final IDeleteContext context) {
		if (!userInputService.confirmDelete(context)) {
			return;
		}

		// Make the modification
		final Generalization generalization = (Generalization) bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
		modificationService.modify(generalization, new AbstractModifier<Generalization, Object>() {
			private DiagramModificationService.Modification diagramMod;
			
			@Override
			public Object modify(final Resource resource, final Generalization generalization) {
				// Handle diagram updates
	 			diagramMod = diagramModService.startModification();
	 			final Classifier classifier = generalization.getContainingClassifier();
	 			if(classifier != null) {
	 				diagramMod.markOpenLinkagesAsDirty(classifier);
	 			}
	 			
				EcoreUtil.delete(generalization);

				return null;
			}
			
	 		@Override
			public void beforeCommit(final Resource resource, final Generalization generalization, final Object modificationResult) {
				diagramMod.commit();
			}
		});

		// Clear selection
		getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior().getDiagramContainer()
				.selectPictogramElements(new PictogramElement[0]);
	}

	// Reconnect
	@Override
	public boolean canReconnect(final IReconnectionContext context) {
		final Object bo = bor.getBusinessObjectForPictogramElement(context.getConnection());

		// Require a new anchor
		if (context.getNewAnchor() == null) {
			return false;
		}

		// Only allow certain types to be moved
		if (!(bo instanceof TypeExtension || bo instanceof ImplementationExtension || bo instanceof GroupExtension)) {
			return false;
		}

		// Determine if the the reconnection is valid
		final Connection connection = context.getConnection();
		final Object oldBo = getShapeBusinessObject(context.getOldAnchor());
		final Object newBo = getShapeBusinessObject(context.getNewAnchor());

		final Object srcBo;
		final Object dstBo;
		final Object otherBo;
		if (context.getReconnectType().equals(ReconnectionContext.RECONNECT_SOURCE)) {
			srcBo = newBo;
			otherBo = dstBo = getShapeBusinessObject(connection.getEnd());
		} else {
			otherBo = srcBo = getShapeBusinessObject(connection.getStart());
			dstBo = newBo;
		}

		if (bor.areBusinessObjectsEqual(oldBo, newBo) || bor.areBusinessObjectsEqual(otherBo, newBo) || !areSrcAndDestCompatible(srcBo, dstBo)) {
			return false;
		}

		if (context.getReconnectType().equals(ReconnectionContext.RECONNECT_SOURCE)) {
			if (bo instanceof TypeExtension) {
				final ComponentType ct = (ComponentType) newBo;
				return ct.getOwnedExtension() == null;
			} else if (bo instanceof ImplementationExtension) {
				final ComponentImplementation ci = (ComponentImplementation) newBo;
				return ci.getOwnedExtension() == null;
			} else if (bo instanceof GroupExtension) {
				final FeatureGroupType fgt = (FeatureGroupType) newBo;
				return fgt.getOwnedExtension() == null;
			}
		}

		return true;
	}

	@Override
	public void reconnect(final IReconnectionContext context) {
		final Generalization generalization = (Generalization) bor.getBusinessObjectForPictogramElement(context
				.getConnection());

		modificationService.modify(generalization, new AbstractModifier<Generalization, Object>() {
			@Override
			public Object modify(final Resource resource, final Generalization generalization) {
				final Object newBo = getShapeBusinessObject(context.getNewAnchor());
				if (generalization instanceof TypeExtension) {
					if (context.getReconnectType().equals(ReconnectionContext.RECONNECT_SOURCE)) {
						final ComponentType generalComponentType = (ComponentType) generalization.getGeneral();

						// Delete the generalization and create a new one. (Setting specific on a generalization is not
// supported)
						EcoreUtil.delete(generalization);

						// Create the new type extension
						final ComponentType ct = (ComponentType) newBo;
						final TypeExtension te = ct.createOwnedExtension();
						te.setExtended(generalComponentType);

					} else {
						final TypeExtension te = (TypeExtension) generalization;
						te.setExtended((ComponentType) newBo);
					}
				} else if (generalization instanceof ImplementationExtension) {
					if (context.getReconnectType().equals(ReconnectionContext.RECONNECT_SOURCE)) {
						final ComponentImplementation generalComponentImplementation = (ComponentImplementation) generalization
								.getGeneral();

						// Delete the generalization and create a new one. (Setting specific on a generalization is not
// supported)
						EcoreUtil.delete(generalization);

						// Create the new type extension
						final ComponentImplementation ci = (ComponentImplementation) newBo;
						final ImplementationExtension ie = ci.createOwnedExtension();
						ie.setExtended(generalComponentImplementation);

					} else {
						final ImplementationExtension ie = (ImplementationExtension) generalization;
						ie.setExtended((ComponentImplementation) newBo);
					}

				} else if (generalization instanceof GroupExtension) {
					if (context.getReconnectType().equals(ReconnectionContext.RECONNECT_SOURCE)) {
						final FeatureGroupType generalFgt = (FeatureGroupType) generalization.getGeneral();

						// Delete the generalization and create a new one. (Setting specific on a generalization is not supported)
						EcoreUtil.delete(generalization);

						// Create the new group extension
						final FeatureGroupType fgt = (FeatureGroupType) newBo;
						final GroupExtension ge = fgt.createOwnedExtension();
						ge.setExtended(generalFgt);
					} else {
						final GroupExtension ge = (GroupExtension) generalization;
						ge.setExtended((FeatureGroupType) newBo);
					}
				}

				return null;
			}
		});
	}

	@Override
	public void preReconnect(final IReconnectionContext context) {
	}

	@Override
	public void postReconnect(final IReconnectionContext context) {
	}

	@Override
	public void canceledReconnect(final IReconnectionContext context) {
	}

	//@Override - Not in the previous version of Graphiti(as of 2014-08-14) so the Override annotation causes problems
	public boolean canStartReconnect(final IReconnectionContext context) {
		final Object bo = bor.getBusinessObjectForPictogramElement(context.getConnection());

		// Only allow certain types to be moved
		return bo instanceof TypeExtension || bo instanceof ImplementationExtension || bo instanceof GroupExtension;
	}
	
	/**
	 * Returns the package the diagram represents
	 * @return
	 */
	private AadlPackage getDiagramPackage() {
		return (AadlPackage)bor.getBusinessObjectForPictogramElement(getDiagram());
	}

	@Override
	public String getCategory() {
		return Categories.RELATIONSHIPS;
	}
	
	private Style getGeneralizationArrowHeadStyle() {
		return styleUtil.getStyle("generalization-arrowhead");
    }
	
	private Style getExtendsStyle() {
		return styleUtil.getStyle("extends");
    }
	
	private Style getImplementsStyle() {
		return styleUtil.getStyle("implements");
    }
}
