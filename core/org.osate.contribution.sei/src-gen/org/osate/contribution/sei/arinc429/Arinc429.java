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

public class Arinc429 {
	public static final String ARINC429__NAME = "ARINC429";
	
	public static final String WORDID__NAME = "WordID";
	public static final String FIRSTBIT__NAME = "FirstBit";
	public static final String NUMBERBITS__NAME = "NumberBits";
	
	// Lookup methods for ARINC429::WordID
	
	public static boolean acceptsWordid(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getWordid_Property(lookupContext));
	}
	
	public static OptionalLong getWordid(NamedElement lookupContext) {
		return getWordid(lookupContext, Optional.empty());
	}
	
	public static OptionalLong getWordid(NamedElement lookupContext, Mode mode) {
		return getWordid(lookupContext, Optional.of(mode));
	}
	
	public static OptionalLong getWordid(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getWordid_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalLong.of(((IntegerLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return OptionalLong.empty();
		}
	}
	
	public static Property getWordid_Property(NamedElement lookupContext) {
		String name = ARINC429__NAME + "::" + WORDID__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getWordid_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getWordid_Property(lookupContext));
	}
	
	// Lookup methods for ARINC429::FirstBit
	
	public static boolean acceptsFirstbit(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getFirstbit_Property(lookupContext));
	}
	
	public static OptionalLong getFirstbit(NamedElement lookupContext) {
		return getFirstbit(lookupContext, Optional.empty());
	}
	
	public static OptionalLong getFirstbit(NamedElement lookupContext, Mode mode) {
		return getFirstbit(lookupContext, Optional.of(mode));
	}
	
	public static OptionalLong getFirstbit(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getFirstbit_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalLong.of(((IntegerLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return OptionalLong.empty();
		}
	}
	
	public static Property getFirstbit_Property(NamedElement lookupContext) {
		String name = ARINC429__NAME + "::" + FIRSTBIT__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getFirstbit_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getFirstbit_Property(lookupContext));
	}
	
	// Lookup methods for ARINC429::NumberBits
	
	public static boolean acceptsNumberbits(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getNumberbits_Property(lookupContext));
	}
	
	public static OptionalLong getNumberbits(NamedElement lookupContext) {
		return getNumberbits(lookupContext, Optional.empty());
	}
	
	public static OptionalLong getNumberbits(NamedElement lookupContext, Mode mode) {
		return getNumberbits(lookupContext, Optional.of(mode));
	}
	
	public static OptionalLong getNumberbits(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getNumberbits_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalLong.of(((IntegerLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return OptionalLong.empty();
		}
	}
	
	public static Property getNumberbits_Property(NamedElement lookupContext) {
		String name = ARINC429__NAME + "::" + NUMBERBITS__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getNumberbits_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getNumberbits_Property(lookupContext));
	}
}
