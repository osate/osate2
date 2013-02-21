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
package org.osate.xtext.aadl2.errormodel.scoping;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagations;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;

/**
 * This class contains custom scoping description.
 *
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it
 *
 */
public class ErrorModelScopeProvider extends AbstractDeclarativeScopeProvider {

	public IScope scope_ErrorBehaviorState(ErrorBehaviorStateMachine context,
			EReference reference) {

		return Scopes.scopeFor(getAllStates(context));
	}

	public IScope scope_ErrorType(ErrorType context,
			EReference reference) {
		ErrorModelLibrary owner = org.eclipse.xtext.EcoreUtil2.getContainerOfType(context,
				ErrorModelLibrary.class);
		return Scopes.scopeFor(getAllTypes(owner));
	}
	public IScope scope_ErrorType(ErrorPropagation context,
			EReference reference) {
		ErrorModelSubclause owner = org.eclipse.xtext.EcoreUtil2.getContainerOfType(context,
				ErrorModelSubclause.class);
		BasicEList<ErrorTypes> result = new BasicEList<ErrorTypes>();
		EList<ErrorModelLibrary> members = owner.getUseTypes();
		for(ErrorModelLibrary member: members) {
			result.addAll(getAllTypes(member));
		}
		return Scopes.scopeFor(result);
	}

	//PropagationCondition

	public IScope scope_ErrorBehaviorEvent(ErrorBehaviorTransition context,
			EReference reference) {
		ErrorBehaviorStateMachine owner = org.eclipse.xtext.EcoreUtil2.getContainerOfType(context,
				ErrorBehaviorStateMachine.class);
			IScope result =  Scopes.scopeFor(getAllEvents(owner));
			return result;
			}


	public EList<ErrorBehaviorState> getAllStates(ErrorBehaviorStateMachine context){
		EList<ErrorBehaviorState> result = context.getStates();
//		if (context.getExtends() != null){
//			result.addAll(context.getExtends().getStates());
//		}
		return result;
	}

	public EList<ErrorBehaviorEvent> getAllEvents(ErrorBehaviorStateMachine context){
		EList<ErrorBehaviorEvent> result = context.getEvents();
//		if (context.getExtends() != null){
//			result.addAll(context.getExtends().getEvents());
//		}
		return result;
	}

	public EList<ErrorTypes> getAllTypes(ErrorModelLibrary context){
		EList<ErrorTypes> result = context.getTypes();
		EList<ErrorModelLibrary> extenderlist = context.getExtends();
		for (ErrorModelLibrary extender: extenderlist )
		{
			result.addAll(extender.getTypes());
		}
		return result;
	}


	}
