package org.osate.ui.dependencyvisualization;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.layout.PixelConverter;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.IWorkingSetManager;
import org.eclipse.ui.PlatformUI;
import org.osate.ui.OsateUiPlugin;

public class ProjectDependencyVisualizationView extends AbstractDependencyVisualizationView {
	public static final String ID = "org.osate.ui.projectdependencyvisualization";

	private final Image projectImage = OsateUiPlugin.getImageDescriptor("icons/project.png").createImage();

	private Button workspaceButton;
	private Button workingSetButton;
	private ComboViewer workingSetCombo;
	private Button projectButton;
	private ComboViewer projectCombo;

	private final IAction showAllProjectsAction = new Action("Show All Projects in Workspace") {
		@Override
		public void run() {
			setScopeToWorkspace();
		}
	};

	private final IAction focusOnProjectAction = new Action() {
		@Override
		public void run() {
			setScope((IProject) getGraphSelection().getFirstElement());
		}
	};

	private final ISelectionChangedListener workingSetComboListener = event -> {
		setInput(new ProjectVisualizationInput((IWorkingSet) event.getStructuredSelection().getFirstElement()));
	};

	private final ISelectionChangedListener projectComboListener = event -> {
		setInput(new ProjectVisualizationInput((IProject) event.getStructuredSelection().getFirstElement()));
	};

	private final IPropertyChangeListener workingSetListener = event -> {
		if (event.getProperty().contentEquals(IWorkingSetManager.CHANGE_WORKING_SET_ADD)
				|| event.getProperty().contentEquals(IWorkingSetManager.CHANGE_WORKING_SET_REMOVE)
				|| event.getProperty().contentEquals(IWorkingSetManager.CHANGE_WORKING_SET_NAME_CHANGE)) {
			getSite().getShell().getDisplay().asyncExec(() -> {
				IWorkingSet selected = (IWorkingSet) workingSetCombo.getStructuredSelection().getFirstElement();
				workingSetCombo.setInput(PlatformUI.getWorkbench().getWorkingSetManager().getWorkingSets());
				if (selected != null) {
					workingSetCombo.removeSelectionChangedListener(workingSetComboListener);
					workingSetCombo.setSelection(new StructuredSelection(selected));
					workingSetCombo.addSelectionChangedListener(workingSetComboListener);
				}
			});
		}
	};

	private final IResourceChangeListener resourceListener = event -> {
		getSite().getShell().getDisplay().asyncExec(() -> {
			IProject selected = (IProject) projectCombo.getStructuredSelection().getFirstElement();
			projectCombo.setInput(Arrays.stream(ResourcesPlugin.getWorkspace().getRoot().getProjects())
					.filter(IProject::isOpen).collect(Collectors.toList()));
			if (selected != null) {
				projectCombo.removeSelectionChangedListener(projectComboListener);
				projectCombo.setSelection(new StructuredSelection(selected));
				projectCombo.addSelectionChangedListener(projectComboListener);
			}
		});
	};

	@Override
	public void dispose() {
		super.dispose();
		projectImage.dispose();
		PlatformUI.getWorkbench().getWorkingSetManager().removePropertyChangeListener(workingSetListener);
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(resourceListener);
	}

	@Override
	protected void menuAboutToShow(IMenuManager manager) {
		manager.add(showAllProjectsAction);
		manager.add(new Separator());
		IStructuredSelection selection = getGraphSelection();
		if (selection.size() == 1) {
			Object selectedObject = selection.getFirstElement();
			if (selectedObject instanceof IProject) {
				IProject selectedProject = (IProject) selectedObject;
				focusOnProjectAction.setText("Show Projects Connected to '" + selectedProject.getName() + "'");
				manager.add(focusOnProjectAction);
			}
		}
	}

