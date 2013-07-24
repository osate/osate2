package org.osate.xtext.aadl2.ui.propertyview.associationwizard.assistant;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.serializer.ISerializer;
import org.osate.aadl2.AadlBoolean;
import org.osate.aadl2.AadlInteger;
import org.osate.aadl2.AadlReal;
import org.osate.aadl2.AadlString;
import org.osate.aadl2.ClassifierType;
import org.osate.aadl2.EnumerationType;
import org.osate.aadl2.ListType;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.RangeType;
import org.osate.aadl2.RecordType;
import org.osate.aadl2.ReferenceType;

public class AssistantDialog extends Dialog
{
	private final PropertyType type;
	private final ISerializer serializer;
	private final NamedElement holder;
	
	private AbstractAssistant assistant = null;
	private String valueText = null;
	
	public AssistantDialog(Shell parent, PropertyType type, ISerializer serializer, NamedElement holder)
	{
		super(parent);
		this.type = type;
		this.serializer = serializer;
		this.holder = holder;
		int flags = getShellStyle();
		flags |= SWT.RESIZE;
		setShellStyle(flags);
	}
	
	public String getValueText()
	{
		if (valueText == null)
			throw new IllegalStateException("Method called out of order.  Only call this method when open() has returned Dialog.OK");
		else
			return valueText;
	}
	
	@Override
	protected Control createDialogArea(Composite parent)
	{
		Composite composite = (Composite)super.createDialogArea(parent);
		if (type instanceof ListType)
			composite.getShell().setText("New List Item");
		else if (type instanceof AadlBoolean)
			composite.getShell().setText("New Boolean Item");
		else if (type instanceof AadlString)
			composite.getShell().setText("New String Item");
		else if (type instanceof ClassifierType)
			composite.getShell().setText("New Classifier Item");
		else if (type instanceof EnumerationType)
			composite.getShell().setText("New Enumeration Item");
		else if (type instanceof AadlInteger)
			composite.getShell().setText("New Integer Item");
		else if (type instanceof AadlReal)
			composite.getShell().setText("New Real Item");
		else if (type instanceof RangeType)
			composite.getShell().setText("New Range Item");
		else if (type instanceof RecordType)
			composite.getShell().setText("New Record Item");
		else if (type instanceof ReferenceType)
			composite.getShell().setText("New Reference Item");
		else
			composite.getShell().setText("New List Item");
		
		assistant = AssistantFactory.getAssistantForType(composite, type, serializer, holder, new AssistantValueChangedListener()
		{
			@Override
			public void assistantValueChanged()
			{
				getButton(IDialogConstants.OK_ID).setEnabled(assistant.isComplete());
			}
		});
		assistant.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		return composite;
	}
	
	@Override
	protected Control createContents(Composite parent)
	{
		Control control = super.createContents(parent);
		getButton(IDialogConstants.OK_ID).setEnabled(assistant.isComplete());
		return control;
	}
	
	@Override
	protected void okPressed()
	{
		valueText = assistant.getValueText();
		super.okPressed();
	}
	
	@Override
	protected Point getInitialSize()
	{
		if (type instanceof ClassifierType || type instanceof ReferenceType)
			return new Point(600, 600);
		else if (type instanceof ListType)
			return new Point(600, 400);
		else
			return super.getInitialSize();
	}
}