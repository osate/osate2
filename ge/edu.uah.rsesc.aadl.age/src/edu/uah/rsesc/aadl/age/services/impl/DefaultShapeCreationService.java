package edu.uah.rsesc.aadl.age.services.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.Feature;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.services.ShapeCreationService;
import edu.uah.rsesc.aadl.age.services.ShapeService;

public class DefaultShapeCreationService implements ShapeCreationService {
	private final ShapeService shapeService;
	private IFeatureProvider fp;
	
	public DefaultShapeCreationService(final ShapeService shapeService, final IFeatureProvider fp) {
		this.shapeService = shapeService;
		this.fp = fp;
	}

	@Override
	public void createUpdateFeatureShapes(final ContainerShape shape, final List<Feature> features, final Collection<Shape> touchedShapes) {	
		createUpdateShapesForElements(shape, features, 0, false, 25, 45, true, 5, true, touchedShapes);
	}
	
	@Override
	public void createUpdateModeShapes(final ContainerShape shape, final List<Mode> modes) {
		createUpdateShapesForElements(shape, modes, 80, false, 25, 25, true, 5);
	}
	
	@Override
	public void createUpdateShapesForElements(final ContainerShape shape, final List<? extends NamedElement> elements, final int startX, final boolean incX, final int xPadding, final int startY, final boolean incY, final int yPadding) {
		createUpdateShapesForElements(shape, elements, startX, incX, xPadding, startY, incY, yPadding, false, null);
	}
	
	/**
	 * 
	 * @param shape
	 * @param elements
	 * @param fp
	 * @param startX
	 * @param incX
	 * @param xPadding
	 * @param startY
	 * @param incY
	 * @param yPadding
	 * @param touchedShapes a list to populate with the shapes that were created/updated. Can be null.
	 */
	private void createUpdateShapesForElements(final ContainerShape shape, final List<? extends NamedElement> elements, final int startX, final boolean incX, final int xPadding, final int startY, final boolean incY, final int yPadding, final boolean checkForOverlapOnCreate, final Collection<Shape> touchedShapes) {
		// TODO: Could find an X and Y that doens't overlap existing one. Or wait until layout algorithm is implemented.
		int childX = startX;
		int childY = startY;
		for(final NamedElement element : elements) {
			PictogramElement pictogramElement = shapeService.getChildShapeByElementQualifiedName(shape, element);
			if(pictogramElement == null) {
				final AddContext addContext = new AddContext();
				addContext.setNewObject(new AadlElementWrapper(element));
				addContext.setTargetContainer(shape);
				addContext.setX(childX);
				addContext.setY(childY);
				final IAddFeature feature = fp.getAddFeature(addContext);
				if(feature != null && feature.canAdd(addContext)) {
					pictogramElement = feature.add(addContext);
					if(incX) {
						childX += pictogramElement.getGraphicsAlgorithm().getWidth() + xPadding;
					}
					
					if(incY) {
						childY += pictogramElement.getGraphicsAlgorithm().getHeight() + yPadding;
					}
					
					if(checkForOverlapOnCreate) {
						final GraphicsAlgorithm newGa = pictogramElement.getGraphicsAlgorithm();
						
						boolean intersects;
						// TODO: Need to call move feature?
						// TODO: Loop cap?
						do	{
							final int minX1 = newGa.getX();
							final int minY1 = newGa.getY();
							final int maxX1 = newGa.getX() + newGa.getWidth();
							final int maxY1 = newGa.getY() + newGa.getHeight();
							
							intersects = false;
							for(final Shape child : shape.getChildren()) {
								if(child != pictogramElement) {
									final GraphicsAlgorithm childGa = child.getGraphicsAlgorithm();
									final int minX2 = childGa.getX();
									final int minY2 = childGa.getY();
									final int maxX2 = childGa.getX() + childGa.getWidth();
									final int maxY2 = childGa.getY() + childGa.getHeight();
									
									if(minX1 < maxX2 && maxX1 > minX2 && minY1 < maxY2 && maxY1 > minY2) {
										if(incX) {
											newGa.setX(maxX2 + xPadding);
										}
		
										if(incY) {
											newGa.setY(maxY2 + yPadding);
										}
	
										intersects = true;
										break;
									}
								}
							}
						} while(intersects);
					}
				}
			} else {
				final UpdateContext updateContext = new UpdateContext(pictogramElement);
				final IUpdateFeature updateFeature = fp.getUpdateFeature(updateContext);
				
				// Update the shape regardless of whether it is "needed" or not.
				if(updateFeature != null && updateFeature.canUpdate(updateContext)) {
					updateFeature.update(updateContext);
				}
			}

			if(touchedShapes != null && pictogramElement instanceof Shape) {
				touchedShapes.add((Shape)pictogramElement);
			}
		}
	}
}
