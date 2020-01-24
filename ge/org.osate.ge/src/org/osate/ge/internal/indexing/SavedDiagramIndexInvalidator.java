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
