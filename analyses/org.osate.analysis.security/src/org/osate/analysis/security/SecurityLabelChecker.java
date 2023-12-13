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
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.eclipse.e4.core.services.log.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.xbase.lib.Pair;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.aadl2.Feature;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.contrib.deployment.DeploymentProperties;
import org.osate.aadl2.instance.AnnexInstance;
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
import org.osate.result.AnalysisResult;
import org.osate.result.Result;
import org.osate.result.util.ResultUtil;

@SuppressWarnings("restriction")
public class SecurityLabelChecker {

	private Logger logger = PlatformUI.getWorkbench().getService(org.eclipse.e4.core.services.log.Logger.class);

	private static final Boolean DONE = Boolean.TRUE;

	private static final Boolean PRUNE = Boolean.FALSE;

	Result result;

	/// Operation mode used during this analysis
	final private SystemOperationMode som;

	public SecurityLabelChecker(SystemOperationMode som) {
		this.som = som;
	}

	public AnalysisResult invoke(SystemInstance root) {
		AnalysisResult analysisResult = ResultUtil.createAnalysisResult("Security", root);

		if (som.getCurrentModes().size() > 0) {
			for (ComponentInstance ci : root.getAllComponentInstances()) {
				ci.setCurrentMode(som.getCurrentModes().get(0));
			}
			root.setCurrentSystemOperationMode(som);
		}

		LabelPropagator propagator = new LabelPropagator(som);
		propagator.propagate(root);
		result = ResultUtil.createResult("", root);
		analysisResult.getResults().add(result);

		for (TreeIterator<Element> iter = EcoreUtil.getAllContents(root.eResource(), true); iter.hasNext();) {
			Element elem = iter.next();
			if (instanceSwitch.doSwitch(elem) == PRUNE) {
				iter.prune();
			}
		}

		return analysisResult;
	}

	private InstanceSwitch<Boolean> instanceSwitch = new InstanceSwitch<Boolean>() {

		/**
		 * Check if component containment complies with the security policy.
		 * Compare component's security label with the label of its container.
		 */
		@Override
		public Boolean caseComponentInstance(ComponentInstance ci) {
			if (!ci.getInModes().isEmpty() && !ci.isActive(som)) {
				return PRUNE;
			}

			// Annotate flow statistics
			Optional<Pair<Integer, Integer>> flowStats = LabelUtil.getFlowStats(ci) != null ? LabelUtil.getFlowStats(ci)
					: Optional.empty();
			flowStats.ifPresent(stats -> {
				if (stats.getKey() > 0) {
					String msg = "Component has " + stats.getKey() + " (nested) flows of which " + stats.getValue()
							+ " are trusted.";
					logger.info("Componet " + ci.getName() + msg);
					result.getDiagnostics().add(ResultUtil.createInfoDiagnostic(msg, ci));
				}
			});

			checkValidContainment(ci);
			checkBindingLeastPrivileges(ci);
			checkValidBindings(ci);
			findHiddenFlows(ci);
			return DONE;
		}

		/**
		 * Check feature for security policy compliance:
		 * Security labels of feature and associated data type must conform
		 * to policy.
		 */
		@Override
		public Boolean caseFeatureInstance(FeatureInstance fi) {
			if (!fi.isActive(som)) {
				return PRUNE;
			}

			checkFeatureClassifierLabelEquality(fi);
			checkValidContainment(fi);
			checkBindingLeastPrivileges(fi);
			checkValidBindings(fi);
			return DONE;
		}

		/**
		 * Check connection instance for security policy compliance:
		 * Data flow from source and destination label must conform to policy.
		 */
		@Override
		public Boolean caseConnectionInstance(final ConnectionInstance conni) {
			if (!conni.isActive(som)) {
				return PRUNE;
			}
			ConnectionInstanceEnd src = conni.getSource();
			ConnectionInstanceEnd dst = conni.getDestination();

			checkSameLabel(conni, src, dst);
			checkBindingLeastPrivileges(conni);
			checkValidBindings(conni);
			return DONE;
		}

		/**
		 * Check connection reference for security policy compliance:
		 * Data flow from source and destination label must be identical
		 */
		@Override
		public Boolean caseConnectionReference(ConnectionReference cref) {
			if (!cref.isActive(som)) {
				return PRUNE;
			}
			ConnectionInstanceEnd src = cref.getSource();
			ConnectionInstanceEnd dst = cref.getDestination();

			checkSameLabel(cref, src, dst);
			checkBindingLeastPrivileges(cref);
			checkValidBindings(cref);
			return PRUNE;
		}

		@Override
		public Boolean caseEndToEndFlowInstance(org.osate.aadl2.instance.EndToEndFlowInstance object) {
			return PRUNE;
		};

		@Override
		public Boolean caseSystemOperationMode(org.osate.aadl2.instance.SystemOperationMode object) {
			return DONE;
		};

		@Override
		public Boolean caseAnnexInstance(AnnexInstance object) {
			return PRUNE;
		}

		@Override
		public Boolean casePropertyAssociation(PropertyAssociation object) {
			return PRUNE;
		}

		/**
		 * Check flow specification for security policy compliance:
		 * Data flow from source and destination label must conform to policy.
		 */
		@Override
		public Boolean caseFlowSpecificationInstance(FlowSpecificationInstance fsi) {
			if (!fsi.isActive(som)) {
				return PRUNE;
			}
			NamedElement src = fsi.getSource();
			NamedElement dst = fsi.getDestination();

			return checkValidFlow(fsi, src, dst);
		}

	};

