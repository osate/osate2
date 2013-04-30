package org.osate.xtext.aadl2.ui.propertyview;

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.PageBook;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.xtext.aadl2.parser.antlr.Aadl2Parser;
import org.osate.xtext.aadl2.ui.MyAadl2Activator;
import org.osate.xtext.aadl2.ui.propertyview.associationwizard.PropertyAssociationWizard;

import com.google.inject.Inject;

/**
 * View that displays the AADL property value associations within a given AADL
 * model element.
 * 
 * @author aarong
 */
public class AadlPropertyView extends ViewPart implements ISelectionListener {
	private static final String SHOW_UNDEFINED_TRUE_TOOL_TIP = "Click to hide undefined properties";
	private static final String SHOW_UNDEFINED_FALSE_TOOL_TIP = "Click to show undefined properties";
	
	private static final String NO_PROPERTIES_TO_SHOW =
			"No properties to show: Please select a single object that is an AADL Property Holder.";
	
	/**
	 * Page book for switching between the tree viewer and the "no properties"
	 * message.
	 */
	private PageBook pageBook;
	
	/**
	 * Tree for displaying properties. Underlying model is a
	 * {@link java.util.List} of {@link PropertySet} objects.
	 */
	private TreeViewer treeViewer;
	
	/**
	 * The label for the no results message.
	 */
	private Label noPropertiesLabel;
	
	/**
	 * Action for toggling the display of nonexistent properties
	 */
	private Action showUndefinedAction = null;
	
	/**
	 * Action for creating a new Property Association without using any information
	 * from this view's selection
	 */
	private Action addNewPropertyAssociationToolbarAction = null;
	
	/**
	 * Model
	 */
	private PropertyViewModel model = null;
	
	/**
	 * The currently viewed model element
	 */
	/*
	 * This variable is used to carry the current selection across reloads
	 */
	protected URI currentSelectionUri = null;
	
	/**
	 * The editing domain for {@link #getCurrentElement()}.
	 */
	private EditingDomain editingDomain = null;
	
	private IXtextDocument xtextDocument = null;
	
	@Inject
	private ISerializer serializer;
	
	@Inject
	private Aadl2Parser aadl2Parser;
	
	@Inject
	private ILinker linker;
	
	@Override
	public void createPartControl(final Composite parent) {
		pageBook = new PageBook(parent, SWT.NULL);
		
		noPropertiesLabel = new Label(pageBook, SWT.LEFT);
		noPropertiesLabel.setText(NO_PROPERTIES_TO_SHOW);
		noPropertiesLabel.setAlignment(SWT.CENTER);
		noPropertiesLabel.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_LIST_BACKGROUND));
		
		model = new PropertyViewModel(serializer);
		model.setShowUndefined(false);
		treeViewer = new TreeViewer(pageBook, SWT.H_SCROLL | SWT.V_SCROLL);
		Tree tree = treeViewer.getTree();
		TableLayout tableLayout = new TableLayout();
		tree.setLayout(tableLayout);
		tree.setLinesVisible(true);
		tree.setHeaderVisible(true);
		new TreeColumn(tree, SWT.LEFT).setText("Property Association");
		tableLayout.addColumnData(new ColumnWeightData(1, true));
		new TreeColumn(tree, SWT.LEFT).setText("Status of the Association");
		tableLayout.addColumnData(new ColumnWeightData(1, true));
		treeViewer.setLabelProvider(model);
		treeViewer.setContentProvider(model);
		treeViewer.setInput(model.getInput());
		
		// Show the "nothing to show" page by default
		pageBook.showPage(noPropertiesLabel);
		getSite().getPage().addSelectionListener(this);
		createActions();
		fillToolbar();
