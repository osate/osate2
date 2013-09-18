package edu.uah.rsesc.aadl.age.diagrams.common.util;

import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.ChopboxAnchor;
import org.eclipse.graphiti.mm.pictograms.FixPointAnchor;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

/**
 * Provides methods to make working with anchors easier.
 * @author philip.alldredge
 *
 */
public interface AnchorService {

	Anchor getAnchorByName(PictogramElement pe, String name);

	ChopboxAnchor createOrUpdateChopboxAnchor(AnchorContainer container, String name);

	FixPointAnchor createOrUpdateFixPointAnchor(AnchorContainer shape, String name, int x, int y);

}