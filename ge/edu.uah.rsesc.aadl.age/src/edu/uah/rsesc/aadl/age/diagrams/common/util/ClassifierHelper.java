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
import org.osate.aadl2.ComponentPrototype;
import org.osate.aadl2.ComponentPrototypeActual;
import org.osate.aadl2.ComponentPrototypeBinding;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.Element;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupPrototypeActual;
import org.osate.aadl2.FeatureGroupPrototypeBinding;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.FeaturePrototypeActual;
import org.osate.aadl2.FeaturePrototypeBinding;
import org.osate.aadl2.FeaturePrototypeReference;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Prototype;
import org.osate.aadl2.PrototypeBinding;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.modelsupport.util.ResolvePrototypeUtil;
import org.osate.aadl2.util.Aadl2Util;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;

public class ClassifierHelper {
	public static void createUpdateFeatureShapes(final ContainerShape shape, final List<Feature> features, final IFeatureProvider fp, final Collection<Shape> touchedShapes) {	
		createUpdateShapesForElements(shape, features, fp, 0, false, 25, 0, true, 5, touchedShapes);
	}
	
	public static void createUpdateModeShapes(final ContainerShape shape, final List<Mode> modes, final IFeatureProvider fp) {
		createUpdateShapesForElements(shape, modes, fp, 80, false, 25, 0, true, 5);
	}
	