	/**
	 * Checks if the classifier related to a feature instance has the same security label.
	 * If not a warning is added to the feature instance.
	 *
	 * @param fi Feature instance on which the classifier label equality property will be checked.
	 */
	private void checkFeatureClassifierLabelEquality(FeatureInstance fi) {
		if (!fi.isActive(som)) {
			return;
		}
		Optional<SecurityLabel> label = LabelUtil.getLabel(fi) != null ? LabelUtil.getLabel(fi) : Optional.empty();

		// Check feature equality
		Feature feature = fi.getFeature();
		if (feature != null) {
			Classifier classifier = feature.getClassifier();
			if (classifier != null) {
				Optional<SecurityLabel> classifierLabel = SecurityLabel.of(classifier);

				if (label.isPresent() && classifierLabel.isPresent()) {
					if (!label.get().equals(classifierLabel.get())) {
						String msg = "Security label of feature " + fi.getName() + " " + label.get()
								+ " and it's feature classifier " + classifierLabel.get() + " must be equal.";
						result.getDiagnostics().add(ResultUtil.createErrorDiagnostic(msg, fi));
					}
				}
			}
		}
	}

	/**
	 * Checks if the relation between components, parents and children are valid.
	 *
	 * @param io Object to evaluate.
	 */
	private void checkValidContainment(InstanceObject io) {
		// Skip inactive objects
		if (!isActiveInstanceObject(io)) {
			return;
		}
		Optional<SecurityLabel> childLimit = LabelUtil.getHighestChildLabel(io) != null
				? LabelUtil.getHighestChildLabel(io)
				: Optional.empty();
		Optional<SecurityLabel> upperLimit = LabelUtil.getUpperLabelLimit(io) != null ? LabelUtil.getUpperLabelLimit(io)
				: Optional.empty();
		Optional<SecurityLabel> label = LabelUtil.getLabel(io) != null ? LabelUtil.getLabel(io) : Optional.empty();

		if (upperLimit.isPresent() && childLimit.isPresent() && !(upperLimit.get()).dominates(childLimit.get())) {
			String msg = "Inconsistent security labels: " + io.getQualifiedName() + " has no valid security label. "
					+ "Has children requiring label: " + childLimit.get() + ". Parent requires: " + upperLimit.get()
					+ ".";
			result.getDiagnostics().add(ResultUtil.createErrorDiagnostic(msg, io));
		}
		upperLimit.ifPresent(limit -> {
			if (label.isPresent()) {
				SecurityLabel l = label.get();

				if (!limit.dominates(l)) {
					String msg = "Security label not dominated by " + limit.toString() + " of containing element";
					result.getDiagnostics().add(ResultUtil.createErrorDiagnostic(msg, io));
				}
			} else {
				String msg = "Missing security label, must be dominated by " + limit.toString();
				result.getDiagnostics().add(ResultUtil.createWarningDiagnostic(msg, io));
			}
		});
		childLimit.ifPresent(limit -> {
			if (label.isPresent()) {
				SecurityLabel l = label.get();

				if (!l.dominates(limit)) {
					String msg = "Security label does not dominate " + limit.toString();
					result.getDiagnostics().add(ResultUtil.createErrorDiagnostic(msg, io));
				} else if (l.greaterThan(limit)) {
					String msg = "Least privilege violation: Label should be " + limit.toString();
					result.getDiagnostics().add(ResultUtil.createWarningDiagnostic(msg, io));
				}
			} else {
				String msg = "Missing security label: should be " + childLimit.toString();
				result.getDiagnostics().add(ResultUtil.createWarningDiagnostic(msg, io));
			}
		});
	}

