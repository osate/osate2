/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.analysis.resource.budgets.internal.busload.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osate.aadl2.Element;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.modeltraversal.ForAllElement;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.xtext.aadl2.properties.util.GetProperties;

public class PowerRequirementModel extends ModelElement {
	private String systemSOMname = new String();
	private String componentName = new String();

	private double capacityTotal = 0;
	private double budgetTotal = 0;
	private double supplyTotal = 0;

	private final List<Feature> rootFeatures = new ArrayList<>();
	private final List<ConnectionEnd> rootConnectionEnds = new ArrayList<>();

	private final Map<FeatureInstance, Feature> features = new HashMap<>();
	private final Map<ConnectionInstanceEnd, ConnectionEnd> connectionEnds = new HashMap<>();

	/**
	 * Use {@link #buildModel(SystemInstance, SystemOperationMode)} to get an instance of the
	 * model.
	 */
	private PowerRequirementModel() {
		super();
	}

	@Override
	void visitSelfPrefix(final Visitor visitor) {
		rootFeatures.forEach(e -> visitor.visitFeaturePrefix(e));
		rootConnectionEnds.forEach(e -> visitor.visitConnectionEndPrefix(e));
	}

	@Override
	void visitChildren(final Visitor visitor) {
		// no children
	}

	@Override
	void visitSelfPostfix(final Visitor visitor) {
		rootFeatures.forEach(e -> visitor.visitFeaturePostfix(e));
		rootConnectionEnds.forEach(e -> visitor.visitConnectionEndPostfix(e));
	}

	public static PowerRequirementModel buildModel(final SystemInstance root, final SystemOperationMode som) {
		final PowerRequirementModel model = new PowerRequirementModel();

		final String somName = Aadl2Util.getPrintableSOMName(som);
		String systemName = root.getComponentClassifier().getName();
		model.systemSOMname = systemName + " " + somName;

		final ForAllElement mal = new ForAllElement() {
			@Override
			protected void process(final Element obj) {
				final ComponentInstance ci = (ComponentInstance) obj;

				double tmpCapacity = GetProperties.getPowerCapacity(ci, 0.0);

				if (tmpCapacity == 0) {
					return;
				} else {
					model.capacityTotal = tmpCapacity;
				}

				model.componentName = ci.getName();

				for (FeatureInstance fi : ci.getFeatureInstances()) {
					double supply = GetProperties.getPowerBudget(fi, 0.0);
					if ((supply > 0) && (!fi.getDstConnectionInstances().isEmpty()
							|| !fi.getSrcConnectionInstances().isEmpty())) {
						addFeature(model, fi, som, 0, supply);
						model.supplyTotal += supply;
					}

					for (ConnectionInstance inconni : fi.getDstConnectionInstances()) {
						// incoming connections: does the other end provide power?
						ConnectionInstanceEnd srcfi = inconni.getSource();
						supply = GetProperties.getPowerSupply(srcfi, 0.0);
						if (supply > 0) {
							addConnectionEnd(model, srcfi, som, 0, supply);
							model.supplyTotal += supply;
						}
					}
					for (ConnectionInstance outconni : fi.getSrcConnectionInstances()) {
						// outgoing connection. Does the other end have a power budget?
						ConnectionInstanceEnd dstfi = outconni.getDestination();
						double budget = GetProperties.getPowerBudget(dstfi, 0.0);
						if (budget > 0) {
							addConnectionEnd(model, dstfi, som, budget, 0);
							model.budgetTotal += budget;
						}
					}
				}
				// power supply and budget based on access connections to this bus
				// we are checking whether there are connections with the component with power capacity as source or destination
				// this could be a bus, possibly an abstract component
				for (ConnectionInstance ac : ci.getSrcConnectionInstances()) {
					// Outgoing from Power system as bus
					FeatureInstance dstfi = (FeatureInstance) ac.getDestination();
					double budget = GetProperties.getPowerBudget(dstfi, 0.0);
					if (budget > 0) {
						addFeature(model, dstfi, som, budget, 0);
						model.budgetTotal += budget;
					}
					double supply = GetProperties.getPowerSupply(dstfi, 0.0);
					if (supply > 0) {
						addFeature(model, dstfi, som, 0, supply);
						model.supplyTotal += supply;
					}
				}
				for (ConnectionInstance ac : ci.getDstConnectionInstances()) {
					// Incoming to Power system as bus
					FeatureInstance srcfi = (FeatureInstance) ac.getSource();
					double budget = GetProperties.getPowerBudget(srcfi, 0.0);
					if (budget > 0) {
						addFeature(model, srcfi, som, budget, 0);
						model.budgetTotal += budget;
					}
					double supply = GetProperties.getPowerSupply(srcfi, 0.0);
					if (supply > 0) {
						addFeature(model, srcfi, som, 0, supply);
						model.supplyTotal += supply;
					}
				}
			}
		};
		mal.processPreOrderComponentInstance(root);
		return model;
	}

	public static String addUnits(double value) {
		return value > 2000.0 ? value / 1000 + " W" : value + " mW";
	}

	void addFeature(final Feature feature) {
		rootFeatures.add(feature);
	}

	private static void addFeature(final PowerRequirementModel model, final FeatureInstance feature,
			final SystemOperationMode som, double budget, double supply) {
		final Feature theFeature = model.getFeature(feature, budget, supply);
		model.addFeature(theFeature);
	}

	private Feature getFeature(final FeatureInstance fi, double budget, double supply) {
		Feature feature = features.get(fi);
		if (feature == null) {
			feature = new Feature(fi, budget, supply);
			features.put(fi, feature);
		}
		return feature;
	}

	void addConnection(final ConnectionEnd connectionEnd) {
		rootConnectionEnds.add(connectionEnd);
	}

	private static void addConnectionEnd(final PowerRequirementModel model, final ConnectionInstanceEnd connEnd,
			final SystemOperationMode som, double budget, double supply) {
		final ConnectionEnd theConnEnd = model.getConnectionEnd(connEnd, budget, supply);
		model.addConnection(theConnEnd);
	}

	private ConnectionEnd getConnectionEnd(final ConnectionInstanceEnd cie, double budget, double supply) {
		ConnectionEnd connEnd = connectionEnds.get(cie);
		if (connEnd == null) {
			connEnd = new ConnectionEnd(cie, budget, supply);
			connectionEnds.put(cie, connEnd);
		}
		return connEnd;
	}

	public double getTotalCapacity() {
		return this.capacityTotal;
	}

	public double getTotalBudget() {
		return this.budgetTotal;
	}

	public double getTotalSupply() {
		return this.supplyTotal;
	}

	public String getSystemSOMname() {
		return this.systemSOMname;
	}

	public String getComponentName() {
		return this.componentName;
	}
}