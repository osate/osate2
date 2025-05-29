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
package org.osate.core.tests.issues;

import java.util.List;
import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue626Test extends XtextTest {

	private static final String FILE = "org.osate.core.tests/models/issue626/Issue626.aadl";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void testFeatureClassiferInstantiation() throws Exception {
		AadlPackage pkg = testHelper.parseFile(FILE);
		Optional<Classifier> impl = pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(c -> c.getName().equals("S.i"))
				.findFirst();

		SystemInstance instance = InstantiateModel.instantiate((ComponentImplementation) impl.get());
		Assert.assertEquals("S_i_Instance", instance.getName());
		List<EObject> contents = instance.eResource().getContents();

		FeatureInstance fi;
		fi = instance.getFeatureInstances().get(0);
		Assert.assertEquals("Should be Issue626::DP.i* instead of " + fi.getType().getName(), contents.get(3),
				fi.getType());
		fi = instance.getFeatureInstances().get(1);
		Assert.assertEquals("Should be Issue626::D.i instead of " + fi.getType().getName(), contents.get(1),
				fi.getType());
		fi = instance.getFeatureInstances().get(2);
		Assert.assertEquals("Should be Issue626::DP.i1 instead of " + fi.getType().getName(), contents.get(4),
				fi.getType());

		ComponentInstance ci;
		ci = (ComponentInstance) contents.get(1);
		Assert.assertEquals("Issue626::D.i", ci.getName());
		fi = ci.getFeatureInstances().get(0);
		Assert.assertEquals("Should be Issue626::D1.i instead of " + fi.getType().getName(), contents.get(2),
				fi.getType());

		ci = (ComponentInstance) contents.get(3);
		Assert.assertEquals("Issue626::DP.i*", ci.getName());
		fi = ci.getFeatureInstances().get(0);
		Assert.assertEquals("Should be Issue626::D1.i instead of " + fi.getType().getName(), contents.get(2),
				fi.getType());

		ci = (ComponentInstance) contents.get(4);
		Assert.assertEquals("Issue626::DP.i1", ci.getName());
		fi = ci.getFeatureInstances().get(0);
		Assert.assertEquals("Should be Issue626::D.i instead of " + fi.getType().getName(), contents.get(1),
				fi.getType());
	}

}
