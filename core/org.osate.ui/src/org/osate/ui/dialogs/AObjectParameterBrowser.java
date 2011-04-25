/*
 * <copyright>
 * Copyright  2005 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/cpl-v10.html.
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
 * </copyright>
 */
package org.osate.ui.dialogs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.osate.aadl2.Element;
import org.osate.ui.UiUtil;


public class AObjectParameterBrowser extends Dialog
{	
	private final String title;
	private final String instructionalMessage;
	private final Element selectedModel;
	private final List<Class<? extends Element>> acceptableParameterTypes;
	private final boolean canSelectRootObject;
	
	private Element parameter = null;
	
	private TreeViewer aObjectsTreeViewer = null;
	
	public AObjectParameterBrowser(Shell parent, Element selectedModel, List acceptableParameterTypes, boolean canSelectRootObject, String instructionalMessage, String title)
	{
		super(parent);
		int flags = getShellStyle();
		flags |= SWT.RESIZE;
		setShellStyle(flags);
		this.selectedModel = selectedModel;
		this.acceptableParameterTypes = new ArrayList<Class<? extends Element>>(acceptableParameterTypes);
		this.canSelectRootObject = canSelectRootObject;
		this.instructionalMessage = instructionalMessage;
		this.title = title;
	}
	
	public Element getParameter() throws IllegalStateException
	{
		if (parameter == null)
			throw new IllegalStateException("Method called out of order.  Only call this method when open() has returned Dialog.OK");
		else
			return parameter;
	}
	
	public String getParameterLabel() throws IllegalStateException
	{
		return UiUtil.getAObjectLabelProvider().getText(getParameter());
	}
	
	protected Control createDialogArea(Composite parent)
	{
		Composite composite = (Composite)super.createDialogArea(parent);
		composite.getShell().setText(title);
		
		Label treeViewerLabel = new Label(composite, SWT.NONE);
		treeViewerLabel.setText(instructionalMessage);
		treeViewerLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		
		aObjectsTreeViewer = new TreeViewer(composite, SWT.BORDER);
		configureAObjectsTreeViewer();
		aObjectsTreeViewer.getTree().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		addListeners();
		
		return composite;
	}
	
	protected Control createContents(Composite parent)
	{
		Control control = super.createContents(parent);
		getButton(IDialogConstants.OK_ID).setEnabled(false);
		return control;
	}
	
	protected Point getInitialSize()
	{
		return new Point(500, 600);
	}
	
	protected void okPressed()
	{
		parameter = (Element)AdapterFactoryEditingDomain.unwrap(((IStructuredSelection)aObjectsTreeViewer.getSelection()).getFirstElement());
		super.okPressed();
	}
	
	private void configureAObjectsTreeViewer()
	{
		for (Iterator<Class<? extends Element>> iter = acceptableParameterTypes.iterator(); iter.hasNext();)
			aObjectsTreeViewer.addFilter(new AObjectFilter(iter.next()));
		aObjectsTreeViewer.setContentProvider(UiUtil.getAObjectContentProvider());
		aObjectsTreeViewer.setLabelProvider(UiUtil.getAObjectLabelProvider());
		aObjectsTreeViewer.setInput(selectedModel.eResource());
		aObjectsTreeViewer.expandAll();
		aObjectsTreeViewer.collapseAll();
	}
	
	private void validateSelection()
	{
		Element currentlySelectedParameter = (Element)AdapterFactoryEditingDomain.unwrap(((IStructuredSelection)aObjectsTreeViewer.getSelection()).getFirstElement());
		if (canSelectRootObject && currentlySelectedParameter.equals(currentlySelectedParameter.getElementRoot()))
		{
			getButton(IDialogConstants.OK_ID).setEnabled(true);
			return;
		}
		else
			for (Iterator<Class<? extends Element>> iter = acceptableParameterTypes.iterator(); iter.hasNext();)
				if ((iter.next()).isInstance(currentlySelectedParameter))
				{
					getButton(IDialogConstants.OK_ID).setEnabled(true);
					return;
				}
		getButton(IDialogConstants.OK_ID).setEnabled(false);
	}
	
	private void addListeners()
	{
		aObjectsTreeViewer.addSelectionChangedListener(
				new ISelectionChangedListener()
				{				
					public void selectionChanged(SelectionChangedEvent event)
					{
						validateSelection();
					}				
				});
	}
}