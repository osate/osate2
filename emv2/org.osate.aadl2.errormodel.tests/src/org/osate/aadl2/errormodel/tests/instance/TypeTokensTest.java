package org.osate.aadl2.errormodel.tests.instance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.osate.testsupport.ScopeFunctions.with;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
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

@RunWith(XtextRunner.class)
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
			with((TypeInstance) propagation.getOutTypeSet().getElements().get(0), type -> {
				assertEquals("ServiceError", type.getName());
				assertEquals("ServiceError", type.getType().getName());
				assertEquals("ServiceError", type.getResolvedType().getName());
			});
			with((TypeInstance) propagation.getOutTypeSet().getElements().get(1), type -> {
				assertEquals("TimingError", type.getName());
				assertEquals("TimingError", type.getType().getName());
				assertEquals("ItemTimingError", type.getResolvedType().getName());
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
			with((TypeProductInstance) propagation.getOutTypeSet().getElements().get(0), product -> {
				assertEquals("ServiceError * TimingError", product.getName());
				assertEquals(2, product.getTypes().size());
				with(product.getTypes().get(0), type -> {
					assertEquals("ServiceError", type.getName());
					assertEquals("ServiceError", type.getType().getName());
					assertEquals("ServiceError", type.getResolvedType().getName());
				});
				with(product.getTypes().get(1), type -> {
					assertEquals("TimingError", type.getName());
					assertEquals("TimingError", type.getType().getName());
					assertEquals("ItemTimingError", type.getResolvedType().getName());
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
			with((TypeSetInstance) propagation.getOutTypeSet().getElements().get(0), set -> {
				assertEquals("TimingRelatedError", set.getName());
				assertEquals("TimingRelatedError", set.getTypeSet().getName());
				assertEquals("TimingRelatedError", set.getResolvedTypeSet().getName());
				assertEquals(3, set.getElements().size());
				with((TypeInstance) set.getElements().get(0), type -> {
					assertEquals("ItemTimingError", type.getName());
					assertEquals("ItemTimingError", type.getType().getName());
					assertEquals("ItemTimingError", type.getResolvedType().getName());
				});
				with((TypeInstance) set.getElements().get(1), type -> {
					assertEquals("SequenceTimingError", type.getName());
					assertEquals("SequenceTimingError", type.getType().getName());
					assertEquals("SequenceTimingError", type.getResolvedType().getName());
				});
				with((TypeInstance) set.getElements().get(2), type -> {
					assertEquals("ServiceTimingError", type.getName());
					assertEquals("ServiceTimingError", type.getType().getName());
					assertEquals("ServiceTimingError", type.getResolvedType().getName());
				});
				assertEquals(3, set.flatten().size());
				assertEquals("ItemTimingError", set.flatten().get(0).getName());
				assertEquals("SequenceTimingError", set.flatten().get(1).getName());
				assertEquals("ServiceTimingError", set.flatten().get(2).getName());
			});
			with((TypeSetInstance) propagation.getOutTypeSet().getElements().get(1), set -> {
				assertEquals("ValueErrors", set.getName());
				assertEquals("ValueErrors", set.getTypeSet().getName());
				assertEquals("ValueRelatedError", set.getResolvedTypeSet().getName());
				assertEquals(3, set.getElements().size());
				with((TypeInstance) set.getElements().get(0), type -> {
					assertEquals("ItemValueError", type.getName());
					assertEquals("ItemValueError", type.getType().getName());
					assertEquals("ItemValueError", type.getResolvedType().getName());
				});
				with((TypeInstance) set.getElements().get(1), type -> {
					assertEquals("SequenceValueError", type.getName());
					assertEquals("SequenceValueError", type.getType().getName());
					assertEquals("SequenceValueError", type.getResolvedType().getName());
				});
				with((TypeInstance) set.getElements().get(2), type -> {
					assertEquals("ServiceValueError", type.getName());
					assertEquals("ServiceValueError", type.getType().getName());
					assertEquals("ServiceValueError", type.getResolvedType().getName());
				});
				assertEquals(3, set.flatten().size());
				assertEquals("ItemValueError", set.flatten().get(0).getName());
				assertEquals("SequenceValueError", set.flatten().get(1).getName());
				assertEquals("ServiceValueError", set.flatten().get(2).getName());
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
			with((TypeSetInstance) propagation.getOutTypeSet().getElements().get(0), element -> {
				assertEquals("CommonErrors", element.getName());
				assertEquals("CommonErrors", element.getTypeSet().getName());
				assertEquals("CommonErrors", element.getResolvedTypeSet().getName());
				assertEquals(5, element.getElements().size());
				with((TypeInstance) element.getElements().get(0), type -> {
					assertEquals("ServiceError", type.getName());
					assertEquals("ServiceError", type.getType().getName());
					assertEquals("ServiceError", type.getResolvedType().getName());
				});
				with((TypeSetInstance) element.getElements().get(1), set -> {
					assertEquals("TimingRelatedError", set.getName());
					assertEquals("TimingRelatedError", set.getTypeSet().getName());
					assertEquals("TimingRelatedError", set.getResolvedTypeSet().getName());
					assertEquals(3, set.getElements().size());
					with((TypeInstance) set.getElements().get(0), type -> {
						assertEquals("ItemTimingError", type.getName());
						assertEquals("ItemTimingError", type.getType().getName());
						assertEquals("ItemTimingError", type.getResolvedType().getName());
					});
					with((TypeInstance) set.getElements().get(1), type -> {
						assertEquals("SequenceTimingError", type.getName());
						assertEquals("SequenceTimingError", type.getType().getName());
						assertEquals("SequenceTimingError", type.getResolvedType().getName());
					});
					with((TypeInstance) set.getElements().get(2), type -> {
						assertEquals("ServiceTimingError", type.getName());
						assertEquals("ServiceTimingError", type.getType().getName());
						assertEquals("ServiceTimingError", type.getResolvedType().getName());
					});
				});
				with((TypeSetInstance) element.getElements().get(2), set -> {
					assertEquals("ValueRelatedError", set.getName());
					assertEquals("ValueRelatedError", set.getTypeSet().getName());
					assertEquals("ValueRelatedError", set.getResolvedTypeSet().getName());
					assertEquals(3, set.getElements().size());
					with((TypeInstance) set.getElements().get(0), type -> {
						assertEquals("ItemValueError", type.getName());
						assertEquals("ItemValueError", type.getType().getName());
						assertEquals("ItemValueError", type.getResolvedType().getName());
					});
					with((TypeInstance) set.getElements().get(1), type -> {
						assertEquals("SequenceValueError", type.getName());
						assertEquals("SequenceValueError", type.getType().getName());
						assertEquals("SequenceValueError", type.getResolvedType().getName());
					});
					with((TypeInstance) set.getElements().get(2), type -> {
						assertEquals("ServiceValueError", type.getName());
						assertEquals("ServiceValueError", type.getType().getName());
						assertEquals("ServiceValueError", type.getResolvedType().getName());
					});
				});
				with((TypeInstance) element.getElements().get(3), type -> {
					assertEquals("ReplicationError", type.getName());
					assertEquals("ReplicationError", type.getType().getName());
					assertEquals("ReplicationError", type.getResolvedType().getName());
				});
				with((TypeInstance) element.getElements().get(4), type -> {
					assertEquals("ConcurrencyError", type.getName());
					assertEquals("ConcurrencyError", type.getType().getName());
					assertEquals("ConcurrencyError", type.getResolvedType().getName());
				});
				assertEquals(9, element.flatten().size());
				assertEquals("ServiceError", element.flatten().get(0).getName());
				assertEquals("ItemTimingError", element.flatten().get(1).getName());
				assertEquals("SequenceTimingError", element.flatten().get(2).getName());
				assertEquals("ServiceTimingError", element.flatten().get(3).getName());
				assertEquals("ItemValueError", element.flatten().get(4).getName());
				assertEquals("SequenceValueError", element.flatten().get(5).getName());
				assertEquals("ServiceValueError", element.flatten().get(6).getName());
				assertEquals("ReplicationError", element.flatten().get(7).getName());
				assertEquals("ConcurrencyError", element.flatten().get(8).getName());
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
			with((TypeSetInstance) propagation.getOutTypeSet().getElements().get(0), set -> {
				assertEquals("ProductSet", set.getName());
				assertEquals("ProductSet", set.getTypeSet().getName());
				assertEquals("ProductSet", set.getResolvedTypeSet().getName());
				assertEquals(1, set.getElements().size());
				with((TypeProductInstance) set.getElements().get(0), product -> {
					assertEquals("ServiceError * ItemTimingError", product.getName());
					assertEquals(2, product.getTypes().size());
					with(product.getTypes().get(0), type -> {
						assertEquals("ServiceError", type.getName());
						assertEquals("ServiceError", type.getType().getName());
						assertEquals("ServiceError", type.getResolvedType().getName());
					});
					with(product.getTypes().get(1), type -> {
						assertEquals("ItemTimingError", type.getName());
						assertEquals("ItemTimingError", type.getType().getName());
						assertEquals("ItemTimingError", type.getResolvedType().getName());
					});
				});
				assertEquals(1, set.flatten().size());
				assertEquals("ServiceError * ItemTimingError", set.flatten().get(0).getName());
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
			with((TypeInstance) propagation.getInTypeSet().getElements().get(0), element -> {
				assertEquals("Error1", element.getName());
				assertEquals("Error1", element.getType().getName());
				assertEquals("Error1", element.getResolvedType().getName());
			});
			with((TypeSetInstance) propagation.getInTypeSet().getElements().get(1), element -> {
				assertEquals("CommonErrors", element.getName());
				assertEquals("CommonErrors", element.getTypeSet().getName());
				assertEquals("CommonErrors", element.getResolvedTypeSet().getName());
				assertEquals(5, element.getElements().size());
				with((TypeInstance) element.getElements().get(0), type -> {
					assertEquals("ServiceError", type.getName());
					assertEquals("ServiceError", type.getType().getName());
					assertEquals("ServiceError", type.getResolvedType().getName());
				});
				with((TypeSetInstance) element.getElements().get(1), set -> {
					assertEquals("TimingRelatedError", set.getName());
					assertEquals("TimingRelatedError", set.getTypeSet().getName());
					assertEquals("TimingRelatedError", set.getResolvedTypeSet().getName());
					assertEquals(3, set.getElements().size());
					with((TypeInstance) set.getElements().get(0), type -> {
						assertEquals("ItemTimingError", type.getName());
						assertEquals("ItemTimingError", type.getType().getName());
						assertEquals("ItemTimingError", type.getResolvedType().getName());
					});
					with((TypeInstance) set.getElements().get(1), type -> {
						assertEquals("SequenceTimingError", type.getName());
						assertEquals("SequenceTimingError", type.getType().getName());
						assertEquals("SequenceTimingError", type.getResolvedType().getName());
					});
					with((TypeInstance) set.getElements().get(2), type -> {
						assertEquals("ServiceTimingError", type.getName());
						assertEquals("ServiceTimingError", type.getType().getName());
						assertEquals("ServiceTimingError", type.getResolvedType().getName());
					});
				});
				with((TypeSetInstance) element.getElements().get(2), set -> {
					assertEquals("ValueRelatedError", set.getName());
					assertEquals("ValueRelatedError", set.getTypeSet().getName());
					assertEquals("ValueRelatedError", set.getResolvedTypeSet().getName());
					assertEquals(3, set.getElements().size());
					with((TypeInstance) set.getElements().get(0), type -> {
						assertEquals("ItemValueError", type.getName());
						assertEquals("ItemValueError", type.getType().getName());
						assertEquals("ItemValueError", type.getResolvedType().getName());
					});
					with((TypeInstance) set.getElements().get(1), type -> {
						assertEquals("SequenceValueError", type.getName());
						assertEquals("SequenceValueError", type.getType().getName());
						assertEquals("SequenceValueError", type.getResolvedType().getName());
					});
					with((TypeInstance) set.getElements().get(2), type -> {
						assertEquals("ServiceValueError", type.getName());
						assertEquals("ServiceValueError", type.getType().getName());
						assertEquals("ServiceValueError", type.getResolvedType().getName());
					});
				});
				with((TypeInstance) element.getElements().get(3), type -> {
					assertEquals("ReplicationError", type.getName());
					assertEquals("ReplicationError", type.getType().getName());
					assertEquals("ReplicationError", type.getResolvedType().getName());
				});
				with((TypeInstance) element.getElements().get(4), type -> {
					assertEquals("ConcurrencyError", type.getName());
					assertEquals("ConcurrencyError", type.getType().getName());
					assertEquals("ConcurrencyError", type.getResolvedType().getName());
				});
			});
			with((TypeProductInstance) propagation.getInTypeSet().getElements().get(2), element -> {
				assertEquals("Error2 * Error3", element.getName());
				assertEquals(2, element.getTypes().size());
				with(element.getTypes().get(0), type -> {
					assertEquals("Error2", type.getName());
					assertEquals("Error2", type.getType().getName());
					assertEquals("Error2", type.getResolvedType().getName());
				});
				with(element.getTypes().get(1), type -> {
					assertEquals("Error3", type.getName());
					assertEquals("Error3", type.getType().getName());
					assertEquals("Error3", type.getResolvedType().getName());
				});
			});
			with((TypeSetInstance) propagation.getInTypeSet().getElements().get(3), element -> {
				assertEquals("ProductSet", element.getName());
				assertEquals("ProductSet", element.getTypeSet().getName());
				assertEquals("ProductSet", element.getResolvedTypeSet().getName());
				assertEquals(2, element.getElements().size());
				with((TypeProductInstance) element.getElements().get(0), product -> {
					assertEquals("Error4 * Error5", product.getName());
					assertEquals(2, product.getTypes().size());
					with(product.getTypes().get(0), type -> {
						assertEquals("Error4", type.getName());
						assertEquals("Error4", type.getType().getName());
						assertEquals("Error4", type.getResolvedType().getName());
					});
					with(product.getTypes().get(1), type -> {
						assertEquals("Error5", type.getName());
						assertEquals("Error5", type.getType().getName());
						assertEquals("Error5", type.getResolvedType().getName());
					});
				});
				with((TypeInstance) element.getElements().get(1), type -> {
					assertEquals("Error6", type.getName());
					assertEquals("Error6", type.getType().getName());
					assertEquals("Error6", type.getResolvedType().getName());
				});
			});
			with((TypeInstance) propagation.getOutTypeSet().getElements().get(0), element -> {
				assertEquals("ServiceError", element.getName());
				assertEquals("ServiceError", element.getType().getName());
				assertEquals("ServiceError", element.getResolvedType().getName());
			});
			with((TypeSetInstance) propagation.getOutTypeSet().getElements().get(1), element -> {
				assertEquals("TimingRelatedError", element.getName());
				assertEquals("TimingRelatedError", element.getTypeSet().getName());
				assertEquals("TimingRelatedError", element.getResolvedTypeSet().getName());
				assertEquals(3, element.getElements().size());
				with((TypeInstance) element.getElements().get(0), type -> {
					assertEquals("ItemTimingError", type.getName());
					assertEquals("ItemTimingError", type.getType().getName());
					assertEquals("ItemTimingError", type.getResolvedType().getName());
				});
				with((TypeInstance) element.getElements().get(1), type -> {
					assertEquals("SequenceTimingError", type.getName());
					assertEquals("SequenceTimingError", type.getType().getName());
					assertEquals("SequenceTimingError", type.getResolvedType().getName());
				});
				with((TypeInstance) element.getElements().get(2), type -> {
					assertEquals("ServiceTimingError", type.getName());
					assertEquals("ServiceTimingError", type.getType().getName());
					assertEquals("ServiceTimingError", type.getResolvedType().getName());
				});
			});
			with((TypeProductInstance) propagation.getOutTypeSet().getElements().get(2), element -> {
				assertEquals("ReplicationError * ConcurrencyError", element.getName());
				assertEquals(2, element.getTypes().size());
				with(element.getTypes().get(0), type -> {
					assertEquals("ReplicationError", type.getName());
					assertEquals("ReplicationError", type.getType().getName());
					assertEquals("ReplicationError", type.getResolvedType().getName());
				});
				with(element.getTypes().get(1), type -> {
					assertEquals("ConcurrencyError", type.getName());
					assertEquals("ConcurrencyError", type.getType().getName());
					assertEquals("ConcurrencyError", type.getResolvedType().getName());
				});
			});
			assertEquals(13, propagation.getInTypeSet().flatten().size());
			assertEquals("Error1", propagation.getInTypeSet().flatten().get(0).getName());
			assertEquals("ServiceError", propagation.getInTypeSet().flatten().get(1).getName());
			assertEquals("ItemTimingError", propagation.getInTypeSet().flatten().get(2).getName());
			assertEquals("SequenceTimingError", propagation.getInTypeSet().flatten().get(3).getName());
			assertEquals("ServiceTimingError", propagation.getInTypeSet().flatten().get(4).getName());
			assertEquals("ItemValueError", propagation.getInTypeSet().flatten().get(5).getName());
			assertEquals("SequenceValueError", propagation.getInTypeSet().flatten().get(6).getName());
			assertEquals("ServiceValueError", propagation.getInTypeSet().flatten().get(7).getName());
			assertEquals("ReplicationError", propagation.getInTypeSet().flatten().get(8).getName());
			assertEquals("ConcurrencyError", propagation.getInTypeSet().flatten().get(9).getName());
			assertEquals("Error2 * Error3", propagation.getInTypeSet().flatten().get(10).getName());
			assertEquals("Error4 * Error5", propagation.getInTypeSet().flatten().get(11).getName());
			assertEquals("Error6", propagation.getInTypeSet().flatten().get(12).getName());
			assertEquals(5, propagation.getOutTypeSet().flatten().size());
			assertEquals("ServiceError", propagation.getOutTypeSet().flatten().get(0).getName());
			assertEquals("ItemTimingError", propagation.getOutTypeSet().flatten().get(1).getName());
			assertEquals("SequenceTimingError", propagation.getOutTypeSet().flatten().get(2).getName());
			assertEquals("ServiceTimingError", propagation.getOutTypeSet().flatten().get(3).getName());
			assertEquals("ReplicationError * ConcurrencyError", propagation.getOutTypeSet().flatten().get(4).getName());
		});
	}
}