/*
 * <copyright>
 * Copyright  2012 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 *
 * </copyright>
 *
 */
package org.osate.aadl2.modelsupport.util;

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentPrototype;
import org.osate.aadl2.ComponentPrototypeActual;
import org.osate.aadl2.ComponentPrototypeBinding;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.Element;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupPrototype;
import org.osate.aadl2.FeatureGroupPrototypeActual;
import org.osate.aadl2.FeatureGroupPrototypeBinding;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.FeaturePrototypeActual;
import org.osate.aadl2.FeaturePrototypeBinding;
import org.osate.aadl2.FeaturePrototypeReference;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Prototype;
import org.osate.aadl2.PrototypeBinding;
import org.osate.aadl2.Subcomponent;

/**
 * @author phf
 */
public class ResolvePrototypeUtil {

	/**
	 * Find the binding for a given component prototype.
	 *
	 * @param proto the prototype to resolve
	 * @param context the context of the feature or subcomponent in which the prototype is used, e.g., a
	 *            ComponentType, FeatureGroupType, ComponentImplementation
	 * @return The component prototype actual that the prototype resolves to.
	 */
	public static ComponentClassifier resolveComponentPrototype(ComponentPrototype proto, Element context) {
		ComponentPrototypeBinding cpb = (ComponentPrototypeBinding) resolvePrototype(proto, context);

		if (cpb == null) {
			// look for constraining classifier
			ComponentPrototype refinedPrototype = proto;
			while (refinedPrototype.getConstrainingClassifier() != null
					&& refinedPrototype.getRefined() instanceof ComponentPrototype) {
				refinedPrototype = (ComponentPrototype) refinedPrototype.getRefined();
			}
			if (refinedPrototype.getConstrainingClassifier() != null) {
				return refinedPrototype.getConstrainingClassifier();
			} else {
				return null;
			}
		}
		EList<ComponentPrototypeActual> actuals = cpb.getActuals();

		if (actuals != null && actuals.size() > 0) {
			ComponentPrototypeActual actual = actuals.get(0);

			if (actual.getSubcomponentType() instanceof ComponentClassifier) {
				return (ComponentClassifier) actual.getSubcomponentType();
			} else {
				if (actual.getSubcomponentType() instanceof ComponentPrototype
						&& context instanceof ContainmentPathElement) {
					// resolve recursively if we are in a containment path
					return resolveComponentPrototype((ComponentPrototype) actual.getSubcomponentType(),
							getPrevious((ContainmentPathElement) context));
				}
			}
		}
		return null;
	}

	/**
	 * Find the binding for a given feature group prototype.
	 *
	 * @param proto the prototype to resolve
	 * @param context the context of the feature group in which the prototype is used, e.g., a
	 *            ComponentType, FeatureGroupType, ContainmentPathElement
	 * @return The feature group prototype actual the prototype is bound to.
	 */
	public static FeatureGroupType resolveFeatureGroupPrototype(FeatureGroupPrototype proto, Element context) {
		FeatureGroupPrototypeBinding fgpb = (FeatureGroupPrototypeBinding) resolvePrototype(proto, context);

		if (fgpb == null) {
			// look for constraining classifier
			FeatureGroupPrototype refinedPrototype = proto;
			while (refinedPrototype.getConstrainingFeatureGroupType() != null
					&& refinedPrototype.getRefined() instanceof FeatureGroupPrototype) {
				refinedPrototype = (FeatureGroupPrototype) refinedPrototype.getRefined();
			}
			if (refinedPrototype.getConstrainingFeatureGroupType() != null) {
				return refinedPrototype.getConstrainingFeatureGroupType();
			} else {
				return null;
			}
		}
		FeatureGroupPrototypeActual actual = fgpb.getActual();

		if (actual.getFeatureType() instanceof FeatureGroupType) {
			return (FeatureGroupType) actual.getFeatureType();
		} else {
			if (actual.getFeatureType() instanceof Prototype && context instanceof ContainmentPathElement) {
				// resolve recursively if we are in a containment path
				return resolveFeatureGroupPrototype((FeatureGroupPrototype) actual.getFeatureType(),
						getPrevious((ContainmentPathElement) context));
			}
		}
		return null;
	}

