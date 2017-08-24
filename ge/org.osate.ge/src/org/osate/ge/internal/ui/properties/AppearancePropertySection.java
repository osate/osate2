package org.osate.ge.internal.ui.properties;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.resource.DeviceResourceManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
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
import org.osate.ge.internal.Activator;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.FontSize;
import org.osate.ge.internal.diagram.runtime.LineWidth;
import org.osate.ge.internal.diagram.runtime.Style;
import org.osate.ge.internal.diagram.runtime.StyleBuilder;
import org.osate.ge.internal.graphics.AgeConnection;
import org.osate.ge.internal.graphics.Label;
import org.osate.ge.internal.ui.util.UiUtil;

public class AppearancePropertySection extends AbstractPropertySection {
	public static class SelectionFilter implements IFilter {
		@Override
		public boolean select(final Object o) {
			return Adapters.adapt(o, DiagramElement.class) != null;
		}
	}

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		resourceMgr = new DeviceResourceManager(Display.getCurrent());
		final Composite containerComposite = getWidgetFactory().createFlatFormComposite(parent);
		createComboViewerSection(containerComposite);
		createButtonSection(containerComposite);
	}

	@Override
	public void dispose() {
		resourceMgr.dispose();
	}

	private void createComboViewerSection(final Composite parent) {
		fontSizeLabel = createLabel(parent, "Font Size:");
		FormData fd = new FormData();
		fd.top = new FormAttachment(5, 0);
		fd.left = new FormAttachment(0, 10);
		fontSizeLabel.setLayoutData(fd);

		fontSizeComboViewer = createComboViewer(parent, FontSize.values());
		fd = new FormData();
		fd.top = new FormAttachment(fontSizeLabel, 0, SWT.TOP);
		fd.left = new FormAttachment(fontSizeLabel, 20);
		fontSizeComboViewer.getCombo().setLayoutData(fd);

		lineWidthLabel = createLabel(parent, "Line Width:");
		fd = new FormData();
		fd.top = new FormAttachment(fontSizeLabel, 10);
		fd.left = new FormAttachment(0, 10);
		lineWidthLabel.setLayoutData(fd);

		lineWidthComboViewer = createComboViewer(parent, LineWidth.values());
		fd = new FormData();
		fd.top = new FormAttachment(lineWidthLabel, 0, SWT.TOP);
		fd.left = new FormAttachment(lineWidthLabel, 10);
		lineWidthComboViewer.getCombo().setLayoutData(fd);
	}

	private void createButtonSection(final Composite parent) {
		final Button outlineButton = createButton(parent, outlineIcon);
		FormData fd = new FormData();
		fd.top = new FormAttachment(lineWidthLabel, 10);
		fd.left = new FormAttachment(0, 30);
		outlineButton.setLayoutData(fd);
		outlinePaintListener = new StylePaintListener(outlineButton,
				new StyleCommand("Set Outline", (diagramElement, sb, value) -> {
					if (supportsOutline(diagramElement)) {
						final java.awt.Color awtOutline = (java.awt.Color) value;
						sb.outlineColor(awtOutline);
					}
				}));

		final Button fontColorButton = createButton(parent, fontColorIcon);
		fd = new FormData();
		fd.top = new FormAttachment(outlineButton, 0, SWT.TOP);
		fd.left = new FormAttachment(outlineButton, 0);
		fontColorButton.setLayoutData(fd);
		fontColorPaintListener = new StylePaintListener(fontColorButton,
				new StyleCommand("Set Font Color", (diagramElement, sb, value) -> {
					if (supportsFontOptions(diagramElement)) {
						final java.awt.Color awtFontColor = (java.awt.Color) value;
						sb.fontColor(awtFontColor);
					}
				}));

		final Button backgroundButton = createButton(parent, backgroundIcon);
		fd = new FormData();
		fd.top = new FormAttachment(fontColorButton, 0, SWT.TOP);
		fd.left = new FormAttachment(fontColorButton, 0);
		backgroundButton.setLayoutData(fd);
		backgroundPaintListener = new StylePaintListener(backgroundButton,
				new StyleCommand("Set Background", (diagramElement, sb, value) -> {
					if (supportsBackground(diagramElement)) {
						final java.awt.Color awtBackground = (java.awt.Color) value;
						sb.backgroundColor(awtBackground);
					}
				}));
	}

	@Override
	public void setInput(final IWorkbenchPart part, final ISelection selection) {
		super.setInput(part, selection);
		selectedDiagramElements.clear();

		final IStructuredSelection ss = (IStructuredSelection) selection;
		final RGB disableColor = lightGray.rgb;
		boolean enableFontOptions = false;
		boolean enableLineWidth = false;
		boolean enableBackground = false;
		boolean enableOutlineOption = false;
		final Iterator<?> itr = ss.iterator();
		while (itr.hasNext()) {
			final Object o = itr.next();
			final DiagramElement diagramElement = Adapters.adapt(o, DiagramElement.class);
			selectedDiagramElements.add(diagramElement);

			// Font options
			if (supportsFontOptions(diagramElement)) {
				enableFontOptions = true;
			}

			// Shape/Connection options
			if (supportsLineWidth(diagramElement)) {
				enableLineWidth = true;
			}

			if (supportsBackground(diagramElement)) {
				enableBackground = true;
			}

			if (supportsOutline(diagramElement)) {
				enableOutlineOption = true;
			}
		}

		// Get the editor from the selected diagram elements
		ageDiagram = Objects.requireNonNull(UiUtil.getDiagram(selectedDiagramElements), "Unable to retrieve diagram");

		// Set options to match last selected element
		final DiagramElement diagramElement = selectedDiagramElements.get(selectedDiagramElements.size() - 1);
		final Style currentStyle = diagramElement.getStyle();

		final FontSize lastFontSizeSelected = currentStyle.getFontSize() != null ? currentStyle.getFontSize()
				: FontSize.Default;
		final LineWidth lastLineWidthSelected = currentStyle.getLineWidth() != null ? currentStyle.getLineWidth()
				: LineWidth.Default;

		final Button backgroundButton = backgroundPaintListener.getButton();
		backgroundButton.setEnabled(enableBackground);

		final Button fontColorButton = fontColorPaintListener.getButton();
		fontColorButton.setEnabled(enableFontOptions);

		final Button outlineButton = outlinePaintListener.getButton();
		outlineButton.setEnabled(enableOutlineOption);

		backgroundPaintListener.setDefaultColor(toRGB(diagramElement.getDefaultBackgroundColor()));
		fontColorPaintListener.setDefaultColor(toRGB(diagramElement.getDefaultFontColor()));
		outlinePaintListener.setDefaultColor(toRGB(diagramElement.getDefaultOutlineColor()));

		final RGB background;
		if (enableBackground) {
			background = currentStyle.getBackgroundColor() == null ? null : toRGB(currentStyle.getBackgroundColor());
		} else {
			background = disableColor;
		}

		final RGB fontColor;
		if (enableFontOptions) {
			fontColor = currentStyle.getFontColor() == null ? null : toRGB(currentStyle.getFontColor());
		} else {
			fontColor = disableColor;
		}

		final RGB outline;
		if (enableOutlineOption) {
			outline = currentStyle.getOutlineColor() == null ? null : toRGB(currentStyle.getOutlineColor());
		} else {
			outline = disableColor;
		}

		// Update UI
		setComboViewersEnabled(enableFontOptions, enableLineWidth);
		setStructuredSelection(lastFontSizeSelected, lastLineWidthSelected);
		setPaintListenerColors(background, fontColor, outline);
	}

	private boolean supportsFontOptions(final DiagramElement de) {
		return de.getName() != null || de.getGraphic() instanceof Label;
	}

	private boolean supportsLineWidth(final DiagramElement de) {
		return de.getGraphic() instanceof AgeConnection;
	}

	private boolean supportsBackground(final DiagramElement de) {
		return !(de.getGraphic() instanceof Label);
	}

	private boolean supportsOutline(final DiagramElement de) {
		return !(de.getGraphic() instanceof Label);
	}

	private static RGB toRGB(final java.awt.Color color) {
		return new RGB(color.getRed(), color.getGreen(), color.getBlue());
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

	private void setPaintListenerColors(final RGB background, final RGB fontColor, final RGB outline) {
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

	private class ColorSelectionListener extends SelectionAdapter {
		private ColorSelectionListener(final StylePaintListener paintListener, final StyleCommand styleCmd) {
			this.paintListener = paintListener;
			this.styleCmd = styleCmd;
		}

		private Button createColorButton(final Composite parent, final ImageDescriptor imgDescriptor) {
			final Button btn = new Button(parent, SWT.PUSH);
			btn.setImage(imgDescriptor.createImage());
			btn.addDisposeListener(e -> {
				btn.getImage().dispose();
			});
			return btn;
		}

		@Override
		public void widgetSelected(final SelectionEvent e) {
			final Shell shell = new Shell(Display.getCurrent(), SWT.NO_TRIM);
			GridLayoutFactory.fillDefaults().spacing(0, 0).numColumns(6).applyTo(shell);

			// Create preset color buttons
			for (final PresetColor pc : colors) {
				final Button btn = createColorButton(shell, pc.imageDescriptor);
				btn.addSelectionListener(new ColorSelectionAdapter(shell, paintListener, pc.rgb, styleCmd));
			}

			// Create custom color button
			final boolean hasCustomColor = customPC != null;
			final PresetColor customPresetColor = hasCustomColor ? customPC : white;
			final Button customColorBtn = createButton(shell, customPresetColor.imageDescriptor);
			customColorBtn.setEnabled(hasCustomColor);
			customColorBtn.addSelectionListener(
					new ColorSelectionAdapter(shell, paintListener, customPresetColor.rgb, styleCmd));

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
						paintListener.setColor(customPC.rgb);
						runStyleCommand(createAWTColor(customPC.rgb), styleCmd);
					}
				}
			});

			// Default button
			final Button defaultColorBtn = new Button(shell, SWT.PUSH);
			defaultColorBtn.setText("Default");
			GridDataFactory.fillDefaults().grab(true, true).span(6, 0).applyTo(defaultColorBtn);
			defaultColorBtn.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					shell.dispose();
					paintListener.setColor(null);
					runStyleCommand(null, styleCmd);
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
		private final Button button;
		private RGB rgb;
		private RGB defaultRgb;
		private Color color;

		private StylePaintListener(final Button button, final StyleCommand styleCmd) {
			this.button = button;
			this.button.addPaintListener(this);
			this.button.addSelectionListener(new ColorSelectionListener(this, styleCmd));
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

		private void setDefaultColor(final RGB defaultRgb) {
			this.defaultRgb = defaultRgb;
		}

		private void setColor(final RGB newRgb) {
			if (rgb != null) {
				resourceMgr.destroyColor(rgb);
			}

			this.rgb = newRgb == null ? defaultRgb : newRgb;
			this.color = resourceMgr.createColor(rgb);
			button.redraw();
		}

		private Button getButton() {
			return button;
		}

	}

	private static interface CreateStyle {
		void createStyle(final DiagramElement diagramElement, final StyleBuilder sb, final Object value);
	}

	private static class StyleCommand {
		public StyleCommand(final String desc, final CreateStyle createStyle) {
			this.desc = desc;
			this.createStyle = createStyle;
		}

		private String getDescription() {
			return desc;
		}

		private Style getStyle(final DiagramElement diagramElement, final Object value) {
			final StyleBuilder sb = StyleBuilder.create(diagramElement.getStyle());
			createStyle.createStyle(diagramElement, sb, value);
			return sb.build();
		}

		private final String desc;
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
			}
		}

		private final StyleCommand styleCmd;
	}

	private static Object createAWTColor(final RGB color) {
		return new java.awt.Color(color.red, color.green, color.blue);
	}

	private void runStyleCommand(final Object value, final StyleCommand styleCmd) {
		ageDiagram.modify(styleCmd.getDescription(), m -> {
			for (final DiagramElement diagramElement : selectedDiagramElements) {
				m.setStyle(diagramElement, styleCmd.getStyle(diagramElement, value));
			}
		});
	}

	private class ColorSelectionAdapter extends SelectionAdapter {
		public ColorSelectionAdapter(final Shell shell, final StylePaintListener paintListener, final RGB color,
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

		private final RGB color;
		private final StylePaintListener paintListener;
		private final StyleCommand styleCmd;
		private final Shell shell;
	}

	private static final Point COLOR_ICON_SIZE = new Point(18, 18);

	private static class PresetColor {
		private RGB rgb;
		private ImageDescriptor imageDescriptor;

		private PresetColor(final RGB rgb) {
			setColor(rgb);
		}

		private void setColor(final RGB newRgb) {
			this.rgb = newRgb;
			final ImageData data = getImageData(rgb);
			this.imageDescriptor = ImageDescriptor.createFromImageDataProvider(zoom -> zoom == 100 ? data : null);
		}

		private static ImageData getImageData(final RGB rgb) {
			final ImageData data = new ImageData(COLOR_ICON_SIZE.x, COLOR_ICON_SIZE.y, 1,
					new PaletteData(new RGB[] { rgb }));

			for (int i = 0; i < COLOR_ICON_SIZE.y; i++) {
				data.setPixel(0, i, 1);
			}

			for (int i = 0; i < COLOR_ICON_SIZE.y; i++) {
				data.setPixel(COLOR_ICON_SIZE.x - 1, i, 1);
			}

			for (int i = 0; i < COLOR_ICON_SIZE.x; i++) {
				data.setPixel(i, 0, 1);
			}

			for (int i = 0; i < COLOR_ICON_SIZE.x; i++) {
				data.setPixel(i, COLOR_ICON_SIZE.y - 1, 1);
			}

			return data;
		}
	}

	private ComboViewerSelection lineWidthSelectionListener = new ComboViewerSelection(
			new StyleCommand("Set Line Width", (diagramElement, sb, value) -> {
				if(supportsLineWidth(diagramElement)) {
					final LineWidth lineWidth = (LineWidth) value;
					sb.lineWidth(lineWidth == LineWidth.Default ? null : lineWidth);
				}
			}));

	private ComboViewerSelection fontSizeSelectionListener = new ComboViewerSelection(
			new StyleCommand("Set Font Size", (diagramElement, sb, value) -> {
				if (supportsFontOptions(diagramElement)) {
					final FontSize fontSize = (FontSize) value;
					sb.fontSize(fontSize == FontSize.Default ? null : fontSize);
				}
			}));

	private final static ImageDescriptor outlineIcon = Activator.getImageDescriptor("icons/Outline.gif");
	private final static ImageDescriptor backgroundIcon = Activator.getImageDescriptor("icons/Background.gif");
	private final static ImageDescriptor fontColorIcon = Activator.getImageDescriptor("icons/FontColor.gif");
	private AgeDiagram ageDiagram;
	private ResourceManager resourceMgr;
	private List<DiagramElement> selectedDiagramElements = new ArrayList<>();
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

	private final List<PresetColor> colors = new ArrayList<>();
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
