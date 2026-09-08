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
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider;
import org.osate.testsupport.AssertHelper;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.errormodel.errorModel.CompositeState;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPath;
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedPropagationPoint;
import org.osate.xtext.aadl2.errormodel.errorModel.SConditionElement;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * Verifies subcomponent and propagation-point scopes across nested EMV2 paths.
 */
@RunWith(XtextRunner.class)
@InjectWith(ErrorModelInjectorProvider.class)
public class SubcomponentReferenceTest extends XtextTest {
	@Inject
	private TestHelper<AadlPackage> testHelper;
	private AssertHelper assertHelper = IResourceServiceProvider.Registry.INSTANCE
			.getResourceServiceProvider(URI.createFileURI("dummy.emv2")).<AssertHelper>get(AssertHelper.class);

	/**
	 * Tests scope_SubcomponentElement_subcomponent(ComponentImplementation, EReference),
	 * scope_SubcomponentElement_subcomponent(QualifiedErrorBehaviorState, EReference), and
	 * scope_SubcomponentElement_subcomponent(QualifiedPropagationPoint, EReference)
	 */
	@Test
	public void testSubcomponentReference() throws Exception {
		var lib1 = """
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
		var subclause1 = """
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
				\t\t
				\t\tpropagation paths
				\t\t\tpropPath1: asub1.point1 -> asub1.asub2.point2;
				\t\t\tpropPath2: asub1.asub2.asub3.point3 -> asub1.asub2.asub3.asub4.point4;
				\t\tend paths;
				\t**};
				\tend a1.i;
				\t
				\tabstract a2
				\tannex EMV2 {**
				\t\tuse behavior lib1::bvr2;
				\t\t
				\t\tpropagation paths
				\t\t\tpoint1: propagation point;
				\t\tend paths;
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
				\t\t
				\t\tpropagation paths
				\t\t\tpoint2: propagation point;
				\t\tend paths;
				\t**};
				\tend a3;
				\t
				\tabstract implementation a3.i
				\tsubcomponents
				\t\tasub3: abstract a4.i;
				\tend a3.i;
				\t
				\tabstract a4
				\tannex EMV2 {**
				\t\tuse behavior lib1::bvr4;
				\t\t
				\t\tpropagation paths
				\t\t\tpoint3: propagation point;
				\t\tend paths;
				\t**};
				\tend a4;
				\t
				\tabstract implementation a4.i
				\tsubcomponents
				\t\tasub4: abstract a5;
				\tend a4.i;
				\t
				\tabstract a5
				\tannex EMV2 {**
				\t\tpropagation paths
				\t\t\tpoint4: propagation point;
				\t\tend paths;
				\t**};
				\tend a5;
				end subclause1;
				""";
		final AadlPackage pkg = this.testHelper.parseString(subclause1, lib1);
		Assert.assertEquals("subclause1", pkg.getName());
		var classifier = pkg.getPublicSection().getOwnedClassifiers().get(1);
		Assert.assertEquals("a1.i", classifier.getName());
		var errorModelSubclause = ((ErrorModelSubclause) ((DefaultAnnexSubclause) (classifier.getOwnedAnnexSubclauses())
				.getFirst()).getParsedAnnexSubclause());
		var compositeState = errorModelSubclause.getStates().get(0);
		Assert.assertEquals("compositeState1", compositeState.getName());
		var qualifiedErrorBehaviorState11 = ((SConditionElement) compositeState.getCondition()).getQualifiedState();
		Assert.assertEquals("asub1", qualifiedErrorBehaviorState11.getSubcomponent().getSubcomponent().getName());
		this.assertHelper.assertScope(qualifiedErrorBehaviorState11,
				ErrorModelPackage.eINSTANCE.getSubcomponentElement_Subcomponent(), List.of("asub1"));
		Assert.assertNull(qualifiedErrorBehaviorState11.getNext());
		var compositeState2 = errorModelSubclause.getStates().get(1);
		Assert.assertEquals("compositeState2", compositeState2.getName());
		var qualifiedErrorBehaviorState12 = ((SConditionElement) compositeState2.getCondition()).getQualifiedState();
		Assert.assertEquals("asub1", qualifiedErrorBehaviorState12.getSubcomponent().getSubcomponent().getName());
		this.assertHelper.assertScope(qualifiedErrorBehaviorState12,
				ErrorModelPackage.eINSTANCE.getSubcomponentElement_Subcomponent(), List.of("asub1"));
		var qualifiedErrorBehaviorState5 = qualifiedErrorBehaviorState12.getNext();
		Assert.assertEquals("asub2", qualifiedErrorBehaviorState5.getSubcomponent().getSubcomponent().getName());
		this.assertHelper.assertScope(qualifiedErrorBehaviorState5,
				ErrorModelPackage.eINSTANCE.getSubcomponentElement_Subcomponent(), List.of("asub2"));
		Assert.assertNull(qualifiedErrorBehaviorState5.getNext());
		var compositeState3 = errorModelSubclause.getStates().get(2);
		Assert.assertEquals("compositeState3", compositeState3.getName());
		var qualifiedErrorBehaviorState13 = ((SConditionElement) compositeState3.getCondition()).getQualifiedState();
		Assert.assertEquals("asub1", qualifiedErrorBehaviorState13.getSubcomponent().getSubcomponent().getName());
		this.assertHelper.assertScope(qualifiedErrorBehaviorState13,
				ErrorModelPackage.eINSTANCE.getSubcomponentElement_Subcomponent(), List.of("asub1"));
		var qualifiedErrorBehaviorState6 = qualifiedErrorBehaviorState13.getNext();
		Assert.assertEquals("asub2", qualifiedErrorBehaviorState6.getSubcomponent().getSubcomponent().getName());
		this.assertHelper.assertScope(qualifiedErrorBehaviorState6,
				ErrorModelPackage.eINSTANCE.getSubcomponentElement_Subcomponent(), List.of("asub2"));
		var qualifiedErrorBehaviorState = qualifiedErrorBehaviorState6.getNext();
		Assert.assertEquals("asub3", qualifiedErrorBehaviorState.getSubcomponent().getSubcomponent().getName());
		this.assertHelper.assertScope(qualifiedErrorBehaviorState,
				ErrorModelPackage.eINSTANCE.getSubcomponentElement_Subcomponent(), List.of("asub3"));
		Assert.assertNull(qualifiedErrorBehaviorState.getNext());
		var propagationPath = errorModelSubclause.getPaths().get(0);
		Assert.assertEquals("propPath1", propagationPath.getName());
		var qualifiedPropagationPoint4 = propagationPath.getSource();
		Assert.assertEquals("asub1", qualifiedPropagationPoint4.getSubcomponent().getSubcomponent().getName());
		this.assertHelper.assertScope(qualifiedPropagationPoint4,
				ErrorModelPackage.eINSTANCE.getSubcomponentElement_Subcomponent(), List.of("asub1"));
		var qualifiedErrorBehaviorState7 = qualifiedPropagationPoint4.getNext();
		Assert.assertEquals("point1", qualifiedErrorBehaviorState7.getPropagationPoint().getName());
		this.assertHelper.assertScope(qualifiedErrorBehaviorState7,
				ErrorModelPackage.eINSTANCE.getQualifiedPropagationPoint_PropagationPoint(), List.of("point1"));
		Assert.assertNull(qualifiedErrorBehaviorState7.getNext());
		var qualifiedPropagationPoint5 = propagationPath.getTarget();
		Assert.assertEquals("asub1", qualifiedPropagationPoint5.getSubcomponent().getSubcomponent().getName());
		this.assertHelper.assertScope(qualifiedPropagationPoint5,
				ErrorModelPackage.eINSTANCE.getSubcomponentElement_Subcomponent(), List.of("asub1"));
		var qualifiedErrorBehaviorState8 = qualifiedPropagationPoint5.getNext();
		Assert.assertEquals("asub2", qualifiedErrorBehaviorState8.getSubcomponent().getSubcomponent().getName());
		this.assertHelper.assertScope(qualifiedErrorBehaviorState8,
				ErrorModelPackage.eINSTANCE.getSubcomponentElement_Subcomponent(), List.of("asub2"));
		var qualifiedErrorBehaviorState2 = qualifiedErrorBehaviorState8.getNext();
		Assert.assertEquals("point2", qualifiedErrorBehaviorState2.getPropagationPoint().getName());
		this.assertHelper.assertScope(qualifiedErrorBehaviorState2,
				ErrorModelPackage.eINSTANCE.getQualifiedPropagationPoint_PropagationPoint(), List.of("point2"));
		Assert.assertNull(qualifiedErrorBehaviorState2.getNext());
		var propagationPath2 = errorModelSubclause.getPaths().get(1);
		Assert.assertEquals("propPath2", propagationPath2.getName());
		var qualifiedPropagationPoint6 = propagationPath2.getSource();
		Assert.assertEquals("asub1", qualifiedPropagationPoint6.getSubcomponent().getSubcomponent().getName());
		this.assertHelper.assertScope(qualifiedPropagationPoint6,
				ErrorModelPackage.eINSTANCE.getSubcomponentElement_Subcomponent(), List.of("asub1"));
		var qualifiedErrorBehaviorState9 = qualifiedPropagationPoint6.getNext();
		Assert.assertEquals("asub2", qualifiedErrorBehaviorState9.getSubcomponent().getSubcomponent().getName());
		this.assertHelper.assertScope(qualifiedErrorBehaviorState9,
				ErrorModelPackage.eINSTANCE.getSubcomponentElement_Subcomponent(), List.of("asub2"));
		var qualifiedErrorBehaviorState3 = qualifiedErrorBehaviorState9.getNext();
		Assert.assertEquals("asub3", qualifiedErrorBehaviorState3.getSubcomponent().getSubcomponent().getName());
		this.assertHelper.assertScope(qualifiedErrorBehaviorState3,
				ErrorModelPackage.eINSTANCE.getSubcomponentElement_Subcomponent(), List.of("asub3"));
		var qualifiedPropagationPoint2 = qualifiedErrorBehaviorState3.getNext();
		Assert.assertEquals("point3", qualifiedPropagationPoint2.getPropagationPoint().getName());
		this.assertHelper.assertScope(qualifiedPropagationPoint2,
				ErrorModelPackage.eINSTANCE.getQualifiedPropagationPoint_PropagationPoint(), List.of("point3"));
		Assert.assertNull(qualifiedPropagationPoint2.getNext());
		var qualifiedPropagationPoint7 = propagationPath2.getTarget();
		Assert.assertEquals("asub1", qualifiedPropagationPoint7.getSubcomponent().getSubcomponent().getName());
		this.assertHelper.assertScope(qualifiedPropagationPoint7,
				ErrorModelPackage.eINSTANCE.getSubcomponentElement_Subcomponent(), List.of("asub1"));
		var qualifiedErrorBehaviorState10 = qualifiedPropagationPoint7.getNext();
		Assert.assertEquals("asub2", qualifiedErrorBehaviorState10.getSubcomponent().getSubcomponent().getName());
		this.assertHelper.assertScope(qualifiedErrorBehaviorState10,
				ErrorModelPackage.eINSTANCE.getSubcomponentElement_Subcomponent(), List.of("asub2"));
		var qualifiedErrorBehaviorState4 = qualifiedErrorBehaviorState10.getNext();
		Assert.assertEquals("asub3", qualifiedErrorBehaviorState4.getSubcomponent().getSubcomponent().getName());
		this.assertHelper.assertScope(qualifiedErrorBehaviorState4,
				ErrorModelPackage.eINSTANCE.getSubcomponentElement_Subcomponent(), List.of("asub3"));
		var qualifiedPropagationPoint3 = qualifiedErrorBehaviorState4.getNext();
		Assert.assertEquals("asub4", qualifiedPropagationPoint3.getSubcomponent().getSubcomponent().getName());
		this.assertHelper.assertScope(qualifiedPropagationPoint3,
				ErrorModelPackage.eINSTANCE.getSubcomponentElement_Subcomponent(), List.of("asub4"));
		var qualifiedPropagationPoint = qualifiedPropagationPoint3.getNext();
		Assert.assertEquals("point4", qualifiedPropagationPoint.getPropagationPoint().getName());
		this.assertHelper.assertScope(qualifiedPropagationPoint,
				ErrorModelPackage.eINSTANCE.getQualifiedPropagationPoint_PropagationPoint(), List.of("point4"));
		Assert.assertNull(qualifiedPropagationPoint.getNext());

	}
}
