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
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Objects;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue780Test {
	private static final String AADL_TEXT = """
			package issue480
			public
			\t
			\tfeature group ps
			\t\tfeatures
			\t\t\tp1: in data port;
			\t\t\tp2: out data port;
			\tend ps;

			\tsystem top
			\tfeatures
			\t\tfg: feature group;
			\t\tps: feature group ps;
			\tend top;
			\t
			\tsystem implementation top.i
			\t\tsubcomponents
			\t\t\tl: abstract a;
			\t\t\tr: abstract b;
			\t\tconnections
			\t\t\tc01: feature group l.fg -> fg;
			\t\t\tc02: feature group l.ps <-> fg;
			\t\t\tc03: feature group l.fg <-> ps;
			\t\t\tc04: feature group l.ps <-> ps;

			\t\t\tc11: feature group fg -> l.fg;
			\t\t\tc12: feature group ps <-> l.fg;
			\t\t\tc13: feature group fg <-> l.ps;
			\t\t\tc14: feature group ps <-> l.ps;
			\t\t\t
			\t\t\tc21: feature group l.fg -> r.fg;
			\t\t\tc22: feature group l.ps <-> r.fg;
			\t\t\tc23: feature group l.fg <-> r.ps;
			\t\t\tc24: feature group l.ps <-> r.ps;
			\tend top.i;

			\tabstract a
			\tfeatures
			\t\tfg: feature group;
			\t\tps: feature group ps;
			\tend a;

			\tabstract b
			\tfeatures
			\t\tfg: feature group;
			\t\tps: feature group inverse of ps;
			\tend b;
			\t
			end issue480;
			""";

	private static final List<String> EXPECTED_CONNECTIONS = List.of("fg -> l.fg", "fg -> l.ps.p1", "fg -> l.ps.p1",
			"l.fg -> fg", "l.fg -> ps.p2", "l.fg -> ps.p2", "l.fg -> r.fg", "l.fg -> r.ps.p2", "l.ps.p2 -> fg",
			"l.ps.p2 -> fg", "l.ps.p2 -> ps.p2", "l.ps.p2 -> ps.p2", "l.ps.p2 -> r.fg", "l.ps.p2 -> r.ps.p2",
			"ps.p1 -> l.fg", "ps.p1 -> l.fg", "ps.p1 -> l.ps.p1", "ps.p1 -> l.ps.p1", "r.fg -> l.ps.p1",
			"r.ps.p1 -> l.fg", "r.ps.p1 -> l.ps.p1");

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void issue780() throws Exception {
		AadlPackage pkg = testHelper.parseString(AADL_TEXT);
		var classifiers = pkg.getOwnedPublicSection().getOwnedClassifiers();
		assertTrue("System implementation \"top.i\" not found",
				classifiers.stream().anyMatch(classifier -> "top.i".equals(classifier.getName())));
		SystemImplementation sysImpl = (SystemImplementation) classifiers.stream()
				.filter(classifier -> "top.i".equals(classifier.getName()))
				.findFirst()
				.get();
		var instance = InstantiateModel.instantiate(sysImpl);
		assertEquals("top_i_Instance", instance.getName());
		var connections = instance.getConnectionInstances();
		assertTrue("In top_i_Instance: Expected 21 connections but found " + connections.size(),
				connections.size() == 21);
		var names = connections.stream().map(ConnectionInstance::getName).sorted().toList();
		assertTrue("In top_i_Instance: Did not find expected connections",
				Objects.equals(names, EXPECTED_CONNECTIONS));
	}
}
