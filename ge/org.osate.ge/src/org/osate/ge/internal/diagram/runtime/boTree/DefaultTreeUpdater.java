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
package org.osate.ge.internal.diagram.runtime.boTree;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.Property;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.InstanceReferenceValue;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.ContentFilter;
import org.osate.ge.DiagramType;
import org.osate.ge.internal.aadlproperties.AadlPropertyResolutionResults;
import org.osate.ge.internal.aadlproperties.AadlPropertyResolver;
import org.osate.ge.internal.aadlproperties.AadlPropertyUtil;
import org.osate.ge.internal.aadlproperties.PropertyResult;
import org.osate.ge.internal.aadlproperties.PropertyResult.NullReason;
import org.osate.ge.internal.aadlproperties.PropertyValueUtil;
import org.osate.ge.internal.aadlproperties.ReferenceValueWithContext;
import org.osate.ge.internal.diagram.runtime.DiagramConfiguration;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;
import org.osate.ge.internal.model.AgePropertyValue;
import org.osate.ge.internal.model.BusinessObjectProxy;
import org.osate.ge.internal.model.EmbeddedBusinessObject;
import org.osate.ge.internal.model.PropertyValueGroup;
import org.osate.ge.internal.query.Queryable;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.ProjectProvider;
import org.osate.ge.internal.services.ProjectReferenceService;
import org.osate.ge.internal.util.BusinessObjectProviderHelper;
import org.osate.ge.internal.util.ContentFilterUtil;
import org.osate.ge.internal.util.ScopedEMFIndexRetrieval;
import org.osate.ge.services.QueryService;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;

/**
 * A TreeUpdater which create a tree which contains which contains contains nodes based all
 * provided by registered business object providers. Nodes are removed or created based on the input tree,
 * the business objects provided by the providers, diagram type, and whether a node has previously had its default children populated.
 *
 * Diagrams which have a context business object specified will only contain the specified business object as a root. Diagrams which do not have a context
 * may include any business objects which are returned by the business object providers when using the current IProject as the root business object context.
 */
public class DefaultTreeUpdater implements TreeUpdater {
	private final ProjectProvider projectProvider;
	private final ExtensionService extService;
	private final ProjectReferenceService refService;
	private final QueryService queryService;
	private final DefaultBusinessObjectNodeFactory nodeFactory;

