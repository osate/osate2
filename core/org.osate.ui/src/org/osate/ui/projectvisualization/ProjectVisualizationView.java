package org.osate.ui.projectvisualization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.findReferences.IReferenceFinder;
import org.eclipse.xtext.findReferences.IReferenceFinder.Acceptor;
import org.eclipse.xtext.findReferences.TargetURIs;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.viewers.IEntityStyleProvider;
import org.eclipse.zest.core.viewers.IGraphEntityContentProvider;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.layouts.LayoutAlgorithm;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.CompositeLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.DirectedGraphLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.HorizontalShift;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ModelUnit;
import org.osate.core.AadlNature;
import org.osate.ui.OsateUiPlugin;

import com.google.inject.Injector;

@SuppressWarnings("restriction")
public class ProjectVisualizationView extends ViewPart {
	public static final String ID = "org.osate.ui.projectvisualization";

	private final Injector injector;
	private final IReferenceFinder referenceFinder;
	private final IResourceDescriptions resourceDescriptions;

	// Either IProject or URI<AadlPackage>
	private final Set<Object> scopedElements = new LinkedHashSet<>();

	private Label label;
	private Font labelFont;
	private GraphViewer graph;

	public ProjectVisualizationView() {
		injector = IResourceServiceProvider.Registry.INSTANCE
				.getResourceServiceProvider(URI.createFileURI("dummy.aadl")).get(Injector.class);
		referenceFinder = injector.getInstance(IReferenceFinder.class);
		resourceDescriptions = injector.getInstance(IResourceDescriptions.class);
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout());

		label = new Label(parent, SWT.NONE);
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		labelFont = FontDescriptor.createFrom(label.getFont()).increaseHeight(5).createFont(label.getDisplay());
		label.setFont(labelFont);

