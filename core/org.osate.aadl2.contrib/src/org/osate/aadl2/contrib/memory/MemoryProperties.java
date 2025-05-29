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
package org.osate.aadl2.contrib.memory;

import java.util.Optional;
import java.util.OptionalLong;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.contrib.aadlproject.SizeUnits;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
import org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.pluginsupport.properties.CodeGenUtil;
import org.osate.pluginsupport.properties.IntegerRangeWithUnits;
import org.osate.pluginsupport.properties.IntegerWithUnits;

public final class MemoryProperties {
	public static final String MEMORY_PROPERTIES__NAME = "Memory_Properties";
	
	private MemoryProperties() {}
	
	// Lookup methods for Memory_Properties::Access_Right
	
	public static final String ACCESS_RIGHT__NAME = "Access_Right";
	
	public static boolean acceptsAccessRight(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getAccessRight_Property(lookupContext));
	}
	
	public static Optional<AccessRights> getAccessRight(NamedElement lookupContext) {
		return getAccessRight(lookupContext, Optional.empty());
	}
	
	public static Optional<AccessRights> getAccessRight(NamedElement lookupContext, Mode mode) {
		return getAccessRight(lookupContext, Optional.of(mode));
	}
	
	public static Optional<AccessRights> getAccessRight(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getAccessRight_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(AccessRights.valueOf(resolved));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getAccessRight_Property(EObject lookupContext) {
		String name = MEMORY_PROPERTIES__NAME + "::" + ACCESS_RIGHT__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getAccessRight_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getAccessRight_Property(lookupContext));
	}
	
	// Lookup methods for Memory_Properties::Access_Time
	
	public static final String ACCESS_TIME__NAME = "Access_Time";
	
	public static boolean acceptsAccessTime(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getAccessTime_Property(lookupContext));
	}
	
	public static Optional<AccessTime> getAccessTime(NamedElement lookupContext) {
		return getAccessTime(lookupContext, Optional.empty());
	}
	
	public static Optional<AccessTime> getAccessTime(NamedElement lookupContext, Mode mode) {
		return getAccessTime(lookupContext, Optional.of(mode));
	}
	
	public static Optional<AccessTime> getAccessTime(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getAccessTime_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new AccessTime(resolved, lookupContext, mode));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getAccessTime_Property(EObject lookupContext) {
		String name = MEMORY_PROPERTIES__NAME + "::" + ACCESS_TIME__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getAccessTime_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getAccessTime_Property(lookupContext));
	}
	
	// Lookup methods for Memory_Properties::Allowed_Message_Size
	
	public static final String ALLOWED_MESSAGE_SIZE__NAME = "Allowed_Message_Size";
	
	public static boolean acceptsAllowedMessageSize(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getAllowedMessageSize_Property(lookupContext));
	}
	
	public static Optional<IntegerRangeWithUnits<SizeUnits>> getAllowedMessageSize(NamedElement lookupContext) {
		return getAllowedMessageSize(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerRangeWithUnits<SizeUnits>> getAllowedMessageSize(NamedElement lookupContext, Mode mode) {
		return getAllowedMessageSize(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerRangeWithUnits<SizeUnits>> getAllowedMessageSize(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getAllowedMessageSize_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerRangeWithUnits<>(resolved, SizeUnits.class, lookupContext, mode));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getAllowedMessageSize_Property(EObject lookupContext) {
		String name = MEMORY_PROPERTIES__NAME + "::" + ALLOWED_MESSAGE_SIZE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getAllowedMessageSize_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getAllowedMessageSize_Property(lookupContext));
	}
	
	// Lookup methods for Memory_Properties::Assign_Time
	
	public static final String ASSIGN_TIME__NAME = "Assign_Time";
	
	public static boolean acceptsAssignTime(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getAssignTime_Property(lookupContext));
	}
	
	public static Optional<AssignTime> getAssignTime(NamedElement lookupContext) {
		return getAssignTime(lookupContext, Optional.empty());
	}
	
	public static Optional<AssignTime> getAssignTime(NamedElement lookupContext, Mode mode) {
		return getAssignTime(lookupContext, Optional.of(mode));
	}
	
	public static Optional<AssignTime> getAssignTime(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getAssignTime_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new AssignTime(resolved, lookupContext, mode));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getAssignTime_Property(EObject lookupContext) {
		String name = MEMORY_PROPERTIES__NAME + "::" + ASSIGN_TIME__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getAssignTime_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getAssignTime_Property(lookupContext));
	}
	
	// Lookup methods for Memory_Properties::Base_Address
	
	public static final String BASE_ADDRESS__NAME = "Base_Address";
	
	public static boolean acceptsBaseAddress(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getBaseAddress_Property(lookupContext));
	}
	
	public static OptionalLong getBaseAddress(NamedElement lookupContext) {
		return getBaseAddress(lookupContext, Optional.empty());
	}
	
	public static OptionalLong getBaseAddress(NamedElement lookupContext, Mode mode) {
		return getBaseAddress(lookupContext, Optional.of(mode));
	}
	
	public static OptionalLong getBaseAddress(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getBaseAddress_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalLong.of(((IntegerLiteral) resolved).getValue());
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return OptionalLong.empty();
		}
	}
	
	public static Property getBaseAddress_Property(EObject lookupContext) {
		String name = MEMORY_PROPERTIES__NAME + "::" + BASE_ADDRESS__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getBaseAddress_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getBaseAddress_Property(lookupContext));
	}
	
	// Lookup methods for Memory_Properties::Device_Register_Address
	
	public static final String DEVICE_REGISTER_ADDRESS__NAME = "Device_Register_Address";
	
	public static boolean acceptsDeviceRegisterAddress(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getDeviceRegisterAddress_Property(lookupContext));
	}
	
	public static OptionalLong getDeviceRegisterAddress(NamedElement lookupContext) {
		return getDeviceRegisterAddress(lookupContext, Optional.empty());
	}
	
	public static OptionalLong getDeviceRegisterAddress(NamedElement lookupContext, Mode mode) {
		return getDeviceRegisterAddress(lookupContext, Optional.of(mode));
	}
	
	public static OptionalLong getDeviceRegisterAddress(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getDeviceRegisterAddress_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalLong.of(((IntegerLiteral) resolved).getValue());
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return OptionalLong.empty();
		}
	}
	
	public static Property getDeviceRegisterAddress_Property(EObject lookupContext) {
		String name = MEMORY_PROPERTIES__NAME + "::" + DEVICE_REGISTER_ADDRESS__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getDeviceRegisterAddress_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getDeviceRegisterAddress_Property(lookupContext));
	}
	
	// Lookup methods for Memory_Properties::Read_Time
	
	public static final String READ_TIME__NAME = "Read_Time";
	
	public static boolean acceptsReadTime(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getReadTime_Property(lookupContext));
	}
	
	public static Optional<ReadTime> getReadTime(NamedElement lookupContext) {
		return getReadTime(lookupContext, Optional.empty());
	}
	
	public static Optional<ReadTime> getReadTime(NamedElement lookupContext, Mode mode) {
		return getReadTime(lookupContext, Optional.of(mode));
	}
	
	public static Optional<ReadTime> getReadTime(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getReadTime_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new ReadTime(resolved, lookupContext, mode));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getReadTime_Property(EObject lookupContext) {
		String name = MEMORY_PROPERTIES__NAME + "::" + READ_TIME__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getReadTime_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getReadTime_Property(lookupContext));
	}
	
	// Lookup methods for Memory_Properties::Code_Size
	
	public static final String CODE_SIZE__NAME = "Code_Size";
	
	public static boolean acceptsCodeSize(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getCodeSize_Property(lookupContext));
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getCodeSize(NamedElement lookupContext) {
		return getCodeSize(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getCodeSize(NamedElement lookupContext, Mode mode) {
		return getCodeSize(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getCodeSize(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getCodeSize_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, SizeUnits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getCodeSize_Property(EObject lookupContext) {
		String name = MEMORY_PROPERTIES__NAME + "::" + CODE_SIZE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getCodeSize_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getCodeSize_Property(lookupContext));
	}
	
	// Lookup methods for Memory_Properties::Data_Size
	
	public static final String DATA_SIZE__NAME = "Data_Size";
	
	public static boolean acceptsDataSize(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getDataSize_Property(lookupContext));
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getDataSize(NamedElement lookupContext) {
		return getDataSize(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getDataSize(NamedElement lookupContext, Mode mode) {
		return getDataSize(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getDataSize(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getDataSize_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, SizeUnits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getDataSize_Property(EObject lookupContext) {
		String name = MEMORY_PROPERTIES__NAME + "::" + DATA_SIZE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getDataSize_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getDataSize_Property(lookupContext));
	}
	
	// Lookup methods for Memory_Properties::Heap_Size
	
	public static final String HEAP_SIZE__NAME = "Heap_Size";
	
	public static boolean acceptsHeapSize(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getHeapSize_Property(lookupContext));
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getHeapSize(NamedElement lookupContext) {
		return getHeapSize(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getHeapSize(NamedElement lookupContext, Mode mode) {
		return getHeapSize(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getHeapSize(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getHeapSize_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, SizeUnits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getHeapSize_Property(EObject lookupContext) {
		String name = MEMORY_PROPERTIES__NAME + "::" + HEAP_SIZE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getHeapSize_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getHeapSize_Property(lookupContext));
	}
	
	// Lookup methods for Memory_Properties::Stack_Size
	
	public static final String STACK_SIZE__NAME = "Stack_Size";
	
	public static boolean acceptsStackSize(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getStackSize_Property(lookupContext));
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getStackSize(NamedElement lookupContext) {
		return getStackSize(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getStackSize(NamedElement lookupContext, Mode mode) {
		return getStackSize(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getStackSize(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getStackSize_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, SizeUnits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getStackSize_Property(EObject lookupContext) {
		String name = MEMORY_PROPERTIES__NAME + "::" + STACK_SIZE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getStackSize_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getStackSize_Property(lookupContext));
	}
	
	// Lookup methods for Memory_Properties::Memory_Size
	
	public static final String MEMORY_SIZE__NAME = "Memory_Size";
	
	public static boolean acceptsMemorySize(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getMemorySize_Property(lookupContext));
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getMemorySize(NamedElement lookupContext) {
		return getMemorySize(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getMemorySize(NamedElement lookupContext, Mode mode) {
		return getMemorySize(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getMemorySize(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getMemorySize_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, SizeUnits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getMemorySize_Property(EObject lookupContext) {
		String name = MEMORY_PROPERTIES__NAME + "::" + MEMORY_SIZE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getMemorySize_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getMemorySize_Property(lookupContext));
	}
	
	// Lookup methods for Memory_Properties::Word_Size
	
	public static final String WORD_SIZE__NAME = "Word_Size";
	
	public static boolean acceptsWordSize(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getWordSize_Property(lookupContext));
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getWordSize(NamedElement lookupContext) {
		return getWordSize(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getWordSize(NamedElement lookupContext, Mode mode) {
		return getWordSize(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getWordSize(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getWordSize_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, SizeUnits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getWordSize_Property(EObject lookupContext) {
		String name = MEMORY_PROPERTIES__NAME + "::" + WORD_SIZE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getWordSize_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getWordSize_Property(lookupContext));
	}
	
	// Lookup methods for Memory_Properties::Word_Space
	
	public static final String WORD_SPACE__NAME = "Word_Space";
	
	public static boolean acceptsWordSpace(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getWordSpace_Property(lookupContext));
	}
	
	public static OptionalLong getWordSpace(NamedElement lookupContext) {
		return getWordSpace(lookupContext, Optional.empty());
	}
	
	public static OptionalLong getWordSpace(NamedElement lookupContext, Mode mode) {
		return getWordSpace(lookupContext, Optional.of(mode));
	}
	
	public static OptionalLong getWordSpace(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getWordSpace_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalLong.of(((IntegerLiteral) resolved).getValue());
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return OptionalLong.empty();
		}
	}
	
	public static Property getWordSpace_Property(EObject lookupContext) {
		String name = MEMORY_PROPERTIES__NAME + "::" + WORD_SPACE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getWordSpace_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getWordSpace_Property(lookupContext));
	}
	
	// Lookup methods for Memory_Properties::Write_Time
	
	public static final String WRITE_TIME__NAME = "Write_Time";
	
	public static boolean acceptsWriteTime(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getWriteTime_Property(lookupContext));
	}
	
	public static Optional<WriteTime> getWriteTime(NamedElement lookupContext) {
		return getWriteTime(lookupContext, Optional.empty());
	}
	
	public static Optional<WriteTime> getWriteTime(NamedElement lookupContext, Mode mode) {
		return getWriteTime(lookupContext, Optional.of(mode));
	}
	
	public static Optional<WriteTime> getWriteTime(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getWriteTime_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new WriteTime(resolved, lookupContext, mode));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getWriteTime_Property(EObject lookupContext) {
		String name = MEMORY_PROPERTIES__NAME + "::" + WRITE_TIME__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getWriteTime_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getWriteTime_Property(lookupContext));
	}
	
	// Lookup methods for Memory_Properties::Source_Code_Size
	
	public static final String SOURCE_CODE_SIZE__NAME = "Source_Code_Size";
	
	public static boolean acceptsSourceCodeSize(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getSourceCodeSize_Property(lookupContext));
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getSourceCodeSize(NamedElement lookupContext) {
		return getSourceCodeSize(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getSourceCodeSize(NamedElement lookupContext, Mode mode) {
		return getSourceCodeSize(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getSourceCodeSize(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getSourceCodeSize_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, SizeUnits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getSourceCodeSize_Property(EObject lookupContext) {
		String name = MEMORY_PROPERTIES__NAME + "::" + SOURCE_CODE_SIZE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getSourceCodeSize_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getSourceCodeSize_Property(lookupContext));
	}
	
	// Lookup methods for Memory_Properties::Source_Data_Size
	
	public static final String SOURCE_DATA_SIZE__NAME = "Source_Data_Size";
	
	public static boolean acceptsSourceDataSize(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getSourceDataSize_Property(lookupContext));
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getSourceDataSize(NamedElement lookupContext) {
		return getSourceDataSize(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getSourceDataSize(NamedElement lookupContext, Mode mode) {
		return getSourceDataSize(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getSourceDataSize(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getSourceDataSize_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, SizeUnits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getSourceDataSize_Property(EObject lookupContext) {
		String name = MEMORY_PROPERTIES__NAME + "::" + SOURCE_DATA_SIZE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getSourceDataSize_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getSourceDataSize_Property(lookupContext));
	}
	
	// Lookup methods for Memory_Properties::Source_Heap_Size
	
	public static final String SOURCE_HEAP_SIZE__NAME = "Source_Heap_Size";
	
	public static boolean acceptsSourceHeapSize(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getSourceHeapSize_Property(lookupContext));
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getSourceHeapSize(NamedElement lookupContext) {
		return getSourceHeapSize(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getSourceHeapSize(NamedElement lookupContext, Mode mode) {
		return getSourceHeapSize(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getSourceHeapSize(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getSourceHeapSize_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, SizeUnits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getSourceHeapSize_Property(EObject lookupContext) {
		String name = MEMORY_PROPERTIES__NAME + "::" + SOURCE_HEAP_SIZE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getSourceHeapSize_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getSourceHeapSize_Property(lookupContext));
	}
	
	// Lookup methods for Memory_Properties::Source_Stack_Size
	
	public static final String SOURCE_STACK_SIZE__NAME = "Source_Stack_Size";
	
	public static boolean acceptsSourceStackSize(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getSourceStackSize_Property(lookupContext));
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getSourceStackSize(NamedElement lookupContext) {
		return getSourceStackSize(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getSourceStackSize(NamedElement lookupContext, Mode mode) {
		return getSourceStackSize(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getSourceStackSize(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getSourceStackSize_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, SizeUnits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getSourceStackSize_Property(EObject lookupContext) {
		String name = MEMORY_PROPERTIES__NAME + "::" + SOURCE_STACK_SIZE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getSourceStackSize_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getSourceStackSize_Property(lookupContext));
	}
	
	// Lookup methods for Memory_Properties::Byte_Count
	
	public static final String BYTE_COUNT__NAME = "Byte_Count";
	
	public static boolean acceptsByteCount(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getByteCount_Property(lookupContext));
	}
	
	public static OptionalLong getByteCount(NamedElement lookupContext) {
		return getByteCount(lookupContext, Optional.empty());
	}
	
	public static OptionalLong getByteCount(NamedElement lookupContext, Mode mode) {
		return getByteCount(lookupContext, Optional.of(mode));
	}
	
	public static OptionalLong getByteCount(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getByteCount_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalLong.of(((IntegerLiteral) resolved).getValue());
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return OptionalLong.empty();
		}
	}
	
	public static Property getByteCount_Property(EObject lookupContext) {
		String name = MEMORY_PROPERTIES__NAME + "::" + BYTE_COUNT__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getByteCount_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getByteCount_Property(lookupContext));
	}
}
