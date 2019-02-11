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
import org.osate.aadl2.Element;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.Mode;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.ReferenceValue;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.InstanceFactory;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.PropertyAssociationInstance;
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
import org.osate.aadl2.properties.PropertyEvaluationResult;
import org.osate.aadl2.util.OsateDebug;

/**
 * TODO: Add comment
 * @author lwrage
 */
public class CachePropertyAssociationsSwitch extends AadlProcessingSwitchWithProgress {

	/*
	 * PropertyFilter contains all properties used in the model.
	 */
	private List<Property> propertyFilter;

	private HashMap<InstanceObject, InstantiatedClassifier> classifierCache;

	/**
	 * Maps mode instances to SOMs that contain this mode instance
	 */
	final private HashMap<ModeInstance, List<SystemOperationMode>> mode2som;

	/*
	 * The cache of contained property associations that apply to semantic
	 * connections.
	 */
	final private SCProperties scProps;

	protected CachePropertyAssociationsSwitch(final IProgressMonitor pm, final AnalysisErrorReporterManager errManager,
			final List<Property> filter, final HashMap<InstanceObject, InstantiatedClassifier> classifierCache,
			final SCProperties scProps, final HashMap<ModeInstance, List<SystemOperationMode>> mode2som) {
		super(pm, PROCESS_POST_ORDER_ALL, errManager);
		propertyFilter = filter;
		this.classifierCache = classifierCache;
		this.scProps = scProps;
		this.mode2som = mode2som;
	}

	@Override
	protected void initSwitches() {
		instanceSwitch = new InstanceSwitch<String>() {
			@Override
			public String caseComponentInstance(final ComponentInstance ci) {
				if (monitor.isCanceled()) {
					cancelTraversal();
					return DONE;
				}
				final int size;
				if (ci instanceof SystemInstance) {
					size = ((SystemInstance) ci).getComponentImplementation().getOwnedPropertyAssociations().size();
					monitor.subTask("Caching " + size + " property associations");
				} else if (ci.getContainingComponentInstance() instanceof SystemInstance) {
					monitor.subTask("Caching property associations in " + ci.getName());
				}

				cachePropertyAssociations(ci);
				return DONE;
			}

			@Override
			public String caseConnectionInstance(ConnectionInstance conni) {
				if (monitor.isCanceled()) {
					cancelTraversal();
					return DONE;
				}
				cacheConnectionPropertyAssociations(conni);
				return DONE;
			}

			@Override
			public String caseConnectionReference(ConnectionReference cr) {
				if (monitor.isCanceled()) {
					cancelTraversal();
				}
				return DONE;
			}

			@Override
			public String caseInstanceObject(InstanceObject iobj) {
				if (monitor.isCanceled()) {
					cancelTraversal();
					return DONE;
				}
				cachePropertyAssociations(iobj);
				return DONE;
			}
		};
	}

	SCProperties getSemanticConnectionProperties() {
		return scProps;
	}

	protected void cachePropertyAssociations(InstanceObject io) {
		// OsateDebug.osateDebug ("[CachePropertyAssociation] io=" + io);

		try {
			for (Property property : propertyFilter) {
				if (io.acceptsProperty(property)) {

					/*
					 * Just look up the property. The property doesn't yet have a
					 * local association, so lookup will get the value from the
					 * declarative model. Property lookup process now corrects
					 * reference values to instance reference values.
					 */
					PropertyEvaluationResult result = property.evaluate(new EvaluationContext(io, classifierCache), 0);
					List<EvaluatedProperty> evaluated = result.getEvaluated();

					if (!evaluated.isEmpty()) {
						// OsateDebug.osateDebug ("[CachePropertyAssociation] io=" + io + ";property=" + property + ";value=" + value);
						PropertyAssociationInstance newPA = InstanceFactory.eINSTANCE
								.createPropertyAssociationInstance();

						io.removePropertyAssociations(property);
						newPA.setProperty(property);
						newPA.setPropertyAssociation(getDeclarativePA(result.getPa()));
						fillPropertyValue(io, newPA, evaluated);
						if (!newPA.getOwnedValues().isEmpty()) {
							io.getOwnedPropertyAssociations().add(newPA);
						}
					}
				}
				checkIfCancelled();
				if (cancelled()) {
					break;
				}
			}
		} catch (IllegalStateException e) {
			// circular dependency
			// xxx: this is a misleading place to put the marker
			OsateDebug.osateDebug("IllegalStateException raised in cachePropertyAssociations");
			error(io, e.getMessage());
			return;
		} catch (InvalidModelException e) {
			OsateDebug.osateDebug("InvalidModelException raised in cachePropertyAssociations");
			error(e.getElement(), e.getMessage());
			return;
		}
	}

	private PropertyAssociation getDeclarativePA(PropertyAssociation pa) {
		while (pa instanceof PropertyAssociationInstance) {
			pa = ((PropertyAssociationInstance) pa).getPropertyAssociation();
		}
		return pa;
	}

