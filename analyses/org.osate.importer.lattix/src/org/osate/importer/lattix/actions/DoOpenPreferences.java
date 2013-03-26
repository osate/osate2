/*
 * Copyright 2013 Carnegie Mellon University
 * 
 * The AADL/DSM Bridge (org.osate.importer.lattix ) (the “Content” or “Material”) 
 * is based upon work funded and supported by the Department of Defense under 
 * Contract No. FA8721-05-C-0003 with Carnegie Mellon University for the operation 
 * of the Software Engineering Institute, a federally funded research and development 
 * center.

 * Any opinions, findings and conclusions or recommendations expressed in this 
 * Material are those of the author(s) and do not necessarily reflect the 
 * views of the United States Department of Defense. 

 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING 
 * INSTITUTE MATERIAL IS FURNISHED ON AN “AS-IS” BASIS. CARNEGIE MELLON 
 * UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, 
 * AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR 
 * PURPOSE OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF 
 * THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT MAKE ANY WARRANTY OF 
 * ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT 
 * INFRINGEMENT.
 * 
 * This Material has been approved for public release and unlimited 
 * distribution except as restricted below. 
 * 
 * This Material is provided to you under the terms and conditions of the 
 * Eclipse Public License Version 1.0 ("EPL"). A copy of the EPL is 
 * provided with this Content and is also available at 
 * http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Carnegie Mellon® is registered in the U.S. Patent and Trademark 
 * Office by Carnegie Mellon University. 
 * 
 * DM-0000232
 * 
 */

package org.osate.importer.lattix.actions;


import java.awt.TextField;
import java.io.BufferedOutputStream;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.*;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.importer.lattix.vdid.Activator;
import org.osate.importer.lattix.vdid.CostGenerator;
import org.osate.importer.lattix.vdid.ExcelGenerator;
import org.osate.importer.lattix.vdid.LdmGenerator;
import org.osate.importer.lattix.vdid.MatrixGenerator;
import org.osate.importer.lattix.vdid.MetricsReporter;
import org.osate.importer.lattix.vdid.Preferences;
import org.osate.ui.actions.AaxlReadOnlyActionAsJob;
import org.osate.ui.dialogs.Dialog;
import org.osgi.framework.Bundle;




import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;



class PreferencesDialog extends TitleAreaDialog {

	  private Combo weightMethodCombo;
	  private Combo parallelDependenciesCombo;
	  private Text invalidSystems;
	  private Text ignoreHierarchy;
	  private Button arincCheckBox;
	  private final static String [] weightMethods = {"boolean", "architecture driven"};
	  private final static String [] parallelDependenciesMethods = {"sum", "average", "max"};

//	  private String lastName;

	  public PreferencesDialog(Shell parentShell) {
	    super(parentShell);
	    setHelpAvailable(false);
	  }

	  @Override
	  public void create() {
	    super.create();
	    // Set the title
	    setTitle("VDID Preferences");
	    // Set the message
	    setMessage("Set your preferences for VDID related analysis", 
	        IMessageProvider.NONE);

	  }

