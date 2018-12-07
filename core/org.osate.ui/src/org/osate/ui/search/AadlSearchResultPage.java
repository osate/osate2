package org.osate.ui.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.ISearchResultListener;
import org.eclipse.search.ui.ISearchResultPage;
import org.eclipse.search.ui.ISearchResultViewPart;
import org.eclipse.search.ui.SearchResultEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.parsesupport.AObject;
import org.osate.search.AadlSearchResult;
import org.osate.search.AadlSearchResultEvent;
import org.osate.search.FoundDeclarationEvent;
import org.osate.search.FoundReferenceEvent;
import org.osate.xtext.aadl2.ui.internal.Aadl2Activator;

import com.google.inject.Inject;
import com.google.inject.Injector;

public final class AadlSearchResultPage implements ISearchResultListener, ISearchResultPage {
	@Inject
	private IURIEditorOpener editorOpener;

	private AadlSearchResult searchResult;
	private IPageSite pageSite;
	private String id;

	private ISearchResultViewPart viewPart;
	private Composite root;
	private TreeViewer treeViewer;

	private final Map<URI, List<Object>> results = new TreeMap<URI, List<Object>>((uri1, uri2) -> {
		final String[] segments1 = uri1.segments();
		final String[] segments2 = uri2.segments();
		final int length1 = segments1.length;
		final int length2 = segments2.length;
		final int max = Math.min(length1, length2);

		for (int i = 0; i < max; i++) {
			final int compareResult = String.CASE_INSENSITIVE_ORDER.compare(segments1[i], segments2[i]);
			if (compareResult != 0) {
				return compareResult;
			}
		}
		// If we are here, then all the segments are equal: shortest goes first
		return length1 - length2;
	});

	public AadlSearchResultPage() {
		// XXX Stole this from AadlNavigatorActionProvider, not sure if this is correct
		final Injector injector = Aadl2Activator.getInstance().getInjector(Aadl2Activator.ORG_OSATE_XTEXT_AADL2_AADL2);
		editorOpener = injector.getInstance(IURIEditorOpener.class);
	}

	@Override
	public IPageSite getSite() {
		return pageSite;
	}

	@Override
	public void init(final IPageSite site) throws PartInitException {
		pageSite = site;
	}

