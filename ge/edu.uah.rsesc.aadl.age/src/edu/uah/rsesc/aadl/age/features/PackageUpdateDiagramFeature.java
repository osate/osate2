package edu.uah.rsesc.aadl.age.features;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.features.context.impl.CustomContext;
import org.eclipse.graphiti.features.context.impl.LayoutContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.services.IPeService;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Element;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.FeatureType;
import org.osate.aadl2.Generalization;
import org.osate.aadl2.GroupExtension;
import org.osate.aadl2.ImplementationExtension;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PublicPackageSection;
import org.osate.aadl2.Realization;
import org.osate.aadl2.TypeExtension;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;

import edu.uah.rsesc.aadl.age.diagram.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.util.Log;
import edu.uah.rsesc.aadl.age.util.StyleUtil;

// TODO: Move this out of feature where it runs when the diagram is loaded?
// (Override DefaultPersistencyBehavior)

public class PackageUpdateDiagramFeature extends AbstractUpdateFeature {
	public PackageUpdateDiagramFeature(final IFeatureProvider fp) {
		super(fp);
	}
	
	@Override
	public IReason updateNeeded(IUpdateContext context) {
		Log.info("updateNeeded called with context: " + context);
		return Reason.createTrueReason("");
	}

	@Override
	public boolean canUpdate(IUpdateContext context) {
		return true;
	}
	
	@Override
	public boolean update(IUpdateContext context) {		
		Log.info("update called with context: " + context);
		final Diagram diagram = (Diagram)context.getPictogramElement();
		final boolean wasEmpty = diagram.getChildren().size() == 0; 
		
		// Update styles
		StyleUtil.updateStyles(diagram);
		
		// Get the AADL Package
		final NamedElement element = (NamedElement)AadlElementWrapper.unwrap(this.getBusinessObjectForPictogramElement(diagram));
		if(element == null || !(element instanceof AadlPackage)) {
			return false;
		}	
		final AadlPackage pkg = (AadlPackage)element;

		// Prune Invalid Generalizations
		removeInvalidGeneralizations(diagram);
		
		// Prune Invalid Shapes
		removeShapesWithouBusinessObject(diagram);
		
		// Build a list of all named elements in the public and private sections of the package
		final Set<NamedElement> relevantElements = new HashSet<NamedElement>();
		if(pkg.getPublicSection() != null) {
			relevantElements.addAll(pkg.getPublicSection().getMembers());	
		}

		if(pkg.getPrivateSection() != null) {
			relevantElements.addAll(pkg.getPrivateSection().getMembers());	
		}
		
		// Add classifiers that are extends or implemented by classifiers in this package
		final Set<NamedElement> elementsToAdd = new HashSet<NamedElement>();
		for(final NamedElement el : relevantElements) {
			if(el instanceof ComponentType) {
				final ComponentType componentType = ((ComponentType)el);
				if(componentType.getOwnedExtension() != null) {
					elementsToAdd.add(componentType.getOwnedExtension().getGeneral());
				}
			} else if(el instanceof ComponentImplementation) {
				final ComponentImplementation componentImplementation = ((ComponentImplementation)el);
				if(componentImplementation.getOwnedExtension() != null) {
					elementsToAdd.add(componentImplementation.getOwnedExtension().getGeneral());
				}
				if(componentImplementation.getOwnedRealization() != null) {
					elementsToAdd.add(componentImplementation.getOwnedRealization().getGeneral());
				}
			} else if(el instanceof FeatureGroupType) {
				final FeatureGroupType featureGroupType = ((FeatureGroupType)el);
				if(featureGroupType.getOwnedExtension() != null) {
					elementsToAdd.add(featureGroupType.getOwnedExtension().getGeneral());
				}
			}
		}
		relevantElements.addAll(elementsToAdd);
		
		// Iterate over named elements and add/update classifiers and their relationships.
		updateClassifiers(diagram, relevantElements, 0, 0);	
		updateRelationships(diagram, relevantElements);

		// If the diagram was just initially populated, run the layout diagram feature
		if(wasEmpty) {
			final CustomContext customContext = new CustomContext();
			new LayoutDiagramFeature(this.getFeatureProvider()).execute(customContext);
		}
				
		return false;
	}
	
