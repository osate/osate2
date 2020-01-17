/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.ge.internal.ui.properties;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.graphiti.ui.editor.DiagramEditorInput;
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
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
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
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.graphics.internal.AgeConnection;
import org.osate.ge.graphics.internal.Label;
import org.osate.ge.internal.Activator;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramElementPredicates;
import org.osate.ge.internal.graphiti.services.GraphitiService;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;
import org.osate.ge.internal.ui.util.InternalPropertySectionUtil;
import org.osate.ge.internal.ui.util.UiUtil;
import org.osate.ge.internal.util.StringUtil;

import com.google.common.collect.Lists;

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
		createImageSection(containerComposite);
		createButtonSection(containerComposite);
		InternalPropertySectionUtil.setPropertiesHelp(aTabbedPropertySheetPage.getControl());
	}

	@Override
	public void dispose() {
		if (resourceMgr != null) {
			resourceMgr.dispose();
		}
	}

	private void createComboViewerSection(final Composite parent) {
		FormData fd;

		primaryLabelVisibleLabel = createLabel(parent, "Label Visibility:");
		fd = new FormData();
		fd.top = new FormAttachment(5, 0);
		fd.left = new FormAttachment(0, 10);
		primaryLabelVisibleLabel.setLayoutData(fd);

		primaryLabelVisibleViewer = createComboViewer(parent, LabelVisibility.values());
		fd = new FormData();
		fd.top = new FormAttachment(primaryLabelVisibleLabel, 0, SWT.TOP);
		fd.left = new FormAttachment(primaryLabelVisibleLabel, 10);
		primaryLabelVisibleViewer.getCombo().setLayoutData(fd);
		primaryLabelVisibleViewer.getControl().setData(UiUtil.AUTOMATED_SWTBOT_TESTING_KEY,
				primaryLabelVisibilityCombo);

		fontSizeLabel = createLabel(parent, "Font Size:");
		fd = new FormData();
		fd.top = new FormAttachment(primaryLabelVisibleLabel, 10);
		fd.left = new FormAttachment(0, 10);
		fontSizeLabel.setLayoutData(fd);

		fontSizeComboViewer = createComboViewer(parent, FontSize.values());
		fd = new FormData();
		fd.top = new FormAttachment(fontSizeLabel, 0, SWT.TOP);
		fd.left = new FormAttachment(primaryLabelVisibleViewer.getControl(), 0, SWT.LEFT);
		fontSizeComboViewer.getCombo().setLayoutData(fd);
		fontSizeComboViewer.getControl().setData(UiUtil.AUTOMATED_SWTBOT_TESTING_KEY, fontSizeCombo);

		lineWidthLabel = createLabel(parent, "Line Width:");
		fd = new FormData();
		fd.top = new FormAttachment(fontSizeLabel, 10);
		fd.left = new FormAttachment(0, 10);
		lineWidthLabel.setLayoutData(fd);

		lineWidthComboViewer = createComboViewer(parent, LineWidth.values());
		fd = new FormData();
		fd.top = new FormAttachment(lineWidthLabel, 0, SWT.TOP);
		fd.left = new FormAttachment(primaryLabelVisibleViewer.getControl(), 0, SWT.LEFT);
		lineWidthComboViewer.getCombo().setLayoutData(fd);
		lineWidthComboViewer.getControl().setData(UiUtil.AUTOMATED_SWTBOT_TESTING_KEY, lineWidthCombo);
	}

	private void createButtonSection(final Composite parent) {
		final Button outlineButton = createButton(parent, outlineIcon, "Outline Color", outlineColorId);
		FormData fd = new FormData();
		fd.top = new FormAttachment(imageLabel, 10);
		fd.left = new FormAttachment(0, 30);
		outlineButton.setLayoutData(fd);
		outlinePaintListener = new StylePaintListener(outlineButton,
				new StyleCommand("Set Outline", (diagramElement, sb, value) -> {
					if (supportsOutline(diagramElement)) {
						final org.osate.ge.graphics.Color outline = (org.osate.ge.graphics.Color) value;
						sb.outlineColor(outline);
					}
				}));

		final Button fontColorButton = createButton(parent, fontColorIcon, "Font Color", fontColorId);
		fd = new FormData();
		fd.top = new FormAttachment(outlineButton, 0, SWT.TOP);
		fd.left = new FormAttachment(outlineButton, 0);
		fontColorButton.setLayoutData(fd);
		fontColorPaintListener = new StylePaintListener(fontColorButton,
				new StyleCommand("Set Font Color", (diagramElement, sb, value) -> {
					if (supportsFontOptions(diagramElement)) {
						final org.osate.ge.graphics.Color fontColor = (org.osate.ge.graphics.Color) value;
						sb.fontColor(fontColor);
					}
				}));

		final Button backgroundButton = createButton(parent, backgroundIcon, "Background Color", backgroundColorId);
		fd = new FormData();
		fd.top = new FormAttachment(fontColorButton, 0, SWT.TOP);
		fd.left = new FormAttachment(fontColorButton, 0);
		backgroundButton.setLayoutData(fd);
		backgroundPaintListener = new StylePaintListener(backgroundButton,
				new StyleCommand("Set Background", (diagramElement, sb, value) -> {
					if (supportsBackground(diagramElement)) {
						final org.osate.ge.graphics.Color background = (org.osate.ge.graphics.Color) value;
						sb.backgroundColor(background);
					}
				}));
	}

	private void createImageSection(final Composite parent) {
		// Create controls
		imageLabel = createLabel(parent, "Show as Image:");
		toggleShowImage = new Button(parent, SWT.CHECK);
		toggleShowImage.setToolTipText("Show Image");
		setImageButton = createButton(parent, imageIcon, "Set Image", setImageId);

		// Set layout
		FormData fd = new FormData();
		fd.top = new FormAttachment(lineWidthLabel, 10);
		fd.left = new FormAttachment(0, 10);
		imageLabel.setLayoutData(fd);

		fd = new FormData();
		fd.top = new FormAttachment(imageLabel, 0, SWT.TOP);
		fd.left = new FormAttachment(toggleShowImage, 0);
		setImageButton.setLayoutData(fd);

		fd = new FormData();
		fd.top = new FormAttachment(setImageButton, 0, SWT.CENTER);
		fd.left = new FormAttachment(primaryLabelVisibleViewer.getControl(), 0, SWT.LEFT);
		toggleShowImage.setLayoutData(fd);

		toggleShowImage.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				final boolean isVisible = toggleShowImage.getSelection();
				runStyleCommand(isVisible, showAsImageStyleCmd);
			}
		});

		setImageButton.addSelectionListener(imageSelectionAdapter);
	}

	// Determine if the file is an image and supported type
	private boolean isImageFile(final IFile file) {
		final String ext = file.getFileExtension();
		for (final String suf : supportedImageTypes) {
			if (suf.equalsIgnoreCase(ext)) {
				return true;
			}
		}
		return false;
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
		boolean enablePrimaryLabelVisibleOption = false;
		boolean enableImage = false;
		boolean enableShowAsImage = false;
		boolean isShowAsImageEnabled = false;
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

			if (supportsPrimaryLabelVisible(diagramElement)) {
				enablePrimaryLabelVisibleOption = true;
			}

			// Image options
			if (DiagramElementPredicates.supportsImage(diagramElement)) {
				enableImage = true;
				final Style style = diagramElement.getStyle();
				// If any elements have an image style
				if (style.getImagePath() != null) {
					enableShowAsImage = true;

					// If any elements are images
					if (Boolean.TRUE.equals(style.getShowAsImage())) {
						isShowAsImageEnabled = true;
					}
				}
			}
		}

		// Get the diagram from the selected diagram elements
		ageDiagram = Objects.requireNonNull(UiUtil.getDiagram(selectedDiagramElements), "Unable to retrieve diagram");

		// Set image controls
		imageLabel.setEnabled(enableImage);
		setImageButton.setEnabled(enableImage);
		toggleShowImage.setEnabled(enableShowAsImage);
		toggleShowImage.setSelection(isShowAsImageEnabled);

		// Set options to match last selected element
		final DiagramElement diagramElement = selectedDiagramElements.get(selectedDiagramElements.size() - 1);
		final Style currentStyle = diagramElement.getStyle();

		final FontSize lastFontSizeSelected = FontSize.getByValue(currentStyle.getFontSize());
		final LineWidth lastLineWidthSelected = LineWidth.getByValue(currentStyle.getLineWidth());
		final LabelVisibility lastLabelVisibilitySelected = LabelVisibility
				.getByValue(currentStyle.getPrimaryLabelVisible());

		final Button backgroundButton = backgroundPaintListener.getButton();
		backgroundButton.setEnabled(enableBackground);

		final Button fontColorButton = fontColorPaintListener.getButton();
		fontColorButton.setEnabled(enableFontOptions);

		final Button outlineButton = outlinePaintListener.getButton();
		outlineButton.setEnabled(enableOutlineOption);

		final Style defaultStyle = StyleBuilder.create(diagramElement.getGraphicalConfiguration().style, Style.DEFAULT)
				.build();
		backgroundPaintListener.setDefaultColor(toRGB(defaultStyle.getBackgroundColor()));
		fontColorPaintListener.setDefaultColor(toRGB(defaultStyle.getFontColor()));
		outlinePaintListener.setDefaultColor(toRGB(defaultStyle.getOutlineColor()));

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
		setComboViewersEnabled(enableFontOptions, enableLineWidth, enablePrimaryLabelVisibleOption);
		setStructuredSelection(lastFontSizeSelected, lastLineWidthSelected, lastLabelVisibilitySelected);
		setPaintListenerColors(background, fontColor, outline);
	}

	private static boolean supportsFontOptions(final DiagramElement de) {
		return de.getLabelName() != null || de.getGraphic() instanceof Label;
	}

	private static boolean supportsLineWidth(final DiagramElement de) {
		return de.getGraphic() instanceof AgeConnection;
	}

	private static boolean supportsBackground(final DiagramElement de) {
		return !(de.getGraphic() instanceof Label);
	}

	private static boolean supportsOutline(final DiagramElement de) {
		return !(de.getGraphic() instanceof Label);
	}

	private static boolean supportsPrimaryLabelVisible(final DiagramElement de) {
		return !(de.getGraphic() instanceof Label);
	}

	private static RGB toRGB(final org.osate.ge.graphics.Color color) {
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

	private static Button createButton(final Composite parent, final ImageDescriptor imageDescriptor,
			final String toolTipText, final String id) {
		final Button button = new Button(parent, SWT.PUSH);
		button.setImage(imageDescriptor.createImage());
		button.setToolTipText(toolTipText);
		button.setData(UiUtil.AUTOMATED_SWTBOT_TESTING_KEY, id);

		return button;
	}

	private void setComboViewersEnabled(final boolean showFontSize, final boolean showLineWidth,
			final boolean enablePrimaryLabelVisibleOption) {
		fontSizeLabel.setEnabled(showFontSize);
		fontSizeComboViewer.getControl().setEnabled(showFontSize);
		lineWidthLabel.setEnabled(showLineWidth);
		lineWidthComboViewer.getControl().setEnabled(showLineWidth);
		primaryLabelVisibleLabel.setEnabled(enablePrimaryLabelVisibleOption);
		primaryLabelVisibleViewer.getControl().setEnabled(enablePrimaryLabelVisibleOption);
	}

	private void setPaintListenerColors(final RGB background, final RGB fontColor, final RGB outline) {
		backgroundPaintListener.setColor(background);
		fontColorPaintListener.setColor(fontColor);
		outlinePaintListener.setColor(outline);
	}

	private void setStructuredSelection(final FontSize fontSize, final LineWidth lineWidth,
			final LabelVisibility labelVisibility) {
		fontSizeComboViewer.removeSelectionChangedListener(fontSizeSelectionListener);
		fontSizeComboViewer
		.setSelection(fontSize == null ? StructuredSelection.EMPTY : new StructuredSelection(fontSize));
		fontSizeComboViewer.addSelectionChangedListener(fontSizeSelectionListener);

		lineWidthComboViewer.removeSelectionChangedListener(lineWidthSelectionListener);
		lineWidthComboViewer
		.setSelection(lineWidth == null ? StructuredSelection.EMPTY : new StructuredSelection(lineWidth));
		lineWidthComboViewer.addSelectionChangedListener(lineWidthSelectionListener);

		primaryLabelVisibleViewer.removeSelectionChangedListener(primaryLabelVisibleSelectionListener);
		primaryLabelVisibleViewer.setSelection(
				labelVisibility == null ? StructuredSelection.EMPTY : new StructuredSelection(labelVisibility));
		primaryLabelVisibleViewer.addSelectionChangedListener(primaryLabelVisibleSelectionListener);
	}

	private class ColorSelectionListener extends SelectionAdapter {
		private ColorSelectionListener(final StylePaintListener paintListener, final StyleCommand styleCmd) {
			this.paintListener = paintListener;
			this.styleCmd = styleCmd;
		}

		private Button createColorButton(final Composite parent, final ImageDescriptor imgDescriptor) {
			final Button btn = new Button(parent, SWT.PUSH);
			btn.setImage(imgDescriptor.createImage());
			btn.setData(UiUtil.AUTOMATED_SWTBOT_TESTING_KEY, presetColorId);
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
			final Button customColorBtn = createButton(shell, customPresetColor.imageDescriptor, "Custom...",
					customColorId);
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
						runStyleCommand(createGeColor(customPC.rgb), styleCmd);
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

			shell.pack();

			shell.setLocation(getShellPosition(shell.getSize(), (Button) e.getSource(), 50));

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

	private static org.osate.ge.graphics.Color createGeColor(final RGB color) {
		return new org.osate.ge.graphics.Color(color.red, color.green, color.blue);
	}

	public Point getShellPosition(final Point widgetSize, final Button button,
			final int minSpacingFromDisplayRightAndBottom) {
		// Position the shell
		final Point unclampedShellPosition = Display.getCurrent().map(button.getParent(), null, button.getLocation().x,
				button.getLocation().y + button.getSize().y);
		final Rectangle clientArea = Display.getCurrent().getClientArea();
		final Point shellPosition = new Point(
				Math.min(unclampedShellPosition.x,
						clientArea.width - widgetSize.x - minSpacingFromDisplayRightAndBottom),
				Math.min(unclampedShellPosition.y,
						clientArea.height - widgetSize.y - minSpacingFromDisplayRightAndBottom));

		return shellPosition;
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
			runStyleCommand(createGeColor(color), styleCmd);
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
			final PaletteData paletteData = new PaletteData(new RGB[] { rgb, new RGB(0, 0, 0) });

			final ImageData data = new ImageData(COLOR_ICON_SIZE.x, COLOR_ICON_SIZE.y, 1, paletteData);

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
				if (supportsLineWidth(diagramElement) && value != null) {
					sb.lineWidth(((LineWidth) value).getValue());
				}
			}));

	private ComboViewerSelection fontSizeSelectionListener = new ComboViewerSelection(
			new StyleCommand("Set Font Size", (diagramElement, sb, value) -> {
				if (supportsFontOptions(diagramElement) && value != null) {
					sb.fontSize(((FontSize) value).getValue());
				}
			}));

	private ComboViewerSelection primaryLabelVisibleSelectionListener = new ComboViewerSelection(
			new StyleCommand("Set Primary Label Visibility", (diagramElement, sb, value) -> {
				if (supportsPrimaryLabelVisible(diagramElement) && value != null) {
					sb.primaryLabelVisible(((LabelVisibility) value).getValue());
				}
			}));

	private SelectionAdapter imageSelectionAdapter = new SelectionAdapter() {
		@Override
		public void widgetSelected(final SelectionEvent e) {
			// Open menu that lets user choose new image or remove image
			final Menu popupMenu = new Menu(setImageButton);
			// Add menu item to launch choose new image dialog
			final MenuItem chooseImgMenuItem = new MenuItem(popupMenu, SWT.NONE);
			chooseImgMenuItem.setText("Select...");
			chooseImgMenuItem.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					final AgeDiagramEditor editor = UiUtil.getActiveDiagramEditor();
					if (editor != null) {
						final ElementTreeSelectionDialog dialog = createSelectionDialog(editor);
						if (dialog.open() == Window.OK) {
							final IFile iFile = (IFile) dialog.getResult()[0];
							runStyleCommand(iFile.getFullPath(), imageStyleCommand);
						}
					}
				}
			});

			if (toggleShowImage.isEnabled()) {
				// Menu item to remove image from diagram element
				final MenuItem removeImgMenuItem = new MenuItem(popupMenu, SWT.NONE);
				removeImgMenuItem.setText("Remove");
				removeImgMenuItem.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(final SelectionEvent e) {
						runStyleCommand(null, imageStyleCommand);
					}
				});
			}
			// Set menu location
			popupMenu.setLocation(getShellPosition(setImageButton.getSize(), setImageButton, 5));
			// Show menu
			popupMenu.setVisible(true);
		}

		private ElementTreeSelectionDialog createSelectionDialog(final AgeDiagramEditor editor) {
			final ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(
					Display.getCurrent().getActiveShell(), new WorkbenchLabelProvider(),
					new BaseWorkbenchContentProvider());
			try {
				final GraphitiService graphitiService = Objects
						.requireNonNull(Adapters.adapt(editor, GraphitiService.class),
								"graphiti service must not be null");
				// Configure selection dialog
				dialog.setTitle("Select an Image");
				dialog.setMessage("Select an image.");
				dialog.setAllowMultiple(false);
				dialog.setHelpAvailable(false);
				final IProject project = graphitiService.getProject();
				final IProject[] referencedProjects = project.getReferencedProjects();
				// Filter Resources
				dialog.addFilter(new ImageSelectionViewerFilter(Lists.asList(project, referencedProjects)));
				dialog.setValidator(selection -> {
					if (selection.length > 0 && selection[0] instanceof IFile) {
						return new Status(IStatus.OK, Activator.PLUGIN_ID, "");
					}
					return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "No image selected.");
				});

				// Set initial selection
				final IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
				// Allow selection of project resources
				dialog.setInput(workspaceRoot);

				if (editor.getEditorInput() instanceof DiagramEditorInput) {
					final DiagramEditorInput dei = (DiagramEditorInput) editor.getEditorInput();
					// Get file directory
					final URI fileDirectory = dei.getUri().trimFragment().trimSegments(1);
					dialog.setInitialSelection(workspaceRoot.findMember(fileDirectory.toPlatformString(true)));
				}
			} catch (final CoreException e) {
				throw new RuntimeException("unable to get referenced projects");
			}

			return dialog;
		}

		// Set image and visibility
		private final StyleCommand imageStyleCommand = new StyleCommand("Set Image", (diagramElement, sb, value) -> {
			if (DiagramElementPredicates.supportsImage(diagramElement)) {
				final IPath imagePath = (IPath) value;
				sb.imagePath(imagePath);
				sb.showAsImage(imagePath != null);
			}
		});
	};

	// Set image visibility
	final StyleCommand showAsImageStyleCmd = new StyleCommand("Show as Image", (diagramElement, sb, value) -> {
		if (DiagramElementPredicates.supportsImage(diagramElement) && value != null
				&& diagramElement.getStyle().getImagePath() != null) {
			sb.showAsImage((Boolean) value);
		}
	});

	// Only allow resources that are in the current project or referenced projects to be in dialog
	private class ImageSelectionViewerFilter extends ViewerFilter {
		private final List<IProject> projects;

		private ImageSelectionViewerFilter(final List<IProject> projects) {
			this.projects = projects;
		}

		@Override
		public boolean select(final Viewer viewer, final Object parentElement, final Object element) {
			return isReferencedProject(element) || element instanceof IFolder
					|| (element instanceof IFile && isImageFile((IFile) element));
		}

		private boolean isReferencedProject(final Object element) {
			for (final IProject project : projects) {
				if (project == element) {
					return true;
				}
			}
			return false;
		}
	}

	public final static String primaryLabelVisibilityCombo = "org.osate.ge.properties.PrimaryLabelVisibility";
	public final static String fontSizeCombo = "org.osate.ge.properties.FontSize";
	public final static String lineWidthCombo = "org.osate.ge.properties.LineWidth";
	public final static String backgroundColorId = "org.osate.ge.properties.BackgroundColor";
	public final static String fontColorId = "org.osate.ge.properties.FontColor";
	public final static String outlineColorId = "org.osate.ge.properties.OutlineColor";
	public final static String customColorId = "org.osate.ge.properties.CustomColor";
	public final static String presetColorId = "org.osate.ge.properties.PresetColorButton";
	public final static String setImageId = "org.osate.ge.properties.SetImage";
	private final static ImageDescriptor outlineIcon = Activator.getImageDescriptor("icons/Outline.gif");
	private final static ImageDescriptor backgroundIcon = Activator.getImageDescriptor("icons/Background.gif");
	private final static ImageDescriptor fontColorIcon = Activator.getImageDescriptor("icons/FontColor.gif");
	private final static ImageDescriptor imageIcon = Activator.getImageDescriptor("icons/BackgroundImage.gif");
	private final String[] supportedImageTypes = { "bmp", "png", "jpg", "jpeg", "gif" };
	private AgeDiagram ageDiagram;
	private ResourceManager resourceMgr;
	private List<DiagramElement> selectedDiagramElements = new ArrayList<>();
	private Button setImageButton;
	private Button toggleShowImage;
	private org.eclipse.swt.widgets.Label fontSizeLabel;
	private org.eclipse.swt.widgets.Label lineWidthLabel;
	private org.eclipse.swt.widgets.Label imageLabel;
	private ComboViewer fontSizeComboViewer;
	private ComboViewer lineWidthComboViewer;
	private org.eclipse.swt.widgets.Label primaryLabelVisibleLabel;
	private ComboViewer primaryLabelVisibleViewer;

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

	private static enum LineWidth {
		Default(null), Small(2.0), Medium(4.0), Large(6.0);

		private LineWidth(final Double value) {
			this.value = value;
		}

		public Double getValue() {
			return value;
		}

		public static LineWidth getByValue(final Double value) {
			return Stream.of(values()).filter(v -> Objects.equals(v.value, value)).findAny().orElse(null);
		}

		private final Double value;
	}

	private static enum FontSize {
		Default(null), Small(8.0), Medium(10.0), Large(16.0), ExtraLarge(20.0);

		private FontSize(final Double value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return StringUtil.camelCaseToUser(super.toString());
		}

		public Double getValue() {
			return value;
		}

		public static FontSize getByValue(final Double value) {
			return Stream.of(values()).filter(v -> Objects.equals(v.value, value)).findAny().orElse(null);
		}

		private final Double value;
	}

	private static enum LabelVisibility {
		Default(null), Show(true), Hide(false);

		private LabelVisibility(final Boolean value) {
			this.value = value;
		}

		public Boolean getValue() {
			return value;
		}

		public static LabelVisibility getByValue(final Boolean value) {
			return Stream.of(values()).filter(v -> Objects.equals(v.value, value)).findAny().orElse(null);
		}

		private final Boolean value;
	}
}
