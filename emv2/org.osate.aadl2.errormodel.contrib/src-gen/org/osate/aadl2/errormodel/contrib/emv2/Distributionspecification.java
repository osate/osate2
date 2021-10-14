package org.osate.aadl2.errormodel.contrib.emv2;

import java.util.Objects;
import java.util.Optional;
import java.util.OptionalDouble;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.pluginsupport.properties.CodeGenUtil;
import org.osate.pluginsupport.properties.GeneratedRecord;

public class Distributionspecification extends GeneratedRecord {
	public static final String PROBABILITYVALUE__NAME = "ProbabilityValue";
	public static final String OCCURRENCERATE__NAME = "OccurrenceRate";
	public static final String MEANVALUE__NAME = "MeanValue";
	public static final String STANDARDDEVIATION__NAME = "StandardDeviation";
	public static final String SHAPEPARAMETER__NAME = "ShapeParameter";
	public static final String SCALEPARAMETER__NAME = "ScaleParameter";
	public static final String SUCCESSCOUNT__NAME = "SuccessCount";
	public static final String SAMPLECOUNT__NAME = "SampleCount";
	public static final String PROBABILITY__NAME = "Probability";
	public static final String DISTRIBUTION__NAME = "Distribution";
	public static final URI PROBABILITYVALUE__URI = URI.createURI("platform:/resource/EMV2_prop_sets/EMV2.aadl#/0/@ownedPropertyType.0/@ownedField.0");
	public static final URI OCCURRENCERATE__URI = URI.createURI("platform:/resource/EMV2_prop_sets/EMV2.aadl#/0/@ownedPropertyType.0/@ownedField.1");
	public static final URI MEANVALUE__URI = URI.createURI("platform:/resource/EMV2_prop_sets/EMV2.aadl#/0/@ownedPropertyType.0/@ownedField.2");
	public static final URI STANDARDDEVIATION__URI = URI.createURI("platform:/resource/EMV2_prop_sets/EMV2.aadl#/0/@ownedPropertyType.0/@ownedField.3");
	public static final URI SHAPEPARAMETER__URI = URI.createURI("platform:/resource/EMV2_prop_sets/EMV2.aadl#/0/@ownedPropertyType.0/@ownedField.4");
	public static final URI SCALEPARAMETER__URI = URI.createURI("platform:/resource/EMV2_prop_sets/EMV2.aadl#/0/@ownedPropertyType.0/@ownedField.5");
	public static final URI SUCCESSCOUNT__URI = URI.createURI("platform:/resource/EMV2_prop_sets/EMV2.aadl#/0/@ownedPropertyType.0/@ownedField.6");
	public static final URI SAMPLECOUNT__URI = URI.createURI("platform:/resource/EMV2_prop_sets/EMV2.aadl#/0/@ownedPropertyType.0/@ownedField.7");
	public static final URI PROBABILITY__URI = URI.createURI("platform:/resource/EMV2_prop_sets/EMV2.aadl#/0/@ownedPropertyType.0/@ownedField.8");
	public static final URI DISTRIBUTION__URI = URI.createURI("platform:/resource/EMV2_prop_sets/EMV2.aadl#/0/@ownedPropertyType.0/@ownedField.9");
	
	private final OptionalDouble probabilityvalue;
	private final OptionalDouble occurrencerate;
	private final OptionalDouble meanvalue;
	private final OptionalDouble standarddeviation;
	private final OptionalDouble shapeparameter;
	private final OptionalDouble scaleparameter;
	private final OptionalDouble successcount;
	private final OptionalDouble samplecount;
	private final OptionalDouble probability;
	private final Optional<Distributionfunction> distribution;
	
	public Distributionspecification(
			OptionalDouble probabilityvalue,
			OptionalDouble occurrencerate,
			OptionalDouble meanvalue,
			OptionalDouble standarddeviation,
			OptionalDouble shapeparameter,
			OptionalDouble scaleparameter,
			OptionalDouble successcount,
			OptionalDouble samplecount,
			OptionalDouble probability,
			Optional<Distributionfunction> distribution
	) {
		this.probabilityvalue = probabilityvalue;
		this.occurrencerate = occurrencerate;
		this.meanvalue = meanvalue;
		this.standarddeviation = standarddeviation;
		this.shapeparameter = shapeparameter;
		this.scaleparameter = scaleparameter;
		this.successcount = successcount;
		this.samplecount = samplecount;
		this.probability = probability;
		this.distribution = distribution;
	}
	
