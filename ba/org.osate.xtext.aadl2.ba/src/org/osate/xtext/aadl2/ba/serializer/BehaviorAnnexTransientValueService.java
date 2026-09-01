/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 */
package org.osate.xtext.aadl2.ba.serializer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.parsetree.reconstr.impl.DefaultTransientValueService;
import org.osate.aadl2.Aadl2Package;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex;

/**
 * Treats the annex name assigned by the AADL host as transient because the BA grammar owns only the subclause body.
 */
public final class BehaviorAnnexTransientValueService extends DefaultTransientValueService {
	@Override
	public boolean isTransient(EObject owner, EStructuralFeature feature, int index) {
		if (owner instanceof BehaviorAnnex && feature == Aadl2Package.eINSTANCE.getNamedElement_Name()) {
			return true;
		}
		return super.isTransient(owner, feature, index);
	}
}
