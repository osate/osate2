/************************************************************************************
 * Copyright (c) 2012 Brandon Breuil. Contributions by Peter Feiler.                                               *
 *                                                                                  *
 * All rights reserved. This program and the accompanying materials are made        *
 * available under the terms of the Eclipse Public License v1.0 which accompanies   *
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html *
 *                                                                                  *
 * Use is subject to the terms of Eclipse Public License v1.0.                      *
 *                                                                                  *
 ************************************************************************************/

package org.osate.imv.ui.outline;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.IWorkbenchAdapter;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Feature;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.imv.ui.ImvAdapterFactory;
import org.osate.imv.ui.editor.ImvInstanceEditor;


public class ImvContentOutlinePage extends ContentOutlinePage {

	private IAdapterFactory adapterFactory = new ImvAdapterFactory();

	// A reference to the editor that is associated with this outline page.
	private ImvInstanceEditor editor;

	/**
	 * The tree viewer.
	 */
	private TreeViewer viewer;

	public ImvContentOutlinePage(ImvInstanceEditor editor){
		Assert.isNotNull(editor);
		this.editor = editor;
	}

	@Override
	public void createControl(Composite parent){
		super.createControl(parent);
		registerAdapters();
		configureTree();
	}


	private void configureTree(){
		/* Set up content and label providers. */
		viewer = this.getTreeViewer();
		viewer.setAutoExpandLevel(2);
		viewer.setLabelProvider(new WorkbenchLabelProvider());
		viewer.setContentProvider(new BaseWorkbenchContentProvider());

		IWorkbenchAdapter root = new IWorkbenchAdapter(){

			@Override
			public Object[] getChildren(Object o) {
				if (editor.getSystemInstance() != null)
				return new Object[] {editor.getSystemInstance()};
				if (editor.getAadlPackage() != null)
				return new Object[] {editor.getAadlPackage()};
				return null;
			}

			@Override
			public ImageDescriptor getImageDescriptor(Object object) {
				return null;
			}

			@Override
			public String getLabel(Object o) {
				return null;
			}

			@Override
			public Object getParent(Object o) {
				return null;
			}

		};

		// Set input to tree viewer.
		viewer.setInput(root);
	}

	private void registerAdapters(){
		// Register adapters for model objects.
		Platform.getAdapterManager().registerAdapters(adapterFactory, SystemInstance.class);
		Platform.getAdapterManager().registerAdapters(adapterFactory, ComponentInstance.class);
		Platform.getAdapterManager().registerAdapters(adapterFactory, FeatureInstance.class);
		Platform.getAdapterManager().registerAdapters(adapterFactory, AadlPackage.class);
		Platform.getAdapterManager().registerAdapters(adapterFactory, ComponentType.class);
		Platform.getAdapterManager().registerAdapters(adapterFactory, ComponentImplementation.class);
		Platform.getAdapterManager().registerAdapters(adapterFactory, Subcomponent.class);
		Platform.getAdapterManager().registerAdapters(adapterFactory, Feature.class);
	}

	private void unregisterAdapters(){
		Platform.getAdapterManager().unregisterAdapters(adapterFactory);
	}

	public void dispose(){
		unregisterAdapters();
		super.dispose();
	}

}
