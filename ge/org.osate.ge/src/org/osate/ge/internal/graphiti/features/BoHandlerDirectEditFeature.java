package org.osate.ge.internal.graphiti.features;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.inject.Inject;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.ICustomUndoRedoFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.impl.AbstractDirectEditingFeature;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.window.Window;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.ProcessorBasedRefactoring;
import org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor;
import org.eclipse.ltk.ui.refactoring.RefactoringUI;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.refactoring.IRenameRefactoringProvider;
import org.eclipse.xtext.ui.refactoring.impl.AbstractRenameProcessor;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.NamedElement;
import org.osate.ge.di.CanRename;
import org.osate.ge.di.GetNameForEditing;
import org.osate.ge.di.Names;
import org.osate.ge.di.Rename;
import org.osate.ge.di.ValidateName;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.diagram.runtime.CanonicalBusinessObjectReference;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;
import org.osate.ge.internal.graphiti.ShapeNames;
import org.osate.ge.internal.graphiti.diagram.PropertyUtil;
import org.osate.ge.internal.graphiti.services.GraphitiService;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.DiagramService;
import org.osate.ge.internal.services.DiagramService.ReferenceCollection;
import org.osate.ge.internal.services.DiagramService.UpdatedReferenceValueProvider;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.ModelChangeNotifier;
import org.osate.ge.internal.services.ModelChangeNotifier.Lock;
import org.osate.ge.internal.util.AnnotationUtil;
import org.osate.ge.internal.util.ProjectUtil;
import org.osate.ge.services.ReferenceBuilderService;

// Direct Editing Feature implementation that uses Xtext/LTK refactoring to rename an element.
// Uses businesss Object Handlers to determine if an element can be renamed.
// Only supports NamedElement objects.
@SuppressWarnings("restriction")
public class BoHandlerDirectEditFeature extends AbstractDirectEditingFeature implements ICustomUndoRedoFeature {
	// Property for the context to specify whether the feature should require the specified pictogram element to be the primary label. Defaults to true.
	public static final String PROPERTY_REQUIRE_PRIMARY_LABEL = "org.osate.ge.require_primary_label";

	private final GraphitiService graphitiService;
	private final ExtensionService extService;
	private final AadlModificationService aadlModService;
	private final DiagramService diagramService;
	private final ReferenceBuilderService referenceBuilderService;
	private final ModelChangeNotifier modelChangeNotifier;

	@Inject
	public BoHandlerDirectEditFeature(final IFeatureProvider fp,
			final GraphitiService graphitiService,
			final ExtensionService extService, final AadlModificationService aadlModService,
			final DiagramService diagramService, final ReferenceBuilderService referenceBuilderService,
			final ModelChangeNotifier modelChangeNotifier) {
		super(fp);
		this.graphitiService = Objects.requireNonNull(graphitiService, "graphitiService must not be null");
		this.extService = Objects.requireNonNull(extService, "extService must not be null");
		this.aadlModService = Objects.requireNonNull(aadlModService, "aadlModService must not be null");
		this.diagramService = Objects.requireNonNull(diagramService, "diagramService must not be null");
		this.referenceBuilderService = Objects.requireNonNull(referenceBuilderService,
				"referenceBuilderService must not be null");
		this.modelChangeNotifier = Objects.requireNonNull(modelChangeNotifier, "modelChangeNotifier must not be null");
	}

	@Override
	public boolean canDirectEdit(final IDirectEditingContext context) {
		final DiagramElement de = graphitiService.getGraphitiAgeDiagram().getClosestDiagramElement(context.getPictogramElement());
		if(de == null) {
			return false;
		}

		final Object bo = de.getBusinessObject();

		// Only EObjects are supported at this time
		if (!(bo instanceof EObject)) {
			return false;
		}

		final Object handler = de.getBusinessObjectHandler();
		if(!AnnotationUtil.hasMethodWithAnnotation(ValidateName.class, handler)) {
			return false;
		}

		if (!AnnotationUtil.hasMethodWithAnnotation(Rename.class, handler) && getRenameRefactoring(bo) == null) {
			return false;
		}

		// Ensure that the specified pictogram elmenet is a primary label unless the context contains a property specifying otherwise.
		if (!Boolean.FALSE.equals(context.getProperty(PROPERTY_REQUIRE_PRIMARY_LABEL))) {
			if (!ShapeNames.primaryLabelShapeName.equals(PropertyUtil.getName(context.getPictogramElement()))) {
				return false;
			}
		}

		final IEclipseContext childCtx = extService.createChildContext();
		boolean canRename = true;
		try {
			childCtx.set(Names.BUSINESS_OBJECT, bo);
			childCtx.set(Names.BUSINESS_OBJECT_CONTEXT, de);
			canRename = (boolean)ContextInjectionFactory.invoke(handler, CanRename.class, childCtx, true);
			if(!canRename) {
				return false;
			}
		} finally {
			childCtx.dispose();
		}

		return true;
	}