	public static void createUpdateShapesForElements(final ContainerShape shape, final List<? extends NamedElement> elements, final IFeatureProvider fp, final int startX, final boolean incX, final int xPadding, final int startY, final boolean incY, final int yPadding) {
		createUpdateShapesForElements(shape, elements, fp, startX, incX, xPadding, startY, incY, yPadding, null);
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
	public static void createUpdateShapesForElements(final ContainerShape shape, final List<? extends NamedElement> elements, final IFeatureProvider fp, final int startX, final boolean incX, final int xPadding, final int startY, final boolean incY, final int yPadding, final Collection<Shape> touchedShapes) {
		// TODO: Could find an X and Y that doens't overlap existing one. Or wait until layout algorithm is implemented.
		int childX = startX;
		int childY = startY;
		for(final NamedElement element : elements) {
			PictogramElement pictogramElement = ShapeHelper.getChildShapeByElement(shape, element, fp);
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
	
	/**
	 * Returns all the features owned by the feature group type or the type it extends. This differs from FeatureGroupType's getAllFeatures because it does not 
	 * return features from the inverse.
	 * @param fgt
	 * @return
	 */
	public static EList<Feature> getAllOwnedFeatures(final Classifier classifier) {
		if(classifier instanceof FeatureGroupType) {
			return getAllOwnedFeatures((FeatureGroupType)classifier);
		} else {
			return classifier.getAllFeatures();
		}
	}
	
	/**
	 * Returns all the features owned by the feature group type or the type it extends. This differs from FeatureGroupType's getAllFeatures because it does not 
	 * return features from the inverse.
	 * @param fgt
	 * @return
	 */
	public static EList<Feature> getAllOwnedFeatures(final FeatureGroupType fgt) {
		final EList<Feature> features = new BasicEList<Feature>();
		FeatureGroupType temp = fgt;
		while(temp != null) {
			features.addAll(temp.getOwnedFeatures());
			temp = temp.getExtended();
		}

		return features;
	}
	
	// Alternative implementation of getAllFeatures. 
	// TODO: Remove if/when it is implemented into OSATE
	public static EList<Feature> getAllFeatures(final FeatureGroupType fgt) {
		final EList<Feature> owned = getAllOwnedFeatures(fgt);
		final FeatureGroupType inverseFgt = fgt.getInverse();
		if (owned.isEmpty() && !Aadl2Util.isNull(inverseFgt)) {
			return getAllOwnedFeatures(inverseFgt);
		}
		
		return owned;
	}
	
	public static void createUpdateFlowSpecifications(final ContainerShape shape, final ComponentType componentType, final IFeatureProvider fp) {
		for(final FlowSpecification fs : componentType.getAllFlowSpecifications()) {
			// Only show flow specifications that re not in any modes	
			final PictogramElement pictogramElement = ConnectionHelper.getForFlowSpecification(shape, fs, fp);
			if(pictogramElement == null) {			
				final Anchor[] anchors = AnchorUtil.getAnchorsForFlowSpecification(fs, shape, fp);
				
				if(anchors != null) {
					final AddConnectionContext addContext = new AddConnectionContext(anchors[0], anchors[1]);
					addContext.setNewObject(new AadlElementWrapper(fs));
					
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
	
	public static void createUpdateModeTransitions(final List<ModeTransition> modeTransitions, final IFeatureProvider fp) {
		for(final ModeTransition mt : modeTransitions) {			
			final PictogramElement pictogramElement = fp.getPictogramElementForBusinessObject(mt);
			if(pictogramElement == null) {	
				final Anchor[] anchors = AnchorUtil.getAnchorsForModeTransition(mt, fp);
				
				if(anchors != null) {
					final AddConnectionContext addContext = new AddConnectionContext(anchors[0], anchors[1]);
					addContext.setNewObject(new AadlElementWrapper(mt));
					
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
	}
	
	/**
	 * Adjusts the positions of the child shapes so that they are non-negative and determines the needed size for the container
	 * @param shape
	 * @param fp
	 */
	public static int[] adjustChildShapePositions(final ContainerShape shape, final IFeatureProvider fp) {	
		// Determine how much to shift the X and Y of the children by
		int shiftX = 0;
		int shiftY = 0;
		for(final Shape childShape : shape.getChildren()) {
			final GraphicsAlgorithm childGa = childShape.getGraphicsAlgorithm();
			shiftX = Math.min(shiftX, childGa.getX());
			shiftY = Math.min(shiftY, childGa.getY());
		}
		
		// Determine the extra width needed to hold AADL features
		int featureWidth = 80;
		for(final Shape childShape : shape.getChildren()) {
			if(AadlElementWrapper.unwrap(fp.getBusinessObjectForPictogramElement(childShape)) instanceof Feature) {
				featureWidth = Math.max(featureWidth, childShape.getGraphicsAlgorithm().getWidth());
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
	
	
	// Prototype Related Methods
	// CLEAN-UP: Consider moving to another class
	public static FeatureGroupType getFeatureGroupType(final Shape shape, final FeatureGroup fg, final IFeatureProvider fp) {
		if(fg.getFeatureGroupPrototype() == null) {
			return fg.getAllFeatureGroupType();
		} else {
			final Element bindingContext = getPrototypeBindingContext(shape, fp);
			if(bindingContext != null) {
				final FeatureGroupType fgt = resolveFeatureGroupPrototype(fg.getFeatureGroupPrototype(), bindingContext);
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
				final ComponentClassifier cc = ClassifierHelper.resolveComponentPrototype(sc.getPrototype(), bindingContext);
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
		FeatureGroupPrototypeBinding fgpb = (FeatureGroupPrototypeBinding) resolvePrototype(proto, context);

		if (fgpb == null) {
			// cannot resolve
			return null;
		}
		
		return fgpb.getActual();
	}
	
// TODO: Remove after merged into OSATE(all following)
	public static PrototypeBinding resolvePrototype(Prototype proto, Element context) {
		PrototypeBinding result = null;
		if (context instanceof Classifier) {
			Classifier impl = (Classifier) context;
			result = impl.lookupPrototypeBinding(proto);
		} else if (context instanceof Subcomponent) {
			Subcomponent parentSub = (Subcomponent)context;
			result = parentSub.lookupPrototypeBinding(proto);
			if(result == null) {
				result = resolvePrototype(proto, parentSub.getAllClassifier());
			}
		} else if (context instanceof ContainmentPathElement){
			result = ResolvePrototypeUtil.resolvePrototypeInContainmentPath(proto, (ContainmentPathElement)context);
		} else if(context instanceof FeatureGroupPrototypeActual) {
			final FeatureGroupPrototypeActual fgpa = (FeatureGroupPrototypeActual)context;
			for(final PrototypeBinding binding : fgpa.getBindings()) {
				if(binding.getFormal() == proto) {
					result = binding;
					break;
				}				
			}
		}
//			// lookup in parent's classifier (nested prototype bindings)
//			if (result == null && parent != null) {
//				ResolvedClassifier parentClassifier = getInstantiatedClassifier(parent, 0, classifierCache);
//
//				if (parentClassifier.bindings != null) {
//					for (PrototypeBinding binding : parentClassifier.bindings) {
//						if (binding.getFormal() == proto) {
//							result = binding;
//							break;
//						}
//					}
//				}
//				if (result == null) {
//					result = parentClassifier.classifier.lookupPrototypeBinding(proto);
//				}
//			}
		return result;
	}
	
	// Add another patch to OSATE 2 when finished
	/**
	 * Find the binding for a given feature prototype. Recursively resolves references.
	 * @param proto the prototype to resolve
	 * @param context the context in which the prototype is used, e.g., a ComponentType,  FeatureGroupType
	 * @return the actual feature this prototype resolves to.
	 */
	public static FeaturePrototypeBinding resolveFeaturePrototype(Prototype proto, Element context) {
		final FeaturePrototypeBinding fpb = (FeaturePrototypeBinding)resolvePrototype(proto, context);
		if(fpb == null) {
			// cannot resolve
			return null;
		}
		
		final FeaturePrototypeActual actual = fpb.getActual();
		if(actual instanceof FeaturePrototypeReference) {
			// If context is FeatureGroupPrototypeActual, use containing classifier as the context for the reference
			if(context instanceof FeatureGroupPrototypeActual) {
				context = context.getContainingClassifier();
			}
			return resolveFeaturePrototype(((FeaturePrototypeReference) actual).getPrototype(), context);
		}			
		
		return fpb;
	}
	
	// TODO:MERGE INTO OSATE IF CHANGES ARE MADE. Otherwise just remove when no longer needed
	public static FeatureGroupType resolveFeatureGroupPrototype(Prototype proto, Element context) {
		FeatureGroupPrototypeBinding fgpb = (FeatureGroupPrototypeBinding) resolvePrototype(proto, context);

		if (fgpb == null) {
			// cannot resolve
			return null;
		}
		FeatureGroupPrototypeActual actual = fgpb.getActual();

		if (actual.getFeatureType() instanceof FeatureGroupType) {
			return (FeatureGroupType) actual.getFeatureType();
		} else {
			if (actual.getFeatureType() instanceof Prototype && context instanceof ContainmentPathElement){
			// resolve recursively if we are in a containment path
				System.out.println("CODE PATH DISABLED TO ALLOW COMPILING OUTSIDE OF OSATE");
			//	return resolveFeatureGroupPrototype((Prototype)actual.getFeatureType(), getPrevious((ContainmentPathElement) context));
			}
		}
		return null;
	}
	
	public static ComponentClassifier resolveComponentPrototype(Prototype proto, Element context) {
		ComponentPrototypeBinding cpb = (ComponentPrototypeBinding) resolvePrototype(proto, context);

		if (cpb == null) {
			// cannot resolve
			return null;
		}
		EList<ComponentPrototypeActual> actuals = cpb.getActuals();

		if (actuals != null && actuals.size() > 0) {
			ComponentPrototypeActual actual = actuals.get(0);

			if (actual.getSubcomponentType() instanceof ComponentClassifier) {
				return (ComponentClassifier)actual.getSubcomponentType();
			} else {
				if (actual.getSubcomponentType() instanceof ComponentPrototype && context instanceof ContainmentPathElement){
				// resolve recursively if we are in a containment path
					System.out.println("CODE PATH DISABLED TO ALLOW COMPILING OUTSIDE OF OSATE");
					//return resolveComponentPrototype((Prototype)actual.getSubcomponentType(), getPrevious((ContainmentPathElement) context));
				}
			}
		}
		return null;
	}
}
