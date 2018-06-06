package org.osate.ge.internal.ui.handlers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.impl.DeleteContext;
import org.eclipse.graphiti.features.context.impl.MultiDeleteInfo;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.graphiti.diagram.GraphitiAgeDiagram;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;

public class DeleteHandler extends AbstractHandler {
	@Override
	public void setEnabled(final Object evaluationContext) {
		final boolean enabled = calculateEnabled(evaluationContext);
		setBaseEnabled(enabled);
	}

	private boolean calculateEnabled(final Object evaluationContext) {
		final IEditorPart activeEditor = AgeHandlerUtil.getActiveEditorFromContext(evaluationContext);
		if (!(activeEditor instanceof AgeDiagramEditor)) {
			return false;
		}

		final AgeDiagramEditor ageEditor = (AgeDiagramEditor) activeEditor;
		final GraphitiAgeDiagram graphitiAgeDiagram = ageEditor.getGraphitiAgeDiagram();
		if (graphitiAgeDiagram == null) {
			return false;
		}

		final List<DiagramElement> selectedDiagramElements = AgeHandlerUtil
				.getSelectedDiagramElementsFromContext(evaluationContext);
		if (selectedDiagramElements.size() == 0) {
			return false;
		}

		final IFeatureProvider fp = ageEditor.getDiagramTypeProvider().getFeatureProvider();
		if (fp == null) {
			return false;
		}

		for (final DiagramElement de : selectedDiagramElements) {
			final PictogramElement pe = graphitiAgeDiagram.getPictogramElement(de);
			if (pe == null) {
				return false;
			}

			final DeleteContext deleteContext = new DeleteContext(pe);
			final IDeleteFeature feature = fp.getDeleteFeature(deleteContext);
			if (feature == null) {
				return false;
			}

			if (!feature.canDelete(deleteContext)) {
				return false;
			}
		}

		return true;
	}

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);
		if (!(activeEditor instanceof AgeDiagramEditor)) {
			throw new RuntimeException("Unexpected editor: " + activeEditor);
		}

		// Get diagram and selected elements
		final List<DiagramElement> selectedDiagramElements = AgeHandlerUtil.getSelectedDiagramElements(event);
		if (selectedDiagramElements.size() == 0) {
			throw new RuntimeException("No element selected");
		}

		final AgeDiagramEditor ageEditor = (AgeDiagramEditor) activeEditor;
		final GraphitiAgeDiagram graphitiAgeDiagram = Objects.requireNonNull(ageEditor.getGraphitiAgeDiagram(),
				"Unable to retrieve graphiti diagram");

		final IFeatureProvider fp = Objects.requireNonNull(ageEditor.getDiagramTypeProvider().getFeatureProvider(),
				"Unable to retrieve feature provider");

		final Map<DeleteContext, IDeleteFeature> deleteContextToFeatureMap = new LinkedHashMap<>();
		for (final DiagramElement de : selectedDiagramElements) {
			final PictogramElement pe = Objects.requireNonNull(graphitiAgeDiagram.getPictogramElement(de),
					"Unable to retrieve pictogram element");
			final DeleteContext deleteContext = new DeleteContext(pe);
			final IDeleteFeature deleteFeature = fp.getDeleteFeature(deleteContext);

			if (selectedDiagramElements.size() > 1) {
				deleteContext
				.setMultiDeleteInfo(new MultiDeleteInfo(false, false, selectedDiagramElements.size()));
			}

			if (!deleteFeature.canDelete(deleteContext)) {
				throw new RuntimeException("Delete feature's canDelete() returned false");
			}

			deleteContextToFeatureMap.put(deleteContext, deleteFeature);
		}

		final Map.Entry<DeleteContext, IDeleteFeature> firstEntry = deleteContextToFeatureMap.entrySet().iterator()
				.next();
		if (firstEntry.getKey().getMultiDeleteInfo() != null) {
			firstEntry.getKey().getMultiDeleteInfo().setShowDialog(true);
		}

		for (final DeleteContext deleteContext : deleteContextToFeatureMap.keySet()) {
			final IDeleteFeature deleteFeature = deleteContextToFeatureMap.get(deleteContext);
			ageEditor.getDiagramBehavior().executeFeature(deleteFeature, deleteContext);
			if (deleteContext.getMultiDeleteInfo() != null && deleteContext.getMultiDeleteInfo().isDeleteCanceled()) {
				break;
			}
		}

		return null;
	}
}