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

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentPrototype;
import org.osate.aadl2.ComponentPrototypeActual;
import org.osate.aadl2.ComponentPrototypeBinding;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.Element;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
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
	public static ComponentClassifier resolveComponentPrototype(Prototype proto, Element context) {
		ComponentPrototypeBinding cpb = (ComponentPrototypeBinding) resolvePrototype(proto, context);

		if (cpb == null) {
			// cannot resolve
			return null;
		}
		EList<ComponentPrototypeActual> actuals = cpb.getActuals();

		if (actuals != null && actuals.size() > 0) {
			ComponentPrototypeActual actual = actuals.get(0);

			if (actual.getSubcomponentType() instanceof ComponentClassifier) {
				return (ComponentClassifier)actual.getSubcomponentType();
			} else {
				if (actual.getSubcomponentType() instanceof ComponentPrototype && context instanceof ContainmentPathElement){
				// resolve recursively if we are in a containment path
					return resolveComponentPrototype((Prototype)actual.getSubcomponentType(), getPrevious((ContainmentPathElement) context));
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
	public static FeatureGroupType resolveFeatureGroupPrototype(Prototype proto, Element context) {
		FeatureGroupPrototypeBinding fgpb = (FeatureGroupPrototypeBinding) resolvePrototype(proto, context);

		if (fgpb == null) {
			// cannot resolve
			return null;
		}
		FeatureGroupPrototypeActual actual = fgpb.getActual();

		if (actual.getFeatureType() instanceof FeatureGroupType) {
			return (FeatureGroupType) actual.getFeatureType();
		} else {
			if (actual.getFeatureType() instanceof Prototype && context instanceof ContainmentPathElement){
			// resolve recursively if we are in a containment path
				return resolveFeatureGroupPrototype((Prototype)actual.getFeatureType(), getPrevious((ContainmentPathElement) context));
			}
		}
		return null;
	}

	/**
	 * Find the binding for a given feature prototype.
	 * 
	 * @param proto the prototype to resolve
	 * @param context the context in which the prototype is used, e.g., a
	 *            ComponentType,  FeatureGroupType
	 * @return The actual feature this prototype resolves to.
	 */
	public static Feature resolveFeaturePrototype(Prototype proto, Element context) {
//		FeaturePrototypeBinding fpb = (FeaturePrototypeBinding) resolvePrototype(proto, context);
//
//		if (fpb == null) {
//			return null;
//		}
//		FeaturePrototypeActual actual = fpb.getActual();
//		if (actual.getFeatureType() instanceof FeatureGroupType) {
//			return (FeatureGroupType) actual.getFeatureType();
//		} else {
//			if (actual.getFeatureType() instanceof Prototype && context instanceof ContainmentPathElement){
//			// resolve recursively if we are in a containment path
//				return resolveFeatureGroupPrototype((Prototype)actual.getFeatureType(), getPrevious((ContainmentPathElement) context));
//			}
//		}
		return null;
//		if (result instanceof FeaturePrototypeReference) {
////			// resolve recursively
////			result = resolveFeaturePrototype(((FeaturePrototypeReference) fpb.getActual()).getPrototype(),
////					context.getContainingComponentInstance(), classifierCache);
//		}
//		return result;
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
			Subcomponent parentSub = (Subcomponent)context;
			result = parentSub.lookupPrototypeBinding(proto);
		} else if (context instanceof ContainmentPathElement){
			result = resolvePrototypeInContainmentPath(proto, (ContainmentPathElement)context);
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
	
	public static ContainmentPathElement getPrevious(ContainmentPathElement cpe){
		ContainedNamedElement path = (ContainedNamedElement) cpe.eContainer();
		EList<ContainmentPathElement> list = path.getContainmentPathElements();
		int idx = list.indexOf(cpe);
		if (idx > 0){
			return list.get(idx - 1);
		} else {
			return null;
		}
	}
	
	public static PrototypeBinding resolvePrototypeInContainmentPath(Prototype proto, ContainmentPathElement cpe){
		ContainmentPathElement previous = getPrevious(cpe);
		if (previous != null){
			// find prototype binding in namespace of previous element
			NamedElement ne = previous.getNamedElement();
			if (ne instanceof Subcomponent){
				// look for prototype in prototype binding of subcomponent declaration
				PrototypeBinding res = resolvePrototype(proto, ne);
				if (res == null){
					ComponentClassifier cl = ((Subcomponent)ne).getAllClassifier();
					res = resolvePrototype(proto, cl);
				}
				return res;
			} else if (ne instanceof FeatureGroup){
				
			} else if (ne instanceof Feature){
				
			}
		} else {
			// the context is the entity with the property association
			// need to make sure we look in the correct name space
			Classifier cl = null;
			if (AadlUtil.getContainingSubcomponent(cpe) != null){
				cl = AadlUtil.getContainingSubcomponentClassifier(cpe);
			} else {
				cl =AadlUtil.getContainingClassifier(cpe);
			}
			PrototypeBinding res = resolvePrototype(proto, cl);
			return res;
		}
		return null;
	}

}
