/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.gef.ui.editor.export;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.osate.ge.graphics.Dimension;

class ExportDiagramDialog {
	private static final Dimension MAX_IMAGE_DIMENSIONS = new Dimension(4000, 4000);
	private static final Dimension MIN_IMAGE_DIMENSIONS = new Dimension(50, 50);
	private static final double MAX_SCALE_FACTOR = 5.0;
	private static final double MIN_SCALE_FACTOR = 0.1;
	private static final String[] WIDTHS = new String[] { "320", "640", "800", "1024", "1280", "1600", "1920" };
	private static final String[] HEIGHTS = new String[] { "200", "400", "600", "768", "1024", "1280" };
	private static final double[] SCALE_FACTORS = new double[] { 0.5, 1.0, 2.0, 4.0 };

	public static enum ImageFormat {
		BMP, JPEG, PNG, SVG
	}

	public static class Result {
		private final boolean all;
		private final ImageFormat format;
		private final double scaleFactor;
		private final Dimension dim;

		Result(final boolean all, final ImageFormat format, final double scaleFactor, final Dimension dim) {
			this.all = all;
			this.format = format;
			this.scaleFactor = scaleFactor;
			this.dim = dim;
		}

		/**
		 * Returns whether to export the entire figure.
		 * @return true if the user selected to export all the diagram. False if the user selected to export just selected elements.
		 */
		public boolean getAll() {
			return all;
		}

		public ImageFormat getFormat() {
			return format;
		}

		public double getScaleFactor() {
			return scaleFactor;
		}

		public Dimension getDimension() {
			return dim;
		}
	}

	private static class InnerDialog extends Dialog {
		private final Dimension rootElement;
		private final Dimension selectedElement;
		private Dimension figure;
		private Result result;
		private Button allFigureButton;
		private Combo scaleFactorCombo;
		private Combo widthCombo;
		private Combo heightCombo;
		private Combo formatCombo;
		private double scaleFactor = 1.0; // default value for scaling
		private boolean internalModification = false; // flag so listeners are not executed during modifications

		private InnerDialog(final Shell parentShell, final Dimension rootElement, final Dimension selectedElement) {
			super(parentShell);
			this.rootElement = rootElement;
			this.selectedElement = selectedElement;
			setShellStyle(SWT.CLOSE | SWT.PRIMARY_MODAL | SWT.BORDER | SWT.TITLE);
			determinePossibleFigures();
		}

		private void determinePossibleFigures() {
			figure = selectedElement == null ? rootElement : selectedElement;
		}

		@Override
		protected void configureShell(final Shell newShell) {
			super.configureShell(newShell);
			newShell.setText("Export Diagram");
		}

		@Override
		protected Control createDialogArea(final Composite parent) {
			final Composite container = (Composite) super.createDialogArea(parent);
			container.setLayout(new GridLayout(2, false));
			createFigureGroup(container);
			createScaleGroup(container);
			createFormatGroup(container);
			return container;
		}

		private void createLabel(final Group parent, final String text) {
			final Label label = new Label(parent, SWT.NONE);
			label.setText(text);
		}

		private Combo createCombo(final Group parent, final String[] items) {
			final Combo combo = new Combo(parent, SWT.DROP_DOWN);
			combo.setItems(WIDTHS);
			combo.setLayoutData(GridDataFactory.fillDefaults().grab(true, false).create());
			return combo;
		}