	/**
	 * Check if connection instances have valid security labels on both ends.
	 *
	 * @param conn connection instance
	 * @param src connection source
	 * @param dst connection destination
	 */
	private void checkSameLabel(InstanceObject conn, ConnectionInstanceEnd src, ConnectionInstanceEnd dst) {
		if (!conn.isActive(som)) {
			return;
		}
		Optional<SecurityLabel> srcLabel = LabelUtil.getLabel(src) != null ? LabelUtil.getLabel(src) : Optional.empty();
		Optional<SecurityLabel> dstLabel = LabelUtil.getLabel(dst) != null ? LabelUtil.getLabel(dst) : Optional.empty();

		if (!srcLabel.isPresent() && !dstLabel.isPresent()) {
			String msg = "Missing security labels on connection ends";
			result.getDiagnostics().add(ResultUtil.createInfoDiagnostic(msg, conn));
		} else {
			if (srcLabel.isPresent()) {
				SecurityLabel sl = srcLabel.get();
				if (dstLabel.isPresent()) {
					SecurityLabel dl = dstLabel.get();

					if (!sl.equals(dl)) {
						String msg = "Source security label " + sl.toString() + " does not match destination "
								+ dl.toString();
						result.getDiagnostics().add(ResultUtil.createErrorDiagnostic(msg, conn));
					}
				} else {
					String msg = "Missing security label on destination end: should be " + sl.toString();
					result.getDiagnostics().add(ResultUtil.createWarningDiagnostic(msg, conn));
				}
			} else {
				dstLabel.ifPresent(dl -> {
					String msg = "Missing security label on source end: should be " + dl.toString();
					result.getDiagnostics().add(ResultUtil.createWarningDiagnostic(msg, conn));
				});
			}
		}
	}

	/**
	 * Checks for least privilege violation in binding references.
	 *
	 * @param io Component referenced in binding
	 */
	private void checkBindingLeastPrivileges(InstanceObject io) {
		// Skip inactive objects
		if (!isActiveInstanceObject(io)) {
			return;
		}

		// Retrieve component label and it's highest binding label
		Optional<SecurityLabel> componentLabel = LabelUtil.getLabel(io) != null ? LabelUtil.getLabel(io)
				: Optional.empty();
		Optional<SecurityLabel> highestBindingLabel = LabelUtil.getHighestBindingLabel(io) != null
				? LabelUtil.getHighestBindingLabel(io)
				: Optional.empty();

		if (componentLabel.isPresent() && highestBindingLabel.isPresent()) {
			SecurityLabel label = componentLabel.get();
			SecurityLabel bindingLabel = highestBindingLabel.get();

			// Check for lest privilege violation
			if (label.greaterThan(bindingLabel)) {
				String msg = "Least privilege violation(Binding): Label should be " + bindingLabel.toString();
				result.getDiagnostics().add(ResultUtil.createWarningDiagnostic(msg, io));
			}
		} else if (!componentLabel.isPresent() && highestBindingLabel.isPresent()) {
			// Missing label warning on bound component
			SecurityLabel bindingLabel = highestBindingLabel.get();
			String msg = "Missing security label: should be " + bindingLabel.toString();
			result.getDiagnostics().add(ResultUtil.createWarningDiagnostic(msg, io));
		}

	}

