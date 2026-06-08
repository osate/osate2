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
package org.osate.annexsupport;

import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.parsesupport.ParseUtil;

/**
 * @since 3.1
 */
public class AnnexValidator extends EObjectValidator {

	private static class NoValidationAdaper implements Adapter {

		private NoValidationAdaper() {
		}

		@Override
		public void notifyChanged(Notification notification) {
		}

		@Override
		public Notifier getTarget() {
			return null;
		}

		@Override
		public void setTarget(Notifier newTarget) {
		}

		@Override
		public boolean isAdapterForType(Object type) {
			return false;
		}
	}

	private static final Adapter NO_VALIDATION_ADAPTER = new NoValidationAdaper();

	private final EValidator delegateValidator;

	public AnnexValidator(final EValidator delegateValidator) {
		this.delegateValidator = delegateValidator;
	}

	@Override
	public boolean validate(EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!isValidating(eObject)) {
			return true;
		}

		if (delegateValidator == null) {
			return super.validate(eObject, diagnostics, context);
		}

		return delegateValidator.validate(eObject, diagnostics, context);
	}

	@Override
	public boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!isValidating(eObject)) {
			return true;
		}

		if (delegateValidator == null) {
			return super.validate(eClass, eObject, diagnostics, context);
		}

		return delegateValidator.validate(eClass, eObject, diagnostics, context);
	}

	private static boolean isValidating(final EObject object) {
		if (object == null) {
			return true;
		}

		for (final Adapter adapter : object.eAdapters()) {
			if (adapter == NO_VALIDATION_ADAPTER) {
				return false;
			}
		}

		if (!isValidating(object.eContainer())) {
			return false;
		}

		return true;
	}

	public static <A extends NamedElement, D extends A> void setNoValidation(final D defaultAnnexSection,
			final String annexName) {
		if (isValidating(defaultAnnexSection)) {
			defaultAnnexSection.eAdapters().add(NO_VALIDATION_ADAPTER);
		}

		final String annexPackageUri = ParseUtil.getAnnexNS(annexName);

		if (annexPackageUri != null) {
			final EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(annexPackageUri);

			registerAnnexValidator(ePackage);
		}
	}

	private static void registerAnnexValidator(final EPackage ePackage) {
		if (ePackage != null) {
			final EValidator registeredValidator = EValidator.Registry.INSTANCE.getEValidator(ePackage);

			if (!(registeredValidator instanceof AnnexValidator)) {

				Descriptor desc = new AnnexValidatorDescriptor(registeredValidator);
				// Add annex validator
				EValidator.Registry.INSTANCE.put(ePackage, desc);

			}
		}
	}
}
