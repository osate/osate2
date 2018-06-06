/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
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
