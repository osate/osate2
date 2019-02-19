package org.osate.ui.dependencyvisualization;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.layout.PixelConverter;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IElementComparer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerComparator;
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
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.osate.aadl2.Aadl2Package;
import org.osate.ui.OsateUiPlugin;

public class ModelUnitDependencyVisualizationView extends AbstractDependencyVisualizationView {
	public static final String ID = "org.osate.ui.modelunitdependencyvisualization";

	private final Image packageImage = OsateUiPlugin.getImageDescriptor("icons/package.gif").createImage();
	private final Image propertySetImage = OsateUiPlugin.getImageDescriptor("icons/properties.gif").createImage();

	private final IResourceDescriptions resourceDescriptions = IResourceServiceProvider.Registry.INSTANCE
			.getResourceServiceProvider(URI.createFileURI("dummy.aadl")).get(IResourceDescriptions.class);

	private Button workspaceButton;
	private Button workingSetButton;
	private ComboViewer workingSetCombo;
	private Button projectButton;
	private ComboViewer projectCombo;
	private Button modelUnitButton;
	private ComboViewer modelUnitCombo;

	private final IAction showAllModelUnitsAction = new Action("Show All Packages and Property Sets in Workspace") {
		@Override
		public void run() {
			setScopeToWorkspace();
		}
	};

	private final IAction focusOnModelUnitAction = new Action() {
		public void run() {
			IEObjectDescription modelUnit = (IEObjectDescription) getGraphSelection().getFirstElement();
			setInput(ModelUnitVisualizationInput.create(resourceDescriptions, modelUnit.getEObjectURI()));
		}
	};

	private final ISelectionChangedListener workingSetComboListener = event -> {
		setInput(ModelUnitVisualizationInput.create(resourceDescriptions,
				(IWorkingSet) event.getStructuredSelection().getFirstElement()));
	};

	private final ISelectionChangedListener projectComboListener = event -> {
		setInput(ModelUnitVisualizationInput.create(resourceDescriptions,
				(IProject) event.getStructuredSelection().getFirstElement()));
	};

