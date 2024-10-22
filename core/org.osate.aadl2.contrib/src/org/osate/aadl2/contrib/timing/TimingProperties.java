/*******************************************************************************
 * Copyright (c) 2004-2024 Carnegie Mellon University and others. (see Contributors file). 
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
package org.osate.aadl2.contrib.timing;

import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.contrib.aadlproject.ProcessorSpeedUnits;
import org.osate.aadl2.contrib.aadlproject.TimeUnits;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.InstanceReferenceValue;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
import org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.pluginsupport.properties.CodeGenUtil;
import org.osate.pluginsupport.properties.IntegerRangeWithUnits;
import org.osate.pluginsupport.properties.IntegerWithUnits;
import org.osate.pluginsupport.properties.RealWithUnits;

public final class TimingProperties {
	public static final String TIMING_PROPERTIES__NAME = "Timing_Properties";
	
	private TimingProperties() {}
	
	// Lookup methods for Timing_Properties::Activate_Deadline
	
	public static final String ACTIVATE_DEADLINE__NAME = "Activate_Deadline";
	
	public static boolean acceptsActivateDeadline(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getActivateDeadline_Property(lookupContext));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getActivateDeadline(NamedElement lookupContext) {
		return getActivateDeadline(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getActivateDeadline(NamedElement lookupContext, Mode mode) {
		return getActivateDeadline(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getActivateDeadline(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getActivateDeadline_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getActivateDeadline_Property(EObject lookupContext) {
		String name = TIMING_PROPERTIES__NAME + "::" + ACTIVATE_DEADLINE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getActivateDeadline_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getActivateDeadline_Property(lookupContext));
	}
	
	// Lookup methods for Timing_Properties::Activate_Execution_Time
	
	public static final String ACTIVATE_EXECUTION_TIME__NAME = "Activate_Execution_Time";
	
	public static boolean acceptsActivateExecutionTime(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getActivateExecutionTime_Property(lookupContext));
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getActivateExecutionTime(NamedElement lookupContext) {
		return getActivateExecutionTime(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getActivateExecutionTime(NamedElement lookupContext, Mode mode) {
		return getActivateExecutionTime(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getActivateExecutionTime(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getActivateExecutionTime_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerRangeWithUnits<>(resolved, TimeUnits.class, lookupContext, mode));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getActivateExecutionTime_Property(EObject lookupContext) {
		String name = TIMING_PROPERTIES__NAME + "::" + ACTIVATE_EXECUTION_TIME__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getActivateExecutionTime_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getActivateExecutionTime_Property(lookupContext));
	}
	
	// Lookup methods for Timing_Properties::Compute_Deadline
	
	public static final String COMPUTE_DEADLINE__NAME = "Compute_Deadline";
	
	public static boolean acceptsComputeDeadline(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getComputeDeadline_Property(lookupContext));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getComputeDeadline(NamedElement lookupContext) {
		return getComputeDeadline(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getComputeDeadline(NamedElement lookupContext, Mode mode) {
		return getComputeDeadline(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getComputeDeadline(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getComputeDeadline_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getComputeDeadline_Property(EObject lookupContext) {
		String name = TIMING_PROPERTIES__NAME + "::" + COMPUTE_DEADLINE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getComputeDeadline_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getComputeDeadline_Property(lookupContext));
	}
	
	// Lookup methods for Timing_Properties::Compute_Execution_Time
	
	public static final String COMPUTE_EXECUTION_TIME__NAME = "Compute_Execution_Time";
	
	public static boolean acceptsComputeExecutionTime(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getComputeExecutionTime_Property(lookupContext));
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getComputeExecutionTime(NamedElement lookupContext) {
		return getComputeExecutionTime(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getComputeExecutionTime(NamedElement lookupContext, Mode mode) {
		return getComputeExecutionTime(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getComputeExecutionTime(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getComputeExecutionTime_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerRangeWithUnits<>(resolved, TimeUnits.class, lookupContext, mode));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getComputeExecutionTime_Property(EObject lookupContext) {
		String name = TIMING_PROPERTIES__NAME + "::" + COMPUTE_EXECUTION_TIME__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getComputeExecutionTime_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getComputeExecutionTime_Property(lookupContext));
	}
	
	// Lookup methods for Timing_Properties::Client_Subprogram_Execution_Time
	
	public static final String CLIENT_SUBPROGRAM_EXECUTION_TIME__NAME = "Client_Subprogram_Execution_Time";
	
	public static boolean acceptsClientSubprogramExecutionTime(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getClientSubprogramExecutionTime_Property(lookupContext));
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getClientSubprogramExecutionTime(NamedElement lookupContext) {
		return getClientSubprogramExecutionTime(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getClientSubprogramExecutionTime(NamedElement lookupContext, Mode mode) {
		return getClientSubprogramExecutionTime(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getClientSubprogramExecutionTime(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getClientSubprogramExecutionTime_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerRangeWithUnits<>(resolved, TimeUnits.class, lookupContext, mode));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getClientSubprogramExecutionTime_Property(EObject lookupContext) {
		String name = TIMING_PROPERTIES__NAME + "::" + CLIENT_SUBPROGRAM_EXECUTION_TIME__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getClientSubprogramExecutionTime_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getClientSubprogramExecutionTime_Property(lookupContext));
	}
	
	// Lookup methods for Timing_Properties::Deactivate_Deadline
	
	public static final String DEACTIVATE_DEADLINE__NAME = "Deactivate_Deadline";
	
	public static boolean acceptsDeactivateDeadline(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getDeactivateDeadline_Property(lookupContext));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getDeactivateDeadline(NamedElement lookupContext) {
		return getDeactivateDeadline(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getDeactivateDeadline(NamedElement lookupContext, Mode mode) {
		return getDeactivateDeadline(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getDeactivateDeadline(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getDeactivateDeadline_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getDeactivateDeadline_Property(EObject lookupContext) {
		String name = TIMING_PROPERTIES__NAME + "::" + DEACTIVATE_DEADLINE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getDeactivateDeadline_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getDeactivateDeadline_Property(lookupContext));
	}
	
	// Lookup methods for Timing_Properties::Deactivate_Execution_Time
	
	public static final String DEACTIVATE_EXECUTION_TIME__NAME = "Deactivate_Execution_Time";
	
	public static boolean acceptsDeactivateExecutionTime(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getDeactivateExecutionTime_Property(lookupContext));
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getDeactivateExecutionTime(NamedElement lookupContext) {
		return getDeactivateExecutionTime(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getDeactivateExecutionTime(NamedElement lookupContext, Mode mode) {
		return getDeactivateExecutionTime(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getDeactivateExecutionTime(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getDeactivateExecutionTime_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerRangeWithUnits<>(resolved, TimeUnits.class, lookupContext, mode));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getDeactivateExecutionTime_Property(EObject lookupContext) {
		String name = TIMING_PROPERTIES__NAME + "::" + DEACTIVATE_EXECUTION_TIME__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getDeactivateExecutionTime_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getDeactivateExecutionTime_Property(lookupContext));
	}
	
	// Lookup methods for Timing_Properties::Deadline
	
	public static final String DEADLINE__NAME = "Deadline";
	
	public static boolean acceptsDeadline(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getDeadline_Property(lookupContext));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getDeadline(NamedElement lookupContext) {
		return getDeadline(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getDeadline(NamedElement lookupContext, Mode mode) {
		return getDeadline(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getDeadline(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getDeadline_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getDeadline_Property(EObject lookupContext) {
		String name = TIMING_PROPERTIES__NAME + "::" + DEADLINE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getDeadline_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getDeadline_Property(lookupContext));
	}
	
	// Lookup methods for Timing_Properties::First_Dispatch_Time
	
	public static final String FIRST_DISPATCH_TIME__NAME = "First_Dispatch_Time";
	
	public static boolean acceptsFirstDispatchTime(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getFirstDispatchTime_Property(lookupContext));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getFirstDispatchTime(NamedElement lookupContext) {
		return getFirstDispatchTime(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getFirstDispatchTime(NamedElement lookupContext, Mode mode) {
		return getFirstDispatchTime(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getFirstDispatchTime(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getFirstDispatchTime_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getFirstDispatchTime_Property(EObject lookupContext) {
		String name = TIMING_PROPERTIES__NAME + "::" + FIRST_DISPATCH_TIME__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getFirstDispatchTime_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getFirstDispatchTime_Property(lookupContext));
	}
	
	// Lookup methods for Timing_Properties::Dispatch_Jitter
	
	public static final String DISPATCH_JITTER__NAME = "Dispatch_Jitter";
	
	public static boolean acceptsDispatchJitter(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getDispatchJitter_Property(lookupContext));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getDispatchJitter(NamedElement lookupContext) {
		return getDispatchJitter(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getDispatchJitter(NamedElement lookupContext, Mode mode) {
		return getDispatchJitter(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getDispatchJitter(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getDispatchJitter_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getDispatchJitter_Property(EObject lookupContext) {
		String name = TIMING_PROPERTIES__NAME + "::" + DISPATCH_JITTER__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getDispatchJitter_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getDispatchJitter_Property(lookupContext));
	}
	
	// Lookup methods for Timing_Properties::Dispatch_Offset
	
	public static final String DISPATCH_OFFSET__NAME = "Dispatch_Offset";
	
	public static boolean acceptsDispatchOffset(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getDispatchOffset_Property(lookupContext));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getDispatchOffset(NamedElement lookupContext) {
		return getDispatchOffset(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getDispatchOffset(NamedElement lookupContext, Mode mode) {
		return getDispatchOffset(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getDispatchOffset(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getDispatchOffset_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getDispatchOffset_Property(EObject lookupContext) {
		String name = TIMING_PROPERTIES__NAME + "::" + DISPATCH_OFFSET__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getDispatchOffset_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getDispatchOffset_Property(lookupContext));
	}
	
	// Lookup methods for Timing_Properties::Execution_Time
	
	public static final String EXECUTION_TIME__NAME = "Execution_Time";
	
	public static boolean acceptsExecutionTime(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getExecutionTime_Property(lookupContext));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getExecutionTime(NamedElement lookupContext) {
		return getExecutionTime(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getExecutionTime(NamedElement lookupContext, Mode mode) {
		return getExecutionTime(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getExecutionTime(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getExecutionTime_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getExecutionTime_Property(EObject lookupContext) {
		String name = TIMING_PROPERTIES__NAME + "::" + EXECUTION_TIME__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getExecutionTime_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getExecutionTime_Property(lookupContext));
	}
	
	// Lookup methods for Timing_Properties::Finalize_Deadline
	
	public static final String FINALIZE_DEADLINE__NAME = "Finalize_Deadline";
	
	public static boolean acceptsFinalizeDeadline(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getFinalizeDeadline_Property(lookupContext));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getFinalizeDeadline(NamedElement lookupContext) {
		return getFinalizeDeadline(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getFinalizeDeadline(NamedElement lookupContext, Mode mode) {
		return getFinalizeDeadline(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getFinalizeDeadline(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getFinalizeDeadline_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getFinalizeDeadline_Property(EObject lookupContext) {
		String name = TIMING_PROPERTIES__NAME + "::" + FINALIZE_DEADLINE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getFinalizeDeadline_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getFinalizeDeadline_Property(lookupContext));
	}
	
	// Lookup methods for Timing_Properties::Finalize_Execution_Time
	
	public static final String FINALIZE_EXECUTION_TIME__NAME = "Finalize_Execution_Time";
	
	public static boolean acceptsFinalizeExecutionTime(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getFinalizeExecutionTime_Property(lookupContext));
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getFinalizeExecutionTime(NamedElement lookupContext) {
		return getFinalizeExecutionTime(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getFinalizeExecutionTime(NamedElement lookupContext, Mode mode) {
		return getFinalizeExecutionTime(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getFinalizeExecutionTime(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getFinalizeExecutionTime_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerRangeWithUnits<>(resolved, TimeUnits.class, lookupContext, mode));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getFinalizeExecutionTime_Property(EObject lookupContext) {
		String name = TIMING_PROPERTIES__NAME + "::" + FINALIZE_EXECUTION_TIME__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getFinalizeExecutionTime_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getFinalizeExecutionTime_Property(lookupContext));
	}
	
	// Lookup methods for Timing_Properties::Initialize_Deadline
	
	public static final String INITIALIZE_DEADLINE__NAME = "Initialize_Deadline";
	
	public static boolean acceptsInitializeDeadline(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getInitializeDeadline_Property(lookupContext));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getInitializeDeadline(NamedElement lookupContext) {
		return getInitializeDeadline(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getInitializeDeadline(NamedElement lookupContext, Mode mode) {
		return getInitializeDeadline(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getInitializeDeadline(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getInitializeDeadline_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getInitializeDeadline_Property(EObject lookupContext) {
		String name = TIMING_PROPERTIES__NAME + "::" + INITIALIZE_DEADLINE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getInitializeDeadline_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getInitializeDeadline_Property(lookupContext));
	}
	
	// Lookup methods for Timing_Properties::Initialize_Execution_Time
	
	public static final String INITIALIZE_EXECUTION_TIME__NAME = "Initialize_Execution_Time";
	
	public static boolean acceptsInitializeExecutionTime(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getInitializeExecutionTime_Property(lookupContext));
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getInitializeExecutionTime(NamedElement lookupContext) {
		return getInitializeExecutionTime(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getInitializeExecutionTime(NamedElement lookupContext, Mode mode) {
		return getInitializeExecutionTime(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getInitializeExecutionTime(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getInitializeExecutionTime_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerRangeWithUnits<>(resolved, TimeUnits.class, lookupContext, mode));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getInitializeExecutionTime_Property(EObject lookupContext) {
		String name = TIMING_PROPERTIES__NAME + "::" + INITIALIZE_EXECUTION_TIME__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getInitializeExecutionTime_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getInitializeExecutionTime_Property(lookupContext));
	}
	
	// Lookup methods for Timing_Properties::Load_Deadline
	
	public static final String LOAD_DEADLINE__NAME = "Load_Deadline";
	
	public static boolean acceptsLoadDeadline(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getLoadDeadline_Property(lookupContext));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getLoadDeadline(NamedElement lookupContext) {
		return getLoadDeadline(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getLoadDeadline(NamedElement lookupContext, Mode mode) {
		return getLoadDeadline(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getLoadDeadline(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getLoadDeadline_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getLoadDeadline_Property(EObject lookupContext) {
		String name = TIMING_PROPERTIES__NAME + "::" + LOAD_DEADLINE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getLoadDeadline_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getLoadDeadline_Property(lookupContext));
	}
	
	// Lookup methods for Timing_Properties::Load_Time
	
	public static final String LOAD_TIME__NAME = "Load_Time";
	
	public static boolean acceptsLoadTime(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getLoadTime_Property(lookupContext));
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getLoadTime(NamedElement lookupContext) {
		return getLoadTime(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getLoadTime(NamedElement lookupContext, Mode mode) {
		return getLoadTime(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getLoadTime(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getLoadTime_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerRangeWithUnits<>(resolved, TimeUnits.class, lookupContext, mode));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getLoadTime_Property(EObject lookupContext) {
		String name = TIMING_PROPERTIES__NAME + "::" + LOAD_TIME__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getLoadTime_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getLoadTime_Property(lookupContext));
	}
	
	// Lookup methods for Timing_Properties::Processor_Capacity
	
	public static final String PROCESSOR_CAPACITY__NAME = "Processor_Capacity";
	
	public static boolean acceptsProcessorCapacity(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getProcessorCapacity_Property(lookupContext));
	}
	
	public static Optional<RealWithUnits<ProcessorSpeedUnits>> getProcessorCapacity(NamedElement lookupContext) {
		return getProcessorCapacity(lookupContext, Optional.empty());
	}
	
	public static Optional<RealWithUnits<ProcessorSpeedUnits>> getProcessorCapacity(NamedElement lookupContext, Mode mode) {
		return getProcessorCapacity(lookupContext, Optional.of(mode));
	}
	
	public static Optional<RealWithUnits<ProcessorSpeedUnits>> getProcessorCapacity(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getProcessorCapacity_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RealWithUnits<>(resolved, ProcessorSpeedUnits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getProcessorCapacity_Property(EObject lookupContext) {
		String name = TIMING_PROPERTIES__NAME + "::" + PROCESSOR_CAPACITY__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getProcessorCapacity_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getProcessorCapacity_Property(lookupContext));
	}
	
	// Lookup methods for Timing_Properties::Period
	
	public static final String PERIOD__NAME = "Period";
	
	public static boolean acceptsPeriod(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getPeriod_Property(lookupContext));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getPeriod(NamedElement lookupContext) {
		return getPeriod(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getPeriod(NamedElement lookupContext, Mode mode) {
		return getPeriod(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getPeriod(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getPeriod_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getPeriod_Property(EObject lookupContext) {
		String name = TIMING_PROPERTIES__NAME + "::" + PERIOD__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getPeriod_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getPeriod_Property(lookupContext));
	}
	
	// Lookup methods for Timing_Properties::Recover_Deadline
	
	public static final String RECOVER_DEADLINE__NAME = "Recover_Deadline";
	
	public static boolean acceptsRecoverDeadline(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getRecoverDeadline_Property(lookupContext));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getRecoverDeadline(NamedElement lookupContext) {
		return getRecoverDeadline(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getRecoverDeadline(NamedElement lookupContext, Mode mode) {
		return getRecoverDeadline(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getRecoverDeadline(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getRecoverDeadline_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getRecoverDeadline_Property(EObject lookupContext) {
		String name = TIMING_PROPERTIES__NAME + "::" + RECOVER_DEADLINE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getRecoverDeadline_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getRecoverDeadline_Property(lookupContext));
	}
	
	// Lookup methods for Timing_Properties::Recover_Execution_Time
	
	public static final String RECOVER_EXECUTION_TIME__NAME = "Recover_Execution_Time";
	
	public static boolean acceptsRecoverExecutionTime(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getRecoverExecutionTime_Property(lookupContext));
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getRecoverExecutionTime(NamedElement lookupContext) {
		return getRecoverExecutionTime(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getRecoverExecutionTime(NamedElement lookupContext, Mode mode) {
		return getRecoverExecutionTime(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getRecoverExecutionTime(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getRecoverExecutionTime_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerRangeWithUnits<>(resolved, TimeUnits.class, lookupContext, mode));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getRecoverExecutionTime_Property(EObject lookupContext) {
		String name = TIMING_PROPERTIES__NAME + "::" + RECOVER_EXECUTION_TIME__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getRecoverExecutionTime_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getRecoverExecutionTime_Property(lookupContext));
	}
	
	// Lookup methods for Timing_Properties::Reference_Time
	
	public static final String REFERENCE_TIME__NAME = "Reference_Time";
	
	public static boolean acceptsReferenceTime(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getReferenceTime_Property(lookupContext));
	}
	
	public static Optional<InstanceObject> getReferenceTime(NamedElement lookupContext) {
		return getReferenceTime(lookupContext, Optional.empty());
	}
	
	public static Optional<InstanceObject> getReferenceTime(NamedElement lookupContext, Mode mode) {
		return getReferenceTime(lookupContext, Optional.of(mode));
	}
	
	public static Optional<InstanceObject> getReferenceTime(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getReferenceTime_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((InstanceReferenceValue) resolved).getReferencedInstanceObject());
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getReferenceTime_Property(EObject lookupContext) {
		String name = TIMING_PROPERTIES__NAME + "::" + REFERENCE_TIME__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getReferenceTime_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getReferenceTime_Property(lookupContext));
	}
	
	// Lookup methods for Timing_Properties::Startup_Deadline
	
	public static final String STARTUP_DEADLINE__NAME = "Startup_Deadline";
	
	public static boolean acceptsStartupDeadline(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getStartupDeadline_Property(lookupContext));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getStartupDeadline(NamedElement lookupContext) {
		return getStartupDeadline(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getStartupDeadline(NamedElement lookupContext, Mode mode) {
		return getStartupDeadline(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getStartupDeadline(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getStartupDeadline_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getStartupDeadline_Property(EObject lookupContext) {
		String name = TIMING_PROPERTIES__NAME + "::" + STARTUP_DEADLINE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getStartupDeadline_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getStartupDeadline_Property(lookupContext));
	}
	
	// Lookup methods for Timing_Properties::Startup_Execution_Time
	
	public static final String STARTUP_EXECUTION_TIME__NAME = "Startup_Execution_Time";
	
	public static boolean acceptsStartupExecutionTime(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getStartupExecutionTime_Property(lookupContext));
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getStartupExecutionTime(NamedElement lookupContext) {
		return getStartupExecutionTime(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getStartupExecutionTime(NamedElement lookupContext, Mode mode) {
		return getStartupExecutionTime(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getStartupExecutionTime(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getStartupExecutionTime_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerRangeWithUnits<>(resolved, TimeUnits.class, lookupContext, mode));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getStartupExecutionTime_Property(EObject lookupContext) {
		String name = TIMING_PROPERTIES__NAME + "::" + STARTUP_EXECUTION_TIME__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getStartupExecutionTime_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getStartupExecutionTime_Property(lookupContext));
	}
	
	// Lookup methods for Timing_Properties::Clock_Jitter
	
	public static final String CLOCK_JITTER__NAME = "Clock_Jitter";
	
	public static boolean acceptsClockJitter(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getClockJitter_Property(lookupContext));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getClockJitter(NamedElement lookupContext) {
		return getClockJitter(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getClockJitter(NamedElement lookupContext, Mode mode) {
		return getClockJitter(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getClockJitter(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getClockJitter_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getClockJitter_Property(EObject lookupContext) {
		String name = TIMING_PROPERTIES__NAME + "::" + CLOCK_JITTER__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getClockJitter_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getClockJitter_Property(lookupContext));
	}
	
	// Lookup methods for Timing_Properties::Clock_Period
	
	public static final String CLOCK_PERIOD__NAME = "Clock_Period";
	
	public static boolean acceptsClockPeriod(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getClockPeriod_Property(lookupContext));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getClockPeriod(NamedElement lookupContext) {
		return getClockPeriod(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getClockPeriod(NamedElement lookupContext, Mode mode) {
		return getClockPeriod(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getClockPeriod(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getClockPeriod_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getClockPeriod_Property(EObject lookupContext) {
		String name = TIMING_PROPERTIES__NAME + "::" + CLOCK_PERIOD__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getClockPeriod_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getClockPeriod_Property(lookupContext));
	}
	
	// Lookup methods for Timing_Properties::Clock_Period_Range
	
	public static final String CLOCK_PERIOD_RANGE__NAME = "Clock_Period_Range";
	
	public static boolean acceptsClockPeriodRange(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getClockPeriodRange_Property(lookupContext));
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getClockPeriodRange(NamedElement lookupContext) {
		return getClockPeriodRange(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getClockPeriodRange(NamedElement lookupContext, Mode mode) {
		return getClockPeriodRange(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getClockPeriodRange(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getClockPeriodRange_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerRangeWithUnits<>(resolved, TimeUnits.class, lookupContext, mode));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getClockPeriodRange_Property(EObject lookupContext) {
		String name = TIMING_PROPERTIES__NAME + "::" + CLOCK_PERIOD_RANGE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getClockPeriodRange_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getClockPeriodRange_Property(lookupContext));
	}
	
	// Lookup methods for Timing_Properties::Process_Swap_Execution_Time
	
	public static final String PROCESS_SWAP_EXECUTION_TIME__NAME = "Process_Swap_Execution_Time";
	
	public static boolean acceptsProcessSwapExecutionTime(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getProcessSwapExecutionTime_Property(lookupContext));
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getProcessSwapExecutionTime(NamedElement lookupContext) {
		return getProcessSwapExecutionTime(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getProcessSwapExecutionTime(NamedElement lookupContext, Mode mode) {
		return getProcessSwapExecutionTime(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getProcessSwapExecutionTime(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getProcessSwapExecutionTime_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerRangeWithUnits<>(resolved, TimeUnits.class, lookupContext, mode));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getProcessSwapExecutionTime_Property(EObject lookupContext) {
		String name = TIMING_PROPERTIES__NAME + "::" + PROCESS_SWAP_EXECUTION_TIME__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getProcessSwapExecutionTime_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getProcessSwapExecutionTime_Property(lookupContext));
	}
	
	// Lookup methods for Timing_Properties::Reference_Processor
	
	public static final String REFERENCE_PROCESSOR__NAME = "Reference_Processor";
	
	public static boolean acceptsReferenceProcessor(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getReferenceProcessor_Property(lookupContext));
	}
	
	public static Optional<Classifier> getReferenceProcessor(NamedElement lookupContext) {
		return getReferenceProcessor(lookupContext, Optional.empty());
	}
	
	public static Optional<Classifier> getReferenceProcessor(NamedElement lookupContext, Mode mode) {
		return getReferenceProcessor(lookupContext, Optional.of(mode));
	}
	
	public static Optional<Classifier> getReferenceProcessor(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getReferenceProcessor_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ClassifierValue) resolved).getClassifier());
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getReferenceProcessor_Property(EObject lookupContext) {
		String name = TIMING_PROPERTIES__NAME + "::" + REFERENCE_PROCESSOR__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getReferenceProcessor_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getReferenceProcessor_Property(lookupContext));
	}
	
	// Lookup methods for Timing_Properties::Scheduler_Quantum
	
	public static final String SCHEDULER_QUANTUM__NAME = "Scheduler_Quantum";
	
	public static boolean acceptsSchedulerQuantum(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getSchedulerQuantum_Property(lookupContext));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getSchedulerQuantum(NamedElement lookupContext) {
		return getSchedulerQuantum(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getSchedulerQuantum(NamedElement lookupContext, Mode mode) {
		return getSchedulerQuantum(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getSchedulerQuantum(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getSchedulerQuantum_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getSchedulerQuantum_Property(EObject lookupContext) {
		String name = TIMING_PROPERTIES__NAME + "::" + SCHEDULER_QUANTUM__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getSchedulerQuantum_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getSchedulerQuantum_Property(lookupContext));
	}
	
	// Lookup methods for Timing_Properties::Thread_Swap_Execution_Time
	
	public static final String THREAD_SWAP_EXECUTION_TIME__NAME = "Thread_Swap_Execution_Time";
	
	public static boolean acceptsThreadSwapExecutionTime(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getThreadSwapExecutionTime_Property(lookupContext));
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getThreadSwapExecutionTime(NamedElement lookupContext) {
		return getThreadSwapExecutionTime(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getThreadSwapExecutionTime(NamedElement lookupContext, Mode mode) {
		return getThreadSwapExecutionTime(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerRangeWithUnits<TimeUnits>> getThreadSwapExecutionTime(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getThreadSwapExecutionTime_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerRangeWithUnits<>(resolved, TimeUnits.class, lookupContext, mode));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getThreadSwapExecutionTime_Property(EObject lookupContext) {
		String name = TIMING_PROPERTIES__NAME + "::" + THREAD_SWAP_EXECUTION_TIME__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getThreadSwapExecutionTime_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getThreadSwapExecutionTime_Property(lookupContext));
	}
	
	// Lookup methods for Timing_Properties::Frame_Period
	
	public static final String FRAME_PERIOD__NAME = "Frame_Period";
	
	public static boolean acceptsFramePeriod(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getFramePeriod_Property(lookupContext));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getFramePeriod(NamedElement lookupContext) {
		return getFramePeriod(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getFramePeriod(NamedElement lookupContext, Mode mode) {
		return getFramePeriod(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getFramePeriod(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getFramePeriod_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getFramePeriod_Property(EObject lookupContext) {
		String name = TIMING_PROPERTIES__NAME + "::" + FRAME_PERIOD__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getFramePeriod_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getFramePeriod_Property(lookupContext));
	}
	
	// Lookup methods for Timing_Properties::Slot_Time
	
	public static final String SLOT_TIME__NAME = "Slot_Time";
	
	public static boolean acceptsSlotTime(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getSlotTime_Property(lookupContext));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getSlotTime(NamedElement lookupContext) {
		return getSlotTime(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getSlotTime(NamedElement lookupContext, Mode mode) {
		return getSlotTime(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getSlotTime(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getSlotTime_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getSlotTime_Property(EObject lookupContext) {
		String name = TIMING_PROPERTIES__NAME + "::" + SLOT_TIME__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getSlotTime_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getSlotTime_Property(lookupContext));
	}
}
