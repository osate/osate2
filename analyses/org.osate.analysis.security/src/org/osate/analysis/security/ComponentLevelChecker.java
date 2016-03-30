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
 * @version $Id: ComponentLevelChecker.java,v 1.11 2010-03-23 19:59:50 jseibel Exp $
 */
package org.osate.analysis.security;

import java.util.Iterator;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.Property;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitchWithProgress;
import org.osate.aadl2.properties.InvalidModelException;
import org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException;
import org.osate.aadl2.properties.PropertyIsModalException;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.aadl2.util.Aadl2Switch;
import org.osate.xtext.aadl2.properties.util.PropertyUtils;

/**
 * Analysis the security levels of the declarative components, checking
 * that components are nested appropriately.  Makes an attempt to 
 * upgrade the security level of those components that have inappropriate
 * declared levels.  
 * 
 * <p>Only works correctly on models that aren't model.  Keeps track of those 
 * components where the security level depends on the mode so that the
 * analysis plug-in can inform the user of the problem.
 */
public class ComponentLevelChecker extends AadlProcessingSwitchWithProgress {
	/** The property to check.  Must be an aadlinteger-valued property. */
	private final Property property;

	public ComponentLevelChecker(final IProgressMonitor monitor, final AnalysisErrorReporterManager errMgr,
			final Property pd) {
		super(monitor, PROCESS_BOTTOM_UP_COMPONENT_IMPL, errMgr);
		property = pd;
	}

	protected final void initSwitches() {
		aadl2Switch = new Aadl2Switch<String>() {
			public String caseComponentImplementation(final ComponentImplementation ci) {
				monitor.subTask("Checking level of " + ci.getQualifiedName());
				try {
					// Get my security level, if declared
					boolean cipvExists;
					long cilv;
					try {
						cilv = PropertyUtils.getIntegerValue(ci, property, 0);
						cipvExists = true;
					} catch (PropertyDoesNotApplyToHolderException e) {
						cilv = 0;
						cipvExists = false;
					} catch (PropertyIsModalException e) {
						cilv = 0;
						cipvExists = false;
						warning(ci, "Modal property association for property \"" + property.getQualifiedName() + "\"");
					}

					// Get the max security level of my subcomponents
					long maxslv = 0;
					final EList<Subcomponent> subs = ci.getAllSubcomponents();
					for (Iterator<Subcomponent> it = subs.iterator(); it.hasNext();) {
						final Subcomponent sub = (Subcomponent) it.next();
						final ComponentImplementation sci = sub.getComponentImplementation();
						if (sci != null) {
							try {
								long slv = PropertyUtils.getIntegerValue(sci, property);
								// Update max subcomponent security level
								if (slv > maxslv) {
									maxslv = slv;
								}
							} catch (PropertyDoesNotApplyToHolderException e) {
								// Do nothing
							} catch (PropertyNotPresentException e) {
								// Do nothing
							} catch (PropertyIsModalException e) {
								warning(sci, "Modal property association for property \"" + property.getQualifiedName()
										+ "\"");
							}
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
				if (monitor.isCanceled()) {
					cancelTraversal();
				}
				monitor.worked(1);
				return DONE;
			}
		};
	}
}