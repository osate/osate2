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
package org.osate.xtext.aadl2.ba.naming;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage;
import org.osate.xtext.aadl2.properties.naming.PropertiesQualifiedNameProvider;

/**
 * Keeps subclause-local BA declarations out of the global AADL index. BA has no annex-library declarations, and local
 * states are scoped directly by {@code BehaviorAnnexScopeProvider}; exporting them would also make the parsed annex
 * collide with its containing {@code DefaultAnnexSubclause} in Xtext's unique-name validation.
 */
public final class BehaviorAnnexQualifiedNameProvider extends PropertiesQualifiedNameProvider {
	@Override
	public QualifiedName getFullyQualifiedName(EObject object) {
		if (object.eClass().getEPackage() == BehaviorAnnexPackage.eINSTANCE) {
			return null;
		}
		return super.getFullyQualifiedName(object);
	}
}
