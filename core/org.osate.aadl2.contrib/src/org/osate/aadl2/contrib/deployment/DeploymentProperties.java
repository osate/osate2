package org.osate.aadl2.contrib.deployment;

import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.stream.Collectors;

import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.contrib.aadlproject.SupportedConnectionQos;
import org.osate.aadl2.contrib.aadlproject.SupportedDispatchProtocols;
import org.osate.aadl2.contrib.aadlproject.SupportedSchedulingProtocols;
import org.osate.aadl2.contrib.aadlproject.TimeUnits;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.InstanceReferenceValue;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.pluginsupport.properties.CodeGenUtil;
import org.osate.pluginsupport.properties.IntegerRange;
import org.osate.pluginsupport.properties.IntegerRangeWithUnits;

public class DeploymentProperties {
	public static final String DEPLOYMENT_PROPERTIES__NAME = "Deployment_Properties";
	
	public static final String ALLOWED_PROCESSOR_BINDING_CLASS__NAME = "Allowed_Processor_Binding_Class";
	public static final String ALLOWED_PROCESSOR_BINDING__NAME = "Allowed_Processor_Binding";
	public static final String ACTUAL_PROCESSOR_BINDING__NAME = "Actual_Processor_Binding";
	public static final String ALLOWED_MEMORY_BINDING_CLASS__NAME = "Allowed_Memory_Binding_Class";
	public static final String ALLOWED_MEMORY_BINDING__NAME = "Allowed_Memory_Binding";
	public static final String ACTUAL_MEMORY_BINDING__NAME = "Actual_Memory_Binding";
	public static final String ALLOWED_CONNECTION_BINDING_CLASS__NAME = "Allowed_Connection_Binding_Class";
	public static final String ALLOWED_CONNECTION_BINDING__NAME = "Allowed_Connection_Binding";
	public static final String ACTUAL_CONNECTION_BINDING__NAME = "Actual_Connection_Binding";
	public static final String ACTUAL_FUNCTION_BINDING__NAME = "Actual_Function_Binding";
	public static final String ALLOWED_SUBPROGRAM_CALL__NAME = "Allowed_Subprogram_Call";
	public static final String ACTUAL_SUBPROGRAM_CALL__NAME = "Actual_Subprogram_Call";
	public static final String ALLOWED_SUBPROGRAM_CALL_BINDING__NAME = "Allowed_Subprogram_Call_Binding";
	public static final String ACTUAL_SUBPROGRAM_CALL_BINDING__NAME = "Actual_Subprogram_Call_Binding";
	public static final String PROVIDED_VIRTUAL_BUS_CLASS__NAME = "Provided_Virtual_Bus_Class";
	public static final String REQUIRED_VIRTUAL_BUS_CLASS__NAME = "Required_Virtual_Bus_Class";
	public static final String PROVIDED_CONNECTION_QUALITY_OF_SERVICE__NAME = "Provided_Connection_Quality_Of_Service";
	public static final String REQUIRED_CONNECTION_QUALITY_OF_SERVICE__NAME = "Required_Connection_Quality_Of_Service";
	public static final String NOT_COLLOCATED__NAME = "Not_Collocated";
	public static final String COLLOCATED__NAME = "Collocated";
	public static final String ALLOWED_CONNECTION_TYPE__NAME = "Allowed_Connection_Type";
	public static final String ALLOWED_DISPATCH_PROTOCOL__NAME = "Allowed_Dispatch_Protocol";
	public static final String ALLOWED_PERIOD__NAME = "Allowed_Period";
	public static final String ALLOWED_PHYSICAL_ACCESS_CLASS__NAME = "Allowed_Physical_Access_Class";
	public static final String ALLOWED_PHYSICAL_ACCESS__NAME = "Allowed_Physical_Access";
	public static final String MEMORY_PROTOCOL__NAME = "Memory_Protocol";
	public static final String RUNTIME_PROTECTION_SUPPORT__NAME = "Runtime_Protection_Support";
	public static final String SCHEDULING_PROTOCOL__NAME = "Scheduling_Protocol";
	public static final String PREEMPTIVE_SCHEDULER__NAME = "Preemptive_Scheduler";
	public static final String THREAD_LIMIT__NAME = "Thread_Limit";
	public static final String PRIORITY_MAP__NAME = "Priority_Map";
	public static final String PRIORITY_RANGE__NAME = "Priority_Range";
	
	// Lookup methods for Deployment_Properties::Allowed_Processor_Binding_Class
	
