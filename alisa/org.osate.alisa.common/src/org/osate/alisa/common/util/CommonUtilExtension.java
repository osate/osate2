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
package org.osate.alisa.common.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Connection;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.alisa.common.common.AModelReference;
import org.osate.alisa.common.common.AVariableReference;
import org.osate.alisa.common.common.ComputeDeclaration;
import org.osate.alisa.common.common.Description;
import org.osate.alisa.common.common.DescriptionElement;
import org.osate.alisa.common.common.ValDeclaration;
import org.osate.alisa.common.typing.CommonInterpreter;

public class CommonUtilExtension {
	private static CommonInterpreter interpreter = IResourceServiceProvider.Registry.INSTANCE
			.getResourceServiceProvider(URI.createFileURI("dummy.___common___"))
			.get(CommonInterpreter.class);

	public static String toText(final Description description, final NamedElement target) {
		var result = new StringBuilder();
		for (var element : description.getDescription()) {
			result.append(toText(element, target));
		}
		return result.toString();
	}

	private static String stripNewlineTab(final String text) {
		if (text.contains("\n")) {
			return text.replace("\n", " ").replace("\r", "").replace("\t", "");
		}
		if (text.contains("\r")) {
			return text.replace("\r", " ").replace("\t", "");
		}
		return text.replace("\t", " ");
	}

	public static String toText(final DescriptionElement descriptionElement, final NamedElement target) {
		if (descriptionElement.getText() != null) {
			return stripNewlineTab(descriptionElement.getText());
		}
		if (descriptionElement.isThisTarget() && target != null) {
			return target.getQualifiedName();
		}

		var declaration = descriptionElement.getShowValue();
		if (declaration == null) {
			return "";
		}
		if (declaration.eIsProxy()) {
			return "TBD";
		}

		var variable = ((AVariableReference) declaration.getExpression()).getVariable();
		return switch (variable) {
		case ComputeDeclaration computeDeclaration -> computeDeclaration.getName();
		case ValDeclaration valueDeclaration -> {
			var expression = valueDeclaration.getValue();
			if (expression instanceof AModelReference modelReference) {
				yield toText(modelReference);
			}
			if (target instanceof InstanceObject) {
				var environment = new RuleEnvironment();
				environment.add("vals", new HashMap<String, PropertyExpression>());
				environment.add("computes", new HashMap<String, Object>());
				environment.add("target", target);
				var result = interpreter.interpretExpression(environment, declaration);
				if (result.failed()) {
					yield "Could not evaluate expression for " + valueDeclaration.getName() + ": "
							+ getFailedMsg(result.getRuleFailedException());
				}
				var value = result.getValue();
				yield value == null ? "TBD" : value.toString();
			}
			yield "value of '" + valueDeclaration.getName() + "'";
		}
		case null, default -> null;
		};
	}

	public static String getFailedMsg(final Throwable throwable) {
		var rootCause = throwable;
		while (rootCause.getCause() != null && !Objects.equals(rootCause.getCause(), rootCause)) {
			rootCause = rootCause.getCause();
		}
		return rootCause.getMessage();
	}

	public static String toText(final AModelReference modelReference) {
		if (modelReference.getPrev() == null) {
			return "this";
		}
		var modelElement = modelReference.getModelElement();
		return toText(modelReference.getPrev()) + "." + (modelElement == null ? null : modelElement.getName());
	}

	// From GetProperties: May need to use it for actual values from compute.
//	public static String toStringScaled(final double value, final UnitLiteral unit) {
//		var targetLiteral = scaleupUnit(value, unit);
//		var result = value;
//		if (targetLiteral != unit) {
//			result = convertToScale(value, unit, targetLiteral);
//		}
//		return String.format("%.3f " + targetLiteral.getName(), result);
//	}

	public static boolean isSameorExtends(final Classifier target, final Classifier ancestor) {
		if (Aadl2Util.isNull(target) || Aadl2Util.isNull(ancestor)) {
			return false;
		}
		Classifier extended = target;
		if (target instanceof ComponentImplementation implementation && ancestor instanceof ComponentType) {
			extended = implementation.getType();
		}
		while (!Aadl2Util.isNull(extended)) {
			if (ancestor.getName().equalsIgnoreCase(extended.getName())) {
				return true;
			}
			extended = extended.getExtended();
		}
		return false;
	}

