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
import static org.junit.Assert.assertTrue;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue666Test extends XtextTest {
	private static final String AADL_TEXT = """
			package pkg1
			public
			\tabstract inner
			\t\tmodes
			\t\t\tm1: initial mode;
			\t\t\tm2: mode;
			\tend inner;
			\t
			\tabstract outer
			\tend outer;
			\t
			\tabstract implementation outer.ok
			\t\tsubcomponents
			\t\t\tsub1: abstract inner[9];
			\tend outer.ok;
			\t
			\tabstract implementation outer.tooManySOMs
			\t\tsubcomponents
			\t\t\tsub2: abstract inner[10];
			\tend outer.tooManySOMs;
			end pkg1;
			""";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void issue666() throws Exception {
		FluentIssueCollection testFileResult = issues = testHelper.testString(AADL_TEXT);
		AadlPackage pkg = (AadlPackage) testFileResult.getResource().getContents().get(0);
		assertEquals("pkg1", pkg.getName());
		var classifiers = pkg.getPublicSection().getOwnedClassifiers();

		ComponentImplementation ok = (ComponentImplementation) classifiers.get(2);
		assertEquals("outer.ok", ok.getName());
		AnalysisErrorReporterManager okErrorManager = new AnalysisErrorReporterManager(
				QueuingAnalysisErrorReporter.factory);
		var okInstance = InstantiateModel.instantiate(ok, okErrorManager);
		var okMessages = ((QueuingAnalysisErrorReporter) okErrorManager.getReporter(okInstance.eResource()))
				.getErrors();
		assertEquals("outer_ok_Instance", okInstance.getName());
		assertEquals(512, okInstance.getSystemOperationModes().size());
		assertTrue(okMessages.isEmpty());

		ComponentImplementation tooMany = (ComponentImplementation) classifiers.get(3);
		assertEquals("outer.tooManySOMs", tooMany.getName());
		AnalysisErrorReporterManager tooManyErrorManager = new AnalysisErrorReporterManager(
				QueuingAnalysisErrorReporter.factory);
		var tooManyInstance = InstantiateModel.instantiate(tooMany, tooManyErrorManager);
		var tooManyMessages = ((QueuingAnalysisErrorReporter) tooManyErrorManager
				.getReporter(tooManyInstance.eResource())).getErrors();
		assertEquals("outer_tooManySOMs_Instance", tooManyInstance.getName());
		assertEquals(1000, tooManyInstance.getSystemOperationModes().size());
		assertEquals(1, tooManyMessages.size());
		assertEquals(QueuingAnalysisErrorReporter.Kind.WARNING, tooManyMessages.get(0).kind);
		assertEquals("List of system operation modes is incomplete (see project property 'Instantiation')",
				tooManyMessages.get(0).message);
	}
}
