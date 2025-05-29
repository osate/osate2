/*******************************************************************************
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party beneficiaries
 * to this license with respect to the terms applicable to their Third Party Software. Third Party Software licenses
 * only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 *******************************************************************************/
package org.osate.contribution.sei.physical;

import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
import org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.pluginsupport.properties.CodeGenUtil;
import org.osate.pluginsupport.properties.RealWithUnits;

public final class Physical {
	public static final String PHYSICAL__NAME = "Physical";
	
	private Physical() {}
	
	// Lookup methods for Physical::Voltage
	
	public static final String VOLTAGE__NAME = "Voltage";
	
	public static boolean acceptsVoltage(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getVoltage_Property(lookupContext));
	}
	
	public static Optional<RealWithUnits<VoltageUnits>> getVoltage(NamedElement lookupContext) {
		return getVoltage(lookupContext, Optional.empty());
	}
	
	public static Optional<RealWithUnits<VoltageUnits>> getVoltage(NamedElement lookupContext, Mode mode) {
		return getVoltage(lookupContext, Optional.of(mode));
	}
	
	public static Optional<RealWithUnits<VoltageUnits>> getVoltage(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getVoltage_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RealWithUnits<>(resolved, VoltageUnits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getVoltage_Property(EObject lookupContext) {
		String name = PHYSICAL__NAME + "::" + VOLTAGE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getVoltage_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getVoltage_Property(lookupContext));
	}
}
