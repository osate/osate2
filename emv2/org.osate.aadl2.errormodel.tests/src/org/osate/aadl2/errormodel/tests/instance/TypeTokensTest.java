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
import org.osate.aadl2.errormodel.instance.FeatureReference;
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
		with((FeatureReference) annexInstance.getPropagations().get(0), propagation -> {
			assertEquals("f", propagation.getName());
			assertEquals(0, propagation.getInTokens().size());
			assertEquals(2, propagation.getOutTokens().size());
			with((TypeReference) propagation.getOutTokens().get(0), token -> {
				assertEquals("ServiceError", token.getName());
				assertEquals("ServiceError", token.getDeclaredType().getName());
				assertEquals("ServiceError", token.getResolvedType().getName());
			});
			with((TypeReference) propagation.getOutTokens().get(1), token -> {
				assertEquals("TimingError", token.getName());
				assertEquals("TimingError", token.getDeclaredType().getName());
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
		with((FeatureReference) annexInstance.getPropagations().get(0), propagation -> {
			assertEquals("f", propagation.getName());
			assertEquals(0, propagation.getInTokens().size());
			assertEquals(1, propagation.getOutTokens().size());
			with((TypeProductInstance) propagation.getOutTokens().get(0), token -> {
				assertEquals("ServiceError * TimingError", token.getName());
				assertEquals(2, token.getTypes().size());
				with(token.getTypes().get(0), type -> {
					assertEquals("ServiceError", type.getName());
					assertEquals("ServiceError", type.getDeclaredType().getName());
					assertEquals("ServiceError", type.getResolvedType().getName());
				});
				with(token.getTypes().get(1), type -> {
					assertEquals("TimingError", type.getName());
					assertEquals("TimingError", type.getDeclaredType().getName());
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
		with((FeatureReference) annexInstance.getPropagations().get(0), propagation -> {
			assertEquals("f", propagation.getName());
			assertEquals(0, propagation.getInTokens().size());
			assertEquals(2, propagation.getOutTokens().size());
			with((TypeSetInstance) propagation.getOutTokens().get(0), token -> {
				assertEquals("TimingRelatedError", token.getName());
				assertEquals("TimingRelatedError", token.getDeclaredSet().getName());
				assertEquals("TimingRelatedError", token.getResolvedSet().getName());
				assertEquals(3, token.getTokens().size());
				with((TypeReference) token.getTokens().get(0), type -> {
					assertEquals("ItemTimingError", type.getName());
					assertEquals("ItemTimingError", type.getDeclaredType().getName());
					assertEquals("ItemTimingError", type.getResolvedType().getName());
				});
				with((TypeReference) token.getTokens().get(1), type -> {
					assertEquals("SequenceTimingError", type.getName());
					assertEquals("SequenceTimingError", type.getDeclaredType().getName());
					assertEquals("SequenceTimingError", type.getResolvedType().getName());
				});
				with((TypeReference) token.getTokens().get(2), type -> {
					assertEquals("ServiceTimingError", type.getName());
					assertEquals("ServiceTimingError", type.getDeclaredType().getName());
					assertEquals("ServiceTimingError", type.getResolvedType().getName());
				});
			});
			with((TypeSetInstance) propagation.getOutTokens().get(1), token -> {
				assertEquals("ValueErrors", token.getName());
				assertEquals("ValueErrors", token.getDeclaredSet().getName());
				assertEquals("ValueRelatedError", token.getResolvedSet().getName());
				assertEquals(3, token.getTokens().size());
				with((TypeReference) token.getTokens().get(0), type -> {
					assertEquals("ItemValueError", type.getName());
					assertEquals("ItemValueError", type.getDeclaredType().getName());
					assertEquals("ItemValueError", type.getResolvedType().getName());
				});
				with((TypeReference) token.getTokens().get(1), type -> {
					assertEquals("SequenceValueError", type.getName());
					assertEquals("SequenceValueError", type.getDeclaredType().getName());
					assertEquals("SequenceValueError", type.getResolvedType().getName());
				});
				with((TypeReference) token.getTokens().get(2), type -> {
					assertEquals("ServiceValueError", type.getName());
					assertEquals("ServiceValueError", type.getDeclaredType().getName());
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
		with((FeatureReference) annexInstance.getPropagations().get(0), propagation -> {
			assertEquals("f", propagation.getName());
			assertEquals(0, propagation.getInTokens().size());
			assertEquals(1, propagation.getOutTokens().size());
			with((TypeSetInstance) propagation.getOutTokens().get(0), token -> {
				assertEquals("CommonErrors", token.getName());
				assertEquals("CommonErrors", token.getDeclaredSet().getName());
				assertEquals("CommonErrors", token.getResolvedSet().getName());
				assertEquals(5, token.getTokens().size());
				with((TypeReference) token.getTokens().get(0), type -> {
					assertEquals("ServiceError", type.getName());
					assertEquals("ServiceError", type.getDeclaredType().getName());
					assertEquals("ServiceError", type.getResolvedType().getName());
				});
				with((TypeSetInstance) token.getTokens().get(1), set -> {
					assertEquals("TimingRelatedError", set.getName());
					assertEquals("TimingRelatedError", set.getDeclaredSet().getName());
					assertEquals("TimingRelatedError", set.getResolvedSet().getName());
					assertEquals(3, set.getTokens().size());
					with((TypeReference) set.getTokens().get(0), type -> {
						assertEquals("ItemTimingError", type.getName());
						assertEquals("ItemTimingError", type.getDeclaredType().getName());
						assertEquals("ItemTimingError", type.getResolvedType().getName());
					});
					with((TypeReference) set.getTokens().get(1), type -> {
						assertEquals("SequenceTimingError", type.getName());
						assertEquals("SequenceTimingError", type.getDeclaredType().getName());
						assertEquals("SequenceTimingError", type.getResolvedType().getName());
					});
					with((TypeReference) set.getTokens().get(2), type -> {
						assertEquals("ServiceTimingError", type.getName());
						assertEquals("ServiceTimingError", type.getDeclaredType().getName());
						assertEquals("ServiceTimingError", type.getResolvedType().getName());
					});
				});
				with((TypeSetInstance) token.getTokens().get(2), set -> {
					assertEquals("ValueRelatedError", set.getName());
					assertEquals("ValueRelatedError", set.getDeclaredSet().getName());
					assertEquals("ValueRelatedError", set.getResolvedSet().getName());
					assertEquals(3, set.getTokens().size());
					with((TypeReference) set.getTokens().get(0), type -> {
						assertEquals("ItemValueError", type.getName());
						assertEquals("ItemValueError", type.getDeclaredType().getName());
						assertEquals("ItemValueError", type.getResolvedType().getName());
					});
					with((TypeReference) set.getTokens().get(1), type -> {
						assertEquals("SequenceValueError", type.getName());
						assertEquals("SequenceValueError", type.getDeclaredType().getName());
						assertEquals("SequenceValueError", type.getResolvedType().getName());
					});
					with((TypeReference) set.getTokens().get(2), type -> {
						assertEquals("ServiceValueError", type.getName());
						assertEquals("ServiceValueError", type.getDeclaredType().getName());
						assertEquals("ServiceValueError", type.getResolvedType().getName());
					});
				});
				with((TypeReference) token.getTokens().get(3), type -> {
					assertEquals("ReplicationError", type.getName());
					assertEquals("ReplicationError", type.getDeclaredType().getName());
					assertEquals("ReplicationError", type.getResolvedType().getName());
				});
				with((TypeReference) token.getTokens().get(4), type -> {
					assertEquals("ConcurrencyError", type.getName());
					assertEquals("ConcurrencyError", type.getDeclaredType().getName());
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
		with((FeatureReference) annexInstance.getPropagations().get(0), propagation -> {
			assertEquals("f", propagation.getName());
			assertEquals(0, propagation.getInTokens().size());
			assertEquals(1, propagation.getOutTokens().size());
			with((TypeSetInstance) propagation.getOutTokens().get(0), token -> {
				assertEquals("ProductSet", token.getName());
				assertEquals("ProductSet", token.getDeclaredSet().getName());
				assertEquals("ProductSet", token.getResolvedSet().getName());
				assertEquals(1, token.getTokens().size());
				with((TypeProductInstance) token.getTokens().get(0), product -> {
					assertEquals("ServiceError * ItemTimingError", product.getName());
					assertEquals(2, product.getTypes().size());
					with(product.getTypes().get(0), type -> {
						assertEquals("ServiceError", type.getName());
						assertEquals("ServiceError", type.getDeclaredType().getName());
						assertEquals("ServiceError", type.getResolvedType().getName());
					});
					with(product.getTypes().get(1), type -> {
						assertEquals("ItemTimingError", type.getName());
						assertEquals("ItemTimingError", type.getDeclaredType().getName());
						assertEquals("ItemTimingError", type.getResolvedType().getName());
					});
				});
			});
		});
	}
}