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
package org.osate.ge.internal.tooltips;

import javax.inject.Named;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.EventDataSource;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.InternalFeature;
import org.osate.aadl2.PortProxy;
import org.osate.aadl2.ProcessorFeature;
import org.osate.aadl2.SubprogramProxy;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.ge.di.Names;
import org.osate.ge.di.Activate;

/**
 * Shows tooltip for feature instances
 */
public class FeatureInstanceTooltipContributor {
	@Activate
	public void getTooltip(final Composite parent, @Named(Names.BUSINESS_OBJECT) FeatureInstance featureInstance) {
		final Feature feature = featureInstance.getFeature();

		if(feature instanceof Feature || feature instanceof InternalFeature || feature instanceof ProcessorFeature) {
			// Determine the feature classifier
			final Classifier featureClassifier;
			if(feature instanceof EventDataSource) {
				final EventDataSource aadlFeature = (EventDataSource)feature;
				featureClassifier = aadlFeature.getDataClassifier();
			} else if(feature instanceof PortProxy) {
				final PortProxy aadlFeature = (PortProxy)feature;
				featureClassifier = aadlFeature.getDataClassifier();
			} else if(feature instanceof SubprogramProxy) {
				final SubprogramProxy aadlFeature = (SubprogramProxy)feature;
				featureClassifier = aadlFeature.getSubprogramClassifier();
			} else if(feature instanceof Feature) {
				final Feature aadlFeature = (Feature)feature;
				featureClassifier = aadlFeature.getAllClassifier();		    	
			} else {
				featureClassifier = null;
			}
			
			// Build the text to contribute to the tooltip
			final StringBuffer tooltipContents = new StringBuffer();
			if(featureClassifier instanceof ComponentClassifier) {
				tooltipContents.append(((ComponentClassifier) featureClassifier).getCategory() + " " + featureClassifier.getQualifiedName());
			} else if(featureClassifier instanceof FeatureGroupType) {
				tooltipContents.append("feature group " + featureClassifier.getQualifiedName());
			} else if(featureClassifier == null) {
				tooltipContents.append("No Classifier");
			} else {
				tooltipContents.append(featureClassifier.getQualifiedName());	
			}	    	

			// Create the styled text describing the feature
			final Label lbl = new Label(parent, SWT.NONE);
			lbl.setText(tooltipContents.toString());
		}
	}
}
