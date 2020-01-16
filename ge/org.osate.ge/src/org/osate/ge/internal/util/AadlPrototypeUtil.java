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
package org.osate.ge.internal.util;

import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Element;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupPrototypeActual;
import org.osate.aadl2.FeatureGroupPrototypeBinding;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.Prototype;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.modelsupport.util.ResolvePrototypeUtil;
import org.osate.ge.internal.query.Queryable;

public class AadlPrototypeUtil {
	public static ComponentClassifier getComponentClassifier(final Element bindingContext, final Subcomponent sc) {
		if(sc.getPrototype() == null) {
			return sc.getClassifier();
		} else {
			if(bindingContext == null) {
				return null;
			}
			
			final ComponentClassifier cc = ResolvePrototypeUtil.resolveComponentPrototype(sc.getPrototype(), bindingContext);
			if(cc != null) {
				return cc;
			}

			return sc.getPrototype().getConstrainingClassifier();	
		}
	}

	public static FeatureGroupType getFeatureGroupType(final Element bindingContext, final FeatureGroup fg) {
		if(fg.getFeatureGroupPrototype() == null) {
			return fg.getAllFeatureGroupType();
		} else {
			if(bindingContext != null) {
				final FeatureGroupType fgt = ResolvePrototypeUtil.resolveFeatureGroupPrototype(fg.getFeatureGroupPrototype(), bindingContext);
				if(fgt != null) {
					return fgt;
				}
				return fg.getFeatureGroupPrototype().getConstrainingFeatureGroupType();
			}			
		}

		return null;
	}
	
	public static Element getPrototypeBindingContext(final Queryable queryable) {
		final Queryable container = queryable.getParent();
		if(container != null) {
			return getPrototypeBindingContextByContainer(container);
		}		
					
		return null;
	}
	
	public static Element getPrototypeBindingContextByContainer(final Queryable queryable) {
		Queryable temp = queryable;
		
		while(temp != null) {
			Object bo = temp.getBusinessObject();
			if(bo instanceof ComponentClassifier || bo instanceof FeatureGroupType) {
				return (Classifier)bo;
			} else if(bo instanceof Subcomponent) {
				return (Subcomponent)bo;
			} else if(bo instanceof FeatureGroup){
				if(temp.getParent() != null) {
					return getFeatureGroupTypeOrActual(temp.getParent(), (FeatureGroup)bo);	
				}
				return null;
			}

			temp = temp.getParent();
		}
		return null;
	}
	
	/**
	 * Returns either the feature group type or the actual prototype
	 * @param 
	 * @param fg
	 * @param fp
	 * @return
	 */
	private static Element getFeatureGroupTypeOrActual(final Queryable queryable, final FeatureGroup fg) {
		if(fg.getFeatureGroupPrototype() == null) {
			return fg.getAllFeatureGroupType();
		} else {
			final Element bindingContext = getPrototypeBindingContext(queryable);
			if(bindingContext != null) {
				return resolveFeatureGroupPrototypeToActual(fg.getFeatureGroupPrototype(), bindingContext);
			} else {
				return null;
			}
		}
	}
	
	private static FeatureGroupPrototypeActual resolveFeatureGroupPrototypeToActual(Prototype proto, Element context) {
		FeatureGroupPrototypeBinding fgpb = (FeatureGroupPrototypeBinding)ResolvePrototypeUtil.resolvePrototype(proto, context);

		if (fgpb == null) {
			// cannot resolve
			return null;
		}
		
		return fgpb.getActual();
	}
}