	/**
	 * Checks if software-hardware bindings are valid.
	 * The hardware component to which some other software component is bound must dominate the label of the software component.
	 *
	 * @param io Object to check binding for
	 */
	private void checkValidBindings(InstanceObject io) {
		if (!isActiveInstanceObject(io)) {
			return;
		}
		Optional<SecurityLabel> label;

		// Retrieve indirect label from connection data
		if (io instanceof ConnectionInstance || io instanceof ConnectionReference) {
			ConnectionInstanceEnd src = (io instanceof ConnectionInstance) ? ((ConnectionInstance) io).getSource()
					: ((ConnectionReference) io).getSource();

			// use source, since destination must have a matching label
			label = LabelUtil.getLabel(src) != null ? LabelUtil.getLabel(src) : Optional.empty();
		} else {
			// Retrieve label from instance object
			label = LabelUtil.getLabel(io) != null ? LabelUtil.getLabel(io) : Optional.empty();
		}

		LinkedList<InstanceObject> bindings = new LinkedList<>();

		// Add processor, memory, connection and subprogram call bindings
		bindings.addAll(DeploymentProperties.getActualProcessorBinding(io).orElse(Collections.emptyList()));
		bindings.addAll(DeploymentProperties.getActualMemoryBinding(io).orElse(Collections.emptyList()));
		bindings.addAll(DeploymentProperties.getActualConnectionBinding(io).orElse(Collections.emptyList()));
		bindings.addAll(DeploymentProperties.getActualSubprogramCallBinding(io).orElse(Collections.emptyList()));

		// Add warnings/errors if bindings are present
		if (!bindings.isEmpty()) {
			if (label.isPresent()) {
				for (InstanceObject binding : bindings) {
					if (!binding.isActive(som)) {
						continue;
					}
					Optional<SecurityLabel> boundLabel = LabelUtil.getLabel(binding) != null
							? LabelUtil.getLabel(binding)
							: Optional.empty();

					if (boundLabel.isPresent()) {
						if (!boundLabel.get().dominates(label.get())) {
							String msg = "Security label " + label.get() + " not dominated by "
									+ boundLabel.get().toString() + " of bound component " + binding.getFullName();
							result.getDiagnostics().add(ResultUtil.createErrorDiagnostic(msg, io));
						}
					}
					// Missing labels are reported in checkBindingLeastPrivileges as the highest security label is not known here
				}

			} else {
				Optional<SecurityLabel> maxLabel = Optional.empty();
				for (InstanceObject binding : bindings) {
					if (!binding.isActive(som)) {
						return;
					}
					Optional<SecurityLabel> boundLabel = LabelUtil.getLabel(binding) != null
							? LabelUtil.getLabel(binding)
							: Optional.empty();

					if (boundLabel.isPresent()) {
						maxLabel = LabelUtil.join(maxLabel, boundLabel);
					}
				}

				if (maxLabel.isPresent()) {
					// Add warning if the component to which a binding is applies is missing a Security Label
					String msg = "Missing security label on bound component: should be " + maxLabel.get().toString();
					result.getDiagnostics().add(ResultUtil.createWarningDiagnostic(msg, io));
				}
			}
		}
	}

	/**
	 * Checks the star property for flow paths.
	 *
	 * @param fsi flow path
	 * @param src source of flow path
	 * @param dst destination of flow path
	 * @return
	 */
	protected Boolean checkValidFlow(FlowSpecificationInstance fsi, NamedElement src, NamedElement dst) {
		// skip all flows which are not active in the current mode
		if (!fsi.isActive(som)) {
			return PRUNE;
		}

		// Skip sinks and sources
		if (src == null || dst == null) {
			return DONE;
		}

		// Retrieve label from flow ends
		Optional<SecurityLabel> srcLabel = SecurityLabel.of(src) != null ? SecurityLabel.of(src) : Optional.empty();
		Optional<SecurityLabel> dstLabel = SecurityLabel.of(dst) != null ? SecurityLabel.of(dst) : Optional.empty();

		if (srcLabel.isPresent() && dstLabel.isPresent()) {

			// Skip trusted flows
			if (LabelPropagator.isTrusted(fsi, som)) {
				if (dstLabel.get().dominates(srcLabel.get())) {
					result.getDiagnostics()
							.add(ResultUtil.createWarningDiagnostic(
									"Suspicious flow: marked as Trusted but not required to be trusted.", fsi));
				}

				result.getDiagnostics().add(ResultUtil.createInfoDiagnostic("Flow marked as Trusted.", fsi));
				return DONE;
			}

			// Assert destination dominates source
			if (!dstLabel.get().dominates(srcLabel.get())) {
				String msg = "Security policy violation: Flow from " + srcLabel.get().toString() + " to "
						+ dstLabel.get().toString();
				result.getDiagnostics().add(ResultUtil.createErrorDiagnostic(msg, fsi));
			}

		} else {
			// Add warnings for missing label specification on src/dst
			if (!srcLabel.isPresent() && dstLabel.isPresent()) {
				String msg = "Missing security label for (part of flow path): " + src.getQualifiedName();
				result.getDiagnostics().add(ResultUtil.createErrorDiagnostic(msg, src));
			}
			if (srcLabel.isPresent() && !dstLabel.isPresent()) {
				String msg = "Missing security label for (part of flow path): " + dst.getQualifiedName();
				result.getDiagnostics().add(ResultUtil.createErrorDiagnostic(msg, dst));
			}

		}

		return DONE;
	}

