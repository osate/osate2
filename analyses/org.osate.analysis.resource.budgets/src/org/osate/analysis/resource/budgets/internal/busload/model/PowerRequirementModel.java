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
	private String sectionName = new String();
	private String powerComponentHeader = new String();

	private double capacity = 0;
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
		model.sectionName = systemName + somName;



		final ForAllElement mal = new ForAllElement() {
			@Override
			protected void process(final Element obj) {
				final ComponentInstance ci = (ComponentInstance) obj;

				model.capacity = GetProperties.getPowerCapacity(ci, 0.0);
				if (model.capacity == 0) {
					return;
				}

				model.powerComponentHeader = "Computing Electrical Power for " + ci.getName();

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

	public double getCapacity() {
		return this.capacity;
	}

	public double getTotalBudget() {
		return this.budgetTotal;
	}

	public double getTotalSupply() {
		return this.supplyTotal;
	}
}