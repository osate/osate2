package org.osate.ge.internal.graphiti.features;

import java.text.MessageFormat;
import java.util.Objects;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.ICustomUndoRedoFeature;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IMultiDeleteInfo;
import org.eclipse.graphiti.features.impl.AbstractFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.osate.aadl2.NamedElement;
import org.osate.ge.EmfContainerProvider;
import org.osate.ge.di.CanDelete;
import org.osate.ge.di.Delete;
import org.osate.ge.di.Names;
import org.osate.ge.internal.di.DeleteRaw;
import org.osate.ge.internal.diagram.runtime.CanonicalBusinessObjectReference;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.graphiti.services.GraphitiService;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.util.AnnotationUtil;
import org.osate.ge.services.ReferenceBuilderService;

// IDeleteFeature implementation that delegates behavior to a business object handler
public class BoHandlerDeleteFeature extends AbstractFeature implements IDeleteFeature, ICustomUndoRedoFeature {
	private final GraphitiService graphitiService;
	private final ExtensionService extService;
	private final AadlModificationService aadlModService;
	private final ReferenceBuilderService refBuilder;

	@Inject
	public BoHandlerDeleteFeature(final GraphitiService graphitiService,
			final ExtensionService extService,
			final AadlModificationService aadlModService,
			final ReferenceBuilderService refBuilder,
			final IFeatureProvider fp) {
		super(fp);
		this.graphitiService = Objects.requireNonNull(graphitiService, "graphitiService must not be null");
		this.aadlModService = Objects.requireNonNull(aadlModService, "aadlModService must not be null");
		this.extService = Objects.requireNonNull(extService, "extService must not be null");
		this.refBuilder = Objects.requireNonNull(refBuilder, "refBuilder must not be null");
	}

	@Override
	public boolean canExecute(IContext context) {
		boolean ret = false;
		if (context instanceof IDeleteContext) {
			ret = canDelete((IDeleteContext) context);
		}
		return ret;
	}

	@Override
	public void execute(IContext context) {
		if (context instanceof IDeleteContext) {
			delete((IDeleteContext) context);
		}
	}

	@Override
	public void preDelete(IDeleteContext context) {
	}

	@Override
	public boolean isDeleteAbort() {
		return false;
	}

	@Override
	public void postDelete(IDeleteContext context) {
	}

	@Override
	public boolean canDelete(final IDeleteContext context) {
		final DiagramElement de = graphitiService.getGraphitiAgeDiagram()
				.getClosestDiagramElement(context.getPictogramElement());
		if(de == null) {
			return false;
		}

		final Object bo = de.getBusinessObject();

		final Object boHandler = de.getBusinessObjectHandler();
		if (boHandler == null) {
			return false;
		}

		if (!AnnotationUtil.hasMethodWithAnnotation(CanDelete.class, boHandler)) {
			return false;
		}

		// Don't allow proxies.
		if (bo instanceof EObject) {
			final EObject eobj = ((EObject) bo);
			if(eobj.eIsProxy()) {
				return false;
			}

			// Prevent deletion of resources which are part of plugins
			final Resource res = eobj.eResource();
			if (res != null && res.getURI().isPlatformPlugin()) {
				return false;
			}
		}

		final IEclipseContext childCtx = extService.createChildContext();
		try {
			childCtx.set(Names.BUSINESS_OBJECT, bo);
			childCtx.set(Names.BUSINESS_OBJECT_CONTEXT, de);
			return (boolean) ContextInjectionFactory.invoke(boHandler, CanDelete.class, childCtx, false);
		} finally {
			childCtx.dispose();
		}
	}

	@Override
	public void delete(final IDeleteContext context) {
		if(!confirmDelete(context)) {
			return;
		}

		// Remove the EObject from the model
		final DiagramElement de = graphitiService.getGraphitiAgeDiagram()
				.getClosestDiagramElement(context.getPictogramElement());
		final Object bo = de.getBusinessObject();

		final CanonicalBusinessObjectReference diagramContextRef = graphitiService.getGraphitiAgeDiagram()
				.getAgeDiagram().getConfiguration().getContextBoReference();
		final CanonicalBusinessObjectReference boRef = refBuilder.getCanonicalReference(bo);
		final boolean boIsContext = boRef != null && boRef.equals(diagramContextRef);

		final Object boHandler = de.getBusinessObjectHandler();
		if (AnnotationUtil.hasMethodWithAnnotation(DeleteRaw.class, boHandler)) {
			// Call raw delete method
			final IEclipseContext eclipseCtx = extService.createChildContext();
			try {
				eclipseCtx.set(Names.BUSINESS_OBJECT, bo);
				ContextInjectionFactory.invoke(boHandler, DeleteRaw.class, eclipseCtx);
			} finally {
				eclipseCtx.dispose();
			}
		} else if (bo instanceof EObject) {
			final EObject boEObj = (EObject) bo;
			aadlModService.modify(boEObj, (boToModify) -> {
				EcoreUtil.remove(boToModify);
			});
		} else if (bo instanceof EmfContainerProvider) {
			final EObject ownerBo = ((EmfContainerProvider) bo).getEmfContainer();
			aadlModService.modify(ownerBo, (boToModify) -> {
				// Call delete
				final IEclipseContext eclipseCtx = extService.createChildContext();
				try {
					eclipseCtx.set(Names.BUSINESS_OBJECT, bo);
					eclipseCtx.set(Names.MODIFY_BO, boToModify);
					ContextInjectionFactory.invoke(boHandler, Delete.class, eclipseCtx);
				} finally {
					eclipseCtx.dispose();
				}
			});
		} else {
			// canDelete() should have returned false in this case
			throw new RuntimeException("Unhandled case: " + bo);
		}

		if(boIsContext) {
			// Close the editor if the context was deleted
			Display.getDefault().asyncExec(() -> graphitiService.getEditor().close());
		} else {
			// Clear selection
			getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior().getDiagramContainer().selectPictogramElements(new PictogramElement[0]);
		}
	}

	private boolean confirmDelete(final IDeleteContext context) {
		final IMultiDeleteInfo multiDeleteInfo = context.getMultiDeleteInfo();
		if(multiDeleteInfo == null) {
			final Object bo = getFeatureProvider().getBusinessObjectForPictogramElement(context.getPictogramElement());
			if(bo == null) {
				return false;
			}

			final String elementName = (bo instanceof NamedElement) ? ((NamedElement) bo).getQualifiedName() : null;
			final String msg = (elementName != null)
					? MessageFormat.format("Are you sure you want to delete ''{0}''?", elementName)
							: "Are you sure you want to delete this element?";
					if(!MessageDialog.openQuestion(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Confirm Delete", msg)) {
						return false;
					}
		} else {
			if(multiDeleteInfo.isDeleteCanceled()) {
				return false;
			}

			if(multiDeleteInfo.isShowDialog()) {
				final String msg = MessageFormat.format("Are you sure you want to delete {0} elements?", multiDeleteInfo.getNumber());
				if(!MessageDialog.openQuestion(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Confirm Delete", msg)) {
					multiDeleteInfo.setDeleteCanceled(true);
					return false;
				}
				multiDeleteInfo.setShowDialog(false);
			}
		}

		return true;
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
