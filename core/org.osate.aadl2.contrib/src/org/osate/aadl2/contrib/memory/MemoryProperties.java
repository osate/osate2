package org.osate.aadl2.contrib.memory;

import java.util.Optional;
import java.util.OptionalLong;

import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.contrib.aadlproject.SizeUnits;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.pluginsupport.properties.CodeGenUtil;
import org.osate.pluginsupport.properties.IntegerRangeWithUnits;
import org.osate.pluginsupport.properties.IntegerWithUnits;

public class MemoryProperties {
	public static final String MEMORY_PROPERTIES__NAME = "Memory_Properties";
	
	public static final String ACCESS_RIGHT__NAME = "Access_Right";
	public static final String ACCESS_TIME__NAME = "Access_Time";
	public static final String ALLOWED_MESSAGE_SIZE__NAME = "Allowed_Message_Size";
	public static final String ASSIGN_TIME__NAME = "Assign_Time";
	public static final String BASE_ADDRESS__NAME = "Base_Address";
	public static final String DEVICE_REGISTER_ADDRESS__NAME = "Device_Register_Address";
	public static final String READ_TIME__NAME = "Read_Time";
	public static final String CODE_SIZE__NAME = "Code_Size";
	public static final String DATA_SIZE__NAME = "Data_Size";
	public static final String HEAP_SIZE__NAME = "Heap_Size";
	public static final String STACK_SIZE__NAME = "Stack_Size";
	public static final String SOURCE_CODE_SIZE__NAME = "Source_Code_Size";
	public static final String SOURCE_DATA_SIZE__NAME = "Source_Data_Size";
	public static final String SOURCE_HEAP_SIZE__NAME = "Source_Heap_Size";
	public static final String SOURCE_STACK_SIZE__NAME = "Source_Stack_Size";
	public static final String BYTE_COUNT__NAME = "Byte_Count";
	public static final String MEMORY_SIZE__NAME = "Memory_Size";
	public static final String WORD_SIZE__NAME = "Word_Size";
	public static final String WORD_SPACE__NAME = "Word_Space";
	public static final String WRITE_TIME__NAME = "Write_Time";
	
	public static Optional<AccessRights> getAccessRight(NamedElement lookupContext) {
		return getAccessRight(lookupContext, Optional.empty());
	}
	
	public static Optional<AccessRights> getAccessRight(NamedElement lookupContext, Mode mode) {
		return getAccessRight(lookupContext, Optional.of(mode));
	}
	
