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
package org.osate.aadl2.errormodel.tests.instance;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.osate.pluginsupport.ScopeFunctions.with;

import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.SystemType;
import org.osate.aadl2.errormodel.instance.EMV2AnnexInstance;
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;

import com.google.inject.Inject;

@ExtendWith(InjectionExtension.class)
@InjectWith(ErrorModelInjectorProvider.class)
public class ModeMappingsTest {
	private static final String PATH = "org.osate.aadl2.errormodel.tests/models/instantiation/ModeMappings/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Test
	public void testUntypedSource() throws Exception {
		var pkg = testHelper.parseFile(PATH + "untyped_source.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(2, annexInstance.getModeMappings().size());
		with(annexInstance.getModeMappings().get(0), modeMapping -> {
			assertEquals("state1 in modes (m1)", modeMapping.getName());
			assertSame(((ErrorModelSubclause) ((DefaultAnnexSubclause) ((SystemType) pkg.getPublicSection()
					.getOwnedClassifiers()
					.get(0)).getOwnedAnnexSubclauses().get(0)).getParsedAnnexSubclause()).getErrorStateToModeMappings()
					.get(0), modeMapping.getModeMapping());
			assertEquals("state1", modeMapping.getState().getName());
			assertNull(modeMapping.getTypeSet());
			assertIterableEquals(List.of("m1"), modeMapping.getModes().stream().map(NamedElement::getName).toList());
		});
		with(annexInstance.getModeMappings().get(1), modeMapping -> {
			assertEquals("state2 in modes (m2, m3, m4)", modeMapping.getName());
			assertSame(((ErrorModelSubclause) ((DefaultAnnexSubclause) ((SystemType) pkg.getPublicSection()
					.getOwnedClassifiers()
					.get(0)).getOwnedAnnexSubclauses().get(0)).getParsedAnnexSubclause()).getErrorStateToModeMappings()
					.get(1), modeMapping.getModeMapping());
			assertEquals("state2", modeMapping.getState().getName());
			assertNull(modeMapping.getTypeSet());
			assertIterableEquals(List.of("m2", "m3", "m4"),
					modeMapping.getModes().stream().map(NamedElement::getName).toList());
		});
	}

	@Test
	public void testTypedSourceWithTypes() throws Exception {
		var pkg = testHelper.parseFile(PATH + "typed_source_with_types.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(2, annexInstance.getModeMappings().size());
		with(annexInstance.getModeMappings().get(0), modeMapping -> {
			assertEquals("state1 {ServiceError} in modes (m1)", modeMapping.getName());
			assertSame(((ErrorModelSubclause) ((DefaultAnnexSubclause) ((SystemType) pkg.getPublicSection()
					.getOwnedClassifiers()
					.get(0)).getOwnedAnnexSubclauses().get(0)).getParsedAnnexSubclause()).getErrorStateToModeMappings()
					.get(0), modeMapping.getModeMapping());
			assertEquals("state1", modeMapping.getState().getName());
			assertEquals("{ServiceError}", modeMapping.getTypeSet().getName());
			assertIterableEquals(List.of("m1"), modeMapping.getModes().stream().map(NamedElement::getName).toList());
		});
		with(annexInstance.getModeMappings().get(1), modeMapping -> {
			assertEquals(
					"state2 {ItemTimingError, ValueRelatedError, ConcurrencyError * ReplicationError} in modes (m2)",
					modeMapping.getName());
			assertSame(((ErrorModelSubclause) ((DefaultAnnexSubclause) ((SystemType) pkg.getPublicSection()
					.getOwnedClassifiers()
					.get(0)).getOwnedAnnexSubclauses().get(0)).getParsedAnnexSubclause()).getErrorStateToModeMappings()
					.get(1), modeMapping.getModeMapping());
			assertEquals("state2", modeMapping.getState().getName());
			assertEquals("{ItemTimingError, ValueRelatedError, ConcurrencyError * ReplicationError}",
					modeMapping.getTypeSet().getName());
			assertIterableEquals(List.of("m2"), modeMapping.getModes().stream().map(NamedElement::getName).toList());
		});
	}

	@Test
	public void testTypedSourceWithoutTypes() throws Exception {
		var pkg = testHelper.parseFile(PATH + "typed_source_without_types.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getModeMappings().size());
		with(annexInstance.getModeMappings().get(0), modeMapping -> {
			assertEquals("state1 {CommonErrors} in modes (m1)", modeMapping.getName());
			assertSame(((ErrorModelSubclause) ((DefaultAnnexSubclause) ((SystemType) pkg.getPublicSection()
					.getOwnedClassifiers()
					.get(0)).getOwnedAnnexSubclauses().get(0)).getParsedAnnexSubclause()).getErrorStateToModeMappings()
					.get(0), modeMapping.getModeMapping());
			assertEquals("state1", modeMapping.getState().getName());
			assertEquals("{CommonErrors}", modeMapping.getTypeSet().getName());
			assertIterableEquals(List.of("m1"), modeMapping.getModes().stream().map(NamedElement::getName).toList());
		});
	}
}