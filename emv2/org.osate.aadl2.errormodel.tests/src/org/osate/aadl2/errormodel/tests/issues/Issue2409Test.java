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
package org.osate.aadl2.errormodel.tests.issues;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.ProcessorBasedRefactoring;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;
import org.eclipse.xtext.ide.refactoring.IRenameStrategy2;
import org.eclipse.xtext.ide.refactoring.RefactoringIssueAcceptor.Severity;
import org.eclipse.xtext.ide.refactoring.RenameChange;
import org.eclipse.xtext.ide.refactoring.RenameContext;
import org.eclipse.xtext.ide.serializer.IChangeSerializer;
import org.eclipse.xtext.ide.serializer.IEmfResourceChange;
import org.eclipse.xtext.ide.serializer.ITextDocumentChange;
import org.eclipse.xtext.ide.server.rename.ServerRefactoringIssueAcceptor;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.ui.refactoring.IRenameRefactoringProvider;
import org.eclipse.xtext.ui.refactoring.impl.AbstractRenameProcessor;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.ui.resource.LiveScopeResourceSetInitializer;
import org.eclipse.xtext.util.Modules2;
import org.junit.After;
import org.junit.Test;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.SystemType;
import org.osate.xtext.aadl2.Aadl2RuntimeModule;
import org.osate.xtext.aadl2.Aadl2StandaloneSetup;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;
import org.osate.xtext.aadl2.errormodel.ide.ErrorModelIdeSetup;
import org.osate.xtext.aadl2.errormodel.ui.internal.ErrormodelActivator;
import org.osate.xtext.aadl2.ide.Aadl2IdeModule;
import org.osate.xtext.aadl2.ui.internal.Aadl2Activator;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Renaming a propagation point changes the synthetic name of an error propagation that references it. The refactoring
 * must update the propagation declaration, error-flow references, and propagation-path references together through
 * both the Eclipse UI and serializer-based language-server paths.
 */
@SuppressWarnings("restriction")
public class Issue2409Test {
	private static final String PROJECT_NAME = "issue2409-refactoring-test";

	private IProject project;

	@Test
	public void renameTracksSyntheticErrorPropagationName() throws Exception {
		IFile modelFile = createProject();
		var injector = Aadl2Activator.getInstance()
				.getInjector(Aadl2Activator.ORG_OSATE_XTEXT_AADL2_AADL2);
		var resourceSet = new XtextResourceSet();
		injector.getInstance(LiveScopeResourceSetInitializer.class).initialize(resourceSet);
		URI modelUri = URI.createPlatformResourceURI(modelFile.getFullPath().toString(), true);
		var resource = resourceSet.getResource(modelUri, true);
		var pkg = (AadlPackage) resource.getContents().getFirst();
		injector.getInstance(ValidationTestHelper.class).assertNoIssues(pkg);
		var system = (SystemType) pkg.getOwnedPublicSection().getOwnedClassifiers().getFirst();
		var annex = (DefaultAnnexSubclause) system.getOwnedAnnexSubclauses().getFirst();
		var errorModel = (ErrorModelSubclause) annex.getParsedAnnexSubclause();
		var propagationPoint = errorModel.getPoints().getFirst();

		var context = new IRenameElementContext.Impl(URI.createPlatformResourceURI(modelFile.getFullPath().toString(),
				true).appendFragment(resource.getURIFragment(propagationPoint)), propagationPoint.eClass());
		var errorModelInjector = ErrormodelActivator.getInstance()
				.getInjector(ErrormodelActivator.ORG_OSATE_XTEXT_AADL2_ERRORMODEL_ERRORMODEL);
		ProcessorBasedRefactoring refactoring = errorModelInjector.getInstance(IRenameRefactoringProvider.class)
				.getRenameRefactoring(context);
		assertNotNull(refactoring);
		var processor = (AbstractRenameProcessor) refactoring.getProcessor();
		processor.setNewName("renamed_up1");

		RefactoringStatus initialStatus = refactoring.checkInitialConditions(new NullProgressMonitor());
		assertFalse(initialStatus.toString(), initialStatus.hasError());
		RefactoringStatus finalStatus = refactoring.checkFinalConditions(new NullProgressMonitor());
		assertFalse(finalStatus.toString(), finalStatus.hasFatalError());
		assertFalse(finalStatus.toString(), finalStatus.toString().contains("Refactoring introduces a name conflict."));
		var change = refactoring.createChange(new NullProgressMonitor());
		assertNotNull(change);
		change.initializeValidationData(new NullProgressMonitor());
		assertFalse(change.isValid(new NullProgressMonitor()).hasError());
		change.perform(new NullProgressMonitor());

		modelFile.refreshLocal(IFile.DEPTH_ZERO, new NullProgressMonitor());
		String contents = new String(modelFile.getContents().readAllBytes(), StandardCharsets.UTF_8);
		assertTrue(contents.contains("renamed_up1: in propagation"));
		assertTrue(contents.contains("f3: error sink renamed_up1;"));
		assertTrue(contents.contains("renamed_up1: propagation point;"));
		assertTrue(contents.contains("path1: renamed_up1 -> renamed_up1;"));
	}

