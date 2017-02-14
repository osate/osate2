/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal.ui.properties;

import java.util.ArrayList;

import org.eclipse.swt.widgets.Display;
import org.eclipse.graphiti.features.IDirectEditingFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.impl.CustomContext;
import org.eclipse.graphiti.features.context.impl.DirectEditingContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.jface.action.IAction;
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
import org.osate.aadl2.Connection;
import org.osate.ge.internal.AadlElementWrapper;
import org.osate.ge.internal.features.ConfigureInModesFeature;
import org.osate.ge.internal.features.RefineConnectionFeature;
import org.osate.ge.internal.features.SetConnectionBidirectionalityFeature;
import org.osate.ge.internal.features.SwitchDirectionOfConnectionFeature;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ShapeService;
import org.osate.ge.internal.services.UiService;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;
import org.osate.ge.internal.ui.tools.SetBindingTool;

/**
 * Property section for changing a connection's properties.
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
	private ConfigureInModesFeature configureInModesFeature;
	private SwitchDirectionOfConnectionFeature switchDirectionOfConnectionFeature;
	private SetConnectionBidirectionalityFeature setConnectionBidirectionalityFeature;
	private IDirectEditingFeature renameConnectionFeature;
	private IAction setBindingTool;

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

	private AgeDiagramEditor editor;

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
		for (final Composite composite : subComposites) {
			composite.setLayout(new GridLayout(composite.getChildren().length, true));
			formData = new FormData();
			composite.setLayoutData(formData);
			for (final Control control : composite.getChildren()) {
				gridData = new GridData();
				gridData.widthHint = 125;
				control.setLayoutData(gridData);
			}
		}


		//Switch direction button
		switchDirectionPushButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				if (featureValidation(switchDirectionOfConnectionFeature)) {
					getDiagramTypeProvider().getDiagramBehavior().executeFeature(switchDirectionOfConnectionFeature, customCtx);
					determineFocus(customCtx.getPictogramElements()[0], editor);
				} else {
					editor.setFocus();
				}
			}
		});

		//Refine button
		refinePushButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				if (featureValidation(refineConnectionFeature)) {
					getDiagramTypeProvider().getDiagramBehavior().executeFeature(refineConnectionFeature, customCtx);
					determineFocus(customCtx.getPictogramElements()[0], editor);
					refresh();
				} else {
					editor.setFocus();
				}
			}       	
		});

		//Bind button
		bindPushButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				if ((customCtx.getPictogramElements()[0].isVisible()) && (setBindingTool.isEnabled())) {
					setBindingTool.run();
					editor.setFocus();
				}
			} 
		});

		//Configure in modes.. button
		configureInModesPushButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				if (featureValidation(configureInModesFeature)) {
					getDiagramTypeProvider().getDiagramBehavior().executeFeature(configureInModesFeature, customCtx);
					determineFocus(customCtx.getPictogramElements()[0], editor);
				} else {
					editor.setFocus();
				}
			}
		});

		//Directional controller
		unidirectionalRadioButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {					
				if (featureValidation(setConnectionBidirectionalityFeature)) {	
					getDiagramTypeProvider().getDiagramBehavior().executeFeature(setConnectionBidirectionalityFeature, customCtx);
					setConnectionBidirectionalityFeature = new SetConnectionBidirectionalityFeature(getAadlModificationService(), getShapeService(),
							getBusinessObjectResolutionService(), getFeatureProvider(), getDirectionalValue());
					determineFocus(customCtx.getPictogramElements()[0], editor);
				} else {
					editor.setFocus();
				}
			}
		});

		//Rename Connection on loss of focus
		nameConnectionText.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(final FocusEvent e) {
				if((customCtx.getPictogramElements()[0].isVisible()) && (newConnectionName != null) && (pe != null) 
						&& (renameConnectionFeature.checkValueValid(newConnectionName, directEditingCxt) == null) && !(oldConnectionName.equals(newConnectionName))) {	
					renameConnectionFeature.setValue(newConnectionName, directEditingCxt);
					if (!composite.isDisposed()) {
						determineFocus(customCtx.getPictogramElements()[0], editor);
					} else {
						getDiagramContainer().setPictogramElementForSelection(customCtx.getPictogramElements()[0]);
						getDiagramContainer().getDiagramBehavior().refresh();
					}
				} else {
					editor.setFocus();
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
				if (customCtx.getPictogramElements()[0].isVisible()) {
					if((pe != null) && (renameConnectionFeature.checkValueValid(nameConnectionText.getText(), directEditingCxt) == null)) {	
						newConnectionName = nameConnectionText.getText();
						nameConnectionText.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));									
					} else {
						nameConnectionText.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_RED));	
					}
				} else {
					editor.setFocus();
				}
			}

			@Override
			public void keyReleased(final KeyEvent e) {
				switch(e.keyCode) {			
				case (SWT.CR):
				case (SWT.KEYPAD_CR):					
					if((nameConnectionText.getText() != null) && (pe != null) && (renameConnectionFeature.checkValueValid(newConnectionName, directEditingCxt) == null) && 
							!(oldConnectionName.equals(nameConnectionText.getText()))) {
						renameConnectionFeature.setValue(newConnectionName, directEditingCxt);
						determineFocus(customCtx.getPictogramElements()[0], editor);
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

			pe  = getDiagramContainer().getSelectedPictogramElements()[0];
			editor = (AgeDiagramEditor)getPart();
			if ((pe != null) && (pe instanceof FreeFormConnection) && (editor != null)) {
				final org.osate.aadl2.Connection aadlConnection = ((Connection)((Object) AadlElementWrapper.unwrap(getFeatureProvider().getBusinessObjectForPictogramElement(pe))));
				nameConnectionText.setText(aadlConnection.getName());
				directEditingCxt = new DirectEditingContext(pe, pe.getGraphicsAlgorithm());
				renameConnectionFeature = getFeatureProvider().getDirectEditingFeature(directEditingCxt);
				nameConnectionText.setEnabled(renameConnectionFeature.canDirectEdit(directEditingCxt));
				nameConnectionText.setEditable(renameConnectionFeature.canDirectEdit(directEditingCxt));
				final PictogramElement[] pes = new PictogramElement[1];
				pes[0] = pe;

				if ((pes[0] != null) && (pes[0] instanceof FreeFormConnection)) {
					customCtx.setPictogramElements(pes);
					final ICustomFeature[] customFeatures = getFeatureProvider().getCustomFeatures(customCtx);
					if (customFeatures != null && customCtx != null) {
						for (final ICustomFeature customFeature : customFeatures) {
							if (customFeature instanceof SetConnectionBidirectionalityFeature && featureValidation((SetConnectionBidirectionalityFeature)customFeature)) {	
								setConnectionBidirectionalityFeature = (SetConnectionBidirectionalityFeature)customFeature;
								for (final Control control : directionComposite.getChildren()) {
									control.setVisible(true);
								}
								setDirectionalRadioButtons(aadlConnection);
								directionComposite.setVisible(true);
							}
							if (customFeature instanceof RefineConnectionFeature && featureValidation((RefineConnectionFeature)customFeature)) {
								refineConnectionFeature = (RefineConnectionFeature)customFeature;
								refinePushButton.setVisible(true);
							}
							if (customFeature instanceof ConfigureInModesFeature && featureValidation((ConfigureInModesFeature)customFeature)) {
								configureInModesFeature = (ConfigureInModesFeature)customFeature;	
								optionComposite.setVisible(true);
								configureInModesPushButton.setVisible(true);
							}
							if (customFeature instanceof SwitchDirectionOfConnectionFeature && featureValidation((SwitchDirectionOfConnectionFeature)customFeature)) {
								switchDirectionOfConnectionFeature = (SwitchDirectionOfConnectionFeature)customFeature;
								switchDirectionPushButton.setVisible(true);
							}
						}
						
						setBindingTool = getUiService().getActivateToolAction(SetBindingTool.ID);
						if(setBindingTool.isEnabled()) {
							bindPushButton.setVisible(true);
						}

						for (final Control c : optionComposite.getChildren()) {
							if (c.getVisible()) {
								optionComposite.setVisible(true);
								optionsLabel.setVisible(true);		
							}
						}

						//Layout the composites so invisible composites do not take up space and exclude appropriate controls from layout
						Composite visibleComposite = nameComposite;
						final ArrayList<Composite> notVisibleComposites = new ArrayList<Composite>();
						for (final Composite subComposite : subComposites) {					
							if (subComposite.getVisible()) {
								formData = (FormData) subComposite.getLayoutData();
								formData.top = new FormAttachment(visibleComposite, VSPACE);
								subComposite.setLayoutData(formData);
								for (final Control c : subComposite.getChildren()) {
									gridData = (GridData) c.getLayoutData();
									gridData.exclude = !c.getVisible();									
									c.setLayoutData(gridData);
								}
								visibleComposite = subComposite;
							} else {
								notVisibleComposites.add(subComposite);
							}
							subComposite.layout(true);
						}

						/**
						 *  Add space for other composites possible, so composite keeps the same size
						 *	fixes bug where subcomposites gets cut out of parent composite on refresh
						 */
						for (final Composite composite : notVisibleComposites) {
							formData = (FormData) composite.getLayoutData();
							formData.top = new FormAttachment(visibleComposite, VSPACE);
							visibleComposite = composite;
							composite.setLayoutData(formData);
						}
						composite.layout(true);
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
			composite.setVisible(false);
			for (final Control control : composite.getChildren()) {
				control.setVisible(false);
			}
		}
	}

	/**
	 * Determine if focus can be kept on the connection modified or set focus to editor
	 * @param originalElement
	 * @param editor
	 */
	final private void determineFocus(PictogramElement originalElement, AgeDiagramEditor editor) {
		if (originalElement.isVisible()) {
			getDiagramContainer().setPictogramElementForSelection(customCtx.getPictogramElements()[0]);
			getDiagramContainer().getDiagramBehavior().refresh();
		} else {
			editor.setFocus();
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
		return (BusinessObjectResolutionService) getPart().getAdapter(BusinessObjectResolutionService.class);
	}

	final private AadlModificationService getAadlModificationService() {
		return (AadlModificationService) getPart().getAdapter(AadlModificationService.class);
	}

	final private UiService getUiService() {
		return (UiService) getPart().getAdapter(UiService.class);
	}

	final private IFeatureProvider getFeatureProvider() {
		return getDiagramTypeProvider().getFeatureProvider();
	}

	final private boolean getDirectionalValue() {
		return unidirectionalRadioButton.getSelection() ? true : false;
	}

	final private boolean featureValidation(ICustomFeature customFeature) {
		return (customCtx.getPictogramElements()[0].isVisible()) && (customFeature.canExecute(customCtx)) && (customFeature.isAvailable(customCtx));
	}
}


