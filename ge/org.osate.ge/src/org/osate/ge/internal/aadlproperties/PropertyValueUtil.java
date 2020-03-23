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

import java.util.LinkedList;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.ge.internal.query.Queryable;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public class PropertyValueUtil {
	private static StandaloneQuery classifierQuery = StandaloneQuery.create((rootQuery) -> rootQuery.children().children().filterByBusinessObjectCanonicalReference(qa -> qa).first());
	private static StandaloneQuery partialInstanceObjectQuery = StandaloneQuery.create((rootQuery) -> rootQuery
			.descendantsByBusinessObjectsRelativeReference((InstanceObject io) -> getInstanceObjectPath(io), 1)
			.first());
	private static StandaloneQuery instanceObjectQuery = StandaloneQuery.create((rootQuery) -> rootQuery
			.descendantsByBusinessObjectsRelativeReference((InstanceObject io) -> getInstanceObjectPath(io)).first());

	public static Queryable getReferencedClassifier(final Queryable q,
			final ClassifierValue cv,
			final QueryService queryService) {
		// Decide whether to show it as connection or not.
		Queryable top = q;
		while(top.getParent() != null) {
			top = top.getParent();
		}

		return queryService.getFirstResult(classifierQuery, top, cv.getClassifier());
	}

	public static AadlPropertyResolutionResults getReferencedInstanceObject(final Queryable q, final InstanceObject io,
			final QueryService queryService) {

		// Decide whether to show it as connection or not.
		Queryable top = q;
		while (top.getParent() != null) {
			top = top.getParent();
		}

		final Queryable dst = queryService.getFirstResult(partialInstanceObjectQuery, top, io);
		final boolean hasPartial = dst != null;
		final Queryable referencedQueryable = queryService.getFirstResult(instanceObjectQuery, top, io);
		final boolean isPartial = hasPartial && dst != referencedQueryable;
		return new AadlPropertyResolutionResults(dst, isPartial);
	}

	private static Object[] getInstanceObjectPath(final InstanceObject io) {
		final LinkedList<InstanceObject> path = new LinkedList<InstanceObject>();
		for (EObject tmp = io; tmp instanceof InstanceObject; tmp = tmp.eContainer()) {
			path.addFirst((InstanceObject) tmp);
		}
		return path.toArray(new Object[path.size()]);
	}
}
