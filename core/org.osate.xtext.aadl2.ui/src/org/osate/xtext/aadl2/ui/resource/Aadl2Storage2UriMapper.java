/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.xtext.aadl2.ui.resource;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.ui.resource.Storage2UriMapperImpl;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.osate.pluginsupport.PluginSupportUtil;

public class Aadl2Storage2UriMapper extends Storage2UriMapperImpl {
	/*
	 * Here we still use PluginSupportUtil.getContributedAadl() and not
	 * PredeclaredProperties.getVisibleContributedResources(). We are just determining which items need a special
	 * Storage object, and it is only going to be those are contributed by a plug-in. Items that are contributed by the
	 * workspace are already resources in the workspace and should open just fine.
	 */
	private final Map<URI, ContributedAadlStorage> contributedAadlStorages = createContributedAadlStorages();

	@Override
	public Iterable<Pair<IStorage, IProject>> getStorages(URI uri) {
		if (!contributedAadlStorages.containsKey(uri)) {
			return super.getStorages(uri);
		}
		var projects = getWorkspaceRoot().getProjects();
		IProject firstProject = projects.length == 0 ? null : projects[0];
		return List.of(Tuples.<IStorage, IProject>create(contributedAadlStorages.get(uri), firstProject));
	}

	@Override
	public URI getUri(IStorage storage) {
		if (storage instanceof ContributedAadlStorage contributedStorage) {
			return contributedStorage.getUri();
		}
		return super.getUri(storage);
	}

	private static Map<URI, ContributedAadlStorage> createContributedAadlStorages() {
		var storages = new LinkedHashMap<URI, ContributedAadlStorage>();
		for (var uri : PluginSupportUtil.getContributedAadl()) {
			storages.put(uri, new ContributedAadlStorage(null, uri));
		}
		return storages;
	}
}
