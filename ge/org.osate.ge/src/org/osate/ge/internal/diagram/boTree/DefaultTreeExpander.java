package org.osate.ge.internal.diagram.boTree;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.Property;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.diagram.BuiltinContentsFilter;
import org.osate.ge.internal.diagram.ContentsFilter;
import org.osate.ge.internal.diagram.DiagramConfiguration;
import org.osate.ge.internal.diagram.RelativeBusinessObjectReference;
import org.osate.ge.internal.model.PropertyResultValue;
import org.osate.ge.internal.query.Queryable;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.ProjectProvider;
import org.osate.ge.internal.services.ReferenceService;
import org.osate.ge.internal.util.AadlPropertyResolver;
import org.osate.ge.internal.util.BusinessObjectProviderHelper;
import org.osate.ge.internal.util.PropertyResult;
import org.osate.ge.internal.util.ScopedEMFIndexRetrieval;
import org.osate.ge.internal.util.PropertyResult.NullReason;

/**
 * A TreeExpander whose results contain all elements provided by registered business object providers which are already in the diagram business object tree
 * or indicated by auto contents filter.
 * 
 * Diagrams which have a context business object specified will only contain the specified business object as a root.
 */
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
	
	private final ProjectProvider projectProvider;
	private final ExtensionService extService;
	private final ReferenceService refService;
	private final DefaultBusinessObjectNodeFactory nodeFactory;
	
	public DefaultTreeExpander(final ProjectProvider projectProvider,
			final ExtensionService extService,
			final ReferenceService refService,
			final DefaultBusinessObjectNodeFactory nodeFactory) {
		this.projectProvider = Objects.requireNonNull(projectProvider, "projectProvider must not be null");
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
	public BusinessObjectNode expandTree(final DiagramConfiguration configuration, final BusinessObjectNode tree) {
		if(configuration.getContextBoReference() == null) {
			// Contextless diagrams are not currently supported. While this class may have appropriate support,
			// Such diagrams have not been adequately tested and other parts of the editor do not support them.
			throw new RuntimeException("Contextless diagrams are not supported");
		}
		
		// Refresh Child Nodes
		try(final BusinessObjectProviderHelper bopHelper = new BusinessObjectProviderHelper(extService)) {		
			// If the context business object is non-null, then only one business object may exist at the root of the resulting tree and it must be the context business object. 
			// This restriction prevents the need to retrieve all packages as potential top level business objects.
			// Determine what business objects are required based on the diagram configuration
			final Collection<Object> potentialBusinessObjects;
			final BuiltinContentsFilter filter;			
			if(configuration.getContextBoReference() == null) {			
				// Get potential top level business objects from providers
				potentialBusinessObjects = bopHelper.getChildBusinessObjects(projectBoc);
				filter = BuiltinContentsFilter.ALLOW_FUNDAMENTAL; // Only business objects that already exist in the business object tree should be used
			} else{
				// Get the context business object
				Object contextBo = refService.resolve(configuration.getContextBoReference());
				if(contextBo == null) {
					throw new RuntimeException("Unable to find context business object");
				}
				
				potentialBusinessObjects = Collections.singleton(contextBo);
				filter = BuiltinContentsFilter.ALLOW_ALL; // Require the use of the business object specified in the diagram along with any other business objects which are already in the diagram.
			}
	
			final BusinessObjectNode newRoot = nodeFactory.create(null, null, true, filter, Completeness.UNKNOWN);
			
			// Populate the new tree
			final Map<RelativeBusinessObjectReference, BusinessObjectNode> oldNodes = tree.getChildrenMap();	
			final Map<RelativeBusinessObjectReference, Object> boMap = getChildBusinessObjects(potentialBusinessObjects, oldNodes.keySet(), newRoot.getAutoContentsFilter());
			createNodes(bopHelper, boMap, oldNodes, newRoot);
			newRoot.setCompleteness(potentialBusinessObjects.size() == boMap.size() ? Completeness.COMPLETE : Completeness.INCOMPLETE);
						
			// Build set of the names of all properties which are enabled
			final Set<String> enabledPropertyNames = new HashSet<>(configuration.getEnabledAadlPropertyNames());
			enabledPropertyNames.add("communication_properties::timing"); // Add properties which are always enabled regardless of configuration setting

			// Get the property objects
			final Set<Property> enabledProperties = getPropertiesByLowercasePropertyNames(enabledPropertyNames);
			
			// Process properties
			final AadlPropertyResolver propertyResolver = new AadlPropertyResolver(newRoot);
			processProperties(propertyResolver, newRoot, enabledProperties);			
			
			return newRoot;
		}
	}
	
	private Set<Property> getPropertiesByLowercasePropertyNames(final Set<String> lcPropertyNames) {
		final Set<Property> properties = new HashSet<>();
		for(final IEObjectDescription desc : ScopedEMFIndexRetrieval.getAllEObjectsByType(projectProvider.getProject(), Aadl2Package.eINSTANCE.getProperty())) {
			final String lowercasePropertyName = desc.getName().toString("::").toLowerCase();
			if(lcPropertyNames.contains(lowercasePropertyName)) {
				EObject property = desc.getEObjectOrProxy();
				property = EcoreUtil.resolve(property, OsateResourceUtil.getResourceSet());
				if(!Aadl2Util.isNull(property)) {
					properties.add((Property)property);
				}
			}
		}
		return properties;
	}
	
	public void processProperties(final AadlPropertyResolver pr, final BusinessObjectNode node, final Collection<Property> properties) {
		final Deque<Integer> indicesStack = new ArrayDeque<Integer>();
		for(final Property property : properties) {
			final PropertyResult result = PropertyResult.getPropertyValue(pr, node, property, false, false); // Don't include default property values
			if(result != null) {
				// Don't show undefined or inherited property values
				if(result.nullReason != NullReason.UNDEFINED) {
					// Loop test
					indicesStack.clear();
					createPropertyValueBusinessObjects(node, property, result, result.value, indicesStack);					
				}
			}
		}
		
		for(final BusinessObjectNode child : node.getChildren()) {
			processProperties(pr, child, properties);
		}
	}
	
	void createPropertyValueBusinessObjects(final BusinessObjectNode node,
			final Property property, 
			final PropertyResult propertyResult, 
			final Object value, 
			final Deque<Integer> indicesStack) {
		boolean shouldCreateBusinessObject = true;
		if(value instanceof List) {
			@SuppressWarnings("unchecked")
			final List<Object> valueList = (List<Object>)value;
			int idx = 0;
			for(final Object element : valueList) {
				// Update indices stack and create business object(s)
				indicesStack.addLast(idx);
				createPropertyValueBusinessObjects(node, property, propertyResult, element, indicesStack);
				indicesStack.removeLast();
				idx++;
			}

			// Create a business object for the entire list if the stack is empty.
			shouldCreateBusinessObject = indicesStack.size() == 0;
		}
		
		if(shouldCreateBusinessObject) {
			nodeFactory.create(node, 
				new PropertyResultValue(property, node.getBusinessObject(), propertyResult, value, indicesStack), 
				false, 
				BuiltinContentsFilter.ALLOW_FUNDAMENTAL, 
				Completeness.COMPLETE);
		}
	}
	
	private void createNodes(
			final BusinessObjectProviderHelper bopHelper,
			final Map<RelativeBusinessObjectReference, Object> newBoMap, 
			final Map<RelativeBusinessObjectReference, BusinessObjectNode> oldNodeMap,
			final BusinessObjectNode parentNode) {
		for(final Entry<RelativeBusinessObjectReference, Object> childEntry : newBoMap.entrySet()) {
			// Create node	
			final Object childBo = childEntry.getValue();
			final RelativeBusinessObjectReference childRelReference = childEntry.getKey();			
			createNode(bopHelper, newBoMap, oldNodeMap, parentNode, childBo, childRelReference);			
		}
	}
	
	private void createNode(
			final BusinessObjectProviderHelper bopHelper,
			final Map<RelativeBusinessObjectReference, Object> newBoMap, 
			final Map<RelativeBusinessObjectReference, BusinessObjectNode> oldNodeMap,
			final BusinessObjectNode parentNode,
			final Object bo,
			final RelativeBusinessObjectReference relReference) {		
		// Get the node which is in the input tree from the old node map
		final BusinessObjectNode oldNode = oldNodeMap.get(relReference);
		
		// Create the node
		final ContentsFilter autoContentsFilter = oldNode == null || oldNode.getAutoContentsFilter() == null ? BuiltinContentsFilter.getDefault(bo) : oldNode.getAutoContentsFilter();
		final BusinessObjectNode newNode = nodeFactory.create(parentNode, bo, oldNode == null ? false : oldNode.isManual(), autoContentsFilter, Completeness.UNKNOWN);
    	
		// Determine the business objects for which nodes in the tree should be created.
    	final Map<RelativeBusinessObjectReference, BusinessObjectNode> childOldNodes =
    			oldNode == null ?
    			Collections.emptyMap() :
    			oldNode.getChildrenMap();    	
    	final Collection<Object> childBusinessObjectsFromProviders = bopHelper.getChildBusinessObjects(newNode);
    	final Map<RelativeBusinessObjectReference, Object> childBoMap = getChildBusinessObjects(childBusinessObjectsFromProviders, childOldNodes.keySet(), autoContentsFilter);    	
    	newNode.setCompleteness(childBusinessObjectsFromProviders.size() == childBoMap.size() ? Completeness.COMPLETE : Completeness.INCOMPLETE);
    	createNodes(bopHelper, childBoMap, childOldNodes, newNode);
	}
		
	// Build a collection of all the child business objects based on children from providers, old nodes, and the auto contents filter	
	// It filters the potential business objects based on the children in the input tree and the auto contents filter.
	// If an object is in the previous tree, it will be in the new tree.
	// A map between the relative reference and the business object is returned.
	private Map<RelativeBusinessObjectReference, Object> getChildBusinessObjects(final Collection<Object> potentialBusinessObjects,
			final Collection<RelativeBusinessObjectReference> oldNodeRefs,
			final ContentsFilter contentsFilter) {
		
		final Map<RelativeBusinessObjectReference, Object> potentialBusinessObjectsMap = potentialBusinessObjects.stream().
				collect(Collectors.toMap(
						(bo) -> Objects.requireNonNull(refService.getRelativeReference(bo), "Unable to build relative reference for " + bo),
						Function.identity(),
						(k1, k2) -> k1));
		
		// Create a map containing potential business objects which existed in the input tree		
		final Map<RelativeBusinessObjectReference, Object> results = createReferenceToBusinessObjectMapFromReferences(oldNodeRefs, potentialBusinessObjectsMap);
		
		// Add additional objects based based on the content filter
		potentialBusinessObjectsMap.entrySet().stream().
			filter((e) -> contentsFilter.test(e.getValue())).
			sequential().
			forEach((e) -> {
				results.put(e.getKey(), e.getValue());
			});

		return results;
	}
	
	private Map<RelativeBusinessObjectReference, Object> createReferenceToBusinessObjectMapFromReferences(final Collection<RelativeBusinessObjectReference> refs,
			final Map<RelativeBusinessObjectReference, Object> potentialBusinessObjectsMap) {
		final Map<RelativeBusinessObjectReference, Object> results = new HashMap<>();
		for(final RelativeBusinessObjectReference relRef : refs) {
			final Object bo = potentialBusinessObjectsMap.get(relRef);
			if(bo != null) {
				results.put(relRef, bo);
			}
		}
		return results;
	}
}
