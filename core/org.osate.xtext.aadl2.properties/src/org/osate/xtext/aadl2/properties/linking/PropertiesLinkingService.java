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
package org.osate.xtext.aadl2.properties.linking;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AbstractSubcomponent;
import org.osate.aadl2.BasicProperty;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.BehavioredImplementation;
import org.osate.aadl2.CallContext;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentPrototype;
import org.osate.aadl2.ComponentPrototypeBinding;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.Context;
import org.osate.aadl2.DataPrototype;
import org.osate.aadl2.Element;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.EnumerationType;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupPrototype;
import org.osate.aadl2.FeatureGroupPrototypeActual;
import org.osate.aadl2.FeatureGroupPrototypeBinding;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.FeatureType;
import org.osate.aadl2.FlowEnd;
import org.osate.aadl2.Generalization;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeBinding;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.Namespace;
import org.osate.aadl2.NumberType;
import org.osate.aadl2.NumberValue;
import org.osate.aadl2.NumericRange;
import org.osate.aadl2.PackageRename;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.PrivatePackageSection;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.Prototype;
import org.osate.aadl2.PrototypeBinding;
import org.osate.aadl2.PublicPackageSection;
import org.osate.aadl2.RangeType;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.RecordType;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubcomponentType;
import org.osate.aadl2.SubprogramAccess;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramGroupAccess;
import org.osate.aadl2.SubprogramGroupSubcomponent;
import org.osate.aadl2.SubprogramSubcomponent;
import org.osate.aadl2.ThreadSubcomponent;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.UnitsType;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.modelsupport.util.ResolvePrototypeUtil;
import org.osate.xtext.aadl2.properties.util.PSNode;

import com.google.inject.Inject;

public class PropertiesLinkingService extends DefaultLinkingService {

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	public PropertiesLinkingService() {
		super();
	}

	private static PSNode psNode = new PSNode();

