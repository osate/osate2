package org.osate.analysis.security;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.InstanceReferenceValue;
import org.osate.xtext.aadl2.properties.util.AadlProject;
import org.osate.xtext.aadl2.properties.util.GetProperties;
import org.osate.xtext.aadl2.properties.util.PropertyUtils;

public class Encryption {

	public static final String ENCRYPTION_PROPERTY = "SecurityEnforcementProperties::Encryption";
	public static final String KEY_LENGTH_PROPERTY = "SecurityEnforcementProperties::Key_Length";

	private static Property encryptionProperty = null;
	private static Property keyLengthProperty = null;
	private static UnitLiteral bitsLiteral = null;

	public static Optional<Encryption> of(NamedElement ne) {
		try {
			final PropertyExpression pe = ne.getSimplePropertyValue(getEncryptionProperty(ne));
			if (!(pe instanceof RecordValue)) {
				return Optional.empty();
			}
			RecordValue rv = (RecordValue) pe;
			Optional<PropertyExpression> aform = Util.getFieldValue(rv, "encryption_form");
			Optional<PropertyExpression> amodes = Util.getFieldValue(rv, "encryption_mode");
			Optional<PropertyExpression> aalgos = Util.getFieldValue(rv, "encryption_algorithm");
			Optional<PropertyExpression> apad = Util.getFieldValue(rv, "padding");
			Optional<PropertyExpression> aauth = Util.getFieldValue(rv, "authenticated_encryption_type");
			Optional<PropertyExpression> akeys = Util.getFieldValue(rv, "key_type");
			Optional<PropertyExpression> apriv = Util.getFieldValue(rv, "private_key");
			Optional<PropertyExpression> apub = Util.getFieldValue(rv, "public_key");
			Optional<PropertyExpression> asingle = Util.getFieldValue(rv, "single_key");

			EnumerationLiteral form = null;
			if (aform.isPresent()) {
				form = (EnumerationLiteral) ((NamedValue) aform.get()).getNamedValue();
			}

			List<EnumerationLiteral> modes = Collections.emptyList();
			if (amodes.isPresent()) {
				modes = ((ListValue) amodes.get()).getOwnedListElements()
						.stream()
						.map((e) -> (EnumerationLiteral) ((NamedValue) e).getNamedValue())
						.collect(Collectors.toList());
			}

			List<EnumerationLiteral> algorithms = Collections.emptyList();
			if (aalgos.isPresent()) {
				algorithms = ((ListValue) aalgos.get()).getOwnedListElements()
						.stream()
						.map((e) -> (EnumerationLiteral) ((NamedValue) e).getNamedValue())
						.collect(Collectors.toList());
			}

			EnumerationLiteral padding = null;
			if (apad.isPresent()) {
				padding = (EnumerationLiteral) ((NamedValue) apad.get()).getNamedValue();
			}

			EnumerationLiteral authentication = null;
			if (aauth.isPresent()) {
				authentication = (EnumerationLiteral) ((NamedValue) aauth.get()).getNamedValue();
			}

			List<Classifier> classifiers = Collections.emptyList();
			if (akeys.isPresent()) {
				classifiers = ((ListValue) akeys.get()).getOwnedListElements()
						.stream()
						.map((e) -> ((ClassifierValue) e).getClassifier())
						.collect(Collectors.toList());
			}

			InstanceObject privateKey = null;
			if (apriv.isPresent()) {
				privateKey = ((InstanceReferenceValue) apriv.get()).getReferencedInstanceObject();
			}

			InstanceObject publicKey = null;
			if (apub.isPresent()) {
				publicKey = ((InstanceReferenceValue) apub.get()).getReferencedInstanceObject();
			}

			InstanceObject singleKey = null;
			if (asingle.isPresent()) {
				singleKey = ((InstanceReferenceValue) asingle.get()).getReferencedInstanceObject();
			}

			return Optional.of(new Encryption(form, modes, algorithms, padding, authentication, classifiers, privateKey,
					publicKey, singleKey));
		} catch (Exception e) {
			return Optional.empty();
		}
	}

	/**
	 * @return the encryption property
	 */
	private static Property getEncryptionProperty(NamedElement ne) {
		if (encryptionProperty == null) {
			encryptionProperty = GetProperties.lookupPropertyDefinition(ne, ENCRYPTION_PROPERTY);
		}
		return encryptionProperty;
	}

