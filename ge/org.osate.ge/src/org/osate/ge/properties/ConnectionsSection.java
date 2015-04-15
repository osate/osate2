package org.osate.ge.properties;


import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.swt.widgets.Display;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.impl.CustomContext;
import org.eclipse.graphiti.features.context.impl.DirectEditingContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.osate.ge.diagrams.common.AadlElementWrapper;
import org.osate.ge.diagrams.common.features.ConfigureInModesFeature;
import org.osate.ge.diagrams.common.features.SwitchDirectionOfConnectionFeature;
import org.osate.ge.diagrams.componentImplementation.features.RefineConnectionFeature;
import org.osate.ge.diagrams.componentImplementation.features.RenameConnectionFeature;
import org.osate.ge.diagrams.componentImplementation.features.SetConnectionBidirectionalityFeature;
import org.osate.ge.services.AadlModificationService;
import org.osate.ge.services.BusinessObjectResolutionService;
import org.osate.ge.services.ShapeService;
import org.osate.ge.ui.editor.AgeDiagramEditor;
import org.osate.ge.ui.editor.SetBindingAction;

/**
 * Property section for changing a connection's properties.
 * @author ryan.mcilnay
 */

public class ConnectionsSection extends GFPropertySection implements ITabbedPropertyConstants {
	private Button switchDirectionPushButton;
	private Button unidirectionalRadioButton;
	private Button bidirectionalRadioButton;
	private Button bindPushButton;
	private Button configureInModesPushButton;
	private Button refinePushButton;

	private CLabel nameConnectionLabel;
	private CLabel optionsLabel;
	private CLabel directionLabel;
	private Text nameConnectionText;

	private RefineConnectionFeature refineConnectionFeature;
	private SetBindingAction setBindingAction;
	private ConfigureInModesFeature configureInModesFeature;
	private SwitchDirectionOfConnectionFeature switchDirectionOfConnectionFeature;
	private SetConnectionBidirectionalityFeature setConnectionBidirectionalityFeature;
	private RenameConnectionFeature renameConnectionFeature;

	private PictogramElement pe;
	final private CustomContext customCtx = new CustomContext();
	private DirectEditingContext directEditingCxt;

	private FormData formData;	
	private GridData gridData;

	private Composite composite;
	private Composite nameComposite;
	private Composite directionComposite;
	private Composite optionComposite;

	final private ArrayList<Composite> subComposites = new ArrayList<Composite>();

	private String oldConnectionName;
	private String newConnectionName;

	private boolean currentDirectionSelection;

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		final TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		composite = factory.createFlatFormComposite(parent);
		nameComposite = factory.createFlatFormComposite(composite);
		
		directionComposite = factory.createFlatFormComposite(composite);
		optionComposite = factory.createFlatFormComposite(composite);

		nameConnectionLabel = factory.createCLabel(nameComposite,  "Name:");
		gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.widthHint = 125;
		nameConnectionLabel.setLayoutData(gridData);
		
		directionLabel = factory.createCLabel(directionComposite,  "Direction:");
		optionsLabel = factory.createCLabel(optionComposite,  "Options:");		
		final ArrayList<CLabel> labels = new ArrayList<CLabel>();
		labels.add(nameConnectionLabel);
		labels.add(directionLabel);
		labels.add(optionsLabel);

		nameConnectionText = factory.createText(nameComposite, "");
		gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.widthHint = 600;
		nameConnectionText.setLayoutData(gridData);
		nameComposite.setLayout(new GridLayout(nameComposite.getChildren().length, false));
		
		formData = new FormData();
		formData.top = new FormAttachment(0,0);
		nameComposite.setLayoutData(formData);

		unidirectionalRadioButton = factory.createButton(directionComposite, "Unidirectional", SWT.RADIO);		
		bidirectionalRadioButton = factory.createButton(directionComposite, "Bidirectional", SWT.RADIO);
		final ArrayList<Button> directionButtons = new ArrayList<Button>();
		directionButtons.add(unidirectionalRadioButton);
		directionButtons.add(bidirectionalRadioButton);

