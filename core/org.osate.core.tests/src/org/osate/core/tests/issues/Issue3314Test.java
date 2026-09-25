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
import static org.junit.Assert.assertSame;

import java.util.List;
import java.util.stream.StreamSupport;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.validation.Issue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.DataPort;
import org.osate.aadl2.DeviceType;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

/**
 * Tests a package that renames a package that is defined twice and an unnamed component type that does not exist,
 * next to a valid package rename. Neither unresolved rename may crash validation: each must be reported as a linking
 * error and skipped, so that the data ports still resolve their local classifier and the classifier renamed from the
 * valid package, and the classifier scope still offers the valid rename's classifiers by their unqualified names.
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3314Test {
	private static final String PATH = "org.osate.core.tests/models/issue3314/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private IScopeProvider scopeProvider;

	@Test
	public void unresolvedRenamesAreReportedAndSkipped() throws Exception {
		var pkg = testHelper.parseFile(PATH + "Issue3314.aadl", PATH + "SharedA.aadl", PATH + "SharedB.aadl",
				PATH + "Other.aadl");
		var errors = StreamSupport.stream(testHelper.testResource(pkg.eResource()).errorsOnly().spliterator(), false)
				.map(Issue::getMessage)
				.sorted()
				.toList();
		assertEquals(List.of("Couldn't resolve reference to AadlPackage 'Shared'.",
				"Couldn't resolve reference to ComponentType 'Other::Absent'.",
				"Couldn't resolve reference to ModelUnit 'Shared'."), errors);

		var classifiers = pkg.getOwnedPublicSection().getOwnedClassifiers();
		var local = classifiers.get(0);
		var device = (DeviceType) classifiers.get(1);
		assertSame(local, findPort(device, "p").getDataFeatureClassifier());
		var portQ = findPort(device, "q");
		var value = portQ.getDataFeatureClassifier();
		assertFalse(value.eIsProxy());
		assertEquals("Other::Value", value.getQualifiedName());

		var scope = scopeProvider.getScope(portQ, Aadl2Package.eINSTANCE.getDataPort_DataFeatureClassifier());
		var renamed = scope.getSingleElement(QualifiedName.create("Value"));
		assertNotNull(renamed);
		assertSame(value, renamed.getEObjectOrProxy());
	}

	private static DataPort findPort(DeviceType device, String name) {
		return (DataPort) device.getOwnedFeatures()
				.stream()
				.filter(feature -> feature.getName().equals(name))
				.findFirst()
				.orElseThrow();
	}
}
