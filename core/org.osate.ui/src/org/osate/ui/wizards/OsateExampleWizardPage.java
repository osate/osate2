package org.osate.ui.wizards;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.statushandlers.StatusManager;
import org.osate.ui.OsateUiPlugin;
import org.osgi.framework.Bundle;

/**
 * @since 5.0
 */
public class OsateExampleWizardPage extends WizardPage {
	public OsateExampleWizardPage(String pageName) {
		super(pageName);
	}

	public OsateExampleWizardPage() {
		super("Examples");
		setTitle("Examples Wizard Page");
		setDescription("Examples Wizard");
	}

	private static final String PLUGIN_ID = "org.osate.examples";
	private static final String ATT_NODE = "example";
	private static final String ATT_NAME = "name";
	private static final String ATT_EXAMPLEURI = "exampleURI";
	private static final String ATT_READMEURI = "readmeURI";
	private static final String ATT_CATEGORY = "category";
	private static final String ATT_PROJECTPATH = "path";
	private static final String EXAMPLE_ROOT_PATH = "examples";
	protected Browser browser;
	protected PluginInfo selectedProject;

	public PluginInfo getSelectedProject() {
		return selectedProject;
	}

	public class TreeContentProvider implements ITreeContentProvider {
		PluginInfo treeContent;

		@Override
		public void dispose() {
			// Nothing to do.
		}

		@SuppressWarnings("unchecked")
		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			treeContent = (PluginInfo) newInput;
		}

		@Override
		public Object[] getElements(Object inputElement) {
			return getChildren(inputElement);
		}

