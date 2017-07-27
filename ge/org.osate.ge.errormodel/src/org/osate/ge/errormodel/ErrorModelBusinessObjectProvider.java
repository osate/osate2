package org.osate.ge.errormodel;

import java.util.stream.Stream;

import javax.inject.Named;

import org.osate.ge.BusinessObjectContext;
import org.osate.ge.di.Activate;
import org.osate.ge.di.Names;
import org.osate.ge.errormodel.model.ErrorTypeExtension;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;

public class ErrorModelBusinessObjectProvider {

	@Activate
	public Stream<?> getBusinessObjects(final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc) {
		final Object bo = boc.getBusinessObject();
		if(bo instanceof ErrorModelLibrary) {
			final ErrorModelLibrary lib = (ErrorModelLibrary)bo;
			return Stream.concat(lib.getTypes().stream(), lib.getBehaviors().stream());
		} else if(bo instanceof ErrorBehaviorStateMachine) {
			final ErrorBehaviorStateMachine stateMachine = (ErrorBehaviorStateMachine)bo;
			return Stream.concat(Stream.concat(stateMachine.getEvents().stream(), 
					stateMachine.getStates().stream()),
					stateMachine.getTransitions().stream());
		} else if(bo instanceof ErrorType) {
			final ErrorType errorType = (ErrorType)bo;
			if(errorType.getSuperType() != null) {
				return Stream.of(new ErrorTypeExtension(errorType.getSuperType(), errorType));
			}
		}
		
		return null;		
	}
}
