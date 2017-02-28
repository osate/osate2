package org.osate.codegen.checker.checks;

import java.util.List;
import java.util.stream.Collectors;

import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.codegen.checker.report.ErrorReport;
import org.osate.xtext.aadl2.properties.util.GetProperties;

public class MemoryCheck extends AbstractCheck {

	public void perform(SystemInstance si) {

		/**
		 * Get the memory segments without size.
		 * For that, we get all memory components that have a parent that
		 * is ALSO a memory component. The segment does not have the byte_count
		 * property set.
		 */

		if (pok()) {
			final List<ComponentInstance> segmentsWithoutSize = si.getAllComponentInstances()
					.stream()
					.filter(comp -> (comp.getCategory() == ComponentCategory.MEMORY)
							&& (GetProperties.getByteCount(comp) == 0.0)
							&& (comp.getContainingComponentInstance().getCategory() == ComponentCategory.MEMORY))
					.collect(Collectors.toList());

			for (ComponentInstance data : segmentsWithoutSize) {
				addError(new ErrorReport(data, "Partition size must be set"));
			}
		}

	}

}
