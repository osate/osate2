package org.osate.aadl2.errormodel.contrib.arpa4761;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.errormodel.contrib.emv2.Dallabels;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.pluginsupport.properties.CodeGenUtil;
import org.osate.pluginsupport.properties.GeneratedRecord;

public class Hazards extends GeneratedRecord {
	public static final String CROSSREFERENCE__NAME = "CrossReference";
	public static final String HAZARDTITLE__NAME = "HazardTitle";
	public static final String DESCRIPTION__NAME = "Description";
	public static final String FAILURE__NAME = "Failure";
	public static final String FAILUREEFFECT__NAME = "FailureEffect";
	public static final String PHASES__NAME = "Phases";
	public static final String ENVIRONMENT__NAME = "Environment";
	public static final String MISHAP__NAME = "Mishap";
	public static final String RISK__NAME = "Risk";
	public static final String FAILURECONDITION__NAME = "FailureCondition";
	public static final String FAILURECONDITIONCLASSIFICATION__NAME = "FailureConditionClassification";
	public static final String QUALITATIVEPROBABILITY__NAME = "QualitativeProbability";
	public static final String QUANTITATIVEPROBABILITY__NAME = "QuantitativeProbability";
	public static final String QUALITATIVEPROBABILITYOBJECTIVE__NAME = "QualitativeProbabilityObjective";
	public static final String QUANTITATIVEPROBABILITYOBJECTIVE__NAME = "QuantitativeProbabilityObjective";
	public static final String DEVELOPMENTASSURANCELEVEL__NAME = "DevelopmentAssuranceLevel";
	public static final String VERIFICATIONMETHOD__NAME = "VerificationMethod";
	public static final String SAFETYREPORT__NAME = "SafetyReport";
	public static final String COMMENT__NAME = "Comment";
	public static final URI CROSSREFERENCE__URI = URI.createURI("platform:/resource/EMV2_prop_sets/ARP4761.aadl#/0/@ownedProperty.0/@ownedPropertyType/@ownedElementType/@ownedField.0");
	public static final URI HAZARDTITLE__URI = URI.createURI("platform:/resource/EMV2_prop_sets/ARP4761.aadl#/0/@ownedProperty.0/@ownedPropertyType/@ownedElementType/@ownedField.1");
	public static final URI DESCRIPTION__URI = URI.createURI("platform:/resource/EMV2_prop_sets/ARP4761.aadl#/0/@ownedProperty.0/@ownedPropertyType/@ownedElementType/@ownedField.2");
	public static final URI FAILURE__URI = URI.createURI("platform:/resource/EMV2_prop_sets/ARP4761.aadl#/0/@ownedProperty.0/@ownedPropertyType/@ownedElementType/@ownedField.3");
	public static final URI FAILUREEFFECT__URI = URI.createURI("platform:/resource/EMV2_prop_sets/ARP4761.aadl#/0/@ownedProperty.0/@ownedPropertyType/@ownedElementType/@ownedField.4");
	public static final URI PHASES__URI = URI.createURI("platform:/resource/EMV2_prop_sets/ARP4761.aadl#/0/@ownedProperty.0/@ownedPropertyType/@ownedElementType/@ownedField.5");
	public static final URI ENVIRONMENT__URI = URI.createURI("platform:/resource/EMV2_prop_sets/ARP4761.aadl#/0/@ownedProperty.0/@ownedPropertyType/@ownedElementType/@ownedField.6");
	public static final URI MISHAP__URI = URI.createURI("platform:/resource/EMV2_prop_sets/ARP4761.aadl#/0/@ownedProperty.0/@ownedPropertyType/@ownedElementType/@ownedField.7");
	public static final URI RISK__URI = URI.createURI("platform:/resource/EMV2_prop_sets/ARP4761.aadl#/0/@ownedProperty.0/@ownedPropertyType/@ownedElementType/@ownedField.8");
	public static final URI FAILURECONDITION__URI = URI.createURI("platform:/resource/EMV2_prop_sets/ARP4761.aadl#/0/@ownedProperty.0/@ownedPropertyType/@ownedElementType/@ownedField.9");
	public static final URI FAILURECONDITIONCLASSIFICATION__URI = URI.createURI("platform:/resource/EMV2_prop_sets/ARP4761.aadl#/0/@ownedProperty.0/@ownedPropertyType/@ownedElementType/@ownedField.10");
	public static final URI QUALITATIVEPROBABILITY__URI = URI.createURI("platform:/resource/EMV2_prop_sets/ARP4761.aadl#/0/@ownedProperty.0/@ownedPropertyType/@ownedElementType/@ownedField.11");
	public static final URI QUANTITATIVEPROBABILITY__URI = URI.createURI("platform:/resource/EMV2_prop_sets/ARP4761.aadl#/0/@ownedProperty.0/@ownedPropertyType/@ownedElementType/@ownedField.12");
	public static final URI QUALITATIVEPROBABILITYOBJECTIVE__URI = URI.createURI("platform:/resource/EMV2_prop_sets/ARP4761.aadl#/0/@ownedProperty.0/@ownedPropertyType/@ownedElementType/@ownedField.13");
	public static final URI QUANTITATIVEPROBABILITYOBJECTIVE__URI = URI.createURI("platform:/resource/EMV2_prop_sets/ARP4761.aadl#/0/@ownedProperty.0/@ownedPropertyType/@ownedElementType/@ownedField.14");
	public static final URI DEVELOPMENTASSURANCELEVEL__URI = URI.createURI("platform:/resource/EMV2_prop_sets/ARP4761.aadl#/0/@ownedProperty.0/@ownedPropertyType/@ownedElementType/@ownedField.15");
	public static final URI VERIFICATIONMETHOD__URI = URI.createURI("platform:/resource/EMV2_prop_sets/ARP4761.aadl#/0/@ownedProperty.0/@ownedPropertyType/@ownedElementType/@ownedField.16");
	public static final URI SAFETYREPORT__URI = URI.createURI("platform:/resource/EMV2_prop_sets/ARP4761.aadl#/0/@ownedProperty.0/@ownedPropertyType/@ownedElementType/@ownedField.17");
	public static final URI COMMENT__URI = URI.createURI("platform:/resource/EMV2_prop_sets/ARP4761.aadl#/0/@ownedProperty.0/@ownedPropertyType/@ownedElementType/@ownedField.18");
	
