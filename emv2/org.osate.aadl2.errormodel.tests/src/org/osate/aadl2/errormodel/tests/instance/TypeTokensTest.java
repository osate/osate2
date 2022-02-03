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
import org.osate.aadl2.errormodel.instance.TypeProductInstance;
import org.osate.aadl2.errormodel.instance.TypeReference;
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
	public void testTypeReference() throws Exception {
		var pkg = testHelper.parseFile(PATH + "type_reference_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getPropagations().size());
		with((FeaturePropagation) annexInstance.getPropagations().get(0), propagation -> {
			assertEquals("f", propagation.getName());
			assertEquals(0, propagation.getInTokens().size());
			assertEquals(2, propagation.getOutTokens().size());
			with((TypeReference) propagation.getOutTokens().get(0), token -> {
				assertEquals("ServiceError", token.getName());
				assertEquals("ServiceError", token.getType().getName());
				assertEquals("ServiceError", token.getResolvedType().getName());
			});
			with((TypeReference) propagation.getOutTokens().get(1), token -> {
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
				with((TypeReference) token.getTokens().get(0), type -> {
					assertEquals("ItemTimingError", type.getName());
					assertEquals("ItemTimingError", type.getType().getName());
					assertEquals("ItemTimingError", type.getResolvedType().getName());
				});
				with((TypeReference) token.getTokens().get(1), type -> {
					assertEquals("SequenceTimingError", type.getName());
					assertEquals("SequenceTimingError", type.getType().getName());
					assertEquals("SequenceTimingError", type.getResolvedType().getName());
				});
				with((TypeReference) token.getTokens().get(2), type -> {
					assertEquals("ServiceTimingError", type.getName());
					assertEquals("ServiceTimingError", type.getType().getName());
					assertEquals("ServiceTimingError", type.getResolvedType().getName());
				});
			});
			with((TypeSetInstance) propagation.getOutTokens().get(1), token -> {
				assertEquals("ValueErrors", token.getName());
				assertEquals("ValueErrors", token.getTypeSet().getName());
				assertEquals("ValueRelatedError", token.getResolvedTypeSet().getName());
				assertEquals(3, token.getTokens().size());
				with((TypeReference) token.getTokens().get(0), type -> {
					assertEquals("ItemValueError", type.getName());
					assertEquals("ItemValueError", type.getType().getName());
					assertEquals("ItemValueError", type.getResolvedType().getName());
				});
				with((TypeReference) token.getTokens().get(1), type -> {
					assertEquals("SequenceValueError", type.getName());
					assertEquals("SequenceValueError", type.getType().getName());
					assertEquals("SequenceValueError", type.getResolvedType().getName());
				});
				with((TypeReference) token.getTokens().get(2), type -> {
					assertEquals("ServiceValueError", type.getName());
					assertEquals("ServiceValueError", type.getType().getName());
					assertEquals("ServiceValueError", type.getResolvedType().getName());
				});
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
				with((TypeReference) token.getTokens().get(0), type -> {
					assertEquals("ServiceError", type.getName());
					assertEquals("ServiceError", type.getType().getName());
					assertEquals("ServiceError", type.getResolvedType().getName());
				});
				with((TypeSetInstance) token.getTokens().get(1), set -> {
					assertEquals("TimingRelatedError", set.getName());
					assertEquals("TimingRelatedError", set.getTypeSet().getName());
					assertEquals("TimingRelatedError", set.getResolvedTypeSet().getName());
					assertEquals(3, set.getTokens().size());
					with((TypeReference) set.getTokens().get(0), type -> {
						assertEquals("ItemTimingError", type.getName());
						assertEquals("ItemTimingError", type.getType().getName());
						assertEquals("ItemTimingError", type.getResolvedType().getName());
					});
					with((TypeReference) set.getTokens().get(1), type -> {
						assertEquals("SequenceTimingError", type.getName());
						assertEquals("SequenceTimingError", type.getType().getName());
						assertEquals("SequenceTimingError", type.getResolvedType().getName());
					});
					with((TypeReference) set.getTokens().get(2), type -> {
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
					with((TypeReference) set.getTokens().get(0), type -> {
						assertEquals("ItemValueError", type.getName());
						assertEquals("ItemValueError", type.getType().getName());
						assertEquals("ItemValueError", type.getResolvedType().getName());
					});
					with((TypeReference) set.getTokens().get(1), type -> {
						assertEquals("SequenceValueError", type.getName());
						assertEquals("SequenceValueError", type.getType().getName());
						assertEquals("SequenceValueError", type.getResolvedType().getName());
					});
					with((TypeReference) set.getTokens().get(2), type -> {
						assertEquals("ServiceValueError", type.getName());
						assertEquals("ServiceValueError", type.getType().getName());
						assertEquals("ServiceValueError", type.getResolvedType().getName());
					});
				});
				with((TypeReference) token.getTokens().get(3), type -> {
					assertEquals("ReplicationError", type.getName());
					assertEquals("ReplicationError", type.getType().getName());
					assertEquals("ReplicationError", type.getResolvedType().getName());
				});
				with((TypeReference) token.getTokens().get(4), type -> {
					assertEquals("ConcurrencyError", type.getName());
					assertEquals("ConcurrencyError", type.getType().getName());
					assertEquals("ConcurrencyError", type.getResolvedType().getName());
				});
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
			});
		});
	}
}