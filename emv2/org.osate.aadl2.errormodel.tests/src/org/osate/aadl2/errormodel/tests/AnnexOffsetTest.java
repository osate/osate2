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
package org.osate.aadl2.errormodel.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.SystemType;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;

import com.google.inject.Inject;

/**
 * Verifies that the generic AADL offset helper enters an embedded EMV2 node model using host-resource offsets. This
 * guards the nested-Xtext annex support that must remain when legacy annex editor extension points are changed.
 */
@RunWith(XtextRunner.class)
@InjectWith(ErrorModelInjectorProvider.class)
public class AnnexOffsetTest {
	private static final String MODEL = "org.osate.aadl2.errormodel.tests/models/annexOffsets/AnnexOffsets.aadl";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Inject
	private EObjectAtOffsetHelper offsetHelper;

	@Test
	public void resolvesElementsAcrossEmbeddedAnnexOffsets() {
		var pkg = testHelper.parseFile(MODEL);
		validationHelper.assertNoIssues(pkg);

		var system = (SystemType) pkg.getPublicSection().getOwnedClassifiers().get(0);
		var defaultAnnex = (DefaultAnnexSubclause) system.getOwnedAnnexSubclauses().get(0);
		var annex = (ErrorModelSubclause) defaultAnnex.getParsedAnnexSubclause();
		var resource = (XtextResource) pkg.eResource();
		var resourceText = resource.getParseResult().getRootNode().getText();
		var annexDelimiterOffset = resourceText.indexOf("{**");
		assertTrue("Expected an embedded annex delimiter", annexDelimiterOffset >= 0);
		var annexOffset = annexDelimiterOffset + 3;
		var annexLength = defaultAnnex.getSourceText().length() - 6;

		var semanticHits = 0;
		var crossReferenceHits = 0;
		for (var offset = annexOffset; offset < annexOffset + annexLength; offset++) {
			if (offsetHelper.resolveElementAt(resource, offset) != null) {
				semanticHits++;
			}
			if (offsetHelper.resolveCrossReferencedElementAt(resource, offset) != null) {
				crossReferenceHits++;
			}
		}

		assertTrue("The EMV2 offset sweep must reach semantic elements", semanticHits > 0);
		assertTrue("The EMV2 offset sweep must reach cross references", crossReferenceHits > 0);

		var useTypesOffset = resourceText.indexOf("ErrorLibrary", annexOffset);
		var errorLibrary = assertCrossReference(resource, useTypesOffset, "ErrorLibrary", "ErrorModelLibrary",
				"EMV2");
		assertSame(annex.getUseTypes().get(0), errorLibrary);

		var propagationOffset = resourceText.indexOf("input: in propagation", annexOffset);
		var dataPort = assertCrossReference(resource, propagationOffset, "input", "DataPort", "input");
		assertSame(system.getOwnedDataPorts().get(0), dataPort);

		var errorTypeOffset = resourceText.indexOf("ServiceOmission", propagationOffset);
		assertCrossReference(resource, errorTypeOffset, "ServiceOmission", "ErrorType", "ServiceOmission");
	}

	private EObject assertCrossReference(XtextResource resource, int offset, String token, String expectedEClass,
			String expectedName) {
		assertTrue("Expected token in the parsed resource: " + token, offset >= 0);
		var target = offsetHelper.resolveCrossReferencedElementAt(resource, offset);
		assertNotNull("Expected a cross reference at " + token, target);
		assertEquals(expectedEClass, target.eClass().getName());
		assertEquals(expectedName, ((NamedElement) target).getName());

		for (var tokenOffset = offset; tokenOffset < offset + token.length(); tokenOffset++) {
			assertSame("Every character in " + token + " must resolve to the same target", target,
					offsetHelper.resolveCrossReferencedElementAt(resource, tokenOffset));
		}
		return target;
	}
}
