/*
 * Created on Dec, 7 2012
 *
 * <copyright>
 * Copyright  2012-2013 by Carnegie Mellon University, all rights reserved.
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
 *
 * </copyright>
 */

package org.osate.validation.lute;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.validation.Logger;
import org.osate.validation.lute.utils.Invoke;

/*
 * Custom class to read an inputstream line by line
 */
class MyInputStream
{  
    private static final int _CR = 13;  
    private static final int _LF = 10;  
    private int	 			_last=-1;  
    private int 			_ch = -1;

    
    private InputStream in;  
    public MyInputStream(InputStream i)  
    {  
    	in 				= i;  
    }  

    
    public String readLine() throws IOException  
    {  
       StringBuffer sb = new StringBuffer("");
       
       if (_last != -1) sb.append((char) _last);  
       
       _ch = in.read();
       
       if (_ch == -1)
       {
    	   return null;
       }
       while(_ch != _CR && _ch != _LF)  
       {  
          sb.append((char) _ch);  
          _ch = in.read();
          if (_ch == -1)
          {
        	  break;
          }
       }  

       _last = in.read();  
       if (_last == _LF)
       {  
          _last = -1;  
       }  
       return(new String(sb));  
    }  
    
    public InputStream getInputStream()
    {
    	return in;
    }
 } 

public class DialogConsole extends Dialog {
	  private String 			theorem;
	  private String 			input;
	  private Logger 			logger;
	  private SystemInstance 	systemInstance;
	  
	  public List<String> getTheoremList ()
	  {
		  String tmp;
		  ArrayList<String> result;
		  MyInputStream ms;
		  
		  result = new ArrayList<String> ();
		  
		  ms = new MyInputStream (RunConsoleAction.class.getResourceAsStream("/resource/predefined.lute"));
		  
		  try 
		  {
			while (( tmp = ms.readLine()) != null)
			{
				if (tmp.contains("theorem"))
				{
					tmp = tmp.replaceAll("theorem ", "");
					result.add(tmp);
				}
				
			}
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return result;
	  }
	  
	  public String getTheorem (String name)
	  {
		  String theorem;
		  String tmp;
		  boolean shouldTake;
		  MyInputStream ms;

		  theorem = "";
		  shouldTake = false;
		  ms = new MyInputStream (RunConsoleAction.class.getResourceAsStream("/resource/predefined.lute"));
		  
		  try 
		  {
			while (( tmp = ms.readLine()) != null)
			{

				if (tmp.contains("theorem " + name))
				{
					shouldTake = true;
					
				}
				
				if ((shouldTake == true) && (tmp.length() == 0))
				{
					shouldTake = false;
				}
				
				if (shouldTake)
				{
					theorem = theorem + tmp + "\n";
				}
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return theorem;
	  }
	  
	  
	  public DialogConsole(Shell parent)
	  {
	    this(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
    	logger			= null;
    	systemInstance 	= null;
	  }

	  public DialogConsole(Shell parent, SystemInstance systemInstance, Logger log)
	  {
	    this(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
	    this.logger 			= log;
	    this.systemInstance 	= systemInstance;
	  }
	  
	  
	  public DialogConsole(Shell parent, int style) 
	  {
	    super(parent, style);
	  }

	  
	  public String getTheorem() 
	  {
	    return theorem;
	  }



	  public String open()
	  {
	  
	    Shell shell = new Shell(getParent(), getStyle());
	    shell.setText(getText());
	    createContents(shell);
	    //shell.pack();
	    shell.open();
	    Display display = getParent().getDisplay();
	    while (!shell.isDisposed()) 
	    {
	      if (!display.readAndDispatch()) 
	      {
	        display.sleep();
	      }
	    }
	  
	    return input;
	  }


	  private void createContents(final Shell shell) 
	  {
	    shell.setLayout(new GridLayout(2, true));

	    Label label = new Label(shell, SWT.NONE);
	    label.setText("Theorem");
	    GridData data = new GridData();
	    data.horizontalSpan = 2;
	    label.setLayoutData(data);

	    final Text text = new Text(shell, SWT.BORDER | SWT.MULTI);
	    text.setText("<Write your theorem here>");
	    text.setSize(70, 30);
	    data = new GridData(GridData.FILL_HORIZONTAL|GridData.FILL_VERTICAL);
	    data.horizontalSpan = 2;
	    text.setLayoutData(data);


	    
	    Label theoremSelect =  new Label(shell, SWT.NONE);
	    theoremSelect.setText("Choose a pre-defined theorem");
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    theoremSelect.setLayoutData(data);


		final Combo theorems = new Combo (shell, SWT.READ_ONLY);
		List<String> l = getTheoremList();
		String theoremNames[] = new String[l.size()];
		for (int i = 0 ; i < l.size() ; i++)
		{
			theoremNames[i] = new String (l.get(i));
		}
		theorems.setItems (theoremNames);
		

	    data = new GridData(GridData.FILL_HORIZONTAL);
	    theorems.setLayoutData(data);
	    
	    theorems.addSelectionListener(new SelectionAdapter() {
	        public void widgetSelected(SelectionEvent e) {
	            System.out.println (theorems.getText());
	            String theorem = getTheorem (theorems.getText());
	            text.setText(theorem);
	          }
	        });
	    

	    Button ok = new Button(shell, SWT.PUSH);
	    ok.setText("Check");
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    ok.setLayoutData(data);
	    ok.addSelectionListener(new SelectionAdapter() {
	      public void widgetSelected(SelectionEvent event) {
	        theorem = text.getText();
	        Invoke.invoke(systemInstance, theorem, logger);
	      }
	    });

	    Button cancel = new Button(shell, SWT.PUSH);
	    cancel.setText("Close");
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    cancel.setLayoutData(data);
	    cancel.addSelectionListener(new SelectionAdapter() {
	      public void widgetSelected(SelectionEvent event) {
	        theorem = null;
	        shell.close();
	      }
	    });


	    shell.setDefaultButton(ok);
	    
	  }
	}