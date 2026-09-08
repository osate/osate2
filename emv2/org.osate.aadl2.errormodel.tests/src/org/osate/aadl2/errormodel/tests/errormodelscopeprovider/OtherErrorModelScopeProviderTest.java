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
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AbstractImplementation;
import org.osate.aadl2.AbstractType;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.PublicPackageSection;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider;
import org.osate.testsupport.AssertHelper;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.errormodel.errorModel.CompositeState;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2PropertyAssociation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorFlow;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorStateToModeMapping;
import org.osate.xtext.aadl2.errormodel.errorModel.FeatureorPPReference;
import org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPath;
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedPropagationPoint;
import org.osate.xtext.aadl2.errormodel.errorModel.SConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeMappingSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeTransformationSet;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;
import com.itemis.xtext.testing.XtextTest;

/**
 * Covers the remaining EMV2 scope-provider entry points and reference visibility rules.
 */
@RunWith(XtextRunner.class)
@InjectWith(ErrorModelInjectorProvider.class)
public class OtherErrorModelScopeProviderTest extends XtextTest {
	@Inject
	private TestHelper<AadlPackage> testHelper;
	private AssertHelper assertHelper = IResourceServiceProvider.Registry.INSTANCE
			.getResourceServiceProvider(URI.createFileURI("dummy.emv2")).<AssertHelper>get(AssertHelper.class);

	/**
	 * Tests scope_ErrorModelLibrary, scope_TypeMappingSet, scope_ErrorModelSubclause_useBehavior, and
	 * scope_TypeTransformationSet
	 */
	@Test
	public void testErrorModelLibraryReference() throws Exception {
		var pkg = """
				package pkg
				public
				\tannex EMV2 {**
				\t\terror types
				\t\t\tuse types ErrorLibrary;
				\t\t\textends ErrorLibrary with
				\t\tend types;
				\t\t
				\t\terror behavior b
				\t\t\tuse types ErrorLibrary;
				\t\t\tuse transformations t;
				\t\tend behavior;
				\t\t
				\t\ttype mappings m
				\t\t\tuse types ErrorLibrary;
				\t\t\t{ServiceError} -> {ItemOmission};
				\t\tend mappings;
				\t\t
				\t\ttype transformations t
				\t\t\tuse types ErrorLibrary;
				\t\t\tall -[]-> {ServiceError};
				\t\tend transformations;
				\t**};
				\t
				\tabstract a
				\t\tannex EMV2 {**
				\t\t\tuse types ErrorLibrary;
				\t\t\tuse type equivalence pkg::m;
				\t\t\tuse mappings pkg::m;
				\t\t\tuse behavior pkg::b;
				\t\t\t
				\t\t\terror propagations
				\t\t\tflows
				\t\t\t\tp: error path all -> all use mappings pkg::m;
				\t\t\tend propagations;
				\t\t\t
				\t\t\tcomponent error behavior
				\t\t\t\tuse transformations pkg::t;
				\t\t\tend component;
				\t\t\t
				\t\t\tconnection error
				\t\t\t\tuse transformations pkg::t;
				\t\t\tend connection;
				\t\t**};
				\tend a;
				end pkg;
				""";
		final FluentIssueCollection testFileResult = this.issues = this.testHelper.testString(pkg);
		final FluentIssueCollection issueCollection = new FluentIssueCollection(testFileResult.getResource(),
				new ArrayList<>(), new ArrayList<>());
		var aadlPackage = ((AadlPackage) (testFileResult.getResource().getContents()).getFirst());
		Assert.assertEquals("pkg", aadlPackage.getName());
		var publicPackageSection = aadlPackage.getPublicSection();
		var errorModelLibrary = ((ErrorModelLibrary) ((DefaultAnnexLibrary) (publicPackageSection
				.getOwnedAnnexLibraries()).getFirst()).getParsedAnnexLibrary());
		this.assertHelper.assertScope(errorModelLibrary, ErrorModelPackage.eINSTANCE.getErrorModelLibrary_UseTypes(),
				List.of("pkg"));
		this.assertHelper.assertScope(errorModelLibrary, ErrorModelPackage.eINSTANCE.getErrorModelLibrary_Extends(),
				List.of("pkg"));
		var errorBehaviorStateMachine = (errorModelLibrary.getBehaviors()).getFirst();
		Assert.assertEquals("b", errorBehaviorStateMachine.getName());
		this.assertHelper.assertScope(errorBehaviorStateMachine,
				ErrorModelPackage.eINSTANCE.getErrorBehaviorStateMachine_UseTypes(), List.of("pkg"));
		this.assertHelper.assertScope(errorBehaviorStateMachine,
				ErrorModelPackage.eINSTANCE.getErrorBehaviorStateMachine_UseTransformation(), List.of("t", "pkg::t"));
		var typeMappingSet = (errorModelLibrary.getMappings()).getFirst();
		Assert.assertEquals("m", typeMappingSet.getName());
		this.assertHelper.assertScope(typeMappingSet, ErrorModelPackage.eINSTANCE.getTypeMappingSet_UseTypes(),
				List.of("pkg"));
		var typeTransformationSet2 = (errorModelLibrary.getTransformations()).getFirst();
		Assert.assertEquals("t", typeTransformationSet2.getName());
		this.assertHelper.assertScope(typeTransformationSet2,
				ErrorModelPackage.eINSTANCE.getTypeTransformationSet_UseTypes(), List.of("pkg"));
		var classifier = (publicPackageSection.getOwnedClassifiers()).getFirst();
		Assert.assertEquals("a", classifier.getName());
		var errorModelSubclause = ((ErrorModelSubclause) ((DefaultAnnexSubclause) (classifier.getOwnedAnnexSubclauses())
				.getFirst()).getParsedAnnexSubclause());
		this.assertHelper.assertScope(errorModelSubclause,
				ErrorModelPackage.eINSTANCE.getErrorModelSubclause_UseTypes(), List.of("pkg"));
		this.assertHelper.assertScope(errorModelSubclause,
				ErrorModelPackage.eINSTANCE.getErrorModelSubclause_TypeEquivalence(), List.of("pkg::m"));
		this.assertHelper.assertScope(errorModelSubclause,
				ErrorModelPackage.eINSTANCE.getErrorModelSubclause_TypeMappingSet(), List.of("pkg::m"));
		this.assertHelper.assertScope(errorModelSubclause,
				ErrorModelPackage.eINSTANCE.getErrorModelSubclause_UseBehavior(), List.of("pkg::b"));
		var errorPath = (errorModelSubclause.getFlows()).getFirst();
		Assert.assertEquals("p", errorPath.getName());
		AssertHelper.assertWarning(errorPath, testFileResult.getIssues(), issueCollection,
				"Legacy support: please declare \'use mappings\' at subclause level.");
		this.assertHelper.assertScope(errorPath, ErrorModelPackage.eINSTANCE.getErrorPath_TypeMappingSet(),
				List.of("pkg::m"));
		this.assertHelper.assertScope(errorModelSubclause,
				ErrorModelPackage.eINSTANCE.getErrorModelSubclause_UseTransformation(), List.of("pkg::t"));
		this.assertHelper.assertScope(errorModelSubclause,
				ErrorModelPackage.eINSTANCE.getErrorModelSubclause_TypeTransformationSet(), List.of("pkg::t"));

		issueCollection.sizeIs(testFileResult.getIssues().size());
		this.assertConstraints(issueCollection);

	}

