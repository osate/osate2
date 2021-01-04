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

package org.osate.ui.wizards;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;

/**
 * @since 5.0
 */
public class PluginInfo {
	public PluginInfo() {
	}

	public PluginInfo(URL exampleURI, URL readmeURI, String name, String category, String bundle) {
		this.exampleURI = exampleURI;
		this.readmeURI = readmeURI;
		this.name = name;
		this.category = category;
		this.bundle = bundle;
	}

	public PluginInfo(String name) {
		this.name = name;
	}

	public String exampleS;
	public URL exampleURI;
	public URL readmeURI;
	public String name;
	public String category;
	public String bundle;
	public List<String> projectPath;
	protected List<PluginInfo> nodes = new ArrayList<>();
	protected PluginInfo parent;

	public List<PluginInfo> getNode() {
		return nodes;
	}

	public void addProjectPath(String path) {
		if (this.projectPath == null) {
			this.projectPath = new ArrayList<String>();
		}

		this.projectPath.add(path);
	}

	protected void addNode(PluginInfo node) {
		nodes.add(node);
		node.parent = this;
	}

	protected PluginInfo getParent() {
		return parent;
	}

	public IProject getProject() {
		return ResourcesPlugin.getWorkspace().getRoot().getProject(name);
	}

	public IFile getWorkspaceFile() {
		return ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(exampleURI.getPath()));
	}
}