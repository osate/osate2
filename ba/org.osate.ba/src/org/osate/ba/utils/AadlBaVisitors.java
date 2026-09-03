/**
 * AADL-BA-FrontEnd
 *
 * Copyright (c) 2011-2021 TELECOM ParisTech and CNRS
 *
 * TELECOM ParisTech/LTCI
 *
 * Authors: see AUTHORS
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 2.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see
 * https://www.eclipse.org/legal/epl-2.0/
 */

package org.osate.ba.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.Port;
import org.osate.aadl2.PrivatePackageSection;
import org.osate.ba.aadlba.AadlBaFactory;
import org.osate.ba.aadlba.BasicAction;
import org.osate.ba.aadlba.BehaviorAction;
import org.osate.ba.aadlba.BehaviorActionCollection;
import org.osate.ba.aadlba.BehaviorActions;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ba.aadlba.BehaviorState;
import org.osate.ba.aadlba.BehaviorTransition;
import org.osate.ba.aadlba.BehaviorVariable;
import org.osate.ba.aadlba.DispatchConjunction;
import org.osate.ba.aadlba.DispatchTrigger;
import org.osate.ba.aadlba.DispatchTriggerLogicalExpression;
import org.osate.ba.aadlba.ElseStatement;
import org.osate.ba.aadlba.IfStatement;
import org.osate.ba.aadlba.LoopStatement;
import org.osate.utils.internal.Aadl2Visitors;

/**
 * A collection of behavior annex visitors.
 */
public class AadlBaVisitors {
	// Some names.

	public static final String INITIALIZE_ENTRYPOINT_PROPERTYSET = "Programming_Properties";
	public static final String INITIALIZE_ENTRYPOINT_PROPERTY_NAME = "Initialize_Entrypoint";

	public static final String DISPATCH_PROTOCOL_PROPERTY_NAME = "Dispatch_Protocol";

	public static final String SEI_AADL2_PACKAGE_NAME = "org.osate.aadl2";

	public static final String SEI_AADL2_CLASSIFIER_SUFFIX = "Classifier";

	public static final long DEFAULT_TRANSITION_PRIORITY;

	static {
		DEFAULT_TRANSITION_PRIORITY = AadlBaFactory.eINSTANCE.createBehaviorTransition().getPriority();
	}

	/**
	* Returns a list of basic action contained in the given behavior
	* action (recursively).
	*
	* @param BehAction the given behavior action
	* @return a list of basic action contained in the given behavior
	* action
	*/
	public static EList<BasicAction> getBasicActions(BehaviorAction BehAction) {
		EList<BasicAction> result = null;

		if (BehAction instanceof BasicAction basicAction) {
			result = new BasicEList<>();
			result.add(basicAction);
		} else {
			// Case of an loop statements (excepted if statement).
			if (BehAction instanceof LoopStatement loop) {
				result = getBasicActions(loop.getBehaviorActions());
			} else if (BehAction instanceof IfStatement statement) {
				result = getBasicActions(statement.getBehaviorActions());

				if (statement.getElseStatement() != null) {
					result.addAll(getBasicActions(statement.getElseStatement().getBehaviorActions()));
				}
			} else // ElseStatement case.
			{
				var elseStat = (ElseStatement) BehAction;
				result = getBasicActions(elseStat.getBehaviorActions());
			}
		}

		return result;
	}

	/**
	* Return a list of the BasicAction objects contained in a given BehaviorActions
	* object (recursively). If the given BehaviorActions object is {@code null},
	* the returned list is empty.
	*
	* @param BehActions the given BehaviorActions object or {@code null} (for
	* batch processing purpose)
	* @return the list of BasicAction contained in the given BehaviorActions
	* object. May be empty.
	*/
	public static EList<BasicAction> getBasicActions(BehaviorActions BehActions) {
		var result = new BasicEList<BasicAction>();

		// A behavior transition may have no behavior actions.
		if (BehActions != null) {
			// Case of single behavior action.
			if (BehActions instanceof BehaviorAction action) {
				result.addAll(getBasicActions(action));
			} else // Case of BehaviorActionCollection.
			{
				for (var BehAct : ((BehaviorActionCollection) BehActions).getActions()) {
					result.addAll(getBasicActions(BehAct));
				}
			}
		}

		return result;
	}