		@Override
		public void create() {
			super.create();
			updateControls((long) figure.width, (long) figure.height);

			// Create modify and verify listeners
			final ModifyListener modifyListener = e -> {
				if (internalModification) {
					return;
				}

				try {
					final Combo combo = (Combo) e.getSource();
					if (combo.getText().isEmpty() || combo.getText().equals(".")) {
						setOkBtnEnabled(false);
						return;
					}

					internalModification = true;
					final long width, height;
					if (combo == widthCombo) {
						// Get new width value, update scale factor and height
						width = Long.valueOf(combo.getText());
						scaleFactor = width / figure.width;
						height = Math.round(scaleFactor * figure.height);
					} else if (combo == heightCombo) {
						// Get new height value, update scale factor and width
						height = Long.valueOf(combo.getText());
						scaleFactor = height / figure.height;
						width = Math.round(scaleFactor * figure.width);
					} else {
						// Update width and height for new scale factor
						width = Math.round(scaleFactor * figure.width);
						height = Math.round(scaleFactor * figure.height);
					}

					updateControls(width, height);
				} finally {
					internalModification = false;
				}
			};

			final VerifyListener verifyListener = e -> {
				// Do not allow letters
				if (Character.isLetter(e.character)) {
					e.doit = false;
					return;
				}

				final Combo combo = (Combo) e.getSource();
				final String originalText = combo.getText();
				final String updatedText = originalText.substring(0, e.start) + e.text + originalText.substring(e.end);
				if (combo == scaleFactorCombo) {
					try {
						// Allow for empty or a period to be placed in scaled combo text
						if (updatedText.isEmpty() || updatedText.equals(".")) {
							scaleFactor = 0;
						} else {
							scaleFactor = Double.parseDouble(updatedText);
						}
					} catch (final Exception ex) {
						e.doit = false;
					}
				} else {
					// Verify Width and Height combos
					e.doit = isValidInteger(updatedText);
				}
			};

			// Add listeners here so initialization does not trigger listeners
			widthCombo.addVerifyListener(verifyListener);
			widthCombo.addModifyListener(modifyListener);
			heightCombo.addVerifyListener(verifyListener);
			heightCombo.addModifyListener(modifyListener);
			scaleFactorCombo.addVerifyListener(verifyListener);
			scaleFactorCombo.addModifyListener(modifyListener);
		}

		private void createFigureGroup(final Composite parent) {
			final Group figureGroup = createGroup(parent, "Figure");
			figureGroup.setLayout(new GridLayout(1, false));
			figureGroup.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

			final boolean isSingleSelection = selectedElement != null;
			allFigureButton = createButton(figureGroup, "All", !isSingleSelection, rootElement != null);
			createButton(figureGroup, "Selected (only single-selection)", isSingleSelection, isSingleSelection);
		}