	/**
	 * Tests ErrorModelScopeProvider.scope_FeatureorPPReference_featureorPP(Classifier, EReference),
	 * ErrorModelScopeProvider.scope_FeatureorPPReference_featureorPP(FeatureorPPReference, EReference), and
	 * ErrorModelSerializerScopeProvider.scope_FeatureorPPReference_featureorPP(FeatureorPPReference, EReference)
	 */
	@Test
	public void testFeatureorPPReference() throws Exception {
		var pkg = """
				package pkg
				public
				\tabstract a
				\tfeatures
				\t\top1: out data port;
				\t\tfg1: feature group fgt1;
				\tend a;
				\t
				\tabstract implementation a.i
				\tinternal features
				\t\tes: event;
				\t\teds: event data;
				\tannex EMV2 {**
				\t\tuse types ErrorLibrary;
				\t\t
				\t\terror propagations
				\t\t\tfg1.fg2.op3: out propagation {ServiceOmission};
				\t\tend propagations;
				\t\t
				\t\tpropagation paths
				\t\t\tpoint1: propagation point;
				\t\t\tpoint2: propagation point;
				\t\tend paths;
				\t**};
				\tend a.i;
				\t
				\tfeature group fgt1
				\tfeatures
				\t\top2: out data port;
				\t\tfg2: feature group fgt2;
				\tend fgt1;
				\t
				\tfeature group fgt2
				\tfeatures
				\t\top3: out data port;
				\tend fgt2;
				end pkg;
				""";
		var aadlPackage = this.testHelper.parseString(pkg);
		Assert.assertEquals("pkg", aadlPackage.getName());
		var abstractImplementation = ((AbstractImplementation) aadlPackage.getPublicSection().getOwnedClassifiers()
				.get(1));
		Assert.assertEquals("a.i", abstractImplementation.getName());
		var featureorPPReference3 = (((ErrorModelSubclause) ((DefaultAnnexSubclause) (abstractImplementation
				.getOwnedAnnexSubclauses()).getFirst()).getParsedAnnexSubclause()).getPropagations()).getFirst()
				.getFeatureorPPRef();
		Assert.assertEquals("fg1", featureorPPReference3.getFeatureorPP().getName());
		this.assertHelper.assertScope(featureorPPReference3,
				ErrorModelPackage.eINSTANCE.getFeatureorPPReference_FeatureorPP(),
				List.of("eds", "es", "fg1", "op1", "point1", "point2"));
		var featureorPPReference2 = featureorPPReference3.getNext();
		Assert.assertEquals("fg2", featureorPPReference2.getFeatureorPP().getName());
		this.assertHelper.assertScope(featureorPPReference2,
				ErrorModelPackage.eINSTANCE.getFeatureorPPReference_FeatureorPP(), List.of("fg2", "op2"));
		var featureorPPReference = featureorPPReference2.getNext();
		Assert.assertEquals("op3", featureorPPReference.getFeatureorPP().getName());
		this.assertHelper.assertScope(featureorPPReference,
				ErrorModelPackage.eINSTANCE.getFeatureorPPReference_FeatureorPP(), List.of("op3"));
		Assert.assertNull(featureorPPReference.getNext());

	}

	/**
	 * Tests scope_ErrorSource_outgoing, scope_ErrorSink_incoming, scope_ErrorPath_incoming, scope_ErrorPath_outgoing,
	 * and scope_OutgoingPropagationCondition_outgoing
	 */
	@Test
	public void testErrorPropagationReference() throws Exception {
		var pkg = """
				package pkg
				public
				\tabstract a
				\tfeatures
				\t\tp1: out data port;
				\t\tp2: out data port;
				\t\tp4: in data port;
				\t\tp5: in data port;
				\t\tfg1: feature group fgt1;
				\tannex EMV2 {**
				\t\tuse types ErrorLibrary;
				\t\t
				\t\terror propagations
				\t\t\tp1: out propagation {AboveRange};
				\t\t\tp2: out propagation {AboveRange};
				\t\t\tfg1.p3: out propagation {AboveRange};
				\t\t\tfg1.fg2.p4: out propagation {AboveRange};
				\t\t\tmemory: out propagation {AboveRange};
				\t\t\tbinding: out propagation {AboveRange};
				\t\t\t
				\t\t\tp4: in propagation {AboveRange};
				\t\t\tp5: in propagation {AboveRange};
				\t\t\tfg1.p4: in propagation {AboveRange};
				\t\t\tfg1.fg2.p5: in propagation {AboveRange};
				\t\t\tmemory: in propagation {AboveRange};
				\t\t\tbinding: in propagation {AboveRange};
				\t\tflows
				\t\t\terrSource: error source fg1.p3;
				\t\t\terrSink: error sink fg1.p4;
				\t\t\terrPath: error path fg1.p4 -> fg1.p3;
				\t\tend propagations;
				\t\t
				\t\tcomponent error behavior
				\t\tpropagations
				\t\t\tcondition1: all -[ p4 ]-> p1;
				\t\tend component;
				\t**};
				\tend a;
				\t
				\tfeature group fgt1
				\tfeatures
				\t\tp3: out data port;
				\t\tp4: in data port;
				\t\tfg2: feature group fgt2;
				\tend fgt1;
				\t
				\tfeature group fgt2
				\tfeatures
				\t\tp4: out data port;
				\t\tp5: in data port;
				\tend fgt2;
				end pkg;
				""";
		var aadlPackage = this.testHelper.parseString(pkg);
		Assert.assertEquals("pkg", aadlPackage.getName());
		var abstractType = ((AbstractType) (aadlPackage.getPublicSection().getOwnedClassifiers()).getFirst());
		Assert.assertEquals("a", abstractType.getName());
		var errorModelSubclause = ((ErrorModelSubclause) ((DefaultAnnexSubclause) (abstractType
				.getOwnedAnnexSubclauses()).getFirst()).getParsedAnnexSubclause());
		final List<String> outgoingScope = List.of("p1", "p2", "fg1.p3", "fg1.fg2.p4", "memory", "binding");
		final List<String> incomingScope = List.of("p4", "p5", "fg1.p4", "fg1.fg2.p5", "memory", "binding");
		var errorFlow = errorModelSubclause.getFlows().get(0);
		Assert.assertEquals("errSource", errorFlow.getName());
		this.assertHelper.assertScope(errorFlow, ErrorModelPackage.eINSTANCE.getErrorSource_SourceModelElement(),
				outgoingScope);
		var errorFlow2 = errorModelSubclause.getFlows().get(1);
		Assert.assertEquals("errSink", errorFlow2.getName());
		this.assertHelper.assertScope(errorFlow2, ErrorModelPackage.eINSTANCE.getErrorSink_Incoming(), incomingScope);
		var errorFlow3 = errorModelSubclause.getFlows().get(2);
		Assert.assertEquals("errPath", errorFlow3.getName());
		this.assertHelper.assertScope(errorFlow3, ErrorModelPackage.eINSTANCE.getErrorPath_Incoming(), incomingScope);
		this.assertHelper.assertScope(errorFlow3, ErrorModelPackage.eINSTANCE.getErrorPath_Outgoing(), outgoingScope);
		var outgoingPropagationCondition = (errorModelSubclause.getOutgoingPropagationConditions()).getFirst();
		Assert.assertEquals("condition1", outgoingPropagationCondition.getName());
		this.assertHelper.assertScope(outgoingPropagationCondition,
				ErrorModelPackage.eINSTANCE.getOutgoingPropagationCondition_Outgoing(), outgoingScope);

	}

