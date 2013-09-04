package edu.uah.rsesc.aadl.age.ui.editor;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorPart;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Element;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.NamedElement;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.diagrams.common.util.PropertyUtil;

public class FlowContributionItem extends ComboContributionItem {
	private AgeDiagramEditor editor = null;
	private final String selectedFlowPropertyKey = "edu.uah.rsesc.aadl.age.ui.editor.selectedFlow";
	
	public FlowContributionItem(String id) {
		super(id);
	}
	
	@Override
	public boolean isDynamic() {
		return true;
	}
	
	/*
	CLEAN-UP: Can use this instead of dispose listeners. How to update when flows change by editing the diagram?(Instead of switching editors)
	@Override
	public void update() {
		System.out.println("UP");
		super.update();
	}
	
	public void update(String id) {
		System.out.println("UP2");
		super.update(id);
	}
	*/
	public final void setActiveEditor(final IEditorPart newEditor) {
		if(editor != newEditor) {
			saveFlowSelection();

			// Update the editor
			if(getElementForEditor(newEditor) instanceof ComponentClassifier) {
				this.editor = (AgeDiagramEditor)newEditor;
			} else {
				this.editor = null;
			}
			
			refresh();
		}
	}
	
	@Override
	protected void onControlDisposed() {
		saveFlowSelection();
		super.onControlDisposed();
	}
	
	private void saveFlowSelection() {
		// Save the current flow selection
		final Combo cmb = this.getCombo();
		if(cmb != null) {
			if(this.editor != null) {
				final String selection = cmb.getText();
				editor.setPartProperty(selectedFlowPropertyKey, selection);
			}
		}
	}
	
	private static Element getElementForEditor(final IEditorPart part) {
		if(part instanceof AgeDiagramEditor) {
			final AgeDiagramEditor ed = (AgeDiagramEditor)part;
			final IFeatureProvider fp = ed.getDiagramTypeProvider().getFeatureProvider();
			final NamedElement element = (NamedElement)AadlElementWrapper.unwrap(fp.getBusinessObjectForPictogramElement(ed.getDiagramTypeProvider().getDiagram()));
			return element;
		}
		
		return null;
	}
	/**
	 * Get the top-level component classifier from the editor
	 * @return
	 */
	private ComponentImplementation getComponentImplementation() {
		if(editor != null) {
			// Get the AADL Element at the top level of the diagram
			final Diagram diagram = editor.getDiagramTypeProvider().getDiagram();
			final IFeatureProvider fp = editor.getDiagramTypeProvider().getFeatureProvider();
			final NamedElement element = (NamedElement)AadlElementWrapper.unwrap(fp.getBusinessObjectForPictogramElement(diagram));
			if(element instanceof ComponentImplementation) {
				return (ComponentImplementation)element;
			}
		}
		
		return null;
	}	
	
	protected Control createControl(final Composite parent) {
		final Control control = super.createControl(parent);
		refresh(); // Populate the combo box
		return control;
	}
	
	private void refresh() {
		final Combo combo = getCombo();
		if(combo != null) {
			String selectedFlowName = (editor == null) ? null : editor.getPartProperty(selectedFlowPropertyKey);			
			// Clear the combo box			
			combo.removeAll();

			String selectionTxt = "";
			final ComponentImplementation componentImplementation = getComponentImplementation();
			if(componentImplementation != null) {
				combo.add("");
				
				// Add Flow Implementations
				for(final FlowImplementation flow : componentImplementation.getAllFlowImplementations()) {
					if(flow.getSpecification() != null && flow.getSpecification().getName() != null) {
						final String name = flow.getSpecification().getName();
						combo.add(name);

						if(name.equalsIgnoreCase(selectedFlowName)) {
							selectionTxt = name;
						}
					}
				}
				
				// Add End to End Flows
				for(final EndToEndFlow flow : componentImplementation.getAllEndToEndFlows()) {
					final String name = flow.getName();
					if(name != null) {
						combo.add(name);
						if(name.equalsIgnoreCase(selectedFlowName)) {
							selectionTxt = name;
						}
					}
				}
			}			
			
			// Set the selection
			combo.setText(selectionTxt);
			onSelection(selectionTxt);
		}
	}
	
	@Override
	protected void onSelection(final String txt) {
		final ComponentClassifier cc = getComponentImplementation();
		if(cc != null) {	
			if(!txt.equalsIgnoreCase(PropertyUtil.getSelectedFlow(editor.getDiagramTypeProvider().getDiagram()))) {
				// Set the selected flow property on the diagram
				editor.getEditingDomain().getCommandStack().execute(new RecordingCommand(editor.getEditingDomain()) {
					@Override
					protected void doExecute() {
						PropertyUtil.setSelectedFlow(editor.getDiagramTypeProvider().getDiagram(), txt);
					}				
				});
			
				// Update the diagram
				final UpdateContext ctx = new UpdateContext(editor.getDiagramTypeProvider().getDiagram());
				final IUpdateFeature feature = editor.getDiagramTypeProvider().getFeatureProvider().getUpdateFeature(ctx);
				if(feature != null && feature.canUpdate(ctx)) {
					editor.getDiagramBehavior().executeFeature(feature, ctx);
				}
			}
		}
	}
}