	@Override
	public int getEditingType() {
		return TYPE_TEXT;
	}

	@Override
	public boolean stretchFieldToFitText() {
		return true;
	}

	@Override
	public String checkValueValid(final String value, final IDirectEditingContext context) {
		final DiagramElement de = graphitiService.getGraphitiAgeDiagram().getClosestDiagramElement(context.getPictogramElement());
		if(de == null) {
			return "Unable to get diagram element.";
		}

		final Object bo = de.getBusinessObject();
		final Object handler = de.getBusinessObjectHandler();
		final IEclipseContext childCtx = extService.createChildContext();
		try {
			childCtx.set(Names.BUSINESS_OBJECT, bo);
			childCtx.set(Names.NAME, value);
			childCtx.set(InternalNames.PROJECT, graphitiService.getProject());
			return (String)ContextInjectionFactory.invoke(handler, ValidateName.class, childCtx, null);
		} finally {
			childCtx.dispose();
		}
	}

	@Override
	public String getInitialValue(final IDirectEditingContext context) {
		final DiagramElement de = graphitiService.getGraphitiAgeDiagram().getClosestDiagramElement(context.getPictogramElement());
		final Object bo = de.getBusinessObject();
		final Object handler = de.getBusinessObjectHandler();

		// Attempt to use the value provided by the method annotated with GetNameForEditing first
		final IEclipseContext childCtx = extService.createChildContext();
		try {
			childCtx.set(Names.BUSINESS_OBJECT, bo);
			childCtx.set(Names.BUSINESS_OBJECT_CONTEXT, de);
			String result = (String)ContextInjectionFactory.invoke(handler, GetNameForEditing.class, childCtx, null);
			if(result != null) {
				return result;
			}
		} finally {
			childCtx.dispose();
		}

		// Otherwise, use the element name
		return de.getName();
	}

