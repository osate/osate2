/*
Copyright (c) 2015, Rockwell Collins.
Developed with the sponsorship of Defense Advanced Research Projects Agency (DARPA).

Permission is hereby granted, free of charge, to any person obtaining a copy of this data, 
including any software or models in source or binary form, as well as any drawings, specifications, 
and documentation (collectively "the Data"), to deal in the Data without restriction, including
without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, 
and/or sell copies of the Data, and to permit persons to whom the Data is furnished to do so, 
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or 
substantial portions of the Data.

THE DATA IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
IN NO EVENT SHALL THE AUTHORS, SPONSORS, DEVELOPERS, CONTRIBUTORS, OR COPYRIGHT HOLDERS BE LIABLE 
FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
ARISING FROM, OUT OF OR IN CONNECTION WITH THE DATA OR THE USE OR OTHER DEALINGS IN THE DATA.
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
