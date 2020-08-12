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
package org.osate.ui.internal.instantiate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceRuleFactory;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.jobs.MultiRule;
import org.eclipse.ui.IWorkingSet;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.instantiation.RootMissingException;
import org.osate.core.AadlNature;
import org.osate.workspace.WorkspacePlugin;

/**
 * @since 3.0
 */
public final class ReinstantiationEngine extends AbstractInstantiationEngine<IFile> {
	public ReinstantiationEngine(final List<?> selectionAsList) {
		super(selectionAsList);
	}

	@Override
	protected PrereqHelper getPrereqHelper(final int size, final IResourceRuleFactory ruleFactory) {
		return new PrereqHelper() {
			final List<IFile> inputs = new ArrayList<>(size);

			@Override
			public void handleInput(final IFile input) {
				inputs.add(input);
			}

			@Override
			public boolean performPrereqs() {
				// nothing to do here
				return true;
			}

			@Override
			public ReinstantiationJob getJob(final int i, final Map<IFile, InternalJobResult> results) {
				final IFile aaxlFile = inputs.get(i);
				final ReinstantiationJob job = new ReinstantiationJob(aaxlFile, results);
				/*
				 * NB. According to <https://www.eclipse.org/articles/Article-Concurrency/jobs-api.html> locking
				 * is only needed for modification, not for reading from resources. This seems sketchy to me
				 * but I'm going to go with it. Readers are supposed to written defensively, to expect that
				 * things might go wonky.
				 *
				 * We create and possibly remove the aaxl file in the case of errors.
				 */
				job.setRule(MultiRule.combine(ruleFactory.modifyRule(aaxlFile), ruleFactory.deleteRule(aaxlFile)));
				return job;
			}
		};
	}

	@Override
	protected Set<IFile> getInputsFromSelection(final List<?> selectionAsList) {
		final List<IFile> instanceFiles = new ArrayList<>();
		findAllInstanceFiles(selectionAsList.toArray(new Object[selectionAsList.size()]), instanceFiles);
		// remove duplicates
		return instanceFiles.stream().distinct().collect(Collectors.toSet());
	}

	private static void findAllInstanceFiles(final Object[] rsrcs, final List<IFile> instanceFiles) {
		for (final Object rsrc : rsrcs) {
			if (rsrc instanceof IWorkingSet) {
				findAllInstanceFiles(((IWorkingSet) rsrc).getElements(), instanceFiles);
			} else if (rsrc instanceof IFile) {
				final IFile file = (IFile) rsrc;
				final String ext = file.getFileExtension();
				if (ext.equals(WorkspacePlugin.INSTANCE_FILE_EXT)) {
					instanceFiles.add(file);
				}
			} else if (rsrc instanceof IContainer) {
				final IContainer container = (IContainer) rsrc;
				if (container instanceof IProject) {
					final IProject project = (IProject) container;
					if (!project.isOpen() || !AadlNature.hasNature(project)) {
						// Project is closed or is not an AADL project, so ignore it
						continue;
					}
				}

				if (!container.getName().startsWith(".")) {
					try {
						findAllInstanceFiles(container.members(), instanceFiles);
					} catch (CoreException e) {
						WorkspacePlugin.log(e);
					}
				}
			}
		}
	}

	private final class ReinstantiationJob extends AbstractInstantiationJob {
		private final IFile modelFile;

		public ReinstantiationJob(final IFile modelFile, final Map<IFile, InternalJobResult> results) {
			super("Reinstantiate " + modelFile.getName(), results);
			this.modelFile = modelFile;
		}

		@Override
		protected SystemInstance buildSystemInstance(final IProgressMonitor monitor)
				throws InterruptedException, OperationCanceledException, RootMissingException, Exception {
			return InstantiateModel.rebuildInstanceModelFile(modelFile, monitor);
		}

		@Override
		protected IFile getOutputFile() {
			return modelFile;
		}

		@Override
		protected IFile getInput() {
			return modelFile;
		}
	}

	@Override
	protected String getResultActionName() {
		return "Reinstantiation";
	}

	@Override
	protected String getResultLabelName() {
		return "Instance Model";
	}

	@Override
	protected Function<IFile, String> getResultLabelProvider() {
		return modelFile -> modelFile.getFullPath().toString();
	}
}