	protected void cacheConnectionPropertyAssociations(final ConnectionInstance conni) {
		PropertyAssociation setPA;
		PropertyExpression defaultvalue;

		try {
			/*
			 * propertyFilter contains all properties used by the system, so, we try to
			 * use the one associated to the connection instance and their reference and
			 * see if the user declares a specific value.
			 */
			for (Property prop : propertyFilter) {
				setPA = null;

				defaultvalue = prop.getDefaultValue();

				for (final ConnectionReference connRef : conni.getConnectionReferences()) {

					/*
					 * In the following piece of code, we check that a property
					 * is consistent all along the connection reference.
					 * For example, we check that the timing property (immediate, delayed)
					 * is consistent for each connection.
					 */
					if (connRef.acceptsProperty(prop)) {
						/*
						 * Just look up the property. The property doesn't yet have
						 * a local association, so lookup will get the value from
						 * the declarative model. Property lookup process now
						 * corrects reference values to instance reference values.
						 */

						final PropertyAssociation propAssociation = scProps.retrieveSCProperty(conni, prop,
								connRef.getConnection());

						final EvaluationContext ctx = new EvaluationContext(connRef, classifierCache, propAssociation);
						PropertyEvaluationResult result = prop.evaluate(ctx, 0);
						List<EvaluatedProperty> evaluated = result.getEvaluated();

						if (!evaluated.isEmpty()) {
							PropertyAssociationInstance newPA = InstanceFactory.eINSTANCE
									.createPropertyAssociationInstance();

							newPA.setProperty(prop);
							newPA.setPropertyAssociation(getDeclarativePA(result.getPa()));
							fillPropertyValue(connRef, newPA, evaluated);
							if (!newPA.getOwnedValues().isEmpty()) {
								/*
								 * FIXME JD
								 *
								 * Try to look if the property references a component or not.
								 * This was done to fix the issue related to the Bound Bus analysis plugin
								 */
								for (Iterator<Element> content = EcoreUtil.getAllProperContents(newPA, false); content
										.hasNext();) {
									Element elem = content.next();
									if (elem instanceof ModalPropertyValue) {
										ModalPropertyValue mpv = (ModalPropertyValue) elem;
										if (mpv.getOwnedValue() instanceof ListValue) {
											ListValue lv = (ListValue) mpv.getOwnedValue();
											for (Element e : lv.getOwnedListElements()) {
												if (e instanceof ReferenceValue) {
													PropertyExpression irv = ((ReferenceValue) e)
															.instantiate(conni.getContainingComponentInstance());
													if (irv != null) {
														lv.getOwnedListElements().remove(e);
														lv.getOwnedListElements().add(irv);
													}
												}
											}
										}
									}
									if (elem instanceof ReferenceValue) {
										PropertyExpression irv = ((ReferenceValue) elem)
												.instantiate(conni.getContainingComponentInstance());
										if (irv != null) {
											EcoreUtil.replace(elem, irv);
										}
									}
								}

								scProps.recordSCProperty(conni, prop, connRef.getConnection(), newPA);

								if (setPA == null) {
									setPA = newPA;
									conni.getOwnedPropertyAssociations().add(newPA);
								} else {
									// check consistency
									for (Mode m : conni.getSystemInstance().getSystemOperationModes()) {
										PropertyExpression newVal = newPA.valueInMode(m);
										PropertyExpression setVal = setPA.valueInMode(m);
										if (!newVal.sameAs(setVal)) {
											error(conni, "Value for property " + setPA.getProperty().getQualifiedName()
													+ " not consistent along connection");
											break;
										}
									}
								}
							}
						}
					}
				}
				checkIfCancelled();
				if (cancelled()) {
					break;
				}
			}
		} catch (IllegalStateException e) {
			// circular dependency
			// xxx: this is a misleading place to put the marker
			error(conni, e.getMessage());
			System.out.println("IllegalStateException raised in cacheConnectionPropertyAssociations");
		} catch (InvalidModelException e) {
			error(conni, e.getMessage());
			System.out.println("InvalidModelException raised in cacheConnectionPropertyAssociations");
		}

	}

	private void fillPropertyValue(InstanceObject io, PropertyAssociation pa, List<EvaluatedProperty> values) {

		PropertyExpression lexp;
		List<PropertyExpression> elems;
		final Iterator<EvaluatedProperty> valueIter = values.iterator();
		final EvaluatedProperty value = valueIter.next();
		final List<MpvProxy> proxies = value.getProxies();

		for (MpvProxy proxy : proxies) {

			ModalPropertyValue newVal = Aadl2Factory.eINSTANCE.createModalPropertyValue();
			List<SystemOperationMode> inSOMs = new ArrayList<SystemOperationMode>();

			newVal.setOwnedValue(EcoreUtil.copy(proxy.getValue()));
			// process list appends
			while (valueIter.hasNext()) {
				MpvProxy prx = valueIter.next().getProxies().get(0);

				if (prx.isModal()) {
					throw new InvalidModelException(pa, "Trying to append to a modal list value");
				}

				lexp = EcoreUtil.copy(prx.getValue());
				elems = ((ListValue) lexp).getOwnedListElements();

				((ListValue) newVal.getOwnedValue()).getOwnedListElements().addAll(0, elems);
			}

			boolean valueIsUsed = false;
			if (!proxy.isModal()) {
				valueIsUsed = true;
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
							List<ModeInstance> holderModes = (io instanceof ComponentInstance)
									? ((ComponentInstance) io).getModeInstances()
									: io.getContainingComponentInstance().getModeInstances();

							for (ModeInstance mi : holderModes) {
								if (mi.getMode() == mode) {
									if (mode2som.containsKey(mi)) {
										inSOMs.addAll(mode2som.get(mi));
										break;
									}
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
					valueIsUsed = true;
					pa.getOwnedValues().add(newVal);
				}
			}
			if (valueIsUsed) {
				// replace reference values in the context of the contained PA's owner
				for (Iterator<Element> content = EcoreUtil.getAllProperContents(newVal, false); content.hasNext();) {
					Element elem = content.next();

					if (elem instanceof ReferenceValue) {
						try {
							PropertyExpression irv = ((ReferenceValue) elem).instantiate(io);
							if (irv != null) {
								EcoreUtil.replace(elem, irv);
							}
						} catch (InvalidModelException e) {
							error(io, e.getMessage());
						}
					}
				}
			}
		}
	}

}
