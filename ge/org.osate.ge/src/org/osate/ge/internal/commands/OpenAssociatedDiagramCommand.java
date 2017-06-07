package org.osate.ge.internal.commands;

import javax.inject.Named;

import org.osate.aadl2.Classifier;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.di.Activate;
import org.osate.ge.di.GetLabel;
import org.osate.ge.di.IsAvailable;
import org.osate.ge.di.Names;
import org.osate.ge.internal.businessObjectHandlers.ClassifierHandler;
import org.osate.ge.internal.businessObjectHandlers.SubcomponentHandler;
import org.osate.ge.internal.services.DiagramService;
import org.osate.ge.internal.util.AadlSubcomponentUtil;

public class OpenAssociatedDiagramCommand {
	@GetLabel
	public String getLabel() {
		return "Open Associated Diagram";
	}

	@IsAvailable
	public boolean isAvailable(@Named(Names.BUSINESS_OBJECT) final Object bo,
			@Named(Names.BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext boc) {
		return bo instanceof Classifier || 
				(bo instanceof Subcomponent && AadlSubcomponentUtil.getComponentClassifier(boc, (Subcomponent)bo) != null);
	}

	@Activate
	public void activate(@Named(Names.BUSINESS_OBJECT) final Object bo, 
			@Named(Names.BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext boc,
			final DiagramService diagramService) {
		if(bo instanceof Classifier) {
			ClassifierHandler.openAssociatedDiagram((Classifier)bo, diagramService);
		} else if(bo instanceof Subcomponent) {
			SubcomponentHandler.openAssociatedDiagram((Subcomponent)bo, boc, diagramService);
		}
	}
}
