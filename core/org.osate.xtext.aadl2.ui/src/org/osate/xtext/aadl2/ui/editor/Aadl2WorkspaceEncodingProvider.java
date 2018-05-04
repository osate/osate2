package org.osate.xtext.aadl2.ui.editor;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.ui.editor.WorkspaceEncodingProvider;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class Aadl2WorkspaceEncodingProvider extends WorkspaceEncodingProvider {

	private static final Logger LOG = Logger.getLogger(Aadl2WorkspaceEncodingProvider.class);

	@Inject
	private IWorkspace workspace;

	@Override
	public String getEncoding(URI uri) {
		if (workspace != null) {
			if (uri != null) {
				if (uri.isPlatformPlugin()) {
					try {
						return workspace.getRoot().getDefaultCharset();
					} catch (CoreException e) {
						LOG.error("Error getting file encoding for " + uri, e);
					}
				}
			}
		}
		return super.getEncoding(uri);
	}

}
