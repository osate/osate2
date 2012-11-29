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

package org.osate.imv.providers;

import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Context;
import org.osate.aadl2.Element;
import org.osate.aadl2.Feature;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.imv.aadldiagram.providers.IAadlContentProvider;


public class OsateContentProvider implements IAadlContentProvider {

	@Override
	public boolean isAllowedToBeContainer(Object element) {
		boolean retValue = false;
		if(element instanceof ComponentInstance || element instanceof ComponentImplementation)
			retValue = true;
		return retValue;
	}


	protected FeatureInstance featureInstanceForFeature(ComponentInstance component, Context context, Feature feature) {
		FeatureInstance featureInstance = null;

		if (context == null || context instanceof ComponentImplementation) {
			//lookup feature in the context using the connection src
			featureInstance = component.findFeatureInstance(feature);
		} else if (context instanceof Subcomponent) {
			//lookup feature in the subcomponent
			featureInstance = component.findSubcomponentInstance((Subcomponent) context).findFeatureInstance(
					feature);
		}

		return featureInstance;
	}

	@Override
	public Object getRoot(Object object) {
		Element element = (Element)object;
		return element.getElementRoot();
	}

	@Override
	public Object getParent(Object object) {
		// Get the parent of the input object.
		Element element = (Element)object;
		return element.getOwner();
	}

}
