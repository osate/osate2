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
 * $Id: CachePropertyAssociationsSwitch.java,v 1.57 2010-06-15 20:46:23 lwrage Exp $
 *
 */
package org.osate.aadl2.instantiation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.Mode;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitchWithProgress;
import org.osate.aadl2.properties.EvaluatedProperty;
import org.osate.aadl2.properties.EvaluationContext;
import org.osate.aadl2.properties.InstanceUtil.InstantiatedClassifier;
import org.osate.aadl2.properties.InvalidModelException;


/**
 * TODO: Add comment
 * @author lwrage
 */
class CachePropertyAssociationsSwitch extends AadlProcessingSwitchWithProgress {
	private final List<Property> propertyFilter;
	private final SystemInstance root;

	private HashMap<InstanceObject, InstantiatedClassifier> classifierCache;

	/**
	 * Maps mode instances to SOMs that contain this mode instance
	 */
	private HashMap<ModeInstance, List<SystemOperationMode>> mode2som;

	/*
	 * The cache of contained property associations that apply to semantic
	 * connections.
	 */
	private final SCProperties scProps = new SCProperties();

	CachePropertyAssociationsSwitch(final IProgressMonitor pm, final AnalysisErrorReporterManager errManager,
			final SystemInstance si, final List<Property> filter,
			HashMap<InstanceObject, InstantiatedClassifier> classifierCache,
			HashMap<ModeInstance, List<SystemOperationMode>> mode2som) {
		super(pm, PROCESS_POST_ORDER_ALL, errManager);
		propertyFilter = filter;
		root = si;
		this.classifierCache = classifierCache;
		this.mode2som = mode2som;
	}

	protected final void initSwitches() {
		instanceSwitch = new InstanceSwitch<String>() {
			public String caseComponentInstance(final ComponentInstance ci) {
				if (ci instanceof SystemInstance) {
					int size = ((SystemInstance) ci).getSystemImplementation().getOwnedPropertyAssociations().size();
					monitor.subTask("Caching " + size + " property associations");
				} else if (ci.getContainingComponentInstance() instanceof SystemInstance) {
					monitor.subTask("Caching property associations in " + ci.getName());
				}
				cachePropertyAssociations(ci);
				return DONE;
			}

			public String caseInstanceObject(final InstanceObject iobj) {
				// Handle the normal property associations
				cachePropertyAssociations(iobj);
				return DONE;
			}
		};
	}

	SCProperties getSemanticConnectionProperties() {
		return scProps;
	}

	protected void cachePropertyAssociations(final InstanceObject io) {
		if (propertyFilter == null) {
			return;
		}
		for (final Iterator<Property> it = propertyFilter.iterator(); it.hasNext() && notCancelled();) {
			final Property property = it.next();
			if (io.acceptsProperty(property)) {
				/*
				 * Just look up the property. The property doesn't yet have a
				 * local association, so lookup will get the value from the
				 * declarative model. Property lookup process now corrects
				 * reference values to instance reference values.
				 */
				// Already checked that acceptsProperty is true
				try {
					EvaluatedProperty value = property.evaluate(new EvaluationContext(io, classifierCache));
					
					if (value != null) {
						PropertyAssociation pa = io.createOwnedPropertyAssociation();

						io.removePropertyAssociations(property);
						pa.setProperty(property);
						fillPropertyValue(io, pa, value);
					}
				} catch (final IllegalStateException e) {
					// circular dependency
					// xxx: this is a misleading place to put the marker
					error(io, e.getMessage());
				} catch (InvalidModelException e) {
					error(e.getElement(), e.getMessage());
				}
			}
			checkIfCancelled();
		}
	}

	private void fillPropertyValue(final InstanceObject io, PropertyAssociation pa, EvaluatedProperty value) {
		for (EvaluatedProperty.MpvProxy proxy : value.getProxies()) {
			List<SystemOperationMode> inSOMs = new ArrayList<SystemOperationMode>();
			ModalPropertyValue newVal = Aadl2Factory.eINSTANCE.createModalPropertyValue();

			newVal.setOwnedValue((PropertyExpression) EcoreUtil.copy(proxy.getValue()));
			if (!proxy.isModal()) {
				pa.getOwnedValues().add(newVal);
			} else {
				for (Mode mode : proxy.getModes()) {
					if (mode instanceof SystemOperationMode) {
						inSOMs.add((SystemOperationMode) mode);
					} else {
						ModeInstance modeInst = null;
						ComponentInstance comp = getComponentInstance(io);
						while (comp != null) {
							Iterator<ModeInstance> iter = comp.getModeInstances().iterator();

							while (iter.hasNext()) {
								ModeInstance mi = iter.next();

								if (mi.getMode() == mode) {
									modeInst = mi;
									break;
								}
							}
							comp = comp.getContainingComponentInstance();
						}
						if (modeInst != null) {
							inSOMs.addAll(mode2som.get(modeInst));
						}
					}
				}
				for (SystemOperationMode som : inSOMs) {
					if (io.isActive(som)) {
						newVal.getInModes().add(som);
					}
				}
				if (!newVal.getInModes().isEmpty()) {
					pa.getOwnedValues().add(newVal);
				}
			}
		}
	}

	protected ComponentInstance getComponentInstance(InstanceObject io) {
		EObject current = io;
		
		while (current != null && !(current instanceof ComponentInstance)) {
			current = current.eContainer();
		}
		return (ComponentInstance) current;
	}

	/*
	 * Returns a set of SystemOperationModes such that each SOM contains a
	 * ModeInstance contained in the given modeContext and that ModeInstance is
	 * an instance of a mode in inModes.
	 */
	private List<SystemOperationMode> convertInModesToInSOMs(final ComponentInstance modeContext,
			final List<Mode> inModes) {
		final List<SystemOperationMode> inSOM = new LinkedList<SystemOperationMode>();
		for (Iterator<Mode> i = inModes.iterator(); i.hasNext();) {
			final Mode mode = i.next();
			for (Iterator<SystemOperationMode> soms = root.getSystemOperationModes().iterator(); soms.hasNext();) {
				final SystemOperationMode som = soms.next();
				for (Iterator<ModeInstance> mis = som.getCurrentModes().iterator(); mis.hasNext();) {
					final ModeInstance mi = mis.next();
					if (mi.eContainer().equals(modeContext) && mi.getMode().equals(mode)) {
						inSOM.add(som);
					}
				}
			}
		}
		return inSOM;
	}
}
