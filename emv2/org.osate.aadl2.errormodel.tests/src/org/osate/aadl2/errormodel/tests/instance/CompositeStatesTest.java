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
package org.osate.aadl2.errormodel.tests.instance;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.osate.pluginsupport.ScopeFunctions.with;

import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.errormodel.instance.ConditionPropagationReference;
import org.osate.aadl2.errormodel.instance.CountExpression;
import org.osate.aadl2.errormodel.instance.CountExpressionOperation;
import org.osate.aadl2.errormodel.instance.EMV2AnnexInstance;
import org.osate.aadl2.errormodel.instance.NoErrorPropagationReference;
import org.osate.aadl2.errormodel.instance.OthersExpression;
import org.osate.aadl2.errormodel.instance.StateReference;
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;

import com.google.inject.Inject;

@ExtendWith(InjectionExtension.class)
@InjectWith(ErrorModelInjectorProvider.class)
public class CompositeStatesTest {
	private static final String PATH = "org.osate.aadl2.errormodel.tests/models/instantiation/CompositeStates/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Test
	public void testOverriddenComposite() throws Exception {
		var pkg = testHelper.parseFile(PATH + "overridden_composite.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getComposites().size());
		with(annexInstance.getComposites().get(0), composite -> {
			assertEquals("COMPOSITE1", composite.getName());
			assertEquals("COMPOSITE1", composite.getComposite().getName());
			assertEquals("others", composite.getCondition().getName());
			assertEquals("state2", composite.getDestination().getName());
			assertNull(composite.getDestinationTypeSet());
			assertNull(composite.getDestinationTypeToken());
		});
	}

	@Test
	public void testInheritUnnamedComposite() throws Exception {
		var pkg = testHelper.parseFile(PATH + "inherit_unnamed_composite.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(2, annexInstance.getComposites().size());
		with(annexInstance.getComposites().get(0), composite -> {
			assertEquals("[f2 {CommonErrors}]-> state2 {ServiceError}", composite.getName());
			assertSame(((ErrorModelSubclause) ((DefaultAnnexSubclause) system.getOwnedAnnexSubclauses().get(0))
					.getParsedAnnexSubclause()).getStates().get(0), composite.getComposite());
			assertEquals("f2 {CommonErrors}", composite.getCondition().getName());
			assertEquals("state2", composite.getDestination().getName());
			assertEquals("{ServiceError}", composite.getDestinationTypeSet().getName());
			assertEquals("ServiceError", composite.getDestinationTypeToken().getName());
		});
		with(annexInstance.getComposites().get(1), composite -> {
			assertEquals("[f1 {CommonErrors}]-> state1", composite.getName());
			assertSame(((ErrorModelSubclause) ((DefaultAnnexSubclause) pkg.getPublicSection()
					.getOwnedClassifiers()
					.get(0)
					.getOwnedAnnexSubclauses()
					.get(0)).getParsedAnnexSubclause()).getStates().get(0), composite.getComposite());
			assertEquals("f1 {CommonErrors}", composite.getCondition().getName());
			assertEquals("state1", composite.getDestination().getName());
			assertNull(composite.getDestinationTypeSet());
			assertNull(composite.getDestinationTypeToken());
		});
	}

	@Test
	public void testPropagationReference() throws Exception {
		var pkg = testHelper.parseFile(PATH + "propagation_reference.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(6, annexInstance.getComposites().size());
		with(annexInstance.getComposites().get(0), composite -> {
			assertEquals("composite1", composite.getName());
			assertEquals("composite1", composite.getComposite().getName());
			with((ConditionPropagationReference) composite.getCondition(), condition -> {
				assertEquals("f1 {CommonErrors}", condition.getName());
				assertEquals("f1", condition.getPropagation().getName());
				assertEquals("{CommonErrors}", condition.getTypeSet().getName());
			});
			assertEquals("destinationState", composite.getDestination().getName());
			assertNull(composite.getDestinationTypeSet());
			assertNull(composite.getDestinationTypeToken());
		});
		with(annexInstance.getComposites().get(1), composite -> {
			assertEquals("composite2", composite.getName());
			assertEquals("composite2", composite.getComposite().getName());
			with((ConditionPropagationReference) composite.getCondition(), condition -> {
				assertEquals("f2 {ServiceError}", condition.getName());
				assertEquals("f2", condition.getPropagation().getName());
				assertEquals("{ServiceError}", condition.getTypeSet().getName());
			});
			assertEquals("destinationState", composite.getDestination().getName());
			assertNull(composite.getDestinationTypeSet());
			assertNull(composite.getDestinationTypeToken());
		});
		with(annexInstance.getComposites().get(2), composite -> {
			assertEquals("composite3", composite.getName());
			assertEquals("composite3", composite.getComposite().getName());
			with((NoErrorPropagationReference) composite.getCondition(), condition -> {
				assertEquals("f3 {noerror}", condition.getName());
				assertEquals("f3", condition.getPropagation().getName());
			});
			assertEquals("destinationState", composite.getDestination().getName());
			assertNull(composite.getDestinationTypeSet());
			assertNull(composite.getDestinationTypeToken());
		});
		with(annexInstance.getComposites().get(3), composite -> {
			assertEquals("composite4", composite.getName());
			assertEquals("composite4", composite.getComposite().getName());
			with((ConditionPropagationReference) composite.getCondition(), condition -> {
				assertEquals("memory {CommonErrors}", condition.getName());
				assertEquals("memory", condition.getPropagation().getName());
				assertEquals("{CommonErrors}", condition.getTypeSet().getName());
			});
			assertEquals("destinationState", composite.getDestination().getName());
			assertNull(composite.getDestinationTypeSet());
			assertNull(composite.getDestinationTypeToken());
		});
		with(annexInstance.getComposites().get(4), composite -> {
			assertEquals("composite5", composite.getName());
			assertEquals("composite5", composite.getComposite().getName());
			with((ConditionPropagationReference) composite.getCondition(), condition -> {
				assertEquals("fg1.f4 {ServiceError, ItemTimingError}", condition.getName());
				assertEquals("fg1.f4", condition.getPropagation().getName());
				assertEquals("{ServiceError, ItemTimingError}", condition.getTypeSet().getName());
			});
			assertEquals("destinationState", composite.getDestination().getName());
			assertNull(composite.getDestinationTypeSet());
			assertNull(composite.getDestinationTypeToken());
		});
		with(annexInstance.getComposites().get(5), composite -> {
			assertEquals("composite6", composite.getName());
			assertEquals("composite6", composite.getComposite().getName());
			with((ConditionPropagationReference) composite.getCondition(), condition -> {
				assertEquals("fg1.fg2.fg3.f5 {CommonErrors}", condition.getName());
				assertEquals("fg1.fg2.fg3.f5", condition.getPropagation().getName());
				assertEquals("{CommonErrors}", condition.getTypeSet().getName());
			});
			assertEquals("destinationState", composite.getDestination().getName());
			assertNull(composite.getDestinationTypeSet());
			assertNull(composite.getDestinationTypeToken());
		});
	}

	@Test
	public void testStateReference() throws Exception {
		var pkg = testHelper.parseFile(PATH + "state_reference.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(6, annexInstance.getComposites().size());
		with(annexInstance.getComposites().get(0), composite -> {
			assertEquals("composite1", composite.getName());
			assertEquals("composite1", composite.getComposite().getName());
			with((StateReference) composite.getCondition(), condition -> {
				assertEquals("sub1.state1", condition.getName());
				assertEquals("state1", condition.getState().getName());
				assertNull(condition.getTypeSet());
			});
			assertEquals("destinationState", composite.getDestination().getName());
			assertNull(composite.getDestinationTypeSet());
			assertNull(composite.getDestinationTypeToken());
		});
		with(annexInstance.getComposites().get(1), composite -> {
			assertEquals("composite2", composite.getName());
			assertEquals("composite2", composite.getComposite().getName());
			with((StateReference) composite.getCondition(), condition -> {
				assertEquals("sub1.state2 {ServiceError}", condition.getName());
				assertEquals("state2", condition.getState().getName());
				assertEquals("{ServiceError}", condition.getTypeSet().getName());
			});
			assertEquals("destinationState", composite.getDestination().getName());
			assertNull(composite.getDestinationTypeSet());
			assertNull(composite.getDestinationTypeToken());
		});
		with(annexInstance.getComposites().get(2), composite -> {
			assertEquals("composite3", composite.getName());
			assertEquals("composite3", composite.getComposite().getName());
			with((StateReference) composite.getCondition(), condition -> {
				assertEquals("sub1.state3 {CommonErrors}", condition.getName());
				assertEquals("state3", condition.getState().getName());
				assertEquals("{CommonErrors}", condition.getTypeSet().getName());
			});
			assertEquals("destinationState", composite.getDestination().getName());
			assertNull(composite.getDestinationTypeSet());
			assertNull(composite.getDestinationTypeToken());
		});
		with(annexInstance.getComposites().get(3), composite -> {
			assertEquals("composite4", composite.getName());
			assertEquals("composite4", composite.getComposite().getName());
			with((StateReference) composite.getCondition(), condition -> {
				assertEquals("sub1.sub2.sub3.state4", condition.getName());
				assertEquals("state4", condition.getState().getName());
				assertNull(condition.getTypeSet());
			});
			assertEquals("destinationState", composite.getDestination().getName());
			assertNull(composite.getDestinationTypeSet());
			assertNull(composite.getDestinationTypeToken());
		});
		with(annexInstance.getComposites().get(4), composite -> {
			assertEquals("composite5", composite.getName());
			assertEquals("composite5", composite.getComposite().getName());
			with((StateReference) composite.getCondition(), condition -> {
				assertEquals("sub1.sub2.sub3.state5 {ServiceError, ItemTimingError}", condition.getName());
				assertEquals("state5", condition.getState().getName());
				assertEquals("{ServiceError, ItemTimingError}", condition.getTypeSet().getName());
			});
			assertEquals("destinationState", composite.getDestination().getName());
			assertNull(composite.getDestinationTypeSet());
			assertNull(composite.getDestinationTypeToken());
		});
		with(annexInstance.getComposites().get(5), composite -> {
			assertEquals("composite6", composite.getName());
			assertEquals("composite6", composite.getComposite().getName());
			with((StateReference) composite.getCondition(), condition -> {
				assertEquals("sub1.sub2.sub3.state6 {CommonErrors}", condition.getName());
				assertEquals("state6", condition.getState().getName());
				assertEquals("{CommonErrors}", condition.getTypeSet().getName());
			});
			assertEquals("destinationState", composite.getDestination().getName());
			assertNull(composite.getDestinationTypeSet());
			assertNull(composite.getDestinationTypeToken());
		});
	}

	@Test
	public void testCountExpressions() throws Exception {
		var pkg = testHelper.parseFile(PATH + "count_expressions.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(5, annexInstance.getComposites().size());
		with(annexInstance.getComposites().get(0), composite -> {
			assertEquals("composite1", composite.getName());
			assertEquals("composite1", composite.getComposite().getName());
			with((CountExpression) composite.getCondition(), condition -> {
				assertEquals("count(sub1.state1, sub1.state2) >= 1", condition.getName());
				assertIterableEquals(List.of("sub1.state1", "sub1.state2"),
						condition.getOperands().stream().map(NamedElement::getName).toList());
				assertEquals(CountExpressionOperation.GREATER_EQUAL, condition.getOperation());
				assertEquals(1, condition.getCount());
			});
			assertEquals("destinationState", composite.getDestination().getName());
			assertNull(composite.getDestinationTypeSet());
			assertNull(composite.getDestinationTypeToken());
		});
		with(annexInstance.getComposites().get(1), composite -> {
			assertEquals("composite2", composite.getName());
			assertEquals("composite2", composite.getComposite().getName());
			with((CountExpression) composite.getCondition(), condition -> {
				assertEquals("count(sub1.state1, sub1.state2) == 2", condition.getName());
				assertIterableEquals(List.of("sub1.state1", "sub1.state2"),
						condition.getOperands().stream().map(NamedElement::getName).toList());
				assertEquals(CountExpressionOperation.EQUALS, condition.getOperation());
				assertEquals(2, condition.getCount());
			});
			assertEquals("destinationState", composite.getDestination().getName());
			assertNull(composite.getDestinationTypeSet());
			assertNull(composite.getDestinationTypeToken());
		});
		with(annexInstance.getComposites().get(2), composite -> {
			assertEquals("composite3", composite.getName());
			assertEquals("composite3", composite.getComposite().getName());
			with((CountExpression) composite.getCondition(), condition -> {
				assertEquals("count(sub1.state1, sub1.state2, sub1.state3) >= 2", condition.getName());
				assertIterableEquals(List.of("sub1.state1", "sub1.state2", "sub1.state3"),
						condition.getOperands().stream().map(NamedElement::getName).toList());
				assertEquals(CountExpressionOperation.GREATER_EQUAL, condition.getOperation());
				assertEquals(2, condition.getCount());
			});
			assertEquals("destinationState", composite.getDestination().getName());
			assertNull(composite.getDestinationTypeSet());
			assertNull(composite.getDestinationTypeToken());
		});
		with(annexInstance.getComposites().get(3), composite -> {
			assertEquals("composite4", composite.getName());
			assertEquals("composite4", composite.getComposite().getName());
			with((CountExpression) composite.getCondition(), condition -> {
				assertEquals("count(sub1.state1, sub1.state2, sub1.state3) <= 2", condition.getName());
				assertIterableEquals(List.of("sub1.state1", "sub1.state2", "sub1.state3"),
						condition.getOperands().stream().map(NamedElement::getName).toList());
				assertEquals(CountExpressionOperation.LESS_EQUAL, condition.getOperation());
				assertEquals(2, condition.getCount());
			});
			assertEquals("destinationState", composite.getDestination().getName());
			assertNull(composite.getDestinationTypeSet());
			assertNull(composite.getDestinationTypeToken());
		});
		with(annexInstance.getComposites().get(4), composite -> {
			assertEquals("composite5", composite.getName());
			assertEquals("composite5", composite.getComposite().getName());
			with((CountExpression) composite.getCondition(), condition -> {
				assertEquals("count(sub1.state1, count(sub1.state2, sub1.state3) >= 1) == 2", condition.getName());
				assertEquals(2, condition.getOperands().size());
				assertEquals("sub1.state1", condition.getOperands().get(0).getName());
				with((CountExpression) condition.getOperands().get(1), nested1 -> {
					assertEquals("count(sub1.state2, sub1.state3) >= 1", nested1.getName());
					assertEquals(2, nested1.getOperands().size());
					assertIterableEquals(List.of("sub1.state2", "sub1.state3"),
							nested1.getOperands().stream().map(NamedElement::getName).toList());
					assertEquals(CountExpressionOperation.GREATER_EQUAL, nested1.getOperation());
					assertEquals(1, nested1.getCount());
				});
				assertEquals(CountExpressionOperation.EQUALS, condition.getOperation());
				assertEquals(2, condition.getCount());
			});
			assertEquals("destinationState", composite.getDestination().getName());
			assertNull(composite.getDestinationTypeSet());
			assertNull(composite.getDestinationTypeToken());
		});
	}

	@Test
	public void testOthersExpression() throws Exception {
		var pkg = testHelper.parseFile(PATH + "others_expression.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getComposites().size());
		with(annexInstance.getComposites().get(0), composite -> {
			assertEquals("composite1", composite.getName());
			assertEquals("composite1", composite.getComposite().getName());
			with((OthersExpression) composite.getCondition(), condition -> {
				assertEquals("others", condition.getName());
			});
			assertEquals("destinationState", composite.getDestination().getName());
			assertNull(composite.getDestinationTypeSet());
			assertNull(composite.getDestinationTypeToken());
		});
	}

	@Test
	public void testDestination() throws Exception {
		var pkg = testHelper.parseFile(PATH + "destination.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(2, annexInstance.getComposites().size());
		with(annexInstance.getComposites().get(0), composite -> {
			assertEquals("composite1", composite.getName());
			assertEquals("composite1", composite.getComposite().getName());
			assertEquals("f1 {CommonErrors}", composite.getCondition().getName());
			assertEquals("state1", composite.getDestination().getName());
			assertNull(composite.getDestinationTypeSet());
			assertNull(composite.getDestinationTypeToken());
		});
		with(annexInstance.getComposites().get(1), composite -> {
			assertEquals("composite2", composite.getName());
			assertEquals("composite2", composite.getComposite().getName());
			assertEquals("f2 {CommonErrors}", composite.getCondition().getName());
			assertEquals("state2", composite.getDestination().getName());
			assertEquals("{ServiceError}", composite.getDestinationTypeSet().getName());
			assertEquals("ServiceError", composite.getDestinationTypeToken().getName());
		});
	}
}