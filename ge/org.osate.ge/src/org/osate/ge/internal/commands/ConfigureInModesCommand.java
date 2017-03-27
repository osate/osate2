package org.osate.ge.internal.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Named;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Display;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Connection;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.ModalPath;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeBinding;
import org.osate.aadl2.ModeFeature;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.di.Activate;
import org.osate.ge.di.GetLabel;
import org.osate.ge.di.IsAvailable;
import org.osate.ge.di.Names;
import org.osate.ge.internal.DiagramElement;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.di.ModifiesBusinessObjects;
import org.osate.ge.internal.query.StandaloneDiagramElementQuery;
import org.osate.ge.internal.services.QueryService;
import org.osate.ge.internal.ui.dialogs.SetInModeFeaturesDialog;

@ModifiesBusinessObjects
public class ConfigureInModesCommand {
	private static final StandaloneDiagramElementQuery parentQuery = StandaloneDiagramElementQuery.create((root) -> root.ancestor(1));

	@GetLabel
	public String getLabel() {
		return "Configure In Modes...";
	}

	@IsAvailable
	public boolean isAvailable(@Named(Names.BUSINESS_OBJECT) final ModalElement modalElement,
			@Named(InternalNames.DIAGRAM_ELEMENT_PROXY) final DiagramElement diagramElement,
			final QueryService queryService) {
		final Object diagram = queryService.getFirstBusinessObject(parentQuery, diagramElement);
		return (modalElement instanceof Subcomponent || modalElement instanceof Connection || modalElement instanceof FlowSpecification) && 
				modalElement.getContainingClassifier() instanceof ComponentClassifier && modalElement.getContainingClassifier() == diagram;
	}

	@Activate
	public boolean activate(@Named(Names.BUSINESS_OBJECT) final ModalElement modalElement) {
		// Build a list of all modes in the containing classifier
		final ComponentClassifier cc = (ComponentClassifier)modalElement.getContainingClassifier();
		final List<ModeFeature> localModeFeatures = new ArrayList<ModeFeature>(cc.getAllModes());

		final List<Mode> childModes;
		final List<String> childModeNames;
		final Map<String, String> localToChildModeMap = new HashMap<String, String>();
		if(modalElement instanceof Subcomponent) {
			final Subcomponent sc = (Subcomponent)modalElement;

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
		} else if(modalElement instanceof org.osate.aadl2.Connection || modalElement instanceof FlowSpecification) {
			localModeFeatures.addAll(cc.getAllModeTransitions());
			childModes = null;
			childModeNames = null;

			final ModalPath modalPath = (ModalPath)modalElement;
			for(final ModeFeature mf : modalPath.getInModeOrTransitions()) {
				localToChildModeMap.put(mf.getName(), null);
			}
		} else {
			throw new RuntimeException("Unsupported type: " + modalElement.getClass());
		}

		//Sort mode and transition names for dialog menu
		final List<String> localModeFeatureNames = new ArrayList<String>();
		final List<String> localModeTransitionFeatureNames = new ArrayList<String>();
		for(final ModeFeature tmpMode : localModeFeatures) {
			if (tmpMode instanceof Mode){
				localModeFeatureNames.add(tmpMode.getName());
			} else {
				if(tmpMode instanceof ModeTransition){
					localModeTransitionFeatureNames.add(tmpMode.getName());
				}
			}
		}

		// Show the dialog
		final SetInModeFeaturesDialog dlg = new SetInModeFeaturesDialog(Display.getCurrent().getActiveShell(), localModeFeatureNames, localModeTransitionFeatureNames, childModeNames, localToChildModeMap);
		if(dlg.open() == Dialog.CANCEL) {
			return false;
		}
		
		if(modalElement instanceof Subcomponent) {
			final Subcomponent sc = (Subcomponent)modalElement;
			sc.getOwnedModeBindings().clear();
			for(final Entry<String, String> localToChildModeMapEntry : dlg.getLocalToChildModeMap().entrySet()) {
				final ModeFeature localMode = findModeByName(localModeFeatures, localToChildModeMapEntry.getKey());
				final ModeFeature childMode = (childModes != null && localToChildModeMapEntry.getValue() != null) ? findModeByName(childModes, localToChildModeMapEntry.getValue()) : null;
				final ModeBinding newModeBinding = sc.createOwnedModeBinding();
				newModeBinding.setParentMode((Mode)localMode);
				newModeBinding.setDerivedMode((Mode)childMode);
			}
		} else if(modalElement instanceof Connection || modalElement instanceof FlowSpecification) {
			final ModalPath mp = (ModalPath)modalElement;
			mp.getInModeOrTransitions().clear();
			for(final Entry<String, String> localToChildModeMapEntry : dlg.getLocalToChildModeMap().entrySet()) {
				final ModeFeature localMode = findModeByName(localModeFeatures, localToChildModeMapEntry.getKey());
				if(localMode != null) {
					mp.getInModeOrTransitions().add(localMode);
				}
			}
		} else {
			throw new RuntimeException("Unsupported type: " + modalElement.getClass());
		}

		return true;
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
