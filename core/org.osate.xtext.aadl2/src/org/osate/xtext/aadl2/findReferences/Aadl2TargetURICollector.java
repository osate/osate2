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
package org.osate.xtext.aadl2.findReferences;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.findReferences.TargetURICollector;
import org.eclipse.xtext.findReferences.TargetURIs;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.PropertyType;

public class Aadl2TargetURICollector extends TargetURICollector {

	@Override
	protected void doAdd(EObject object, TargetURIs targetURIs) {
		super.doAdd(object, targetURIs);

		if (object instanceof ComponentType) {
			AadlPackage pkg = EcoreUtil2.getContainerOfType(object, AadlPackage.class);
			for (ComponentImplementation impl : EcoreUtil2.getAllContentsOfType(pkg, ComponentImplementation.class)) {
				if (impl.getType() == object) {
					super.doAdd(impl, targetURIs);
				}
			}
		} else if (object instanceof AadlPackage) {
			for (Classifier cl : EcoreUtil2.getAllContentsOfType(object, Classifier.class)) {
				super.doAdd(cl, targetURIs);
			}
		} else if (object instanceof PropertySet) {
			for (PropertyType p : EcoreUtil2.getAllContentsOfType(object, PropertyType.class)) {
				super.doAdd(p, targetURIs);
			}
			for (PropertyConstant p : EcoreUtil2.getAllContentsOfType(object, PropertyConstant.class)) {
				super.doAdd(p, targetURIs);
			}
			for (Property p : EcoreUtil2.getAllContentsOfType(object, Property.class)) {
				super.doAdd(p, targetURIs);
			}
		}
	}

}
