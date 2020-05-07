/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.internal.services.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.modelsupport.Activator;
import org.osate.annexsupport.AnnexRegistry;
import org.osate.annexsupport.AnnexUnparserRegistry;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.ActionExecutor;
import org.osate.ge.internal.services.ActionService;
import org.osate.ge.internal.services.AgeAction;
import org.osate.ge.internal.services.ModelChangeNotifier;
import org.osate.ge.internal.services.ModelChangeNotifier.Lock;
import org.osate.ge.internal.ui.xtext.AgeXtextUtil;
import org.osate.ge.internal.util.ProjectUtil;

import com.google.common.collect.Lists;
import com.google.common.io.CharStreams;

public class DefaultAadlModificationService implements AadlModificationService {
	public static class ContextFunction extends SimpleServiceContextFunction<AadlModificationService> {
		@Override
		public AadlModificationService createService(final IEclipseContext context) {
			return new DefaultAadlModificationService(context.get(ModelChangeNotifier.class),
					context.get(ActionService.class));
		}
	}

	private final ModelChangeNotifier modelChangeNotifier;
	private final ActionService actionService;

	public DefaultAadlModificationService(final ModelChangeNotifier modelChangeNotifier,
			final ActionService actionService) {
		this.modelChangeNotifier = Objects.requireNonNull(modelChangeNotifier,
				"modelChangeNotifier must not be null");
		this.actionService = Objects.requireNonNull(actionService, "activeService must not be null");
	}

	@Override
	public void modify(final List<? extends Modification<?, ?>> modifications,
			final ModificationPostprocessor postProcessor) {
		runInDisplayThread(() -> performModifications(modifications, postProcessor));
	}

	private static void runInDisplayThread(final Runnable runnable) {
		if (Display.getDefault().getThread() == Thread.currentThread()) {
			try {
				runnable.run();
			} catch (RuntimeException ex) {
				final Status status = new Status(IStatus.ERROR, Activator.getPluginId(),
						"An error occured.", ex);
				StatusManager.getManager().handle(status, StatusManager.SHOW | StatusManager.LOG);
				throw ex; // Rethrow exception to let caller know that there was a problem.
			}
		} else {
			Display.getDefault().syncExec(runnable);
		}
	}

	// Assumes that the modification notifier is already locked
	private void performModifications(final List<? extends Modification<?, ?>> modifications,
			final ModificationPostprocessor postProcessor) {
		class ModificationAction implements AgeAction {
			@Override
			public boolean canExecute() {
				return true;
			}

			@Override
			public AgeAction execute() {
				try (Lock lock = modelChangeNotifier.lock()) {
					final Set<IProject> projectsToBuild = new HashSet<>();

					boolean allSuccessful = true;

					final List<ModificationResult> modificationResults = new ArrayList<>();

					// Iterate over the input objects
					for (final Modification<?, ?> modification : modifications) {
						final ModificationResult modificationResult = performModification(modification,
								projectsToBuild);
						allSuccessful = modificationResult.modificationSuccessful;

						if (!allSuccessful) {
							break;
						}

						modificationResults.add(modificationResult);
					}

					// Build projects before unlocking. This will cause the post build notifications to be sent out before the lock is released.
					// This is desired to avoid multiple diagram updates for the same change.
					buildProjects(projectsToBuild);

					if (postProcessor != null) {
						postProcessor.modificationCompleted(allSuccessful);
					}

					return modificationResults.size() > 0 ? new UndoAction(modificationResults) : null;
				}
			}

		}

		actionService.execute("Modify Model", ActionExecutor.ExecutionMode.NORMAL, new ModificationAction());
	}

