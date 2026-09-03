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

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Element;
import org.osate.aadl2.modelsupport.errorreporting.AbstractAnalysisErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.ba.analyzers.AadlBaRulesCheckersDriver;
import org.osate.ba.analyzers.AadlBaTypeChecker;
import org.osate.ba.analyzers.AdaLikeDataTypeChecker;
import org.osate.annexsupport.ParseResultHolder;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage;
import org.osate.xtext.aadl2.ba.translation.DeclarativeToStrictTranslator;
import org.osate.xtext.aadl2.ba.translation.DeclarativeToStrictTranslator.TranslationResult;

import com.google.inject.Inject;

/**
 * Runs the existing strict-model Behavior Annex checkers over the translated Xtext model and retargets their
 * diagnostics to the declarative source objects. Syntax and linking failures gate this adapter so semantic checking
 * does not cascade over an incomplete model.
 */
public final class BehaviorAnnexValidator extends AbstractBehaviorAnnexValidator {
	public static final String CHECKER_DIAGNOSTIC = "org.osate.xtext.aadl2.ba.checker";
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
				|| hasSyntaxOrLinkingErrors(source)) {
			return;
		}

		var translation = translator.translate(source, owner);
		var strictAnnex = translation.getStrictAnnex();
		synchronized (strictAnnex) {
			var validationResource = new ResourceImpl(VALIDATION_RESOURCE_URI);
			validationResource.getContents().add(strictAnnex);
			try {
				var errorManager = new AnalysisErrorReporterManager(
						resource -> new ValidatorErrorReporter(resource, this, translation));
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

	private void reportError(final Element strict, final String message, final TranslationResult translation) {
		error(message, sourceFor(strict, translation), null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
				CHECKER_DIAGNOSTIC);
	}

	private void reportWarning(final Element strict, final String message, final TranslationResult translation) {
		warning(message, sourceFor(strict, translation), null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
				CHECKER_DIAGNOSTIC);
	}

	private void reportInfo(final Element strict, final String message, final TranslationResult translation) {
		info(message, sourceFor(strict, translation), null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
				CHECKER_DIAGNOSTIC);
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

	private static final class ValidatorErrorReporter extends AbstractAnalysisErrorReporter {
		private final BehaviorAnnexValidator validator;
		private final TranslationResult translation;

		private ValidatorErrorReporter(final Resource resource, final BehaviorAnnexValidator validator,
				final TranslationResult translation) {
			super(resource);
			this.validator = validator;
			this.translation = translation;
		}

		@Override
		protected void errorImpl(final Element where, final String message, final String[] attributes,
				final Object[] values) {
			validator.reportError(where, message, translation);
		}

		@Override
		protected void warningImpl(final Element where, final String message, final String[] attributes,
				final Object[] values) {
			validator.reportWarning(where, message, translation);
		}

		@Override
		protected void infoImpl(final Element where, final String message, final String[] attributes,
				final Object[] values) {
			validator.reportInfo(where, message, translation);
		}

		@Override
		protected void deleteMessagesImpl() {
			// Xtext owns the diagnostic lifecycle.
		}
	}
}
