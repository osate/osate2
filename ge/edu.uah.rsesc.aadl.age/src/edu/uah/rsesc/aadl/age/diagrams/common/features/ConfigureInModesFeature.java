package edu.uah.rsesc.aadl.age.diagrams.common.features;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Inject;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Display;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeBinding;
import org.osate.aadl2.ModeFeature;
import org.osate.aadl2.Subcomponent;

import edu.uah.rsesc.aadl.age.dialogs.SetInModeFeaturesDialog;
import edu.uah.rsesc.aadl.age.services.AadlModificationService;
import edu.uah.rsesc.aadl.age.services.BusinessObjectResolutionService;
import edu.uah.rsesc.aadl.age.services.ShapeService;
import edu.uah.rsesc.aadl.age.services.AadlModificationService.AbstractModifier;

/**
 * Feature for configuring the mode/mode transitions in which an element is contained. Currently supports subcomponents and connections.
 * @author philip.alldredge
 *
 */
public class ConfigureInModesFeature extends AbstractCustomFeature {
	private final AadlModificationService aadlModService;
	private final BusinessObjectResolutionService bor;
	private final ShapeService shapeService;
	
	@Inject
	public ConfigureInModesFeature(final AadlModificationService aadlModService, final ShapeService shapeService, final BusinessObjectResolutionService bor, final IFeatureProvider fp) {
		super(fp);
		this.aadlModService = aadlModService;
		this.shapeService = shapeService;
		this.bor = bor;
	}
	
	@Override
    public String getName() {
        return "Configure In Modes...";
    }
	
	@Override
	public boolean canUndo(final IContext context) {
		return false;
	}
	
    @Override
	public boolean isAvailable(final IContext context) {
		final ICustomContext customCtx = (ICustomContext)context;
		final PictogramElement[] pes = customCtx.getPictogramElements();		
		if(customCtx.getPictogramElements().length < 1) {
			return false;
		}
		
		final PictogramElement pe = pes[0];
		if(!(pe instanceof Shape || pe instanceof Connection)) {
			return false;
		}
		
		// Check that the pictogram represents a modal element and that the modal element is owned by the classifier represented by the shape's container				
		final Object bo = bor.getBusinessObjectForPictogramElement(pe);
		final Object containerBo;
		if(pe instanceof Shape) {
			containerBo = bor.getBusinessObjectForPictogramElement(((Shape)pe).getContainer());
		} else if(pe instanceof Connection) {
			final AnchorContainer startContainer = ((Connection)pe).getStart().getParent();
			if(!(startContainer instanceof Shape)) {
				return false;
			}
			
			containerBo = getComponentImplementation((Shape)startContainer);
		} else {
			return false;
		}
		
		return (bo instanceof Subcomponent || bo instanceof org.osate.aadl2.Connection) && 
				((ModalElement)bo).getContainingClassifier() == containerBo && ((ModalElement)bo).getContainingClassifier() instanceof ComponentClassifier;
	}
    
	/**
	 * Returns the first component implementation associated with the specified or a containing shape.
	 * @param shape
	 * @return
	 */
	private ComponentImplementation getComponentImplementation(final Shape shape) {
		return shapeService.getClosestBusinessObjectOfType(shape, ComponentImplementation.class);
	}
    
    @Override
    public boolean canExecute(final ICustomContext context) {
    	return true;
    }
        
