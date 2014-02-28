/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.ui.properties;

import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.ui.provider.PropertySource;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.osate.aadl2.Element;
import org.osate.ui.UiUtil;

public class AadlElementPropertySource implements IPropertySource {
	private final IPropertySource src;
	public AadlElementPropertySource(final Element element) {
		final IItemPropertySource itemPropSrc = (IItemPropertySource)UiUtil.getAdapterFactory().adapt(element, IItemPropertySource.class);
		if(itemPropSrc == null) {
			src = null;
		} else {
			src = new PropertySource(element, itemPropSrc);
		}
	}

	@Override
	public Object getEditableValue() {
		if(src != null) {
			return src.getEditableValue();
		}
		return null;
	}
	
	// http://help.eclipse.org/indigo/index.jsp?topic=%2Forg.eclipse.platform.doc.isv%2Freference%2Fapi%2Forg%2Feclipse%2Fui%2Fviews%2Fproperties%2FIPropertyDescriptor.html
	@Override
	public IPropertyDescriptor[] getPropertyDescriptors() {
		if(src != null) {
			return src.getPropertyDescriptors();
		}
		return null;
				/*
		System.out.println(UiUtil.getAdapterFactory().adapt(element, IPropertySource.class));
		if(src != null) {
			final List<IItemPropertyDescriptor> descriptors = src.getPropertyDescriptors(element);
			if(descriptors != null) {
				IPropertyDescriptor[] descs = new IPropertyDescriptor[descriptors.size()];
				for(int i=0; i < descs.length; i++) {
					descs[i] = new PropertyDescriptor(descriptors.get(i).getId(element), descriptors.get(i).getDisplayName(element)) {
						@Override
						public String getCategory() {
							return null;
						};
					};
				}
				return descs;
			}
		}
			
		return null;*/
	}

	@Override
	public Object getPropertyValue(Object id) {
		if(src != null) {
			return src.getPropertyValue(id);
		}
		return null;
	}

	@Override
	public boolean isPropertySet(Object id) {
		if(src != null) {
			return src.isPropertySet(id);
		}
		return false;
	}

	@Override
	public void resetPropertyValue(Object id) {			
		if(src != null) {
			src.resetPropertyValue(id);
		}
	}

	@Override
	public void setPropertyValue(Object id, Object value) {
		if(src != null) {
			src.setPropertyValue(id, value);
		}
	}

}
