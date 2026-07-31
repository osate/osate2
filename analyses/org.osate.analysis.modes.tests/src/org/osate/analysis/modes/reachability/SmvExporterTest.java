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
package org.osate.analysis.modes.reachability;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Files;
import java.nio.file.Path;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.io.TempDir;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

@ExtendWith(InjectionExtension.class)
@InjectWith(Aadl2InjectorProvider.class)
public class SmvExporterTest extends XtextTest {

	@Inject
	TestHelper<AadlPackage> testHelper;

	@TempDir
	Path temporaryFolder;

	@Test
	public void noModalComponentsProducesValidEmptyMain() throws Exception {
		var content = generate("""
				package empty_modes
				public
					system s
					end s;
					system implementation s.i
					end s.i;
				end empty_modes;
				""");

		assertEquals("""
				-- This mode domain has no modal components.
				MODULE main
				  DEFINE
				    no_modal_domains := TRUE;
				""", content);
		assertFalse(content.contains("d0: D0"));
	}

	@Test
	public void noTransitionsProducesValidEmptyMain() throws Exception {
		var content = generate("""
				package no_transitions
				public
					system s
					end s;
					system implementation s.i
						modes
							m0: initial mode;
							m1: mode;
					end s.i;
				end no_transitions;
				""");

		assertTrue(content.startsWith("-- This mode domain has no SOM transitions.\n"));
		assertTrue(content.endsWith("MODULE main\n  DEFINE\n    no_modal_domains := TRUE;\n"));
		assertFalse(content.contains("d0: D0"));
	}

	@Test
	public void validDomainIsDefinedBeforeMainReferencesIt() throws Exception {
		var content = generate("""
				package valid_modes
				public
					system s
						features
							e: in event port;
					end s;
					system implementation s.i
						modes
							m0: initial mode;
							m1: mode;
							m0 -[e]-> m1;
					end s.i;
				end valid_modes;
				""");

		var module = content.indexOf("MODULE D0");
		var main = content.indexOf("MODULE main");
		assertTrue(module >= 0 && main > module, content);
		assertTrue(content.contains("d0: D0;"), content);
	}

	private String generate(String source) throws Exception {
		var pkg = testHelper.parseString(source);
		var implementation = pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(ComponentImplementation.class::isInstance)
				.map(ComponentImplementation.class::cast)
				.findFirst()
				.orElseThrow();
		var instance = InstantiateModel.instantiate(implementation);
		var instancePath = temporaryFolder.resolve("model.aaxl2");
		instance.eResource().setURI(URI.createFileURI(instancePath.toString()));
		var reportDirectory = temporaryFolder.resolve("reports").resolve("som-reachability");
		Files.createDirectories(reportDirectory);
		var analyzer = new ReachabilityAnalyzer(new ReachabilityConfiguration().withSMV(), instance);
		analyzer.analyzeModel();
		assertTrue(analyzer.writeReports().isOK());
		return Files.readString(reportDirectory.resolve("model.smv"));
	}
}
