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
package org.osate.core.tests.issues;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.builder.AbstractIncrementalBuilderTest;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.DeviceType;
import org.osate.aadl2.SubprogramImplementation;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

/**
 * Verifies qualified classifier references through both direct resource-set linking and the workspace index. Bus
 * accesses and abstract features use broad feature-classifier reference types, while the data port provides a control
 * whose narrower subcomponent-type reference already works through the index.
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3319Test extends AbstractIncrementalBuilderTest {
	private static final String PATH = "org.osate.core.tests/models/issue3319/";
	private static final String MODEL_PATH = "models/issue3319/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Override
	protected IResourceServiceProvider.Registry getLanguages() {
		return IResourceServiceProvider.Registry.INSTANCE;
	}

	@Test
	public void qualifiedFeatureClassifiersResolveDirectly() throws Exception {
		var pkg = testHelper.parseFile(PATH + "Issue3319.aadl", PATH + "TestBus.aadl");
		validationHelper.assertNoIssues(pkg);

		var device = (DeviceType) pkg.getOwnedPublicSection().getOwnedClassifiers().getFirst();
		var busClassifier = (Classifier) device.getOwnedBusAccesses().getFirst().getBusFeatureClassifier();
		assertFalse(busClassifier.eIsProxy());
		assertEquals("TestBus::TestBus.impl", busClassifier.getQualifiedName());

		var abstractClassifier = (Classifier) device.getOwnedAbstractFeatures()
				.getFirst()
				.getAbstractFeatureClassifier();
		assertFalse(abstractClassifier.eIsProxy());
		assertEquals("TestBus::TestAbstract.impl", abstractClassifier.getQualifiedName());

		var caller = (SubprogramImplementation) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> classifier.getName().equals("Caller.impl"))
				.findFirst()
				.orElseThrow();
		var call = caller.getOwnedSubprogramCallSequences().getFirst().getOwnedSubprogramCalls().getFirst();
		var context = (Classifier) call.getContext();
		assertFalse(context.eIsProxy());
		assertEquals("TestBus::TestSubprogram", context.getQualifiedName());
		var called = (Classifier) call.getCalledSubprogram();
		assertFalse(called.eIsProxy());
		assertEquals("TestBus::TestSubprogram.impl", called.getQualifiedName());
	}

	@Test
	public void cleanBuildResolvesFeatureClassifiersWhenTargetIsBuiltFirst() throws Exception {
		assertCleanBuildHasNoIssues(List.of("TestBus.aadl", "Issue3319.aadl"));
	}

	@Test
	public void cleanBuildResolvesFeatureClassifiersWhenReferenceIsBuiltFirst() throws Exception {
		assertCleanBuildHasNoIssues(List.of("Issue3319.aadl", "TestBus.aadl"));
	}

	private void assertCleanBuildHasNoIssues(List<String> dirtyFileOrder) throws Exception {
		URI target = newFile("TestBus.aadl", readModel("TestBus.aadl"));
		URI reference = newFile("Issue3319.aadl", readModel("Issue3319.aadl"));
		build(newBuildRequest(request -> request.setDirtyFiles(dirtyFileOrder.stream()
				.map(name -> name.equals("TestBus.aadl") ? target : reference)
				.toList())));

		assertTrue(describeIssues().toString(), describeIssues().isEmpty());
	}

	private String readModel(String name) throws IOException {
		try (var stream = getClass().getClassLoader().getResourceAsStream(MODEL_PATH + name)) {
			assertNotNull(name, stream);
			return new String(stream.readAllBytes(), StandardCharsets.UTF_8);
		}
	}

	private List<String> describeIssues() {
		return issues.stream()
				.map(issue -> issue.getSeverity() + ": " + issue.getMessage())
				.toList();
	}
}