	@Test
	public void testErrorBehaviorStateOrTypeSetReference() throws Exception {
		var lib = """
				package lib1
				public
				\tannex EMV2 {**
				\t\terror types
				\t\t\tt1: type;
				\t\t\tts1: type set {t1};
				\t\tend types;
				\t\t
				\t\terror behavior bvr1
				\t\tstates
				\t\t\tbvr_state1: initial state;
				\t\t\tbvr_state2: state;
				\t\tend behavior;
				\t**};
				end lib1;
				""";
		var subclause = """
				package subclause1
				public
				\tabstract a1
				\tannex EMV2 {**
				\t\tuse types lib1;
				\t\tuse behavior lib1::bvr1;
				\t\t
				\t\terror propagations
				\t\tflows
				\t\t\terrSource1: error source all when bvr_state1;
				\t\tend propagations;
				\t**};
				\tend a1;
				end subclause1;
				""";
		var aadlPackage = this.testHelper.parseString(subclause, lib);
		Assert.assertEquals("subclause1", aadlPackage.getName());
		var classifier = (aadlPackage.getPublicSection().getOwnedClassifiers()).getFirst();
		Assert.assertEquals("a1", classifier.getName());
		var errorSource = ((ErrorSource) (((ErrorModelSubclause) ((DefaultAnnexSubclause) (classifier
				.getOwnedAnnexSubclauses()).getFirst()).getParsedAnnexSubclause()).getFlows()).getFirst());
		Assert.assertEquals("errSource1", errorSource.getName());
		this.assertHelper.assertScope(errorSource, ErrorModelPackage.eINSTANCE.getErrorSource_FailureModeReference(),
				List.of("ts1", "bvr_state1", "bvr_state2"));

	}

	@Test
	public void testPropagationPointReference() throws Exception {
		var subclause = """
				package subclause1
				public
				\tabstract a1
				\tend a1;
				\t
				\tabstract implementation a1.i
				\tsubcomponents
				\t\tasub2: abstract a2.i;
				\tannex EMV2 {**
				\t\tpropagation paths
				\t\t\tpoint1: propagation point;
				\t\tend paths;
				\t**};
				\tend a1.i;
				\t
				\tabstract a2
				\tend a2;
				\t
				\tabstract implementation a2.i
				\tsubcomponents
				\t\tasub3: abstract a3.i;
				\tannex EMV2 {**
				\t\tpropagation paths
				\t\t\tpoint2: propagation point;
				\t\tend paths;
				\t**};
				\tend a2.i;
				\t
				\tabstract a3
				\tend a3;
				\t
				\tabstract implementation a3.i
				\tsubcomponents
				\t\tasub4: abstract a4.i;
				\tannex EMV2 {**
				\t\tpropagation paths
				\t\t\tpoint3: propagation point;
				\t\tend paths;
				\t**};
				\tend a3.i;
				\t
				\tabstract a4
				\tend a4;
				\t
				\tabstract implementation a4.i
				\tannex EMV2 {**
				\t\tpropagation paths
				\t\t\tpoint4: propagation point;
				\t\tend paths;
				\t**};
				\tend a4.i;
				\t
				\tabstract a5
				\tend a5;
				\t
				\tabstract implementation a5.i
				\tsubcomponents
				\t\tasub1: abstract a1.i;
				\tannex EMV2 {**
				\t\tpropagation paths
				\t\t\tpropPath1: asub1.point1 -> asub1.asub2.point2;
				\t\t\tpropPath2: asub1.asub2.asub3.point3 -> asub1.asub2.asub3.asub4.point4;
				\t\tend paths;
				\t**};
				\tend a5.i;
				end subclause1;
				""";
		var aadlPackage = this.testHelper.parseString(subclause);
		Assert.assertEquals("subclause1", aadlPackage.getName());
		var classifier = aadlPackage.getPublicSection().getOwnedClassifiers().get(9);
		Assert.assertEquals("a5.i", classifier.getName());
		var errorModelSubclause = ((ErrorModelSubclause) ((DefaultAnnexSubclause) (classifier.getOwnedAnnexSubclauses())
				.getFirst()).getParsedAnnexSubclause());
		var propagationPath = errorModelSubclause.getPaths().get(0);
		Assert.assertEquals("propPath1", propagationPath.getName());
		var qualifiedPropagationPoint11 = propagationPath.getSource();
		Assert.assertEquals("asub1", qualifiedPropagationPoint11.getSubcomponent().getSubcomponent().getName());
		var qualifiedPropagationPoint7 = qualifiedPropagationPoint11.getNext();
		Assert.assertEquals("point1", qualifiedPropagationPoint7.getPropagationPoint().getName());
		this.assertHelper.assertScope(qualifiedPropagationPoint7,
				ErrorModelPackage.eINSTANCE.getQualifiedPropagationPoint_PropagationPoint(), List.of("point1"));
		Assert.assertNull(qualifiedPropagationPoint7.getNext());
		var qualifiedPropagationPoint12 = propagationPath.getTarget();
		Assert.assertEquals("asub1", qualifiedPropagationPoint12.getSubcomponent().getSubcomponent().getName());
		var qualifiedPropagationPoint8 = qualifiedPropagationPoint12.getNext();
		Assert.assertEquals("asub2", qualifiedPropagationPoint8.getSubcomponent().getSubcomponent().getName());
		var qualifiedPropagationPoint4 = qualifiedPropagationPoint8.getNext();
		Assert.assertEquals("point2", qualifiedPropagationPoint4.getPropagationPoint().getName());
		this.assertHelper.assertScope(qualifiedPropagationPoint4,
				ErrorModelPackage.eINSTANCE.getQualifiedPropagationPoint_PropagationPoint(), List.of("point2"));
		Assert.assertNull(qualifiedPropagationPoint4.getNext());
		var propagationPath2 = errorModelSubclause.getPaths().get(1);
		Assert.assertEquals("propPath2", propagationPath2.getName());
		var qualifiedPropagationPoint13 = propagationPath2.getSource();
		Assert.assertEquals("asub1", qualifiedPropagationPoint13.getSubcomponent().getSubcomponent().getName());
		var qualifiedPropagationPoint9 = qualifiedPropagationPoint13.getNext();
		Assert.assertEquals("asub2", qualifiedPropagationPoint9.getSubcomponent().getSubcomponent().getName());
		var qualifiedPropagationPoint5 = qualifiedPropagationPoint9.getNext();
		Assert.assertEquals("asub3", qualifiedPropagationPoint5.getSubcomponent().getSubcomponent().getName());
		var qualifiedPropagationPoint2 = qualifiedPropagationPoint5.getNext();
		Assert.assertEquals("point3", qualifiedPropagationPoint2.getPropagationPoint().getName());
		this.assertHelper.assertScope(qualifiedPropagationPoint2,
				ErrorModelPackage.eINSTANCE.getQualifiedPropagationPoint_PropagationPoint(), List.of("point3"));
		Assert.assertNull(qualifiedPropagationPoint2.getNext());
		var qualifiedPropagationPoint14 = propagationPath2.getTarget();
		Assert.assertEquals("asub1", qualifiedPropagationPoint14.getSubcomponent().getSubcomponent().getName());
		var qualifiedPropagationPoint10 = qualifiedPropagationPoint14.getNext();
		Assert.assertEquals("asub2", qualifiedPropagationPoint10.getSubcomponent().getSubcomponent().getName());
		var qualifiedPropagationPoint6 = qualifiedPropagationPoint10.getNext();
		Assert.assertEquals("asub3", qualifiedPropagationPoint6.getSubcomponent().getSubcomponent().getName());
		var qualifiedPropagationPoint3 = qualifiedPropagationPoint6.getNext();
		Assert.assertEquals("asub4", qualifiedPropagationPoint3.getSubcomponent().getSubcomponent().getName());
		var qualifiedPropagationPoint = qualifiedPropagationPoint3.getNext();
		Assert.assertEquals("point4", qualifiedPropagationPoint.getPropagationPoint().getName());
		this.assertHelper.assertScope(qualifiedPropagationPoint,
				ErrorModelPackage.eINSTANCE.getQualifiedPropagationPoint_PropagationPoint(), List.of("point4"));
		Assert.assertNull(qualifiedPropagationPoint.getNext());

	}

