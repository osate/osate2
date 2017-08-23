package org.osate.ge.internal.ui.properties;

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
import org.eclipse.jface.viewers.IFilter;
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
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.osate.aadl2.Connection;
import org.osate.aadl2.Flow;
import org.osate.aadl2.Generalization;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.ModeTransitionTrigger;
import org.osate.ge.internal.Activator;
import org.osate.ge.internal.di.Icon;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramLayoutUtil;
import org.osate.ge.internal.diagram.runtime.FontSize;
import org.osate.ge.internal.diagram.runtime.LineWidth;
import org.osate.ge.internal.diagram.runtime.Style;
import org.osate.ge.internal.diagram.runtime.StyleBuilder;
import org.osate.ge.internal.graphics.Label;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;

public class AppearancePropertySection extends AbstractPropertySection {
	public static class SelectionFilter implements IFilter {
		@Override
		public boolean select(final Object o) {
			if (o instanceof IAdaptable) {
				final IAdaptable adaptable = (IAdaptable) o;
				final DiagramElement diagramElement = adaptable.getAdapter(DiagramElement.class);
				return diagramElement != null;
			}

			return false;
		}
	}

	@Icon
	public final static ImageDescriptor OutlineIcon = Activator.getImageDescriptor("icons/Outline.gif");

	@Icon
	public final static ImageDescriptor BackgroundIcon = Activator.getImageDescriptor("icons/Background.gif");

