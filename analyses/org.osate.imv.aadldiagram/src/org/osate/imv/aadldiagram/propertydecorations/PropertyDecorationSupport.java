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

package org.osate.imv.aadldiagram.propertydecorations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.osate.imv.aadldiagram.aadlfigures.components.ComponentFigure;
import org.osate.imv.aadldiagram.adapters.ComponentAdapterCategory;


public class PropertyDecorationSupport {

	private static final String PROPERTY_DECORATION_EXTENSION_POINT = "edu.erau.aadldiagram.propertydecorations";

	private static final String THREAD_ELEMENT = "thread";
	private static final String DEVICE_ELEMENT = "device";
	private static final String ALL_ELEMENT = "all";

	private Map<ComponentAdapterCategory, List<IConfigurationElement>> elementTypeToConfigMap;

	public PropertyDecorationSupport() {
		this.initializeElementTypeToDecorationMap();
		this.loadPropertyDecorationExtensions();
	}

	public void addPropertyDecorations(ComponentAdapterCategory category, ComponentFigure compFigure, Object modelElement) {
		try {
			List<IConfigurationElement> configList = this.elementTypeToConfigMap.get(category);
			if (configList != null) {
				for (IConfigurationElement e : configList) {
					final Object o = e.createExecutableExtension("class");
					if (o instanceof IPropertyDecorationDelegate) {
						IPropertyDecorationDelegate delegate = (IPropertyDecorationDelegate) o;
						delegate.setAadlElement(modelElement);
						compFigure.addPropertyDecorationDelegate(delegate);
					}
				}
			}
		} catch (CoreException ex) {
			System.err.println(ex.getMessage());
		}
	}

	private void loadPropertyDecorationExtensions() {
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(PROPERTY_DECORATION_EXTENSION_POINT);

		for (IConfigurationElement e : config) {
			this.addElementToDecorationMap(e.getName(), e);
		}
	}

	private void addElementToDecorationMap(String elementName, IConfigurationElement configElement) {
		ComponentAdapterCategory category = null;

		if(elementName.equals(ALL_ELEMENT)) {
			for(Iterator<List<IConfigurationElement>> it = this.elementTypeToConfigMap.values().iterator(); it.hasNext();)
				it.next().add(configElement);
		} else {
			if(elementName.equals(THREAD_ELEMENT))
				category = ComponentAdapterCategory.THREAD;
			else if(elementName.equals(DEVICE_ELEMENT))
				category = ComponentAdapterCategory.DEVICE;

			List<IConfigurationElement> list = this.elementTypeToConfigMap.get(category);
			if(list != null)
				list.add(configElement);
		}
	}

	private void initializeElementTypeToDecorationMap() {
		this.elementTypeToConfigMap = new HashMap<ComponentAdapterCategory, List<IConfigurationElement>>();
		this.elementTypeToConfigMap.put(ComponentAdapterCategory.THREAD, new ArrayList<IConfigurationElement>());
		this.elementTypeToConfigMap.put(ComponentAdapterCategory.DEVICE, new ArrayList<IConfigurationElement>());
	}
}