	@Test
	public void testErrorBehaviorStateReference() throws Exception {
		var lib = """
				package lib1
				public
				\tannex EMV2 {**
				\t\terror types
				\t\t\tt1: type;
				\t\tend types;
				\t\t
				\t\terror behavior bvr
				\t\tevents
				\t\t\terr_evt1: error event;
				\t\tstates
				\t\t\tbvr_state1: state;
				\t\t\tbvr_state2: state;
				\t\ttransitions
				\t\t\ttransition1: bvr_state1 -[ err_evt1 ]-> bvr_state2;
				\t\t\ttransition2: bvr_state1 -[ err_evt1 ]-> (bvr_state2 with 0.2, bvr_state2 with 0.8);
				\t\tend behavior;
				\t**};
				end lib1;
				""";
		var subclause = """
				package subclause1
				public
				\tabstract a
				\tfeatures
				\t\tep1: in event port;
				\tmodes
				\t\tm1: initial mode;
				\tannex EMV2 {**
				\t\tuse types lib1;
				\t\tuse behavior lib1::bvr;
				\t\t
				\t\terror propagations
				\t\t\tprocessor: in propagation {t1};
				\t\tend propagations;
				\t\t
				\t\tcomponent error behavior
				\t\tevents
				\t\t\terr_evt2: error event;
				\t\ttransitions
				\t\t\ttransition3: bvr_state1 -[ err_evt2 ]-> bvr_state2;
				\t\t\ttransition4: bvr_state1 -[ err_evt2 ]-> (bvr_state2 with 0.2, bvr_state2 with 0.8);
				\t\tpropagations
				\t\t\tpropagationCondition1: bvr_state1 -[ processor ]-> all;
				\t\tdetections
				\t\t\tdetection1: bvr_state1 -[ err_evt2 ]-> ep1!;
				\t\tmode mappings
				\t\t\tbvr_state1 in modes (m1);
				\t\tend component;
				\t\t
				\t\tcomposite error behavior states
				\t\t\tcompositeState1: [ others ]-> bvr_state1;
				\t\tend composite;
				\t**};
				\tend a;
				end subclause1;
				""";
		final List<String> expectedScope = List.of("bvr_state1", "bvr_state2");
		var aadlPackage = this.testHelper.parseString(lib);
		Assert.assertEquals("lib1", aadlPackage.getName());
		var errorBehaviorStateMachine = (((ErrorModelLibrary) ((DefaultAnnexLibrary) (aadlPackage.getPublicSection()
				.getOwnedAnnexLibraries()).getFirst()).getParsedAnnexLibrary()).getBehaviors()).getFirst();
		Assert.assertEquals("bvr", errorBehaviorStateMachine.getName());
		var errorBehaviorTransition3 = errorBehaviorStateMachine.getTransitions().get(0);
		Assert.assertEquals("transition1", errorBehaviorTransition3.getName());
		this.assertHelper.assertScope(errorBehaviorTransition3,
				ErrorModelPackage.eINSTANCE.getErrorBehaviorTransition_Source(), expectedScope);
		this.assertHelper.assertScope(errorBehaviorTransition3,
				ErrorModelPackage.eINSTANCE.getErrorBehaviorTransition_Target(), expectedScope);
		var errorBehaviorTransition4 = errorBehaviorStateMachine.getTransitions().get(1);
		Assert.assertEquals("transition2", errorBehaviorTransition4.getName());
		this.assertHelper.assertScope(errorBehaviorTransition4,
				ErrorModelPackage.eINSTANCE.getErrorBehaviorTransition_Source(), expectedScope);
		this.assertHelper.assertScope(errorBehaviorTransition4.getDestinationBranches().get(0),
				ErrorModelPackage.eINSTANCE.getTransitionBranch_Target(), expectedScope);
		this.assertHelper.assertScope(errorBehaviorTransition4.getDestinationBranches().get(1),
				ErrorModelPackage.eINSTANCE.getTransitionBranch_Target(), expectedScope);

		var aadlPackage2 = this.testHelper.parseString(subclause, lib);
		Assert.assertEquals("subclause1", aadlPackage2.getName());
		var annexLibrary = (aadlPackage2.getPublicSection().getOwnedClassifiers()).getFirst();
		Assert.assertEquals("a", annexLibrary.getName());
		var errorModelSubclause = ((ErrorModelSubclause) ((DefaultAnnexSubclause) (annexLibrary
				.getOwnedAnnexSubclauses()).getFirst()).getParsedAnnexSubclause());
		var errorBehaviorTransition = errorModelSubclause.getTransitions().get(0);
		Assert.assertEquals("transition3", errorBehaviorTransition.getName());
		this.assertHelper.assertScope(errorBehaviorTransition,
				ErrorModelPackage.eINSTANCE.getErrorBehaviorTransition_Source(), expectedScope);
		this.assertHelper.assertScope(errorBehaviorTransition,
				ErrorModelPackage.eINSTANCE.getErrorBehaviorTransition_Target(), expectedScope);
		var errorBehaviorTransition2 = errorModelSubclause.getTransitions().get(1);
		Assert.assertEquals("transition4", errorBehaviorTransition2.getName());
		this.assertHelper.assertScope(errorBehaviorTransition2,
				ErrorModelPackage.eINSTANCE.getErrorBehaviorTransition_Source(), expectedScope);
		this.assertHelper.assertScope(errorBehaviorTransition2.getDestinationBranches().get(0),
				ErrorModelPackage.eINSTANCE.getTransitionBranch_Target(), expectedScope);
		this.assertHelper.assertScope(errorBehaviorTransition2.getDestinationBranches().get(1),
				ErrorModelPackage.eINSTANCE.getTransitionBranch_Target(), expectedScope);
		var outgoingPropagationCondition = (errorModelSubclause.getOutgoingPropagationConditions()).getFirst();
		Assert.assertEquals("propagationCondition1", outgoingPropagationCondition.getName());
		this.assertHelper.assertScope(outgoingPropagationCondition,
				ErrorModelPackage.eINSTANCE.getOutgoingPropagationCondition_State(), expectedScope);
		var errorDetection = (errorModelSubclause.getErrorDetections()).getFirst();
		Assert.assertEquals("detection1", errorDetection.getName());
		this.assertHelper.assertScope(errorDetection, ErrorModelPackage.eINSTANCE.getErrorDetection_State(),
				expectedScope);
		var errorStateToModeMapping = (errorModelSubclause.getErrorStateToModeMappings()).getFirst();
		Assert.assertEquals("bvr_state1", errorStateToModeMapping.getErrorState().getName());
		this.assertHelper.assertScope(errorStateToModeMapping,
				ErrorModelPackage.eINSTANCE.getErrorStateToModeMapping_ErrorState(), expectedScope);
		var compositeState = (errorModelSubclause.getStates()).getFirst();
		Assert.assertEquals("compositeState1", compositeState.getName());
		this.assertHelper.assertScope(compositeState, ErrorModelPackage.eINSTANCE.getCompositeState_State(),
				expectedScope);

	}