	public static Optional<AccessRights> getAccessRight(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Memory_Properties::Access_Right";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(AccessRights.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getAccessRight_EObject(NamedElement lookupContext) {
		String name = "Memory_Properties::Access_Right";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<AccessTime> getAccessTime(NamedElement lookupContext) {
		return getAccessTime(lookupContext, Optional.empty());
	}
	
	public static Optional<AccessTime> getAccessTime(NamedElement lookupContext, Mode mode) {
		return getAccessTime(lookupContext, Optional.of(mode));
	}
	
	public static Optional<AccessTime> getAccessTime(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Memory_Properties::Access_Time";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new AccessTime(resolved, lookupContext, mode));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getAccessTime_EObject(NamedElement lookupContext) {
		String name = "Memory_Properties::Access_Time";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<IntegerRangeWithUnits<SizeUnits>> getAllowedMessageSize(NamedElement lookupContext) {
		return getAllowedMessageSize(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerRangeWithUnits<SizeUnits>> getAllowedMessageSize(NamedElement lookupContext, Mode mode) {
		return getAllowedMessageSize(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerRangeWithUnits<SizeUnits>> getAllowedMessageSize(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Memory_Properties::Allowed_Message_Size";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerRangeWithUnits<>(resolved, SizeUnits.class, lookupContext, mode));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getAllowedMessageSize_EObject(NamedElement lookupContext) {
		String name = "Memory_Properties::Allowed_Message_Size";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<AssignTime> getAssignTime(NamedElement lookupContext) {
		return getAssignTime(lookupContext, Optional.empty());
	}
	
	public static Optional<AssignTime> getAssignTime(NamedElement lookupContext, Mode mode) {
		return getAssignTime(lookupContext, Optional.of(mode));
	}
	
	public static Optional<AssignTime> getAssignTime(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Memory_Properties::Assign_Time";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new AssignTime(resolved, lookupContext, mode));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getAssignTime_EObject(NamedElement lookupContext) {
		String name = "Memory_Properties::Assign_Time";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static OptionalLong getBaseAddress(NamedElement lookupContext) {
		return getBaseAddress(lookupContext, Optional.empty());
	}
	
	public static OptionalLong getBaseAddress(NamedElement lookupContext, Mode mode) {
		return getBaseAddress(lookupContext, Optional.of(mode));
	}
	
	public static OptionalLong getBaseAddress(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Memory_Properties::Base_Address";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalLong.of(((IntegerLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return OptionalLong.empty();
		}
	}
	
	public static PropertyExpression getBaseAddress_EObject(NamedElement lookupContext) {
		String name = "Memory_Properties::Base_Address";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static OptionalLong getDeviceRegisterAddress(NamedElement lookupContext) {
		return getDeviceRegisterAddress(lookupContext, Optional.empty());
	}
	
	public static OptionalLong getDeviceRegisterAddress(NamedElement lookupContext, Mode mode) {
		return getDeviceRegisterAddress(lookupContext, Optional.of(mode));
	}
	
	public static OptionalLong getDeviceRegisterAddress(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Memory_Properties::Device_Register_Address";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalLong.of(((IntegerLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return OptionalLong.empty();
		}
	}
	
	public static PropertyExpression getDeviceRegisterAddress_EObject(NamedElement lookupContext) {
		String name = "Memory_Properties::Device_Register_Address";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<ReadTime> getReadTime(NamedElement lookupContext) {
		return getReadTime(lookupContext, Optional.empty());
	}
	
	public static Optional<ReadTime> getReadTime(NamedElement lookupContext, Mode mode) {
		return getReadTime(lookupContext, Optional.of(mode));
	}
	
	public static Optional<ReadTime> getReadTime(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Memory_Properties::Read_Time";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new ReadTime(resolved, lookupContext, mode));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getReadTime_EObject(NamedElement lookupContext) {
		String name = "Memory_Properties::Read_Time";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getCodeSize(NamedElement lookupContext) {
		return getCodeSize(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getCodeSize(NamedElement lookupContext, Mode mode) {
		return getCodeSize(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getCodeSize(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Memory_Properties::Code_Size";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, SizeUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getCodeSize_EObject(NamedElement lookupContext) {
		String name = "Memory_Properties::Code_Size";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getDataSize(NamedElement lookupContext) {
		return getDataSize(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getDataSize(NamedElement lookupContext, Mode mode) {
		return getDataSize(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getDataSize(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Memory_Properties::Data_Size";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, SizeUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getDataSize_EObject(NamedElement lookupContext) {
		String name = "Memory_Properties::Data_Size";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getHeapSize(NamedElement lookupContext) {
		return getHeapSize(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getHeapSize(NamedElement lookupContext, Mode mode) {
		return getHeapSize(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getHeapSize(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Memory_Properties::Heap_Size";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, SizeUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getHeapSize_EObject(NamedElement lookupContext) {
		String name = "Memory_Properties::Heap_Size";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getStackSize(NamedElement lookupContext) {
		return getStackSize(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getStackSize(NamedElement lookupContext, Mode mode) {
		return getStackSize(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getStackSize(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Memory_Properties::Stack_Size";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, SizeUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getStackSize_EObject(NamedElement lookupContext) {
		String name = "Memory_Properties::Stack_Size";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getSourceCodeSize(NamedElement lookupContext) {
		return getSourceCodeSize(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getSourceCodeSize(NamedElement lookupContext, Mode mode) {
		return getSourceCodeSize(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getSourceCodeSize(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Memory_Properties::Source_Code_Size";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, SizeUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getSourceCodeSize_EObject(NamedElement lookupContext) {
		String name = "Memory_Properties::Source_Code_Size";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getSourceDataSize(NamedElement lookupContext) {
		return getSourceDataSize(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getSourceDataSize(NamedElement lookupContext, Mode mode) {
		return getSourceDataSize(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getSourceDataSize(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Memory_Properties::Source_Data_Size";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, SizeUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getSourceDataSize_EObject(NamedElement lookupContext) {
		String name = "Memory_Properties::Source_Data_Size";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getSourceHeapSize(NamedElement lookupContext) {
		return getSourceHeapSize(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getSourceHeapSize(NamedElement lookupContext, Mode mode) {
		return getSourceHeapSize(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getSourceHeapSize(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Memory_Properties::Source_Heap_Size";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, SizeUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getSourceHeapSize_EObject(NamedElement lookupContext) {
		String name = "Memory_Properties::Source_Heap_Size";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getSourceStackSize(NamedElement lookupContext) {
		return getSourceStackSize(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getSourceStackSize(NamedElement lookupContext, Mode mode) {
		return getSourceStackSize(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getSourceStackSize(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Memory_Properties::Source_Stack_Size";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, SizeUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getSourceStackSize_EObject(NamedElement lookupContext) {
		String name = "Memory_Properties::Source_Stack_Size";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static OptionalLong getByteCount(NamedElement lookupContext) {
		return getByteCount(lookupContext, Optional.empty());
	}
	
	public static OptionalLong getByteCount(NamedElement lookupContext, Mode mode) {
		return getByteCount(lookupContext, Optional.of(mode));
	}
	
	public static OptionalLong getByteCount(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Memory_Properties::Byte_Count";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalLong.of(((IntegerLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return OptionalLong.empty();
		}
	}
	
	public static PropertyExpression getByteCount_EObject(NamedElement lookupContext) {
		String name = "Memory_Properties::Byte_Count";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getMemorySize(NamedElement lookupContext) {
		return getMemorySize(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getMemorySize(NamedElement lookupContext, Mode mode) {
		return getMemorySize(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getMemorySize(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Memory_Properties::Memory_Size";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, SizeUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getMemorySize_EObject(NamedElement lookupContext) {
		String name = "Memory_Properties::Memory_Size";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getWordSize(NamedElement lookupContext) {
		return getWordSize(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getWordSize(NamedElement lookupContext, Mode mode) {
		return getWordSize(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getWordSize(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Memory_Properties::Word_Size";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, SizeUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getWordSize_EObject(NamedElement lookupContext) {
		String name = "Memory_Properties::Word_Size";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static OptionalLong getWordSpace(NamedElement lookupContext) {
		return getWordSpace(lookupContext, Optional.empty());
	}
	
	public static OptionalLong getWordSpace(NamedElement lookupContext, Mode mode) {
		return getWordSpace(lookupContext, Optional.of(mode));
	}
	
	public static OptionalLong getWordSpace(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Memory_Properties::Word_Space";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalLong.of(((IntegerLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return OptionalLong.empty();
		}
	}
	
	public static PropertyExpression getWordSpace_EObject(NamedElement lookupContext) {
		String name = "Memory_Properties::Word_Space";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<WriteTime> getWriteTime(NamedElement lookupContext) {
		return getWriteTime(lookupContext, Optional.empty());
	}
	
	public static Optional<WriteTime> getWriteTime(NamedElement lookupContext, Mode mode) {
		return getWriteTime(lookupContext, Optional.of(mode));
	}
	
	public static Optional<WriteTime> getWriteTime(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Memory_Properties::Write_Time";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new WriteTime(resolved, lookupContext, mode));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getWriteTime_EObject(NamedElement lookupContext) {
		String name = "Memory_Properties::Write_Time";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
}
