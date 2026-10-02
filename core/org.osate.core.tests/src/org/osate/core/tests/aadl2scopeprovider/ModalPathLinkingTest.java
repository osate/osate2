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
package org.osate.core.tests.aadl2scopeprovider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import java.util.List;

import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.validation.Issue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.ModalPath;
import org.osate.aadl2.ModeFeature;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * Characterizes mode and transition references on connections and flows before and after migration to scope-based
 * linking. References must retain case-insensitive lookup and inheritance from types and implementations, while
 * rejecting missing names, non-mode members, and modes belonging to unrelated classifiers.
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class ModalPathLinkingTest extends XtextTest {
	private static final String PATH = "org.osate.core.tests/models/modalPathScope/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Inject
	private IScopeProvider scopeProvider;

	@Test
	public void connectionsAndFlowsLinkToInheritedTypeModesIgnoringCase() throws Exception {
		var pkg = testHelper.parseFile(PATH + "ModalPaths.aadl");
		validationHelper.assertNoIssues(pkg);
		var base = (ComponentType) classifier(pkg, "Base");
		var derived = (ComponentType) classifier(pkg, "Derived");
		var implementation = (ComponentImplementation) classifier(pkg, "Derived.base");
		var idle = base.getOwnedModes().getFirst();
		var activate = base.getOwnedModeTransitions().getFirst();
		assertTargets(base.getOwnedFlowSpecifications().getFirst(), idle, activate);
		assertTargets(derived.getOwnedFlowSpecifications().getFirst(), idle, activate);
		for (var connection : implementation.getOwnedConnections()) {
			assertTargets(connection, idle, activate);
		}
		assertTargets(implementation.getOwnedFlowImplementations().getFirst(), idle, activate);
		assertTargets(implementation.getOwnedEndToEndFlows().getFirst(), idle, activate);
		var leaf = (ComponentImplementation) classifier(pkg, "Derived.leaf");
		assertTargets(leaf.getOwnedConnections().getFirst(), idle, base.getOwnedModes().get(1), activate);
	}

	@Test
	public void connectionsAndFlowsLinkToInheritedImplementationModesIgnoringCase() throws Exception {
		var pkg = testHelper.parseFile(PATH + "ModalPaths.aadl");
		validationHelper.assertNoIssues(pkg);
		var base = (ComponentImplementation) classifier(pkg, "ImplementationModes.base");
		var leaf = (ComponentImplementation) classifier(pkg, "ImplementationModes.leaf");
		var waiting = base.getOwnedModes().getFirst();
		var advance = base.getOwnedModeTransitions().getFirst();
		assertTargets(base.getOwnedConnections().getFirst(), waiting, advance);
		assertTargets(leaf.getOwnedConnections().getFirst(), waiting, advance);
		assertTargets(leaf.getOwnedEndToEndFlows().getFirst(), waiting, advance);
	}

	@Test
	public void scopeExcludesNonModeMembersAndModesOfOtherClassifiers() throws Exception {
		var pkg = testHelper.parseFile(PATH + "ModalPaths.aadl");
		validationHelper.assertNoIssues(pkg);
		var implementation = (ComponentImplementation) classifier(pkg, "Derived.base");
		var scope = scopeProvider.getScope(implementation.getOwnedConnections().getFirst(),
				Aadl2Package.eINSTANCE.getModalPath_InModeOrTransition());
		assertNull(scope.getSingleElement(QualifiedName.create("tick")));
		assertNull(scope.getSingleElement(QualifiedName.create("foreign_mode")));
		assertNull(scope.getSingleElement(QualifiedName.create("missing")));
	}

	@Test
	public void invalidModeReferencesRemainUnresolved() throws Exception {
		var pkg = testHelper.parseFile(PATH + "InvalidModalPaths.aadl", PATH + "ModalPaths.aadl");
		var issues = validationHelper.validate(pkg);
		assertEquals(List.of("Couldn't resolve reference to ModeFeature 'foreign_mode'.",
				"Couldn't resolve reference to ModeFeature 'missing'.",
				"Couldn't resolve reference to ModeFeature 'tick'."),
				issues.stream().map(Issue::getMessage).sorted().toList());
		assertEquals(List.of(Diagnostic.LINKING_DIAGNOSTIC), issues.stream().map(Issue::getCode).distinct().toList());
	}

	private static void assertTargets(ModalPath path, ModeFeature... expected) {
		var targets = path.getInModeOrTransitions();
		assertEquals(expected.length, targets.size());
		for (int index = 0; index < expected.length; index++) {
			assertSame(expected[index], targets.get(index));
		}
	}

	private static ComponentClassifier classifier(AadlPackage pkg, String name) {
		return (ComponentClassifier) pkg.getPublicSection().getOwnedClassifiers().stream()
				.filter(classifier -> name.equals(classifier.getName())).findFirst().orElseThrow();
	}
}
