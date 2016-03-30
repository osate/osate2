/*
 * <copyright>
 * Copyright  2008 by Carnegie Mellon University, all rights reserved.
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
package org.osate.ui.navigator;

import java.io.IOException;
import java.util.HashSet;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourceAttributes;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.RefreshAction;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonViewerSite;
import org.eclipse.ui.navigator.ICommonViewerWorkbenchSite;
import org.osate.aadl2.modelsupport.resources.PredeclaredProperties;
import org.osate.ui.OsateUiPlugin;

public class AadlNavigatorActionGroup extends org.eclipse.ui.navigator.CommonActionProvider {
	private static final String OPEN_FOR_MODIFICATION_ACTION_ID = "org.osate.ui.navigator.OpenForModificationAction";
	private static final String REVERT_TO_CONTRIBUTED_ACTION_ID = "org.osate.ui.navigator.RevertToContributedAction";

	private static final HashSet<String> validIds;
	private Action openForModificationAction;
	private Action revertToContributedAction;

	static {
		validIds = new HashSet<String>();
		validIds.add(OPEN_FOR_MODIFICATION_ACTION_ID);
		validIds.add(REVERT_TO_CONTRIBUTED_ACTION_ID);
		validIds.add(PlatformUI.PLUGIN_ID + ".CopyAction");
		validIds.add(PlatformUI.PLUGIN_ID + ".DeleteResourceAction");
		validIds.add("import");
		validIds.add("export");
		validIds.add(RefreshAction.ID);
	}

	@Override
	public void fillContextMenu(IMenuManager menu) {
		Object selectedElement = ((IStructuredSelection) getContext().getSelection()).getFirstElement();
		if (selectedElement instanceof IResource && ((IResource) selectedElement).getProject().getName()
				.equals(PredeclaredProperties.PLUGIN_RESOURCES_PROJECT_NAME)) {
			if (selectedElement instanceof IFile) {
				menu.add(openForModificationAction);
				menu.add(revertToContributedAction);
				if (((IFile) selectedElement).getResourceAttributes().isReadOnly()) {
					openForModificationAction.setEnabled(true);
					revertToContributedAction.setEnabled(false);
				} else {
					openForModificationAction.setEnabled(false);
					revertToContributedAction.setEnabled(true);
				}
			}
			super.fillContextMenu(menu);
			for (IContributionItem item : menu.getItems()) {
				if (!(item instanceof Separator)) {
					String id = item.getId();
					if (id == null) {
						if (item instanceof ActionContributionItem || item instanceof MenuManager) {
							menu.remove(item);
						}
					} else if (!validIds.contains(id)) {
						menu.remove(item);
					}
				}
			}
		} else {
			super.fillContextMenu(menu);
		}
	}

	@Override
	public void init(final ICommonActionExtensionSite aSite) {
		final ICommonViewerSite viewSite = aSite.getViewSite();
		if (viewSite instanceof ICommonViewerWorkbenchSite) {
			final ICommonViewerWorkbenchSite workbenchSite = (ICommonViewerWorkbenchSite) viewSite;

			openForModificationAction = new Action("Open For Modification") {
				@Override
				public void run() {
					IFile file = (IFile) ((IStructuredSelection) workbenchSite.getSelectionProvider().getSelection())
							.getFirstElement();
					ResourceAttributes attributes = file.getResourceAttributes();
					attributes.setReadOnly(false);
					try {
						file.setResourceAttributes(attributes);
						aSite.getStructuredViewer().update(file, null);
						IDE.openEditor(workbenchSite.getPage(), file, "org.osate.xtext.aadl2.Aadl2");
					} catch (CoreException e) {
						OsateUiPlugin.log(e);
					}
				}
			};
			openForModificationAction.setId(OPEN_FOR_MODIFICATION_ACTION_ID);
			revertToContributedAction = new Action("Revert To Contributed Version") {
				@Override
				public void run() {
					IFile file = (IFile) ((IStructuredSelection) aSite.getStructuredViewer().getSelection())
							.getFirstElement();
					try {
						PredeclaredProperties.revertToContributed(file);
						aSite.getStructuredViewer().update(file, null);
					} catch (IOException e) {
						OsateUiPlugin.log(e);
					} catch (CoreException e) {
						OsateUiPlugin.log(e);
					}
				}
			};
			revertToContributedAction.setId(REVERT_TO_CONTRIBUTED_ACTION_ID);
		}
	}
}