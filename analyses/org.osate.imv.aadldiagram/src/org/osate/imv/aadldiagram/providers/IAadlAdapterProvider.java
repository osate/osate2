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

package org.osate.imv.aadldiagram.providers;

import org.osate.imv.aadldiagram.adapters.AadlComponentAdapter;


public interface IAadlAdapterProvider {
	public AadlComponentAdapter getContainerComponentAdapter(Object modelElement, int nesting);
	public void updateContainerComponentAdapter(AadlComponentAdapter containerAdapter, int nesting) ;
	
	public void setDirectConnection(boolean dir);
}
