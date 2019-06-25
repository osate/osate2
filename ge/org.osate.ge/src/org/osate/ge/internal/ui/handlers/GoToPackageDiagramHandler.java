package org.osate.ge.internal.ui.handlers;

import java.util.List;
import java.util.Objects;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Element;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.EmfContainerProvider;
import org.osate.ge.internal.services.DiagramService;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;
import org.osate.ge.internal.util.ProjectUtil;

public class GoToPackageDiagramHandler extends AbstractHandler {
	@Override
	public void setEnabled(final Object evaluationContext) {
		boolean enabled = false;
		final List<BusinessObjectContext> selectedBusinessObjectContexts = AgeHandlerUtil
				.getSelectedBusinessObjectContexts();
		if (selectedBusinessObjectContexts.size() == 1) {
			final Object selectedBo = selectedBusinessObjectContexts.get(0).getBusinessObject();
			if (!(selectedBo instanceof AadlPackage)) {
				final AadlPackage pkg = getPackage(selectedBo);
				enabled = pkg != null && ProjectUtil.getProjectForBo(pkg).isPresent();
			}
		}

		setBaseEnabled(enabled);
	}

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);
		if (!(activeEditor instanceof AgeDiagramEditor)) {
			throw new RuntimeException("Unexpected editor: " + activeEditor);
		}

		// Get diagram and selected BOCs
		final List<BusinessObjectContext> selectedBusinessObjectContexts = AgeHandlerUtil
				.getSelectedBusinessObjectContexts();
		if (selectedBusinessObjectContexts.size() == 0) {
			throw new RuntimeException("No element selected");
		}

		final Object bo = selectedBusinessObjectContexts.get(0).getBusinessObject();

		final DiagramService diagramService = Objects.requireNonNull(Adapters.adapt(activeEditor, DiagramService.class),
				"Unable to retrieve diagram service");

		final AadlPackage pkg = Objects.requireNonNull(getPackage(bo), "Unable to retrieve package");
		diagramService.openOrCreateDiagramForBusinessObject(pkg);

		return null;
	}

	private AadlPackage getPackage(Object bo) {
		if (bo instanceof EmfContainerProvider) {
			bo = ((EmfContainerProvider) bo).getEmfContainer();
		}

		return bo instanceof Element && ((Element) bo).getElementRoot() instanceof AadlPackage
				? (AadlPackage) ((Element) bo).getElementRoot()
						: null;
	}
}
