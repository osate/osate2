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
package org.osate.xtext.aadl2.errormodel.serializer;

import java.util.Objects;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic;
import org.eclipse.xtext.serializer.tokens.CrossReferenceSerializer;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.NamedElement;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;

/**
 * Verifies ErrorModelCrossReferenceSerializer behavior after the Xtend-to-Java migration.
 */
public class ErrorModelCrossReferenceSerializer extends CrossReferenceSerializer {
	public static final String PREFIX = "emv2$";

	@Override
	public String serializeCrossRef(final EObject semanticObject, final CrossReference crossref, final EObject target,
			final INode node, final ISerializationDiagnostic.Acceptor errors) {
		var crossReference = super.serializeCrossRef(semanticObject, crossref, target, node, errors);
		return crossReference.startsWith(PREFIX) ? crossReference.substring(PREFIX.length()) : crossReference;
	}

	@Override
	protected String getCrossReferenceNameFromScope(final EObject semanticObject, final CrossReference crossref,
			final EObject target, final IScope scope, final ISerializationDiagnostic.Acceptor errors) {
		var reference = GrammarUtil.getReference(crossref);
		if (isErrorTypeReference(reference)) {
			return getErrorTypeReferenceName((ErrorTypes) target, scope);
		}
		if (Objects.equals(reference, ErrorModelPackage.Literals.ERROR_MODEL_LIBRARY__EXTENDS)) {
			var aadlPackage = EcoreUtil2.getContainerOfType(target, AadlPackage.class);
			return aadlPackage == null ? null : aadlPackage.getName();
		}
		if (isNamedElementReference(reference)) {
			return ((NamedElement) target).getName();
		}
		return super.getCrossReferenceNameFromScope(semanticObject, crossref, target, scope, errors);
	}

	private static boolean isErrorTypeReference(final EReference reference) {
		return Objects.equals(reference, ErrorModelPackage.Literals.TYPE_TOKEN__TYPE)
				|| Objects.equals(reference, ErrorModelPackage.Literals.ERROR_TYPE__SUPER_TYPE)
				|| Objects.equals(reference, ErrorModelPackage.Literals.ERROR_TYPE__ALIASED_TYPE)
				|| Objects.equals(reference, ErrorModelPackage.Literals.TYPE_SET__ALIASED_TYPE);
	}

	private static boolean isNamedElementReference(final EReference reference) {
		return Objects.equals(reference, ErrorModelPackage.Literals.FEATUREOR_PP_REFERENCE__FEATUREOR_PP)
				|| Objects.equals(reference, ErrorModelPackage.Literals.QUALIFIED_PROPAGATION_POINT__PROPAGATION_POINT)
				|| Objects.equals(reference, ErrorModelPackage.Literals.SUBCOMPONENT_ELEMENT__SUBCOMPONENT);
	}

	private static String getErrorTypeReferenceName(final ErrorTypes target, final IScope scope) {
		var simpleName = target.getName();
		IEObjectDescription fromScope = scope.getSingleElement(QualifiedName.create(simpleName));
		var targetPackage = EcoreUtil2.getContainerOfType(target, AadlPackage.class);
		if (fromScope == null
				|| !Objects.equals(EcoreUtil2.getContainerOfType(fromScope.getEObjectOrProxy(), AadlPackage.class),
						targetPackage)) {
			return targetPackage.getName() + "::" + simpleName;
		}
		return simpleName;
	}
}
