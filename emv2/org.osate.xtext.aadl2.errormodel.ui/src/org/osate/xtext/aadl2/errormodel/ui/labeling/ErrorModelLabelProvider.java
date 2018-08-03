/*
 * <copyright>
 * Copyright  2012 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE ''DELIVERABLES'') ARE ON AN ''AS-IS'' BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE
 */
package org.osate.xtext.aadl2.errormodel.ui.labeling;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;
import org.osate.aadl2.Feature;
import org.osate.aadl2.NamedElement;
import org.osate.xtext.aadl2.errormodel.errorModel.AndExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.CompositeState;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2PropertyAssociation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.OrExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.OrlessExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.OrmoreExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPoint;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;

import com.google.inject.Inject;

/**
 * Provides labels for a EObjects.
 *
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class ErrorModelLabelProvider extends DefaultEObjectLabelProvider {

	@Inject
	public ErrorModelLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	// Labels and icons can be computed like this:

	String text(AndExpression ele) {
		return "and";
	}

	String text(OrExpression ele) {
		return "or";
	}

	String text(OrmoreExpression ele) {
		return "ormore " + ele.getCount();
	}

	String text(OrlessExpression ele) {
		return "orless " + ele.getCount();
	}

	String text(OutgoingPropagationCondition ele) {
		NamedElement res = ele.getOutgoing().getFeatureorPPRef().getFeatureorPP();
		String fname;
		if (res instanceof Feature) {
			fname = ((Feature) res).getName();
		} else {
			fname = ((PropagationPoint) res).getName();
		}
		String s = ele.getName() == null ? fname : ele.getName();
		return "out propagation " + s + " when";
	}

	String text(ErrorDetection ele) {
		String s = ele.getDetectionReportingPort().getName();
		return "event " + s + " when";
	}

	String text(CompositeState ele) {
		String s = ele.getState().getName();
		return "state " + s + " when";
	}

	String text(ErrorBehaviorTransition ele) {
		String s = ele.isSteadyState() ? "steady state" : (ele.getName() == null ? "<unnamed>" : ele.getName());
		return "transition " + s + " when";
	}

	String text(EMV2PropertyAssociation ele) {
		String s = ele.getProperty().getName();
		return "property " + s;
	}

	String text(ErrorModelLibrary ele) {
		return "Error Model Library";
	}

	String text(ErrorModelSubclause ele) {
		return "Error Model Subclause";
	}

	String text(TypeSet ele) {
		return "Type Set " + (ele.getName() != null ? ele.getName() : "");
	}

	String text(ErrorType ele) {
		return "Type " + (ele.getName() != null ? ele.getName() : "");
	}

	String text(TypeToken ele) {
		return EMV2Util.getPrintName(ele);
	}

	String text(ErrorPropagation ele) {
		return (ele.isNot() ? "not " : "") + "propagation " + EMV2Util.getPrintName(ele);
	}
//
//    String image(MyModel ele) {
//      return "MyModel.gif";
//    }

}
