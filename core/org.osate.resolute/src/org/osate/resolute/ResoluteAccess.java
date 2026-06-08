/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.resolute;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.result.Diagnostic;

public interface ResoluteAccess {

	/**
	 * Runs Resolute on EMV2
	 * @param fundef
	 * @param instanceroot
	 * @param targetComponent
	 * @param targetElement
	 * @param parameterObjects
	 * @return
	 */
	public Diagnostic executeResoluteFunctionOnce(EObject fundef, final SystemInstance instanceroot,
			final ComponentInstance targetComponent, final InstanceObject targetElement,
			List<PropertyExpression> parameterObjects);

	/**
	 * Runs Resolute on Assure
	 * @param fundef
	 * @param targetComponent
	 * @param targetElement
	 * @param parameterObjects
	 * @return
	 */
	public EObject executeResoluteFunctionOnce(EObject fundef, final ComponentInstance targetComponent,
			final InstanceObject targetElement, List<PropertyExpression> parameterObjects);

	/**
	 * Given a Resolute ResoluteLibrary, returns a list of its definitions, or null if argument is not a Resolute ResoluteLibrary
	 * @param type - EObject that is an instance of com.rockwellcollins.atc.resolute.resolute.ResoluteLibrary
	 * @return List of EObject that are instances of com.rockwellcollins.atc.resolute.resolute.Definition,
	 * or null if argument is not a Resolute ResoluteLibrary
	 */
	public List<EObject> getDefinitions(EObject resoluteLibrary);

	/**
	 * Given an EObject, returns whether is is an instance of com.rockwellcollins.atc.resolute.resolute.FunctionDefinition
	 * @param type - EObject
	 * @return boolean indicating whether type argument is a Resolute FunctionDefinition
	 */
	public boolean isFunctionDefinition(EObject obj);

	/**
	 * Given a Resolute FunctionDefinition, returns a list of its arguments, or null if argument is not a Resolute FunctionDefinition
	 * @param functionDefinition - EObject that is an instance of com.rockwellcollins.atc.resolute.resolute.FunctionDefinition
	 * @return List of org.osate.aadl2.NamedElement that are instances of com.rockwellcollins.atc.resolute.resolute.Arg,
	 * or null if argument is not a Resolute FunctionDefinition
	 */
	public List<NamedElement> getArgs(EObject functionDefinition);

	/**
	 * Given a Resolute Arg, returns its Resolute Type, or null if argument is not a Resolute Arg
	 * @param arg - EObject that is an instance of com.rockwellcollins.atc.resolute.Arg
	 * @return EObject that is an instance com.rockwellcollins.atc.resolute.Type,
	 * or null if arg is not a Resolute Arg.
	 */
	public EObject getType(EObject arg);

	/**
	 * Given an EObject, returns whether is is an instance of com.rockwellcollins.atc.resolute.resolute.BaseType
	 * @param type - EObject
	 * @return boolean indicating whether type argument is a Resolute BaseType
	 */
	public boolean isBaseType(EObject type);

	/**
	 * Given a Resolute BaseType, returns the type name or an empty String if argument is not a Resolute BaseType
	 * @param baseType - EObject that is an instance of com.rockwellcollins.atc.resolute.resolute.BaseType
	 * @return String containing the type name of the argument, or an empty string if it is not a Resolute BaseType
	 */
	public String getTypeName(EObject baseType);

}
