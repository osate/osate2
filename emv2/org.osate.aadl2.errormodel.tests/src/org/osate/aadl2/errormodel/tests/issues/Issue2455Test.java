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
package org.osate.aadl2.errormodel.tests.issues;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.validation.Issue;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider;
import org.osate.testsupport.AssertHelper;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;
import com.itemis.xtext.testing.XtextTest;

/**
 * Preserves EMV2 regression coverage for OSATE issue #2455 during the Xtend-to-Java migration.
 */
@RunWith(XtextRunner.class)
@InjectWith(ErrorModelInjectorProvider.class)
public class Issue2455Test extends XtextTest {
	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Test
	public void issue2455Test() throws Exception {
		final FluentIssueCollection testFileResult = this.issues = this.testHelper
				.testFile("org.osate.aadl2.errormodel.tests/models/Issue2455/Cyclic_Error_types.aadl");
		final FluentIssueCollection issueCollection = new FluentIssueCollection(testFileResult.getResource(),
				new ArrayList<>(), new ArrayList<>());
		var aadlPackage = ((AadlPackage) (testFileResult.getResource().getContents()).getFirst());
		Assert.assertEquals("Cyclic_Error_Types", aadlPackage.getName());
		var defaultAnnexLibrary = ((DefaultAnnexLibrary) aadlPackage.getPublicSection().getOwnedAnnexLibraries()
				.get(0));
		Assert.assertEquals("EMV2", defaultAnnexLibrary.getName());
		var errorModelLibrary = ((ErrorModelLibrary) defaultAnnexLibrary.getParsedAnnexLibrary());
		AssertHelper.assertError(errorModelLibrary.getTypes().get(0), testFileResult.getIssues(), issueCollection,
				"Cycle in supertype hierarchy of error type a at type b");
		AssertHelper.assertError(errorModelLibrary.getTypes().get(1), testFileResult.getIssues(), issueCollection,
				"Cycle in supertype hierarchy of error type b at type a");

		issueCollection.sizeIs(testFileResult.getIssues().size());
		this.assertConstraints(issueCollection);

	}
}
