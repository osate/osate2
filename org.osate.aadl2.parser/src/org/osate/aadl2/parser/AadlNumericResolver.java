/*
 * Created on Jan 30, 2004
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
 * $Id: AadlNumericResolver.java,v 1.39 2010-04-02 17:48:09 jseibel Exp $
 */
package org.osate.aadl2.parser;

/**
 * Checks numeric literals for validity and also resolves them from Strings to
 * java objects. Necessary because the lexer uses a single rule for both real
 * and integer literals (problems with look ahead). Also, there are additional
 * properties that cannot be directly enforced by the lexer, for example, the
 * base must be between 2 and 16, and the range of the extended digits must
 * conform to the base.
 * 
 * <p>Needs to be run <em>after</em> the aadl name resolvers 
 * because it assumes reference
 * to property constant values have already been resolved.
 * 
 * @author aarong
 */
/*
 * XXX: Commented out entire class to remove error markers.  Not currently used in Aadl 2 beta.
 * Need to check if this should be used after implementing the Xtext parser.
 */
public final class AadlNumericResolver /*extends AadlProcessingSwitch */{
//	public AadlNumericResolver(final AnalysisErrorReporterManager manager) {
//		super(PROCESS_PRE_ORDER_ALL, manager);
//	}
//	
//	
//	protected void initSwitches() {
//		propertySwitch = new PropertySwitch() {
//			public Object caseIntegerValue(final IntegerValue iv) {
//				try {
//					final long[] baseValuePair = 
//						AadlParseUtil.parseAadlInteger(iv.getValueString());
//					iv.setBase((int) baseValuePair[0]);
//					iv.setValue(baseValuePair[1]);
//				} catch(final IllegalArgumentException e) {
//					error(iv, e.getMessage());
//				}
//				return DONE;
//			}
//			
//			public Object caseRealValue(final RealValue rv) {
//				try {
//					rv.setValue(AadlParseUtil.parseAadlReal(rv.getValueString()));
//				} catch(final IllegalArgumentException e) {
//					error(rv, e.getMessage());
//				}
//				return DONE;
//			}
//		};
//	}
}