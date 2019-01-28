package org.osate.analysis.security;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitch;
import org.osate.aadl2.properties.InvalidModelException;
import org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.xtext.aadl2.properties.util.PropertyUtils;

public class ComponentInstanceLabelChecker extends AadlProcessingSwitch {

	private SecurityPolicy policy;

	public ComponentInstanceLabelChecker(AnalysisErrorReporterManager errMgr, SecurityPolicy policy) {
		super(PROCESS_POST_ORDER_ALL, errMgr);
		this.policy = policy;
	}

	@Override
	protected final void initSwitches() {
		instanceSwitch = new InstanceSwitch<String>() {
			@Override
			public String caseComponentInstance(final ComponentInstance ci) {
				try {
					// Get my security level, if declared
					boolean cipvExists;
					SecurityLabel ciLabel;
					try {
						ciLabel = SecurityLabel.of(ci);
						cipvExists = true;
					} catch (PropertyDoesNotApplyToHolderException | PropertyNotPresentException e) {
						ciLabel = null;
						cipvExists = false;
					}

					// Get the max security level of my subcomponents
					SecurityLabel maxLabel;
					for (ComponentInstance sub : ci.getComponentInstances()) {
						try {
							SecurityLabel subLabel = SecurityLabel.of(sub);
							// Update max subcomponent security level
							maxLabel = maxLabel.join(subLabel);
						} catch (PropertyDoesNotApplyToHolderException | PropertyNotPresentException e) {
							// Do nothing.
						}
					}

					if (! ciLabel.dominates(maxLabel)) {
						/*
						 * Subcomponents have higher security level than me.
						 * Update my declared security level.
						 */
						if (cipvExists) { // My declared level is wrong
							warning(ci, property.getQualifiedName()
									+ " updated to the maximum of the subcomponent values: " + maxslv);
						} else {
							warning(ci, property.getQualifiedName() + " set to the maximum of the subcomponent values: "
									+ maxslv);
						}

						// Update the property value on the instance model
						// TODO: add contained property association to the declarative model

						// Create new property value: An Integer value
						final IntegerLiteral newpv = Aadl2Factory.eINSTANCE.createIntegerLiteral();
						// Set to max security level
						newpv.setValue(maxslv);
						// Set the property association
						ci.setPropertyValue(property, newpv);
					}
				} catch (InvalidModelException e) {
					error(e.getElement(), e.getMessage());
				}
				return DONE;
			}
		};
	}
}