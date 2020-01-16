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
package org.osate.xtext.aadl2.errormodel.ui.labeling;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;
import org.osate.aadl2.NamedElement;
import org.osate.xtext.aadl2.errormodel.errorModel.CompositeState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSink;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorStateToModeMapping;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPath;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPoint;
import org.osate.xtext.aadl2.errormodel.errorModel.RecoverEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.RepairEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeMapping;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeMappingSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeTransformation;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeTransformationSet;
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

	public String text(ErrorModelSubclause errorModelSubclause) {
		return appendName("Error Model Subclause", errorModelSubclause);
	}

	public String text(ErrorModelLibrary errorModelLibrary) {
		return appendName("Error Model Library", errorModelLibrary);
	}

	public String text(ErrorType errorType) {
		return appendName("Type", errorType);
	}

	public String text(TypeSet typeSet) {
		return appendName("Type Set", typeSet);
	}

	public String text(TypeTransformationSet typeTransformationSet) {
		return appendName("Type Transformations", typeTransformationSet);
	}

	public String text(TypeTransformation typeTransformation) {
		return "Transformation";
	}

	public String text(TypeMappingSet typeMappingSet) {
		return appendName("Type Mappings", typeMappingSet);
	}

	public String text(TypeMapping typeMapping) {
		return "Mapping";
	}

	public String text(ErrorPropagation errorPropagation) {
		StringBuilder builder = new StringBuilder("Propagation");
		String name = EMV2Util.getPrintName(errorPropagation);
		if (name != null && !name.isEmpty()) {
			builder.append(' ');
			builder.append(name);
		}
		return builder.toString();
	}

	public String text(ErrorSource errorSource) {
		return appendName("Error Source", errorSource);
	}

	public String text(ErrorSink errorSink) {
		return appendName("Error Sink", errorSink);
	}

	public String text(ErrorPath errorPath) {
		return appendName("Error Path", errorPath);
	}

	public String text(PropagationPoint propagationPoint) {
		return appendName("Propagation Point", propagationPoint);
	}

	public String text(PropagationPath propagationPath) {
		return appendName("Propagation Path", propagationPath);
	}

	public String text(ErrorBehaviorStateMachine errorBehaviorStateMachine) {
		return appendName("Error Behavior", errorBehaviorStateMachine);
	}

	public String text(ErrorEvent errorEvent) {
		return appendName("Error Event", errorEvent);
	}

	public String text(RepairEvent repairEvent) {
		return appendName("Repair Event", repairEvent);
	}

	public String text(RecoverEvent recoverEvent) {
		return appendName("Recover Event", recoverEvent);
	}

	public String text(ErrorBehaviorState errorBehaviorState) {
		return appendName("State", errorBehaviorState);
	}

	public String text(ErrorBehaviorTransition errorBehaviorTransition) {
		return appendName("Transition", errorBehaviorTransition);
	}

	public String text(OutgoingPropagationCondition outgoingPropagationCondition) {
		return appendName("Propagation Condition", outgoingPropagationCondition);
	}

	public String text(ErrorDetection errorDetection) {
		return appendName("Detection", errorDetection);
	}

	public String text(ErrorStateToModeMapping errorStateToModeMapping) {
		StringBuilder builder = new StringBuilder("Mode Mapping");
		String name;
		if (errorStateToModeMapping.getErrorState() != null) {
			name = errorStateToModeMapping.getErrorState().getName();
		} else {
			name = null;
		}
		if (name != null && !name.isEmpty()) {
			builder.append(' ');
			builder.append(name);
		}
		return builder.toString();
	}

	public String text(CompositeState compositeState) {
		return appendName("State", compositeState);
	}

	private static String appendName(String label, NamedElement namedElement) {
		StringBuilder builder = new StringBuilder(label);
		String name = namedElement.getName();
		if (name != null && !name.isEmpty()) {
			builder.append(' ');
			builder.append(name);
		}
		return builder.toString();
	}
}