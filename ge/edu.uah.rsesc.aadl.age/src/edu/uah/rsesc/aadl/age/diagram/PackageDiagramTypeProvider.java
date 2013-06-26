package edu.uah.rsesc.aadl.age.diagram;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;
import org.osate.aadl2.Generalization;

public class PackageDiagramTypeProvider extends AbstractDiagramTypeProvider {
	public PackageDiagramTypeProvider() {
		super();
		setFeatureProvider(new PackageFeatureProvider(this));
	}
	
	@Override
	public boolean isAutoUpdateAtStartup() {
		return true;
	}
	/*
	@Override
	public boolean isAutoUpdateAtRuntime() {
		return true;
	}
*/

	// Tool behaviors are provided to modify the business object equality check. This is because as of 2013-06-26, the default comparison between
	// Generalization objects does not work. See https://github.com/osate/osate2-core/issues/250
	// TODO: Disable after issue is resolved
	private IToolBehaviorProvider[] toolBehaviorProviders;
	@Override
    public IToolBehaviorProvider[] getAvailableToolBehaviorProviders() {
        if (toolBehaviorProviders == null) {
            toolBehaviorProviders = new IToolBehaviorProvider[] { new DefaultToolBehaviorProvider(this) {
            	@Override
				public boolean equalsBusinessObjects(final Object o1, final Object o2) {            	
            		if(o1 instanceof Generalization) {
            			return o1.equals(o2);
            		} 
            		return super.equalsBusinessObjects(o1, o2);
            	}	                	
            }};
        }
        return toolBehaviorProviders;
    }
}
