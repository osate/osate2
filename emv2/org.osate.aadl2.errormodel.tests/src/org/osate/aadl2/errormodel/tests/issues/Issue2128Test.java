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
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
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
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.ReportingPortReference;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;
import com.itemis.xtext.testing.XtextTest;

/**
 * Preserves EMV2 regression coverage for OSATE issue #2128 during the Xtend-to-Java migration.
 */
@RunWith(XtextRunner.class)
@InjectWith(ErrorModelInjectorProvider.class)
public class Issue2128Test extends XtextTest {
	@Inject
	private ValidationTestHelper validationTestHelper;

	@Inject
	private TestHelper<AadlPackage> testHelper;
	private AssertHelper assertHelper = IResourceServiceProvider.Registry.INSTANCE
			.getResourceServiceProvider(URI.createFileURI("dummy.emv2")).<AssertHelper>get(AssertHelper.class);

	@Test
	public void testScoping() throws Exception {
		var issue2128Scoping = """
				package issue_2128_scoping
				public
				\tabstract a1
				\t\tfeatures
				\t\t\tfg1: feature group fgt1;
				\tend a1;
				\t
				\tabstract implementation a1.i
				\t\tinternal features
				\t\t\tevent_source_1: event;
				\t\tannex EMV2 {**
				\t\t\tcomponent error behavior
				\t\t\t\tdetections
				\t\t\t\t\tdetection1: all -[access]-> fg1.fg2.fg3.port3 !;
				\t\t\tend component;
				\t\t**};
				\tend a1.i;
				\t
				\tfeature group fgt1
				\t\tfeatures
				\t\t\tport1: in out data port;
				\t\t\tfg2: feature group fgt2;
				\tend fgt1;
				\t
				\tfeature group fgt2
				\t\tfeatures
				\t\t\tport2: in out data port;
				\t\t\tfg3: feature group fgt3;
				\tend fgt2;
				\t
				\tfeature group fgt3
				\t\tfeatures
				\t\t\tport3: in out data port;
				\tend fgt3;
				end issue_2128_scoping;
				""";
		final EReference reference = ErrorModelPackage.eINSTANCE.getReportingPortReference_Element();
		var aadlPackage = this.testHelper.parseString(issue2128Scoping);
		this.validationTestHelper.assertNoIssues(aadlPackage);
		Assert.assertEquals("issue_2128_scoping", aadlPackage.getName());
		var classifier = aadlPackage.getPublicSection().getOwnedClassifiers().get(1);
		Assert.assertEquals("a1.i", classifier.getName());
		final DefaultAnnexSubclause defaultSubclause = ((DefaultAnnexSubclause) (classifier.getOwnedAnnexSubclauses())
				.getFirst());
		var errorDetection = (((ErrorModelSubclause) defaultSubclause.getParsedAnnexSubclause()).getErrorDetections())
				.getFirst();
		Assert.assertEquals("detection1", errorDetection.getName());
		var reportingPortReference4 = errorDetection.getDetectionReportingPort();
		Assert.assertEquals("port3", reportingPortReference4.getElement().getName());
		this.assertHelper.assertScope(reportingPortReference4, reference, List.of("port3"));
		var reportingPortReference3 = reportingPortReference4.getPrevious();
		Assert.assertEquals("fg3", reportingPortReference3.getElement().getName());
		this.assertHelper.assertScope(reportingPortReference3, reference, List.of("port2", "fg3"));
		var reportingPortReference2 = reportingPortReference3.getPrevious();
		Assert.assertEquals("fg2", reportingPortReference2.getElement().getName());
		this.assertHelper.assertScope(reportingPortReference2, reference, List.of("port1", "fg2"));
		var reportingPortReference = reportingPortReference2.getPrevious();
		Assert.assertEquals("fg1", reportingPortReference.getElement().getName());
		this.assertHelper.assertScope(reportingPortReference, reference, List.of("fg1", "event_source_1"));
		Assert.assertNull(reportingPortReference.getPrevious());

	}

