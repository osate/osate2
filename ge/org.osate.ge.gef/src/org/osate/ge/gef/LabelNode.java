/**
 * Copyright (c) 2004-2023 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.gef;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;

/**
 * Node for displaying and styling labels. Lightweight wrapper around {@link Label} which implements {@link Stylable}.
 * Labels do not have backgrounds.
 */
public class LabelNode extends Region implements Stylable, HasLabelBackgroundColor {
	/**
	 * Max preferred width when wrapping is enabled.
	 */
	private static final double MAX_PREFERRED_WRAPPED_WIDTH = 300;

	private static final Insets PADDING_INSETS = new Insets(2.0, 6.0, 3.0, 6.0);

	private final Label text = new Label();

	/**
	 * Create a new instance
	 * @param txt the text to display in the label.
	 */
	public LabelNode(final String txt) {
		this.getChildren().addAll(text);
		apply(FxStyle.DEFAULT);
		setText(txt);
		text.setPadding(PADDING_INSETS);
	}

	/**
	 * Creates a new instance
	 */
	public LabelNode() {
		this("");
	}

	@Override
	protected void layoutChildren() {
		super.layoutChildren();

		final double width = this.getWidth();
		final double height = this.getHeight();
		text.resize(width, height);
	}

	@Override
	protected double computeMinWidth(double height) {
		return text.minWidth(height);
	}

	@Override
	protected double computeMinHeight(double width) {
		return text.minHeight(width);
	}

	@Override
	public double computePrefWidth(double height) {
		final double prefWidth = text.prefWidth(height);
		return text.isWrapText() ? Math.min(MAX_PREFERRED_WRAPPED_WIDTH, prefWidth) : prefWidth;
	}

	@Override
	public double computePrefHeight(double width) {
		return text.prefHeight(width);
	}

	@Override
	protected double computeMaxWidth(double height) {
		return text.maxWidth(height);
	}

	@Override
	protected double computeMaxHeight(double width) {
		return text.maxHeight(width);
	}

	@Override
	public final void apply(final FxStyle style) {
		text.setFont(style.getFont());
		text.setTextFill(style.getFontColor());
	}

	@Override
	public void setLabelBackgroundColor(final Color value) {
		// Set the background to match the specified color. The label background has an inset that matches the
		// text padding so the background matches the actual text.
		this.setBackground(new Background(
				new BackgroundFill(value, CornerRadii.EMPTY, PADDING_INSETS)));
	}

	/**
	 * Gets the text contained in the label
	 * @return the label's text
	 */
	public String getText() {
		return text.getText();
	}

	/**
	 * Sets the text contained in the label
	 * @param value the new text for the label
	 */
	public void setText(final String value) {
		text.setText(value);
		requestLayout();
	}

	/**
	 * Sets whether to allow text to be wrapped. If it is not wrapped, text which exceeds the available size will be truncated and an
	 * ellipsis will be rendered. Default to false.
	 * @param value whether to allow text to wrap.
	 */
	public void setWrapText(final boolean value) {
		text.setWrapText(value);
	}
}
