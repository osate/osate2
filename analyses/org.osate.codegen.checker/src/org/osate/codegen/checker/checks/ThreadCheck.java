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
