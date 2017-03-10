/**
 * <copyright>
 * Copyright 2016 by Carnegie Mellon University, all rights reserved.
 * 
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/epl-v10.html.
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
 * of Defense under Contract FA8721-05-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 */

package org.osate.core.compare;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.ide.ui.dependency.IDependencyProvider;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResourceSet;

@SuppressWarnings("restriction")
public class XtextDependencyProvider implements IDependencyProvider {

	static final String[] HANDLED_EXTS = { "aadl", "aadl2", "instance", "assure", "alisa", "cat", "filter", "org",
			"reqspec", "goals", "constants", "reqdoc", "goaldoc", "verify", "methodregistry", "results" };

	protected static Map<URI, Set<URI>> cache = new HashMap<URI, Set<URI>>();
	protected static long timestamp = 0;

	@Override
	public boolean apply(URI uri) {
		String extension = uri.fileExtension();
		for (String ext : HANDLED_EXTS) {
			if (ext.equals(extension)) {
				return !isContributed(uri);
			}
		}
		return false;
	}

	protected boolean isContributed(URI uri) {
		return uri.isPlatformPlugin() || uri.isPlatformResource() && uri.segment(1).equals("Plugin_Resources");
	}

	@Override
	public Set<URI> getDependencies(URI uri, URIConverter uriConverter) {
		long now = System.currentTimeMillis();
		if (now - timestamp > 500) {
			cache.clear();
		}
		timestamp = System.currentTimeMillis();
		if (cache.containsKey(uri)) {
			return cache.get(uri);
		}
		Set<URI> result = new HashSet<URI>();
		System.out.println(uri.toString());
		try {
			IResourceServiceProvider rsp = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(uri);
			XtextResourceSet rs = rsp.get(XtextResourceSet.class);
			Resource res = rs.createResource(uri);
			IResourceDescription.Manager mgr = rsp.getResourceDescriptionManager();
			IResourceDescription rd = mgr.getResourceDescription(res);

			for (IReferenceDescription ref : rd.getReferenceDescriptions()) {
				URI refUri = ref.getTargetEObjectUri().trimFragment();
				if (!isContributed(refUri)) {
					result.add(refUri);
				}
			}
		} catch (NullPointerException e) {
			// ignore, happens only if language plugins are missing or guice fails
		}
		cache.put(uri, result);
		return result;
	}

}
