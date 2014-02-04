package org.osate.xtext.aadl2.ui.propertyview.associationwizard.assistant;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierType;
import org.osate.aadl2.MetaclassReference;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.ui.UiUtil;
import org.osate.xtext.aadl2.properties.util.EMFIndexRetrieval;

public class ClassifierAssistant extends AbstractAssistant
{
	private final ClassifierType type;
	private final NamedElement holder;
	private final HashMap<AadlPackage, HashSet<Classifier>> validClassifiers;
	
	private Label noClassifiersLabel = null;
	private TreeViewer classifierViewer = null;
	
	public ClassifierAssistant(Composite parent, ClassifierType type, NamedElement holder, AssistantValueChangedListener listener) {
		super(parent, listener);
		this.type = type;
		this.holder = holder;
		validClassifiers = new HashMap<AadlPackage, HashSet<Classifier>>();
		fillValidClassifiers();
		layoutComponents();
	}
	
	private void fillValidClassifiers() {
		for (IEObjectDescription packageDescription : EMFIndexRetrieval.getAllPackagesInWorkspace(holder)) {
			AadlPackage currentPackage = (AadlPackage)OsateResourceUtil.getResourceSet().getEObject(packageDescription.getEObjectURI(), true);
			addAllToValidClassifiers(currentPackage, currentPackage.getPublicSection().getOwnedClassifiers());
		}
		NamedElement holderRoot = holder.getElementRoot();
		if (holderRoot instanceof AadlPackage && ((AadlPackage)holderRoot).getPrivateSection() != null) {
			addAllToValidClassifiers((AadlPackage)holderRoot, ((AadlPackage)holderRoot).getPrivateSection().getOwnedClassifiers());
		}
	}
	
	private void addAllToValidClassifiers(AadlPackage aadlPackage, EList<Classifier> classifiers) {
		for (Classifier classifier : classifiers) {
			if (type.getClassifierReferences().size() == 0 || isValidMetaclass(classifier.eClass()))
				addToValidClassifiers(aadlPackage, classifier);
		}
	}
	
	private boolean isValidMetaclass(EClass classifierMetaclass)
	{
		for (MetaclassReference metaclassReference : type.getClassifierReferences())
		{
			EClass acceptableMetaclass = metaclassReference.getMetaclass();
			if (acceptableMetaclass.isSuperTypeOf(classifierMetaclass) && checkAbstract(acceptableMetaclass, classifierMetaclass))
				return true;
		}
		return false;
	}
	
	private boolean checkAbstract(EClass acceptableMetaclass, EClass classifierMetaclass)
	{
		if (Aadl2Package.eINSTANCE.getAbstract().isSuperTypeOf(classifierMetaclass))
		{
			return Aadl2Package.eINSTANCE.getAbstract().isSuperTypeOf(acceptableMetaclass);
		}
		return true;
	}
	
	private void addToValidClassifiers(AadlPackage aadlPackage, Classifier classifier) {
		HashSet<Classifier> setForCurrentPackage = validClassifiers.get(aadlPackage);
		if (setForCurrentPackage == null) {
			setForCurrentPackage = new HashSet<Classifier>();
			validClassifiers.put(aadlPackage, setForCurrentPackage);
		}
		setForCurrentPackage.add(classifier);
	}
	
	private void layoutComponents() {
		setLayout(new GridLayout(1, false));
		
		if (validClassifiers.size() == 0) {
			noClassifiersLabel = new Label(this, SWT.WRAP);
			noClassifiersLabel.setText("There are no valid classifiers within scope of the selected property holder.");
			noClassifiersLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		}
		else {
			classifierViewer = new TreeViewer(this, SWT.BORDER | SWT.SINGLE);
			classifierViewer.setContentProvider(new ITreeContentProvider()
			{
				@Override
				public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
				}
				
				@Override
				public void dispose() {
				}
				
				@Override
				public Object[] getElements(Object inputElement) {
					return getChildren(inputElement);
				}
				
				@Override
				public boolean hasChildren(Object element) {
					Object[] children = getChildren(element);
					return children != null && children.length > 0;
				}
				
				@Override
				public Object getParent(Object element) {
					if (element instanceof HashMap)
						return null;
					else if (element instanceof AadlPackage)
						return validClassifiers;
					else if (element instanceof Classifier) {
						for (Entry<AadlPackage, HashSet<Classifier>> currentEntry : validClassifiers.entrySet()) {
							if (currentEntry.getValue().contains(element))
								return currentEntry.getKey();
						}
						return null;
					}
					else
						return null;
				}
				
				@Override
				public Object[] getChildren(Object parentElement) {
					if (parentElement instanceof HashMap)
						return validClassifiers.keySet().toArray();
					else if (parentElement instanceof AadlPackage)
						return validClassifiers.get(parentElement).toArray();
					else
						return null;
				}
			});
			classifierViewer.setInput(validClassifiers);
			classifierViewer.setLabelProvider(UiUtil.getModelElementLabelProvider());
			classifierViewer.setSorter(new ViewerSorter());
			classifierViewer.getTree().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			classifierViewer.addSelectionChangedListener(new ISelectionChangedListener() {
				@Override
				public void selectionChanged(SelectionChangedEvent event) {
					requestUpdate();
				}
			});
		}
	}
	
	@Override
	public String getValueText() {
		Classifier classifier = (Classifier)((IStructuredSelection)classifierViewer.getSelection()).getFirstElement();
		StringBuilder valueText = new StringBuilder("classifier (");
		NamedElement holderRoot = holder.getElementRoot();
		NamedElement classifierRoot = classifier.getElementRoot();
		if (holderRoot instanceof AadlPackage && classifierRoot instanceof AadlPackage && holderRoot.equals(classifierRoot))
			valueText.append(classifier.getName());
		else
			valueText.append(classifier.getQualifiedName());
		valueText.append(")");
		return valueText.toString();
	}
	
	@Override
	public boolean isComplete() {
		if (validClassifiers.size() == 0)
			return false;
		else
			return ((IStructuredSelection)classifierViewer.getSelection()).getFirstElement() instanceof Classifier;
	}

	@Override
	public void setAssistantEnabled(boolean enabled) {
		if (validClassifiers.size() == 0)
			noClassifiersLabel.setEnabled(enabled);
		else
			classifierViewer.getTree().setEnabled(enabled);
	}
}