		graph = new GraphViewer(parent, SWT.NONE);
		graph.getGraphControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		graph.setContentProvider(new IGraphEntityContentProvider() {
			@Override
			public Object[] getElements(Object inputElement) {
				Set<?> inputSet = (Set<?>) inputElement;
				if (inputSet.isEmpty()) {
					return new Object[0];
				} else if (inputSet.iterator().next() instanceof IProject) {
					Set<IProject> allProjects = new LinkedHashSet<>();
					for (Object inputSetElement : inputSet) {
						IProject project = (IProject) inputSetElement;
						if (project.isOpen()) {
							allProjects.add(project);
							traverseDependencies(project, allProjects, p -> {
								try {
									return p.getReferencedProjects();
								} catch (CoreException e) {
									StatusManager.getManager().handle(e, OsateUiPlugin.PLUGIN_ID);
									return new IProject[0];
								}
							});
							traverseDependencies(project, allProjects, IProject::getReferencingProjects);
						}
					}
					return allProjects.toArray();
				} else {
					// inputSet is set of URI<AadlPackage>
					Set<AadlPackage> allPackages = new LinkedHashSet<>();
					ResourceSet resourceSet = new ResourceSetImpl();
					for (Object inputSetElement : inputSet) {
						URI pkgURI = (URI) inputSetElement;
						AadlPackage pkg = (AadlPackage) resourceSet.getEObject(pkgURI, true);
						allPackages.add(pkg);
						traverseDependencies(pkg, allPackages, this::getReferencedPackages);
						traverseDependencies(pkg, allPackages, this::getReferencingPackages);
					}
					return allPackages.stream().map(EcoreUtil::getURI).toArray();
				}
			}

			private List<AadlPackage> getReferencingPackages(AadlPackage pkg) {
				TargetURIs uris = injector.getInstance(TargetURIs.class);
				uris.addURI(EcoreUtil.getURI(pkg));
				List<AadlPackage> referencingPackages = new ArrayList<>();
				referenceFinder.findAllReferences(uris, null, resourceDescriptions, new Acceptor() {
					@Override
					public void accept(EObject source, URI sourceURI, EReference eReference, int index,
							EObject targetOrProxy, URI targetURI) {
						// Not called.
					}

					@Override
					public void accept(IReferenceDescription description) {
						EObject source = pkg.eResource().getResourceSet().getEObject(description.getSourceEObjectUri(),
								true);
						AadlPackage sourcePkg = EcoreUtil2.getContainerOfType(source, AadlPackage.class);
						if (sourcePkg != null) {
							referencingPackages.add(sourcePkg);
						}
					}
				}, null);
				return referencingPackages;
			}

			private List<AadlPackage> getReferencedPackages(AadlPackage pkg) {
				List<AadlPackage> referencedPackages = new ArrayList<>();
				if (pkg.getOwnedPublicSection() != null) {
					for (ModelUnit imported : pkg.getOwnedPublicSection().getImportedUnits()) {
						ModelUnit resolved = (ModelUnit) EcoreUtil.resolve(imported, pkg);
						if (resolved instanceof AadlPackage) {
							referencedPackages.add((AadlPackage) resolved);
						}
					}
				}
				if (pkg.getOwnedPrivateSection() != null) {
					for (ModelUnit imported : pkg.getOwnedPrivateSection().getImportedUnits()) {
						ModelUnit resolved = (ModelUnit) EcoreUtil.resolve(imported, pkg);
						if (resolved instanceof AadlPackage) {
							referencedPackages.add((AadlPackage) resolved);
						}
					}
				}
				return referencedPackages;
			}

			private void traverseDependencies(IProject project, Set<IProject> visited,
					Function<IProject, IProject[]> getDependencies) {
				for (IProject dependency : getDependencies.apply(project)) {
					if (dependency.isOpen() && !visited.contains(dependency)) {
						visited.add(dependency);
						traverseDependencies(dependency, visited, getDependencies);
					}
				}
			}

			private void traverseDependencies(AadlPackage pkg, Set<AadlPackage> visited,
					Function<AadlPackage, List<AadlPackage>> getDependencies) {
				for (AadlPackage dependency : getDependencies.apply(pkg)) {
					if (!visited.contains(dependency)) {
						visited.add(dependency);
						traverseDependencies(dependency, visited, getDependencies);
					}
				}
			}

			@Override
			public Object[] getConnectedTo(Object entity) {
				if (entity instanceof IProject) {
					try {
						IProject[] references = ((IProject) entity).getReferencedProjects();
						return Arrays.stream(references).filter(IProject::isOpen).toArray();
					} catch (CoreException e) {
						StatusManager.getManager().handle(e, OsateUiPlugin.PLUGIN_ID);
						return new Object[0];
					}
				} else {
					// entity is URI<AadlPackage>
					AadlPackage pkg = (AadlPackage) new ResourceSetImpl().getEObject((URI) entity, true);
					return getReferencedPackages(pkg).stream().map(EcoreUtil::getURI).toArray();
				}
			}
		});
		graph.setLabelProvider(new VisualizationLabelProvider(parent.getDisplay()));
		graph.setConnectionStyle(ZestStyles.CONNECTIONS_DIRECTED);
		graph.setLayoutAlgorithm(new CompositeLayoutAlgorithm(
				new LayoutAlgorithm[] { new DirectedGraphLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING),
						new HorizontalShift(LayoutStyles.NO_LAYOUT_NODE_RESIZING) }));
		setScopeToWorkspace();

		MenuManager menuManager = new MenuManager();
		menuManager.setRemoveAllWhenShown(true);
		menuManager.addMenuListener(manager -> {
			manager.add(showAllProjectsAction);
			IStructuredSelection selection = graph.getStructuredSelection();
			if (selection.size() == 1) {
				Object selectedObject = selection.getFirstElement();
				if (selectedObject instanceof IProject) {
					IProject selectedProject = (IProject) selectedObject;
					try {
						if (selectedProject.hasNature(AadlNature.ID)) {
							showPackagesInProjectAction
									.setText("Show AADL Packages in project '" + selectedProject.getName() + "'");
							manager.add(showPackagesInProjectAction);
						}
					} catch (CoreException e) {
						StatusManager.getManager().handle(e, OsateUiPlugin.PLUGIN_ID);
					}
				}
			}
		});
		graph.getGraphControl().setMenu(menuManager.createContextMenu(graph.getGraphControl()));
	}

	private final IAction showAllProjectsAction = new Action("Show All Projects") {
		@Override
		public void run() {
			setScopeToWorkspace();
		}
	};

	private final IAction showPackagesInProjectAction = new Action() {
		@Override
		public void run() {
			IProject project = (IProject) graph.getStructuredSelection().getFirstElement();
			List<IFile> files = getAllAadlFiles(project);
			ResourceSet resourceSet = new ResourceSetImpl();
			List<URI> packages = files.stream()
					.map(file -> resourceSet
							.getResource(URI.createPlatformResourceURI(file.getFullPath().toString(), true), true))
					.filter(resource -> !resource.getContents().isEmpty())
					.map(resource -> resource.getContents().get(0)).filter(eObject -> eObject instanceof AadlPackage)
					.map(EcoreUtil::getURI).collect(Collectors.toList());
			scopedElements.clear();
			scopedElements.addAll(packages);
			graph.setInput(scopedElements);
			label.setText("Scope: Packages in Project '" + project.getName() + "'");
		}

		private List<IFile> getAllAadlFiles(IContainer container) {
			List<IFile> files = new ArrayList<>();
			try {
				for (IResource member : container.members()) {
					if (member instanceof IFile) {
						IFile file = (IFile) member;
						if (file.getFileExtension().contentEquals("aadl")) {
							files.add(file);
						}
					} else if (member instanceof IContainer) {
						files.addAll(getAllAadlFiles((IContainer) member));
					}
				}
			} catch (CoreException e) {
				StatusManager.getManager().handle(e, OsateUiPlugin.PLUGIN_ID);
			}
			return files;
		}
	};

	@Override
	public void setFocus() {
		graph.getGraphControl().setFocus();
	}

	@Override
	public void dispose() {
		super.dispose();
		labelFont.dispose();
	}

	public void setScope(IWorkingSet workingSet) {
		List<IProject> projects = Arrays.stream(workingSet.getElements())
				.map(adaptable -> Adapters.adapt(adaptable, IProject.class)).filter(IProject::isOpen)
				.collect(Collectors.toList());
		scopedElements.clear();
		scopedElements.addAll(projects);
		graph.setInput(scopedElements);
		label.setText("Scope: Working Set '" + workingSet.getName() + "'");
	}

	public void setScope(IProject project) {
		scopedElements.clear();
		scopedElements.add(project);
		graph.setInput(scopedElements);
		label.setText("Scope: Project '" + project.getName() + "'");
	}

	private void setScopeToWorkspace() {
		List<IProject> projects = Arrays.stream(ResourcesPlugin.getWorkspace().getRoot().getProjects())
				.filter(IProject::isOpen).collect(Collectors.toList());
		scopedElements.clear();
		scopedElements.addAll(projects);
		graph.setInput(scopedElements);
		label.setText("Scope: All Projects");
	}

	private class VisualizationLabelProvider extends LabelProvider implements IEntityStyleProvider {
		private final Display display;

		public VisualizationLabelProvider(Display display) {
			this.display = display;
		}

		@Override
		public String getText(Object element) {
			if (element instanceof IProject) {
				return ((IProject) element).getName();
			} else if (element instanceof URI) {
				ResourceSet resourceSet = new ResourceSetImpl();
				return ((AadlPackage) resourceSet.getEObject((URI) element, true)).getName();
			} else {
				return null;
			}
		}

		@Override
		public Color getNodeHighlightColor(Object entity) {
			return null;
		}

		@Override
		public Color getBorderColor(Object entity) {
			return null;
		}

		@Override
		public Color getBorderHighlightColor(Object entity) {
			return null;
		}

		@Override
		public int getBorderWidth(Object entity) {
			return -1;
		}

		@Override
		public Color getBackgroundColour(Object entity) {
			if (!scopedElements.contains(entity)) {
				return display.getSystemColor(SWT.COLOR_WHITE);
			} else {
				return null;
			}
		}

		@Override
		public Color getForegroundColour(Object entity) {
			return null;
		}

		@Override
		public IFigure getTooltip(Object entity) {
			return null;
		}

		@Override
		public boolean fisheyeNode(Object entity) {
			return false;
		}
	}
}