	/**
	* Return the package sections related to a given BehaviorAnnex. As
	* "Classifier declarations in public sections are accessible to other
	* packages, while classifiers in private sections can only be referenced
	* within the private section of the same package".<br><br>
	* table[0] always refers to public section.
	* If the given BehaviorAnnex is declared in a private section, table's
	* length equals to 2 and table[1] refers to the private section.
	*
	* @param ba The given BehaviorAnnex
	* @return the package sections related to the given BehaviorAnnex.
	*/
	public static PackageSection[] getBaPackageSections(BehaviorAnnex ba) {
		return getBaPackageSections(ba, null);
	}

	/**
	 * Return the package sections related to a behavior annex, using the given component classifier when the annex is
	 * detached from its AADL containment hierarchy.
	 *
	 * @param ba the behavior annex
	 * @param fallback the component classifier to use for a detached annex
	 * @return the package sections related to the behavior annex
	 */
	public static PackageSection[] getBaPackageSections(BehaviorAnnex ba, ComponentClassifier fallback) {
		PackageSection result[];
		var container = Aadl2Visitors.getContainingPackageSection(ba);
		if (container == null && fallback != null) {
			container = Aadl2Visitors.getContainingPackageSection(fallback);
		}

		// Init contexts tab with current package's sections.
		// Private section is also investigated only if ba is declared in
		// package's private section.
		if (container instanceof PrivatePackageSection) {
			result = new PackageSection[2];
			result[1] = container;
			result[0] = ((AadlPackage) container.eContainer()).getPublicSection();
		} else {
			result = new PackageSection[1];
			result[0] = container;
		}

		return result;
	}

	/**
	* Find the first occurrence of an BehaviorVariable within a given
	* BehaviorAnnex which name equals to the given name. Return {@code null}
	* if no BehaviorVariable is found.
	*
	* @param ba the given BehaviorAnnex
	* @param variableName the given name
	* @return the first occurrence of an BehaviorVariable related to the given
	* name or {@code null}.
	*/
	public static BehaviorVariable findBehaviorVariable(BehaviorAnnex ba, String variableName) {
		for (var v : ba.getVariables()) {
			if (v.getName().equalsIgnoreCase(variableName)) {
				return v;
			}
		}
		return null;
	}

	/**
	* Find the first occurrence of an BehaviorState within a given BehaviorAnnex
	* which name equals to a given name. Return {@code null} if no
	* BehaviorState is found.
	*
	* @param ba the given BehaviorAnnex
	* @param stateName the given name
	* @return the first occurrence of an BehaviorState related to the given name
	* or {@code null}
	*/
	public static BehaviorState findBehaviorState(BehaviorAnnex ba, String stateName) {
		for (var s : ba.getStates()) {
			if (stateName.equalsIgnoreCase(s.getName())) {
				return s;
			}
		}
		return null;
	}

	/**
	* Return a list of DispatchTrigger objects contained in the given
	* DispatchTriggerLogicelExpression object. The list may be empty but not
	* {@code null}.
	*
	* @param dtle the given DispatchTriggerLogicelExpression object
	* @return a list of DispatchTrigger objects, eventually empty.
	*/
	public static EList<DispatchTrigger> getDispatchTriggers(DispatchTriggerLogicalExpression dtle) {
		var result = new BasicEList<DispatchTrigger>();

		for (var dc : dtle.getDispatchConjunctions()) {
			result.addAll(dc.getDispatchTriggers());
		}

		return result;
	}

	/**
	* Returns the behavior annex's parent component.
	*
	* @param ba the behavior annex
	* @return the behavior annex's parent component
	*/
	public static ComponentClassifier getParentComponent(BehaviorAnnex ba) {
		return getParentComponent(ba, null);
	}