	public EObject getIndexedObject(EObject context, EReference reference, String crossRefString) {
		psNode.setText(crossRefString);
		EObject res = null;
		try {
			List<EObject> el;
			el = super.getLinkedObjects(context, reference, psNode);
			res = (el.isEmpty() ? null : el.get(0));
			if (res != null && res.eIsProxy()) {
				res = EcoreUtil.resolve(res, context);
				if (res.eIsProxy()) {
					return null;
				}
			}
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return res;
		// XXX phf: lookup in global index without regard to project dependencies
		// EObject res = EMFIndexRetrieval.getEObjectOfType(context,reference.getEReferenceType(), crossRefString);
		// return res;

	}

	/**
	* copy of a method from within Xtext. Needed to change getSingleElement to getElements to see if we have doubles
	* in different files and the same project or in different projects.
	* @param context
	* @param reference
	* @param crossRefString
	* @return
	*/
	public Iterable<IEObjectDescription> getIndexedObjects(EObject context, EReference reference,
			String crossRefString) {
		// List<EObject> el;
		try {

			if (crossRefString != null && !crossRefString.equals("")) {

				final IScope scope = getScope(context, reference);
				QualifiedName qualifiedLinkName = qualifiedNameConverter.toQualifiedName(crossRefString);
				Iterable<IEObjectDescription> eObjectDescriptions = scope.getElements(qualifiedLinkName);
				return eObjectDescriptions;
			}
			// el = super.getLinkedObjects(context, reference, psNode);
		} catch (Exception e) {
			return null;
		}
		// EObject res = (el.isEmpty()?null: el.get(0));
		// if (res != null&&res.eIsProxy()){
		// res = EcoreUtil.resolve(res,context);
		// if (res.eIsProxy()) return null;
		// }
		return null;
	}

	@Override
	public String getCrossRefNodeAsString(INode node) throws IllegalNodeException {
		if (node instanceof PSNode) {
			return getLinkingHelper().getCrossRefNodeAsString(node, false);
		} else {
			return getLinkingHelper().getCrossRefNodeAsString(node, true);
		}
	}

	/**
	 * returns the first linked object
	 */
	@Override
	public List<EObject> getLinkedObjects(EObject context, EReference reference, INode node)
			throws IllegalNodeException {
		final EClass requiredType = reference.getEReferenceType();
		if (requiredType == null) {
			return Collections.<EObject> emptyList();
		}
		EObject searchResult = null;

		final EClass cl = Aadl2Package.eINSTANCE.getClassifier();
		final EClass sct = Aadl2Package.eINSTANCE.getSubcomponentType();
		final EClass pt = Aadl2Package.eINSTANCE.getPropertyType();
		final String name = getCrossRefNodeAsString(node);
		if (sct.isSuperTypeOf(requiredType) || cl.isSuperTypeOf(requiredType)) {
			// XXX: this code can be replicated in Aadl2LinkingService as it is called often in the core
			// resolve classifier reference
			EObject e = findClassifier(context, reference, name);
			if (e != null) {
				// the result satisfied the expected class
				return Collections.singletonList(e);
			}
			if (!(context instanceof Generalization) && sct.isSuperTypeOf(requiredType)) {
				// need to resolve prototype
				EObject res = AadlUtil.getContainingClassifier(context).findNamedElement(name);
				if (Aadl2Package.eINSTANCE.getDataPrototype() == reference) {
					if (res instanceof DataPrototype) {
						searchResult = res;
					}
				} else if (res instanceof ComponentPrototype) {
					searchResult = res;
				}
			}
		} else if (Aadl2Package.eINSTANCE.getModelUnit() == requiredType) {
			AadlPackage pack = findAadlPackage(context, name, reference);
			if (pack != null) {
				searchResult = pack;
			} else {
				PropertySet ps = findPropertySet(context, name, reference);
				if (ps != null) {
					searchResult = ps;
				}
			}

		} else if (Aadl2Package.eINSTANCE.getAadlPackage() == requiredType) {
			AadlPackage pack = findAadlPackage(context, name, reference);
			if (pack != null) {
				searchResult = pack;
			}

		} else if (Aadl2Package.eINSTANCE.getPropertySet() == requiredType) {
			PropertySet ps = findPropertySet(context, name, reference);
			if (ps != null) {
				searchResult = ps;
			}

		} else if (Aadl2Package.eINSTANCE.getFeature().isSuperTypeOf(requiredType)) {
			if (context instanceof Feature) {
				// Feature referenced in feature refinement
				Classifier ns = AadlUtil.getContainingClassifier(context);
				// we need to resolve a refinement
				if (ns.getExtended() != null) {
					EObject res = ns.getExtended().findNamedElement(name);
					if (res != null && res instanceof Feature) {
						searchResult = res;
					}
				} else {
					return Collections.emptyList();
				}
			} else if (context instanceof FlowEnd) {
				FlowEnd flowEnd = (FlowEnd) context;
				searchResult = findElementInContext(flowEnd, flowEnd.getContext(), name, Feature.class);
			}

		} else if (Aadl2Package.eINSTANCE.getSubcomponent().isSuperTypeOf(requiredType)) {
			// if context Subcomponent then find in extension source (refined
			// to)
			// prototype binding as context
			Classifier ns = AadlUtil.getContainingClassifier(context);
			if (context instanceof Subcomponent) {
				// we need to resolve a refinement
				if (ns.getExtended() != null) {
					ns = ns.getExtended();
				} else {
					return Collections.emptyList();
				}
			}
			EObject res = ns.findNamedElement(name);
			if (res instanceof Subcomponent) {
				searchResult = res;
			}

		} else if (Aadl2Package.eINSTANCE.getProperty() == requiredType) {
			// look for property definition in property set
			return findPropertyDefinitionAsList(context, reference, name);

		} else if (Aadl2Package.eINSTANCE.getAbstractNamedValue() == requiredType) {
			// AbstractNamedValue: constant reference, property definition reference, unit literal, enumeration literal
			if (context instanceof NamedValue) {
				List<EObject> res = Collections.EMPTY_LIST;
				if (name.indexOf("::") == -1) {
					// names without qualifier. Must be enum/unit literal
					res = findEnumLiteralAsList(context, reference, name);
					if (res.isEmpty()) {
						res = findUnitLiteralAsList(context, reference, name);
					}
				}
				if (res.isEmpty()) {
					res = findPropertyConstant(context, reference, name);
				}
				if (res.isEmpty()) {
					res = findPropertyDefinitionAsList(context, reference, name);
				}
				return res;
			}

		} else if (Aadl2Package.eINSTANCE.getBasicProperty() == requiredType) {
			// look for record field definition
			if (context instanceof BasicPropertyAssociation) {
				BasicPropertyAssociation bpa = (BasicPropertyAssociation) context;
				// TODO: Need to check that the type of the record field is
				// correct for the value.
				Element parent = bpa.getOwner();
				while (parent != null
						&& !(parent instanceof BasicPropertyAssociation || parent instanceof PropertyAssociation
								|| parent instanceof Property || parent instanceof PropertyConstant)) {
					parent = parent.getOwner();
				}
				PropertyType propertyType = null;
				if (parent instanceof BasicPropertyAssociation) {
					BasicProperty bp = ((BasicPropertyAssociation) parent).getProperty();
					if (bp != null) {
						propertyType = bp.getPropertyType();
					}
				} else if (parent instanceof PropertyAssociation) {
					Property pd = ((PropertyAssociation) parent).getProperty();
					if (pd != null) {
						propertyType = pd.getPropertyType();
					}
				} else if (parent instanceof Property) {
					propertyType = ((Property) parent).getPropertyType();
				} else if (parent instanceof PropertyConstant) {
					propertyType = ((PropertyConstant) parent).getPropertyType();
				}
				propertyType = AadlUtil.getBasePropertyType(propertyType);

				if (propertyType != null && propertyType instanceof RecordType) {
					BasicProperty rf = (BasicProperty) ((RecordType) propertyType).findNamedElement(name);
					if (rf != null) {
						searchResult = rf;
					}
				}
			}
		} else if (pt.isSuperTypeOf(requiredType)) {
			// look for property type in property set
			return findPropertyType(context, reference, name);

		} else if (Aadl2Package.eINSTANCE.getPropertyConstant() == requiredType) {
			// look for property constant in property set
			return findPropertyConstant(context, reference, name);

		} else if (Aadl2Package.eINSTANCE.getUnitLiteral() == requiredType) {
			// look for unit literal pointed to by baseUnit
			return findUnitLiteralAsList(context, reference, name);

		} else if (Aadl2Package.eINSTANCE.getEnumerationLiteral() == requiredType) {
			// look for enumeration literal
			return findEnumLiteralAsList(context, reference, name);

		} else if (Aadl2Package.eINSTANCE.getMode() == requiredType) {
			// referenced by mode transition, inmodes, ModeBinding
			EObject res = null;
			if (context instanceof ModeBinding) {
				if (reference == Aadl2Package.eINSTANCE.getModeBinding_ParentMode()) {
					res = AadlUtil.getContainingClassifier(context).findNamedElement(name);
				} else if (reference == Aadl2Package.eINSTANCE.getModeBinding_DerivedMode()) {
					Subcomponent subcomponent = AadlUtil.getContainingSubcomponent(context);
					while (subcomponent.getSubcomponentType() == null && subcomponent.getRefined() != null) {
						subcomponent = subcomponent.getRefined();
					}
					ComponentClassifier subcomponentClassifier = null;
					if (subcomponent.getSubcomponentType() instanceof ComponentClassifier) {
						subcomponentClassifier = ((ComponentClassifier) subcomponent.getSubcomponentType());
					} else if (subcomponent.getSubcomponentType() instanceof ComponentPrototype) {
						subcomponentClassifier = findClassifierForComponentPrototype(
								AadlUtil.getContainingClassifier(context),
								((ComponentPrototype) subcomponent.getSubcomponentType()));
					}
					if (subcomponentClassifier != null) {
						res = subcomponentClassifier.findNamedElement(name);
					}
				}
			} else {
				// check about in modes in a contained property association
				PropertyAssociation pa = AadlUtil.getContainingPropertyAssociation(context);
				if (pa != null && !pa.getAppliesTos().isEmpty()) {
					ContainedNamedElement path = pa.getAppliesTos().get(0);
					EList<ContainmentPathElement> cpelist = path.getContainmentPathElements();
					Subcomponent cpesub = null;
					for (ContainmentPathElement containmentPathElement : cpelist) {
						if (containmentPathElement.getNamedElement() instanceof Subcomponent) {
							cpesub = (Subcomponent) containmentPathElement.getNamedElement();
						} else {
							break;
						}
					}
					if (cpesub != null) {
						if (cpesub.getAllClassifier() != null) {
							res = cpesub.getAllClassifier().findNamedElement(name);
						}
					} else {
						res = AadlUtil.getContainingClassifier(context).findNamedElement(name);
					}
				} else {
					if ((pa != null) && (pa.getOwner() instanceof Subcomponent)) {
						Subcomponent subco = (Subcomponent) pa.getOwner();
						if (subco.getAllClassifier() != null) {
							res = subco.getAllClassifier().findNamedElement(name);

						}
					} else {
						res = AadlUtil.getContainingClassifier(context).findNamedElement(name);
					}
				}
			}
			if (res != null && res instanceof Mode) {
				searchResult = res;
			}
		} else if (Aadl2Package.eINSTANCE.getNamedElement() == requiredType) {
			// containment path element
			if (context instanceof ContainmentPathElement) {
				EObject res = null;
				if (((ContainmentPathElement) context).getOwner() instanceof ContainmentPathElement) {
					// find next element in namespace of previous element
					ContainmentPathElement el = (ContainmentPathElement) ((ContainmentPathElement) context).getOwner();
					NamedElement ne = el.getNamedElement();
					if (ne instanceof Subcomponent) {
						Subcomponent subcomponent = (Subcomponent) ne;
						while (subcomponent.getSubcomponentType() == null && subcomponent.getRefined() != null) {
							subcomponent = subcomponent.getRefined();
						}
						ComponentClassifier ns = null;
						if (subcomponent.getSubcomponentType() instanceof ComponentClassifier) {
							ns = (ComponentClassifier) subcomponent.getSubcomponentType();
						} else if (subcomponent.getSubcomponentType() instanceof ComponentPrototype) {
							ns = ResolvePrototypeUtil.resolveComponentPrototype(
									(ComponentPrototype) subcomponent.getSubcomponentType(), el);
						}
						if (ns != null) {
							res = ns.findNamedElement(name);
							if (res == null
									&& (ne instanceof ThreadSubcomponent || ne instanceof SubprogramSubcomponent
											|| ne instanceof AbstractSubcomponent)
									&& ns instanceof BehavioredImplementation) {
								res = AadlUtil.findNamedElementInList(((BehavioredImplementation) ns).subprogramCalls(),
										name);
							}
						}
					} else if (ne instanceof FeatureGroup) {
						FeatureGroup featureGroup = (FeatureGroup) ne;
						while (featureGroup.getFeatureType() == null
								&& featureGroup.getRefined() instanceof FeatureGroup) {
							featureGroup = (FeatureGroup) featureGroup.getRefined();
						}
						FeatureGroupType ns = null;
						if (featureGroup.getFeatureType() instanceof FeatureGroupType) {
							ns = (FeatureGroupType) featureGroup.getFeatureType();
						} else if (featureGroup.getFeatureType() instanceof FeatureGroupPrototype) {
							ns = ResolvePrototypeUtil.resolveFeatureGroupPrototype(
									(FeatureGroupPrototype) featureGroup.getFeatureType(), el);
						}
						if (ns != null) {
							res = ns.findNamedElement(name);
						}
					}
				} else {
					// the first containment path element
					Classifier ns = null;
					PropertyAssociation containingPropertyAssociation = AadlUtil
							.getContainingPropertyAssociation(context);
					if (containingPropertyAssociation != null) {
						// need to make sure we look in the correct name space
						if (containingPropertyAssociation.getOwner() instanceof Subcomponent) {
							Subcomponent subcomponent = (Subcomponent) containingPropertyAssociation.getOwner();
							while (subcomponent.getSubcomponentType() == null && subcomponent.getRefined() != null) {
								subcomponent = subcomponent.getRefined();
							}
							if (subcomponent.getSubcomponentType() instanceof ComponentClassifier) {
								ns = (ComponentClassifier) subcomponent.getSubcomponentType();
							} else if (subcomponent.getSubcomponentType() instanceof ComponentPrototype) {
								ns = ResolvePrototypeUtil.resolveComponentPrototype(
										(ComponentPrototype) subcomponent.getSubcomponentType(),
										AadlUtil.getContainingClassifier(context));
							}
						} else if (containingPropertyAssociation.getOwner() instanceof FeatureGroup) {
							FeatureGroup fg = (FeatureGroup) containingPropertyAssociation.getOwner();
							while (fg.getFeatureType() == null && fg.getRefined() instanceof FeatureGroup) {
								fg = (FeatureGroup) fg.getRefined();
							}
							if (fg.getFeatureType() instanceof FeatureGroupType) {
								ns = (FeatureGroupType) fg.getFeatureType();
							} else if (fg.getFeatureType() instanceof FeatureGroupPrototype) {
								ns = ResolvePrototypeUtil.resolveFeatureGroupPrototype(
										(FeatureGroupPrototype) fg.getFeatureType(),
										AadlUtil.getContainingClassifier(context));
							}
						} else {
							ns = containingPropertyAssociation.getContainingClassifier();
						}
					}
					if (ns != null) {
						res = ns.findNamedElement(name);
					}
				}
				if (res != null && res instanceof NamedElement) {
					searchResult = res;
				}
			}
		} else {
			List<EObject> superes = super.getLinkedObjects(context, reference, node);
			return superes;
		}
		if (searchResult != null) {
			return Collections.singletonList(searchResult);
		}
		return Collections.<EObject> emptyList();
	}

	/**
	 * Look up package in EMF index or in resource set
	 * NOTE: the resource set does not have all resources loaded
	 * @param context Context of reference
	 * @param name Package name
	 * @return aadl package or null
	 */
	public AadlPackage findAadlPackage(EObject context, String name) {
//		EReference reference = Aadl2Package.eINSTANCE.getPackageSection_ImportedUnit();
		EReference reference = Aadl2Package.eINSTANCE.getPropertySet_ImportedUnit();
		return findAadlPackage(context, name, reference);
	}

	/**
	 * Look up package in EMF index
	 * NOTE: the resource set does not have all resources loaded
	 * @param context Context of reference
	 * @param name Package name
	 * @param reference Ereference identifying the type of the reference
	 * @return aadl package or null
	 */
	public AadlPackage findAadlPackage(EObject context, String name, EReference reference) {
		EObject res = getIndexedObject(context, reference, name);
		if (res instanceof AadlPackage) {
			return (AadlPackage) res;
		}
		if (name == null || name.length() == 0) {
			return null;
		}
		return null;
	}

	/**
	 * Find referenced Package by resolving renames first and then making sure it is listed in a with clause
	 * If package name is null or that of the context return containing package
	 * @param packageName
	 * @param context location of the package reference
	 * @return aadl package
	 */
	public AadlPackage findAadlPackageReference(String packageName, Namespace context) {
		if (context instanceof PackageSection
				&& (packageName == null || context.getName().equalsIgnoreCase(packageName))) {
			return (AadlPackage) ((PackageSection) context).eContainer();
		} else {
			AadlPackage aadlPackage = null;

			if (context instanceof PackageSection) {
				aadlPackage = resolvePackageRename(packageName, (PackageSection) context);
				if (aadlPackage == null) {
					aadlPackage = AadlUtil.findImportedPackage(packageName, context);
				}
			} else {
				aadlPackage = AadlUtil.findImportedPackage(packageName, context);
			}

			return aadlPackage;
		}
	}

	/**
	 * resolve package name by looking it up in PackageRename
	 * @param name package name
	 * @param context Package section with rename declarations
	 * @return aadl package or null
	 */
	public AadlPackage resolvePackageRename(String name, PackageSection context) {
		AadlPackage searchResult = resolvePackageRename(name, context.getOwnedPackageRenames());
		if (searchResult == null && context instanceof PrivatePackageSection
				&& ((AadlPackage) context.eContainer()).getPublicSection() != null) {
			PublicPackageSection pubsec = ((AadlPackage) context.eContainer()).getPublicSection();
			searchResult = resolvePackageRename(name, pubsec.getOwnedPackageRenames());
		}
		return searchResult;
	}

	/**
	 * find and return renamed package in list of package renames
	 * @param name package name to be resolved
	 * @param packageRenames list of package renames
	 * @return aadl package or null
	 */
	public AadlPackage resolvePackageRename(String name, EList<PackageRename> packageRenames) {
		for (PackageRename namedElement : packageRenames) {
			if (namedElement.hasName() && namedElement.getName().equalsIgnoreCase(name)) {
				return namedElement.getRenamedPackage();
			}
		}
		return null;
	}

	/**
	 * look up property set in EMF index or resource set
	 * @param context
	 * @param name
	 * @return
	 */
	public PropertySet findPropertySet(Element context, String name) {
		EReference reference = Aadl2Package.eINSTANCE.getPropertySet_ImportedUnit();
		return findPropertySet(context, name, reference);
	}

	/**
	 * look property set up in EMF index, if not found search through resource set
	 * NOTE: resource set does not have all resources loaded
	 * @param context
	 * @param name Property set name
	 * @param reference EReference used to identify the type of object we are looking for
	 * @return
	 */
	public PropertySet findPropertySet(EObject context, String name, EReference reference) {
		EObject res = getIndexedObject(context, reference, name);
		if (res instanceof PropertySet) {
			return (PropertySet) res;
		}
		if (name == null || name.length() == 0) {
			return null;
		}
		return null;
	}

	/**
	 * find the component classifier taking into account rename aliases
	 * The name may be qualified with a package name
	 * We do not check whether the referenced package is in the with clause. This is checked separately
	 * @param context Element any model object that is the context of the reference
	 * @param name name to be resolved; may be unqualified or qualified with a package name
	 * @return ComponentClassifier or null
	 */
	public ComponentClassifier findComponentClassifier(Element context, String name) {
		EReference reference = Aadl2Package.eINSTANCE.getComponentPrototype_ConstrainingClassifier();
		return (ComponentClassifier) findClassifier(context, reference, name);
	}

	public FeatureGroupType findFeatureGroupType(Element context, String name) {
		EReference reference = Aadl2Package.eINSTANCE.getFeatureGroupPrototype_ConstrainingFeatureGroupType();
		return (FeatureGroupType) findClassifier(context, reference, name);
	}

	public FeatureGroupType findFeatureGroupType(EObject context, String name, EReference reference) {
		return (FeatureGroupType) findClassifier(context, reference, name);
	}

	/**
	 * find the classifier taking into account rename aliases
	 * We do not check whether the referenced package is in the with clause. This is checked separately
	 * This is a helper method for findFeatureGroupType and findComponentClassifier
	 * @param context classifier reference context
	 * @param reference identifying attribute of reference
	 * @param name name to be resolved
	 * @return Classifier or null
	 */
	public Classifier findClassifier(EObject context, EReference reference, String name) {
		Namespace scope = AadlUtil.getContainingTopLevelNamespace(context);
		EObject e = getIndexedObject(context, reference, name);
		if (e != null && e instanceof Classifier && reference.getEReferenceType().isSuperTypeOf(e.eClass())) {
			// the result satisfied the expected class
			Namespace ns = AadlUtil.getContainingTopLevelNamespace(e);
			if (ns instanceof PrivatePackageSection && scope != ns) {
				return null;
			}
			return (Classifier) e;
		}
		// need to do a local lookup as it was not found in the index.
		String packname = null;
		String cname = name;
		final int idx = name.lastIndexOf("::");
		if (idx != -1) {
			packname = name.substring(0, idx);
			cname = name.substring(idx + 2);
			// if rename is not a package rename, but component type rename then all is treated as component ID
			if (cname.equalsIgnoreCase("all")) {
				return null;
			}
		}
		// NOTE: checking whether the referenced package is imported is done by the validator.
		if (context instanceof NamedElement) {
			// if we have a NamedElement (e.g., a renames) without a name and we are looking for the reference in own package
			// then stop. Otherwise we have a cycle.
			if (((NamedElement) context).getName() == null) {
				if (packname == null || scope.getName().equalsIgnoreCase(packname)) {
					return null;
				}
			}
		}
		if (e == null && scope instanceof PackageSection) {
			// the reference is from inside a package section. Lookup by identifier with or without qualification
			e = findNamedElementInAadlPackage(packname, cname, scope);
			if (e != null && e instanceof Classifier && reference.getEReferenceType().isSuperTypeOf(e.eClass())) {
				// the result satisfied the expected class
				return (Classifier) e;
			}
		}
		return null;
	}

	/**
	 * find a named element in a property set based on an optionally qualified name.
	 * The name is qualified with the property set name, or if unqualified is assumed to be a predeclared property constant
	 * The context object can be any model object, typically the object that is the context of the reference such as a property definition
	 * The reference is an EReference pointing to the the named element
	 * This method is a helper method for the FindPropertyConstant/Type/Definition methods
	 * @param context Element an AADL model element
	 * @param reference EReference
	 * @param name property type name possibly qualified with the property set name
	 * @return
	 */
	public EObject findPropertySetElement(EObject context, EReference reference, String name) {
		// look for element in property set
		String psname = null;
		String pname = name;
		final int idx = name.lastIndexOf("::");
		if (idx != -1) {
			psname = name.substring(0, idx);
			pname = name.substring(idx + 2);
		}
		if (psname == null) {
			return findNamedElementInPredeclaredPropertySets(pname, context, reference);
		} else {
			return getIndexedObject(context, reference, name);
		}
	}

	/**
	 * find property constant based on property constant name.
	 * The name is qualified with the property set name, or if unqualified is assumed to be a predeclared property constant
	 * The context object can be any model object, typically the object that is the context of the reference such as a property definition
	 * @param context Element an AADL model element
	 * @param name property type name possibly qualified with the property set name
	 * @return PropertyConstant the property type or null
	 */
	public PropertyConstant findPropertyConstant(EObject context, String name) {
		// look for property constant in property set
		EReference reference = Aadl2Package.eINSTANCE.getNamedValue_NamedValue();
		EObject e = findPropertySetElement(context, reference, name);
		if (e != null && e instanceof PropertyConstant) {
			return (PropertyConstant) e;
		}
		return null;
	}

	public List<EObject> findPropertyConstant(EObject context, EReference reference, String name) {
		// look for property constant in property set
		EObject e = findPropertySetElement(context, reference, name);
		if (e != null && e instanceof PropertyConstant) {
			return Collections.singletonList(e);
		}
		return Collections.<EObject> emptyList();
	}

	/**
	 * find property type based on property name.
	 * The name is qualified with the property set name, or if unqualified is assumed to be a predeclared property type
	 * The context object can be any model object, typically the object that is the context of the reference such as a property definition
	 * @param context Element an AADL model element
	 * @param name property type name possibly qualified with the property set name
	 * @return PropertyType the property type or null
	 */
	public PropertyType findPropertyType(EObject context, String name) {
		// look for property type in property set
		EReference reference = Aadl2Package.eINSTANCE.getBasicProperty_PropertyType();
		EObject e = findPropertySetElement(context, reference, name);
		if (e != null && e instanceof PropertyType) {
			return (PropertyType) e;
		}
		return null;
	}

	public List<EObject> findPropertyType(EObject context, EReference reference, String name) {
		// look for property constant in property set
		EObject e = findPropertySetElement(context, reference, name);
		if (e != null && e instanceof PropertyType) {
			return Collections.singletonList(e);
		}
		return Collections.<EObject> emptyList();
	}

	/**
	 * find property definition based on property name.
	 * The name is qualified with the property set name, or if unqualified is assumed to be a predeclared property
	 * The context object can be any model object, typically the object that is the context of the reference such as a property association
	 * @param context Element an AADL model element
	 * @param name property name possibly qualified with the property set name
	 * @return Property the property definition or null
	 */
	public Property findPropertyDefinition(EObject context, String name) {
		// look for property type in property set
		EReference reference = Aadl2Package.eINSTANCE.getPropertyAssociation_Property();
		EObject e = findPropertySetElement(context, reference, name);
		if (e != null && e instanceof Property) {
			return (Property) e;
		}
		return null;
	}

//	/**
//	 * find property definition based on property name.
//	 * The name is qualified with the property set name, or if unqualified is assumed to be a predeclared property
//	 * @param name property name possibly qualified with the property set name
//	 * @return Property the property definition or null
//	 */
//	public Property findPropertyDefinition(String name){
//		// look for property type in property set
//		EReference reference = Aadl2Package.eINSTANCE.getPropertyAssociation_Property();
//		EObject e = findPropertySetElement(PredeclaredProperties.getAadlProjectPropertySet(), reference, name);
//		if (e != null && e instanceof Property) {
//			return (Property)e;
//		}
//		return null;
//	}
//
	public List<EObject> findPropertyDefinitionAsList(EObject context, EReference reference, String name) {
		// look for property definition in property set
		EObject e = findPropertySetElement(context, reference, name);
		if (e != null && e instanceof Property) {
			return Collections.singletonList(e);
		}
		return Collections.<EObject> emptyList();
	}

	/**
	 * Dependencies: PrototypeFormalReference, ClassifierReference,
	 * PrototypeOrClassifierReference, ComponentPrototypeClassifierReference,
	 * ComponentPrototypeRefinementReference. Based on the type of
	 * containingClassifier: ComponentTypeExtensionReference,
	 * ComponentImplementationExtensionReference, RealizationReference,
	 * FeatureGroupTypeExtendReference.
	 */
	/*
	 * TODO: Check for circular dependencies with prototypes. Example:
	 * 
	 * abstract a prototypes p1: subprogram group; p2: subprogram group; end a;
	 * 
	 * abstract implementation a.i ( p1 => p2, p2 => p1) subcomponents sub:
	 * subprogram group p1; calls sequence1: { call1: subprogram
	 * sub.access_feature_1; end a.i;
	 * 
	 * This will cause a stack overflow!
	 */
	public static ComponentClassifier findClassifierForComponentPrototype(Classifier containingClassifier,
			ComponentPrototype prototype) {
		// TODO: Need to check that the prototype binding is a component
		// prototype binding. In PrototypeFormalReference,
		// we should check that component prototypes are bound by component
		// prototype bindings.
		ComponentPrototypeBinding binding = (ComponentPrototypeBinding) findPrototypeBinding(containingClassifier,
				prototype);
		if (binding != null && binding.getActuals().size() >= 1) {
			SubcomponentType st = binding.getActuals().get(0).getSubcomponentType();
			if (st instanceof ComponentClassifier) {
				return (ComponentClassifier) st;
			} else // It is a ComponentPrototypeReference
			{
				ComponentClassifier classifierForReferencedPrototype = findClassifierForComponentPrototype(
						containingClassifier, (ComponentPrototype) st);
				if (classifierForReferencedPrototype != null) {
					return classifierForReferencedPrototype;
				}
			}
		}
		while (prototype.getConstrainingClassifier() == null && prototype.getRefined() != null) {
			// TODO: Need to check that the component prototype refines a
			// component prototype.
			// This should be done in ComponentPrototypeRefinementReference.
			prototype = (ComponentPrototype) prototype.getRefined();
		}
		if (prototype.getConstrainingClassifier() != null) {
			return prototype.getConstrainingClassifier();
		} else {
			return null;
		}
	}

	/**
	 * Dependencies: PrototypeFormalReference, ClassifierReference,
	 * PrototypeOrClassifierReference, ComponentPrototypeClassifierReference,
	 * ComponentPrototypeRefinementReference. Based on the type of
	 * classifierPrototypeContext: ComponentTypeExtensionReference,
	 * ComponentImplementationExtensionReference, RealizationReference,
	 * FeatureGroupTypeExtendReference.
	 */
	/*
	 * TODO: Check for circular dependencies with prototypes.
	 */
	public static ComponentClassifier findClassifierForComponentPrototype(Classifier classifierPrototypeContext,
			Subcomponent subcomponentPrototypeContext, ComponentPrototype prototype) {
		// TODO: Need to check that the prototype binding is a component
		// prototype binding. In PrototypeFormalReference,
		// we should check that component prototypes are bound by component
		// prototype bindings.
		ComponentPrototypeBinding binding = (ComponentPrototypeBinding) findPrototypeBinding(classifierPrototypeContext,
				subcomponentPrototypeContext, prototype);
		if (binding != null && binding.getActuals().size() >= 1) {
			SubcomponentType st = binding.getActuals().get(0).getSubcomponentType();
			if (st instanceof ComponentClassifier) {
				return (ComponentClassifier) st;
			} else if (st instanceof ComponentPrototype) {
				ComponentClassifier classifierForReferencedPrototype = findClassifierForComponentPrototype(
						classifierPrototypeContext, subcomponentPrototypeContext, ((ComponentPrototype) st));
				if (classifierForReferencedPrototype != null) {
					return classifierForReferencedPrototype;
				}
			}
		}
		while (prototype.getConstrainingClassifier() == null && prototype.getRefined() != null) {
			// TODO: Need to check that the component prototype refines a
			// component prototype.
			// This should be done in ComponentPrototypeRefinementReference.
			prototype = (ComponentPrototype) prototype.getRefined();
		}
		if (prototype.getConstrainingClassifier() != null) {
			return prototype.getConstrainingClassifier();
		} else {
			return null;
		}
	}

	/**
	 * Dependencies: PrototypeFormalReference, FeatureGroupTypeReference,
	 * PrototypeOrFeatureGroupTypeReference,
	 * FeatureGroupPrototypeClassifierReference,
	 * FeatureGroupPrototypeRefinementReference. Based on the type of
	 * containingClassifier: ComponentTypeExtensionReference,
	 * ComponentImplementationExtensionReference, RealizationReference,
	 * FeatureGroupTypeExtendReference.
	 */
	// TODO: Check for circular dependencies with prototypes.
	public static FeatureGroupType findFeatureGroupTypeForFeatureGroupPrototype(Classifier containingClassifier,
			FeatureGroupPrototype prototype) {
		// TODO: Need to check that the prototype binding is a feature group
		// prototype binding. In PrototypeFormalReference,
		// we should check that feature group prototypes are bound by feature
		// group prototype bindings.
		FeatureGroupPrototypeBinding binding = (FeatureGroupPrototypeBinding) findPrototypeBinding(containingClassifier,
				prototype);
		if (binding != null) {
			if (binding.getActual() instanceof FeatureGroupPrototypeActual) {
				FeatureType ft = binding.getActual().getFeatureType();
				if (ft instanceof FeatureGroupType) {
					return (FeatureGroupType) ft;
				} else {
					FeatureGroupType featureGroupTypeForReferencedPrototype = findFeatureGroupTypeForFeatureGroupPrototype(
							containingClassifier, ((FeatureGroupPrototype) ft));
					if (featureGroupTypeForReferencedPrototype != null) {
						return featureGroupTypeForReferencedPrototype;
					}
				}
			}
		}
		if (prototype == null) {
			return null;
		}
		while (prototype.getConstrainingFeatureGroupType() == null && prototype.getRefined() != null) {
			// TODO: Need to check that the feature group prototype refines a
			// feature group prototype.
			// This should be done in FeatureGroupPrototypeRefinementReference.
			prototype = (FeatureGroupPrototype) prototype.getRefined();
		}
		if (prototype.getConstrainingFeatureGroupType() != null) {
			return prototype.getConstrainingFeatureGroupType();
		} else {
			return null;
		}
	}

	/**
	 * Search for a {@link NamedElement} inside a package. If {@code context} is a
	 * {@link PublicPackageSection}, then this method will search through the
	 * {@link PublicPackageSection} only. If {@code context} is a
	 * {@link PrivatePackageSection}, then this method will search through the
	 * {@link PrivatePackageSection} and its corresponding
	 * {@link PublicPackageSection}.
	 * It will resolve any renames since it is a package internal lookup.
	 *
	 * Dependencies: RenamesAll, ComponentTypeRename, FeatureGroupTypeRename.
	 *
	 * @param name
	 *            The name of the {@link NamedElement} to search for.
	 * @param context
	 *            The {@link PackageSection} that contains the {@link Element}
	 *            that needs the search result.
	 * @return The {@link NamedElement} or {@code null} if it cannot be found.
	 */
	public NamedElement findNamedElementInsideAadlPackage(String name, PackageSection context) {
		NamedElement result = context.findInternallyVisibleNamedElement(name);
		if (result == null && context instanceof PrivatePackageSection
				&& ((AadlPackage) context.eContainer()).getOwnedPublicSection() != null) {
			result = ((AadlPackage) context.eContainer()).getOwnedPublicSection()
					.findInternallyVisibleNamedElement(name);
		}
		return result;
	}

	/**
	 * Search for a {@link NamedElement} with the name {@code elementName} in
	 * the containing package, which is also the specified by {@code packageName}.
	 * If the element cannot be found in the specified package, then {@code null} will be returned.
	 *
	 *
	 * @param packageName
	 *            The name of the package that contains the element to search
	 *            for, or null
	 * @param elementName
	 *            The name of the element to search for.
	 * @param context
	 *            The {@link PackageSection} that needs to refer to the
	 *            specified {@link Element}.
	 * @return The {@link NamedElement} or {@code null} if it cannot be found.
	 */
	public NamedElement findNamedElementInAadlPackage(String packageName, String elementName, Namespace context) {
		if (context instanceof PackageSection
				&& (packageName == null || context.getName().equalsIgnoreCase(packageName))) {
			// lookup in package that has reference
			NamedElement ne = findNamedElementInsideAadlPackage(elementName, (PackageSection) context);
			return ne;
		} else {
			// lookup in another package as external reference
			// we need to do this because references that use package aliases did not get picked up
			AadlPackage aadlPackage = null;
			if (context instanceof PackageSection) {
				aadlPackage = resolvePackageRename(packageName, (PackageSection) context);
				if (aadlPackage == null) {
					aadlPackage = AadlUtil.findImportedPackage(packageName, context);
				}
			}
			if (aadlPackage != null && aadlPackage.getOwnedPublicSection() != null) {
				return aadlPackage.getOwnedPublicSection().findNamedElement(elementName);
			} else {
				return null;
			}
		}
	}

	/**
	 * Find element in  predeclared property sets which do not require the qualification
	 * @param propertyName
	 * @param context
	 * @param reference
	 * @return
	 */
	public EObject findNamedElementInPredeclaredPropertySets(String propertyName, EObject context,
			EReference reference) {
		for (String predeclaredPSName : AadlUtil.getPredeclaredPropertySetNames()) {
			EObject res = getIndexedObject(context, reference, getQualifiedName(predeclaredPSName, propertyName));
			if (res != null) {
				return res;
			}
		}
		return null;
	}

	public String getQualifiedName(String packageOrPropertySetName, String elementName) {
		if (packageOrPropertySetName == null) {
			return elementName;
		} else {
			return packageOrPropertySetName + "::" + elementName;
		}
	}

	/**
	 * Dependencies: PrototypeFormalReference. Based on the type of classifier:
	 * ComponentTypeExtensionReference,
	 * ComponentImplementationExtensionReference, RealizationReference,
	 * FeatureGroupTypeExtendReference.
	 */
	public static PrototypeBinding findPrototypeBinding(Classifier classifier, Prototype prototype) {
		for (PrototypeBinding binding : classifier.getOwnedPrototypeBindings()) {
			if (binding.getFormal().equals(prototype)) {
				return binding;
			}
		}
		for (Generalization generalization : classifier.getGeneralizations()) {
			PrototypeBinding result = findPrototypeBinding(generalization.getGeneral(), prototype);
			if (result != null) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Dependencies: PrototypeFormalReference. Based on the type of
	 * classifierPrototypeContext: ComponentTypeExtensionReference,
	 * ComponentImplementationExtensionReference, RealizationReference,
	 * FeatureGroupTypeExtendReference.
	 */
	public static PrototypeBinding findPrototypeBinding(Classifier classifierPrototypeContext,
			Subcomponent subcomponentPrototypeContext, Prototype prototype) {
		for (PrototypeBinding binding : subcomponentPrototypeContext.getOwnedPrototypeBindings()) {
			if (binding.getFormal().equals(prototype)) {
				return binding;
			}
		}
		for (PrototypeBinding binding : classifierPrototypeContext.getOwnedPrototypeBindings()) {
			if (binding.getFormal().equals(prototype)) {
				return binding;
			}
		}
		for (Generalization generalization : classifierPrototypeContext.getGeneralizations()) {
			PrototypeBinding result = findPrototypeBinding(generalization.getGeneral(), prototype);
			if (result != null) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Dependencies: PrototypeFormalReference.
	 */
	public PrototypeBinding findPrototypeBinding(Subcomponent subcomponent, Prototype prototype) {
		for (PrototypeBinding binding : subcomponent.getOwnedPrototypeBindings()) {
			if (binding.getFormal().equals(prototype)) {
				return binding;
			}
		}
		return null;
	}

	public static EnumerationLiteral findEnumerationLiteral(Property property, String name) {
		PropertyType propertyType = property.getPropertyType();
		if (propertyType instanceof EnumerationType) {
			return ((EnumerationType) propertyType).findLiteral(name);
		}
		return null;
	}

	public static UnitLiteral findUnitLiteral(Property property, String name) {
		PropertyType propertyType = property.getPropertyType();
		UnitsType unitsType = null;
		if (propertyType instanceof NumberType) {
			unitsType = ((NumberType) propertyType).getUnitsType();
		} else if (propertyType instanceof RangeType) {
			unitsType = ((RangeType) propertyType).getNumberType().getUnitsType();
		}
		if (unitsType != null) {
			return unitsType.findLiteral(name);
		}
		return null;
	}

	public static UnitLiteral findUnitLiteral(NumberValue nv, String name) {
		EReference reference = Aadl2Package.eINSTANCE.getNamedValue_NamedValue();
		return findUnitLiteral(nv, reference, name);
	}

	public static List<EObject> findUnitLiteralAsList(EObject context, EReference reference, String name) {
		EObject e = findUnitLiteral(context, reference, name);
		if (e == null) {
			return Collections.<EObject> emptyList();
		}
		return Collections.singletonList(e);
	}

	public static UnitLiteral findUnitLiteral(EObject context, EReference reference, String name) {
		// look for unit literal pointed to by baseUnit
		if (context instanceof UnitLiteral) {
			UnitsType unitsType = (UnitsType) ((UnitLiteral) context).getOwner();
			return (UnitLiteral) unitsType.findNamedElement(name);
		} else if (context instanceof NumberValue) {
			UnitsType unitsType = null;
			NumberValue numberValue = (NumberValue) context;
			Element owner = numberValue.getOwner();
			while (owner instanceof ListValue) {
				owner = owner.getOwner();
			}
			if (owner instanceof NumericRange) {
				// values of a number
				// property type.
				unitsType = ((NumberType) owner.getOwner()).getUnitsType();
			} else {
				if (owner instanceof RangeValue) {
					owner = owner.getOwner();
				}
				if (owner instanceof ListValue) {
					owner = owner.getOwner();
				}
				PropertyType propertyType = null;
				if (owner instanceof PropertyConstant) // Value of the
				// property
				// constant.
				{
					// TODO: Need to check that the type of the property
					// constant is correct for the value.
					// We should do this when the type of the constant is
					// resolved in PropertyTypeReference.
					propertyType = ((PropertyConstant) owner).getPropertyType();
				} else if (owner instanceof Property) // Default value of a
				// property
				// definition.
				{
					// TODO: Need to check that the type of the property
					// definition is correct for the value.
					// We should do this when the type of the definition is
					// resolved in PropertyValuePropertyTypeReference.
					propertyType = ((Property) owner).getPropertyType();
				} else if (owner instanceof ModalPropertyValue && owner.getOwner() instanceof PropertyAssociation)
				// Value of an association.
				{
					// TODO: Need to check that the type of the property
					// definition is correct for the value.
					// We should do this when the definition of the
					// association is resolved in
					// PropertyDefinitionReference.
					propertyType = ((PropertyAssociation) owner.getOwner()).getProperty().getPropertyType();
				} else if (owner instanceof BasicPropertyAssociation)
				// Inner value of a record value.
				{
					// TODO: Need to check that the type of the record field
					// is correct for the value.
					// We should do this when the record field of the record
					// value is resolved in PropertyRecordFieldReference.
					propertyType = ((BasicPropertyAssociation) owner).getProperty().getPropertyType();
				}
				propertyType = AadlUtil.getBasePropertyType(propertyType);
				if (propertyType instanceof NumberType) {
					unitsType = ((NumberType) propertyType).getUnitsType();
				} else if (propertyType instanceof RangeType) {
					RangeType rangeType = (RangeType) propertyType;
					// The number type could be null if the model is incomplete.
					if (rangeType.getNumberType() != null) {
						unitsType = rangeType.getNumberType().getUnitsType();
					}
				}
			}
			if (unitsType != null) {
				return unitsType.findLiteral(name);
			}
		}
		return null;
	}

	public static EnumerationLiteral findEnumerationLiteral(EnumerationType enumType, String name) {
		return enumType.findLiteral(name);
	}

	public static EnumerationLiteral findEnumerationLiteral(NamedValue nv, String name) {
		EReference reference = Aadl2Package.eINSTANCE.getNamedValue_NamedValue();
		List<EObject> el = findEnumLiteralAsList(nv, reference, name);
		if (!el.isEmpty() && el.get(0) instanceof EnumerationLiteral) {
			return (EnumerationLiteral) el.get(0);
		}
		return null;
	}

	public static List<EObject> findEnumLiteralAsList(EObject context, EReference reference, String name) {
		// look for enumeration literal
		if (context instanceof NamedValue) {
			NamedValue value = (NamedValue) context;
			EObject owner = value.getOwner();
			while (owner instanceof ListValue) {
				owner = owner.eContainer();
			}
			PropertyType propertyType = null;
			if (owner instanceof PropertyConstant) // Value of the property
			// constant.
			{
				// TODO: Need to check that the type of the property
				// constant is correct for the value.
				// We should do this when the type of the constant is
				// resolved in PropertyTypeReference.
				propertyType = ((PropertyConstant) owner).getPropertyType();
			} else if (owner instanceof Property) // Default value of a
			// property definition.
			{
				// TODO: Need to check that the type of the property
				// definition is correct for the value.
				// We should do this when the type of the definition is
				// resolved in PropertyValuePropertyTypeReference.
				propertyType = ((Property) owner).getPropertyType();
			} else if (owner instanceof ModalPropertyValue && owner.eContainer() instanceof PropertyAssociation) // Value
			// of
			// an
			// association.
			{
				// TODO: Need to check that the type of the property
				// definition is correct for the value.
				// We should do this when the definition of the association
				// is resolved in PropertyDefinitionReference.
				Property p = ((PropertyAssociation) owner.eContainer()).getProperty();
				propertyType = p.getPropertyType();
			} else if (owner instanceof BasicPropertyAssociation) // Inner
			// value
			// of a
			// record
			// value.
			{
				// TODO: Need to check that the type of the record field is
				// correct for the value.
				// We should do this when the record field of the record
				// value is resolved in PropertyRecordFieldReference.
				propertyType = ((BasicPropertyAssociation) owner).getProperty().getPropertyType();
			}

			propertyType = AadlUtil.getBasePropertyType(propertyType);
			if (propertyType != null && propertyType instanceof EnumerationType) {
				EnumerationLiteral literal = ((EnumerationType) propertyType).findLiteral(name);
				if (literal != null) {
					return Collections.singletonList((EObject) literal);
				}
			}
		}
		return Collections.<EObject> emptyList();
	}

	protected static <T> T findElementInContext(Element referencingObject, Context context, String name,
			Class<T> validSearchResultType) {
		NamedElement searchResult = null;
		if (context == null) {
			searchResult = AadlUtil.getContainingClassifier(referencingObject).findNamedElement(name);
		} else if (context instanceof FeatureGroup) {
			FeatureGroup featureGroup = (FeatureGroup) context;
			while (featureGroup.getFeatureGroupType() == null && featureGroup.getFeatureGroupPrototype() == null
					&& featureGroup.getRefined() instanceof FeatureGroup) {
				featureGroup = (FeatureGroup) featureGroup.getRefined();
			}
			FeatureGroupType featureGroupType = null;
			if (featureGroup.getFeatureGroupType() != null) {
				featureGroupType = featureGroup.getFeatureGroupType();
			} else if (featureGroup.getFeatureGroupPrototype() != null) {
				featureGroupType = findFeatureGroupTypeForFeatureGroupPrototype(
						AadlUtil.getContainingClassifier(referencingObject), featureGroup.getFeatureGroupPrototype());
			}
			if (featureGroupType != null) {
				searchResult = featureGroupType.findNamedElement(name);
			}
		} else if (context instanceof Feature) {
			Feature feature = (Feature) context;
			while (feature.getClassifier() == null && feature.getPrototype() == null && feature.getRefined() != null) {
				feature = feature.getRefined();
			}
			Classifier featureClassifier = null;
			if (feature.getClassifier() != null) {
				featureClassifier = feature.getClassifier();
			} else if (feature.getPrototype() != null) {
				featureClassifier = findClassifierForComponentPrototype(
						AadlUtil.getContainingClassifier(referencingObject), feature.getPrototype());
			}
			if (featureClassifier != null) {
				searchResult = featureClassifier.findNamedElement(name);
			}
		} else if (context instanceof Subcomponent) {
			Subcomponent subcomponent = (Subcomponent) context;
			while (subcomponent.getSubcomponentType() == null && subcomponent.getRefined() != null) {
				subcomponent = subcomponent.getRefined();
			}
			ComponentClassifier subcomponentClassifier = null;
			if (subcomponent.getSubcomponentType() instanceof ComponentClassifier) {
				subcomponentClassifier = (ComponentClassifier) subcomponent.getSubcomponentType();
			} else if (subcomponent.getSubcomponentType() instanceof ComponentPrototype) {
				subcomponentClassifier = findClassifierForComponentPrototype(
						AadlUtil.getContainingClassifier(referencingObject),
						(ComponentPrototype) subcomponent.getSubcomponentType());
			}
			if (subcomponentClassifier != null) {
				searchResult = subcomponentClassifier.findNamedElement(name);
			}
		} else if (context instanceof SubprogramCall) {
			SubprogramCall subprogramCall = (SubprogramCall) context;
			if (subprogramCall.getCalledSubprogram() instanceof ComponentClassifier) {
				searchResult = ((ComponentClassifier) subprogramCall.getCalledSubprogram()).findNamedElement(name);
			} else if (subprogramCall.getCalledSubprogram() instanceof SubprogramSubcomponent) {
				Subcomponent subcomponent = (SubprogramSubcomponent) subprogramCall.getCalledSubprogram();
				while (subcomponent.getSubcomponentType() == null && subcomponent.getRefined() != null) {
					subcomponent = subcomponent.getRefined();
				}
				ComponentClassifier subcomponentClassifier = null;
				if (subcomponent.getSubcomponentType() instanceof ComponentClassifier) {
					subcomponentClassifier = (ComponentClassifier) subcomponent.getSubcomponentType();
				} else if (subcomponent.getSubcomponentType() instanceof ComponentPrototype) {
					subcomponentClassifier = findClassifierForComponentPrototype(
							AadlUtil.getContainingClassifier(referencingObject),
							(ComponentPrototype) subcomponent.getSubcomponentType());
				}
				if (subcomponentClassifier != null) {
					searchResult = subcomponentClassifier.findNamedElement(name);
				}
			} else if (subprogramCall.getCalledSubprogram() instanceof SubprogramAccess) {
				Feature access = (SubprogramAccess) subprogramCall.getCalledSubprogram();
				while (access.getClassifier() == null && access.getPrototype() == null && access.getRefined() != null) {
					access = access.getRefined();
				}
				Classifier accessClassifier = null;
				if (access.getClassifier() != null) {
					accessClassifier = access.getClassifier();
				} else if (access.getPrototype() != null) {
					CallContext callContext = subprogramCall.getContext();
					if (callContext instanceof ComponentType) {
						accessClassifier = findClassifierForComponentPrototype((ComponentType) callContext,
								access.getPrototype());
					} else if (callContext instanceof FeatureGroup) {
						FeatureGroup callContextFeatureGroup = (FeatureGroup) callContext;
						FeatureGroupType prototypeContext = null;
						while (callContextFeatureGroup.getFeatureGroupType() == null
								&& callContextFeatureGroup.getFeatureGroupPrototype() == null
								&& callContextFeatureGroup.getRefined() instanceof FeatureGroup) {
							callContextFeatureGroup = (FeatureGroup) callContextFeatureGroup.getRefined();
						}
						if (callContextFeatureGroup.getFeatureGroupType() != null) {
							prototypeContext = callContextFeatureGroup.getFeatureGroupType();
						} else if (callContextFeatureGroup.getFeatureGroupPrototype() != null) {
							prototypeContext = findFeatureGroupTypeForFeatureGroupPrototype(
									AadlUtil.getContainingClassifier(referencingObject),
									callContextFeatureGroup.getFeatureGroupPrototype());
						}
						if (prototypeContext != null) {
							accessClassifier = findClassifierForComponentPrototype(prototypeContext,
									access.getPrototype());
						}
					} else if (callContext instanceof SubprogramGroupAccess) {
						Feature callContextAccess = (SubprogramGroupAccess) callContext;
						Classifier prototypeContext = null;
						while (callContextAccess.getClassifier() == null && callContextAccess.getPrototype() == null
								&& callContextAccess.getRefined() != null) {
							callContextAccess = callContextAccess.getRefined();
						}
						if (callContextAccess.getClassifier() != null) {
							prototypeContext = callContextAccess.getClassifier();
						} else if (callContextAccess.getPrototype() != null) {
							prototypeContext = findClassifierForComponentPrototype(
									AadlUtil.getContainingClassifier(referencingObject),
									callContextAccess.getPrototype());
						}
						if (prototypeContext != null) {
							accessClassifier = findClassifierForComponentPrototype(prototypeContext,
									access.getPrototype());
						}
					} else if (callContext instanceof SubprogramGroupSubcomponent) {
						Subcomponent callContextSubcomponent = (SubprogramGroupSubcomponent) callContext;
						while (callContextSubcomponent.getSubcomponentType() == null
								&& callContextSubcomponent.getRefined() != null) {
							callContextSubcomponent = callContextSubcomponent.getRefined();
						}
						if (callContextSubcomponent.getSubcomponentType() instanceof ComponentClassifier) {
							if (callContextSubcomponent.getOwnedPrototypeBindings().isEmpty()) {
								accessClassifier = findClassifierForComponentPrototype(
										callContextSubcomponent.getClassifier(), access.getPrototype());
							} else {
								accessClassifier = findClassifierForComponentPrototype(
										callContextSubcomponent.getClassifier(), callContextSubcomponent,
										access.getPrototype());
							}
						} else if (callContextSubcomponent.getSubcomponentType() instanceof ComponentPrototype) {
							ComponentClassifier prototypeContext = findClassifierForComponentPrototype(
									AadlUtil.getContainingClassifier(referencingObject),
									callContextSubcomponent.getPrototype());
							if (prototypeContext != null) {
								accessClassifier = findClassifierForComponentPrototype(prototypeContext,
										access.getPrototype());
							}
						}
					} else // callContext is null.
					{
						accessClassifier = findClassifierForComponentPrototype(
								AadlUtil.getContainingClassifier(referencingObject), access.getPrototype());
					}
				}
				if (accessClassifier != null) {
					searchResult = accessClassifier.findNamedElement(name);
				}
			} else if (subprogramCall.getCalledSubprogram() instanceof ComponentPrototype) {
				ComponentClassifier classifier = findClassifierForComponentPrototype(
						AadlUtil.getContainingClassifier(referencingObject),
						(ComponentPrototype) subprogramCall.getCalledSubprogram());
				if (classifier != null) {
					searchResult = classifier.findNamedElement(name);
				}
			}
		}
		if (validSearchResultType.isInstance(searchResult)) {
			return validSearchResultType.cast(searchResult);
		} else {
			return null;
		}
	}
}