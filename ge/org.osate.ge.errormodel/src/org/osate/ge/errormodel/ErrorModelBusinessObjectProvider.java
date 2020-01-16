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
package org.osate.ge.errormodel;

import java.util.stream.Stream;

import javax.inject.Named;

import org.osate.aadl2.AadlPackage;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.di.Activate;
import org.osate.ge.di.Names;
import org.osate.ge.errormodel.model.BehaviorTransitionTrunk;
import org.osate.ge.errormodel.model.ErrorTypeExtension;
import org.osate.ge.errormodel.model.ErrorTypeLibrary;
import org.osate.ge.errormodel.util.ErrorModelGeUtil;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;

public class ErrorModelBusinessObjectProvider {

	@Activate
	public Stream<?> getBusinessObjects(final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc) {
		final Object bo = boc.getBusinessObject();
		if (bo instanceof AadlPackage) {
			final ErrorModelLibrary lib = ErrorModelGeUtil.getErrorModelLibrary((AadlPackage) bo);
			if (lib == null) {
				return null;
			}

			return Stream.concat(Stream.of(new ErrorTypeLibrary(lib)), lib.getBehaviors().stream());
		} else if (bo instanceof ErrorTypeLibrary) {
			final ErrorTypeLibrary etl = (ErrorTypeLibrary) bo;
			return etl.getErrorModelLibrary().getTypes().stream();
		} else if(bo instanceof ErrorBehaviorStateMachine) {
			final ErrorBehaviorStateMachine stateMachine = (ErrorBehaviorStateMachine)bo;
			return Stream.concat(Stream.concat(stateMachine.getEvents().stream(),
					stateMachine.getStates().stream()),
					stateMachine.getTransitions().stream());
		} else if (bo instanceof ErrorBehaviorTransition) {
			// See ErrorBehaviorTransitionHandler for details regarding how the business objects related to error behavior transitions are represented.
			final ErrorBehaviorTransition t = (ErrorBehaviorTransition) bo;
			return t.getDestinationBranches().isEmpty() ? Stream.empty()
					: Stream.concat(Stream.of(new BehaviorTransitionTrunk(t)), t.getDestinationBranches().stream());
		} else if(bo instanceof ErrorType) {
			final ErrorType errorType = (ErrorType)bo;
			if(errorType.getSuperType() != null) {
				return Stream.of(new ErrorTypeExtension(errorType.getSuperType(), errorType));
			}
		}

		return null;
	}
}
