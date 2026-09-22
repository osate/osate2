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
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.Document;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.persistence.SerializableResourceDescription;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.ui.refactoring.ElementRenameArguments;
import org.eclipse.xtext.ui.refactoring.IDependentElementsCalculator;
import org.eclipse.xtext.ui.refactoring.IRenamedElementTracker;
import org.eclipse.xtext.ui.refactoring.IRefactoringUpdateAcceptor;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy;
import org.eclipse.xtext.ui.refactoring.impl.IRefactoringDocument;
import org.eclipse.xtext.ui.refactoring.impl.RefactoringResourceSetProvider;
import org.eclipse.xtext.ui.refactoring.impl.ReferenceUpdaterDispatcher;
import org.eclipse.xtext.ui.refactoring.impl.StatusWrapper;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.util.Modules2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.Aadl2RuntimeModule;
import org.osate.xtext.aadl2.errormodel.ErrorModelStandaloneSetup;
import org.osate.xtext.aadl2.errormodel.ErrorModelRuntimeModule;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPoint;
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
public class Issue3302Test extends XtextTest {
	@Inject
	private TestHelper<AadlPackage> testHelper;
	@Inject
	private ValidationTestHelper validation;

	@Test
	public void renamesInputPropagationAndFlow() throws Exception {
		assertRename("input", "new_input");
	}

	@Test
	public void renamesOutputPropagationAndFlow() throws Exception {
		assertRename("output", "new_output");
	}

	@Test
	public void preservesCoreClassifierRename() throws Exception {
		assertRename("Example", "RenamedExample");
	}

	@Test
	public void renamesInheritedFeatureInUnopenedAnnexFile() throws Exception {
		assertRename("input", "new_input", List.of("Definitions.aadl", "Uses.aadl"));
	}

	@Test
	public void preservesPropagationPointRename() throws Exception {
		assertRename("up1", "renamed_point", List.of("PropagationPoints.aadl"));
	}

	private void assertRename(String oldName, String newName) throws Exception {
		assertRename(oldName, newName, List.of("Issue3302.aadl"));
	}

