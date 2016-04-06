package org.osate.ge.internal.query;

import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

class AncestorUtil {
	/**
	 * Returns the first ancestor which is also a member of the logical tree.
	 * @param pe
	 * @param propertyService
	 * @return
	 */
	public static <A> PictogramElement getAncestor(PictogramElement pe, QueryExecutionState<A> state) {
		while(pe != null) {
			if(pe instanceof Shape) {
				pe = ((Shape) pe).getContainer();
			} else if(pe instanceof Connection) {
				pe = state.connectionService.getOwnerShape((Connection)pe);
			} else {
				throw new RuntimeException("Unhandled pictoram element: " + pe);
			}

			if(pe != null && state.propertyService.isLogicalTreeNode(pe)) {
				return pe;
			}
		}
		
		return null;
	}
}
