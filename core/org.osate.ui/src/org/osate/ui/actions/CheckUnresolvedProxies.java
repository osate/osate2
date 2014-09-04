/*
 * Created on Jan 30, 2004
 *
 * <copyright>
 * Copyright  2004 by Carnegie Mellon University, all rights reserved.
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
 *
 *
 * @version $Id: CheckUnresolvedProxies.java,v 1.12 2010-04-02 19:44:45 jseibel Exp $
 */
package org.osate.ui.actions;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.osate.aadl2.Element;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.LogAnalysisErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.MarkerAnalysisErrorReporter;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.ui.OsateUiPlugin;
import org.osgi.framework.Bundle;

/**
 * CheckUnresolvedProxies looks for objects with unresolved proxies and marks them
 * @see IWorkbenchWindowActionDelegate
 */
public class CheckUnresolvedProxies implements IWorkbenchWindowActionDelegate, IObjectActionDelegate {
	/** the current selection in the AADL model
	 *
	 */
	private Set currentSelection = Collections.EMPTY_SET;
	private IWorkbenchWindow window;

	/**
	 * The constructor.
	 */
	public CheckUnresolvedProxies() {
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		window = targetPart.getSite().getWorkbenchWindow();
	}

	/**
	 * The action has been activated. The argument of the
	 * method represents the 'real' action sitting
	 * in the workbench UI.
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	@Override
	public void run(IAction action) {
		final Bundle theBundle = OsateUiPlugin.getDefault().getBundle();
		final AnalysisErrorReporterManager errManager = new AnalysisErrorReporterManager(
				new MarkerAnalysisErrorReporter.Factory("org.osate.ui.XMLErrorMarker",
						new LogAnalysisErrorReporter.Factory(theBundle)));

		if (currentSelection.isEmpty()) {
			MessageDialog.openError(getShell(), "Check Unresolved Proxies", "No resource(s) selected.");
			return;
		}
		for (final Iterator rsrcs = currentSelection.iterator(); rsrcs.hasNext();) {
			final IResource rsrc = (IResource) rsrcs.next();
			final Resource res = OsateResourceUtil.getResource(rsrc);

			/*
			 * Get the error reporter for the current resource. This has the
			 * effect of clearing the old error reports on the resource.
			 */
			final AnalysisErrorReporter errReporter = errManager.getReporter(res);

			final Map map = EcoreUtil.UnresolvedProxyCrossReferencer.find(res);
			if (!map.isEmpty()) {
				for (Iterator i = map.entrySet().iterator(); i.hasNext();) {
					final Map.Entry entry = (Map.Entry) i.next();
//		        final EObject unresolvedProxy = (EObject)entry.getKey();
//				String proxy = unresolvedProxy.toString();
//		        if (unresolvedProxy instanceof BasicEObjectImpl){
//		        	proxy = ((BasicEObjectImpl)unresolvedProxy).eProxyURI().toString();
//				}
					for (Iterator j = ((List) entry.getValue()).iterator(); j.hasNext();) {
						final EStructuralFeature.Setting setting = (EStructuralFeature.Setting) j.next();
						final EObject obj = setting.getEObject();
						errManager.error((Element) obj, "Unresolved proxy");
					}
				}
			}
		}
	}

	/**
		 * Selection in the workbench has been changed. We
		 * can change the state of the 'real' action here
		 * if we want, but this can only happen after
		 * the delegate has been created.
		 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction, org.eclipse.jface.viewers.ISelection)
		 */
	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			currentSelection = new HashSet();
			for (final Iterator elts = ((IStructuredSelection) selection).iterator(); elts.hasNext();) {
				final Object object = elts.next();
				if (object != null && object instanceof IResource) {
					currentSelection.add(object);
				}
			}
		}
	}

	/**
	 * We can use this method to dispose of any system
	 * resources we previously allocated.
	 * @see IWorkbenchWindowActionDelegate#dispose
	 */
	@Override
	public void dispose() {
	}

	/**
	 * We will cache window object in order to
	 * be able to provide parent shell for the message dialog.
	 * @see IWorkbenchWindowActionDelegate#init
	 */
	@Override
	public void init(IWorkbenchWindow window) {
		this.window = window;
	}

	private final Shell getShell() {
		return window.getShell();
	}
}