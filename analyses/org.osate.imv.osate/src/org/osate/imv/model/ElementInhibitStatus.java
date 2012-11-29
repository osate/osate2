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

package org.osate.imv.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ElementInhibitStatus<T> {

	public static final String CATEGORY_PROPERTY = "category";
	public static final String INHIBIT_PROPERTY = "inhibited";

	private T category;
	private boolean inhibited;

	private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(
			this);

	public ElementInhibitStatus(T category){
		this(category, false);
	}

	public ElementInhibitStatus(T category, boolean inhibited){
		this.category = category;
		this.inhibited = inhibited;
	}

	public T getCategory() {
		return category;
	}

	public void setCategory(T category) {
		propertyChangeSupport.firePropertyChange(CATEGORY_PROPERTY, this.category, this.category = category);
	}

	public boolean isInhibited() {
		return inhibited;
	}

	public void setInhibited(boolean inhibit) {
		propertyChangeSupport.firePropertyChange(INHIBIT_PROPERTY, this.inhibited, this.inhibited = inhibit);
	}

	public String toString(){
		return category.toString();
	}

	public void addPropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(listener);
	}
}
