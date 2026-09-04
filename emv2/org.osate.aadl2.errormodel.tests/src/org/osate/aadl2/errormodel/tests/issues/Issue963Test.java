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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.validation.Issue;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AbstractImplementation;
import org.osate.aadl2.AbstractType;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider;
import org.osate.testsupport.AssertHelper;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2PathElement;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;
import com.itemis.xtext.testing.XtextTest;

/**
 * Preserves EMV2 regression coverage for OSATE issue #963 during the Xtend-to-Java migration.
 */
@RunWith(XtextRunner.class)
@InjectWith(ErrorModelInjectorProvider.class)
public class Issue963Test extends XtextTest {
	private static final String PROJECT_LOCATION = "org.osate.aadl2.errormodel.tests/models/Issue963/";

	@Inject
	private TestHelper<AadlPackage> testHelper;
	private AssertHelper assertHelper = IResourceServiceProvider.Registry.INSTANCE
			.getResourceServiceProvider(URI.createFileURI("dummy.emv2")).<AssertHelper>get(AssertHelper.class);

	@Test
	public void testPkg1() {
		final String pkg1FileName = "pkg1.aadl";
		final AadlPackage pkg = this.testHelper.parseFile((Issue963Test.PROJECT_LOCATION + pkg1FileName));
		Assert.assertEquals("pkg1", pkg.getName());
		var abstractType = ((AbstractType) (pkg.getPublicSection().getOwnedClassifiers()).getFirst());
		Assert.assertEquals("a1", abstractType.getName());
		var errorModelSubclause = ((ErrorModelSubclause) ((DefaultAnnexSubclause) (abstractType
				.getOwnedAnnexSubclauses()).getFirst()).getParsedAnnexSubclause());
		var emv2PathElement3 = (errorModelSubclause.getProperties().get(0).getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("fg1",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement3.getNamedElement())));
		this.assertHelper.assertScope(emv2PathElement3, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("f1", "fg1"));
		var emv2PathElement = emv2PathElement3.getPath();
		Assert.assertEquals("type1", emv2PathElement.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("type1", "type2", "pkg1::type1", "pkg1::type2"));
		Assert.assertNull(emv2PathElement.getPath());
		var emv2PathElement4 = (errorModelSubclause.getProperties().get(1).getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("f1", EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement4.getNamedElement())));
		this.assertHelper.assertScope(emv2PathElement4, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("f1", "fg1"));
		var emv2PathElement2 = emv2PathElement4.getPath();
		Assert.assertEquals("type1", emv2PathElement2.getNamedElement().getName());
		this.assertHelper.assertScope(emv2PathElement2, ErrorModelPackage.eINSTANCE.getEMV2PathElement_NamedElement(),
				List.of("type1", "type2", "pkg1::type1", "pkg1::type2"));
		Assert.assertNull(emv2PathElement2.getPath());

	}

	@Test
	public void testPkg2() throws Exception {
		final String pkg2FileName = "pkg2.aadl";
		final FluentIssueCollection testFileResult = this.issues = this.testHelper
				.testFile((Issue963Test.PROJECT_LOCATION + pkg2FileName));
		final FluentIssueCollection issueCollection = new FluentIssueCollection(testFileResult.getResource(),
				new ArrayList<>(), new ArrayList<>());
		var aadlPackage = ((AadlPackage) (testFileResult.getResource().getContents()).getFirst());
		Assert.assertEquals("pkg2", aadlPackage.getName());
		var abstractImplementation = ((AbstractImplementation) aadlPackage.getPublicSection().getOwnedClassifiers()
				.get(1));
		Assert.assertEquals("a1.i", abstractImplementation.getName());
		var errorModelSubclause = ((ErrorModelSubclause) ((DefaultAnnexSubclause) (abstractImplementation
				.getOwnedAnnexSubclauses()).getFirst()).getParsedAnnexSubclause());
		var emv2PathElement25 = (errorModelSubclause.getProperties().get(0).getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("fg1",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement25.getNamedElement())));
		Assert.assertTrue((emv2PathElement25.getNamedElement() instanceof ErrorPropagation));
		var emv2PathElement9 = emv2PathElement25.getPath();
		Assert.assertEquals("type1", emv2PathElement9.getNamedElement().getName());
		Assert.assertNull(emv2PathElement9.getPath());
		var emv2PathElement26 = (errorModelSubclause.getProperties().get(1).getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("fg2", emv2PathElement26.getNamedElement().getName());
		Assert.assertTrue((emv2PathElement26.getNamedElement() instanceof FeatureGroup));
		var emv2PathElement10 = emv2PathElement26.getPath();
		AssertHelper.assertError(emv2PathElement10, testFileResult.getIssues(), issueCollection,
				"Couldn\'t resolve reference to \'type1\'.");
		Assert.assertNull(emv2PathElement10.getPath());
		var emv2PathElement27 = (errorModelSubclause.getProperties().get(2).getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("fg3", emv2PathElement27.getNamedElement().getName());
		Assert.assertTrue((emv2PathElement27.getNamedElement() instanceof FeatureGroup));
		var emv2PathElement11 = emv2PathElement27.getPath();
		AssertHelper.assertError(emv2PathElement11, testFileResult.getIssues(), issueCollection,
				"Couldn\'t resolve reference to \'type1\'.");
		Assert.assertNull(emv2PathElement11.getPath());
		var emv2PathElement28 = (errorModelSubclause.getProperties().get(3).getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("fg4", emv2PathElement28.getNamedElement().getName());
		Assert.assertTrue((emv2PathElement28.getNamedElement() instanceof FeatureGroup));
		var emv2PathElement12 = emv2PathElement28.getPath();
		AssertHelper.assertError(emv2PathElement12, testFileResult.getIssues(), issueCollection,
				"Couldn\'t resolve reference to \'type1\'.");
		Assert.assertNull(emv2PathElement12.getPath());
		var emv2PathElement29 = (errorModelSubclause.getProperties().get(4).getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("fg4", emv2PathElement29.getNamedElement().getName());
		var emv2PathElement13 = emv2PathElement29.getPath();
		Assert.assertEquals("fg4.fg9",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement13.getNamedElement())));
		Assert.assertTrue((emv2PathElement13.getNamedElement() instanceof ErrorPropagation));
		var emv2PathElement = emv2PathElement13.getPath();
		Assert.assertEquals("type1", emv2PathElement.getNamedElement().getName());
		Assert.assertNull(emv2PathElement.getPath());
		var emv2PathElement30 = (errorModelSubclause.getProperties().get(5).getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("fg4", emv2PathElement30.getNamedElement().getName());
		var emv2PathElement14 = emv2PathElement30.getPath();
		Assert.assertEquals("fg10", emv2PathElement14.getNamedElement().getName());
		Assert.assertTrue((emv2PathElement14.getNamedElement() instanceof FeatureGroup));
		var emv2PathElement2 = emv2PathElement14.getPath();
		AssertHelper.assertError(emv2PathElement2, testFileResult.getIssues(), issueCollection,
				"Couldn\'t resolve reference to \'type1\'.");
		Assert.assertNull(emv2PathElement2.getPath());
		var emv2PathElement31 = (errorModelSubclause.getProperties().get(6).getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("fg4", emv2PathElement31.getNamedElement().getName());
		var emv2PathElement15 = emv2PathElement31.getPath();
		Assert.assertEquals("fg11", emv2PathElement15.getNamedElement().getName());
		Assert.assertTrue((emv2PathElement15.getNamedElement() instanceof FeatureGroup));
		var emv2PathElement3 = emv2PathElement15.getPath();
		AssertHelper.assertError(emv2PathElement3, testFileResult.getIssues(), issueCollection,
				"Couldn\'t resolve reference to \'type1\'.");
		Assert.assertNull(emv2PathElement3.getPath());
		var emv2PathElement32 = (errorModelSubclause.getProperties().get(7).getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("fg4", emv2PathElement32.getNamedElement().getName());
		var emv2PathElement16 = emv2PathElement32.getPath();
		Assert.assertEquals("fg12", emv2PathElement16.getNamedElement().getName());
		Assert.assertTrue((emv2PathElement16.getNamedElement() instanceof FeatureGroup));
		var emv2PathElement4 = emv2PathElement16.getPath();
		AssertHelper.assertError(emv2PathElement4, testFileResult.getIssues(), issueCollection,
				"Couldn\'t resolve reference to \'type1\'.");
		Assert.assertNull(emv2PathElement4.getPath());
		var emv2PathElement33 = (errorModelSubclause.getProperties().get(8).getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("fg5",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement33.getNamedElement())));
		Assert.assertTrue((emv2PathElement33.getNamedElement() instanceof ErrorPropagation));
		var emv2PathElement17 = emv2PathElement33.getPath();
		Assert.assertEquals("type1", emv2PathElement17.getNamedElement().getName());
		Assert.assertNull(emv2PathElement17.getPath());
		var emv2PathElement34 = (errorModelSubclause.getProperties().get(9).getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("fg6", emv2PathElement34.getNamedElement().getName());
		Assert.assertTrue((emv2PathElement34.getNamedElement() instanceof FeatureGroup));
		var emv2PathElement18 = emv2PathElement34.getPath();
		AssertHelper.assertError(emv2PathElement18, testFileResult.getIssues(), issueCollection,
				"Couldn\'t resolve reference to \'type1\'.");
		Assert.assertNull(emv2PathElement18.getPath());
		var emv2PathElement35 = (errorModelSubclause.getProperties().get(10).getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("fg7", emv2PathElement35.getNamedElement().getName());
		Assert.assertTrue((emv2PathElement35.getNamedElement() instanceof FeatureGroup));
		var emv2PathElement19 = emv2PathElement35.getPath();
		AssertHelper.assertError(emv2PathElement19, testFileResult.getIssues(), issueCollection,
				"Couldn\'t resolve reference to \'type1\'.");
		Assert.assertNull(emv2PathElement19.getPath());
		var emv2PathElement36 = (errorModelSubclause.getProperties().get(11).getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("fg8", emv2PathElement36.getNamedElement().getName());
		Assert.assertTrue((emv2PathElement36.getNamedElement() instanceof FeatureGroup));
		var emv2PathElement20 = emv2PathElement36.getPath();
		AssertHelper.assertError(emv2PathElement20, testFileResult.getIssues(), issueCollection,
				"Couldn\'t resolve reference to \'type1\'.");
		Assert.assertNull(emv2PathElement20.getPath());
		var emv2PathElement37 = (errorModelSubclause.getProperties().get(12).getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("fg8", emv2PathElement37.getNamedElement().getName());
		var emv2PathElement21 = emv2PathElement37.getPath();
		Assert.assertEquals("fg8.fg9",
				EMV2Util.getPropagationName(((ErrorPropagation) emv2PathElement21.getNamedElement())));
		Assert.assertTrue((emv2PathElement21.getNamedElement() instanceof ErrorPropagation));
		var emv2PathElement5 = emv2PathElement21.getPath();
		Assert.assertEquals("type1", emv2PathElement5.getNamedElement().getName());
		Assert.assertNull(emv2PathElement5.getPath());
		var emv2PathElement38 = (errorModelSubclause.getProperties().get(13).getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("fg8", emv2PathElement38.getNamedElement().getName());
		var emv2PathElement22 = emv2PathElement38.getPath();
		Assert.assertEquals("fg10", emv2PathElement22.getNamedElement().getName());
		Assert.assertTrue((emv2PathElement22.getNamedElement() instanceof FeatureGroup));
		var emv2PathElement6 = emv2PathElement22.getPath();
		AssertHelper.assertError(emv2PathElement6, testFileResult.getIssues(), issueCollection,
				"Couldn\'t resolve reference to \'type1\'.");
		Assert.assertNull(emv2PathElement6.getPath());
		var emv2PathElement39 = (errorModelSubclause.getProperties().get(14).getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("fg8", emv2PathElement39.getNamedElement().getName());
		var emv2PathElement23 = emv2PathElement39.getPath();
		Assert.assertEquals("fg11", emv2PathElement23.getNamedElement().getName());
		Assert.assertTrue((emv2PathElement23.getNamedElement() instanceof FeatureGroup));
		var emv2PathElement7 = emv2PathElement23.getPath();
		AssertHelper.assertError(emv2PathElement7, testFileResult.getIssues(), issueCollection,
				"Couldn\'t resolve reference to \'type1\'.");
		Assert.assertNull(emv2PathElement7.getPath());
		var emv2PathElement40 = (errorModelSubclause.getProperties().get(15).getEmv2Path()).getFirst().getEmv2Target();
		Assert.assertEquals("fg8", emv2PathElement40.getNamedElement().getName());
		var emv2PathElement24 = emv2PathElement40.getPath();
		Assert.assertEquals("fg12", emv2PathElement24.getNamedElement().getName());
		Assert.assertTrue((emv2PathElement24.getNamedElement() instanceof FeatureGroup));
		var emv2PathElement8 = emv2PathElement24.getPath();
		AssertHelper.assertError(emv2PathElement8, testFileResult.getIssues(), issueCollection,
				"Couldn\'t resolve reference to \'type1\'.");
		Assert.assertNull(emv2PathElement8.getPath());

		issueCollection.sizeIs(testFileResult.getIssues().size());
		this.assertConstraints(issueCollection);

	}
}