	/**
	 * Find the binding for a given feature prototype. Recursively resolves references.
	 *
	 * @param proto the prototype to resolve
	 * @param context the context in which the prototype is used, e.g., a ComponentType, FeatureGroupType
	 * @return the actual feature this prototype resolves to.
	 */
	public static FeaturePrototypeBinding resolveFeaturePrototype(Prototype proto, Element context) {
		final FeaturePrototypeBinding fpb = (FeaturePrototypeBinding) resolvePrototype(proto, context);
		if (fpb == null) {
			// cannot resolve
			return null;
		}

		final FeaturePrototypeActual actual = fpb.getActual();
		if (actual instanceof FeaturePrototypeReference) {
			// If context is FeatureGroupPrototypeActual, use containing classifier as the context for the reference
			if (context instanceof FeatureGroupPrototypeActual) {
				context = context.getContainingClassifier();
			}
			return resolveFeaturePrototype(((FeaturePrototypeReference) actual).getPrototype(), context);
		}

		return fpb;
	}

	/**
	 * Find the binding for a given prototype.
	 *
	 * @param proto the prototype to resolve
	 * @param context the context of the entity in which the prototype is used, e.g., a
	 *            ComponentType, ComponentImplementation, FeatureGroupType, Subcomponent
	 * @return The binding that assigns the value to the prototype relative to
	 *         its usage context.
	 */
	public static PrototypeBinding resolvePrototype(Prototype proto, Element context) {
		PrototypeBinding result = null;
		if (context instanceof Classifier) {
			Classifier impl = (Classifier) context;
			result = impl.lookupPrototypeBinding(proto);
		} else if (context instanceof Subcomponent) {
			Subcomponent parentSub = (Subcomponent) context;
			result = parentSub.lookupPrototypeBinding(proto);
			if (result == null) {
				result = resolvePrototype(proto, parentSub.getAllClassifier());
			}
		} else if (context instanceof ContainmentPathElement) {
			result = resolvePrototypeInContainmentPath(proto, (ContainmentPathElement) context);
		} else if (context instanceof FeatureGroupPrototypeActual) {
			final FeatureGroupPrototypeActual fgpa = (FeatureGroupPrototypeActual) context;
			for (final PrototypeBinding binding : fgpa.getBindings()) {
				if (binding.getFormal() == proto) {
					result = binding;
					break;
				}
			}
		}
//		// lookup in parent's classifier (nested prototype bindings)
//		if (result == null && parent != null) {
//			ResolvedClassifier parentClassifier = getInstantiatedClassifier(parent, 0, classifierCache);
//
//			if (parentClassifier.bindings != null) {
//				for (PrototypeBinding binding : parentClassifier.bindings) {
//					if (binding.getFormal() == proto) {
//						result = binding;
//						break;
//					}
//				}
//			}
//			if (result == null) {
//				result = parentClassifier.classifier.lookupPrototypeBinding(proto);
//			}
//		}
		return result;
	}

	public static ContainmentPathElement getPrevious(ContainmentPathElement cpe) {
		Element parent = cpe.getOwner();
		if (parent instanceof ContainmentPathElement) {
			return (ContainmentPathElement) parent;
		} else {
			return null;
		}
	}