	@Override
	public void createControl(final Composite parent) {
		root = new Composite(parent, SWT.NULL);
		final Tree tree = new Tree(root, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		tree.setLayoutData(new GridData(GridData.FILL_BOTH));
		tree.setLinesVisible(false);
		tree.setHeaderVisible(false);
		tree.setFont(parent.getFont());

		final TreeColumn column = new TreeColumn(tree, SWT.LEFT);
		final TreeColumnLayout treeLayout = new TreeColumnLayout();
		treeLayout.setColumnData(column, new ColumnWeightData(1, true));
		root.setLayout(treeLayout);

		treeViewer = new TreeViewer(tree);
		treeViewer.setLabelProvider(new TreeLabelProvider());
		treeViewer.setContentProvider(new TreeContentProvider());
		treeViewer.setInput(results);

		treeViewer.addDoubleClickListener(event -> {
			openURI(event);
		});
	}

	@Override
	public void dispose() {
		// nothind to do
	}

	@Override
	public Control getControl() {
		return root;
	}

	@Override
	public void setActionBars(IActionBars actionBars) {
		// nothing to do
	}

	@Override
	public void setFocus() {
		root.setFocus();
	}

	@Override
	public Object getUIState() {
		return null;
	}

	@Override
	public void setInput(final ISearchResult search, final Object uiState) {
		if (search == null) {
			// clean up old search
			if (searchResult != null) {
				searchResult.removeListener(this);
				searchResult = null;
			}
			results.clear();
		} else {
			final AadlSearchResult aadlSearchResult = (AadlSearchResult) search;
			searchResult = aadlSearchResult;
			aadlSearchResult.addListener(this);
			aadlSearchResult.getFoundDeclarations().forEach(objDesc -> addDeclaration(objDesc));
			aadlSearchResult.getFoundReferences().forEach(refDesc -> addReference(refDesc));
			Display.getDefault().asyncExec(() -> treeViewer.refresh());
		}
	}

	@Override
	public void setViewPart(final ISearchResultViewPart part) {
		viewPart = part;
	}

	@Override
	public void restoreState(IMemento memento) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveState(final IMemento memento) {
		// nothing to do

	}

	@Override
	public void setID(final String id) {
		this.id = id;
	}

	@Override
	public String getID() {
		return id;
	}

	@Override
	public String getLabel() {
		return (searchResult == null) ? "No search result" : searchResult.getLabel();
	}

	@Override
	public void searchResultChanged(final SearchResultEvent e) {
		if (e instanceof AadlSearchResultEvent) {
			if (e instanceof FoundDeclarationEvent) {
				final IEObjectDescription objDesc = ((FoundDeclarationEvent) e).getObjectDescription();
				addDeclaration(objDesc);
			} else if (e instanceof FoundReferenceEvent) {
				final IReferenceDescription refDesc = ((FoundReferenceEvent) e).getReferenceDescription();
				addReference(refDesc);
			}
			Display.getDefault().asyncExec(() -> {
				viewPart.updateLabel();
				treeViewer.refresh();
			});
		}
	}

	private void addReference(final IReferenceDescription refDesc) {
		addResult(refDesc.getSourceEObjectUri(), refDesc);
	}

	private void addDeclaration(final IEObjectDescription objDesc) {
		addResult(objDesc.getEObjectURI(), objDesc);
	}

	private void addResult(final URI uri, final Object obj) {
		List<Object> list = results.get(uri);
		if (list == null) {
			list = new ArrayList<Object>();
			results.put(uri, list);
		}
		list.add(obj);
	}

	// Called in the UI thread
	private final void openURI(final DoubleClickEvent event) {
		final IStructuredSelection selected = (IStructuredSelection) event.getSelection();
		final Object selectedNode = selected.getFirstElement();

		if (selectedNode instanceof IEObjectDescription) {
			editorOpener.open(((IEObjectDescription) selectedNode).getEObjectURI(), true);
		} else if (selectedNode instanceof IReferenceDescription) {
			final IReferenceDescription refDesc = (IReferenceDescription) selectedNode;
			editorOpener.open(refDesc.getSourceEObjectUri(), refDesc.getEReference(), refDesc.getIndexInList(), true);
		} else {
			if (treeViewer.isExpandable(selectedNode)) {
				if (treeViewer.getExpandedState(selectedNode)) {
					treeViewer.collapseToLevel(selectedNode, 1);
				} else {
					treeViewer.expandToLevel(selectedNode, 1);
				}
			}
		}
	}

	private final class TreeContentProvider implements ITreeContentProvider {
		@SuppressWarnings("rawtypes")
		@Override
		public Object[] getElements(final Object inputElement) {
			return ((Map) inputElement).keySet().toArray();
		}

		@SuppressWarnings("rawtypes")
		@Override
		public Object[] getChildren(final Object parentElement) {
			return ((List) results.get(parentElement)).toArray();
		}

		@Override
		public Object getParent(final Object element) {
			if (element instanceof IEObjectDescription) {
				return ((IEObjectDescription) element).getEObjectURI();
			} else if (element instanceof IReferenceDescription) {
				return ((IReferenceDescription) element).getSourceEObjectUri();
			} else {
				return null;
			}
		}

		@Override
		public boolean hasChildren(final Object element) {
			if (element instanceof URI) {
				return true;
			}
			return false;
		}
	}

	private final class TreeLabelProvider extends LabelProvider {
		@Override
		public Image getImage(final Object element) {
			// TODO Get some images
			return null;
		}

		private String getContainerName(final AObject aObject) {
			final Classifier classifier = AadlUtil.getContainingClassifier(aObject);
			if (classifier != null) {
				return " in " + classifier.getName();
			} else {
				return "";
			}
		}

		@Override
		public String getText(final Object element) {
			if (element instanceof URI) {
				final String[] segments = ((URI) element).segments();
				final StringBuilder sb = new StringBuilder();
				for (final String segment : segments) {
					sb.append('/');
					sb.append(segment);
				}
				return sb.toString();
			} else if (element instanceof IEObjectDescription) {
				final IEObjectDescription objDesc = (IEObjectDescription) element;
				return "Declaration of " + objDesc.getName().toString("::");
			} else if (element instanceof IReferenceDescription) {
				final IReferenceDescription refDesc = (IReferenceDescription) element;
				final URI targetEObjectUri = refDesc.getTargetEObjectUri();
				final URI sourceEObjectUri = refDesc.getSourceEObjectUri();
				final NamedElement namedElement = (NamedElement) searchResult.getResourceSet()
						.getEObject(targetEObjectUri, true);
				final AObject srcObject = (AObject) searchResult.getResourceSet().getEObject(sourceEObjectUri, true);
				return "Reference to " + namedElement.getName() + getContainerName(srcObject);
			} else {
				return null;
			}
		}
	}

}
