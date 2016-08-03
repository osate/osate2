package org.osate.codegen.checker.checks;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.internal.resources.Marker;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.util.OsateDebug;
import org.osate.codegen.checker.handlers.CheckerHandler;
import org.osate.codegen.checker.report.ErrorReport;
import org.osate.codegen.checker.utils.PokProperties;
import org.osate.xtext.aadl2.properties.util.GetProperties;

public class ProcessorCheck extends AbstractCheck {

	public void perform(SystemInstance si) {


		/**
		 * processor needs to define their schedule
		 */
		if (vxworks() || deos())
		{
			List<ComponentInstance> badProcessors = (List<ComponentInstance>) si.getAllComponentInstances().stream()
					.filter( comp -> comp.getCategory() == ComponentCategory.PROCESSOR).filter( cpu -> GetProperties.getModuleSchedule(cpu).size() == 0).collect(Collectors.toList());
	
			for (ComponentInstance cpu : badProcessors)
			{
				addError (new ErrorReport (cpu, "Need to define the processor schedule"));
			}
		}
		
		if (pok())
		{
			OsateDebug.osateDebug("pok case");
			
			/**
			 * For each CPU, we check that every virtual processor contained in the cpu is correctly
			 * referenced in the schedule slots 
			 */
			for (ComponentInstance cpu : si.getComponentInstances().stream().filter(comp -> comp.getCategory() == ComponentCategory.PROCESSOR).collect(Collectors.toList()) )
			{
				List<ComponentInstance> badVirtualProcessor = cpu.getComponentInstances().stream()
						.filter(comp -> ( (comp.getCategory() == ComponentCategory.VIRTUAL_PROCESSOR) && (PokProperties.getSlotsAllocation(cpu).contains(comp) == false) )).collect(Collectors.toList());
				for (ComponentInstance vp : badVirtualProcessor)
				{
					addError (new ErrorReport (cpu, "Need to be referenced in the processor slots"));
				}
			

				if (PokProperties.getSlotsAllocation(cpu).size() != PokProperties.getTimeSlotInMs(cpu).size())
				{
					addError (new ErrorReport (cpu, "There are missing slots"));
				}
			}
			
			
			
//			List<ComponentInstance> badProcessors = (List<ComponentInstance>) si.getAllComponentInstances().stream()
//					.filter( comp -> comp.getCategory() == ComponentCategory.PROCESSOR).filter( cpu -> GetProperties.getModuleSchedule(cpu).size() == 0).collect(Collectors.toList());
//	
//			for (ComponentInstance cpu : badProcessors)
//			{
//				addError (new ErrorReport (cpu, "Need to define the processor schedule"));
//			}		
		}
	}
	

}
