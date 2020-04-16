package org.osate.analysis.security;

import static security_type_specifications.EncryptionSpecificationType.AlgorithmName_FieldType.AES;
import static security_type_specifications.EncryptionSpecificationType.AlgorithmName_FieldType.BLOWFISH;
import static security_type_specifications.EncryptionSpecificationType.AlgorithmName_FieldType.DES;
import static security_type_specifications.EncryptionSpecificationType.AlgorithmName_FieldType.ECC;
import static security_type_specifications.EncryptionSpecificationType.AlgorithmName_FieldType.RSA;
import static security_type_specifications.EncryptionSpecificationType.AlgorithmName_FieldType.TRIPLEDES;
import static security_type_specifications.EncryptionSpecificationType.AlgorithmName_FieldType.TWOFISH;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitch;

import aadl_project.Size;
import aadl_project.SizeUnits;
import security_enforcement_properties.SecurityEnforcementProperties;
import security_type_specifications.EncryptionSpecificationType;
import security_type_specifications.EncryptionSpecificationType.AlgorithmName_FieldType;
import security_type_specifications.EncryptionSpecificationType.EncryptionMode_FieldType;
import security_type_specifications.EncryptionSpecificationType.Padding_FieldType;
import security_type_specifications.SecuritySpecificationType;

public class RuleViolationChecker extends AadlProcessingSwitch {

	private static final Set<AlgorithmName_FieldType> symmetric = new HashSet<EncryptionSpecificationType.AlgorithmName_FieldType>();
	private static final Set<AlgorithmName_FieldType> asymmetric = new HashSet<EncryptionSpecificationType.AlgorithmName_FieldType>();
	private final static Integer[] AES_LENGTHS = { 128, 192, 256 };
	private final static Integer[] DES_LENGTHS = { 56 };
	private final static Integer[] TRIPLEDES_LENGTHS = { 56, 112, 168 };
	private final static Integer[] BLOWFISH_LENGTHS = new Integer[(448 - 32) / 8 + 1];
	private final static Integer[] TWOFISH_LENGTHS = { 128, 192, 256 };
	private final static Integer[] RSA_LENGTHS = { 512, 768, 1024, 2048, 3072, 4096, 8192 };