	private final Optional<String> crossreference;
	private final Optional<String> hazardtitle;
	private final Optional<String> description;
	private final Optional<String> failure;
	private final Optional<String> failureeffect;
	private final Optional<List<String>> phases;
	private final Optional<String> environment;
	private final Optional<String> mishap;
	private final Optional<String> risk;
	private final Optional<String> failurecondition;
	private final Optional<Severityclassification> failureconditionclassification;
	private final Optional<Probabilitylabels> qualitativeprobability;
	private final OptionalDouble quantitativeprobability;
	private final Optional<Probabilitylabels> qualitativeprobabilityobjective;
	private final OptionalDouble quantitativeprobabilityobjective;
	private final Optional<Dallabels> developmentassurancelevel;
	private final Optional<String> verificationmethod;
	private final Optional<String> safetyreport;
	private final Optional<String> comment;
	
	public Hazards(
			Optional<String> crossreference,
			Optional<String> hazardtitle,
			Optional<String> description,
			Optional<String> failure,
			Optional<String> failureeffect,
			Optional<List<String>> phases,
			Optional<String> environment,
			Optional<String> mishap,
			Optional<String> risk,
			Optional<String> failurecondition,
			Optional<Severityclassification> failureconditionclassification,
			Optional<Probabilitylabels> qualitativeprobability,
			OptionalDouble quantitativeprobability,
			Optional<Probabilitylabels> qualitativeprobabilityobjective,
			OptionalDouble quantitativeprobabilityobjective,
			Optional<Dallabels> developmentassurancelevel,
			Optional<String> verificationmethod,
			Optional<String> safetyreport,
			Optional<String> comment
	) {
		this.crossreference = crossreference;
		this.hazardtitle = hazardtitle;
		this.description = description;
		this.failure = failure;
		this.failureeffect = failureeffect;
		this.phases = phases;
		this.environment = environment;
		this.mishap = mishap;
		this.risk = risk;
		this.failurecondition = failurecondition;
		this.failureconditionclassification = failureconditionclassification;
		this.qualitativeprobability = qualitativeprobability;
		this.quantitativeprobability = quantitativeprobability;
		this.qualitativeprobabilityobjective = qualitativeprobabilityobjective;
		this.quantitativeprobabilityobjective = quantitativeprobabilityobjective;
		this.developmentassurancelevel = developmentassurancelevel;
		this.verificationmethod = verificationmethod;
		this.safetyreport = safetyreport;
		this.comment = comment;
	}
	
