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
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider;
import org.osate.testsupport.AssertHelper;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;
import com.itemis.xtext.testing.XtextTest;

/**
 * Preserves EMV2 regression coverage for OSATE issue #117 during the Xtend-to-Java migration.
 */
@RunWith(XtextRunner.class)
@InjectWith(ErrorModelInjectorProvider.class)
public class Issue117Test extends XtextTest {
	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Test
	public void issue117() throws Exception {
		var issue117 = """
				package pkg1
				public
				\tabstract a1
				\t\tannex EMV2 {**
				\t\t\tuse types pkg1;
				\t\t\t
				\t\t\tcomponent error behavior
				\t\t\tpropagations
				\t\t\t\tcondition1: all -[ ]-> all;
				\t\t\t\tcondition2: all -[ memory ]-> all;
				\t\t\t\tcondition3: all -[ ]-> all {errorType1};
				\t\t\t\tcondition4: all -[ memory ]-> all {errorType1};
				\t\t\tend component;
				\t\t**};
				\tend a1;
				\t
				\tannex EMV2 {**
				\t\terror types
				\t\t\terrorType1: type;
				\t\tend types;
				\t**};
				end pkg1;
				""";
		final FluentIssueCollection testFileResult = this.issues = this.testHelper.testString(issue117);
		final FluentIssueCollection issueCollection = new FluentIssueCollection(testFileResult.getResource(),
				new ArrayList<>(), new ArrayList<>());
		var aadlPackage = ((AadlPackage) (testFileResult.getResource().getContents()).getFirst());
		Assert.assertEquals("pkg1", aadlPackage.getName());
		var classifier = (aadlPackage.getPublicSection().getOwnedClassifiers()).getFirst();
		Assert.assertEquals("a1", classifier.getName());
		var outgoingPropagationCondition = (((ErrorModelSubclause) ((DefaultAnnexSubclause) (classifier
				.getOwnedAnnexSubclauses()).getFirst()).getParsedAnnexSubclause()).getOutgoingPropagationConditions())
				.getFirst();
		Assert.assertEquals("condition1", outgoingPropagationCondition.getName());
		AssertHelper.assertError(outgoingPropagationCondition, testFileResult.getIssues(), issueCollection,
				"Propagation condition must have at least a condition within brackets or a type set for the outgoing propagation");

		issueCollection.sizeIs(testFileResult.getIssues().size());
		this.assertConstraints(issueCollection);

	}
}
