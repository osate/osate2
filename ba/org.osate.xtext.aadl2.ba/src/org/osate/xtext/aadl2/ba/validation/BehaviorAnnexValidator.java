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
package org.osate.xtext.aadl2.ba.validation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.DataSubcomponent;
import org.osate.aadl2.Element;
import org.osate.aadl2.InternalFeature;
import org.osate.aadl2.modelsupport.errorreporting.AbstractAnalysisErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.parsesupport.ParseUtil;
import org.osate.annexsupport.ParseResultHolder;
import org.osate.ba.analyzers.AadlBaRulesCheckersDriver;
import org.osate.ba.analyzers.AadlBaTypeChecker;
import org.osate.ba.analyzers.AdaLikeDataTypeChecker;
import org.osate.xtext.aadl2.ba.behaviorAnnex.AssignmentAction;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorIntegerLiteral;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTransition;
import org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction;
import org.osate.xtext.aadl2.ba.behaviorAnnex.InternalCondition;
import org.osate.xtext.aadl2.ba.behaviorAnnex.Reference;
import org.osate.xtext.aadl2.ba.translation.DeclarativeToStrictTranslator;
import org.osate.xtext.aadl2.ba.translation.DeclarativeToStrictTranslator.TranslationResult;

import com.google.inject.Inject;

/**
 * Runs the existing strict-model Behavior Annex checkers over the translated Xtext model and retargets their
 * diagnostics to the declarative source objects. Naming, syntax, and linking failures gate this adapter so semantic
 * checking does not cascade over an incomplete model. Literal spellings that the grammar accepts but translation
 * cannot represent are reported directly, since no strict object carries them.
 */
public final class BehaviorAnnexValidator extends AbstractBehaviorAnnexValidator {
	public static final String DECLARATION_NAME = "org.osate.xtext.aadl2.ba.declarationName";
	public static final String CHECKER_DIAGNOSTIC = "org.osate.xtext.aadl2.ba.checker";
	public static final String UNREPRESENTABLE_LITERAL = "org.osate.xtext.aadl2.ba.unrepresentableLiteral";
	public static final String INTERNAL_PORT_USE = "org.osate.xtext.aadl2.ba.internalPortUse";
	public static final String INTERNAL_CONDITION_PORT = "org.osate.xtext.aadl2.ba.internalConditionPort";
	private static final URI VALIDATION_RESOURCE_URI = URI.createURI("validation:/behavior-annex.aadlba");

	@Inject
	private DeclarativeToStrictTranslator translator;

	@Override
	protected List<EPackage> getEPackages() {
		return List.of(BehaviorAnnexPackage.eINSTANCE);
	}

	@Override
	public boolean isLanguageSpecific() {
		// Embedded annex objects live in an AADL Xtext resource, but this validator owns only the BA EPackage.
		return false;
	}

	@Check(CheckType.NORMAL)
	public void checkBehaviorAnnex(final BehaviorAnnex source) {
		if (!(source.getContainingClassifier() instanceof ComponentClassifier owner)
				|| !checkDeclarationNames(source, owner) || hasSyntaxOrLinkingErrors(source)) {
			return;
		}

		var translation = translator.translate(source, owner);
		// Both checks describe a name the strict model cannot carry, and a model can get each one wrong independently,
		// so report them both before deciding whether the strict checkers have a model to work on.
		var representable = checkInternalPortUses(source, translation);
		representable &= checkInternalConditionPorts(source, translation);
		if (!representable) {
			return;
		}
		var strictAnnex = translation.getStrictAnnex();
		synchronized (strictAnnex) {
			var validationResource = new ResourceImpl(VALIDATION_RESOURCE_URI);
			validationResource.getContents().add(strictAnnex);
			try {
				// One declarative transition becomes one strict transition per source state, so a rule that constrains
				// the transition reports once per source state. Those reports collapse onto the same declarative
				// object with the same message, and repeating them tells the user nothing.
				var reported = new HashSet<Report>();
				var errorManager = new AnalysisErrorReporterManager(
						resource -> new ValidatorErrorReporter(resource, this, translation, reported));
				var dataTypeChecker = new AdaLikeDataTypeChecker(errorManager);
				var typeChecker = new AadlBaTypeChecker(strictAnnex, owner, dataTypeChecker, errorManager);
				if (typeChecker.checkTypes()) {
					new AadlBaRulesCheckersDriver(strictAnnex, owner, errorManager).process(strictAnnex);
				}
			} finally {
				validationResource.getContents().clear();
			}
		}
	}