	public static PrototypeBinding resolvePrototypeInContainmentPath(Prototype proto, ContainmentPathElement cpe) {
		if (cpe.getNamedElement() instanceof Subcomponent) {
			PrototypeBinding res = resolvePrototype(proto, AadlUtil.getContainingClassifier(cpe.getNamedElement()));
			if (res != null) {
				return res;
			}
		}
		ContainmentPathElement previous = getPrevious(cpe);
		if (previous != null) {
			// find prototype binding in namespace of previous element
			NamedElement ne = previous.getNamedElement();
			if (ne instanceof Subcomponent) {
				// look for prototype in prototype binding of subcomponent declaration
				PrototypeBinding res = resolvePrototype(proto, ne);
				if (res != null) {
					return res;
				} else {
					Subcomponent subcomponent = (Subcomponent) ne;
					while (subcomponent.getSubcomponentType() == null && subcomponent.getRefined() != null) {
						subcomponent = subcomponent.getRefined();
					}
					ComponentClassifier subcomponentClassifier = null;
					if (subcomponent.getSubcomponentType() instanceof ComponentClassifier) {
						subcomponentClassifier = (ComponentClassifier) subcomponent.getSubcomponentType();
					} else if (subcomponent.getSubcomponentType() instanceof ComponentPrototype) {
						subcomponentClassifier = resolveComponentPrototype(
								(ComponentPrototype) subcomponent.getSubcomponentType(), previous);
					}
					if (subcomponentClassifier != null) {
						return resolvePrototype(proto, subcomponentClassifier);
					}
				}
			} else if (ne instanceof FeatureGroup) {
				FeatureGroup fg = (FeatureGroup) ne;
				while (fg.getFeatureType() == null && fg.getRefined() instanceof FeatureGroup) {
					fg = (FeatureGroup) fg.getRefined();
				}
				FeatureGroupType fgt = null;
				if (fg.getFeatureType() instanceof FeatureGroupType) {
					fgt = (FeatureGroupType) fg.getFeatureType();
				} else if (fg.getFeatureType() instanceof FeatureGroupPrototype) {
					fgt = resolveFeatureGroupPrototype((FeatureGroupPrototype) fg.getFeatureType(), previous);
				}
				if (fgt != null) {
					return resolvePrototype(proto, fgt);
				}
			} else if (ne instanceof Feature) {

			}
		} else {
			// the context is the entity with the property association
			// need to make sure we look in the correct name space
			Classifier cl = null;
			if (AadlUtil.getContainingSubcomponent(cpe) != null) {
				Subcomponent containingSubcomponent = AadlUtil.getContainingSubcomponent(cpe);
				PrototypeBinding res = resolvePrototype(proto, containingSubcomponent);
				if (res != null) {
					return res;
				}
				while (containingSubcomponent.getSubcomponentType() == null
						&& containingSubcomponent.getRefined() != null) {
					containingSubcomponent = containingSubcomponent.getRefined();
				}
				if (containingSubcomponent.getSubcomponentType() instanceof ComponentClassifier) {
					cl = (ComponentClassifier) containingSubcomponent.getSubcomponentType();
				} else if (containingSubcomponent.getSubcomponentType() instanceof ComponentPrototype) {
					cl = resolveComponentPrototype((ComponentPrototype) containingSubcomponent.getSubcomponentType(),
							AadlUtil.getContainingClassifier(cpe));
				}
			} else if (AadlUtil.getContainingFeatureGroup(cpe) != null) {
				FeatureGroup containingFeatureGroup = AadlUtil.getContainingFeatureGroup(cpe);
				FeatureGroupType typeForContainingFeatureGroup = null;
				while (containingFeatureGroup.getFeatureType() == null
						&& containingFeatureGroup.getRefined() instanceof FeatureGroup) {
					containingFeatureGroup = (FeatureGroup) containingFeatureGroup.getRefined();
				}
				if (containingFeatureGroup.getFeatureType() instanceof FeatureGroupType) {
					typeForContainingFeatureGroup = (FeatureGroupType) containingFeatureGroup.getFeatureType();
				} else if (containingFeatureGroup.getFeatureType() instanceof FeatureGroupPrototype) {
					typeForContainingFeatureGroup = resolveFeatureGroupPrototype(
							(FeatureGroupPrototype) containingFeatureGroup.getFeatureType(),
							AadlUtil.getContainingClassifier(cpe));
				}
				if (typeForContainingFeatureGroup != null) {
					PrototypeBinding res = resolvePrototype(proto, typeForContainingFeatureGroup);
					if (res != null) {
						return res;
					}
				}
			} else {
				cl = AadlUtil.getContainingClassifier(cpe);
			}
			PrototypeBinding res = resolvePrototype(proto, cl);
			return res;
		}
		return null;
	}
}
