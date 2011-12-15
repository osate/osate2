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
 * @version $Id: RequiredConnectionSwitch.java,v 1.48 2009-11-11 20:58:13 jseibel Exp $
 */
package edu.cmu.sei.aadl.architecture;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.AccessConnection;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Connection;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.DeviceSubcomponent;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.aadl2.EventPort;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.ModeTransitionTrigger;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Port;
import org.osate.aadl2.ProcessSubcomponent;
import org.osate.aadl2.ProcessorSubcomponent;
import org.osate.aadl2.Property;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramSubcomponent;
import org.osate.aadl2.SystemSubcomponent;
import org.osate.aadl2.ThreadGroupSubcomponent;
import org.osate.aadl2.ThreadSubcomponent;
import org.osate.aadl2.TriggerPort;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitchWithProgress;
import org.osate.aadl2.properties.InvalidModelException;
import org.osate.aadl2.util.Aadl2Switch;
import org.osate.xtext.aadl2.properties.util.GetProperties;
import org.osate.xtext.aadl2.properties.util.PropertyUtils;

/**
 * @author phf This class provides for checking whether the required_connection
 *         property on ports is satisfied in declarative models. It also
 *         contains a check for matching miss rates on port connections. In the
 *         future it will contain additional architecture consistency checks.
 *         Their invocation will be individually controllable.
 */
public final class RequiredConnectionSwitch extends AadlProcessingSwitchWithProgress {
	/**
	 * the analysis method that is invoked on each visited model element. If the
	 * analysis is being run on the instance model, pass the name of the
	 * SystemOperationMode. If the analysis is being run on the declarative
	 * model, pass null for the String somName.
	 */
	public RequiredConnectionSwitch(final IProgressMonitor pm, final AnalysisErrorReporterManager errMgr) {
		super(pm, PROCESS_PRE_ORDER_ALL, errMgr);
	}

