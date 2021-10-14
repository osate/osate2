package org.osate.aadl2.errormodel.contrib.emv2;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalLong;
import java.util.stream.Collectors;

import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.pluginsupport.properties.CodeGenUtil;

public class Emv2 {
	public static final String EMV2__NAME = "EMV2";
	
	public static final String OCCURRENCEDISTRIBUTION__NAME = "OccurrenceDistribution";
	public static final String EXPOSUREPERIOD__NAME = "ExposurePeriod";
	public static final String DURATIONDISTRIBUTION__NAME = "DurationDistribution";
	public static final String PROPAGATIONTIMEDELAY__NAME = "PropagationTimeDelay";
	public static final String TRANSIENTFAILURERATIO__NAME = "TransientFailureRatio";
	public static final String RECOVERYFAILURERATIO__NAME = "RecoveryFailureRatio";
	public static final String STATEKIND__NAME = "StateKind";
	public static final String DETECTIONMECHANISM__NAME = "DetectionMechanism";
	public static final String FAULTKIND__NAME = "FaultKind";
	public static final String PERSISTENCE__NAME = "Persistence";
	public static final String SEVERITY__NAME = "Severity";
	public static final String LIKELIHOOD__NAME = "Likelihood";
	public static final String HAZARDS__NAME = "Hazards";
	public static final String DESCRIPTION__NAME = "Description";
	public static final String HAZARDALLOCATION__NAME = "HazardAllocation";
	
	public static Optional<Distributionspecification> getOccurrencedistribution(NamedElement lookupContext) {
		return getOccurrencedistribution(lookupContext, Optional.empty());
	}
	
	public static Optional<Distributionspecification> getOccurrencedistribution(NamedElement lookupContext, Mode mode) {
		return getOccurrencedistribution(lookupContext, Optional.of(mode));
	}
	
