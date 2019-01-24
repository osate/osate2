package org.osate.ui.dependencyvisualization;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osate.aadl2.Aadl2Package;

public class ModelUnitDependencyVisualizationView extends AbstractDependencyVisualizationView {
	public static final String ID = "org.osate.ui.modelunitdependencyvisualization";
	
	private final IAction showAllModelUnitsAction = new Action("Show All Packages and Property Sets in Workspace") {
		@Override
		public void run() {
			setScopeToWorkspace();
		}
	};

	private final IAction focusOnModelUnitAction = new Action() {
		public void run() {
			IEObjectDescription modelUnit = (IEObjectDescription) graph.getStructuredSelection().getFirstElement();
			input = ModelUnitVisualizationInput.create(getSite().getShell(), modelUnit.getEObjectURI());
			graph.setInput(input);
			String name = modelUnit.getName().toString("::");
			if (modelUnit.getEClass().equals(Aadl2Package.eINSTANCE.getAadlPackage())) {
				label.setText("Packages and Property Sets Connected to Package '" + name + "'");
			} else if (modelUnit.getEClass().equals(Aadl2Package.eINSTANCE.getPropertySet())) {
				label.setText("Packages and Property Sets Connected to Property Set '" + name + "'");
			}
		}
	};
	
	@Override
	protected void menuAboutToShow(IMenuManager manager) {
		manager.add(showAllModelUnitsAction);
		manager.add(new Separator());
		IStructuredSelection selection = graph.getStructuredSelection();
		if (selection.size() == 1) {
			Object selectedObject = selection.getFirstElement();
			if (selectedObject instanceof IEObjectDescription) {
				IEObjectDescription selectedModelUnit = (IEObjectDescription) selectedObject;
				String name = selectedModelUnit.getName().toString("::");
				focusOnModelUnitAction.setText("Show Packages and Property Sets Connected to '" + name + "'");
				manager.add(focusOnModelUnitAction);
			}
		}
	}
	
	@Override
	protected void setScopeToWorkspace() {
		input = ModelUnitVisualizationInput.create(getSite().getShell());
		graph.setInput(input);
		label.setText("All Packages and Property Sets in Workspace");
	}

	public void setScope(IWorkingSet workingSet) {
		input = ModelUnitVisualizationInput.create(getSite().getShell(), workingSet);
		graph.setInput(input);
		label.setText("Packages and Property Sets in Working Set '" + workingSet.getName() + "'");
	}

	public void setScope(IProject project) {
		input = ModelUnitVisualizationInput.create(getSite().getShell(), project);
		graph.setInput(input);
		label.setText("Packages and Property Sets in Project '" + project.getName() + "'");
	}
}