	@Test
	public void testConnectionReference() throws Exception {
		var subclause = """
				package subclause1
				public
				\tabstract a1
				\tfeatures
				\t\tf1: feature;
				\tend a1;
				\t
				\tabstract implementation a1.i
				\tsubcomponents
				\t\tsub1: abstract a1;
				\tconnections
				\t\tconn1: feature sub1.f1 -> f1;
				\tend a1.i;
				\t
				\tabstract a2 extends a1
				\tend a2;
				\t
				\tabstract implementation a2.i extends a1.i
				\tconnections
				\t\tconn2: feature f1 -> sub1.f1;
				\tannex EMV2 {**
				\t\tconnection error
				\t\t\tsource1: error source conn1;
				\t\tend connection;
				\t**};
				\tend a2.i;
				end subclause1;
				""";
		var aadlPackage = this.testHelper.parseString(subclause);
		Assert.assertEquals("subclause1", aadlPackage.getName());
		var classifier = aadlPackage.getPublicSection().getOwnedClassifiers().get(3);
		Assert.assertEquals("a2.i", classifier.getName());
		var errorSource = (((ErrorModelSubclause) ((DefaultAnnexSubclause) (classifier.getOwnedAnnexSubclauses())
				.getFirst()).getParsedAnnexSubclause()).getConnectionErrorSources()).getFirst();
		Assert.assertEquals("source1", errorSource.getName());
		this.assertHelper.assertScope(errorSource, ErrorModelPackage.eINSTANCE.getErrorSource_SourceModelElement(),
				List.of("conn1", "conn2"));

	}

	@Test
	public void testErrorDetectionReferences() throws Exception {
		var ps = """
				property set ps1 is
				\tconst1: constant aadlinteger => 42;
				end ps1;
				""";
		var subclause = """
				package subclause1
				public
				\tabstract a1
				\tfeatures
				\t\taf1: feature;
				\t\tdp1: in data port;
				\t\tep1: in event port;
				\t\tedp1: in event data port;
				\tend a1;
				\t
				\tabstract implementation a1.i
				\tinternal features
				\t\tes1: event;
				\t\teds1: event data;
				\tend a1.i;
				\t
				\tabstract a2 extends a1
				\tfeatures
				\t\taf2: feature;
				\t\tdp2: in data port;
				\t\tep2: in event port;
				\t\tedp2: in event data port;
				\tannex EMV2 {**
				\t\tcomponent error behavior
				\t\tdetections
				\t\t\tdetection1: all -[ access ]-> dp1!;
				\t\tend component;
				\t**};
				\tend a2;
				\t
				\tabstract implementation a2.i extends a1.i
				\tinternal features
				\t\tes2: event;
				\t\teds2: event data;
				\tannex EMV2 {**
				\t\tuse types ErrorLibrary;
				\t\t
				\t\terror propagations
				\t\t\taccess: in propagation {AboveRange};
				\t\tend propagations;
				\t\t
				\t\tcomponent error behavior
				\t\tdetections
				\t\t\tdetection2: all -[ access ]-> dp1! (ps1::const1);
				\t\tend component;
				\t**};
				\tend a2.i;
				end subclause1;
				""";
		var aadlPackage = this.testHelper.parseString(subclause, ps);
		Assert.assertEquals("subclause1", aadlPackage.getName());
		var classifier = aadlPackage.getPublicSection().getOwnedClassifiers().get(2);
		Assert.assertEquals("a2", classifier.getName());
		var errorDetection = (((ErrorModelSubclause) ((DefaultAnnexSubclause) (classifier.getOwnedAnnexSubclauses())
				.getFirst()).getParsedAnnexSubclause()).getErrorDetections()).getFirst();
		Assert.assertEquals("detection1", errorDetection.getName());
		this.assertHelper.assertScope(errorDetection.getDetectionReportingPort(),
				ErrorModelPackage.eINSTANCE.getReportingPortReference_Element(),
				List.of("af1", "dp1", "ep1", "edp1", "af2", "dp2", "ep2", "edp2"));
		var classifier2 = aadlPackage.getPublicSection().getOwnedClassifiers().get(3);
		Assert.assertEquals("a2.i", classifier2.getName());
		var errorDetection2 = (((ErrorModelSubclause) ((DefaultAnnexSubclause) (classifier2.getOwnedAnnexSubclauses())
				.getFirst()).getParsedAnnexSubclause()).getErrorDetections()).getFirst();
		Assert.assertEquals("detection2", errorDetection2.getName());
		this.assertHelper.assertScope(errorDetection2.getDetectionReportingPort(),
				ErrorModelPackage.eINSTANCE.getReportingPortReference_Element(),
				List.of("af1", "dp1", "ep1", "edp1", "es1", "eds1", "af2", "dp2", "ep2", "edp2", "es2", "eds2"));
		this.assertHelper.assertScope(errorDetection2.getErrorCode(),
				ErrorModelPackage.eINSTANCE.getErrorCodeValue_Constant(),
				List.of("Max_Aadlinteger", "Max_Base_Address", "Max_Byte_Count", "Max_Memory_Size", "Max_Queue_Size",
						"Max_Target_Integer", "Max_Thread_Limit", "Max_Time", "Max_Urgency", "Max_Volume",
						"Max_Word_Space", "Supported_Classifier_Complement_Matches",
						"Supported_Classifier_Equivalence_Matches", "Supported_Classifier_Subset_Matches",
						"Supported_Type_Conversions", "ps1::const1", "AADL_Project::Max_Aadlinteger",
						"AADL_Project::Max_Base_Address", "AADL_Project::Max_Byte_Count",
						"AADL_Project::Max_Memory_Size", "AADL_Project::Max_Queue_Size",
						"AADL_Project::Max_Target_Integer", "AADL_Project::Max_Thread_Limit", "AADL_Project::Max_Time",
						"AADL_Project::Max_Urgency", "AADL_Project::Max_Volume", "AADL_Project::Max_Word_Space",
						"AADL_Project::Supported_Classifier_Complement_Matches",
						"AADL_Project::Supported_Classifier_Equivalence_Matches",
						"AADL_Project::Supported_Classifier_Subset_Matches",
						"AADL_Project::Supported_Type_Conversions"));

	}

