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

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider;
import org.osate.testsupport.AssertHelper;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.errormodel.errorModel.CompositeState;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorFlow;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorStateToModeMapping;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeMappingSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeTransformationSet;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * Verifies error-type and type-set scopes across imported and extended EMV2 libraries.
 */
@RunWith(XtextRunner.class)
@InjectWith(ErrorModelInjectorProvider.class)
public class ErrorTypesTest extends XtextTest {
	@Inject
	private TestHelper<AadlPackage> testHelper;
	private AssertHelper assertHelper = IResourceServiceProvider.Registry.INSTANCE
			.getResourceServiceProvider(URI.createFileURI("dummy.emv2")).<AssertHelper>get(AssertHelper.class);

	/**
	 * Tests scope_ErrorType, scope_TypeSet_aliasedType, scope_TypeToken_type(ErrorModelLibrary, EReference),
	 * scope_TypeToken_type(ErrorBehaviorStateMachine, EReference), scope_TypeToken_type(TypeMappingSet, EReference),
	 * scope_TypeToken_type(TypeTransformationSet, EReference), and scope_TypeToken_type(ErrorModelSubclause, EReference)
	 */
	@Test
	public void testErrorTypesReference() throws Exception {
		var lib1 = """
				package lib1
				public
				\tannex EMV2 {**
				\t\terror types
				\t\t\tt1: type;
				\t\t\tconflict1: type;
				\t\t\tconflict2: type;
				\t\t\t
				\t\t\tts1: type set {t1};
				\t\t\tconflict_ts1: type set {t1};
				\t\t\tconflict_ts2: type set {t1};
				\t\tend types;
				\t**};
				end lib1;
				""";
		var lib2 = """
				package lib2
				public
				\tannex EMV2 {**
				\t\terror types extends lib1 with
				\t\t\tt2: type;
				\t\t\t
				\t\t\tts2: type set {t2};
				\t\tend types;
				\t**};
				end lib2;
				""";
		var lib3 = """
				package lib3
				public
				\tannex EMV2 {**
				\t\terror types
				\t\t\tt3: type;
				\t\t\tconflict1: type;
				\t\t\t
				\t\t\tts3: type set {t3};
				\t\t\tconflict_ts1: type set {t3};
				\t\tend types;
				\t**};
				end lib3;
				""";
		var lib4 = """
				package lib4
				public
				\tannex EMV2 {**
				\t\terror types extends lib3 with
				\t\t\tt4: type;
				\t\t\t
				\t\t\tts4: type set {t4};
				\t\tend types;
				\t**};
				end lib4;
				""";
		var lib5 = """
				package lib5
				public
				\tannex EMV2 {**
				\t\terror types extends lib1 with
				\t\tend types;
				\t**};
				end lib5;
				""";
		var lib6 = """
				package lib6
				public
				\tannex EMV2 {**
				\t\terror types
				\t\t\tuse types lib2, lib5;
				\t\t\textends lib4 with
				\t\t\t
				\t\t\tconflict2: type;
				\t\t\tt6: type;
				\t\t\t
				\t\t\tconflict_ts2: type set {t6};
				\t\t\tts6: type set {t6};
				\t\tend types;
				\t\t
				\t\terror behavior bvr1 use types lib2, lib5, lib6;
				\t\tevents
				\t\t\terr_evt1: error event {t1, ts2};
				\t\tstates
				\t\t\tbvr_state1: state {t1, ts2};
				\t\t\tbvr_state2: state {t2};
				\t\ttransitions
				\t\t\ttransition1: bvr_state1 {t1} -[ err_evt1 {t1} ]-> bvr_state2 {t2};
				\t\t\ttransition2: bvr_state1 -[ err_evt1 ]-> (bvr_state2 {t2} with 0.2, bvr_state2 {ts2} with 0.8);
				\t\tend behavior;
				\t\t
				\t\ttype mappings mappings1 use types lib2, lib5, lib6;
				\t\t\t{t1} -> {t2};
				\t\tend mappings;
				\t\t
				\t\ttype transformations transformation1 use types lib2, lib5, lib6;
				\t\t\t{t1} -[ ]-> {t2};
				\t\tend transformations;
				\t**};
				end lib6;
				""";
		var subclause1 = """
				package subclause1
				public
				\tabstract a1
				\tannex EMV2 {**
				\t\tuse behavior lib6::bvr1;
				\t**};
				\tend a1;
				\t
				\tabstract a2
				\tfeatures
				\t\tep1: in event port;
				\tmodes
				\t\tm1: mode;
				\tend a2;
				\t
				\tabstract implementation a2.i
				\tsubcomponents
				\t\tasub1: abstract a1;
				\tannex EMV2 {**
				\t\tuse types lib2, lib5, lib6;
				\t\tuse behavior lib6::bvr1;
				\t\t
				\t\terror propagations
				\t\t\tprocessor: in propagation {t1};
				\t\tflows
				\t\t\terrSource1: error source all {t1} when {t1};
				\t\t\terrSource2: error source all {t1} when {ts1};
				\t\t\terrSink1: error sink all {t1};
				\t\t\terrPath1: error path all {t1} -> all {t1};
				\t\tend propagations;
				\t\t
				\t\tcomponent error behavior
				\t\tevents
				\t\t\terrEvent1: error event {t1};
				\t\ttransitions
				\t\t\terrBvrTransition1: bvr_state1 {t1} -[ errEvent1 {t1} ]-> bvr_state2 {t2};
				\t\t\terrBvrTransition2: bvr_state1 -[ errEvent1 ]-> (bvr_state2 {t2} with 0.2, bvr_state2 {t2} with 0.8);
				\t\tpropagations
				\t\t\tpropCondition1: bvr_state1 {t1} -[ processor {t1} ]-> all {t1};
				\t\tdetections
				\t\t\tdetection1: bvr_state1 {t1} -[ errEvent1 {t1} ]-> ep1!;
				\t\tmode mappings
				\t\t\tbvr_state1 {t1} in modes (m1);
				\t\tend component;
				\t\t
				\t\tcomposite error behavior states
				\t\t\tcompositeState1: [asub1.bvr_state1 {t1}]-> bvr_state2 {t1};
				\t\t\tcompositeState2: [in processor {t1}]-> bvr_state2 {t1};
				\t\tend composite;
				\t\t
				\t\tconnection error
				\t\t\tconnErrSource1: error source all {t1} when {t1};
				\t\tend connection;
				\t**};
				\tend a2.i;
				end subclause1;
				""";
		final AadlPackage pkg1 = this.testHelper.parseString(lib1, lib2, lib3, lib4, lib5, lib6);
		Assert.assertEquals("lib1", pkg1.getName());
		var errorModelLibrary = ((ErrorModelLibrary) ((DefaultAnnexLibrary) (pkg1.getPublicSection()
				.getOwnedAnnexLibraries()).getFirst()).getParsedAnnexLibrary());
		final List<String> expectedTypeScope = List.of("conflict1", "conflict2", "t1", "lib1::conflict1",
				"lib1::conflict2", "lib1::t1", "lib2::conflict1", "lib2::conflict2", "lib2::t1", "lib2::t2",
				"lib3::conflict1", "lib3::t3", "lib4::conflict1", "lib4::t3", "lib4::t4", "lib5::conflict1",
				"lib5::conflict2", "lib5::t1", "lib6::conflict1", "lib6::conflict2", "lib6::t3", "lib6::t4",
				"lib6::t6");
		var errorType = errorModelLibrary.getTypes().get(0);
		Assert.assertEquals("t1", errorType.getName());
		this.assertHelper.assertScope(errorType, ErrorModelPackage.eINSTANCE.getErrorType_SuperType(),
				expectedTypeScope);
		this.assertHelper.assertScope(errorType, ErrorModelPackage.eINSTANCE.getErrorType_AliasedType(),
				expectedTypeScope);
		var errorType2 = errorModelLibrary.getTypes().get(1);
		Assert.assertEquals("conflict1", errorType2.getName());
		this.assertHelper.assertScope(errorType2, ErrorModelPackage.eINSTANCE.getErrorType_SuperType(),
				expectedTypeScope);
		this.assertHelper.assertScope(errorType2, ErrorModelPackage.eINSTANCE.getErrorType_AliasedType(),
				expectedTypeScope);
		var errorType3 = errorModelLibrary.getTypes().get(2);
		Assert.assertEquals("conflict2", errorType3.getName());
		this.assertHelper.assertScope(errorType3, ErrorModelPackage.eINSTANCE.getErrorType_SuperType(),
				expectedTypeScope);
		this.assertHelper.assertScope(errorType3, ErrorModelPackage.eINSTANCE.getErrorType_AliasedType(),
				expectedTypeScope);
		final List<String> expectedTypeSetScope = List.of("conflict_ts1", "conflict_ts2", "ts1", "lib1::conflict_ts1",
				"lib1::conflict_ts2", "lib1::ts1", "lib2::conflict_ts1", "lib2::conflict_ts2", "lib2::ts1", "lib2::ts2",
				"lib3::conflict_ts1", "lib3::ts3", "lib4::conflict_ts1", "lib4::ts3", "lib4::ts4", "lib5::conflict_ts1",
				"lib5::conflict_ts2", "lib5::ts1", "lib6::conflict_ts1", "lib6::conflict_ts2", "lib6::ts3", "lib6::ts4",
				"lib6::ts6");
		var typeSet5 = errorModelLibrary.getTypesets().get(0);
		Assert.assertEquals("ts1", typeSet5.getName());
		this.assertHelper.assertScope(typeSet5, ErrorModelPackage.eINSTANCE.getTypeSet_AliasedType(),
				expectedTypeSetScope);
		this.assertHelper.assertScope(typeSet5.getTypeTokens().getFirst(),
				ErrorModelPackage.eINSTANCE.getTypeToken_Type(),
				Iterables.<String>concat(expectedTypeScope, expectedTypeSetScope));
		var typeSet6 = errorModelLibrary.getTypesets().get(1);
		Assert.assertEquals("conflict_ts1", typeSet6.getName());
		this.assertHelper.assertScope(typeSet6, ErrorModelPackage.eINSTANCE.getTypeSet_AliasedType(),
				expectedTypeSetScope);
		this.assertHelper.assertScope(typeSet6.getTypeTokens().getFirst(),
				ErrorModelPackage.eINSTANCE.getTypeToken_Type(),
				Iterables.<String>concat(expectedTypeScope, expectedTypeSetScope));
		var typeSet7 = errorModelLibrary.getTypesets().get(2);
		Assert.assertEquals("conflict_ts2", typeSet7.getName());
		this.assertHelper.assertScope(typeSet7, ErrorModelPackage.eINSTANCE.getTypeSet_AliasedType(),
				expectedTypeSetScope);
		this.assertHelper.assertScope(typeSet7.getTypeTokens().getFirst(),
				ErrorModelPackage.eINSTANCE.getTypeToken_Type(),
				Iterables.<String>concat(expectedTypeScope, expectedTypeSetScope));

		final AadlPackage pkg2 = this.testHelper.parseString(lib2, lib1, lib3, lib4, lib5, lib6);
		Assert.assertEquals("lib2", pkg2.getName());
		var errorModelLibrary2 = ((ErrorModelLibrary) ((DefaultAnnexLibrary) (pkg2.getPublicSection()
				.getOwnedAnnexLibraries()).getFirst()).getParsedAnnexLibrary());
		var typeToken2 = (errorModelLibrary2.getTypes()).getFirst();
		Assert.assertEquals("t2", typeToken2.getName());
		final List<String> expectedTypeScope2 = List.of("conflict1", "conflict2", "t1", "t2", "lib1::conflict1",
				"lib1::conflict2", "lib1::t1", "lib2::conflict1", "lib2::conflict2", "lib2::t1", "lib2::t2",
				"lib3::conflict1", "lib3::t3", "lib4::conflict1", "lib4::t3", "lib4::t4", "lib5::conflict1",
				"lib5::conflict2", "lib5::t1", "lib6::conflict1", "lib6::conflict2", "lib6::t3", "lib6::t4",
				"lib6::t6");
		this.assertHelper.assertScope(typeToken2, ErrorModelPackage.eINSTANCE.getErrorType_SuperType(),
				expectedTypeScope2);
		this.assertHelper.assertScope(typeToken2, ErrorModelPackage.eINSTANCE.getErrorType_AliasedType(),
				expectedTypeScope2);
		var typeSet8 = (errorModelLibrary2.getTypesets()).getFirst();
		Assert.assertEquals("ts2", typeSet8.getName());
		this.assertHelper.assertScope(typeSet8, ErrorModelPackage.eINSTANCE.getTypeSet_AliasedType(),
				List.of("conflict_ts1", "conflict_ts2", "ts1", "ts2", "lib1::conflict_ts1", "lib1::conflict_ts2",
						"lib1::ts1", "lib2::conflict_ts1", "lib2::conflict_ts2", "lib2::ts1", "lib2::ts2",
						"lib3::conflict_ts1", "lib3::ts3", "lib4::conflict_ts1", "lib4::ts3", "lib4::ts4",
						"lib5::conflict_ts1", "lib5::conflict_ts2", "lib5::ts1", "lib6::conflict_ts1",
						"lib6::conflict_ts2", "lib6::ts3", "lib6::ts4", "lib6::ts6"));
		this.assertHelper.assertScope((typeSet8.getTypeTokens()).getFirst(),
				ErrorModelPackage.eINSTANCE.getTypeToken_Type(),
				List.of("conflict1", "conflict2", "conflict_ts1", "conflict_ts2", "t1", "t2", "ts1", "ts2",
						"lib1::conflict1", "lib1::conflict2", "lib1::conflict_ts1", "lib1::conflict_ts2", "lib1::t1",
						"lib1::ts1", "lib2::conflict1", "lib2::conflict2", "lib2::conflict_ts1", "lib2::conflict_ts2",
						"lib2::t1", "lib2::t2", "lib2::ts1", "lib2::ts2", "lib3::conflict1", "lib3::conflict_ts1",
						"lib3::t3", "lib3::ts3", "lib4::conflict1", "lib4::conflict_ts1", "lib4::t3", "lib4::t4",
						"lib4::ts3", "lib4::ts4", "lib5::conflict1", "lib5::conflict2", "lib5::conflict_ts1",
						"lib5::conflict_ts2", "lib5::t1", "lib5::ts1", "lib6::conflict1", "lib6::conflict2",
						"lib6::conflict_ts1", "lib6::conflict_ts2", "lib6::t3", "lib6::t4", "lib6::t6", "lib6::ts3",
						"lib6::ts4", "lib6::ts6"));

		final AadlPackage pkg3 = this.testHelper.parseString(lib3, lib1, lib2, lib4, lib5, lib6);
		Assert.assertEquals("lib3", pkg3.getName());
		var errorModelLibrary3 = ((ErrorModelLibrary) ((DefaultAnnexLibrary) (pkg3.getPublicSection()
				.getOwnedAnnexLibraries()).getFirst()).getParsedAnnexLibrary());
		final List<String> expectedTypeScope3 = List.of("conflict1", "t3", "lib1::conflict1", "lib1::conflict2",
				"lib1::t1", "lib2::conflict1", "lib2::conflict2", "lib2::t1", "lib2::t2", "lib3::conflict1", "lib3::t3",
				"lib4::conflict1", "lib4::t3", "lib4::t4", "lib5::conflict1", "lib5::conflict2", "lib5::t1",
				"lib6::conflict1", "lib6::conflict2", "lib6::t3", "lib6::t4", "lib6::t6");
		var errorType4 = errorModelLibrary3.getTypes().get(0);
		Assert.assertEquals("t3", errorType4.getName());
		this.assertHelper.assertScope(errorType4, ErrorModelPackage.eINSTANCE.getErrorType_SuperType(),
				expectedTypeScope3);
		this.assertHelper.assertScope(errorType4, ErrorModelPackage.eINSTANCE.getErrorType_AliasedType(),
				expectedTypeScope3);
		var errorType5 = errorModelLibrary3.getTypes().get(1);
		Assert.assertEquals("conflict1", errorType5.getName());
		this.assertHelper.assertScope(errorType5, ErrorModelPackage.eINSTANCE.getErrorType_SuperType(),
				expectedTypeScope3);
		this.assertHelper.assertScope(errorType5, ErrorModelPackage.eINSTANCE.getErrorType_AliasedType(),
				expectedTypeScope3);
		final List<String> expectedTypeSetScope2 = List.of("conflict_ts1", "ts3", "lib1::conflict_ts1",
				"lib1::conflict_ts2", "lib1::ts1", "lib2::conflict_ts1", "lib2::conflict_ts2", "lib2::ts1", "lib2::ts2",
				"lib3::conflict_ts1", "lib3::ts3", "lib4::conflict_ts1", "lib4::ts3", "lib4::ts4", "lib5::conflict_ts1",
				"lib5::conflict_ts2", "lib5::ts1", "lib6::conflict_ts1", "lib6::conflict_ts2", "lib6::ts3", "lib6::ts4",
				"lib6::ts6");
		var inheritedTypeSet = errorModelLibrary3.getTypesets().get(0);
		Assert.assertEquals("ts3", inheritedTypeSet.getName());
		this.assertHelper.assertScope(inheritedTypeSet, ErrorModelPackage.eINSTANCE.getTypeSet_AliasedType(),
				expectedTypeSetScope2);
		this.assertHelper.assertScope(inheritedTypeSet.getTypeTokens().getFirst(),
				ErrorModelPackage.eINSTANCE.getTypeToken_Type(),
				Iterables.<String>concat(expectedTypeScope3, expectedTypeSetScope2));
		var typeSet9 = errorModelLibrary3.getTypesets().get(1);
		Assert.assertEquals("conflict_ts1", typeSet9.getName());
		this.assertHelper.assertScope(typeSet9, ErrorModelPackage.eINSTANCE.getTypeSet_AliasedType(),
				expectedTypeSetScope2);
		this.assertHelper.assertScope(typeSet9.getTypeTokens().getFirst(),
				ErrorModelPackage.eINSTANCE.getTypeToken_Type(),
				Iterables.<String>concat(expectedTypeScope3, expectedTypeSetScope2));

		final AadlPackage pkg4 = this.testHelper.parseString(lib4, lib1, lib2, lib3, lib5, lib6);
		Assert.assertEquals("lib4", pkg4.getName());
		var errorModelLibrary4 = ((ErrorModelLibrary) ((DefaultAnnexLibrary) (pkg4.getPublicSection()
				.getOwnedAnnexLibraries()).getFirst()).getParsedAnnexLibrary());
		var typeToken3 = (errorModelLibrary4.getTypes()).getFirst();
		Assert.assertEquals("t4", typeToken3.getName());
		final List<String> expectedTypeScope4 = List.of("conflict1", "t3", "t4", "lib1::conflict1", "lib1::conflict2",
				"lib1::t1", "lib2::conflict1", "lib2::conflict2", "lib2::t1", "lib2::t2", "lib3::conflict1", "lib3::t3",
				"lib4::conflict1", "lib4::t3", "lib4::t4", "lib5::conflict1", "lib5::conflict2", "lib5::t1",
				"lib6::conflict1", "lib6::conflict2", "lib6::t3", "lib6::t4", "lib6::t6");
		this.assertHelper.assertScope(typeToken3, ErrorModelPackage.eINSTANCE.getErrorType_SuperType(),
				expectedTypeScope4);
		this.assertHelper.assertScope(typeToken3, ErrorModelPackage.eINSTANCE.getErrorType_AliasedType(),
				expectedTypeScope4);
		var typeSet10 = (errorModelLibrary4.getTypesets()).getFirst();
		Assert.assertEquals("ts4", typeSet10.getName());
		this.assertHelper.assertScope(typeSet10, ErrorModelPackage.eINSTANCE.getTypeSet_AliasedType(),
				List.of("conflict_ts1", "ts3", "ts4", "lib1::conflict_ts1", "lib1::conflict_ts2", "lib1::ts1",
						"lib2::conflict_ts1", "lib2::conflict_ts2", "lib2::ts1", "lib2::ts2", "lib3::conflict_ts1",
						"lib3::ts3", "lib4::conflict_ts1", "lib4::ts3", "lib4::ts4", "lib5::conflict_ts1",
						"lib5::conflict_ts2", "lib5::ts1", "lib6::conflict_ts1", "lib6::conflict_ts2", "lib6::ts3",
						"lib6::ts4", "lib6::ts6"));
		this.assertHelper.assertScope((typeSet10.getTypeTokens()).getFirst(),
				ErrorModelPackage.eINSTANCE.getTypeToken_Type(),
				List.of("conflict1", "conflict_ts1", "t3", "t4", "ts3", "ts4", "lib1::conflict1", "lib1::conflict2",
						"lib1::conflict_ts1", "lib1::conflict_ts2", "lib1::t1", "lib1::ts1", "lib2::conflict1",
						"lib2::conflict2", "lib2::conflict_ts1", "lib2::conflict_ts2", "lib2::t1", "lib2::t2",
						"lib2::ts1", "lib2::ts2", "lib3::conflict1", "lib3::conflict_ts1", "lib3::t3", "lib3::ts3",
						"lib4::conflict1", "lib4::conflict_ts1", "lib4::t3", "lib4::t4", "lib4::ts3", "lib4::ts4",
						"lib5::conflict1", "lib5::conflict2", "lib5::conflict_ts1", "lib5::conflict_ts2", "lib5::t1",
						"lib5::ts1", "lib6::conflict1", "lib6::conflict2", "lib6::conflict_ts1", "lib6::conflict_ts2",
						"lib6::t3", "lib6::t4", "lib6::t6", "lib6::ts3", "lib6::ts4", "lib6::ts6"));

		final AadlPackage pkg5 = this.testHelper.parseString(lib6, lib5, lib4, lib3, lib2, lib1);
		Assert.assertEquals("lib6", pkg5.getName());
		var errorModelLibrary5 = ((ErrorModelLibrary) ((DefaultAnnexLibrary) (pkg5.getPublicSection()
				.getOwnedAnnexLibraries()).getFirst()).getParsedAnnexLibrary());
		final List<String> expectedTypeScope5 = List.of("conflict1", "conflict2", "t1", "t2", "t3", "t4", "t6",
				"lib1::conflict1", "lib1::conflict2", "lib1::t1", "lib2::conflict1", "lib2::conflict2", "lib2::t1",
				"lib2::t2", "lib3::conflict1", "lib3::t3", "lib4::conflict1", "lib4::t3", "lib4::t4", "lib5::conflict1",
				"lib5::conflict2", "lib5::t1", "lib6::conflict1", "lib6::conflict2", "lib6::t3", "lib6::t4",
				"lib6::t6");
		var errorType7 = errorModelLibrary5.getTypes().get(0);
		Assert.assertEquals("conflict2", errorType7.getName());
		this.assertHelper.assertScope(errorType7, ErrorModelPackage.eINSTANCE.getErrorType_SuperType(),
				expectedTypeScope5);
		this.assertHelper.assertScope(errorType7, ErrorModelPackage.eINSTANCE.getErrorType_AliasedType(),
				expectedTypeScope5);
		var errorType8 = errorModelLibrary5.getTypes().get(1);
		Assert.assertEquals("t6", errorType8.getName());
		this.assertHelper.assertScope(errorType8, ErrorModelPackage.eINSTANCE.getErrorType_SuperType(),
				expectedTypeScope5);
		this.assertHelper.assertScope(errorType8, ErrorModelPackage.eINSTANCE.getErrorType_AliasedType(),
				expectedTypeScope5);
		final List<String> expectedTypeSetScope3 = List.of("conflict_ts1", "conflict_ts2", "ts1", "ts2", "ts3", "ts4",
				"ts6", "lib1::conflict_ts1", "lib1::conflict_ts2", "lib1::ts1", "lib2::conflict_ts1",
				"lib2::conflict_ts2", "lib2::ts1", "lib2::ts2", "lib3::conflict_ts1", "lib3::ts3", "lib4::conflict_ts1",
				"lib4::ts3", "lib4::ts4", "lib5::conflict_ts1", "lib5::conflict_ts2", "lib5::ts1", "lib6::conflict_ts1",
				"lib6::conflict_ts2", "lib6::ts3", "lib6::ts4", "lib6::ts6");
		var conflictingTypeSet = errorModelLibrary5.getTypesets().get(0);
		Assert.assertEquals("conflict_ts2", conflictingTypeSet.getName());
		this.assertHelper.assertScope(conflictingTypeSet, ErrorModelPackage.eINSTANCE.getTypeSet_AliasedType(),
				expectedTypeSetScope3);
		this.assertHelper.assertScope(conflictingTypeSet.getTypeTokens().getFirst(),
				ErrorModelPackage.eINSTANCE.getTypeToken_Type(),
				Iterables.<String>concat(expectedTypeScope5, expectedTypeSetScope3));
		var typeSet11 = errorModelLibrary5.getTypesets().get(1);
		Assert.assertEquals("ts6", typeSet11.getName());
		this.assertHelper.assertScope(typeSet11, ErrorModelPackage.eINSTANCE.getTypeSet_AliasedType(),
				expectedTypeSetScope3);
		this.assertHelper.assertScope(typeSet11.getTypeTokens().getFirst(),
				ErrorModelPackage.eINSTANCE.getTypeToken_Type(),
				Iterables.<String>concat(expectedTypeScope5, expectedTypeSetScope3));
		final List<String> expectedTypeTokenScope = List.of("t1", "t2", "t3", "t4", "t6", "ts1", "ts2", "ts3", "ts4",
				"ts6", "lib1::conflict1", "lib1::conflict2", "lib1::conflict_ts1", "lib1::conflict_ts2", "lib1::t1",
				"lib1::ts1", "lib2::conflict1", "lib2::conflict2", "lib2::conflict_ts1", "lib2::conflict_ts2",
				"lib2::t1", "lib2::t2", "lib2::ts1", "lib2::ts2", "lib3::conflict1", "lib3::conflict_ts1", "lib3::t3",
				"lib3::ts3", "lib4::conflict1", "lib4::conflict_ts1", "lib4::t3", "lib4::t4", "lib4::ts3", "lib4::ts4",
				"lib5::conflict1", "lib5::conflict2", "lib5::conflict_ts1", "lib5::conflict_ts2", "lib5::t1",
				"lib5::ts1", "lib6::conflict1", "lib6::conflict2", "lib6::conflict_ts1", "lib6::conflict_ts2",
				"lib6::t3", "lib6::t4", "lib6::t6", "lib6::ts3", "lib6::ts4", "lib6::ts6");
		var typeToken4 = (errorModelLibrary5.getBehaviors()).getFirst();
		Assert.assertEquals("bvr1", typeToken4.getName());
		var errorEvent = ((ErrorEvent) (typeToken4.getEvents()).getFirst());
		Assert.assertEquals("err_evt1", errorEvent.getName());
		this.assertHelper.assertScope(errorEvent.getTypeSet().getTypeTokens().get(0),
				ErrorModelPackage.eINSTANCE.getTypeToken_Type(), expectedTypeTokenScope);
		this.assertHelper.assertScope(errorEvent.getTypeSet().getTypeTokens().get(1),
				ErrorModelPackage.eINSTANCE.getTypeToken_Type(), expectedTypeTokenScope);
		var typeSet = typeToken4.getStates().get(0);
		Assert.assertEquals("bvr_state1", typeSet.getName());
		this.assertHelper.assertScope(typeSet.getTypeSet().getTypeTokens().get(0),
				ErrorModelPackage.eINSTANCE.getTypeToken_Type(), expectedTypeTokenScope);
		this.assertHelper.assertScope(typeSet.getTypeSet().getTypeTokens().get(1),
				ErrorModelPackage.eINSTANCE.getTypeToken_Type(), expectedTypeTokenScope);
		var typeSet2 = typeToken4.getStates().get(1);
		Assert.assertEquals("bvr_state2", typeSet2.getName());
		this.assertHelper.assertScope((typeSet2.getTypeSet().getTypeTokens()).getFirst(),
				ErrorModelPackage.eINSTANCE.getTypeToken_Type(), expectedTypeTokenScope);
		var errorBehaviorTransition = typeToken4.getTransitions().get(0);
		Assert.assertEquals("transition1", errorBehaviorTransition.getName());
		this.assertHelper.assertScope((errorBehaviorTransition.getTypeTokenConstraint().getTypeTokens()).getFirst(),
				ErrorModelPackage.eINSTANCE.getTypeToken_Type(), expectedTypeTokenScope);
		this.assertHelper.assertScope(
				(((ConditionElement) errorBehaviorTransition.getCondition()).getConstraint().getTypeTokens())
						.getFirst(),
				ErrorModelPackage.eINSTANCE.getTypeToken_Type(), expectedTypeTokenScope);
		this.assertHelper.assertScope(errorBehaviorTransition.getTargetToken(),
				ErrorModelPackage.eINSTANCE.getTypeToken_Type(), expectedTypeTokenScope);
		var errorBehaviorTransition2 = typeToken4.getTransitions().get(1);
		Assert.assertEquals("transition2", errorBehaviorTransition2.getName());
		this.assertHelper.assertScope(errorBehaviorTransition2.getDestinationBranches().get(0).getTargetToken(),
				ErrorModelPackage.eINSTANCE.getTypeToken_Type(), expectedTypeTokenScope);
		this.assertHelper.assertScope(errorBehaviorTransition2.getDestinationBranches().get(1).getTargetToken(),
				ErrorModelPackage.eINSTANCE.getTypeToken_Type(), expectedTypeTokenScope);
		var typeSet12 = (errorModelLibrary5.getMappings()).getFirst();
		Assert.assertEquals("mappings1", typeSet12.getName());
		this.assertHelper.assertScope(((typeSet12.getMapping()).getFirst().getSource().getTypeTokens()).getFirst(),
				ErrorModelPackage.eINSTANCE.getTypeToken_Type(), expectedTypeTokenScope);
		this.assertHelper.assertScope((typeSet12.getMapping()).getFirst().getTarget(),
				ErrorModelPackage.eINSTANCE.getTypeToken_Type(), expectedTypeTokenScope);
		var typeTransformationSet2 = (errorModelLibrary5.getTransformations()).getFirst();
		Assert.assertEquals("transformation1", typeTransformationSet2.getName());
		this.assertHelper.assertScope(
				((typeTransformationSet2.getTransformation()).getFirst().getSource().getTypeTokens()).getFirst(),
				ErrorModelPackage.eINSTANCE.getTypeToken_Type(), expectedTypeTokenScope);
		this.assertHelper.assertScope((typeTransformationSet2.getTransformation()).getFirst().getTarget(),
				ErrorModelPackage.eINSTANCE.getTypeToken_Type(), expectedTypeTokenScope);

		final AadlPackage pkg6 = this.testHelper.parseString(subclause1, lib6, lib5, lib4, lib3, lib2, lib1);
		Assert.assertEquals("subclause1", pkg6.getName());
		var errorType10 = pkg6.getPublicSection().getOwnedClassifiers().get(2);
		Assert.assertEquals("a2.i", errorType10.getName());
		var errorModelSubclause = ((ErrorModelSubclause) ((DefaultAnnexSubclause) (errorType10
				.getOwnedAnnexSubclauses()).getFirst()).getParsedAnnexSubclause());
		final List<String> expectedScope = List.of("t1", "t2", "t3", "t4", "t6", "ts1", "ts2", "ts3", "ts4", "ts6",
				"lib1::conflict1", "lib1::conflict2", "lib1::conflict_ts1", "lib1::conflict_ts2", "lib1::t1",
				"lib1::ts1", "lib2::conflict1", "lib2::conflict2", "lib2::conflict_ts1", "lib2::conflict_ts2",
				"lib2::t1", "lib2::t2", "lib2::ts1", "lib2::ts2", "lib3::conflict1", "lib3::conflict_ts1", "lib3::t3",
				"lib3::ts3", "lib4::conflict1", "lib4::conflict_ts1", "lib4::t3", "lib4::t4", "lib4::ts3", "lib4::ts4",
				"lib5::conflict1", "lib5::conflict2", "lib5::conflict_ts1", "lib5::conflict_ts2", "lib5::t1",
				"lib5::ts1", "lib6::conflict1", "lib6::conflict2", "lib6::conflict_ts1", "lib6::conflict_ts2",
				"lib6::t3", "lib6::t4", "lib6::t6", "lib6::ts3", "lib6::ts4", "lib6::ts6");
		var typeToken = (errorModelSubclause.getPropagations()).getFirst();
		Assert.assertEquals("processor", typeToken.getKind());
		this.assertHelper.assertScope((typeToken.getTypeSet().getTypeTokens()).getFirst(),
				ErrorModelPackage.eINSTANCE.getTypeToken_Type(), expectedScope);
		var errorSource = ((ErrorSource) errorModelSubclause.getFlows().get(0));
		Assert.assertEquals("errSource1", errorSource.getName());
		this.assertHelper.assertScope((errorSource.getTypeTokenConstraint().getTypeTokens()).getFirst(),
				ErrorModelPackage.eINSTANCE.getTypeToken_Type(), expectedScope);
		this.assertHelper.assertScope((errorSource.getFailureModeType().getTypeTokens()).getFirst(),
				ErrorModelPackage.eINSTANCE.getTypeToken_Type(), expectedScope);
		var errorSource2 = ((ErrorSource) errorModelSubclause.getFlows().get(1));
		Assert.assertEquals("errSource2", errorSource2.getName());
		this.assertHelper.assertScope((errorSource2.getTypeTokenConstraint().getTypeTokens()).getFirst(),
				ErrorModelPackage.eINSTANCE.getTypeToken_Type(), expectedScope);
		this.assertHelper.assertScope((errorSource2.getFailureModeType().getTypeTokens()).getFirst(),
				ErrorModelPackage.eINSTANCE.getTypeToken_Type(), expectedScope);
		var typeSet3 = errorModelSubclause.getFlows().get(2);
		Assert.assertEquals("errSink1", typeSet3.getName());
		this.assertHelper.assertScope((typeSet3.getTypeTokenConstraint().getTypeTokens()).getFirst(),
				ErrorModelPackage.eINSTANCE.getTypeToken_Type(), expectedScope);
		var errorPath = ((ErrorPath) errorModelSubclause.getFlows().get(3));
		Assert.assertEquals("errPath1", errorPath.getName());
		this.assertHelper.assertScope((errorPath.getTypeTokenConstraint().getTypeTokens()).getFirst(),
				ErrorModelPackage.eINSTANCE.getTypeToken_Type(), expectedScope);
		this.assertHelper.assertScope(errorPath.getTargetToken(), ErrorModelPackage.eINSTANCE.getTypeToken_Type(),
				expectedScope);
		var errorEvent2 = ((ErrorEvent) (errorModelSubclause.getEvents()).getFirst());
		Assert.assertEquals("errEvent1", errorEvent2.getName());
		this.assertHelper.assertScope((errorEvent2.getTypeSet().getTypeTokens()).getFirst(),
				ErrorModelPackage.eINSTANCE.getTypeToken_Type(), expectedScope);
		var typeSet4 = errorModelSubclause.getTransitions().get(0);
		Assert.assertEquals("errBvrTransition1", typeSet4.getName());
		this.assertHelper.assertScope((typeSet4.getTypeTokenConstraint().getTypeTokens()).getFirst(),
				ErrorModelPackage.eINSTANCE.getTypeToken_Type(), expectedScope);
		this.assertHelper.assertScope(
				(((ConditionElement) typeSet4.getCondition()).getConstraint().getTypeTokens()).getFirst(),
				ErrorModelPackage.eINSTANCE.getTypeToken_Type(), expectedScope);
		this.assertHelper.assertScope(typeSet4.getTargetToken(), ErrorModelPackage.eINSTANCE.getTypeToken_Type(),
				expectedScope);
		var errorBehaviorTransition3 = errorModelSubclause.getTransitions().get(1);
		Assert.assertEquals("errBvrTransition2", errorBehaviorTransition3.getName());
		this.assertHelper.assertScope(errorBehaviorTransition3.getDestinationBranches().get(0).getTargetToken(),
				ErrorModelPackage.eINSTANCE.getTypeToken_Type(), expectedScope);
		this.assertHelper.assertScope(errorBehaviorTransition3.getDestinationBranches().get(1).getTargetToken(),
				ErrorModelPackage.eINSTANCE.getTypeToken_Type(), expectedScope);
		var typeTransformationSet = (errorModelSubclause.getOutgoingPropagationConditions()).getFirst();
		Assert.assertEquals("propCondition1", typeTransformationSet.getName());
		this.assertHelper.assertScope((typeTransformationSet.getTypeTokenConstraint().getTypeTokens()).getFirst(),
				ErrorModelPackage.eINSTANCE.getTypeToken_Type(), expectedScope);
		this.assertHelper.assertScope(
				(((ConditionElement) typeTransformationSet.getCondition()).getConstraint().getTypeTokens()).getFirst(),
				ErrorModelPackage.eINSTANCE.getTypeToken_Type(), expectedScope);
		this.assertHelper.assertScope(typeTransformationSet.getTypeToken(),
				ErrorModelPackage.eINSTANCE.getTypeToken_Type(), expectedScope);
		var errorDetection = (errorModelSubclause.getErrorDetections()).getFirst();
		Assert.assertEquals("detection1", errorDetection.getName());
		this.assertHelper.assertScope((errorDetection.getTypeTokenConstraint().getTypeTokens()).getFirst(),
				ErrorModelPackage.eINSTANCE.getTypeToken_Type(), expectedScope);
		this.assertHelper.assertScope(
				(((ConditionElement) errorDetection.getCondition()).getConstraint().getTypeTokens()).getFirst(),
				ErrorModelPackage.eINSTANCE.getTypeToken_Type(), expectedScope);
		var errorStateToModeMapping = (errorModelSubclause.getErrorStateToModeMappings()).getFirst();
		Assert.assertEquals("bvr_state1", errorStateToModeMapping.getErrorState().getName());
		this.assertHelper.assertScope(errorStateToModeMapping.getTypeToken(),
				ErrorModelPackage.eINSTANCE.getTypeToken_Type(), expectedScope);
		var errorBehaviorTransition4 = errorModelSubclause.getStates().get(0);
		Assert.assertEquals("compositeState1", errorBehaviorTransition4.getName());
		this.assertHelper.assertScope(
				(((ConditionElement) errorBehaviorTransition4.getCondition()).getConstraint().getTypeTokens())
						.getFirst(),
				ErrorModelPackage.eINSTANCE.getTypeToken_Type(), expectedScope);
		this.assertHelper.assertScope(errorBehaviorTransition4.getTypedToken(),
				ErrorModelPackage.eINSTANCE.getTypeToken_Type(), expectedScope);
		var compositeState = errorModelSubclause.getStates().get(1);
		Assert.assertEquals("compositeState2", compositeState.getName());
		this.assertHelper.assertScope(
				(((ConditionElement) compositeState.getCondition()).getConstraint().getTypeTokens()).getFirst(),
				ErrorModelPackage.eINSTANCE.getTypeToken_Type(), expectedScope);
		this.assertHelper.assertScope(compositeState.getTypedToken(), ErrorModelPackage.eINSTANCE.getTypeToken_Type(),
				expectedScope);
		var errorSource3 = (errorModelSubclause.getConnectionErrorSources()).getFirst();
		Assert.assertEquals("connErrSource1", errorSource3.getName());
		this.assertHelper.assertScope((errorSource3.getTypeTokenConstraint().getTypeTokens()).getFirst(),
				ErrorModelPackage.eINSTANCE.getTypeToken_Type(), expectedScope);
		this.assertHelper.assertScope((errorSource3.getFailureModeType().getTypeTokens()).getFirst(),
				ErrorModelPackage.eINSTANCE.getTypeToken_Type(), expectedScope);

	}
}
