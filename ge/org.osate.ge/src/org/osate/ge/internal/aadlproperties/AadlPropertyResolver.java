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
package org.osate.ge.internal.aadlproperties;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.Element;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.RefinableElement;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.PropertyAssociationInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.properties.PropertyAcc;
import org.osate.ge.internal.query.Queryable;
import org.osate.ge.internal.util.AadlPrototypeUtil;

import com.google.common.collect.Iterables;

/**
 * This class is intended to retrieve all property associations associated with a Queryable.
 * Upon instantiation, it processes all contained property associations contained in the Queryable tree's business objects or in related classifiers.
 * It associates processed associations with the Queryable closest to the element which it applies.
 * This is useful in the case of finding property associations which may reference queryables which are in the queryable tree.
 * Local non-contained property associations which belong to elements which are not in the queryable tree will not be processed.
 *
 * For instance model objects, only properties which are owned by instance objects in the queryable tree or are reference/list of references properties will be processed.
 *
 * Caveat: This class relies on OSATE's PropertyAcc class to handle local property associations which does not support binding specific property associations
 * at this time. If a property contains property associations for multiple bindings, only the first one will be processed.
 */
public class AadlPropertyResolver {
	private final Map<Queryable, PropertyNode> propertyNodeMap = new HashMap<>();

	/**
	 * Contains processed property associations for a specific Queryable.
	 *
	 */
	private static class ProcessedPropertyAssociationCollection {
		List<ProcessedPropertyAssociation> processedPropertyAssociations = new ArrayList<>();
		boolean includesLocalProperties = false;
	}

	private static class PropertyNode {
		ProcessedPropertyAssociationCollection getCreateProcessedPropertyAssociations(final Property property) {
			ProcessedPropertyAssociationCollection result = propertyNameToProcessedPropertyAssociationsMap.get(property);
			if(result == null) {
				result = new ProcessedPropertyAssociationCollection();
				propertyNameToProcessedPropertyAssociationsMap.put(property, result);
			}
			return result;
		}

		private final Map<Property, ProcessedPropertyAssociationCollection> propertyNameToProcessedPropertyAssociationsMap = new HashMap<>(); // Maping from property to Processed Property Association List
	}

	public AadlPropertyResolver(final Queryable topContext) {
		// Process Contained Property Associations
		if(topContext.getBusinessObject() instanceof Classifier) {
			processDeclarativeContainedPropertyAssociations(topContext, (Classifier) topContext.getBusinessObject());
		} else {
			processContainedPropertyAssociationsInChildren(topContext);
		}
	}

	private void processContainedPropertyAssociationsInChildren(final Queryable q) {
		// Process contained property associations contained in children
		for(final Queryable childQueryable : q.getChildren()) {
			final Object childBo = childQueryable.getBusinessObject();
			if (childBo instanceof InstanceObject) {
				processPropertyAssociationsForInstanceObjectsNotInTree(childQueryable, (InstanceObject) childBo);
			} else {
				if(childBo instanceof Subcomponent || childBo instanceof FeatureGroup) {
					final NamedElement childNamedElement = (NamedElement)childBo;

					// Handle refinements
					RefinableElement tmpRefinable = (RefinableElement)childNamedElement;
					do {
						processDeclarativeContainedPropertyAssociations(childQueryable,
								tmpRefinable.getOwnedPropertyAssociations());
						tmpRefinable = tmpRefinable.getRefinedElement();
					} while(tmpRefinable != null);

					// Process contained property associations contained in the element's classifier
					if(childBo instanceof FeatureGroup) {
						final FeatureGroupType featureGroupType = AadlPrototypeUtil.getFeatureGroupType(AadlPrototypeUtil.getPrototypeBindingContext(childQueryable), (FeatureGroup)childBo);
						if(featureGroupType != null) {
							processDeclarativeContainedPropertyAssociations(childQueryable, featureGroupType);
						}
					} else if(childBo instanceof Subcomponent) {
						final Classifier subcomponentClassifier = AadlPrototypeUtil.getComponentClassifier(AadlPrototypeUtil.getPrototypeBindingContext(childQueryable), (Subcomponent)childBo);
						if(subcomponentClassifier != null) {
							processDeclarativeContainedPropertyAssociations(childQueryable, subcomponentClassifier);
						}
					}
				} else if(childBo instanceof Classifier) {
					processDeclarativeContainedPropertyAssociations(childQueryable, ((Classifier) childBo));
				} else if(childBo instanceof AadlPackage) {
					processContainedPropertyAssociationsInChildren(childQueryable);
				}
			}
		}
	}

