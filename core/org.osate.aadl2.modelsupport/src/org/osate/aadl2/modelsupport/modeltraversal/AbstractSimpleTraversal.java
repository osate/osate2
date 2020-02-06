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

package org.osate.aadl2.modelsupport.modeltraversal;

import java.util.HashSet;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;

abstract class AbstractSimpleTraversal extends AbstractTraversal {

	public AbstractSimpleTraversal(final IProcessingMethod pm) {
		super(pm);
	}

	/**
	 * Process all AADL models in the AadlWorkspace.
	 *
	 * <p>
	 * This method checks whether the processing has been cancelled after
	 * visiting each element, and terminates the processing if the traversal has
	 * been cancelled.
	 *
	 * @return The {@link IProcessingMethod#getResultList() result list} of the
	 *         encapsulated processing method.
	 */
	@Override
	public final EList<Element> visitWorkspace() {
		final ResourceSet resourceSet = new ResourceSetImpl();
		HashSet<IFile> files = TraverseWorkspace.getAadlandInstanceFilesInWorkspace();
		for (final IFile file : files) {
			/*
			 * JD fix for bug
			 * This part of the code was taken from SaveAsTextHandler.java
			 * from package org.osate.xtext.aadl2.ui.handlers. It seems
			 * that we can retrieve all packages using that method using
			 * the XText framework. The code is reused in other methods
			 * in this package also.
			 */
			final TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
					.getEditingDomain("org.osate.aadl2.ModelEditingDomain");
			domain.getCommandStack().execute(new RecordingCommand(domain) {
				@Override
				protected void doExecute() {
					Resource res = resourceSet.getResource(OsateResourceUtil.toResourceURI(file), true);
					Element target = (Element) res.getContents().get(0);

					visitRoot(target);

				}
			});

			if (processingMethod.cancelled()) {
				break;
			}
		}

		return processingMethod.getResultList();
	}

	/**
	 * Process all declarative AADL models in the AadlWorkspace.
	 *
	 * <p>
	 * This method checks whether the processing has been cancelled after
	 * visiting each element, and terminates the processing if the traversal has
	 * been cancelled.
	 *
	 * @return The {@link IProcessingMethod#getResultList() result list} of the
	 *         encapsulated processing method.
	 */
	@Override
	public final EList<Element> visitWorkspaceDeclarativeModels() {
		final ResourceSet resourceSet = new ResourceSetImpl();
		HashSet<IFile> files = TraverseWorkspace.getAadlFilesInWorkspace();
		for (final IFile file : files) {

			/*
			 * JD fix for bug 169. For justification, see comments before.
			 */
			final TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
					.getEditingDomain("org.osate.aadl2.ModelEditingDomain");
			domain.getCommandStack().execute(new RecordingCommand(domain) {
				@Override
				protected void doExecute() {
					Resource res = resourceSet.getResource(OsateResourceUtil.toResourceURI(file), true);
					Element target = (Element) res.getContents().get(0);

					visitRoot(target);

				}
			});

			if (processingMethod.cancelled()) {
				break;
			}
		}
		return processingMethod.getResultList();
	}

	/**
	 * Process all AADL instance models in the AadlWorkspace.
	 *
	 * <p>
	 * This method checks whether the processing has been cancelled after
	 * visiting each element, and terminates the processing if the traversal has
	 * been cancelled.
	 *
	 * @return The {@link IProcessingMethod#getResultList() result list} of the
	 *         encapsulated processing method.
	 */
	@Override
	public final EList<?> visitWorkspaceInstanceModels() {
		HashSet<IFile> files = TraverseWorkspace.getInstanceModelFilesInWorkspace();
		for (IFile file : files) {
			SystemInstance target = Platform.getAdapterManager().getAdapter(file,
					SystemInstance.class);
			if (target != null) {
				visitRoot(target);
			}
			if (processingMethod.cancelled()) {
				break;
			}
		}
		return processingMethod.getResultList();
	}
}
