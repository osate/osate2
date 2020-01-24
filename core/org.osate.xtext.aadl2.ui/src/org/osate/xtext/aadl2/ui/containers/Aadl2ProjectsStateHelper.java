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
package org.osate.xtext.aadl2.ui.containers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.ui.containers.WorkspaceProjectsStateHelper;
import org.osate.aadl2.modelsupport.resources.PredeclaredProperties;
import org.osate.pluginsupport.PluginSupportUtil;

import com.google.inject.Singleton;

@Singleton
public class Aadl2ProjectsStateHelper extends WorkspaceProjectsStateHelper {
	private final static String AADL_PROJECT_HANDLE = "$aadl_project$";
	private final static String CONTRIBUTED_HANDLE = "$contributed_aadl_handle$";
	private final static List<URI> CONTRIBUTED_AADL = PluginSupportUtil.getContributedAadl();

	@Override
	public String initHandle(URI uri) {
		if (uri.lastSegment().contentEquals(PredeclaredProperties.AADL_PROJECT)) {
			if (uri.toString().contentEquals(PredeclaredProperties.getAADLProjectPreference())) {
				return AADL_PROJECT_HANDLE;
			} else {
				return null;
			}
		} else if (CONTRIBUTED_AADL.contains(uri)) {
			return CONTRIBUTED_HANDLE;
		} else {
			return super.initHandle(uri);
		}
	}

	@Override
	public Collection<URI> initContainedURIs(String containerHandle) {
		if (containerHandle.contentEquals(AADL_PROJECT_HANDLE)) {
			return Collections
					.singleton(URI.createPlatformResourceURI(PredeclaredProperties.getAADLProjectPreference(), true));
		} else if (containerHandle.equals(CONTRIBUTED_HANDLE)) {
			if (!PredeclaredProperties.getAADLProjectPreference()
					.contentEquals(PredeclaredProperties.AADL_PROJECT_DEFAULT)) {
				return CONTRIBUTED_AADL.stream()
						.filter(uri -> !uri.lastSegment().contentEquals(PredeclaredProperties.AADL_PROJECT))
						.collect(Collectors.toList());
			} else {
				return CONTRIBUTED_AADL;
			}
		} else {
			return super.initContainedURIs(containerHandle);
		}
	}

	@Override
	public List<String> initVisibleHandles(String handle) {
		List<String> result = new ArrayList<>(super.initVisibleHandles(handle));
		result.add(CONTRIBUTED_HANDLE);
		result.add(AADL_PROJECT_HANDLE);
		return result;
	}
}