	/**
	 * Returns a list of processed property associations for a specific Queryable and property. The property associations order in the list
	 * will be such that elements earlier in the list should override elements later in the list.
	 * @param q
	 * @param property
	 * @return
	 */
	public final List<ProcessedPropertyAssociation> getProcessedPropertyAssociations(final Queryable q, final Property property) {
		final PropertyNode pn = getOrCreatePropertyNode(q);

		final ProcessedPropertyAssociationCollection ppas = pn.getCreateProcessedPropertyAssociations(property);

		// Add local property associations to the collection if it does not include them already.
		if(!ppas.includesLocalProperties) {
			Object bo = q.getBusinessObject();
			bo = bo instanceof ConnectionReference ? ((ConnectionReference)bo).eContainer() : bo; // Use the connection instance instead of the connection reference.
			if(bo instanceof NamedElement) {
				final NamedElement ne = (NamedElement)bo;
				final PropertyAcc pas = new PropertyAcc(property);
				ne.getPropertyValueInternal(property, pas, true);

				if(pas.getAssociations().size() > 0) {
					for(final PropertyAssociation localPa : pas.getAssociations()) {
						// Only process property associations without applies to. That should be the only kind contained in the PropertyAcc's list but
						// we check just to make sure. Property associations with applies to are contained property associations and have already been
						// processed
						if(localPa.getAppliesTos().size() == 0) {
							ppas.processedPropertyAssociations.add(
									new LocalProcessedPropertyAssociation(localPa));
						}
					}
				}
			}

			ppas.includesLocalProperties = true;
		}

		return ppas == null || ppas.processedPropertyAssociations == null ? Collections.emptyList() : Collections.unmodifiableList(ppas.processedPropertyAssociations);
	}

	private PropertyNode getOrCreatePropertyNode(final Queryable q) {
		Objects.requireNonNull(q, "q must not be null");

		// Get/Create the property node
		PropertyNode pn = propertyNodeMap.get(q);
		if(pn == null) {
			pn = new PropertyNode();
			propertyNodeMap.put(q, pn);
		}

		return pn;
	}

	private void processDeclarativeContainedPropertyAssociations(final Queryable q, final Classifier classifier) {
		// Process classifiers in the appropriate order while only processing elements that are included in the queryable tree.
		for(final Classifier tmpClassifier : classifier.getSelfPlusAllExtended()) {
			// Process the classifier's property associations
			processDeclarativeContainedPropertyAssociations(q, tmpClassifier.getOwnedPropertyAssociations());
		}

		processContainedPropertyAssociationsInChildren(q);
	}

