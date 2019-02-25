package alisa_consistency;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.Property;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.result.Result;
import org.osate.result.ResultFactory;
import org.osate.result.ResultType;
import org.osate.result.util.ResultUtil;
import org.osate.xtext.aadl2.properties.util.GetProperties;
import org.osate.xtext.aadl2.properties.util.PropertyUtils;

public class ModelVerifications {

	/**
	 * returns true if the component instance is a leaf component (without subcomponent instances)
	 * @param ci
	 * @return boolean
	 */
	public static boolean isLeafComponent(ComponentInstance ci) {
		return ci.getComponentInstances().isEmpty();
	}

	/**
	 * returns true if all features are are sources or destinations of connection instances
	 * @param ci
	 * @return
	 */
	public static boolean isConnected(ComponentInstance ci) {
		for (FeatureInstance fi : ci.getAllFeatureInstances()) {
			if (!isConnected(fi)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * returns true if feature instance is source or destination of a connection instance
	 * @param fi
	 * @return
	 */
	public static boolean isConnected(FeatureInstance fi) {
		return !(fi.getSrcConnectionInstances().isEmpty() && fi.getDstConnectionInstances().isEmpty());
	}

	/**
	 * Recursively consistency check that all leaf components have all features
	 * connected. Returns Result object with issues detailing each unconnected feature.
	 */
	public static Result allComponentFeaturesConnected(ComponentInstance ci) {
		Result res = ResultFactory.eINSTANCE.createResult();
		res.setMessage("All components are fully connected");
		for (ComponentInstance subi : ci.getAllComponentInstances()) {
			if (isLeafComponent(subi)) {
				for (FeatureInstance fi : subi.getAllFeatureInstances()) {
					if (!isConnected(fi)) {
						Result issue = ResultUtil.createFailureResult(
							"Feature " + fi.getName() + " of component "
							+ fi.getContainingComponentInstance().getName()
							+ " not connected",
								fi);
						res.getSubResults().add(issue);
						res.setResultType(ResultType.FAILURE);
					}
				}
			}
		}
        return res;
	}

	/**
	 * returns true if the component has two incoming abstract feature instances with the Classifier "power"
	 * @param ci
	 * @return
	 */
	public static boolean twoPowerInlets(ComponentInstance ci) {
		int count = 0;
		for (FeatureInstance fi : ci.getAllFeatureInstances(FeatureCategory.ABSTRACT_FEATURE)) {
			if (fi.getDirection().incoming()) {
				Classifier cl = fi.getFeature().getAllClassifier();
				if (cl.getName().equalsIgnoreCase("power")) {
					count++;
				}
			}
		}
		return count == 2;
	}

	/**
	 * returns true if feature instance has Voltage property with value 'v'
	 * @param fi
	 * @param v
	 * @return
	 */
	public static boolean hasVoltageValue(FeatureInstance fi, double v) {
			double volt = getVoltage(fi);
			return volt == v;
	}

	/**
	 * returns true if incoming (requires) abstract feature instance in component 'ci' has a power budget of 'w' watts
	 * @param ci
	 * @param featurename
	 * @param w
	 * @return
	 */
	public static boolean hasWattageBudgetValue(FeatureInstance fi, double w) {
			if (fi.getDirection().incoming()) {
				double watt = GetProperties.getPowerBudget(fi, 0.0);
				return watt == w;
			}
		return false;
	}

	/**
	 * returns true if two incoming (requires) abstract feature instances in component 'ci' have same voltage
	 * @param ci
	 * @return
	 */
	public static boolean sameVoltage(ComponentInstance ci) {
		EList<FeatureInstance> inlets = new BasicEList<FeatureInstance>();
		for (FeatureInstance fi : ci.getAllFeatureInstances(FeatureCategory.ABSTRACT_FEATURE)) {
			Classifier cl = fi.getFeature().getAllClassifier();
			if (fi.getDirection().incoming() && cl.getName().equalsIgnoreCase("power")) {
				inlets.add(fi);
			}
		}
		if (inlets.size() == 2) {
			double v1 = getVoltage(inlets.get(0));
			double v2 = getVoltage(inlets.get(1));
			return v1 == v2;
		}
		return false;
	}

	/**
	 * returns true if two incoming (requires) abstract feature instances in component 'ci' have same power budget
	 * @param ci
	 * @return
	 */
	public static boolean samePowerBudget(ComponentInstance ci) {
		EList<FeatureInstance> inlets = new BasicEList<FeatureInstance>();
		for (FeatureInstance fi : ci.getAllFeatureInstances(FeatureCategory.ABSTRACT_FEATURE)) {
			Classifier cl = fi.getFeature().getAllClassifier();
			if (fi.getDirection().incoming() && cl.getName().equalsIgnoreCase("power")) {
				inlets.add(fi);
			}
		}
		if (inlets.size() == 2) {
			double pb1 = GetProperties.getPowerBudget(inlets.get(0), 0.0);
			double pb2 = GetProperties.getPowerBudget(inlets.get(1), 0.0);
			return pb1 == pb2;
		}
		return false;
	}

	/**
	 * return the value of property 'Physical::Voltage' for feature instance 'fi'
	 * @param fi
	 * @return double
	 */
	public static double getVoltage(final FeatureInstance fi) {
		Property voltage = GetProperties.lookupPropertyDefinition(fi, "Physical", "Voltage");
		UnitLiteral volts = GetProperties.findUnitLiteral(voltage, "V");
		return PropertyUtils.getScaledNumberValue(fi, voltage, volts, 0.0);
	}


		  public boolean hasWattageCapacityValue(final ComponentInstance ci, final double capacity) {
		    final double prop = GetProperties.getPowerCapacity(ci, 0.0);
		    return prop == capacity;
		  }

		  public boolean consistentWeightLimit(final ComponentInstance ci, final double limit) {
		    final double prop = GetProperties.getWeightLimit(ci, 0.0);
		    return prop == limit;
		  }

		  public boolean electricalPowerSelfSufficiency(final ComponentInstance ci) {
		    final EList<FeatureInstance> fil = ci.getFeatureInstances();
		    for (final FeatureInstance fi : fil) {
		      return ((GetProperties.getPowerBudget(fi, 0.0) != 0.0) ||
		        (GetProperties.getPowerSupply(fi, 0.0) != 0.0));
		    }
		    return false;
		  }

		  public boolean electricalPowerSelfSufficiency1(final ComponentInstance ci) {
			  for (FeatureInstance fi : ci.getFeatureInstances()) {
				  if (((GetProperties.getPowerBudget(fi, 0.0) != 0.0) ||
					        (GetProperties.getPowerSupply(fi, 0.0) != 0.0))) {
					  return false;
				  }
			  }
		    return true;
		  }

		  public boolean CPUSelfSufficiency(final ComponentInstance ci) {
		    return (this.hasNoExternalCPUDemand(ci) && this.providesNoCPUExternally(ci));
		  }

		  public boolean hasNoExternalCPUDemand(final ComponentInstance ci) {
		    if ((GetProperties.hasAssignedPropertyValue(ci, "SEI::MIPSBudget") &&
		      (GetProperties.getPowerBudget(ci, 0.0) != 0.0))) {
		      return false;
		    }
		    return true;
		  }

		  public boolean providesNoCPUExternally(final ComponentInstance ci) {
		    if ((GetProperties.hasAssignedPropertyValue(ci, "SEI::MIPSCapacity") &&
		      (GetProperties.getPowerSupply(ci, 0.0) != 0.0))) {
		      return false;
		    }
		    return true;
		  }

		  public boolean isRavenscarCompliant(final ComponentInstance ci) {
			  for (ComponentInstance thr : allThreads(ci)) {
				  if (!hasOnlySamplingPorts(thr)) {
					  return false;
				  }
			  }
		    return true;
		  }

		  public boolean hasOnlySamplingPorts(final ComponentInstance thread) {
			  for (FeatureInstance fi: thread.getAllFeatureInstances()) {
				  if (fi.getCategory() != FeatureCategory.DATA_PORT) {
					  return false;
				  }
			  }
			  return true;
		  }

		  public EList<ComponentInstance> allThreads(final ComponentInstance ci) {
		    return ci.getAllComponentInstances(ComponentCategory.THREAD);
		  }

}
