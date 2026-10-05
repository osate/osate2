/*
 * <copyright>
 * Copyright (c) 2004-2026 Carnegie Mellon University, all rights reserved.
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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Set;

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
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Tree;
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
 * This class represents the OSATE > Contributed Resources workspace preferences.
 * @since 5.0
 */
public final class ContributedResourcesPreferencePage extends PreferencePage
		implements IWorkbenchPreferencePage {
	private final Map<URI, URI> overriddenAadl = new HashMap<>();
	private final Set<URI> disabledContribResources = new HashSet<>();

	private TreeViewer tree;
	private Button disableButton;
	private Button overrideButton;
	private Button restoreButton;
	private TreeNode selectedNode;

	public ContributedResourcesPreferencePage() {
		super("Contributed Resources");
	}

	@Override
	public Control createContents(final Composite parent) {
		overriddenAadl.clear();
		overriddenAadl.putAll(PredeclaredProperties.getOverriddenResources());
		disabledContribResources.clear();
		disabledContribResources.addAll(PredeclaredProperties.getDisabledContributions());

		final var composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));

		final var explanation = new Label(composite, SWT.WRAP);
		final var explanationLayout = new GridData(SWT.FILL, SWT.TOP, true, false);
		explanationLayout.widthHint = 650;
		explanation.setLayoutData(explanationLayout);
		explanation.setText("Plug-ins contribute property sets and packages to every project in the workspace. "
				+ "Select a resource to disable it, override it with a workspace file, or restore the original contribution. "
				+ "A resource cannot be both disabled and overridden. AADL_Project cannot be disabled.");

		tree = createTree(composite);
		tree.setContentProvider(new TreeContentProvider());
		tree.setAutoExpandLevel(3);
		tree.setInput(createTreeHierarchy());
		tree.setComparator(new ViewerComparator());
		tree.setSorter(new Sorter());
		tree.addSelectionChangedListener(event -> {
			final var selection = (IStructuredSelection) event.getSelection();
			selectedNode = selection.getFirstElement() instanceof TreeNode node ? node : null;
			updateButtons();
		});
		tree.addDoubleClickListener(event -> {
			final var selection = (IStructuredSelection) event.getSelection();
			if (selection.getFirstElement() instanceof TreeNode node) {
				if (node.canOverride()) {
					doOverrideAction(node);
				} else {
					tree.setExpandedState(node, !tree.getExpandedState(node));
				}
			}
		});

		final var actions = new Composite(composite, SWT.NONE);
		actions.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		actions.setLayout(new GridLayout(3, false));
		disableButton = new Button(actions, SWT.PUSH);
		disableButton.setText("Disable");
		disableButton.setToolTipText("Exclude this contribution from all projects in the workspace.");
		disableButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				if (canDisableSelection()) {
					disabledContribResources.add(URI.createURI(selectedNode.path));
					refreshState();
				}
			}
		});

		overrideButton = new Button(actions, SWT.PUSH);
		overrideButton.setText("Override...");
		overrideButton.setToolTipText("Use a workspace file instead of the contributed resource.");
		overrideButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				if (selectedNode != null) {
					doOverrideAction(selectedNode);
				}
			}
		});

		restoreButton = new Button(actions, SWT.PUSH);
		restoreButton.setText("Restore");
		restoreButton.setToolTipText("Enable the original contribution and remove any workspace override.");
		restoreButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				if (selectedNode != null && selectedNode.canOverride()) {
					final var uri = URI.createURI(selectedNode.path);
					overriddenAadl.remove(uri);
					disabledContribResources.remove(uri);
					refreshState();
				}
			}
		});
		updateButtons();
		return composite;
	}

	private boolean canDisableSelection() {
		if (selectedNode == null || !selectedNode.canOverride()) {
			return false;
		}
		final var uri = URI.createURI(selectedNode.path);
		return !PredeclaredProperties.isRequiredContribution(uri) && !overriddenAadl.containsKey(uri)
				&& !disabledContribResources.contains(uri);
	}

	private void updateButtons() {
		final var uri = selectedNode != null && selectedNode.canOverride() ? URI.createURI(selectedNode.path) : null;
		disableButton.setEnabled(canDisableSelection());
		overrideButton.setEnabled(uri != null);
		restoreButton.setEnabled(uri != null
				&& (overriddenAadl.containsKey(uri) || disabledContribResources.contains(uri)));
	}

	private void refreshState() {
		tree.refresh();
		updateButtons();
	}

	private void doOverrideAction(final TreeNode node) {
		if (node.canOverride()) {
			final var uri = URI.createURI(node.path);
			final var replacement = getWorkspaceContributedResource(uri.lastSegment());
			if (replacement != null) {
				overriddenAadl.put(uri, replacement);
				disabledContribResources.remove(uri);
				refreshState();
			}
		}
	}

	@Override
	public void init(final IWorkbench workbench) {
		setPreferenceStore(PluginSupportPlugin.getDefault().getPreferenceStore());
	}

	@Override
	protected void performDefaults() {
		overriddenAadl.clear();
		disabledContribResources.clear();
		refreshState();
		super.performDefaults();
	}

	@Override
	public boolean performOk() {
		if (!super.performOk()) {
			return false;
		}
		if (!PredeclaredProperties.getOverriddenResources().equals(overriddenAadl)
				|| !new HashSet<>(PredeclaredProperties.getDisabledContributions()).equals(disabledContribResources)) {
			// Save disabled resources first: setting an override enables its replacement.
			PredeclaredProperties.setDisabledContributions(new ArrayList<>(disabledContribResources));
			PredeclaredProperties.setOverriddenResources(overriddenAadl);
			PredeclaredProperties.closeAndReopenProjects();
		}
		return true;
	}

	@Override
	public void performHelp() {
		PlatformUI.getWorkbench().getHelpSystem().setHelp(getShell(), "org.osate.ui.help_dialog_contribRes");
		PlatformUI.getWorkbench().getHelpSystem().displayHelp("org.osate.ui.help_dialog_contribRes");
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
						+ "Only files with the same name are shown. The replacement will be enabled; "
						+ "an overridden resource cannot be disabled.");
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
		final var treeComposite = new Composite(parent, SWT.NONE);
		final var layoutData = new GridData(SWT.FILL, SWT.FILL, true, true);
		layoutData.widthHint = 650;
		layoutData.heightHint = 300;
		treeComposite.setLayoutData(layoutData);

		final var widget = new Tree(treeComposite, SWT.SINGLE | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		widget.setLinesVisible(true);
		widget.setHeaderVisible(true);
		widget.setFont(parent.getFont());
		final var viewer = new TreeViewer(widget);
		final var resourceColumn = new TreeViewerColumn(viewer, SWT.LEFT);
		resourceColumn.getColumn().setText("Resource");
		final var statusColumn = new TreeViewerColumn(viewer, SWT.LEFT);
		statusColumn.getColumn().setText("Status");
		// Set the default after creating the columns; the sorter also uses it for resource names.
		viewer.setLabelProvider(new FileLabelProvider(null, null));
		statusColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (!(element instanceof TreeNode node) || !node.canOverride()) {
					return "";
				}
				final var uri = URI.createURI(node.path);
				if (disabledContribResources.contains(uri)) {
					return "Disabled";
				}
				final var replacement = overriddenAadl.get(uri);
				return replacement == null ? "Contributed by " + uri.segment(1)
						: "Overridden by " + replacement.toPlatformString(true);
			}
		});
		final var layout = new TreeColumnLayout();
		layout.setColumnData(resourceColumn.getColumn(), new ColumnWeightData(45, 250));
		layout.setColumnData(statusColumn.getColumn(), new ColumnWeightData(55, 300));
		treeComposite.setLayout(layout);
		return viewer;
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
				pSet.addNode(new TreeNode(fullPath.toString(), fullPath.lastSegment()));
			} else {
				cont.addNode(new TreeNode(fullPath.toString(), fullPath.lastSegment()));
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

	public class FileLabelProvider extends ColumnLabelProvider {
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

		public TreeNode(String path, String label) {
			this.path = path;
			this.label = label;
			this.imageType = 2;
		}

		public TreeNode(String label, int imageType) {
			this.label = label;
			this.imageType = imageType;
			this.path = "";
		}

		private String label;
		public String path;
		public int imageType;

		protected List<TreeNode> nodes = new ArrayList<>();
		protected TreeNode parent;

		public Boolean canOverride() {
			return this.path != null && !this.path.isEmpty();
		}

		public String getLabel() {
			return this.label;
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