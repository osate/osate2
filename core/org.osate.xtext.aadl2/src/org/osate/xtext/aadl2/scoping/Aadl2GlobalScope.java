/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.xtext.aadl2.scoping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.PrivatePackageSection;
import org.osate.aadl2.modelsupport.scoping.Aadl2IndexMetadata;
import org.osate.aadl2.modelsupport.util.AadlUtil;

/** Selects visible, type-compatible descriptions without resolving index proxies. */
final class Aadl2GlobalScope implements IScope {
	private final IScope delegate;
	private final EClass requiredType;
	private final String packageName;
	private final boolean privateContext;

	Aadl2GlobalScope(IScope delegate, EObject context, EReference reference) {
		this.delegate = delegate;
		requiredType = reference.getEReferenceType();
		var namespace = AadlUtil.getContainingTopLevelNamespace(context);
		privateContext = namespace instanceof PrivatePackageSection;
		packageName = namespace instanceof PackageSection section ? ((AadlPackage) section.getOwner()).getName() : null;
	}

	@Override
	public IEObjectDescription getSingleElement(QualifiedName name) {
		var candidates = getElements(name).iterator();
		if (!candidates.hasNext()) {
			return null;
		}
		var candidate = candidates.next();
		return candidates.hasNext() ? null : candidate;
	}

	@Override
	public Iterable<IEObjectDescription> getElements(QualifiedName name) {
		List<IEObjectDescription> selected = new ArrayList<>();
		int bestRank = Integer.MAX_VALUE;
		for (var description : delegate.getElements(name)) {
			int rank = rank(description);
			if (rank == Integer.MAX_VALUE) {
				continue;
			}
			if (rank < bestRank) {
				selected.clear();
				bestRank = rank;
			}
			if (rank == bestRank) {
				selected.add(description);
			}
		}
		return selected;
	}

	@Override
	public IEObjectDescription getSingleElement(EObject object) {
		var descriptions = getElements(object).iterator();
		return descriptions.hasNext() ? descriptions.next() : null;
	}

	@Override
	public Iterable<IEObjectDescription> getElements(EObject object) {
		return () -> StreamSupport.stream(delegate.getElements(object).spliterator(), false).filter(description -> {
			var selected = getSingleElement(description.getName());
			return selected != null && selected.getEObjectURI().equals(description.getEObjectURI());
		}).iterator();
	}

	@Override
	public Iterable<IEObjectDescription> getAllElements() {
		return () -> StreamSupport.stream(delegate.getAllElements().spliterator(), false)
				.filter(description -> rank(description) != Integer.MAX_VALUE).iterator();
	}

	private int rank(IEObjectDescription description) {
		if (requiredType != null && !requiredType.isSuperTypeOf(description.getEClass())) {
			return Integer.MAX_VALUE;
		}
		boolean privateCandidate = Aadl2IndexMetadata.PRIVATE.equals(description.getUserData(Aadl2IndexMetadata.VISIBILITY));
		String candidatePackage = description.getUserData(Aadl2IndexMetadata.PACKAGE_NAME);
		// Resource-local descriptions can lack index metadata. Inspect only objects that are already loaded.
		if (description.getUserData(Aadl2IndexMetadata.VISIBILITY) == null) {
			var object = description.getEObjectOrProxy();
			if (!object.eIsProxy() && AadlUtil.getContainingTopLevelNamespace(object) instanceof PrivatePackageSection section) {
				privateCandidate = true;
				candidatePackage = ((AadlPackage) section.getOwner()).getName();
			}
		}
		if (privateCandidate && (!privateContext || packageName == null || !packageName.equalsIgnoreCase(candidatePackage))) {
			return Integer.MAX_VALUE;
		}
		return privateCandidate ? 0 : 1;
	}
}