	@Override
	public void setValue(final String value, final IDirectEditingContext context) {
		final DiagramElement de = graphitiService.getGraphitiAgeDiagram().getClosestDiagramElement(context.getPictogramElement());
		final EObject bo = (EObject) de.getBusinessObject();
		final Object handler = de.getBusinessObjectHandler();

		// If the business object handler provides a Rename method, then use it to rename the element instead of using LTK refactoring.
		if (AnnotationUtil.hasMethodWithAnnotation(Rename.class, handler)) {
			final CanonicalBusinessObjectReference canonicalRef = referenceBuilderService
					.getCanonicalReference(bo); // TOOD: Rename
			final IProject project = ProjectUtil.getProject(EcoreUtil.getURI(bo));
			final ReferenceCollection references;
			if (canonicalRef == null || project == null) {
				references = null;
			} else {
				final Set<IProject> relevantProjects = ProjectUtil.getAffectedProjects(project, new HashSet<>());
				references = diagramService.getReferences(relevantProjects,
						Collections.singleton(canonicalRef));
			}

			aadlModService.modify(bo, (boToModify) -> {
				final IEclipseContext childCtx = extService.createChildContext();
				try {
					childCtx.set(Names.BUSINESS_OBJECT, boToModify);
					childCtx.set(Names.NAME, value);
					ContextInjectionFactory.invoke(handler, Rename.class, childCtx);
				} finally {
					childCtx.dispose();
				}

				// Update diagram references. This is done in the modify block because the project is build and the diagram is updated before the modify()
				// function returns.
				final CanonicalBusinessObjectReference newCanonicalRef = referenceBuilderService
						.getCanonicalReference(boToModify);
				final RelativeBusinessObjectReference newRelRef = referenceBuilderService
						.getRelativeReference(boToModify);

				if (newCanonicalRef != null && newRelRef != null) {
					references.update(new UpdatedReferenceValueProvider() {
						@Override
						public CanonicalBusinessObjectReference getNewCanonicalReference(
								final CanonicalBusinessObjectReference originalCanonicalReference) {
							if (originalCanonicalReference.equals(canonicalRef)) {
								return newCanonicalRef;
							}

							return null;
						}

						@Override
						public RelativeBusinessObjectReference getNewRelativeReference(
								final CanonicalBusinessObjectReference originalCanonicalReference) {
							if (originalCanonicalReference.equals(canonicalRef)) {
								return newRelRef;
							}

							return null;
						}
					});
				}
			});

		} else { // Rename using LTK
			// TODO: Remove when issue regarding Xtext Dirty State has been resolved.
			// https://github.com/osate/osate-ge/issues/210
			// This works around the issue by saving the resource before trying to refactor.
			if (bo instanceof EObject) {
				final EObject eObj = bo;
				if (eObj.eResource() != null) {
					// Get the IResource for the current BO
					final IResource boRes = ResourcesPlugin.getWorkspace().getRoot()
							.getFile(new Path(eObj.eResource().getURI().toPlatformString(true)));

					// Find and save the edit part
					if (boRes != null && PlatformUI.getWorkbench() != null) {
						for (final IWorkbenchWindow window : PlatformUI.getWorkbench().getWorkbenchWindows()) {
							for (final IWorkbenchPage page : window.getPages()) {
								for (final IEditorReference editorRef : page.getEditorReferences()) {
									if (editorRef.isDirty()) {
										final IEditorPart editorPart = editorRef.getEditor(false);
										if (editorPart instanceof XtextEditor) {
											final IResource editorRes = ((XtextEditor) editorPart).getResource();
											if (boRes.equals(editorRes)) {
												page.saveEditor(editorPart, false);
											}
										}
									}
								}
							}
						}
					}
				}
			}

			// Rename the element using LTK
			final ProcessorBasedRefactoring renameRefactoring = getRenameRefactoring(bo);
			final RefactoringStatus refactoringStatus = prepareAndCheck(renameRefactoring, value);
			if (!refactoringStatus.isOK()) {
				final Dialog dlg = RefactoringUI.createRefactoringStatusDialog(refactoringStatus,
						Display.getCurrent().getActiveShell(), "Refactoring", false);
				if (dlg.open() != Window.OK) {
					// Abort
					return;
				}
			}

			try {
				final Change change = renameRefactoring.createChange(new NullProgressMonitor());
				new WorkspaceModifyOperation() {
					@Override
					protected void execute(IProgressMonitor monitor)
							throws CoreException, InvocationTargetException, InterruptedException {
						// Prevent model notification changes from being sent until after the refactoring
						try (Lock lock = modelChangeNotifier.lock()) {
							// Perform the modification
							change.perform(monitor);

							// Build the project to prevent reference resolver from using old objects.
							try {
								graphitiService.getProject().build(IncrementalProjectBuilder.INCREMENTAL_BUILD,
										new NullProgressMonitor());
							} catch (CoreException e) {
								// Ignore any errors that occur while building the project
								e.printStackTrace();
							}
						}
					}
				}.run(null);
			} catch (final Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	private static ProcessorBasedRefactoring getRenameRefactoring(final Object bo) {
		if (!(bo instanceof NamedElement)) {
			return null;
		}

		final EObject eObjBo = (EObject)bo;
		if(!(eObjBo.eResource() instanceof XtextResource)) {
			return null;
		}

		final XtextResource res = (XtextResource)eObjBo.eResource();
		final IResourceServiceProvider resourceServiceProvider = res.getResourceServiceProvider();
		if(resourceServiceProvider == null) {
			return null;
		}

		final IRenameRefactoringProvider renameRefactoringProvider = resourceServiceProvider.get(IRenameRefactoringProvider.class);
		if(renameRefactoringProvider == null) {
			return null;
		}

		final URI boUri = EcoreUtil.getURI(eObjBo);
		if(boUri == null) {
			return null;
		}

		return renameRefactoringProvider.getRenameRefactoring(new IRenameElementContext.Impl(boUri, Aadl2Package.eINSTANCE.getNamedElement()));
	}

	/**
	 * Sets the new name of the refactoring's processor. Check arguments and initial conditions. Returns true if rename can proceed.
	 * @param refactoring
	 * @param newName
	 * @return
	 */
	private static RefactoringStatus prepareAndCheck(final ProcessorBasedRefactoring refactoring, final String newName) {
		try {
			if(refactoring == null) {
				return RefactoringStatus.createFatalErrorStatus("Refactoring is null");
			}

			final RefactoringProcessor refactoringProcessor = refactoring.getProcessor();
			if(!(refactoringProcessor instanceof AbstractRenameProcessor)) {
				return RefactoringStatus.createFatalErrorStatus("refactoringProcessor is not an AbstractRenameProcessor");
			}

			// Set the name
			((AbstractRenameProcessor)refactoringProcessor).setNewName(newName);

			final RefactoringStatus initialStatus = refactoring.checkInitialConditions(new NullProgressMonitor());
			if(!initialStatus.isOK()) {
				return initialStatus;
			}

			final RefactoringStatus finalStatus = refactoring.checkFinalConditions(new NullProgressMonitor());
			if(!finalStatus.isOK()) {
				return finalStatus;
			}
		} catch(final CoreException ex) {
			return RefactoringStatus.create(ex.getStatus());
		}

		return new RefactoringStatus();
	}

	// ICustomUndoRedoFeature
	@Override
	public boolean canUndo(final IContext context) {
		return false;
	}

	@Override
	public void preUndo(IContext context) {
	}

	@Override
	public void postUndo(IContext context) {
	}

	@Override
	public boolean canRedo(IContext context) {
		return false;
	}

	@Override
	public void preRedo(IContext context) {
	}

	@Override
	public void postRedo(IContext context) {
	}
}