	private void assertRename(String oldName, String newName, List<String> fileNames) throws Exception {
		ErrorModelStandaloneSetup.doSetup();
		var directory = "org.osate.xtext.aadl2.ba.tests/models/issue3302/";
		var model = testHelper.parseFile(directory + fileNames.getFirst(),
				fileNames.stream().skip(1).map(directory::concat).toArray(String[]::new));
		var resource = (XtextResource) model.eResource();
		var resourceSet = resource.getResourceSet();
		var resources = fileNames.stream().map(name -> (XtextResource) resourceSet.getResource(
				URI.createURI(directory + name), false)).toList();
		var originals = new LinkedHashMap<URI, String>();
		var project = ResourcesPlugin.getWorkspace().getRoot().getProject("issue3302");
		if (!project.exists()) {
			project.create(null);
		}
		project.open(null);
		for (var modelResource : resources) {
			var fileName = modelResource.getURI().lastSegment();
			var file = project.getFile(fileName);
			var path = Path.of(System.getProperty("user.dir"), "../" + directory + fileName);
			try (var stream = Files.newInputStream(path)) {
				if (file.exists()) {
					file.setContents(stream, true, false, null);
				} else {
					file.create(stream, true, null);
				}
			}
			modelResource.unload();
			modelResource.setURI(URI.createPlatformResourceURI(file.getFullPath().toString(), true));
		}
		for (var modelResource : resources) {
			modelResource.load(resourceSet.getLoadOptions());
			originals.put(modelResource.getURI(), modelResource.getParseResult().getRootNode().getText());
		}
		for (var modelResource : resources) {
			EcoreUtil.resolveAll(modelResource);
			validation.assertNoIssues(modelResource.getContents().getFirst());
		}
		var text = originals.get(resource.getURI());
		FrameworkUtil.getBundle(Aadl2Activator.class).start();
		var descriptions = new ResourceDescriptionsData(resources.stream().<IResourceDescription>map(modelResource ->
				SerializableResourceDescription.createCopy(modelResource.getResourceServiceProvider()
						.getResourceDescriptionManager().getResourceDescription(modelResource))).toList());
		if (resources.size() > 1) {
			resources.getLast().unload();
			assertTrue(!resources.getLast().isLoaded());
		}
		var provider = new RefactoringResourceSetProvider() {
			@Override
			public ResourceSet get(IProject requestedProject) {
				return resourceSet;
			}
		};
		var injector = Guice.createInjector(Modules.override(Modules2.mixin(new Aadl2RuntimeModule(), new SharedStateModule(),
				new Aadl2UiModule(Aadl2Activator.getInstance()))).with(new AbstractModule() {
					@Override
					protected void configure() {
						bind(IResourceDescriptions.class).toInstance(descriptions);
						bind(RefactoringResourceSetProvider.class).toInstance(provider);
					}
				}));
		FrameworkUtil.getBundle(ErrormodelActivator.class).start();
		var emv2Injector = Guice.createInjector(Modules.override(Modules2.mixin(new ErrorModelRuntimeModule(),
				new SharedStateModule(), new ErrorModelUiModule(ErrormodelActivator.getInstance()))).with(new AbstractModule() {
			@Override
			protected void configure() {
				bind(IResourceDescriptions.class).toInstance(descriptions);
				bind(RefactoringResourceSetProvider.class).toInstance(provider);
			}
		}));
		var registry = IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap();
		var previousEmv2 = registry.put("emv2", emv2Injector.getInstance(IResourceServiceProvider.class));
		var previousAadl = registry.put("aadl", injector.getInstance(IResourceServiceProvider.class));
		try {
			var pointOffset = text.indexOf(oldName + ": propagation point");
			var offset = pointOffset < 0 ? text.indexOf(oldName) : pointOffset;
			var target = injector.getInstance(EObjectAtOffsetHelper.class).resolveElementAt(resource, offset);
			assertNotNull(target);
			var renameInjector = target instanceof PropagationPoint ? emv2Injector : injector;
			var oldUri = EcoreUtil.getURI(target);
			var strategy = renameInjector.getInstance(IRenameStrategy.Provider.class)
					.get(target, new IRenameElementContext.Impl(oldUri, target.eClass()));
			assertNotNull(strategy);
			assertTrue(strategy.validateNewName(newName).isOK());
			var tracked = new ArrayList<URI>();
			tracked.add(oldUri);
			renameInjector.getInstance(IDependentElementsCalculator.class)
					.getDependentElementURIs(target, new NullProgressMonitor()).forEach(tracked::add);
			var renamed = renameInjector.getInstance(IRenamedElementTracker.class)
					.renameAndTrack(tracked, newName, resourceSet, strategy, new NullProgressMonitor());
			var arguments = new ElementRenameArguments(oldUri, newName, strategy, renamed, provider);
			var acceptor = new Updates(injector.getInstance(StatusWrapper.class));
			strategy.createDeclarationUpdates(newName, resourceSet, acceptor);
			renameInjector.getInstance(ReferenceUpdaterDispatcher.class)
					.createReferenceUpdates(arguments, resourceSet, acceptor, new NullProgressMonitor());
			assertTrue(acceptor.status.getRefactoringStatus().toString(), acceptor.status.getRefactoringStatus().isOK());
			for (var original : originals.entrySet()) {
				var document = new Document(original.getValue());
				assertNotNull(acceptor.edits.get(original.getKey()));
				acceptor.edits.get(original.getKey()).apply(document);
				assertEquals(original.getValue().replace(oldName, newName), document.get());
				((XtextResource) resourceSet.getResource(original.getKey(), true)).reparse(document.get());
			}
			for (var modelResource : resources) {
				EcoreUtil.resolveAll(modelResource);
				validation.assertNoIssues(modelResource.getContents().getFirst());
			}
		} finally {
			restore(registry, "aadl", previousAadl);
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

	private static final class Updates implements IRefactoringUpdateAcceptor {
		private final Map<URI, MultiTextEdit> edits = new HashMap<>();
		private final StatusWrapper status;

		private Updates(StatusWrapper status) {
			this.status = status;
		}

		@Override
		public void accept(URI uri, TextEdit edit) {
			edits.computeIfAbsent(uri, ignored -> new MultiTextEdit()).addChild(edit);
		}

		@Override
		public void accept(URI uri, Change change) {
			throw new AssertionError("Unexpected non-text change");
		}

		@Override
		public StatusWrapper getRefactoringStatus() {
			return status;
		}

		@Override
		public IRefactoringDocument getDocument(URI uri) {
			throw new AssertionError("Unexpected document request");
		}

		@Override
		public Change createCompositeChange(String name, IProgressMonitor monitor) {
			throw new AssertionError("Unexpected composite change");
		}
	}
}
