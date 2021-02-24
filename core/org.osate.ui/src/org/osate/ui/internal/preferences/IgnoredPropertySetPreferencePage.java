package org.osate.ui.internal.preferences;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.viewers.ViewerSorter;
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
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.PlatformUI;
import org.osate.pluginsupport.PredeclaredProperties;
import org.osate.ui.dialogs.Dialog;
import org.osate.ui.utils.PropertySetModel;

/**
 * This class represents the OSATE > Property Set workspace preferences.
 * @since 6.0
 */
public class IgnoredPropertySetPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {
	private TreeViewer tree;
	private Button addButton, deleteButton;
	private TreeNode selectedNode;
	private TreeNode content;

	public IgnoredPropertySetPreferencePage() {
		super("Property Sets");
	}

	@Override
	public void init(IWorkbench workbench) {
		// TODO Auto-generated method stub

	}

	@Override
	protected Control createContents(Composite parent) {
		final Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(3, true));

		SashForm sashForm = new SashForm(composite, SWT.HORIZONTAL);
		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1);
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
				deleteButton.setEnabled(false);
			}

			for (final Iterator<?> iter = selection.iterator(); iter.hasNext();) {
				final Object object = iter.next();
				if (object instanceof TreeNode) {
					selectedNode = (TreeNode) object;
					deleteButton.setEnabled(true);
				}
			}
		});

		addButton = new Button(composite, SWT.PUSH);
		addButton.setLayoutData(new GridData(SWT.RIGHT, SWT.FILL, false, false));
		addButton.setText("Add");
		addButton.setToolTipText("Add Property Set name that will be ignored in the workspace.");
		addButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				String newPropSetName = Dialog.getInput("Add", "Type in a property set name to add it to ignored list",
						"", null);
				tree.add(content, new TreeNode(newPropSetName));
				PropertySetModel.setIgnoredPropertySetPreference(newPropSetName);
			}
		});

		deleteButton = new Button(composite, SWT.PUSH);
		deleteButton.setLayoutData(new GridData(SWT.CENTER, SWT.FILL, false, false));
		deleteButton.setText("Delete");
		deleteButton.setToolTipText("Delete Property Set from ignored list in the workspace.");
		deleteButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				if (selectedNode != null) {
					tree.remove(selectedNode);
					// delete this property set name from ignored list
					PropertySetModel.deletePropertySetFromIgnoredList(selectedNode.getLabel());
				}
			}
		});

		return composite;
	}

	@Override
	public void performHelp() {
		PlatformUI.getWorkbench().getHelpSystem().setHelp(getShell(), "org.osate.ui.help_dialog_propSet");
		PlatformUI.getWorkbench().getHelpSystem().displayHelp("org.osate.ui.help_dialog_propSet");
	}

	@Override
	protected void performDefaults() {
		PropertySetModel.resetIgnoredPropertySetPreference();
		PredeclaredProperties.closeAndReopenProjects();
	}

	@Override
	public boolean performOk() {
		PredeclaredProperties.closeAndReopenProjects();
		return super.performOk();
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
		TreeNode root = new TreeNode();
		content = new TreeNode("Currently Ignored Property Sets", 0);

		// get all property set names that were previously added by user
		for (String propSet : PropertySetModel.getAllAddedPropertySetNames()) {
			content.addNode(new TreeNode(propSet));
		}

		root.addNode(content);

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

		public TreeNode(String label) {
			this.label = label;
		}

		public TreeNode(String label, int imageType) {
			this.imageType = imageType;
			this.label = label;
		}

		private String label;
		private int imageType = 1;

		protected List<TreeNode> nodes = new ArrayList<>();
		protected TreeNode parent;

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