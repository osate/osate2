package org.osate.analysis.security;

import java.util.Arrays;
import java.util.Optional;

import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitch;

public class RuleViolationChecker extends AadlProcessingSwitch {

	public static final String[] SYMMETRIC_ALGORITHMS = { "AES", "DES", "TripleDES" };
	public static final String[] ASYMMETRIC_ALGORITHMS = { "RSA", "ECC" };

	public RuleViolationChecker(final AnalysisErrorReporterManager errMgr) {
		super(PROCESS_POST_ORDER_ALL, errMgr);
	}

	@Override
	protected void initSwitches() {

		instanceSwitch = new InstanceSwitch<String>() {

			/**
			 * Check if component containment complies with the security policy.
			 * Compare component's security label with the label of its container.
			 */
			@Override
			public String caseInstanceObject(InstanceObject io) {

				Optional<Encryption> encryption = Encryption.of(io);
				if (!encryption.isPresent()) {
					return DONE;
				}

				Encryption enc = encryption.get();
				String form = enc.getEncryptionForm().getName().toLowerCase();
				int modeCount = enc.getEncryptionModes().size();
				int algCount = enc.getEncryptionAlgorithms().size();
				int keyCount = enc.getKeyLengths().size();

				// There must be at most one mode
				if (modeCount > 1) {
					error(io, "Invalid encryption specification: At most one encryption mode is allowed");
				}

				if (form.equals("no_encryption")) {
					if (modeCount == 1) {
						EnumerationLiteral mode = enc.getEncryptionModes().get(0);
						if (!isNoEncryption(mode)) {
							error(io, "Inconsistent encryption specification: No mode allowed with no_encryption");
						}
					}
					if (algCount > 1) {
						error(io, "Inconsistent encryption specification: More than one encryption algorithm");
					} else if (algCount == 1) {
						EnumerationLiteral alg = enc.getEncryptionAlgorithms().get(0);
						if (!isNoEncryption(alg)) {
							error(io,
									"Inconsistent encryption specification: No algorithm allowed with no_encryption");
						}
					}
					if (keyCount > 0) {
						error(io, "Inconsistent encryption specification: No key allowed with no_encryption");
					}
					if (enc.getPadding() != null && !is(enc.getPadding(), "no_padding")) {
						error(io, "Inconsistent encryption specification: No padding allowed with no_encryption");
					}
				} else if (form.equals("symmetric")) {
					if (modeCount != 1) {
						error(io, "Inconsistent encryption specification: Symmetric encryption must have a mode");
					}
					if (algCount == 0) {
						error(io, "Inconsistent encryption specification: Missing encryption algorithm");
					} else if (algCount != 1) {
						error(io,
								"Inconsistent encryption specification: Symmetric encryption must specify exactly one algorithm");
					}
					enc.getEncryptionAlgorithms().forEach((a) -> {
						if (!isSymmetric(a)) {
							error(io, "Inconsistent encryption specification: " + a.getName()
									+ " is not a symmetric encryption algorithm");
						}
					});
					if (enc.getPadding() != null && !is(enc.getPadding(), "no_padding")) {
						error(io,
								"Inconsistent encryption specification: No padding allowed with symmetric encryption");
					}
				} else if (form.equals("asymmetric")) {
					if (modeCount != 0) {
						warning(io,
								"Inconsistent encryption specification: Asymmetric encryption must not have a mode");
					}
					if (algCount == 0) {
						error(io, "Inconsistent encryption specification: Missing encryption algorithm");
					} else if (algCount != 1) {
						error(io,
								"Inconsistent encryption specification: Asymmetric encryption must specify exactly one algorithm");
					}
					enc.getEncryptionAlgorithms().forEach((a) -> {
						if (!isSymmetric(a)) {
							error(io, "Inconsistent encryption specification: " + a.getName()
									+ " is not a symmetric encryption algorithm");
						}
					});
					if (enc.getPadding() == null || is(enc.getPadding(), "no_padding")) {
						error(io,
								"Inconsistent encryption specification: Padding must be specified for asymmetric encryption");
					}
				} else if (form.equals("hybrid")) {
					if (modeCount != 1) {
						error(io, "Inconsistent encryption specification: Hybrid encryption must have a mode");
					}
					if (enc.getPadding() == null || is(enc.getPadding(), "no_padding")) {
						error(io,
								"Inconsistent encryption specification: Padding must be specified for asymmetric encryption");
					}
				} else if (form.equals("authenticated_encryption")) {
					warning(io, "Not implemented: validation for authenticated encyption");
				} else if (form.equals("authenticated_only")) {
					warning(io, "Not implemented: validation for authentication only");
				}

				return DONE;
			}

		};
	}

	protected boolean isNoEncryption(EnumerationLiteral alg) {
		return is(alg, "no_encryption");
	}

	protected boolean isSymmetric(EnumerationLiteral alg) {
		if (is(alg, "to_be_specified")) {
			return true;
		}
		return Arrays.stream(SYMMETRIC_ALGORITHMS).anyMatch((n) -> alg.getName().equalsIgnoreCase(n));
	}

	protected boolean isAsymmetric(EnumerationLiteral alg) {
		if (is(alg, "to_be_specified")) {
			return true;
		}
		return Arrays.stream(ASYMMETRIC_ALGORITHMS).anyMatch((n) -> alg.getName().equalsIgnoreCase(n));
	}

	private boolean is(EnumerationLiteral lit, String name) {
		return lit != null && lit.getName().equalsIgnoreCase(name);
	}

}
