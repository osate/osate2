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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceProxy;
import org.eclipse.core.resources.IResourceProxyVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.ide.ui.dependency.IDependencyProvider;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.graphiti.mm.pictograms.Diagram;

@SuppressWarnings("restriction")
public class DiagramDependencyProvider implements IDependencyProvider {

	static String[] HANDLED_EXTS = { "aadl_diagram" };

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

	private boolean isContributed(URI uri) {
		return uri.isPlatformPlugin() || uri.isPlatformResource() && uri.segment(1).equals("Plugin_Resources");
	}

	@Override
	public Set<URI> getDependencies(URI uri, URIConverter uriConverter) {
		Set<URI> result = new HashSet<URI>();
		System.out.println(uri.toString());
		if (!uri.isPlatformResource()) {
			return result;
		}

		ResourceSet rs = new ResourceSetImpl();
		Resource res = rs.getResource(uri, true);
		Diagram d = (Diagram) res.getContents().get(0);
		String name = d.getName().toLowerCase();
		int i = name.lastIndexOf(':') - 1;
		String packageName = i <= 0 ? name : name.substring(0, i);
		// read aadl files and find package name in text should be fastest option
		IWorkspace ws = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot wr = ws.getRoot();
		IProject pr = wr.getProject(uri.segment(1));
		try {
			boolean[] cancel = { false };
			pr.accept(new IResourceProxyVisitor() {

				@Override
				public boolean visit(IResourceProxy proxy) throws CoreException {
					if (cancel[0] == false && proxy.getType() == IResource.FILE) {
						if (proxy.getName().endsWith("aadl") || proxy.getName().endsWith("aadl2")) {
							cancel[0] = findPackage((IFile) proxy.requestResource());
						}
					}
					return true;
				}

				private boolean findPackage(IFile resource) {
					try (BufferedReader br = new BufferedReader(new InputStreamReader(resource.getContents()))) {
						String line;
						boolean foundPackage = false;
						while ((line = br.readLine()) != null) {
							line = line.trim().toLowerCase();
							if (line.startsWith("--")) {
								continue;
							}
							line = line.toLowerCase();
							if (!foundPackage) {
								if (line.startsWith("package")) {
									foundPackage = true;
									line = line.substring(7).trim();
									if (line.startsWith("--")) {
										continue;
									}
								}
							}
							if (foundPackage) {
								cancel[0] = true;
								if (line.equals(packageName)) {
									result.add(URI.createPlatformResourceURI(resource.getFullPath().toString(), false));
								}
							}
						}
					} catch (CoreException | IOException e) {
					}
					return false;
				}
			}, 0);
		} catch (CoreException e) {
		}
		return result;
	}

}
