package org.osate.ge.internal.diagram.boTree;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.ArrayRange;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.ComputedValue;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.Generalization;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.ModeTransitionTrigger;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.NumberValue;
import org.osate.aadl2.Property;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.ReferenceValue;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.InstanceReferenceValue;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.di.Activate;
import org.osate.ge.di.Names;
import org.osate.ge.internal.diagram.ContentsFilter;
import org.osate.ge.internal.diagram.DiagramConfiguration;
import org.osate.ge.internal.diagram.RelativeBusinessObjectReference;
import org.osate.ge.internal.model.Tag;
import org.osate.ge.internal.query.Queryable;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.ProjectProvider;
import org.osate.ge.internal.services.ReferenceService;
import org.osate.ge.internal.util.AadlPropertyResolver;
import org.osate.ge.internal.util.PropertyResult;
import org.osate.ge.internal.util.ScopedEMFIndexRetrieval;
import org.osate.ge.internal.util.PropertyResult.NullReason;
import org.osate.ge.internal.util.PropertyResult.ReferenceValueWithContext;

/**
 * A TreeExpander whose results contain all elements provided by registered business object providers which are already in the diagram business object tree
 * or indicated by auto contents filter.
 * 
 * Diagrams which have a root business object specified will only contain the specified business object as a root.
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
		// Refresh Child Nodes
		final IEclipseContext eclipseCtx = extService.createChildContext();
		try {		
			// If the root business object is non-null, then only one root business object may existing in the diagram and it is restricted to the referenced object.
			// This restriction prevents the need to retrieve all packages as potential root business objects.
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
			
			// Populate the new tree
			final Map<RelativeBusinessObjectReference, BusinessObjectNode> oldNodes = tree.getChildrenMap();	
			final Map<RelativeBusinessObjectReference, Object> boMap = getChildBusinessObjects(potentialBusinessObjects, oldNodes.keySet(), newRoot.getAutoContentsFilter());
			createNodes(eclipseCtx, boMap, oldNodes, newRoot);
			newRoot.setCompleteness(potentialBusinessObjects.size() == boMap.size() ? Completeness.COMPLETE : Completeness.INCOMPLETE);
						
			// Build set of the names of all properties which are enabled
			final Set<String> enabledPropertyNames = new HashSet<>(configuration.getEnabledAadlPropertyNames());
			enabledPropertyNames.add("communication_properties::timing"); // Add properties which are always enabled regardless of configuration setting
			
			enabledPropertyNames.add("deployment_properties::actual_processor_binding"); // TODO: Remove.. added for testing
			
			// Get the property objects
			final Set<Property> enabledProperties = getPropertiesByLowercasePropertyNames(enabledPropertyNames);
			
			// TODO: What to do with property objects that already exist in tree? Will need to remove if they don't exist anymore? Or they should just be hidden when drawing..
			final AadlPropertyResolver propertyResolver = new AadlPropertyResolver(newRoot);
			testPropertyResolver(propertyResolver, newRoot, enabledProperties);			
			
			return newRoot;
		} finally {
			eclipseCtx.dispose();
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
	
	public void testPropertyResolver(final AadlPropertyResolver pr, final Queryable q, final Collection<Property> properties) {
		for(final Property property : properties) {
			final PropertyResult result = PropertyResult.getPropertyValue(pr, q, property);
			if(result != null) {
				final String boName = ((NamedElement)q.getBusinessObject()).getQualifiedName();
				if(result.value != null) {
					// TODO: Need a higher level function that handles the null reason
					final StringBuilder sb = new StringBuilder();
					appendPropertyValue(q, result.value, false, sb);
					System.err.println("ABBR: " + boName + " : " + property.getQualifiedName() + " : " + sb.toString());
					
					sb.setLength(0);
					appendPropertyValue(q, result.value, true, sb);
					System.err.println("FULL: " + boName + " : " + property.getQualifiedName() + " : " + sb.toString());
				} else {
					if(result.nullReason != NullReason.UNDEFINED) {
						System.err.println(boName + " : " + property.getQualifiedName() + " : " + result.nullReason);
					}
				}
			}
		}
		
		for(final Queryable child : q.getChildren()) {
			testPropertyResolver(pr, child, properties);
		}
	}
	
	@SuppressWarnings("unchecked")
	private static void appendPropertyValue(final Queryable q, final Object value, boolean expandLists, final StringBuilder sb) {
		if(value instanceof List) {
			if(expandLists) {
				sb.append('(');
				boolean isFirst = true;
				for(final Object element : (List<Object>)value) {
					if(!isFirst) {
						sb.append(", ");
					}
					isFirst = false;
					
					appendPropertyValue(q, element, expandLists, sb);
				}
				sb.append(')');
			}
			sb.append("<list>");
		} else {
			// TODO: Decide how to handle error cases
			if(value instanceof BooleanLiteral) {
				final BooleanLiteral bl = (BooleanLiteral)value;
				sb.append(bl.getValue() ? "true" : "false");
			} else if(value instanceof ClassifierValue) {
				final ClassifierValue cv = (ClassifierValue)value;
				sb.append(cv.getClassifier() == null ? "<Error>" : cv.getClassifier().getQualifiedName());
			} else if(value instanceof ComputedValue) {
				final ComputedValue cv = (ComputedValue)value;
				sb.append(cv.getFunction());
			} else if(value instanceof NamedValue) {
				final NamedValue nv = (NamedValue)value;
				if(nv.getNamedValue() == null) {
					// TODO					
				} else {
					appendPropertyValue(q, nv.getNamedValue(), expandLists, sb);
				}
			} else if(value instanceof AbstractNamedValue) {
				final AbstractNamedValue anv = (AbstractNamedValue)value;
				sb.append(anv instanceof NamedElement ? ((NamedElement)anv).getName() : "<Error>");
			} else if(value instanceof IntegerLiteral) {
				final IntegerLiteral il = (IntegerLiteral)value;
				sb.append(il.getValue());
				if(il.getUnit() != null) {
					sb.append(' ');
					sb.append(il.getUnit().getName());
				}
			} else if(value instanceof RealLiteral) {
				final RealLiteral rl = (RealLiteral)value;
				sb.append(rl.getValue());
				if(rl.getUnit() != null) {
					sb.append(' ');
					sb.append(rl.getUnit().getName());
				}
			} else if(value instanceof RangeValue) {
				final RangeValue rv = (RangeValue)value;
				appendPropertyValue(q, rv.getMinimum(), expandLists, sb);
				sb.append(" .. ");
				appendPropertyValue(q, rv.getMaximum(), expandLists, sb);
				if(rv.getDeltaValue() != null) {
					sb.append("delta ");
					appendPropertyValue(q, rv.getDelta(), expandLists, sb);
				}
			} else if(value instanceof RecordValue) {
				final RecordValue rv = (RecordValue)value;
				sb.append('[');
				for(final BasicPropertyAssociation bpa : rv.getOwnedFieldValues()) {
					sb.append(bpa.getProperty() == null ? "<UnknownField>" : bpa.getProperty().getName());
					sb.append(" => ");
					appendPropertyValue(q, bpa.getValue(), expandLists, sb);
					sb.append("; ");
				}
				sb.append(']');
			} else if(value instanceof StringLiteral) {
				final StringLiteral sl = (StringLiteral)value;
				sb.append('"');
				sb.append(sl.getValue());
				sb.append('"');
			} else if(value instanceof ReferenceValueWithContext) {
				final ReferenceValueWithContext rv = (ReferenceValueWithContext)value;
				
				Queryable tmp = q;
				for(int i = 0; i < rv.ownerAncestorLevel; i++) {
					tmp = q.getParent();
					if(tmp == null) {
						// TODO: Decide what to append
						return;
					}
				}
				
				// The reference is relative to the current value of tmp
				// Append Each Level Until Reaching the Containing Classifier
				String prefix = null;
				while(tmp != null && tmp.getBusinessObject() instanceof NamedElement && !(tmp.getBusinessObject() instanceof Classifier)) {
					final String containerName = ((NamedElement)tmp.getBusinessObject()).getName();
					if(containerName == null) {
						// TODO: Handle
						return;
					}
					
					if(prefix == null) {
						prefix = containerName;
					} else {
						prefix = containerName + "." + prefix;
					}
					
					tmp = tmp.getParent();
				}
				
				System.err.println("TESTD: " + prefix);
				
				//rv.ownerAncestorLevel
				// TODO: Handle relative portion.. need to add appropriate ancestors.
				// TODO: Is there a helper for generating path?
				if(prefix != null) {
					sb.append(prefix);
				}
				boolean isFirst = prefix == null;
				for(final ContainmentPathElement pathElement : rv.referenceValue.getContainmentPathElements()) {
					if(!isFirst) {
						sb.append(".");
					}
					isFirst = false;
					
					final NamedElement ne = pathElement.getNamedElement();
					if(ne == null) {
						// TODO: Handle null						
					} else {
						sb.append(ne.getName());
					}
					
					for(final ArrayRange ar : pathElement.getArrayRanges()) {
						sb.append('[');
						sb.append(ar.getLowerBound());
						if(ar.getUpperBound() > 0) {
							sb.append(" .. ");
							sb.append(ar.getUpperBound());
						}
						sb.append(']');
					}
				}
				
			} else if(value instanceof InstanceReferenceValue) {
				final InstanceReferenceValue irv = (InstanceReferenceValue)value;
				if(irv.getReferencedInstanceObject() != null) {					
					sb.append(irv.getReferencedInstanceObject().getComponentInstancePath());
				} else {
					sb.append("?");
				}
			} else if(value instanceof EObject) {
				final INode n = NodeModelUtils.getNode((EObject)value);
				if(n != null) {
					final String txt = NodeModelUtils.getTokenText(n);
					if(txt != null) {
						sb.append(txt);
						return;
					}
				}
				sb.append("<Unable to Retrieve>");
			} else {
				sb.append("<Unsupported Value Type>");
			}
		}
	}

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
		// Get the node which is in the input tree from the old node map
		final BusinessObjectNode oldNode = oldNodeMap.get(relReference);
		
		// Create the node
		final ContentsFilter autoContentsFilter = oldNode == null || oldNode.getAutoContentsFilter() == null ? getDefaultContentsFilter(bo) : oldNode.getAutoContentsFilter();
		final BusinessObjectNode newNode = nodeFactory.create(parentNode, bo, oldNode == null ? false : oldNode.isManual(), autoContentsFilter, Completeness.UNKNOWN);
    	
		// Determine the business objects for which nodes in the tree should be created.
    	final Map<RelativeBusinessObjectReference, BusinessObjectNode> childOldNodes =
    			oldNode == null ?
    			Collections.emptyMap() :
    			oldNode.getChildrenMap();    	
    	final Collection<Object> childBusinessObjectsFromProviders = getChildBusinessObjectsFromProviders(eclipseCtx, newNode);
    	final Map<RelativeBusinessObjectReference, Object> childBoMap = getChildBusinessObjects(childBusinessObjectsFromProviders, childOldNodes.keySet(), autoContentsFilter);    	
    	newNode.setCompleteness(childBusinessObjectsFromProviders.size() == childBoMap.size() ? Completeness.COMPLETE : Completeness.INCOMPLETE);
    	createNodes(eclipseCtx, childBoMap, childOldNodes, newNode);
	}
	
	private ContentsFilter getDefaultContentsFilter(final Object bo) {
		if(bo instanceof Subcomponent) {
			return ContentsFilter.ALLOW_TYPE;
		}
		
		return ContentsFilter.ALLOW_FUNDAMENTAL;
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
		
		switch(contentsFilter) {
		case ALLOW_ALL:
			return potentialBusinessObjectsMap;			

		case ALLOW_FUNDAMENTAL:
		{
			// Create a map containing potential business objects which existed in the input tree		
			final Map<RelativeBusinessObjectReference, Object> results = createReferenceToBusinessObjectMapFromReferences(oldNodeRefs, potentialBusinessObjectsMap);
			
			// Add additional objects based based on the content filter
			potentialBusinessObjectsMap.entrySet().stream().
				filter((e) -> isFundamental(e.getValue())).
				sequential().
				forEach((e) -> {
					results.put(e.getKey(), e.getValue());
				});

			return results;
		}
		
		case ALLOW_TYPE: {
			// Create a map containing potential business objects which existed in the input tree	
			final Map<RelativeBusinessObjectReference, Object> results = createReferenceToBusinessObjectMapFromReferences(oldNodeRefs, potentialBusinessObjectsMap);			
						
			// Add additional objects based based on the content filter
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
	
	private boolean isFundamental(final Object bo) {
		if(bo instanceof Generalization || bo instanceof ModeTransitionTrigger) {
			return true;
		}
		
		if(bo instanceof Tag) {
			final Tag tag = (Tag)bo;
			if(tag.key.equals(Tag.KEY_UNIDIRECTIONAL) ||
					tag.key.equals(Tag.KEY_SUBPROGRAM_CALL_CALLED_SUBPROGRAM)) {
				return true;
			}
		}
		
		return false;
	}	
	
	private boolean isInType(final Object bo) {
		if(isFundamental(bo) ||
				bo instanceof Classifier || 
				bo instanceof Generalization || 
				bo instanceof Feature || 
				bo instanceof FlowSpecification || 
				bo instanceof Mode || 
				bo instanceof ModeTransition) {
			return true;
		}
		
		if(bo instanceof Tag) {
			final Tag tag = (Tag)bo;
			if(tag.key.equals(Tag.KEY_SUBCOMPONENT_TYPE)) {
				return true;
			}
		}
		
		
		return false;
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