	public DefaultTreeUpdater(final ProjectProvider projectProvider, final ExtensionService extService,
			final ProjectReferenceService refService, final QueryService queryService,
			final DefaultBusinessObjectNodeFactory nodeFactory) {
		this.projectProvider = Objects.requireNonNull(projectProvider, "projectProvider must not be null");
		this.extService = Objects.requireNonNull(extService, "extService must not be null");
		this.refService = Objects.requireNonNull(refService, "refService must not be null");
		this.queryService = Objects.requireNonNull(queryService, "queryService must not be null");
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
		try (final BusinessObjectProviderHelper bopHelper = new BusinessObjectProviderHelper(extService)) {
			final BusinessObjectNode newRoot = nodeFactory.create(null, UUID.randomUUID(), null, Completeness.UNKNOWN);

			final Map<RelativeBusinessObjectReference, Object> boMap;

			// If the context business object is non-null, then only one business object may exist at the root of the resulting tree and it must be the context
			// business object.
			// This restriction prevents the need to retrieve all packages as potential top level business objects.
			// Determine what business objects are required based on the diagram configuration
			if (configuration.getContextBoReference() == null) {
				// Get potential top level business objects from providers
				// A simple business object context which is used as the root BOC for contextless diagrams. It has no parent and used the current
				// project as the business object.
				final BusinessObjectContext contextlessRootBoc = new BusinessObjectContext() {
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
						return projectProvider.getProject();
					}
				};
				final Collection<Object> potentialRootBusinessObjects = bopHelper
						.getChildBusinessObjects(contextlessRootBoc);

				// Determine the root business objects
				final Set<RelativeBusinessObjectReference> existingRootBranches = tree.getChildrenMap().keySet();

				// Content filters are not supported for the root of diagrams.
				final ImmutableSet<ContentFilter> rootContentFilters = ImmutableSet.of();

				boMap = getChildBusinessObjects(potentialRootBusinessObjects, existingRootBranches, rootContentFilters);

				// Contextless diagrams are always considered complete
				newRoot.setCompleteness(Completeness.COMPLETE);

				// TODO: Is this the proper way to handle this? This is needed so the configure diagram dialog, etc will know which project should be used to
				// retrieve root objects.
				// Set the root of the BO tree to the project
				newRoot.setBusinessObject(projectProvider.getProject());
			} else {
				// Get the context business object
				Object contextBo = refService.resolve(configuration.getContextBoReference());
				if (contextBo == null) {
					final String contextLabel = refService.getLabel(configuration.getContextBoReference(),
							projectProvider.getProject());
					throw new RuntimeException("Unable to find context business object: "
							+ (contextLabel == null ? configuration.getContextBoReference() : contextLabel));
				}

				// Require the use of the business object specified in the diagram along with any other business objects which are already in the diagram.
				final RelativeBusinessObjectReference relativeReference = refService.getRelativeReference(contextBo);
				if (relativeReference == null) {
					throw new RuntimeException("Unable to build relative reference for context business object");
				}

				boMap = new HashMap<>();
				boMap.put(relativeReference, contextBo);
				newRoot.setCompleteness(Completeness.COMPLETE);
			}

			// Add embedded business objects to the child BO map
			addEmbeddedBusinessObjectsToBoMap(tree.getChildrenMap().values(), boMap);

			// Populate the new tree
			final Map<RelativeBusinessObjectReference, BusinessObjectNode> oldNodes = tree.getChildrenMap();
			createNodes(configuration.getDiagramType(), bopHelper, boMap, oldNodes, newRoot);

			// Build set of the names of all properties which are enabled
			final Set<String> enabledPropertyNames = new HashSet<>(configuration.getEnabledAadlPropertyNames());
			enabledPropertyNames.add("communication_properties::timing"); // Add properties which are always enabled regardless of configuration setting

			// Get the property objects
			final Set<Property> enabledProperties = getPropertiesByLowercasePropertyNames(enabledPropertyNames);

			// Process properties. This is done after everything else since properties may need to refer to other nodes.
			final AadlPropertyResolver propertyResolver = new AadlPropertyResolver(newRoot);
			processProperties(propertyResolver, newRoot, tree, enabledProperties);

			return newRoot;
		}
	}

	private Set<Property> getPropertiesByLowercasePropertyNames(final Set<String> lcPropertyNames) {
		final ResourceSet resourceSet = new ResourceSetImpl();
		final Set<Property> properties = new HashSet<>();
		for (final IEObjectDescription desc : ScopedEMFIndexRetrieval.getAllEObjectsByType(projectProvider.getProject(),
				Aadl2Package.eINSTANCE.getProperty())) {
			final String lowercasePropertyName = desc.getName().toString("::").toLowerCase();
			if (lcPropertyNames.contains(lowercasePropertyName)) {
				EObject property = desc.getEObjectOrProxy();
				property = EcoreUtil.resolve(property, resourceSet);
				if (!Aadl2Util.isNull(property)) {
					properties.add((Property) property);
				}
			}
		}
		return properties;
	}

	public void processProperties(final AadlPropertyResolver pr, final BusinessObjectNode node,
			final BusinessObjectNode oldNode, final Collection<Property> properties) {
		final Deque<Integer> indicesStack = new ArrayDeque<Integer>();
		final Multimap<BusinessObjectNode, AgePropertyValue> dstToValues = HashMultimap.create();
		processProperties(pr, node, oldNode, properties, indicesStack, dstToValues);
	}

	public void processProperties(final AadlPropertyResolver pr, final BusinessObjectNode node,
			final BusinessObjectNode oldNode, final Collection<Property> properties, final Deque<Integer> indicesStack,
			final Multimap<BusinessObjectNode, AgePropertyValue> dstToValues) {
		for (final Property property : properties) {
			// Get values from processed property associations and create property value objects while grouping them by destination.
			final PropertyResult result = PropertyResult.getProcessedPropertyValue(pr, queryService, node, property);
			if (result != null) {
				// Don't show undefined or inherited property values
				if (result.nullReason != NullReason.UNDEFINED) {
					indicesStack.clear();
					createPropertyValues(node, property, result, indicesStack, null, dstToValues);
				}
			}

			// For reference properties, do the same for unprocessed references.
			if (AadlPropertyUtil.isReferenceOrListReferenceType(property.getType())) {
				// Create property values which reference children which are not included in the diagram. These are stored as property associations
				// which have not been fully processed
				// The key is the path to the element is applies to
				final Map<String, PropertyResult> unprocessedReferencesResult = PropertyResult
						.getIncompletelyProcessedReferencePropertyValues(pr, queryService, node, property);

				if (!unprocessedReferencesResult.isEmpty()) {
					// Convert to property result value objects and place in the multimap based on destination.
					for (final Entry<String, PropertyResult> propertyResultEntry : unprocessedReferencesResult
							.entrySet()) {
						indicesStack.clear();
						final String appliesToDescendantRef = propertyResultEntry.getKey();
						createPropertyValues(node, property, propertyResultEntry.getValue(), indicesStack,
								appliesToDescendantRef, dstToValues);
					}
				}
			}

			// Iterate over unique destinations and create business objects for groups.
			for (final BusinessObjectNode dst : dstToValues.keySet()) {
				final Collection<AgePropertyValue> dstPropertyValues = dstToValues.get(dst);

				// Create the Property Value Group business object
				final UUID dstId = dst == null ? null : dst.getId();
				final PropertyValueGroup pvg = new PropertyValueGroup(property, dstId, dstPropertyValues);

				// Create the business object node for the property value group
				final RelativeBusinessObjectReference propRelRef = Objects
						.requireNonNull(refService.getRelativeReference(pvg), "unable to get relative reference");
				final BusinessObjectNode oldPropNode = oldNode == null ? null : oldNode.getChild(propRelRef);
				final UUID propNodeId = oldPropNode == null ? UUID.randomUUID() : oldPropNode.getId();
				new BusinessObjectNode(node, propNodeId, propRelRef, pvg, Completeness.COMPLETE, true);
			}

			dstToValues.clear(); // Clear map for the next use.
		}

		for (final BusinessObjectNode child : node.getChildren()) {
			final BusinessObjectNode oldChild = oldNode == null ? null : oldNode.getChild(child.getRelativeReference());
			processProperties(pr, child, oldChild, properties, indicesStack, dstToValues);
		}
	}

	private void createPropertyValues(final BusinessObjectNode node, final Property property, final PropertyResult pr,
			final Deque<Integer> indicesStack, final String appliesToDescendantRef,
			final Multimap<BusinessObjectNode, AgePropertyValue> dstToPropertyValues) {
		createPropertyValues(node, property, pr, pr.value, indicesStack, appliesToDescendantRef, dstToPropertyValues);
	}

	private void createPropertyValues(final BusinessObjectNode node, final Property property, final PropertyResult pr,
			final Object value, final Deque<Integer> indicesStack, final String appliesToDescendantRef,
			final Multimap<BusinessObjectNode, AgePropertyValue> dstToPropertyValues) {
		if (value instanceof List) {
			@SuppressWarnings("unchecked")
			final List<Object> valueList = ((List<Object>) value);
			int idx = 0;
			for (final Object innerValue : valueList) {
				indicesStack.addLast(idx);
				createPropertyValues(node, property, pr, innerValue, indicesStack, appliesToDescendantRef,
						dstToPropertyValues);
				indicesStack.removeLast();
				idx++;
			}
		} else {
			final BusinessObjectNode dst;
			boolean fullyResolved = true;
			if (value instanceof ReferenceValueWithContext) {
				final AadlPropertyResolutionResults rr = ((ReferenceValueWithContext) value).resolve(node,
						queryService);
				dst = (BusinessObjectNode) rr.dst;
				fullyResolved = !rr.isPartial;
			} else if (value instanceof ClassifierValue) {
				dst = (BusinessObjectNode) PropertyValueUtil.getReferencedClassifier(node, (ClassifierValue) value,
						queryService);
			} else if (value instanceof InstanceReferenceValue) {
				final InstanceReferenceValue irv = (InstanceReferenceValue) value;
				final InstanceObject referencedInstanceObject = irv.getReferencedInstanceObject();
				final AadlPropertyResolutionResults rr = PropertyValueUtil.getReferencedInstanceObject(node,
						referencedInstanceObject, queryService);
				dst = (BusinessObjectNode) rr.dst;
				fullyResolved = !rr.isPartial;
			} else {
				dst = null;
			}

			dstToPropertyValues.put(dst, new AgePropertyValue(pr, indicesStack, appliesToDescendantRef, fullyResolved));
		}
	}

	private void createNodes(final DiagramType diagramType, final BusinessObjectProviderHelper bopHelper,
			final Map<RelativeBusinessObjectReference, Object> newBoMap,
			final Map<RelativeBusinessObjectReference, BusinessObjectNode> oldNodeMap,
			final BusinessObjectNode parentNode) {
		for (final Entry<RelativeBusinessObjectReference, Object> childEntry : newBoMap.entrySet()) {
			// Create node
			final Object childBo = childEntry.getValue();
			final RelativeBusinessObjectReference childRelReference = childEntry.getKey();
			createNode(diagramType, bopHelper, oldNodeMap, parentNode, childBo, childRelReference);
		}
	}

	private void createNode(final DiagramType diagramType, final BusinessObjectProviderHelper bopHelper,
			final Map<RelativeBusinessObjectReference, BusinessObjectNode> oldNodeMap,
			final BusinessObjectNode parentNode, final Object bo, final RelativeBusinessObjectReference relReference) {
		// Get the node which is in the input tree from the old node map
		final BusinessObjectNode oldNode = oldNodeMap.get(relReference);

		// Create the node
		final ImmutableSet<ContentFilter> contentFilters = oldNode == null
				|| !oldNode.defaultChildrenHaveBeenPopulated() ? getDefaultContentFilters(diagramType, bo)
						: ImmutableSet.of();
				final UUID id = oldNode == null || oldNode.getId() == null ? UUID.randomUUID() : oldNode.getId();
				final BusinessObjectNode newNode = nodeFactory.create(parentNode, id, bo, Completeness.UNKNOWN);

				// Determine the business objects for which nodes in the tree should be created.
				final Map<RelativeBusinessObjectReference, BusinessObjectNode> childOldNodes = oldNode == null
						? Collections.emptyMap()
								: oldNode.getChildrenMap();
						final Collection<Object> childBusinessObjectsFromProviders = bopHelper.getChildBusinessObjects(newNode);

						final Map<RelativeBusinessObjectReference, Object> childBoMap = getChildBusinessObjects(
								childBusinessObjectsFromProviders, childOldNodes.keySet(), contentFilters);

						// Update the business objects before considering embedded business objects
						newNode.setCompleteness(childBusinessObjectsFromProviders.size() == childBoMap.size() ? Completeness.COMPLETE
								: Completeness.INCOMPLETE);

						addEmbeddedBusinessObjectsToBoMap(childOldNodes.values(), childBoMap);

						createNodes(diagramType, bopHelper, childBoMap, childOldNodes, newNode);
	}

	private static void addEmbeddedBusinessObjectsToBoMap(final Collection<BusinessObjectNode> childOldNodes,
			final Map<RelativeBusinessObjectReference, Object> boMap) {
		// Add embedded business objects to the child BO map
		for (final BusinessObjectNode childOldNode : childOldNodes) {
			if (childOldNode.getBusinessObject() instanceof EmbeddedBusinessObject) {
				boMap.put(childOldNode.getRelativeReference(), childOldNode.getBusinessObject());
			}
		}
	}

	private ImmutableSet<ContentFilter> getDefaultContentFilters(final DiagramType diagramType, final Object bo) {
		return diagramType.getApplicableDefaultContentFilters(bo, extService);
	}

	// Create a map between relative references and business objects for every business object which should be used as a child BO
	// Create entries for all potential business objects which pass the filter or are in the forcedRefs set.
	// Do not include objects unless relative reference exists
	private Map<RelativeBusinessObjectReference, Object> getChildBusinessObjects(
			final Collection<Object> potentialBusinessObjects, final Set<RelativeBusinessObjectReference> forcedRefs,
			final ImmutableSet<ContentFilter> contentFilters) {

		final Map<RelativeBusinessObjectReference, Object> results = new HashMap<>();
		for (final Object potentialBusinessObject : potentialBusinessObjects) {
			final RelativeBusinessObjectReference relativeReference = refService
					.getRelativeReference(potentialBusinessObject);
			if (relativeReference != null) {
				if (forcedRefs.contains(relativeReference) || extService.isFundamental(potentialBusinessObject)
						|| ContentFilterUtil.passesAnyContentFilter(potentialBusinessObject, contentFilters)) {
					// Special handling of proxies. Only resolve them if they are needed
					Object resolvedBo = potentialBusinessObject;
					if (potentialBusinessObject instanceof BusinessObjectProxy) {
						final BusinessObjectProxy proxy = (BusinessObjectProxy) potentialBusinessObject;
						resolvedBo = proxy.resolve(refService);
					}

					results.put(relativeReference, resolvedBo);
				}
			}
		}

		return results;
	}
}
