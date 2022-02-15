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