	@Override
	protected void fillControlComposite(Composite parent) {
		parent.setLayout(new GridLayout(2, false));

		workspaceButton = new Button(parent, SWT.RADIO);
		workspaceButton.setText("Workspace");
		workspaceButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		workspaceButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (workspaceButton.getSelection()) {
					workingSetCombo.getCombo().setEnabled(false);
					projectCombo.getCombo().setEnabled(false);
					setInput(new ProjectVisualizationInput());
				}
			}
		});

		workingSetButton = new Button(parent, SWT.RADIO);
		workingSetButton.setText("Working Set:");
		workingSetButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		workingSetButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (workingSetButton.getSelection()) {
					workingSetCombo.getCombo().setEnabled(true);
					projectCombo.getCombo().setEnabled(false);
					IStructuredSelection comboSelection = workingSetCombo.getStructuredSelection();
					if (comboSelection.isEmpty()) {
						setInput(IVisualizationInput.EMPTY);
					} else {
						setInput(new ProjectVisualizationInput((IWorkingSet) comboSelection.getFirstElement()));
					}
				}
			}
		});

		workingSetCombo = new ComboViewer(parent);
		int comboWidth = new PixelConverter(workingSetCombo.getCombo()).convertWidthInCharsToPixels(20);
		GridData workingSetComboGridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
		workingSetComboGridData.widthHint = comboWidth;
		workingSetCombo.getCombo().setLayoutData(workingSetComboGridData);
		workingSetCombo.setContentProvider(ArrayContentProvider.getInstance());
		workingSetCombo.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return ((IWorkingSet) element).getName();
			}
		});
		workingSetCombo.setInput(PlatformUI.getWorkbench().getWorkingSetManager().getWorkingSets());
		workingSetCombo.addSelectionChangedListener(workingSetComboListener);

		projectButton = new Button(parent, SWT.RADIO);
		projectButton.setText("Project:");
		projectButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		projectButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (projectButton.getSelection()) {
					workingSetCombo.getCombo().setEnabled(false);
					projectCombo.getCombo().setEnabled(true);
					IStructuredSelection comboSelection = projectCombo.getStructuredSelection();
					if (comboSelection.isEmpty()) {
						setInput(IVisualizationInput.EMPTY);
					} else {
						setInput(new ProjectVisualizationInput((IProject) comboSelection.getFirstElement()));
					}
				}
			}
		});

		projectCombo = new ComboViewer(parent);
		GridData projectComboGridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
		projectComboGridData.widthHint = comboWidth;
		projectCombo.getCombo().setLayoutData(projectComboGridData);
		projectCombo.setContentProvider(ArrayContentProvider.getInstance());
		projectCombo.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return ((IProject) element).getName();
			}
		});
		projectCombo.setInput(Arrays.stream(ResourcesPlugin.getWorkspace().getRoot().getProjects())
				.filter(IProject::isOpen).collect(Collectors.toList()));
		projectCombo.addSelectionChangedListener(projectComboListener);

		PlatformUI.getWorkbench().getWorkingSetManager().addPropertyChangeListener(workingSetListener);
		ResourcesPlugin.getWorkspace().addResourceChangeListener(resourceListener, IResourceChangeEvent.POST_CHANGE);
	}

	@Override
	protected Image getImage(Object element) {
		if (element instanceof IProject) {
			return projectImage;
		} else {
			return null;
		}
	}

	@Override
	protected String getText(Object element) {
		if (element instanceof IProject) {
			return ((IProject) element).getName();
		} else {
			return null;
		}
	}

	@Override
	protected void refresh() {
		if (workspaceButton.getSelection()) {
			setInput(new ProjectVisualizationInput());
		} else if (workingSetButton.getSelection()) {
			IStructuredSelection comboSelection = workingSetCombo.getStructuredSelection();
			if (comboSelection.isEmpty()) {
				setInput(IVisualizationInput.EMPTY);
			} else {
				setInput(new ProjectVisualizationInput((IWorkingSet) comboSelection.getFirstElement()));
			}
		} else if (projectButton.getSelection()) {
			IStructuredSelection comboSelection = projectCombo.getStructuredSelection();
			if (comboSelection.isEmpty()) {
				setInput(IVisualizationInput.EMPTY);
			} else {
				setInput(new ProjectVisualizationInput((IProject) comboSelection.getFirstElement()));
			}
		}
	}

	@Override
	protected void setScopeToWorkspace() {
		workspaceButton.setSelection(true);
		workingSetButton.setSelection(false);
		workingSetCombo.getCombo().setEnabled(false);
		projectButton.setSelection(false);
		projectCombo.getCombo().setEnabled(false);
		setInput(new ProjectVisualizationInput());
	}

	public void setScope(IWorkingSet workingSet) {
		workspaceButton.setSelection(false);
		workingSetButton.setSelection(true);
		workingSetCombo.removeSelectionChangedListener(workingSetComboListener);
		workingSetCombo.setSelection(new StructuredSelection(workingSet));
		workingSetCombo.addSelectionChangedListener(workingSetComboListener);
		workingSetCombo.getCombo().setEnabled(true);
		projectButton.setSelection(false);
		projectCombo.getCombo().setEnabled(false);
		setInput(new ProjectVisualizationInput(workingSet));
	}

	public void setScope(IProject project) {
		workspaceButton.setSelection(false);
		workingSetButton.setSelection(false);
		workingSetCombo.getCombo().setEnabled(false);
		projectButton.setSelection(true);
		projectCombo.removeSelectionChangedListener(projectComboListener);
		projectCombo.setSelection(new StructuredSelection(project));
		projectCombo.addSelectionChangedListener(projectComboListener);
		projectCombo.getCombo().setEnabled(true);
		setInput(new ProjectVisualizationInput(project));
	}
}