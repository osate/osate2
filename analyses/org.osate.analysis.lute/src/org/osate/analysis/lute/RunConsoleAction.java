/*
 * Created on Dec, 7 2012
 *
 * <copyright>
 * Copyright  2012 by Carnegie Mellon University, all rights reserved.
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

package org.osate.analysis.lute;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.osate.aadl2.Element;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.aadl2.util.OsateDebug;
import org.osate.analysis.lute.utils.LuteLogger;
import org.osate.ui.dialogs.Dialog;
import org.osgi.framework.Bundle;


public class RunConsoleAction extends AadlAction {
	protected Bundle getBundle() {
		return Activator.getDefault().getBundle();
	}

	protected String getActionName() {
		return "Run LUTE console";
	}

	protected IStatus runJob(Element obj, IProgressMonitor monitor, LuteLogger log) 
	{

		final SystemInstance si;
		
		
		if (obj instanceof SystemImplementation) 
		{
			 
			SystemImplementation sysimpl = (SystemImplementation) obj;
			InstantiateModel im = new InstantiateModel(
					new NullProgressMonitor(), getErrorManager());
			URI uri = OsateResourceUtil.getInstanceModelURI(sysimpl);
			Resource resource = OsateResourceUtil.getEmptyAaxl2Resource(uri);
			try {
				si = im.createSystemInstance(sysimpl, resource);
			} catch (Exception e) {
				Dialog.showError(
						"Model Instantiate",
						"Error while re-instantiating the model: "
								+ e.getMessage());
				return Status.CANCEL_STATUS;
			}
		}
		else
		{
		
			if (obj instanceof InstanceObject)
			{
				si = ((InstanceObject)obj).getSystemInstance();
			}
			else
			{
				si = null;
			}
		}
		
		
		if (si == null)
		{
			Dialog.showError("LUTE console", "Invalid System Instance");
			return Status.CANCEL_STATUS;
		}

		 PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable(){

			public void run() {
				IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();

				Shell sh = window.getShell();

				LuteLogger logger = new LuteLogger(LuteLogger.INFO, "AADL Validation", getWindow());
				
				DialogConsole dialog = new DialogConsole (sh, si, logger);
				logger.setDialogConsole (dialog);
				dialog.open();
			}});
		 return Status.OK_STATUS;
	}



}
