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
import static org.junit.Assert.assertFalse;
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
import org.osate.aadl2.ComponentImplementation;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * Characterizes connection refinement linking as it moves to the scope provider. Refinements must link to the
 * nearest inherited declaration, ignore name case, and exclude connections declared in the current implementation.
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class ConnectionRefinementLinkingTest extends XtextTest {
	private static final String MODEL = "org.osate.core.tests/models/connectionRefinementScope/Connections.aadl";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Inject
	private IScopeProvider scopeProvider;

	@Test
	public void refinementsLinkToTheNearestInheritedConnectionIgnoringCase() throws Exception {
		var pkg = testHelper.parseFile(MODEL);
		validationHelper.assertNoIssues(pkg);
		var base = implementation(pkg, "Container.base");
		var middle = implementation(pkg, "Container.middle");
		var leaf = implementation(pkg, "Container.leaf");
		for (int index = 0; index < 2; index++) {
			var original = base.getOwnedConnections().get(index);
			var refined = middle.getOwnedConnections().get(index);
			var mostRefined = leaf.getOwnedConnections().get(index);
			assertSame(original, refined.getRefined());
			assertSame(refined, mostRefined.getRefined());
			var scope = scopeProvider.getScope(mostRefined, Aadl2Package.eINSTANCE.getConnection_Refined());
			var candidates = scope.getElements(QualifiedName.create(original.getName())).iterator();
			assertSame(refined, candidates.next().getEObjectOrProxy());
			assertFalse(candidates.hasNext());
		}
	}

	@Test
	public void refinementScopeExcludesLocalConnectionsAndHasNoFallback() throws Exception {
		var pkg = testHelper.parseFile(MODEL);
		validationHelper.assertNoIssues(pkg);
		var base = implementation(pkg, "Container.base");
		var leaf = implementation(pkg, "Container.leaf");
		var reference = Aadl2Package.eINSTANCE.getConnection_Refined();
		var scope = scopeProvider.getScope(leaf.getOwnedConnections().getFirst(), reference);
		assertNull(scope.getSingleElement(QualifiedName.create("local_link")));
		assertNull(scope.getSingleElement(QualifiedName.create("missing")));
		var baseScope = scopeProvider.getScope(base.getOwnedConnections().getFirst(), reference);
		assertFalse(baseScope.getAllElements().iterator().hasNext());
	}

	@Test
	public void parameterConnectionRefinementLinksThroughItsScope() throws Exception {
		var pkg = testHelper.parseFile(MODEL);
		validationHelper.assertNoIssues(pkg);
		var base = implementation(pkg, "Parameters.base").getOwnedConnections().getFirst();
		var refined = implementation(pkg, "Parameters.derived").getOwnedConnections().getFirst();
		assertSame(base, refined.getRefined());
	}

	@Test
	public void invalidRefinementsRemainUnresolved() throws Exception {
		var pkg = testHelper.parseFile("org.osate.core.tests/models/connectionRefinementScope/InvalidConnections.aadl",
				MODEL);
		var issues = validationHelper.validate(pkg);
		assertEquals(List.of("Couldn't resolve reference to Connection 'missing'.",
				"Couldn't resolve reference to Connection 'port_link'.",
				"Couldn't resolve reference to Connection 'src'."),
				issues.stream().map(Issue::getMessage).sorted().toList());
		assertEquals(List.of(Diagnostic.LINKING_DIAGNOSTIC), issues.stream().map(Issue::getCode).distinct().toList());
	}

	private static ComponentImplementation implementation(AadlPackage pkg, String name) {
		return (ComponentImplementation) pkg.getPublicSection().getOwnedClassifiers().stream()
				.filter(classifier -> name.equals(classifier.getName())).findFirst().orElseThrow();
	}
}
