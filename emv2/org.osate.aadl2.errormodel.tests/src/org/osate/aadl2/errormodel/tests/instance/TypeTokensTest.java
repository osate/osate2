package org.osate.aadl2.errormodel.tests.instance;

import static org.junit.Assert.assertEquals;
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
			assertEquals(0, propagation.getInTokens().size());
			assertEquals(2, propagation.getOutTokens().size());
			with((TypeInstance) propagation.getOutTokens().get(0), token -> {
				assertEquals("ServiceError", token.getName());
				assertEquals("ServiceError", token.getType().getName());
				assertEquals("ServiceError", token.getResolvedType().getName());
			});
			with((TypeInstance) propagation.getOutTokens().get(1), token -> {
				assertEquals("TimingError", token.getName());
				assertEquals("TimingError", token.getType().getName());
				assertEquals("ItemTimingError", token.getResolvedType().getName());
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
			assertEquals(0, propagation.getInTokens().size());
			assertEquals(1, propagation.getOutTokens().size());
			with((TypeProductInstance) propagation.getOutTokens().get(0), token -> {
				assertEquals("ServiceError * TimingError", token.getName());
				assertEquals(2, token.getTypes().size());
				with(token.getTypes().get(0), type -> {
					assertEquals("ServiceError", type.getName());
					assertEquals("ServiceError", type.getType().getName());
					assertEquals("ServiceError", type.getResolvedType().getName());
				});
				with(token.getTypes().get(1), type -> {
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
			assertEquals(0, propagation.getInTokens().size());
			assertEquals(2, propagation.getOutTokens().size());
			with((TypeSetInstance) propagation.getOutTokens().get(0), token -> {
				assertEquals("TimingRelatedError", token.getName());
				assertEquals("TimingRelatedError", token.getTypeSet().getName());
				assertEquals("TimingRelatedError", token.getResolvedTypeSet().getName());
				assertEquals(3, token.getTokens().size());
				with((TypeInstance) token.getTokens().get(0), type -> {
					assertEquals("ItemTimingError", type.getName());
					assertEquals("ItemTimingError", type.getType().getName());
					assertEquals("ItemTimingError", type.getResolvedType().getName());
				});
				with((TypeInstance) token.getTokens().get(1), type -> {
					assertEquals("SequenceTimingError", type.getName());
					assertEquals("SequenceTimingError", type.getType().getName());
					assertEquals("SequenceTimingError", type.getResolvedType().getName());
				});
				with((TypeInstance) token.getTokens().get(2), type -> {
					assertEquals("ServiceTimingError", type.getName());
					assertEquals("ServiceTimingError", type.getType().getName());
					assertEquals("ServiceTimingError", type.getResolvedType().getName());
				});
				assertEquals(3, token.getAllTokens().size());
				assertEquals("ItemTimingError", token.getAllTokens().get(0).getName());
				assertEquals("SequenceTimingError", token.getAllTokens().get(1).getName());
				assertEquals("ServiceTimingError", token.getAllTokens().get(2).getName());
			});
			with((TypeSetInstance) propagation.getOutTokens().get(1), token -> {
				assertEquals("ValueErrors", token.getName());
				assertEquals("ValueErrors", token.getTypeSet().getName());
				assertEquals("ValueRelatedError", token.getResolvedTypeSet().getName());
				assertEquals(3, token.getTokens().size());
				with((TypeInstance) token.getTokens().get(0), type -> {
					assertEquals("ItemValueError", type.getName());
					assertEquals("ItemValueError", type.getType().getName());
					assertEquals("ItemValueError", type.getResolvedType().getName());
				});
				with((TypeInstance) token.getTokens().get(1), type -> {
					assertEquals("SequenceValueError", type.getName());
					assertEquals("SequenceValueError", type.getType().getName());
					assertEquals("SequenceValueError", type.getResolvedType().getName());
				});
				with((TypeInstance) token.getTokens().get(2), type -> {
					assertEquals("ServiceValueError", type.getName());
					assertEquals("ServiceValueError", type.getType().getName());
					assertEquals("ServiceValueError", type.getResolvedType().getName());
				});
				assertEquals(3, token.getAllTokens().size());
				assertEquals("ItemValueError", token.getAllTokens().get(0).getName());
				assertEquals("SequenceValueError", token.getAllTokens().get(1).getName());
				assertEquals("ServiceValueError", token.getAllTokens().get(2).getName());
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
			assertEquals(0, propagation.getInTokens().size());
			assertEquals(1, propagation.getOutTokens().size());
			with((TypeSetInstance) propagation.getOutTokens().get(0), token -> {
				assertEquals("CommonErrors", token.getName());
				assertEquals("CommonErrors", token.getTypeSet().getName());
				assertEquals("CommonErrors", token.getResolvedTypeSet().getName());
				assertEquals(5, token.getTokens().size());
				with((TypeInstance) token.getTokens().get(0), type -> {
					assertEquals("ServiceError", type.getName());
					assertEquals("ServiceError", type.getType().getName());
					assertEquals("ServiceError", type.getResolvedType().getName());
				});
				with((TypeSetInstance) token.getTokens().get(1), set -> {
					assertEquals("TimingRelatedError", set.getName());
					assertEquals("TimingRelatedError", set.getTypeSet().getName());
					assertEquals("TimingRelatedError", set.getResolvedTypeSet().getName());
					assertEquals(3, set.getTokens().size());
					with((TypeInstance) set.getTokens().get(0), type -> {
						assertEquals("ItemTimingError", type.getName());
						assertEquals("ItemTimingError", type.getType().getName());
						assertEquals("ItemTimingError", type.getResolvedType().getName());
					});
					with((TypeInstance) set.getTokens().get(1), type -> {
						assertEquals("SequenceTimingError", type.getName());
						assertEquals("SequenceTimingError", type.getType().getName());
						assertEquals("SequenceTimingError", type.getResolvedType().getName());
					});
					with((TypeInstance) set.getTokens().get(2), type -> {
						assertEquals("ServiceTimingError", type.getName());
						assertEquals("ServiceTimingError", type.getType().getName());
						assertEquals("ServiceTimingError", type.getResolvedType().getName());
					});
				});
				with((TypeSetInstance) token.getTokens().get(2), set -> {
					assertEquals("ValueRelatedError", set.getName());
					assertEquals("ValueRelatedError", set.getTypeSet().getName());
					assertEquals("ValueRelatedError", set.getResolvedTypeSet().getName());
					assertEquals(3, set.getTokens().size());
					with((TypeInstance) set.getTokens().get(0), type -> {
						assertEquals("ItemValueError", type.getName());
						assertEquals("ItemValueError", type.getType().getName());
						assertEquals("ItemValueError", type.getResolvedType().getName());
					});
					with((TypeInstance) set.getTokens().get(1), type -> {
						assertEquals("SequenceValueError", type.getName());
						assertEquals("SequenceValueError", type.getType().getName());
						assertEquals("SequenceValueError", type.getResolvedType().getName());
					});
					with((TypeInstance) set.getTokens().get(2), type -> {
						assertEquals("ServiceValueError", type.getName());
						assertEquals("ServiceValueError", type.getType().getName());
						assertEquals("ServiceValueError", type.getResolvedType().getName());
					});
				});
				with((TypeInstance) token.getTokens().get(3), type -> {
					assertEquals("ReplicationError", type.getName());
					assertEquals("ReplicationError", type.getType().getName());
					assertEquals("ReplicationError", type.getResolvedType().getName());
				});
				with((TypeInstance) token.getTokens().get(4), type -> {
					assertEquals("ConcurrencyError", type.getName());
					assertEquals("ConcurrencyError", type.getType().getName());
					assertEquals("ConcurrencyError", type.getResolvedType().getName());
				});
				assertEquals(9, token.getAllTokens().size());
				assertEquals("ServiceError", token.getAllTokens().get(0).getName());
				assertEquals("ItemTimingError", token.getAllTokens().get(1).getName());
				assertEquals("SequenceTimingError", token.getAllTokens().get(2).getName());
				assertEquals("ServiceTimingError", token.getAllTokens().get(3).getName());
				assertEquals("ItemValueError", token.getAllTokens().get(4).getName());
				assertEquals("SequenceValueError", token.getAllTokens().get(5).getName());
				assertEquals("ServiceValueError", token.getAllTokens().get(6).getName());
				assertEquals("ReplicationError", token.getAllTokens().get(7).getName());
				assertEquals("ConcurrencyError", token.getAllTokens().get(8).getName());
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
			assertEquals(0, propagation.getInTokens().size());
			assertEquals(1, propagation.getOutTokens().size());
			with((TypeSetInstance) propagation.getOutTokens().get(0), token -> {
				assertEquals("ProductSet", token.getName());
				assertEquals("ProductSet", token.getTypeSet().getName());
				assertEquals("ProductSet", token.getResolvedTypeSet().getName());
				assertEquals(1, token.getTokens().size());
				with((TypeProductInstance) token.getTokens().get(0), product -> {
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
				assertEquals(1, token.getAllTokens().size());
				assertEquals("ServiceError * ItemTimingError", token.getAllTokens().get(0).getName());
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
			assertEquals(4, propagation.getInTokens().size());
			assertEquals(3, propagation.getOutTokens().size());
			with((TypeInstance) propagation.getInTokens().get(0), token -> {
				assertEquals("Error1", token.getName());
				assertEquals("Error1", token.getType().getName());
				assertEquals("Error1", token.getResolvedType().getName());
			});
			with((TypeSetInstance) propagation.getInTokens().get(1), token -> {
				assertEquals("CommonErrors", token.getName());
				assertEquals("CommonErrors", token.getTypeSet().getName());
				assertEquals("CommonErrors", token.getResolvedTypeSet().getName());
				assertEquals(5, token.getTokens().size());
				with((TypeInstance) token.getTokens().get(0), type -> {
					assertEquals("ServiceError", type.getName());
					assertEquals("ServiceError", type.getType().getName());
					assertEquals("ServiceError", type.getResolvedType().getName());
				});
				with((TypeSetInstance) token.getTokens().get(1), set -> {
					assertEquals("TimingRelatedError", set.getName());
					assertEquals("TimingRelatedError", set.getTypeSet().getName());
					assertEquals("TimingRelatedError", set.getResolvedTypeSet().getName());
					assertEquals(3, set.getTokens().size());
					with((TypeInstance) set.getTokens().get(0), type -> {
						assertEquals("ItemTimingError", type.getName());
						assertEquals("ItemTimingError", type.getType().getName());
						assertEquals("ItemTimingError", type.getResolvedType().getName());
					});
					with((TypeInstance) set.getTokens().get(1), type -> {
						assertEquals("SequenceTimingError", type.getName());
						assertEquals("SequenceTimingError", type.getType().getName());
						assertEquals("SequenceTimingError", type.getResolvedType().getName());
					});
					with((TypeInstance) set.getTokens().get(2), type -> {
						assertEquals("ServiceTimingError", type.getName());
						assertEquals("ServiceTimingError", type.getType().getName());
						assertEquals("ServiceTimingError", type.getResolvedType().getName());
					});
				});
				with((TypeSetInstance) token.getTokens().get(2), set -> {
					assertEquals("ValueRelatedError", set.getName());
					assertEquals("ValueRelatedError", set.getTypeSet().getName());
					assertEquals("ValueRelatedError", set.getResolvedTypeSet().getName());
					assertEquals(3, set.getTokens().size());
					with((TypeInstance) set.getTokens().get(0), type -> {
						assertEquals("ItemValueError", type.getName());
						assertEquals("ItemValueError", type.getType().getName());
						assertEquals("ItemValueError", type.getResolvedType().getName());
					});
					with((TypeInstance) set.getTokens().get(1), type -> {
						assertEquals("SequenceValueError", type.getName());
						assertEquals("SequenceValueError", type.getType().getName());
						assertEquals("SequenceValueError", type.getResolvedType().getName());
					});
					with((TypeInstance) set.getTokens().get(2), type -> {
						assertEquals("ServiceValueError", type.getName());
						assertEquals("ServiceValueError", type.getType().getName());
						assertEquals("ServiceValueError", type.getResolvedType().getName());
					});
				});
				with((TypeInstance) token.getTokens().get(3), type -> {
					assertEquals("ReplicationError", type.getName());
					assertEquals("ReplicationError", type.getType().getName());
					assertEquals("ReplicationError", type.getResolvedType().getName());
				});
				with((TypeInstance) token.getTokens().get(4), type -> {
					assertEquals("ConcurrencyError", type.getName());
					assertEquals("ConcurrencyError", type.getType().getName());
					assertEquals("ConcurrencyError", type.getResolvedType().getName());
				});
			});
			with((TypeProductInstance) propagation.getInTokens().get(2), token -> {
				assertEquals("Error2 * Error3", token.getName());
				assertEquals(2, token.getTypes().size());
				with(token.getTypes().get(0), type -> {
					assertEquals("Error2", type.getName());
					assertEquals("Error2", type.getType().getName());
					assertEquals("Error2", type.getResolvedType().getName());
				});
				with(token.getTypes().get(1), type -> {
					assertEquals("Error3", type.getName());
					assertEquals("Error3", type.getType().getName());
					assertEquals("Error3", type.getResolvedType().getName());
				});
			});
			with((TypeSetInstance) propagation.getInTokens().get(3), token -> {
				assertEquals("ProductSet", token.getName());
				assertEquals("ProductSet", token.getTypeSet().getName());
				assertEquals("ProductSet", token.getResolvedTypeSet().getName());
				assertEquals(2, token.getTokens().size());
				with((TypeProductInstance) token.getTokens().get(0), product -> {
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
				with((TypeInstance) token.getTokens().get(1), type -> {
					assertEquals("Error6", type.getName());
					assertEquals("Error6", type.getType().getName());
					assertEquals("Error6", type.getResolvedType().getName());
				});
			});
			with((TypeInstance) propagation.getOutTokens().get(0), token -> {
				assertEquals("ServiceError", token.getName());
				assertEquals("ServiceError", token.getType().getName());
				assertEquals("ServiceError", token.getResolvedType().getName());
			});
			with((TypeSetInstance) propagation.getOutTokens().get(1), token -> {
				assertEquals("TimingRelatedError", token.getName());
				assertEquals("TimingRelatedError", token.getTypeSet().getName());
				assertEquals("TimingRelatedError", token.getResolvedTypeSet().getName());
				assertEquals(3, token.getTokens().size());
				with((TypeInstance) token.getTokens().get(0), type -> {
					assertEquals("ItemTimingError", type.getName());
					assertEquals("ItemTimingError", type.getType().getName());
					assertEquals("ItemTimingError", type.getResolvedType().getName());
				});
				with((TypeInstance) token.getTokens().get(1), type -> {
					assertEquals("SequenceTimingError", type.getName());
					assertEquals("SequenceTimingError", type.getType().getName());
					assertEquals("SequenceTimingError", type.getResolvedType().getName());
				});
				with((TypeInstance) token.getTokens().get(2), type -> {
					assertEquals("ServiceTimingError", type.getName());
					assertEquals("ServiceTimingError", type.getType().getName());
					assertEquals("ServiceTimingError", type.getResolvedType().getName());
				});
			});
			with((TypeProductInstance) propagation.getOutTokens().get(2), token -> {
				assertEquals("ReplicationError * ConcurrencyError", token.getName());
				assertEquals(2, token.getTypes().size());
				with(token.getTypes().get(0), type -> {
					assertEquals("ReplicationError", type.getName());
					assertEquals("ReplicationError", type.getType().getName());
					assertEquals("ReplicationError", type.getResolvedType().getName());
				});
				with(token.getTypes().get(1), type -> {
					assertEquals("ConcurrencyError", type.getName());
					assertEquals("ConcurrencyError", type.getType().getName());
					assertEquals("ConcurrencyError", type.getResolvedType().getName());
				});
			});
			assertEquals(13, propagation.getAllInTokens().size());
			assertEquals("Error1", propagation.getAllInTokens().get(0).getName());
			assertEquals("ServiceError", propagation.getAllInTokens().get(1).getName());
			assertEquals("ItemTimingError", propagation.getAllInTokens().get(2).getName());
			assertEquals("SequenceTimingError", propagation.getAllInTokens().get(3).getName());
			assertEquals("ServiceTimingError", propagation.getAllInTokens().get(4).getName());
			assertEquals("ItemValueError", propagation.getAllInTokens().get(5).getName());
			assertEquals("SequenceValueError", propagation.getAllInTokens().get(6).getName());
			assertEquals("ServiceValueError", propagation.getAllInTokens().get(7).getName());
			assertEquals("ReplicationError", propagation.getAllInTokens().get(8).getName());
			assertEquals("ConcurrencyError", propagation.getAllInTokens().get(9).getName());
			assertEquals("Error2 * Error3", propagation.getAllInTokens().get(10).getName());
			assertEquals("Error4 * Error5", propagation.getAllInTokens().get(11).getName());
			assertEquals("Error6", propagation.getAllInTokens().get(12).getName());
			assertEquals(5, propagation.getAllOutTokens().size());
			assertEquals("ServiceError", propagation.getAllOutTokens().get(0).getName());
			assertEquals("ItemTimingError", propagation.getAllOutTokens().get(1).getName());
			assertEquals("SequenceTimingError", propagation.getAllOutTokens().get(2).getName());
			assertEquals("ServiceTimingError", propagation.getAllOutTokens().get(3).getName());
			assertEquals("ReplicationError * ConcurrencyError", propagation.getAllOutTokens().get(4).getName());
		});
	}
}