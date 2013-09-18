package edu.uah.rsesc.aadl.age.diagrams.common;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;

public class AgeDiagramTypeProvider extends AbstractDiagramTypeProvider {
	public AgeDiagramTypeProvider() {			
	}
	
	@Override
	public boolean isAutoUpdateAtStartup() {
		return true;
	}	

	private IToolBehaviorProvider[] toolBehaviorProviders;
	
	@Override
    public IToolBehaviorProvider[] getAvailableToolBehaviorProviders() {
        if (toolBehaviorProviders == null) {
            toolBehaviorProviders = new IToolBehaviorProvider[] { new AgeToolBehaviorProvider(this) };
        }
        return toolBehaviorProviders;
    }
}