	public Distributionspecification(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
		RecordValue recordValue = (RecordValue) propertyExpression;
		
		OptionalDouble probabilityvalue_local;
		try {
			probabilityvalue_local = findFieldValue(recordValue, PROBABILITYVALUE__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((RealLiteral) resolved).getValue();
			}).map(OptionalDouble::of).orElse(OptionalDouble.empty());
		} catch (PropertyNotPresentException e) {
			probabilityvalue_local = OptionalDouble.empty();
		}
		this.probabilityvalue = probabilityvalue_local;
		
		OptionalDouble occurrencerate_local;
		try {
			occurrencerate_local = findFieldValue(recordValue, OCCURRENCERATE__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((RealLiteral) resolved).getValue();
			}).map(OptionalDouble::of).orElse(OptionalDouble.empty());
		} catch (PropertyNotPresentException e) {
			occurrencerate_local = OptionalDouble.empty();
		}
		this.occurrencerate = occurrencerate_local;
		
		OptionalDouble meanvalue_local;
		try {
			meanvalue_local = findFieldValue(recordValue, MEANVALUE__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((RealLiteral) resolved).getValue();
			}).map(OptionalDouble::of).orElse(OptionalDouble.empty());
		} catch (PropertyNotPresentException e) {
			meanvalue_local = OptionalDouble.empty();
		}
		this.meanvalue = meanvalue_local;
		
		OptionalDouble standarddeviation_local;
		try {
			standarddeviation_local = findFieldValue(recordValue, STANDARDDEVIATION__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((RealLiteral) resolved).getValue();
			}).map(OptionalDouble::of).orElse(OptionalDouble.empty());
		} catch (PropertyNotPresentException e) {
			standarddeviation_local = OptionalDouble.empty();
		}
		this.standarddeviation = standarddeviation_local;
		
		OptionalDouble shapeparameter_local;
		try {
			shapeparameter_local = findFieldValue(recordValue, SHAPEPARAMETER__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((RealLiteral) resolved).getValue();
			}).map(OptionalDouble::of).orElse(OptionalDouble.empty());
		} catch (PropertyNotPresentException e) {
			shapeparameter_local = OptionalDouble.empty();
		}
		this.shapeparameter = shapeparameter_local;
		
		OptionalDouble scaleparameter_local;
		try {
			scaleparameter_local = findFieldValue(recordValue, SCALEPARAMETER__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((RealLiteral) resolved).getValue();
			}).map(OptionalDouble::of).orElse(OptionalDouble.empty());
		} catch (PropertyNotPresentException e) {
			scaleparameter_local = OptionalDouble.empty();
		}
		this.scaleparameter = scaleparameter_local;
		
		OptionalDouble successcount_local;
		try {
			successcount_local = findFieldValue(recordValue, SUCCESSCOUNT__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((RealLiteral) resolved).getValue();
			}).map(OptionalDouble::of).orElse(OptionalDouble.empty());
		} catch (PropertyNotPresentException e) {
			successcount_local = OptionalDouble.empty();
		}
		this.successcount = successcount_local;
		
		OptionalDouble samplecount_local;
		try {
			samplecount_local = findFieldValue(recordValue, SAMPLECOUNT__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((RealLiteral) resolved).getValue();
			}).map(OptionalDouble::of).orElse(OptionalDouble.empty());
		} catch (PropertyNotPresentException e) {
			samplecount_local = OptionalDouble.empty();
		}
		this.samplecount = samplecount_local;
		
		OptionalDouble probability_local;
		try {
			probability_local = findFieldValue(recordValue, PROBABILITY__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((RealLiteral) resolved).getValue();
			}).map(OptionalDouble::of).orElse(OptionalDouble.empty());
		} catch (PropertyNotPresentException e) {
			probability_local = OptionalDouble.empty();
		}
		this.probability = probability_local;
		
		Optional<Distributionfunction> distribution_local;
		try {
			distribution_local = findFieldValue(recordValue, DISTRIBUTION__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return Distributionfunction.valueOf(resolved);
			});
		} catch (PropertyNotPresentException e) {
			distribution_local = Optional.empty();
		}
		this.distribution = distribution_local;
	}
	
	public OptionalDouble getProbabilityvalue() {
		return probabilityvalue;
	}
	
	public OptionalDouble getOccurrencerate() {
		return occurrencerate;
	}
	
	public OptionalDouble getMeanvalue() {
		return meanvalue;
	}
	
	public OptionalDouble getStandarddeviation() {
		return standarddeviation;
	}
	
	public OptionalDouble getShapeparameter() {
		return shapeparameter;
	}
	
	public OptionalDouble getScaleparameter() {
		return scaleparameter;
	}
	
	public OptionalDouble getSuccesscount() {
		return successcount;
	}
	
	public OptionalDouble getSamplecount() {
		return samplecount;
	}
	
	public OptionalDouble getProbability() {
		return probability;
	}
	
	public Optional<Distributionfunction> getDistribution() {
		return distribution;
	}
	
	@Override
	public RecordValue toPropertyExpression(ResourceSet resourceSet) {
		if (!probabilityvalue.isPresent()
				&& !occurrencerate.isPresent()
				&& !meanvalue.isPresent()
				&& !standarddeviation.isPresent()
				&& !shapeparameter.isPresent()
				&& !scaleparameter.isPresent()
				&& !successcount.isPresent()
				&& !samplecount.isPresent()
				&& !probability.isPresent()
				&& !distribution.isPresent()
		) {
			throw new IllegalStateException("Record must have at least one field set.");
		}
		RecordValue recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
		probabilityvalue.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, PROBABILITYVALUE__URI, PROBABILITYVALUE__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
		});
		occurrencerate.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, OCCURRENCERATE__URI, OCCURRENCERATE__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
		});
		meanvalue.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, MEANVALUE__URI, MEANVALUE__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
		});
		standarddeviation.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, STANDARDDEVIATION__URI, STANDARDDEVIATION__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
		});
		shapeparameter.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, SHAPEPARAMETER__URI, SHAPEPARAMETER__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
		});
		scaleparameter.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, SCALEPARAMETER__URI, SCALEPARAMETER__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
		});
		successcount.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, SUCCESSCOUNT__URI, SUCCESSCOUNT__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
		});
		samplecount.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, SAMPLECOUNT__URI, SAMPLECOUNT__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
		});
		probability.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, PROBABILITY__URI, PROBABILITY__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
		});
		distribution.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, DISTRIBUTION__URI, DISTRIBUTION__NAME));
			fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
		});
		return recordValue;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(
				probabilityvalue,
				occurrencerate,
				meanvalue,
				standarddeviation,
				shapeparameter,
				scaleparameter,
				successcount,
				samplecount,
				probability,
				distribution
		);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Distributionspecification)) {
			return false;
		}
		Distributionspecification other = (Distributionspecification) obj;
		return Objects.equals(this.probabilityvalue, other.probabilityvalue)
				&& Objects.equals(this.occurrencerate, other.occurrencerate)
				&& Objects.equals(this.meanvalue, other.meanvalue)
				&& Objects.equals(this.standarddeviation, other.standarddeviation)
				&& Objects.equals(this.shapeparameter, other.shapeparameter)
				&& Objects.equals(this.scaleparameter, other.scaleparameter)
				&& Objects.equals(this.successcount, other.successcount)
				&& Objects.equals(this.samplecount, other.samplecount)
				&& Objects.equals(this.probability, other.probability)
				&& Objects.equals(this.distribution, other.distribution);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append('[');
		this.probabilityvalue.ifPresent(field -> {
			builder.append(PROBABILITYVALUE__NAME);
			builder.append(" => ");
			builder.append(field);
			builder.append(';');
		});
		this.occurrencerate.ifPresent(field -> {
			builder.append(OCCURRENCERATE__NAME);
			builder.append(" => ");
			builder.append(field);
			builder.append(';');
		});
		this.meanvalue.ifPresent(field -> {
			builder.append(MEANVALUE__NAME);
			builder.append(" => ");
			builder.append(field);
			builder.append(';');
		});
		this.standarddeviation.ifPresent(field -> {
			builder.append(STANDARDDEVIATION__NAME);
			builder.append(" => ");
			builder.append(field);
			builder.append(';');
		});
		this.shapeparameter.ifPresent(field -> {
			builder.append(SHAPEPARAMETER__NAME);
			builder.append(" => ");
			builder.append(field);
			builder.append(';');
		});
		this.scaleparameter.ifPresent(field -> {
			builder.append(SCALEPARAMETER__NAME);
			builder.append(" => ");
			builder.append(field);
			builder.append(';');
		});
		this.successcount.ifPresent(field -> {
			builder.append(SUCCESSCOUNT__NAME);
			builder.append(" => ");
			builder.append(field);
			builder.append(';');
		});
		this.samplecount.ifPresent(field -> {
			builder.append(SAMPLECOUNT__NAME);
			builder.append(" => ");
			builder.append(field);
			builder.append(';');
		});
		this.probability.ifPresent(field -> {
			builder.append(PROBABILITY__NAME);
			builder.append(" => ");
			builder.append(field);
			builder.append(';');
		});
		this.distribution.ifPresent(field -> {
			builder.append(DISTRIBUTION__NAME);
			builder.append(" => ");
			builder.append(field);
			builder.append(';');
		});
		builder.append(']');
		return builder.toString();
	}
}
