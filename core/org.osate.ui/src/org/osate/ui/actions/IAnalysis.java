/*
 * <copyright>
 * Copyright  2005 by Carnegie Mellon University, all rights reserved.
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
 * </copyright>
 */
package org.osate.ui.actions;

import java.util.HashMap;

import org.eclipse.emf.common.util.URI;

/**
 * <code>IAnalysis</code> is the interface for all analyses that can be run
 * through the Auto-Analysis view.  There should be one analysis instance per
 * analysis run.  Here is the life cycle of an <code>IAnalysis</code> object:
 *    1.  Create a new instance.
 *    2.  Call <code>setParameter(AObject parameter)</code>.
 *    3.  Call <code>readyToRun()</code>.
 *    4a.  If <code>readyToRun()</code> returned <code>true</code>, call <code>run()</code>.
 *    4b.  If <code>readyToRun()</code> returned <code>false</code>, call <code>getNotReadyToRunReason()</code>.
 * If a method is called out of order, an <code>IllegalStateException</code> is
 * thrown.  After step 4 is executed, the object is dead and should no longer
 * be used.  Do not try to reset the parameter or run the analysis again.
 * Instead, a new <code>IAnalysis</code> object should be created.
 *
 * @author jseibel
 *
 */
public interface IAnalysis {
	/**
	 * Depending on the analysis, the parameter is the model,
	 * <code>ComponentImpl</code>, <code>SystemImpl</code>, or other
	 * <code>AObject</code> that the analysis runs on.  The appropriate
	 * parameter is dependent on the specific
	 * <code>org.osate.ui.analysis</code> extension.
	 * <code>setParameter</code> does not validate the parameter.  It is the
	 * responsibility of this method's caller to ensure that the parameter is
	 * appropriate according to the analysis' <code>plugin.xml</code> file.
	 *
	 * @param parameterPath The <code>URI</code> path of the parameter which
	 * 						can be found by calling
	 * 						<code>EcoreUtil.getURI(EObject)</code>.
	 * @param readablePath A textual representation of the parameter including
	 * 					   its location that can be displayed to the user.
	 */
	public void setParameter(URI parameterPath, String readablePath);

	public void setConfiguratorKeysAndValues(HashMap<String, String> keysAndValues);

	/**
	 * Execute the analysis based on the parameter.  If the analysis passed,
	 * then <code>true</code> is returned.  If the analysis failed, then
	 * <code>false</code> is returned.  For most analyses, failure is reported
	 * through problem markers on the model, however this behavior is not
	 * guaranteed for all analyses.  See each analysis for failure details.
	 *
	 * @return <code>true</code> if the analysis passed; <code>false</code> if
	 * 		   it failed.
	 */
	public boolean run();

	/**
	 * For all analyses, this method ensures that the parameter still exists.
	 * Depending on the specific analysis, this method might check if certain
	 * property definitions are available.  If for some reason the analysis is
	 * not in a runnable state, the reason is reported as a <code>String</code>
	 * and can be retrieved through <code>getNotReadyToRunReason()</code>.
	 *
	 * @return <code>true</code> if the <code>run()</code> method can be
	 * 		   called; <code>false</code> if it cannot.
	 */
	public boolean readyToRun();

	/**
	 * If for some reason the <code>run()</code> method could not be called,
	 * the reason is given as a human readable <code>String</code> that can be
	 * displayed to the user.
	 *
	 * @return The reason that <code>run()</code> could not be called.
	 */
	public String getNotReadyToRunReason();
}