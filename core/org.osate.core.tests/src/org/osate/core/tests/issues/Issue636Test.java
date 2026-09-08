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

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue636Test extends XtextTest {
	private static final String AADL_TEXT = """
			package issue636
			public
			\tfeature group fg
			\t	features
			\t		di: in data port;
			\t		do: out data port;
			\tend fg;
			\t
			\tfeature group fgi
			\t	features
			\t		do: out data port;
			\t		di: in data port;
			\t	inverse of fg
			\tend fgi;
			\t
			\tsystem left
			\t	features
			\t		fgi: feature group fgi;
			\tend left;
			\t
			\tsystem rss
			\t	features
			\t		si: in data port;
			\t		so: out data port;
			\tend rss;
			\t
			\tsystem right
			\t	features
			\t		fg: feature group fg;
			\tend right;
			
			\tsystem implementation right.i
			\t	subcomponents
			\t		rss: system rss;
			\t	connections
			\t		c3: feature fg.di -> rss.si;
			\t		c4: feature rss.so -> fg.do;
			\tend right.i;
			\t
			\tsystem top
			\tend top;
			\t
			\tsystem implementation top.i
			\t	subcomponents
			\t		left: system left;
			\t		right: system right.i;
			\t	connections
			\t		c1: feature group left.fgi <-> right.fg;
			\tend top.i;
			\t
			end issue636;
			""";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void issue636TestA() throws Exception {
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
		assertTrue("Expected 2 connection instances but found " + connections.size(), connections.size() == 2);
	}
}
