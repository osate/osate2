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

import static org.junit.Assert.assertTrue;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.PrivatePackageSection;
import org.osate.aadl2.PublicPackageSection;
import org.osate.aadl2.SystemSubcomponent;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * Tests selection between the public and private declarations of one component implementation.
 * This matters because both declarations have the same qualified name, but external references may
 * see only the public declaration while references in the package's private section need its private
 * realization rather than whichever index entry happens to appear first.
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue1836Test extends XtextTest {
	private static final String PATH = "org.osate.core.tests/models/issue1836/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void publicAndPrivateImplementationDeclarationsAreSelectedByContext() throws Exception {
		AadlPackage client = testHelper.parseFile(PATH + "Issue1836.aadl", PATH + "Library.aadl");
		validationHelper.assertNoIssues(client);
		AadlPackage library = (AadlPackage) client.eResource()
				.getResourceSet()
				.getResource(URI.createURI(PATH + "Library.aadl"), false)
				.getContents()
				.get(0);

		SystemSubcomponent external = findSubcomponent(client.getOwnedPublicSection(), "Top.i", "external");
		assertTrue(external.getSystemSubcomponentType().eContainer() instanceof PublicPackageSection);

		SystemSubcomponent internal = findSubcomponent(library.getOwnedPrivateSection(), "Holder.i", "local_service");
		assertTrue(internal.getSystemSubcomponentType().eContainer() instanceof PrivatePackageSection);
	}

	private static SystemSubcomponent findSubcomponent(PackageSection section, String implementationName,
			String subcomponentName) {
		var implementation = (ComponentImplementation) section.getOwnedClassifiers()
				.stream()
				.filter(classifier -> classifier.getName().equals(implementationName))
				.findFirst()
				.orElseThrow();
		return (SystemSubcomponent) implementation.getOwnedSubcomponents()
				.stream()
				.filter(subcomponent -> subcomponent.getName().equals(subcomponentName))
				.findFirst()
				.orElseThrow();
	}
}
