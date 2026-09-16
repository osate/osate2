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
package org.osate.ui.tests.propertyview.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.net.URL;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.text.IDocument;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.texteditor.ITextEditor;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * Workbench and workspace helpers that are not specific to the AADL Property Values view: importing a model project
 * that is shipped with this test bundle, opening the AADL text editor for one of its files, and moving the caret in
 * that editor.
 * <p>
 * Everything here is a thin wrapper around the workbench and SWTBot. The property view specific commands and
 * assertions live in {@link AadlPropertyViewBot}.
 */
public final class WorkbenchTestUtil {
	/**
	 * Views that {@link #prepareWorkbench()} leaves open. Every other view is closed so that no other view contributes
	 * to the workbench selection while a test drives the property view from the text editor.
	 */
	private static final Set<String> VIEWS_TO_KEEP = Set.of("AADL Navigator", AadlPropertyViewBot.VIEW_TITLE);

	/** Directory in this bundle that holds the AADL model projects used by the tests. */
	private static final String MODELS_DIRECTORY = "models";

	private static final SWTWorkbenchBot bot = new SWTWorkbenchBot();

	// All methods are static
	private WorkbenchTestUtil() {
	}

	/**
	 * Puts the workbench into a known state: a window large enough that the property view shows a useful number of rows
	 * without scrolling, no editors, and no views other than {@link #VIEWS_TO_KEEP}.
	 */
	public static void prepareWorkbench() {
		SWTBotPreferences.TIMEOUT = 20_000;
		UIThreadRunnable
				.syncExec(() -> PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().setSize(1600, 1000));
		for (final SWTBotView view : bot.views()) {
			if (!VIEWS_TO_KEEP.contains(view.getTitle())) {
				view.close();
			}
		}
		closeAllEditors();
	}

	/**
	 * Copies the model project {@code projectName} from this bundle's {@value #MODELS_DIRECTORY} directory into the
	 * workspace, creates and opens it, and waits for the AADL build to finish. A project of that name that is left over
	 * from an earlier run is deleted first.
	 */
	public static IProject importModelProject(final String projectName) {
		deleteProject(projectName);

		final IWorkspace workspace = ResourcesPlugin.getWorkspace();
		final IPath destination = workspace.getRoot().getLocation().append(projectName);
		try {
			copyDirectory(modelDirectory(projectName), destination.toFile().toPath());
			final IProjectDescription description = workspace
					.loadProjectDescription(destination.append(IProjectDescription.DESCRIPTION_FILE_NAME));
			final IProject project = workspace.getRoot().getProject(description.getName());
			project.create(description, null);
			project.open(null);
			waitForBuild();
			return project;
		} catch (final IOException | CoreException e) {
			throw new RuntimeException("Unable to import model project '" + projectName + "'", e);
		}
	}