		@Override
		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof PluginInfo) {
				return ((PluginInfo) parentElement).getNode().toArray();
			} else {
				return null;
			}
		}

		@SuppressWarnings("unchecked")
		@Override
		public Object getParent(Object element) {
			if (element instanceof PluginInfo) {
				return ((PluginInfo) element).getParent();
			}

			return null;
		}

		@Override
		public boolean hasChildren(Object element) {
			return getChildren(element).length > 0;
		}
	}

	public class FileLabelProvider extends LabelProvider {
		public FileLabelProvider(Image fileImg, Image categoryImg) {
			super();
		}

		@Override
		public Image getImage(Object element) {
			return null;
		}

		@Override
		public void dispose() {
			super.dispose();
		}

		@Override
		public String getText(Object element) {
			return ((PluginInfo) element).name;
		}
	}

	@Override
	public void performHelp() {
		PlatformUI.getWorkbench().getHelpSystem().setHelp(getShell(), "org.osate.ui.help_dialog");
	}

	@Override
	public void createControl(Composite parent) {
		try {
			Composite panelChoice = new Composite(parent, SWT.NONE);

			FillLayout fillLayout = new FillLayout();
			fillLayout.marginHeight = 5;
			fillLayout.marginWidth = 5;
			panelChoice.setLayout(fillLayout);

			SashForm sashForm = new SashForm(panelChoice, SWT.HORIZONTAL);

			PluginInfo root = loadExamples(EXAMPLE_ROOT_PATH);
			final TreeViewer pickTree = createTree(sashForm);
			pickTree.setLabelProvider(new FileLabelProvider(null, null));
			pickTree.setContentProvider(new TreeContentProvider());
			pickTree.setInput(root);

			pickTree.addSelectionChangedListener(event -> {
				IStructuredSelection selection = (IStructuredSelection) event.getSelection();
				for (final Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					final Object object = iter.next();
					if (object instanceof PluginInfo) {
						selectedProject = (PluginInfo) object;
						if (selectedProject.readmeURI != null) {
							try {
								File f = new File(selectedProject.readmeURI.getPath());
								browser.setUrl(f.toURL().toString());
							} catch (IllegalArgumentException e) {
								browser.setUrl("<p>Failed to load readme</p>");
								catchError(e, e.getMessage(), true);
							} catch (MalformedURLException e) {
								browser.setUrl("<p>Failed to load readme</p>");
								catchError(e, e.getMessage(), true);
							}
						}
					}
				}
			});

			browser = new Browser(sashForm, SWT.NONE);
			GridData layoutData = new GridData(GridData.FILL_BOTH);
			layoutData.verticalSpan = 100;
			browser.setLayoutData(layoutData);
			browser.setText(
					"<p>Expand the category on the left and select an example project to import. If project has a description available, it will be shown here once the project is selected</p>");

			sashForm.setWeights(new int[] { 1, 4 });
			setControl(panelChoice);

		} catch (Exception e) {
			catchError(e, e.getMessage(), true);
		}
	}

	public List<PluginInfo> loadExamplesFromPlugin() throws IOException, NullPointerException {
		List<PluginInfo> result = new ArrayList<PluginInfo>();

		final IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();

		IExtensionPoint extensionPoint = extensionRegistry.getExtensionPoint(OsateUiPlugin.PLUGIN_ID, ATT_NODE);
		IExtension[] exts = extensionPoint.getExtensions();

		for (int i = 0; i < exts.length; i++) {
			try {
				IConfigurationElement[] configElems = exts[i].getConfigurationElements();

				if (configElems != null) {
					Bundle bundle = Platform.getBundle(exts[i].getContributor().getName());
					for (int j = 0; j < configElems.length; j++) {

						PluginInfo project = new PluginInfo(
								org.eclipse.core.runtime.FileLocator
										.toFileURL(bundle.getEntry(configElems[j].getAttribute(ATT_EXAMPLEURI))),
								org.eclipse.core.runtime.FileLocator
										.toFileURL(bundle.getEntry(combine(configElems[j].getAttribute(ATT_EXAMPLEURI),
												configElems[j].getAttribute(ATT_READMEURI)))),
								configElems[j].getAttribute(ATT_NAME), configElems[j].getAttribute(ATT_CATEGORY));

						if (project != null && project.name != null && project.exampleURI != null) {
							project.exampleS = configElems[j].getAttribute(ATT_EXAMPLEURI);

							// list of projects
							IConfigurationElement[] projectElems = configElems[j].getChildren();
							if (projectElems != null) {
								for (int k = 0; k < projectElems.length; k++) {
									project.addProjectPath(projectElems[k].getAttribute(ATT_PROJECTPATH));
								}
							}
							result.add(project);
						}
					}
				}
			} catch (NullPointerException e) {
				catchError(e, e.getMessage(), true);
			} catch (InvalidRegistryObjectException e) {
				catchError(e, e.getMessage(), true);
			}
		}

		return result;
	}

	/**
	 * @since 4.0
	 */
	protected PluginInfo loadExamples(String examplesPath) throws IOException, NullPointerException {
		PluginInfo result = new PluginInfo();

		List<PluginInfo> projectInfo = loadExamplesFromPlugin();

		for (PluginInfo p : projectInfo) {
			File file = null;

			if (Platform.isRunning()) {
				if (p.exampleURI == null) {
					continue;
				}

				file = new File(FileLocator.toFileURL(p.exampleURI).getFile());
			}

			if (file == null) {
				continue; // if example files are not found, there is no point in showing it as an option to import
			}

			// check if node with this category exists
			List<PluginInfo> existingCategories = result.getNode();
			Object[] currentNodeCategory = existingCategories.stream()
					.filter(x -> x.category != null && p.category != null && x.category.compareToIgnoreCase(
							p.category) == 0)
					.toArray();
			if (currentNodeCategory != null && currentNodeCategory.length > 0) {
				for (int j = 0; j < currentNodeCategory.length; j++) {
					((PluginInfo) currentNodeCategory[j]).addNode(p);
				}
			} else {
				// add category node to root -> add the project under category
				PluginInfo cNode = new PluginInfo(null, null, p.category, p.category);
				cNode.addNode(p);
				result.addNode(cNode);
			}
		}

		return result;
	}

	/**
	 * @since 4.0
	 */
	protected TreeViewer createTree(Composite parent) {
		GridData compLayout = new GridData(GridData.FILL_BOTH);
		compLayout.heightHint = 200;
		compLayout.widthHint = 200;

		Composite treeComposite = new Composite(parent, SWT.NONE);
		treeComposite.setLayoutData(compLayout);

		GridData dataLayout = new GridData(GridData.FILL_BOTH);
		dataLayout.heightHint = compLayout.heightHint;
		dataLayout.widthHint = compLayout.widthHint;

		int style = SWT.SINGLE | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL;
		Tree tree = new Tree(treeComposite, style);
		tree.setLayoutData(dataLayout);
		tree.setLinesVisible(true);
		tree.setHeaderVisible(false);
		tree.setFont(parent.getFont());

		TreeColumn col = new TreeColumn(tree, SWT.LEFT);

		TreeColumnLayout treeLayout = new TreeColumnLayout();
		treeLayout.setColumnData(col, new ColumnWeightData(dataLayout.widthHint));
		treeComposite.setLayout(treeLayout);

		return new TreeViewer(tree);
	}

	public static String combine(String path1, String path2) {
		File file1 = new File(path1);
		File file2 = new File(file1, path2);
		return file2.getPath();
	}

	protected void catchError(Exception e, String message, Boolean logOnly) {
		IStatus status = new Status(IStatus.ERROR, OsateUiPlugin.PLUGIN_ID, message, e);
		StatusManager manager = StatusManager.getManager();
		manager.handle(status, logOnly ? StatusManager.LOG : StatusManager.SHOW | StatusManager.LOG);
	}
}