	@Test
	public void testModeReference() throws Exception {
		var lib = """
				package lib1
				public
				\tannex EMV2 {**
				\t\terror behavior bvr1
				\t\tstates
				\t\t\tbvr_state1: state;
				\t\tend behavior;
				\t**};
				end lib1;
				""";
		var subclause = """
				package subclause1
				public
				\tabstract a1
				\tmodes
				\t\tm1: initial mode;
				\t\tm2: mode;
				\tend a1;
				\t
				\tabstract a2 extends a1
				\tmodes
				\t\tm3: mode;
				\t\tm4: mode;
				\tannex EMV2 {**
				\t\tuse behavior lib1::bvr1;
				\t\t
				\t\tcomponent error behavior
				\t\tmode mappings
				\t\t\tbvr_state1 in modes (m1, m3);
				\t\tend component;
				\t**};
				\tend a2;
				end subclause1;
				""";
		var aadlPackage = this.testHelper.parseString(subclause, lib);
		Assert.assertEquals("subclause1", aadlPackage.getName());
		var classifier = aadlPackage.getPublicSection().getOwnedClassifiers().get(1);
		Assert.assertEquals("a2", classifier.getName());
		var errorStateToModeMapping = (((ErrorModelSubclause) ((DefaultAnnexSubclause) (classifier
				.getOwnedAnnexSubclauses()).getFirst()).getParsedAnnexSubclause()).getErrorStateToModeMappings())
				.getFirst();
		Assert.assertEquals("bvr_state1", errorStateToModeMapping.getErrorState().getName());
		this.assertHelper.assertScope(errorStateToModeMapping,
				ErrorModelPackage.eINSTANCE.getErrorStateToModeMapping_MappedModes(), List.of("m1", "m2", "m3", "m4"));

	}

	@Test
	public void testQualifiedErrorBehaviorState() throws Exception {
		var lib = """
				package lib1
				public
				\tannex EMV2 {**
				\t\terror behavior bvr1
				\t\tstates
				\t\t\tbvr_state1: state;
				\t\tend behavior;
				\t\t
				\t\terror behavior bvr2
				\t\tstates
				\t\t\tbvr_state2: state;
				\t\tend behavior;
				\t\t
				\t\terror behavior bvr3
				\t\tstates
				\t\t\tbvr_state3: state;
				\t\tend behavior;
				\t\t
				\t\terror behavior bvr4
				\t\tstates
				\t\t\tbvr_state4: state;
				\t\tend behavior;
				\t**};
				end lib1;
				""";
		var subclause = """
				package subclause1
				public
				\tabstract a1
				\tend a1;
				\t
				\tabstract implementation a1.i
				\tsubcomponents
				\t\tasub1: abstract a2.i;
				\tannex EMV2 {**
				\t\tuse behavior lib1::bvr1;
				\t\t
				\t\tcomposite error behavior states
				\t\t\tcompositeState1: [ asub1.bvr_state2 ]-> bvr_state1;
				\t\t\tcompositeState2: [ asub1.asub2.bvr_state3 ]-> bvr_state1;
				\t\t\tcompositeState3: [ asub1.asub2.asub3.bvr_state4 ]-> bvr_state1;
				\t\tend composite;
				\t**};
				\tend a1.i;
				\t
				\tabstract a2
				\tannex EMV2 {**
				\t\tuse behavior lib1::bvr2;
				\t**};
				\tend a2;
				\t
				\tabstract implementation a2.i
				\tsubcomponents
				\t\tasub2: abstract a3.i;
				\tend a2.i;
				\t
				\tabstract a3
				\tannex EMV2 {**
				\t\tuse behavior lib1::bvr3;
				\t**};
				\tend a3;
				\t
				\tabstract implementation a3.i
				\tsubcomponents
				\t\tasub3: abstract a4;
				\tend a3.i;
				\t
				\tabstract a4
				\tannex EMV2 {**
				\t\tuse behavior lib1::bvr4;
				\t**};
				\tend a4;
				end subclause1;
				""";
		var aadlPackage = this.testHelper.parseString(subclause, lib);
		Assert.assertEquals("subclause1", aadlPackage.getName());
		var classifier = aadlPackage.getPublicSection().getOwnedClassifiers().get(1);
		Assert.assertEquals("a1.i", classifier.getName());
		var errorModelSubclause = ((ErrorModelSubclause) ((DefaultAnnexSubclause) (classifier.getOwnedAnnexSubclauses())
				.getFirst()).getParsedAnnexSubclause());
		var compositeState = errorModelSubclause.getStates().get(0);
		Assert.assertEquals("compositeState1", compositeState.getName());
		var qualifiedErrorBehaviorState4 = ((SConditionElement) compositeState.getCondition()).getQualifiedState();
		Assert.assertEquals("asub1", qualifiedErrorBehaviorState4.getSubcomponent().getSubcomponent().getName());
		this.assertHelper.assertScope(qualifiedErrorBehaviorState4,
				ErrorModelPackage.eINSTANCE.getQualifiedErrorBehaviorState_State(), List.of("bvr_state2"));
		Assert.assertNull(qualifiedErrorBehaviorState4.getNext());
		var compositeState2 = errorModelSubclause.getStates().get(1);
		Assert.assertEquals("compositeState2", compositeState2.getName());
		var qualifiedErrorBehaviorState5 = ((SConditionElement) compositeState2.getCondition()).getQualifiedState();
		Assert.assertEquals("asub1", qualifiedErrorBehaviorState5.getSubcomponent().getSubcomponent().getName());
		var qualifiedErrorBehaviorState2 = qualifiedErrorBehaviorState5.getNext();
		Assert.assertEquals("asub2", qualifiedErrorBehaviorState2.getSubcomponent().getSubcomponent().getName());
		this.assertHelper.assertScope(qualifiedErrorBehaviorState2,
				ErrorModelPackage.eINSTANCE.getQualifiedErrorBehaviorState_State(), List.of("bvr_state3"));
		Assert.assertNull(qualifiedErrorBehaviorState2.getNext());
		var compositeState3 = errorModelSubclause.getStates().get(2);
		Assert.assertEquals("compositeState3", compositeState3.getName());
		var qualifiedErrorBehaviorState6 = ((SConditionElement) compositeState3.getCondition()).getQualifiedState();
		Assert.assertEquals("asub1", qualifiedErrorBehaviorState6.getSubcomponent().getSubcomponent().getName());
		var qualifiedErrorBehaviorState3 = qualifiedErrorBehaviorState6.getNext();
		Assert.assertEquals("asub2", qualifiedErrorBehaviorState3.getSubcomponent().getSubcomponent().getName());
		var qualifiedErrorBehaviorState = qualifiedErrorBehaviorState3.getNext();
		Assert.assertEquals("asub3", qualifiedErrorBehaviorState.getSubcomponent().getSubcomponent().getName());
		this.assertHelper.assertScope(qualifiedErrorBehaviorState,
				ErrorModelPackage.eINSTANCE.getQualifiedErrorBehaviorState_State(), List.of("bvr_state4"));
		Assert.assertNull(qualifiedErrorBehaviorState.getNext());

	}

