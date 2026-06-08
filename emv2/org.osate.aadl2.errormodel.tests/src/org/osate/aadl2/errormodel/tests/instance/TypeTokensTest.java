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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.osate.pluginsupport.ScopeFunctions.with;

import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.errormodel.instance.EMV2AnnexInstance;
import org.osate.aadl2.errormodel.instance.FeaturePropagation;
import org.osate.aadl2.errormodel.instance.TypeInstance;
import org.osate.aadl2.errormodel.instance.TypeProductInstance;
import org.osate.aadl2.errormodel.instance.TypeSetInstance;
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

@ExtendWith(InjectionExtension.class)
@InjectWith(ErrorModelInjectorProvider.class)
public class TypeTokensTest {
	private static final String PATH = "org.osate.aadl2.errormodel.tests/models/instantiation/TypeTokens/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Test
	public void testTypeInstance() throws Exception {
		var pkg = testHelper.parseFile(PATH + "type_reference_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getPropagations().size());
		with((FeaturePropagation) annexInstance.getPropagations().get(0), propagation -> {
			assertEquals("f", propagation.getName());
			assertNull(propagation.getInTypeSet());
			assertEquals(2, propagation.getOutTypeSet().getElements().size());
			assertEquals("{ServiceError, TimingError}", propagation.getOutTypeSet().getName());
			with((TypeInstance) propagation.getOutTypeSet().getElements().get(0), type -> {
				assertEquals("ServiceError", type.getName());
				assertEquals("ServiceError", type.getType().getName());
				assertEquals("ServiceError", type.resolveAlias().getName());
			});
			with((TypeInstance) propagation.getOutTypeSet().getElements().get(1), type -> {
				assertEquals("TimingError", type.getName());
				assertEquals("TimingError", type.getType().getName());
				assertEquals("ItemTimingError", type.resolveAlias().getName());
			});
		});
	}

	@Test
	public void testTypeProduct() throws Exception {
		var pkg = testHelper.parseFile(PATH + "type_product_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getPropagations().size());
		with((FeaturePropagation) annexInstance.getPropagations().get(0), propagation -> {
			assertEquals("f", propagation.getName());
			assertNull(propagation.getInTypeSet());
			assertEquals(1, propagation.getOutTypeSet().getElements().size());
			assertEquals("{ServiceError * TimingError}", propagation.getOutTypeSet().getName());
			with((TypeProductInstance) propagation.getOutTypeSet().getElements().get(0), product -> {
				assertEquals("ServiceError * TimingError", product.getName());
				assertEquals(2, product.getTypes().size());
				with(product.getTypes().get(0), type -> {
					assertEquals("ServiceError", type.getName());
					assertEquals("ServiceError", type.getType().getName());
					assertEquals("ServiceError", type.resolveAlias().getName());
				});
				with(product.getTypes().get(1), type -> {
					assertEquals("TimingError", type.getName());
					assertEquals("TimingError", type.getType().getName());
					assertEquals("ItemTimingError", type.resolveAlias().getName());
				});
			});
		});
	}

	@Test
	public void testSetOfTypes() throws Exception {
		var pkg = testHelper.parseFile(PATH + "set_of_types_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getPropagations().size());
		with((FeaturePropagation) annexInstance.getPropagations().get(0), propagation -> {
			assertEquals("f", propagation.getName());
			assertNull(propagation.getInTypeSet());
			assertEquals(2, propagation.getOutTypeSet().getElements().size());
			assertEquals("{TimingRelatedError, ValueErrors}", propagation.getOutTypeSet().getName());
			with((TypeSetInstance) propagation.getOutTypeSet().getElements().get(0), set -> {
				assertEquals("TimingRelatedError", set.getName());
				assertEquals("TimingRelatedError", set.getTypeSet().getName());
				assertEquals("TimingRelatedError", set.resolveAlias().getName());
				assertEquals(3, set.getElements().size());
				with((TypeInstance) set.getElements().get(0), type -> {
					assertEquals("ItemTimingError", type.getName());
					assertEquals("ItemTimingError", type.getType().getName());
					assertEquals("ItemTimingError", type.resolveAlias().getName());
				});
				with((TypeInstance) set.getElements().get(1), type -> {
					assertEquals("SequenceTimingError", type.getName());
					assertEquals("SequenceTimingError", type.getType().getName());
					assertEquals("SequenceTimingError", type.resolveAlias().getName());
				});
				with((TypeInstance) set.getElements().get(2), type -> {
					assertEquals("ServiceTimingError", type.getName());
					assertEquals("ServiceTimingError", type.getType().getName());
					assertEquals("ServiceTimingError", type.resolveAlias().getName());
				});
				assertIterableEquals(List.of("ItemTimingError", "SequenceTimingError", "ServiceTimingError"),
						set.flatten().stream().map(NamedElement::getName).toList());
			});
			with((TypeSetInstance) propagation.getOutTypeSet().getElements().get(1), set -> {
				assertEquals("ValueErrors", set.getName());
				assertEquals("ValueErrors", set.getTypeSet().getName());
				assertEquals("ValueRelatedError", set.resolveAlias().getName());
				assertEquals(3, set.getElements().size());
				with((TypeInstance) set.getElements().get(0), type -> {
					assertEquals("ItemValueError", type.getName());
					assertEquals("ItemValueError", type.getType().getName());
					assertEquals("ItemValueError", type.resolveAlias().getName());
				});
				with((TypeInstance) set.getElements().get(1), type -> {
					assertEquals("SequenceValueError", type.getName());
					assertEquals("SequenceValueError", type.getType().getName());
					assertEquals("SequenceValueError", type.resolveAlias().getName());
				});
				with((TypeInstance) set.getElements().get(2), type -> {
					assertEquals("ServiceValueError", type.getName());
					assertEquals("ServiceValueError", type.getType().getName());
					assertEquals("ServiceValueError", type.resolveAlias().getName());
				});
				assertIterableEquals(List.of("ItemValueError", "SequenceValueError", "ServiceValueError"),
						set.flatten().stream().map(NamedElement::getName).toList());
			});
		});
	}

	@Test
	public void testSetOfSets() throws Exception {
		var pkg = testHelper.parseFile(PATH + "set_of_sets_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getPropagations().size());
		with((FeaturePropagation) annexInstance.getPropagations().get(0), propagation -> {
			assertEquals("f", propagation.getName());
			assertNull(propagation.getInTypeSet());
			assertEquals(1, propagation.getOutTypeSet().getElements().size());
			assertEquals("{CommonErrors}", propagation.getOutTypeSet().getName());
			with((TypeSetInstance) propagation.getOutTypeSet().getElements().get(0), element -> {
				assertEquals("CommonErrors", element.getName());
				assertEquals("CommonErrors", element.getTypeSet().getName());
				assertEquals("CommonErrors", element.resolveAlias().getName());
				assertEquals(5, element.getElements().size());
				with((TypeInstance) element.getElements().get(0), type -> {
					assertEquals("ServiceError", type.getName());
					assertEquals("ServiceError", type.getType().getName());
					assertEquals("ServiceError", type.resolveAlias().getName());
				});
				with((TypeSetInstance) element.getElements().get(1), set -> {
					assertEquals("TimingRelatedError", set.getName());
					assertEquals("TimingRelatedError", set.getTypeSet().getName());
					assertEquals("TimingRelatedError", set.resolveAlias().getName());
					assertEquals(3, set.getElements().size());
					with((TypeInstance) set.getElements().get(0), type -> {
						assertEquals("ItemTimingError", type.getName());
						assertEquals("ItemTimingError", type.getType().getName());
						assertEquals("ItemTimingError", type.resolveAlias().getName());
					});
					with((TypeInstance) set.getElements().get(1), type -> {
						assertEquals("SequenceTimingError", type.getName());
						assertEquals("SequenceTimingError", type.getType().getName());
						assertEquals("SequenceTimingError", type.resolveAlias().getName());
					});
					with((TypeInstance) set.getElements().get(2), type -> {
						assertEquals("ServiceTimingError", type.getName());
						assertEquals("ServiceTimingError", type.getType().getName());
						assertEquals("ServiceTimingError", type.resolveAlias().getName());
					});
					assertIterableEquals(List.of("ItemTimingError", "SequenceTimingError", "ServiceTimingError"),
							set.flatten().stream().map(NamedElement::getName).toList());
				});
				with((TypeSetInstance) element.getElements().get(2), set -> {
					assertEquals("ValueRelatedError", set.getName());
					assertEquals("ValueRelatedError", set.getTypeSet().getName());
					assertEquals("ValueRelatedError", set.resolveAlias().getName());
					assertEquals(3, set.getElements().size());
					with((TypeInstance) set.getElements().get(0), type -> {
						assertEquals("ItemValueError", type.getName());
						assertEquals("ItemValueError", type.getType().getName());
						assertEquals("ItemValueError", type.resolveAlias().getName());
					});
					with((TypeInstance) set.getElements().get(1), type -> {
						assertEquals("SequenceValueError", type.getName());
						assertEquals("SequenceValueError", type.getType().getName());
						assertEquals("SequenceValueError", type.resolveAlias().getName());
					});
					with((TypeInstance) set.getElements().get(2), type -> {
						assertEquals("ServiceValueError", type.getName());
						assertEquals("ServiceValueError", type.getType().getName());
						assertEquals("ServiceValueError", type.resolveAlias().getName());
					});
					assertIterableEquals(List.of("ItemValueError", "SequenceValueError", "ServiceValueError"),
							set.flatten().stream().map(NamedElement::getName).toList());
				});
				with((TypeInstance) element.getElements().get(3), type -> {
					assertEquals("ReplicationError", type.getName());
					assertEquals("ReplicationError", type.getType().getName());
					assertEquals("ReplicationError", type.resolveAlias().getName());
				});
				with((TypeInstance) element.getElements().get(4), type -> {
					assertEquals("ConcurrencyError", type.getName());
					assertEquals("ConcurrencyError", type.getType().getName());
					assertEquals("ConcurrencyError", type.resolveAlias().getName());
				});
				assertIterableEquals(
						List.of("ServiceError", "ItemTimingError", "SequenceTimingError", "ServiceTimingError",
								"ItemValueError", "SequenceValueError", "ServiceValueError", "ReplicationError",
								"ConcurrencyError"),
						element.flatten().stream().map(NamedElement::getName).toList());
			});
		});
	}

	@Test
	public void testSetOfProducts() throws Exception {
		var pkg = testHelper.parseFile(PATH + "set_of_products_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getPropagations().size());
		with((FeaturePropagation) annexInstance.getPropagations().get(0), propagation -> {
			assertEquals("f", propagation.getName());
			assertNull(propagation.getInTypeSet());
			assertEquals(1, propagation.getOutTypeSet().getElements().size());
			assertEquals("{ProductSet}", propagation.getOutTypeSet().getName());
			with((TypeSetInstance) propagation.getOutTypeSet().getElements().get(0), set -> {
				assertEquals("ProductSet", set.getName());
				assertEquals("ProductSet", set.getTypeSet().getName());
				assertEquals("ProductSet", set.resolveAlias().getName());
				assertEquals(1, set.getElements().size());
				with((TypeProductInstance) set.getElements().get(0), product -> {
					assertEquals("ServiceError * ItemTimingError", product.getName());
					assertEquals(2, product.getTypes().size());
					with(product.getTypes().get(0), type -> {
						assertEquals("ServiceError", type.getName());
						assertEquals("ServiceError", type.getType().getName());
						assertEquals("ServiceError", type.resolveAlias().getName());
					});
					with(product.getTypes().get(1), type -> {
						assertEquals("ItemTimingError", type.getName());
						assertEquals("ItemTimingError", type.getType().getName());
						assertEquals("ItemTimingError", type.resolveAlias().getName());
					});
				});
				assertIterableEquals(List.of("ServiceError * ItemTimingError"),
						set.flatten().stream().map(NamedElement::getName).toList());
			});
		});
	}

	@Test
	public void testAllTokens() throws Exception {
		var pkg = testHelper.parseFile(PATH + "all_tokens_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getPropagations().size());
		with((FeaturePropagation) annexInstance.getPropagations().get(0), propagation -> {
			assertEquals("f", propagation.getName());
			assertEquals(4, propagation.getInTypeSet().getElements().size());
			assertEquals(3, propagation.getOutTypeSet().getElements().size());
			assertEquals("{Error1, CommonErrors, Error2 * Error3, ProductSet}", propagation.getInTypeSet().getName());
			assertEquals("{ServiceError, TimingRelatedError, ReplicationError * ConcurrencyError}",
					propagation.getOutTypeSet().getName());
			with((TypeInstance) propagation.getInTypeSet().getElements().get(0), element -> {
				assertEquals("Error1", element.getName());
				assertEquals("Error1", element.getType().getName());
				assertEquals("Error1", element.resolveAlias().getName());
			});
			with((TypeSetInstance) propagation.getInTypeSet().getElements().get(1), element -> {
				assertEquals("CommonErrors", element.getName());
				assertEquals("CommonErrors", element.getTypeSet().getName());
				assertEquals("CommonErrors", element.resolveAlias().getName());
				assertEquals(5, element.getElements().size());
				with((TypeInstance) element.getElements().get(0), type -> {
					assertEquals("ServiceError", type.getName());
					assertEquals("ServiceError", type.getType().getName());
					assertEquals("ServiceError", type.resolveAlias().getName());
				});
				with((TypeSetInstance) element.getElements().get(1), set -> {
					assertEquals("TimingRelatedError", set.getName());
					assertEquals("TimingRelatedError", set.getTypeSet().getName());
					assertEquals("TimingRelatedError", set.resolveAlias().getName());
					assertEquals(3, set.getElements().size());
					with((TypeInstance) set.getElements().get(0), type -> {
						assertEquals("ItemTimingError", type.getName());
						assertEquals("ItemTimingError", type.getType().getName());
						assertEquals("ItemTimingError", type.resolveAlias().getName());
					});
					with((TypeInstance) set.getElements().get(1), type -> {
						assertEquals("SequenceTimingError", type.getName());
						assertEquals("SequenceTimingError", type.getType().getName());
						assertEquals("SequenceTimingError", type.resolveAlias().getName());
					});
					with((TypeInstance) set.getElements().get(2), type -> {
						assertEquals("ServiceTimingError", type.getName());
						assertEquals("ServiceTimingError", type.getType().getName());
						assertEquals("ServiceTimingError", type.resolveAlias().getName());
					});
					assertIterableEquals(List.of("ItemTimingError", "SequenceTimingError", "ServiceTimingError"),
							set.flatten().stream().map(NamedElement::getName).toList());
				});
				with((TypeSetInstance) element.getElements().get(2), set -> {
					assertEquals("ValueRelatedError", set.getName());
					assertEquals("ValueRelatedError", set.getTypeSet().getName());
					assertEquals("ValueRelatedError", set.resolveAlias().getName());
					assertEquals(3, set.getElements().size());
					with((TypeInstance) set.getElements().get(0), type -> {
						assertEquals("ItemValueError", type.getName());
						assertEquals("ItemValueError", type.getType().getName());
						assertEquals("ItemValueError", type.resolveAlias().getName());
					});
					with((TypeInstance) set.getElements().get(1), type -> {
						assertEquals("SequenceValueError", type.getName());
						assertEquals("SequenceValueError", type.getType().getName());
						assertEquals("SequenceValueError", type.resolveAlias().getName());
					});
					with((TypeInstance) set.getElements().get(2), type -> {
						assertEquals("ServiceValueError", type.getName());
						assertEquals("ServiceValueError", type.getType().getName());
						assertEquals("ServiceValueError", type.resolveAlias().getName());
					});
					assertIterableEquals(List.of("ItemValueError", "SequenceValueError", "ServiceValueError"),
							set.flatten().stream().map(NamedElement::getName).toList());
				});
				with((TypeInstance) element.getElements().get(3), type -> {
					assertEquals("ReplicationError", type.getName());
					assertEquals("ReplicationError", type.getType().getName());
					assertEquals("ReplicationError", type.resolveAlias().getName());
				});
				with((TypeInstance) element.getElements().get(4), type -> {
					assertEquals("ConcurrencyError", type.getName());
					assertEquals("ConcurrencyError", type.getType().getName());
					assertEquals("ConcurrencyError", type.resolveAlias().getName());
				});
				assertIterableEquals(
						List.of("ServiceError", "ItemTimingError", "SequenceTimingError", "ServiceTimingError",
								"ItemValueError", "SequenceValueError", "ServiceValueError", "ReplicationError",
								"ConcurrencyError"),
						element.flatten().stream().map(NamedElement::getName).toList());
			});
			with((TypeProductInstance) propagation.getInTypeSet().getElements().get(2), element -> {
				assertEquals("Error2 * Error3", element.getName());
				assertEquals(2, element.getTypes().size());
				with(element.getTypes().get(0), type -> {
					assertEquals("Error2", type.getName());
					assertEquals("Error2", type.getType().getName());
					assertEquals("Error2", type.resolveAlias().getName());
				});
				with(element.getTypes().get(1), type -> {
					assertEquals("Error3", type.getName());
					assertEquals("Error3", type.getType().getName());
					assertEquals("Error3", type.resolveAlias().getName());
				});
			});
			with((TypeSetInstance) propagation.getInTypeSet().getElements().get(3), element -> {
				assertEquals("ProductSet", element.getName());
				assertEquals("ProductSet", element.getTypeSet().getName());
				assertEquals("ProductSet", element.resolveAlias().getName());
				assertEquals(2, element.getElements().size());
				with((TypeProductInstance) element.getElements().get(0), product -> {
					assertEquals("Error4 * Error5", product.getName());
					assertEquals(2, product.getTypes().size());
					with(product.getTypes().get(0), type -> {
						assertEquals("Error4", type.getName());
						assertEquals("Error4", type.getType().getName());
						assertEquals("Error4", type.resolveAlias().getName());
					});
					with(product.getTypes().get(1), type -> {
						assertEquals("Error5", type.getName());
						assertEquals("Error5", type.getType().getName());
						assertEquals("Error5", type.resolveAlias().getName());
					});
				});
				with((TypeInstance) element.getElements().get(1), type -> {
					assertEquals("Error6", type.getName());
					assertEquals("Error6", type.getType().getName());
					assertEquals("Error6", type.resolveAlias().getName());
				});
				assertIterableEquals(List.of("Error4 * Error5", "Error6"),
						element.flatten().stream().map(NamedElement::getName).toList());
			});
			with((TypeInstance) propagation.getOutTypeSet().getElements().get(0), element -> {
				assertEquals("ServiceError", element.getName());
				assertEquals("ServiceError", element.getType().getName());
				assertEquals("ServiceError", element.resolveAlias().getName());
			});
			with((TypeSetInstance) propagation.getOutTypeSet().getElements().get(1), element -> {
				assertEquals("TimingRelatedError", element.getName());
				assertEquals("TimingRelatedError", element.getTypeSet().getName());
				assertEquals("TimingRelatedError", element.resolveAlias().getName());
				assertEquals(3, element.getElements().size());
				with((TypeInstance) element.getElements().get(0), type -> {
					assertEquals("ItemTimingError", type.getName());
					assertEquals("ItemTimingError", type.getType().getName());
					assertEquals("ItemTimingError", type.resolveAlias().getName());
				});
				with((TypeInstance) element.getElements().get(1), type -> {
					assertEquals("SequenceTimingError", type.getName());
					assertEquals("SequenceTimingError", type.getType().getName());
					assertEquals("SequenceTimingError", type.resolveAlias().getName());
				});
				with((TypeInstance) element.getElements().get(2), type -> {
					assertEquals("ServiceTimingError", type.getName());
					assertEquals("ServiceTimingError", type.getType().getName());
					assertEquals("ServiceTimingError", type.resolveAlias().getName());
				});
				assertIterableEquals(List.of("ItemTimingError", "SequenceTimingError", "ServiceTimingError"),
						element.flatten().stream().map(NamedElement::getName).toList());
			});
			with((TypeProductInstance) propagation.getOutTypeSet().getElements().get(2), element -> {
				assertEquals("ReplicationError * ConcurrencyError", element.getName());
				assertEquals(2, element.getTypes().size());
				with(element.getTypes().get(0), type -> {
					assertEquals("ReplicationError", type.getName());
					assertEquals("ReplicationError", type.getType().getName());
					assertEquals("ReplicationError", type.resolveAlias().getName());
				});
				with(element.getTypes().get(1), type -> {
					assertEquals("ConcurrencyError", type.getName());
					assertEquals("ConcurrencyError", type.getType().getName());
					assertEquals("ConcurrencyError", type.resolveAlias().getName());
				});
			});
			assertIterableEquals(
					List.of("Error1", "ServiceError", "ItemTimingError", "SequenceTimingError", "ServiceTimingError",
							"ItemValueError", "SequenceValueError", "ServiceValueError", "ReplicationError",
							"ConcurrencyError", "Error2 * Error3", "Error4 * Error5", "Error6"),
					propagation.getInTypeSet().flatten().stream().map(NamedElement::getName).toList());
			assertIterableEquals(
					List.of("ServiceError", "ItemTimingError", "SequenceTimingError", "ServiceTimingError",
							"ReplicationError * ConcurrencyError"),
					propagation.getOutTypeSet().flatten().stream().map(NamedElement::getName).toList());
		});
	}
}