	private void processDeclarativeContainedPropertyAssociations(final Queryable q,
			final List<PropertyAssociation> propertyAssociations) {
		for(final PropertyAssociation pa : propertyAssociations) {
			// Only process contained property associations
			if(pa.getAppliesTos().size() > 0) {
				if(pa.getProperty() == null) {
					continue;
				}

				// Find the queryable for each contained named element
				for(final ContainedNamedElement cne : pa.getAppliesTos()) {
					// Try to find the queryable being referenced
					Queryable appliedToQueryable = q;
					final List<ContainmentPathElement> containmentPathElements = cne.getContainmentPathElements();
					int containmentPathElementIndex;
					for(containmentPathElementIndex = 0; containmentPathElementIndex < containmentPathElements.size(); containmentPathElementIndex++) {
						final ContainmentPathElement pathElement = containmentPathElements.get(containmentPathElementIndex);
						if(pathElement.getAnnexName() != null)  {
							break;
						}

						Queryable next = null;
						final String pathElementName = pathElement.getNamedElement().getName();
						if(pathElementName != null) {
							for(final Queryable child : appliedToQueryable.getChildren()) {
								final Object childBo = child.getBusinessObject();
								if(childBo instanceof NamedElement) {
									final NamedElement childNamedElement = (NamedElement)childBo;
									final String childName = childNamedElement.getName();
									if(childName != null) {
										if(pathElementName.equalsIgnoreCase(childName)) {
											next = child;
											break;
										}
									}
								}
							}
						}

						if(next == null) {
							break;
						}

						appliedToQueryable = next;
					}

					// Create and add the processed property association
					final PropertyNode pn = getOrCreatePropertyNode(appliedToQueryable);
					final ProcessedPropertyAssociationCollection ppas = pn.getCreateProcessedPropertyAssociations(pa.getProperty());
					ppas.processedPropertyAssociations.add(new DeclarativeProcessedPropertyAssociation(pa,
							containmentPathElements, containmentPathElementIndex));
				}
			}
		}
	}

	private void processPropertyAssociationsForInstanceObjectsNotInTree(final Queryable q, final InstanceObject io) {
		// Find the support instance objects which are not represented in the queryable tree
		final Set<Object> childrenBosInTree = q.getChildren().stream().map(c -> c.getBusinessObject())
				.filter(childBo -> childBo != null).collect(Collectors.toCollection(HashSet::new));
		final Set<InstanceObject> childrenBosNotInTree = io.getChildren().stream()
				.filter(tmpBo -> isSupportedInstanceObject(tmpBo))
				.map(tmpBo -> (InstanceObject) tmpBo).collect(Collectors.toCollection(HashSet::new));
		childrenBosNotInTree.removeAll(childrenBosInTree);

		// Process property associations for instance objects which are not in the queryable tree
		for (final InstanceObject childNotInTree : childrenBosNotInTree) {
			processedPropertyAssociationsForInstanceObjectNotInTree(q, childNotInTree, Collections.emptyList());
		}

		// Process children of the queryable
		for (final Queryable child : q.getChildren()) {
			final Object childBo = child.getBusinessObject();
			if (childBo instanceof InstanceObject) {
				processPropertyAssociationsForInstanceObjectsNotInTree(child, (InstanceObject) childBo);
			}
		}
	}

	private void processedPropertyAssociationsForInstanceObjectNotInTree(final Queryable q,
			final InstanceObject ioNotInTree, final Iterable<InstanceObject> parentPath) {

		final Iterable<InstanceObject> newPath = Iterables.concat(parentPath,
				Collections.singletonList(ioNotInTree));

		// Process relevant properties
		for (final PropertyAssociation pa : ioNotInTree.getOwnedPropertyAssociations()) {
			final Property property = pa.getProperty();

			// Only process reference of list reference properties
			if (AadlPropertyUtil.isReferenceOrListReferenceType(property.getType())) {
				final PropertyNode pn = getOrCreatePropertyNode(q);
				final ProcessedPropertyAssociationCollection ppas = pn
						.getCreateProcessedPropertyAssociations(property);

				ppas.processedPropertyAssociations.add(new InstanceProcessedPropertyAssociation(pa, newPath));
			}
		}

		// Process children
		for (final Element child : ioNotInTree.getChildren()) {
			if (isSupportedInstanceObject(child)) {
				processedPropertyAssociationsForInstanceObjectNotInTree(q, (InstanceObject) child, newPath);
			}
		}
	}

	private static boolean isSupportedInstanceObject(final Object bo) {
		return bo instanceof InstanceObject
				&& !(bo instanceof SystemOperationMode || bo instanceof PropertyAssociationInstance);
	}
}
