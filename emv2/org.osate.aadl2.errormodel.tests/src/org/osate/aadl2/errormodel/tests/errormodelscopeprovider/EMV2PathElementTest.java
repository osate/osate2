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
package org.osate.aadl2.errormodel.tests.errormodelscopeprovider;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.validation.Issue;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider;
import org.osate.testsupport.AssertHelper;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.errormodel.errorModel.CompositeState;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2Path;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2PathElement;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2PropertyAssociation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition;
import org.osate.xtext.aadl2.errormodel.errorModel.SConditionElement;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;
import com.itemis.xtext.testing.XtextTest;

/**
 * Verifies EMV2 path-element scopes across grammar contexts because these scopes drive linking and editing.
 */
@RunWith(XtextRunner.class)
@InjectWith(ErrorModelInjectorProvider.class)
public class EMV2PathElementTest extends XtextTest {
	@Inject
	private TestHelper<AadlPackage> testHelper;
	private AssertHelper assertHelper = IResourceServiceProvider.Registry.INSTANCE
			.getResourceServiceProvider(URI.createFileURI("dummy.emv2")).<AssertHelper>get(AssertHelper.class);

	/**
	 * Tests scope_EMV2PathElement_namedElement for grammar path: ErrorModelLibrary -> ErrorBehaviorStateMachine ->
	 * 		ErrorBehaviorTransition -> ConditionExpression -> ... -> QualifiedErrorEventOrPropagation ->
	 * 		EMV2ErrorPropagationPath
	 */
	@Test
	public void testErrorBehaviorTransitionInErrorBehaviorStateMachine() throws Exception {
		var aadlText = """
				package ErrorBehaviorTransition_in_ErrorBehaviorStateMachine
				public
				\tannex EMV2 {**
				\t\terror behavior bvr1
				\t\tevents
				\t\t\tevt1: error event;
				\t\ttransitions
				\t\t\ttrans1: all -[ evt1 ]-> same state;
				\t\tend behavior;
				\t**};
				end ErrorBehaviorTransition_in_ErrorBehaviorStateMachine;
				""";
		final AadlPackage pkg = this.testHelper.parseString(aadlText);
		Assert.assertEquals("ErrorBehaviorTransition_in_ErrorBehaviorStateMachine", pkg.getName());
		var errorBehaviorStateMachine = (((ErrorModelLibrary) ((DefaultAnnexLibrary) (pkg.getPublicSection()
				.getOwnedAnnexLibraries()).getFirst()).getParsedAnnexLibrary()).getBehaviors()).getFirst();
		Assert.assertEquals("bvr1", errorBehaviorStateMachine.getName());
		var errorBehaviorTransition = (errorBehaviorStateMachine.getTransitions()).getFirst();
		Assert.assertEquals("trans1", errorBehaviorTransition.getName());
		var emv2PathElement = ((ConditionElement) errorBehaviorTransition.getCondition())
				.getQualifiedErrorPropagationReference().getEmv2Target();
		Assert.assertEquals("evt1", emv2PathElement.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("evt1"));
		Assert.assertNull(emv2PathElement.getPath());

	}

