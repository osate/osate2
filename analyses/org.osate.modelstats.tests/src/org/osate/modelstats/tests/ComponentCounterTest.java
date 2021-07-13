/*******************************************************************************
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file). 
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
 *******************************************************************************/
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
