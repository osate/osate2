package org.osate.ge.internal.diagram.boTree;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.Generalization;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.ModeTransitionTrigger;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.di.Activate;
import org.osate.ge.di.Names;
import org.osate.ge.internal.diagram.ContentsFilter;
import org.osate.ge.internal.diagram.DiagramConfiguration;
import org.osate.ge.internal.diagram.RelativeBusinessObjectReference;
import org.osate.ge.internal.query.Queryable;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.ReferenceService;

// TODO: Rename
public class DefaultTreeExpander implements TreeExpander {	
	// A simple business object context which is to designed to represent the project level. It has no parent and it has no business object.
	private final BusinessObjectContext projectBoc = new BusinessObjectContext() {					
		@Override
		public Collection<? extends Queryable> getChildren() {
			return Collections.emptyList();
		}
		
		@Override
		public BusinessObjectContext getParent() {
			return null;
		}
		
		@Override
		public Object getBusinessObject() {
			return null;
		}
	};
	
	private final ExtensionService extService;
	private final ReferenceService refService;
	private final DefaultBusinessObjectNodeFactory nodeFactory;
	
	public DefaultTreeExpander(final ExtensionService extService,
			final ReferenceService refService,
			final DefaultBusinessObjectNodeFactory nodeFactory) {
		this.extService = Objects.requireNonNull(extService, "extService must not be null");
		this.refService = Objects.requireNonNull(refService, "refService must not be null");
		this.nodeFactory = Objects.requireNonNull(nodeFactory, "nodeFactory must not be null");
	}
	
	/**
	 * Creates a new tree with nodes based on business objects provided by providers and auto content filters.		
	 * @param configuration
	 * @param tree
	 * @return
	 */
	@Override
	public BusinessObjectNode expandTree(final DiagramConfiguration configuration, BusinessObjectNode tree) {
		// Refresh Child Nodes
		final IEclipseContext eclipseCtx = extService.createChildContext();
		try {		
			// TODO: DOcument special handling of potential business objects to avoid listing packages, etc.
			// Determine what business objects are required based on the diagram configuration
			final Collection<Object> potentialBusinessObjects;
			final ContentsFilter filter;
			if(configuration.getRootBoReference() == null) {
				// Get potential root business objects from providers
				potentialBusinessObjects = getChildBusinessObjectsFromProviders(eclipseCtx, projectBoc);
				filter = ContentsFilter.ALLOW_FUNDAMENTAL; // Only business objects that already exist in the business object tree should be used
			} else{
				// Get the root business object
				Object rootBo = refService.resolve(configuration.getRootBoReference());
				if(rootBo == null) {
					throw new RuntimeException("Unable to find root business object");
				}
				
				potentialBusinessObjects = Collections.singleton(rootBo);
				filter = ContentsFilter.ALLOW_ALL; // Require the use of the business object specified in the diagram along with any other business objects which are already in the diagram.
			}
	
			final BusinessObjectNode newRoot = nodeFactory.create(null, null, true, filter, Completeness.UNKNOWN);
			
			// TODO: Rename
			final Map<RelativeBusinessObjectReference, BusinessObjectNode> oldNodes = tree.getChildrenMap();	
			final Map<RelativeBusinessObjectReference, Object> boMap = getChildBusinessObjects(potentialBusinessObjects, oldNodes.keySet(), newRoot.getAutoContentsFilter());
			createNodes(eclipseCtx, boMap, oldNodes, newRoot);
			newRoot.setCompleteness(potentialBusinessObjects.size() == boMap.size() ? Completeness.COMPLETE : Completeness.INCOMPLETE);
			
			return newRoot;
		} finally {
			eclipseCtx.dispose();
		}
	}	

	// TODO: Rename oldNodeMap
	private void createNodes(
			final IEclipseContext eclipseCtx,
			final Map<RelativeBusinessObjectReference, Object> newBoMap, 
			final Map<RelativeBusinessObjectReference, BusinessObjectNode> oldNodeMap,
			final BusinessObjectNode parentNode) {
		for(final Entry<RelativeBusinessObjectReference, Object> childEntry : newBoMap.entrySet()) {
			// Create node	
			final Object childBo = childEntry.getValue();
			final RelativeBusinessObjectReference childRelReference = childEntry.getKey();			
			createNode(eclipseCtx, newBoMap, oldNodeMap, parentNode, childBo, childRelReference);			
		}
	}
	
