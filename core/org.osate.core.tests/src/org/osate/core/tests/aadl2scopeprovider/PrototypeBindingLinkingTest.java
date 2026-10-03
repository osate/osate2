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
import org.eclipse.xtext.diagnostics.Severity;
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
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentPrototypeBinding;
import org.osate.aadl2.FeatureGroupPrototypeBinding;
import org.osate.aadl2.Prototype;
import org.osate.aadl2.PrototypeBinding;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * Characterizes formal prototype lookup in every binding context as it moves to the scope provider. Bindings must
 * select prototypes from the bound classifier, including refinements, without capturing prototypes from the enclosing
 * classifier or a different nested actual. Prototype refinement linking remains separate from binding formal lookup.
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class PrototypeBindingLinkingTest extends XtextTest {
	private static final String PATH = "org.osate.core.tests/models/prototypeBindingScope/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Inject
	private IScopeProvider scopeProvider;

	@Test
	public void classifierBindingsSelectInheritedFormalsIgnoringCase() throws Exception {
		var pkg = parseValidModel();
		var template = classifier(pkg, "Template");
		var refined = classifier(pkg, "RefinedTemplate");
		var bound = classifier(pkg, "Bound");
		var implementation = classifier(pkg, "Template.base");
		for (int index = 0; index < 3; index++) {
			assertSame(template.getOwnedPrototypes().get(index), refined.getOwnedPrototypes().get(index).getRefined());
			assertBinding(bound.getOwnedPrototypeBindings().get(index), refined.getOwnedPrototypes().get(index));
			assertBinding(implementation.getOwnedPrototypeBindings().get(index), template.getOwnedPrototypes().get(index));
		}
		assertBinding(classifier(pkg, "Template.extended").getOwnedPrototypeBindings().getFirst(),
				template.getOwnedPrototypes().getFirst());
		assertBinding(classifier(pkg, "BoundGroup").getOwnedPrototypeBindings().getFirst(),
				classifier(pkg, "Group1").getOwnedPrototypes().getFirst());
	}

	@Test
	public void subcomponentBindingsSelectTheReferencedClassifiersFormals() throws Exception {
		var pkg = parseValidModel();
		var implementation = (ComponentImplementation) classifier(pkg, "Container.i");
		var bindings = implementation.getOwnedSubcomponents().getFirst().getOwnedPrototypeBindings();
		var target = classifier(pkg, "RefinedTemplate");
		for (int index = 0; index < 3; index++) {
			assertBinding(bindings.get(index), target.getOwnedPrototypes().get(index));
		}
	}

	@Test
	public void nestedActualBindingsUseTheirOwnComponentOrFeatureGroup() throws Exception {
		var pkg = parseValidModel();
		var implementation = (ComponentImplementation) classifier(pkg, "Container.i");
		for (var bindings : List.of(classifier(pkg, "Bound").getOwnedPrototypeBindings(),
				implementation.getOwnedSubcomponents().getFirst().getOwnedPrototypeBindings())) {
			var component = (ComponentPrototypeBinding) bindings.get(0);
			var group = (FeatureGroupPrototypeBinding) bindings.get(1);
			assertBinding(component.getActuals().getFirst().getBindings().getFirst(),
					classifier(pkg, "Payload").getOwnedPrototypes().getFirst());
			assertBinding(group.getActual().getBindings().getFirst(),
					classifier(pkg, "Group1").getOwnedPrototypes().getFirst());
		}
	}

	@Test
	public void implementationReferenceBindingsUseTheReferencedImplementation() throws Exception {
		var pkg = testHelper.parseFile(PATH + "ImplementationReferences.aadl", PATH + "Bindings.aadl");
		var issues = validationHelper.validate(pkg);
		assertEquals(List.of("List of implementation reference not fully implemented in instantiator."),
				issues.stream().map(Issue::getMessage).toList());
		assertEquals(Severity.WARNING, issues.getFirst().getSeverity());
		var implementation = (ComponentImplementation) classifier(pkg, "Holder.i");
		var reference = implementation.getOwnedSubcomponents().getFirst().getImplementationReferences().getFirst();
		var target = reference.getImplementation();
		validationHelper.assertNoIssues(target.eResource().getContents().getFirst());
		assertBinding(reference.getOwnedPrototypeBindings().getFirst(), target.getType().getOwnedPrototypes().getFirst());
	}

	@Test
	public void bindingScopesExcludeLocalDeclarationsAndOtherContexts() throws Exception {
		var pkg = parseValidModel();
		var binding = classifier(pkg, "Bound").getOwnedPrototypeBindings().getFirst();
		var scope = scopeProvider.getScope(binding, Aadl2Package.eINSTANCE.getPrototypeBinding_Formal());
		assertNull(scope.getSingleElement(QualifiedName.create("local_proto")));
		assertNull(scope.getSingleElement(QualifiedName.create("event1")));
		var actual = ((ComponentPrototypeBinding) binding).getActuals().getFirst();
		var nestedScope = scopeProvider.getScope(actual.getBindings().getFirst(),
				Aadl2Package.eINSTANCE.getPrototypeBinding_Formal());
		assertNull(nestedScope.getSingleElement(QualifiedName.create("comp")));
	}

	@Test
	public void invalidFormalsRemainUnresolved() throws Exception {
		var pkg = testHelper.parseFile(PATH + "InvalidBindings.aadl", PATH + "Bindings.aadl");
		var issues = validationHelper.validate(pkg);
		assertEquals(List.of("Couldn't resolve reference to Prototype 'comp'.",
				"Couldn't resolve reference to Prototype 'event1'.",
				"Couldn't resolve reference to Prototype 'feat'.",
				"Couldn't resolve reference to Prototype 'local_proto'.",
				"Couldn't resolve reference to Prototype 'missing'.",
				"Couldn't resolve reference to Prototype 'nested'."),
				issues.stream().map(Issue::getMessage).sorted().toList());
		assertEquals(List.of(Diagnostic.LINKING_DIAGNOSTIC), issues.stream().map(Issue::getCode).distinct().toList());
	}

	private AadlPackage parseValidModel() throws Exception {
		var pkg = testHelper.parseFile(PATH + "Bindings.aadl");
		validationHelper.assertNoIssues(pkg);
		return pkg;
	}

	private void assertBinding(PrototypeBinding binding, Prototype expected) {
		assertSame(expected, binding.getFormal());
		var candidates = scopeProvider.getScope(binding, Aadl2Package.eINSTANCE.getPrototypeBinding_Formal())
				.getElements(QualifiedName.create(expected.getName())).iterator();
		assertSame(expected, candidates.next().getEObjectOrProxy());
		assertFalse(candidates.hasNext());
	}

	private static Classifier classifier(AadlPackage pkg, String name) {
		return pkg.getPublicSection().getOwnedClassifiers().stream()
				.filter(classifier -> name.equals(classifier.getName())).findFirst().orElseThrow();
	}
}
