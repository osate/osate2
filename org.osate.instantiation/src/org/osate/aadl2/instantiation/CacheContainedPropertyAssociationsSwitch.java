/*
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
 * $Id: CacheContainedPropertyAssociationsSwitch.java,v 1.4 2010-06-14 01:21:51 lwrage Exp $
 *
 */
package org.osate.aadl2.instantiation;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.Element;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.ReferenceValue;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitchWithProgress;
import org.osate.aadl2.properties.InstanceUtil;
import org.osate.aadl2.properties.InstanceUtil.InstantiatedClassifier;


/**
 * TODO: Add comment
 * @author lwrage
 */
class CacheContainedPropertyAssociationsSwitch extends AadlProcessingSwitchWithProgress {

	private HashMap<InstanceObject, InstantiatedClassifier> classifierCache;

	/*
	 * The cache of contained property associations that apply to semantic
	 * connections.
	 */
//	private final SCProperties scProps = new SCProperties();

	CacheContainedPropertyAssociationsSwitch(final HashMap<InstanceObject, InstantiatedClassifier> classifierCache,
			final IProgressMonitor pm, final AnalysisErrorReporterManager errManager) {
		super(pm, PROCESS_POST_ORDER_ALL, errManager);
	}

	protected final void initSwitches() {
		instanceSwitch = new InstanceSwitch<String>() {
			public String caseSystemInstance(final SystemInstance si) {
				monitor.subTask("Caching system instance contained property associations");
				processContainedPropertyAssociations(si, si, si.getSystemImplementation().getAllPropertyAssociations());
				return DONE;
			}

			public String caseComponentInstance(final ComponentInstance ci) {
				if (ci.getContainingComponentInstance() instanceof SystemInstance) {
					monitor.subTask("Caching contained property associations in " + ci.getName());
				}
				/*
				 * (1) Get the contained associations from the classifier of the
				 * subcomponents. (2) Get the contained associations from the
				 * subcomponent itself.
				 */
				ComponentClassifier ctype = InstanceUtil.getComponentType(ci, 0, classifierCache);
				if (ctype != null) {
					processContainedPropertyAssociations(ci, ci, ctype.getAllPropertyAssociations());
				}
				ComponentClassifier cimpl = InstanceUtil.getComponentImplementation(ci, 0, classifierCache);
				if (cimpl != null) {
					processContainedPropertyAssociations(ci, ci, cimpl.getAllPropertyAssociations());
				}
				processContainedPropertyAssociations((ComponentInstance) ci.eContainer(), ci, ci.getSubcomponent()
						.getOwnedPropertyAssociations());
				return DONE;
			}

			// TODO: LW contained PAs of feature groups
		};
	}

	/**
	 * Copy contained property associations to the instance model.
	 * Don't fully evaluate the property expression. Just replace reference values with
	 * a reference to the referenced instance object.
	 *  
	 * @param modeContext
	 * @param ci
	 * @param propertyList
	 */
	// TODO: LW applies to arrays
	// TODO: LW connections
	private void processContainedPropertyAssociations(final ComponentInstance modeContext, final ComponentInstance ci,
			final EList<PropertyAssociation> propertyList) {
		for (Iterator<PropertyAssociation> iter = propertyList.iterator(); iter.hasNext() && notCancelled();) {
			final PropertyAssociation pa = iter.next();
			Property prop = pa.getProperty();
			if (prop == null || prop.getType() == null) {
				// PA is missing the prop def, skip to the next one
				continue;
			}
			for (ContainedNamedElement cne : pa.getAppliesTos()) {
				final EList<ContainmentPathElement> cpes = cne.getContainmentPathElements();
				if (cpes != null && !cpes.isEmpty()) {
//					final NamedElement last = cpes.get(cpes.size() - 1).getNamedElement();
					final Collection<? extends InstanceObject> ios = ci.findInstanceObjects(cpes);

					if (!ios.isEmpty()) {
						for (InstanceObject io : ios) {
							PropertyAssociation newPA = Aadl2Factory.eINSTANCE.createPropertyAssociation();

							newPA.setProperty(prop);
							newPA.getOwnedValues().addAll(EcoreUtil.copyAll(pa.getOwnedValues()));

							// replace reference values in the context of the contained PA's owner
							for (Iterator<Element> content = EcoreUtil.getAllProperContents(newPA, false); content
									.hasNext();) {
								Element elem = content.next();

								if (elem instanceof ReferenceValue) {
									// TODO: LW what if ref to connection?
									PropertyExpression irv = ((ReferenceValue) elem).instantiate(ci);
									EcoreUtil.replace(elem, irv);
								}
							}

							io.removePropertyAssociations(prop);
							io.getOwnedPropertyAssociations().add(newPA);
						}

//							try {							
//							final AadlPropertyValue ipv = pa.getValue().instantiate(ci);
//							final EList<Mode> inModes = new BasicEList<Mode>();
//							for (ModalPropertyValue modalPropertyValue : pa.getOwnedValues()) {
//								inModes.addAll(modalPropertyValue.getInModes());
//							}
//							for (Iterator<? extends InstanceObject> iot = ios.iterator(); iot.hasNext();) {
//								/*
//								 * Copy the instantiated property association
//								 * because when we connect the copied property
//								 * values to the new property association, it
//								 * creates a bidirectional link, so we need
//								 * fresh copies for each item in the 'iol' list.
//								 */
//								final List<PropertyExpression> values = AadlUtil.copyList(ipv.getValue());
//								ion = iot.next();
//								if (inModes != null && !inModes.isEmpty()) {
//									final List<SystemOperationMode> soms = convertInModesToInSOMs(modeContext, inModes);
//									if (last instanceof Connection) {
//										scProps.recordConnectionProperty((ConnectionInstance) ion, prop,
//												(Connection) last, soms, values);
//									}
//									ion.setPropertyValue(prop, values, soms);
//								} else {
//									if (last instanceof Connection) {
//										scProps.recordConnectionProperty((ConnectionInstance) ion, prop,
//												(Connection) last, root.getSystemOperationModes(), values);
//									}
//									ion.setPropertyValue(prop, values);
//								}
//							}
//						} catch (final IllegalArgumentException e) {
//							error(
//									ion,
//									"Contained property "
//											+ prop.getQualifiedName()
//											+ " cannot be applied to to instance object: "
//											+ e.getMessage()
//											+ ". Type mismatch in declarative model: type of value does not match property type.");
//						}
					}
				}
			}
			checkIfCancelled();
		}
	}

}