	public static boolean isSameorExtendsURI(final ComponentClassifier target, final URI ancestorURI) {
		if (target == null || ancestorURI == null) {
			return false;
		}
		Classifier extended = target;
		while (extended != null) {
			if (Objects.equals(ancestorURI, EcoreUtil.getURI(extended))) {
				return true;
			}
			extended = extended.getExtended();
		}
		if (target instanceof ComponentImplementation implementation) {
			extended = implementation.getType();
			while (extended != null) {
				if (Objects.equals(ancestorURI, EcoreUtil.getURI(extended))) {
					return true;
				}
				extended = extended.getExtended();
			}
		}
		return false;
	}

	public static InstanceObject findElementInstance(final ComponentInstance componentInstance,
			final NamedElement element) {
		var name = element.getName();
		return switch (element) {
		case EndToEndFlow ignored -> findETEFInstance(componentInstance.getEndToEndFlows(), name);
		case Subcomponent ignored -> findElementInstanceInList(componentInstance.getComponentInstances(), name);
		case Feature ignored -> findElementInstanceInList(componentInstance.getFeatureInstances(), name);
		case FlowSpecification ignored -> findElementInstanceInList(componentInstance.getFlowSpecifications(), name);
		case Connection ignored -> findConnectionInstance(componentInstance.getConnectionInstances(), name);
		default -> null;
		};
	}

	public static InstanceObject findElementInstanceInList(final List<? extends InstanceObject> instances,
			final String name) {
		for (var instance : instances) {
			if (instance.getName().equalsIgnoreCase(name)) {
				return instance;
			}
		}
		return null;
	}

	public static ConnectionInstance findConnectionInstance(final Collection<ConnectionInstance> connectionInstances,
			final String name) {
		for (var connectionInstance : connectionInstances) {
			var connection = getCrossConnection(connectionInstance);
			if (connection != null && name.equalsIgnoreCase(connection.getName())) {
				return connectionInstance;
			}
		}
		return null;
	}

	/**
	 * @since 2.0
	 */
	public static EndToEndFlowInstance findETEFInstance(final Collection<EndToEndFlowInstance> flowInstances,
			final String name) {
		for (var flowInstance : flowInstances) {
			var flow = flowInstance.getEndToEndFlow();
			if (flow != null && name.equalsIgnoreCase(flow.getName())) {
				return flowInstance;
			}
		}
		return null;
	}

	public static Collection<ConnectionInstance> findConnectionInstances(
			final Collection<ConnectionInstance> connectionInstances, final ConnectionInstance connectionInstance) {
		var result = new ArrayList<ConnectionInstance>();
		var targetConnection = getCrossConnection(connectionInstance);
		for (var candidate : connectionInstances) {
			if (Objects.equals(targetConnection, getCrossConnection(candidate))) {
				result.add(candidate);
			}
		}
		return result;
	}

	public static Connection getCrossConnection(final ConnectionInstance connectionInstance) {
		for (var connectionReference : connectionInstance.getConnectionReferences()) {
			var connection = connectionReference.getConnection();
			if (connection.isAcross()) {
				return connection;
			}
		}
		return null;
	}

	public static Iterable<Connection> getCrossConnections(final ComponentImplementation componentImplementation) {
		var connections = componentImplementation.getAllConnections();
		return () -> connections.stream().filter(Connection::isAcross).iterator();
	}

	public static final CommonUtilExtension eInstance = new CommonUtilExtension();

	/**
	 * @since 2.0
	 */
	public static Collection<EndToEndFlowInstance> findETEFInstances(
			final Collection<EndToEndFlowInstance> flowInstances, final EndToEndFlowInstance flowInstance) {
		var result = new ArrayList<EndToEndFlowInstance>();
		var targetFlow = flowInstance.getEndToEndFlow();
		for (var candidate : flowInstances) {
			if (Objects.equals(targetFlow, candidate.getEndToEndFlow())) {
				result.add(candidate);
			}
		}
		return result;
	}
}
