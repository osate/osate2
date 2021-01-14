/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file). 
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
package org.osate.organization.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.osate.organization.organization.Organization;
import org.osate.organization.organization.OrganizationPackage;
import org.osate.organization.organization.Stakeholder;
import org.osate.organization.services.OrganizationGrammarAccess;

@SuppressWarnings("all")
public class OrganizationSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private OrganizationGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == OrganizationPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case OrganizationPackage.ORGANIZATION:
				sequence_Organization(context, (Organization) semanticObject); 
				return; 
			case OrganizationPackage.STAKEHOLDER:
				sequence_Stakeholder(context, (Stakeholder) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     Organization returns Organization
	 *
	 * Constraint:
	 *     (name=ID stakeholder+=Stakeholder+)
	 */
	protected void sequence_Organization(ISerializationContext context, Organization semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Stakeholder returns Stakeholder
	 *
	 * Constraint:
	 *     (
	 *         supervisor=[Stakeholder|QID]? 
	 *         (
	 *             name=ID 
	 *             (
	 *                 fullname=STRING | 
	 *                 title=STRING | 
	 *                 description=STRING | 
	 *                 role=STRING | 
	 *                 email=STRING | 
	 *                 phone=STRING
	 *             )*
	 *         )?
	 *     )+
	 */
	protected void sequence_Stakeholder(ISerializationContext context, Stakeholder semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
