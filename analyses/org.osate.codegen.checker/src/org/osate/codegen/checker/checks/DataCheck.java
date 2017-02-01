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

public class DataCheck extends AbstractCheck {
	
	public void perform(SystemInstance si) {
		/**
		 * Get data that do not have size
		 */
		final List<ComponentInstance> dataWithoutSize = (List<ComponentInstance>) si.getAllComponentInstances().stream()
				.filter( comp -> (comp.getCategory() == ComponentCategory.DATA) && (GetProperties.getDataSizeInBytes(comp) == 0.0 ) ).collect(Collectors.toList());

		for (ComponentInstance data : dataWithoutSize)
		{
			addError (new ErrorReport (data, "Data needs to define their size"));
		}
	}
	

}
