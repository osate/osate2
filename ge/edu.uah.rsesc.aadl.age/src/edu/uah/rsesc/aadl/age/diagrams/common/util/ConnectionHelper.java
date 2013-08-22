package edu.uah.rsesc.aadl.age.diagrams.common.util;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.Subcomponent;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;

public class ConnectionHelper {
	/**
	 * Returns the shape that represents the owner of the flow specification. That is the shape for the Subcomponent or ComponentType that owns the flow specification.
	 * @param connection
	 * @return
	 */
	public static ContainerShape getFlowSpecificationOwnerShape(final Connection connection, final IFeatureProvider fp) {
		if(connection.getStart().getParent() instanceof ContainerShape) {
			ContainerShape temp = (ContainerShape)connection.getStart().getParent();
			while(temp != null) {
				final Object tempBo = AadlElementWrapper.unwrap(fp.getBusinessObjectForPictogramElement(temp));
				if(tempBo instanceof Subcomponent || tempBo instanceof ComponentType) {
					return temp;
				}
				temp = temp.getContainer();
			}
			
		}

		return null;
	}
	
	public static Connection getForFlowSpecification(final ContainerShape ownerShape, final FlowSpecification fs, final IFeatureProvider fp) {		
		// Get a shape that corresponds to one of the ends o the connection.
		final PictogramElement fsEndShape = AnchorUtil.getFlowEndPictogramElement(fs.getAllInEnd() == null ? fs.getAllOutEnd() : fs.getAllInEnd(), ownerShape, fp);
		if(fsEndShape == null) {
			return null;
		}
					
		for(final Connection c : fp.getDiagramTypeProvider().getDiagram().getConnections()) {
			// Check if the anchor's parent matches the flow specification's end shape
			if((c.getStart() != null && c.getStart().getParent() == fsEndShape) || 
					(c.getEnd() != null && c.getEnd().getParent() == fsEndShape)) {
				if(AadlElementWrapper.unwrap(fp.getBusinessObjectForPictogramElement(c)) == fs) {
					return c;
				}
			}
		}
		
		return null;
	}
}
