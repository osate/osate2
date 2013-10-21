package org.osate.xtext.aadl2.ui.propertyview.associationwizard.assistant;

import java.util.ArrayList;
import java.util.Collections;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.xtext.serializer.ISerializer;
import org.osate.aadl2.ListType;
import org.osate.aadl2.NamedElement;
import org.osate.ui.UiUtil;

public class ListAssistant extends AbstractAssistant
{
	private final ListType type;
	private final ISerializer serializer;
	private final NamedElement holder;
	
	private Label listLabel = null;
	private ListViewer viewer = null;
	private Button add = null;
	private Button remove = null;
	private Button moveUp = null;
	private Button moveDown = null;
	
	private ArrayList<String> listOfValues = new ArrayList<String>();
	
	public ListAssistant(Composite parent, ListType type, ISerializer serializer, NamedElement holder, AssistantValueChangedListener listener)
	{
		super(parent, listener);
		this.type = type;
		this.serializer = serializer;
		this.holder = holder;
		layoutComponents();
	}
	
	private void layoutComponents()
	{
		setLayout(new GridLayout(2, false));
		
		listLabel = new Label(this, SWT.NONE);
		listLabel.setText("&List of values:");
		listLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		
		viewer = new ListViewer(this, SWT.MULTI | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new ArrayContentProvider());
		viewer.setLabelProvider(UiUtil.getModelElementLabelProvider());
		viewer.setInput(listOfValues);
		viewer.getList().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 5));
		
		add = new Button(this, SWT.PUSH);
		add.setText("&Add...");
		add.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		
		remove = new Button(this, SWT.PUSH);
		remove.setText("&Remove");
		remove.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		
		moveUp = new Button(this, SWT.PUSH);
		moveUp.setText("Move &Up");
		moveUp.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		
		moveDown = new Button(this, SWT.PUSH);
		moveDown.setText("Move &Down");
		moveDown.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		
		addListeners();
		setButtonsEnabled();
	}
	
	private void addListeners()
	{
		add.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				AssistantDialog assistantDialog = new AssistantDialog(getShell(), type.getElementType(), serializer, holder);
				if (assistantDialog.open() == Dialog.OK)
				{
					listOfValues.add(assistantDialog.getValueText());
					viewer.setInput(listOfValues);
					requestUpdate();
				}
			}
		});
		viewer.addSelectionChangedListener(new ISelectionChangedListener()
		{
			@Override
			public void selectionChanged(SelectionChangedEvent event)
			{
				setButtonsEnabled();
			}
		});
		remove.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				int[] selectionIndices = viewer.getList().getSelectionIndices();
				for (int i = selectionIndices.length - 1; i >= 0; i--)
					listOfValues.remove(selectionIndices[i]);
				viewer.setInput(listOfValues);
				setButtonsEnabled();
				requestUpdate();
			}
		});
		moveUp.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				int selectionIndex = viewer.getList().getSelectionIndex();
				Collections.swap(listOfValues, selectionIndex, selectionIndex - 1);
				viewer.setInput(listOfValues);
				viewer.getList().setSelection(selectionIndex - 1);
				setButtonsEnabled();
				requestUpdate();
			}
		});
		moveDown.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				int selectionIndex = viewer.getList().getSelectionIndex();
				Collections.swap(listOfValues, selectionIndex, selectionIndex + 1);
				viewer.setInput(listOfValues);
				viewer.getList().setSelection(selectionIndex + 1);
				setButtonsEnabled();
				requestUpdate();
			}
		});
	}
	
	private void setButtonsEnabled()
	{
		IStructuredSelection selection = (IStructuredSelection)viewer.getSelection();
		remove.setEnabled(selection.size() > 0);
		moveUp.setEnabled(selection.size() == 1 && viewer.getList().getSelectionIndex() > 0);
		moveDown.setEnabled(selection.size() == 1 && viewer.getList().getSelectionIndex() < listOfValues.size() - 1);
	}
	
	@Override
	public String getValueText()
	{
		StringBuilder valueText = new StringBuilder("(");
		if (listOfValues.size() > 0)
		{
			for (int i = 0; i < listOfValues.size() - 1; i++)
			{
				valueText.append(listOfValues.get(i));
				valueText.append(", ");
			}
			valueText.append(listOfValues.get(listOfValues.size() - 1));
		}
		valueText.append(")");
		return valueText.toString();
	}
	
	@Override
	public boolean isComplete()
	{
		return true;
	}
	
	@Override
	public void setAssistantEnabled(boolean enabled)
	{
		listLabel.setEnabled(enabled);
		viewer.getList().setEnabled(enabled);
		add.setEnabled(enabled);
		if (enabled)
			setButtonsEnabled();
		else
		{
			remove.setEnabled(false);
			moveUp.setEnabled(false);
			moveDown.setEnabled(false);
		}
	}
}