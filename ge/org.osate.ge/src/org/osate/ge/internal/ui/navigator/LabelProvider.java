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
package org.osate.ge.internal.ui.navigator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.osate.ge.internal.services.DiagramService;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;

public class LabelProvider implements ILabelProvider {
	private final IBaseLabelProvider innerLabelProvider; // An optional label provider that will return the results if the content is not a diagram.
	private final List<ILabelProviderListener> listeners = new ArrayList<ILabelProviderListener>();
	private final DiagramService diagramService;
	private final IResourceChangeListener resourceChangeListener = new IResourceChangeListener() {
		public void resourceChanged(final IResourceChangeEvent event) {
			if(event.getType() == IResourceChangeEvent.POST_CHANGE) {
				try {
					event.getDelta().accept(new IResourceDeltaVisitor() {
						@Override
						public boolean visit(final IResourceDelta delta) throws CoreException {
							if(delta.getKind() == IResourceDelta.CHANGED && (delta.getFlags() & IResourceDelta.CONTENT) != 0) {
								if(isApplicable(delta.getResource())) {
									Display.getDefault().asyncExec(new Runnable() {
										@Override
										public void run() {
											notifyListeners(delta.getResource());
										}
									});
								}
							}
							
							return true;
						}
						 
					 });
				} catch (CoreException e) {
					e.printStackTrace();
				}
	         }
	      }
	   };
	   
	public LabelProvider() {
		this(null);
	}	
	
	public LabelProvider(final IBaseLabelProvider innerLabelProvider) {
		this.innerLabelProvider = innerLabelProvider;
		this.diagramService = (DiagramService)PlatformUI.getWorkbench().getActiveWorkbenchWindow().getService(DiagramService.class);

		// Register to listen for workspace changes
		ResourcesPlugin.getWorkspace().addResourceChangeListener(resourceChangeListener);
	}
	
	@Override
	public void addListener(final ILabelProviderListener listener) {
		listeners.add(listener);
		
		if(innerLabelProvider != null) {
			innerLabelProvider.addListener(listener);
		}
	}

	@Override
	public void removeListener(final ILabelProviderListener listener) {
		listeners.remove(listener);
		
		if(innerLabelProvider != null) {
			innerLabelProvider.removeListener(listener);
		}
	}

	@Override
	public void dispose() {	
		listeners.clear();
		
		// Register to listen for workspace changes
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(resourceChangeListener);
		
		if(innerLabelProvider != null) {
			innerLabelProvider.dispose();
		}
	}
	
	private void notifyListeners(final Object resource) {
		for(final ILabelProviderListener listener : listeners) {
			listener.labelProviderChanged(new LabelProviderChangedEvent(this, resource));
		}
	}
	
	@Override
	public boolean isLabelProperty(Object element, String property) {
		if(innerLabelProvider != null) {
			return innerLabelProvider.isLabelProperty(element, property);
		}
		
		return false;
	}
	
	@Override
	public Image getImage(Object element) {
		if(innerLabelProvider instanceof ILabelProvider) {
			return((ILabelProvider)innerLabelProvider).getImage(element);
		}
		
		return null;
	}

	private boolean isApplicable(Object element) {
		if(element instanceof IFile) {
			final IFile file = (IFile)element;
			return AgeDiagramEditor.EXTENSION_NO_DOT.equalsIgnoreCase(file.getFileExtension());
		}
		
		return false;
	}
	
	@Override
	public String getText(Object element) {
		if(isApplicable(element)) {
			final IFile file = (IFile)element;
			final String name = diagramService.getName(file);
			return name == null ? file.getName() : name;
		}
		
		if(innerLabelProvider instanceof ILabelProvider) {
			return ((ILabelProvider)innerLabelProvider).getText(element);
		}
		
		return null;
	}
}
