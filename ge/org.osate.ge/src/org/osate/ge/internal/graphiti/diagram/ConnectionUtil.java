package org.osate.ge.internal.graphiti.diagram;

import java.util.Collection;
import org.eclipse.graphiti.datatypes.ILocation;
import org.eclipse.graphiti.mm.algorithms.styles.PrecisionPoint;
import org.eclipse.graphiti.mm.algorithms.styles.StylesFactory;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.CurvedConnection;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.ILayoutService;

class ConnectionUtil {	
	public static void updateControlPoints(final Collection<Connection> connections) {
		for(final Connection c : connections) {
			if(c instanceof CurvedConnection) {
				updateControlPoints((CurvedConnection)c);
			}
		}
	}
	
	public static void updateControlPoints(final CurvedConnection connection) {
		final ILayoutService layoutService = Graphiti.getLayoutService();			

		// Decide a sign for the control point
		final ILocation startLocation = layoutService.getLocationRelativeToDiagram(connection.getStart());
		final ILocation endLocation = layoutService.getLocationRelativeToDiagram(connection.getEnd());
		final int sign = (startLocation.getX() - endLocation.getX()) > 0 ? -1 : 1; 
		
		final int magnitude = 30;

		// Determine a reasonable control point
		int y = sign * magnitude;
		boolean unique = false;
		while(!unique) {
			unique = true;
			for(final Connection tempConnection : connection.getParent().getConnections()) {
				if(tempConnection != connection) {
					if(tempConnection instanceof CurvedConnection) {
						final CurvedConnection tempCC = (CurvedConnection)tempConnection;
						if(connection.getStart() == tempCC.getStart() && connection.getEnd() == tempCC.getEnd()) {
							if(tempCC.getControlPoints().get(0).getY() == y) {
								unique = false;
								y += sign * magnitude;
								break;
							}
						}
					}
				}
			}
		}
		
		// Set the control point
		connection.getControlPoints().clear();
		final PrecisionPoint pp = StylesFactory.eINSTANCE.createPrecisionPoint();
		pp.setX(1.0);
		pp.setY(y);
		connection.getControlPoints().add(pp);
	}
	
}
