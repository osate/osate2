package org.osate.ge.internal.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Connection;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.Element;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.ReferenceValue;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramCallSequence;
import org.osate.ge.internal.DiagramElement;
import org.osate.ge.internal.diagram.AgeDiagramElement;
import org.osate.ge.internal.diagram.DiagramNode;
import org.osate.ge.internal.query.DiagramNodeQuery;
import org.osate.ge.internal.query.QueryRunner;
import org.osate.ge.internal.query.QueryRunnerFactory;
import org.osate.ge.internal.query.RootAgeDiagramNodeQuery;
import org.osate.ge.internal.services.AadlPropertyService;
import org.osate.ge.internal.services.CachingService;
import org.osate.ge.internal.services.InternalReferenceBuilderService;
import org.osate.ge.internal.services.PropertyService;
import org.osate.ge.internal.services.AadlPropertyService.PropertyResult;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.CachingService.Cache;

public class DefaultAadlPropertyService implements AadlPropertyService {
	private final IDiagramTypeProvider dtp;
	private final PropertyService propertyService;
	private final BusinessObjectResolutionService bor;
	private DiagramNode rootDiagramElement;
	private final DiagramNodeQuery<Object> rootDiagramElementQuery = new RootAgeDiagramNodeQuery(() -> this.rootDiagramElement);
	private final DiagramNodeQuery<Object> supportedChildrenQuery = rootDiagramElementQuery.children().filter((fa) -> isElementSupportedNamedElement(fa.getBusinessObject()));
	private final QueryRunner queryRunner;
	
	private final Cache cache = new Cache() {
		@Override
		public void invalidate() {
			// TODO
		}			
	};
	
	public DefaultAadlPropertyService(final CachingService cachingService, 
			final IDiagramTypeProvider dtp,
			final PropertyService propertyService,
			final BusinessObjectResolutionService bor,
			final QueryRunnerFactory queryRunnerFactory) {
		Objects.requireNonNull(cachingService, "cachingService must not be null");
		this.dtp = Objects.requireNonNull(dtp, "dtp must not be null");
		this.propertyService = Objects.requireNonNull(propertyService, "propertyService must not be null");
		this.bor = Objects.requireNonNull(bor, "bor must not be null");
		this.queryRunner = queryRunnerFactory.create();
		
		cachingService.registerCache(cache);
	}
	
	private final List<DiagramNode> getSupportedChildren(final AgeDiagramElement e) {
		rootDiagramElement = e;
		return queryRunner.getResults(supportedChildrenQuery, null);		
	}
	
	@Override
	public PropertyResult getValue(final DiagramElement diagramElement, final String propertySetName, final String propertyName) {
		// TODO: For testing.. Process the diagram.. Need to lazy process
		//processDiagramPropertyAssociations(dtp.getDiagram());
		
		// TODO: Convert diagram element proxy into a reference/bo path
		
		// TODO: Lazily evaluate the property
	
		// Assume path [test_pkg, test_sys]
		// Evaluate property in test_pkg and test_sys.
		// Go ahead and process any property associations found in these... Have to build tree to multiple levels... 
		
		// TODO: Everything is related to shapes.. Not connections. Need to use logical tree walker...
		// TODO: Need to only support core AADL model elements.. ignore annex...

		
		// TODO: Handle refined features appropriately. Already handled?
		return null;
	}
	
	// TODO
	/*
	private void processDiagramPropertyAssociations(final Diagram diagram) {
		// TODO: For testing: process all root elements.
		if(propertyService.isLogicalTreeNode(diagram)) {
			processPropertyAssociations(diagram); // TODO: Pass in context. Blank...
		} else {
			for(final PictogramElement childPe : getSupportedChildren(dtp.getDiagram())) {
				processPropertyAssociations(childPe); // TODO: Pass in context. Blank...
			}
		}
	}
	
	private void processPropertyAssociations(final PictogramElement pe) {
		// TODO: Pass in context
		processPropertyAssociations(pe, (NamedElement)bor.getBusinessObjectForPictogramElement(pe));
	}
	*/
	/**
	 * Returns true if the element is a named element and the property service should process the element when determining property values
	 * @param e
	 * @return
	 */
	private boolean isElementSupportedNamedElement(final Object e) {
		return e instanceof AadlPackage ||
				e instanceof Classifier ||
				e instanceof Feature ||
				e instanceof Subcomponent ||
				e instanceof Connection ||
				e instanceof FlowSpecification ||
				e instanceof FlowImplementation ||
				e instanceof EndToEndFlow ||
				e instanceof SubprogramCallSequence ||
				e instanceof SubprogramCall ||
				e instanceof Mode ||
				e instanceof ModeTransition;
	}	
	
