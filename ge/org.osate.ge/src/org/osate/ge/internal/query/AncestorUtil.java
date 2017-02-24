package org.osate.ge.internal.query;

import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.ge.internal.services.ConnectionService;
import org.osate.ge.internal.services.PropertyService;

public class AncestorUtil {
	/**
	 * Returns the first ancestor which is also a member of the logical tree.
	 * @param pe
	 * @return
	 */
	public static <A> PictogramElement getParent(PictogramElement pe, QueryExecutionState<A> state) {
		return getParent(pe, state.propertyService, state.connectionService);
	}
	
	/**
	 * Returns the first ancestor which is also a member of the logical tree.
	 * @return
	 */
	public static PictogramElement getParent(PictogramElement pe, final PropertyService propertyService, final ConnectionService connectionService) {
		while(pe != null) {
			if(pe instanceof ConnectionDecorator) {
				pe = ((ConnectionDecorator) pe).getConnection();
			} else if(pe instanceof Shape) {
				pe = ((Shape) pe).getContainer();
			} else if(pe instanceof Connection) {
				pe = connectionService.getOwner((Connection)pe);
			} else {
				throw new RuntimeException("Unhandled pictoram element: " + pe);
			}

			if(pe != null && propertyService.isLogicalTreeNode(pe)) {
				return pe;
			}
		}
		
		return null;
	}
}