	private void buildProjects(final Set<IProject> projectsToBuild) {
		for (final IProject project : projectsToBuild) {
			try {
				project.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, new NullProgressMonitor());
			} catch (CoreException e) {
				// Ignore any errors that occur while building the project
				e.printStackTrace();
			}
		}
	}

	private class UndoAction implements AgeAction {
		private final List<ModificationResult> modResults;

		public UndoAction(final List<ModificationResult> modResults) {
			this.modResults = modResults;
		}

		private final IXtextDocument getXtextDocument(final ModificationResult modResult) {
			return AgeXtextUtil.getDocumentByRootElement(modResult.rootQualifiedName, modResult.resourceUri);
		}

		@Override
		public AgeAction execute() {
			// Results of the undo action. Used to redo the operation.
			final List<ModificationResult> undoResults = new ArrayList<>();

			runInDisplayThread(() -> {
				try (Lock lock = modelChangeNotifier.lock()) {
					final Set<IProject> projectsToBuild = new HashSet<>();

					// Undo the operations in the opposite order from which they were originally performed.
					for (final ModificationResult modResult : Lists.reverse(modResults)) {
						final IXtextDocument doc = getXtextDocument(modResult);
						final String newOriginalTextContents;
						if (doc == null) {
							final IProject projectResource = ProjectUtil.getProject(modResult.resourceUri);
							if (projectResource instanceof IProject) {
								projectsToBuild.add((IProject) projectResource);
							}

							// Get the model file
							String platformString = modResult.resourceUri.toPlatformString(true);
							final IResource modelResource = ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
							if (!(modelResource instanceof IFile)) {
								throw new RuntimeException("Unable to get file: " + platformString);
							}

							final IFile modelFile = (IFile) modelResource;

							// Store the current contents of the model file and update the model file with the original contents
							try {
								final String charsetName = modelFile.getCharset(true);
								final Charset charset = Charset.forName(charsetName);

								// Get original contents
								newOriginalTextContents = CharStreams
										.toString(new InputStreamReader(modelFile.getContents(), charset));

								modelFile.setContents(
										new ByteArrayInputStream(
												modResult.originalTextContents.getBytes(charset)),
										true, true, new NullProgressMonitor());
							} catch (IOException | CoreException e) {
								throw new RuntimeException(e);
							}

						} else {
							fixXtextDocumentDirtyState(doc);
							newOriginalTextContents = doc.get();
							doc.set(modResult.originalTextContents);

							// Call readonly on the document. This will should cause Xtext's reconciler to be called to ensure the document matches the
							// model and trigger model change events.
							doc.readOnly(res -> null);
						}

						undoResults.add(
								ModificationResult.createSuccess(modResult.rootQualifiedName, modResult.resourceUri,
										newOriginalTextContents));

					}

					// Build projects before unlocking. This will cause the post build notifications to be sent out before the lock is released.
					// This is desired to avoid multiple diagram updates for the same change.
					buildProjects(projectsToBuild);
				}
			});

			// Return action to redo the operation.
			return new UndoAction(undoResults);
		}
	}

	private <TagType, BusinessObjectType extends EObject> ModificationResult performModification(
			final Modification<TagType, BusinessObjectType> modification, final Set<IProject> projectsToBuild) {
		final TagType tag = modification.getTag();

		// Determine the object to modify
		final BusinessObjectType bo = modification.getTagToBusinessObjectMapper().apply(tag);
		if (bo == null) {
			return ModificationResult.createFailure();
		}

		if (!(bo.eResource() instanceof XtextResource)) {
			throw new RuntimeException("Unexpected case. Resource is not an XtextResource");
		}

		// Try to get the Xtext document
		String rootQualifiedName = null;
		URI rootResourceUri = null;
		if(bo.eResource() != null) {
			final Object root = bo.eResource() == null ? null : bo.eResource().getContents().get(0);
			if(root instanceof NamedElement) {
				final NamedElement rootNamedElement = (NamedElement)root;
				rootQualifiedName = rootNamedElement.getQualifiedName();
				rootResourceUri = rootNamedElement.eResource().getURI();
			}
		}

		final IXtextDocument doc = AgeXtextUtil.getDocumentByRootElement(rootQualifiedName, rootResourceUri);
		final String originalTextContents;
		final ModifySafelyResults modifySafelyResult;
		if (doc == null) {
			// Modify the EMF resource directly
			final XtextResource res = (XtextResource) bo.eResource();

			try {
				originalTextContents = getText(res);
			} catch (RuntimeException ex) {
				throw new RuntimeException(
						"Unable to modify model. Unable to get AADL source text. Check model for errors.",
						ex);
			}

			// Check if the AADL file is editable.
			final IResource aadlResource = ResourcesPlugin.getWorkspace().getRoot()
					.getFile(new Path(res.getURI().toPlatformString(true)));
			if (aadlResource instanceof IFile) {
				final IFile aadlFile = (IFile) aadlResource;
				if (aadlFile.isReadOnly()) {
					final IStatus status = ResourcesPlugin.getWorkspace().validateEdit(new IFile[] { aadlFile },
							IWorkspace.VALIDATE_PROMPT);
					if (!status.isOK() || aadlFile.isReadOnly()) {
						final String extMessage = status.isOK() ? "" : status.getMessage();
						throw new RuntimeException("One or more AADL files are not read-only. " + extMessage);
					}
				}
			}

			modifySafelyResult = modifySafely(res, tag, bo, modification.getModifier(), true);

			if (modifySafelyResult.modificationSuccessful) {
				// Save the model
				try {
					res.save(SaveOptions.newBuilder().format().getOptions().toOptionsMap());
				} catch (final IOException e) {
					throw new RuntimeException(e);
				}
			}

			// Try to get the project for the resource and add it to the list of projects to build.
			final URI resourceUri = res.getURI();
			if (resourceUri != null) {
				final IPath projectPath = new Path(resourceUri.toPlatformString(true)).uptoSegment(1);
				final IResource projectResource = ResourcesPlugin.getWorkspace().getRoot().findMember(projectPath);
				if (projectResource instanceof IProject) {
					projectsToBuild.add((IProject) projectResource);
				}
			}
		} else {
			fixXtextDocumentDirtyState(doc);

			// If the element is in an annex, determine the root actual/parsed annex element
			final EObject parsedAnnexRoot = getParsedAnnexRoot(bo);

			// Store original contents
			originalTextContents = doc.get();

			// If the element which needs to be edited is in an annex, modify the default annex element. This is needed because objects inside
			// of annexes may not have unique URI's
			final EObject objectToModify = parsedAnnexRoot == null ? bo : parsedAnnexRoot.eContainer();
			final URI modificationObjectUri = EcoreUtil.getURI(objectToModify);
			modifySafelyResult = doc
					.modify(new IUnitOfWork<ModifySafelyResults, XtextResource>() {
						@SuppressWarnings("unchecked")
						@Override
						public ModifySafelyResults exec(final XtextResource res) throws Exception {
							final EObject objectToModify = res.getResourceSet().getEObject(modificationObjectUri,
									true);
							if (objectToModify == null) {
								return new ModifySafelyResults(false);
							}

							if (parsedAnnexRoot != null && (objectToModify instanceof DefaultAnnexLibrary
									|| objectToModify instanceof DefaultAnnexSubclause)) {
								return modifyAnnexInXtextDocument(res, objectToModify, tag, bo,
										modification.getModifier());
							} else {
								return modifySafely(res, tag, (BusinessObjectType) objectToModify, modification.getModifier(),
										false);
							}
						}
					});

			// Call the after modification callback
			if (modifySafelyResult.modificationSuccessful) {
				// Call readonly on the document. This will should cause Xtext's reconciler to be called to ensure the document matches the
				// model and trigger model change events.
				doc.readOnly(res -> null);
			}
		}

		if(modifySafelyResult.modificationSuccessful) {
			return ModificationResult.createSuccess(rootQualifiedName, rootResourceUri, originalTextContents);
		} else {
			return ModificationResult.createFailure();
		}
	}

	private static void fixXtextDocumentDirtyState(final IXtextDocument doc) {
		// TODO: Remove when issue regarding Xtext Dirty State has been resolved.
		// https://github.com/osate/osate-ge/issues/210
		// This works around the issue by getting the xtext editor and calling doVerify() on it's dirty state editor support which starts
		// managing
		// the dirty state.
		for (final IEditorReference editorRef : PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.getEditorReferences()) {
			final IEditorPart editor = editorRef.getEditor(false);
			if (editor instanceof XtextEditor) {
				final XtextEditor xtextEditor = (XtextEditor) editor;
				if (xtextEditor.getDocument() == doc) {
					xtextEditor.getDirtyStateEditorSupport().doVerify();
					break;
				}
			}
		}
	}

	private static String getText(final XtextResource res) {
		// Serialize the current resource to a string.
		final ByteArrayOutputStream stream = new ByteArrayOutputStream();
		try {
			res.save(stream, SaveOptions.newBuilder().format().getOptions().toOptionsMap());
		} catch (final IOException e) {
			throw new RuntimeException(e);
		}

		try {
			final String txt = stream.toString(res.getEncoding());
			if (txt == null || txt.length() == 0) {
				throw new RuntimeException("Unable to get source text for resource: " + res.getURI());
			}

			return txt;
		} catch (final UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

	private <TagType, BusinessObjectType extends EObject> ModifySafelyResults modifyAnnexInXtextDocument(final XtextResource resource,
			final EObject defaultAnnexElement, final TagType tag, final BusinessObjectType bo, final Modifier<TagType, BusinessObjectType> modifier) {
		// Make a copy of the resource
		final EObject parsedAnnexElement = getParsedAnnexElement(defaultAnnexElement);
		final ResourceSet tmpResourceSet = new ResourceSetImpl();
		final Resource tmpResource = tmpResourceSet.createResource(resource.getURI());
		tmpResource.getContents().addAll(EcoreUtil.copyAll(resource.getContents()));

		// Clone the bo specified by the modfication
		final EObject parsedAnnexRootClone = tmpResourceSet.getEObject(EcoreUtil.getURI(parsedAnnexElement), false);
		final Deque<Integer> indexStack = getParsedAnnexRootIndices(bo);
		EObject tmpClonedObject = parsedAnnexRootClone;
		while(!indexStack.isEmpty()) {
			tmpClonedObject = tmpClonedObject.eContents().get(indexStack.pop());
		}

		@SuppressWarnings("unchecked")
		final BusinessObjectType clonedUserObject = (BusinessObjectType)tmpClonedObject;

		// Modify the annex by modifying the cloned object, unparsing, and then updating the source text of the original default annex element.
		return modifySafely(resource, tag, defaultAnnexElement, (unusedTag, defaultAnnexElement1) -> {
			// Modify the cloned object
			modifier.modify(tag, clonedUserObject);

			// Unparse the annex text of the cloned object and update the Xtext document
			if(parsedAnnexRootClone instanceof AnnexLibrary) {
				final DefaultAnnexLibrary defaultAnnexLibrary = (DefaultAnnexLibrary)defaultAnnexElement1;
				final String sourceTxt1 = "{**" + getAnnexUnparserRegistry().getAnnexUnparser(defaultAnnexLibrary.getName()).unparseAnnexLibrary((AnnexLibrary)parsedAnnexRootClone, "  ") + "**}";
				EcoreUtil.delete(defaultAnnexLibrary.getParsedAnnexLibrary());
				defaultAnnexLibrary.setSourceText(sourceTxt1);
			} else if(parsedAnnexRootClone instanceof AnnexSubclause) {
				final DefaultAnnexSubclause defaultAnnexSubclause = (DefaultAnnexSubclause)defaultAnnexElement1;
				final String sourceTxt2 = "{**" + getAnnexUnparserRegistry().getAnnexUnparser(defaultAnnexSubclause.getName()).unparseAnnexSubclause((AnnexSubclause)parsedAnnexRootClone, "  ") + "**}";
				EcoreUtil.delete(defaultAnnexSubclause.getParsedAnnexSubclause());
				defaultAnnexSubclause.setSourceText(sourceTxt2);
			} else {
				throw new RuntimeException("Unhandled case, parsedAnnexRoot is of type: " + parsedAnnexRootClone.getClass());
			}
		}, false);
	}

	private AnnexUnparserRegistry getAnnexUnparserRegistry() {
		return (AnnexUnparserRegistry)AnnexRegistry.getRegistry(AnnexRegistry.ANNEX_UNPARSER_EXT_ID);
	}

	private EObject getParsedAnnexElement(final EObject defaultAnnexObject) {
		if(defaultAnnexObject instanceof DefaultAnnexLibrary) {
			return ((DefaultAnnexLibrary) defaultAnnexObject).getParsedAnnexLibrary();
		} else if(defaultAnnexObject instanceof DefaultAnnexSubclause) {
			return ((DefaultAnnexSubclause) defaultAnnexObject).getParsedAnnexSubclause();
		} else {
			throw new RuntimeException("Unexpected type: " + defaultAnnexObject.getClass().getName());
		}
	}

	/**
	 * Finds the parsed AnnexLibrary or AnnexSubclause for a model object. Returns null if the object is not part of a parsed annex.
	 * Used to determine whether special handling for the object is necessary
	 */
	private EObject getParsedAnnexRoot(final EObject obj) {
		// If the object is a default annex library or subclause, then it is not part of a parsed annex
		if(obj instanceof DefaultAnnexLibrary || obj instanceof DefaultAnnexSubclause) {
			return null;
		}

		// Find the root of the parsed annex
		EObject tmp = obj;
		while(tmp != null && !(tmp instanceof AnnexLibrary || tmp instanceof AnnexSubclause)) {
			tmp = tmp.eContainer();
		}

		return tmp;
	}

	/**
	 * Return indices that indicate the location of an object within a parsed annex element.
	 * @param obj
	 * @return
	 */
	private Deque<Integer> getParsedAnnexRootIndices(final EObject obj) {
		assert !(obj instanceof DefaultAnnexLibrary || obj instanceof DefaultAnnexSubclause);

		final Deque<Integer> indices = new ArrayDeque<Integer>();

		// Find the root of the parsed annex
		EObject tmp = obj;
		while(tmp != null && !(tmp instanceof AnnexLibrary || tmp instanceof AnnexSubclause)) {

			final int newIndex = ECollections.indexOf(tmp.eContainer().eContents(), tmp, 0);
			if(newIndex == -1) {
				throw new RuntimeException("Unable to get index inside of container contents");
			}

			indices.push(newIndex);;
			tmp = tmp.eContainer();
		}

		return indices;
	}

	private static class ModificationResult {
		private ModificationResult(final boolean modificationSuccessful, final String rootQualifiedName,
				final URI resourceUri, final String originalTextContents) {
			this.modificationSuccessful = modificationSuccessful;
			this.rootQualifiedName = rootQualifiedName;
			this.resourceUri = resourceUri;
			this.originalTextContents = originalTextContents;
		}

		public static ModificationResult createSuccess(final String rootQualifiedName, final URI resourceUri,
				final String originalTextContents) {
			return new ModificationResult(true,
					Objects.requireNonNull(rootQualifiedName, "rootQualifiedName must not be null"),
					Objects.requireNonNull(resourceUri, "resourceUri must not be null"),
					Objects.requireNonNull(originalTextContents, "originalTextContents must not be null"));
		}

		public static ModificationResult createFailure() {
			return new ModificationResult(false, null, null, null);
		}

		public final boolean modificationSuccessful;
		public final String rootQualifiedName;
		public final URI resourceUri;
		public final String originalTextContents;
	}

	/**
	 * Class used to return the results of the modifySafely method
	 *
	 * @param <R>
	 */
	private static class ModifySafelyResults {
		private ModifySafelyResults(final boolean modificationSuccessful) {
			this.modificationSuccessful = modificationSuccessful;
		}


		public final boolean modificationSuccessful;
	}

	/**
	 * Modifies the resource. If changes causes a validation error, the changes are reverted.
	 * @param resource
	 * @param element
	 * @param modifier
	 * @param testSerialization
	 * @return
	 */
	private <TagType, BusinessObjectType extends EObject> ModifySafelyResults modifySafely(final XtextResource resource, final TagType tag, final BusinessObjectType element,
			final Modifier<TagType, BusinessObjectType> modifier, final boolean testSerialization) {
		if(resource.getContents().size() < 1) {
			return null;
		}

		final ResourceSet resourceSet = Objects.requireNonNull(resource.getResourceSet(),
				"Unable to retrieve resource set");
		final TransactionalEditingDomain domain = TransactionalEditingDomain.Factory.INSTANCE
				.getEditingDomain(resourceSet);

		boolean modificationSuccessful = false;

		final Command undoCommand;
		final RecordingCommand cmd;
		if (domain == null) {
			undoCommand = null;
			cmd = null;

			// Perform the modification without a transaction
			modifier.modify(tag, element);
		} else {
			// Make modification in a transaction
			undoCommand = domain.getCommandStack().getUndoCommand();
			cmd = new RecordingCommand(domain) {
				@Override
				protected void doExecute() {
					modifier.modify(tag, element);
				}
			};
			domain.getCommandStack().execute(cmd);
		}

		// Try to serialize the resource. In some cases serialization can fail and leave a corrupt model if we are editing without an xtext document
		// The real serialization will occur later.
		if (testSerialization) {
			final String serializedSrc = resource.getSerializer().serialize(resource.getContents().get(0));
			modificationSuccessful = serializedSrc != null && !serializedSrc.trim().isEmpty();

			if (!modificationSuccessful) {
				while (domain != null && domain.getCommandStack().canUndo()
						&& domain.getCommandStack().getUndoCommand() != undoCommand) {
					domain.getCommandStack().undo();
				}
			}
		} else {
			// Mark the modification as successful
			modificationSuccessful = true;
		}

		return new ModifySafelyResults(modificationSuccessful);
	}
}