	@Icon
	public final static ImageDescriptor FontColorIcon = Activator.getImageDescriptor("icons/FontColor.gif");

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		final Composite containerComposite = getWidgetFactory().createFlatFormComposite(parent);
		createComboViewerSection(containerComposite);
		createButtonSection(containerComposite);
	}

	private void createComboViewerSection(final Composite parent) {
		fontSizeLabel = createLabel(parent, "Font Size:");
		FormData fd = new FormData();
		fd.top = new FormAttachment(5, 0);
		fd.left = new FormAttachment(0, 10);
		fontSizeLabel.setLayoutData(fd);

		fontSizeComboViewer = createComboViewer(parent,
				new FontSize[] { FontSize.Small, FontSize.Default, FontSize.Large });
		fd = new FormData();
		fd.top = new FormAttachment(fontSizeLabel, 0, SWT.TOP);
		fd.left = new FormAttachment(fontSizeLabel, 20);
		fontSizeComboViewer.getCombo().setLayoutData(fd);

		lineWidthLabel = createLabel(parent, "Line Width:");
		fd = new FormData();
		fd.top = new FormAttachment(fontSizeLabel, 10);
		fd.left = new FormAttachment(0, 10);
		lineWidthLabel.setLayoutData(fd);

		lineWidthComboViewer = createComboViewer(parent,
				new LineWidth[] { LineWidth.Small, LineWidth.Default, LineWidth.Large });
		fd = new FormData();
		fd.top = new FormAttachment(lineWidthLabel, 0, SWT.TOP);
		fd.left = new FormAttachment(lineWidthLabel, 10);
		lineWidthComboViewer.getCombo().setLayoutData(fd);
	}

	private void createButtonSection(final Composite parent) {
		final Button outlineButton = createButton(parent, OutlineIcon);
		FormData fd = new FormData();
		fd.top = new FormAttachment(lineWidthLabel, 10);
		fd.left = new FormAttachment(0, 30);
		outlineButton.setLayoutData(fd);
		outlinePaintListener = new StylePaintListener(outlineButton,
				new StyleCommand("Set Outline", StyleType.OUTLINE, (diagramElement, value) -> {
					final java.awt.Color awtOutline = (java.awt.Color) value;
					final Style currentStyle = diagramElement.getStyle();
					if (!awtOutline.equals(diagramElement.getDefaultOutlineColor())) {
						return StyleBuilder.create().backgroundColor(currentStyle.getBackgroundColor())
								.fontColor(currentStyle.getFontColor()).outlineColor(awtOutline)
								.fontSize(currentStyle.getFontSize()).lineWidth(currentStyle.getLineWidth()).build();
					}

					return StyleBuilder.create().backgroundColor(currentStyle.getBackgroundColor())
							.fontColor(currentStyle.getFontColor()).fontSize(currentStyle.getFontSize())
							.lineWidth(currentStyle.getLineWidth()).build();
				}));

		final Button fontColorButton = createButton(parent, FontColorIcon);
		fd = new FormData();
		fd.top = new FormAttachment(outlineButton, 0, SWT.TOP);
		fd.left = new FormAttachment(outlineButton, 0);
		fontColorButton.setLayoutData(fd);
		fontColorPaintListener = new StylePaintListener(fontColorButton,
				new StyleCommand("Set Font Color", StyleType.FONTCOLOR, (diagramElement, value) -> {
					final java.awt.Color awtFontColor = (java.awt.Color) value;
					final Style currentStyle = diagramElement.getStyle();
					if (!awtFontColor.equals(diagramElement.getDefaultFontColor())) {
						return StyleBuilder.create().backgroundColor(currentStyle.getBackgroundColor())
								.fontColor(awtFontColor).outlineColor(currentStyle.getOutlineColor())
								.fontSize(currentStyle.getFontSize()).lineWidth(currentStyle.getLineWidth())
								.build();
					}

					return StyleBuilder.create().backgroundColor(currentStyle.getBackgroundColor())
							.outlineColor(currentStyle.getOutlineColor()).fontSize(currentStyle.getFontSize())
							.lineWidth(currentStyle.getLineWidth()).build();
				}));

		final Button backgroundButton = createButton(parent, BackgroundIcon);
		fd = new FormData();
		fd.top = new FormAttachment(fontColorButton, 0, SWT.TOP);
		fd.left = new FormAttachment(fontColorButton, 0);
		backgroundButton.setLayoutData(fd);
		backgroundPaintListener = new StylePaintListener(backgroundButton,
				new StyleCommand("Set Background", StyleType.BACKGROUND, (diagramElement, value) -> {
					final java.awt.Color awtBackground = (java.awt.Color) value;
					final Style currentStyle = diagramElement.getStyle();
					if (!awtBackground.equals(diagramElement.getDefaultBackgroundColor())) {
						return StyleBuilder.create().backgroundColor(awtBackground)
								.fontColor(currentStyle.getFontColor()).outlineColor(currentStyle.getOutlineColor())
								.fontSize(currentStyle.getFontSize()).lineWidth(currentStyle.getLineWidth())
								.build();
					}

					return StyleBuilder.create().fontColor(currentStyle.getFontColor())
							.outlineColor(currentStyle.getOutlineColor()).fontSize(currentStyle.getFontSize())
							.lineWidth(currentStyle.getLineWidth()).build();
				}));
	}

	@Override
	public void setInput(final IWorkbenchPart part, final ISelection selection) {
		super.setInput(part, selection);
		this.ageDiagramEditor = (AgeDiagramEditor) part;
		selectedDiagramElements.clear();

		final IStructuredSelection ss = (IStructuredSelection) selection;
		final Color disableColor = lightGray.color;
		boolean showFontOptions = false;
		boolean showLineWidth = false;
		boolean showBackground = false;
		boolean showOutlineOption = false;
		final Iterator<?> itr = ss.iterator();
		while (itr.hasNext()) {
			final Object o = itr.next();
			final DiagramElement diagramElement = ((IAdaptable) o).getAdapter(DiagramElement.class);
			selectedDiagramElements.add(diagramElement);

			final Object bo = diagramElement.getBusinessObject();
			boolean isLabel = diagramElement.getGraphic() instanceof Label;
			boolean isGeneralization = bo instanceof Generalization;
			boolean isModeTransitionTrigger = bo instanceof ModeTransitionTrigger;
			// Font options
			if (!(isModeTransitionTrigger || isGeneralization) || isLabel) {
				showFontOptions = true;
			}

			// Shape/Connection options
			if (isGeneralization || bo instanceof ModeTransition || bo instanceof Flow) {
				showLineWidth = true;
				showOutlineOption = true;
				showBackground = true;
			} else if (bo instanceof Connection || isModeTransitionTrigger) {
				showLineWidth = true;
				showOutlineOption = true;
			} else if (!isLabel) {
				showBackground = true;
				showOutlineOption = true;
			}

		}

		// Set options to match last selected element
		final DiagramElement diagramElement = selectedDiagramElements.get(selectedDiagramElements.size() - 1);
		final Style currentStyle = diagramElement.getStyle();

		final FontSize lastFontSizeSelected = currentStyle.getFontSize() != null ? currentStyle.getFontSize()
				: FontSize.Default;
		final LineWidth lastLineWidthSelected = currentStyle.getLineWidth() != null ? currentStyle.getLineWidth()
				: LineWidth.Default;

		final Button backgroundButton = backgroundPaintListener.getButton();
		backgroundButton.setEnabled(showBackground);

		final Button fontColorButton = fontColorPaintListener.getButton();
		fontColorButton.setEnabled(showFontOptions);

		final Button outlineButton = outlinePaintListener.getButton();
		outlineButton.setEnabled(showOutlineOption);

		final Object background;
		if (showBackground) {
			background = currentStyle.getBackgroundColor() != null ? currentStyle.getBackgroundColor()
					: diagramElement.getDefaultBackgroundColor();
		} else {
			background = disableColor;
		}

		final Object fontColor;
		if (showFontOptions) {
			fontColor = currentStyle.getFontColor() != null ? currentStyle.getFontColor()
					: diagramElement.getDefaultFontColor();
		} else {
			fontColor = disableColor;
		}

		final Object outline;
		if (showOutlineOption) {
			outline = currentStyle.getOutlineColor() != null ? currentStyle.getOutlineColor()
					: diagramElement.getDefaultOutlineColor();
		} else {
			outline = disableColor;
		}

		// Update UI
		setComboViewersEnabled(showFontOptions, showLineWidth);
		setStructuredSelection(lastFontSizeSelected, lastLineWidthSelected);
		setPaintListenerColors(background, fontColor, outline);
	}

	private static ComboViewer createComboViewer(final Composite parent, final Object[] input) {
		final ComboViewer comboViewer = new ComboViewer(parent, SWT.DROP_DOWN | SWT.READ_ONLY | SWT.BORDER);
		comboViewer.setContentProvider(ArrayContentProvider.getInstance());
		comboViewer.setInput(input);

		return comboViewer;
	}

	private static org.eclipse.swt.widgets.Label createLabel(final Composite parent, final String text) {
		final org.eclipse.swt.widgets.Label label = new org.eclipse.swt.widgets.Label(parent, SWT.NONE);
		label.setText(text);
		label.setBackground(parent.getBackground());

		return label;
	}

	private static Button createButton(final Composite parent, final ImageDescriptor imageDescriptor) {
		final Button button = new Button(parent, SWT.PUSH);
		button.setImage(imageDescriptor.createImage());

		return button;
	}

	private void setComboViewersEnabled(final boolean showFontSize, final boolean showLineWidth) {
		fontSizeLabel.setEnabled(showFontSize);
		fontSizeComboViewer.getControl().setEnabled(showFontSize);
		lineWidthLabel.setEnabled(showLineWidth);
		lineWidthComboViewer.getControl().setEnabled(showLineWidth);
	}

	private void setPaintListenerColors(final Object background, final Object fontColor, final Object outline) {
		backgroundPaintListener.setColor(background);
		fontColorPaintListener.setColor(fontColor);
		outlinePaintListener.setColor(outline);
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
		private ColorSelection(final StylePaintListener paintListener, final StyleCommand styleCmd) {
			this.paintListener = paintListener;
			this.styleCmd = styleCmd;
		}

		@Override
		public void widgetSelected(final SelectionEvent e) {
			final Shell shell = new Shell(Display.getCurrent(), SWT.NO_TRIM);
			GridLayoutFactory.fillDefaults().spacing(0, 0).numColumns(6).applyTo(shell);

			// Create preset color buttons
			for (final PresetColor pc : colors) {
				final Button btn = new Button(shell, SWT.PUSH);
				btn.setImage(pc.image);
				btn.addSelectionListener(new ColorSelectionAdapter(shell, paintListener, pc.color, styleCmd));
			}

			// Create custom color button
			final Button pcBtn = new Button(shell, SWT.PUSH);
			final Color color;
			if (customPC == null) {
				pcBtn.setEnabled(false);
				pcBtn.setImage(white.image);
				color = white.color;
			} else {
				pcBtn.setEnabled(true);
				pcBtn.setImage(customPC.image);
				color = customPC.color;
			}
			pcBtn.addSelectionListener(new ColorSelectionAdapter(shell, paintListener, color, styleCmd));

			// Custom color dialog
			final Button colorDlgBtn = new Button(shell, SWT.PUSH);
			colorDlgBtn.setText("Custom...");
			GridDataFactory.fillDefaults().grab(true, true).span(5, 0).applyTo(colorDlgBtn);
			colorDlgBtn.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					shell.dispose();
					final Shell dlgShell = new Shell(Display.getCurrent().getActiveShell());
					final Rectangle rect = Display.getCurrent().getActiveShell().getBounds();
					// Center color dialog on screen
					dlgShell.setLocation(rect.x + rect.width / 2, rect.y + rect.height / 2);
					final ColorDialog dlg = new ColorDialog(dlgShell);
					final RGB rgb = dlg.open();
					if (rgb != null) {
						if (customPC == null) {
							customPC = new PresetColor(rgb);
						} else {
							customPC.setColor(rgb);
						}
						final Color color = customPC.color;
						paintListener.setColor(color);
						runStyleCommand(createAWTColor(color), styleCmd);
					}
				}
			});

			// Close shell if user clicks off of the shell
			shell.addListener(SWT.Deactivate, e1 -> shell.setVisible(false));

			// Original button selected
			final Button button = (Button) e.getSource();
			shell.setLocation(Display.getDefault().map(button.getParent(), null, button.getLocation().x,
					button.getLocation().y + button.getSize().y));
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

		private StylePaintListener paintListener;
		private PresetColor customPC;
		private StyleCommand styleCmd;
	}

	private class StylePaintListener implements PaintListener {
		private StylePaintListener(final Button button, final StyleCommand styleCmd) {
			this.button = button;
			this.button.addPaintListener(this);
			this.button.addSelectionListener(new ColorSelection(this, styleCmd));
		}

		@Override
		public void paintControl(final PaintEvent e) {
			// Paint color bar on button
			if (color != null) {
				final Rectangle bounds = button.getBounds();
				if (color != null) {
					e.gc.setBackground(color);
				}

				e.gc.fillRectangle(4, bounds.height - 7, bounds.width - 8, 4);
				e.gc.dispose();
			}
		}

		private void setColor(final Object color) {
			if (color instanceof Color) {
				setColor((Color) color);
			} else if (color instanceof java.awt.Color) {
				final java.awt.Color awtColor = (java.awt.Color) color;
				setColor(new Color(Display.getDefault(), awtColor.getRed(), awtColor.getGreen(), awtColor.getBlue()));
			}
		}

		private void setColor(final Color color) {
			this.color = color;
			button.redraw();
		}

		private Button getButton() {
			return button;
		}

		private final Button button;
		private Color color;
	}

	private static interface CreateStyle {
		Style getStyle(final DiagramElement diagramElement, final Object value);
	}

	private static class StyleCommand {
		public StyleCommand(final String desc, final StyleType styleType, final CreateStyle createStyle) {
			this.desc = desc;
			this.styleType = styleType;
			this.createStyle = createStyle;
		}

		private String getDescription() {
			return desc;
		}

		private Style getStyle(final DiagramElement diagramElement, final Object value) {
			return createStyle.getStyle(diagramElement, value);
		}

		private StyleType getStyleType() {
			return styleType;
		}

		private final String desc;
		private final StyleType styleType;
		private final CreateStyle createStyle;
	}

	private class ComboViewerSelection implements ISelectionChangedListener {
		private ComboViewerSelection(final StyleCommand styleCmd) {
			this.styleCmd = styleCmd;
		}

		@Override
		public void selectionChanged(final SelectionChangedEvent event) {
			if (!selectedDiagramElements.isEmpty()) {
				final IStructuredSelection selection = (IStructuredSelection) event.getSelection();
				runStyleCommand(selection.getFirstElement(), styleCmd);
				// Update needed so show line width change
				Display.getDefault().asyncExec(() -> ageDiagramEditor.updateDiagramWhenVisible());
			}
		}

		private final StyleCommand styleCmd;
	}

	private static Object createAWTColor(final Color color) {
		return new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue());
	}

	private void runStyleCommand(final Object value, final StyleCommand styleCmd) {
		Display.getDefault().asyncExec(() -> {
			final AgeDiagram ageDiagram = ageDiagramEditor.getGraphitiAgeDiagram().getAgeDiagram();
			ageDiagramEditor.getEditingDomain().getCommandStack()
			.execute(new RecordingCommand(ageDiagramEditor.getEditingDomain(), styleCmd.getDescription()) {
				@Override
				protected void doExecute() {
					ageDiagram.modify(m -> {
						final StyleType styleType = styleCmd.getStyleType();
						for (final DiagramElement diagramElement : selectedDiagramElements) {
							if (!(diagramElement.getGraphic() instanceof Label)) {
								final Object bo = diagramElement.getBusinessObject();
								if (StyleType.BACKGROUND == styleType
										&& !(bo instanceof Connection || bo instanceof ModeTransitionTrigger)) {
									m.setStyle(diagramElement, styleCmd.getStyle(diagramElement, value));
								} else if ((StyleType.FONTCOLOR == styleType || StyleType.FONTSIZE == styleType)
										&& !(bo instanceof Generalization
												|| bo instanceof ModeTransitionTrigger)) {
									m.setStyle(diagramElement, styleCmd.getStyle(diagramElement, value));
								} else if (StyleType.LINEWIDTH == styleType && (bo instanceof Connection
										|| bo instanceof ModeTransition || bo instanceof ModeTransitionTrigger
										|| bo instanceof Generalization || bo instanceof Flow)) {
									m.setStyle(diagramElement, styleCmd.getStyle(diagramElement, value));
								} else if (StyleType.OUTLINE == styleType) {
									m.setStyle(diagramElement, styleCmd.getStyle(diagramElement, value));
								}

								// Allow background and font options to change for contained labels
								for (final DiagramElement de : diagramElement.getDiagramElements()) {
									if (de.getGraphic() instanceof Label && (styleType == StyleType.BACKGROUND
											|| styleType == StyleType.FONTSIZE
											|| styleType == StyleType.FONTCOLOR)) {
										m.setStyle(de, styleCmd.getStyle(diagramElement, value));
									}
								}
							} else if (styleCmd.styleType == StyleType.FONTCOLOR
									|| styleCmd.styleType == StyleType.FONTSIZE) {
								// Allow font options for selected labels
								m.setStyle(diagramElement, styleCmd.getStyle(diagramElement, value));
							}
						}

						DiagramLayoutUtil.layout(ageDiagram, m, false);
					});
				}
			});
		});
	}

	private class ColorSelectionAdapter extends SelectionAdapter {
		public ColorSelectionAdapter(final Shell shell, final StylePaintListener paintListener, final Color color,
				final StyleCommand styleCmd) {
			this.shell = shell;
			this.paintListener = paintListener;
			this.color = color;
			this.styleCmd = styleCmd;
		}

		@Override
		public void widgetSelected(final SelectionEvent e) {
			paintListener.setColor(color);
			shell.dispose();
			runStyleCommand(createAWTColor(color), styleCmd);
		}

		private final Color color;
		private final StylePaintListener paintListener;
		private final StyleCommand styleCmd;
		private final Shell shell;
	}

	private enum StyleType {
		BACKGROUND, FONTCOLOR, OUTLINE, FONTSIZE, LINEWIDTH
	}

	private static class PresetColor extends ImageDescriptor {
		private PresetColor(final RGB rgb) {
			this.color = new Color(Display.getDefault(), rgb);
			this.image = createImage();
		}

		private void setColor(final RGB rgb) {
			this.color = new Color(Display.getDefault(), rgb);
			this.image = createImage();
		}

		@Override
		public Image createImage() {
			final Device device = Display.getCurrent();
			ImageData data = getImageData();
			if (data == null) {
				data = DEFAULT_IMAGE_DATA;
			}

			try {
				if (data.transparentPixel >= 0) {
					final ImageData maskData = data.getTransparencyMask();
					return new Image(device, data, maskData);
				}
				return new Image(device, data);
			} catch (final SWTException exception) {
				try {
					return new Image(device, DEFAULT_IMAGE_DATA);
				} catch (final SWTException nextException) {
					return null;
				}
			}
		}

		@Override
		public ImageData getImageData() {
			final ImageData data = new ImageData(ICON_SIZE.x, ICON_SIZE.y, 1,
					new PaletteData(new RGB[] { color.getRGB() }));

			for (int i = 0; i < ICON_SIZE.y; i++) {
				data.setPixel(0, i, 1);
			}

			for (int i = 0; i < ICON_SIZE.y; i++) {
				data.setPixel(ICON_SIZE.x - 1, i, 1);
			}

			for (int i = 0; i < ICON_SIZE.x; i++) {
				data.setPixel(i, 0, 1);
			}

			for (int i = 0; i < ICON_SIZE.x; i++) {
				data.setPixel(i, ICON_SIZE.y - 1, 1);
			}

			return data;
		}

		private static final Point ICON_SIZE = new Point(18, 18);
		private Color color;
		private Image image;
	}

	private ComboViewerSelection lineWidthSelectionListener = new ComboViewerSelection(
			new StyleCommand("Set Line Width", StyleType.LINEWIDTH, (diagramElement, value) -> {
				final LineWidth lineWidth = (LineWidth) value;
				final Style currentStyle = diagramElement.getStyle();
				if (lineWidth != LineWidth.Default) {
					return StyleBuilder.create().backgroundColor(currentStyle.getBackgroundColor())
							.fontColor(currentStyle.getFontColor()).outlineColor(currentStyle.getOutlineColor())
							.fontSize(currentStyle.getFontSize()).lineWidth(lineWidth).build();
				}

				return StyleBuilder.create().backgroundColor(currentStyle.getBackgroundColor())
						.fontColor(currentStyle.getFontColor()).outlineColor(currentStyle.getOutlineColor())
						.fontSize(currentStyle.getFontSize()).build();
			}));

	private ComboViewerSelection fontSizeSelectionListener = new ComboViewerSelection(
			new StyleCommand("Set Font Size", StyleType.FONTSIZE, (diagramElement, value) -> {
				final FontSize fontSize = (FontSize) value;
				final Style currentStyle = diagramElement.getStyle();
				if (fontSize != FontSize.Default) {
					return StyleBuilder.create().backgroundColor(currentStyle.getBackgroundColor())
							.fontColor(currentStyle.getFontColor()).outlineColor(currentStyle.getOutlineColor())
							.fontSize(fontSize).lineWidth(currentStyle.getLineWidth()).build();
				}

				return StyleBuilder.create().backgroundColor(currentStyle.getBackgroundColor())
						.fontColor(currentStyle.getFontColor()).outlineColor(currentStyle.getOutlineColor())
						.lineWidth(currentStyle.getLineWidth()).build();
			}));

	private List<DiagramElement> selectedDiagramElements = new ArrayList<>();
	private AgeDiagramEditor ageDiagramEditor;
	private org.eclipse.swt.widgets.Label fontSizeLabel;
	private org.eclipse.swt.widgets.Label lineWidthLabel;
	private ComboViewer fontSizeComboViewer;
	private ComboViewer lineWidthComboViewer;
	private StylePaintListener backgroundPaintListener;
	private StylePaintListener fontColorPaintListener;
	private StylePaintListener outlinePaintListener;

	// Red Column
	private final PresetColor lighterRed = new PresetColor(new RGB(255, 204, 204));
	private final PresetColor lightRed = new PresetColor(new RGB(255, 102, 102));
	private final PresetColor red = new PresetColor(new RGB(255, 0, 0));
	private final PresetColor darkRed = new PresetColor(new RGB(153, 0, 0));

	// Orange Column
	private final PresetColor lighterOrange = new PresetColor(new RGB(255, 229, 204));
	private final PresetColor lightOrange = new PresetColor(new RGB(255, 178, 102));
	private final PresetColor orange = new PresetColor(new RGB(255, 128, 0));
	private final PresetColor darkOrange = new PresetColor(new RGB(153, 76, 0));

	// Blue Column
	private final PresetColor lighterBlue = new PresetColor(new RGB(204, 204, 255));
	private final PresetColor lightBlue = new PresetColor(new RGB(102, 102, 255));
	private final PresetColor blue = new PresetColor(new RGB(0, 0, 255));
	private final PresetColor darkBlue = new PresetColor(new RGB(0, 0, 153));

	// Yellow Column
	private final PresetColor lighterYellow = new PresetColor(new RGB(255, 255, 204));
	private final PresetColor lightYellow = new PresetColor(new RGB(255, 255, 102));
	private final PresetColor yellow = new PresetColor(new RGB(255, 255, 0));
	private final PresetColor darkYellow = new PresetColor(new RGB(153, 153, 0));

	// Green Column
	private final PresetColor lighterGreen = new PresetColor(new RGB(204, 255, 204));
	private final PresetColor lightGreen = new PresetColor(new RGB(102, 255, 102));
	private final PresetColor green = new PresetColor(new RGB(0, 255, 0));
	private final PresetColor darkGreen = new PresetColor(new RGB(0, 153, 0));

	// Shade Column
	private final PresetColor white = new PresetColor(new RGB(255, 255, 255));
	private final PresetColor lightGray = new PresetColor(new RGB(224, 224, 224));
	private final PresetColor gray = new PresetColor(new RGB(160, 160, 160));
	private final PresetColor black = new PresetColor(new RGB(0, 0, 0));

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
}
