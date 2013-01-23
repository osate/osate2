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
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.aadl2.instance.util.InstanceUtil.InstantiatedClassifier;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitchWithProgress;
import org.osate.aadl2.properties.EvaluatedProperty;
import org.osate.aadl2.properties.EvaluatedProperty.MpvProxy;
import org.osate.aadl2.properties.EvaluationContext;
import org.osate.aadl2.properties.InvalidModelException;
import org.osate.aadl2.util.OsateDebug;

/**
 * TODO: Add comment
 * @author lwrage
 */
class CachePropertyAssociationsSwitch extends AadlProcessingSwitchWithProgress {
	private List<Property> propertyFilter;
//	private SystemInstance root;

	private HashMap<InstanceObject, InstantiatedClassifier> classifierCache;

	/**
	 * Maps mode instances to SOMs that contain this mode instance
	 */
	private HashMap<ModeInstance, List<SystemOperationMode>> mode2som;

	/*
	 * The cache of contained property associations that apply to semantic
	 * connections.
	 */
	private SCProperties scProps;

	CachePropertyAssociationsSwitch(IProgressMonitor pm, AnalysisErrorReporterManager errManager, SystemInstance si,
			List<Property> filter, HashMap<InstanceObject, InstantiatedClassifier> classifierCache,
			SCProperties scProps, HashMap<ModeInstance, List<SystemOperationMode>> mode2som) {
		super(pm, PROCESS_POST_ORDER_ALL, errManager);
		propertyFilter = filter;
//		root = si;
		this.classifierCache = classifierCache;
		this.scProps = scProps;
		this.mode2som = mode2som;
	}

	protected void initSwitches() {
		instanceSwitch = new InstanceSwitch<String>() {
			@Override
			public String caseComponentInstance(ComponentInstance ci) {
				if (ci instanceof SystemInstance) {
					int size = ((SystemInstance) ci).getSystemImplementation().getOwnedPropertyAssociations().size();
					monitor.subTask("Caching " + size + " property associations");
				} else if (ci.getContainingComponentInstance() instanceof SystemInstance) {
					monitor.subTask("Caching property associations in " + ci.getName());
				}
				cachePropertyAssociations(ci);
				return DONE;
			}

			@Override
			public String caseConnectionInstance(ConnectionInstance conni) {
				cacheConnectionPropertyAssociations(conni);
				return DONE;
			}

			@Override
			public String caseConnectionReference(ConnectionReference cr) {
				return DONE;
			}

			@Override
			public String caseInstanceObject(InstanceObject iobj) {
				cachePropertyAssociations(iobj);
				return DONE;
			}
		};
	}

	SCProperties getSemanticConnectionProperties() {
		return scProps;
	}

	protected void cachePropertyAssociations(InstanceObject io)
	{
		//OsateDebug.osateDebug ("[CachePropertyAssociation] io=" + io);
		
		for (Property property : propertyFilter) {
			//OsateDebug.osateDebug  ("   property=" + property);
			if (io.acceptsProperty(property))
			{
				/*
				 * Just look up the property. The property doesn't yet have a
				 * local association, so lookup will get the value from the
				 * declarative model. Property lookup process now corrects
				 * reference values to instance reference values.
				 */
				try {
					List<EvaluatedProperty> value = property.evaluate(new EvaluationContext(io, classifierCache));
					//OsateDebug.osateDebug ("   value=" + value);

					if (!value.isEmpty()) {
						PropertyAssociation pa = io.createOwnedPropertyAssociation();

						io.removePropertyAssociations(property);
						pa.setProperty(property);
						fillPropertyValue(io, pa, value);
					}
				} catch (IllegalStateException e) {
					// circular dependency
					// xxx: this is a misleading place to put the marker
					error(io, e.getMessage());
				} catch (InvalidModelException e) {
					
					error(e.getElement(), e.getMessage());
				}
			}
			else
			{
				//OsateDebug.osateDebug ("   prperty not accepted on " + io);

			}
			checkIfCancelled();
			if (cancelled())
				break;
		}
	}

