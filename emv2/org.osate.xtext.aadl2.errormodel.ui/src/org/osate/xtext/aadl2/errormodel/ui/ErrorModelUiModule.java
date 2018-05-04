/*
 * <copyright>
 * Copyright  2012 by Carnegie Mellon University, all rights reserved.
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
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE
 */
package org.osate.xtext.aadl2.errormodel.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.resource.containers.IAllContainersState;
import org.eclipse.xtext.ui.shared.Access;
import org.osate.xtext.aadl2.errormodel.ui.contentassist.antlr.AnnexAwareEntryPointFinder;
import org.osate.xtext.aadl2.ui.containers.Aadl2ProjectsState;
import org.osate.xtext.aadl2.ui.containers.Aadl2ProjectsStateHelper;

/**
 * Use this class to register components to be used within the IDE.
 */
public class ErrorModelUiModule extends org.osate.xtext.aadl2.errormodel.ui.AbstractErrorModelUiModule {
	public ErrorModelUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	public Class<? extends org.eclipse.xtext.ui.editor.contentassist.antlr.EntryPointFinder> bindEntryPointFinder() {
		return AnnexAwareEntryPointFinder.class;
	}

	@Override
	public com.google.inject.Provider<org.eclipse.xtext.resource.containers.IAllContainersState> provideIAllContainersState() {
		return Access.<IAllContainersState> provider(Aadl2ProjectsState.class);
	}

	public Class<? extends Aadl2ProjectsStateHelper> bindWorkspaceProjectsStateHelper() {
		return Aadl2ProjectsStateHelper.class;
	}
}