	@Test
	public void testEMV2PathElement_errorType() throws Exception {
		var ps = """
				property set ps1 is
				\tdef1: aadlinteger applies to (all);
				end ps1;
				""";
		var pkg = """
				package pkg1
				public
				\twith ps1;
				\t
				\tabstract a1
				\t\tannex EMV2 {**
				\t\t\tuse types pkg1;
				\t\t\t
				\t\t\terror propagations
				\t\t\t\tmemory: in propagation {t1};
				\t\t\t\tmemory: not in propagation {t2};
				\t\t\t\tmemory: out propagation {t3};
				\t\t\t\tmemory: not out propagation {t4};
				\t\t\tend propagations;
				\t\t\t
				\t\t\tproperties
				\t\t\t\tps1::def1 => 1 applies to memory.t1;
				\t\t**};
				\tend a1;
				\t
				\tannex EMV2 {**
				\t\terror types
				\t\t\tt1: type;
				\t\t\tt2: type;
				\t\t\tt3: type;
				\t\t\tt4: type;
				\t\tend types;
				\t**};
				end pkg1;
				""";
		var aadlPackage = this.testHelper.parseString(pkg, ps);
		Assert.assertEquals("pkg1", aadlPackage.getName());
		var classifier = (aadlPackage.getPublicSection().getOwnedClassifiers()).getFirst();
		Assert.assertEquals("a1", classifier.getName());
		var emv2PropertyAssociation = (((ErrorModelSubclause) ((DefaultAnnexSubclause) (classifier
				.getOwnedAnnexSubclauses()).getFirst()).getParsedAnnexSubclause()).getProperties()).getFirst();
		Assert.assertEquals(1,
				((IntegerLiteral) (emv2PropertyAssociation.getOwnedValues()).getFirst().getOwnedValue()).getValue());
		this.assertHelper.assertScope((emv2PropertyAssociation.getEmv2Path()).getFirst().getEmv2Target(),
				ErrorModelPackage.eINSTANCE.getEMV2PathElement_ErrorType(), List.of("t1", "t2", "t3", "t4"));

	}

	@Test
	public void testRecordFieldNameReference() throws Exception {
		var ps = """
				property set ps1 is
				\tdef1: record (
				\t\tfield1: aadlinteger;
				\t\tfield2: aadlinteger;
				\t\tfield3: record (
				\t\t\tfield4: aadlinteger;
				\t\t\tfield5: aadlinteger;
				\t\t\tfield6: record (
				\t\t\t\tfield7: aadlinteger;
				\t\t\t\tfield8: aadlinteger;
				\t\t\t\tfield9: aadlinteger;
				\t\t\t);
				\t\t);
				\t) applies to (all);
				end ps1;
				""";
		var pkg = """
				package pkg1
				public
				\twith ps1;
				\t
				\tannex EMV2 {**
				\t\terror types
				\t\t\tt1: type;
				\t\tproperties
				\t\t\tps1::def1 => [
				\t\t\t\tfield1 => 1;
				\t\t\t\tfield2 => 2;
				\t\t\t\tfield3 => [
				\t\t\t\t\tfield4 => 4;
				\t\t\t\t\tfield5 => 5;
				\t\t\t\t\tfield6 => [
				\t\t\t\t\t\tfield7 => 7;
				\t\t\t\t\t\tfield8 => 8;
				\t\t\t\t\t\tfield9 => 9;
				\t\t\t\t\t];
				\t\t\t\t];
				\t\t\t] applies to t1;
				\t\tend types;
				\t**};
				end pkg1;
				""";
		var aadlPackage = this.testHelper.parseString(pkg, ps);
		Assert.assertEquals("pkg1", aadlPackage.getName());
		var recordValue3 = ((RecordValue) ((((ErrorModelLibrary) ((DefaultAnnexLibrary) (aadlPackage.getPublicSection()
				.getOwnedAnnexLibraries()).getFirst()).getParsedAnnexLibrary()).getProperties()).getFirst()
				.getOwnedValues()).getFirst().getOwnedValue());
		final List<String> firstLevelScope = List.of("field1", "field2", "field3");
		final List<String> secondLevelScope = List.of("field4", "field5", "field6");
		final List<String> thirdLevelScope = List.of("field7", "field8", "field9");
		var basicPropertyAssociation7 = recordValue3.getOwnedFieldValues().get(0);
		Assert.assertEquals("field1", basicPropertyAssociation7.getProperty().getName());
		this.assertHelper.assertScope(basicPropertyAssociation7,
				Aadl2Package.eINSTANCE.getBasicPropertyAssociation_Property(), firstLevelScope);
		var basicPropertyAssociation8 = recordValue3.getOwnedFieldValues().get(1);
		Assert.assertEquals("field2", basicPropertyAssociation8.getProperty().getName());
		this.assertHelper.assertScope(basicPropertyAssociation8,
				Aadl2Package.eINSTANCE.getBasicPropertyAssociation_Property(), firstLevelScope);
		var basicPropertyAssociation9 = recordValue3.getOwnedFieldValues().get(2);
		Assert.assertEquals("field3", basicPropertyAssociation9.getProperty().getName());
		this.assertHelper.assertScope(basicPropertyAssociation9,
				Aadl2Package.eINSTANCE.getBasicPropertyAssociation_Property(), firstLevelScope);
		var recordValue2 = ((RecordValue) basicPropertyAssociation9.getOwnedValue());
		var basicPropertyAssociation4 = recordValue2.getOwnedFieldValues().get(0);
		Assert.assertEquals("field4", basicPropertyAssociation4.getProperty().getName());
		this.assertHelper.assertScope(basicPropertyAssociation4,
				Aadl2Package.eINSTANCE.getBasicPropertyAssociation_Property(), secondLevelScope);
		var basicPropertyAssociation5 = recordValue2.getOwnedFieldValues().get(1);
		Assert.assertEquals("field5", basicPropertyAssociation5.getProperty().getName());
		this.assertHelper.assertScope(basicPropertyAssociation5,
				Aadl2Package.eINSTANCE.getBasicPropertyAssociation_Property(), secondLevelScope);
		var basicPropertyAssociation6 = recordValue2.getOwnedFieldValues().get(2);
		Assert.assertEquals("field6", basicPropertyAssociation6.getProperty().getName());
		this.assertHelper.assertScope(basicPropertyAssociation6,
				Aadl2Package.eINSTANCE.getBasicPropertyAssociation_Property(), secondLevelScope);
		var recordValue = ((RecordValue) basicPropertyAssociation6.getOwnedValue());
		var basicPropertyAssociation = recordValue.getOwnedFieldValues().get(0);
		Assert.assertEquals("field7", basicPropertyAssociation.getProperty().getName());
		this.assertHelper.assertScope(basicPropertyAssociation,
				Aadl2Package.eINSTANCE.getBasicPropertyAssociation_Property(), thirdLevelScope);
		var basicPropertyAssociation2 = recordValue.getOwnedFieldValues().get(1);
		Assert.assertEquals("field8", basicPropertyAssociation2.getProperty().getName());
		this.assertHelper.assertScope(basicPropertyAssociation2,
				Aadl2Package.eINSTANCE.getBasicPropertyAssociation_Property(), thirdLevelScope);
		var basicPropertyAssociation3 = recordValue.getOwnedFieldValues().get(2);
		Assert.assertEquals("field9", basicPropertyAssociation3.getProperty().getName());
		this.assertHelper.assertScope(basicPropertyAssociation3,
				Aadl2Package.eINSTANCE.getBasicPropertyAssociation_Property(), thirdLevelScope);

	}

