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
 * conditions contained in any such Third Party Software or separate license file distributed with this program. The
 * parties who own the Third Party Software ("Third Party Licensors") are intended third party beneficiaries to this
 * license with respect to the terms applicable to their Third Party Software. Third Party Software licenses only apply
 * to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.xtext.aadl2.ba.tests;

import static org.junit.Assert.assertNotNull;

import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.IGlobalServiceProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.ba.ui.internal.BaActivator;
import org.osate.xtext.aadl2.ui.internal.Aadl2Activator;
import org.osgi.framework.FrameworkUtil;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexEmbeddedInjectorProvider.class)
public class Issue3298Test extends XtextTest {
	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validation;

	@Test
	public void findsBehaviorRenameServices() throws Exception {
		assertServices("counter");
	}

	@Test
	public void preservesCoreRenameServices() throws Exception {
		assertServices("input");
	}

	@Test
	public void findsBehaviorStateRenameServices() throws Exception {
		assertServices("idle");
	}

	private void assertServices(String name) throws Exception {
		var model = testHelper.parseFile("org.osate.xtext.aadl2.ba.tests/models/issue3298/Issue3298.aadl");
		validation.assertNoIssues(model);
		var resource = (XtextResource) model.eResource();
		FrameworkUtil.getBundle(Aadl2Activator.class).start();
		FrameworkUtil.getBundle(BaActivator.class).start();
		var injector = Aadl2Activator.getInstance().getInjector(Aadl2Activator.ORG_OSATE_XTEXT_AADL2_AADL2);
		var baInjector = BaActivator.getInstance().getInjector(BaActivator.ORG_OSATE_XTEXT_AADL2_BA_BEHAVIORANNEX);
		var registry = IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap();
		var previous = registry.put("baxtext", baInjector.getInstance(IResourceServiceProvider.class));
		try {
			var text = resource.getParseResult().getRootNode().getText();
			for (var offset = text.indexOf(name); offset >= 0; offset = text.indexOf(name, offset + name.length())) {
				var target = injector.getInstance(EObjectAtOffsetHelper.class).resolveElementAt(resource, offset);
				assertNotNull(target);
				assertNotNull(injector.getInstance(IGlobalServiceProvider.class)
						.findService(target, IRenameStrategy.Provider.class));
			}
		} finally {
			if (previous == null) {
				registry.remove("baxtext");
			} else {
				registry.put("baxtext", previous);
			}
		}
	}
}
