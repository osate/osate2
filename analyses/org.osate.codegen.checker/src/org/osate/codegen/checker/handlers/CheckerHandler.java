/**
 * <copyright>
 * Copyright 2016 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/epl-v10.html.
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
 * of Defense under Contract FA8721-05-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 */

package org.osate.codegen.checker.handlers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.codegen.checker.checks.AbstractCheck;
import org.osate.codegen.checker.checks.DataCheck;
import org.osate.codegen.checker.checks.MemoryCheck;
import org.osate.codegen.checker.checks.ProcessCheck;
import org.osate.codegen.checker.checks.ProcessorCheck;
import org.osate.codegen.checker.checks.ThreadCheck;
import org.osate.codegen.checker.report.ErrorReport;
import org.osate.ui.utils.SelectionHelper;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class CheckerHandler extends AbstractHandler {

	protected final String MARKER_TYPE = "org.osate.codegen.codegen.marker";

	public CheckerHandler() {
	}

	protected static IResource getIResource(Resource r) {
		final URI uri = r.getURI();
		final IPath path = new Path(uri.toPlatformString(true));
		final IResource resource = ResourcesPlugin.getWorkspace().getRoot().findMember(path);
		if (resource == null) {
			throw new RuntimeException("Unable to get IResource for Resource: " + r);
		}
		return resource;
	}

	public static List<ErrorReport> executeCheck(SystemInstance si, Class<? extends AbstractCheck> myCheck, int kind) {

		try {
			AbstractCheck checkInstance = myCheck.newInstance();
			checkInstance.setKind(kind);
			checkInstance.perform(si);
			return (checkInstance.getErrors());
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}

		return null;

	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final IWorkbenchWindow window;
		int checkerkind;
		String checkKind;
		EObject selectedObject;
		SystemInstance selectedSystemInstance;
		List<ErrorReport> errors;

		checkerkind = AbstractCheck.CHECKER_KIND_UNKNOWN;
		checkKind = event.getParameter("org.osate.codegen.checker.kind");

		/**
		 * Get the type of check we will do. And then, pass it to the checker
		 * object.
		 */
		if (checkKind.equalsIgnoreCase("pok")) {
			checkerkind = AbstractCheck.CHECKER_KIND_POK;
		}
		if (checkKind.equalsIgnoreCase("vxworks")) {
			checkerkind = AbstractCheck.CHECKER_KIND_VXWORKS;
		}
		if (checkKind.equalsIgnoreCase("deos")) {
			checkerkind = AbstractCheck.CHECKER_KIND_DEOS;
		}

		window = HandlerUtil.getActiveWorkbenchWindowChecked(event);

		errors = new ArrayList<ErrorReport>();
		selectedSystemInstance = null;

		selectedObject = SelectionHelper.getSelectedObjectinOutline();

		if (selectedObject instanceof SystemInstance) {
			selectedSystemInstance = (SystemInstance) selectedObject;
		}

		if (selectedObject instanceof SystemImplementation) {
			try {
				selectedSystemInstance = InstantiateModel.buildInstanceModelFile((SystemImplementation) selectedObject);
			} catch (Exception e) {
				e.printStackTrace();
				selectedSystemInstance = null;
			}
		}

		if (selectedSystemInstance == null) {
			MessageDialog.openError(window.getShell(), "Code Generation Checker",
					"Please select a system implementation in the outline view");
			return null;
		}

		errors.addAll(executeCheck(selectedSystemInstance, MemoryCheck.class, checkerkind));
		errors.addAll(executeCheck(selectedSystemInstance, ProcessorCheck.class, checkerkind));
		errors.addAll(executeCheck(selectedSystemInstance, ProcessCheck.class, checkerkind));
		errors.addAll(executeCheck(selectedSystemInstance, ThreadCheck.class, checkerkind));
		errors.addAll(executeCheck(selectedSystemInstance, DataCheck.class, checkerkind));

		/**
		 * For now, we print the errors.
		 */
		for (ErrorReport e : errors) {
			try {
				IMarker marker = getIResource(e.getComponent().eResource()).createMarker(MARKER_TYPE);
				marker.setAttribute(IMarker.MESSAGE, e.getComponent().getName() + " - " + e.getMessage());
				marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
//				marker.setAttribute(IMarker.LINE_NUMBER, lineNumber);
			} catch (CoreException exception) {
				exception.printStackTrace();
			}
		}

		if (errors.isEmpty()) {
			MessageDialog.openInformation(window.getShell(), "Code Generation Checker", "No problems found");
		} else {
			MessageDialog.openError(window.getShell(), "Code Generation Checker", errors.size() + " problem(s) found");
		}

		return null;
	}

}
