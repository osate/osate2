package edu.uah.rsesc.aadl.age.diagrams.common.util;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.Anchor;
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

public class ClassifierHelper {
	public static void createUpdateFeatureShapes(final ContainerShape shape, final List<Feature> features, final IFeatureProvider fp, final Collection<Shape> touchedShapes) {	
		createUpdateShapesForElements(shape, features, fp, 0, false, 25, 25, true, 5, true, touchedShapes);
	}
	
	public static void createUpdateModeShapes(final ContainerShape shape, final List<Mode> modes, final IFeatureProvider fp) {
		createUpdateShapesForElements(shape, modes, fp, 80, false, 25, 25, true, 5);
	}
	
	public static void createUpdateShapesForElements(final ContainerShape shape, final List<? extends NamedElement> elements, final IFeatureProvider fp, final int startX, final boolean incX, final int xPadding, final int startY, final boolean incY, final int yPadding) {
		createUpdateShapesForElements(shape, elements, fp, startX, incX, xPadding, startY, incY, yPadding, false, null);
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
	private static void createUpdateShapesForElements(final ContainerShape shape, final List<? extends NamedElement> elements, final IFeatureProvider fp, final int startX, final boolean incX, final int xPadding, final int startY, final boolean incY, final int yPadding, final boolean checkForOverlapOnCreate, final Collection<Shape> touchedShapes) {
		// TODO: Could find an X and Y that doens't overlap existing one. Or wait until layout algorithm is implemented.
		int childX = startX;
		int childY = startY;
		for(final NamedElement element : elements) {
			PictogramElement pictogramElement = ShapeHelper.getChildShapeByElementQualifiedName(shape, element, fp);
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
	
	public static void createUpdateConnections(final ContainerShape ownerShape, final List<? extends Element> elements, final IFeatureProvider fp) {
		for(final Element el : elements) {
			createUpdateConnection(ownerShape, el, fp);
		}
	}
	
	public static void createUpdateConnection(final ContainerShape ownerShape, final Element el, final IFeatureProvider fp) {
		final PictogramElement pictogramElement = ConnectionHelper.getConnection(ownerShape, el, fp);
		if(pictogramElement == null) {			
			final Anchor[] anchors = ConnectionHelper.getAnchors(ownerShape, el, fp);
			if(anchors != null) {
				final AddConnectionContext addContext = new AddConnectionContext(anchors[0], anchors[1]);
				addContext.setNewObject(new AadlElementWrapper(el));
				addContext.setTargetContainer(ownerShape);
				
				final IAddFeature addFeature = fp.getAddFeature(addContext);
				if(addFeature != null && addFeature.canAdd(addContext)) {
					addFeature.add(addContext);
				}
			}
		} else {
			final UpdateContext updateContext = new UpdateContext(pictogramElement);
			final IUpdateFeature updateFeature = fp.getUpdateFeature(updateContext);
			
			// Update the connection regardless of whether it is "needed" or not.
			if(updateFeature != null && updateFeature.canUpdate(updateContext)) {
				updateFeature.update(updateContext);
			}
		}
	}
	
	/**
	 * Adjusts the positions of the child shapes so that they are non-negative and determines the needed size for the container
	 * @param shape
	 * @param fp
	 */
	public static int[] adjustChildShapePositions(final ContainerShape shape, final IFeatureProvider fp) {	
		// Determine the extra width needed to hold AADL features
		int featureWidth = 80;
		for(final Shape childShape : shape.getChildren()) {
			if(AadlElementWrapper.unwrap(fp.getBusinessObjectForPictogramElement(childShape)) instanceof Feature) {
				featureWidth = Math.max(featureWidth, childShape.getGraphicsAlgorithm().getWidth()) + 30;
			}
		}		
		
		// Determine how much to shift the X and Y of the children by
		int shiftX = 0;
		int shiftY = 0;
		for(final Shape childShape : shape.getChildren()) {
			final GraphicsAlgorithm childGa = childShape.getGraphicsAlgorithm();
			if(!(AadlElementWrapper.unwrap(fp.getBusinessObjectForPictogramElement(childShape)) instanceof Feature)) {				
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
			if(!(AadlElementWrapper.unwrap(fp.getBusinessObjectForPictogramElement(childShape)) instanceof Feature)) {				
				maxWidth = Math.max(maxWidth, childGa.getX() + childGa.getWidth() - shiftX + featureWidth);
			}			
			maxHeight = Math.max(maxHeight, childGa.getY() + childGa.getHeight() - shiftY);
			
			// Update the position of the child
			childGa.setX(childGa.getX()-shiftX);
			childGa.setY(childGa.getY()-shiftY);
		}
		
		return new int[] { maxWidth, maxHeight+25};
	}
	
	/**
	 * Returns all the features owned by the feature group type or the type it extends. It does not return features from the inverse and in the case of refined features, 
	 * only returns the refined feature.
	 * @param fgt
	 * @return
	 */
	public static EList<Feature> getAllOwnedFeatures(final FeatureGroupType fgt) {
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
	
	/**
	 * Returns all the features owned by the feature group type or the type it extends. It does not return features from the inverse and in the case of refined features, 
	 * only returns the refined feature.
	 * @param fgt
	 * @return
	 */
	public static EList<Feature> getAllOwnedFeatures(final ComponentType ct) {
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
	
	/**
	 * Returns all the features owned by the feature group type or the type it extends. This differs from getAllFeatures because it does not 
	 * return features from the inverse
	 * @param fgt
	 * @return
	 */
	public static EList<Feature> getAllOwnedFeatures(final Classifier classifier) {
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
	
	public static EList<Feature> getAllFeatures(final FeatureGroupType fgt) {
		final EList<Feature> owned = getAllOwnedFeatures(fgt);
		final FeatureGroupType inverseFgt = fgt.getInverse();
		if (owned.isEmpty() && !Aadl2Util.isNull(inverseFgt)) {
			return getAllOwnedFeatures(inverseFgt);
		}
		
		return owned;
	}
	
	/**
	 * Returns whether a feature is inverted by checking parent shapes and the corresponding features and feature group type definitions. Walks the diagram shape
	 * instead of trying to walk declarative model because it is not possible to walk up the declarative model when nested feature groups are used and in cased
	 * involving feature groups implicitly defined using inverse of.
	 * @param featureShape
	 * @param fp
	 * @return
	 */
	public static boolean isFeatureInverted(final Shape featureShape, final IFeatureProvider fp) {
		boolean isInverted = false;
		
		Shape container = featureShape.getContainer();
		while(!(container instanceof Diagram)) {
			final Object containerBo = AadlElementWrapper.unwrap(fp.getBusinessObjectForPictogramElement(container));
			if(containerBo instanceof FeatureGroup) {
				final FeatureGroup fg = (FeatureGroup)containerBo;
				isInverted ^= fg.isInverse();
				
				// This feature group type is not necessarily the one that owned the feature... Could be inverse.. Could be refined, etc..
				// Check if the feature group type was implicitly defined via an inverse
				final FeatureGroupType fgt = getFeatureGroupType(container, fg, fp);
				if(ClassifierHelper.getAllOwnedFeatures(fgt).isEmpty() && !Aadl2Util.isNull(fgt.getInverse())) {
					isInverted = !isInverted;
				}
			}

			container = container.getContainer();
		}
		
		return isInverted;
	}
	
	// Prototype Related Methods
	// CLEAN-UP: Consider moving to another class
	public static FeatureGroupType getFeatureGroupType(final Shape shape, final FeatureGroup fg, final IFeatureProvider fp) {
		if(fg.getFeatureGroupPrototype() == null) {
			return fg.getAllFeatureGroupType();
		} else {
			final Element bindingContext = getPrototypeBindingContext(shape, fp);
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
	
	public static ComponentClassifier getComponentClassifier(final Shape shape, final Subcomponent sc, final IFeatureProvider fp) {
		if(sc.getPrototype() == null) {
			return sc.getClassifier();
		} else {
			final Element bindingContext = getPrototypeBindingContext(shape, fp);
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
	
	public static ComponentCategory getComponentCategory(final Shape shape, final Subcomponent sc, final IFeatureProvider fp) {
		final ComponentClassifier c = getComponentClassifier(shape, sc, fp);
		return c == null ? sc.getCategory() : c.getCategory();
	}
	
	public static boolean isImplementation(final Shape shape, final Subcomponent sc, final IFeatureProvider fp) {
		final ComponentClassifier c = getComponentClassifier(shape, sc, fp);
		return c == null ? false : c instanceof ComponentImplementation;
	}
	
	/**
	 * Returns either the feature group type or the actual prototype
	 * @param shape
	 * @param fg
	 * @param fp
	 * @return
	 */
	// TODO: Define what shape is supposed to be
	public static Element getFeatureGroupTypeOrActual(final Shape shape, final FeatureGroup fg, final IFeatureProvider fp) {
		if(fg.getFeatureGroupPrototype() == null) {
			return fg.getAllFeatureGroupType();
		} else {
			final Element bindingContext = getPrototypeBindingContext(shape, fp);
			if(bindingContext != null) {
				return resolveFeatureGroupPrototypeToActual(fg.getFeatureGroupPrototype(), bindingContext);
			} else {
				return null;
			}
		}
	}
	
	/**
	 * @param shape
	 * @param fp
	 * @return
	 */
	public static Element getPrototypeBindingContext(final Shape shape, final IFeatureProvider fp) {
		ContainerShape temp = shape.getContainer();
		
		while(temp != null) {
			Object bo = AadlElementWrapper.unwrap(fp.getBusinessObjectForPictogramElement(temp));
			if(bo instanceof ComponentClassifier || bo instanceof FeatureGroupType) {
				return (Classifier)bo;
			} else if(bo instanceof Subcomponent) {
				return (Subcomponent)bo;
			} else if(bo instanceof FeatureGroup){
				return ClassifierHelper.getFeatureGroupTypeOrActual(temp.getContainer(), (FeatureGroup)bo, fp);
			}

			temp = temp.getContainer();
		}
		return null;
	}
	
	public static FeatureGroupPrototypeActual resolveFeatureGroupPrototypeToActual(Prototype proto, Element context) {
		FeatureGroupPrototypeBinding fgpb = (FeatureGroupPrototypeBinding)ResolvePrototypeUtil.resolvePrototype(proto, context);

		if (fgpb == null) {
			// cannot resolve
			return null;
		}
		
		return fgpb.getActual();
	}
}
