package org.osate.ge.internal.services.impl;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
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
import org.osate.ge.internal.services.ModelChangeNotifier;
import org.osate.ge.internal.services.ModelChangeNotifier.Lock;
import org.osate.ge.internal.ui.xtext.AgeXtextUtil;
import org.osate.ge.internal.util.Log;

public class DefaultAadlModificationService implements AadlModificationService {
	public static class ContextFunction extends SimpleServiceContextFunction<AadlModificationService> {
		@Override
		public AadlModificationService createService(final IEclipseContext context) {
			return new DefaultAadlModificationService(context.get(ModelChangeNotifier.class));
		}
	}

	final ModelChangeNotifier modelChangeNotifier;

	public DefaultAadlModificationService(final ModelChangeNotifier modelChangeNotifier) {
		this.modelChangeNotifier = Objects.requireNonNull(modelChangeNotifier,
				"modelChangeNotifier must not be null");
	}

	@Override
	public void modify(final List<? extends Modification<?, ?>> modifications,
			final ModificationPostprocessor postProcessor) {
		class ModifyRunnable implements Runnable {
			@Override
			public void run() {
				try (Lock lock = modelChangeNotifier.lock()) {
					boolean allSuccessful = performModifications(modifications);

					if (postProcessor != null) {
						postProcessor.modificationCompleted(allSuccessful);
					}
				}
			}
		}

		// We want to run the modification in the display thread. Executing in the display thread will allow the diagram editor updates to be ran synchronously
		final ModifyRunnable modifyRunnable = new ModifyRunnable();
		if (Display.getDefault().getThread() == Thread.currentThread()) {
			try {
				modifyRunnable.run();
			} catch (RuntimeException ex) {
				final Status status = new Status(IStatus.ERROR, Activator.getPluginId(),
						"An error occured modifying the AADL model.", ex);
				StatusManager.getManager().handle(status, StatusManager.SHOW | StatusManager.LOG);
				throw ex; // Rethrow exception to let caller know that there was a problem.
			}
		} else {
			Log.info("Executing modification after switching to display thread");
			Display.getDefault().syncExec(modifyRunnable);
		}
	}

	// Assumes that the modification notifier is already locked
	private boolean performModifications(final List<? extends Modification<?, ?>> modifiers) {
		final Set<IProject> projectsToBuild = new HashSet<>();

		boolean allSuccessful = true;

		// Iterate over the input objects
		for (final Modification<?, ?> modification : modifiers) {
			final ModifySafelyResults modifySafelyResult = performModification(modification, projectsToBuild);
			allSuccessful = modifySafelyResult.modificationSuccessful;

			if (!allSuccessful) {
				break;
			}
		}

		// Build projects before unlocking. This will cause the post build notifications to be sent out before the lock is released.
		// This is desired to avoid multiple diagram updates for the same change.
		for (final IProject project : projectsToBuild) {
			try {
				project.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, new NullProgressMonitor());
			} catch (CoreException e) {
				// Ignore any errors that occur while building the project
				e.printStackTrace();
			}
		}

		return allSuccessful;
	}

	private <TagType, BusinessObjectType extends EObject> ModifySafelyResults performModification(
			final Modification<TagType, BusinessObjectType> modification, final Set<IProject> projectsToBuild) {
		final TagType tag = modification.getTag();

		// Determine the object to modify
		final BusinessObjectType bo = modification.getTagToBusinessObjectMapper().apply(tag);
		if (bo == null) {
			return new ModifySafelyResults(false);
		}

		if (!(bo.eResource() instanceof XtextResource)) {
			throw new RuntimeException("Unexpected case. Resource is not an XtextResource");
		}

		// Try to get the Xtext document
		final Object root = bo.eResource() == null ? null : bo.eResource().getContents().get(0);
		final IXtextDocument doc = AgeXtextUtil
				.getDocumentByRootElement(root instanceof NamedElement ? (NamedElement) root : null);
		final ModifySafelyResults modifySafelyResult;
		if (doc == null) {
			// Modify the EMF resource directly
			final XtextResource res = (XtextResource) bo.eResource();
			modifySafelyResult = modifySafely(res, tag, bo, modification.getModifier(),
					true);

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
			// TODO: Remove when issue regarding Xtext Dirty State has been resolved.
			// https://github.com/osate/osate-ge/issues/210
			// This works around the issue by getting the xtext editor and calling doVerify() on it's dirty state editor support which starts
			// managing
			// the dirty state.
			for (final IEditorReference editorRef : PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getActivePage().getEditorReferences()) {
				final IEditorPart editor = editorRef.getEditor(false);
				if (editor instanceof XtextEditor) {
					final XtextEditor xtextEditor = (XtextEditor) editor;
					if (xtextEditor.getDocument() == doc) {
						xtextEditor.getDirtyStateEditorSupport().doVerify();
						break;
					}
				}
			}

			// If the element is in an annex, determine the root actual/parsed annex element
			final EObject parsedAnnexRoot = getParsedAnnexRoot(bo);

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
				// model.
				// If modify() has been called in the display thread, then the diagram should be updated by the diagram editor as well
				doc.readOnly(res -> null);
			}
		}

		return modifySafelyResult;
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


	/**
	 * Class used to return the results of the modifySafely method
	 *
	 * @param <R>
	 */
	private static class ModifySafelyResults {
		public ModifySafelyResults(final boolean modificationSuccessful) {
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
		TransactionalEditingDomain domain = null;

		boolean modificationSuccessful = false;
		domain = TransactionalEditingDomain.Factory.INSTANCE.getEditingDomain(resourceSet);

		final Command undoCommand = domain == null ? null : domain.getCommandStack().getUndoCommand();
		if (domain == null) {
			// Perform the modification without a transaction
			modifier.modify(tag, element);
		} else {
			// Make modification in a transaction
			final RecordingCommand cmd = new RecordingCommand(domain) {
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