	/**
	 * AS5506/3 Rev A names an internal port in the D.3 internal_condition production and in the D.6 target and
	 * communication_action productions only. The grammar accepts a generic reference everywhere else, so an internal
	 * port can be written where the standard admits an incoming port and where the strict model has nothing to carry
	 * it. Report each such reference and leave the strict-model checkers out of it, the way a linking failure already
	 * gates them.
	 *
	 * @return {@code true} when the annex uses every internal port it names as the standard admits
	 */
	private boolean checkInternalPortUses(final BehaviorAnnex source, final TranslationResult translation) {
		var accepted = true;
		for (var contents = source.eAllContents(); contents.hasNext();) {
			if (contents.next() instanceof Reference reference
					&& translation.getResolvedReference(reference) instanceof InternalFeature internalPort
					&& !isStandardInternalPortUse(reference)) {
				error("'" + internalPort.getName() + "' is an internal port: it can only be an assignment or dequeue"
						+ " target, the port of a send action, or a port of an internal condition", reference, null,
						ValidationMessageAcceptor.INSIGNIFICANT_INDEX, INTERNAL_PORT_USE);
				accepted = false;
			}
		}
		return accepted;
	}

	private static boolean isStandardInternalPortUse(final Reference reference) {
		if (reference.eContainer() instanceof AssignmentAction assignment) {
			return assignment.getTarget() == reference;
		}
		if (reference.eContainer() instanceof CommunicationAction action) {
			return action.getTarget() == reference || action.isSend() && action.getReference() == reference;
		}
		return reference.eContainer() instanceof InternalCondition condition
				&& condition.getInternalPorts().contains(reference);
	}

	/**
	 * The AS5506/3 Rev A D.3 internal_condition production lists internal_port_names, so every name in an internal
	 * condition must denote an internal event or internal event data feature of the owner. Any other name the annex can
	 * see, and any name it cannot resolve at all, has no internal port holder to become: translation drops it, and the
	 * condition would otherwise reach the strict checkers silently short of the ports the user wrote. Report the name
	 * as written, since an unresolved one has no element to name.
	 *
	 * @return {@code true} when every internal condition in the annex lists internal ports only
	 */
	private boolean checkInternalConditionPorts(final BehaviorAnnex source, final TranslationResult translation) {
		var accepted = true;
		for (var contents = source.eAllContents(); contents.hasNext();) {
			if (!(contents.next() instanceof InternalCondition condition)) {
				continue;
			}
			for (var port : condition.getInternalPorts()) {
				if (!(translation.getResolvedReference(port) instanceof InternalFeature)) {
					error("'" + NodeModelUtils.getTokenText(NodeModelUtils.findActualNodeFor(port)) + "' is not an"
							+ " internal port: an internal condition can only list internal event or internal event data"
							+ " features", port, null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
							INTERNAL_CONDITION_PORT);
					accepted = false;
				}
			}
		}
		return accepted;
	}

	/**
	 * D.3 names share one namespace, including inherited features, data subcomponents, and modes of the owner.
	 * Check the declarations before resolving references so missing classifiers cannot hide duplicate names, and
	 * skip the strict checkers when names are ambiguous instead of validating an arbitrary resolution.
	 */
	private boolean checkDeclarationNames(final BehaviorAnnex source, final ComponentClassifier owner) {
		var declarations = new ArrayList<Declaration>();
		for (var group : source.getVariableGroups()) {
			for (var variable : group.getVariables()) {
				declarations.add(new Declaration(variable.getName(), variable,
						BehaviorAnnexPackage.eINSTANCE.getBehaviorVariable_Name(), false));
			}
		}
		for (var group : source.getStateGroups()) {
			for (var state : group.getStates()) {
				declarations.add(new Declaration(state.getName(), state,
						BehaviorAnnexPackage.eINSTANCE.getBehaviorState_Name(), group.isComplete()));
			}
		}
		for (var transition : source.getTransitions()) {
			declarations.add(new Declaration(transition.getName(), transition,
					BehaviorAnnexPackage.eINSTANCE.getBehaviorTransition_Name(), false));
		}

		Map<String, List<Declaration>> byName = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		for (var declaration : declarations) {
			// Transitions need not have a label; partially edited declarations may also lack a name.
			if (declaration.name() != null && !declaration.name().isEmpty()) {
				byName.computeIfAbsent(declaration.name(), key -> new ArrayList<>()).add(declaration);
			}
		}
		Map<String, String> enclosingNames = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		for (var feature : owner.getAllFeatures()) {
			if (feature.getName() != null) {
				enclosingNames.put(feature.getName(), "feature");
			}
		}
		if (owner instanceof ComponentImplementation implementation) {
			for (var subcomponent : implementation.getAllSubcomponents()) {
				if (subcomponent instanceof DataSubcomponent && subcomponent.getName() != null) {
					enclosingNames.put(subcomponent.getName(), "data subcomponent");
				}
			}
		}
		var modeNames = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		for (var mode : owner.getAllModes()) {
			if (mode.getName() != null) {
				modeNames.add(mode.getName());
			}
		}

		var valid = true;
		for (var sameName : byName.values()) {
			for (var declaration : sameName) {
				if (sameName.size() > 1) {
					error("Duplicate Behavior Annex identifier '" + declaration.name() + "'",
							declaration.source(), declaration.feature(), DECLARATION_NAME);
					valid = false;
				}
				// A complete state may represent a same-named mode, but cannot reuse a feature or data name.
				var enclosingKind = enclosingNames.get(declaration.name());
				if (enclosingKind == null && modeNames.contains(declaration.name()) && !declaration.complete()) {
					enclosingKind = "mode";
				}
				if (enclosingKind != null) {
					error("Behavior Annex identifier '" + declaration.name() + "' conflicts with an enclosing "
							+ enclosingKind + " identifier", declaration.source(), declaration.feature(), DECLARATION_NAME);
					valid = false;
				}
			}
		}
		return valid;
	}

