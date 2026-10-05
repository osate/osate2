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
import static org.junit.Assert.assertSame;

import java.util.List;

import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.validation.Issue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AbstractImplementation;
import org.osate.aadl2.AbstractType;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Connection;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.RecordType;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.ReferenceValue;
import org.osate.aadl2.SubprogramGroupType;
import org.osate.aadl2.SubprogramType;
import org.osate.aadl2.ThreadImplementation;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * Characterizes resolution through subcomponents, nested feature groups, prototype bindings, call contexts, and
 * property-value contexts. Targets must belong to the selected namespace and never fall back to outer declarations.
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class ContextReferenceLinkingTest extends XtextTest {
	private static final String PATH = "org.osate.core.tests/models/contextReferenceScope/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Inject
	private ISerializer serializer;

	@Test
	public void connectionsFlowsAndTriggersResolveWithinTheirContext() throws Exception {
		var pkg = parseValidModel();
		var worker = (AbstractType) classifier(pkg, "Worker");
		var implementation = (AbstractImplementation) classifier(pkg, "Parent.i");
		var incoming = connection(implementation, "incoming");
		assertSame(worker.getOwnedEventPorts().getFirst(), incoming.getDestination().getConnectionEnd());
		var nested = connection(implementation, "nested").getSource();
		assertSame(worker.getOwnedFeatureGroups().getFirst(), nested.getConnectionEnd());
		assertSame(((FeatureGroupType) classifier(pkg, "Outer")).getOwnedFeatureGroups().getFirst(),
				nested.getNext().getConnectionEnd());
		assertSame(((FeatureGroupType) classifier(pkg, "Inner")).getOwnedEventPorts().getFirst(),
				nested.getNext().getNext().getConnectionEnd());
		assertSame(worker.getOwnedFlowSpecifications().get(2),
				implementation.getOwnedFlowImplementations().getFirst().getOwnedFlowSegments().get(1).getFlowElement());
		var segments = implementation.getOwnedEndToEndFlows().getFirst().getOwnedEndToEndFlowSegments();
		assertSame(worker.getOwnedFlowSpecifications().get(0), segments.getFirst().getFlowElement());
		assertSame(worker.getOwnedFlowSpecifications().get(1), segments.getLast().getFlowElement());
		assertSame(worker.getOwnedEventPorts().get(1),
				implementation.getOwnedModeTransitions().getFirst().getOwnedTriggers().getFirst().getTriggerPort());
		var parent = (AbstractType) classifier(pkg, "Parent");
		assertSame(nested.getNext().getNext().getConnectionEnd(),
				parent.getOwnedFlowSpecifications().get(1).getOutEnd().getFeature());
	}

	@Test
	public void modeMappingsAndPropertyModesUseTheSelectedComponent() throws Exception {
		var pkg = parseValidModel();
		var worker = (AbstractType) classifier(pkg, "Worker");
		var parent = (AbstractType) classifier(pkg, "Parent");
		var implementation = (AbstractImplementation) classifier(pkg, "Parent.i");
		var left = implementation.getOwnedSubcomponents().getFirst();
		assertSame(worker.getOwnedModes().getFirst(), left.getOwnedModeBindings().getFirst().getDerivedMode());
		var right = implementation.getOwnedSubcomponents().get(1);
		assertSame(worker.getOwnedModes().getFirst(), right.getOwnedPropertyAssociations().getFirst()
				.getOwnedValues().getFirst().getInModes().getFirst());
		var associations = implementation.getOwnedPropertyAssociations();
		assertSame(worker.getOwnedModes().get(1), associations.get(2).getOwnedValues().getFirst().getInModes().getFirst());
		assertSame(parent.getOwnedModes().getFirst(), associations.get(3).getOwnedValues().getFirst().getInModes().getFirst());
	}

	@Test
	public void propertyPathsFieldsAndUnitsResolveInTheirValueContext() throws Exception {
		var pkg = parseValidModel();
		var implementation = (AbstractImplementation) classifier(pkg, "Parent.i");
		var associations = implementation.getOwnedPropertyAssociations();
		var expected = ((FeatureGroupType) classifier(pkg, "Inner")).getOwnedEventPorts().getFirst();
		var applied = associations.get(0).getAppliesTos().getFirst().getContainmentPathElements();
		assertSame(expected, applied.getLast().getNamedElement());
		var value = (ReferenceValue) associations.get(1).getOwnedValues().getFirst().getOwnedValue();
		assertSame(expected, value.getContainmentPathElements().getLast().getNamedElement());
		var right = implementation.getOwnedSubcomponents().get(1);
		var local = (ReferenceValue) right.getOwnedPropertyAssociations().get(1)
				.getOwnedValues().getFirst().getOwnedValue();
		assertSame(((AbstractType) classifier(pkg, "Worker")).getOwnedEventPorts().getFirst(),
				local.getPath().getNamedElement());
		var record = (RecordValue) associations.get(4).getOwnedValues().getFirst().getOwnedValue();
		var field = record.getOwnedFieldValues().getFirst();
		var type = (RecordType) associations.get(4).getProperty().getPropertyType();
		assertSame(type.getOwnedFields().getFirst(), field.getProperty());
		var number = (IntegerLiteral) field.getOwnedValue();
		assertEquals("large", number.getUnit().getName());
	}

	@Test
	public void calledSubprogramsAndParametersUseTheirCallContext() throws Exception {
		var pkg = parseValidModel();
		var implementation = (ThreadImplementation) classifier(pkg, "Caller.i");
		var calls = implementation.getOwnedSubprogramCallSequences().getFirst().getOwnedSubprogramCalls();
		var services = (SubprogramGroupType) classifier(pkg, "Services");
		assertSame(services.getOwnedSubprogramAccesses().getFirst(), calls.get(0).getCalledSubprogram());
		assertSame(((FeatureGroupType) classifier(pkg, "CallGroup")).getOwnedSubprogramAccesses().getFirst(),
				calls.get(1).getCalledSubprogram());
		assertSame(services.getOwnedSubprogramAccesses().getFirst(), calls.get(2).getCalledSubprogram());
		assertSame(classifier(pkg, "Action.i"), calls.get(3).getCalledSubprogram());
		assertSame(((SubprogramType) classifier(pkg, "Action")).getOwnedParameters().getFirst(),
				implementation.getOwnedParameterConnections().getFirst().getDestination().getConnectionEnd());
	}

	@Test
	public void missingContextMemberDoesNotCaptureAnOuterFeature() throws Exception {
		var pkg = testHelper.parseFile(PATH + "InvalidContexts.aadl", PATH + "Contexts.aadl",
				PATH + "ContextProperties.aadl");
		assertEquals(List.of("Couldn't resolve reference to ConnectionEnd 'decoy'."),
				validationHelper.validate(pkg).stream().map(Issue::getMessage).toList());
	}

	@Test
	public void serializationPreservesNestedReferenceTargets() throws Exception {
		var pkg = parseValidModel();
		var propertySet = pkg.eResource().getResourceSet().getResources().stream()
				.flatMap(resource -> resource.getContents().stream())
				.filter(PropertySet.class::isInstance).map(PropertySet.class::cast)
				.filter(set -> "ContextProperties".equals(set.getName())).findFirst().orElseThrow();
		var reparsed = testHelper.parseString(serializer.serialize(pkg), serializer.serialize(propertySet));
		validationHelper.assertNoIssues(reparsed);
		var implementation = (AbstractImplementation) classifier(reparsed, "Parent.i");
		var signal = ((FeatureGroupType) classifier(reparsed, "Inner")).getOwnedEventPorts().getFirst();
		assertSame(signal, connection(implementation, "nested").getSource().getNext().getNext().getConnectionEnd());
		assertSame(signal, implementation.getOwnedPropertyAssociations().getFirst().getAppliesTos().getFirst()
				.getContainmentPathElements().getLast().getNamedElement());
	}

	private AadlPackage parseValidModel() throws Exception {
		var pkg = testHelper.parseFile(PATH + "Contexts.aadl", PATH + "ContextProperties.aadl");
		for (var resource : pkg.eResource().getResourceSet().getResources()) {
			if (!resource.getContents().isEmpty() && resource.getContents().getFirst() instanceof PropertySet set
					&& "ContextProperties".equals(set.getName())) {
				validationHelper.assertNoIssues(set);
			}
		}
		validationHelper.assertNoIssues(pkg);
		return pkg;
	}

	private static Connection connection(ComponentImplementation implementation, String name) {
		return implementation.getOwnedConnections().stream()
				.filter(connection -> name.equals(connection.getName())).findFirst().orElseThrow();
	}

	private static Classifier classifier(AadlPackage pkg, String name) {
		return pkg.getPublicSection().getOwnedClassifiers().stream()
				.filter(classifier -> name.equals(classifier.getName())).findFirst().orElseThrow();
	}
}
