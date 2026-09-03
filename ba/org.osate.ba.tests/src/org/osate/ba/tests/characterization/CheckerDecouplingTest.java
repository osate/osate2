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
 * aries to this license with respect to the terms applicable to the Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.ba.tests.characterization;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.Element;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter;
import org.osate.annexsupport.AnnexUtil;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ba.analyzers.AadlBaRulesCheckersDriver;
import org.osate.ba.analyzers.AadlBaTypeChecker;
import org.osate.ba.analyzers.AdaLikeDataTypeChecker;
import org.osate.ba.analyzers.DataTypeChecker;
import org.osate.ba.utils.AadlBaVisitors;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.ba.util.BehaviorAnnexUtil;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;

/**
 * Verifies the phase 2b checker boundary required by the future declarative-to-strict translator: classifier context
 * must be supplied without relying on annex containment, and checking an already resolved detached strict model must
 * not mutate it.
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class CheckerDecouplingTest {
	private static final String MODEL = "org.osate.ba.tests/models/characterization/GrammarHazards.aadl";

	@Inject
	private TestHelper<Element> testHelper;

	@Test
	public void detachedResolvedModelUsesExplicitContextAndRemainsUnchanged() throws Exception {
		final var root = testHelper.parseFile(MODEL);
		final var issues = testHelper.testResource(root.eResource());
		assertTrue(issues.getSummary(), issues.getIssues().isEmpty());

		final var defaultAnnex = AnnexUtil.getAllDefaultAnnexSubclauses(root).getFirst();
		final var classifier = (ComponentClassifier) defaultAnnex.getContainingClassifier();
		final var detached = EcoreUtil.copy(BehaviorAnnexUtil.getStrictModel(defaultAnnex));
		assertNull(detached.eContainer());

		final var getParentComponent = AadlBaVisitors.class.getMethod("getParentComponent", BehaviorAnnex.class,
				ComponentClassifier.class);
		assertSame(classifier, getParentComponent.invoke(null, detached, classifier));

		final var errorManager = new AnalysisErrorReporterManager(
				QueuingAnalysisErrorReporter.factory);
		final var dataTypeChecker = new AdaLikeDataTypeChecker(errorManager);
		final var typeCheckerConstructor = AadlBaTypeChecker.class.getConstructor(
				BehaviorAnnex.class, ComponentClassifier.class, DataTypeChecker.class,
				AnalysisErrorReporterManager.class);
		final var typeChecker = typeCheckerConstructor.newInstance(detached, classifier, dataTypeChecker,
				errorManager);
		final var beforeChecking = EcoreUtil.copy(detached);
		assertTrue(typeChecker.checkTypes());
		assertTrue("Type checking changed the detached strict model", EcoreUtil.equals(beforeChecking, detached));

		final var rulesConstructor = AadlBaRulesCheckersDriver.class
				.getConstructor(BehaviorAnnex.class, ComponentClassifier.class, AnalysisErrorReporterManager.class);
		final var rules = rulesConstructor.newInstance(detached, classifier, errorManager);
		assertTrue(rules.process(detached));
		assertTrue("Rules checking changed the detached strict model", EcoreUtil.equals(beforeChecking, detached));
	}
}