	// TODO: Need context
	// TODO: Need to do this lazily instead of processing all properties at once
	/*
	private void processPropertyAssociations(final PictogramElement pe, final NamedElement ne) {
		// Special handling for classifiers
		if(ne instanceof Classifier) {
			// TODO: Rework!
			processPropertyAssociations((Classifier)ne, null); // TODO: Need context
		} else { // Default handling
			processPropertyAssociations(ne.getOwnedPropertyAssociations(), null); // TODO: Need context
			
			// Process children
			for(final PictogramElement childPe : getSupportedChildren(dtp.getDiagram())) {
				processPropertyAssociations(childPe); // TODO: Pass in context.
			}
		}
	}
*/
	private void processPropertyAssociations(final Classifier classifier, final Object ctx) {
		// TODO: Rework. Want to process in the appropriate order but want to only process subcomponents that are in the diagram.
		for(final Classifier tmpClassifier : classifier.getSelfPlusAllExtended()) {
			if(tmpClassifier instanceof ComponentImplementation) {
				final ComponentImplementation ci = (ComponentImplementation)tmpClassifier;
				
				for(final Subcomponent sc : ci.getOwnedSubcomponents()) {
					if(sc.getOwnedPropertyAssociations().size() > 0) {
						// TODO
						/*
						// Get subcomponent shape
						final Shape subcomponentShape = shapeService.getChildShapeByElementName(classifierShape, sc);
						if(subcomponentShape instanceof ContainerShape) {
							// Process the subcomponent's bindings
							processBindings(bindingTrackerMap, sc.getOwnedPropertyAssociations(), (ContainerShape)subcomponentShape);
						}
						*/
					}
				}
			}

			processPropertyAssociations(classifier.getOwnedPropertyAssociations(), ctx); // TODO: Check context
		}

		// Process Subcomponent Bindings
		// TODO: Rework as appropriate
		/*
		if(classifier instanceof ComponentImplementation) {
			final ComponentImplementation ci = (ComponentImplementation)classifier;
			for(final Subcomponent sc : ci.getAllSubcomponents()) {				
				final Shape subcomponentShape = shapeService.getChildShapeByElementName(classifierShape, sc);				
				if(subcomponentShape != null) {
					final Classifier subcomponentClassifier = subcomponentService.getComponentClassifier(subcomponentShape, sc);
					if(subcomponentClassifier != null && subcomponentShape instanceof ContainerShape) {
						processBindings(bindingTrackerMap, subcomponentClassifier, (ContainerShape)subcomponentShape);
					}
				}
			}	
		}
		*/
	}
	
	// TODO: ctx need to be used
	private void processPropertyAssociations(final List<PropertyAssociation> propertyAssociations, final Object ctx/*final ContainerShape ctxShape*/) {
		for(final PropertyAssociation pa : propertyAssociations) {
			// TODO: Cleanup
			// Get the binding tracker
			//final BindingTracker bindingTracker = bindingTrackerMap.get(pa.getProperty());
			
			// Get the shape(s) it applies to
			if(pa.getAppliesTos().size() == 0) {
				// TODO
				//processBinding(bindingTracker, ctxShape, pa, ctxShape);
			} else {
				for(final ContainedNamedElement appliesTo : pa.getAppliesTos()) {
					// TODO
					//final PictogramElement appliesToPictogramElement = getReferencedPictogramElement(ctxShape, appliesTo);
					//processBinding(bindingTracker, appliesToPictogramElement, pa, ctxShape);
				}
			}
		}
	}
	
	private void processBinding(final PropertyAssociation pa, final Object paCtx) {
		// TODO: Check if already finalized
		//if(boundPictogramElement != null && !bindingTracker.isPictogramElementFinalized(boundPictogramElement)) {			
			// in the typical case(property association only applies to one object?)
			// Find referenced shapes			
			for(final ModalPropertyValue pv : pa.getOwnedValues()) {				
				if(pv.getOwnedValue() instanceof ListValue) {
					final ListValue lv = (ListValue)pv.getOwnedValue();
					final List<PropertyExpression> listPropExpressions = lv.getOwnedListElements();
					
					// Iterate backwards so we can prepend bindings properly.
					for(int i = listPropExpressions.size() - 1; i >= 0; i--) {
						final PropertyExpression listPropExpression = listPropExpressions.get(i);
						if(listPropExpression instanceof ReferenceValue) {
							final ReferenceValue referenceValue = (ReferenceValue)listPropExpression;
							//final PictogramElement referencedPictogramElement = getReferencedPictogramElement(propAssocCtxShape, referenceValue);
							//bindingTracker.prependBinding(boundPictogramElement, referencedPictogramElement);
						}
					}
				}
			//}
			
			// Finalize the shape
			if(!pa.isAppend()) {
				// TODO
				//bindingTracker.finalizePictogramElement(boundPictogramElement);
			}
		}
	}
}
