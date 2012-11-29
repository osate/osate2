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

package org.osate.imv.ui;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.MissingResourceException;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.model.IWorkbenchAdapter;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.provider.InstanceItemProviderAdapterFactory;
import org.osate.aadl2.provider.Aadl2ItemProviderAdapterFactory;

public class ImvAdapterFactory implements IAdapterFactory{

	private InstanceItemProviderAdapterFactory instanceFactory = new InstanceItemProviderAdapterFactory();

	private Aadl2ItemProviderAdapterFactory aadl2Factory = new Aadl2ItemProviderAdapterFactory();

	private IWorkbenchAdapter elementAdapter = new IWorkbenchAdapter(){

		@Override
		public Object[] getChildren(Object o) {
			List<NamedElement> componentList = new ArrayList<NamedElement>();
			if (o instanceof AadlPackage){
				o = ((AadlPackage)o).getOwnedPublicSection();
			}
			if(o instanceof Element){
				for(Iterator<Element> it = ((Element)o).getChildren().iterator(); it.hasNext();){
					Element ele = it.next();
					// Only object that are instances of ComponentInstance will be displayed in the
					// outline view.
					if(ele instanceof ComponentInstance|| ele instanceof ComponentImplementation)
						componentList.add((NamedElement)ele);
				}
			}
			return componentList.toArray();
		}

		@Override
		public ImageDescriptor getImageDescriptor(Object object) {
			ImageDescriptor desc = null;
			try {
				IItemLabelProvider labelProvider = (IItemLabelProvider) instanceFactory.adapt(object, IItemLabelProvider.class);
				if (labelProvider == null)
					labelProvider = (IItemLabelProvider) aadl2Factory.adapt(object, IItemLabelProvider.class);
				Object imageURL = labelProvider.getImage(object);
				if (imageURL instanceof URL) {
					desc = ImageDescriptor.createFromURL((URL) imageURL);
				}
			} catch (MissingResourceException e) {
				System.err.println("Error: Failed to load image descriptor for: " + object);
			}

			return desc;
		}

		@Override
		public String getLabel(Object o) {
			IItemLabelProvider labelProvider = (IItemLabelProvider)instanceFactory.adapt(o, IItemLabelProvider.class);
			if (labelProvider == null)
				labelProvider = (IItemLabelProvider) aadl2Factory.adapt(o, IItemLabelProvider.class);
			return labelProvider.getText(o);
		}

		@Override
		public Object getParent(Object o) {
			return ((Element)o).getOwner();
		}

	};

	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if(adapterType == IWorkbenchAdapter.class && adaptableObject instanceof Element)
			return elementAdapter;
		else
			return null;
	}

	@Override
	public Class[] getAdapterList() {
		return new Class[] {IWorkbenchAdapter.class};
	}

}