	/**
	 * Tests scope_EMV2PathElement_namedElement for grammar path: ErrorModelSubclause -> ErrorBehaviorTransition ->
	 * 		ConditionExpression -> ... -> QualifiedErrorEventOrPropagation -> EMV2ErrorPropagationPath
	 */
	@Test
	public void testErrorBehaviorTransitionInErrorModelSubclause() throws Exception {
		var aadlText = """
				package ErrorBehaviorTransition_in_ErrorModelSubclause
				public
				\tabstract a1
				\t\tfeatures
				\t\t\tport1: in event port;
				\t\t\tport2: in event port;
				\t\t\tfg1: feature group fgt1;
				\t\tannex EMV2 {**
				\t\t\tuse types ErrorBehaviorTransition_in_ErrorModelSubclause;
				\t\t\tuse behavior ErrorBehaviorTransition_in_ErrorModelSubclause::bvr1;
				\t\t\t
				\t\t\terror propagations
				\t\t\t\tport1: in propagation {t1};
				\t\t\t\tfg1.fg2.fg3.port3: in propagation {t1};
				\t\t\tend propagations;
				\t\t\t
				\t\t\tcomponent error behavior
				\t\t\tevents
				\t\t\t\tevt1: error event;
				\t\t\tend component;
				\t\t**};
				\tend a1;
				\t
				\tabstract implementation a1.i
				\t\tsubcomponents
				\t\t\tasub1: abstract a2.i;
				\t\tannex EMV2 {**
				\t\t\terror propagations
				\t\t\t\tport2: in propagation {t1};
				\t\t\t\tfg1.fg2.fg3.port4: in propagation {t1};
				\t\t\tend propagations;
				\t\t\t
				\t\t\tcomponent error behavior
				\t\t\tevents
				\t\t\t\tevt2: error event;
				\t\t\ttransitions
				\t\t\t\ttrans1: all -[ evt1 ]-> same state;
				\t\t\t\ttrans2: all -[ evt2 ]-> same state;
				\t\t\t\ttrans3: all -[ evt3 ]-> same state;
				\t\t\t\ttrans4: all -[ port1 ]-> same state;
				\t\t\t\ttrans5: all -[ port2 ]-> same state;
				\t\t\t\ttrans6: all -[ fg1.fg2.fg3.port3 ]-> same state;
				\t\t\t\ttrans7: all -[ fg1.fg2.fg3.port4 ]-> same state;
				\t\t\t\ttrans8: all -[ asub1.port5 ]-> same state;
				\t\t\t\ttrans9: all -[ asub1.fg4.port3 ]-> same state;
				\t\t\t\ttrans10: all -[ asub1.asub2.asub3.fg5.fg2.fg3.port3 ]-> same state;
				\t\t\tend component;
				\t\t**};
				\tend a1.i;
				\t
				\tfeature group fgt1
				\t\tfeatures
				\t\t\tfg2: feature group fgt2;
				\tend fgt1;
				\t
				\tfeature group fgt2
				\t\tfeatures
				\t\t\tfg3: feature group fgt3;
				\tend fgt2;
				\t
				\tfeature group fgt3
				\t\tfeatures
				\t\t\tport3: in out event port;
				\t\t\tport4: in event port;
				\tend fgt3;
				\t
				\tabstract a2
				\t\tfeatures
				\t\t\tport5: out event port;
				\t\t\tfg4: feature group fgt3;
				\tend a2;
				\t
				\tabstract implementation a2.i
				\t\tsubcomponents
				\t\t\tasub2: abstract a3.i;
				\t\tannex EMV2 {**
				\t\t\tuse types ErrorBehaviorTransition_in_ErrorModelSubclause;
				\t\t\t
				\t\t\terror propagations
				\t\t\t\tport5: out propagation {t1};
				\t\t\t\tfg4.port3: out propagation {t1};
				\t\t\tend propagations;
				\t\t**};
				\tend a2.i;
				\t
				\tabstract a3
				\tend a3;
				\t
				\tabstract implementation a3.i
				\t\tsubcomponents
				\t\t\tasub3: abstract a4.i;
				\tend a3.i;
				\t
				\tabstract a4
				\t\tfeatures
				\t\t\tfg5: feature group fgt1;
				\tend a4;
				\t
				\tabstract implementation a4.i
				\t\tannex EMV2 {**
				\t\t\tuse types ErrorBehaviorTransition_in_ErrorModelSubclause;
				\t\t\t
				\t\t\terror propagations
				\t\t\t\tfg5.fg2.fg3.port3: in propagation {t1};
				\t\t\tend propagations;
				\t\t**};
				\tend a4.i;
				\t
				\tannex EMV2 {**
				\t\terror types
				\t\t\tt1: type;
				\t\tend types;
				\t\t
				\t\terror behavior bvr1
				\t\tevents
				\t\t\tevt3: error event;
				\t\tend behavior;
				\t**};
				end ErrorBehaviorTransition_in_ErrorModelSubclause;
				""";
		final AadlPackage pkg = this.testHelper.parseString(aadlText);
		Assert.assertEquals("ErrorBehaviorTransition_in_ErrorModelSubclause", pkg.getName());
		var classifier = pkg.getPublicSection().getOwnedClassifiers().get(1);
		Assert.assertEquals("a1.i", classifier.getName());
		var errorModelSubclause = ((ErrorModelSubclause) ((DefaultAnnexSubclause) (classifier.getOwnedAnnexSubclauses())
				.getFirst()).getParsedAnnexSubclause());
		final List<String> firstElementScope = List.of("evt1", "evt2", "evt3", "port1", "port2", "fg1", "asub1");
		var errorBehaviorTransition = errorModelSubclause.getTransitions().get(0);
		Assert.assertEquals("trans1", errorBehaviorTransition.getName());
		var emv2PathElement16 = ((ConditionElement) errorBehaviorTransition.getCondition())
				.getQualifiedErrorPropagationReference().getEmv2Target();
		Assert.assertEquals("evt1", emv2PathElement16.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement16, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		Assert.assertNull(emv2PathElement16.getPath());
		var errorBehaviorTransition2 = errorModelSubclause.getTransitions().get(1);
		Assert.assertEquals("trans2", errorBehaviorTransition2.getName());
		var emv2PathElement17 = ((ConditionElement) errorBehaviorTransition2.getCondition())
				.getQualifiedErrorPropagationReference().getEmv2Target();
		Assert.assertEquals("evt2", emv2PathElement17.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement17, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		Assert.assertNull(emv2PathElement17.getPath());
		var errorBehaviorTransition3 = errorModelSubclause.getTransitions().get(2);
		Assert.assertEquals("trans3", errorBehaviorTransition3.getName());
		var emv2PathElement18 = ((ConditionElement) errorBehaviorTransition3.getCondition())
				.getQualifiedErrorPropagationReference().getEmv2Target();
		Assert.assertEquals("evt3", emv2PathElement18.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement18, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		Assert.assertNull(emv2PathElement18.getPath());
		var errorBehaviorTransition4 = errorModelSubclause.getTransitions().get(3);
		Assert.assertEquals("trans4", errorBehaviorTransition4.getName());
		var emv2PathElement19 = ((ConditionElement) errorBehaviorTransition4.getCondition())
				.getQualifiedErrorPropagationReference().getEmv2Target();
		Assert.assertEquals("port1",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement19.getNamedElement())));
		this.assertHelper.assertScope(emv2PathElement19, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		Assert.assertNull(emv2PathElement19.getPath());
		var errorBehaviorTransition5 = errorModelSubclause.getTransitions().get(4);
		Assert.assertEquals("trans5", errorBehaviorTransition5.getName());
		var emv2PathElement20 = ((ConditionElement) errorBehaviorTransition5.getCondition())
				.getQualifiedErrorPropagationReference().getEmv2Target();
		Assert.assertEquals("port2",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement20.getNamedElement())));
		this.assertHelper.assertScope(emv2PathElement20, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		Assert.assertNull(emv2PathElement20.getPath());
		var errorBehaviorTransition6 = errorModelSubclause.getTransitions().get(5);
		Assert.assertEquals("trans6", errorBehaviorTransition6.getName());
		var emv2PathElement21 = ((ConditionElement) errorBehaviorTransition6.getCondition())
				.getQualifiedErrorPropagationReference().getEmv2Target();
		Assert.assertEquals("fg1", emv2PathElement21.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement21, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		var emv2PathElement11 = emv2PathElement21.getPath();
		Assert.assertEquals("fg2", emv2PathElement11.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement11, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("fg2"));
		var emv2PathElement7 = emv2PathElement11.getPath();
		Assert.assertEquals("fg3", emv2PathElement7.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement7, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("fg3"));
		var emv2PathElement4 = emv2PathElement7.getPath();
		Assert.assertEquals("fg1.fg2.fg3.port3",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement4.getNamedElement())));
		this.assertHelper.assertScope(emv2PathElement4, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("port3", "port4"));
		Assert.assertNull(emv2PathElement4.getPath());
		var errorBehaviorTransition7 = errorModelSubclause.getTransitions().get(6);
		Assert.assertEquals("trans7", errorBehaviorTransition7.getName());
		var emv2PathElement22 = ((ConditionElement) errorBehaviorTransition7.getCondition())
				.getQualifiedErrorPropagationReference().getEmv2Target();
		Assert.assertEquals("fg1", emv2PathElement22.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement22, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		var emv2PathElement12 = emv2PathElement22.getPath();
		Assert.assertEquals("fg2", emv2PathElement12.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement12, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("fg2"));
		var emv2PathElement8 = emv2PathElement12.getPath();
		Assert.assertEquals("fg3", emv2PathElement8.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement8, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("fg3"));
		var emv2PathElement5 = emv2PathElement8.getPath();
		Assert.assertEquals("fg1.fg2.fg3.port4",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement5.getNamedElement())));
		this.assertHelper.assertScope(emv2PathElement5, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("port3", "port4"));
		Assert.assertNull(emv2PathElement5.getPath());
		var errorBehaviorTransition8 = errorModelSubclause.getTransitions().get(7);
		Assert.assertEquals("trans8", errorBehaviorTransition8.getName());
		var emv2PathElement23 = ((ConditionElement) errorBehaviorTransition8.getCondition())
				.getQualifiedErrorPropagationReference().getEmv2Target();
		Assert.assertEquals("asub1", emv2PathElement23.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement23, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		var emv2PathElement13 = emv2PathElement23.getPath();
		Assert.assertEquals("port5",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement13.getNamedElement())));
		this.assertHelper.assertScope(emv2PathElement13, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("asub2", "fg4", "port5"));
		Assert.assertNull(emv2PathElement13.getPath());
		var errorBehaviorTransition9 = errorModelSubclause.getTransitions().get(8);
		Assert.assertEquals("trans9", errorBehaviorTransition9.getName());
		var emv2PathElement24 = ((ConditionElement) errorBehaviorTransition9.getCondition())
				.getQualifiedErrorPropagationReference().getEmv2Target();
		Assert.assertEquals("asub1", emv2PathElement24.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement24, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		var emv2PathElement14 = emv2PathElement24.getPath();
		Assert.assertEquals("fg4", emv2PathElement14.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement14, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("asub2", "fg4", "port5"));
		var emv2PathElement9 = emv2PathElement14.getPath();
		Assert.assertEquals("fg4.port3",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement9.getNamedElement())));
		this.assertHelper.assertScope(emv2PathElement9, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("port3"));
		Assert.assertNull(emv2PathElement9.getPath());
		var errorBehaviorTransition10 = errorModelSubclause.getTransitions().get(9);
		Assert.assertEquals("trans10", errorBehaviorTransition10.getName());
		var emv2PathElement25 = ((ConditionElement) errorBehaviorTransition10.getCondition())
				.getQualifiedErrorPropagationReference().getEmv2Target();
		Assert.assertEquals("asub1", emv2PathElement25.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement25, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		var emv2PathElement15 = emv2PathElement25.getPath();
		Assert.assertEquals("asub2", emv2PathElement15.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement15, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("asub2", "fg4", "port5"));
		var emv2PathElement10 = emv2PathElement15.getPath();
		Assert.assertEquals("asub3", emv2PathElement10.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement10, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("asub3"));
		var emv2PathElement6 = emv2PathElement10.getPath();
		Assert.assertEquals("fg5", emv2PathElement6.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement6, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("fg5"));
		var emv2PathElement3 = emv2PathElement6.getPath();
		Assert.assertEquals("fg2", emv2PathElement3.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement3, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("fg2"));
		var emv2PathElement2 = emv2PathElement3.getPath();
		Assert.assertEquals("fg3", emv2PathElement2.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement2, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("fg3"));
		var emv2PathElement = emv2PathElement2.getPath();
		Assert.assertEquals("fg5.fg2.fg3.port3",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement.getNamedElement())));
		this.assertHelper.assertScope(emv2PathElement, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("port3"));
		Assert.assertNull(emv2PathElement.getPath());

	}

	/**
	 * Tests scope_EMV2PathElement_namedElement for grammar path: ErrorModelSubclause -> OutgoingPropagationCondition ->
	 * 		ConditionExpression -> ... -> QualifiedErrorEventOrPropagation -> EMV2ErrorPropagationPath
	 */
	@Test
	public void testOutgoingPropagationCondition() throws Exception {
		var aadlText = """
				package OutgoingPropagationCondition
				public
				\tabstract a1
				\t\tfeatures
				\t\t\tport1: in event port;
				\t\t\tport2: in event port;
				\t\t\tfg1: feature group fgt1;
				\t\tannex EMV2 {**
				\t\t\tuse types OutgoingPropagationCondition;
				\t\t\tuse behavior OutgoingPropagationCondition::bvr1;
				\t\t\t
				\t\t\terror propagations
				\t\t\t\tport1: in propagation {t1};
				\t\t\t\tfg1.fg2.fg3.port3: in propagation {t1};
				\t\t\tend propagations;
				\t\t\t
				\t\t\tcomponent error behavior
				\t\t\tevents
				\t\t\t\tevt1: error event;
				\t\t\tend component;
				\t\t**};
				\tend a1;
				\t
				\tabstract implementation a1.i
				\t\tsubcomponents
				\t\t\tasub1: abstract a2.i;
				\t\tannex EMV2 {**
				\t\t\terror propagations
				\t\t\t\tport2: in propagation {t1};
				\t\t\t\tfg1.fg2.fg3.port4: in propagation {t1};
				\t\t\tend propagations;
				\t\t\t
				\t\t\tcomponent error behavior
				\t\t\tevents
				\t\t\t\tevt2: error event;
				\t\t\tpropagations
				\t\t\t\tcondition1: all -[ evt1 ]-> all;
				\t\t\t\tcondition2: all -[ evt2 ]-> all;
				\t\t\t\tcondition3: all -[ evt3 ]-> all;
				\t\t\t\tcondition4: all -[ port1 ]-> all;
				\t\t\t\tcondition5: all -[ port2 ]-> all;
				\t\t\t\tcondition6: all -[ fg1.fg2.fg3.port3 ]-> all;
				\t\t\t\tcondition7: all -[ fg1.fg2.fg3.port4 ]-> all;
				\t\t\t\tcondition8: all -[ asub1.port5 ]-> all;
				\t\t\t\tcondition9: all -[ asub1.fg4.port3 ]-> all;
				\t\t\t\tcondition10: all -[ asub1.asub2.asub3.fg5.fg2.fg3.port3 ]-> all;
				\t\t\tend component;
				\t\t**};
				\tend a1.i;
				\t
				\tfeature group fgt1
				\t\tfeatures
				\t\t\tfg2: feature group fgt2;
				\tend fgt1;
				\t
				\tfeature group fgt2
				\t\tfeatures
				\t\t\tfg3: feature group fgt3;
				\tend fgt2;
				\t
				\tfeature group fgt3
				\t\tfeatures
				\t\t\tport3: in out event port;
				\t\t\tport4: in event port;
				\tend fgt3;
				\t
				\tabstract a2
				\t\tfeatures
				\t\t\tport5: out event port;
				\t\t\tfg4: feature group fgt3;
				\tend a2;
				\t
				\tabstract implementation a2.i
				\t\tsubcomponents
				\t\t\tasub2: abstract a3.i;
				\t\tannex EMV2 {**
				\t\t\tuse types OutgoingPropagationCondition;
				\t\t\t
				\t\t\terror propagations
				\t\t\t\tport5: out propagation {t1};
				\t\t\t\tfg4.port3: out propagation {t1};
				\t\t\tend propagations;
				\t\t**};
				\tend a2.i;
				\t
				\tabstract a3
				\tend a3;
				\t
				\tabstract implementation a3.i
				\t\tsubcomponents
				\t\t\tasub3: abstract a4.i;
				\tend a3.i;
				\t
				\tabstract a4
				\t\tfeatures
				\t\t\tfg5: feature group fgt1;
				\tend a4;
				\t
				\tabstract implementation a4.i
				\t\tannex EMV2 {**
				\t\t\tuse types OutgoingPropagationCondition;
				\t\t\t
				\t\t\terror propagations
				\t\t\t\tfg5.fg2.fg3.port3: in propagation {t1};
				\t\t\tend propagations;
				\t\t**};
				\tend a4.i;
				\t
				\tannex EMV2 {**
				\t\terror types
				\t\t\tt1: type;
				\t\tend types;
				\t\t
				\t\terror behavior bvr1
				\t\tevents
				\t\t\tevt3: error event;
				\t\tend behavior;
				\t**};
				end OutgoingPropagationCondition;
				""";
		final AadlPackage pkg = this.testHelper.parseString(aadlText);
		Assert.assertEquals("OutgoingPropagationCondition", pkg.getName());
		var classifier = pkg.getPublicSection().getOwnedClassifiers().get(1);
		Assert.assertEquals("a1.i", classifier.getName());
		var errorModelSubclause = ((ErrorModelSubclause) ((DefaultAnnexSubclause) (classifier.getOwnedAnnexSubclauses())
				.getFirst()).getParsedAnnexSubclause());
		final List<String> firstElementScope = List.of("asub1", "evt1", "evt2", "evt3", "port1", "port2", "fg1");
		var outgoingPropagationCondition = errorModelSubclause.getOutgoingPropagationConditions().get(0);
		Assert.assertEquals("condition1", outgoingPropagationCondition.getName());
		var emv2PathElement16 = ((ConditionElement) outgoingPropagationCondition.getCondition())
				.getQualifiedErrorPropagationReference().getEmv2Target();
		Assert.assertEquals("evt1", emv2PathElement16.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement16, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		Assert.assertNull(emv2PathElement16.getPath());
		var outgoingPropagationCondition2 = errorModelSubclause.getOutgoingPropagationConditions().get(1);
		Assert.assertEquals("condition2", outgoingPropagationCondition2.getName());
		var emv2PathElement17 = ((ConditionElement) outgoingPropagationCondition2.getCondition())
				.getQualifiedErrorPropagationReference().getEmv2Target();
		Assert.assertEquals("evt2", emv2PathElement17.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement17, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		Assert.assertNull(emv2PathElement17.getPath());
		var outgoingPropagationCondition3 = errorModelSubclause.getOutgoingPropagationConditions().get(2);
		Assert.assertEquals("condition3", outgoingPropagationCondition3.getName());
		var emv2PathElement18 = ((ConditionElement) outgoingPropagationCondition3.getCondition())
				.getQualifiedErrorPropagationReference().getEmv2Target();
		Assert.assertEquals("evt3", emv2PathElement18.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement18, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		Assert.assertNull(emv2PathElement18.getPath());
		var outgoingPropagationCondition4 = errorModelSubclause.getOutgoingPropagationConditions().get(3);
		Assert.assertEquals("condition4", outgoingPropagationCondition4.getName());
		var emv2PathElement19 = ((ConditionElement) outgoingPropagationCondition4.getCondition())
				.getQualifiedErrorPropagationReference().getEmv2Target();
		Assert.assertEquals("port1",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement19.getNamedElement())));
		this.assertHelper.assertScope(emv2PathElement19, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		Assert.assertNull(emv2PathElement19.getPath());
		var outgoingPropagationCondition5 = errorModelSubclause.getOutgoingPropagationConditions().get(4);
		Assert.assertEquals("condition5", outgoingPropagationCondition5.getName());
		var emv2PathElement20 = ((ConditionElement) outgoingPropagationCondition5.getCondition())
				.getQualifiedErrorPropagationReference().getEmv2Target();
		Assert.assertEquals("port2",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement20.getNamedElement())));
		this.assertHelper.assertScope(emv2PathElement20, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		Assert.assertNull(emv2PathElement20.getPath());
		var outgoingPropagationCondition6 = errorModelSubclause.getOutgoingPropagationConditions().get(5);
		Assert.assertEquals("condition6", outgoingPropagationCondition6.getName());
		var emv2PathElement21 = ((ConditionElement) outgoingPropagationCondition6.getCondition())
				.getQualifiedErrorPropagationReference().getEmv2Target();
		Assert.assertEquals("fg1", emv2PathElement21.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement21, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		var emv2PathElement11 = emv2PathElement21.getPath();
		Assert.assertEquals("fg2", emv2PathElement11.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement11, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("fg2"));
		var emv2PathElement7 = emv2PathElement11.getPath();
		Assert.assertEquals("fg3", emv2PathElement7.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement7, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("fg3"));
		var emv2PathElement4 = emv2PathElement7.getPath();
		Assert.assertEquals("fg1.fg2.fg3.port3",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement4.getNamedElement())));
		this.assertHelper.assertScope(emv2PathElement4, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("port3", "port4"));
		Assert.assertNull(emv2PathElement4.getPath());
		var outgoingPropagationCondition7 = errorModelSubclause.getOutgoingPropagationConditions().get(6);
		Assert.assertEquals("condition7", outgoingPropagationCondition7.getName());
		var emv2PathElement22 = ((ConditionElement) outgoingPropagationCondition7.getCondition())
				.getQualifiedErrorPropagationReference().getEmv2Target();
		Assert.assertEquals("fg1", emv2PathElement22.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement22, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		var emv2PathElement12 = emv2PathElement22.getPath();
		Assert.assertEquals("fg2", emv2PathElement12.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement12, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("fg2"));
		var emv2PathElement8 = emv2PathElement12.getPath();
		Assert.assertEquals("fg3", emv2PathElement8.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement8, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("fg3"));
		var emv2PathElement5 = emv2PathElement8.getPath();
		Assert.assertEquals("fg1.fg2.fg3.port4",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement5.getNamedElement())));
		this.assertHelper.assertScope(emv2PathElement5, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("port3", "port4"));
		Assert.assertNull(emv2PathElement5.getPath());
		var outgoingPropagationCondition8 = errorModelSubclause.getOutgoingPropagationConditions().get(7);
		Assert.assertEquals("condition8", outgoingPropagationCondition8.getName());
		var emv2PathElement23 = ((ConditionElement) outgoingPropagationCondition8.getCondition())
				.getQualifiedErrorPropagationReference().getEmv2Target();
		Assert.assertEquals("asub1", emv2PathElement23.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement23, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		var emv2PathElement13 = emv2PathElement23.getPath();
		Assert.assertEquals("port5",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement13.getNamedElement())));
		this.assertHelper.assertScope(emv2PathElement13, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("asub2", "fg4", "port5"));
		Assert.assertNull(emv2PathElement13.getPath());
		var outgoingPropagationCondition9 = errorModelSubclause.getOutgoingPropagationConditions().get(8);
		Assert.assertEquals("condition9", outgoingPropagationCondition9.getName());
		var emv2PathElement24 = ((ConditionElement) outgoingPropagationCondition9.getCondition())
				.getQualifiedErrorPropagationReference().getEmv2Target();
		Assert.assertEquals("asub1", emv2PathElement24.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement24, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		var emv2PathElement14 = emv2PathElement24.getPath();
		Assert.assertEquals("fg4", emv2PathElement14.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement14, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("asub2", "fg4", "port5"));
		var emv2PathElement9 = emv2PathElement14.getPath();
		Assert.assertEquals("fg4.port3",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement9.getNamedElement())));
		this.assertHelper.assertScope(emv2PathElement9, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("port3"));
		Assert.assertNull(emv2PathElement9.getPath());
		var outgoingPropagationCondition10 = errorModelSubclause.getOutgoingPropagationConditions().get(9);
		Assert.assertEquals("condition10", outgoingPropagationCondition10.getName());
		var emv2PathElement25 = ((ConditionElement) outgoingPropagationCondition10.getCondition())
				.getQualifiedErrorPropagationReference().getEmv2Target();
		Assert.assertEquals("asub1", emv2PathElement25.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement25, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		var emv2PathElement15 = emv2PathElement25.getPath();
		Assert.assertEquals("asub2", emv2PathElement15.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement15, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("asub2", "fg4", "port5"));
		var emv2PathElement10 = emv2PathElement15.getPath();
		Assert.assertEquals("asub3", emv2PathElement10.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement10, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("asub3"));
		var emv2PathElement6 = emv2PathElement10.getPath();
		Assert.assertEquals("fg5", emv2PathElement6.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement6, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("fg5"));
		var emv2PathElement3 = emv2PathElement6.getPath();
		Assert.assertEquals("fg2", emv2PathElement3.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement3, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("fg2"));
		var emv2PathElement2 = emv2PathElement3.getPath();
		Assert.assertEquals("fg3", emv2PathElement2.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement2, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("fg3"));
		var emv2PathElement = emv2PathElement2.getPath();
		Assert.assertEquals("fg5.fg2.fg3.port3",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement.getNamedElement())));
		this.assertHelper.assertScope(emv2PathElement, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("port3"));
		Assert.assertNull(emv2PathElement.getPath());

	}

	/**
	 * Tests scope_EMV2PathElement_namedElement for grammar path: ErrorModelSubclause -> ErrorDetection ->
	 * 		ConditionExpression -> ... -> QualifiedErrorEventOrPropagation -> EMV2ErrorPropagationPath
	 */
	@Test
	public void testErrorDetection() throws Exception {
		var aadlText = """
				package ErrorDetection
				public
				\tabstract a1
				\t\tfeatures
				\t\t\tport1: in event port;
				\t\t\tport2: in event port;
				\t\t\tfg1: feature group fgt1;
				\t\tannex EMV2 {**
				\t\t\tuse types ErrorDetection;
				\t\t\tuse behavior ErrorDetection::bvr1;
				\t\t\t
				\t\t\terror propagations
				\t\t\t\tport1: in propagation {t1};
				\t\t\t\tfg1.fg2.fg3.port3: in propagation {t1};
				\t\t\tend propagations;
				\t\t\t
				\t\t\tcomponent error behavior
				\t\t\tevents
				\t\t\t\tevt1: error event;
				\t\t\tend component;
				\t\t**};
				\tend a1;
				\t
				\tabstract implementation a1.i
				\t\tsubcomponents
				\t\t\tasub1: abstract a2.i;
				\t\tannex EMV2 {**
				\t\t\terror propagations
				\t\t\t\tport2: in propagation {t1};
				\t\t\t\tfg1.fg2.fg3.port4: in propagation {t1};
				\t\t\tend propagations;
				\t\t\t
				\t\t\tcomponent error behavior
				\t\t\tevents
				\t\t\t\tevt2: error event;
				\t\t\tdetections
				\t\t\t\tdetection1: all -[ evt1 ]-> port1!;
				\t\t\t\tdetection2: all -[ evt2 ]-> port1!;
				\t\t\t\tdetection3: all -[ evt3 ]-> port1!;
				\t\t\t\tdetection4: all -[ port1 ]-> port1!;
				\t\t\t\tdetection5: all -[ port2 ]-> port1!;
				\t\t\t\tdetection6: all -[ fg1.fg2.fg3.port3 ]-> port1!;
				\t\t\t\tdetection7: all -[ fg1.fg2.fg3.port4 ]-> port1!;
				\t\t\t\tdetection8: all -[ asub1.port5 ]-> port1!;
				\t\t\t\tdetection9: all -[ asub1.fg4.port3 ]-> port1!;
				\t\t\t\tdetection10: all -[ asub1.asub2.asub3.fg5.fg2.fg3.port3 ]-> port1!;
				\t\t\tend component;
				\t\t**};
				\tend a1.i;
				\t
				\tfeature group fgt1
				\t\tfeatures
				\t\t\tfg2: feature group fgt2;
				\tend fgt1;
				\t
				\tfeature group fgt2
				\t\tfeatures
				\t\t\tfg3: feature group fgt3;
				\tend fgt2;
				\t
				\tfeature group fgt3
				\t\tfeatures
				\t\t\tport3: in out event port;
				\t\t\tport4: in event port;
				\tend fgt3;
				\t
				\tabstract a2
				\t\tfeatures
				\t\t\tport5: out event port;
				\t\t\tfg4: feature group fgt3;
				\tend a2;
				\t
				\tabstract implementation a2.i
				\t\tsubcomponents
				\t\t\tasub2: abstract a3.i;
				\t\tannex EMV2 {**
				\t\t\tuse types ErrorDetection;
				\t\t\t
				\t\t\terror propagations
				\t\t\t\tport5: out propagation {t1};
				\t\t\t\tfg4.port3: out propagation {t1};
				\t\t\tend propagations;
				\t\t**};
				\tend a2.i;
				\t
				\tabstract a3
				\tend a3;
				\t
				\tabstract implementation a3.i
				\t\tsubcomponents
				\t\t\tasub3: abstract a4.i;
				\tend a3.i;
				\t
				\tabstract a4
				\t\tfeatures
				\t\t\tfg5: feature group fgt1;
				\tend a4;
				\t
				\tabstract implementation a4.i
				\t\tannex EMV2 {**
				\t\t\tuse types ErrorDetection;
				\t\t\t
				\t\t\terror propagations
				\t\t\t\tfg5.fg2.fg3.port3: in propagation {t1};
				\t\t\tend propagations;
				\t\t**};
				\tend a4.i;
				\t
				\tannex EMV2 {**
				\t\terror types
				\t\t\tt1: type;
				\t\tend types;
				\t\t
				\t\terror behavior bvr1
				\t\tevents
				\t\t\tevt3: error event;
				\t\tend behavior;
				\t**};
				end ErrorDetection;
				""";
		final AadlPackage pkg = this.testHelper.parseString(aadlText);
		Assert.assertEquals("ErrorDetection", pkg.getName());
		var classifier = pkg.getPublicSection().getOwnedClassifiers().get(1);
		Assert.assertEquals("a1.i", classifier.getName());
		var errorModelSubclause = ((ErrorModelSubclause) ((DefaultAnnexSubclause) (classifier.getOwnedAnnexSubclauses())
				.getFirst()).getParsedAnnexSubclause());
		final List<String> firstElementScope = List.of("evt1", "evt2", "evt3", "port1", "port2", "fg1", "asub1");
		var errorDetection = errorModelSubclause.getErrorDetections().get(0);
		Assert.assertEquals("detection1", errorDetection.getName());
		var emv2PathElement16 = ((ConditionElement) errorDetection.getCondition())
				.getQualifiedErrorPropagationReference().getEmv2Target();
		Assert.assertEquals("evt1", emv2PathElement16.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement16, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		Assert.assertNull(emv2PathElement16.getPath());
		var errorDetection2 = errorModelSubclause.getErrorDetections().get(1);
		Assert.assertEquals("detection2", errorDetection2.getName());
		var emv2PathElement17 = ((ConditionElement) errorDetection2.getCondition())
				.getQualifiedErrorPropagationReference().getEmv2Target();
		Assert.assertEquals("evt2", emv2PathElement17.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement17, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		Assert.assertNull(emv2PathElement17.getPath());
		var errorDetection3 = errorModelSubclause.getErrorDetections().get(2);
		Assert.assertEquals("detection3", errorDetection3.getName());
		var emv2PathElement18 = ((ConditionElement) errorDetection3.getCondition())
				.getQualifiedErrorPropagationReference().getEmv2Target();
		Assert.assertEquals("evt3", emv2PathElement18.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement18, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		Assert.assertNull(emv2PathElement18.getPath());
		var errorDetection4 = errorModelSubclause.getErrorDetections().get(3);
		Assert.assertEquals("detection4", errorDetection4.getName());
		var emv2PathElement19 = ((ConditionElement) errorDetection4.getCondition())
				.getQualifiedErrorPropagationReference().getEmv2Target();
		Assert.assertEquals("port1",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement19.getNamedElement())));
		this.assertHelper.assertScope(emv2PathElement19, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		Assert.assertNull(emv2PathElement19.getPath());
		var errorDetection5 = errorModelSubclause.getErrorDetections().get(4);
		Assert.assertEquals("detection5", errorDetection5.getName());
		var emv2PathElement20 = ((ConditionElement) errorDetection5.getCondition())
				.getQualifiedErrorPropagationReference().getEmv2Target();
		Assert.assertEquals("port2",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement20.getNamedElement())));
		this.assertHelper.assertScope(emv2PathElement20, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		Assert.assertNull(emv2PathElement20.getPath());
		var errorDetection6 = errorModelSubclause.getErrorDetections().get(5);
		Assert.assertEquals("detection6", errorDetection6.getName());
		var emv2PathElement21 = ((ConditionElement) errorDetection6.getCondition())
				.getQualifiedErrorPropagationReference().getEmv2Target();
		Assert.assertEquals("fg1", emv2PathElement21.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement21, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		var emv2PathElement11 = emv2PathElement21.getPath();
		Assert.assertEquals("fg2", emv2PathElement11.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement11, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("fg2"));
		var emv2PathElement7 = emv2PathElement11.getPath();
		Assert.assertEquals("fg3", emv2PathElement7.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement7, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("fg3"));
		var emv2PathElement4 = emv2PathElement7.getPath();
		Assert.assertEquals("fg1.fg2.fg3.port3",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement4.getNamedElement())));
		this.assertHelper.assertScope(emv2PathElement4, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("port3", "port4"));
		Assert.assertNull(emv2PathElement4.getPath());
		var errorDetection7 = errorModelSubclause.getErrorDetections().get(6);
		Assert.assertEquals("detection7", errorDetection7.getName());
		var emv2PathElement22 = ((ConditionElement) errorDetection7.getCondition())
				.getQualifiedErrorPropagationReference().getEmv2Target();
		Assert.assertEquals("fg1", emv2PathElement22.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement22, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		var emv2PathElement12 = emv2PathElement22.getPath();
		Assert.assertEquals("fg2", emv2PathElement12.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement12, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("fg2"));
		var emv2PathElement8 = emv2PathElement12.getPath();
		Assert.assertEquals("fg3", emv2PathElement8.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement8, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("fg3"));
		var emv2PathElement5 = emv2PathElement8.getPath();
		Assert.assertEquals("fg1.fg2.fg3.port4",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement5.getNamedElement())));
		this.assertHelper.assertScope(emv2PathElement5, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("port3", "port4"));
		var errorDetection8 = errorModelSubclause.getErrorDetections().get(7);
		Assert.assertEquals("detection8", errorDetection8.getName());
		var emv2PathElement23 = ((ConditionElement) errorDetection8.getCondition())
				.getQualifiedErrorPropagationReference().getEmv2Target();
		Assert.assertEquals("asub1", emv2PathElement23.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement23, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		var emv2PathElement13 = emv2PathElement23.getPath();
		Assert.assertEquals("port5",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement13.getNamedElement())));
		this.assertHelper.assertScope(emv2PathElement13, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("asub2", "fg4", "port5"));
		Assert.assertNull(emv2PathElement13.getPath());
		var errorDetection9 = errorModelSubclause.getErrorDetections().get(8);
		Assert.assertEquals("detection9", errorDetection9.getName());
		var emv2PathElement24 = ((ConditionElement) errorDetection9.getCondition())
				.getQualifiedErrorPropagationReference().getEmv2Target();
		Assert.assertEquals("asub1", emv2PathElement24.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement24, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		var emv2PathElement14 = emv2PathElement24.getPath();
		Assert.assertEquals("fg4", emv2PathElement14.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement14, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("asub2", "fg4", "port5"));
		var emv2PathElement9 = emv2PathElement14.getPath();
		Assert.assertEquals("fg4.port3",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement9.getNamedElement())));
		this.assertHelper.assertScope(emv2PathElement9, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("port3"));
		Assert.assertNull(emv2PathElement9.getPath());
		var errorDetection10 = errorModelSubclause.getErrorDetections().get(9);
		Assert.assertEquals("detection10", errorDetection10.getName());
		var emv2PathElement25 = ((ConditionElement) errorDetection10.getCondition())
				.getQualifiedErrorPropagationReference().getEmv2Target();
		Assert.assertEquals("asub1", emv2PathElement25.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement25, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		var emv2PathElement15 = emv2PathElement25.getPath();
		Assert.assertEquals("asub2", emv2PathElement15.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement15, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("asub2", "fg4", "port5"));
		var emv2PathElement10 = emv2PathElement15.getPath();
		Assert.assertEquals("asub3", emv2PathElement10.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement10, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("asub3"));
		var emv2PathElement6 = emv2PathElement10.getPath();
		Assert.assertEquals("fg5", emv2PathElement6.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement6, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("fg5"));
		var emv2PathElement3 = emv2PathElement6.getPath();
		Assert.assertEquals("fg2", emv2PathElement3.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement3, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("fg2"));
		var emv2PathElement2 = emv2PathElement3.getPath();
		Assert.assertEquals("fg3", emv2PathElement2.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement2, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("fg3"));
		var emv2PathElement = emv2PathElement2.getPath();
		Assert.assertEquals("fg5.fg2.fg3.port3",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement.getNamedElement())));
		this.assertHelper.assertScope(emv2PathElement, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("port3"));
		Assert.assertNull(emv2PathElement.getPath());

	}

	/**
	 * Tests scope_EMV2PathElement_namedElement for grammar path: ErrorModelSubclause -> CompositeState ->
	 * 		SConditionExpression -> ... -> QualifiedErrorPropagation -> EMV2ErrorPropagationPath
	 */
	@Test
	public void testCompositeState() throws Exception {
		var aadlText = """
				package CompositeState
				public
				\tabstract a1
				\t\tfeatures
				\t\t\tport1: in event port;
				\t\t\tport2: in event port;
				\t\t\tfg1: feature group fgt1;
				\t\tannex EMV2 {**
				\t\t\tuse types CompositeState;
				\t\t\t
				\t\t\terror propagations
				\t\t\t\tport1: in propagation {t1};
				\t\t\t\tfg1.fg2.fg3.port3: in propagation {t1};
				\t\t\tend propagations;
				\t\t**};
				\tend a1;
				\t
				\tabstract implementation a1.i
				\t\tannex EMV2 {**
				\t\t\tuse behavior CompositeState::bvr1;
				\t\t\t
				\t\t\terror propagations
				\t\t\t\tport2: in propagation {t1};
				\t\t\t\tfg1.fg2.fg3.port4: in propagation {t1};
				\t\t\tend propagations;
				\t\t\t
				\t\t\tcomposite error behavior
				\t\t\tstates
				\t\t\t\tstate1: [ in port1 ]-> state2;
				\t\t\t\tstate2: [ in port2 ]-> state2;
				\t\t\t\tstate3: [ in fg1.fg2.fg3.port3 ]-> state2;
				\t\t\t\tstate4: [ in fg1.fg2.fg3.port4 ]-> state2;
				\t\t\tend composite;
				\t\t**};
				\tend a1.i;
				\t
				\tfeature group fgt1
				\t\tfeatures
				\t\t\tfg2: feature group fgt2;
				\tend fgt1;
				\t
				\tfeature group fgt2
				\t\tfeatures
				\t\t\tfg3: feature group fgt3;
				\tend fgt2;
				\t
				\tfeature group fgt3
				\t\tfeatures
				\t\t\tport3: in event port;
				\t\t\tport4: in event port;
				\tend fgt3;
				\t
				\tannex EMV2 {**
				\t\terror types
				\t\t\tt1: type;
				\t\tend types;
				\t\t
				\t\terror behavior bvr1
				\t\tstates
				\t\t\tstate2: state;
				\t\tend behavior;
				\t**};
				end CompositeState;
				""";
		final AadlPackage pkg = this.testHelper.parseString(aadlText);
		Assert.assertEquals("CompositeState", pkg.getName());
		var classifier = pkg.getPublicSection().getOwnedClassifiers().get(1);
		Assert.assertEquals("a1.i", classifier.getName());
		var errorModelSubclause = ((ErrorModelSubclause) ((DefaultAnnexSubclause) (classifier.getOwnedAnnexSubclauses())
				.getFirst()).getParsedAnnexSubclause());
		final List<String> firstElementScope = List.of("port1", "port2", "fg1");
		var compositeState = errorModelSubclause.getStates().get(0);
		Assert.assertEquals("state1", compositeState.getName());
		var emv2PathElement7 = ((SConditionElement) compositeState.getCondition())
				.getQualifiedErrorPropagationReference().getEmv2Target();
		Assert.assertEquals("port1",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement7.getNamedElement())));
		this.assertHelper.assertScope(emv2PathElement7, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		Assert.assertNull(emv2PathElement7.getPath());
		var compositeState2 = errorModelSubclause.getStates().get(1);
		Assert.assertEquals("state2", compositeState2.getName());
		var emv2PathElement8 = ((SConditionElement) compositeState2.getCondition())
				.getQualifiedErrorPropagationReference().getEmv2Target();
		Assert.assertEquals("port2",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement8.getNamedElement())));
		this.assertHelper.assertScope(emv2PathElement8, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		Assert.assertNull(emv2PathElement8.getPath());
		var compositeState3 = errorModelSubclause.getStates().get(2);
		Assert.assertEquals("state3", compositeState3.getName());
		var emv2PathElement9 = ((SConditionElement) compositeState3.getCondition())
				.getQualifiedErrorPropagationReference().getEmv2Target();
		Assert.assertEquals("fg1", emv2PathElement9.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement9, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		var emv2PathElement5 = emv2PathElement9.getPath();
		Assert.assertEquals("fg2", emv2PathElement5.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement5, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("fg2"));
		var emv2PathElement3 = emv2PathElement5.getPath();
		Assert.assertEquals("fg3", emv2PathElement3.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement3, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("fg3"));
		var emv2PathElement = emv2PathElement3.getPath();
		Assert.assertEquals("fg1.fg2.fg3.port3",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement.getNamedElement())));
		this.assertHelper.assertScope(emv2PathElement, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("port3", "port4"));
		Assert.assertNull(emv2PathElement.getPath());
		var compositeState4 = errorModelSubclause.getStates().get(3);
		Assert.assertEquals("state4", compositeState4.getName());
		var emv2PathElement10 = ((SConditionElement) compositeState4.getCondition())
				.getQualifiedErrorPropagationReference().getEmv2Target();
		Assert.assertEquals("fg1", emv2PathElement10.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement10, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		var emv2PathElement6 = emv2PathElement10.getPath();
		Assert.assertEquals("fg2", emv2PathElement6.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement6, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("fg2"));
		var emv2PathElement4 = emv2PathElement6.getPath();
		Assert.assertEquals("fg3", emv2PathElement4.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement4, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("fg3"));
		var emv2PathElement2 = emv2PathElement4.getPath();
		Assert.assertEquals("fg1.fg2.fg3.port4",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement2.getNamedElement())));
		this.assertHelper.assertScope(emv2PathElement2, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("port3", "port4"));
		Assert.assertNull(emv2PathElement2.getPath());

	}

	/**
	 * Tests scope_EMV2PathElement_namedElement for grammar path: ErrorModelLibrary -> BasicEMV2PropertyAssociation ->
	 * 		BasicEMV2Path -> EMV2PathElementOrKind
	 */
	@Test
	public void testBasicEMV2PropertyAssociationInErrorModelLibrary() throws Exception {
		var aadlText = """
				package lib1
				public
				\tannex EMV2 {**
				\t\terror types
				\t\t\tt2: type;
				\t\t\tts2: type set {t2};
				\t\tend types;
				\t**};
				end lib1;
				""";
		var aadlText1 = """
				package BasicEMV2PropertyAssociation_in_ErrorModelLibrary
				public
				\tannex EMV2 {**
				\t\terror types extends lib1 with
				\t\t\tt1: type;
				\t\t\tts1: type set {t1};
				\t\tproperties
				\t\t\tEMV2::ExposurePeriod => 1.1 applies to t1;
				\t\t\tEMV2::ExposurePeriod => 2.2 applies to ts1;
				\t\t\tEMV2::ExposurePeriod => 3.3 applies to t2;
				\t\t\tEMV2::ExposurePeriod => 4.4 applies to ts2;
				\t\tend types;
				\t**};
				end BasicEMV2PropertyAssociation_in_ErrorModelLibrary;
				""";
		final AadlPackage pkg = this.testHelper.parseString(aadlText1, aadlText);
		Assert.assertEquals("BasicEMV2PropertyAssociation_in_ErrorModelLibrary", pkg.getName());
		var errorModelLibrary = ((ErrorModelLibrary) ((DefaultAnnexLibrary) (pkg.getPublicSection()
				.getOwnedAnnexLibraries()).getFirst()).getParsedAnnexLibrary());
		final List<String> scope = List.of("t1", "ts1", "t2", "ts2");
		var emv2PropertyAssociation = errorModelLibrary.getProperties().get(0);
		PropertyExpression ownedValue = (emv2PropertyAssociation.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(1.1, ((RealLiteral) ownedValue).getValue(), 0);
		var emv2PathElement = (emv2PropertyAssociation.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("t1", emv2PathElement.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				scope);
		Assert.assertNull(emv2PathElement.getPath());
		var emv2PropertyAssociation2 = errorModelLibrary.getProperties().get(1);
		PropertyExpression ownedValue2 = (emv2PropertyAssociation2.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(2.2, ((RealLiteral) ownedValue2).getValue(), 0);
		var emv2PathElement2 = (emv2PropertyAssociation2.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("ts1", emv2PathElement2.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement2, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				scope);
		Assert.assertNull(emv2PathElement2.getPath());
		var emv2PropertyAssociation3 = errorModelLibrary.getProperties().get(2);
		PropertyExpression ownedValue3 = (emv2PropertyAssociation3.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(3.3, ((RealLiteral) ownedValue3).getValue(), 0);
		var emv2PathElement3 = (emv2PropertyAssociation3.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("t2", emv2PathElement3.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement3, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				scope);
		Assert.assertNull(emv2PathElement3.getPath());
		var emv2PropertyAssociation4 = errorModelLibrary.getProperties().get(3);
		PropertyExpression ownedValue4 = (emv2PropertyAssociation4.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(4.4, ((RealLiteral) ownedValue4).getValue(), 0);
		var emv2PathElement4 = (emv2PropertyAssociation4.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("ts2", emv2PathElement4.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement4, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				scope);
		Assert.assertNull(emv2PathElement4.getPath());

	}

	/**
	 * Tests scope_EMV2PathElement_namedElement for grammar path: ErrorModelLibrary -> ErrorBehaviorStateMachine ->
	 * 		BasicEMV2PropertyAssociation -> BasicEMV2Path -> EMV2PathElementOrKind
	 */
	@Test
	public void testBasicEMV2PropertyAssociationInErrorBehaviorStateMachine() throws Exception {
		var aadlText = """
				package BasicEMV2PropertyAssociation_in_ErrorBehaviorStateMachine
				public
				\twith EMV2;
				\t
				\tannex EMV2 {**
				\t\terror behavior bvr1
				\t\tevents
				\t\t\tevt1: error event;
				\t\tstates
				\t\t\tstate1: state;
				\t\ttransitions
				\t\t\ttrans1: all -[ evt1 ]-> same state;
				\t\tproperties
				\t\t\tEMV2::ExposurePeriod => 1.1 applies to evt1;
				\t\t\tEMV2::ExposurePeriod => 2.2 applies to state1;
				\t\t\tEMV2::ExposurePeriod => 3.3 applies to trans1;
				\t\tend behavior;
				\t**};
				end BasicEMV2PropertyAssociation_in_ErrorBehaviorStateMachine;
				""";
		final FluentIssueCollection testResult = this.issues = this.testHelper.testString(aadlText);
		final FluentIssueCollection issueCollection = new FluentIssueCollection(testResult.getResource(),
				new ArrayList<>(), new ArrayList<>());
		var aadlPackage = ((AadlPackage) (testResult.getResource().getContents()).getFirst());
		Assert.assertEquals("BasicEMV2PropertyAssociation_in_ErrorBehaviorStateMachine", aadlPackage.getName());
		var errorBehaviorStateMachine = (((ErrorModelLibrary) ((DefaultAnnexLibrary) (aadlPackage.getPublicSection()
				.getOwnedAnnexLibraries()).getFirst()).getParsedAnnexLibrary()).getBehaviors()).getFirst();
		Assert.assertEquals("bvr1", errorBehaviorStateMachine.getName());
		final List<String> scope = List.of("evt1", "state1", "trans1");
		var emv2PropertyAssociation = errorBehaviorStateMachine.getProperties().get(0);
		PropertyExpression ownedValue = (emv2PropertyAssociation.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(1.1, ((RealLiteral) ownedValue).getValue(), 0);
		var emv2PathElement = (emv2PropertyAssociation.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("evt1", emv2PathElement.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				scope);
		Assert.assertNull(emv2PathElement.getPath());
		var emv2PropertyAssociation2 = errorBehaviorStateMachine.getProperties().get(1);
		PropertyExpression ownedValue2 = (emv2PropertyAssociation2.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(2.2, ((RealLiteral) ownedValue2).getValue(), 0);
		var emv2PathElement2 = (emv2PropertyAssociation2.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("state1", emv2PathElement2.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement2, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				scope);
		Assert.assertNull(emv2PathElement2.getPath());
		var emv2PropertyAssociation3 = errorBehaviorStateMachine.getProperties().get(2);
		AssertHelper.assertError(emv2PropertyAssociation3, testResult.getIssues(), issueCollection,
				"Property EMV2::ExposurePeriod does not apply to trans1");
		PropertyExpression ownedValue3 = (emv2PropertyAssociation3.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(3.3, ((RealLiteral) ownedValue3).getValue(), 0);
		var emv2PathElement3 = (emv2PropertyAssociation3.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("trans1", emv2PathElement3.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement3, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				scope);
		Assert.assertNull(emv2PathElement3.getPath());

		issueCollection.sizeIs(testResult.getIssues().size());
		this.assertConstraints(issueCollection);

	}

	/**
	 * Tests scope_EMV2PathElement_namedElement for grammar path: ErrorModelSubclause -> EMV2PropertyAssociation ->
	 * 		EMV2Path -> EMV2PathElementOrKind
	 */
	@Test
	public void testEMV2PropertyAssociation() throws Exception {
		var aadlText = """
				property set ps1 is
				\treal1: aadlreal applies to (all);
				\tref1: reference (element) applies to (all);
				end ps1;
				""";
		var aadlText1 = """
				package EMV2PropertyAssociation
				public
				\twith ps1;
				\twith EMV2;
				\t
				\tabstract a1
				\t\tfeatures
				\t\t\tport1: in out event port;
				\t\t\tfg1: feature group fgt1;
				\t\tannex EMV2 {**
				\t\t\tuse types EMV2PropertyAssociation;
				\t\t\tuse behavior EMV2PropertyAssociation::bvr1;
				\t\t\t
				\t\t\terror propagations
				\t\t\t\tport1: in propagation {t1};
				\t\t\t\tport1: not in propagation {t2};
				\t\t\t\tport1: out propagation {t3, t1};
				\t\t\t\tport1: not out propagation {t4};
				\t\t\t\tfg1.fg2.fg3.port2: in propagation {t1};
				\t\t\t\tfg1.fg2.fg3.port2: not in propagation {t2};
				\t\t\t\tfg1.fg2.fg3.port2: out propagation {t3, t1};
				\t\t\t\tfg1.fg2.fg3.port2: not out propagation {t4};
				\t\t\tflows
				\t\t\t\terrorSource1: error source all {t3};
				\t\t\t\terrorSink1: error sink all {t1};
				\t\t\t\terrorPath1: error path all -> all;
				\t\t\tend propagations;
				\t\t\t
				\t\t\tcomponent error behavior
				\t\t\tevents
				\t\t\t\terrorEvent1: error event {t1};
				\t\t\t\trepairEvent1: repair event;
				\t\t\t\trecoverEvent1: recover event;
				\t\t\ttransitions
				\t\t\t\ttransition1: all -[ errorEvent1 ]-> state1;
				\t\t\tpropagations
				\t\t\t\toutgoingPropagationCondition1: all -[ errorEvent1 ]-> all;
				\t\t\tdetections
				\t\t\t\tdetection1: all -[ errorEvent1 ]-> port1!;
				\t\t\tend component;
				\t\t\t
				\t\t\tcomposite error behavior
				\t\t\tstates
				\t\t\t\tcompositeState1: [ others ]-> state1;
				\t\t\tend composite;
				\t\t\t
				\t\t\tconnection error
				\t\t\t\tconnectionErrorSource1: error source all {t1};
				\t\t\tend connection;
				\t\t**};
				\tend a1;
				\t
				\tabstract implementation a1.i
				\t\tsubcomponents
				\t\t\tasub1: abstract a2.i;
				\t\tannex EMV2 {**
				\t\t\tpropagation paths
				\t\t\t\tpropagationPath1: asub1.asub2.asub3.propagationPoint1 -> asub1.asub2.asub3.propagationPoint1;
				\t\t\t\tasub1.asub2.asub3.propagationPoint1 -> asub1.asub2.asub3.propagationPoint1;
				\t\t\tend paths;
				\t\t\t
				\t\t\tproperties
				\t\t\t\tEMV2::ExposurePeriod => 1.1 applies to port1;
				\t\t\t\tEMV2::ExposurePeriod => 2.2 applies to port1.t1;
				\t\t\t\tEMV2::ExposurePeriod => 3.3 applies to port1.t2;
				\t\t\t\tEMV2::ExposurePeriod => 4.4 applies to port1.t3;
				\t\t\t\tEMV2::ExposurePeriod => 5.5 applies to port1.t4;
				\t\t\t\tEMV2::ExposurePeriod => 6.6 applies to fg1.fg2.fg3.port2;
				\t\t\t\tEMV2::ExposurePeriod => 7.7 applies to fg1.fg2.fg3.port2.t1;
				\t\t\t\tEMV2::ExposurePeriod => 8.8 applies to fg1.fg2.fg3.port2.t2;
				\t\t\t\tEMV2::ExposurePeriod => 9.9 applies to fg1.fg2.fg3.port2.t3;
				\t\t\t\tEMV2::ExposurePeriod => 10.10 applies to fg1.fg2.fg3.port2.t4;
				\t\t\t\tEMV2::ExposurePeriod => 11.11 applies to ^asub1.asub2.asub3@port3;
				\t\t\t\tEMV2::ExposurePeriod => 12.12 applies to ^asub1.asub2.asub3@port3.t1;
				\t\t\t\tEMV2::ExposurePeriod => 13.13 applies to ^asub1.asub2.asub3@port3.t2;
				\t\t\t\tEMV2::ExposurePeriod => 14.14 applies to ^asub1.asub2.asub3@port3.t3;
				\t\t\t\tEMV2::ExposurePeriod => 15.15 applies to ^asub1.asub2.asub3@port3.t4;
				\t\t\t\tEMV2::ExposurePeriod => 16.16 applies to ^asub1.asub2.asub3@fg4.fg2.fg3.port2;
				\t\t\t\tEMV2::ExposurePeriod => 17.17 applies to ^asub1.asub2.asub3@fg4.fg2.fg3.port2.t1;
				\t\t\t\tEMV2::ExposurePeriod => 18.18 applies to ^asub1.asub2.asub3@fg4.fg2.fg3.port2.t2;
				\t\t\t\tEMV2::ExposurePeriod => 19.19 applies to ^asub1.asub2.asub3@fg4.fg2.fg3.port2.t3;
				\t\t\t\tEMV2::ExposurePeriod => 20.20 applies to ^asub1.asub2.asub3@fg4.fg2.fg3.port2.t4;
				\t\t\t\tEMV2::ExposurePeriod => 21.21 applies to errorSource1;
				\t\t\t\tEMV2::ExposurePeriod => 22.22 applies to errorSource1.t3;
				\t\t\t\tEMV2::ExposurePeriod => 23.23 applies to ^asub1.asub2.asub3@errorSource2;
				\t\t\t\tEMV2::ExposurePeriod => 24.24 applies to ^asub1.asub2.asub3@errorSource2.t3;
				\t\t\t\tEMV2::ExposurePeriod => 25.25 applies to errorSink1;
				\t\t\t\tEMV2::ExposurePeriod => 26.26 applies to errorSink1.t1;
				\t\t\t\tEMV2::ExposurePeriod => 27.27 applies to ^asub1.asub2.asub3@errorSink2;
				\t\t\t\tEMV2::ExposurePeriod => 28.28 applies to ^asub1.asub2.asub3@errorSink2.t1;
				\t\t\t\tEMV2::ExposurePeriod => 29.29 applies to errorPath1;
				\t\t\t\tEMV2::ExposurePeriod => 30.30 applies to ^asub1.asub2.asub3@errorPath2;
				\t\t\t\tEMV2::ExposurePeriod => 31.31 applies to errorEvent1;
				\t\t\t\tEMV2::ExposurePeriod => 32.32 applies to errorEvent1.t1;
				\t\t\t\tEMV2::ExposurePeriod => 33.33 applies to ^asub1.asub2.asub3@errorEvent2;
				\t\t\t\tEMV2::ExposurePeriod => 34.34 applies to ^asub1.asub2.asub3@errorEvent2.t1;
				\t\t\t\tEMV2::ExposurePeriod => 35.35 applies to errorEvent3;
				\t\t\t\tEMV2::ExposurePeriod => 36.36 applies to errorEvent3.t1;
				\t\t\t\tEMV2::ExposurePeriod => 37.37 applies to ^asub1.asub2.asub3@errorEvent3;
				\t\t\t\tEMV2::ExposurePeriod => 38.38 applies to ^asub1.asub2.asub3@errorEvent3.t1;
				\t\t\t\tEMV2::ExposurePeriod => 39.39 applies to repairEvent1;
				\t\t\t\tEMV2::ExposurePeriod => 40.40 applies to ^asub1.asub2.asub3@repairEvent2;
				\t\t\t\tEMV2::ExposurePeriod => 41.41 applies to repairEvent3;
				\t\t\t\tEMV2::ExposurePeriod => 42.42 applies to ^asub1.asub2.asub3@repairEvent3;
				\t\t\t\tEMV2::ExposurePeriod => 43.43 applies to recoverEvent1;
				\t\t\t\tEMV2::ExposurePeriod => 44.44 applies to ^asub1.asub2.asub3@recoverEvent2;
				\t\t\t\tEMV2::ExposurePeriod => 45.45 applies to recoverEvent3;
				\t\t\t\tEMV2::ExposurePeriod => 46.46 applies to ^asub1.asub2.asub3@recoverEvent3;
				\t\t\t\tEMV2::TransientFailureRatio => 47.47 applies to transition1;
				\t\t\t\tEMV2::TransientFailureRatio => 48.48 applies to transition3;
				\t\t\t\tEMV2::TransientFailureRatio => 49.49 applies to ^asub1.asub2.asub3@transition2;
				\t\t\t\tEMV2::TransientFailureRatio => 50.50 applies to ^asub1.asub2.asub3@transition3;
				\t\t\t\tEMV2::ExposurePeriod => 51.51 applies to outgoingPropagationCondition1;
				\t\t\t\tps1::real1 => 52.52 applies to ^asub1.asub2.asub3@outgoingPropagationCondition2;
				\t\t\t\tEMV2::ExposurePeriod => 53.53 applies to detection1;
				\t\t\t\tEMV2::DetectionMechanism => "54" applies to ^asub1.asub2.asub3@detection2;
				\t\t\t\tEMV2::ExposurePeriod => 55.55 applies to compositeState1;
				\t\t\t\tps1::real1 => 56.56 applies to ^asub1.asub2.asub3@compositeState2;
				\t\t\t\tEMV2::ExposurePeriod => 57.57 applies to connectionErrorSource1;
				\t\t\t\tEMV2::ExposurePeriod => 58.58 applies to connectionErrorSource1.t1;
				\t\t\t\tps1::real1 => 59.59 applies to ^asub1.asub2.asub3@connectionErrorSource2;
				\t\t\t\tEMV2::ExposurePeriod => 60.60 applies to ^asub1.asub2.asub3@connectionErrorSource2.t1;
				\t\t\t\tEMV2::ExposurePeriod => 61.61 applies to propagationPath1;
				\t\t\t\tps1::real1 => 62.62 applies to ^asub1.asub2.asub3@propagationPath2;
				\t\t\t\tEMV2::ExposurePeriod => 63.63 applies to state1;
				\t\t\t\tEMV2::ExposurePeriod => 64.64 applies to state1.t1;
				\t\t\t\tEMV2::ExposurePeriod => 65.65 applies to ^asub1.asub2.asub3@state1;
				\t\t\t\tEMV2::ExposurePeriod => 66.66 applies to ^asub1.asub2.asub3@state1.t1;
				\t\t**};
				\tend a1.i;
				\t
				\tfeature group fgt1
				\t\tfeatures
				\t\t\tfg2: feature group fgt2;
				\tend fgt1;
				\t
				\tfeature group fgt2
				\t\tfeatures
				\t\t\tfg3: feature group fgt3;
				\tend fgt2;
				\t
				\tfeature group fgt3
				\t\tfeatures
				\t\t\tport2: in out event port;
				\tend fgt3;
				\t
				\tabstract a2
				\tend a2;
				\t
				\tabstract implementation a2.i
				\t\tsubcomponents
				\t\t\tasub2: abstract a3.i;
				\tend a2.i;
				\t
				\tabstract a3
				\tend a3;
				\t
				\tabstract implementation a3.i
				\t\tsubcomponents
				\t\t\tasub3: abstract a4.i;
				\tend a3.i;
				\t
				\tabstract a4
				\t\tfeatures
				\t\t\tport3: in out event port;
				\t\t\tfg4: feature group fgt1;
				\t\tannex EMV2 {**
				\t\t\tuse types EMV2PropertyAssociation;
				\t\t\tuse behavior EMV2PropertyAssociation::bvr1;
				\t\t\t
				\t\t\terror propagations
				\t\t\t\tport3: in propagation {t1};
				\t\t\t\tport3: not in propagation {t2};
				\t\t\t\tport3: out propagation {t3, t1};
				\t\t\t\tport3: not out propagation {t4};
				\t\t\t\tfg4.fg2.fg3.port2: in propagation {t1};
				\t\t\t\tfg4.fg2.fg3.port2: not in propagation {t2};
				\t\t\t\tfg4.fg2.fg3.port2: out propagation {t3, t1};
				\t\t\t\tfg4.fg2.fg3.port2: not out propagation {t4};
				\t\t\tflows
				\t\t\t\terrorSource2: error source all {t3};
				\t\t\t\terrorSink2: error sink all {t1};
				\t\t\t\terrorPath2: error path all -> all;
				\t\t\tend propagations;
				\t\t\t
				\t\t\tcomponent error behavior
				\t\t\tevents
				\t\t\t\terrorEvent2: error event {t1};
				\t\t\t\trepairEvent2: repair event;
				\t\t\t\trecoverEvent2: recover event;
				\t\t\ttransitions
				\t\t\t\ttransition2: all -[ errorEvent2 ]-> state1;
				\t\t\tpropagations
				\t\t\t\toutgoingPropagationCondition2: all -[ errorEvent2 ]-> all;
				\t\t\tdetections
				\t\t\t\tdetection2: all -[ errorEvent2 ]-> port3!;
				\t\t\tend component;
				\t\t\t
				\t\t\tcomposite error behavior
				\t\t\tstates
				\t\t\t\tcompositeState2: [ others ]-> state1;
				\t\t\tend composite;
				\t\t\t
				\t\t\tconnection error
				\t\t\t\tconnectionErrorSource2: error source all {t1};
				\t\t\tend connection;
				\t\t\t
				\t\t\tpropagation paths
				\t\t\t\tpropagationPoint1: propagation point;
				\t\t\tend paths;
				\t\t**};
				\tend a4;
				\t
				\tabstract implementation a4.i
				\t\tsubcomponents
				\t\t\tasub4: abstract a5;
				\t\tannex EMV2 {**
				\t\t\tpropagation paths
				\t\t\t\tpropagationPath2: asub4.propagationPoint2 -> asub4.propagationPoint2;
				\t\t\tend paths;
				\t\t**};
				\tend a4.i;
				\t
				\tabstract a5
				\t\tannex EMV2 {**
				\t\t\tpropagation paths
				\t\t\t\tpropagationPoint2: propagation point;
				\t\t\tend paths;
				\t\t**};
				\tend a5;
				\t
				\tannex EMV2 {**
				\t\terror types
				\t\t\tt1: type;
				\t\t\tt2: type;
				\t\t\tt3: type;
				\t\t\tt4: type;
				\t\tend types;
				\t\t
				\t\terror behavior bvr1 use types EMV2PropertyAssociation;
				\t\tevents
				\t\t\terrorEvent3: error event {t1};
				\t\t\trepairEvent3: repair event;
				\t\t\trecoverEvent3: recover event;
				\t\tstates
				\t\t\tstate1: initial state {t1};
				\t\ttransitions
				\t\t\ttransition3: all -[ errorEvent3 ]-> state1;
				\t\tend behavior;
				\t**};
				end EMV2PropertyAssociation;
				""";
		final FluentIssueCollection lib1TestResult = this.issues = this.testHelper.testString(aadlText1, aadlText);
		final FluentIssueCollection lib1IssueCollection = new FluentIssueCollection(lib1TestResult.getResource(),
				new ArrayList<>(), new ArrayList<>());
		var aadlPackage = ((AadlPackage) (lib1TestResult.getResource().getContents()).getFirst());
		Assert.assertEquals("EMV2PropertyAssociation", aadlPackage.getName());
		var classifier = aadlPackage.getPublicSection().getOwnedClassifiers().get(1);
		Assert.assertEquals("a1.i", classifier.getName());
		var errorModelSubclause = ((ErrorModelSubclause) ((DefaultAnnexSubclause) (classifier.getOwnedAnnexSubclauses())
				.getFirst()).getParsedAnnexSubclause());
		final List<String> firstElementScope = List.of("compositeState1", "connectionErrorSource1", "detection1",
				"errorEvent1", "errorEvent3", "errorPath1", "errorSink1", "errorSource1", "fg1",
				"outgoingPropagationCondition1", "port1", "port1", "port1", "port1", "propagationPath1",
				"recoverEvent1", "recoverEvent3", "repairEvent1", "repairEvent3", "state1", "transition1",
				"transition3");
		final List<String> postSubcomponentScope = List.of("compositeState2", "connectionErrorSource2", "detection2",
				"errorEvent2", "errorEvent3", "errorPath2", "errorSink2", "errorSource2", "fg4",
				"outgoingPropagationCondition2", "port3", "port3", "port3", "port3", "propagationPath2",
				"recoverEvent2", "recoverEvent3", "repairEvent2", "repairEvent3", "state1", "transition2",
				"transition3");
		var emv2PropertyAssociation = errorModelSubclause.getProperties().get(0);
		PropertyExpression ownedValue = (emv2PropertyAssociation.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(1.1, ((RealLiteral) ownedValue).getValue(), 0);
		var emv2PathElement59 = (emv2PropertyAssociation.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("port1",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement59.getNamedElement())));
		this.assertHelper.assertScope(emv2PathElement59, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		Assert.assertNull(emv2PathElement59.getPath());
		var emv2PropertyAssociation2 = errorModelSubclause.getProperties().get(1);
		PropertyExpression ownedValue2 = (emv2PropertyAssociation2.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(2.2, ((RealLiteral) ownedValue2).getValue(), 0);
		var emv2PathElement60 = (emv2PropertyAssociation2.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("port1",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement60.getNamedElement())));
		this.assertHelper.assertScope(emv2PathElement60, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		var emv2PathElement29 = emv2PathElement60.getPath();
		Assert.assertEquals("t1", emv2PathElement29.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement29, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("t1", "t2", "t3", "t4", "EMV2PropertyAssociation::t1", "EMV2PropertyAssociation::t2",
						"EMV2PropertyAssociation::t3", "EMV2PropertyAssociation::t4"));
		Assert.assertNull(emv2PathElement29.getPath());
		var emv2PropertyAssociation3 = errorModelSubclause.getProperties().get(2);
		PropertyExpression ownedValue3 = (emv2PropertyAssociation3.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(3.3, ((RealLiteral) ownedValue3).getValue(), 0);
		var emv2PathElement61 = (emv2PropertyAssociation3.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("port1",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement61.getNamedElement())));
		this.assertHelper.assertScope(emv2PathElement61, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		var emv2PathElement30 = emv2PathElement61.getPath();
		Assert.assertEquals("t2", emv2PathElement30.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement30, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("t1", "t2", "t3", "t4", "EMV2PropertyAssociation::t1", "EMV2PropertyAssociation::t2",
						"EMV2PropertyAssociation::t3", "EMV2PropertyAssociation::t4"));
		Assert.assertNull(emv2PathElement30.getPath());
		var emv2PropertyAssociation4 = errorModelSubclause.getProperties().get(3);
		PropertyExpression ownedValue4 = (emv2PropertyAssociation4.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(4.4, ((RealLiteral) ownedValue4).getValue(), 0);
		var emv2PathElement62 = (emv2PropertyAssociation4.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("port1",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement62.getNamedElement())));
		this.assertHelper.assertScope(emv2PathElement62, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		var emv2PathElement31 = emv2PathElement62.getPath();
		Assert.assertEquals("t3", emv2PathElement31.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement31, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("t1", "t2", "t3", "t4", "EMV2PropertyAssociation::t1", "EMV2PropertyAssociation::t2",
						"EMV2PropertyAssociation::t3", "EMV2PropertyAssociation::t4"));
		Assert.assertNull(emv2PathElement31.getPath());
		var emv2PropertyAssociation5 = errorModelSubclause.getProperties().get(4);
		PropertyExpression ownedValue5 = (emv2PropertyAssociation5.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(5.5, ((RealLiteral) ownedValue5).getValue(), 0);
		var emv2PathElement63 = (emv2PropertyAssociation5.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("port1",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement63.getNamedElement())));
		this.assertHelper.assertScope(emv2PathElement63, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		var emv2PathElement32 = emv2PathElement63.getPath();
		Assert.assertEquals("t4", emv2PathElement32.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement32, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("t1", "t2", "t3", "t4", "EMV2PropertyAssociation::t1", "EMV2PropertyAssociation::t2",
						"EMV2PropertyAssociation::t3", "EMV2PropertyAssociation::t4"));
		Assert.assertNull(emv2PathElement32.getPath());
		var emv2PropertyAssociation6 = errorModelSubclause.getProperties().get(5);
		PropertyExpression ownedValue6 = (emv2PropertyAssociation6.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(6.6, ((RealLiteral) ownedValue6).getValue(), 0);
		var emv2PathElement64 = (emv2PropertyAssociation6.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("fg1", emv2PathElement64.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement64, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		var emv2PathElement33 = emv2PathElement64.getPath();
		Assert.assertEquals("fg2", emv2PathElement33.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement33, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("fg2"));
		var emv2PathElement19 = emv2PathElement33.getPath();
		Assert.assertEquals("fg3", emv2PathElement19.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement19, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("fg3"));
		var emv2PathElement9 = emv2PathElement19.getPath();
		Assert.assertEquals("fg1.fg2.fg3.port2",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement9.getNamedElement())));
		this.assertHelper.assertScope(emv2PathElement9, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("port2", "port2", "port2", "port2"));
		Assert.assertNull(emv2PathElement9.getPath());
		var emv2PropertyAssociation7 = errorModelSubclause.getProperties().get(6);
		PropertyExpression ownedValue7 = (emv2PropertyAssociation7.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(7.7, ((RealLiteral) ownedValue7).getValue(), 0);
		var emv2PathElement65 = (emv2PropertyAssociation7.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("fg1", emv2PathElement65.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement65, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		var emv2PathElement34 = emv2PathElement65.getPath();
		Assert.assertEquals("fg2", emv2PathElement34.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement34, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("fg2"));
		var emv2PathElement20 = emv2PathElement34.getPath();
		Assert.assertEquals("fg3", emv2PathElement20.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement20, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("fg3"));
		var emv2PathElement10 = emv2PathElement20.getPath();
		Assert.assertEquals("fg1.fg2.fg3.port2",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement10.getNamedElement())));
		this.assertHelper.assertScope(emv2PathElement10, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("port2", "port2", "port2", "port2"));
		var emv2PathElement = emv2PathElement10.getPath();
		Assert.assertEquals("t1", emv2PathElement.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("t1", "t2", "t3", "t4", "EMV2PropertyAssociation::t1", "EMV2PropertyAssociation::t2",
						"EMV2PropertyAssociation::t3", "EMV2PropertyAssociation::t4"));
		Assert.assertNull(emv2PathElement.getPath());
		var emv2PropertyAssociation8 = errorModelSubclause.getProperties().get(7);
		PropertyExpression ownedValue8 = (emv2PropertyAssociation8.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(8.8, ((RealLiteral) ownedValue8).getValue(), 0);
		var emv2PathElement66 = (emv2PropertyAssociation8.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("fg1", emv2PathElement66.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement66, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		var emv2PathElement35 = emv2PathElement66.getPath();
		Assert.assertEquals("fg2", emv2PathElement35.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement35, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("fg2"));
		var emv2PathElement21 = emv2PathElement35.getPath();
		Assert.assertEquals("fg3", emv2PathElement21.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement21, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("fg3"));
		var emv2PathElement11 = emv2PathElement21.getPath();
		Assert.assertEquals("fg1.fg2.fg3.port2",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement11.getNamedElement())));
		this.assertHelper.assertScope(emv2PathElement11, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("port2", "port2", "port2", "port2"));
		var emv2PathElement2 = emv2PathElement11.getPath();
		Assert.assertEquals("t2", emv2PathElement2.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement2, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("t1", "t2", "t3", "t4", "EMV2PropertyAssociation::t1", "EMV2PropertyAssociation::t2",
						"EMV2PropertyAssociation::t3", "EMV2PropertyAssociation::t4"));
		Assert.assertNull(emv2PathElement2.getPath());
		var emv2PropertyAssociation9 = errorModelSubclause.getProperties().get(8);
		PropertyExpression ownedValue9 = (emv2PropertyAssociation9.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(9.9, ((RealLiteral) ownedValue9).getValue(), 0);
		var emv2PathElement67 = (emv2PropertyAssociation9.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("fg1", emv2PathElement67.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement67, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		var emv2PathElement36 = emv2PathElement67.getPath();
		Assert.assertEquals("fg2", emv2PathElement36.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement36, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("fg2"));
		var emv2PathElement22 = emv2PathElement36.getPath();
		Assert.assertEquals("fg3", emv2PathElement22.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement22, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("fg3"));
		var emv2PathElement12 = emv2PathElement22.getPath();
		Assert.assertEquals("fg1.fg2.fg3.port2",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement12.getNamedElement())));
		this.assertHelper.assertScope(emv2PathElement12, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("port2", "port2", "port2", "port2"));
		var emv2PathElement3 = emv2PathElement12.getPath();
		Assert.assertEquals("t3", emv2PathElement3.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement3, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("t1", "t2", "t3", "t4", "EMV2PropertyAssociation::t1", "EMV2PropertyAssociation::t2",
						"EMV2PropertyAssociation::t3", "EMV2PropertyAssociation::t4"));
		Assert.assertNull(emv2PathElement3.getPath());
		var emv2PropertyAssociation10 = errorModelSubclause.getProperties().get(9);
		PropertyExpression ownedValue10 = (emv2PropertyAssociation10.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(10.10, ((RealLiteral) ownedValue10).getValue(), 0);
		var emv2PathElement68 = (emv2PropertyAssociation10.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("fg1", emv2PathElement68.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement68, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		var emv2PathElement37 = emv2PathElement68.getPath();
		Assert.assertEquals("fg2", emv2PathElement37.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement37, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("fg2"));
		var emv2PathElement23 = emv2PathElement37.getPath();
		Assert.assertEquals("fg3", emv2PathElement23.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement23, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("fg3"));
		var emv2PathElement13 = emv2PathElement23.getPath();
		Assert.assertEquals("fg1.fg2.fg3.port2",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement13.getNamedElement())));
		this.assertHelper.assertScope(emv2PathElement13, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("port2", "port2", "port2", "port2"));
		var emv2PathElement4 = emv2PathElement13.getPath();
		Assert.assertEquals("t4", emv2PathElement4.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement4, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("t1", "t2", "t3", "t4", "EMV2PropertyAssociation::t1", "EMV2PropertyAssociation::t2",
						"EMV2PropertyAssociation::t3", "EMV2PropertyAssociation::t4"));
		Assert.assertNull(emv2PathElement4.getPath());
		var emv2PropertyAssociation11 = errorModelSubclause.getProperties().get(10);
		PropertyExpression ownedValue11 = (emv2PropertyAssociation11.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(11.11, ((RealLiteral) ownedValue11).getValue(), 0);
		var emv2PathElement69 = (emv2PropertyAssociation11.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("port3",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement69.getNamedElement())));
		this.assertHelper.assertScope(emv2PathElement69, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				postSubcomponentScope);
		Assert.assertNull(emv2PathElement69.getPath());
		var emv2PropertyAssociation12 = errorModelSubclause.getProperties().get(11);
		PropertyExpression ownedValue12 = (emv2PropertyAssociation12.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(12.12, ((RealLiteral) ownedValue12).getValue(), 0);
		var emv2PathElement70 = (emv2PropertyAssociation12.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("port3",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement70.getNamedElement())));
		this.assertHelper.assertScope(emv2PathElement70, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				postSubcomponentScope);
		var emv2PathElement38 = emv2PathElement70.getPath();
		Assert.assertEquals("t1", emv2PathElement38.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement38, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("t1", "t2", "t3", "t4", "EMV2PropertyAssociation::t1", "EMV2PropertyAssociation::t2",
						"EMV2PropertyAssociation::t3", "EMV2PropertyAssociation::t4"));
		Assert.assertNull(emv2PathElement38.getPath());
		var emv2PropertyAssociation13 = errorModelSubclause.getProperties().get(12);
		PropertyExpression ownedValue13 = (emv2PropertyAssociation13.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(13.13, ((RealLiteral) ownedValue13).getValue(), 0);
		var emv2PathElement71 = (emv2PropertyAssociation13.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("port3",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement71.getNamedElement())));
		this.assertHelper.assertScope(emv2PathElement71, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				postSubcomponentScope);
		var emv2PathElement39 = emv2PathElement71.getPath();
		Assert.assertEquals("t2", emv2PathElement39.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement39, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("t1", "t2", "t3", "t4", "EMV2PropertyAssociation::t1", "EMV2PropertyAssociation::t2",
						"EMV2PropertyAssociation::t3", "EMV2PropertyAssociation::t4"));
		Assert.assertNull(emv2PathElement39.getPath());
		var emv2PropertyAssociation14 = errorModelSubclause.getProperties().get(13);
		PropertyExpression ownedValue14 = (emv2PropertyAssociation14.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(14.14, ((RealLiteral) ownedValue14).getValue(), 0);
		var emv2PathElement72 = (emv2PropertyAssociation14.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("port3",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement72.getNamedElement())));
		this.assertHelper.assertScope(emv2PathElement72, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				postSubcomponentScope);
		var emv2PathElement40 = emv2PathElement72.getPath();
		Assert.assertEquals("t3", emv2PathElement40.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement40, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("t1", "t2", "t3", "t4", "EMV2PropertyAssociation::t1", "EMV2PropertyAssociation::t2",
						"EMV2PropertyAssociation::t3", "EMV2PropertyAssociation::t4"));
		Assert.assertNull(emv2PathElement40.getPath());
		var emv2PropertyAssociation15 = errorModelSubclause.getProperties().get(14);
		PropertyExpression ownedValue15 = (emv2PropertyAssociation15.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(15.15, ((RealLiteral) ownedValue15).getValue(), 0);
		var emv2PathElement73 = (emv2PropertyAssociation15.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("port3",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement73.getNamedElement())));
		this.assertHelper.assertScope(emv2PathElement73, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				postSubcomponentScope);
		var emv2PathElement41 = emv2PathElement73.getPath();
		Assert.assertEquals("t4", emv2PathElement41.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement41, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("t1", "t2", "t3", "t4", "EMV2PropertyAssociation::t1", "EMV2PropertyAssociation::t2",
						"EMV2PropertyAssociation::t3", "EMV2PropertyAssociation::t4"));
		Assert.assertNull(emv2PathElement41.getPath());
		var emv2PropertyAssociation16 = errorModelSubclause.getProperties().get(15);
		PropertyExpression ownedValue16 = (emv2PropertyAssociation16.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(16.16, ((RealLiteral) ownedValue16).getValue(), 0);
		var emv2PathElement74 = (emv2PropertyAssociation16.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("fg4", emv2PathElement74.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement74, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				postSubcomponentScope);
		var emv2PathElement42 = emv2PathElement74.getPath();
		Assert.assertEquals("fg2", emv2PathElement42.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement42, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("fg2"));
		var emv2PathElement24 = emv2PathElement42.getPath();
		Assert.assertEquals("fg3", emv2PathElement24.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement24, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("fg3"));
		var emv2PathElement14 = emv2PathElement24.getPath();
		Assert.assertEquals("fg4.fg2.fg3.port2",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement14.getNamedElement())));
		this.assertHelper.assertScope(emv2PathElement14, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("port2", "port2", "port2", "port2"));
		Assert.assertNull(emv2PathElement14.getPath());
		var emv2PropertyAssociation17 = errorModelSubclause.getProperties().get(16);
		PropertyExpression ownedValue17 = (emv2PropertyAssociation17.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(17.17, ((RealLiteral) ownedValue17).getValue(), 0);
		var emv2PathElement75 = (emv2PropertyAssociation17.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("fg4", emv2PathElement75.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement75, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				postSubcomponentScope);
		var emv2PathElement43 = emv2PathElement75.getPath();
		Assert.assertEquals("fg2", emv2PathElement43.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement43, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("fg2"));
		var emv2PathElement25 = emv2PathElement43.getPath();
		Assert.assertEquals("fg3", emv2PathElement25.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement25, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("fg3"));
		var emv2PathElement15 = emv2PathElement25.getPath();
		Assert.assertEquals("fg4.fg2.fg3.port2",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement15.getNamedElement())));
		this.assertHelper.assertScope(emv2PathElement15, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("port2", "port2", "port2", "port2"));
		var emv2PathElement5 = emv2PathElement15.getPath();
		Assert.assertEquals("t1", emv2PathElement5.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement5, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("t1", "t2", "t3", "t4", "EMV2PropertyAssociation::t1", "EMV2PropertyAssociation::t2",
						"EMV2PropertyAssociation::t3", "EMV2PropertyAssociation::t4"));
		Assert.assertNull(emv2PathElement5.getPath());
		var emv2PropertyAssociation18 = errorModelSubclause.getProperties().get(17);
		PropertyExpression ownedValue18 = (emv2PropertyAssociation18.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(18.18, ((RealLiteral) ownedValue18).getValue(), 0);
		var emv2PathElement76 = (emv2PropertyAssociation18.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("fg4", emv2PathElement76.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement76, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				postSubcomponentScope);
		var emv2PathElement44 = emv2PathElement76.getPath();
		Assert.assertEquals("fg2", emv2PathElement44.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement44, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("fg2"));
		var emv2PathElement26 = emv2PathElement44.getPath();
		Assert.assertEquals("fg3", emv2PathElement26.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement26, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("fg3"));
		var emv2PathElement16 = emv2PathElement26.getPath();
		Assert.assertEquals("fg4.fg2.fg3.port2",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement16.getNamedElement())));
		this.assertHelper.assertScope(emv2PathElement16, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("port2", "port2", "port2", "port2"));
		var emv2PathElement6 = emv2PathElement16.getPath();
		Assert.assertEquals("t2", emv2PathElement6.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement6, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("t1", "t2", "t3", "t4", "EMV2PropertyAssociation::t1", "EMV2PropertyAssociation::t2",
						"EMV2PropertyAssociation::t3", "EMV2PropertyAssociation::t4"));
		Assert.assertNull(emv2PathElement6.getPath());
		var emv2PropertyAssociation19 = errorModelSubclause.getProperties().get(18);
		PropertyExpression ownedValue19 = (emv2PropertyAssociation19.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(19.19, ((RealLiteral) ownedValue19).getValue(), 0);
		var emv2PathElement77 = (emv2PropertyAssociation19.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("fg4", emv2PathElement77.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement77, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				postSubcomponentScope);
		var emv2PathElement45 = emv2PathElement77.getPath();
		Assert.assertEquals("fg2", emv2PathElement45.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement45, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("fg2"));
		var emv2PathElement27 = emv2PathElement45.getPath();
		Assert.assertEquals("fg3", emv2PathElement27.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement27, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("fg3"));
		var emv2PathElement17 = emv2PathElement27.getPath();
		Assert.assertEquals("fg4.fg2.fg3.port2",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement17.getNamedElement())));
		this.assertHelper.assertScope(emv2PathElement17, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("port2", "port2", "port2", "port2"));
		var emv2PathElement7 = emv2PathElement17.getPath();
		Assert.assertEquals("t3", emv2PathElement7.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement7, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("t1", "t2", "t3", "t4", "EMV2PropertyAssociation::t1", "EMV2PropertyAssociation::t2",
						"EMV2PropertyAssociation::t3", "EMV2PropertyAssociation::t4"));
		Assert.assertNull(emv2PathElement7.getPath());
		var emv2PropertyAssociation20 = errorModelSubclause.getProperties().get(19);
		PropertyExpression ownedValue20 = (emv2PropertyAssociation20.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(20.20, ((RealLiteral) ownedValue20).getValue(), 0);
		var emv2PathElement78 = (emv2PropertyAssociation20.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("fg4", emv2PathElement78.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement78, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				postSubcomponentScope);
		var emv2PathElement46 = emv2PathElement78.getPath();
		Assert.assertEquals("fg2", emv2PathElement46.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement46, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("fg2"));
		var emv2PathElement28 = emv2PathElement46.getPath();
		Assert.assertEquals("fg3", emv2PathElement28.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement28, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("fg3"));
		var emv2PathElement18 = emv2PathElement28.getPath();
		Assert.assertEquals("fg4.fg2.fg3.port2",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement18.getNamedElement())));
		this.assertHelper.assertScope(emv2PathElement18, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("port2", "port2", "port2", "port2"));
		var emv2PathElement8 = emv2PathElement18.getPath();
		Assert.assertEquals("t4", emv2PathElement8.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement8, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("t1", "t2", "t3", "t4", "EMV2PropertyAssociation::t1", "EMV2PropertyAssociation::t2",
						"EMV2PropertyAssociation::t3", "EMV2PropertyAssociation::t4"));
		Assert.assertNull(emv2PathElement8.getPath());
		var emv2PropertyAssociation21 = errorModelSubclause.getProperties().get(20);
		PropertyExpression ownedValue21 = (emv2PropertyAssociation21.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(21.21, ((RealLiteral) ownedValue21).getValue(), 0);
		var emv2PathElement79 = (emv2PropertyAssociation21.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("errorSource1", emv2PathElement79.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement79, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		Assert.assertNull(emv2PathElement79.getPath());
		var emv2PropertyAssociation22 = errorModelSubclause.getProperties().get(21);
		PropertyExpression ownedValue22 = (emv2PropertyAssociation22.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(22.22, ((RealLiteral) ownedValue22).getValue(), 0);
		var emv2PathElement80 = (emv2PropertyAssociation22.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("errorSource1", emv2PathElement80.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement80, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		var emv2PathElement47 = emv2PathElement80.getPath();
		Assert.assertEquals("t3", emv2PathElement47.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement47, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("t1", "t2", "t3", "t4", "EMV2PropertyAssociation::t1", "EMV2PropertyAssociation::t2",
						"EMV2PropertyAssociation::t3", "EMV2PropertyAssociation::t4"));
		Assert.assertNull(emv2PathElement47.getPath());
		var emv2PropertyAssociation23 = errorModelSubclause.getProperties().get(22);
		PropertyExpression ownedValue23 = (emv2PropertyAssociation23.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(23.23, ((RealLiteral) ownedValue23).getValue(), 0);
		var emv2PathElement81 = (emv2PropertyAssociation23.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("errorSource2", emv2PathElement81.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement81, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				postSubcomponentScope);
		Assert.assertNull(emv2PathElement81.getPath());
		var emv2PropertyAssociation24 = errorModelSubclause.getProperties().get(23);
		PropertyExpression ownedValue24 = (emv2PropertyAssociation24.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(24.24, ((RealLiteral) ownedValue24).getValue(), 0);
		var emv2PathElement82 = (emv2PropertyAssociation24.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("errorSource2", emv2PathElement82.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement82, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				postSubcomponentScope);
		var emv2PathElement48 = emv2PathElement82.getPath();
		Assert.assertEquals("t3", emv2PathElement48.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement48, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("t1", "t2", "t3", "t4", "EMV2PropertyAssociation::t1", "EMV2PropertyAssociation::t2",
						"EMV2PropertyAssociation::t3", "EMV2PropertyAssociation::t4"));
		Assert.assertNull(emv2PathElement48.getPath());
		var emv2PropertyAssociation25 = errorModelSubclause.getProperties().get(24);
		PropertyExpression ownedValue25 = (emv2PropertyAssociation25.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(25.25, ((RealLiteral) ownedValue25).getValue(), 0);
		var emv2PathElement83 = (emv2PropertyAssociation25.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("errorSink1", emv2PathElement83.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement83, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		Assert.assertNull(emv2PathElement83.getPath());
		var emv2PropertyAssociation26 = errorModelSubclause.getProperties().get(25);
		PropertyExpression ownedValue26 = (emv2PropertyAssociation26.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(26.26, ((RealLiteral) ownedValue26).getValue(), 0);
		var emv2PathElement84 = (emv2PropertyAssociation26.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("errorSink1", emv2PathElement84.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement84, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		var emv2PathElement49 = emv2PathElement84.getPath();
		Assert.assertEquals("t1", emv2PathElement49.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement49, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("t1", "t2", "t3", "t4", "EMV2PropertyAssociation::t1", "EMV2PropertyAssociation::t2",
						"EMV2PropertyAssociation::t3", "EMV2PropertyAssociation::t4"));
		Assert.assertNull(emv2PathElement49.getPath());
		var emv2PropertyAssociation27 = errorModelSubclause.getProperties().get(26);
		PropertyExpression ownedValue27 = (emv2PropertyAssociation27.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(27.27, ((RealLiteral) ownedValue27).getValue(), 0);
		var emv2PathElement85 = (emv2PropertyAssociation27.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("errorSink2", emv2PathElement85.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement85, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				postSubcomponentScope);
		Assert.assertNull(emv2PathElement85.getPath());
		var emv2PropertyAssociation28 = errorModelSubclause.getProperties().get(27);
		PropertyExpression ownedValue28 = (emv2PropertyAssociation28.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(28.28, ((RealLiteral) ownedValue28).getValue(), 0);
		var emv2PathElement86 = (emv2PropertyAssociation28.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("errorSink2", emv2PathElement86.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement86, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				postSubcomponentScope);
		var emv2PathElement50 = emv2PathElement86.getPath();
		Assert.assertEquals("t1", emv2PathElement50.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement50, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("t1", "t2", "t3", "t4", "EMV2PropertyAssociation::t1", "EMV2PropertyAssociation::t2",
						"EMV2PropertyAssociation::t3", "EMV2PropertyAssociation::t4"));
		Assert.assertNull(emv2PathElement50.getPath());
		var emv2PropertyAssociation29 = errorModelSubclause.getProperties().get(28);
		PropertyExpression ownedValue29 = (emv2PropertyAssociation29.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(29.29, ((RealLiteral) ownedValue29).getValue(), 0);
		var emv2PathElement87 = (emv2PropertyAssociation29.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("errorPath1", emv2PathElement87.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement87, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		Assert.assertNull(emv2PathElement87.getPath());
		var emv2PropertyAssociation30 = errorModelSubclause.getProperties().get(29);
		PropertyExpression ownedValue30 = (emv2PropertyAssociation30.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(30.30, ((RealLiteral) ownedValue30).getValue(), 0);
		var emv2PathElement88 = (emv2PropertyAssociation30.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("errorPath2", emv2PathElement88.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement88, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				postSubcomponentScope);
		Assert.assertNull(emv2PathElement88.getPath());
		var emv2PropertyAssociation31 = errorModelSubclause.getProperties().get(30);
		PropertyExpression ownedValue31 = (emv2PropertyAssociation31.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(31.31, ((RealLiteral) ownedValue31).getValue(), 0);
		var emv2PathElement89 = (emv2PropertyAssociation31.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("errorEvent1", emv2PathElement89.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement89, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		Assert.assertNull(emv2PathElement89.getPath());
		var emv2PropertyAssociation32 = errorModelSubclause.getProperties().get(31);
		PropertyExpression ownedValue32 = (emv2PropertyAssociation32.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(32.32, ((RealLiteral) ownedValue32).getValue(), 0);
		var emv2PathElement90 = (emv2PropertyAssociation32.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("errorEvent1", emv2PathElement90.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement90, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		var emv2PathElement51 = emv2PathElement90.getPath();
		Assert.assertEquals("t1", emv2PathElement51.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement51, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("t1", "t2", "t3", "t4", "EMV2PropertyAssociation::t1", "EMV2PropertyAssociation::t2",
						"EMV2PropertyAssociation::t3", "EMV2PropertyAssociation::t4"));
		Assert.assertNull(emv2PathElement51.getPath());
		var emv2PropertyAssociation33 = errorModelSubclause.getProperties().get(32);
		PropertyExpression ownedValue33 = (emv2PropertyAssociation33.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(33.33, ((RealLiteral) ownedValue33).getValue(), 0);
		var emv2PathElement91 = (emv2PropertyAssociation33.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("errorEvent2", emv2PathElement91.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement91, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				postSubcomponentScope);
		Assert.assertNull(emv2PathElement91.getPath());
		var emv2PropertyAssociation34 = errorModelSubclause.getProperties().get(33);
		PropertyExpression ownedValue34 = (emv2PropertyAssociation34.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(34.34, ((RealLiteral) ownedValue34).getValue(), 0);
		var emv2PathElement92 = (emv2PropertyAssociation34.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("errorEvent2", emv2PathElement92.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement92, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				postSubcomponentScope);
		var emv2PathElement52 = emv2PathElement92.getPath();
		Assert.assertEquals("t1", emv2PathElement52.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement52, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("t1", "t2", "t3", "t4", "EMV2PropertyAssociation::t1", "EMV2PropertyAssociation::t2",
						"EMV2PropertyAssociation::t3", "EMV2PropertyAssociation::t4"));
		Assert.assertNull(emv2PathElement52.getPath());
		var emv2PropertyAssociation35 = errorModelSubclause.getProperties().get(34);
		PropertyExpression ownedValue35 = (emv2PropertyAssociation35.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(35.35, ((RealLiteral) ownedValue35).getValue(), 0);
		var emv2PathElement93 = (emv2PropertyAssociation35.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("errorEvent3", emv2PathElement93.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement93, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		Assert.assertNull(emv2PathElement93.getPath());
		var emv2PropertyAssociation36 = errorModelSubclause.getProperties().get(35);
		PropertyExpression ownedValue36 = (emv2PropertyAssociation36.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(36.36, ((RealLiteral) ownedValue36).getValue(), 0);
		var emv2PathElement94 = (emv2PropertyAssociation36.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("errorEvent3", emv2PathElement94.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement94, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		var emv2PathElement53 = emv2PathElement94.getPath();
		Assert.assertEquals("t1", emv2PathElement53.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement53, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("t1", "t2", "t3", "t4", "EMV2PropertyAssociation::t1", "EMV2PropertyAssociation::t2",
						"EMV2PropertyAssociation::t3", "EMV2PropertyAssociation::t4"));
		Assert.assertNull(emv2PathElement53.getPath());
		var emv2PropertyAssociation37 = errorModelSubclause.getProperties().get(36);
		PropertyExpression ownedValue37 = (emv2PropertyAssociation37.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(37.37, ((RealLiteral) ownedValue37).getValue(), 0);
		var emv2PathElement95 = (emv2PropertyAssociation37.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("errorEvent3", emv2PathElement95.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement95, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				postSubcomponentScope);
		Assert.assertNull(emv2PathElement95.getPath());
		var emv2PropertyAssociation38 = errorModelSubclause.getProperties().get(37);
		PropertyExpression ownedValue38 = (emv2PropertyAssociation38.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(38.38, ((RealLiteral) ownedValue38).getValue(), 0);
		var emv2PathElement96 = (emv2PropertyAssociation38.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("errorEvent3", emv2PathElement96.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement96, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				postSubcomponentScope);
		var emv2PathElement54 = emv2PathElement96.getPath();
		Assert.assertEquals("t1", emv2PathElement54.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement54, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("t1", "t2", "t3", "t4", "EMV2PropertyAssociation::t1", "EMV2PropertyAssociation::t2",
						"EMV2PropertyAssociation::t3", "EMV2PropertyAssociation::t4"));
		Assert.assertNull(emv2PathElement54.getPath());
		var emv2PropertyAssociation39 = errorModelSubclause.getProperties().get(38);
		PropertyExpression ownedValue39 = (emv2PropertyAssociation39.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(39.39, ((RealLiteral) ownedValue39).getValue(), 0);
		var emv2PathElement97 = (emv2PropertyAssociation39.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("repairEvent1", emv2PathElement97.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement97, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		Assert.assertNull(emv2PathElement97.getPath());
		var emv2PropertyAssociation40 = errorModelSubclause.getProperties().get(39);
		PropertyExpression ownedValue40 = (emv2PropertyAssociation40.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(40.40, ((RealLiteral) ownedValue40).getValue(), 0);
		var emv2PathElement98 = (emv2PropertyAssociation40.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("repairEvent2", emv2PathElement98.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement98, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				postSubcomponentScope);
		Assert.assertNull(emv2PathElement98.getPath());
		var emv2PropertyAssociation41 = errorModelSubclause.getProperties().get(40);
		PropertyExpression ownedValue41 = (emv2PropertyAssociation41.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(41.41, ((RealLiteral) ownedValue41).getValue(), 0);
		var emv2PathElement99 = (emv2PropertyAssociation41.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("repairEvent3", emv2PathElement99.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement99, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		Assert.assertNull(emv2PathElement99.getPath());
		var emv2PropertyAssociation42 = errorModelSubclause.getProperties().get(41);
		PropertyExpression ownedValue42 = (emv2PropertyAssociation42.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(42.42, ((RealLiteral) ownedValue42).getValue(), 0);
		var emv2PathElement100 = (emv2PropertyAssociation42.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("repairEvent3", emv2PathElement100.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement100, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				postSubcomponentScope);
		Assert.assertNull(emv2PathElement100.getPath());
		var emv2PropertyAssociation43 = errorModelSubclause.getProperties().get(42);
		PropertyExpression ownedValue43 = (emv2PropertyAssociation43.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(43.43, ((RealLiteral) ownedValue43).getValue(), 0);
		var emv2PathElement101 = (emv2PropertyAssociation43.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("recoverEvent1", emv2PathElement101.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement101, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		Assert.assertNull(emv2PathElement101.getPath());
		var emv2PropertyAssociation44 = errorModelSubclause.getProperties().get(43);
		PropertyExpression ownedValue44 = (emv2PropertyAssociation44.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(44.44, ((RealLiteral) ownedValue44).getValue(), 0);
		var emv2PathElement102 = (emv2PropertyAssociation44.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("recoverEvent2", emv2PathElement102.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement102, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				postSubcomponentScope);
		Assert.assertNull(emv2PathElement102.getPath());
		var emv2PropertyAssociation45 = errorModelSubclause.getProperties().get(44);
		PropertyExpression ownedValue45 = (emv2PropertyAssociation45.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(45.45, ((RealLiteral) ownedValue45).getValue(), 0);
		var emv2PathElement103 = (emv2PropertyAssociation45.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("recoverEvent3", emv2PathElement103.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement103, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		Assert.assertNull(emv2PathElement103.getPath());
		var emv2PropertyAssociation46 = errorModelSubclause.getProperties().get(45);
		PropertyExpression ownedValue46 = (emv2PropertyAssociation46.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(46.46, ((RealLiteral) ownedValue46).getValue(), 0);
		var emv2PathElement104 = (emv2PropertyAssociation46.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("recoverEvent3", emv2PathElement104.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement104, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				postSubcomponentScope);
		Assert.assertNull(emv2PathElement104.getPath());
		var emv2PropertyAssociation47 = errorModelSubclause.getProperties().get(46);
		PropertyExpression ownedValue47 = (emv2PropertyAssociation47.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(47.47, ((RealLiteral) ownedValue47).getValue(), 0);
		var emv2PathElement105 = (emv2PropertyAssociation47.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("transition1", emv2PathElement105.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement105, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		Assert.assertNull(emv2PathElement105.getPath());
		var emv2PropertyAssociation48 = errorModelSubclause.getProperties().get(47);
		PropertyExpression ownedValue48 = (emv2PropertyAssociation48.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(48.48, ((RealLiteral) ownedValue48).getValue(), 0);
		var emv2PathElement106 = (emv2PropertyAssociation48.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("transition3", emv2PathElement106.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement106, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		Assert.assertNull(emv2PathElement106.getPath());
		var emv2PropertyAssociation49 = errorModelSubclause.getProperties().get(48);
		PropertyExpression ownedValue49 = (emv2PropertyAssociation49.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(49.49, ((RealLiteral) ownedValue49).getValue(), 0);
		var emv2PathElement107 = (emv2PropertyAssociation49.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("transition2", emv2PathElement107.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement107, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				postSubcomponentScope);
		Assert.assertNull(emv2PathElement107.getPath());
		var emv2PropertyAssociation50 = errorModelSubclause.getProperties().get(49);
		PropertyExpression ownedValue50 = (emv2PropertyAssociation50.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(50.50, ((RealLiteral) ownedValue50).getValue(), 0);
		var emv2PathElement108 = (emv2PropertyAssociation50.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("transition3", emv2PathElement108.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement108, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				postSubcomponentScope);
		Assert.assertNull(emv2PathElement108.getPath());
		var emv2PropertyAssociation51 = errorModelSubclause.getProperties().get(50);
		AssertHelper.assertError(emv2PropertyAssociation51, lib1TestResult.getIssues(), lib1IssueCollection,
				"Property EMV2::ExposurePeriod does not apply to outgoingPropagationCondition1");
		PropertyExpression ownedValue51 = (emv2PropertyAssociation51.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(51.51, ((RealLiteral) ownedValue51).getValue(), 0);
		var emv2PathElement109 = (emv2PropertyAssociation51.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("outgoingPropagationCondition1", emv2PathElement109.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement109, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		Assert.assertNull(emv2PathElement109.getPath());
		var emv2PropertyAssociation52 = errorModelSubclause.getProperties().get(51);
		PropertyExpression ownedValue52 = (emv2PropertyAssociation52.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(52.52, ((RealLiteral) ownedValue52).getValue(), 0);
		var emv2PathElement110 = (emv2PropertyAssociation52.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("outgoingPropagationCondition2", emv2PathElement110.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement110, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				postSubcomponentScope);
		Assert.assertNull(emv2PathElement110.getPath());
		var emv2PropertyAssociation53 = errorModelSubclause.getProperties().get(52);
		AssertHelper.assertError(emv2PropertyAssociation53, lib1TestResult.getIssues(), lib1IssueCollection,
				"Property EMV2::ExposurePeriod does not apply to detection1");
		PropertyExpression ownedValue53 = (emv2PropertyAssociation53.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(53.53, ((RealLiteral) ownedValue53).getValue(), 0);
		var emv2PathElement111 = (emv2PropertyAssociation53.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("detection1", emv2PathElement111.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement111, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		Assert.assertNull(emv2PathElement111.getPath());
		var emv2PropertyAssociation54 = errorModelSubclause.getProperties().get(53);
		PropertyExpression ownedValue54 = (emv2PropertyAssociation54.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals("54", ((StringLiteral) ownedValue54).getValue());
		var emv2PathElement112 = (emv2PropertyAssociation54.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("detection2", emv2PathElement112.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement112, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				postSubcomponentScope);
		Assert.assertNull(emv2PathElement112.getPath());
		var emv2PropertyAssociation55 = errorModelSubclause.getProperties().get(54);
		AssertHelper.assertError(emv2PropertyAssociation55, lib1TestResult.getIssues(), lib1IssueCollection,
				"Property EMV2::ExposurePeriod does not apply to compositeState1");
		PropertyExpression ownedValue55 = (emv2PropertyAssociation55.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(55.55, ((RealLiteral) ownedValue55).getValue(), 0);
		var emv2PathElement113 = (emv2PropertyAssociation55.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("compositeState1", emv2PathElement113.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement113, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		Assert.assertNull(emv2PathElement113.getPath());
		var emv2PropertyAssociation56 = errorModelSubclause.getProperties().get(55);
		PropertyExpression ownedValue56 = (emv2PropertyAssociation56.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(56.56, ((RealLiteral) ownedValue56).getValue(), 0);
		var emv2PathElement114 = (emv2PropertyAssociation56.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("compositeState2", emv2PathElement114.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement114, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				postSubcomponentScope);
		Assert.assertNull(emv2PathElement114.getPath());
		var emv2PropertyAssociation57 = errorModelSubclause.getProperties().get(56);
		PropertyExpression ownedValue57 = (emv2PropertyAssociation57.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(57.57, ((RealLiteral) ownedValue57).getValue(), 0);
		var emv2PathElement115 = (emv2PropertyAssociation57.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("connectionErrorSource1", emv2PathElement115.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement115, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		Assert.assertNull(emv2PathElement115.getPath());
		var emv2PropertyAssociation58 = errorModelSubclause.getProperties().get(57);
		PropertyExpression ownedValue58 = (emv2PropertyAssociation58.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(58.58, ((RealLiteral) ownedValue58).getValue(), 0);
		var emv2PathElement116 = (emv2PropertyAssociation58.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("connectionErrorSource1", emv2PathElement116.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement116, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		var emv2PathElement55 = emv2PathElement116.getPath();
		Assert.assertEquals("t1", emv2PathElement55.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement55, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("t1", "t2", "t3", "t4", "EMV2PropertyAssociation::t1", "EMV2PropertyAssociation::t2",
						"EMV2PropertyAssociation::t3", "EMV2PropertyAssociation::t4"));
		Assert.assertNull(emv2PathElement55.getPath());
		var emv2PropertyAssociation59 = errorModelSubclause.getProperties().get(58);
		PropertyExpression ownedValue59 = (emv2PropertyAssociation59.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(59.59, ((RealLiteral) ownedValue59).getValue(), 0);
		var emv2PathElement117 = (emv2PropertyAssociation59.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("connectionErrorSource2", emv2PathElement117.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement117, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				postSubcomponentScope);
		Assert.assertNull(emv2PathElement117.getPath());
		var emv2PropertyAssociation60 = errorModelSubclause.getProperties().get(59);
		PropertyExpression ownedValue60 = (emv2PropertyAssociation60.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(60.60, ((RealLiteral) ownedValue60).getValue(), 0);
		var emv2PathElement118 = (emv2PropertyAssociation60.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("connectionErrorSource2", emv2PathElement118.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement118, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				postSubcomponentScope);
		var emv2PathElement56 = emv2PathElement118.getPath();
		Assert.assertEquals("t1", emv2PathElement56.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement56, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("t1", "t2", "t3", "t4", "EMV2PropertyAssociation::t1", "EMV2PropertyAssociation::t2",
						"EMV2PropertyAssociation::t3", "EMV2PropertyAssociation::t4"));
		Assert.assertNull(emv2PathElement56.getPath());
		var emv2PropertyAssociation61 = errorModelSubclause.getProperties().get(60);
		AssertHelper.assertError(emv2PropertyAssociation61, lib1TestResult.getIssues(), lib1IssueCollection,
				"Property EMV2::ExposurePeriod does not apply to propagationPath1");
		PropertyExpression ownedValue61 = (emv2PropertyAssociation61.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(61.61, ((RealLiteral) ownedValue61).getValue(), 0);
		var emv2PathElement119 = (emv2PropertyAssociation61.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("propagationPath1", emv2PathElement119.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement119, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		Assert.assertNull(emv2PathElement119.getPath());
		var emv2PropertyAssociation62 = errorModelSubclause.getProperties().get(61);
		PropertyExpression ownedValue62 = (emv2PropertyAssociation62.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(62.62, ((RealLiteral) ownedValue62).getValue(), 0);
		var emv2PathElement120 = (emv2PropertyAssociation62.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("propagationPath2", emv2PathElement120.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement120, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				postSubcomponentScope);
		Assert.assertNull(emv2PathElement120.getPath());
		var emv2PropertyAssociation63 = errorModelSubclause.getProperties().get(62);
		PropertyExpression ownedValue63 = (emv2PropertyAssociation63.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(63.63, ((RealLiteral) ownedValue63).getValue(), 0);
		var emv2PathElement121 = (emv2PropertyAssociation63.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("state1", emv2PathElement121.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement121, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		Assert.assertNull(emv2PathElement121.getPath());
		var emv2PropertyAssociation64 = errorModelSubclause.getProperties().get(63);
		PropertyExpression ownedValue64 = (emv2PropertyAssociation64.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(64.64, ((RealLiteral) ownedValue64).getValue(), 0);
		var emv2PathElement122 = (emv2PropertyAssociation64.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("state1", emv2PathElement122.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement122, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				firstElementScope);
		var emv2PathElement57 = emv2PathElement122.getPath();
		Assert.assertEquals("t1", emv2PathElement57.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement57, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("t1", "t2", "t3", "t4", "EMV2PropertyAssociation::t1", "EMV2PropertyAssociation::t2",
						"EMV2PropertyAssociation::t3", "EMV2PropertyAssociation::t4"));
		Assert.assertNull(emv2PathElement57.getPath());
		var emv2PropertyAssociation65 = errorModelSubclause.getProperties().get(64);
		PropertyExpression ownedValue65 = (emv2PropertyAssociation65.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(65.65, ((RealLiteral) ownedValue65).getValue(), 0);
		var emv2PathElement123 = (emv2PropertyAssociation65.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("state1", emv2PathElement123.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement123, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				postSubcomponentScope);
		Assert.assertNull(emv2PathElement123.getPath());
		var emv2PropertyAssociation66 = errorModelSubclause.getProperties().get(65);
		PropertyExpression ownedValue66 = (emv2PropertyAssociation66.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(66.66, ((RealLiteral) ownedValue66).getValue(), 0);
		var emv2PathElement124 = (emv2PropertyAssociation66.getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("state1", emv2PathElement124.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement124, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				postSubcomponentScope);
		var emv2PathElement58 = emv2PathElement124.getPath();
		Assert.assertEquals("t1", emv2PathElement58.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement58, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("t1", "t2", "t3", "t4", "EMV2PropertyAssociation::t1", "EMV2PropertyAssociation::t2",
						"EMV2PropertyAssociation::t3", "EMV2PropertyAssociation::t4"));
		Assert.assertNull(emv2PathElement58.getPath());

		lib1IssueCollection.sizeIs(lib1IssueCollection.getIssues().size());
		this.assertConstraints(lib1IssueCollection);

	}
}