		refinePushButton = factory.createButton(optionComposite, "Refine...", SWT.PUSH);       	
		bindPushButton = factory.createButton(optionComposite, "Bind...", SWT.PUSH);      
		configureInModesPushButton = factory.createButton(optionComposite, "Configure In Modes...", SWT.PUSH);       	
		switchDirectionPushButton = factory.createButton(optionComposite, "Switch Direction", SWT.PUSH);
		final ArrayList<Button> optionButtons = new ArrayList<Button>();
		optionButtons.add(refinePushButton);
		optionButtons.add(bindPushButton);
		optionButtons.add(configureInModesPushButton);
		optionButtons.add(switchDirectionPushButton);

		subComposites.add(directionComposite);
		subComposites.add(optionComposite);

		//Set the layout for each composite		
		for (Composite composite : subComposites) {
			composite.setLayout(new GridLayout(composite.getChildren().length, true));
			for (final Control control : composite.getChildren()) {
				gridData = new GridData();
				gridData.widthHint = 125;
				gridData.grabExcessHorizontalSpace = true;
				gridData.horizontalAlignment = SWT.FILL;
				control.setLayoutData(gridData);
			}
		}
		
		
		//Switch direction button
		switchDirectionPushButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {	
				getDiagramTypeProvider().getDiagramBehavior().getDiagramContainer().setPictogramElementForSelection(getSelectedPictogramElement());
				getDiagramTypeProvider().getDiagramBehavior().refresh();

				if ((switchDirectionOfConnectionFeature.isAvailable(customCtx)) && (switchDirectionOfConnectionFeature.canExecute(customCtx))) {
					getDiagramTypeProvider().getDiagramBehavior().executeFeature(switchDirectionOfConnectionFeature, customCtx);
					getDiagramTypeProvider().getDiagramBehavior().getDiagramContainer().setPictogramElementForSelection(getSelectedPictogramElement());
					getDiagramTypeProvider().getDiagramBehavior().refresh();
				} 
			}
		});

		//Refine button
		refinePushButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				if ((refineConnectionFeature.isAvailable(customCtx)) && (refineConnectionFeature.canExecute(customCtx))) {
					getDiagramTypeProvider().getDiagramBehavior().getDiagramContainer().setPictogramElementForSelection(getSelectedPictogramElement());
					getDiagramTypeProvider().getDiagramBehavior().executeFeature(refineConnectionFeature, customCtx);
					//Manual refresh to update options after refinement.
					refresh();
				}
			}       	
		});

		//Bind button
		bindPushButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {					
				if (setBindingAction.isEnabled()) {	
					getDiagramTypeProvider().getDiagramBehavior().getDiagramContainer().setPictogramElementForSelection(getSelectedPictogramElement());
					getDiagramTypeProvider().getDiagramBehavior().refresh();
					setBindingAction.run();
					getDiagramTypeProvider().getDiagramBehavior().getDiagramContainer().setPictogramElementForSelection(getSelectedPictogramElement());
					getDiagramTypeProvider().getDiagramBehavior().refresh();
				}
			}
		});

		//Configure in modes.. button
		configureInModesPushButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				if ((configureInModesFeature.isAvailable(customCtx)) && (configureInModesFeature.canExecute(customCtx))) {	
					getDiagramTypeProvider().getDiagramBehavior().getDiagramContainer().setPictogramElementForSelection(getSelectedPictogramElement());
					getDiagramTypeProvider().getDiagramBehavior().executeFeature(configureInModesFeature, customCtx);
				}
			}
		});

		//Directional controller
		unidirectionalRadioButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				if ((currentDirectionSelection != getDirectionalValue()) && (setConnectionBidirectionalityFeature.isAvailable(customCtx)) && (setConnectionBidirectionalityFeature.canExecute(customCtx))) {
					getDiagramTypeProvider().getDiagramBehavior().getDiagramContainer().setPictogramElementForSelection(getSelectedPictogramElement());
					getDiagramTypeProvider().getDiagramBehavior().executeFeature(setConnectionBidirectionalityFeature, customCtx);
					setConnectionBidirectionalityFeature = new SetConnectionBidirectionalityFeature(getAadlModificationService(), getShapeService(), getBusinessObjectResolutionService(), getFeatureProvider(), getDirectionalValue());
					currentDirectionSelection = getDirectionalValue();
				}			
			}
		});

		//Rename Connection on loss of focus
		nameConnectionText.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(final FocusEvent e) {		

				if((newConnectionName != null) && (pe != null) && (renameConnectionFeature.checkValueValid(newConnectionName, directEditingCxt) == null) && !(oldConnectionName.equals(newConnectionName))) {
					PictogramElement originalElement = getSelectedPictogramElement();
					renameConnectionFeature.setValue(newConnectionName, directEditingCxt);
					if (!composite.isDisposed()) {
						getDiagramContainer().setPictogramElementForSelection(originalElement);
						getDiagramContainer().getDiagramBehavior().refresh();
					}				
				}
			}

			@Override
			public void focusGained(final FocusEvent e) {
				oldConnectionName = nameConnectionText.getText();
			}
		});

		//Rename connection when enter is pressed.  Set color of textBox to white or red based on valid String.
		nameConnectionText.addKeyListener(new KeyListener() {		
			@Override
			public void keyPressed(final KeyEvent e) {				
				if((pe != null) && (renameConnectionFeature.checkValueValid(nameConnectionText.getText(), directEditingCxt) == null)) {	
					newConnectionName = nameConnectionText.getText();
					nameConnectionText.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));									
				} else { 
					nameConnectionText.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_RED));				
				}								
			}

			@Override
			public void keyReleased(final KeyEvent e) {
				switch(e.keyCode) {			
				case (SWT.CR):
				case (SWT.KEYPAD_CR):	
					if((nameConnectionText.getText() != null) && (pe != null) && (renameConnectionFeature.checkValueValid(newConnectionName, directEditingCxt) == null) && !(oldConnectionName.equals(nameConnectionText.getText()))) {
						PictogramElement originalPictogram = getSelectedPictogramElement();
						renameConnectionFeature.setValue(newConnectionName, directEditingCxt);					
						getDiagramTypeProvider().getDiagramBehavior().getDiagramContainer().setPictogramElementForSelection(originalPictogram);
						getDiagramTypeProvider().getDiagramBehavior().refresh();
					} break;
				default:
					newConnectionName = nameConnectionText.getText();
					if((pe != null) && (renameConnectionFeature.checkValueValid(nameConnectionText.getText(), directEditingCxt) == null)) {							
						nameConnectionText.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));						
					} else { 
						nameConnectionText.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_RED));						
					} break;						
				}
			}   
		});      
	}
	
	/**
	 * Determines which features are available and which controls and composites are shown.
	 */
	@Override
	public void refresh() {
		if(!composite.isDisposed()) {
			setAllFalse();
			pe = getSelectedPictogramElement();
			final AgeDiagramEditor editor = (AgeDiagramEditor)getPart();
			
			if ((pe != null) && (pe instanceof FreeFormConnection) && (editor != null)) {
				final Object bo = AadlElementWrapper.unwrap(getFeatureProvider().getBusinessObjectForPictogramElement(pe));
				if(bo != null) {
					final org.osate.aadl2.Connection aadlConnection = (org.osate.aadl2.Connection) bo;
					nameConnectionText.setText(aadlConnection.getName());
					directEditingCxt = new DirectEditingContext(pe, pe.getGraphicsAlgorithm());
					renameConnectionFeature = (RenameConnectionFeature) getFeatureProvider().getDirectEditingFeature(directEditingCxt);
					nameConnectionText.setEnabled(renameConnectionFeature.canDirectEdit(directEditingCxt));
					nameConnectionText.setEditable(renameConnectionFeature.canDirectEdit(directEditingCxt));
					final PictogramElement[] pes = new PictogramElement[1];
					pes[0] = pe;
					
					if ((pes[0] != null) && (pes[0] instanceof FreeFormConnection)) {
						customCtx.setPictogramElements(pes);
						final ICustomFeature[] customFeatures = getFeatureProvider().getCustomFeatures(customCtx);
						if (customFeatures != null && customCtx != null) {
							for (final ICustomFeature customFeature : customFeatures) {
								if (customFeature instanceof SetConnectionBidirectionalityFeature && customFeature.isAvailable(customCtx) && customFeature.canExecute(customCtx)) {
										setConnectionBidirectionalityFeature = (SetConnectionBidirectionalityFeature) customFeature;
										for (final Control control : directionComposite.getChildren()) {
											control.setVisible(true);
										}
										currentDirectionSelection = unidirectionalRadioButton.getSelection();
										setDirectionalRadioButtons(aadlConnection);
								}
								if (customFeature instanceof RefineConnectionFeature && customFeature.isAvailable(customCtx) && customFeature.canExecute(customCtx)) {
									refineConnectionFeature = (RefineConnectionFeature) customFeature;
									refinePushButton.setVisible(true);
								}
								if ((customFeature instanceof ConfigureInModesFeature) && (customFeature.isAvailable(customCtx)) && (customFeature.canExecute(customCtx))) {
									configureInModesFeature = (ConfigureInModesFeature) customFeature;	
									optionComposite.setVisible(true);
									configureInModesPushButton.setVisible(true);
								}
								if (customFeature instanceof SwitchDirectionOfConnectionFeature && customFeature.isAvailable(customCtx) && customFeature.canExecute(customCtx)) {
									switchDirectionOfConnectionFeature = (SwitchDirectionOfConnectionFeature) customFeature;
									switchDirectionPushButton.setVisible(true);
								}
							}
							
							for (Control c : optionComposite.getChildren()) {
								if (c.getVisible()) {
									optionsLabel.setVisible(true);		
								}
							}
							
							final Iterator<?> it = editor.getActionRegistry().getActions();
							while (it.hasNext()) {
								final Object o = it.next();
								if((o instanceof SetBindingAction) && (((SetBindingAction) o).isEnabled())) {
									setBindingAction = (SetBindingAction) o;
									bindPushButton.setVisible(true);
								}
							}							
							
							//Layout the composites so invisible composites do not take up space and exclude appropriate controls
							Composite visibleComposite  = nameComposite;
							for (final Composite composite : subComposites) {
								if (composite.getVisible()) {
									formData = new FormData();
									formData.top = new FormAttachment(visibleComposite, VSPACE);
									composite.setLayoutData(formData);
									for (final Control c : composite.getChildren()) {
										gridData = (GridData) c.getLayoutData();
										gridData.exclude = !c.getVisible();									
										c.setLayoutData(gridData);
									}
									composite.update();
									composite.layout();
									visibleComposite = composite;
								}
							}						
						}
					}
				}			
			}
		}
	}

	/**
	 * Set directional and option controls to false
	 */
	final private void setAllFalse() {
		nameConnectionText.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));	
		for (final Composite composite : subComposites) {
			for (final Control control : composite.getChildren()) {
				control.setVisible(false);
			}
		}
	}

	/**
	 * Set directional controls selection
	 * @param connection
	 */
	final private void setDirectionalRadioButtons(final org.osate.aadl2.Connection connection) {
		unidirectionalRadioButton.setSelection(!connection.isBidirectional());
		bidirectionalRadioButton.setSelection(connection.isBidirectional());
	}

	final private ShapeService getShapeService() {
		return (ShapeService) getPart().getAdapter(ShapeService.class);
	}

	final private BusinessObjectResolutionService getBusinessObjectResolutionService() {
		return (BusinessObjectResolutionService)getPart().getAdapter(BusinessObjectResolutionService.class);
	}

	final private AadlModificationService getAadlModificationService() {
		return (AadlModificationService) getPart().getAdapter(AadlModificationService.class);
	}

	final private IFeatureProvider getFeatureProvider() {
		return getDiagramTypeProvider().getFeatureProvider();
	}

	final private boolean getDirectionalValue() {
		return unidirectionalRadioButton.getSelection() ? true : false;
	}
}


