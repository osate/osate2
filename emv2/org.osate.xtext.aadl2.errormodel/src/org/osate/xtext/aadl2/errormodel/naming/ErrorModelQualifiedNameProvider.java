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
package org.osate.xtext.aadl2.errormodel.naming;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.NamedElement;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2Root;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeMappingSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeTransformationSet;

public class ErrorModelQualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider {

	// Enable to limit indexing to global items
	// Duplicates checking only applies to global items
	@Override
	public QualifiedName getFullyQualifiedName(final EObject obj) {
		if (obj instanceof ErrorBehaviorStateMachine || obj instanceof TypeMappingSet
				|| obj instanceof ErrorModelLibrary || obj instanceof ErrorModelSubclause || obj instanceof ErrorType
				|| obj instanceof TypeSet || obj instanceof TypeTransformationSet) {
			/*
			 * It is important that we return null if obj is not in an
			 * AadlPackage or in a EMV2Root. This happens when serializing an
			 * aadl file with an error model annex. See EMV2AnnexUnparser. If
			 * this check is not here, then a ClassCastException occurs during
			 * serialization.
			 */
			NamedElement namedElement = (NamedElement) obj;
			NamedElement root = namedElement.getElementRoot();
			if (namedElement.getName() == null || !(root instanceof AadlPackage || root instanceof EMV2Root)
					|| (obj instanceof ErrorModelSubclause && !(root instanceof EMV2Root))) {
				return null;
			}
			return getConverter().toQualifiedName(getTheName(namedElement));
		}
		if (obj instanceof AadlPackage) {
			return getConverter().toQualifiedName(((AadlPackage) obj).getName());
		}
		return null;
	}

	protected String getTheName(NamedElement namedElement) {
		NamedElement root = namedElement.getElementRoot();
		if (root instanceof EMV2Root) {
			if (namedElement instanceof ErrorModelLibrary || namedElement instanceof ErrorModelSubclause) {
				return namedElement.getName();
			}
			ErrorModelLibrary eml = ((EMV2Root) root).getLibrary();
			if (eml != null)
				return root.getName() + "::" + namedElement.getName();
		}
		if (namedElement instanceof ErrorModelLibrary) {
			return "emv2$" + root.getName();
		}
		return "emv2$" + root.getName() + "::" + namedElement.getName();
	}
}