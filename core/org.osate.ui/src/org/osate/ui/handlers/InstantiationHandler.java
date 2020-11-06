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
package org.osate.ui.handlers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.ui.internal.instantiate.InstantiationEngine;

/**
 * @since 3.0
 */
public final class InstantiationHandler extends AbstractHandler {
	public InstantiationHandler() {
	}

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		// Get a COPY of the selection for thread safety
		@SuppressWarnings("unchecked")
		final List<?> selectionAsList = new ArrayList<>(HandlerUtil.getCurrentStructuredSelection(event).toList());

		final Job job = new KickoffJob(selectionAsList);
		job.setRule(null); // doesn't use resources
		job.schedule();

		// Supposed to always return null
		return null;
	}

	private final class KickoffJob extends Job {
		private final List<?> selectionAsList;

		public KickoffJob(final List<?> selectionAsList) {
			super("Instantiation");
			this.selectionAsList = selectionAsList;
		}

		@Override
		protected IStatus run(final IProgressMonitor monitor) {
			final InstantiationEngine engine = new InstantiationEngine(selectionAsList);
			engine.instantiate(monitor);
			return Status.OK_STATUS;
		}
	}
}