	private void removeInvalidGeneralizations(final Diagram diagram) {
		final List<Connection> connectionsToRemove = new ArrayList<Connection>();
		
		for(final Connection connection : diagram.getConnections()) {
			final Object bo = AadlElementWrapper.unwrap(this.getBusinessObjectForPictogramElement(connection));
			boolean remove = false;
			if(bo instanceof EObject) {
				EObject emfBusinesObject = (EObject)bo;
				if(emfBusinesObject.eIsProxy()) {
					emfBusinesObject = EcoreUtil.resolve(emfBusinesObject, OsateResourceUtil.getResourceSet());
				}

				if(emfBusinesObject.eIsProxy()) {
					// Remove it it is still a proxy
					remove = true;
				} else if(emfBusinesObject instanceof Generalization) {
					final Generalization generalization = (Generalization)emfBusinesObject;
					final Classifier general = generalization.getGeneral();
					final Classifier specific = generalization.getSpecific();
					final Object startBo = AadlElementWrapper.unwrap(this.getBusinessObjectForPictogramElement(connection.getStart().getParent()));
					final Object endBo = AadlElementWrapper.unwrap(this.getBusinessObjectForPictogramElement(connection.getEnd().getParent()));
										
					// Remove the object if the objects pointed to don't match the object referenced by the generalization
					if(!general.equals(startBo) || !specific.equals(endBo)) {
						remove = true;
					}
				}
			} else {
				// Remove the object if the business object was not an EObject
				remove = true;
			}
			
			if(remove) {
				connectionsToRemove.add(connection);
			}
		}
		
		for(final Connection connection : connectionsToRemove) {
			EcoreUtil.delete(connection, true);
		}
	}
	
	private void removeShapesWithouBusinessObject(final Diagram diagram) {	
		final List<Shape> shapesToRemove = new ArrayList<Shape>();		
		for(final Shape shape : diagram.getChildren()) {
			final Object bo = AadlElementWrapper.unwrap(this.getBusinessObjectForPictogramElement(shape));

			if(bo == null) {
				shapesToRemove.add(shape);
			} else {
				EObject emfBusinesObject = (EObject)bo;
				if(emfBusinesObject.eIsProxy()) {
					emfBusinesObject = EcoreUtil.resolve(emfBusinesObject, OsateResourceUtil.getResourceSet());
				}
	
				if(emfBusinesObject.eIsProxy()) {
					shapesToRemove.add(shape);
				}
			}
		}
		
		for(final Shape shape : shapesToRemove) {
			EcoreUtil.delete(shape, true);			
		}
	}
	
	private void updateClassifiers(final Diagram diagram, final Set<NamedElement> elements, int x, int y) {
		for(final NamedElement el : elements) {
			// Add a item for the classifier
			if(el instanceof Classifier) {
				PictogramElement pictogramElement = this.getFeatureProvider().getPictogramElementForBusinessObject(el);
				if(pictogramElement == null) {
					final AddContext addContext = new AddContext();
					addContext.setNewObject(new AadlElementWrapper(el));
					addContext.setTargetContainer(diagram);
					addContext.setX(x);
					addContext.setY(y);
					
					final IAddFeature addFeature = getFeatureProvider().getAddFeature(addContext);
					if(addFeature.canAdd(addContext)) {			
						pictogramElement = addFeature.add(addContext);
						x += 150;
						if(x > 800) {
							y += 70;
							x = 0;
						}
					}
				} else {				
					final UpdateContext updateContext = new UpdateContext(pictogramElement);
					final IUpdateFeature updateFeature = getFeatureProvider().getUpdateFeature(updateContext);
					// TODO: Call update even if not needed?
					if(updateFeature.canUpdate(updateContext)) {
						updateFeature.update(updateContext);
					}
				}
				
				// Update the layout of the classifier shape
				if(pictogramElement != null) {
					final LayoutContext layoutContext = new LayoutContext(pictogramElement);					
					final ILayoutFeature layoutFeature = getFeatureProvider().getLayoutFeature(layoutContext);
					if(layoutFeature != null && layoutFeature.canLayout(layoutContext)) {
						layoutFeature.layout(layoutContext);
					}
				}
			}

		}
	}
	