	  @Override
	  protected Control createDialogArea(Composite parent) {
	    GridLayout layout = new GridLayout();
	    layout.numColumns = 2;
	    // layout.horizontalAlignment = GridData.FILL;
	    parent.setLayout(layout);

	    // The text fields will grow with the size of the dialog
	    GridData gridData = new GridData();
	    gridData.grabExcessHorizontalSpace = true;
	    gridData.horizontalAlignment = GridData.FILL;

	    Label label1 = new Label(parent, SWT.NONE);
	    label1.setText("Dependency weight method");

	    weightMethodCombo = new Combo(parent, SWT.BORDER | SWT.READ_ONLY);

	    
	    weightMethodCombo.setItems(weightMethods);
	    weightMethodCombo.setText(weightMethods[0]);
	    
	    
	    gridData = new GridData();
	    gridData.grabExcessHorizontalSpace = true;
	    gridData.horizontalAlignment = GridData.FILL;

	    Label label2 = new Label(parent, SWT.NONE);
	    label2.setText("Parallel dependecies handling");

	    parallelDependenciesCombo = new Combo(parent, SWT.BORDER | SWT.READ_ONLY);

	    
	    parallelDependenciesCombo.setItems(parallelDependenciesMethods);
	    parallelDependenciesCombo.setText(parallelDependenciesMethods[0]);
	    
	    gridData = new GridData();
	    gridData.grabExcessHorizontalSpace = true;
	    gridData.horizontalAlignment = GridData.FILL;

	    Label label4 = new Label(parent, SWT.NONE);
	    label4.setText("Systems to ignore");

	    invalidSystems = new Text(parent, SWT.SINGLE | SWT.BORDER | SWT.V_SCROLL);
    	
	    gridData = new GridData();
	    gridData.grabExcessHorizontalSpace = true;
	    gridData.horizontalAlignment = GridData.FILL;

	    Label label5 = new Label(parent, SWT.NONE);
	    label5.setText("Ignore the following first hierarchy levels");

	    ignoreHierarchy = new Text(parent, SWT.SINGLE | SWT.BORDER | SWT.V_SCROLL);
	    
	    gridData = new GridData();
	    gridData.grabExcessHorizontalSpace = true;
	    gridData.horizontalAlignment = GridData.FILL;

	    Label label3 = new Label(parent, SWT.NONE);
	    label3.setText("Enable ARINC653 features");

	    arincCheckBox = new Button(parent, SWT.CHECK);
    	arincCheckBox.setSelection(Preferences.useArinc());


	    return parent;
	  }

	
	  protected void createButtonsForButtonBar(Composite parent) {
	    GridData gridData = new GridData();
	    gridData.verticalAlignment = GridData.FILL;
	    gridData.horizontalSpan = 3;
	    gridData.grabExcessHorizontalSpace = true;
	    gridData.grabExcessVerticalSpace = true;
	    gridData.horizontalAlignment = SWT.CENTER;

	    parent.setLayoutData(gridData);

	    createOkButton(parent, OK, "OK", true);

	    Button cancelButton = createButton(parent, CANCEL, "Cancel", false);

	    cancelButton.addSelectionListener(new SelectionAdapter() {
	      public void widgetSelected(SelectionEvent e) {
	        setReturnCode(CANCEL);
	        close();
	      }
	    });
	  }

	  protected Button createOkButton(Composite parent, int id, 
	      String label,
	      boolean defaultButton) {
	    // increment the number of columns in the button bar
	    ((GridLayout) parent.getLayout()).numColumns++;
	    Button button = new Button(parent, SWT.PUSH);
	    button.setText(label);
	    button.setFont(JFaceResources.getDialogFont());
	    button.setData(new Integer(id));
	    
	    button.addSelectionListener(new SelectionAdapter() {
	      public void widgetSelected(SelectionEvent event) {
	    
	          okPressed();
	        
	      }
	    });
	    
	    if (defaultButton) {
	      Shell shell = parent.getShell();
	      if (shell != null) {
	        shell.setDefaultButton(button);
	      }
	    }
	    
	    setButtonLayoutData(button);
	    return button;
	  }


	  protected boolean isResizable() {
	    return true;
	  }


	  private void savePreferences() {
		  if (arincCheckBox.getSelection())
		  {
			  Preferences.enableArinc();
		  }
		  else
		  {
			  Preferences.disableArinc();
		  }
		  
		  if (Preferences.useArinc())
		  {
			  System.out.println ("ARINC is enabled");
		  }
		  else
		  {
			  System.out.println ("ARINC is disabled");
		  }
		  
		  
		  for (int i = 0 ; i < weightMethods.length ; i++)
		  {
			  if (weightMethods[i].equals(weightMethodCombo.getText()))
			  {
				  Preferences.setWeightMethod(i);
			  }
		  }
		  
		  
		  for (int i = 0 ; i < parallelDependenciesMethods.length ; i++)
		  {
			  if (parallelDependenciesMethods[i].equals(parallelDependenciesCombo.getText()))
			  {
				  Preferences.setParallelDependencyMethod(i);
			  }
		  }
		  Preferences.setInvalidSystems(invalidSystems.getText());
		  Preferences.setIgnoreHierarchy(ignoreHierarchy.getText());
	  }

	  protected void okPressed() {
	    savePreferences();
	    super.okPressed();
	  }

	} 


public final class DoOpenPreferences implements IWorkbenchWindowActionDelegate  {
	
	IWorkbenchWindow activeWindow = null;
	
	protected Bundle getBundle() {
		return Activator.getDefault().getBundle();
	}

	protected String getActionName() {
		return "Preferences";
	}


	public void selectionChanged(IAction proxyAction, ISelection selection) {
	}
	
	public void init(IWorkbenchWindow window) {
		activeWindow = window;
	}
	
	public void dispose() {
	}

	public void run(IAction action) {
		System.out.println ("open preferences");
		Shell shell = activeWindow.getShell();
		PreferencesDialog dialog = new PreferencesDialog(shell);
		dialog.create();
		if (dialog.open() == Window.OK) {
		  System.out.println("test");
		} 
		
	}
}
