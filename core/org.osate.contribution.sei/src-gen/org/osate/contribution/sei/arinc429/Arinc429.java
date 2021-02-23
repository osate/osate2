package org.osate.contribution.sei.arinc429;

import java.util.Optional;
import java.util.OptionalLong;

import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.pluginsupport.properties.CodeGenUtil;

/**
 * @since 1.2
 */
public class Arinc429 {
	public static final String ARINC429__NAME = "ARINC429";

	public static final String WORDID__NAME = "WordID";
	public static final String FIRSTBIT__NAME = "FirstBit";
	public static final String NUMBERBITS__NAME = "NumberBits";

	public static OptionalLong getWordid(NamedElement lookupContext) {
		return getWordid(lookupContext, Optional.empty());
	}

	public static OptionalLong getWordid(NamedElement lookupContext, Mode mode) {
		return getWordid(lookupContext, Optional.of(mode));
	}

	public static OptionalLong getWordid(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "ARINC429::WordID";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalLong.of(((IntegerLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return OptionalLong.empty();
		}
	}

	public static PropertyExpression getWordid_EObject(NamedElement lookupContext) {
		String name = "ARINC429::WordID";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static OptionalLong getFirstbit(NamedElement lookupContext) {
		return getFirstbit(lookupContext, Optional.empty());
	}

	public static OptionalLong getFirstbit(NamedElement lookupContext, Mode mode) {
		return getFirstbit(lookupContext, Optional.of(mode));
	}

	public static OptionalLong getFirstbit(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "ARINC429::FirstBit";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalLong.of(((IntegerLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return OptionalLong.empty();
		}
	}

	public static PropertyExpression getFirstbit_EObject(NamedElement lookupContext) {
		String name = "ARINC429::FirstBit";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static OptionalLong getNumberbits(NamedElement lookupContext) {
		return getNumberbits(lookupContext, Optional.empty());
	}

	public static OptionalLong getNumberbits(NamedElement lookupContext, Mode mode) {
		return getNumberbits(lookupContext, Optional.of(mode));
	}

	public static OptionalLong getNumberbits(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "ARINC429::NumberBits";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalLong.of(((IntegerLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return OptionalLong.empty();
		}
	}

	public static PropertyExpression getNumberbits_EObject(NamedElement lookupContext) {
		String name = "ARINC429::NumberBits";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
}
