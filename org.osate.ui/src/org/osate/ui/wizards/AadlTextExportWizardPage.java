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
package org.osate.ui.wizards;

/*
 * XXX: Commented out entire class to remove error markers.  Not currently used in Aadl 2 beta.
 * Need to check if this should be used after implementing the Xtext parser.
 */
public class AadlTextExportWizardPage/* extends WizardPage */
{
//	private IResource selectedResource = null;
//	private boolean modelChoosen = false;
//	private boolean destinationFileValid = false;
//
//	private TreeViewer modelChooser = null;
//	private Text destinationFile = null;
//	private Button browse = null;
//
//	public AadlTextExportWizardPage(IResource selectedResource)
//	{
//		super("selectionPage");
//		setTitle("Aadl Text");
//		setDescription("Exports an XML AADL Model to AADL Text.");
//		this.selectedResource = selectedResource;
//		setPageComplete(false);
//	}
//
//	public void createControl(Composite parent)
//	{
//		//Control initialization:
//		Composite composite = new Composite(parent, SWT.NONE);
//		composite.setLayout(new FormLayout());
//
//		Label browseLabel = new Label(composite, SWT.NONE);
//		browseLabel.setText("&Choose a model to export:");
//
//		modelChooser = new TreeViewer(composite, SWT.BORDER);
//		configureAObjectsTreeViewer();
//
//		Label destinationLabel = new Label(composite, SWT.NONE);
//		destinationLabel.setText("&To text file: ");
//
//		destinationFile = new Text(composite, SWT.BORDER | SWT.SINGLE);
//
//		browse = new Button(composite, SWT.PUSH);
//		browse.setText("&Browse...");
//
//		//Layout:
//
//		//browseLabel
//		FormData layoutData = new FormData();
//		layoutData.top = new FormAttachment(0, 5);
//		layoutData.left = new FormAttachment(0, 5);
//		browseLabel.setLayoutData(layoutData);
//
//		//browse
//		layoutData = new FormData();
//		layoutData.right = new FormAttachment(100, -5);
//		layoutData.bottom = new FormAttachment(100, -5);
//		layoutData.width = getButtonPixelWidth(browse);
//		browse.setLayoutData(layoutData);
//
//		//modelChooser
//		layoutData = new FormData();
//		layoutData.top = new FormAttachment(browseLabel, 5);
//		layoutData.left = new FormAttachment(0, 5);
//		layoutData.right = new FormAttachment(100, -5);
//		layoutData.bottom = new FormAttachment(browse, -5);
//		modelChooser.getControl().setLayoutData(layoutData);
//
//		int extraSpaceForDestinationFile = 0;
//		if (destinationFile.computeSize(SWT.DEFAULT, SWT.DEFAULT).y < browse.computeSize(SWT.DEFAULT, SWT.DEFAULT).y)
//			extraSpaceForDestinationFile = (browse.computeSize(SWT.DEFAULT, SWT.DEFAULT).y - destinationFile.computeSize(SWT.DEFAULT, SWT.DEFAULT).y) / 2;
//		int extraSpaceForDestinationLabel = 0;
//		if (destinationLabel.computeSize(SWT.DEFAULT, SWT.DEFAULT).y < destinationFile.computeSize(SWT.DEFAULT, SWT.DEFAULT).y)
//			extraSpaceForDestinationLabel = (destinationFile.computeSize(SWT.DEFAULT, SWT.DEFAULT).y - destinationLabel.computeSize(SWT.DEFAULT, SWT.DEFAULT).y) / 2 + extraSpaceForDestinationFile;
//
//		//destinationLabel
//		layoutData = new FormData();
//		layoutData.left = new FormAttachment(0, 5);
//		layoutData.top = new FormAttachment(modelChooser.getControl(), 5 + extraSpaceForDestinationLabel);
//		destinationLabel.setLayoutData(layoutData);
//
//		//destinationFile
//		layoutData = new FormData();
//		layoutData.left = new FormAttachment(destinationLabel, 5);
//		layoutData.right = new FormAttachment(browse, -5);
//		layoutData.top = new FormAttachment(modelChooser.getControl(), 5 + extraSpaceForDestinationFile);
//		destinationFile.setLayoutData(layoutData);
//
//		addListeners();
//
//		if (selectedResource != null)
//			modelChooser.setSelection(new StructuredSelection(selectedResource), true);
//
//		setControl(composite);
//	}
//
//	private void configureAObjectsTreeViewer()
//	{
//		modelChooser.setContentProvider(new WorkbenchContentProvider());
//		modelChooser.setLabelProvider(new WorkbenchLabelProvider());
//		//filters hidden files
//		modelChooser.addFilter(
//				new ViewerFilter()
//				{
//					public boolean select(Viewer viewer, Object parentElement, Object element)
//					{
//						return element instanceof IResource && !((IResource)element).getName().startsWith(".");
//					}
//				});
//		//filters for declarative models
//		modelChooser.addFilter(
//				new ViewerFilter()
//				{
//					public boolean select(Viewer viewer, Object parentElement, Object element)
//					{
//						if (element instanceof IResource)
//						{
//							IResource res = (IResource)element;
//							if (res.getType() == IResource.FILE)
//							{
//								Element model = AadlUtil.getAObject(res);
//								return (model != null) && !(model instanceof SystemInstance);
//							}
//							else
//							{
//								return containerHasModel((IContainer)res);
//							}
//						}
//						else
//							return false;
//					}
//
//					private boolean containerHasModel(IContainer element)
//					{
//						IResource[] members = null;
//						try
//						{
//							members = element.members();
//						}
//						catch (CoreException e)
//						{
//							AadlModelPlugin.logThrowable(e);
//							return false;
//						}
//						for (int i = 0; i < members.length; i++)
//						{
//							if (members[i].getType() == IResource.FILE)
//							{
//								Element model = AadlUtil.getAObject(members[i]);
//								if ((model != null) && !(model instanceof SystemInstance))
//									return true;
//							}
//							else
//							{
//								if (containerHasModel((IContainer)members[i]))
//									return true;
//							}
//						}
//						return false;
//					}
//				});
//		modelChooser.setComparator(new ResourceComparator(ResourceComparator.TYPE));
//		modelChooser.setInput(ResourcesPlugin.getWorkspace().getRoot());
//	}
//
//	private void addListeners()
//	{
//		modelChooser.addSelectionChangedListener(
//				new ISelectionChangedListener()
//				{
//					public void selectionChanged(SelectionChangedEvent event)
//					{
//						if (event.getSelection() instanceof IStructuredSelection)
//						{
//							Object selection = ((IStructuredSelection)event.getSelection()).getFirstElement();
//							setModelChoosen(AadlUtil.getAObject(selection) != null);
//						}
//						else
//							setModelChoosen(false);
//					}
//				});
//		browse.addSelectionListener(
//				new SelectionAdapter()
//				{
//					public void widgetSelected(SelectionEvent e)
//					{
//						FileDialog dialog = new FileDialog(getContainer().getShell(), SWT.SAVE);
//						dialog.setFilterExtensions(new String[]{"*.aadl", "*.*"});
//						dialog.setText("Export to File");
//						dialog.setFilterPath(destinationFile.getText().trim());
//						String selectedFileName = dialog.open();
//						if (selectedFileName != null)
//							destinationFile.setText(selectedFileName);
//					}
//				});
//		destinationFile.addModifyListener(
//				new ModifyListener()
//				{
//					public void modifyText(ModifyEvent e)
//					{
//						File file = new File(destinationFile.getText().trim());
//						if (file.getPath().length() <= 0 || file.isDirectory())
//						{
//							setDestinationFileValid(false);
//							setErrorMessage("Destination file not set, or is not a normal file.");
//						}
//						else
//						{
//							setDestinationFileValid(true);
//							setErrorMessage(null);
//						}
//					}
//				});
//	}
//
//	private void setModelChoosen(boolean choosen)
//	{
//		modelChoosen = choosen;
//		setPageComplete(modelChoosen && destinationFileValid);
//	}
//
//	private void setDestinationFileValid(boolean fileValid)
//	{
//		destinationFileValid = fileValid;
//		setPageComplete(modelChoosen && destinationFileValid);
//	}
//
//	public String getDestinationFileName()
//	{
//		return destinationFile.getText().trim();
//	}
//
//	public Element getChoosenModel()
//	{
//		return AadlUtil.getAObject(((IStructuredSelection)modelChooser.getSelection()).getFirstElement());
//	}
//
//	//This method ensures that buttons are not too small.  This logic is copied from
//	//org.eclipse.jface.dialogs.Dialog.setButtonLayoutData(Button).
//	private static int getButtonPixelWidth(Button button)
//	{
//		GC gc = new GC(button);
//		FontMetrics fontMetrics = gc.getFontMetrics();
//		gc.dispose();
//		int widthHint = (fontMetrics.getAverageCharWidth() * 61 + 2) / 4;
//		Point minSize = button.computeSize(SWT.DEFAULT, SWT.DEFAULT, true);
//		return Math.max(widthHint, minSize.x);
//	}
}