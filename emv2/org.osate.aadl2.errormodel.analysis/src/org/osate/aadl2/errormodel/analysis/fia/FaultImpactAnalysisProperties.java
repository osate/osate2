package org.osate.aadl2.errormodel.analysis.fia;

import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
import org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.pluginsupport.properties.CodeGenUtil;

/**
 * @since 1.2
 */
public final class FaultImpactAnalysisProperties {
	public static final String FAULTIMPACTANALYSISPROPERTIES__NAME = "FaultImpactAnalysisProperties";

	private FaultImpactAnalysisProperties() {}

	// Lookup methods for FaultImpactAnalysisProperties::Acceptable

	public static final String ACCEPTABLE__NAME = "Acceptable";

	public static boolean acceptsAcceptable(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getAcceptable_Property(lookupContext));
	}

	public static Optional<Boolean> getAcceptable(NamedElement lookupContext) {
		return getAcceptable(lookupContext, Optional.empty());
	}

	public static Optional<Boolean> getAcceptable(NamedElement lookupContext, Mode mode) {
		return getAcceptable(lookupContext, Optional.of(mode));
	}

	public static Optional<Boolean> getAcceptable(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getAcceptable_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((BooleanLiteral) resolved).getValue());
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}

	public static Property getAcceptable_Property(EObject lookupContext) {
		String name = FAULTIMPACTANALYSISPROPERTIES__NAME + "::" + ACCEPTABLE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}

	public static PropertyExpression getAcceptable_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getAcceptable_Property(lookupContext));
	}
}
