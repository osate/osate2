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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Proxy;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.graphics.Point;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.refactoring.ILinkedPositionGroupCalculator;
import org.eclipse.xtext.ui.refactoring.impl.RefactoringResourceSetProvider;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.util.Modules2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.Aadl2RuntimeModule;
import org.osate.xtext.aadl2.ba.ui.internal.BaActivator;
import org.osate.xtext.aadl2.errormodel.ErrorModelRuntimeModule;
import org.osate.xtext.aadl2.errormodel.ErrorModelStandaloneSetup;
import org.osate.xtext.aadl2.errormodel.ui.ErrorModelUiModule;
import org.osate.xtext.aadl2.errormodel.ui.internal.ErrormodelActivator;
import org.osate.xtext.aadl2.ui.Aadl2UiModule;
import org.osate.xtext.aadl2.ui.internal.Aadl2Activator;
import org.osgi.framework.FrameworkUtil;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.util.Modules;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexEmbeddedInjectorProvider.class)
@SuppressWarnings("restriction")
public class Issue3304Test extends XtextTest {
	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validation;

	@Test
	public void startsCoreSubcomponentRenameWithBehaviorUses() throws Exception {
		assertLinkedPositions("DesiredPositionState");
	}

	@Test
	public void startsCorePortRenameWithCoreAndBehaviorUses() throws Exception {
		assertLinkedPositions("input");
	}

	@Test
	public void startsCoreOutputRenameWithBehaviorSend() throws Exception {
		assertLinkedPositions("output");
	}

	@Test
	public void startsBehaviorVariableRename() throws Exception {
		assertLinkedPositions("counter");
	}

	@Test
	public void preservesCoreClassifierRename() throws Exception {
		assertLinkedPositions("Example");
	}

	@Test
	public void startsRenameFromBehaviorReference() throws Exception {
		assertLinkedPositions("DesiredPositionState", "Issue3304.aadl", true);
	}

	@Test
	public void preservesBehaviorStateRename() throws Exception {
		assertLinkedPositions("idle");
	}

	@Test
	public void preservesEmv2InputRename() throws Exception {
		assertLinkedPositions("input", "Emv2Only.aadl", false);
	}

	@Test
	public void preservesEmv2OutputRename() throws Exception {
		assertLinkedPositions("output", "Emv2Only.aadl", false);
	}

	private void assertLinkedPositions(String name) throws Exception {
		assertLinkedPositions(name, "Issue3304.aadl", false);
	}

	private void assertLinkedPositions(String name, String fileName, boolean fromReference) throws Exception {
		ErrorModelStandaloneSetup.doSetup();
		var directory = "org.osate.xtext.aadl2.ba.tests/models/issue3304/";
		var model = testHelper.parseFile(directory + fileName);
		var resource = (XtextResource) model.eResource();
		var resourceSet = resource.getResourceSet();
		var text = resource.getParseResult().getRootNode().getText();
		var project = ResourcesPlugin.getWorkspace().getRoot().getProject("issue3304");
		if (!project.exists()) {
			project.create(null);
		}
		project.open(null);
		var file = project.getFile(fileName);
		var path = Path.of(System.getProperty("user.dir"), "../" + directory + fileName);
		try (var stream = Files.newInputStream(path)) {
			if (file.exists()) {
				file.setContents(stream, true, false, null);
			} else {
				file.create(stream, true, null);
			}
		}
		resource.unload();
		resource.setURI(URI.createPlatformResourceURI(file.getFullPath().toString(), true));
		resource.load(resourceSet.getLoadOptions());
		EcoreUtil.resolveAll(resource);
		validation.assertNoIssues(resource.getContents().getFirst());
		FrameworkUtil.getBundle(Aadl2Activator.class).start();
		var descriptions = new ResourceDescriptionsData(List.of(
				resource.getResourceServiceProvider().getResourceDescriptionManager().getResourceDescription(resource)));
		var provider = new RefactoringResourceSetProvider() {
			@Override
			public ResourceSet get(IProject requestedProject) {
				return resourceSet;
			}
		};
		var overrides = new AbstractModule() {
			@Override
			protected void configure() {
				bind(IResourceDescriptions.class).toInstance(descriptions);
				bind(RefactoringResourceSetProvider.class).toInstance(provider);
			}
		};
		var injector = Guice.createInjector(Modules.override(Modules2.mixin(new Aadl2RuntimeModule(),
				new SharedStateModule(), new Aadl2UiModule(Aadl2Activator.getInstance()))).with(overrides));
		FrameworkUtil.getBundle(ErrormodelActivator.class).start();
		var emv2Injector = Guice.createInjector(Modules.override(Modules2.mixin(new ErrorModelRuntimeModule(),
				new SharedStateModule(), new ErrorModelUiModule(ErrormodelActivator.getInstance()))).with(overrides));
		var registry = IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap();
		var previousAadl = registry.put("aadl", injector.getInstance(IResourceServiceProvider.class));
		FrameworkUtil.getBundle(BaActivator.class).start();
		var baInjector = BaActivator.getInstance().getInjector(BaActivator.ORG_OSATE_XTEXT_AADL2_BA_BEHAVIORANNEX);
		var previousBa = registry.put("baxtext", baInjector.getInstance(IResourceServiceProvider.class));
		var previousEmv2 = registry.put("emv2", emv2Injector.getInstance(IResourceServiceProvider.class));
		try {
			var offset = fromReference ? text.lastIndexOf(name) : text.indexOf(name);
			var target = injector.getInstance(EObjectAtOffsetHelper.class).resolveElementAt(resource, offset);
			assertNotNull(target);
			var document = injector.getInstance(XtextDocument.class);
			document.set(text);
			document.setInput(resource);
			var viewer = (ISourceViewer) Proxy.newProxyInstance(ISourceViewer.class.getClassLoader(),
					new Class<?>[] { ISourceViewer.class }, (proxy, method, arguments) -> {
						if (method.getName().equals("getSelectedRange")) {
							return new Point(offset, 0);
						}
						throw new AssertionError("Unexpected viewer call: " + method.getName());
					});
			var editor = new XtextEditor() {
				@Override
				public XtextDocument getDocument() {
					return document;
				}

				@Override
				public ISourceViewer getInternalSourceViewer() {
					return viewer;
				}
			};
			var context = new IRenameElementContext.Impl(EcoreUtil.getURI(target), target.eClass(), editor,
					new TextSelection(offset, 0), resource.getURI());
			var group = injector.getInstance(ILinkedPositionGroupCalculator.class)
					.getLinkedPositionGroup(context, new NullProgressMonitor()).get();
			assertNotNull(group);
			var expected = new ArrayList<Integer>();
			for (var position = text.indexOf(name); position >= 0; position = text.indexOf(name, position + name.length())) {
				expected.add(position);
			}
			assertEquals(expected,
					Arrays.stream(group.getPositions()).map(position -> position.getOffset()).sorted().toList());
			for (var position : group.getPositions()) {
				assertEquals(name.length(), position.getLength());
				assertEquals(name, document.get(position.getOffset(), position.getLength()));
			}
			assertEquals(text, document.get());
			validation.assertNoIssues(resource.getContents().getFirst());
		} finally {
			restore(registry, "aadl", previousAadl);
			restore(registry, "baxtext", previousBa);
			restore(registry, "emv2", previousEmv2);
			project.delete(true, true, null);
		}
	}

	private static void restore(Map<String, Object> registry, String extension, Object previous) {
		if (previous == null) {
			registry.remove(extension);
		} else {
			registry.put(extension, previous);
		}
	}
}