	/**
	 * @return the key_lenght property
	 */
	private static Property getKeyLengthProperty(NamedElement ne) {
		if (keyLengthProperty == null) {
			keyLengthProperty = GetProperties.lookupPropertyDefinition(ne, KEY_LENGTH_PROPERTY);
		}
		return keyLengthProperty;
	}

	/**
	 * @return the unit literal for bits
	 */
	private static UnitLiteral getBitsLiteral(NamedElement ne) {
		if (bitsLiteral == null) {
			bitsLiteral = GetProperties.findUnitLiteral(getKeyLengthProperty(ne), AadlProject.BITS_LITERAL);
		}
		return bitsLiteral;
	}

	/**
	 * @param securityLabelProperty the securityLabelProperty to set
	 */
	public static void setSecurityLabelProperty(Property securityLabelProperty) {
		Encryption.encryptionProperty = securityLabelProperty;
	}

	// ----------------------------------------------------------------

	private EnumerationLiteral encryptionForm;
	private List<EnumerationLiteral> encryptionModes;
	private List<EnumerationLiteral> encryptionAlgorithms;
	private EnumerationLiteral padding;
	private EnumerationLiteral authenticatedEncryptionType;
	private List<Classifier> keyTypes;
	private InstanceObject privateKey;
	private InstanceObject publicKey;
	private InstanceObject singleKey;

	public Encryption(EnumerationLiteral encryptionForm, List<EnumerationLiteral> encryptionModes,
			List<EnumerationLiteral> encryptionAlgorithms, EnumerationLiteral padding,
			EnumerationLiteral authenticatedEncryptionType, List<Classifier> keyTypes, InstanceObject privateKey,
			InstanceObject publicKey, InstanceObject singleKey) {
		this.encryptionForm = encryptionForm;
		this.encryptionModes = encryptionModes;
		this.encryptionAlgorithms = encryptionAlgorithms;
		this.padding = padding;
		this.authenticatedEncryptionType = authenticatedEncryptionType;
		this.keyTypes = keyTypes;
		this.privateKey = privateKey;
		this.publicKey = publicKey;
		this.singleKey = singleKey;
	}

	/**
	 * @return the encryptionForm
	 */
	public EnumerationLiteral getEncryptionForm() {
		return encryptionForm;
	}

	/**
	 * @return the encryptionModes
	 */
	public List<EnumerationLiteral> getEncryptionModes() {
		return encryptionModes;
	}

	/**
	 * @return the encryptionAlgorithms
	 */
	public List<EnumerationLiteral> getEncryptionAlgorithms() {
		return encryptionAlgorithms;
	}

	/**
	 * @return the key classifiers
	 */
	public List<Classifier> getKeyTypes() {
		return keyTypes;
	}

	/**
	 * @return the padding
	 */
	public EnumerationLiteral getPadding() {
		return padding;
	}

	/**
	 * @return the authenticatedEncryptionType
	 */
	public EnumerationLiteral getAuthenticatedEncryptionType() {
		return authenticatedEncryptionType;
	}

	/**
	 * @return the privateKey
	 */
	public InstanceObject getPrivateKey() {
		return privateKey;
	}

	/**
	 * @return the publicKey
	 */
	public InstanceObject getPublicKey() {
		return publicKey;
	}

	/**
	 * @return the singleKey
	 */
	public InstanceObject getSingleKey() {
		return singleKey;
	}

	/**
	 * @return the keyLengths
	 */
	public List<Integer> getKeyLengths() {
		return keyTypes.stream()
				.map((c) -> (int) PropertyUtils.getScaledNumberValue(c, getKeyLengthProperty(c), getBitsLiteral(c), -1))
				.collect(Collectors.toList());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Encryption [" + encryptionForm.getName() + ", modes = "
				+ encryptionModes.stream().map(EnumerationLiteral::getName).collect(Collectors.joining(", ", "(", ")"))
				+ ", algorithms = "
				+ encryptionAlgorithms.stream()
						.map(EnumerationLiteral::getName)
						.collect(Collectors.joining(", ", "(", ")"))
				+ ", key lengths = "
				+ getKeyLengths().stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")) + "]";
	}

}