	@Override
	public void execute(final ICustomContext context) {
		final PictogramElement pe = (PictogramElement)context.getPictogramElements()[0];
		final ModalElement me = (ModalElement)bor.getBusinessObjectForPictogramElement(pe);
		
		// Build a list of all modes in the containing classifier
		final ComponentClassifier cc = (ComponentClassifier)me.getContainingClassifier();
		final List<ModeFeature> localModeFeatures = new ArrayList<ModeFeature>(cc.getAllModes());
		
		final List<Mode> childModes;
		final List<String> childModeNames;
		final Map<String, String> localToChildModeMap = new HashMap<String, String>();
		if(me instanceof Subcomponent) {
			final Subcomponent sc = (Subcomponent)me;
			
			// Build the child mode names from the subcomponents required modes
			childModeNames = new ArrayList<String>();
			if(sc.getComponentType() == null) {
				childModes = null;
			} else {			
				childModes = sc.getComponentType().getAllModes();
				for(final Mode childMode : childModes) {
					if(childMode.isDerived()) {
						childModeNames.add(childMode.getName());
					}
				}
			}
			
			// Build the local to child mode map from the mode bindings
			for(final ModeBinding modeBinding : sc.getOwnedModeBindings()) {
				final String localModeName = modeBinding.getParentMode().getName();
				final String childModeName = modeBinding.getDerivedMode() == null ? null : modeBinding.getDerivedMode().getName();
				localToChildModeMap.put(localModeName, childModeName);
			}
		} else if(me instanceof org.osate.aadl2.Connection) {
			localModeFeatures.addAll(cc.getAllModeTransitions());
			childModes = null;
			childModeNames = null;
			
			final org.osate.aadl2.Connection aadlConnection = (org.osate.aadl2.Connection)me;
			for(final ModeFeature mf : aadlConnection.getInModeOrTransitions()) {
				localToChildModeMap.put(mf.getName(), null);
			}			
		} else {
			throw new RuntimeException("Unsupported type: " + me.getClass());
		}
		
		final List<String> localModeFeatureNames = new ArrayList<String>();
		for(final ModeFeature tmpMode : localModeFeatures) {
			localModeFeatureNames.add(tmpMode.getName());
		}
		
		// Show the dialog
		final SetInModeFeaturesDialog dlg = new SetInModeFeaturesDialog(Display.getCurrent().getActiveShell(), localModeFeatureNames, childModeNames, localToChildModeMap);
		if(dlg.open() == Dialog.CANCEL) {
			return;
		}
		
		// Make the modification to the mode
		aadlModService.modify(me, new AbstractModifier<ModalElement, Object>() {
			@Override
			public Object modify(final Resource resource, final ModalElement me) {
				if(me instanceof Subcomponent) {
					final Subcomponent sc = (Subcomponent)me;
					sc.getOwnedModeBindings().clear();
					for(final Entry<String, String> localToChildModeMapEntry : dlg.getLocalToChildModeMap().entrySet()) {
						final ModeFeature localMode = findModeByName(localModeFeatures, localToChildModeMapEntry.getKey());
						final ModeFeature childMode = (childModes != null && localToChildModeMapEntry.getValue() != null) ? findModeByName(childModes, localToChildModeMapEntry.getValue()) : null;
						final ModeBinding newModeBinding = sc.createOwnedModeBinding();
						newModeBinding.setParentMode((Mode)localMode);
						newModeBinding.setDerivedMode((Mode)childMode);
					}
				} else if(me instanceof org.osate.aadl2.Connection) {
					final org.osate.aadl2.Connection aadlConnection = (org.osate.aadl2.Connection)me;
					aadlConnection.getInModeOrTransitions().clear();
					for(final Entry<String, String> localToChildModeMapEntry : dlg.getLocalToChildModeMap().entrySet()) {
						final ModeFeature localMode = findModeByName(localModeFeatures, localToChildModeMapEntry.getKey());
						if(localMode != null) {
							aadlConnection.getInModeOrTransitions().add(localMode);
						}
					}
				} else {
					throw new RuntimeException("Unsupported type: " + me.getClass());
				}
				
				return null;
			}			
		});
	}
	
	private ModeFeature findModeByName(final List<? extends ModeFeature> modeFeatures, final String name) {
		for(final ModeFeature tmpModeFeature : modeFeatures) {
			if(name.equalsIgnoreCase(tmpModeFeature.getName())) {
				return tmpModeFeature;
			}
		}
		
		return null;
	}
}
