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
import org.osate.xtext.aadl2.errormodel.errorModel.ComponentErrorBehavior;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;

/**
 * This class contains custom scoping description.
 *
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it
 *
 */
public class ErrorModelScopeProvider extends AbstractDeclarativeScopeProvider {

//	public IScope scope_ErrorBehaviorState(ErrorBehaviorStateMachine context,
//			EReference reference) {
//				return Scopes.scopeFor(context.getStates());
//	}

	public IScope scope_ErrorBehaviorState(ErrorBehaviorTransition context,
			EReference reference) {
		EList<ErrorModelSubclause> emslist = EMV2Util.getAllContainingClassifierEMV2Subclauses(context);
		if (emslist.isEmpty()){
			// we are in an EMV2 library 
			ErrorBehaviorStateMachine ebsm = EMV2Util.getContainingErrorBehaviorStateMachine(context);
			if (ebsm != null){
				return Scopes.scopeFor(ebsm.getStates());
			} else {
				return IScope.NULLSCOPE;
			}
		}
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			ErrorBehaviorStateMachine ebsm = errorModelSubclause.getUseBehavior();
			if (ebsm!= null){
				return Scopes.scopeFor(ebsm.getStates());
			}
		}
		return IScope.NULLSCOPE;
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
		IScope result = IScope.NULLSCOPE;
		EList<ErrorModelSubclause> emslist = EMV2Util.getAllContainingClassifierEMV2Subclauses(context);
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			ErrorBehaviorStateMachine ebsm = errorModelSubclause.getUseBehavior();
			if (ebsm!= null){
				result = Scopes.scopeFor(ebsm.getEvents());
				break;
			}
		}
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			ComponentErrorBehavior ceb = errorModelSubclause.getComponentBehavior();
			if (ceb!= null){
				EList<ErrorBehaviorEvent> eflist = ceb.getEvents();
				if (!eflist.isEmpty()){
					result = Scopes.scopeFor(eflist, result);
				}
			}
		}
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
