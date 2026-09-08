/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.xtext.aadl2.errormodel.ui.contentassist;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSink;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;

import com.google.common.base.Predicate;

/**
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on how to customize content assistant
 */
public class ErrorModelProposalProvider extends AbstractErrorModelProposalProvider {
	@Override
	public void completeErrorModelLibrary_Extends(final EObject model, final Assignment assignment,
			final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
		Predicate<IEObjectDescription> isNotCurrentLibrary = description -> !Objects.equals(model,
				EcoreUtil.resolve(description.getEObjectOrProxy(), model));
		lookupCrossReference((CrossReference) assignment.getTerminal(), context, acceptor, isNotCurrentLibrary);
	}

	@Override
	public void completeTypeDefinition_SuperType(final EObject model, final Assignment assignment,
			final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
		var currentName = ((ErrorType) model).getName();
		Predicate<IEObjectDescription> hasDifferentName = description -> !description.getName().toString()
				.equalsIgnoreCase(currentName);
		lookupCrossReference((CrossReference) assignment.getTerminal(), context, acceptor, hasDifferentName);
	}

	public List<ErrorModelLibrary> getExtendedLibraries(final ErrorModelLibrary library,
			final List<ErrorModelLibrary> results) {
		for (var extendedLibrary : library.getExtends()) {
			results.add(extendedLibrary);
			getExtendedLibraries(extendedLibrary, results);
		}
		return results;
	}

	@Override
	public void completeTypeSetElement_Type(final EObject model, final Assignment assignment,
			final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
		var container = model.eContainer();
		if (container instanceof ErrorPath path && path.getIncoming() != null) {
			filterTypeSetTokenTypes(path.getIncoming().getTypeSet(), model, assignment, context, acceptor);
			return;
		}
		if (container instanceof TypeSet) {
			var path = EcoreUtil2.getContainerOfType(container, ErrorPath.class);
			if (path != null && path.getIncoming() != null) {
				filterTypeSetTokenTypes(path.getIncoming().getTypeSet(), model, assignment, context, acceptor);
				return;
			}
			var source = EcoreUtil2.getContainerOfType(container, ErrorSource.class);
			if (source != null && source.getSourceModelElement() instanceof ErrorPropagation propagation) {
				filterTypeSetTokenTypes(propagation.getTypeSet(), model, assignment, context, acceptor);
				return;
			}
			var sink = EcoreUtil2.getContainerOfType(container, ErrorSink.class);
			if (sink != null && sink.getIncoming() != null) {
				filterTypeSetTokenTypes(sink.getIncoming().getTypeSet(), model, assignment, context, acceptor);
				return;
			}
		}
		if (container instanceof ErrorSource source) {
			if (source.getSourceModelElement() instanceof ErrorPropagation propagation
					&& Objects.equals(source.getTypeTokenConstraint(), model)) {
				filterTypeSetTokenTypes(propagation.getTypeSet(), model, assignment, context, acceptor);
				return;
			}
			if (source.getFailureModeReference() != null && Objects.equals(source.getFailureModeType(), model)) {
				filterTypeSetTokenTypes(source.getFailureModeReference().getTypeSet(), model, assignment, context,
						acceptor);
				return;
			}
		}
		if (container instanceof ErrorSink sink && sink.getIncoming() != null) {
			filterTypeSetTokenTypes(sink.getIncoming().getTypeSet(), model, assignment, context, acceptor);
			return;
		}
		if (container instanceof ErrorBehaviorTransition transition) {
			if (model instanceof TypeSet) {
				filterTypeSetTokenTypes(transition.getSource().getTypeSet(), model, assignment, context, acceptor);
				return;
			}
			if (model instanceof ConditionElement condition
					&& condition.getQualifiedErrorPropagationReference() != null) {
				var incoming = EMV2Util.getErrorEventOrPropagation(condition);
				switch (incoming) {
				case ErrorPropagation propagation ->
					filterTypeSetTokenTypes(propagation.getTypeSet(), model, assignment, context, acceptor);
				case ErrorEvent event ->
					filterTypeSetTokenTypes(event.getTypeSet(), model, assignment, context, acceptor);
				default -> {
					// No constrained type set is available.
				}
				}
				return;
			}
		}
		super.completeTypeSetElement_Type(model, assignment, context, acceptor);
	}

	/**
	 * @since 6.0.0
	 */
	public void filterTypeSetTokenTypes(final TypeSet typeSet, final EObject model, final Assignment assignment,
			final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
		var validErrorTypes = new ArrayList<ErrorTypes>();
		for (var token : typeSet.getTypeTokens()) {
			getValidTypes(token.getType(), validErrorTypes);
		}
		Predicate<IEObjectDescription> isValidType = description -> {
			var proposedObject = EcoreUtil.resolve(description.getEObjectOrProxy(), model);
			var validSuperTypes = new ArrayList<ErrorTypes>();
			if (proposedObject instanceof ErrorTypes proposedType) {
				getProposedObjectSuperTypes(proposedType, validSuperTypes, proposedObject);
			}
			return validErrorTypes.contains(proposedObject)
					|| validErrorTypes.stream().anyMatch(validSuperTypes::contains);
		};
		lookupCrossReference((CrossReference) assignment.getTerminal(), context, acceptor, isValidType);
	}

	public List<ErrorTypes> getValidTypes(final List<ErrorTypes> input, final List<ErrorTypes> validErrorTypes) {
		if (input == null) {
			return validErrorTypes;
		}
		for (var errorTypes : input) {
			if (errorTypes == null) {
				continue;
			}
			if (!validErrorTypes.contains(errorTypes)) {
				validErrorTypes.add(errorTypes);
			}
			if (errorTypes instanceof TypeSet typeSet) {
				for (var token : typeSet.getTypeTokens()) {
					if (token != null) {
						getValidTypes(token.getType(), validErrorTypes);
					}
				}
			}
		}
		return validErrorTypes;
	}

	public List<ErrorTypes> getProposedObjectSuperTypes(final ErrorTypes errorTypes, final List<ErrorTypes> results,
			final EObject proposedObject) {
		if (!results.contains(errorTypes) && !Objects.equals(errorTypes, proposedObject)) {
			results.add(errorTypes);
		}
		if (errorTypes instanceof ErrorType errorType && errorType.getSuperType() != null) {
			getProposedObjectSuperTypes(errorType.getSuperType(), results, proposedObject);
		}
		return results;
	}
}
