package org.osate.ui.navigator;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.osate.pluginsupport.PredeclaredProperties;

public final class VirtualPluginResources {
	public enum Kind {
		PLUG_IN("Plug-in Contributions") {
			@Override
			public List<URI> getRawContributions() {
				return PredeclaredProperties.getVisiblePluginContributedResources();
			}
		},
		WORKSPACE("Workspace Contributions") {
			@Override
			public List<URI> getRawContributions() {
				return PredeclaredProperties.getVisibleWorkspaceContributedResources();
			}
		};

		private final String label;

		private Kind(final String label) {
			this.label = label;
		}

		public String getLabel() {
			return label;
		}

		public abstract List<URI> getRawContributions();
	}

	private final Kind kind;
	private final IProject project;

	public VirtualPluginResources(final Kind kind, final IProject project) {
		this.kind = kind;
		this.project = project;
	}

	public Kind getKind() {
		return kind;
	}

	public String getLabel() {
		return kind.getLabel();
	}

	public IProject getParent() {
		return project;
	}

}