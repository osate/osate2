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