	/**
	 * Returns the behavior annex's parent component, using the given classifier when the annex is detached.
	 *
	 * @param ba the behavior annex
	 * @param fallback the component classifier to use for a detached annex
	 * @return the behavior annex's parent component
	 */
	public static ComponentClassifier getParentComponent(BehaviorAnnex ba, ComponentClassifier fallback) {
		var result = (ComponentClassifier) ba.getContainingClassifier();
		return result == null ? fallback : result;
	}

	protected static final Map<BehaviorAnnex, Set<Port>> _IS_FRESH = new WeakHashMap<>();

	/**
	 * Return {@code true} if the given port which is contained in the given
	 * BehaviorAnnex object is used as a fresh port value. Otherwise return
	 * {@code false}.
	 *
	 * @param ba the given BehaviorAnnex object which contains the given port
	 * @param port the given port
	 * @return {@code true} if the given is used as a fresh port value.
	 * Otherwise {@code false}
	 */
	public static boolean isFresh(BehaviorAnnex ba, Port port) {
		var ports = _IS_FRESH.get(ba);
		if (ports != null) {
			return ports.contains(port);
		} else {
			return false;
		}
	}

	/**
	 * Tag the given port as a port used as a fresh port value.
	 *
	 * @param ba the BehaviorAnnex object which contains the given port
	 * @param port the given port
	 */
	public static void putFreshPort(BehaviorAnnex ba, Port port) {
		var ports = _IS_FRESH.get(ba);
		if (ports == null) {
			ports = new HashSet<>();
			_IS_FRESH.put(ba, ports);
		}

		ports.add(port);
	}

	/**
	 * Return a list of behavior transitions where the given behavior state is
	 * the source state. May return empty list.<br><br>
	 *
	 * The list of behavior transitions is sorted according to:<br><br>
	 * _ the behavior priority (highest to the lowest).<br>
	 * _ the behavior transitions which have "otherwise" execution condition are
	 *   set at the end of the list.<br>
	 * _ in case of equality, the order of behavior transition appearance in the
	 *   aadl code is applied.<br><br>
	 *
	 * @param state the given behavior state
	 * @return the list of behavior transitions where the given behavior state is
	 * the source state or an empty list
	 */
	public static List<BehaviorTransition> getTransitionWhereSrc(BehaviorState state) {
		var result = new BasicEList<BehaviorTransition>(state.getOutgoingTransitions());
		sort(result);
		return result;
	}

	/**
	 * Specify that the given behavior state is the source state of the given
	 * behavior transition.
	 *
	 * @param state the given behavior state
	 * @param bt the given behavior transition where the the given behavior state
	 * is source
	 */
	@Deprecated
	public static void putTransitionWhereSrc(BehaviorState state, BehaviorTransition bt) {
		var list = state.getOutgoingTransitions();

		if (list == null) {
			return;
		}

		if (!list.contains(bt)) {
			addAndSort(list, bt);
		}
	}

	// Add the given behavior transition to the given list and sort the list.
	protected static void addAndSort(List<BehaviorTransition> btl, BehaviorTransition bt) {
		// TODO to be optimized.
		btl.add(bt);
		sort(btl);
	}

	// Sort (insertion) behavior transitions list
	// according to their priority (highest to the lowest).
	// In case of equality, the order of transition appearance in the aadl
	// code is applied.
	// Behavior transition which have execution condition set to "otherwise"
	// will be set at the end of the list.
	/**
	 * @since 4.0
	 */
	protected static void sort(List<BehaviorTransition> btl) {
		for (var i = btl.size() - 2; i >= 0; i--) {
			var tmp = btl.get(i);
			var j = i;

			while (j < btl.size() - 1 && AadlBaUtils.compareBehaviorTransitionPriority(btl.get(j + 1), tmp)) {
				btl.set(j, btl.get(j + 1));
				j++;
			}

			btl.set(j, tmp);
		}
	}

}