//		createContextMenu();
	}
	
	private void showTree() {
		pageBook.showPage(treeViewer.getControl());
	}
	
	private void showNoProperties() {
		pageBook.showPage(noPropertiesLabel);
	}
	
	private void createActions() {
		showUndefinedAction = new Action() {
			@Override
			public void run() {
				model.toggleShowUndefined();
				updateActionStates();
				buildNewModel(getCurrentElement());
			}
		};
		showUndefinedAction.setImageDescriptor(MyAadl2Activator.getImageDescriptor("icons/propertyview/nonexistent_property.gif"));
		
		addNewPropertyAssociationToolbarAction = new Action() {
			@Override
			public void run() {
				PropertyAssociationWizard wizard = new PropertyAssociationWizard(xtextDocument, getCommandStack(), currentSelectionUri, serializer, aadl2Parser, linker);
				WizardDialog dialog = new WizardDialog(getShell(), wizard);
				if (dialog.open() == Window.OK)
					updateView();
			}
		};
		addNewPropertyAssociationToolbarAction.setToolTipText("New Property Association");
		addNewPropertyAssociationToolbarAction.setImageDescriptor(MyAadl2Activator.getImageDescriptor("icons/propertyview/new_pa.gif"));
		addNewPropertyAssociationToolbarAction.setEnabled(true);
		
		updateActionStates();
	}
	
	private void updateActionStates() {
		final boolean flag = model.getShowUndefined();
		showUndefinedAction.setChecked(flag);
		showUndefinedAction.setToolTipText(flag ? SHOW_UNDEFINED_TRUE_TOOL_TIP : SHOW_UNDEFINED_FALSE_TOOL_TIP);
	}
	
	private void fillToolbar() {
		IActionBars bars = getViewSite().getActionBars();
		IToolBarManager manager = bars.getToolBarManager();
		manager.add(showUndefinedAction);
		manager.add(addNewPropertyAssociationToolbarAction);
	}

	@Override
	public void setFocus() {
		treeViewer.getControl().setFocus();
	}
	
	/*
	 * Change the view when the selection changes.
	 */
	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		EObject currentSelection = null;
		if (!selection.isEmpty()) {
			if (part instanceof XtextEditor && selection instanceof ITextSelection) {
				xtextDocument = ((XtextEditor)part).getDocument();
				final ITextSelection textSelection = (ITextSelection)selection;
				currentSelection = xtextDocument.readOnly(new IUnitOfWork<EObject, XtextResource>() {
					@Override
					public EObject exec(XtextResource state) throws Exception {
						return new EObjectAtOffsetHelper().resolveContainedElementAt(state, textSelection.getOffset());
					}
				});
			}
			else if (selection instanceof IStructuredSelection && ((IStructuredSelection)selection).size() == 1) {
				Object selectedObject = ((IStructuredSelection)selection).getFirstElement();
				if (selectedObject instanceof EObject) {
					xtextDocument = null;
					currentSelection = (EObject)selectedObject;
				}
				else if (selectedObject instanceof EObjectNode) {
					xtextDocument = ((EObjectNode)selectedObject).getDocument();
					currentSelection = ((EObjectNode)selectedObject).readOnly(new IUnitOfWork<EObject, EObject>() {
						@Override
						public EObject exec(EObject state) throws Exception {
							return state;
						}
					});
				}
			}
		}
		if (currentSelection instanceof NamedElement) {
			if (currentSelection.eResource() != null) {
				currentSelectionUri = EcoreUtil.getURI(currentSelection);
				editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(currentSelection);
			}
			else {
				currentSelectionUri = null;
				editingDomain = null;
			}
		}
		else {
			currentSelectionUri = null;
			editingDomain = null;
		}
		
		// Update the view page
		updateView();
	}
	
	private NamedElement getCurrentElement() {
		NamedElement element = null;
		if (currentSelectionUri != null)
			element = (NamedElement)OsateResourceUtil.getResourceSet().getEObject(currentSelectionUri, true);
		return element;
	}
	
	/**
	 * Update the view's contents.
	 */
	private void updateView() {
		if (currentSelectionUri != null) {
			buildNewModel(getCurrentElement());
			showTree();
			addNewPropertyAssociationToolbarAction.setEnabled(true);
		}
		else {
			showNoProperties();
			addNewPropertyAssociationToolbarAction.setEnabled(false);
		}
	}
	
	private void buildNewModel(NamedElement element) {
		if (element != null) {
			model.rebuildModel(element);
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					treeViewer.refresh();
					treeViewer.expandAll();
				}
			});
		}
	}
	
	private Shell getShell() {
		return getViewSite().getWorkbenchWindow().getShell();
	}
	
	private CommandStack getCommandStack() {
		return (editingDomain == null) ? null : editingDomain.getCommandStack();
	}
}