	public static boolean acceptsAllowedProcessorBindingClass(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getAllowedProcessorBindingClass_Property(lookupContext));
	}
	
	public static Optional<List<Classifier>> getAllowedProcessorBindingClass(NamedElement lookupContext) {
		return getAllowedProcessorBindingClass(lookupContext, Optional.empty());
	}
	
	public static Optional<List<Classifier>> getAllowedProcessorBindingClass(NamedElement lookupContext, Mode mode) {
		return getAllowedProcessorBindingClass(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<Classifier>> getAllowedProcessorBindingClass(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getAllowedProcessorBindingClass_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return ((ClassifierValue) resolved1).getClassifier();
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getAllowedProcessorBindingClass_Property(NamedElement lookupContext) {
		String name = DEPLOYMENT_PROPERTIES__NAME + "::" + ALLOWED_PROCESSOR_BINDING_CLASS__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getAllowedProcessorBindingClass_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getAllowedProcessorBindingClass_Property(lookupContext));
	}
	
	// Lookup methods for Deployment_Properties::Allowed_Processor_Binding
	
	public static boolean acceptsAllowedProcessorBinding(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getAllowedProcessorBinding_Property(lookupContext));
	}
	
	public static Optional<List<InstanceObject>> getAllowedProcessorBinding(NamedElement lookupContext) {
		return getAllowedProcessorBinding(lookupContext, Optional.empty());
	}
	
	public static Optional<List<InstanceObject>> getAllowedProcessorBinding(NamedElement lookupContext, Mode mode) {
		return getAllowedProcessorBinding(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<InstanceObject>> getAllowedProcessorBinding(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getAllowedProcessorBinding_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return ((InstanceReferenceValue) resolved1).getReferencedInstanceObject();
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getAllowedProcessorBinding_Property(NamedElement lookupContext) {
		String name = DEPLOYMENT_PROPERTIES__NAME + "::" + ALLOWED_PROCESSOR_BINDING__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getAllowedProcessorBinding_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getAllowedProcessorBinding_Property(lookupContext));
	}
	
	// Lookup methods for Deployment_Properties::Actual_Processor_Binding
	
	public static boolean acceptsActualProcessorBinding(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getActualProcessorBinding_Property(lookupContext));
	}
	
	public static Optional<List<InstanceObject>> getActualProcessorBinding(NamedElement lookupContext) {
		return getActualProcessorBinding(lookupContext, Optional.empty());
	}
	
	public static Optional<List<InstanceObject>> getActualProcessorBinding(NamedElement lookupContext, Mode mode) {
		return getActualProcessorBinding(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<InstanceObject>> getActualProcessorBinding(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getActualProcessorBinding_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return ((InstanceReferenceValue) resolved1).getReferencedInstanceObject();
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getActualProcessorBinding_Property(NamedElement lookupContext) {
		String name = DEPLOYMENT_PROPERTIES__NAME + "::" + ACTUAL_PROCESSOR_BINDING__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getActualProcessorBinding_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getActualProcessorBinding_Property(lookupContext));
	}
	
	// Lookup methods for Deployment_Properties::Allowed_Memory_Binding_Class
	
	public static boolean acceptsAllowedMemoryBindingClass(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getAllowedMemoryBindingClass_Property(lookupContext));
	}
	
	public static Optional<List<Classifier>> getAllowedMemoryBindingClass(NamedElement lookupContext) {
		return getAllowedMemoryBindingClass(lookupContext, Optional.empty());
	}
	
	public static Optional<List<Classifier>> getAllowedMemoryBindingClass(NamedElement lookupContext, Mode mode) {
		return getAllowedMemoryBindingClass(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<Classifier>> getAllowedMemoryBindingClass(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getAllowedMemoryBindingClass_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return ((ClassifierValue) resolved1).getClassifier();
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getAllowedMemoryBindingClass_Property(NamedElement lookupContext) {
		String name = DEPLOYMENT_PROPERTIES__NAME + "::" + ALLOWED_MEMORY_BINDING_CLASS__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getAllowedMemoryBindingClass_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getAllowedMemoryBindingClass_Property(lookupContext));
	}
	
	// Lookup methods for Deployment_Properties::Allowed_Memory_Binding
	
	public static boolean acceptsAllowedMemoryBinding(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getAllowedMemoryBinding_Property(lookupContext));
	}
	
	public static Optional<List<InstanceObject>> getAllowedMemoryBinding(NamedElement lookupContext) {
		return getAllowedMemoryBinding(lookupContext, Optional.empty());
	}
	
	public static Optional<List<InstanceObject>> getAllowedMemoryBinding(NamedElement lookupContext, Mode mode) {
		return getAllowedMemoryBinding(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<InstanceObject>> getAllowedMemoryBinding(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getAllowedMemoryBinding_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return ((InstanceReferenceValue) resolved1).getReferencedInstanceObject();
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getAllowedMemoryBinding_Property(NamedElement lookupContext) {
		String name = DEPLOYMENT_PROPERTIES__NAME + "::" + ALLOWED_MEMORY_BINDING__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getAllowedMemoryBinding_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getAllowedMemoryBinding_Property(lookupContext));
	}
	
	// Lookup methods for Deployment_Properties::Actual_Memory_Binding
	
	public static boolean acceptsActualMemoryBinding(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getActualMemoryBinding_Property(lookupContext));
	}
	
	public static Optional<List<InstanceObject>> getActualMemoryBinding(NamedElement lookupContext) {
		return getActualMemoryBinding(lookupContext, Optional.empty());
	}
	
	public static Optional<List<InstanceObject>> getActualMemoryBinding(NamedElement lookupContext, Mode mode) {
		return getActualMemoryBinding(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<InstanceObject>> getActualMemoryBinding(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getActualMemoryBinding_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return ((InstanceReferenceValue) resolved1).getReferencedInstanceObject();
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getActualMemoryBinding_Property(NamedElement lookupContext) {
		String name = DEPLOYMENT_PROPERTIES__NAME + "::" + ACTUAL_MEMORY_BINDING__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getActualMemoryBinding_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getActualMemoryBinding_Property(lookupContext));
	}
	
	// Lookup methods for Deployment_Properties::Allowed_Connection_Binding_Class
	
	public static boolean acceptsAllowedConnectionBindingClass(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getAllowedConnectionBindingClass_Property(lookupContext));
	}
	
	public static Optional<List<Classifier>> getAllowedConnectionBindingClass(NamedElement lookupContext) {
		return getAllowedConnectionBindingClass(lookupContext, Optional.empty());
	}
	
	public static Optional<List<Classifier>> getAllowedConnectionBindingClass(NamedElement lookupContext, Mode mode) {
		return getAllowedConnectionBindingClass(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<Classifier>> getAllowedConnectionBindingClass(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getAllowedConnectionBindingClass_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return ((ClassifierValue) resolved1).getClassifier();
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getAllowedConnectionBindingClass_Property(NamedElement lookupContext) {
		String name = DEPLOYMENT_PROPERTIES__NAME + "::" + ALLOWED_CONNECTION_BINDING_CLASS__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getAllowedConnectionBindingClass_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getAllowedConnectionBindingClass_Property(lookupContext));
	}
	
	// Lookup methods for Deployment_Properties::Allowed_Connection_Binding
	
	public static boolean acceptsAllowedConnectionBinding(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getAllowedConnectionBinding_Property(lookupContext));
	}
	
	public static Optional<List<InstanceObject>> getAllowedConnectionBinding(NamedElement lookupContext) {
		return getAllowedConnectionBinding(lookupContext, Optional.empty());
	}
	
	public static Optional<List<InstanceObject>> getAllowedConnectionBinding(NamedElement lookupContext, Mode mode) {
		return getAllowedConnectionBinding(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<InstanceObject>> getAllowedConnectionBinding(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getAllowedConnectionBinding_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return ((InstanceReferenceValue) resolved1).getReferencedInstanceObject();
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getAllowedConnectionBinding_Property(NamedElement lookupContext) {
		String name = DEPLOYMENT_PROPERTIES__NAME + "::" + ALLOWED_CONNECTION_BINDING__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getAllowedConnectionBinding_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getAllowedConnectionBinding_Property(lookupContext));
	}
	
	// Lookup methods for Deployment_Properties::Actual_Connection_Binding
	
	public static boolean acceptsActualConnectionBinding(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getActualConnectionBinding_Property(lookupContext));
	}
	
	public static Optional<List<InstanceObject>> getActualConnectionBinding(NamedElement lookupContext) {
		return getActualConnectionBinding(lookupContext, Optional.empty());
	}
	
	public static Optional<List<InstanceObject>> getActualConnectionBinding(NamedElement lookupContext, Mode mode) {
		return getActualConnectionBinding(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<InstanceObject>> getActualConnectionBinding(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getActualConnectionBinding_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return ((InstanceReferenceValue) resolved1).getReferencedInstanceObject();
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getActualConnectionBinding_Property(NamedElement lookupContext) {
		String name = DEPLOYMENT_PROPERTIES__NAME + "::" + ACTUAL_CONNECTION_BINDING__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getActualConnectionBinding_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getActualConnectionBinding_Property(lookupContext));
	}
	
	// Lookup methods for Deployment_Properties::Actual_Function_Binding
	
	public static boolean acceptsActualFunctionBinding(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getActualFunctionBinding_Property(lookupContext));
	}
	
	public static Optional<List<InstanceObject>> getActualFunctionBinding(NamedElement lookupContext) {
		return getActualFunctionBinding(lookupContext, Optional.empty());
	}
	
	public static Optional<List<InstanceObject>> getActualFunctionBinding(NamedElement lookupContext, Mode mode) {
		return getActualFunctionBinding(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<InstanceObject>> getActualFunctionBinding(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getActualFunctionBinding_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return ((InstanceReferenceValue) resolved1).getReferencedInstanceObject();
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getActualFunctionBinding_Property(NamedElement lookupContext) {
		String name = DEPLOYMENT_PROPERTIES__NAME + "::" + ACTUAL_FUNCTION_BINDING__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getActualFunctionBinding_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getActualFunctionBinding_Property(lookupContext));
	}
	
	// Lookup methods for Deployment_Properties::Allowed_Subprogram_Call
	
	public static boolean acceptsAllowedSubprogramCall(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getAllowedSubprogramCall_Property(lookupContext));
	}
	
	public static Optional<List<InstanceObject>> getAllowedSubprogramCall(NamedElement lookupContext) {
		return getAllowedSubprogramCall(lookupContext, Optional.empty());
	}
	
	public static Optional<List<InstanceObject>> getAllowedSubprogramCall(NamedElement lookupContext, Mode mode) {
		return getAllowedSubprogramCall(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<InstanceObject>> getAllowedSubprogramCall(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getAllowedSubprogramCall_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return ((InstanceReferenceValue) resolved1).getReferencedInstanceObject();
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getAllowedSubprogramCall_Property(NamedElement lookupContext) {
		String name = DEPLOYMENT_PROPERTIES__NAME + "::" + ALLOWED_SUBPROGRAM_CALL__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getAllowedSubprogramCall_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getAllowedSubprogramCall_Property(lookupContext));
	}
	
	// Lookup methods for Deployment_Properties::Actual_Subprogram_Call
	
	public static boolean acceptsActualSubprogramCall(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getActualSubprogramCall_Property(lookupContext));
	}
	
	public static Optional<InstanceObject> getActualSubprogramCall(NamedElement lookupContext) {
		return getActualSubprogramCall(lookupContext, Optional.empty());
	}
	
	public static Optional<InstanceObject> getActualSubprogramCall(NamedElement lookupContext, Mode mode) {
		return getActualSubprogramCall(lookupContext, Optional.of(mode));
	}
	
	public static Optional<InstanceObject> getActualSubprogramCall(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getActualSubprogramCall_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((InstanceReferenceValue) resolved).getReferencedInstanceObject());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getActualSubprogramCall_Property(NamedElement lookupContext) {
		String name = DEPLOYMENT_PROPERTIES__NAME + "::" + ACTUAL_SUBPROGRAM_CALL__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getActualSubprogramCall_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getActualSubprogramCall_Property(lookupContext));
	}
	
	// Lookup methods for Deployment_Properties::Allowed_Subprogram_Call_Binding
	
	public static boolean acceptsAllowedSubprogramCallBinding(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getAllowedSubprogramCallBinding_Property(lookupContext));
	}
	
	public static Optional<List<InstanceObject>> getAllowedSubprogramCallBinding(NamedElement lookupContext) {
		return getAllowedSubprogramCallBinding(lookupContext, Optional.empty());
	}
	
	public static Optional<List<InstanceObject>> getAllowedSubprogramCallBinding(NamedElement lookupContext, Mode mode) {
		return getAllowedSubprogramCallBinding(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<InstanceObject>> getAllowedSubprogramCallBinding(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getAllowedSubprogramCallBinding_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return ((InstanceReferenceValue) resolved1).getReferencedInstanceObject();
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getAllowedSubprogramCallBinding_Property(NamedElement lookupContext) {
		String name = DEPLOYMENT_PROPERTIES__NAME + "::" + ALLOWED_SUBPROGRAM_CALL_BINDING__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getAllowedSubprogramCallBinding_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getAllowedSubprogramCallBinding_Property(lookupContext));
	}
	
	// Lookup methods for Deployment_Properties::Actual_Subprogram_Call_Binding
	
	public static boolean acceptsActualSubprogramCallBinding(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getActualSubprogramCallBinding_Property(lookupContext));
	}
	
	public static Optional<List<InstanceObject>> getActualSubprogramCallBinding(NamedElement lookupContext) {
		return getActualSubprogramCallBinding(lookupContext, Optional.empty());
	}
	
	public static Optional<List<InstanceObject>> getActualSubprogramCallBinding(NamedElement lookupContext, Mode mode) {
		return getActualSubprogramCallBinding(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<InstanceObject>> getActualSubprogramCallBinding(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getActualSubprogramCallBinding_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return ((InstanceReferenceValue) resolved1).getReferencedInstanceObject();
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getActualSubprogramCallBinding_Property(NamedElement lookupContext) {
		String name = DEPLOYMENT_PROPERTIES__NAME + "::" + ACTUAL_SUBPROGRAM_CALL_BINDING__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getActualSubprogramCallBinding_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getActualSubprogramCallBinding_Property(lookupContext));
	}
	
	// Lookup methods for Deployment_Properties::Provided_Virtual_Bus_Class
	
	public static boolean acceptsProvidedVirtualBusClass(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getProvidedVirtualBusClass_Property(lookupContext));
	}
	
	public static Optional<List<Classifier>> getProvidedVirtualBusClass(NamedElement lookupContext) {
		return getProvidedVirtualBusClass(lookupContext, Optional.empty());
	}
	
	public static Optional<List<Classifier>> getProvidedVirtualBusClass(NamedElement lookupContext, Mode mode) {
		return getProvidedVirtualBusClass(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<Classifier>> getProvidedVirtualBusClass(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getProvidedVirtualBusClass_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return ((ClassifierValue) resolved1).getClassifier();
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getProvidedVirtualBusClass_Property(NamedElement lookupContext) {
		String name = DEPLOYMENT_PROPERTIES__NAME + "::" + PROVIDED_VIRTUAL_BUS_CLASS__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getProvidedVirtualBusClass_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getProvidedVirtualBusClass_Property(lookupContext));
	}
	
	// Lookup methods for Deployment_Properties::Required_Virtual_Bus_Class
	
	public static boolean acceptsRequiredVirtualBusClass(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getRequiredVirtualBusClass_Property(lookupContext));
	}
	
	public static Optional<List<Classifier>> getRequiredVirtualBusClass(NamedElement lookupContext) {
		return getRequiredVirtualBusClass(lookupContext, Optional.empty());
	}
	
	public static Optional<List<Classifier>> getRequiredVirtualBusClass(NamedElement lookupContext, Mode mode) {
		return getRequiredVirtualBusClass(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<Classifier>> getRequiredVirtualBusClass(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getRequiredVirtualBusClass_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return ((ClassifierValue) resolved1).getClassifier();
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getRequiredVirtualBusClass_Property(NamedElement lookupContext) {
		String name = DEPLOYMENT_PROPERTIES__NAME + "::" + REQUIRED_VIRTUAL_BUS_CLASS__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getRequiredVirtualBusClass_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getRequiredVirtualBusClass_Property(lookupContext));
	}
	
	// Lookup methods for Deployment_Properties::Provided_Connection_Quality_Of_Service
	
	public static boolean acceptsProvidedConnectionQualityOfService(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getProvidedConnectionQualityOfService_Property(lookupContext));
	}
	
	public static Optional<List<SupportedConnectionQos>> getProvidedConnectionQualityOfService(NamedElement lookupContext) {
		return getProvidedConnectionQualityOfService(lookupContext, Optional.empty());
	}
	
	public static Optional<List<SupportedConnectionQos>> getProvidedConnectionQualityOfService(NamedElement lookupContext, Mode mode) {
		return getProvidedConnectionQualityOfService(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<SupportedConnectionQos>> getProvidedConnectionQualityOfService(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getProvidedConnectionQualityOfService_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return SupportedConnectionQos.valueOf(resolved1);
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getProvidedConnectionQualityOfService_Property(NamedElement lookupContext) {
		String name = DEPLOYMENT_PROPERTIES__NAME + "::" + PROVIDED_CONNECTION_QUALITY_OF_SERVICE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getProvidedConnectionQualityOfService_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getProvidedConnectionQualityOfService_Property(lookupContext));
	}
	
	// Lookup methods for Deployment_Properties::Required_Connection_Quality_Of_Service
	
	public static boolean acceptsRequiredConnectionQualityOfService(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getRequiredConnectionQualityOfService_Property(lookupContext));
	}
	
	public static Optional<List<SupportedConnectionQos>> getRequiredConnectionQualityOfService(NamedElement lookupContext) {
		return getRequiredConnectionQualityOfService(lookupContext, Optional.empty());
	}
	
	public static Optional<List<SupportedConnectionQos>> getRequiredConnectionQualityOfService(NamedElement lookupContext, Mode mode) {
		return getRequiredConnectionQualityOfService(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<SupportedConnectionQos>> getRequiredConnectionQualityOfService(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getRequiredConnectionQualityOfService_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return SupportedConnectionQos.valueOf(resolved1);
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getRequiredConnectionQualityOfService_Property(NamedElement lookupContext) {
		String name = DEPLOYMENT_PROPERTIES__NAME + "::" + REQUIRED_CONNECTION_QUALITY_OF_SERVICE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getRequiredConnectionQualityOfService_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getRequiredConnectionQualityOfService_Property(lookupContext));
	}
	
	// Lookup methods for Deployment_Properties::Not_Collocated
	
	public static boolean acceptsNotCollocated(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getNotCollocated_Property(lookupContext));
	}
	
	public static Optional<NotCollocated> getNotCollocated(NamedElement lookupContext) {
		return getNotCollocated(lookupContext, Optional.empty());
	}
	
	public static Optional<NotCollocated> getNotCollocated(NamedElement lookupContext, Mode mode) {
		return getNotCollocated(lookupContext, Optional.of(mode));
	}
	
	public static Optional<NotCollocated> getNotCollocated(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getNotCollocated_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new NotCollocated(resolved, lookupContext, mode));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getNotCollocated_Property(NamedElement lookupContext) {
		String name = DEPLOYMENT_PROPERTIES__NAME + "::" + NOT_COLLOCATED__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getNotCollocated_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getNotCollocated_Property(lookupContext));
	}
	
	// Lookup methods for Deployment_Properties::Collocated
	
	public static boolean acceptsCollocated(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getCollocated_Property(lookupContext));
	}
	
	public static Optional<Collocated> getCollocated(NamedElement lookupContext) {
		return getCollocated(lookupContext, Optional.empty());
	}
	
	public static Optional<Collocated> getCollocated(NamedElement lookupContext, Mode mode) {
		return getCollocated(lookupContext, Optional.of(mode));
	}
	
	public static Optional<Collocated> getCollocated(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getCollocated_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new Collocated(resolved, lookupContext, mode));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getCollocated_Property(NamedElement lookupContext) {
		String name = DEPLOYMENT_PROPERTIES__NAME + "::" + COLLOCATED__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getCollocated_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getCollocated_Property(lookupContext));
	}
	
	// Lookup methods for Deployment_Properties::Allowed_Connection_Type
	
	public static boolean acceptsAllowedConnectionType(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getAllowedConnectionType_Property(lookupContext));
	}
	
	public static Optional<List<AllowedConnectionType>> getAllowedConnectionType(NamedElement lookupContext) {
		return getAllowedConnectionType(lookupContext, Optional.empty());
	}
	
	public static Optional<List<AllowedConnectionType>> getAllowedConnectionType(NamedElement lookupContext, Mode mode) {
		return getAllowedConnectionType(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<AllowedConnectionType>> getAllowedConnectionType(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getAllowedConnectionType_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return AllowedConnectionType.valueOf(resolved1);
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getAllowedConnectionType_Property(NamedElement lookupContext) {
		String name = DEPLOYMENT_PROPERTIES__NAME + "::" + ALLOWED_CONNECTION_TYPE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getAllowedConnectionType_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getAllowedConnectionType_Property(lookupContext));
	}
	
	// Lookup methods for Deployment_Properties::Allowed_Dispatch_Protocol
	
	public static boolean acceptsAllowedDispatchProtocol(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getAllowedDispatchProtocol_Property(lookupContext));
	}
	
	public static Optional<List<SupportedDispatchProtocols>> getAllowedDispatchProtocol(NamedElement lookupContext) {
		return getAllowedDispatchProtocol(lookupContext, Optional.empty());
	}
	
	public static Optional<List<SupportedDispatchProtocols>> getAllowedDispatchProtocol(NamedElement lookupContext, Mode mode) {
		return getAllowedDispatchProtocol(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<SupportedDispatchProtocols>> getAllowedDispatchProtocol(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getAllowedDispatchProtocol_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return SupportedDispatchProtocols.valueOf(resolved1);
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getAllowedDispatchProtocol_Property(NamedElement lookupContext) {
		String name = DEPLOYMENT_PROPERTIES__NAME + "::" + ALLOWED_DISPATCH_PROTOCOL__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getAllowedDispatchProtocol_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getAllowedDispatchProtocol_Property(lookupContext));
	}
	
	// Lookup methods for Deployment_Properties::Allowed_Period
	
	public static boolean acceptsAllowedPeriod(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getAllowedPeriod_Property(lookupContext));
	}
	
	public static Optional<List<IntegerRangeWithUnits<TimeUnits>>> getAllowedPeriod(NamedElement lookupContext) {
		return getAllowedPeriod(lookupContext, Optional.empty());
	}
	
	public static Optional<List<IntegerRangeWithUnits<TimeUnits>>> getAllowedPeriod(NamedElement lookupContext, Mode mode) {
		return getAllowedPeriod(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<IntegerRangeWithUnits<TimeUnits>>> getAllowedPeriod(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getAllowedPeriod_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return new IntegerRangeWithUnits<>(resolved1, TimeUnits.class, lookupContext, mode);
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getAllowedPeriod_Property(NamedElement lookupContext) {
		String name = DEPLOYMENT_PROPERTIES__NAME + "::" + ALLOWED_PERIOD__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getAllowedPeriod_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getAllowedPeriod_Property(lookupContext));
	}
	
	// Lookup methods for Deployment_Properties::Allowed_Physical_Access_Class
	
	public static boolean acceptsAllowedPhysicalAccessClass(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getAllowedPhysicalAccessClass_Property(lookupContext));
	}
	
	public static Optional<List<Classifier>> getAllowedPhysicalAccessClass(NamedElement lookupContext) {
		return getAllowedPhysicalAccessClass(lookupContext, Optional.empty());
	}
	
	public static Optional<List<Classifier>> getAllowedPhysicalAccessClass(NamedElement lookupContext, Mode mode) {
		return getAllowedPhysicalAccessClass(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<Classifier>> getAllowedPhysicalAccessClass(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getAllowedPhysicalAccessClass_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return ((ClassifierValue) resolved1).getClassifier();
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getAllowedPhysicalAccessClass_Property(NamedElement lookupContext) {
		String name = DEPLOYMENT_PROPERTIES__NAME + "::" + ALLOWED_PHYSICAL_ACCESS_CLASS__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getAllowedPhysicalAccessClass_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getAllowedPhysicalAccessClass_Property(lookupContext));
	}
	
	// Lookup methods for Deployment_Properties::Allowed_Physical_Access
	
	public static boolean acceptsAllowedPhysicalAccess(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getAllowedPhysicalAccess_Property(lookupContext));
	}
	
	public static Optional<List<InstanceObject>> getAllowedPhysicalAccess(NamedElement lookupContext) {
		return getAllowedPhysicalAccess(lookupContext, Optional.empty());
	}
	
	public static Optional<List<InstanceObject>> getAllowedPhysicalAccess(NamedElement lookupContext, Mode mode) {
		return getAllowedPhysicalAccess(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<InstanceObject>> getAllowedPhysicalAccess(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getAllowedPhysicalAccess_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return ((InstanceReferenceValue) resolved1).getReferencedInstanceObject();
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getAllowedPhysicalAccess_Property(NamedElement lookupContext) {
		String name = DEPLOYMENT_PROPERTIES__NAME + "::" + ALLOWED_PHYSICAL_ACCESS__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getAllowedPhysicalAccess_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getAllowedPhysicalAccess_Property(lookupContext));
	}
	
	// Lookup methods for Deployment_Properties::Memory_Protocol
	
	public static boolean acceptsMemoryProtocol(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getMemoryProtocol_Property(lookupContext));
	}
	
	public static Optional<MemoryProtocol> getMemoryProtocol(NamedElement lookupContext) {
		return getMemoryProtocol(lookupContext, Optional.empty());
	}
	
	public static Optional<MemoryProtocol> getMemoryProtocol(NamedElement lookupContext, Mode mode) {
		return getMemoryProtocol(lookupContext, Optional.of(mode));
	}
	
	public static Optional<MemoryProtocol> getMemoryProtocol(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getMemoryProtocol_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(MemoryProtocol.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getMemoryProtocol_Property(NamedElement lookupContext) {
		String name = DEPLOYMENT_PROPERTIES__NAME + "::" + MEMORY_PROTOCOL__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getMemoryProtocol_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getMemoryProtocol_Property(lookupContext));
	}
	
	// Lookup methods for Deployment_Properties::Runtime_Protection_Support
	
	public static boolean acceptsRuntimeProtectionSupport(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getRuntimeProtectionSupport_Property(lookupContext));
	}
	
	public static Optional<Boolean> getRuntimeProtectionSupport(NamedElement lookupContext) {
		return getRuntimeProtectionSupport(lookupContext, Optional.empty());
	}
	
	public static Optional<Boolean> getRuntimeProtectionSupport(NamedElement lookupContext, Mode mode) {
		return getRuntimeProtectionSupport(lookupContext, Optional.of(mode));
	}
	
	public static Optional<Boolean> getRuntimeProtectionSupport(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getRuntimeProtectionSupport_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((BooleanLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getRuntimeProtectionSupport_Property(NamedElement lookupContext) {
		String name = DEPLOYMENT_PROPERTIES__NAME + "::" + RUNTIME_PROTECTION_SUPPORT__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getRuntimeProtectionSupport_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getRuntimeProtectionSupport_Property(lookupContext));
	}
	
	// Lookup methods for Deployment_Properties::Scheduling_Protocol
	
	public static boolean acceptsSchedulingProtocol(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getSchedulingProtocol_Property(lookupContext));
	}
	
	public static Optional<List<SupportedSchedulingProtocols>> getSchedulingProtocol(NamedElement lookupContext) {
		return getSchedulingProtocol(lookupContext, Optional.empty());
	}
	
	public static Optional<List<SupportedSchedulingProtocols>> getSchedulingProtocol(NamedElement lookupContext, Mode mode) {
		return getSchedulingProtocol(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<SupportedSchedulingProtocols>> getSchedulingProtocol(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getSchedulingProtocol_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return SupportedSchedulingProtocols.valueOf(resolved1);
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getSchedulingProtocol_Property(NamedElement lookupContext) {
		String name = DEPLOYMENT_PROPERTIES__NAME + "::" + SCHEDULING_PROTOCOL__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getSchedulingProtocol_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getSchedulingProtocol_Property(lookupContext));
	}
	
	// Lookup methods for Deployment_Properties::Preemptive_Scheduler
	
	public static boolean acceptsPreemptiveScheduler(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getPreemptiveScheduler_Property(lookupContext));
	}
	
	public static Optional<Boolean> getPreemptiveScheduler(NamedElement lookupContext) {
		return getPreemptiveScheduler(lookupContext, Optional.empty());
	}
	
	public static Optional<Boolean> getPreemptiveScheduler(NamedElement lookupContext, Mode mode) {
		return getPreemptiveScheduler(lookupContext, Optional.of(mode));
	}
	
	public static Optional<Boolean> getPreemptiveScheduler(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getPreemptiveScheduler_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((BooleanLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getPreemptiveScheduler_Property(NamedElement lookupContext) {
		String name = DEPLOYMENT_PROPERTIES__NAME + "::" + PREEMPTIVE_SCHEDULER__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getPreemptiveScheduler_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getPreemptiveScheduler_Property(lookupContext));
	}
	
	// Lookup methods for Deployment_Properties::Thread_Limit
	
	public static boolean acceptsThreadLimit(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getThreadLimit_Property(lookupContext));
	}
	
	public static OptionalLong getThreadLimit(NamedElement lookupContext) {
		return getThreadLimit(lookupContext, Optional.empty());
	}
	
	public static OptionalLong getThreadLimit(NamedElement lookupContext, Mode mode) {
		return getThreadLimit(lookupContext, Optional.of(mode));
	}
	
	public static OptionalLong getThreadLimit(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getThreadLimit_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalLong.of(((IntegerLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return OptionalLong.empty();
		}
	}
	
	public static Property getThreadLimit_Property(NamedElement lookupContext) {
		String name = DEPLOYMENT_PROPERTIES__NAME + "::" + THREAD_LIMIT__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getThreadLimit_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getThreadLimit_Property(lookupContext));
	}
	
	// Lookup methods for Deployment_Properties::Priority_Map
	
	public static boolean acceptsPriorityMap(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getPriorityMap_Property(lookupContext));
	}
	
	public static Optional<List<PriorityMapping>> getPriorityMap(NamedElement lookupContext) {
		return getPriorityMap(lookupContext, Optional.empty());
	}
	
	public static Optional<List<PriorityMapping>> getPriorityMap(NamedElement lookupContext, Mode mode) {
		return getPriorityMap(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<PriorityMapping>> getPriorityMap(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getPriorityMap_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return new PriorityMapping(resolved1, lookupContext, mode);
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getPriorityMap_Property(NamedElement lookupContext) {
		String name = DEPLOYMENT_PROPERTIES__NAME + "::" + PRIORITY_MAP__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getPriorityMap_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getPriorityMap_Property(lookupContext));
	}
	
	// Lookup methods for Deployment_Properties::Priority_Range
	
	public static boolean acceptsPriorityRange(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getPriorityRange_Property(lookupContext));
	}
	
	public static Optional<IntegerRange> getPriorityRange(NamedElement lookupContext) {
		return getPriorityRange(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerRange> getPriorityRange(NamedElement lookupContext, Mode mode) {
		return getPriorityRange(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerRange> getPriorityRange(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getPriorityRange_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerRange(resolved, lookupContext, mode));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static Property getPriorityRange_Property(NamedElement lookupContext) {
		String name = DEPLOYMENT_PROPERTIES__NAME + "::" + PRIORITY_RANGE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getPriorityRange_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getPriorityRange_Property(lookupContext));
	}
}
