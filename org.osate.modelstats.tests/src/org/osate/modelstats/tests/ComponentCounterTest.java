package org.osate.modelstats.tests;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.modelstats.ComponentCounter;
import org.osate.modelstats.ElementsCounts;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;


@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class ComponentCounterTest {
	private final String path = "org.osate.modelstats.tests/models/ComponentCounter/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Test
	public void emptyTest() throws Exception {
		AadlPackage pkg = testHelper.parseFile(path + "Empty.aadl");
		SystemImplementation impl = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		SystemInstance si = InstantiateModel.instantiate(impl);
		ElementsCounts elementCounts = ComponentCounter.countComponents(si);

		Assert.assertEquals(1, elementCounts.getTotalComponentCount());
		Assert.assertEquals(0, elementCounts.getConnectionsCount());
		Assert.assertEquals(0, elementCounts.getEndToEndFlowsCount());
		Assert.assertEquals(1, elementCounts.getComponentCountMap().size());
		Assert.assertEquals(1, elementCounts.getComponentCountMap().get(ComponentCategory.SYSTEM).intValue());
	}

	@Test
	public void exhaustiveTest() throws Exception {
		AadlPackage pkg = testHelper.parseFile(path + "Exhaustive.aadl");
		SystemImplementation impl = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		SystemInstance si = InstantiateModel.instantiate(impl);
		ElementsCounts elementCounts = ComponentCounter.countComponents(si);

		Assert.assertEquals(16, elementCounts.getTotalComponentCount());
		Assert.assertEquals(1, elementCounts.getConnectionsCount());
		Assert.assertEquals(1, elementCounts.getEndToEndFlowsCount());
		Assert.assertEquals(14, elementCounts.getComponentCountMap().size());
		Assert.assertEquals(2, elementCounts.getComponentCountMap().get(ComponentCategory.SYSTEM).intValue());
		Assert.assertEquals(1, elementCounts.getComponentCountMap().get(ComponentCategory.ABSTRACT).intValue());
		Assert.assertEquals(1, elementCounts.getComponentCountMap().get(ComponentCategory.BUS).intValue());
		Assert.assertEquals(1, elementCounts.getComponentCountMap().get(ComponentCategory.DATA).intValue());
		Assert.assertEquals(1, elementCounts.getComponentCountMap().get(ComponentCategory.DEVICE).intValue());
		Assert.assertEquals(1, elementCounts.getComponentCountMap().get(ComponentCategory.MEMORY).intValue());
		Assert.assertEquals(1, elementCounts.getComponentCountMap().get(ComponentCategory.PROCESS).intValue());
		Assert.assertEquals(1, elementCounts.getComponentCountMap().get(ComponentCategory.PROCESSOR).intValue());
		Assert.assertEquals(1, elementCounts.getComponentCountMap().get(ComponentCategory.SUBPROGRAM).intValue());
		Assert.assertEquals(1, elementCounts.getComponentCountMap().get(ComponentCategory.SUBPROGRAM_GROUP).intValue());
		Assert.assertEquals(1, elementCounts.getComponentCountMap().get(ComponentCategory.VIRTUAL_BUS).intValue());
		Assert.assertEquals(1,
				elementCounts.getComponentCountMap().get(ComponentCategory.VIRTUAL_PROCESSOR).intValue());
		Assert.assertEquals(2, elementCounts.getComponentCountMap().get(ComponentCategory.THREAD).intValue());
	}
}
