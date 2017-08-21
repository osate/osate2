package org.osate.ge.internal.views;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.osate.aadl2.Connection;
import org.osate.aadl2.Flow;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.ModeTransitionTrigger;
import org.osate.aadl2.Realization;
import org.osate.ge.internal.Activator;
import org.osate.ge.internal.Style;
import org.osate.ge.internal.Style.FontSize;
import org.osate.ge.internal.Style.LineWidth;
import org.osate.ge.internal.di.Icon;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramLayoutUtil;
import org.osate.ge.internal.diagram.runtime.DiagramModification;
import org.osate.ge.internal.diagram.runtime.DiagramModifier;
import org.osate.ge.internal.graphics.Label;
import org.osate.ge.internal.services.UiService;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;

public class Appearance extends AbstractPropertySection {
	@Icon
	public final static ImageDescriptor OutlineIcon = Activator.getImageDescriptor("icons/Outline.gif");

	@Icon
	public final static ImageDescriptor BackgroundIcon = Activator.getImageDescriptor("icons/Background.gif");

	@Icon
	public final static ImageDescriptor FontColorIcon = Activator.getImageDescriptor("icons/FontColor.gif");

	private List<DiagramElement> diagramElements = new ArrayList<>();
	private StylePaintListener backgroundPaintListener;
	private StylePaintListener fontColorPaintListener;
	private StylePaintListener outlinePaintListener;
	private org.eclipse.swt.widgets.Label fontSizeLabel;
	private org.eclipse.swt.widgets.Label lineWidthLabel;
	private AgeDiagramEditor ageDiagramEditor;
	private ComboViewer fontSizeComboViewer;
	private ComboViewer lineWidthComboViewer;
	private Group colorsAndFontsGroup;
	public static final Point ICON_SIZE = new Point(18, 18);

	private static class PresetColor extends ImageDescriptor {
		private Color color;
		private Image image;

		private PresetColor(final RGB rgb) {
			this.color = new Color(Display.getDefault(), rgb);
			this.image = createImage();
		}

		public void setColor(final RGB rgb) {
			this.color = new Color(Display.getDefault(), rgb);
			this.image = createImage();
		}

		@Override
		public Image createImage() {
			final Device device = Display.getCurrent();
			ImageData data = getImageData();
			if(data == null) {
				data = DEFAULT_IMAGE_DATA;
			}

			try {
				if(data.transparentPixel >= 0) {
					final ImageData maskData = data.getTransparencyMask();
					return new Image(device, data, maskData);
				}
				return new Image(device, data);
			} catch(final SWTException exception) {
				try{
					return new Image(device, DEFAULT_IMAGE_DATA);
				} catch (final SWTException nextException) {
					return null;
				}
			}
		}

		@Override
		public ImageData getImageData() {
			final ImageData data = new ImageData(ICON_SIZE.x, ICON_SIZE.y, 1, new PaletteData(new RGB[] { color.getRGB() } ));

			for(int i = 0; i < ICON_SIZE.y; i++) {
				data.setPixel(0, i, 1);
			}

			for(int i = 0; i < ICON_SIZE.y; i++) {
				data.setPixel(ICON_SIZE.x - 1, i, 1);
			}

			for(int i = 0; i < ICON_SIZE.x; i++) {
				data.setPixel(i, 0, 1);
			}

			for(int i = 0; i < ICON_SIZE.x; i++) {
				data.setPixel(i, ICON_SIZE.y - 1, 1);
			}

			return data;
		}
	}
	Composite containerComposite;

	// Red Column
	private final PresetColor lighterRed = new PresetColor(new RGB(255,204,204));
	private final PresetColor lightRed = new PresetColor(new RGB(255,102,102));
	private final PresetColor red = new PresetColor(new RGB(255,0,0));
	private final PresetColor darkRed = new PresetColor(new RGB(153,0,0));

	// Orange Column
	private final PresetColor lighterOrange = new PresetColor(new RGB(255,229,204));
	private final PresetColor lightOrange = new PresetColor(new RGB(255,178,102));
	private final PresetColor orange = new PresetColor(new RGB(255,128,0));
	private final PresetColor darkOrange = new PresetColor(new RGB(153,76,0));

