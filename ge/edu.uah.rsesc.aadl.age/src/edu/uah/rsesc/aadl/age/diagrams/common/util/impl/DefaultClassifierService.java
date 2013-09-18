package edu.uah.rsesc.aadl.age.diagrams.common.util.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Element;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupPrototypeActual;
import org.osate.aadl2.FeatureGroupPrototypeBinding;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Prototype;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.modelsupport.util.ResolvePrototypeUtil;
import org.osate.aadl2.util.Aadl2Util;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.diagrams.common.mapping.BusinessObjectResolver;
import edu.uah.rsesc.aadl.age.diagrams.common.util.ClassifierService;
import edu.uah.rsesc.aadl.age.diagrams.common.util.ShapeService;

public class DefaultClassifierService implements ClassifierService {
	private final ShapeService shapeHelper;
	private final BusinessObjectResolver bor;
	private IFeatureProvider fp;
	public DefaultClassifierService(final ShapeService shapeHelper, final BusinessObjectResolver bor, final IFeatureProvider fp) {
		this.shapeHelper = shapeHelper;
		this.bor = bor;
		this.fp = fp;
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.ClassifierService#createUpdateFeatureShapes(org.eclipse.graphiti.mm.pictograms.ContainerShape, java.util.List, java.util.Collection)
	 */
	@Override
	public void createUpdateFeatureShapes(final ContainerShape shape, final List<Feature> features, final Collection<Shape> touchedShapes) {	
		createUpdateShapesForElements(shape, features, 0, false, 25, 25, true, 5, true, touchedShapes);
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.ClassifierService#createUpdateModeShapes(org.eclipse.graphiti.mm.pictograms.ContainerShape, java.util.List)
	 */
	@Override
	public void createUpdateModeShapes(final ContainerShape shape, final List<Mode> modes) {
		createUpdateShapesForElements(shape, modes, 80, false, 25, 25, true, 5);
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.ClassifierService#createUpdateShapesForElements(org.eclipse.graphiti.mm.pictograms.ContainerShape, java.util.List, int, boolean, int, int, boolean, int)
	 */
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
			PictogramElement pictogramElement = shapeHelper.getChildShapeByElementQualifiedName(shape, element);
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
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.ClassifierService#adjustChildShapePositions(org.eclipse.graphiti.mm.pictograms.ContainerShape)
	 */
	@Override
	public int[] adjustChildShapePositions(final ContainerShape shape) {	
		// Determine the extra width needed to hold AADL features
		int featureWidth = 80;
		for(final Shape childShape : shape.getChildren()) {
			if(bor.getBusinessObjectForPictogramElement(childShape) instanceof Feature) {
				featureWidth = Math.max(featureWidth, childShape.getGraphicsAlgorithm().getWidth()) + 30;
			}
		}		
		
		// Determine how much to shift the X and Y of the children by
		int shiftX = 0;
		int shiftY = 0;
		for(final Shape childShape : shape.getChildren()) {
			final GraphicsAlgorithm childGa = childShape.getGraphicsAlgorithm();
			if(!(bor.getBusinessObjectForPictogramElement(childShape) instanceof Feature)) {				
				shiftX = Math.min(shiftX, childGa.getX()-featureWidth);
				shiftY = Math.min(shiftY, childGa.getY()-30);				
			}
		}
		
		// Calculate max width and height
		int maxWidth = 300;
		int maxHeight = 300;
		for(final Shape childShape : shape.getChildren()) {
			final GraphicsAlgorithm childGa = childShape.getGraphicsAlgorithm();
			
			// Determine the needed width and height of the classifier shape
			// Do not consider features when calculating needed width. Otherwise, features on the right side of the shape would prevent the width from shrinking
			if(!(bor.getBusinessObjectForPictogramElement(childShape) instanceof Feature)) {				
				maxWidth = Math.max(maxWidth, childGa.getX() + childGa.getWidth() - shiftX + featureWidth);
			}			
			maxHeight = Math.max(maxHeight, childGa.getY() + childGa.getHeight() - shiftY);
			
			// Update the position of the child
			childGa.setX(childGa.getX()-shiftX);
			childGa.setY(childGa.getY()-shiftY);
		}
		
		return new int[] { maxWidth, maxHeight+25};
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.ClassifierService#getAllOwnedFeatures(org.osate.aadl2.FeatureGroupType)
	 */
	@Override
	public EList<Feature> getAllOwnedFeatures(final FeatureGroupType fgt) {
		final EList<Feature> features = new BasicEList<Feature>();
		FeatureGroupType temp = fgt;
		while(temp != null) {
			boolean wasRefined = false;
			for(final Feature newFeature : temp.getOwnedFeatures()) {
				for(final Feature existingFeature : features) {
					if(existingFeature.getRefined() == newFeature) {
						wasRefined = true;
					}
				}
				
				if(!wasRefined) {
					features.add(newFeature);
				}
			}
			temp = temp.getExtended();
		}

		return features;
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.ClassifierService#getAllOwnedFeatures(org.osate.aadl2.ComponentType)
	 */
	@Override
	public EList<Feature> getAllOwnedFeatures(final ComponentType ct) {
		final EList<Feature> features = new BasicEList<Feature>();
		ComponentType temp = ct;
		while(temp != null) {
			boolean wasRefined = false;
			for(final Feature newFeature : temp.getOwnedFeatures()) {
				for(final Feature existingFeature : features) {
					if(existingFeature.getRefined() == newFeature) {
						wasRefined = true;
					}
				}
				
				if(!wasRefined) {
					features.add(newFeature);
				}
			}
			temp = temp.getExtended();
		}

		return features;
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.ClassifierService#getAllOwnedFeatures(org.osate.aadl2.Classifier)
	 */
	@Override
	public EList<Feature> getAllOwnedFeatures(final Classifier classifier) {
		if(classifier instanceof FeatureGroupType) {
			return getAllOwnedFeatures((FeatureGroupType)classifier);
		} 
		/*else if(classifier instanceof ComponentType) { 
			return classifier.getAllFeatures();// getAllOwnedFeatures((ComponentType)classifier);
		} else if(classifier instanceof ComponentImplementation) {
			return getAllOwnedFeatures(((ComponentImplementation) classifier).getType());
		} else {
			throw new RuntimeException("Unhandled case for classifier:" + classifier);
		}*/
		return classifier.getAllFeatures();
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.ClassifierService#getAllFeatures(org.osate.aadl2.FeatureGroupType)
	 */
	@Override
	public EList<Feature> getAllFeatures(final FeatureGroupType fgt) {
		final EList<Feature> owned = getAllOwnedFeatures(fgt);
		final FeatureGroupType inverseFgt = fgt.getInverse();
		if (owned.isEmpty() && !Aadl2Util.isNull(inverseFgt)) {
			return getAllOwnedFeatures(inverseFgt);
		}
		
		return owned;
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.ClassifierService#isFeatureInverted(org.eclipse.graphiti.mm.pictograms.Shape)
	 */
	@Override
	public boolean isFeatureInverted(final Shape featureShape) {
		boolean isInverted = false;
		
		Shape container = featureShape.getContainer();
		while(!(container instanceof Diagram)) {
			final Object containerBo = bor.getBusinessObjectForPictogramElement(container);
			if(containerBo instanceof FeatureGroup) {
				final FeatureGroup fg = (FeatureGroup)containerBo;
				isInverted ^= fg.isInverse();
				
				// This feature group type is not necessarily the one that owned the feature... Could be inverse.. Could be refined, etc..
				// Check if the feature group type was implicitly defined via an inverse
				final FeatureGroupType fgt = getFeatureGroupType(container, fg);
				if(getAllOwnedFeatures(fgt).isEmpty() && !Aadl2Util.isNull(fgt.getInverse())) {
					isInverted = !isInverted;
				}
			}

			container = container.getContainer();
		}
		
		return isInverted;
	}
	
	// Prototype Related Methods
	// CLEAN-UP: Consider moving to another class
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.ClassifierService#getFeatureGroupType(org.eclipse.graphiti.mm.pictograms.Shape, org.osate.aadl2.FeatureGroup)
	 */
	@Override
	public FeatureGroupType getFeatureGroupType(final Shape shape, final FeatureGroup fg) {
		if(fg.getFeatureGroupPrototype() == null) {
			return fg.getAllFeatureGroupType();
		} else {
			final Element bindingContext = getPrototypeBindingContext(shape);
			if(bindingContext != null) {
				final FeatureGroupType fgt = ResolvePrototypeUtil.resolveFeatureGroupPrototype(fg.getFeatureGroupPrototype(), bindingContext);
				if(fgt != null) {
					return fgt;
				}
				return fg.getFeatureGroupPrototype().getConstrainingFeatureGroupType();
			}			
		}

		return null;
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.ClassifierService#getComponentClassifier(org.eclipse.graphiti.mm.pictograms.Shape, org.osate.aadl2.Subcomponent)
	 */
	@Override
	public ComponentClassifier getComponentClassifier(final Shape shape, final Subcomponent sc) {
		if(sc.getPrototype() == null) {
			return sc.getClassifier();
		} else {
			final Element bindingContext = getPrototypeBindingContext(shape);
			if(bindingContext != null) {
				final ComponentClassifier cc = ResolvePrototypeUtil.resolveComponentPrototype(sc.getPrototype(), bindingContext);
				if(cc != null) {
					return cc;
				}

				return sc.getPrototype().getConstrainingClassifier();
			}			
		}

		return null;
	}	
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.ClassifierService#getComponentCategory(org.eclipse.graphiti.mm.pictograms.Shape, org.osate.aadl2.Subcomponent)
	 */
	@Override
	public ComponentCategory getComponentCategory(final Shape shape, final Subcomponent sc) {
		final ComponentClassifier c = getComponentClassifier(shape, sc);
		return c == null ? sc.getCategory() : c.getCategory();
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.ClassifierService#isImplementation(org.eclipse.graphiti.mm.pictograms.Shape, org.osate.aadl2.Subcomponent)
	 */
	@Override
	public boolean isImplementation(final Shape shape, final Subcomponent sc) {
		final ComponentClassifier c = getComponentClassifier(shape, sc);
		return c == null ? false : c instanceof ComponentImplementation;
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.ClassifierService#getFeatureGroupTypeOrActual(org.eclipse.graphiti.mm.pictograms.Shape, org.osate.aadl2.FeatureGroup)
	 */
	// TODO: Define what shape is supposed to be
	@Override
	public Element getFeatureGroupTypeOrActual(final Shape shape, final FeatureGroup fg) {
		if(fg.getFeatureGroupPrototype() == null) {
			return fg.getAllFeatureGroupType();
		} else {
			final Element bindingContext = getPrototypeBindingContext(shape);
			if(bindingContext != null) {
				return resolveFeatureGroupPrototypeToActual(fg.getFeatureGroupPrototype(), bindingContext);
			} else {
				return null;
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.ClassifierService#getPrototypeBindingContext(org.eclipse.graphiti.mm.pictograms.Shape)
	 */
	@Override
	public Element getPrototypeBindingContext(final Shape shape) {
		ContainerShape temp = shape.getContainer();
		
		while(temp != null) {
			Object bo = bor.getBusinessObjectForPictogramElement(temp);
			if(bo instanceof ComponentClassifier || bo instanceof FeatureGroupType) {
				return (Classifier)bo;
			} else if(bo instanceof Subcomponent) {
				return (Subcomponent)bo;
			} else if(bo instanceof FeatureGroup){
				return getFeatureGroupTypeOrActual(temp.getContainer(), (FeatureGroup)bo);
			}

			temp = temp.getContainer();
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.ClassifierService#resolveFeatureGroupPrototypeToActual(org.osate.aadl2.Prototype, org.osate.aadl2.Element)
	 */
	@Override
	public FeatureGroupPrototypeActual resolveFeatureGroupPrototypeToActual(Prototype proto, Element context) {
		FeatureGroupPrototypeBinding fgpb = (FeatureGroupPrototypeBinding)ResolvePrototypeUtil.resolvePrototype(proto, context);

		if (fgpb == null) {
			// cannot resolve
			return null;
		}
		
		return fgpb.getActual();
	}
}
