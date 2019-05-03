/*
 * <copyright>
 * Copyright  2007 by Carnegie Mellon University, all rights reserved.
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Stream;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.osate.core.AadlNature;
import org.osate.pluginsupport.PluginSupportUtil;
import org.osate.xtext.aadl2.ui.resource.ContributedAadlStorage;

public class AadlContributionContentProvider extends WorkbenchContentProvider {

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof IProject) {
			IProject project = (IProject) element;
			try {
				if (project.getNature(AadlNature.ID) != null) {
					return true;
				}
			} catch (CoreException e) {
				// couldn't retrieve AADL nature from project
			}
		} else if (element instanceof VirtualPluginResources) {
			return true;
		}
		return super.hasChildren(element);
	}

	@Override
	public Object[] getChildren(Object element) {
		if (element instanceof IProject) {
			IProject project = (IProject) element;
			try {
				if (project.getNature(AadlNature.ID) != null) {
					Object[] result = { new VirtualPluginResources(project) };
					return result;
				}
			} catch (CoreException e) {
				// couldn't retrieve AADL nature from project
			}
			return new Object[0];
		} else if (element instanceof VirtualPluginResources) {
			return PluginSupportUtil.getContributedAadl().stream().map(uri -> {
				OptionalInt firstSignificantIndex = PluginSupportUtil.getFirstSignificantIndex(uri);
				if (!firstSignificantIndex.isPresent() || firstSignificantIndex.getAsInt() == uri.segmentCount() - 1) {
					return new ContributedAadlStorage(element, uri);
				} else {
					return new ContributedDirectory(element,
							Collections.singletonList(uri.segment(firstSignificantIndex.getAsInt())));
				}
			}).distinct().toArray();
		} else if (element instanceof ContributedDirectory) {
			List<String> directoryPath = ((ContributedDirectory) element).getPath();
			Stream<URI> inDirectory = PluginSupportUtil.getContributedAadl().stream().filter(uri -> {
				OptionalInt firstSignificantIndex = PluginSupportUtil.getFirstSignificantIndex(uri);
				if (firstSignificantIndex.isPresent() && firstSignificantIndex.getAsInt() < uri.segmentCount() - 1) {
					List<String> uriDirectory = uri.segmentsList().subList(firstSignificantIndex.getAsInt(),
							uri.segmentCount() - 1);
					return isPrefix(directoryPath, uriDirectory);
				} else {
					return false;
				}
			});

			return inDirectory.map(uri -> {
				int nextSignificantIndex = PluginSupportUtil.getFirstSignificantIndex(uri).getAsInt()
						+ directoryPath.size();
				if (nextSignificantIndex == uri.segmentCount() - 1) {
					return new ContributedAadlStorage(element, uri);
				} else {
					ArrayList<String> newPath = new ArrayList<>(directoryPath);
					newPath.add(uri.segment(nextSignificantIndex));
					return new ContributedDirectory(element, newPath);
				}
			}).distinct().toArray();
		}
		return super.getChildren(element);
	}

	@Override
	public Object getParent(Object element) {
		if (element instanceof VirtualPluginResources) {
			return ((VirtualPluginResources) element).getParent();
		} else if (element instanceof ContributedDirectory) {
			return ((ContributedDirectory) element).getParent();
		} else if (element instanceof ContributedAadlStorage) {
			return ((ContributedAadlStorage) element).getParent();
		} else {
			return super.getParent(element);
		}
	}

	/**
	 * Is the first list a prefix of the second one?
	 */
	private static <T> boolean isPrefix(final List<T> first, final List<T> second) {
		if (first.size() > second.size()) {
			return false;
		} else {
			for (int i = 0; i < first.size(); i++) {
				if (first.get(i) != second.get(i)) {
					return false;
				}
			}
			return true;
		}
	}
}