	static {
		Collections.addAll(symmetric, DES, TRIPLEDES, AES, BLOWFISH, TWOFISH);
		Collections.addAll(asymmetric, RSA, ECC);
		for (int i = 0, l = 32; l <= 448; i++, l += 8) {
			BLOWFISH_LENGTHS[i] = l;
		}
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
					ListValue lv = (ListValue) SecurityEnforcementProperties.getDataSecuritySpecification_EObject(io);
					Iterator<PropertyExpression> records = lv.getOwnedListElements().iterator();

					specs.stream().forEach(spec -> {
						RecordValue rec = (RecordValue) records.next();
						spec.getEncryption().ifPresent(enc -> {
							RecordValue rv = (RecordValue) getField(rec, "encryption").get();

							validateEncryptionSpecification(io, enc, rv);
						});
					});
				});
			}

			private void validateEncryptionSpecification(InstanceObject io, EncryptionSpecificationType enc,
					RecordValue encRV) {
				Optional<AlgorithmName_FieldType> algo = enc.getAlgorithmName();
				Optional<EncryptionMode_FieldType> mode = enc.getEncryptionMode();
				Optional<Padding_FieldType> padding = enc.getPadding();
				Optional<Classifier> key = enc.getKeyClassifier();

				Optional<PropertyExpression> algoEObject = getField(encRV, "algorithm_name");
				Optional<PropertyExpression> modeEObject = getField(encRV, "encryption_mode");
				Optional<PropertyExpression> paddingEObject = getField(encRV, "padding");
				Optional<PropertyExpression> keyEObject = getField(encRV, "key_classifier");

				algo.ifPresent(a -> {
					if (a == AlgorithmName_FieldType.OTP) {
						warning(algoEObject.get(), "Don't use OTP");
						mode.ifPresent(m -> error(modeEObject.get(), "OTP doesn't have modes"));
						padding.ifPresent(p -> error(paddingEObject.get(), "Don't use padding with OTP"));
						if (!key.isPresent()) {
							error(encRV, "Missing key for OTP");
						}
					} else if (isSymmetric(a)) {
						if (!mode.isPresent()) {
							error(encRV, "Encryption algorithm " + a.name() + " requires a mode");
						} else if (mode.get() == EncryptionMode_FieldType.ECB) {
							warning(modeEObject.get(), "ECB mode is not secure");
						}
						if (!padding.isPresent()) {
							error(encRV, "Encryption algorithm " + a.name() + " requires block cipher padding");
						} else if (padding.get() != Padding_FieldType.BLOCK_CIPHER) {
							error(encRV, "Encryption algorithm " + a.name() + " requires block cipher padding");
						}
						if (!key.isPresent()) {
							error(encRV, "Encryption algorithm " + a.name() + " requires a key classifier");
						} else {
							Optional<Size> size = SecurityEnforcementProperties.getKeyLength(key.get());

							if (!size.isPresent()) {
								error(keyEObject.get(), "Key is missing the Key_Length property");
							} else {
								double d = size.get().getValue() * size.get().getUnit().getFactorTo(SizeUnits.BITS);
								int len = (int) Math.round(d);
								checkKeyLength(keyEObject.get(), a, len);
							}
						}
					} else if (isAsymmetric(a)) {
						if (mode.isPresent()) {
							error(modeEObject.get(), "Encryption algorithm " + a.name() + " does not support modes");
						}
						if (!padding.isPresent()) {
							error(encRV, "Encryption algorithm " + a.name() + " requires padding to be set");
						} else if (padding.get() == Padding_FieldType.BLOCK_CIPHER) {
							warning(paddingEObject.get(), "Block cipher padding is not secure for " + a.name());
						}
						if (!key.isPresent()) {
							error(encRV, "Encryption algorithm " + a.name() + " requires a key classifier");
						}
					} else {
						warning(encRV,
								"Encryption algorithm " + a.name() + " is not supported by the rule violation checker");
					}
				});

			}

			private boolean isSymmetric(AlgorithmName_FieldType a) {
				return symmetric.contains(a);
			}

			private boolean isAsymmetric(AlgorithmName_FieldType a) {
				return asymmetric.contains(a);
			}

			protected void checkKeyLength(PropertyExpression propertyExpression, AlgorithmName_FieldType a, int len) {
				boolean validKey = true;
				switch (a) {
				case AES:
					validKey = Arrays.asList(AES_LENGTHS).contains(len);
					break;
				case BLOWFISH:
					validKey = Arrays.asList(BLOWFISH_LENGTHS).contains(len);
					break;
				case DES:
					validKey = Arrays.asList(DES_LENGTHS).contains(len);
					break;
				case TRIPLEDES:
					validKey = Arrays.asList(TRIPLEDES_LENGTHS).contains(len);
					break;
				case TWOFISH:
					validKey = Arrays.asList(TWOFISH_LENGTHS).contains(len);
					break;
				case RSA:
					validKey = Arrays.asList(TWOFISH_LENGTHS).contains(len);
					break;
				case ECC:
					validKey = len >= 256;
					break;
				case OTP:
					break;
				}
				if (!validKey) {
					error(propertyExpression, "" + len + " is not a valid key length for " + a.name());
				}
			}

			private Optional<PropertyExpression> getField(RecordValue rv, String name) {
				Optional<BasicPropertyAssociation> fieldAssoc = rv.getOwnedFieldValues()
						.stream()
						.filter(f -> f.getProperty().getName().equalsIgnoreCase(name))
						.findFirst();
				return fieldAssoc.map(a -> a.getOwnedValue());
			}
		};
	}

}
