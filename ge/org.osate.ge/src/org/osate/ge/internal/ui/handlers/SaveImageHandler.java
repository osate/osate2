package org.osate.ge.internal.ui.handlers;

import java.util.Objects;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.ISaveImageFeature;
import org.eclipse.graphiti.features.context.ISaveImageContext;
import org.eclipse.graphiti.features.context.impl.SaveImageContext;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.ge.internal.graphiti.diagram.GraphitiAgeDiagram;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;

public class SaveImageHandler extends AbstractHandler {
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

		final IFeatureProvider fp = ageEditor.getDiagramTypeProvider().getFeatureProvider();
		if (fp == null) {
			return false;
		}

		final ISaveImageFeature feature = fp.getSaveImageFeature();
		if (feature == null) {
			return false;
		}

		return feature.canSave(createSaveImageContext());
	}

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);
		if (!(activeEditor instanceof AgeDiagramEditor)) {
			throw new RuntimeException("Unexpected editor: " + activeEditor);
		}

		final AgeDiagramEditor ageEditor = (AgeDiagramEditor) activeEditor;

		final IFeatureProvider fp = Objects.requireNonNull(ageEditor.getDiagramTypeProvider().getFeatureProvider(),
				"Unable to retrieve feature provider");

		final ISaveImageFeature feature = Objects.requireNonNull(fp.getSaveImageFeature(),
				"Unable to retrieve save image feature");

		final ISaveImageContext ctx = createSaveImageContext();
		if (!feature.canSave(ctx)) {
			throw new RuntimeException("Save image feature's canSave() returned false");
		}

		feature.execute(ctx);

		return null;
	}

	private ISaveImageContext createSaveImageContext() {
		SaveImageContext context = new SaveImageContext();
		return context;
	}
}