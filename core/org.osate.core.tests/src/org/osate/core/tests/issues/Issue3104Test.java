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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.ReferenceValue;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.InstanceReferenceValue;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.core.tests.instantiation.InstanceLookup;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * Characterizes the reference values that property caching leaves on a semantic connection.
 *
 * <p>
 * A reference value of a property association cached on a connection cannot be resolved from the
 * connection reference the value was looked up on, because a connection reference contains no
 * instance objects a containment path could name. The values are therefore resolved by a second
 * pass over the association in the context of the connection's enclosing component instance, and
 * that pass used to visit the values of a list twice (issue #3104). These tests pin what the pass
 * produces for every shape of reference value a connection property can hold - a list, a modal
 * list, a reference that resolves two levels down, a reference to a connection, and a reference
 * that no context resolves - so that folding the two visits into one is held to producing exactly
 * them.
 * </p>
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3104Test extends XtextTest {
	private static final String PROJECT = "org.osate.core.tests/models/issue3104/";
	private static final String MODEL = PROJECT + "Issue3104.aadl";
	private static final String PROPERTIES = PROJECT + "Issue3104Props.aadl";

	/** The one semantic connection of the fixture, named after the two thread ports it connects. */
	private static final String CONNECTION = "src.worker.output -> dst.worker.input";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	/**
	 * Every element of a list of references is instantiated, exactly once: the list holds one
	 * instance reference per declared element, in declaration order.
	 */
	@Test
	public void everyElementOfAReferenceListIsInstantiatedOnce() throws Exception {
		var values = valuesOf("Issue3104Props::Bound_Threads");

		assertEquals(1, values.size());
		assertTrue(values.get(0).getInModes().isEmpty());
		assertEquals(List.of("src.worker", "dst.worker"), referencedPaths(values.get(0).getOwnedValue()));
	}

	/**
	 * The same for a modal list: each value keeps its own list of one instance reference, and each
	 * applies in the system operation modes of the mode it was declared in.
	 */
	@Test
	public void aModalReferenceListKeepsOneInstanceReferencePerValue() throws Exception {
		var values = valuesOf("Issue3104Props::Modal_Threads");

		assertEquals(2, values.size());
		assertEquals(List.of("src.worker"), referencedPaths(values.get(0).getOwnedValue()));
		assertEquals(Set.of("running"), modeNames(values.get(0)));
		assertEquals(List.of("dst.worker"), referencedPaths(values.get(1).getOwnedValue()));
		assertEquals(Set.of("degraded"), modeNames(values.get(1)));
	}

	/** A single reference value is instantiated too, however deep the path it names. */
	@Test
	public void aSingleReferenceIsInstantiated() throws Exception {
		var values = valuesOf("Issue3104Props::Bound_Subprogram");

		assertEquals(1, values.size());
		assertEquals(List.of("src.worker.helper"), referencedPaths(values.get(0).getOwnedValue()));
	}

	/**
	 * A reference that names a connection resolves to the semantic connection that the named
	 * connection is part of. This is a value that only the component instance can resolve: looking
	 * for connection instances is something a component instance does and a connection reference does
	 * not, which is why the second pass exists.
	 */
	@Test
	public void aReferenceToAConnectionIsInstantiated() throws Exception {
		var values = valuesOf("Issue3104Props::Bound_Connection");

		assertEquals(1, values.size());
		assertEquals(List.of(CONNECTION), referencedPaths(values.get(0).getOwnedValue()));
	}

	/**
	 * A reference that no context resolves, here a call sequence, which is not instantiated, is left
	 * declarative: the pass keeps a value it cannot resolve rather than dropping it.
	 */
	@Test
	public void aReferenceNoContextResolvesIsLeftDeclarative() throws Exception {
		var values = valuesOf("Issue3104Props::Bound_Call_Sequence");

		assertEquals(1, values.size());
		PropertyExpression value = values.get(0).getOwnedValue();
		assertTrue(value instanceof ReferenceValue);
		assertFalse(value instanceof InstanceReferenceValue);
		assertEquals(List.of("src", "worker", "startup"), ((ReferenceValue) value).getContainmentPathElements()
				.stream()
				.map(element -> element.getNamedElement().getName())
				.collect(Collectors.toList()));
	}

	/**
	 * The connection carries one association per property of the fixture, the associations hold as
	 * many instance references as the fixture declares references that resolve, and every part of
	 * them is still rooted in the system instance.
	 *
	 * <p>
	 * Instantiating a value replaces it in a containment list, so a value that is visited a second
	 * time is replaced a second time. This is what would notice a replacement that drops a value or
	 * detaches the subtree it belongs to.
	 * </p>
	 */
	@Test
	public void theCachedAssociationsHoldExactlyTheInstantiatedReferences() throws Exception {
		SystemInstance instance = instantiate();
		ConnectionInstance connection = InstanceLookup.connection(instance, CONNECTION);
		var instantiated = new ArrayList<String>();
		var declarative = 0;

		assertEquals(5, connection.getOwnedPropertyAssociations().size());
		for (var association : connection.getOwnedPropertyAssociations()) {
			TreeIterator<EObject> contents = EcoreUtil.getAllProperContents(association, false);
			while (contents.hasNext()) {
				EObject element = contents.next();

				assertSame(instance, EcoreUtil.getRootContainer(element));
				if (element instanceof InstanceReferenceValue irv) {
					instantiated.add(pathOf(irv.getReferencedInstanceObject()));
				} else if (element instanceof ReferenceValue) {
					declarative++;
				}
			}
		}
		/*
		 * Sorted, because the order of the associations on the connection is the order of the property
		 * filter, which is not part of the model. Two references to src.worker and two to dst.worker:
		 * one each from the list and one each from the modal list.
		 */
		assertEquals(List.of("dst.worker", "dst.worker", "src.worker", "src.worker", "src.worker.helper", CONNECTION),
				instantiated.stream().sorted().toList());
		assertEquals(1, declarative);
	}

	/** The values of the association for this property on the connection of the fixture. */
	private List<ModalPropertyValue> valuesOf(String qualifiedPropertyName) throws Exception {
		ConnectionInstance connection = InstanceLookup.connection(instantiate(), CONNECTION);
		var matches = connection.getOwnedPropertyAssociations()
				.stream()
				.filter(association -> qualifiedPropertyName.equalsIgnoreCase(
						association.getProperty().getQualifiedName()))
				.toList();

		assertEquals("associations for " + qualifiedPropertyName, 1, matches.size());
		return List.copyOf(matches.get(0).getOwnedValues());
	}

	/**
	 * The instance objects a value refers to, as paths relative to the system instance, in the order
	 * the value holds them. Every reference of the value must have been instantiated.
	 */
	private static List<String> referencedPaths(PropertyExpression value) {
		var expressions = value instanceof ListValue list ? List.copyOf(list.getOwnedListElements())
				: List.of(value);
		var paths = new ArrayList<String>();

		for (var expression : expressions) {
			assertTrue("not instantiated: " + expression, expression instanceof InstanceReferenceValue);
			paths.add(pathOf(((InstanceReferenceValue) expression).getReferencedInstanceObject()));
		}
		return paths;
	}

	/** The path of an instance object below the system instance, as dot separated names. */
	private static String pathOf(InstanceObject io) {
		var names = new ArrayList<String>();

		for (InstanceObject current = io; !(current instanceof SystemInstance); current = (InstanceObject) current
				.eContainer()) {
			names.add(0, current.getName());
		}
		return String.join(".", names);
	}

	/** The names of the modes that the system operation modes of a value are made of. */
	private static Set<String> modeNames(ModalPropertyValue value) {
		return value.getInModes()
				.stream()
				.flatMap(mode -> ((SystemOperationMode) mode).getCurrentModes().stream())
				.map(ModeInstance::getName)
				.collect(Collectors.toSet());
	}

	private SystemInstance instantiate() throws Exception {
		AadlPackage pkg = testHelper.parseFile(MODEL, PROPERTIES);
		validationHelper.assertNoIssues(pkg);
		ComponentImplementation top = (ComponentImplementation) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> classifier.getName().equals("Top.i"))
				.findFirst()
				.orElseThrow(() -> new IllegalStateException("No system implementation Top.i"));

		return InstantiateModel.instantiate(top);
	}
}