	protected void initSwitches() {
		aadl2Switch = new Aadl2Switch<String>() {
			/**
			 * Check whether the RequiredConnection property is satisfied for
			 * ports This checks whether a (sub)component has "external"
			 * connections to its ports that require connections.
			 */
			public String caseSubcomponent(Subcomponent sub) {
				final ComponentImplementation parentCI = sub.getComponentImplementation();

				// Advance the task
				final String ciName = parentCI.getName();
				final String subName = sub.getName();
//				if (ciName != null && subName != null) {
//					monitor.subTask("Checking subcomponent " + subName + " of " + ciName);
//				}

				Collection<Feature> portlist = sub.getAllFeatures();
				EList<Mode> modes = parentCI.getAllModes();
				if (modes.size() == 0) {
					EList<Connection> connlist = parentCI.getAllConnections();
					checkRequiredConnection(portlist, sub, connlist, null);
				} else {
					for (Iterator<Mode> mit = modes.iterator(); mit.hasNext();) {
						Mode m = mit.next();
						EList<Mode> subim = sub.getAllInModes();
						if (subim.isEmpty() || subim.contains(modes)) {
							EList<Connection> connlist = parentCI.getAllConnections(m);
							checkRequiredConnection(portlist, sub, connlist, m);
						}
					}
				}

				// Advance the work
				monitor.worked(1);
				checkIfCancelled();
				return DONE;
			}

			/**
			 * Check whether the RequiredConnection property is satisfied for
			 * ports This checks whether an implementaiton has connections to
			 * its ports, i.e., processes them in its implementation.
			 */
			public String caseComponentImplementation(ComponentImplementation ci) {
				// if no subcomponents then there is no need to connect interally
				if (!hasPortComponents(ci.getAllSubcomponents()))
					return NOT_DONE;
				Collection<Feature> portlist = ci.getAllFeatures();
				EList<Mode> modes = ci.getAllModes();
				if (modes.size() == 0) {
					EList<Connection> connlist = ci.getAllConnections();
					checkRequiredConnection(portlist, ci, connlist, null);
				} else {
					for (Iterator<Mode> mit = modes.iterator(); mit.hasNext();) {
						Mode m = mit.next();
						EList<Connection> connlist = ci.getAllConnections(m);
						checkRequiredConnection(portlist, ci, connlist, m);
					}
				}
				checkIfCancelled();
				return DONE;
			}

			private boolean hasPortComponents(EList<Subcomponent> subcomps) {
				for (Iterator<Subcomponent> it = subcomps.iterator(); it.hasNext();) {
					Subcomponent o = it.next();
					if (o instanceof SystemSubcomponent || o instanceof ProcessSubcomponent
							|| o instanceof ThreadGroupSubcomponent || o instanceof ThreadSubcomponent
							|| o instanceof DeviceSubcomponent || o instanceof ProcessorSubcomponent
							|| o instanceof SubprogramSubcomponent) {
						return true;
					}
				}
				return false;
			}

			/**
			 * Check whether all ports in the feature list satisfy their
			 * Required_Connection property The connection list is either that
			 * of the enclosing component impl for subcomponents (representing
			 * external connections) or that of the component impl itself to be
			 * used to check internal connections of components
			 * 
			 * @param featurelist List of ports
			 * @param cxt The context for the port list, i.e., a subcomponent or
			 *            component impl
			 * @param connlist The connection list with connections to the
			 *            ports.
			 */
			private void checkRequiredConnection(final Collection<Feature> featurelist, final NamedElement cxt,
					final EList<Connection> connlist, final Mode m) {
				// check to ensure that ports with required connections have connections
				// phf: handling of access connections?
				for (Iterator<Feature> dpit = featurelist.iterator(); dpit.hasNext();) {
					final Feature dp = dpit.next();
					if (dp instanceof Port) {
						int incomingCount = 0;
						int outgoingCount = 0;
						Connection conn = null;
						// check if port connections are required
						try {
							if (GetProperties.getRequiredConnection(cxt)) {
								for (Iterator<Connection> it = connlist.iterator(); it.hasNext();) {
									conn = it.next();
									// Ignore access connections, they don't affect ports
									if (!(conn instanceof AccessConnection)) {
										ConnectionEnd source = conn.getAllSource();
										ConnectionEnd dest = conn.getAllDestination();
										/*
										 * if the source or destination is
										 * missing, skip to the next connection.
										 */
										if (source == null || dest == null)
											continue;
										NamedElement sourceCxt = conn.getAllSrcContextComponent();
										NamedElement destCxt = conn.getAllDstContextComponent();
										if (dest == dp && destCxt == cxt) {
											incomingCount++;
										}
										if (source == dp && sourceCxt == cxt) {
											outgoingCount++;
										}
									}
								}

								final boolean inSubcomponent = cxt instanceof Subcomponent;
								final Element errLocation = inSubcomponent ? cxt : dp;
								final String inmode = m == null ? "" : "In mode '" + m.getName() + "' ";
								final String scName = inSubcomponent ? " of subcomponent '" + cxt.getName()
										+ "' in component '" + cxt.getContainingComponentImpl().getName() + "'"
										: " in component '" + dp.getContainingClassifier().getName() + "'";
								if (dp instanceof Port) {
									DirectionType pdir = ((Port) dp).getDirection();
									if ((inSubcomponent ? pdir == DirectionType.OUT
											: pdir == DirectionType.IN)
											|| pdir == DirectionType.IN_OUT) {
										if (outgoingCount < 1) {
											// check whether the port is named in a mode transition
											if (dp instanceof EventPort) {
												boolean foundModeTransition = false;
												ComponentImplementation ci = inSubcomponent ? ((Subcomponent) cxt)
														.getContainingComponentImpl() : (ComponentImplementation) cxt;
												EList<ModeTransition> mtl = ci.getAllModeTransitions();
												for (Iterator<ModeTransition> it = mtl.iterator(); it.hasNext() && !foundModeTransition;) {
													ModeTransition mt = it.next();
													for (ModeTransitionTrigger mtt : mt.getOwnedTriggers()) {
														if (mtt instanceof TriggerPort && ((TriggerPort)mtt).getPort().equals(dp)) {
															foundModeTransition = true;
														}
													}
												}
												if (!foundModeTransition) {
													warning(
															errLocation,
															inmode
																	+ "Port '"
																	+ dp.getName()
																	+ "' "
																	+ scName
																	+ " does not have required outgoing connection and is not named in mode transition");
												}
											} else {
												warning(errLocation, inmode + "Port '" + dp.getName() + "' " + scName
														+ " does not have required outgoing connection");
											}
										}
									}
									if ((inSubcomponent ? pdir == DirectionType.IN
											: pdir == DirectionType.OUT)
											|| pdir == DirectionType.IN_OUT) {
										if (incomingCount < 1) {
											warning(errLocation, inmode + "Port '" + dp.getName() + "' " + scName
													+ " does not have required incoming connection");
										}
									}
								} else if (dp instanceof FeatureGroup) {
									if (outgoingCount < 1 && incomingCount < 1) {
										warning(errLocation, inmode + "Port group '" + dp.getName() + "' " + scName
												+ " does not have required connection");
									}
								}
							}
						} catch (InvalidModelException e) {
							error(e.getElement(), e.getMessage());
							return;
						}
					}
				}
			}
		};
	}
}
