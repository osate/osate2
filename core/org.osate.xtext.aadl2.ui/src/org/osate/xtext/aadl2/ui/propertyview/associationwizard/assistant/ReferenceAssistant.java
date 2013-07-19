package org.osate.xtext.aadl2.ui.propertyview.associationwizard.assistant;

import java.util.ArrayList;

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
import org.eclipse.swt.widgets.TreeItem;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierFeature;
import org.osate.aadl2.Element;
import org.osate.aadl2.MetaclassReference;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.ReferenceType;
import org.osate.aadl2.Subcomponent;
import org.osate.ui.UiUtil;

public class ReferenceAssistant extends AbstractAssistant
{
	private final ReferenceType type;
	private final NamedElement holder;
	
	private TreeViewer referenceViewer = null;
	
	public ReferenceAssistant(Composite parent, ReferenceType type, NamedElement holder, AssistantValueChangedListener listener)
	{
		super(parent, listener);
		this.type = type;
		this.holder = holder;
		layoutComponents();
	}
	
	private void layoutComponents()
	{
		setLayout(new GridLayout(1, false));
		
		referenceViewer = new TreeViewer(this, SWT.BORDER | SWT.SINGLE);
		referenceViewer.setContentProvider(new ITreeContentProvider()
		{
			@Override
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput)
			{
			}
			
			@Override
			public void dispose()
			{
			}
			
			@Override
			public boolean hasChildren(Object element)
			{
				Object[] children = getChildren(element);
				return children != null && children.length > 0;
			}
			
			@Override
			public Object getParent(Object element)
			{
				return null;
			}
			
			@Override
			public Object[] getElements(Object inputElement)
			{
				return getChildren(inputElement);
			}
			
			@Override
			public Object[] getChildren(Object parentElement)
			{
				if (parentElement instanceof Classifier)
				{
					ArrayList<ClassifierFeature> classifierFeatures = new ArrayList<ClassifierFeature>();
					for (NamedElement member : ((Classifier)parentElement).getMembers())
					{
						if (member instanceof ClassifierFeature)
						{
							if (type.getNamedElementReferences().size() == 0)
								classifierFeatures.add((ClassifierFeature)member);
							else if (isAcceptableMember(member))
								classifierFeatures.add((ClassifierFeature)member);
							else if (member instanceof Subcomponent && subcomponentHasAcceptableMembers((Subcomponent)member))
								classifierFeatures.add((ClassifierFeature)member);
						}
					}
					return classifierFeatures.toArray();
				}
				else if (parentElement instanceof Subcomponent)
				{
					Subcomponent subcomponent = (Subcomponent)parentElement;
					if (subcomponent.getClassifier() == null)
						return null;
					else
						return getChildren(subcomponent.getClassifier());
				}
				else
					return null;
			}
		});
		referenceViewer.setLabelProvider(UiUtil.getAObjectLabelProvider());
		referenceViewer.setSorter(new ViewerSorter());
		referenceViewer.setInput(holder);
		referenceViewer.getTree().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		referenceViewer.addSelectionChangedListener(new ISelectionChangedListener()
		{
			@Override
			public void selectionChanged(SelectionChangedEvent event)
			{
				requestUpdate();
			}
		});
	}
	
	private boolean isAcceptableMember(NamedElement member)
	{
		for (MetaclassReference metaclassReference : type.getNamedElementReferences())
			if (metaclassReference.getMetaclass().isSuperTypeOf(member.eClass()))
				return true;
		return false;
	}
	
	private boolean subcomponentHasAcceptableMembers(Subcomponent subcomponent)
	{
		if (subcomponent.getClassifier() == null)
			return false;
		for (NamedElement subcomponentMember : subcomponent.getClassifier().getMembers())
		{
			if (subcomponentMember instanceof ClassifierFeature)
			{
				if (isAcceptableMember(subcomponentMember))
					return true;
				if (subcomponentMember instanceof Subcomponent && subcomponentHasAcceptableMembers((Subcomponent)subcomponentMember))
					return true;
			}
		}
		return false;
	}
	
	@Override
	public String getValueText()
	{
		StringBuilder referencePath = new StringBuilder(")");
		for (TreeItem currentItem = referenceViewer.getTree().getSelection()[0]; currentItem != null; currentItem = currentItem.getParentItem())
		{
			referencePath.insert(0, ((NamedElement)currentItem.getData()).getName());
			if (currentItem.getParentItem() != null)
				referencePath.insert(0, '.');
		}
		referencePath.insert(0, "reference (");
		return referencePath.toString();
	}
	
	@Override
	public boolean isComplete()
	{
		if (((IStructuredSelection)referenceViewer.getSelection()).size() == 1)
		{
			if (type.getNamedElementReferences().size() == 0)
				return true;
			else
			{
				Object selectedObject = ((IStructuredSelection)referenceViewer.getSelection()).getFirstElement();
				Element selectedElement = (Element)selectedObject;
				for (MetaclassReference metaclassReference : type.getNamedElementReferences())
				{
					if (metaclassReference.getMetaclass().isSuperTypeOf(selectedElement.eClass()))
						return true;
				}
				return false;
			}
		}
		else
			return false;
	}
	
	@Override
	public void setAssistantEnabled(boolean enabled)
	{
		referenceViewer.getTree().setEnabled(enabled);
	}
}