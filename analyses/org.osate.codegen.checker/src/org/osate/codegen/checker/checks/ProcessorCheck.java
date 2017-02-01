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
			final List<ComponentInstance> badProcessors = (List<ComponentInstance>) si.getAllComponentInstances().stream()
					.filter( comp -> comp.getCategory() == ComponentCategory.PROCESSOR).filter( cpu -> GetProperties.getModuleSchedule(cpu).size() == 0).collect(Collectors.toList());
	
			for (ComponentInstance cpu : badProcessors)
			{
				addError (new ErrorReport (cpu, "Need to define the processor schedule"));
			}
		}
		
		/**
		 * For vxworks, we need to check that the Source_Name property
		 * is defined on each virtual processor.
		 */
		if (vxworks())
		{
			final List<ComponentInstance> virtualProcessorsWithoutSourceName = 
					si.getAllComponentInstances(ComponentCategory.VIRTUAL_PROCESSOR).stream()
					.filter(comp -> ( (comp.getCategory() == ComponentCategory.VIRTUAL_PROCESSOR) && (GetProperties.getSourceName(comp) == null) )).collect(Collectors.toList());
			for (ComponentInstance vp : virtualProcessorsWithoutSourceName)
			{
				addError (new ErrorReport (vp, "Need to define the source_name property (virtual processor)"));
			}
		}
		
		/**
		 * For vxworks, we need to check that the Source_Name property
		 * is defined on each virtual processor.
		 */
		if (deos())
		{
			final List<ComponentInstance> virtualProcessorsWithoutExecutionTime = 
					si.getAllComponentInstances(ComponentCategory.VIRTUAL_PROCESSOR).stream()
					.filter(comp -> ( (comp.getCategory() == ComponentCategory.VIRTUAL_PROCESSOR) && (GetProperties.getExecutionTimeInMS(comp) == 0) )).collect(Collectors.toList());
			for (ComponentInstance vp : virtualProcessorsWithoutExecutionTime)
			{
				addError (new ErrorReport (vp, "Need to define the execution_time property"));
			}
			
			final List<ComponentInstance> virtualProcessorsWithoutPeriod = 
					si.getAllComponentInstances(ComponentCategory.VIRTUAL_PROCESSOR).stream()
					.filter(comp -> ( (comp.getCategory() == ComponentCategory.VIRTUAL_PROCESSOR) && (GetProperties.getPeriodinMS(comp) == 0) )).collect(Collectors.toList());
			for (ComponentInstance vp : virtualProcessorsWithoutPeriod)
			{
				addError (new ErrorReport (vp, "Need to define the period property"));
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
				final List<ComponentInstance> unreferencedVirtualProcessors = cpu.getComponentInstances().stream()
						.filter(comp -> ( (comp.getCategory() == ComponentCategory.VIRTUAL_PROCESSOR) && (PokProperties.getSlotsAllocation(cpu).contains(comp) == false) )).collect(Collectors.toList());
				for (ComponentInstance vp : unreferencedVirtualProcessors)
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
