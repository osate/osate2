/*******************************************************************************
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file). 
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
 *******************************************************************************/
package org.osate.modelstats.ui;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.modelstats.ComponentCounter;
import org.osate.modelstats.ElementsCounts;
import org.osate.ui.handlers.AaxlReadOnlyHandlerAsJob;

public class CountComponentsHandler extends AaxlReadOnlyHandlerAsJob {
	private String fileName;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		super.execute(event);
		IStructuredSelection selection = HandlerUtil.getCurrentStructuredSelection(event);
		IFile file = (IFile) selection.getFirstElement();
		fileName = file.getName();
		return null;
	}

	@Override
	protected String getActionName() {
		return "Model Elements Counter";
	}

	@Override
	protected void doAaxlAction(IProgressMonitor monitor, Element root) {
		SystemInstance si = (SystemInstance) root;
		ElementsCounts elementCounts = ComponentCounter.countComponents(si);

		CountComponentsUI dialog = new CountComponentsUI(getShell(), fileName, getActionName(), elementCounts); // creates the dialog object
		getShell().getDisplay().asyncExec(() -> dialog.open()); // opens the dialog
	}
}
