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

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.BusType;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2Path;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2PropertyAssociation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;
import org.osate.xtext.aadl2.errormodel.util.EMV2Properties;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * Preserves EMV2 regression coverage for OSATE issue #1975 during the Xtend-to-Java migration.
 */
@RunWith(XtextRunner.class)
@InjectWith(ErrorModelInjectorProvider.class)
public class Issue1975Test extends XtextTest {
	private static final String PROJECT_LOCATION = "org.osate.aadl2.errormodel.tests/models/Issue1975/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Test
	public void testPkg1() {
		final String pkg1FileName = "BindingsPath.aadl";
		final AadlPackage pkg = this.testHelper.parseFile((Issue1975Test.PROJECT_LOCATION + pkg1FileName));
		Assert.assertEquals("BindingsPath", pkg.getName());
		var busType = ((BusType) (pkg.getPublicSection().getOwnedClassifiers()).getFirst());
		Assert.assertEquals("PCI", busType.getName());
		var emv2PropertyAssociation = ((ErrorModelSubclause) ((DefaultAnnexSubclause) (busType
				.getOwnedAnnexSubclauses()).getFirst()).getParsedAnnexSubclause()).getProperties().get(0);
		final ErrorTypes et = EMV2Util.getErrorType(emv2PropertyAssociation.getEmv2Path().get(0));
		Assert.assertTrue((et != null));
		Assert.assertEquals("ServiceOmission", et.getName());
		Assert.assertEquals(0.567, EMV2Properties.getOccurrenceValue(emv2PropertyAssociation), 0.01);

	}
}