	@Test
	public void testValidation() throws Exception {
		var issue2128Validation = """
				package issue_2128_validation
				public
				\tabstract a1
				\t\tfeatures
				\t\t\tabstract_feature_1: feature;
				\t\t\tport1: in out data port;
				\t\t\tdata_access_1: provides data access;
				\t\t\tfg1: feature group fgt1;
				\tend a1;
				\t
				\tabstract implementation a1.i
				\t\tinternal features
				\t\t\tevent_source_1: event;
				\t\tannex EMV2 {**
				\t\t\tcomponent error behavior
				\t\t\t\tdetections
				\t\t\t\t\t--Valid
				\t\t\t\t\tdetection1: all -[access]-> abstract_feature_1 !;
				\t\t\t\t\tdetection2: all -[access]-> port1 !;
				\t\t\t\t\tdetection3: all -[access]-> event_source_1 !;
				\t\t\t\t\tdetection4: all -[access]-> fg1.abstract_feature_2 !;
				\t\t\t\t\tdetection5: all -[access]-> fg1.port2 !;
				\t\t\t\t\t
				\t\t\t\t\t--Invalid
				\t\t\t\t\tdetection6: all -[access]-> fg1 !;
				\t\t\t\t\tdetection7: all -[access]-> data_access_1 !;
				\t\t\t\t\tdetection8: all -[access]-> fg1.fg2 !;
				\t\t\t\t\tdetection9: all -[access]-> fg1.data_access_2 !;
				\t\t\tend component;
				\t\t**};
				\tend a1.i;
				\t
				\tfeature group fgt1
				\t\tfeatures
				\t\t\tabstract_feature_2: feature;
				\t\t\tport2: in out data port;
				\t\t\tdata_access_2: provides data access;
				\t\t\tfg2: feature group;
				\tend fgt1;
				end issue_2128_validation;
				""";
		final FluentIssueCollection testFileResult = this.issues = this.testHelper.testString(issue2128Validation);
		final FluentIssueCollection issueCollection = new FluentIssueCollection(testFileResult.getResource(),
				new ArrayList<>(), new ArrayList<>());
		var aadlPackage = ((AadlPackage) (testFileResult.getResource().getContents()).getFirst());
		Assert.assertEquals("issue_2128_validation", aadlPackage.getName());
		var classifier = aadlPackage.getPublicSection().getOwnedClassifiers().get(1);
		Assert.assertEquals("a1.i", classifier.getName());
		var errorModelSubclause = ((ErrorModelSubclause) ((DefaultAnnexSubclause) (classifier.getOwnedAnnexSubclauses())
				.getFirst()).getParsedAnnexSubclause());
		var errorDetection = errorModelSubclause.getErrorDetections().get(5);
		Assert.assertEquals("detection6", errorDetection.getName());
		AssertHelper.assertError(errorDetection.getDetectionReportingPort(), testFileResult.getIssues(),
				issueCollection, "\'fg1\' is not a port, abstract feature, or internal feature.");
		var errorDetection2 = errorModelSubclause.getErrorDetections().get(6);
		Assert.assertEquals("detection7", errorDetection2.getName());
		AssertHelper.assertError(errorDetection2.getDetectionReportingPort(), testFileResult.getIssues(),
				issueCollection, "\'data_access_1\' is not a port, abstract feature, or internal feature.");
		var errorDetection3 = errorModelSubclause.getErrorDetections().get(7);
		Assert.assertEquals("detection8", errorDetection3.getName());
		AssertHelper.assertError(errorDetection3.getDetectionReportingPort(), testFileResult.getIssues(),
				issueCollection, "\'fg2\' is not a port, abstract feature, or internal feature.");
		var errorDetection4 = errorModelSubclause.getErrorDetections().get(8);
		Assert.assertEquals("detection9", errorDetection4.getName());
		AssertHelper.assertError(errorDetection4.getDetectionReportingPort(), testFileResult.getIssues(),
				issueCollection, "\'data_access_2\' is not a port, abstract feature, or internal feature.");

		issueCollection.sizeIs(testFileResult.getIssues().size());
		this.assertConstraints(issueCollection);

	}
}
