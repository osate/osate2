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
package org.osate.testsupport;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.osate.pluginsupport.PluginSupportUtil;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

@Singleton
public class TestResourceSetHelper {

	@Inject
	protected Provider<XtextResourceSet> rsp;

	protected static XtextResourceSet set;

	private static List<URI> contributed = PluginSupportUtil.getContributedAadl();

	/**
	 * Provide resource set initialized with all plugin-contributed AADL packages
	 * and property sets for use in junit tests. This method returns the same resource set
	 * with the same content each time it is called. All resources loaded since
	 * the previous call are removed.
	 *
	 * @return the initialized resource set
	 */
	public XtextResourceSet getResourceSet() {
		if (set == null) {
			set = rsp.get();
			initialize();
		} else {
			clean();
		}
		return set;
	}

	protected void initialize() {
		Map<URI, URI> uriMap = set.getURIConverter().getURIMap();

		for (URI uri : contributed) {
			set.getResource(uri, true);
			uriMap.put(uri, URI.createPlatformResourceURI(uri.path().substring(7), false));
		}
	}

	protected void clean() {
		EList<Resource> resources = set.getResources();
		set.getResources().stream().skip(contributed.size()).forEach(Resource::unload);
		for (int i = resources.size(); i > contributed.size(); i--) {
			resources.remove(i - 1);
		}
	}
}
