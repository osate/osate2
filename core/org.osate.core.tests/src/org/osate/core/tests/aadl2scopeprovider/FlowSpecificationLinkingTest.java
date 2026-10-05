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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
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
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * Characterizes flow specification and end-to-end refinement linking as lookup moves to the scope provider.
 * Refinements select the nearest inherited declaration, while implementations select specifications from their
 * component type. Case-insensitive names and unresolved-reference diagnostics must be preserved.
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class FlowSpecificationLinkingTest extends XtextTest {
	private static final String PATH = "org.osate.core.tests/models/flowSpecificationScope/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Inject
	private IScopeProvider scopeProvider;

	@Test
	public void flowRefinementsSelectNearestInheritedSpecificationsIgnoringCase() throws Exception {
		var pkg = parseValidModel();
		var middle = (ComponentType) classifier(pkg, "Middle");
		var base = middle.getExtended();
		var leaf = (ComponentType) classifier(pkg, "Leaf");
		for (int index = 0; index < 3; index++) {
			var original = base.getOwnedFlowSpecifications().get(index);
			var refined = middle.getOwnedFlowSpecifications().get(index);
			var mostRefined = leaf.getOwnedFlowSpecifications().get(index);
			assertSame(original, refined.getRefined());
			assertSame(refined, mostRefined.getRefined());
			assertUniqueTarget(mostRefined, Aadl2Package.eINSTANCE.getFlowSpecification_Refined(),
					original.getName(), refined);
		}
	}

	@Test
	public void flowImplementationsSelectTheRefinedSpecificationsOfTheirType() throws Exception {
		var pkg = parseValidModel();
		var type = (ComponentType) classifier(pkg, "Leaf");
		var implementation = (ComponentImplementation) classifier(pkg, "Leaf.leaf");
		assertEquals(3, implementation.getOwnedFlowImplementations().size());
		for (int index = 0; index < 3; index++) {
			var specification = type.getOwnedFlowSpecifications().get(index);
			var flow = implementation.getOwnedFlowImplementations().get(index);
			assertSame(specification, flow.getSpecification());
			assertUniqueTarget(flow, Aadl2Package.eINSTANCE.getFlowImplementation_Specification(),
					specification.getName(), specification);
		}
	}

	@Test
	public void endToEndRefinementsSelectNearestInheritedFlowsIgnoringCase() throws Exception {
		var pkg = parseValidModel();
		var middle = (ComponentImplementation) classifier(pkg, "Middle.middle");
		var base = middle.getExtended();
		var leaf = (ComponentImplementation) classifier(pkg, "Leaf.leaf");
		var original = base.getOwnedEndToEndFlows().getFirst();
		var refined = middle.getOwnedEndToEndFlows().getFirst();
		var mostRefined = leaf.getOwnedEndToEndFlows().getFirst();
		assertSame(original, refined.getRefined());
		assertSame(refined, mostRefined.getRefined());
		assertUniqueTarget(mostRefined, Aadl2Package.eINSTANCE.getEndToEndFlow_Refined(), original.getName(), refined);
	}

	@Test
	public void refinementScopesExcludeLocalFlowsAndHaveNoFallback() throws Exception {
		var pkg = parseValidModel();
		var leaf = (ComponentType) classifier(pkg, "Leaf");
		var reference = Aadl2Package.eINSTANCE.getFlowSpecification_Refined();
		var scope = scopeProvider.getScope(leaf.getOwnedFlowSpecifications().getFirst(), reference);
		assertNull(scope.getSingleElement(QualifiedName.create("local_flow")));
		assertNull(scope.getSingleElement(QualifiedName.create("output")));
		var base = leaf.getExtended().getExtended();
		assertFalse(scopeProvider.getScope(base.getOwnedFlowSpecifications().getFirst(), reference)
				.getAllElements().iterator().hasNext());

		var implementation = (ComponentImplementation) classifier(pkg, "Leaf.leaf");
		var eteReference = Aadl2Package.eINSTANCE.getEndToEndFlow_Refined();
		var eteScope = scopeProvider.getScope(implementation.getOwnedEndToEndFlows().getFirst(), eteReference);
		assertNull(eteScope.getSingleElement(QualifiedName.create("local_ete")));
		assertNull(eteScope.getSingleElement(QualifiedName.create("worker")));
		var baseImplementation = implementation.getExtended().getExtended();
		assertFalse(scopeProvider.getScope(baseImplementation.getOwnedEndToEndFlows().getFirst(), eteReference)
				.getAllElements().iterator().hasNext());
	}

	@Test
	public void invalidFlowReferencesRemainUnresolved() throws Exception {
		var pkg = testHelper.parseFile(PATH + "InvalidFlows.aadl", PATH + "BaseFlows.aadl");
		var issues = validationHelper.validate(pkg);
		assertEquals(List.of("Couldn't resolve reference to EndToEndFlow 'missing_base_ete'.",
				"Couldn't resolve reference to EndToEndFlow 'missing_ete'.",
				"Couldn't resolve reference to EndToEndFlow 'worker'.",
				"Couldn't resolve reference to FlowSpecification 'missing_base'.",
				"Couldn't resolve reference to FlowSpecification 'missing_impl'.",
				"Couldn't resolve reference to FlowSpecification 'missing_spec'.",
				"Couldn't resolve reference to FlowSpecification 'output'."),
				issues.stream().map(Issue::getMessage).sorted().toList());
		assertEquals(List.of(Diagnostic.LINKING_DIAGNOSTIC), issues.stream().map(Issue::getCode).distinct().toList());
	}

	private AadlPackage parseValidModel() throws Exception {
		var pkg = testHelper.parseFile(PATH + "Flows.aadl", PATH + "BaseFlows.aadl");
		validationHelper.assertNoIssues(pkg);
		validationHelper.assertNoIssues(classifier(pkg, "Middle").getExtended().eResource().getContents().getFirst());
		return pkg;
	}

	private void assertUniqueTarget(EObject context, EReference reference, String name, EObject expected) {
		var candidates = scopeProvider.getScope(context, reference).getElements(QualifiedName.create(name)).iterator();
		assertSame(expected, candidates.next().getEObjectOrProxy());
		assertFalse(candidates.hasNext());
	}

	private static ComponentClassifier classifier(AadlPackage pkg, String name) {
		return (ComponentClassifier) pkg.getPublicSection().getOwnedClassifiers().stream()
				.filter(classifier -> name.equals(classifier.getName())).findFirst().orElseThrow();
	}
}