	// Blue Column
	private final PresetColor lighterBlue = new PresetColor(new RGB(204,204,255));
	private final PresetColor lightBlue = new PresetColor(new RGB(102,102,255));
	private final PresetColor blue = new PresetColor(new RGB(0,0,255));
	private final PresetColor darkBlue = new PresetColor(new RGB(0,0,153));

	// Yellow Column
	private final PresetColor lighterYellow = new PresetColor(new RGB(255,255,204));
	private final PresetColor lightYellow = new PresetColor(new RGB(255,255,102));
	private final PresetColor yellow = new PresetColor(new RGB(255,255,0));
	private final PresetColor darkYellow = new PresetColor(new RGB(153,153,0));

	// Green Column
	private final PresetColor lighterGreen = new PresetColor(new RGB(204,255,204));
	private final PresetColor lightGreen = new PresetColor(new RGB(102,255,102));
	private final PresetColor green = new PresetColor(new RGB(0,255,0));
	private final PresetColor darkGreen = new PresetColor(new RGB(0,153,0));

	// Shade Column
	private final PresetColor white = new PresetColor(new RGB(255,255,255));
	private final PresetColor lightGray = new PresetColor(new RGB(224,224,224));
	private final PresetColor gray = new PresetColor(new RGB(160,160,160));
	private final PresetColor black = new PresetColor(new RGB(0,0,0));

	final List<PresetColor> colors = new ArrayList<>();
	{
		// Lighter Colors
		colors.add(lighterRed);
		colors.add(lighterBlue);
		colors.add(lighterOrange);
		colors.add(lighterYellow);
		colors.add(lighterGreen);
		colors.add(white);

		// Light Colors
		colors.add(lightRed);
		colors.add(lightBlue);
		colors.add(lightOrange);
		colors.add(lightYellow);
		colors.add(lightGreen);
		colors.add(lightGray);

		// Normal Colors
		colors.add(red);
		colors.add(blue);
		colors.add(orange);
		colors.add(yellow);
		colors.add(green);
		colors.add(gray);

		// Dark Colors
		colors.add(darkRed);
		colors.add(darkBlue);		
		colors.add(darkOrange);
		colors.add(darkYellow);
		colors.add(darkGreen);
		colors.add(black);
	}

	public void createControls(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		containerComposite = new Composite(parent, SWT.DOUBLE_BUFFERED);
		containerComposite.setBackground(white.color);
		final FormLayout layout = new FormLayout();
		layout.marginWidth = ITabbedPropertyConstants.HSPACE + 2;
		layout.marginHeight = ITabbedPropertyConstants.VSPACE;
		layout.spacing = ITabbedPropertyConstants.VMARGIN + 1;
		containerComposite.setLayout(layout);

		createFontsAndColorsGroups(containerComposite);
	}

