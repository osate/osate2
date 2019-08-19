package org.osate.ge.internal.ui.wizards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.Element;
import org.osate.ge.DiagramType;
import org.osate.ge.internal.diagram.runtime.types.DiagramTypeProvider;
import org.osate.ge.internal.services.DiagramService;
import org.osate.ge.internal.ui.dialogs.CreateDiagramComposite;
import org.osate.ge.internal.ui.dialogs.DefaultCreateDiagramModel;
import org.osate.ge.internal.ui.dialogs.ElementLabelProvider;
import org.osate.ge.internal.ui.util.EditorUtil;
import org.osate.ge.internal.util.ProjectUtil;
import org.osate.ge.internal.util.ProxyUtil;
import org.osate.ge.internal.util.ScopedEMFIndexRetrieval;
import org.osgi.framework.FrameworkUtil;

public class NewDiagramWizard extends Wizard implements INewWizard {
	// What type of context will be used for the new diagram
	enum ContextType {
		NEW_PACKAGE, EXISTING_PACKAGE, EXISTING_CLASSIFIER, CONTEXTLESS,
	}

	/**
	 * Page for selecting the type of context to be selected.
	 */
	private static class SelectContextTypePage extends WizardPage {
		private Composite container;
		private final List<Button> selectionBtns = new ArrayList<>();
		private final SelectionListener updateOnSelect = new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				update();
			}
		};

		SelectContextTypePage() {
			super("Select Context Type");
			setTitle("Select Context Type");
			setDescription("Select Context Type");
		}

		@Override
		public void createControl(final Composite parent) {
			container = new Composite(parent, SWT.NONE);
			final GridLayout layout = new GridLayout();
			container.setLayout(layout);
			layout.numColumns = 1;

			addButton("New Package", ContextType.NEW_PACKAGE);
			addButton("Existing Package", ContextType.EXISTING_PACKAGE);
			addButton("Existing Classifier", ContextType.EXISTING_CLASSIFIER);
			addButton("Contextless", ContextType.CONTEXTLESS);

			setControl(container);

			update();
		}

		private void addButton(final String label, final ContextType contextType) {
			final Button btn = new Button(container, SWT.RADIO);
			btn.setText(label);
			btn.setData(contextType);
			btn.addSelectionListener(updateOnSelect);
			selectionBtns.add(btn);
		}

		private void update() {
			setPageComplete(getContextType() != null);
			setDescription(getDescription(getContextType()));
		}

		private static String getDescription(final ContextType type) {
			if (type == null) {
				return "Create a new AADL diagram.";
			}

			switch (type) {
			case NEW_PACKAGE:
				return "Select Finish to open the AADL Package wizard.";

			case CONTEXTLESS:
				return "Create a new diagram which is not associated with a model element.";

			case EXISTING_CLASSIFIER:
				return "Create a diagram which uses an existing classifier as its context.";

			case EXISTING_PACKAGE:
				return "Create a diagram which uses an existing package as its context.";
			}

			throw new RuntimeException("Unhandled case: " + type);
		}

		private ContextType getContextType() {
			for (final Button selectionBtn : selectionBtns) {
				if (selectionBtn.getSelection()) {
					return (ContextType) selectionBtn.getData();
				}
			}

			return null;
		}
	}

	/**
	 * Page for selecting the project in which to create the diagram.
	 */
	private static class SelectProjectPage extends WizardPage {
		private Composite container;
		private TreeViewer projectViewer;

		SelectProjectPage() {
			super("Select Project");
			setTitle("Select Project");
			setDescription("Select the project in which to create the diagram.");
		}

		@Override
		public void createControl(final Composite parent) {
			container = new Composite(parent, SWT.NONE);
			final GridLayout layout = new GridLayout();
			container.setLayout(layout);
			layout.numColumns = 1;

			projectViewer = new TreeViewer(container, SWT.SINGLE | SWT.BORDER);
			GridDataFactory.fillDefaults().grab(true, true).applyTo(projectViewer.getControl());
			projectViewer.setContentProvider(new WorkbenchContentProvider() {
				@Override
				public Object[] getChildren(Object element) {
					return Arrays.stream(super.getChildren(element)).filter(r -> r instanceof IProject)
							.map(r -> (IProject) r).filter(p -> p.isOpen()).toArray();
				}
			});
			projectViewer.setLabelProvider(new WorkbenchLabelProvider());
			projectViewer.setComparator(new ViewerComparator());
			projectViewer.addSelectionChangedListener(event -> update());
			projectViewer.setInput(ResourcesPlugin.getWorkspace());

			setControl(container);

			update();
		}

		private void update() {
			setPageComplete(getProject() != null);
		}

		public IProject getProject() {
			return (IProject) ((StructuredSelection) projectViewer.getSelection()).getFirstElement();
		}

		public void setProject(final IProject value) {
			projectViewer.setSelection(value == null ? StructuredSelection.EMPTY : new StructuredSelection(value));
			update();
		}
	}

	/**
	 * Page for selecting the context for the diagram
	 */
	private static class SelectContextPage extends WizardPage {
		private Composite container;
		private ListViewer contextViewer;
		private IProject project;

		SelectContextPage() {
			super("Select Context");
			refresh(null, null);
		}

		@Override
		public void createControl(final Composite parent) {
			container = new Composite(parent, SWT.NONE);
			final GridLayout layout = new GridLayout();
			container.setLayout(layout);
			layout.numColumns = 1;

			contextViewer = new ListViewer(container, SWT.SINGLE | SWT.BORDER | SWT.V_SCROLL);
			GridDataFactory.fillDefaults().grab(true, true).applyTo(contextViewer.getControl());
			contextViewer.setContentProvider(new ArrayContentProvider());
			contextViewer.setLabelProvider(new ElementLabelProvider());
			contextViewer.setComparator(new ViewerComparator());
			contextViewer.addSelectionChangedListener(event -> update());

			setControl(container);
			setPageComplete(false);
			update();
		}

		private void update() {
			setPageComplete(getContext() != null);
		}

		public EObject getContext() {
			if (project == null) {
				return null;
			}

			final IEObjectDescription contextDescription = (IEObjectDescription) ((StructuredSelection) contextViewer
					.getSelection()).getFirstElement();

			if (contextDescription == null) {
				return null;
			}

			// Get a live resource set and use it to load the actual context business object.
			final ResourceSet liveResourceSet = ProjectUtil.getLiveResourceSet(project);

			return ProxyUtil.resolveOrNull(contextDescription, Element.class, liveResourceSet);
		}

		/**
		 * Refreshes the page based on an updated project and context type
		 * @param project
		 * @param contextType
		 */
		public void refresh(final IProject project, final ContextType contextType) {
			setTitle(determineTitle(contextType));
			setDescription(determineDescription(contextType));

			this.project = project;

			if (contextViewer != null) {
				// Determine the EClass of the context
				final EClass contextEclass;
				if (contextType == ContextType.EXISTING_PACKAGE) {
					contextEclass = Aadl2Package.eINSTANCE.getAadlPackage();
				} else if (contextType == ContextType.EXISTING_CLASSIFIER) {
					contextEclass = Aadl2Package.eINSTANCE.getClassifier();
				} else {
					contextEclass = null;
				}

				// Update the context viewer with valid contexts
				if (contextEclass == null || project == null) {
					contextViewer.setInput(Collections.emptyList());
				} else {
					contextViewer.setInput(ScopedEMFIndexRetrieval.getContainedEObjectsByType(project, contextEclass));
				}
			}
		}

		private static String determineTitle(final ContextType contextType) {
			if (contextType == ContextType.EXISTING_PACKAGE) {
				return "Select Package";
			} else if (contextType == ContextType.EXISTING_CLASSIFIER) {
				return "Select Classifier";
			} else {
				return "Select Context";
			}
		}

		private static String determineDescription(final ContextType contextType) {
			if (contextType == ContextType.EXISTING_PACKAGE) {
				return "Select a package to use as the context for the new diagram.";
			} else if (contextType == ContextType.EXISTING_CLASSIFIER) {
				return "Select a classifier to use as the context for the new diagram.";
			} else {
				return "Select a context for the new diagram.";
			}
		}
	}

	/**
	 * Page for selecting the name and type for the diagram.
	 */
	private static class SelectNameAndTypePage extends WizardPage {
		private CreateDiagramComposite<DiagramType> composite;
		private final DiagramTypeProvider diagramTypeProvider;
		private IProject project;
		private Object context;

		SelectNameAndTypePage(final DiagramTypeProvider diagramTypeProvider) {
			super("Select Name and Type");
			this.diagramTypeProvider = Objects.requireNonNull(diagramTypeProvider,
					"diagramTypeProvider must not be null");

			setTitle("Select Diagram Name and Type");
			setDescription("Select Finish to create the diagram.");
		}

		@Override
		public void createControl(final Composite parent) {
			composite = new CreateDiagramComposite<>(parent, createModel());
			setControl(composite);
			setPageComplete(false);

			composite.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					setErrorMessage(composite.getErrorMessage());
					setPageComplete(composite.getErrorMessage() == null);
				}
			});
		}

		public CreateDiagramComposite.Value<DiagramType> getValue() {
			return composite.getValue();
		}

		public void setProject(final IProject project) {
			this.project = project;
			this.composite.setModel(createModel());
		}

		public void setContext(final Object context) {
			this.context = context;
			this.composite.setModel(createModel());
		}

		// Create a new model based on the current state
		private DefaultCreateDiagramModel createModel() {
			return new DefaultCreateDiagramModel(diagramTypeProvider, project, context);
		}
	}

	private final DiagramService diagramService;
	private IProject initialProject = null;
	private SelectContextTypePage contextTypePage = new SelectContextTypePage();
	private SelectProjectPage selectProjectPage = new SelectProjectPage();
	private SelectContextPage contextPage = new SelectContextPage();
	private SelectNameAndTypePage diagramNameAndTypePage;

	public NewDiagramWizard(final DiagramTypeProvider diagramTypeProvider, final DiagramService diagramService) {
		setWindowTitle("New AADL Diagram");
		this.diagramService = Objects.requireNonNull(diagramService, "diagramService must not be null");
		diagramNameAndTypePage = new SelectNameAndTypePage(diagramTypeProvider);
	}

	@Override
	public void init(final IWorkbench workbench, final IStructuredSelection selection) {
		if (selection.getFirstElement() instanceof IResource) {
			initialProject = ((IResource) selection.getFirstElement()).getProject();
		}
	}

	@Override
	public void addPages() {
		addPage(contextTypePage);
		addPage(selectProjectPage);
		addPage(contextPage);
		addPage(diagramNameAndTypePage);
	}

	@Override
	public IWizardPage getNextPage(final IWizardPage currentPage) {
		if (currentPage == contextTypePage) {
			if (contextTypePage.getContextType() == ContextType.NEW_PACKAGE) {
				return null;
			}

			// Update the select project page's project. This is not done during initialization because the method must be called after the page itself is
			// initialized.
			selectProjectPage.setProject(initialProject);
		}

		if (currentPage == selectProjectPage) {
			diagramNameAndTypePage.setProject(selectProjectPage.getProject());
			contextPage.refresh(selectProjectPage.getProject(), contextTypePage.getContextType());

			if (contextTypePage.getContextType() == ContextType.CONTEXTLESS) {
				diagramNameAndTypePage.setContext(null);
				return diagramNameAndTypePage;
			}
		}

		if (currentPage == contextPage) {
			diagramNameAndTypePage.setContext(contextPage.getContext());
		}

		return super.getNextPage(currentPage);
	}

	@Override
	public boolean canFinish() {
		if (contextTypePage.getContextType() == ContextType.NEW_PACKAGE) {
			return true;
		}

		// Ignore context page is contextless is selected.
		if (contextTypePage.getContextType() == ContextType.CONTEXTLESS) {
			return selectProjectPage.isPageComplete() && diagramNameAndTypePage.isPageComplete();
		}

		return super.canFinish();
	}

	@Override
	public boolean performFinish() {
		try {
			if (contextTypePage.getContextType() == ContextType.NEW_PACKAGE) {
				// Use async exec so the current wizard will be closed before the new wizard opens.
				Display.getDefault().asyncExec(() -> {
					// Ideally, this would open the wizard and select the option to open it in the diagram editor. The wizard class can't be used directly at
					// this time because that would require a circular dependency.
					final IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
					final IHandlerService handlerService = (IHandlerService) window.getService(IHandlerService.class);
					try {
						handlerService.executeCommand("org.osate.ui.wizards.packageWizard", null);
					} catch (final Exception e) {
						final Status status = new Status(IStatus.ERROR,
								FrameworkUtil.getBundle(getClass()).getSymbolicName(), "New Diagram Error", e);
						StatusManager.getManager().handle(status, StatusManager.LOG | StatusManager.SHOW);
						throw new RuntimeException(e);
					}
				});

				return true;
			} else {
				final Object context = getContext();
				final CreateDiagramComposite.Value<DiagramType> diagramNameAndType = diagramNameAndTypePage.getValue();
				diagramService.createDiagram(diagramNameAndType.getFile(), diagramNameAndType.getDiagramType(),
						context);

				EditorUtil.openEditor(diagramNameAndType.getFile(), false);

				return true;
			}
		} catch (final RuntimeException ex) {
			final Status status = new Status(IStatus.ERROR, FrameworkUtil.getBundle(getClass()).getSymbolicName(),
					"New Diagram Error", ex);
			StatusManager.getManager().handle(status, StatusManager.LOG | StatusManager.SHOW);
			return false;
		}
	}

	/**
	 * Helper method for getting the proper context by considering whether the context page is being used or not.
	 * @return
	 */
	private Object getContext() {
		if (contextTypePage.getContextType() == ContextType.CONTEXTLESS) {
			return null;
		} else {
			return contextPage.getContext();
		}
	}

}
