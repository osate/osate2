/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.aadl2.instance.textual.tests;

import static org.junit.Assert.assertEquals;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;

import com.google.inject.Injector;

public abstract class AbstractSerializerTest {
	private final ISerializer serializer;
	private final ParseHelper<SystemInstance> instanceParseHelper;
	private ValidationTestHelper validationTestHelper;

	@SuppressWarnings("unchecked")
	public AbstractSerializerTest() {
		var uri = URI.createFileURI("fake.instance");
		var instanceProvider = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(uri);
		serializer = instanceProvider.get(ISerializer.class);
		instanceParseHelper = instanceProvider.get(Injector.class).getInstance(ParseHelper.class);
		validationTestHelper = instanceProvider.get(ValidationTestHelper.class);
	}

	protected void assertSerialize(AadlPackage aadlPackage, String implName, String expected) throws Exception {
		var classifiers = aadlPackage.getPublicSection().getOwnedClassifiers();
		var impl = classifiers.stream()
				.filter(ComponentImplementation.class::isInstance)
				.map(ComponentImplementation.class::cast)
				.filter(component -> component.getName().equals(implName))
				.findFirst()
				.orElseThrow();
		var inst = InstantiateModel.instantiate(impl);
		inst.setClassifier(null);
		assertEquals(expected, serializer.serialize(inst));
		validationTestHelper
				.assertNoIssues(instanceParseHelper.parse(expected, aadlPackage.eResource().getResourceSet()));
	}
}