	protected Group createFontsAndColorsGroups(final Composite parent) {
		colorsAndFontsGroup = new Group(parent, SWT.SHADOW_NONE | SWT.DOUBLE_BUFFERED);
		colorsAndFontsGroup.setText("Fonts and Colors");
		colorsAndFontsGroup.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_LIST_BACKGROUND));
		colorsAndFontsGroup.setForeground(Display.getDefault().getSystemColor(SWT.COLOR_LIST_FOREGROUND));
		GridLayoutFactory.fillDefaults().numColumns(1).extendedMargins(10, 10, 10, 10).equalWidth(false).applyTo(colorsAndFontsGroup);
		createFontsGroup(colorsAndFontsGroup);

		return colorsAndFontsGroup;
	}

	private void createFontsGroup(final Group colorsAndFontsGroup) {
		final Composite parent = getWidgetFactory().createComposite(colorsAndFontsGroup);
		GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(false).applyTo(parent);
		GridDataFactory.fillDefaults().applyTo(parent);

		fontSizeLabel = createLabel(parent, "Font Size: ");
		fontSizeComboViewer = createComboViewer(parent, new FontSize[] { FontSize.Small, FontSize.Default, FontSize.Large } );

		lineWidthLabel = createLabel(parent, "Line Width: ");
		lineWidthComboViewer = createComboViewer(parent, new LineWidth[] { LineWidth.Small, LineWidth.Default, LineWidth.Large } );

		final Composite buttonBar = new Composite(colorsAndFontsGroup, SWT.SHADOW_NONE);
		buttonBar.setLayout(new GridLayout(3, false));
		buttonBar.setBackground(colorsAndFontsGroup.getBackground());
		GridDataFactory.fillDefaults().align(GridData.CENTER, GridData.CENTER).applyTo(buttonBar);

		final Button outlineButton = createButton(buttonBar, OutlineIcon);
		outlinePaintListener = new StylePaintListener(outlineButton, new StyleCommand("Set Outline", StyleType.OUTLINE, new CreateStyle() {
			@Override
			public Style getStyle(final DiagramElement diagramElement, final Object value) {
				final java.awt.Color awtOutline = (java.awt.Color)value;
				if(!awtOutline.equals(diagramElement.getDefaultForeground())) {
					return Style.create().styleBackground(diagramElement.getBackground()).
							styleFontColor(diagramElement.getFontColor()).
							styleOutline(awtOutline).
							styleFontSize(diagramElement.getFontSize()).
							styleLineWidth(diagramElement.getLineWidth()).
							build();			
				}

				return Style.create().styleBackground(diagramElement.getBackground()).
						styleFontColor(diagramElement.getFontColor()).
						styleFontSize(diagramElement.getFontSize()).
						styleLineWidth(diagramElement.getLineWidth()).
						build();
			}
		}));

		final Button fontColorButton = createButton(buttonBar, FontColorIcon);
		fontColorPaintListener = new StylePaintListener(fontColorButton, new StyleCommand("Set Font Color", StyleType.FONTCOLOR, new CreateStyle() {
			@Override
			public Style getStyle(final DiagramElement diagramElement, final Object value) {
				final java.awt.Color awtFontColor = (java.awt.Color)value;
				if(!awtFontColor.equals(diagramElement.getDefaultForeground())) {
					return Style.create().styleBackground(diagramElement.getBackground()).
							styleFontColor(awtFontColor).
							styleOutline(diagramElement.getOutline()).
							styleFontSize(diagramElement.getFontSize()).
							styleLineWidth(diagramElement.getLineWidth()).
							build();
				}
				//}

				return Style.create().styleBackground(diagramElement.getBackground()).
						styleOutline(diagramElement.getOutline()).
						styleFontSize(diagramElement.getFontSize()).
						styleLineWidth(diagramElement.getLineWidth()).
						build();
			}
		}));

		final Button backgroundButton = createButton(buttonBar, BackgroundIcon);
		backgroundPaintListener = new StylePaintListener(backgroundButton, new StyleCommand("Set Background", StyleType.BACKGROUND, new CreateStyle() {
			@Override
			public Style getStyle(final DiagramElement diagramElement, final Object value) {
				final java.awt.Color awtBackground = (java.awt.Color)value;
				if(!awtBackground.equals(diagramElement.getDefaultBackground())) {
					return Style.create().
							styleBackground(awtBackground).
							styleFontColor(diagramElement.getFontColor()).
							styleOutline(diagramElement.getOutline()).
							styleFontSize(diagramElement.getFontSize()).
							styleLineWidth(diagramElement.getLineWidth()).
							build();
				}

				return Style.create().
						styleFontColor(diagramElement.getFontColor()).
						styleOutline(diagramElement.getOutline()).
						styleFontSize(diagramElement.getFontSize()).
						styleLineWidth(diagramElement.getLineWidth()).
						build();
			}
		}));
	}

	private static ComboViewer createComboViewer(final Composite parent, final Object[] objects) {
		final ComboViewer comboViewer = new ComboViewer(parent, SWT.DROP_DOWN | SWT.READ_ONLY | SWT.BORDER);
		comboViewer.setContentProvider(ArrayContentProvider.getInstance());
		comboViewer.getCombo().setLayoutData(new GridData(GridData.BEGINNING, GridData.CENTER, false, false));
		comboViewer.setInput(objects);

		return comboViewer;
	}

	private static org.eclipse.swt.widgets.Label createLabel(final Composite parent, final String text) {
		final org.eclipse.swt.widgets.Label label = new org.eclipse.swt.widgets.Label(parent, SWT.NONE);
		label.setLayoutData(new GridData(GridData.BEGINNING, GridData.CENTER, false, false));
		label.setText(text);
		label.setBackground(parent.getBackground());

		return label;
	}

	private static Button createButton(final Composite parent, final ImageDescriptor imageDescriptor) {
		final Button button = new Button(parent, SWT.PUSH);
		button.setLayoutData(new GridData(GridData.BEGINNING, GridData.CENTER, false, false));
		button.setImage(imageDescriptor.createImage());

		return button;
	}

	public void setInput(final IWorkbenchPart part, final ISelection selection) {
		super.setInput(part, selection);
		this.ageDiagramEditor = (AgeDiagramEditor)part;
		final Color disableColor = lightGray.color;
		diagramElements.clear();

		final IStructuredSelection ss = (IStructuredSelection)selection;
		final Object firstSelection = ss.getFirstElement();
		if(!(firstSelection instanceof IAdaptable)) {
			// Disable Options
			final Button backgroundButton = backgroundPaintListener.getButton();
			backgroundButton.setEnabled(false);

			final Button fontColorButton = fontColorPaintListener.getButton();
			fontColorButton.setEnabled(false);

			final Button outlineButton = outlinePaintListener.getButton();
			outlineButton.setEnabled(false);

			setComboViewersEnabled(false, false);
			setStructuredSelection(FontSize.Default, LineWidth.Default);
			setPaintListenerColors(disableColor, disableColor, disableColor);
			return;
		}

		boolean showFontOptions = false;
		boolean showLineWidth = false;
		boolean showBackground = false;
		boolean showOutlineOption = false;
		DiagramElement diagramElement = null;
		FontSize lastFontSizeSelected = FontSize.Default;
		LineWidth lastLineWidthSelected = LineWidth.Default;
		final Iterator<?> itr = ss.iterator();
		while(itr.hasNext()) {
			final Object o = itr.next();
			final IAdaptable adaptable = (IAdaptable)o;
			diagramElement = adaptable.getAdapter(DiagramElement.class);
			if(diagramElement == null) {
				// Disable Options
				final Button backgroundButton = backgroundPaintListener.getButton();
				backgroundButton.setEnabled(false);

				final Button fontColorButton = fontColorPaintListener.getButton();
				fontColorButton.setEnabled(false);

				final Button outlineButton = outlinePaintListener.getButton();
				outlineButton.setEnabled(false);

				setComboViewersEnabled(false, false);
				setStructuredSelection(FontSize.Default, LineWidth.Default);
				setPaintListenerColors(disableColor, disableColor, disableColor);

				return;
			}

			final Object bo = diagramElement.getBusinessObject();
			boolean isLabel = diagramElement.getGraphic() instanceof Label;
			boolean isRealization = bo instanceof Realization;
			boolean isModeTransitionTrigger = bo instanceof ModeTransitionTrigger;
			if(!(isModeTransitionTrigger || isRealization) || isLabel) {
				showFontOptions = true;
			}

			boolean showConnectionBackground = bo instanceof ModeTransition || bo instanceof Flow;
			if(showConnectionBackground) {
				showBackground = true;
				showLineWidth = true;
				showOutlineOption = true;
			} else if(isRealization) {
				showLineWidth = true;
				showOutlineOption = true;
				showBackground = true;
			} else if(bo instanceof Connection || isModeTransitionTrigger) {
				showLineWidth = true;
				showOutlineOption = true;
			} else if(!isLabel) {
				showBackground = true;
				showOutlineOption = true;
			}

			lastLineWidthSelected = diagramElement.getLineWidth() != null ? diagramElement.getLineWidth() : LineWidth.Default;
			lastFontSizeSelected = diagramElement.getFontSize() != null ? diagramElement.getFontSize() : FontSize.Default;

			diagramElements.add(diagramElement);
		}

		if(diagramElement == null) {
			return;
		}

		final Button backgroundButton = backgroundPaintListener.getButton();
		backgroundButton.setEnabled(showBackground);

		final Button fontColorButton = fontColorPaintListener.getButton();
		fontColorButton.setEnabled(showFontOptions);

		final Button outlineButton = outlinePaintListener.getButton();
		outlineButton.setEnabled(showOutlineOption);

		final Object background;
		if(showBackground) {
			background = diagramElement.getBackground() != null ? diagramElement.getBackground() : diagramElement.getDefaultBackground();
		} else {
			background = disableColor;
		}

		final Object fontColor;
		if(showFontOptions) {
			fontColor = diagramElement.getFontColor() != null ? diagramElement.getFontColor() : diagramElement.getDefaultForeground();
		} else {
			fontColor = disableColor;
		}

		final Object outline;
		if(showOutlineOption) {
			outline = diagramElement.getOutline() != null ? diagramElement.getOutline() : diagramElement.getDefaultForeground();
		} else {
			outline = disableColor;
		}

		setComboViewersEnabled(showFontOptions, showLineWidth);
		setStructuredSelection(lastFontSizeSelected, lastLineWidthSelected);
		setPaintListenerColors(background, fontColor, outline);
	}

	private void setComboViewersEnabled(final boolean showFontSize, final boolean showLineWidth) {
		fontSizeComboViewer.getControl().setEnabled(showFontSize);
		fontSizeLabel.setEnabled(showFontSize);
		lineWidthComboViewer.getControl().setEnabled(showLineWidth);
		lineWidthLabel.setEnabled(showLineWidth);
	}

	private void setPaintListenerColors(final Object background, final Object fontColor, final Object awtOutline) {
		backgroundPaintListener.setColor(background);
		fontColorPaintListener.setColor(fontColor);
		outlinePaintListener.setColor(awtOutline);
	}

	private void setStructuredSelection(final FontSize fontSize, final LineWidth lineWidth) {
		fontSizeComboViewer.removeSelectionChangedListener(fontSizeSelectionListener);
		fontSizeComboViewer.setSelection(new StructuredSelection(fontSize));
		fontSizeComboViewer.addSelectionChangedListener(fontSizeSelectionListener);

		lineWidthComboViewer.removeSelectionChangedListener(lineWidthSelectionListener);
		lineWidthComboViewer.setSelection(new StructuredSelection(lineWidth));
		lineWidthComboViewer.addSelectionChangedListener(lineWidthSelectionListener);
	}

	private class ColorSelection extends SelectionAdapter {
		private StylePaintListener paintListener;
		private PresetColor customPC;
		private StyleCommand styleCmd;

		private ColorSelection(final StylePaintListener paintListener, final StyleCommand styleCmd) {
			this.paintListener = paintListener;
			this.styleCmd = styleCmd;
		}

		@Override
		public void widgetSelected(final SelectionEvent e) {
			final Shell shell = new Shell(Display.getCurrent(), SWT.NO_TRIM);
			GridLayoutFactory.fillDefaults().spacing(0, 0).numColumns(6).applyTo(shell);

			for(final PresetColor pc : colors) {
				final Button btn = new Button(shell, SWT.PUSH);
				btn.setImage(pc.image);
				btn.addSelectionListener(new ColorSelectionAdapter(shell, paintListener, pc.color, styleCmd));
			}

			final Button btn = new Button(shell, SWT.PUSH);
			final Color color;
			if(customPC == null) {
				btn.setEnabled(false);
				btn.setImage(white.image);
				color = white.color;
			} else {
				btn.setEnabled(true);
				btn.setImage(customPC.image);
				color = customPC.color;
			}
			btn.addSelectionListener(new ColorSelectionAdapter(shell, paintListener, color, styleCmd));

			final Button customBtn = new Button(shell, SWT.PUSH);
			customBtn.setText("Custom...");
			GridDataFactory.fillDefaults().grab(true, true).span(5, 0).applyTo(customBtn);

			final Button button = (Button)e.getSource();
			customBtn.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					shell.dispose();
					final Shell dlgShell = new Shell(Display.getCurrent().getActiveShell());
					final Rectangle rect = Display.getCurrent().getActiveShell().getBounds();
					// Center shell on screen
					dlgShell.setLocation(rect.x + rect.width/2, rect.y + rect.height/2);
					final ColorDialog dlg = new ColorDialog(dlgShell);
					final RGB rgb = dlg.open();
					if(rgb != null) {
						if(customPC == null) {
							customPC = new PresetColor(rgb);
						} else {
							customPC.setColor(rgb);
						}
						final Color color = customPC.color;
						paintListener.setColor(color);
						run(createAWTColor(color), styleCmd);
					}
				}
			});

			shell.addListener(SWT.Deactivate, new Listener() {
				public void handleEvent(final Event e) {
					shell.setVisible(false);
				}
			});

			shell.setLocation(Display.getDefault().map(button.getParent(), null, button.getLocation().x, button.getLocation().y + button.getSize().y));
			shell.pack();
			shell.open();
			shell.setFocus();

			final Display display = shell.getDisplay();
			while (!shell.isDisposed() && shell.isVisible()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		}
	}

	private class StylePaintListener implements PaintListener {
		private final Button button;
		private Color color;

		private StylePaintListener(final Button button, final StyleCommand styleCmd) {
			this.button = button;
			this.button.addPaintListener(this);
			this.button.addSelectionListener(new ColorSelection(this, styleCmd));
		}

		public void setColor(final Object color) {
			if(color instanceof Color) {
				setColor((Color)color);
			} else {
				setColor((java.awt.Color)color);
			}
		}

		@Override
		public void paintControl(final PaintEvent e) {
			if(color != null) {
				final Rectangle bounds = button.getBounds();
				if(color != null) {
					e.gc.setBackground(color);
				}

				e.gc.fillRectangle(4, bounds.height-7, bounds.width-8, 4);
				e.gc.dispose();
			}
		}

		private void setColor(final Color color) {
			this.color = color;
			button.redraw();
		}

		private void setColor(final java.awt.Color color) {
			setColor(new Color(Display.getCurrent(), color.getRed(), color.getGreen(), color.getBlue()));
		}

		private Button getButton() {
			return button;
		}
	}

	private static interface CreateStyle {
		Style getStyle(final DiagramElement diagramElement, final Object value);
	}

	private static class StyleCommand {
		private final String desc;
		private final StyleType styleType;
		private final CreateStyle createStyle;

		public StyleCommand(final String desc, final StyleType styleType, final CreateStyle createStyle) {
			this.desc = desc;
			this.styleType = styleType;
			this.createStyle = createStyle;
		}

		public String getDescription() {
			return desc;
		}

		public Style getStyle(final DiagramElement diagramElement, final Object value) {
			return createStyle.getStyle(diagramElement, value);
		}

		public StyleType getStyleType() {
			return styleType;
		}
	}

	private class MySelection implements ISelectionChangedListener {
		final StyleCommand styleCmd;
		private MySelection(final StyleCommand styleCmd) {
			this.styleCmd = styleCmd;
		}

		@Override
		public void selectionChanged(final SelectionChangedEvent event) {
			if(!diagramElements.isEmpty()) {
				final DiagramElement diagramElement = diagramElements.get(0);
				final UiService uiService = (UiService)ageDiagramEditor.getAdapter(UiService.class);
				final IStructuredSelection selection = (IStructuredSelection)event.getSelection();

				run(selection.getFirstElement(), styleCmd);
				Display.getDefault().asyncExec(new Runnable() {
					@Override
					public void run() {
						uiService.clearSelection();
						// TODO another way to select?? this selects both connections when subcomponents are extending same classifier
						ageDiagramEditor.selectDiagramElementsForBusinessObject(diagramElement.getBusinessObject());
					}
				});
			}
		}
	}

	private static Object createAWTColor(final Color color) {
		return new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue());
	}

	private void run(final Object value, final StyleCommand styleCmd) {
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				if(!diagramElements.isEmpty()) {
					final AgeDiagram ageDiagram = ageDiagramEditor.getGraphitiAgeDiagram().getAgeDiagram();
					ageDiagramEditor.getEditingDomain().getCommandStack().execute(new RecordingCommand(ageDiagramEditor.getEditingDomain(), styleCmd.getDescription()) {
						@Override
						protected void doExecute() {
							ageDiagram.modify(new DiagramModifier() {
								@Override
								public void modify(final DiagramModification m) {
									final StyleType styleType = styleCmd.getStyleType();
									for(final DiagramElement diagramElement : diagramElements) {
										if(!(diagramElement.getGraphic() instanceof Label)) {
											final Object bo = diagramElement.getBusinessObject();
											if(StyleType.BACKGROUND == styleType && !(bo instanceof Connection || bo instanceof ModeTransitionTrigger)) {
												m.setStyle(diagramElement, styleCmd.getStyle(diagramElement, value));
											} else if((StyleType.FONTCOLOR == styleType || StyleType.FONTSIZE == styleType) && !(bo instanceof Realization || bo instanceof ModeTransitionTrigger)) {
												m.setStyle(diagramElement, styleCmd.getStyle(diagramElement, value));
											} else if(StyleType.LINEWIDTH == styleType && bo instanceof Connection &&
													bo instanceof ModeTransition &&	bo instanceof ModeTransitionTrigger	&& bo instanceof Realization) {
												m.setStyle(diagramElement, styleCmd.getStyle(diagramElement, value));
											} else if(StyleType.OUTLINE == styleType) {
												m.setStyle(diagramElement, styleCmd.getStyle(diagramElement, value));
											}

											// Allow background and font options to change for contained labels
											for(final DiagramElement de : diagramElement.getDiagramElements()) {
												if(de.getGraphic() instanceof Label && (styleType == StyleType.BACKGROUND ||
														styleType == StyleType.FONTSIZE || styleType ==  StyleType.FONTCOLOR)) {
													m.setStyle(de, styleCmd.getStyle(diagramElement, value));
												}
											}
										} else if(styleCmd.styleType == StyleType.FONTCOLOR || styleCmd.styleType == StyleType.FONTSIZE) {
											// Allow font options for selected labels
											m.setStyle(diagramElement, styleCmd.getStyle(diagramElement, value));
										}
									}

									DiagramLayoutUtil.layout(ageDiagram, m, false);
								}
							});
						}
					});
				}
			}
		});
	}

	private MySelection lineWidthSelectionListener = new MySelection(new StyleCommand("Set Line Width", StyleType.LINEWIDTH, new CreateStyle() {
		@Override
		public Style getStyle(final DiagramElement diagramElement, final Object value) {
			final LineWidth lineWidth = (LineWidth)value;
			if(lineWidth != LineWidth.Default) {
				return Style.create().styleBackground(diagramElement.getBackground()).
						styleFontColor(diagramElement.getFontColor()).
						styleOutline(diagramElement.getOutline()).
						styleFontSize(diagramElement.getFontSize()).
						styleLineWidth(lineWidth).
						build();
			}

			return Style.create().
					styleBackground(diagramElement.getBackground()).
					styleFontColor(diagramElement.getFontColor()).
					styleOutline(diagramElement.getOutline()).
					styleFontSize(diagramElement.getFontSize()).
					build();
		}
	}));

	private MySelection fontSizeSelectionListener = new MySelection(new StyleCommand("Set Font Size", StyleType.FONTSIZE, new CreateStyle() {
		@Override
		public Style getStyle(final DiagramElement diagramElement, final Object value) {
			final FontSize fontSize = (FontSize)value;
			if(fontSize != FontSize.Default) {
				return Style.create().styleBackground(diagramElement.getBackground()).
						styleFontColor(diagramElement.getFontColor()).
						styleOutline(diagramElement.getOutline()).
						styleFontSize(fontSize).
						styleLineWidth(diagramElement.getLineWidth()).
						build();
			}

			return Style.create().
					styleBackground(diagramElement.getBackground()).
					styleFontColor(diagramElement.getFontColor()).
					styleOutline(diagramElement.getOutline()).
					styleLineWidth(diagramElement.getLineWidth()).
					build();
		}
	}));

	private class ColorSelectionAdapter extends SelectionAdapter {
		public ColorSelectionAdapter(final Shell shell, final StylePaintListener paintListener, final Color color, final StyleCommand styleCmd) {
			this.shell = shell;
			this.paintListener = paintListener;
			this.color = color;
			this.styleCmd = styleCmd;
		}

		@Override
		public void widgetSelected(final SelectionEvent e) {
			paintListener.setColor(color);
			shell.dispose();
			run(createAWTColor(color), styleCmd);
		}

		private final Color color;
		private final StylePaintListener paintListener;
		private final StyleCommand styleCmd;
		private final Shell shell;
	}

	private enum StyleType {
		BACKGROUND,
		FONTCOLOR,
		OUTLINE,
		FONTSIZE,
		LINEWIDTH
	}
}
