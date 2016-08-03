package org.osate.codegen.checker.checks;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.util.OsateDebug;
import org.osate.codegen.checker.report.ErrorReport;
import org.osate.xtext.aadl2.properties.util.GetProperties;

public class ProcessCheck extends AbstractCheck {

	public void perform(SystemInstance si) {
		
		
		/**
		 * Get processes that do not have thread
		 */
		final List<ComponentInstance> processWithoutThread = (List<ComponentInstance>) si.getAllComponentInstances().stream()
				.filter (c -> c.getCategory() == ComponentCategory.PROCESS)
				.filter( pr -> pr.getComponentInstances().stream().filter( subco -> subco.getCategory() == ComponentCategory.THREAD).collect(Collectors.toList()).size() == 0).collect(Collectors.toList());

		for (ComponentInstance process : processWithoutThread)
		{
			addError (new ErrorReport (process, "Every Process needs to have at least a thread"));
		}
		
		/**
		 * 
		 * Get Processes that are not bound to a virtual processor/runtime
		 */
		final List<ComponentInstance> processWithoutRuntime = (List<ComponentInstance>) si.getAllComponentInstances().stream()
				.filter( comp -> (comp.getCategory() == ComponentCategory.PROCESS) && (GetProperties.getBoundProcessor(comp) == null) ).collect(Collectors.toList());

		for (ComponentInstance process : processWithoutRuntime)
		{
			addError (new ErrorReport (process, "Every Process needs to be bound to a virtual processor"));
		}
		
		/**
		 * Get processes that are not bound to a memory
		 */
		
		final List<ComponentInstance> processWithoutMemory = (List<ComponentInstance>) si.getAllComponentInstances().stream()
				.filter( comp -> (comp.getCategory() == ComponentCategory.PROCESS) && (GetProperties.getActualMemoryBinding(comp) == null) ).collect(Collectors.toList());

		for (ComponentInstance process : processWithoutMemory)
		{
			addError (new ErrorReport (process, "Every Process needs to be bound to a memory"));
		}
	}
	

}
