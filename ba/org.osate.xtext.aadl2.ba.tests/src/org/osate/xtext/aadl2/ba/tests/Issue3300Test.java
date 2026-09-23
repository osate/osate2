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

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
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
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.ui.refactoring.ElementRenameArguments;
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
public class Issue3300Test extends XtextTest {
	@Inject
	private TestHelper<AadlPackage> testHelper;
	@Inject
	private ValidationTestHelper validation;

	@Test
	public void renamesCorePortAndBehaviorUses() throws Exception {
		assertRename("input", "new_input");
	}

	@Test
	public void renamesCoreSubcomponentAndBehaviorUses() throws Exception {
		assertRename("DesiredPositionState", "new_state");
	}

	@Test
	public void renamesOutputPortAndBehaviorSend() throws Exception {
		assertRename("output", "new_output");
	}

	@Test
	public void preservesCoreClassifierRename() throws Exception {
		assertRename("Example", "RenamedExample");
	}

	private void assertRename(String oldName, String newName) throws Exception {
		var model = testHelper.parseFile("org.osate.xtext.aadl2.ba.tests/models/issue3300/Issue3300.aadl");
		var resource = (XtextResource) model.eResource();
		var resourceSet = resource.getResourceSet();
		var text = resource.getParseResult().getRootNode().getText();
		var project = ResourcesPlugin.getWorkspace().getRoot().getProject("issue3300");
		if (!project.exists()) {
			project.create(null);
		}
		project.open(null);
		var file = project.getFile("Issue3300.aadl");
		var path = Path.of(System.getProperty("user.dir"), "../org.osate.xtext.aadl2.ba.tests/models/issue3300/Issue3300.aadl");
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
		var injector = Guice.createInjector(Modules.override(Modules2.mixin(new Aadl2RuntimeModule(), new SharedStateModule(),
				new Aadl2UiModule(Aadl2Activator.getInstance()))).with(new AbstractModule() {
					@Override
					protected void configure() {
						bind(IResourceDescriptions.class).toInstance(descriptions);
						bind(RefactoringResourceSetProvider.class).toInstance(provider);
					}
				}));
		var registry = IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap();
		var previousAadl = registry.put("aadl", injector.getInstance(IResourceServiceProvider.class));
		try {
			var target = injector.getInstance(EObjectAtOffsetHelper.class).resolveElementAt(resource, text.indexOf(oldName));
			assertNotNull(target);
			var oldUri = EcoreUtil.getURI(target);
			var strategy = injector.getInstance(IRenameStrategy.Provider.class)
					.get(target, new IRenameElementContext.Impl(oldUri, target.eClass()));
			assertNotNull(strategy);
			assertTrue(strategy.validateNewName(newName).isOK());
			strategy.applyDeclarationChange(newName, resourceSet);
			var newUri = EcoreUtil.getURI(target);
			strategy.revertDeclarationChange(resourceSet);
			var arguments = new ElementRenameArguments(oldUri, newName, strategy, Map.of(oldUri, newUri), provider);
			var acceptor = new Updates(injector.getInstance(StatusWrapper.class));
			strategy.createDeclarationUpdates(newName, resourceSet, acceptor);
			injector.getInstance(ReferenceUpdaterDispatcher.class)
					.createReferenceUpdates(arguments, resourceSet, acceptor, new NullProgressMonitor());
			assertTrue(acceptor.status.getRefactoringStatus().toString(), acceptor.status.getRefactoringStatus().isOK());
			var document = new Document(text);
			assertNotNull(acceptor.edits.get(resource.getURI()));
			acceptor.edits.get(resource.getURI()).apply(document);
			assertEquals(text.replace(oldName, newName), document.get());
			resource.reparse(document.get());
			validation.assertNoIssues(resource.getContents().getFirst());
		} finally {
			restore(registry, "aadl", previousAadl);
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
