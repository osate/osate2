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
