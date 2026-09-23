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
import static org.junit.Assert.assertSame;

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
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.graphics.Point;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
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
import org.eclipse.xtext.ui.editor.occurrences.IOccurrenceComputer;
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
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex;
import org.osate.xtext.aadl2.ba.ui.internal.BaActivator;
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
public class Issue3306Test extends XtextTest {
	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validation;

	private enum Check {
		TARGET, OCCURRENCES, RENAME, DECLARATIONS
	}

	@Test
	public void highlightsFromSourcesAndDestination() throws Exception {
		assertStateSelection("Ready", 0, 4, Check.OCCURRENCES);
	}

	@Test
	public void highlightsMultiSourceStateUses() throws Exception {
		assertStateSelection("Busy", 0, 4, Check.OCCURRENCES);
	}

	@Test
	public void highlightsDestinationUses() throws Exception {
		assertStateSelection("Done", 0, 2, Check.OCCURRENCES);
	}

	@Test
	public void highlightsOnlySelectedAnnex() throws Exception {
		assertStateSelection("Ready", 1, 4, Check.OCCURRENCES);
	}

	@Test
	public void renamesFromSourcesAndDestination() throws Exception {
		assertStateSelection("Ready", 0, 4, Check.RENAME);
	}

	@Test
	public void renamesFromMultiSourceTransition() throws Exception {
		assertStateSelection("Busy", 0, 4, Check.RENAME);
	}

	@Test
	public void renamesFromDestination() throws Exception {
		assertStateSelection("Done", 0, 2, Check.RENAME);
	}

	@Test
	public void renamesWithinSelectedAnnex() throws Exception {
		assertStateSelection("Ready", 1, 4, Check.RENAME);
	}

	@Test
	public void resolvesEveryStateTokenCharacter() throws Exception {
		assertStateSelection("Ready", 0, 4, Check.TARGET);
		assertStateSelection("Busy", 0, 4, Check.TARGET);
		assertStateSelection("Done", 0, 2, Check.TARGET);
		assertStateSelection("Ready", 1, 4, Check.TARGET);
	}

	@Test
	public void preservesDeclarationsAndTransitionNames() throws Exception {
		assertStateSelection("Ready", 0, 4, Check.DECLARATIONS);
	}

	private void assertStateSelection(String name, int annexIndex, int count, Check check) throws Exception {
		var fileName = "Issue3306.aadl";
		var directory = "org.osate.xtext.aadl2.ba.tests/models/issue3306/";
		var model = testHelper.parseFile(directory + fileName);
		var resource = (XtextResource) model.eResource();
		var resourceSet = resource.getResourceSet();
		var text = resource.getParseResult().getRootNode().getText();
		var project = ResourcesPlugin.getWorkspace().getRoot().getProject("issue3306");
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
		var registry = IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap();
		var previousAadl = registry.put("aadl", injector.getInstance(IResourceServiceProvider.class));
		FrameworkUtil.getBundle(BaActivator.class).start();
		var baInjector = BaActivator.getInstance().getInjector(BaActivator.ORG_OSATE_XTEXT_AADL2_BA_BEHAVIORANNEX);
		var previousBa = registry.put("baxtext", baInjector.getInstance(IResourceServiceProvider.class));
		var document = injector.getInstance(XtextDocument.class);
		document.set(text);
		document.setInput(resource);
		try {
			var annex = EcoreUtil2.getAllContentsOfType(resource.getContents().getFirst(), BehaviorAnnex.class)
					.get(annexIndex);
			var state = annex.getStateGroups().stream().flatMap(group -> group.getStates().stream())
					.filter(candidate -> name.equals(candidate.getName())).findFirst().orElseThrow();
			var annexNode = NodeModelUtils.getNode(annex);
			var expected = new ArrayList<Integer>();
			for (var offset = text.indexOf(name, annexNode.getOffset()); offset >= 0 && offset < annexNode.getEndOffset();
					offset = text.indexOf(name, offset + name.length())) {
				expected.add(offset);
			}
			assertEquals(count, expected.size());
			var helper = injector.getInstance(EObjectAtOffsetHelper.class);
			assertSame(state, helper.resolveElementAt(resource, expected.getFirst()));
			for (var transition : annex.getTransitions()) {
				if (transition.getName() != null) {
					var offset = text.indexOf(transition.getName() + ":", annexNode.getOffset());
					assertSame(transition, helper.resolveElementAt(resource, offset));
				}
			}
			for (var offset : check == Check.DECLARATIONS ? List.of(expected.getFirst()) : expected) {
				if (check == Check.TARGET || check == Check.DECLARATIONS) {
					for (var characterOffset = offset; characterOffset < offset + name.length(); characterOffset++) {
						assertSame("Selected state at " + characterOffset, state,
								helper.resolveElementAt(resource, characterOffset));
						if (offset != expected.getFirst().intValue()) {
							assertSame(state, helper.resolveCrossReferencedElementAt(resource, characterOffset));
						}
					}
					continue;
				}
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
				if (check == Check.OCCURRENCES) {
					var annotations = injector.getInstance(IOccurrenceComputer.class).createAnnotationMap(editor,
							new TextSelection(offset, 0), SubMonitor.convert(new NullProgressMonitor()));
					assertEquals("Occurrences at " + offset, expected,
							annotations.values().stream().map(position -> position.offset).sorted().toList());
					annotations.values().forEach(position -> assertEquals(name.length(), position.length));
				} else {
					var target = helper.resolveElementAt(resource, offset);
					var context = new IRenameElementContext.Impl(EcoreUtil.getURI(target), target.eClass(), editor,
							new TextSelection(offset, 0), resource.getURI());
					var group = injector.getInstance(ILinkedPositionGroupCalculator.class)
							.getLinkedPositionGroup(context, new NullProgressMonitor()).get();
					assertNotNull(group);
					assertEquals("Linked positions at " + offset, expected,
							Arrays.stream(group.getPositions()).map(position -> position.getOffset()).sorted().toList());
					for (var position : group.getPositions()) {
						assertEquals(name.length(), position.getLength());
					}
				}
			}
			assertEquals(text, document.get());
			validation.assertNoIssues(resource.getContents().getFirst());
		} finally {
			document.disposeInput();
			restore(registry, "aadl", previousAadl);
			restore(registry, "baxtext", previousBa);
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
