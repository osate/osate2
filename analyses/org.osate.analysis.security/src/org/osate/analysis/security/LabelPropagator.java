/*******************************************************************************
 * Copyright (c) 2004-2023 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.analysis.security;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Optional;

import org.eclipse.e4.core.services.log.Logger;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.xbase.lib.Pair;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.Element;
import org.osate.aadl2.Property;
import org.osate.aadl2.contrib.deployment.DeploymentProperties;
import org.osate.aadl2.impl.BooleanLiteralImpl;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;

/**
 * Propagates a model instance and ensures that all features and components have an associated min/max/current
 * {@link SecurityLabel}.
 *
 */
@SuppressWarnings("restriction")
class LabelPropagator extends InstanceSwitch<Boolean> {

	/// Property name used for trusted flow paths
	public static final String TRUSTED_PROPERTY_NAME = "SecurityClassificationProperties::Trusted";

	private Logger logger = PlatformUI.getWorkbench().getService(org.eclipse.e4.core.services.log.Logger.class);

	/// Operation mode used during this analysis
	final private SystemOperationMode som;

	LabelPropagator(SystemOperationMode som) {
		this.som = som;
	}

	/**
	 * Propagates the security Labels on a System instance.
	 *
	 * @param ci System instance (root)
	 */
	void propagate(SystemInstance ci) {
		propagate(ci, Optional.empty());
		propagateHighestBindings(ci);
	}

	/**
	 * Propagates component and feature instances contained in the provided instance and determines the {@code upperLimit}, {@code highestChildLabel} and {@code current} security labels.
	 * All three levels will be associated with the current {@code ci}, using the {@link LabelUtil} functionality.
	 *
	 * The current (or default label) is the one associated with the component in the AADL description.
	 * This includes inherited property associations.
	 *
	 * The highestChildLabel is the lowest required security label, based on sub components and features and their respective security labels.
	 *
	 * The upperLimit label is the highest allowed security label which is determined by the encapsulating parent component or {@code ci}'s property association.
	 *
	 * @param ci Propagation starting point
	 * @param parentmax Highest security level of the encapsulating parent component.
	 * @return Security level of {@code ci}, if present
	 */
	private Optional<SecurityLabel> propagate(ComponentInstance ci, Optional<SecurityLabel> parentmax) {
		if (!ci.getInModes().isEmpty() && !ci.isActive(som)) {
			return Optional.empty();
		}

		Optional<SecurityLabel> current = SecurityLabel.of(ci);

		Optional<SecurityLabel> upperLimit = current.isPresent() ? current : parentmax;
		Optional<SecurityLabel> highestChild = Optional.empty();
		highestChild = ci.getComponentInstances()
				.stream()
				.reduce(highestChild, (l, c) -> LabelUtil.join(l, propagate(c, upperLimit)), LabelUtil::join);
		highestChild = ci.getFeatureInstances()
				.stream()
				.reduce(highestChild, (l, f) -> LabelUtil.join(l, propagate(f, upperLimit)), LabelUtil::join);

		LabelUtil.setLabel(ci, current);
		LabelUtil.setHighestChildLabel(ci, highestChild);
		LabelUtil.setUpperLabelLimit(ci, parentmax);
		Pair<Integer, Integer> pairStats = countFlows(ci);
		LabelUtil.setFlowStats(ci, pairStats != null ? Optional.of(pairStats) : Optional.empty());

		logger.info("component " + ci.getName() + ": " + highestChild + " <= " + current + " <= " + parentmax);
		return current;
	}

	/**
	 * Propagates feature instances contained in the provided instance and determines the {@code upperLimit}, {@code highestChildLabel} and {@code current} security labels.
	 * All three levels will be associated with the current {@code fi}, using the {@link LabelUtil} functionality.
	 *
	 * The current (or default label) is the one associated with the feature in the AADL description.
	 * This includes inherited property associations.
	 *
	 * The highestChildLabel is the lowest required security label, based on child-features and their respective security labels.
	 *
	 * The upperLimit label is the highest allowed security label which is determined by the encapsulating parent component or {@code fi}'s property association.
	 *
	 * @param fi Propagation starting point
	 * @param parentmax Highest security level of the encapsulating parent component.
	 * @return Security level of {@code fi}, if present
	 */
	private Optional<SecurityLabel> propagate(FeatureInstance fi, Optional<SecurityLabel> parentmax) {
		if (!fi.isActive(som)) {
			return Optional.empty();
		}
		Optional<SecurityLabel> current = SecurityLabel.of(fi);

		Optional<SecurityLabel> upperLimit = current.isPresent() ? current : parentmax;
		Optional<SecurityLabel> highestChild = Optional.empty();
		highestChild = fi.getFeatureInstances()
				.stream()
				.reduce(highestChild, (l, f) -> LabelUtil.join(l, propagate(f, upperLimit)), LabelUtil::join);

		// Propagate Data types
		if (fi.getType() != null) {
			highestChild = LabelUtil.join(highestChild, propagate(fi.getType(), upperLimit));
		}

		LabelUtil.setLabel(fi, current);
		LabelUtil.setHighestChildLabel(fi, highestChild);
		LabelUtil.setUpperLabelLimit(fi, parentmax);

		logger.info("feature " + fi.getName() + ": " + highestChild + " <= " + current + " <= " + parentmax);
		return current;
	}

