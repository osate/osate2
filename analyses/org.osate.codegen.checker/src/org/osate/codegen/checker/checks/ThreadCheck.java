/**
 * <copyright>
 * Copyright 2016 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/epl-v10.html.
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
 * of Defense under Contract FA8721-05-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 */

package org.osate.codegen.checker.checks;

import java.util.List;
import java.util.stream.Collectors;

import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.ThreadImplementation;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.codegen.checker.report.ErrorReport;
import org.osate.xtext.aadl2.properties.util.GetProperties;

public class ThreadCheck extends AbstractCheck {

	public void perform(SystemInstance si) {

		final List<ComponentInstance> allThreads = si.getAllComponentInstances().stream()
				.filter(comp -> (comp.getCategory() == ComponentCategory.THREAD)).collect(Collectors.toList());

		/**
		 * Each thread needs to specify its dispatch protocol
		 */
		final List<ComponentInstance> threadMissingDispatch = allThreads.stream()
				.filter(comp -> (GetProperties.getDispatchProtocol(comp) == null)
						&& ((GetProperties.getDispatchProtocol(comp).toString().equalsIgnoreCase("periodic"))
								|| (GetProperties.getDispatchProtocol(comp).toString().equalsIgnoreCase("sporadic"))))
				.collect(Collectors.toList());

		for (ComponentInstance thr : threadMissingDispatch) {
			addError(new ErrorReport(thr, "Need to define the Dispatch_Protocol property"));
		}

		/**
		 * Each thread needs to specify period
		 */
		final List<ComponentInstance> threadMissingPeriod = allThreads.stream()
				.filter(comp -> (GetProperties.getPeriodinMS(comp) == 0.0)).collect(Collectors.toList());
		for (ComponentInstance thr : threadMissingPeriod) {
			addError(new ErrorReport(thr, "Thread needs to define the Period property"));
		}

		final List<ComponentInstance> threadMissingDeadline = allThreads.stream()
				.filter(comp -> (GetProperties.getDeadlineinMilliSec(comp) == 0.0)).collect(Collectors.toList());
		for (ComponentInstance thr : threadMissingDeadline) {
			addError(new ErrorReport(thr, "Thread needs to define the Deadline property"));
		}

		for (ComponentInstance ci : allThreads) {

			ThreadImplementation ti = (ThreadImplementation) ci.getComponentClassifier();
			for (SubprogramCall sc : ti.getSubprogramCalls()) {
				NamedElement cs = (NamedElement) sc.getCalledSubprogram();

				if (GetProperties.getSourceName(cs) == null) {
					addError(new ErrorReport(cs, "Subprogram needs to define Source_Name property"));
				}

				if (GetProperties.getSourceText(cs).size() == 0) {
					addError(new ErrorReport(cs, "Thread needs to define Source_Text property"));
				}

				if (GetProperties.getSourceLanguage(cs).size() == 0) {
					addError(new ErrorReport(cs, "Thread needs to define Source_Language property"));
				}
			}

		}

		/**
		 * FIXME JD
		 * Each thread needs to specify execution time
		 */
//		List<ComponentInstance> threadMissingExecutionTime = (List<ComponentInstance>) si.getAllComponentInstances().stream().
//				filter( comp -> (comp.getCategory() == ComponentCategory.THREAD) && (GetProperties.get > 0.0));
//		for (ComponentInstance thr : threadMissingPeriod)
//		{
//			addError (new ErrorReport (thr, "Thread needs to define a period"));
//		}
	}

}