	private final ISelectionChangedListener modelUnitComboListener = event -> {
		setInput(ModelUnitVisualizationInput.create(resourceDescriptions,
				((IEObjectDescription) event.getStructuredSelection().getFirstElement()).getEObjectURI()));
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
			IProject selectedProject = (IProject) projectCombo.getStructuredSelection().getFirstElement();
			projectCombo.setInput(Arrays.stream(ResourcesPlugin.getWorkspace().getRoot().getProjects())
					.filter(IProject::isOpen).collect(Collectors.toList()));
			if (selectedProject != null) {
				projectCombo.removeSelectionChangedListener(projectComboListener);
				projectCombo.setSelection(new StructuredSelection(selectedProject));
				projectCombo.addSelectionChangedListener(projectComboListener);
			}

			IEObjectDescription selectedModelUnit = (IEObjectDescription) modelUnitCombo.getStructuredSelection()
					.getFirstElement();
			Iterable<IEObjectDescription> modelUnits = resourceDescriptions
					.getExportedObjectsByType(Aadl2Package.eINSTANCE.getModelUnit());
			modelUnitCombo.setInput(StreamSupport.stream(modelUnits.spliterator(), false)
					.filter(description -> description.getEObjectURI().isPlatformResource())
					.collect(Collectors.toList()));
			if (selectedModelUnit != null) {
				modelUnitCombo.removeSelectionChangedListener(modelUnitComboListener);
				modelUnitCombo.setSelection(new StructuredSelection(selectedModelUnit));
				modelUnitCombo.addSelectionChangedListener(modelUnitComboListener);
			}
		});
	};

	@Override
	public void dispose() {
		super.dispose();
		packageImage.dispose();
		propertySetImage.dispose();
		PlatformUI.getWorkbench().getWorkingSetManager().removePropertyChangeListener(workingSetListener);
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(resourceListener);
	}

	@Override
	protected void menuAboutToShow(IMenuManager manager) {
		manager.add(showAllModelUnitsAction);
		manager.add(new Separator());
		IStructuredSelection selection = getGraphSelection();
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
					modelUnitCombo.getCombo().setEnabled(false);
					setInput(ModelUnitVisualizationInput.create(resourceDescriptions));
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
					modelUnitCombo.getCombo().setEnabled(false);
					IStructuredSelection comboSelection = workingSetCombo.getStructuredSelection();
					if (comboSelection.isEmpty()) {
						setInput(IVisualizationInput.EMPTY);
					} else {
						setInput(ModelUnitVisualizationInput.create(resourceDescriptions,
								(IWorkingSet) comboSelection.getFirstElement()));
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
					modelUnitCombo.getCombo().setEnabled(false);
					IStructuredSelection comboSelection = projectCombo.getStructuredSelection();
					if (comboSelection.isEmpty()) {
						setInput(IVisualizationInput.EMPTY);
					} else {
						setInput(ModelUnitVisualizationInput.create(resourceDescriptions,
								(IProject) comboSelection.getFirstElement()));
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

		modelUnitButton = new Button(parent, SWT.RADIO);
		modelUnitButton.setText("Package or Property Set:");
		modelUnitButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		modelUnitButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (modelUnitButton.getSelection()) {
					workingSetCombo.getCombo().setEnabled(false);
					projectCombo.getCombo().setEnabled(false);
					modelUnitCombo.getCombo().setEnabled(true);
					IStructuredSelection comboSelection = modelUnitCombo.getStructuredSelection();
					if (comboSelection.isEmpty()) {
						setInput(IVisualizationInput.EMPTY);
					} else {
						setInput(ModelUnitVisualizationInput.create(resourceDescriptions,
								((IEObjectDescription) comboSelection.getFirstElement()).getEObjectURI()));
					}
				}
			}
		});

		modelUnitCombo = new ComboViewer(parent);
		GridData modelUnitGridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
		modelUnitGridData.widthHint = comboWidth;
		modelUnitCombo.getCombo().setLayoutData(modelUnitGridData);
		modelUnitCombo.setContentProvider(ArrayContentProvider.getInstance());
		modelUnitCombo.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return ((IEObjectDescription) element).getName().toString("::");
			}
		});
		modelUnitCombo.setComparator(new ViewerComparator());
		modelUnitCombo.setComparer(new IElementComparer() {
			@Override
			public boolean equals(Object a, Object b) {
				return ((IEObjectDescription) a).getEObjectURI().equals(((IEObjectDescription) b).getEObjectURI());
			}

			@Override
			public int hashCode(Object element) {
				return ((IEObjectDescription) element).getEObjectURI().hashCode();
			}
		});
		Iterable<IEObjectDescription> modelUnits = resourceDescriptions
				.getExportedObjectsByType(Aadl2Package.eINSTANCE.getModelUnit());
		modelUnitCombo.setInput(StreamSupport.stream(modelUnits.spliterator(), false)
				.filter(description -> description.getEObjectURI().isPlatformResource()).collect(Collectors.toList()));
		modelUnitCombo.addSelectionChangedListener(modelUnitComboListener);

		PlatformUI.getWorkbench().getWorkingSetManager().addPropertyChangeListener(workingSetListener);
		ResourcesPlugin.getWorkspace().addResourceChangeListener(resourceListener, IResourceChangeEvent.POST_CHANGE);
	}

	@Override
	protected Image getImage(Object element) {
		if (element instanceof IEObjectDescription) {
			EClass eClass = ((IEObjectDescription) element).getEClass();
			if (eClass.equals(Aadl2Package.eINSTANCE.getAadlPackage())) {
				return packageImage;
			} else if (eClass.equals(Aadl2Package.eINSTANCE.getPropertySet())) {
				return propertySetImage;
			}
		}
		return null;
	}

	@Override
	protected String getText(Object element) {
		if (element instanceof IEObjectDescription) {
			return ((IEObjectDescription) element).getName().toString("::");
		} else {
			return null;
		}
	}

	@Override
	protected void refresh() {
		if (workspaceButton.getSelection()) {
			setInput(ModelUnitVisualizationInput.create(resourceDescriptions));
		} else if (workingSetButton.getSelection()) {
			IStructuredSelection comboSelection = workingSetCombo.getStructuredSelection();
			if (comboSelection.isEmpty()) {
				setInput(IVisualizationInput.EMPTY);
			} else {
				setInput(ModelUnitVisualizationInput.create(resourceDescriptions,
						(IWorkingSet) comboSelection.getFirstElement()));
			}
		} else if (projectButton.getSelection()) {
			IStructuredSelection comboSelection = projectCombo.getStructuredSelection();
			if (comboSelection.isEmpty()) {
				setInput(IVisualizationInput.EMPTY);
			} else {
				setInput(ModelUnitVisualizationInput.create(resourceDescriptions,
						(IProject) comboSelection.getFirstElement()));
			}
		} else if (modelUnitButton.getSelection()) {
			IStructuredSelection comboSelection = modelUnitCombo.getStructuredSelection();
			if (comboSelection.isEmpty()) {
				setInput(IVisualizationInput.EMPTY);
			} else {
				setInput(ModelUnitVisualizationInput.create(resourceDescriptions,
						((IEObjectDescription) comboSelection.getFirstElement()).getEObjectURI()));
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
		modelUnitButton.setSelection(false);
		modelUnitCombo.getCombo().setEnabled(false);
		setInput(ModelUnitVisualizationInput.create(resourceDescriptions));
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
		modelUnitButton.setSelection(false);
		modelUnitCombo.getCombo().setEnabled(false);
		setInput(ModelUnitVisualizationInput.create(resourceDescriptions, workingSet));
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
		modelUnitButton.setSelection(false);
		modelUnitCombo.getCombo().setEnabled(false);
		setInput(ModelUnitVisualizationInput.create(resourceDescriptions, project));
	}
}