	private record Declaration(String name, EObject source, EStructuralFeature feature, boolean complete) {
	}

	/**
	 * The integer literal terminal admits based, exponent, and long decimal spellings whose value the AADL integer
	 * reader cannot represent. Translation cannot carry such a literal into the strict model, so name the offending
	 * spelling on the literal itself rather than letting it become zero.
	 */
	@Check(CheckType.FAST)
	public void checkIntegerLiteral(final BehaviorIntegerLiteral literal) {
		checkIntegerLiteral(literal.getValue(), literal,
				BehaviorAnnexPackage.eINSTANCE.getBehaviorIntegerLiteral_Value());
	}

	@Check(CheckType.FAST)
	public void checkTransitionPriority(final BehaviorTransition transition) {
		checkIntegerLiteral(transition.getPriority(), transition,
				BehaviorAnnexPackage.eINSTANCE.getBehaviorTransition_Priority());
	}

	private void checkIntegerLiteral(final String value, final EObject owner, final EStructuralFeature feature) {
		if (value == null) {
			return;
		}
		try {
			ParseUtil.parseAadlInteger(value);
		} catch (final IllegalArgumentException exception) {
			error("Cannot represent integer literal " + value + ": " + exception.getMessage(), owner, feature,
					UNREPRESENTABLE_LITERAL);
		}
	}

	private static boolean hasSyntaxOrLinkingErrors(final BehaviorAnnex source) {
		var parseResult = ParseResultHolder.Factory.INSTANCE.adapt(source).getParseResult();
		if ((parseResult != null && parseResult.hasSyntaxErrors()) || hasUnresolvedCrossReference(source)) {
			return true;
		}
		for (var contents = source.eAllContents(); contents.hasNext();) {
			if (hasUnresolvedCrossReference(contents.next())) {
				return true;
			}
		}
		return false;
	}

	private static boolean hasUnresolvedCrossReference(final EObject object) {
		for (var reference : object.eClass().getEAllReferences()) {
			if (reference.isContainment() || reference.isContainer()) {
				continue;
			}
			var value = object.eGet(reference, false);
			if (value instanceof EObject target && target.eIsProxy()) {
				return true;
			}
			if (value instanceof List<?> targets) {
				for (var target : targets) {
					if (target instanceof EObject eObject && eObject.eIsProxy()) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private void reportError(final Element strict, final String message, final TranslationResult translation,
			final Set<Report> reported) {
		var source = sourceFor(strict, translation);
		if (reported.add(new Report(source, Severity.ERROR, message))) {
			error(message, source, null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, CHECKER_DIAGNOSTIC);
		}
	}

	private void reportWarning(final Element strict, final String message, final TranslationResult translation,
			final Set<Report> reported) {
		var source = sourceFor(strict, translation);
		if (reported.add(new Report(source, Severity.WARNING, message))) {
			warning(message, source, null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, CHECKER_DIAGNOSTIC);
		}
	}

	private void reportInfo(final Element strict, final String message, final TranslationResult translation,
			final Set<Report> reported) {
		var source = sourceFor(strict, translation);
		if (reported.add(new Report(source, Severity.INFO, message))) {
			info(message, source, null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, CHECKER_DIAGNOSTIC);
		}
	}

	private static EObject sourceFor(final EObject strict, final TranslationResult translation) {
		for (var current = strict; current != null; current = current.eContainer()) {
			var source = translation.getDeclarative(current);
			if (source != null) {
				return source;
			}
		}
		return translation.getDeclarative(translation.getStrictAnnex());
	}

	/** A diagnostic already handed to Xtext, so that the same message is not repeated on the same source object. */
	private record Report(EObject source, Severity severity, String message) {
	}

	private static final class ValidatorErrorReporter extends AbstractAnalysisErrorReporter {
		private final BehaviorAnnexValidator validator;
		private final TranslationResult translation;
		private final Set<Report> reported;

		private ValidatorErrorReporter(final Resource resource, final BehaviorAnnexValidator validator,
				final TranslationResult translation, final Set<Report> reported) {
			super(resource);
			this.validator = validator;
			this.translation = translation;
			this.reported = reported;
		}

		@Override
		protected void errorImpl(final Element where, final String message, final String[] attributes,
				final Object[] values) {
			validator.reportError(where, message, translation, reported);
		}

		@Override
		protected void warningImpl(final Element where, final String message, final String[] attributes,
				final Object[] values) {
			validator.reportWarning(where, message, translation, reported);
		}

		@Override
		protected void infoImpl(final Element where, final String message, final String[] attributes,
				final Object[] values) {
			validator.reportInfo(where, message, translation, reported);
		}

		@Override
		protected void deleteMessagesImpl() {
			// Xtext owns the diagnostic lifecycle.
		}
	}
}