	/**
	 * Finds hidden/implicit flows in the given component instance.
	 * Implicit flows are discovered using the following technique:
	 * Starting at each IN-Port of the component, the path along related connections is followed (this includes flow paths inside of subcomponents).
	 * If the end of such a path is reached and it is an OUT-port on {@code this} component instance, an error is added to the model.
	 * If the end of the path is a flow sink inside of a subcomponent an error is raised and a similar sink should be added to this component instance.
	 *
	 * Similarly hidden sources are detected (inverse operation)
	 *
	 * @param ci Component Instance on which hidden flows are detected.
	 */
	void findHiddenFlows(ComponentInstance ci) {
		if (!ci.getInModes().isEmpty() && !ci.isActive(som)) {
			return;
		}

		EList<FeatureInstance> features = ci.getFeatureInstances();

		// Get missing flows in both directions and combine them into a set
		Set<Pair<FeatureInstance, FeatureInstance>> missingFlows = new HashSet<>();
		for (FeatureInstance feature : features) {
			if (!feature.isActive(som)) {
				continue;
			}
			if (feature.getDirection() != null && feature.getDirection() == DirectionType.IN) {
				List<FeatureInstance> destinations = getDestinations(ci, feature);
				for (FeatureInstance destination : destinations) {
					if (destination != null && !destination.isActive(som)) {
						continue;
					}
					missingFlows.add(new Pair<>(feature, destination));
				}
			} else if (feature.getDirection() != null && feature.getDirection() == DirectionType.OUT) {
				List<FeatureInstance> sources = getSources(ci, feature);
				for (FeatureInstance source : sources) {
					if (source != null && !source.isActive(som)) {
						continue;
					}
					missingFlows.add(new Pair<>(source, feature));
				}
			}
		}

		// Annotate missing sources
		for (Pair<FeatureInstance, FeatureInstance> missingFlow : missingFlows) {
			FeatureInstance sourceFeature = missingFlow.getKey();
			FeatureInstance destinationFeature = missingFlow.getValue();

			// Check if equivalent flow/sink exists
			boolean exists = false;
			for (FlowSpecificationInstance fsi : ci.getFlowSpecifications()) {
				// skip all flows which are not active in the current mode
				if (!fsi.isActive(som)) {
					continue;
				}
				if (fsi.getSource() == sourceFeature && fsi.getDestination() == destinationFeature) {
					exists = true;
				}
			}

			// Add error to model
			if (!exists) {
				if (sourceFeature != null && destinationFeature != null) {
					// Flow in this component
					String msg = "Missing flow declaration from " + sourceFeature.getFullName() + " to "
							+ destinationFeature.getFullName();
					result.getDiagnostics().add(ResultUtil.createErrorDiagnostic(msg, ci));
				} else if (destinationFeature == null) {
					// Flow sink in subcomponent
					String msg = "Missing flow sink declaration for " + sourceFeature.getFullName();
					result.getDiagnostics().add(ResultUtil.createErrorDiagnostic(msg, ci));
				} else if (sourceFeature == null) {
					// Flow source in subcomponent
					String msg = "Missing flow source declaration for " + destinationFeature.getFullName();
					result.getDiagnostics().add(ResultUtil.createErrorDiagnostic(msg, ci));
				}

			}
		}

	}