	/**
	 * Asserts that the AADL build reported no error for any file of the project. Called after importing a model project,
	 * so that a mistake in a model fails once with the AADL diagnostic instead of failing every test that reads a value
	 * out of that model.
	 */
	public static void assertNoErrorsInProject(final IProject project) {
		final List<String> errors = new ArrayList<>();
		try {
			for (final IMarker marker : project.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE)) {
				if (marker.getAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO) == IMarker.SEVERITY_ERROR) {
					errors.add(marker.getResource().getName() + ':' + marker.getAttribute(IMarker.LINE_NUMBER, -1) + ' '
							+ marker.getAttribute(IMarker.MESSAGE, ""));
				}
			}
		} catch (final CoreException e) {
			throw new RuntimeException("Unable to read the problem markers of '" + project.getName() + "'", e);
		}
		assertEquals("The model project '" + project.getName() + "' has errors", List.of(), errors);
	}

	/**
	 * Deletes the project and its contents on disk. Does nothing if the project does not exist.
	 */
	public static void deleteProject(final String projectName) {
		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		if (!project.exists()) {
			return;
		}
		try {
			project.delete(true, true, null);
		} catch (final CoreException e) {
			throw new RuntimeException("Unable to delete project '" + projectName + "'", e);
		}
		waitForBuild();
	}

	/**
	 * Opens {@code fileName} of {@code project} in the AADL text editor and makes it the active editor. If the editor is
	 * already open it is only activated.
	 */
	public static void openEditor(final IProject project, final String fileName) {
		final IFile file = project.getFile(fileName);
		assertTrue("Model file '" + fileName + "' does not exist in project '" + project.getName() + "'", file.exists());
		UIThreadRunnable.syncExec(() -> {
			try {
				IDE.openEditor(activePage(), file, true);
			} catch (final Exception e) {
				fail("Unable to open an editor for '" + fileName + "': " + e);
			}
		});
		bot.editorByTitle(fileName);
	}

	/**
	 * Makes the editor with the given title the active part.
	 * <p>
	 * The property view registers itself on an Xtext editor's post selection provider when that editor is activated and
	 * unregisters when it is deactivated, so an editor must be activated before its caret is moved. Reading the
	 * property view's tree does not activate the view, but clicking one of its toolbar items or opening a context menu
	 * in it does, which is why every caret movement activates the editor again.
	 */
	public static void activateEditor(final String fileName) {
		final IEditorPart editor = editorPart(fileName);
		UIThreadRunnable.syncExec(() -> activePage().activate(editor));
	}

	/**
	 * Closes the editor with the given title, discarding unsaved changes. Does nothing if it is not open.
	 * <p>
	 * The property view modifies the editor's document rather than the file on disk, so discarding the document is how a
	 * test undoes a modification it made through the view.
	 */
	public static void closeEditorWithoutSaving(final String fileName) {
		UIThreadRunnable.syncExec(() -> {
			for (final var reference : activePage().getEditorReferences()) {
				if (fileName.equals(reference.getName())) {
					final IEditorPart editor = reference.getEditor(false);
					if (editor != null) {
						activePage().closeEditor(editor, false);
					}
				}
			}
		});
	}

	/**
	 * Closes every editor, discarding unsaved changes.
	 */
	public static void closeAllEditors() {
		UIThreadRunnable.syncExec(() -> activePage().closeAllEditors(false));
	}

	/**
	 * Returns the text of the document shown by the editor with the given title. This is the text as the editor sees it,
	 * so it includes modifications that have not been saved.
	 */
	public static String editorText(final String fileName) {
		return UIThreadRunnable.syncExec(() -> document(fileName).get());
	}

	/**
	 * Places the caret in the editor with the given title on the last character of the first occurrence of
	 * {@code snippet}.
	 * <p>
	 * The caret goes on the last character rather than the first because a snippet ends with the name of the element the
	 * test wants to select, and only that name belongs to the element itself. In
	 * <code>system implementation Valued.Impl</code>, for instance, only <code>Impl</code> is the implementation's name;
	 * <code>Valued</code> is a reference to the component type, and putting the caret there selects that reference
	 * instead, which is not an element that can have properties.
	 * <p>
	 * The snippet must also be chosen so that its first occurrence is the declaration, which means it must not appear in
	 * a comment earlier in the file.
	 */
	public static void selectInEditor(final String fileName, final String snippet) {
		activateEditor(fileName);
		final int offset = offsetOf(fileName, snippet) + snippet.length() - 1;
		final IEditorPart editor = editorPart(fileName);
		UIThreadRunnable.syncExec(() -> ((ITextEditor) editor).selectAndReveal(offset, 0));
	}

	/**
	 * Returns the offset of the first occurrence of {@code snippet} in the editor's document.
	 */
	public static int offsetOf(final String fileName, final String snippet) {
		final String text = editorText(fileName);
		final int offset = text.indexOf(snippet);
		assertTrue("'" + snippet + "' does not occur in '" + fileName + "'", offset >= 0);
		return offset;
	}

	/**
	 * Asserts that the editor's document contains {@code snippet}.
	 */
	public static void assertEditorTextContains(final String fileName, final String snippet) {
		final String text = editorText(fileName);
		assertTrue("Expected the text of '" + fileName + "' to contain '" + snippet + "' but it was:\n" + text,
				text.contains(snippet));
	}

	/**
	 * Asserts that the editor's document does not contain {@code snippet}.
	 */
	public static void assertEditorTextDoesNotContain(final String fileName, final String snippet) {
		final String text = editorText(fileName);
		assertFalse("Expected the text of '" + fileName + "' not to contain '" + snippet + "' but it was:\n" + text,
				text.contains(snippet));
	}

	/**
	 * Asserts how often {@code snippet} occurs in the editor's document. Used where a modification adds or removes a
	 * property association whose exact rendering is up to the AADL serializer, so only the number of associations that
	 * mention a property is worth asserting on.
	 */
	public static void assertEditorTextOccurrences(final String fileName, final String snippet, final int expected) {
		final String text = editorText(fileName);
		int occurrences = 0;
		for (int index = text.indexOf(snippet); index >= 0; index = text.indexOf(snippet, index + snippet.length())) {
			occurrences++;
		}
		assertEquals("Occurrences of '" + snippet + "' in '" + fileName + "', whose text is:\n" + text, expected,
				occurrences);
	}

	/**
	 * Waits until the workspace build is idle. Called after a change to the set of AADL files in the workspace; a change
	 * that only touches an editor's document does not start a build.
	 */
	public static void waitForBuild() {
		for (int attempt = 0; attempt < 2; attempt++) {
			bot.sleep(500);
			try {
				Job.getJobManager().join(ResourcesPlugin.FAMILY_AUTO_BUILD, null);
				Job.getJobManager().join(ResourcesPlugin.FAMILY_MANUAL_BUILD, null);
			} catch (final InterruptedException | OperationCanceledException e) {
				throw new RuntimeException("Interrupted while waiting for the workspace build", e);
			}
		}
	}

	private static IWorkbenchPage activePage() {
		return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
	}

	private static IEditorPart editorPart(final String fileName) {
		final IEditorPart editor = UIThreadRunnable.syncExec(() -> {
			for (final var reference : activePage().getEditorReferences()) {
				if (fileName.equals(reference.getName())) {
					return reference.getEditor(true);
				}
			}
			return null;
		});
		if (editor == null) {
			fail("No editor is open for '" + fileName + "'");
		}
		return editor;
	}

	private static IDocument document(final String fileName) {
		final ITextEditor editor = (ITextEditor) editorPart(fileName);
		return editor.getDocumentProvider().getDocument(editor.getEditorInput());
	}

	private static Path modelDirectory(final String projectName) throws IOException {
		final Bundle bundle = FrameworkUtil.getBundle(WorkbenchTestUtil.class);
		final String path = MODELS_DIRECTORY + '/' + projectName;
		final URL entry = bundle.getEntry(path);
		if (entry == null) {
			throw new IOException("'" + path + "' is not part of bundle '" + bundle.getSymbolicName() + "'");
		}
		return Path.of(FileLocator.toFileURL(entry).getPath());
	}

	private static void copyDirectory(final Path source, final Path destination) throws IOException {
		Files.walkFileTree(source, new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult preVisitDirectory(final Path directory, final BasicFileAttributes attributes)
					throws IOException {
				Files.createDirectories(destination.resolve(source.relativize(directory).toString()));
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult visitFile(final Path file, final BasicFileAttributes attributes) throws IOException {
				Files.copy(file, destination.resolve(source.relativize(file).toString()));
				return FileVisitResult.CONTINUE;
			}
		});
	}
}
