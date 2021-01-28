/**
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
 */
package org.osate.xtext.aadl2.ui.resource

import org.eclipse.core.resources.IStorage
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.ui.resource.Storage2UriMapperImpl
import org.eclipse.xtext.util.Tuples
import org.osate.pluginsupport.PluginSupportUtil

class Aadl2Storage2UriMapper extends Storage2UriMapperImpl {
	/* Here we still use PluginSupportUtil.getContributedAadl() and not PredeclaredProperties.getVisibleContributedResources().
	 * We are just determining which items need a special Storage object, and it's only going to be those are 
	 * contributed by a plug-in.  Items that are contributed by the workspace are already resources in the workspace 
	 * and should open just fine.
	 */
	val CONTRIBUTED_AADL = PluginSupportUtil.contributedAadl.toInvertedMap[new ContributedAadlStorage(null, it)]
	
	override getStorages(URI uri) {
		if (CONTRIBUTED_AADL.containsKey(uri)) {
			#[Tuples.create(CONTRIBUTED_AADL.get(uri), workspaceRoot.projects.head)]
		} else {
			super.getStorages(uri)
		}
	}
	
	override getUri(IStorage storage) {
		if (storage instanceof ContributedAadlStorage) {
			storage.uri
		} else {
			super.getUri(storage)
		}
	}
}