		private Button createButton(final Group group, final String text, final boolean isSelected,
				final boolean isEnabled) {
			final Button btn = new Button(group, SWT.RADIO);
			btn.setText(text);
			btn.setSelection(isSelected);
			btn.setEnabled(isEnabled);
			btn.setLayoutData(GridDataFactory.fillDefaults().grab(true, false).create());
			btn.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					// Set figure to root or selection and update dialog controls
					figure = allFigureButton.getSelection() ? rootElement : selectedElement;
					updateControls((long) figure.width, (long) figure.height);
				}
			});
			return btn;
		}

		private Group createScaleGroup(final Composite parent) {
			final Group scaleGroup = createGroup(parent, "Size");
			scaleGroup.setLayoutData(GridDataFactory.fillDefaults().span(1, 2).grab(true, true).create());
			scaleGroup.setLayout(new GridLayout(2, false));

			createLabel(scaleGroup, "Scale-factor:");
			// Scale combo
			scaleFactorCombo = createCombo(scaleGroup, SWT.DROP_DOWN,
					DoubleStream.of(SCALE_FACTORS).mapToObj(Double::toString).toArray(String[]::new), "1.0");

			// Create width and height combos
			createLabel(scaleGroup, "Width:");
			widthCombo = createCombo(scaleGroup, WIDTHS);

			createLabel(scaleGroup, "Height:");
			heightCombo = createCombo(scaleGroup, HEIGHTS);

			return scaleGroup;
		}

		private void createFormatGroup(final Composite parent) {
			final Group formatGroup = createGroup(parent, "Image Format");
			formatGroup.setLayout(new GridLayout(2, false));
			formatGroup.setLayoutData(GridDataFactory.fillDefaults().grab(true, true).create());

			formatCombo = createCombo(formatGroup, SWT.DROP_DOWN | SWT.READ_ONLY,
					Stream.of(ImageFormat.values()).map(ImageFormat::toString).toArray(String[]::new),
					ImageFormat.SVG.toString());
		}

		private Group createGroup(final Composite parent, final String text) {
			final Group group = new Group(parent, SWT.NONE);
			group.setText(text);
			return group;
		}

		private Combo createCombo(final Group parent, final int style, final String[] items,
				final String defaultValue) {
			final Combo combo = new Combo(parent, style);
			combo.setItems(items);
			// Set default selection
			final int defaultIndex = getIndexOfItem(combo, defaultValue);
			combo.select(defaultIndex);
			combo.setLayoutData(GridDataFactory.fillDefaults().grab(true, false).create());
			return combo;
		}

		private int getIndexOfItem(final Combo combo, final String item) {
			return Math.max(0, Arrays.asList(combo.getItems()).indexOf(item));
		}

		@Override
		protected void okPressed() {
			// Set value for return
			result = new Result(allFigureButton.getSelection(), ImageFormat.valueOf(formatCombo.getText()), scaleFactor,
					new Dimension(Integer.valueOf(widthCombo.getText()), Integer.valueOf(heightCombo.getText())));
			super.okPressed();
		}

		public Result getResult() {
			return result;
		}

		// Update controls based on scale factor
		private void updateControls(final long width, final long height) {
			updateDimensionCombo(widthCombo, width);
			updateDimensionCombo(heightCombo, height);
			updateScaleFactorCombo();
			updateOkBtn(width, height);
		}

		private static void updateDimensionCombo(final Combo dimCombo, final long dim) {
			final String newText = Long.toString(dim);
			if (!dimCombo.getText().equals(Long.toString(dim))) {
				// Don't update if identical, otherwise cursor will move to the
				// first character
				dimCombo.setText(newText);
			}
		}

		private boolean isValidScaleFactor() {
			return scaleFactor >= MIN_SCALE_FACTOR && scaleFactor <= MAX_SCALE_FACTOR;
		}

		private static boolean isValidWidth(final long width) {
			return width >= MIN_IMAGE_DIMENSIONS.width && width <= MAX_IMAGE_DIMENSIONS.width;
		}

		private static boolean isValidHeight(final long height) {
			return height >= MIN_IMAGE_DIMENSIONS.height && height <= MAX_IMAGE_DIMENSIONS.height;
		}

		private void updateScaleFactorCombo() {
			try {
				final double oldValue = Double.parseDouble(scaleFactorCombo.getText());
				if (scaleFactor != oldValue) {
					scaleFactorCombo.setText(Double.toString(scaleFactor));
				}
			} catch (final NumberFormatException e) {
				scaleFactorCombo.setText(Double.toString(scaleFactor));
			}
		}

		private void updateOkBtn(final long width, final long height) {
			final boolean isEnable = isValidWidth(width) && isValidHeight(height) && isValidScaleFactor();
			setOkBtnEnabled(isEnable);
		}

		private void setOkBtnEnabled(final boolean isEnabled) {
			final Button okBtn = getButton(OK);
			okBtn.setEnabled(isEnabled);
		}

		private static boolean isValidInteger(final String input) {
			try {
				// Allows for erasing width or height in combo text
				Integer.parseInt(input.isEmpty() ? "0" : input);
			} catch (final Exception e) {
				return false;
			}

			return true;
		}
	}

	/**
	 * Open a modal dialog.
	 * @param parentShell the parent shell for the modal dialog.
	 * @param root the size of the entire diagram when the scale factor is 1.0
	 * @param selected the size of the selected element when the scale factor is 1.0
	 * @return the result of the dialog. An empty value is returned if the dialog is canceled.
	 */
	public static Optional<Result> open(final Shell parentShell, final Dimension root, final Dimension selected) {
		final InnerDialog dlg = new InnerDialog(parentShell, root, selected);
		dlg.open();

		return Optional.ofNullable(dlg.getResult());
	}

	public static void main(final String[] args) {
		open(new Shell(), new Dimension(700, 800), new Dimension(300, 400)).ifPresent(result -> {
			System.err.println("All: " + result.getAll());
			System.err.println("Format: " + result.getFormat());
			System.err.println("Scale Factor: " + result.getScaleFactor());
			System.err.println("Width: " + result.getDimension().width);
			System.err.println("Height: " + result.getDimension().height);
		});
	}
}
