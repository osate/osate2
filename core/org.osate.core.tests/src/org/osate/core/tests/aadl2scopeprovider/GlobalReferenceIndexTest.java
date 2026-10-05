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
package org.osate.core.tests.aadl2scopeprovider;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.builder.AbstractIncrementalBuilderTest;
import org.eclipse.xtext.util.CancelIndicator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AbstractType;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.NamedValue;
import org.osate.testsupport.Aadl2InjectorProvider;

/** Verifies global scopes against persisted descriptions, including lazy property references and both build orders. */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class GlobalReferenceIndexTest extends AbstractIncrementalBuilderTest {
	private static final String PATH = "models/globalReferenceScope/";

	@Override
	protected IResourceServiceProvider.Registry getLanguages() {
		return IResourceServiceProvider.Registry.INSTANCE;
	}

	@Test
	public void terminalClassifierPropertyAndConstantReferencesRemainLazy() throws Exception {
		URI library = newFile("IndexLibrary.aadl", read("IndexLibrary.aadl"));
		URI properties = newFile("Globals.aadl", read("Globals.aadl"));
		build(newBuildRequest(request -> request.setDirtyFiles(List.of(library, properties))));
		assertTrue(issues.toString(), issues.isEmpty());
		URI client = newFile("LazyClient.aadl", read("LazyClient.aadl"));
		var request = newBuildRequest(r -> r.setIndexOnly(true));
		var resources = request.getResourceSet();
		var resource = resources.getResource(client, true);
		assertNull(resources.getResource(library, false));
		assertNull(resources.getResource(properties, false));
		EcoreUtil2.resolveLazyCrossReferences(resource, CancelIndicator.NullImpl);
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		assertNull(resources.getResource(library, false));
		assertNull(resources.getResource(properties, false));
		var pkg = (AadlPackage) resource.getContents().getFirst();
		var type = (AbstractType) pkg.getPublicSection().getOwnedClassifiers().getFirst();
		assertProxy(type.getOwnedDataPorts().getFirst().eGet(Aadl2Package.eINSTANCE.getDataPort_DataFeatureClassifier(), false));
		var association = type.getOwnedPropertyAssociations().getFirst();
		assertProxy(association.eGet(Aadl2Package.eINSTANCE.getPropertyAssociation_Property(), false));
		var value = (NamedValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertProxy(value.eGet(Aadl2Package.eINSTANCE.getNamedValue_NamedValue(), false));
		var implementation = (ComponentImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var size = implementation.getOwnedSubcomponents().getFirst().getArrayDimensions().getFirst().getSize();
		assertProxy(size.eGet(Aadl2Package.eINSTANCE.getArraySize_SizeProperty(), false));
	}

	@Test
	public void importsAliasesAndCallsResolveWhenLibrariesAreBuiltFirst() throws Exception {
		assertBuildOrder(false);
	}

	@Test
	public void importsAliasesAndCallsResolveWhenClientIsBuiltFirst() throws Exception {
		assertBuildOrder(true);
	}

	private void assertBuildOrder(boolean clientFirst) throws Exception {
		URI library = newFile("IndexLibrary.aadl", read("IndexLibrary.aadl"));
		URI properties = newFile("Globals.aadl", read("Globals.aadl"));
		URI client = newFile("IndexClient.aadl", read("IndexClient.aadl"));
		build(newBuildRequest(request -> request.setDirtyFiles(clientFirst ? List.of(client, properties, library)
				: List.of(library, properties, client))));
		assertTrue(issues.toString(), issues.isEmpty());
	}

	private static void assertProxy(Object value) {
		assertNotNull(value);
		assertTrue(((EObject) value).eIsProxy());
	}

	private String read(String name) throws IOException {
		try (var stream = getClass().getClassLoader().getResourceAsStream(PATH + name)) {
			assertNotNull(name, stream);
			return new String(stream.readAllBytes(), StandardCharsets.UTF_8);
		}
	}
}
