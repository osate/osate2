/*
 * <copyright>
 * Copyright  2014 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE ''DELIVERABLES'') ARE ON AN ''AS-IS'' BASIS.
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
package org.osate.ui.handlers;

import static org.osate.ui.OsateUiPlugin.AADL_PROJECT_DEFAULT;
import static org.osate.ui.OsateUiPlugin.AADL_PROJECT_KEY;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.osate.ui.OsateUiPlugin;
import org.osgi.service.prefs.BackingStoreException;

public class SetAadlProjectPropertiesHandler extends AbstractHandler {

	private final static Logger log = Logger.getLogger(SetAadlProjectPropertiesHandler.class);

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow win = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		IWorkbenchPage page = win.getActivePage();
		ISelection selection = page.getSelection();
		if (selection instanceof TreeSelection) {
			TreeSelection tree = (TreeSelection) selection;
			if (tree.size() == 1) {
				if (tree.getFirstElement() instanceof IResource) {
					final IResource newAadlProject = (IResource) tree.getFirstElement();
					IEclipsePreferences prefs = InstanceScope.INSTANCE.getNode(OsateUiPlugin.PLUGIN_ID);
					final String oldAadlProjectPath = prefs.get(AADL_PROJECT_KEY, AADL_PROJECT_DEFAULT);
					String newAadlProjectPath = newAadlProject.getFullPath().toString();
					prefs.put(AADL_PROJECT_KEY, newAadlProjectPath);
					try {
						prefs.flush();
					} catch (BackingStoreException e) {
						log.error(e.getMessage(), e);
						throw new ExecutionException("Could not save preference " + OsateUiPlugin.PLUGIN_ID + " - "
								+ AADL_PROJECT_KEY, e);
					}
					// make a change to the project description to force Xtext to rebuild
					new WorkspaceJob("") {

						@Override
						public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
							try {
								IProject project = newAadlProject.getProject();
								IProjectDescription description = project.getDescription();
								description.setComment("aadl-project:" + newAadlProject.getFullPath().toString());
								project.setDescription(description, null);

								String projectName = new Path(oldAadlProjectPath).segment(0);
								project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
								if (project.exists()) {
									description = project.getDescription();
									String oldComment = description.getComment();
									description.setComment(oldComment.replaceFirst(
											"aadl-project:" + oldAadlProjectPath, ""));
									project.setDescription(description, null);
								}
								return new Status(IStatus.OK, OsateUiPlugin.PLUGIN_ID, "");
							} catch (CoreException e) {
								log.error(e.getMessage());
								return new Status(IStatus.ERROR, OsateUiPlugin.PLUGIN_ID,
										"Could not change project description", e);
							}
						}

					}.schedule();
				}
			}
		}
		return null;
	}

}
