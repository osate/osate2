/*
 * <copyright>
 * Copyright  2009 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 *
 * </copyright>
 */
package org.osate.internal.ui.preferences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.osate.pluginsupport.PluginSupportPlugin;
import org.osate.pluginsupport.PluginSupportUtil;
import org.osate.pluginsupport.PredeclaredProperties;
import org.osate.ui.OsateUiPlugin;

/**
 * This class represents the OSATE > Instantiation workspace preferences.
 * @since 5.0
 */
public final class ContributedResourcesPreferencePage extends PreferencePage
		implements IWorkbenchPreferencePage {
	private Map<URI, URI> originalOverriddenAadl;
	private final Map<URI, URI> overriddenAadl = new HashMap<>();

	private TreeViewer tree;
	private Button overrideButton;
	private Button restoreButton;
	private TreeNode selectedNode;
	private Label uriLabel;

	public ContributedResourcesPreferencePage() {
		super("Contributed Resources");
	}

	/**
	 * Create the field editors.
	 */
	@Override
	public Control createContents(final Composite parent) {
		// Save original settings, and initialize the local copy
		originalOverriddenAadl = PredeclaredProperties.getOverriddenResources();
		overriddenAadl.putAll(originalOverriddenAadl);

		final Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(2, true));

		SashForm sashForm = new SashForm(composite, SWT.HORIZONTAL);
		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);
		sashForm.setLayoutData(gd);
		initializeDialogUnits(sashForm);

		tree = createTree(sashForm);
		tree.setLabelProvider(new FileLabelProvider(null, null));
		tree.setContentProvider(new TreeContentProvider());
		tree.setAutoExpandLevel(3);

		tree.setInput(createTreeHierarchy());
		tree.setComparator(new ViewerComparator());

		Sorter sort = new Sorter();
		tree.setSorter(sort);

		tree.addSelectionChangedListener(event -> {
			IStructuredSelection selection = (IStructuredSelection) event.getSelection();

			if (selection.isEmpty()) {
				restoreButton.setEnabled(false);
				uriLabel.setText("");
			}

			for (final Iterator<?> iter = selection.iterator(); iter.hasNext();) {
				final Object object = iter.next();
				if (object instanceof TreeNode) {
					selectedNode = (TreeNode) object;
					restoreButton.setEnabled(selectedNode.overridden);
					overrideButton.setEnabled(selectedNode.canOverride());
					uriLabel.setText(selectedNode.path);
				}
			}
		});
		tree.addDoubleClickListener(event -> {
			final TreeViewer viewer = (TreeViewer) event.getViewer();
			final IStructuredSelection thisSelection = (IStructuredSelection) event.getSelection();
			final TreeNode selectedNode = (TreeNode) thisSelection.getFirstElement();
			if (selectedNode != null) {
				if (selectedNode.getNode().isEmpty()) {
					doOverrideAction(selectedNode);
				} else {
					viewer.setExpandedState(selectedNode, !viewer.getExpandedState(selectedNode));
				}
			}
		});

		overrideButton = new Button(composite, SWT.PUSH);
		overrideButton.setLayoutData(new GridData(SWT.RIGHT, SWT.FILL, false, false));
		overrideButton.setText("Override");
		overrideButton.setToolTipText("Override the URI of the contributed resource with a URI from the workspace.");
		overrideButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				if (selectedNode != null) {
					doOverrideAction(selectedNode);
				}
			}
		});

		restoreButton = new Button(composite, SWT.PUSH);
		restoreButton.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false));
		restoreButton.setText("Restore");
		restoreButton.setToolTipText("Restore contributed resource to its plugin-specified URI.");
		restoreButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				if (selectedNode != null) {
					URI uri = URI.createURI(selectedNode.path);
					if (uri != null) {
						overriddenAadl.remove(uri);
						restoreButton.setEnabled(false);
						selectedNode.overridden = false;
						tree.refresh();
						uriLabel.setText(uriToReadable(uri));
					}
				}
			}
		});

		final Group labelGroup = new Group(composite, SWT.SHADOW_ETCHED_IN);
		labelGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		labelGroup.setLayout(new GridLayout(1, true));

		labelGroup.setText("Contributed URI");
		uriLabel = new Label(labelGroup, SWT.NONE);
		uriLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		uriLabel.setText("");

		return composite;
	}

	private void doOverrideAction(final TreeNode selectedNode) {
		if (selectedNode.canOverride()) {
			URI uri = URI.createURI(selectedNode.path);
			if (uri != null) {
				final URI newURI = getWorkspaceContributedResource(uri.lastSegment());
				if (newURI != null) {
					overriddenAadl.put(uri, newURI);
					restoreButton.setEnabled(true);
					selectedNode.overridden = true;
					tree.refresh();
					uriLabel.setText(uriToReadable(newURI));
				}
			}
		}
	}

	private static URI getURIFromSelection(final ISelection selection) {
		return (URI) ((IStructuredSelection) selection).getFirstElement();
	}

	private static String uriToReadable(final URI uri) {
		final String uriAsString = uri.toString();
		final int firstSlash = uriAsString.indexOf('/');
		final int secondSlash = uriAsString.indexOf('/', firstSlash + 1);
		return uriAsString.substring(secondSlash + 1);
	}

	@Override
	public void init(final IWorkbench workbench) {
		setPreferenceStore(PluginSupportPlugin.getDefault().getPreferenceStore());
	}

	@Override
	public boolean performOk() {
		final boolean ok = super.performOk();

		/* Check if the preferences changed. Don't want to rebuild the workspace if they didn't */
		final boolean changed = !originalOverriddenAadl.equals(overriddenAadl);

		if (changed) {
			PredeclaredProperties.setOverriddenResources(overriddenAadl);
			PredeclaredProperties.closeAndReopenProjects();
		}

		return ok;
	}

	private static boolean filterContainer(final Map<Object, Boolean> visible, final IResource irsrc,
			final String fileName) throws CoreException {
		boolean isViz = false;
		if (irsrc instanceof IFile) {
			isViz = irsrc.getName().equalsIgnoreCase(fileName);
		} else if (irsrc instanceof IContainer) {
			if (!(irsrc instanceof IProject) || ((IProject) irsrc).isOpen()) {
				for (final IResource child : ((IContainer) irsrc).members()) {
					isViz |= filterContainer(visible, child, fileName);
				}
			}
		}
		visible.put(irsrc, isViz);
		return isViz;
	}

	private URI getWorkspaceContributedResource(final String fileName) {
		final ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(getShell(),
				new WorkbenchLabelProvider(), new WorkbenchContentProvider());
		dialog.setTitle("Choose the Replacement Resource");
		dialog.setMessage(
				"Choose a file named \"" + fileName
						+ "\" in the workspace to override the contributed resource." + System.lineSeparator()
						+ "Only acceptable replacements are shown below.");
		dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());

		final Map<Object, Boolean> visible = new HashMap<>();
		try {
			for (final IResource irsrc : ResourcesPlugin.getWorkspace().getRoot().members()) {
				filterContainer(visible, irsrc, fileName);
			}
		} catch (final CoreException e) {
			OsateUiPlugin.log(e);
		}

		dialog.setAllowMultiple(false); // only singleton selections
		dialog.addFilter(new ViewerFilter() {
			@Override
			public boolean select(final Viewer viewer, final Object parentElement, final Object element) {
				return visible.getOrDefault(element, false);
			}
		});
		dialog.setValidator(selection -> {
			/*
			 * Must a be singleton selection of an IFile whose file name is
			 * the given filename.
			 */
			if (selection.length == 1 && selection[0] instanceof IFile &&
					((IFile) selection[0]).getName().equalsIgnoreCase(fileName)) {
				return new Status(IStatus.OK, OsateUiPlugin.PLUGIN_ID, "");
			} else {
				return new Status(IStatus.ERROR, OsateUiPlugin.PLUGIN_ID,
						"Must select a file named '" + fileName + "'.");
			}
		});

		if (dialog.open() == Window.OK) {
			return URI.createPlatformResourceURI(((IResource) dialog.getFirstResult()).getFullPath().toString(), false);
		} else {
			return null;
		}
	}

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

	protected TreeNode createTreeHierarchy() {
		final List<URI> contributedAadl = PluginSupportUtil.getContributedAadl();

		TreeNode root = new TreeNode();
		TreeNode cont = new TreeNode("Plug-in Contributions", 0);
		TreeNode pSet = new TreeNode("Predeclared_Property_Sets", 1);

		HashMap<URI, Boolean> isInPropSet = new HashMap<URI, Boolean>();

		PredeclaredProperties.getContributedResources().stream().forEach(uri -> {
			OptionalInt firstSignificantIndex = PluginSupportUtil.getFirstSignificantIndex(uri);
			isInPropSet.put(uri, !(!firstSignificantIndex.isPresent()
					|| firstSignificantIndex.getAsInt() == uri.segmentCount() - 1));
		});

		for (URI fullPath : contributedAadl) {
			if (isInPropSet.containsKey(fullPath) && isInPropSet.get(fullPath)) {
				pSet.addNode(new TreeNode(fullPath.toString(), fullPath.lastSegment(),
						overriddenAadl.containsKey(fullPath)));
			} else {
				cont.addNode(new TreeNode(fullPath.toString(), fullPath.lastSegment(),
						overriddenAadl.containsKey(fullPath)));
			}
		}

		cont.addNode(pSet);
		root.addNode(cont);

		return root;
	}

	public class TreeContentProvider implements ITreeContentProvider {
		Object treeContent;

		@Override
		public void dispose() {
			// Nothing to do.
		}

		@SuppressWarnings("unchecked")
		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			treeContent = newInput;
		}

		@Override
		public Object[] getElements(Object inputElement) {
			return getChildren(inputElement);
		}

		@Override
		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof TreeNode) {
				return ((TreeNode) parentElement).getNode().toArray();
			} else {
				return null;
			}
		}

		@SuppressWarnings("unchecked")
		@Override
		public Object getParent(Object element) {
			if (element instanceof TreeNode) {
				return ((TreeNode) element).getParent();
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
			Image image = null;
			if (element instanceof TreeNode) {
				switch (((TreeNode) element).imageType) {
				case 0:
					image = OsateUiPlugin.getImageDescriptor("icons/library_obj.gif").createImage();
					break;
				case 1:
					image = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FOLDER);
					break;
				default:
					image = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);
					break;
				}
			}

			return image;
		}

		@Override
		public void dispose() {
			super.dispose();
		}

		@Override
		public String getText(Object element) {
			if (element instanceof TreeNode) {
				return ((TreeNode) element).getLabel();
			}

			return "";
		}
	}

	public class TreeNode {
		public TreeNode() {
		}

		public TreeNode(String path, String label, Boolean overridden) {
			this.path = path;
			this.label = label;
			this.overridden = overridden;
			this.imageType = 2;
		}

		public TreeNode(String label, int imageType) {
			this.label = label;
			this.overridden = false;
			this.imageType = imageType;
			this.path = "";
		}

		private String label;
		public String path;
		public Boolean overridden;
		public int imageType;

		protected List<TreeNode> nodes = new ArrayList<>();
		protected TreeNode parent;

		public Boolean canOverride() {
			return this.path != null && this.path.contains(".");
		}

		public String getLabel() {
			return (this.overridden ? "[Overridden] " : "") + this.label;
		}

		public List<TreeNode> getNode() {
			return this.nodes;
		}

		protected void addNode(TreeNode node) {
			this.nodes.add(node);
			node.parent = this;
		}

		protected TreeNode getParent() {
			return this.parent;
		}
	}

	public class Sorter extends ViewerSorter {
		@Override
		public int category(Object element) {
			if (element instanceof TreeNode) {
				if (((TreeNode) element).imageType == 1) {
					return 0;
				}
			}

			return 1 + super.category(element);
		}
	}
}