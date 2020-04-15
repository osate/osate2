package org.osate.analysis.security;

import static security_type_specifications.EncryptionSpecificationType.AlgorithmName_FieldType.AES;
import static security_type_specifications.EncryptionSpecificationType.AlgorithmName_FieldType.BLOWFISH;
import static security_type_specifications.EncryptionSpecificationType.AlgorithmName_FieldType.DES;
import static security_type_specifications.EncryptionSpecificationType.AlgorithmName_FieldType.ECC;
import static security_type_specifications.EncryptionSpecificationType.AlgorithmName_FieldType.OTP;
import static security_type_specifications.EncryptionSpecificationType.AlgorithmName_FieldType.RSA;
import static security_type_specifications.EncryptionSpecificationType.AlgorithmName_FieldType.TRIPLEDES;
import static security_type_specifications.EncryptionSpecificationType.AlgorithmName_FieldType.TWOFISH;
import static security_type_specifications.EncryptionSpecificationType.EncryptionMode_FieldType.ECB;
import static security_type_specifications.EncryptionSpecificationType.Padding_FieldType.BLOCK_CIPHER;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.osate.aadl2.Classifier;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitch;

import security_enforcement_properties.SecurityEnforcementProperties;
import security_type_specifications.EncryptionSpecificationType;
import security_type_specifications.EncryptionSpecificationType.AlgorithmName_FieldType;
import security_type_specifications.EncryptionSpecificationType.EncryptionMode_FieldType;
import security_type_specifications.EncryptionSpecificationType.Padding_FieldType;
import security_type_specifications.SecuritySpecificationType;

public class RuleViolationChecker extends AadlProcessingSwitch {

	private static final Set<AlgorithmName_FieldType> symmetric = new HashSet<EncryptionSpecificationType.AlgorithmName_FieldType>();
	private static final Set<AlgorithmName_FieldType> asymmetric = new HashSet<EncryptionSpecificationType.AlgorithmName_FieldType>();

	static {
		Collections.addAll(symmetric, DES, TRIPLEDES, AES, BLOWFISH, TWOFISH);
		Collections.addAll(asymmetric, RSA, ECC);
	}

	public RuleViolationChecker(final AnalysisErrorReporterManager errMgr) {
		super(PROCESS_POST_ORDER_ALL, errMgr);
	}

	@Override
	protected void initSwitches() {

		instanceSwitch = new InstanceSwitch<String>() {

			@Override
			public String caseInstanceObject(InstanceObject io) {
				checkEncryptionSpecification(io);
				return null;
			}

			private void checkEncryptionSpecification(InstanceObject io) {
				Optional<List<SecuritySpecificationType>> p = SecurityEnforcementProperties
						.getDataSecuritySpecification(io);

				p.ifPresent(specs -> {
					specs.stream().forEach(spec -> {
						spec.getEncryption().ifPresent(enc -> {
							validateEncryptionSpecification(io, enc);
						});
					});
				});
			}

			private void validateEncryptionSpecification(InstanceObject io, EncryptionSpecificationType enc) {
				Optional<AlgorithmName_FieldType> algo = enc.getAlgorithmName();
				Optional<EncryptionMode_FieldType> mode = enc.getEncryptionMode();
				Optional<Padding_FieldType> padding = enc.getPadding();
				Optional<Classifier> key = enc.getKeyClassifier();

				algo.ifPresent(a -> {
					if (a == OTP) {
						warning(io, "Don't use OTP");
						mode.ifPresent(m -> error(io, "OTP doesn't have modes"));
						padding.ifPresent(p -> error(io, "Don't use padding with OTP"));
						if (!key.isPresent()) {
							error(io, "Missing key for OTP");
						}
					} else if (isSymmetric(a)) {
						if (!mode.isPresent()) {
							error(io, "Encryption algorithm " + a.name() + " requires a mode");
						} else if (mode.get() == ECB) {
							warning(io, "ECB mode is not secure");
						}
						if (!padding.isPresent()) {
							error(io, "Encryption algorithm " + a.name() + " requires block cipher padding");
						} else if (padding.get() != BLOCK_CIPHER) {
							error(io, "Encryption algorithm " + a.name() + " requires block cipher padding");
						}
						if (!key.isPresent()) {
							error(io, "Encryption algorithm " + a.name() + " requires a key classifier");
						}
					} else if (isAsymmetric(a)) {
						if (mode.isPresent()) {
							error(io, "Encryption algorithm " + a.name() + " does not support modes");
						}
						if (!padding.isPresent()) {
							error(io, "Encryption algorithm " + a.name() + " requires padding to be set");
						} else if (padding.get() == BLOCK_CIPHER) {
							warning(io, "Block cipher padding is not secure for " + a.name());
						}
						if (!key.isPresent()) {
							error(io, "Encryption algorithm " + a.name() + " requires a key classifier");
						}
					} else {
						warning(io,
								"Encrytion algorithm " + a.name() + " is not supported by the rule violation checker");
					}
				});

			}

			private boolean isSymmetric(AlgorithmName_FieldType a) {
				return symmetric.contains(a);
			}

			private boolean isAsymmetric(AlgorithmName_FieldType a) {
				return asymmetric.contains(a);
			}
		};
	}

}
