/**
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
 * @version $Id$
 */
package org.osate.aadl2.parser;




/**
 * Checks an AADL Object model (i.e., an aaxl file) for consistency.
 * These are basic checks on the model
 * structure to make sure it is fit for more advanced AADL semantic checks
 * and other analyses.  This analysis is based on the AADL Name and Numeric
 * resolvers:
 * <ul>
 * <li>The intent is that if the model is being generated from AADL source
 * text, then the name resolver is to be used, followed by the 
 * numeric resolver.
 * <li>If the model objects are being edited/created directly, or the origin of
 * the model is otherwise suspect, then the sanity check is to be run directly
 * on the model and the name resolver and the numeric resolver are not used.
 * </ul>
 * 
 * <p>The general idea is that models that pass the sanity check should be
 * in an equivalent state of suitability as are parsed models that pass through
 * the name resolver and the numeric resolver.  
 */
/*
 * XXX: Commented out entire class to remove error markers.  Not currently used in Aadl 2 beta.
 * Need to check if this should be used after implementing the Xtext parser.
 */
public class AadlModelSanityChecker/* extends AadlProcessingSwitchWithProgress*/ {
//	public AadlModelSanityChecker(final IProgressMonitor monitor,
//			final AnalysisErrorReporterManager manager) {
//		super(monitor, PROCESS_PRE_ORDER_ALL, manager);
//	}
//
//	public AadlModelSanityChecker(final AnalysisErrorReporterManager manager) {
//		super(new NullProgressMonitor(), PROCESS_PRE_ORDER_ALL, manager);
//	}
//
//	/**
//	 * Test for cycle in the extends hierarchy.
//	 * 
//	 * @param cc
//	 *                 The component to start the search from.
//	 * @param sb
//	 *                 String buffer in which to record error information. The
//	 *                 contents are modified as a side effect of this method.
//	 * @return <code>null</code> if there is no cycle; a reference to the
//	 *             component that makes the cyclic reference otherwise.
//	 */
//	private static Classifier testForExtensionLoop(Classifier cc, StringBuffer sb) {
//		final Set visited = new HashSet();
//		do {
//			visited.add(cc);
//			sb.append(cc.getName());
//			sb.append(" extends ");
//			cc = cc.getXExtend();
//		} while (cc != null && !visited.contains(cc));
//		if (cc != null) {
//			sb.append(cc.getName());
//		}
//		return cc;
//	}
//
//	private void updateProgress(final Classifier c) {
//		final String name = c.getQualifiedName();
//		if (name != null) {
//			monitor.subTask("Checking " + name);
//		}		
//		if (monitor.isCanceled()) {
//			cancelTraversal();
//		}
//	}
//	
//	protected final void initSwitches() {
//		coreSwitch = new CoreSwitch() {	
//			public Object caseComponentType(final ComponentType type) {
//				updateProgress(type);
//				final StringBuffer sb = new StringBuffer();
//				final Classifier bad = testForExtensionLoop(type, sb);
//				if (bad != null) {
//					/* break the loop or else future checks will cause stack
//					 * overflow errors from inifinite looping
//					 */
//					bad.eUnset(bad.eClass().getEStructuralFeature("extend"));
//					error(type, "Component type has loop in its ancestry: " + sb + ".  Loop has been broken to allow analysis to continue.");
//				}
//				monitor.worked(1);
//				return DONE;
//			}
//
//			public Object caseComponentImpl(ComponentImpl impl) {
//				updateProgress(impl);
//				/* Check that implementation has a non-null component type
//				 * reference, and that the implementation can implement
//				 * the referenced type.
//				 */ 
//				final ComponentType cType = impl.getComponentType();
//				if (cType == null) {
//					error(impl, "Component type reference is null");
//				} else {
//					final String typeNameFromRef = cType.getName();
//					final String typeName = impl.getTypeName();
//					if (!typeName.equalsIgnoreCase(typeNameFromRef)) {
//						error(impl, "Component type reference is named '" +
//								typeNameFromRef + "' when it should be '" + typeName +"'");
//					}
//				}
//
//				final StringBuffer sb = new StringBuffer();
//				final Classifier bad = testForExtensionLoop(impl, sb);
//				if (bad != null) {
//					/*
//					 * break the loop or else future checks will cause stack
//					 * overflow errors from inifinite looping
//					 */
//					bad.eUnset(bad.eClass().getEStructuralFeature("extend"));
//					error(impl, "Component implementation has loop in its ancestry: " + sb + ".  Loop has been broken to allow analysis to continue.");
//				}
//				monitor.worked(1);
//				return DONE;
//			}
//			
//			public Object caseMode(Mode m) {
//				final Mode refines = m.getRefines();
//				if (refines != null) {
//					ComponentImpl superimpl = (ComponentImpl) ((ComponentImpl) m.eContainer().eContainer()).getXExtend();
//					if (superimpl != null) {
//						final Mode shouldRefine = superimpl.findMode(m.getName());
//						if (shouldRefine == null) {
//							error(m, "Refined mode '" + m.getName() + "' not found");
//						} else if (shouldRefine != refines) {
//							error(m, "Refined mode '" + m.getName() + "' has an incorrect refinement reference");
//						}
//					} else {
//						error(m,	"Mode '" + m.getName() + "' cannot be refined: refinement only allowed in implementation extension");
//					}
//				}
//				return DONE;
//			}
//
//			public Object caseModeMember(ModeMember mm) {
//				final ComponentImpl impl = mm.getContainingComponentImpl();
//				if (impl != null) {
//					if (mm.getInModes() != null && mm.getInModes().size() != 0) {
//						final EList legalModes = impl.getAllMode();
//						final Iterator inModes = mm.getInModes().iterator();
//						while (inModes.hasNext()) {
//							final Mode m = (Mode) inModes.next();
//							if (!legalModes.contains(m)) {
//								error(mm, "Cannot be in mode '" + m.getName() + "' because it is not a mode of the containing component implementation");
//							}
//						}
//					}
//				} else {
//					error(mm, "Couldn't get containing component implementation");
//				}
//				return DONE;
//			}
//
//			public Object caseModeTransition(ModeTransition mt) {
//				final ComponentImpl impl = mt.getContainingComponentImpl();
//				if (impl != null) {
//					final EList legalModes = impl.getAllMode();
//					
//					final Mode srcMode = mt.getSrcMode();
//					if (srcMode == null) {
//						error(mt, "Source mode is null");
//					} else if (!legalModes.contains(srcMode)) {
//						error(mt, "Source mode is not from the containing component implementation");
//					}
//					
//					final Mode destMode = mt.getDstMode();
//					if (destMode == null) {
//						error(mt, "Destination mode is null");
//					} else if (!legalModes.contains(destMode)) {
//						error(mt, "Destination mode is not from the containing component implementation");
//					}
//
//					final EList triggerList = mt.getTriggerEventPort();
//					final EList triggerCtxList = mt.getTriggerEventPortContext();
//					if (triggerList == null) {
//						error(mt, "List of triggers is null");
//					} else {
//						if (triggerCtxList == null) {
//							error(mt, "List of trigger feature contexts is null");
//						} else {
//							if (triggerList.size() != triggerCtxList.size()) {
//								error(mt, "Lists of triggers and trigger feature contects do not have the same length");
//							} else {
//								final Iterator triggers = triggerList.iterator();
//								final Iterator ctxts = triggerCtxList.iterator();
//								int index = 1;
//								while (triggers.hasNext()) {
//									final EventPort trigger = (EventPort) triggers.next();
//									final FeatureContext context = (FeatureContext) ctxts.next();
//									boolean found = true;
//									if (context instanceof ComponentImpl) {
//										if (context != impl) {
//											error(mt, "Feature context " + index + 
//													" is a component implementation but does not reference the containing component implementation");
//										} else {
//											found = impl.getComponentType().findFeature(trigger.getName()) == trigger;
//										}
//									} else if (context instanceof PortGroup) {
//										final PortGroup pg = (PortGroup) context;
//										if (impl.getComponentType().findFeature(pg.getName()) != pg) {
//											error(mt, "Feature context " + index +
//													", port group '" + pg.getName() +
//													"' is not a feature of the containing component implementation's type");
//										} else {
//											found = pg.findFeature(trigger.getName()) == trigger;
//										}
//									} else if (context instanceof Subcomponent) {
//										final Subcomponent sub = (Subcomponent) context;
//										if (impl.findSubcomponent(sub.getName()) != sub) {
//											error(mt, "Feature context " + index + 
//													", subcomponent '" + sub.getName() + 
//													"' is not a subcomponent of the containing component implementation");
//										} else {
//											found = sub.getComponentType().findFeature(trigger.getName()) == trigger;
//										}
//									} else {
//										error(mt, "Feature context " + index + " is not a component implementation, port group, or subcomponent: " + context.eClass().getName());
//									}
//									
//									if (!found) {
//										error(mt, "Couldn't find trigger event port " + index + ", '" + trigger.getName());
//									}
//									index += 1;
//								}
//							}
//						}
//					}
//				} else {
//					error(mt, "Couldn't get containing component implementation");
//				}
//				return DONE;
//			}
//			
//			public Object caseSubcomponent(Subcomponent sub) {
//				/* Check that if the subcomponent is marked as "refined"
//				 * that it has a non-null refinement reference, and that the
//				 * refinment references points to the correct thing.
//				 * 
//				 * Subprogram subcomponents do not have a "refines" feature!
//				 */
//				final EStructuralFeature refinesFeature = 
//					sub.eClass().getEStructuralFeature("refines");
//				if (refinesFeature != null) {
//					final Subcomponent refines = (Subcomponent) sub.eGet(refinesFeature);
//					if (refines != null) {
//						final ComponentImpl superimpl =
//							(ComponentImpl) ((ComponentImpl) sub.eContainer().eContainer()).getXExtend();
//						if (superimpl != null) {
//							final Subcomponent shouldRefine = superimpl.findSubcomponent(sub.getName());
//							if (shouldRefine == null) {
//								error(sub, "Refined subcomponent '" + sub.getName() + "' not found in super implementation");
//							} else if (shouldRefine != refines) {
//								error(sub, "Refined subcomponent '" + sub.getName() + "' has an incorrect refinement reference");
//							} else {
//								if (!AadlUtil.sameEClass(refines, sub)) {
//									error(sub, "Refined subcomponent '" + sub.getName() + "' has incompatible component category");
//								}
//							}
//						} else {
//							error(sub, "Subcomponent '" + sub.getName() + "' cannot be refined: refinement only allowed in implementation extension");
//						}
//					}
//				}
//				// Fall through to caseModeMember
//				return NOT_DONE;
//			}
//		};
//
//		connectionSwitch = new ConnectionSwitch() {
//			public Object caseModeMember(ModeMember object) {
//				return coreSwitch.caseModeMember(object);
//			}
//
//			public Object caseConnection(Connection conn) {
//				final ComponentImpl compImpl = conn.getContainingComponentImpl();
//				final Connection refines = 
//					(Connection) conn.eGet(conn.eClass().getEStructuralFeature("refines"));
//				
//				if (compImpl == null) {
//					error(conn, "Could not get containing component implementation");
//				} else {
//					// Check refinement
//					if (refines != null) {
//						ComponentImpl superimpl = (ComponentImpl) compImpl.getXExtend();
//						if (superimpl != null) {
//							final Connection shouldRefine = superimpl.findConnection(conn.getName());
//							if (shouldRefine == null) {
//								error(conn, "Refined connection '" + conn.getName() + "' not found in super implementation");
//							} else if (shouldRefine != refines) {
//								error(conn, "Refined connection '" + conn.getName() + "' has an incorrect refinement reference");
//							} else {
//								if (!AadlUtil.sameEClass(refines, conn)) {
//									error(conn, "Refined connection '" + conn.getName() + "' has incompatible type");
//								}
//							}
//						} else {
//							error(conn, "Connection '" + conn.getName() + "' cannot be refined: refinement only allowed in implementation extension");
//						}
//					}
//					
//					// check inModeTransitions
//					final EList inModeTrans = conn.getInModeTransitions();
//					if (inModeTrans != null && !inModeTrans.isEmpty()) {
//						List allTransitions = compImpl.getAllModeTransition();
//						if (allTransitions == null) allTransitions = Collections.EMPTY_LIST;
//						for (final Iterator iter = inModeTrans.iterator(); iter.hasNext();) {
//							final ModeTransition mt = (ModeTransition) iter.next();
//							if (!allTransitions.contains(mt)) {
//								error(conn, "Mode transition '" +
//										mt.getSrcModeName() + "->" +
//										mt.getDstModeName() +
//										"' not found in containing component");
//							}
//						}
//					}
//				}
//								
//				// Fall through to caseModeMember
//				return NOT_DONE;
//			}
//			
//			public Object caseDataConnection(DataConnection dc) {
//				final ComponentImpl compImpl = dc.getContainingComponentImpl();
//				final FeatureContext srcContext = dc.getSrcContext();
//				final FeatureContext dstContext = dc.getDstContext();
//				final DataPort src = dc.getSrc();
//				final DataPort dst = dc.getDst();
//				
//				if (compImpl == null) {
//					error(dc, "Couldn't get containing component implementation");
//				} else {
//					if (dc.getXRefines() == null) {
//						checkPortConnectionEnd(dc, compImpl, "Data port", "Source", srcContext, src);
//						checkPortConnectionEnd(dc, compImpl, "Data port", "Destination", dstContext, dst);
//					}
//				}
//				
//				// Fall through to caseConnection
//				return NOT_DONE;
//			}
//			
//			public Object caseEventConnection(EventConnection ec) {
//				final ComponentImpl compImpl = ec.getContainingComponentImpl();
//				final FeatureContext srcContext = ec.getSrcContext();
//				final FeatureContext dstContext = ec.getDstContext();
//				final EventPort src = ec.getSrc();
//				final EventPort dst = ec.getDst();
//				
//				if (compImpl == null) {
//					error(ec, "Couldn't get containing component implementation");
//				} else {
//					if (ec.getXRefines() == null) {
//						checkPortConnectionEnd(ec, compImpl, "Event port", "Source", srcContext, src);
//						checkPortConnectionEnd(ec, compImpl, "Event port", "Destination", dstContext, dst);
//					}
//				}
//				
//				// Fall through to caseConnection
//				return NOT_DONE;
//			}
//			
//			public Object caseEventDataConnection(EventDataConnection edc) {
//				final ComponentImpl compImpl = edc.getContainingComponentImpl();
//				final FeatureContext srcContext = edc.getSrcContext();
//				final FeatureContext dstContext = edc.getDstContext();
//				final EventDataPort src = edc.getSrc();
//				final EventDataPort dst = edc.getDst();
//				
//				if (compImpl == null) {
//					error(edc, "Couldn't get containing component implementation");
//				} else {
//					if (edc.getXRefines() == null) {
//						checkPortConnectionEnd(edc, compImpl, "Event data port", "Source", srcContext, src);
//						checkPortConnectionEnd(edc, compImpl, "Event data port", "Destination", dstContext, dst);
//					}
//				}
//				
//				// Fall through to caseConnection
//				return NOT_DONE;
//			}
//			
//			public Object casePortGroupConnection(PortGroupConnection pgc) {
//				final ComponentImpl compImpl = pgc.getContainingComponentImpl();
//				final FeatureContext srcContext = pgc.getSrcContext();
//				final FeatureContext dstContext = pgc.getDstContext();
//				final PortGroup src = pgc.getSrc();
//				final PortGroup dst = pgc.getDst();
//				
//				if (compImpl == null) {
//					error(pgc, "Couldn't get containing component implementation");
//				} else {
//					if (pgc.getXRefines() == null) {
//						checkPortConnectionEnd(pgc, compImpl, "Port group", "Source", srcContext, src);
//						checkPortConnectionEnd(pgc, compImpl, "Port group", "Destination", dstContext, dst);
//					}
//				}
//				
//				// Fall through to caseConnection
//				return NOT_DONE;
//			}
//			
//			public Object caseParameterConnection(ParameterConnection dc) {
//				final ComponentImpl compImpl = dc.getContainingComponentImpl();
//				final FeatureContext srcContext = dc.getSrcContext();
//				final FeatureContext dstContext = dc.getDstContext();
//				final ParameterEnd src = dc.getSrc();
//				final ParameterEnd dst = dc.getDst();
//				
//				if (compImpl == null) {
//					error(dc, "Couldn't get containing component implementation");
//				} else {
//					if (dc.getXRefines() == null) {
//						checkParameterConnectionEnd(dc, compImpl, "Source", srcContext, src);
//						checkParameterConnectionEnd(dc, compImpl, "Destination", dstContext, dst);
//					}
//				}
//				
//				// Fall through to caseConnection
//				return NOT_DONE;
//			}
//			
//			public Object caseDataAccessConnection(DataAccessConnection dc) {
//				final ComponentImpl compImpl = dc.getContainingComponentImpl();
//				final FeatureContext srcContext = dc.getSrcContext();
//				final FeatureContext dstContext = dc.getDstContext();
//				final DataAccessEnd src = dc.getSrc();
//				final DataAccessEnd dst = dc.getDst();
//				
//				if (compImpl == null) {
//					error(dc, "Couldn't get containing component implementation");
//				} else {
//					if (dc.getXRefines() == null) {
//						checkDataAccessConnectionEnd(dc, compImpl, "Source", srcContext, src);
//						checkDataAccessConnectionEnd(dc, compImpl, "Destination", dstContext, dst);
//					}
//				}
//				
//				// Fall through to caseConnection
//				return NOT_DONE;
//			}
//			
//			public Object caseBusAccessConnection(BusAccessConnection dc) {
//				final ComponentImpl compImpl = dc.getContainingComponentImpl();
//				final FeatureContext srcContext = dc.getSrcContext();
//				final FeatureContext dstContext = dc.getDstContext();
//				final BusAccessEnd src = dc.getSrc();
//				final BusAccessEnd dst = dc.getDst();
//				
//				if (compImpl == null) {
//					error(dc, "Couldn't get containing component implementation");
//				} else {
//					if (dc.getXRefines() == null) {
//						checkBusAccessConnectionEnd(dc, compImpl, "Source", srcContext, src);
//						checkBusAccessConnectionEnd(dc, compImpl, "Destination", dstContext, dst);
//					}
//				}
//				
//				// Fall through to caseConnection
//				return NOT_DONE;
//			}
//		};
//
//		featureSwitch = new FeatureSwitch() {
//			public Object casePortGroupType(final PortGroupType pgt) {
//				updateProgress(pgt);
//				// Check for loop in exenstion hierarchy
//				final StringBuffer sb = new StringBuffer();
//				final Classifier bad = testForExtensionLoop(pgt, sb);
//				if (bad != null) {
//					/* break the loop or else future checks will cause stack
//					 * overflow errors from inifinite looping
//					 */
//					bad.eUnset(bad.eClass().getEStructuralFeature("extend"));
//					// report error
//					error(pgt, "Port group type has loop in its ancestry: " + sb + ".  Loop has been broken to allow analysis to continue.");
//				}
//
//				// check for unique feature names in port group type
//				EList fl = pgt.getAllFeature();
//				EList<NamedElement> doubles = AadlUtil.findDoubleNamedElementsInList(fl);
//				if (doubles.size() > 0) {
//					for (NamedElement ne : doubles) {
//						error(ne, "feature identifier '" + ne.getName() +
//								"' previously defined in port group type '" +
//								pgt.getName() + "'");
//					}
//				}
//				monitor.worked(1);
//				return DONE;
//			}
//
//			public Object caseFeature(Feature feature) {
//				// check about name
////				if (feature.getName().equalsIgnoreCase("dispatch") || feature.getName().equalsIgnoreCase("error")
////						|| feature.getName().equalsIgnoreCase("complete")) {
////					error(feature, "feature uses the predeclared 'dispatch', 'complete', or 'error' name");
////				}
//				
//				// handle reference to refined feature
//				final Feature refines = 
//					(Feature) feature.eGet(feature.eClass().getEStructuralFeature("refines"));
//				if (refines != null) {
//					final Element parent = (Element) feature.eContainer();
//					final boolean inPortGroupType = parent instanceof PortGroupFeatures;
//
//					if (inPortGroupType) {
//						final PortGroupType pgt = (PortGroupType) parent.eContainer();
//						final PortGroupType supertype = pgt.getExtend();
//						if (supertype != null) {
//							final Feature shouldRefine = supertype.findFeature(feature.getName());
//							if (shouldRefine == null) {
//								error(feature, "Refined feature '" + feature.getName() + "' not found in super type");
//							} else if (shouldRefine != refines) {
//								error(feature, "Refined feature '" + feature.getName() + "' has an incorrect refinement reference");
//							} else {
//								if (!AadlUtil.sameEClass(refines, feature)) {
//									error(feature, "Refined subcomponent '" + feature.getName() + "' has incompatible type");
//								}
//							}
//						} else {
//							error(feature, "Feature '" + feature.getName() + "' cannot be refined: refinement only allowed in type extension");
//						}
//					} else {
//						final boolean inRefinesType = parent instanceof RefinesType;
//						ComponentType supertype = null;
//						if (inRefinesType) {
//							supertype = ((ComponentImpl) parent.eContainer()).getComponentType();
//						} else {
//							supertype = (ComponentType) ((ComponentType) parent.eContainer()).getXExtend();
//						}
//						if (supertype != null) {
//							final Feature shouldRefine = supertype.findFeature(feature.getName());
//							if (shouldRefine == null) {
//								error(feature, "Refined feature '" + feature.getName() + "' not found in super type");
//							} else if (shouldRefine != refines) {
//								error(feature, "Refined feature '" + feature.getName() + "' has an incorrect refinement reference");
//							} else {
//								if (!AadlUtil.sameEClass(refines, feature)) {
//									error(feature, "Refined subcomponent '" + feature.getName() + "' has incompatible type");
//								}
//							}
//						} else {
//							if (inRefinesType) {
//								error(parent, "Couldn't get containing component type for RefinesType object");
//							} else {
//								error(feature, "Feature '" + feature.getName() + "' cannot be refined: refinement only allowed in type extension");
//							}
//						}
//					}
//				}
//				return DONE;
//			}
//		};
//
//		componentSwitch = new ComponentSwitch() {
//			public Object caseSubprogramSubcomponent(SubprogramSubcomponent sub) {
//				// TODO the name resolver sets both
//				// getQualifiedName for Subcomponent assumes that the classifier is set
////				if (sub.getDataSubprogram() != null && 
////						sub.getClassifier() != null) {
////					error(sub, "Subprogram subcomponent '" + sub.getName() + "' has both the data subprogram and the classifier attributes set");
////				}
//				// Fall through to CoreSwitch.caseSubcomponent()
//				return NOT_DONE;
//			}
//		};
//
//		flowSwitch = new FlowSwitch() {
//			public Object caseModeMember(ModeMember object) {
//				return coreSwitch.caseModeMember(object);
//			}
//
//			public Object caseFlowSequence(FlowSequence seq) {
//				final EList flowElts = seq.getFlowElement();
//				final FlowSequence refines = seq.getRefines();
//				if (refines != null) {
//					if (seq instanceof FlowImpl){
//						error(seq,"Flow Implementations are not allowed to be refined");
//						return NOT_DONE;
//					}
//					ComponentImpl superimpl = (ComponentImpl) seq.getContainingComponentImpl().getXExtend();
//					if (superimpl != null) {
//						final EList shouldRefineList = superimpl.findFlowSequence(seq.getName());
//						if (shouldRefineList.isEmpty()) {
//							error(seq, "Refined flow sequence '" + seq.getName() + "' not found in super implementation");
//						} else {
//							final FlowSequence shouldRefine = (FlowSequence) shouldRefineList.get(0);
//							if (shouldRefine != refines) {
//								error(seq, "Refined flow sequence '" + seq.getName() + "' has an incorrect refinement reference");
//							} else {
//								if (!AadlUtil.sameEClass(refines, seq)) {
//									error(seq, "Refined subcomponent '" + seq.getName() + "' has incompatible type");
//								}
//							}
//						}
//					} else {
//						error(seq, "Flow sequence '" + seq.getName() + "' cannot be refined: refinement only allowed in implementation extension");
//					}
//					
//					if (flowElts != null && !flowElts.isEmpty()) {
//						error(seq, "Refined flow sequence cannot have flow elements");
//					}
//				}
//				// Falls through to caseModeMember()
//				return NOT_DONE;
//			}
//
//			public Object caseFlowImpl(FlowImpl fi) {
//				final ComponentImpl impl = fi.getContainingComponentImpl();
//				final FlowSpec shouldImpl = impl.getComponentType().findFlowSpec(fi.getName());
//				if (shouldImpl == null){
//					error(fi, "No flow specification with same name in " +
//							impl.getCategory().getReadableName() + " '" +
//							impl.getTypeName() + "'");
//				} else {
//					final FlowSpec doesImpl = 
//						(FlowSpec) fi.eGet(fi.eClass().getEStructuralFeature("implement"));
//					if (doesImpl == null) {
//						error(fi, "Flow implementation has null implementation reference");
//					} else {
//						if (shouldImpl != doesImpl) {
//							error(fi, "Flow implementation has incorrect implementation reference");
//						} else {
//							if (!AadlUtil.canImplement(fi, doesImpl)) {
//								error(fi, "Type mismatch between flow implementation and flow specification");
//							}
//						}
//					}
//				}		
//				// Falls through to caseFlowSequence
//				return NOT_DONE;
//			}
//
//			public Object caseFlowSpec(FlowSpec fs) {
//				final FlowSpec refines = fs.getRefines();
//				if (refines != null) {
//					ComponentType supertype = (ComponentType) ((ComponentType) fs.getContainingClassifier()).getXExtend();
//					if (supertype != null) {
//						final FlowSpec shouldRefine = supertype.findFlowSpec(fs.getName());
//						if (shouldRefine == null) {
//							error(fs, "Refined flow specification '" + fs.getName() + "' not found in super type");
//						} else if (shouldRefine != refines) {
//							error(fs, "Refined flow specification '" + fs.getName() + "' has an incorrect refinement reference");
//						} else {
//							if (!AadlUtil.sameEClass(refines, fs)) {
//								error(fs, "Refined flow specification '" + fs.getName() + "' has incompatible type");
//							}
//						}
//					} else {
//						error(fs, "Flow specfication '" + fs.getName() + "' cannot be refined: refinement only allowed in type extension");
//					}
//				} 
//				return DONE;
//			}
//
//			public Object caseFlowSourceSpec(FlowSourceSpec fss) {
//				final ComponentType type = (ComponentType) fss.getContainingClassifier();
//				final Feature dst = (Feature) fss.getDst();
//				final PortGroup dstCtxt = fss.getDstContext();
//				
//				if (!fss.isRefined()) {
//					checkFlowSpecEndPoint(fss, type, "Destination", dst, dstCtxt);
//				}
//				// Fall through to caseFlowSpec
//				return NOT_DONE;
//			}
//			
//			public Object caseFlowSinkSpec(FlowSinkSpec fss) {
//				final ComponentType type = (ComponentType) fss.getContainingClassifier();
//				final Feature src = (Feature) fss.getSrc();
//				final PortGroup srcCtxt = fss.getSrcContext();
//				
//				if (!fss.isRefined()) {
//					checkFlowSpecEndPoint(fss, type, "Source", src, srcCtxt);
//				}
//				// Fall through to caseFlowSpec
//				return NOT_DONE;
//			}
//			
//			public Object caseFlowPathSpec(FlowPathSpec fps) {
//				final ComponentType type = (ComponentType) fps.getContainingClassifier();
//				final Feature dst = (Feature) fps.getDst();
//				final PortGroup dstCtxt = fps.getDstContext();
//				final Feature src = (Feature) fps.getSrc();
//				final PortGroup srcCtxt = fps.getSrcContext();
//				
//				if (!fps.isRefined()) {
//					checkFlowSpecEndPoint(fps, type, "Source", src, srcCtxt);				
//					checkFlowSpecEndPoint(fps, type, "Destination", dst, dstCtxt);
//				}
//				// falls through to caseFlowSpec
//				return NOT_DONE;
//			}
//			
//			public Object caseFlowElement(FlowElement fe) {
//				final FlowSpec fs = fe.getFlowSpec();
//				final Subcomponent fc = fe.getFlowContext();
//				final Connection c = fe.getConnection();
//				final ComponentImpl impl = fe.getContainingComponentImpl();
//				
//				if (impl == null) {
//					error(fe, "Couldn't find containing component implementation");
//				} else {
//					if (c != null) {
//						if (fs != null || fc != null) {
//							error(fe, "Connection flow element has non-null flow spec or non-null subcomponent reference");
//						}
//					} else {
//						if (fs == null || fc == null) {
//							error(fe, "Flow spec flow element has null flow spec or null subcomponent reference");
//						}
//					}
//
//					// Make sure connection is from containing component impl
//					if (c != null) {
//						if (impl.findConnection(c.getName()) != c) {
//							error(fe, "Connection '" + c.getName() +
//									"' is not from the containing component implementation");
//						}
//					}
//					
//					// Make sure flow spec is from a subcomponent of the
//					// containing compoment impl
//					if (fc != null) {
//						final Subcomponent foundSub;
//						if (fc instanceof SubprogramSubcomponent) {
//							foundSub = impl.findSubprogram(fc.getName());
//						} else {
//							foundSub = impl.findSubcomponent(fc.getName());
//						}
//						if (foundSub != fc) {
//							error(fe, "Subcomponent '" + fc.getName() +
//									"' is not from the containing component implementation");
//						} else {
//							final ComponentType ctype = fc.getComponentType();
//							if (ctype.findFlowSpec(fs.getName()) != fs) {
//								error(fe, "Flow spec '" + fs.getName() +
//										"' is not from the component type of subcomponent '" +
//										fc.getName() + "'");
//							}
//						}
//					}
//				}
//				
//				return DONE;
//			}
//		};
//
//		propertySwitch = new PropertySwitch() {
//			public Object caseModeMember(ModeMember object) {
//				return coreSwitch.caseModeMember(object);
//			}
//
//			public Object caseEnumValue(EnumValue ev) {
//				final EnumLiteral el = ev.getEnumLiteral();
//				if (el == null) {
//					error(ev, "Enum value has a null enum literal reference");
//				} else {
//					// Get the type that constrains the domain of literals
//					EObject obj = ev.eContainer();
//					PropertyType type = null;
//					if (obj instanceof PropertyAssociation) {
//						obj = ((PropertyAssociation) obj).getPropertyDefinition();
//					}
//					if (obj instanceof PropertyDefinition) {
//						type = ((PropertyDefinition) obj).getThePropertyType();
//					} else if (obj instanceof PropertyConstant) {
//						type = ((PropertyConstant) obj).getThePropertyType();
//					}
//					if (type == null) {
//						error(ev, "Couldn't get property type for enumeration");
//					} else {
//						if (type instanceof EnumType) {
//							final EnumType etype = (EnumType) type;
//							if (!etype.getEnumLiteral().contains(el)) {
//								error(ev, "Enum literal '" + el.getName() +
//										"' is not a member of enum type '" +
//										etype.getName() + "'");
//							}
//						} else {
//							error(ev, "Constraining property type is not an enum type");
//						}
//					}
//				}
//				return DONE;
//			}
//
//			public Object caseNumberValue(NumberValue nv) {
//				final UnitLiteral ul = nv.getUnitLiteral();
//				if (ul != null) {
//					UnitsType ut = null;
//					EObject nvContainer = nv.eContainer();
//					PropertyType propType = null;
//					NumberType numType = null; 
//
//					if (nvContainer instanceof RangeValue) {
//						nvContainer = nvContainer.eContainer();
//					}
//					String objName = "";
//					if (nvContainer instanceof PropertyAssociation) {
//						propType = ((PropertyAssociation) nvContainer).getPropertyDefinition().getThePropertyType();
//						objName = ((PropertyAssociation) nvContainer).getPropertyDefinition().getName();
//					} else if (nvContainer instanceof PropertyDefinition) {
//						propType = ((PropertyDefinition) nvContainer).getThePropertyType();
//						objName = ((PropertyDefinition) nvContainer).getName();
//					} else if (nvContainer instanceof PropertyConstant) {
//						propType = ((PropertyConstant) nvContainer).getThePropertyType();
//						objName = ((PropertyConstant) nvContainer).getName();
//					} else if (nvContainer instanceof NumberType) {
//						/* Number is the lower/upper bound of a number type,
//						 * the container is the relevant property type.
//						 */
//						propType = (PropertyType) nvContainer;
//					} else if (nvContainer instanceof UnitLiteral) {
//						/* Number is part of a unit literal. Cannot have a
//						 * unit of it's own. Return.
//						 */
//						return DONE;
//					} else {
//						error(nv, "Number value encountered in unexpected container: "
//								+ nvContainer.getClass().getName());
//					}
//					if (propType instanceof RangeType) {
//						numType = ((RangeType) propType).getTheNumberType();
//					} else {
//						numType = (NumberType) propType;
//					}
//					if (numType == null){
//						
//						error(nv, "Property type for '" + objName +
//								"' is null");
//						return DONE;
//					}
//					ut = numType.getTheUnitsType();
//					if (ut == null || !ut.getUnitLiteral().contains(ul)) {
//						error(nv, "Unit literal '" + ul.getName() +
//								"' not allowed for number type '" +
//								numType.getName() + "'");
//					}
//				}
//				return DONE;
//			}
//
//			public Object caseIntegerValue(final IntegerValue intVal) {
//				final int base = intVal.getBase();
//				final long value = intVal.getValue();
//				final String valString = intVal.getValueString();
//				
//				if (valString == null) {
//					error(intVal, "Integer value has null value string");					
//				} else {
//					try {
//						final long[] baseValuePair = AadlParseUtil.parseAadlInteger(valString);
//						final int parsedBase = (int) baseValuePair[0];
//						final long parsedValue = baseValuePair[1];
//						if (base != parsedBase) {
//							error(intVal,
//									"Integer value base, " + base +
//									", does not match base in value string, " +
//									parsedBase);
//						}
//						if (value != parsedValue) {
//							error(intVal,
//									"Integer value, " + value +
//									", does not match value in value string, " +
//									parsedValue);
//						}
//					} catch(final IllegalArgumentException e) {
//						error(intVal, 
//								"Couldn't parse value string: " + e.getMessage());
//					}
//					
//				}
//				// Fall through to caseNumberValue
//				return NOT_DONE;
//			}
//			
//			public Object caseRealValue(final RealValue realVal) {
//				final double value = realVal.getValue();
//				final String valString = realVal.getValueString();
//				
//				if (valString == null) {
//					error(realVal, "Real value has null value string");
//				} else {
//					try {
//						final double parsedValue = AadlParseUtil.parseAadlReal(valString);
//						if (value != parsedValue) {
//							error(realVal, 
//									"Real value, " + value +
//									", does not match value in value string, " +
//									parsedValue);
//						}
//					} catch(final IllegalArgumentException e) {
//						error(realVal,
//								"Couldn't parse value string: " + e.getMessage());
//					}
//				}
//				// Fall through to caseNumberValue
//				return NOT_DONE;
//			}
//			
//			public Object casePropertyAssociation(PropertyAssociation pa) {
//				if (pa.getPropertyDefinition() == null) {
//					error(pa, "Property definition reference is null");
//				}
//
//				final EList appliesToPath = pa.getComponentPath();
//				if (appliesToPath != null && !appliesToPath.isEmpty()) {
//					final EObject twoup = pa.eContainer().eContainer();
//					if (!(twoup instanceof Subcomponent) &&
//							!(twoup instanceof ComponentImpl)) {
//						error(pa, "Contained property association allowed in subcomponents or component implementations only");
//					} else {
//						ComponentImpl impl;
//						Subcomponent subcomp = null;
//						if (twoup instanceof Subcomponent) {
//							subcomp = (Subcomponent) twoup;
//							impl = subcomp.getComponentImpl();
//						} else {
//							impl = (ComponentImpl) twoup;
//						}
//						if (subcomp != null && impl == null) {
//							error(subcomp, 
//									"Subcomponent '" + subcomp.getName()
//									+ "' with contained property association has no implementation");
//						}
//					}
//				}
//
//				// in binding references
//				final EList inBindings = pa.getInBinding();
//				if (inBindings != null && !inBindings.isEmpty()) {
//					int index = 0;
//					for (final Iterator bindings = inBindings.iterator(); bindings.hasNext();) {
//						final ComponentClassifier cc = (ComponentClassifier) bindings.next();
//						if (!(cc instanceof ProcessorClassifier)
//								&& !(cc instanceof MemoryClassifier)
//								&& !(cc instanceof BusClassifier)) {
//							error(pa, "In binding " + index + ", '" + 
//									cc.getName() + "', is not a memory, processor, or bus classifier");
//						}
//					}
//					
//					if (pa.eContainer() instanceof ComponentClassifier) {
//						error(pa, "In binding allowed in component classifiers only");
//					}
//				}
//				/* Fall through to caseModeMember, but only if the association
//				 * is inside a component implementation.
//				 */ 
//				return (pa.getContainingComponentImpl() == null) ? DONE : NOT_DONE;
//			}
//
//			public Object casePropertyDefinition(PropertyDefinition pd) {
//				final PropertyType pt = pd.getPropertyType();
//				final PropertyType refPt = pd.getPropertyTypeReference();
//				
//				if (pt == null && refPt == null) {
//					error(pd, "Property definition has null property type and property type reference; one must be non-null");
//				}
//				if (pt != null && refPt != null) {
//					error(pd, "Property definition has non-null propety type and property type reference; one must be null");
//				}
//				return DONE;
//			}
//
//			public Object caseRangeType(RangeType rt) {
//				final NumberType nt = rt.getNumberType();
//				final NumberType refNT = rt.getNumberTypeReference();
//				
//				if (nt == null && refNT == null) {
//					error(rt, "Range type has null number type and number type reference; one must be non-null");
//				}
//				if (nt != null && refNT != null) {
//					error(rt, "Range type has non-null number type and number type reference; one must be null");
//				}
//				return DONE;
//			}
//
//			public Object casePropertyConstant(PropertyConstant pc) {
//				final PropertyConstantType type = pc.getPropertyType();
//				final PropertyConstantType typeRef = pc.getPropertyTypeReference();
//				
//				if (type == null && typeRef == null) {
//					error(pc, "Property constant has null property type and property type reference; one must be non-null");
//				}
//				if (type != null && typeRef != null) {
//					error(pc, "Property constant has non-null property type and property type reference; one must be null");
//				}
//				return DONE;
//			}
//
//			public Object caseUnitsType(UnitsType ut) {
//				final EList units = ut.getUnitLiteral();
//				if (units == null || units.isEmpty()) {
//					error(ut, "Units type must have unit literals");
//				} else {
//					UnitLiteral prev = null;
//					for (final Iterator iter = units.iterator(); iter.hasNext();) {
//						final UnitLiteral ul = (UnitLiteral) iter.next();
//						final UnitLiteral base = ul.getBaseunit();
//						if (prev == null) {
//							if (base != null) {
//								error(ut, "First unit has reference to a base unit; must be null");
//							}
//						} else {
//							if (base != prev) {
//								error(ut, "Unit literal '" + ul.getName() + "' does not refer to its immediately preceeding unit literal");
//							}
//						}
//						prev = ul;
//					}
//				}
//				return DONE;
//			}
//			
//			public Object caseNumberType(NumberType nt) {
//				final UnitsType type = nt.getPropertyType();
//				final UnitsType typeRef = nt.getPropertyTypeReference();
//				
//				if (type != null && typeRef != null) {
//					error(nt, "Number type has non-null property type and property type reference; one must be null");
//				}
//				
//				final NumberOrPropertyReference upper = nt.getUpper();
//				final NumberOrPropertyReference lower = nt.getLower();
//				if (upper != null && lower == null) {
//					error(nt, "Number type has upper bound but no lower bound");
//				} 
//				if (upper == null && lower != null) {
//					error(nt, "Number type has lower bound but no upper bound");
//				}
//				return DONE;
//			}
//
//			public Object caseReferenceValue(ReferenceValue rv) {
//				final EList elts = rv.getReferenceElement();
//				if (elts == null || elts.isEmpty()) {
//					error(rv, "Reference value has null reference element list");
//				} else {
//					if (!(elts.get(0) instanceof Subcomponent)) {
//						error(rv, "First reference element is not a subcomponent");
//					} else {
//						ComponentImpl impl;
//						ComponentImpl contimpl = rv.getContainingComponentImpl();
//						Subcomponent sc = rv.getContainingSubcomponent();
//						impl = (sc == null) ? contimpl : sc.getComponentImpl();
//						for (Iterator iter = elts.iterator(); iter.hasNext();) {
//							final ReferenceElement refElt = (ReferenceElement) iter.next();
//							if (impl != null) {
//								if (refElt instanceof Subcomponent) {
//									final Subcomponent sub = (Subcomponent) refElt;
//									final String name = sub.getName();
//									if (impl.findSubcomponent(name) != refElt) {
//										error(rv, "Couldn't find reference element '" +
//												name + "'");
//										break;
//									}
//									impl = sub.getComponentImpl();
//								} else if (refElt instanceof Connection) {
//									final Connection conn = (Connection) refElt;
//									final String name = conn.getName();
//									if (iter.hasNext()) {
//										error(rv, "Reference element '" +
//												name + "' must be last because it is a connection");
//										break;
//									}
//									if (impl.findConnection(name) != refElt) {
//										error(rv, "Couldn't find reference element '" +
//												name + "'");
//										break;
//									}
//								} else if (refElt instanceof ServerSubprogram) {
//									final ServerSubprogram ss = (ServerSubprogram) refElt;
//									final String name = ss.getName();
//									if (iter.hasNext()) {
//										error(rv, "Reference element '" +
//												name + "' must be last because it is a server subprogram");
//										break;
//									}
//									final ComponentType type = impl.getComponentType();
//									if (type.findFeature(name) != refElt) {
//										error(rv, "Couldn't find reference element '" +
//												name + "'");
//										break;
//									}
//								}
//							} else {
//								if (!(refElt instanceof ServerSubprogram)) {
//									error(rv, "Couldn't find reference element because component implementation is null");
//								}
//								break;
//							}
//						}
//					}
//				}
//				return DONE;
//			}
//			
//			public Object caseClassifierValue(ClassifierValue cv) {
//				if (cv.getComponentClassifier() == null) {
//					// it can have just a category
////					error(cv, "Component classifier reference is null");
//				}
//				if (cv.getValue() == null){
//					error(cv, "Component classifier is missing a component category");
//				}
//				return DONE;
//			}
//
//			public Object casePropertyReference(PropertyReference pr) {
//				final ReferencedProperty rp = pr.getReferencedProperty();
//				if (rp == null) {
//					error(pr, "Referenced property reference is null");
//				} else {
//					final String sign = pr.getReferenceSign();
//
//					if (rp instanceof PropertyDefinition) {
//						// (1) reject signed property references
//						if (sign != null) {
//							error(pr, "Property references cannot be signed");
//						}
//
//						/* (2) property ref only allowed at top of a
//						 * property_expression or inside a BooleanExpression
//						 */
//						final EObject container = pr.eContainer();
//						if (!(container instanceof PropertyAssociation) && !(container instanceof PropertyDefinition)
//								&& !(container instanceof BooleanValue)) {
//							error(pr, "Property references only allowed at top-level of property expression");
//						}
//					} else if (rp instanceof PropertyConstant) {
//						final PropertyConstant pc = (PropertyConstant) rp;
//						final boolean isList = pc.isList();
//						if (sign != null) {
//							// check that constant is not a list
//							if (isList) {
//								error(pr, "References to list constants cannot be signed");
//							} else {
//								// check that type is aadlreal or aadlinteger
//								final PropertyType pt = pc.getThePropertyType();
//								if (!(pt instanceof Aadlinteger) && !(pt instanceof Aadlreal)) {
//									error(pr, "References to non-numeric constants cannot be signed");
//								}
//							}
//						}
//					} else {
//						error(pr, "Unknown subclass of ReferencedProperty: " + rp.getClass().getName());
//					}
//				}
//				return DONE;
//			}
//		};
//	}
//
//	private void checkPortConnectionEnd(
//			final Connection conn, final ComponentImpl compImpl,
//			final String typeLabel, final String label,
//			final FeatureContext context, final AbstractPort port) {
//		// switch on the class of the context
//		if (context == null) {
//			error(conn, label + " context is null");
//		} else if (context instanceof ComponentImpl) {
//			// context better point to the containing component
//			if (context != compImpl) {
//				error(conn, label + " context is a component implementation but doesn't refer to the containing component");
//			} else {
//				if (port == null) {
//					error(conn, label + " is null");
//				} else {
//					final String portName = port.getName();
//					Feature f = compImpl.findRefinedFeature(portName);
//					if (f == null) f = compImpl.getComponentType().findFeature(portName);
//					if (f != port) {
//						error(conn, typeLabel + " '" + portName + "' not found in component");
//					}
//				}
//			}
//		} else if (context instanceof PortGroup) {
//			final PortGroup pg = (PortGroup) context;
//			final String pgName = pg.getName();
//			Feature pgFeature = compImpl.findRefinedFeature(pgName);
//			if (pgFeature == null) pgFeature = compImpl.getComponentType().findFeature(pgName);
//			if (pgFeature != pg) {
//				error(conn, label + " context, port group '" + 
//						pgName + "' not found in containing component");
//			} else {
//				if (port == null) {
//					error(conn, label + " is null");
//				} else {
//					final String portName = port.getName();
//					Feature f = pg.findFeature(portName);
//					if (f != port) {
//						error(conn, typeLabel + " '" + portName +
//								"' not found in " + label +
//								" context, port group '" + pgName + "'");
//					}
//				}
//			}
//		} else if (context instanceof SubprogramSubcomponent) {
//			// Must check for this *before* subcomponent
//			final SubprogramSubcomponent sub = (SubprogramSubcomponent) context;
//			final String subName = sub.getName();
//			final Subcomponent sub2 = compImpl.findSubprogram(subName);
//			if (sub2 != sub) {
//				error(conn, label + " context, subprogram '" +
//						subName + "' not found in containing component");
//			} else {
//				if (port == null) {
//					error(conn, label + " is null");
//				} else {
//					final ComponentType type = sub.getComponentType();
//					if (type == null) {
//						error(conn, "Couldn't get component type of subprogram '" + subName + "'");
//					} else {
//						final String portName = port.getName();
//						Feature f = type.findFeature(portName);
//						if (f != port) {
//							error(conn, typeLabel + " '" + portName +
//									"' not found in " + label + 
//									" context, subprogram '" + subName + "'");
//						}
//					}
//				}
//			}
//		} else if (context instanceof Subcomponent) {
//			final Subcomponent sub = (Subcomponent) context;
//			final String subName = sub.getName();
//			final Subcomponent sub2 = compImpl.findSubcomponent(subName);
//			if (sub2 != sub) {
//				error(conn, label + " context, subcomponent '" +
//						subName + "' not found in containing component");
//			} else {
//				if (port == null) {
//					error(conn, label + " is null");
//				} else {
//					final ComponentType type = sub.getComponentType();
//					if (type == null) {
//						error(conn, "Couldn't get component type of subcomponent '" + subName + "'");
//					} else {
//						final String portName = port.getName();
//						Feature f = null;
//						ComponentImpl impl = sub.getComponentImpl();
//						if (impl != null && impl.getRefinesType() != null)
//							f = impl.findRefinedFeature(portName);
//						if (f == null)
//							f = type.findFeature(portName);
//						if (f != port) {
//							error(conn, typeLabel + " '" + portName +
//									"' not found in " + label + 
//									" context, subcomponent '" + subName + "'");
//						}
//					}
//				}
//			}
//		}
//	}
//
//	private void checkParameterConnectionEnd(
//			final Connection conn, final ComponentImpl compImpl,
//			final String label, final FeatureContext context,
//			final ParameterEnd port) {
//		// switch on the class of the context
//		if (context == null) {
//			error(conn, label + " context is null");
//		} else if (context instanceof ComponentImpl) {
//			// context better point to the containing component
//			if (context != compImpl) {
//				error(conn, label + " context is a component implementation but doesn't refer to the containing component");
//			} else {
//				if (port == null) {
//					error(conn, label + " is null");
//				} else {
//					final String portName = port.getName();
//					Feature f = compImpl.findRefinedFeature(portName);
//					if (f == null) f = compImpl.getComponentType().findFeature(portName);
//					if (f != port) {
//						error(conn, "Parameter end '" + portName + "' not found in component");
//					}
//				}
//			}
//		} else if (context instanceof PortGroup) {
//			final PortGroup pg = (PortGroup) context;
//			final String pgName = pg.getName();
//			Feature pgFeature = compImpl.findRefinedFeature(pgName);
//			if (pgFeature == null) pgFeature = compImpl.getComponentType().findFeature(pgName);
//			if (pgFeature != pg) {
//				error(conn, label + " context, port group '" + 
//						pgName + "' not found in containing component");
//			} else {
//				if (port == null) {
//					error(conn, label + " is null");
//				} else if (port instanceof Parameter) {
//					error(conn, label + " parameter end is not allowed to be a parameter feature when the context is a port group");
//				} else {
//					final String portName = port.getName();
//					Feature f = pg.findFeature(portName);
//					if (f != port) {
//						error(conn, "Port '" + portName +
//								"' not found in " + label +
//								" context, port group '" + pgName + "'");
//					}
//				}
//			}
//		} else if (context instanceof SubprogramSubcomponent) {
//			// Must check for this *before* subcomponent
//			final SubprogramSubcomponent sub = (SubprogramSubcomponent) context;
//			final String subName = sub.getName();
//			final Subcomponent sub2 = compImpl.findSubprogram(subName);
//			if (sub2 != sub) {
//				error(conn, label + " context, subprogram '" +
//						subName + "' not found in containing component");
//			} else {
//				if (port == null) {
//					error(conn, label + " is null");
//				} else if (!(port instanceof Parameter)) {
//					error(conn, label + " parameter end must be a parameter feature when the context is a subprogram");
//				} else {
//					final ComponentType type = sub.getComponentType();
//					if (type == null) {
//						error(conn, "Couldn't get component type of subprogram '" + subName + "'");
//					} else {
//						final String portName = port.getName();
//						Feature f = type.findFeature(portName);
//						if (f != port) {
//							error(conn, "Data port '" + portName +
//									"' not found in " + label + 
//									" context, subprogram '" + subName + "'");
//						}
//					}
//				}
//			}
//		} else if (context instanceof Subcomponent) {
//			error(conn, "Non-subprogram subcomponents not allowed as " +
//					label + " contexts in parameter connections");
//		}
//	}
//	
//	private void checkDataAccessConnectionEnd(
//			final Connection conn, final ComponentImpl compImpl,
//			final String label,	final FeatureContext context,
//			final DataAccessEnd end) {
//		// switch on the class of the context
//		if (context == null) {
//			if (end == null) {
//				error(conn, label + " is null");
//			} else {
//				if (!(end instanceof DataSubcomponent)) {
//					error(conn, label + " must be a data subcomponent when the context is null");
//				} else {
//					final String endName = end.getName();
//					Subcomponent sub = compImpl.findSubcomponent(endName);
//					if (sub != end) {
//						error(conn, "Data subcomponent '" + endName + "' not found in component");
//					}
//				}
//			}
//		} else if (context instanceof ComponentImpl) {
//			// context better point to the containing component
//			if (context != compImpl) {
//				error(conn, label + " context is a component implementation but doesn't refer to the containing component");
//			} else {
//				if (end == null) {
//					error(conn, label + " is null");
//				} else if (!(end instanceof DataAccess)) {
//					error(conn, label + " must be a data access feature when the context is the containing component");
//				} else {
//					final String endName = end.getName();
//					DataAccess f = (DataAccess) compImpl.findRefinedFeature(endName);
//					if (f == null) f = (DataAccess) compImpl.getComponentType().findFeature(endName);
//					if (f != end) {
//						error(conn, "Data access '" + endName + "' not found in component");
//					}
//				}
//			}
//		} else if (context instanceof PortGroup) {
//			error(conn, label + " context is not allowed to be a port group");
//		} else if (context instanceof SubprogramSubcomponent) {
//			// Must check for this *before* subcomponent
//			final SubprogramSubcomponent sub = (SubprogramSubcomponent) context;
//			final String subName = sub.getName();
//			final Subcomponent sub2 = compImpl.findSubprogram(subName);
//			if (sub2 != sub) {
//				error(conn, label + " context, subprogram '" +
//						subName + "' not found in containing component");
//			} else {
//				if (end == null) {
//					error(conn, label + " is null");
//				} else if (!(end instanceof DataAccess)) {
//					error(conn, label + " must be a data access feature when the context is a subprogram");
//				} else {
//					final ComponentType type = sub.getComponentType();
//					if (type == null) {
//						error(conn, "Couldn't get component type of subprogram '" + subName + "'");
//					} else {
//						final String endName = end.getName();
//						Feature f = type.findFeature(endName);
//						if (f != end) {
//							error(conn, "Data access '" + endName +
//									"' not found in " + label + 
//									" context, subprogram '" + subName + "'");
//						}
//					}
//				}
//			}
//		} else if (context instanceof Subcomponent) {
//			final Subcomponent sub = (Subcomponent) context;
//			final String subName = sub.getName();
//			final Subcomponent sub2 = compImpl.findSubcomponent(subName);
//			if (sub2 != sub) {
//				error(conn, label + " context, subcomponent '" +
//						subName + "' not found in containing component");
//			} else {
//				if (end == null) {
//					error(conn, label + " is null");
//				} else if (end instanceof DataSubcomponent) {
//					/* Special case, context really should be null,
//					 * but name resolver produces models in this case
//					 * where the context and the end are equal.  First check
//					 * that the end is the correct thing.  If it is, we 
//					 * issue a warning.
//					 */
//					if (end != sub) {
//						error(conn, label + " must equal the context when both refer to a subcomponent");
//					} else {
//	//					warning(conn, "Context should be null when " + label + " refers to a data subcomponent");
//					}
//				} else { // end instanceof DataAccess
//					final ComponentType type = sub.getComponentType();
//					if (type == null) {
//						error(conn, "Couldn't get component type of subcomponent '" + subName + "'");
//					} else {
//						final String endName = end.getName();
//						Feature f = type.findFeature(endName);
//						if (f != end) {
//							error(conn, "Data access '" + endName +
//									"' not found in " + label + 
//									" context, subcomponent '" + subName + "'");
//						}
//					}
//				}
//			}
//		}
//	}
//	
//	private void checkBusAccessConnectionEnd(
//			final Connection conn, final ComponentImpl compImpl,
//			final String label,	final FeatureContext context,
//			final BusAccessEnd end) {
//		// switch on the class of the context
//		if (context == null) {
//			if (end == null) {
//				error(conn, label + " is null");
//			} else {
//				if (!(end instanceof BusSubcomponent)) {
//					error(conn, label + " must be a bus subcomponent when the context is null");
//				} else {
//					final String endName = end.getName();
//					Subcomponent sub = compImpl.findSubcomponent(endName);
//					if (sub != end) {
//						error(conn, "Bus subcomponent '" + endName + "' not found in component");
//					}
//				}
//			}
//		} else if (context instanceof ComponentImpl) {
//			// context better point to the containing component
//			if (context != compImpl) {
//				error(conn, label + " context is a component implementation but doesn't refer to the containing component");
//			} else {
//				if (end == null) {
//					error(conn, label + " is null");
//				} else if (!(end instanceof BusAccess)) {
//					error(conn, label + " must be a bus access feature when the context is the containing component");
//				} else {
//					final String endName = end.getName();
//					BusAccess f = (BusAccess) compImpl.findRefinedFeature(endName);
//					if (f == null) f = (BusAccess) compImpl.getComponentType().findFeature(endName);
//					if (f != end) {
//						error(conn, "Bus access '" + endName + "' not found in component");
//					}
//				}
//			}
//		} else if (context instanceof PortGroup) {
//			error(conn, label + " context is not allowed to be a port group");
//		} else if (context instanceof Subcomponent) {
//			final Subcomponent sub = (Subcomponent) context;
//			final String subName = sub.getName();
//			final Subcomponent sub2 = compImpl.findSubcomponent(subName);
//			if (sub2 != sub) {
//				error(conn, label + " context, subcomponent '" +
//						subName + "' not found in containing component");
//			} else {
//				if (end == null) {
//					error(conn, label + " is null");
//				} else if (end instanceof BusSubcomponent) {
//					/* Special case, context really should be null,
//					 * but name resolver produces models in this case
//					 * where the context and the end are equal.  First check
//					 * that the end is the correct thing.  If it is, we 
//					 * issue a warning.
//					 */
//					if (end != sub) {
//						error(conn, label + " must equal the context when both refer to a subcomponent");
//					} else {
//	//					warning(conn, "Context should be null when " + label + " refers to a bus subcomponent");
//					}
//				} else { // end instanceof BusAccess
//					final ComponentImpl impl = sub.getComponentImpl();
//					final ComponentType type = sub.getComponentType();
//					if (type == null) {
//						error(conn, "Couldn't get component type of subcomponent '" + subName + "'");
//					} else {
//						final String endName = end.getName();
//						Feature f = null;
//						if (impl != null)
//							f = impl.findRefinedFeature(endName);
//						if (f == null)
//							f = type.findFeature(endName);
//						if (f != end) {
//							error(conn, "Bus access '" + endName +
//									"' not found in " + label + 
//									" context, subcomponent '" + subName + "'");
//						}
//					}
//				}
//			}
//		}
//	}
//
//	private void checkFlowSpecEndPoint(
//			final FlowSpec fs, final ComponentType type,
//			final String label,	final Feature port, final PortGroup ctxt) {
//		if (port == null) {
//			error(fs, label + " reference is null");
//		} else {
//			if (ctxt == null) {
//				final Feature f = type.findFeature(port.getName());
//				if (f != port) { // f could be null
//					error(fs, label + " flow point '" + 
//							port.getName() + "' not found in containing classifier");
//				}
//			} else {
//				final Feature pg = type.findFeature(ctxt.getName());
//				if (pg != ctxt) { // pg could be null
//					error(fs, label + " flow context '" + 
//							ctxt.getName() + "' not found in containing classifier");
//				} else {
//					final Feature f = ctxt.findFeature(port.getName());
//					if (f != port) { // f could be null
//						error(fs, label + " flow point '" +
//								port.getName() + 
//								"' not found in flow context '" +
//								ctxt.getName());
//					}
//				}
//			}
//		}
//	}
}