	/**
	 * Counts the number of flows and trusted flows for a given component and it's children.
	 *
	 * @param ci Root component
	 * @return Pair of total and trusted components
	 */
	private Pair<Integer, Integer> countFlows(ComponentInstance ci) {
		int flows = 0;
		int trustedFlows = 0;
		for (FlowSpecificationInstance fsi : ci.getFlowSpecifications()) {
			// skip all flows which are not active in the current mode
			if (!fsi.isActive(som)) {
				continue;
			}
			// Skip sinks and sources
			if (fsi.getSource() == null || fsi.getDestination() == null) {
				continue;
			}
			flows++;
			trustedFlows += LabelPropagator.isTrusted(fsi, som) ? 1 : 0;
		}

		// Pair containing total and trusted flow count
		Pair<Integer, Integer> stats = new Pair<>(flows, trustedFlows);

		for (ComponentInstance instance : ci.getComponentInstances()) {
			if (!ci.getInModes().isEmpty() && !ci.isActive(som)) {
				continue;
			}
			stats = addFlowStats(stats, countFlows(instance));
		}

		return stats;
	}

	/**
	 * Adds two pairs element wise.
	 * @param pair1 First pair
	 * @param pair2 Second pair
	 * @return New pair with element wise added key and value
	 */
	private Pair<Integer, Integer> addFlowStats(Pair<Integer, Integer> pair1, Pair<Integer, Integer> pair2) {
		return new Pair<>(pair1.getKey() + pair2.getKey(), pair1.getValue() + pair2.getValue());
	}

	/**
	 * Traverses the root instance objects and updates all referenced elements (via bindings),
	 * such that they hold the highest bound label.
	 *
	 * @param root element for which binding labels are updated
	 */
	private void propagateHighestBindings(InstanceObject root) {
		TreeIterator<Element> iter = EcoreUtil.getAllContents(root.eResource(), true);
		iter.forEachRemaining(e -> instanceSwitch.doSwitch(e));
	}

	private InstanceSwitch<Void> instanceSwitch = new InstanceSwitch<Void>() {

		/**
		 * Updates the max binding label in bound elements
		 */
		@Override
		public Void caseInstanceObject(InstanceObject io) {
			if (io instanceof ComponentInstance) {
				ComponentInstance ci = (ComponentInstance) io;
				if (!ci.getInModes().isEmpty() && !ci.isActive(som)) {
					return null;
				}
			} else {
				if (!io.isActive(som)) {
					return null;
				}
			}

			Optional<SecurityLabel> componentLabel = LabelUtil.getLabel(io) != null ? LabelUtil.getLabel(io)
					: Optional.empty();
			LinkedList<InstanceObject> bindings = new LinkedList<>();

			// Add processor, memory, connection and subprogram call bindings
			bindings.addAll(DeploymentProperties.getActualProcessorBinding(io).orElse(Collections.emptyList()));
			bindings.addAll(DeploymentProperties.getActualMemoryBinding(io).orElse(Collections.emptyList()));
			bindings.addAll(DeploymentProperties.getActualConnectionBinding(io).orElse(Collections.emptyList()));
			bindings.addAll(DeploymentProperties.getActualSubprogramCallBinding(io).orElse(Collections.emptyList()));

			// Go through all bindings and update their highest binding label to incorporate the one of this(current) component
			for (InstanceObject binding : bindings) {
				if (!binding.isActive(som)) {
					continue;
				}
				Optional<SecurityLabel> highestBindingLabel = LabelUtil.getHighestBindingLabel(binding) != null
						? LabelUtil.getHighestBindingLabel(binding)
						: Optional.empty();

				if (io instanceof ConnectionInstance || io instanceof ConnectionReference) {
					// use source, since destination must have a matching label
					ConnectionInstanceEnd src = (io instanceof ConnectionInstance)
							? ((ConnectionInstance) io).getSource()
							: ((ConnectionReference) io).getSource();

					componentLabel = LabelUtil.getLabel(src) != null ? LabelUtil.getLabel(src) : Optional.empty();
				}
				highestBindingLabel = LabelUtil.join(highestBindingLabel, componentLabel);
				LabelUtil.setHighestBindingLabel(binding, highestBindingLabel);
			}
			return null;
		}

	};

	/**
	 * Retrieves the value of the trusted flag for the provided component.
	 *
	 * @param ci Component for which the trusted property is checked
	 * @return True if the component has the Trusted property and it is set to true
	 */
	public static boolean isTrusted(InstanceObject io, SystemOperationMode som) {
		if (!io.isActive(som)) {
			return false;
		}
		Property trustedProperty = Aadl2GlobalScopeUtil.get(io, Aadl2Package.eINSTANCE.getProperty(),
				TRUSTED_PROPERTY_NAME);

		try {
			BooleanLiteralImpl booleanImpl = (BooleanLiteralImpl) io.getSimplePropertyValue(trustedProperty);
			if (booleanImpl != null) {
				return booleanImpl.getValue();
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}
}