	public Hazards(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
		RecordValue recordValue = (RecordValue) propertyExpression;
		
		Optional<String> crossreference_local;
		try {
			crossreference_local = findFieldValue(recordValue, CROSSREFERENCE__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((StringLiteral) resolved).getValue();
			});
		} catch (PropertyNotPresentException e) {
			crossreference_local = Optional.empty();
		}
		this.crossreference = crossreference_local;
		
		Optional<String> hazardtitle_local;
		try {
			hazardtitle_local = findFieldValue(recordValue, HAZARDTITLE__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((StringLiteral) resolved).getValue();
			});
		} catch (PropertyNotPresentException e) {
			hazardtitle_local = Optional.empty();
		}
		this.hazardtitle = hazardtitle_local;
		
		Optional<String> description_local;
		try {
			description_local = findFieldValue(recordValue, DESCRIPTION__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((StringLiteral) resolved).getValue();
			});
		} catch (PropertyNotPresentException e) {
			description_local = Optional.empty();
		}
		this.description = description_local;
		
		Optional<String> failure_local;
		try {
			failure_local = findFieldValue(recordValue, FAILURE__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((StringLiteral) resolved).getValue();
			});
		} catch (PropertyNotPresentException e) {
			failure_local = Optional.empty();
		}
		this.failure = failure_local;
		
		Optional<String> failureeffect_local;
		try {
			failureeffect_local = findFieldValue(recordValue, FAILUREEFFECT__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((StringLiteral) resolved).getValue();
			});
		} catch (PropertyNotPresentException e) {
			failureeffect_local = Optional.empty();
		}
		this.failureeffect = failureeffect_local;
		
		Optional<List<String>> phases_local;
		try {
			phases_local = findFieldValue(recordValue, PHASES__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
					PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
					return ((StringLiteral) resolved1).getValue();
				}).collect(Collectors.toList());
			});
		} catch (PropertyNotPresentException e) {
			phases_local = Optional.empty();
		}
		this.phases = phases_local;
		
		Optional<String> environment_local;
		try {
			environment_local = findFieldValue(recordValue, ENVIRONMENT__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((StringLiteral) resolved).getValue();
			});
		} catch (PropertyNotPresentException e) {
			environment_local = Optional.empty();
		}
		this.environment = environment_local;
		
		Optional<String> mishap_local;
		try {
			mishap_local = findFieldValue(recordValue, MISHAP__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((StringLiteral) resolved).getValue();
			});
		} catch (PropertyNotPresentException e) {
			mishap_local = Optional.empty();
		}
		this.mishap = mishap_local;
		
		Optional<String> risk_local;
		try {
			risk_local = findFieldValue(recordValue, RISK__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((StringLiteral) resolved).getValue();
			});
		} catch (PropertyNotPresentException e) {
			risk_local = Optional.empty();
		}
		this.risk = risk_local;
		
		Optional<String> failurecondition_local;
		try {
			failurecondition_local = findFieldValue(recordValue, FAILURECONDITION__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((StringLiteral) resolved).getValue();
			});
		} catch (PropertyNotPresentException e) {
			failurecondition_local = Optional.empty();
		}
		this.failurecondition = failurecondition_local;
		
		Optional<Severityclassification> failureconditionclassification_local;
		try {
			failureconditionclassification_local = findFieldValue(recordValue, FAILURECONDITIONCLASSIFICATION__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return Severityclassification.valueOf(resolved);
			});
		} catch (PropertyNotPresentException e) {
			failureconditionclassification_local = Optional.empty();
		}
		this.failureconditionclassification = failureconditionclassification_local;
		
		Optional<Probabilitylabels> qualitativeprobability_local;
		try {
			qualitativeprobability_local = findFieldValue(recordValue, QUALITATIVEPROBABILITY__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return Probabilitylabels.valueOf(resolved);
			});
		} catch (PropertyNotPresentException e) {
			qualitativeprobability_local = Optional.empty();
		}
		this.qualitativeprobability = qualitativeprobability_local;
		
		OptionalDouble quantitativeprobability_local;
		try {
			quantitativeprobability_local = findFieldValue(recordValue, QUANTITATIVEPROBABILITY__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((RealLiteral) resolved).getValue();
			}).map(OptionalDouble::of).orElse(OptionalDouble.empty());
		} catch (PropertyNotPresentException e) {
			quantitativeprobability_local = OptionalDouble.empty();
		}
		this.quantitativeprobability = quantitativeprobability_local;
		
		Optional<Probabilitylabels> qualitativeprobabilityobjective_local;
		try {
			qualitativeprobabilityobjective_local = findFieldValue(recordValue, QUALITATIVEPROBABILITYOBJECTIVE__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return Probabilitylabels.valueOf(resolved);
			});
		} catch (PropertyNotPresentException e) {
			qualitativeprobabilityobjective_local = Optional.empty();
		}
		this.qualitativeprobabilityobjective = qualitativeprobabilityobjective_local;
		
		OptionalDouble quantitativeprobabilityobjective_local;
		try {
			quantitativeprobabilityobjective_local = findFieldValue(recordValue, QUANTITATIVEPROBABILITYOBJECTIVE__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((RealLiteral) resolved).getValue();
			}).map(OptionalDouble::of).orElse(OptionalDouble.empty());
		} catch (PropertyNotPresentException e) {
			quantitativeprobabilityobjective_local = OptionalDouble.empty();
		}
		this.quantitativeprobabilityobjective = quantitativeprobabilityobjective_local;
		
		Optional<Dallabels> developmentassurancelevel_local;
		try {
			developmentassurancelevel_local = findFieldValue(recordValue, DEVELOPMENTASSURANCELEVEL__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return Dallabels.valueOf(resolved);
			});
		} catch (PropertyNotPresentException e) {
			developmentassurancelevel_local = Optional.empty();
		}
		this.developmentassurancelevel = developmentassurancelevel_local;
		
		Optional<String> verificationmethod_local;
		try {
			verificationmethod_local = findFieldValue(recordValue, VERIFICATIONMETHOD__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((StringLiteral) resolved).getValue();
			});
		} catch (PropertyNotPresentException e) {
			verificationmethod_local = Optional.empty();
		}
		this.verificationmethod = verificationmethod_local;
		
		Optional<String> safetyreport_local;
		try {
			safetyreport_local = findFieldValue(recordValue, SAFETYREPORT__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((StringLiteral) resolved).getValue();
			});
		} catch (PropertyNotPresentException e) {
			safetyreport_local = Optional.empty();
		}
		this.safetyreport = safetyreport_local;
		
		Optional<String> comment_local;
		try {
			comment_local = findFieldValue(recordValue, COMMENT__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((StringLiteral) resolved).getValue();
			});
		} catch (PropertyNotPresentException e) {
			comment_local = Optional.empty();
		}
		this.comment = comment_local;
	}
	
	public Optional<String> getCrossreference() {
		return crossreference;
	}
	
	public Optional<String> getHazardtitle() {
		return hazardtitle;
	}
	
	public Optional<String> getDescription() {
		return description;
	}
	
	public Optional<String> getFailure() {
		return failure;
	}
	
	public Optional<String> getFailureeffect() {
		return failureeffect;
	}
	
	public Optional<List<String>> getPhases() {
		return phases;
	}
	
	public Optional<String> getEnvironment() {
		return environment;
	}
	
	public Optional<String> getMishap() {
		return mishap;
	}
	
	public Optional<String> getRisk() {
		return risk;
	}
	
	public Optional<String> getFailurecondition() {
		return failurecondition;
	}
	
	public Optional<Severityclassification> getFailureconditionclassification() {
		return failureconditionclassification;
	}
	
	public Optional<Probabilitylabels> getQualitativeprobability() {
		return qualitativeprobability;
	}
	
	public OptionalDouble getQuantitativeprobability() {
		return quantitativeprobability;
	}
	
	public Optional<Probabilitylabels> getQualitativeprobabilityobjective() {
		return qualitativeprobabilityobjective;
	}
	
	public OptionalDouble getQuantitativeprobabilityobjective() {
		return quantitativeprobabilityobjective;
	}
	
	public Optional<Dallabels> getDevelopmentassurancelevel() {
		return developmentassurancelevel;
	}
	
	public Optional<String> getVerificationmethod() {
		return verificationmethod;
	}
	
	public Optional<String> getSafetyreport() {
		return safetyreport;
	}
	
	public Optional<String> getComment() {
		return comment;
	}
	
	@Override
	public RecordValue toPropertyExpression(ResourceSet resourceSet) {
		if (!crossreference.isPresent()
				&& !hazardtitle.isPresent()
				&& !description.isPresent()
				&& !failure.isPresent()
				&& !failureeffect.isPresent()
				&& !phases.isPresent()
				&& !environment.isPresent()
				&& !mishap.isPresent()
				&& !risk.isPresent()
				&& !failurecondition.isPresent()
				&& !failureconditionclassification.isPresent()
				&& !qualitativeprobability.isPresent()
				&& !quantitativeprobability.isPresent()
				&& !qualitativeprobabilityobjective.isPresent()
				&& !quantitativeprobabilityobjective.isPresent()
				&& !developmentassurancelevel.isPresent()
				&& !verificationmethod.isPresent()
				&& !safetyreport.isPresent()
				&& !comment.isPresent()
		) {
			throw new IllegalStateException("Record must have at least one field set.");
		}
		RecordValue recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
		crossreference.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, CROSSREFERENCE__URI, CROSSREFERENCE__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
		});
		hazardtitle.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, HAZARDTITLE__URI, HAZARDTITLE__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
		});
		description.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, DESCRIPTION__URI, DESCRIPTION__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
		});
		failure.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, FAILURE__URI, FAILURE__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
		});
		failureeffect.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, FAILUREEFFECT__URI, FAILUREEFFECT__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
		});
		phases.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, PHASES__URI, PHASES__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
				return CodeGenUtil.toPropertyExpression(element1);
			}));
		});
		environment.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, ENVIRONMENT__URI, ENVIRONMENT__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
		});
		mishap.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, MISHAP__URI, MISHAP__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
		});
		risk.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, RISK__URI, RISK__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
		});
		failurecondition.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, FAILURECONDITION__URI, FAILURECONDITION__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
		});
		failureconditionclassification.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, FAILURECONDITIONCLASSIFICATION__URI, FAILURECONDITIONCLASSIFICATION__NAME));
			fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
		});
		qualitativeprobability.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, QUALITATIVEPROBABILITY__URI, QUALITATIVEPROBABILITY__NAME));
			fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
		});
		quantitativeprobability.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, QUANTITATIVEPROBABILITY__URI, QUANTITATIVEPROBABILITY__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
		});
		qualitativeprobabilityobjective.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, QUALITATIVEPROBABILITYOBJECTIVE__URI, QUALITATIVEPROBABILITYOBJECTIVE__NAME));
			fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
		});
		quantitativeprobabilityobjective.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, QUANTITATIVEPROBABILITYOBJECTIVE__URI, QUANTITATIVEPROBABILITYOBJECTIVE__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
		});
		developmentassurancelevel.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, DEVELOPMENTASSURANCELEVEL__URI, DEVELOPMENTASSURANCELEVEL__NAME));
			fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
		});
		verificationmethod.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, VERIFICATIONMETHOD__URI, VERIFICATIONMETHOD__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
		});
		safetyreport.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, SAFETYREPORT__URI, SAFETYREPORT__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
		});
		comment.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, COMMENT__URI, COMMENT__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
		});
		return recordValue;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(
				crossreference,
				hazardtitle,
				description,
				failure,
				failureeffect,
				phases,
				environment,
				mishap,
				risk,
				failurecondition,
				failureconditionclassification,
				qualitativeprobability,
				quantitativeprobability,
				qualitativeprobabilityobjective,
				quantitativeprobabilityobjective,
				developmentassurancelevel,
				verificationmethod,
				safetyreport,
				comment
		);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Hazards)) {
			return false;
		}
		Hazards other = (Hazards) obj;
		return Objects.equals(this.crossreference, other.crossreference)
				&& Objects.equals(this.hazardtitle, other.hazardtitle)
				&& Objects.equals(this.description, other.description)
				&& Objects.equals(this.failure, other.failure)
				&& Objects.equals(this.failureeffect, other.failureeffect)
				&& Objects.equals(this.phases, other.phases)
				&& Objects.equals(this.environment, other.environment)
				&& Objects.equals(this.mishap, other.mishap)
				&& Objects.equals(this.risk, other.risk)
				&& Objects.equals(this.failurecondition, other.failurecondition)
				&& Objects.equals(this.failureconditionclassification, other.failureconditionclassification)
				&& Objects.equals(this.qualitativeprobability, other.qualitativeprobability)
				&& Objects.equals(this.quantitativeprobability, other.quantitativeprobability)
				&& Objects.equals(this.qualitativeprobabilityobjective, other.qualitativeprobabilityobjective)
				&& Objects.equals(this.quantitativeprobabilityobjective, other.quantitativeprobabilityobjective)
				&& Objects.equals(this.developmentassurancelevel, other.developmentassurancelevel)
				&& Objects.equals(this.verificationmethod, other.verificationmethod)
				&& Objects.equals(this.safetyreport, other.safetyreport)
				&& Objects.equals(this.comment, other.comment);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append('[');
		this.crossreference.ifPresent(field -> {
			builder.append(CROSSREFERENCE__NAME);
			builder.append(" => \"");
			builder.append(field);
			builder.append("\";");
		});
		this.hazardtitle.ifPresent(field -> {
			builder.append(HAZARDTITLE__NAME);
			builder.append(" => \"");
			builder.append(field);
			builder.append("\";");
		});
		this.description.ifPresent(field -> {
			builder.append(DESCRIPTION__NAME);
			builder.append(" => \"");
			builder.append(field);
			builder.append("\";");
		});
		this.failure.ifPresent(field -> {
			builder.append(FAILURE__NAME);
			builder.append(" => \"");
			builder.append(field);
			builder.append("\";");
		});
		this.failureeffect.ifPresent(field -> {
			builder.append(FAILUREEFFECT__NAME);
			builder.append(" => \"");
			builder.append(field);
			builder.append("\";");
		});
		this.phases.ifPresent(field -> {
			builder.append(PHASES__NAME);
			builder.append(" => ");
			builder.append(field.stream().map(element1 -> {
				return '\"' + element1 + '\"';
			}).collect(Collectors.joining(", ", "(", ")")));
			builder.append(';');
		});
		this.environment.ifPresent(field -> {
			builder.append(ENVIRONMENT__NAME);
			builder.append(" => \"");
			builder.append(field);
			builder.append("\";");
		});
		this.mishap.ifPresent(field -> {
			builder.append(MISHAP__NAME);
			builder.append(" => \"");
			builder.append(field);
			builder.append("\";");
		});
		this.risk.ifPresent(field -> {
			builder.append(RISK__NAME);
			builder.append(" => \"");
			builder.append(field);
			builder.append("\";");
		});
		this.failurecondition.ifPresent(field -> {
			builder.append(FAILURECONDITION__NAME);
			builder.append(" => \"");
			builder.append(field);
			builder.append("\";");
		});
		this.failureconditionclassification.ifPresent(field -> {
			builder.append(FAILURECONDITIONCLASSIFICATION__NAME);
			builder.append(" => ");
			builder.append(field);
			builder.append(';');
		});
		this.qualitativeprobability.ifPresent(field -> {
			builder.append(QUALITATIVEPROBABILITY__NAME);
			builder.append(" => ");
			builder.append(field);
			builder.append(';');
		});
		this.quantitativeprobability.ifPresent(field -> {
			builder.append(QUANTITATIVEPROBABILITY__NAME);
			builder.append(" => ");
			builder.append(field);
			builder.append(';');
		});
		this.qualitativeprobabilityobjective.ifPresent(field -> {
			builder.append(QUALITATIVEPROBABILITYOBJECTIVE__NAME);
			builder.append(" => ");
			builder.append(field);
			builder.append(';');
		});
		this.quantitativeprobabilityobjective.ifPresent(field -> {
			builder.append(QUANTITATIVEPROBABILITYOBJECTIVE__NAME);
			builder.append(" => ");
			builder.append(field);
			builder.append(';');
		});
		this.developmentassurancelevel.ifPresent(field -> {
			builder.append(DEVELOPMENTASSURANCELEVEL__NAME);
			builder.append(" => ");
			builder.append(field);
			builder.append(';');
		});
		this.verificationmethod.ifPresent(field -> {
			builder.append(VERIFICATIONMETHOD__NAME);
			builder.append(" => \"");
			builder.append(field);
			builder.append("\";");
		});
		this.safetyreport.ifPresent(field -> {
			builder.append(SAFETYREPORT__NAME);
			builder.append(" => \"");
			builder.append(field);
			builder.append("\";");
		});
		this.comment.ifPresent(field -> {
			builder.append(COMMENT__NAME);
			builder.append(" => \"");
			builder.append(field);
			builder.append("\";");
		});
		builder.append(']');
		return builder.toString();
	}
}