	private void createNode(
			final IEclipseContext eclipseCtx,
			final Map<RelativeBusinessObjectReference, Object> newBoMap, 
			final Map<RelativeBusinessObjectReference, BusinessObjectNode> oldNodeMap,
			final BusinessObjectNode parentNode,
			final Object bo,
			final RelativeBusinessObjectReference relReference) {		
		// TODO: Check the old node map
		final BusinessObjectNode oldNode = oldNodeMap.get(relReference); // TODO: Rename
		
		// Create the node
		final ContentsFilter autoContentsFilter = oldNode == null || oldNode.getAutoContentsFilter() == null ? ContentsFilter.ALLOW_FUNDAMENTAL : oldNode.getAutoContentsFilter();
		final BusinessObjectNode newNode = nodeFactory.create(parentNode, bo, oldNode == null ? false : oldNode.isManual(), autoContentsFilter, Completeness.UNKNOWN);
    	
		// Determine the business objects for which nodes in the tree should be created.
    	// TODO: Shortcut getting the potential business objects if auto contents filter is none and there are no children..
    	final Map<RelativeBusinessObjectReference, BusinessObjectNode> childOldNodes =
    			oldNode == null ?
    			Collections.emptyMap() :
    			oldNode.getChildrenMap();    	
    	final Collection<Object> childBusinessObjectsFromProviders = getChildBusinessObjectsFromProviders(eclipseCtx, newNode);
    	final Map<RelativeBusinessObjectReference, Object> childBoMap = getChildBusinessObjects(childBusinessObjectsFromProviders, childOldNodes.keySet(), autoContentsFilter);    	
    	newNode.setCompleteness(childBusinessObjectsFromProviders.size() == childBoMap.size() ? Completeness.COMPLETE : Completeness.INCOMPLETE);
    	createNodes(eclipseCtx, childBoMap, childOldNodes, newNode);
	}
	
	// Build a collection of all the child business objects that are needed based on children from providers, 
	// old nodes, and the auto contents filter	
	// TODO: Describe purpose
	private Map<RelativeBusinessObjectReference, Object> getChildBusinessObjects(final Collection<Object> potentialBusinessObjects,
			final Collection<RelativeBusinessObjectReference> oldNodeRefs, // TODO: Rename
			final ContentsFilter contentsFilter) {
		
		// TODO: Rename
		final Map<RelativeBusinessObjectReference, Object> potentialBusinessObjectsMap = potentialBusinessObjects.stream().
				collect(Collectors.toMap(
						(bo) -> Objects.requireNonNull(refService.getRelativeReference(bo), "Unable to build relative reference for " + bo),
						Function.identity(),
						(k1, k2) -> k1));
		
		switch(contentsFilter) {
		case ALLOW_ALL:
			return potentialBusinessObjectsMap;			

		case ALLOW_FUNDAMENTAL:
		{
			// TODO: Objects from old node map and filtered objects from providers			
			final Map<RelativeBusinessObjectReference, Object> results = createReferenceToBusinessObjectMapFromReferences(oldNodeRefs, potentialBusinessObjectsMap);			
			potentialBusinessObjectsMap.entrySet().stream().
				filter((e) -> isFundamental(e.getValue())).
				sequential().
				forEach((e) -> {
					results.put(e.getKey(), e.getValue());
				});

			return results;
		}
		
		case ALLOW_TYPE: {
			// TODO: Objects from old node map and filtered objects from providers			
			final Map<RelativeBusinessObjectReference, Object> results = createReferenceToBusinessObjectMapFromReferences(oldNodeRefs, potentialBusinessObjectsMap);			
			potentialBusinessObjectsMap.entrySet().stream().
				filter((e) -> isInType(e.getValue())).
				sequential().
				forEach((e) -> {
					results.put(e.getKey(), e.getValue());
				});

			return results;
		}
			
		default:
			throw new RuntimeException("Unhandled contents filter: " + contentsFilter);
		
		}
	}
	
	// TODO: Rename
	// TODO: Describe purpose. Get up to date business objects
	private Map<RelativeBusinessObjectReference, Object> createReferenceToBusinessObjectMapFromReferences(final Collection<RelativeBusinessObjectReference> refs,
			Map<RelativeBusinessObjectReference, Object> potentialBusinessObjectsMap) {
		final Map<RelativeBusinessObjectReference, Object> results = new HashMap<>();
		for(final RelativeBusinessObjectReference relRef : refs) {
			final Object bo = potentialBusinessObjectsMap.get(relRef);
			if(bo != null) {
				results.put(relRef, bo);
			}
		}
		return results;
	}
	
	private boolean isFundamental(final Object bo) {
		return bo instanceof Generalization || bo instanceof ModeTransitionTrigger;
	}	
	
	private boolean isInType(final Object bo) {
		return bo instanceof Classifier || 
				bo instanceof Generalization || 
				bo instanceof Feature || 
				bo instanceof FlowSpecification || 
				bo instanceof Mode || 
				bo instanceof ModeTransition;
	}
	
	/**
	 * The eclipse context must contain the arguments for the business object providers
	 * @param eclipseCtx
	 * @return
	 */
	private Collection<Object> getChildBusinessObjectsFromProviders(final IEclipseContext eclipseCtx, final BusinessObjectContext boc) {
		eclipseCtx.set(Names.BUSINESS_OBJECT, boc.getBusinessObject());
		eclipseCtx.set(Names.BUSINESS_OBJECT_CONTEXT, boc);
		
		// Use business object providers to determine the children
		Stream<Object> allChildren = Stream.empty();
		for(final Object bop : extService.getBusinessObjectProviders()) {
			final Stream<?> childBos = (Stream<?>)ContextInjectionFactory.invoke(bop, Activate.class, eclipseCtx, null);
			if(childBos != null) {
				allChildren = Stream.concat(allChildren, childBos);
			}
		};
		
	
		return allChildren.distinct().collect(Collectors.toList());
	}
}