	protected void cacheConnectionPropertyAssociations(ConnectionInstance conni) {
		for (Property prop : propertyFilter) {
			PropertyAssociation setPA = null;

			PropertyExpression defaultvalue = prop.getDefaultValue();
			if (defaultvalue instanceof NamedValue){
				AbstractNamedValue val = ((NamedValue)defaultvalue).getNamedValue();
				if (val instanceof NamedElement){
					
				}
			}
			for (ConnectionReference connRef : conni.getConnectionReferences()) {
				// acceptance test of connref tests connection itself
				if (connRef.acceptsProperty(prop)) {
					/*
					 * Just look up the property. The property doesn't yet have
					 * a local association, so lookup will get the value from
					 * the declarative model. Property lookup process now
					 * corrects reference values to instance reference values.
					 */
					try {
						List<EvaluatedProperty> value = prop.evaluate(new EvaluationContext(connRef, classifierCache,
								scProps.retrieveSCProperty(conni, prop, connRef.getConnection())));

						if (!value.isEmpty()) {
							PropertyAssociation newPA = Aadl2Factory.eINSTANCE.createPropertyAssociation();

							newPA.setProperty(prop);
							fillPropertyValue(connRef, newPA, value);
							scProps.recordSCProperty(conni, prop, connRef.getConnection(), newPA);

							if (setPA == null) {
								conni.getOwnedPropertyAssociations().add(newPA);
								setPA = newPA;
							} else {
								// check consistency
								for (Mode m : conni.getSystemInstance().getSystemOperationModes()) {
									if (!newPA.valueInMode(m).equals(setPA.valueInMode(m))){
										//  this comparison return inequality even if the two proeprty values are the same. They are
										// enumeration literals kept in a NameValue object and there are two isntances of the NemdValue object pointing to the same literal
										// The second issue is that evaluate may return the default value for the property, which may be different from the assigned value.
										if (!newPA.valueInMode(m).equals(defaultvalue)&& !setPA.valueInMode(m).equals(defaultvalue)) {
											// TODO Fix
//											error(conni, "Value for property " + setPA.getProperty().getQualifiedName()
//													+ " not consistent along connection");
											break;
										}
									}
								}
							}
						}
					} catch (IllegalStateException e) {
						// circular dependency
						// xxx: this is a misleading place to put the marker
						error(conni, e.getMessage());
					} catch (InvalidModelException e) {
						error(e.getElement(), e.getMessage());
					}
				}
				checkIfCancelled();
				if (cancelled())
					break;
			}
		}
	}

	private void fillPropertyValue(InstanceObject io, PropertyAssociation pa, List<EvaluatedProperty> values) {
		Iterator<EvaluatedProperty> valueIter = values.iterator();
		EvaluatedProperty value = valueIter.next();

		for (MpvProxy proxy : value.getProxies()) {
			ModalPropertyValue newVal = Aadl2Factory.eINSTANCE.createModalPropertyValue();
			List<SystemOperationMode> inSOMs = new ArrayList<SystemOperationMode>();

			newVal.setOwnedValue(EcoreUtil.copy(proxy.getValue()));
			// process list appends
			while (valueIter.hasNext()) {
				MpvProxy prx = valueIter.next().getProxies().get(0);

				if (prx.isModal()) {
					throw new InvalidModelException(pa, "Trying to append to a modal list value");
				}
				PropertyExpression lexp = EcoreUtil.copy(prx.getValue());
				List<PropertyExpression> elems = ((ListValue) lexp).getOwnedListElements();

				((ListValue) newVal.getOwnedValue()).getOwnedListElements().addAll(0, elems);
			}
			if (!proxy.isModal()) {
				pa.getOwnedValues().add(newVal);
			} else {
				List<Mode> modes = proxy.getModes();

				for (Mode mode : modes) {
					if (mode instanceof SystemOperationMode) {
						inSOMs.add((SystemOperationMode) mode);
					} else {

						if (io instanceof ConnectionReference) {
							List<SystemOperationMode> conniModes = ((ConnectionInstance) io.eContainer())
									.getInSystemOperationModes();
							if (conniModes.isEmpty()) {
								conniModes = io.getSystemInstance().getSystemOperationModes();
							}
							List<ModeInstance> holderModes = ((ConnectionReference) io).getContext().getModeInstances();

							for (ModeInstance mi : holderModes) {
								if (mi.getMode() == mode) {
									for (SystemOperationMode som : conniModes) {
										if (som.getCurrentModes().contains(mi)) {
											inSOMs.add(som);
										}
									}
									break;
								}
							}
						} else {
							List<ModeInstance> holderModes = (io instanceof ComponentInstance) ? ((ComponentInstance) io)
									.getModeInstances() : io.getContainingComponentInstance().getModeInstances();

							for (ModeInstance mi : holderModes) {
								if (mi.getMode() == mode) {
									inSOMs.addAll(mode2som.get(mi));
									break;
								}
							}
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

}