	@Test
	public void languageServerRenameTracksSyntheticErrorPropagationName() throws Exception {
		var injector = createAadlIdeInjector();
		var source = Files.readString(getModelPath(), StandardCharsets.UTF_8);
		var resourceSet = injector.getInstance(XtextResourceSet.class);
		var resource = (XtextResource) resourceSet.createResource(URI.createURI("Issue2409.aadl"));
		resource.load(new java.io.ByteArrayInputStream(source.getBytes(StandardCharsets.UTF_8)), null);
		var pkg = (AadlPackage) resource.getContents().getFirst();
		injector.getInstance(ValidationTestHelper.class).assertNoIssues(pkg);
		var system = (SystemType) pkg.getOwnedPublicSection().getOwnedClassifiers().getFirst();
		var annex = (DefaultAnnexSubclause) system.getOwnedAnnexSubclauses().getFirst();
		var errorModel = (ErrorModelSubclause) annex.getParsedAnnexSubclause();
		var propagationPoint = errorModel.getPoints().getFirst();
		var services = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(resource.getURI());
		var changeSerializer = services.get(IChangeSerializer.class);
		var renameStrategy = services.get(IRenameStrategy2.class);
		var issues = new ServerRefactoringIssueAcceptor();
		var change = new RenameChange("renamed_up1", EcoreUtil.getURI(propagationPoint));
		var context = new RenameContext(List.of(change), resourceSet, changeSerializer, issues);
		var changes = new ArrayList<IEmfResourceChange>();

		renameStrategy.applyRename(context);
		changeSerializer.applyModifications(changes::add);

		assertEquals(Severity.OK, issues.getMaximumSeverity());
		var documentChange = changes.stream()
				.filter(ITextDocumentChange.class::isInstance)
				.map(ITextDocumentChange.class::cast)
				.filter(candidate -> resource.getURI().equals(candidate.getOldURI()))
				.findFirst()
				.orElseThrow();
		var contents = applyReplacements(source, documentChange.getReplacements());
		assertTrue(contents, contents.contains("renamed_up1: in propagation"));
		assertTrue(contents, contents.contains("f3: error sink renamed_up1;"));
		assertTrue(contents, contents.contains("renamed_up1: propagation point;"));
		assertTrue(contents, contents.contains("path1: renamed_up1 -> renamed_up1;"));
		var renamedResourceSet = injector.getInstance(XtextResourceSet.class);
		var renamedResource = renamedResourceSet.createResource(URI.createURI("RenamedIssue2409.aadl"));
		renamedResource.load(new java.io.ByteArrayInputStream(contents.getBytes(StandardCharsets.UTF_8)), null);
		injector.getInstance(ValidationTestHelper.class)
				.assertNoIssues((AadlPackage) renamedResource.getContents().getFirst());
	}

	@After
	public void deleteProject() throws CoreException {
		if (project != null && project.exists()) {
			project.delete(true, true, new NullProgressMonitor());
		}
	}

	private IFile createProject() throws CoreException, IOException {
		var workspace = ResourcesPlugin.getWorkspace();
		project = workspace.getRoot().getProject(PROJECT_NAME);
		if (project.exists()) {
			project.delete(true, true, new NullProgressMonitor());
		}
		IProjectDescription description = workspace.newProjectDescription(PROJECT_NAME);
		description.setNatureIds(
				new String[] { "org.osate.core.aadlnature", "org.eclipse.xtext.ui.shared.xtextNature" });
		ICommand builder = description.newCommand();
		builder.setBuilderName("org.eclipse.xtext.ui.shared.xtextBuilder");
		description.setBuildSpec(new ICommand[] { builder });
		project.create(description, new NullProgressMonitor());
		project.open(new NullProgressMonitor());
		IFile modelFile = project.getFile("Issue2409.aadl");
		var source = getModelPath();
		try (var stream = Files.newInputStream(source)) {
			modelFile.create(stream, true, new NullProgressMonitor());
		}
		project.build(IncrementalProjectBuilder.FULL_BUILD, new NullProgressMonitor());
		return modelFile;
	}

	private static java.nio.file.Path getModelPath() {
		return java.nio.file.Path.of(System.getProperty("user.dir"), "models", "issue2409", "Issue2409.aadl");
	}

	private static Injector createAadlIdeInjector() {
		ErrormodelActivator.getInstance()
				.getInjector(ErrormodelActivator.ORG_OSATE_XTEXT_AADL2_ERRORMODEL_ERRORMODEL);
		var aadlInjector = new Aadl2StandaloneSetup() {
			@Override
			public Injector createInjector() {
				var runtimeModule = new Aadl2RuntimeModule() {
					@Override
					public ClassLoader bindClassLoaderToInstance() {
						return Issue2409Test.class.getClassLoader();
					}
				};
				return Guice.createInjector(Modules2.mixin(runtimeModule, new Aadl2IdeModule()));
			}
		}.createInjectorAndDoEMFRegistration();
		new ErrorModelIdeSetup().createInjectorAndDoEMFRegistration();
		return aadlInjector;
	}

	private static String applyReplacements(String originalText, List<ITextReplacement> replacements) {
		var result = new StringBuilder(originalText);
		replacements.stream()
				.sorted(Comparator.comparingInt(ITextReplacement::getOffset).reversed())
				.forEach(replacement -> result.replace(replacement.getOffset(),
						replacement.getOffset() + replacement.getLength(), replacement.getReplacementText()));
		return result.toString();
	}
}
