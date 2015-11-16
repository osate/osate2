/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 *
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 *
 * See COPYRIGHT file for full details.
 */
package org.osate.organization.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.osate.organization.organization.Organization;
import org.osate.organization.organization.OrganizationPackage;
import org.osate.organization.organization.Stakeholder;
import org.osate.organization.services.OrganizationGrammarAccess;

@SuppressWarnings("all")
public class OrganizationSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private OrganizationGrammarAccess grammarAccess;
	
	@Override
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == OrganizationPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case OrganizationPackage.ORGANIZATION:
				sequence_Organization(context, (Organization) semanticObject); 
				return; 
			case OrganizationPackage.STAKEHOLDER:
				sequence_Stakeholder(context, (Stakeholder) semanticObject); 
				return; 
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (name=ID stakeholder+=Stakeholder+)
	 */
	protected void sequence_Organization(EObject context, Organization semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         fullname=STRING? 
	 *         title=STRING? 
	 *         description=STRING? 
	 *         role=STRING? 
	 *         email=STRING? 
	 *         phone=STRING? 
	 *         supervisor=[Stakeholder|QID]?
	 *     )
	 */
	protected void sequence_Stakeholder(EObject context, Stakeholder semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