	@Test
	public void testUnitLiteralReference() throws Exception {
		var ps = """
				property set ps1 is
				\tdef1: aadlinteger units Time_Units applies to (all);
				\tdef2: record (
				\t\tfield1: aadlreal units Data_Rate_Units;
				\t\tfield2: record (
				\t\t\tfield3: range of aadlinteger units Processor_Speed_Units;
				\t\t\tfield4: record (
				\t\t\t\tfield5: range of aadlreal units Size_Units;
				\t\t\t);
				\t\t);
				\t) applies to (all);
				end ps1;
				""";
		var pkg = """
				package pkg1
				public
				\twith ps1;
				\t
				\tsystem s
				\tend s;
				\t
				\tannex EMV2 {**
				\t\terror types
				\t\t\tt1: type;
				\t\tproperties
				\t\t\tps1::def1 => 1 ms applies to t1;
				\t\t\tps1::def2 => [
				\t\t\t\tfield1 => 2.2 Bytesps;
				\t\t\t\tfield2 => [
				\t\t\t\t\tfield3 => 3 KIPS .. 4 GIPS;
				\t\t\t\t\tfield4 => [
				\t\t\t\t\t\tfield5 => 5.5 bits .. 6.6 TByte;
				\t\t\t\t\t];
				\t\t\t\t];
				\t\t\t] applies to t1;
				\t\tend types;
				\t**};
				end pkg1;
				""";
		var aadlPackage = this.testHelper.parseString(pkg, ps);
		Assert.assertEquals("pkg1", aadlPackage.getName());
		var errorModelLibrary = ((ErrorModelLibrary) ((DefaultAnnexLibrary) (aadlPackage.getPublicSection()
				.getOwnedAnnexLibraries()).getFirst()).getParsedAnnexLibrary());
		var emv2PropertyAssociation = errorModelLibrary.getProperties().get(0);
		Assert.assertEquals("def1", emv2PropertyAssociation.getProperty().getName());
		this.assertHelper.assertScope((emv2PropertyAssociation.getOwnedValues()).getFirst().getOwnedValue(),
				Aadl2Package.eINSTANCE.getNumberValue_Unit(), List.of("ps", "ns", "us", "ms", "sec", "min", "hr"));
		var emv2PropertyAssociation2 = errorModelLibrary.getProperties().get(1);
		Assert.assertEquals("def2", emv2PropertyAssociation2.getProperty().getName());
		var recordValue2 = ((RecordValue) (emv2PropertyAssociation2.getOwnedValues()).getFirst().getOwnedValue());
		var basicPropertyAssociation4 = recordValue2.getOwnedFieldValues().get(0);
		Assert.assertEquals("field1", basicPropertyAssociation4.getProperty().getName());
		this.assertHelper.assertScope(basicPropertyAssociation4.getOwnedValue(),
				Aadl2Package.eINSTANCE.getNumberValue_Unit(),
				List.of("bitsps", "Bytesps", "KBytesps", "MBytesps", "GBytesps", "kbps", "Mbps", "Gbps"));
		var basicPropertyAssociation5 = recordValue2.getOwnedFieldValues().get(1);
		Assert.assertEquals("field2", basicPropertyAssociation5.getProperty().getName());
		var recordValue = ((RecordValue) basicPropertyAssociation5.getOwnedValue());
		var basicPropertyAssociation2 = recordValue.getOwnedFieldValues().get(0);
		Assert.assertEquals("field3", basicPropertyAssociation2.getProperty().getName());
		PropertyExpression ownedValue2 = basicPropertyAssociation2.getOwnedValue();
		var rangeValue2 = ((RangeValue) ownedValue2);
		this.assertHelper.assertScope(rangeValue2.getMinimum(), Aadl2Package.eINSTANCE.getNumberValue_Unit(),
				List.of("KIPS", "MIPS", "GIPS"));
		this.assertHelper.assertScope(rangeValue2.getMaximum(), Aadl2Package.eINSTANCE.getNumberValue_Unit(),
				List.of("KIPS", "MIPS", "GIPS"));
		var basicPropertyAssociation3 = recordValue.getOwnedFieldValues().get(1);
		Assert.assertEquals("field4", basicPropertyAssociation3.getProperty().getName());
		PropertyExpression ownedValue22 = basicPropertyAssociation3.getOwnedValue();
		var basicPropertyAssociation = (((RecordValue) ownedValue22).getOwnedFieldValues()).getFirst();
		Assert.assertEquals("field5", basicPropertyAssociation.getProperty().getName());
		var rangeValue = ((RangeValue) basicPropertyAssociation.getOwnedValue());
		this.assertHelper.assertScope(rangeValue.getMinimum(), Aadl2Package.eINSTANCE.getNumberValue_Unit(),
				List.of("bits", "Bytes", "KByte", "MByte", "GByte", "TByte", "KiByte", "MiByte", "GiByte", "TiByte"));
		this.assertHelper.assertScope(rangeValue.getMaximum(), Aadl2Package.eINSTANCE.getNumberValue_Unit(),
				List.of("bits", "Bytes", "KByte", "MByte", "GByte", "TByte", "KiByte", "MiByte", "GiByte", "TiByte"));

	}
}
