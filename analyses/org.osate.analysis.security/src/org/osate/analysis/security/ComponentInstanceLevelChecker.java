/*
 * Created on July 7, 2004
 *
 * <copyright>
 * Copyright  2004 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/cpl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 *
 * </copyright>
 *
 *
 * @version $Id: ComponentInstanceLevelChecker.java,v 1.8 2010-03-23 19:59:50 jseibel Exp $
 */
package org.osate.analysis.security;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.Property;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitch;
import org.osate.aadl2.properties.InvalidModelException;
import org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.xtext.aadl2.properties.util.PropertyUtils;

/**
 * @author aarong
 */
public class ComponentInstanceLevelChecker extends AadlProcessingSwitch {
	/** The property to check.  Must be an aadlinteger-valued property. */
	private final Property property;

	public ComponentInstanceLevelChecker(final AnalysisErrorReporterManager errMgr, final Property pd) {
		super(PROCESS_POST_ORDER_ALL, errMgr);
		property = pd;
	}

	protected final void initSwitches() {
		instanceSwitch = new InstanceSwitch<String>() {
			public String caseComponentInstance(final ComponentInstance ci) {
				try {
					// Get my security level, if declared
					boolean cipvExists;
					long cilv;
					try {
						cilv = PropertyUtils.getIntegerValue(ci, property);
						cipvExists = true;
					} catch (PropertyDoesNotApplyToHolderException e) {
						cilv = 0;
						cipvExists = false;
					} catch (PropertyNotPresentException e) {
						cilv = 0;
						cipvExists = false;
					}

					// Get the max security level of my subcomponents
					long maxslv = 0;
					final EList<ComponentInstance> subs = ci.getComponentInstances();
					for (final Iterator<ComponentInstance> it = subs.iterator(); it.hasNext();) {
						final ComponentInstance sub = it.next();
						try {
							long slv = PropertyUtils.getIntegerValue(sub, property);
							// Update max subcomponent security level
							if (slv > maxslv)
								maxslv = slv;
						} catch (PropertyDoesNotApplyToHolderException e) {
							// Do nothing.
						} catch (PropertyNotPresentException e) {
							// Do nothing.
						}
					}

					if (maxslv > cilv) {
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