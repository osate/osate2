package org.osate.xtext.aadl2.ui.propertyview.associationwizard;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.serializer.ISerializer;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.xtext.aadl2.properties.util.EMFIndexRetrieval;

public class PropertyDefinitionWizardPage extends WizardPage {
	private static final String COLUMN_PROPERTY_DEFINITION = "Property Definition";
	private static final String COLUMN_PROPERTY_TYPE = "Property Type";
	
	private final NamedElement holder;
	private final PropertyDefinitionSelectionChangedListener listener;
	private final ISerializer serializer;
	
	private TreeViewer definitionsViewer = null;
	
	public PropertyDefinitionWizardPage(NamedElement holder, ISerializer serializer, PropertyDefinitionSelectionChangedListener listener) {
		super("Property Definition Wizard Page");
		this.holder = holder;
		this.listener = listener;
		this.serializer = serializer;
		setTitle("PropertyDefinition");
		setDescription("Select a property definition.");
	}
	
	@Override
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		
		definitionsViewer = new TreeViewer(composite, SWT.SINGLE | SWT.BORDER | SWT.FULL_SELECTION);
		definitionsViewer.getTree().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		Tree tree = definitionsViewer.getTree();
		TableLayout tableLayout = new TableLayout();
		tree.setLayout(tableLayout);
		tree.setLinesVisible(true);
		tree.setHeaderVisible(true);
		
		TreeColumn column = new TreeColumn(tree, SWT.LEFT);
		column.setText(COLUMN_PROPERTY_DEFINITION);
		tableLayout.addColumnData(new ColumnWeightData(1, true));
		
		column = new TreeColumn(tree, SWT.LEFT);
		column.setText(COLUMN_PROPERTY_TYPE);
		tableLayout.addColumnData(new ColumnWeightData(1, true));
		
		definitionsViewer.setContentProvider(new ITreeContentProvider() {
			@Override
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			}
			
			@Override
			public void dispose() {
			}
			
			@Override
			public boolean hasChildren(Object element) {
				Object[] children = getChildren(element);
				return children != null && children.length > 0;
			}
			
			@Override
			public Object getParent(Object element) {
				if (element instanceof PropertySet)
					return definitionsViewer.getInput();
				else if (element instanceof Property)
					return ((Property)element).eContainer();
				else
					return null;
			}
			
			@Override
			public Object[] getElements(Object inputElement) {
				return getChildren(inputElement);
			}
			
			@Override
			public Object[] getChildren(Object parentElement) {
				if (parentElement instanceof EList<?>) {
					ArrayList<PropertySet> applicablePropertySets = new ArrayList<PropertySet>();
					for (Iterator<?> iter = ((EList<?>)parentElement).iterator(); iter.hasNext();) {
						PropertySet currentPS = (PropertySet)OsateResourceUtil.getResourceSet().getEObject(((IEObjectDescription)iter.next()).getEObjectURI(), true);
						if (hasAcceptableDefinitions(holder, currentPS))
							applicablePropertySets.add(currentPS);
					}
					return applicablePropertySets.toArray();
				}
				else if (parentElement instanceof PropertySet) {
					ArrayList<Property> applicablePropertyDefinitions = new ArrayList<Property>();
					for (Property currentDefinition : ((PropertySet)parentElement).getOwnedProperties()) {
						if (holder.acceptsProperty(currentDefinition))
							applicablePropertyDefinitions.add(currentDefinition);
					}
					return applicablePropertyDefinitions.toArray();
				}
				else
					return null;
			}
		});
		definitionsViewer.setLabelProvider(new ITableLabelProvider() {
			@Override
			public void removeListener(ILabelProviderListener listener) {
			}
			
			@Override
			public boolean isLabelProperty(Object element, String property) {
				return true;
			}
			
			@Override
			public void dispose() {
			}
			
			@Override
			public void addListener(ILabelProviderListener listener) {
			}
			
			@Override
			public String getColumnText(Object element, int columnIndex) {
				if (columnIndex == 0)
					//element should be a PropertySet or a Property.
					return ((NamedElement)element).getName();
				else if (columnIndex == 1) {
					if (element instanceof Property) {
						Property definition = (Property)element;
						return AssociationWizardUtil.unparse(serializer, definition.getPropertyType());
					}
					else
						return null;
				}
				else
					return null;
			}
			
			@Override
			public Image getColumnImage(Object element, int columnIndex) {
				return null;
			}
		});
		definitionsViewer.setSorter(new ViewerSorter() {
			@SuppressWarnings("unchecked")
			@Override
			public int compare(Viewer viewer, Object e1, Object e2) {
				//Each object should be a PropertySet or a Property
				return getComparator().compare(((NamedElement)e1).getName(), ((NamedElement)e2).getName());
			}
		});
		definitionsViewer.setInput(EMFIndexRetrieval.getAllPropertySetsInWorkspace(holder));
		definitionsViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				Object selectedElement = ((IStructuredSelection)definitionsViewer.getSelection()).getFirstElement();
				if (selectedElement instanceof Property) {
					setPageComplete(true);
					listener.propertyDefinitionSelectionChanged();
				}
				else
					setPageComplete(false);
			}
		});
		
		setPageComplete(((IStructuredSelection)definitionsViewer.getSelection()).getFirstElement() instanceof Property);
		setControl(composite);
	}
	
	public Property getSelectedDefinition() {
		return (Property)((IStructuredSelection)definitionsViewer.getSelection()).getFirstElement();
	}
	
	//Used to determine if the PropertySet ps should be displayed in the tree.
	private static boolean hasAcceptableDefinitions(NamedElement holder, PropertySet ps) {
		for (Property definition : ps.getOwnedProperties())
			if (holder.acceptsProperty(definition))
				return true;
		return false;
	}
}