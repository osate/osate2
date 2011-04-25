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



/*
 * XXX: Commented out entire class to remove error markers.  Not currently used in Aadl 2 beta.
 * Need to check if this should be used after implementing the Xtext parser.
 */
public class AadlUniqueNamesSwitch /*extends AadlProcessingSwitch */{
//	public AadlUniqueNamesSwitch(final AnalysisErrorReporterManager manager) {
//		super(PROCESS_PRE_ORDER_ALL, manager);
//	}
//
//	protected final void initSwitches() {
//		propertySwitch = new PropertySwitch() {
//			public Object caseUnitsType(final UnitsType ut) {
//				final Set seen = new HashSet();
//				final EList literals = ut.getUnitLiteral();
//				for (final Iterator i = literals.iterator(); i.hasNext();) {
//					final UnitLiteral lit = (UnitLiteral) i.next();
//					final String name = lit.getName();
//					if (seen.contains(name)) {
//						error(lit, "Unit '" + name + "' previously declared in units type");
//					} else {
//						seen.add(name);
//					}
//				}
//				return DONE;
//			}
//			
//			public Object caseEnumType(final EnumType et) {
//				final Set seen = new HashSet();
//				final EList literals = et.getEnumLiteral();
//				for (final Iterator i = literals.iterator(); i.hasNext();) {
//					final EnumLiteral lit = (EnumLiteral) i.next();
//					final String name = lit.getName();
//					if (seen.contains(name)) {
//						error(lit, "Literal '" + name + "' previously declared in enumeration");
//					} else {
//						seen.add(name);
//					}
//				}
//				return DONE;
//			}
//		};
//		
//		aadl2Switch = new Aadl2Switch() {
//			/**
//			 * check for unique feature names and flow spec names
//			 */
//			public Object caseComponentType(ComponentType type) {
//				// process in core package
//				EList l = new BasicEList();
//				l.addAll(type.getAllFlowSpec());
//				l.addAll(type.allFeatures());
//				EList<NamedElement> doubles = AadlUtil.findDoubleNamedElementsInList(l);
//				if (doubles.size() > 0) {
//					for (NamedElement ne : doubles) {
//						error(ne,
//								(ne instanceof Feature ? "feature " : "flow spec ") + 
//								" identifier '" + ne.getName() + "' previously defined");
//					}
//				}
//				return DONE;
//			}
//
//			/**
//			 * check for unique feature names and flow spec names
//			 */
//			public Object caseComponentImplementation(ComponentImplementation impl) {
//				// process in core package
//				EList usedNames = new BasicEList();
//				usedNames.addAll(impl.allFeatures());
//				usedNames.addAll(impl.getSubcomponents());
//				usedNames.addAll(impl.getAllConnection());
//				usedNames.addAll(impl.getModes());
//				usedNames.addAll(impl.getType().getAllFlowSpec());
//
//				EList allFlowSeqs = impl.getAllFlowSequence();
//				for (final Iterator i = allFlowSeqs.iterator(); i.hasNext();) {
//					final FlowSequence fs = (FlowSequence) i.next();
//					// Filter out flow impls
//					if (fs instanceof EndToEndFlow) {
//						usedNames.add(fs);
//					}
//				}
//				
//				EList callSequenceList = impl.getXAllCallSequence();
//				usedNames.addAll(callSequenceList);
//				
//				// add all the calls from the call sequences
//				for (Iterator callIter = callSequenceList.iterator(); callIter.hasNext();){
//					CallSequence cseq = (CallSequence) callIter.next();
//					usedNames.addAll(cseq.getCall());
//				}
//				
//				EList<NamedElement> doubles = AadlUtil.findDoubleNamedElementsInList(usedNames);
//				boolean noRefinesType = impl.getRefinesType() == null;
//				if (doubles.size() > 0) {
//					for (NamedElement ne : doubles) {
//						if (!((noRefinesType && ne instanceof Feature) ))
//							error(impl, "Identifier '" + ne.getName() + "' names more than one subcomponent/connection/flow/feature/mode in component " + impl.getQualifiedName());
//					}
//				}
//
//				// Check that no flow spec impl appears in a mode more than once
//				EList localFlowSeqs = impl.getFlowSequence(); 
//				final Map map = new HashMap();
//				for (final Iterator i = localFlowSeqs.iterator(); i.hasNext();) {
//					final FlowSequence fs = (FlowSequence) i.next();
//					// Filter out end-to-end flows -- they do not implement a
//					// flow spec
//					if (fs instanceof FlowImpl) {
//						final String name = fs.getName();
//						EList s = (EList) map.get(name);
//						if (s == null) {
//							s = new BasicEList();
//							map.put(name, s);
//						}
//						s.add(fs);
//					}
//				}
//				for (Iterator i = map.keySet().iterator(); i.hasNext();) {
//					final String name = (String) i.next();
//					final EList s = (EList) map.get(name);
//					if (!AadlUtil.oncePerMode(s, impl.getModes())) {
//						error(impl, "Flow spec " + name + " implemented more than once for a given mode");
//					}
//				}
//
//				/* Check that no end to end flow appears in a mode more than once
//				 * and that its name isn't already used.
//				 */
////				map.clear();
////				EList allFlowSeqs = impl.getAllFlowSequence();
////				for (final Iterator i = allFlowSeqs.iterator(); i.hasNext();) {
////					final FlowSequence fs = (FlowSequence) i.next();
////					// Filter out flow impls
////					if (fs instanceof EndToEndFlow) {
////						final String name = fs.getName();
////						if (AadlUtil.findNamedElementInList(usedNames, name) != null) {
////							error(impl, "'" + name + "': identifier previously defined in component");
////						}
////						EList s = (EList) map.get(name);
////						if (s == null) {
////							s = new BasicEList();
////							map.put(name, s);
////						}
////						s.add(fs);
////					}
////				}
////				for (Iterator i = map.keySet().iterator(); i.hasNext();) {
////					final String name = (String) i.next();
////					final EList s = (EList) map.get(name);
////					if (!AadlUtil.oncePerMode(s, impl.getAllMode())) {
////						error(impl, "End to End Flow " + name + " implemented more than once for a given mode");
////					}
////				}
//
//				
//				return DONE;
//			}
//		};
//
//	}
}