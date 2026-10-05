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
import static org.junit.Assert.assertTrue;

import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AbstractType;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.SubprogramImplementation;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * Characterizes global lookup before moving it into scopes: aliases, inherited public imports in private sections,
 * property constants and enumeration literals, and classifier-based calls with public/private implementations.
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class GlobalReferenceLinkingTest extends XtextTest {
	private static final String PATH = "org.osate.core.tests/models/globalReferenceScope/";
	@Inject
	private TestHelper<AadlPackage> testHelper;
	@Inject
	private ValidationTestHelper validationHelper;

	@Inject
	private ISerializer serializer;

	@Test
	public void classifierAndPackageAliasesRemainVisibleInBothSections() throws Exception {
		var client = parse();
		var library = library(client);
		var payload = classifier(library.getPublicSection(), "Payload");
		var container = (AbstractType) classifier(client.getPublicSection(), "Container");
		assertSame(payload, container.getOwnedDataPorts().get(0).getDataFeatureClassifier());
		assertSame(payload, container.getOwnedDataPorts().get(1).getDataFeatureClassifier());
		assertSame(classifier(library.getPublicSection(), "Link.i"), container.getOwnedBusAccesses().getFirst().getBusFeatureClassifier());
		assertSame(classifier(library.getPublicSection(), "Ports"), container.getOwnedFeatureGroups().getFirst().getFeatureType());
		var local = (ComponentImplementation) classifier(client.getPrivateSection(), "Local.i");
		assertSame(payload, local.getOwnedSubcomponents().get(0).getSubcomponentType());
		assertSame(classifier(library.getPublicSection(), "Payload.i"), local.getOwnedSubcomponents().get(1).getSubcomponentType());
	}

	@Test
	public void callsHonorAliasesAndPublicPrivateImplementationVisibility() throws Exception {
		var client = parse();
		var library = library(client);
		var caller = (SubprogramImplementation) classifier(client.getPublicSection(), "Caller.i");
		var calls = caller.getOwnedSubprogramCallSequences().getFirst().getOwnedSubprogramCalls();
		assertSame(classifier(library.getPublicSection(), "Action"), calls.getFirst().getCalledSubprogram());
		for (int index = 1; index < calls.size(); index++) {
			assertSame(classifier(library.getPublicSection(), "Action.i"), calls.get(index).getCalledSubprogram());
		}
		var privateCaller = (SubprogramImplementation) classifier(library.getPrivateSection(), "Caller.i");
		var privateCalls = privateCaller.getOwnedSubprogramCallSequences().getFirst().getOwnedSubprogramCalls();
		assertSame(classifier(library.getPrivateSection(), "PrivateAction.hidden"), privateCalls.get(0).getCalledSubprogram());
	}

	@Test
	public void propertyConstantsLiteralsAndPredeclaredPropertiesResolve() throws Exception {
		var client = parse();
		var implementation = (ComponentImplementation) classifier(client.getPublicSection(), "Container.i");
		var values = implementation.getOwnedPropertyAssociations();
		var constant = (NamedValue) values.get(0).getOwnedValues().getFirst().getOwnedValue();
		assertEquals("Globals::Count", ((NamedElement) constant.getNamedValue()).getQualifiedName());
		var literal = (NamedValue) values.get(1).getOwnedValues().getFirst().getOwnedValue();
		assertEquals("first", ((NamedElement) literal.getNamedValue()).getName());
		assertSame(constant.getNamedValue(), implementation.getOwnedSubcomponents().getFirst()
				.getArrayDimensions().getFirst().getSize().getSizeProperty());
		var local = (ComponentImplementation) classifier(client.getPrivateSection(), "Local.i");
		assertTrue(local.getOwnedPropertyAssociations().getFirst().getProperty().getQualifiedName().endsWith("::Data_Size"));
	}

	@Test
	public void serializationPreservesGlobalAliasesAndClassifierCalls() throws Exception {
		var client = parse();
		var properties = client.eResource().getResourceSet().getResources().stream()
				.flatMap(resource -> resource.getContents().stream()).filter(PropertySet.class::isInstance)
				.map(PropertySet.class::cast).filter(set -> "Globals".equals(set.getName())).findFirst().orElseThrow();
		var reparsed = testHelper.parseString(serializer.serialize(client), serializer.serialize(library(client)),
				serializer.serialize(properties));
		validationHelper.assertNoIssues(reparsed);
		validationHelper.assertNoIssues(library(reparsed));
		var caller = (SubprogramImplementation) classifier(reparsed.getPublicSection(), "Caller.i");
		var implementation = classifier(library(reparsed).getPublicSection(), "Action.i");
		var calls = caller.getOwnedSubprogramCallSequences().getFirst().getOwnedSubprogramCalls();
		for (int index = 1; index < calls.size(); index++) {
			assertSame(implementation, calls.get(index).getCalledSubprogram());
		}
	}

	private AadlPackage parse() throws Exception {
		var client = testHelper.parseFile(PATH + "Client.aadl", PATH + "Library.aadl", PATH + "Globals.aadl");
		validationHelper.assertNoIssues(client);
		validationHelper.assertNoIssues(library(client));
		return client;
	}

	private static AadlPackage library(AadlPackage client) {
		return client.eResource().getResourceSet().getResources().stream().flatMap(r -> r.getContents().stream())
				.filter(AadlPackage.class::isInstance).map(AadlPackage.class::cast)
				.filter(pkg -> "GlobalLibrary".equals(pkg.getName())).findFirst().orElseThrow();
	}

	private static Classifier classifier(PackageSection section, String name) {
		return section.getOwnedClassifiers().stream().filter(c -> name.equals(c.getName())).findFirst().orElseThrow();
	}
}