	private void updateRelationships(final Diagram diagram, final Set<NamedElement> elements) {
		final AadlPackage pkg = (AadlPackage)AadlElementWrapper.unwrap(this.getBusinessObjectForPictogramElement(diagram));
		for(final NamedElement el : elements) {
			if(el.getNamespace().getOwner() == pkg) {
				if(el instanceof ComponentType) {
					// Extension
					final ComponentType ct = (ComponentType)el;
					final TypeExtension te = ct.getOwnedExtension();
					if(te != null) {
						updateGeneralization(diagram, te);	
					}
				}
				
				if(el instanceof ComponentImplementation) {
					final ComponentImplementation ci = ((ComponentImplementation)el);
					
					// Implementation Extension
					final ImplementationExtension ie = ci.getOwnedExtension();
					if(ie != null) {	
						updateGeneralization(diagram, ie);					
					}
					
					// Realization
					final Realization realization = ci.getOwnedRealization();
					if(realization != null) {	
						updateGeneralization(diagram, realization);					
					}
				}
				
				if(el instanceof FeatureGroupType) {
					final FeatureGroupType fgt = (FeatureGroupType)el;
					final GroupExtension ge = fgt.getOwnedExtension();
					if(ge != null) {
						updateGeneralization(diagram, ge);	
					}
				}
			}
		}
	}
	
	private void updateGeneralization(final Diagram diagram, final Generalization generalization) {
		if(this.getFeatureProvider().getPictogramElementForBusinessObject(generalization) == null) {
			final IPeService peService = Graphiti.getPeService();
			
			final Classifier generalClassifier = generalization.getGeneral();
			final Classifier specificClassifier = generalization.getSpecific();

			// Get the pictogram objects for them
			final PictogramElement generalPictogramEl = this.getFeatureProvider().getPictogramElementForBusinessObject(generalClassifier);
			final PictogramElement specificPictogramEl = this.getFeatureProvider().getPictogramElementForBusinessObject(specificClassifier);
			
			if(generalPictogramEl == null) {
				throw new RuntimeException("Unhandled case, referenced general classifier is not in diagram. " + generalClassifier.getQualifiedName());
			}
			
			if(specificPictogramEl == null) {
				throw new RuntimeException("Unhandled case, referenced specific classifier is not in diagram. " + specificClassifier.getQualifiedName());
			}
	
			// Get anchors
			final Anchor generalAnchor = peService.getChopboxAnchor((AnchorContainer)generalPictogramEl);
			final Anchor specificAnchor = peService.getChopboxAnchor((AnchorContainer)specificPictogramEl);
			
			if(generalAnchor == null || specificAnchor == null) {
				throw new RuntimeException("Unhandled case. Unable to get chopbox anchor for pictogram elements");
			}
	
			// Call the add connection feature					
			final AddConnectionContext addContext = new AddConnectionContext(generalAnchor, specificAnchor);
			addContext.setNewObject(new AadlElementWrapper(generalization));
			addContext.setTargetContainer(diagram);
			
			final IAddFeature addFeature = getFeatureProvider().getAddFeature(addContext);
			if(addFeature.canAdd(addContext)) {
				addFeature.add(addContext);
			}
		}
	}
}
