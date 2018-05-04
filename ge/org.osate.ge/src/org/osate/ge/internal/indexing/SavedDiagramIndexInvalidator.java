package org.osate.ge.internal.indexing;

import java.util.Objects;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.runtime.CoreException;

// Responds to resource change events and invalidates a SaveDiagramIndex accordingly. 
// An instance of this class should be registered as a resource change listener for the workspace.
public class SavedDiagramIndexInvalidator implements IResourceChangeListener {
	private SavedDiagramIndex index;
	
	private IResourceDeltaVisitor visitor = new IResourceDeltaVisitor() {
        public boolean visit(final IResourceDelta delta) {
        	final IResource resource = delta.getResource();

        	if ((resource.getType() == IResource.PROJECT && delta.getKind() != IResourceDelta.CHANGED) ||
        		   (resource.getType() == IResource.FILE)) {

	        	// Remove resources from the index. They will be recreated lazily.
	        	if(resource instanceof IProject) {
	        		index.remove((IProject)resource);
	        		return true;
	        	} else if(resource instanceof IFile) {
	        		index.remove((IFile)resource);
	        		return false;
	        	}
        	}

        	return true;
        }
    };
    
    public SavedDiagramIndexInvalidator(final SavedDiagramIndex index) {
    	this.index = Objects.requireNonNull(index, "index must not be null");
    }
    
	@Override
	public void resourceChanged(final IResourceChangeEvent event) {
		final IResourceDelta delta = event.getDelta();
		if(delta != null) {
			try {
				delta.accept(visitor);
			} catch (final CoreException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
