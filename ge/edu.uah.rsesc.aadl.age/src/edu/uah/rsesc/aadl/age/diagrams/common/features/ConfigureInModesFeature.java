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
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Display;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeBinding;
import org.osate.aadl2.Subcomponent;

import edu.uah.rsesc.aadl.age.dialogs.SetInModesDialog;
import edu.uah.rsesc.aadl.age.services.AadlModificationService;
import edu.uah.rsesc.aadl.age.services.BusinessObjectResolutionService;
import edu.uah.rsesc.aadl.age.services.AadlModificationService.AbstractModifier;

public class ConfigureInModesFeature extends AbstractCustomFeature {
	private final AadlModificationService aadlModService;
	private final BusinessObjectResolutionService bor;
	
	@Inject
	public ConfigureInModesFeature(final AadlModificationService aadlModService, final BusinessObjectResolutionService bor, final IFeatureProvider fp) {
		super(fp);
		this.aadlModService = aadlModService;
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
		if(customCtx.getPictogramElements().length < 1 && customCtx.getPictogramElements()[0] instanceof Shape) {
			return false;
		}
		
		// Check that the pictogram represents a modal element and that the modal element is owned by the classifier represented by the shape's container
		final PictogramElement pe = pes[0];		
		final Object bo = bor.getBusinessObjectForPictogramElement(pe);
		final Object containerBo = bor.getBusinessObjectForPictogramElement(((Shape)pe).getContainer());
		return bo instanceof Subcomponent && ((ModalElement)bo).getContainingClassifier() == containerBo && ((ModalElement)bo).getContainingClassifier() instanceof ComponentClassifier;
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
		final List<Mode> localModes = ((ComponentClassifier)me.getContainingClassifier()).getAllModes();
		final List<String> localModeNames = new ArrayList<String>();
		for(final Mode tmpMode : localModes) {
			localModeNames.add(tmpMode.getName());
		}
		
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
		} else {
			throw new RuntimeException("Unsupported type: " + me.getClass());
		}
		
		// Show the dialog
		final SetInModesDialog dlg = new SetInModesDialog(Display.getCurrent().getActiveShell(), localModeNames, childModeNames, localToChildModeMap);
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
						final Mode localMode = findModeByName(localModes, localToChildModeMapEntry.getKey());
						final Mode childMode = (childModes != null && localToChildModeMapEntry.getValue() != null) ? findModeByName(childModes, localToChildModeMapEntry.getValue()) : null;
						final ModeBinding newModeBinding = sc.createOwnedModeBinding();
						newModeBinding.setParentMode(localMode);
						newModeBinding.setDerivedMode(childMode);
					}
				} else {
					throw new RuntimeException("Unsupported type: " + me.getClass());
				}
				
				return null;
			}			
		});
	}
	
	private Mode findModeByName(final List<Mode> modes, final String name) {
		for(final Mode tmpMode : modes) {
			if(name.equalsIgnoreCase(tmpMode.getName())) {
				return tmpMode;
			}
		}
		
		return null;
	}
}
