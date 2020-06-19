/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
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