	public static Optional<Distributionspecification> getOccurrencedistribution(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "EMV2::OccurrenceDistribution";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new Distributionspecification(resolved, lookupContext, mode));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getOccurrencedistribution_EObject(NamedElement lookupContext) {
		String name = "EMV2::OccurrenceDistribution";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static OptionalDouble getExposureperiod(NamedElement lookupContext) {
		return getExposureperiod(lookupContext, Optional.empty());
	}
	
	public static OptionalDouble getExposureperiod(NamedElement lookupContext, Mode mode) {
		return getExposureperiod(lookupContext, Optional.of(mode));
	}
	
	public static OptionalDouble getExposureperiod(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "EMV2::ExposurePeriod";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalDouble.of(((RealLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return OptionalDouble.empty();
		}
	}
	
	public static PropertyExpression getExposureperiod_EObject(NamedElement lookupContext) {
		String name = "EMV2::ExposurePeriod";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<Durationdistributionspecification> getDurationdistribution(NamedElement lookupContext) {
		return getDurationdistribution(lookupContext, Optional.empty());
	}
	
	public static Optional<Durationdistributionspecification> getDurationdistribution(NamedElement lookupContext, Mode mode) {
		return getDurationdistribution(lookupContext, Optional.of(mode));
	}
	
	public static Optional<Durationdistributionspecification> getDurationdistribution(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "EMV2::DurationDistribution";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new Durationdistributionspecification(resolved, lookupContext, mode));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getDurationdistribution_EObject(NamedElement lookupContext) {
		String name = "EMV2::DurationDistribution";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<Durationdistributionspecification> getPropagationtimedelay(NamedElement lookupContext) {
		return getPropagationtimedelay(lookupContext, Optional.empty());
	}
	
	public static Optional<Durationdistributionspecification> getPropagationtimedelay(NamedElement lookupContext, Mode mode) {
		return getPropagationtimedelay(lookupContext, Optional.of(mode));
	}
	
	public static Optional<Durationdistributionspecification> getPropagationtimedelay(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "EMV2::PropagationTimeDelay";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new Durationdistributionspecification(resolved, lookupContext, mode));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getPropagationtimedelay_EObject(NamedElement lookupContext) {
		String name = "EMV2::PropagationTimeDelay";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static OptionalDouble getTransientfailureratio(NamedElement lookupContext) {
		return getTransientfailureratio(lookupContext, Optional.empty());
	}
	
	public static OptionalDouble getTransientfailureratio(NamedElement lookupContext, Mode mode) {
		return getTransientfailureratio(lookupContext, Optional.of(mode));
	}
	
	public static OptionalDouble getTransientfailureratio(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "EMV2::TransientFailureRatio";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalDouble.of(((RealLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return OptionalDouble.empty();
		}
	}
	
	public static PropertyExpression getTransientfailureratio_EObject(NamedElement lookupContext) {
		String name = "EMV2::TransientFailureRatio";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static OptionalDouble getRecoveryfailureratio(NamedElement lookupContext) {
		return getRecoveryfailureratio(lookupContext, Optional.empty());
	}
	
	public static OptionalDouble getRecoveryfailureratio(NamedElement lookupContext, Mode mode) {
		return getRecoveryfailureratio(lookupContext, Optional.of(mode));
	}
	
	public static OptionalDouble getRecoveryfailureratio(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "EMV2::RecoveryFailureRatio";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalDouble.of(((RealLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return OptionalDouble.empty();
		}
	}
	
	public static PropertyExpression getRecoveryfailureratio_EObject(NamedElement lookupContext) {
		String name = "EMV2::RecoveryFailureRatio";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<Statekindenum> getStatekind(NamedElement lookupContext) {
		return getStatekind(lookupContext, Optional.empty());
	}
	
	public static Optional<Statekindenum> getStatekind(NamedElement lookupContext, Mode mode) {
		return getStatekind(lookupContext, Optional.of(mode));
	}
	
	public static Optional<Statekindenum> getStatekind(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "EMV2::StateKind";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(Statekindenum.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getStatekind_EObject(NamedElement lookupContext) {
		String name = "EMV2::StateKind";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<String> getDetectionmechanism(NamedElement lookupContext) {
		return getDetectionmechanism(lookupContext, Optional.empty());
	}
	
	public static Optional<String> getDetectionmechanism(NamedElement lookupContext, Mode mode) {
		return getDetectionmechanism(lookupContext, Optional.of(mode));
	}
	
	public static Optional<String> getDetectionmechanism(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "EMV2::DetectionMechanism";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((StringLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getDetectionmechanism_EObject(NamedElement lookupContext) {
		String name = "EMV2::DetectionMechanism";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<Faultkindenum> getFaultkind(NamedElement lookupContext) {
		return getFaultkind(lookupContext, Optional.empty());
	}
	
	public static Optional<Faultkindenum> getFaultkind(NamedElement lookupContext, Mode mode) {
		return getFaultkind(lookupContext, Optional.of(mode));
	}
	
	public static Optional<Faultkindenum> getFaultkind(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "EMV2::FaultKind";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(Faultkindenum.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getFaultkind_EObject(NamedElement lookupContext) {
		String name = "EMV2::FaultKind";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<Persistenceenum> getPersistence(NamedElement lookupContext) {
		return getPersistence(lookupContext, Optional.empty());
	}
	
	public static Optional<Persistenceenum> getPersistence(NamedElement lookupContext, Mode mode) {
		return getPersistence(lookupContext, Optional.of(mode));
	}
	
	public static Optional<Persistenceenum> getPersistence(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "EMV2::Persistence";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(Persistenceenum.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getPersistence_EObject(NamedElement lookupContext) {
		String name = "EMV2::Persistence";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static OptionalLong getSeverity(NamedElement lookupContext) {
		return getSeverity(lookupContext, Optional.empty());
	}
	
	public static OptionalLong getSeverity(NamedElement lookupContext, Mode mode) {
		return getSeverity(lookupContext, Optional.of(mode));
	}
	
	public static OptionalLong getSeverity(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "EMV2::Severity";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalLong.of(((IntegerLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return OptionalLong.empty();
		}
	}
	
	public static PropertyExpression getSeverity_EObject(NamedElement lookupContext) {
		String name = "EMV2::Severity";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<Likelihoodlabels> getLikelihood(NamedElement lookupContext) {
		return getLikelihood(lookupContext, Optional.empty());
	}
	
	public static Optional<Likelihoodlabels> getLikelihood(NamedElement lookupContext, Mode mode) {
		return getLikelihood(lookupContext, Optional.of(mode));
	}
	
	public static Optional<Likelihoodlabels> getLikelihood(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "EMV2::Likelihood";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(Likelihoodlabels.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getLikelihood_EObject(NamedElement lookupContext) {
		String name = "EMV2::Likelihood";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<List<Hazards>> getHazards(NamedElement lookupContext) {
		return getHazards(lookupContext, Optional.empty());
	}
	
	public static Optional<List<Hazards>> getHazards(NamedElement lookupContext, Mode mode) {
		return getHazards(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<Hazards>> getHazards(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "EMV2::Hazards";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return new Hazards(resolved1, lookupContext, mode);
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getHazards_EObject(NamedElement lookupContext) {
		String name = "EMV2::Hazards";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<String> getDescription(NamedElement lookupContext) {
		return getDescription(lookupContext, Optional.empty());
	}
	
	public static Optional<String> getDescription(NamedElement lookupContext, Mode mode) {
		return getDescription(lookupContext, Optional.of(mode));
	}
	
	public static Optional<String> getDescription(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "EMV2::Description";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((StringLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getDescription_EObject(NamedElement lookupContext) {
		String name = "EMV2::Description";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<Hazardallocation> getHazardallocation(NamedElement lookupContext) {
		return getHazardallocation(lookupContext, Optional.empty());
	}
	
	public static Optional<Hazardallocation> getHazardallocation(NamedElement lookupContext, Mode mode) {
		return getHazardallocation(lookupContext, Optional.of(mode));
	}
	
	public static Optional<Hazardallocation> getHazardallocation(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "EMV2::HazardAllocation";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new Hazardallocation(resolved, lookupContext, mode));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getHazardallocation_EObject(NamedElement lookupContext) {
		String name = "EMV2::HazardAllocation";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
}