	/**
	 * Determines destinations which can be reached from the starting IN-Port via connections and flows in subcomponents.
	 *
	 * @param ci root component
	 * @param inPort start port in root component
	 * @return List of destination features (can be null in case of sinks)
	 */
	List<FeatureInstance> getDestinations(ComponentInstance ci, FeatureInstance inPort) {
		LinkedList<FeatureInstance> destinations = new LinkedList<>();
		EList<ConnectionInstance> connections = ci.getConnectionInstances();

		LinkedList<FeatureInstance> unWalkedFeatures = new LinkedList<>();

		// add starting port
		unWalkedFeatures.add(inPort);

		while (!unWalkedFeatures.isEmpty()) {

			// Get connection with feature as source
			LinkedList<ConnectionInstance> unWalkedConnections = new LinkedList<>();
			for (FeatureInstance feature : unWalkedFeatures) {
				if (!feature.isActive(som)) {
					continue;
				}

				// Add connections (from ci) which start with the feature to the walking list
				for (ConnectionInstance connectionInstance : connections) {
					if (!connectionInstance.isActive(som)) {
						continue;
					}
					if (connectionInstance.getSource() == feature) {
						unWalkedConnections.add(connectionInstance);
					}
				}
			}
			unWalkedFeatures.clear();

			// Walk along connection
			for (ConnectionInstance connection : unWalkedConnections) {
				if (!connection.isActive(som)) {
					continue;
				}
				ConnectionInstanceEnd end = connection.getDestination();

				if (end instanceof FeatureInstance) {
					FeatureInstance subComponentFeature = (FeatureInstance) end;
					ComponentInstance subComponent = end.getComponentInstance();

					if (subComponent != ci) {
						// Find flows in subcomponent which start with the feature used at the end of the current connection
						EList<FlowSpecificationInstance> flowSpecifications = subComponent.getFlowSpecifications();
						for (FlowSpecificationInstance fsi : flowSpecifications) {
							// skip all flows which are not active in the current mode
							if (!fsi.isActive(som)) {
								continue;
							}
							if (fsi.getSource() == subComponentFeature) {
								FeatureInstance destination = fsi.getDestination();
								if (destination != null) {
									// Follow the subcomponents flow destination
									unWalkedFeatures.add(destination);
								} else {
									// flow sink in subcomponent
									destinations.add(null);
								}
							}
						}
					} else {
						// End of connection is a feature on the component itself
						destinations.add(subComponentFeature);
					}

				}
			}
			unWalkedConnections.clear();
		}

		return destinations;
	}

	/**
	 * Determines sources which lead to the OUT-Port via connections and flows in subcomponents.
	 *
	 * @param ci root component
	 * @param outPort target port in root component
	 * @return List of source features (can be null in case of sources)
	 */
	List<FeatureInstance> getSources(ComponentInstance ci, FeatureInstance outPort) {
		LinkedList<FeatureInstance> sources = new LinkedList<>();
		EList<ConnectionInstance> connections = ci.getConnectionInstances();

		LinkedList<FeatureInstance> unWalkedFeatures = new LinkedList<>();

		// Add starting port
		unWalkedFeatures.add(outPort);

		while (!unWalkedFeatures.isEmpty()) {

			// Get connection with feature as destination
			LinkedList<ConnectionInstance> unWalkedConnections = new LinkedList<>();
			for (FeatureInstance feature : unWalkedFeatures) {
				if (!feature.isActive(som)) {
					continue;
				}
				// Add connections (from ci) which start with the feature to the walking list
				for (ConnectionInstance connectionInstance : connections) {
					if (!connectionInstance.isActive(som)) {
						continue;
					}
					if (connectionInstance.getDestination() == feature) {
						unWalkedConnections.add(connectionInstance);
					}
				}
			}
			unWalkedFeatures.clear();

			// Walk backwards along connection
			for (ConnectionInstance connection : unWalkedConnections) {
				if (!connection.isActive(som)) {
					continue;
				}
				ConnectionInstanceEnd src = connection.getSource();

				if (src instanceof FeatureInstance) {
					FeatureInstance subComponentFeature = (FeatureInstance) src;
					ComponentInstance subComponent = src.getComponentInstance();

					if (subComponent != ci) {
						// Find flows in subcomponent which end with the feature used at the start of the current connection
						EList<FlowSpecificationInstance> flowSpecifications = subComponent.getFlowSpecifications();
						for (FlowSpecificationInstance fsi : flowSpecifications) {
							// skip all flows which are not active in the current mode
							if (!fsi.isActive(som)) {
								continue;
							}
							if (fsi.getDestination() == subComponentFeature) {
								FeatureInstance source = fsi.getSource();
								if (source != null) {
									// Follow the subcomponents flow destination
									unWalkedFeatures.add(source);
								} else {
									// flow source in subcomponent
									sources.add(null);
								}
							}
						}
					} else {
						// Start of connection is a feature on the component itself
						sources.add(subComponentFeature);
					}

				}
			}
			unWalkedConnections.clear();
		}

		return sources;
	}

	/**
	 * Determine if the instance object is active within the current SOM
	 * @param io instance object to check for
	 * @return true fi the instance object is active
	 */
	private boolean isActiveInstanceObject(InstanceObject io) {
		if (io instanceof ComponentInstance) {
			ComponentInstance ci = (ComponentInstance) io;
			return ci.getInModes().isEmpty() || ci.isActive(som);
		} else {
			return io.isActive(som);
		}
	}

}
