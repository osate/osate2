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
package org.osate.ge.graphics;

import org.eclipse.core.runtime.IPath;

public class Style {
	public static final Style EMPTY = StyleBuilder.create().build();
	public final static Style DEFAULT = StyleBuilder.create().backgroundColor(Color.WHITE).foregroundColor(Color.BLACK)
			.fontSize(10.0).lineWidth(2.0)
			.lineStyle(LineStyle.SOLID).labelsHorizontalPosition(LabelPosition.GRAPHIC_BEGINNING)
			.primaryLabelVisible(true)
			.labelsVerticalPosition(LabelPosition.GRAPHIC_BEGINNING).build();

	private final Color background;
	private final Color outline;
	private final Color fontColor;
	private final Double fontSize;
	private final Double lineWidth;
	private final IPath image;
	private final Boolean showAsImage; // If this is true, then image must not be null.
	private final LineStyle lineStyle;
	private final LabelPosition horizontalLabelPosition;
	private final LabelPosition verticalLabelPosition;
	private final Boolean primaryLabelVisible;

	Style(final Color background, final Color fontColor, final Color outline, final Double fontSize,
			final Boolean showAsImage, final IPath image,
			final Double lineWidth, final LineStyle lineStyle, final LabelPosition horizontalLabelPosition,
			final LabelPosition verticalLabelPosition, final Boolean primaryLabelVisible) {
		this.background = background;
		this.fontColor = fontColor;
		this.outline = outline;
		this.fontSize = fontSize;
		this.showAsImage = showAsImage;
		this.image = image;
		this.lineWidth = lineWidth;
		this.lineStyle = lineStyle;
		this.horizontalLabelPosition = horizontalLabelPosition;
		this.verticalLabelPosition = verticalLabelPosition;
		this.primaryLabelVisible = primaryLabelVisible;

		if (showAsImage == Boolean.TRUE && image == null) {
			throw new RuntimeException("showAsImage must be false if image is not set.");
		}
	}

	public final Color getBackgroundColor() {
		return background;
	}

	public final IPath getImagePath() {
		return image;
	}

	public final Boolean getShowAsImage() {
		return showAsImage;
	}

	public final Color getOutlineColor() {
		return outline;
	}

	public final Color getFontColor() {
		return fontColor;
	}

	public final Double getFontSize() {
		return fontSize;
	}

	public final Double getLineWidth() {
		return lineWidth;
	}

	/**
	 * @since 1.1
	 */
	public final LineStyle getLineStyle() {
		return lineStyle;
	}

	public final LabelPosition getHorizontalLabelPosition() {
		return horizontalLabelPosition;
	}

	public final LabelPosition getVerticalLabelPosition() {
		return verticalLabelPosition;
	}

	public final Boolean getPrimaryLabelVisible() {
		return primaryLabelVisible;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((background == null) ? 0 : background.hashCode());
		result = prime * result + ((fontColor == null) ? 0 : fontColor.hashCode());
		result = prime * result + ((fontSize == null) ? 0 : fontSize.hashCode());
		result = prime * result + ((horizontalLabelPosition == null) ? 0 : horizontalLabelPosition.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((showAsImage == null) ? 0 : showAsImage.hashCode());
		result = prime * result + ((lineStyle == null) ? 0 : lineStyle.hashCode());
		result = prime * result + ((lineWidth == null) ? 0 : lineWidth.hashCode());
		result = prime * result + ((outline == null) ? 0 : outline.hashCode());
		result = prime * result + ((primaryLabelVisible == null) ? 0 : primaryLabelVisible.hashCode());
		result = prime * result + ((verticalLabelPosition == null) ? 0 : verticalLabelPosition.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Style other = (Style) obj;
		if (background == null) {
			if (other.background != null) {
				return false;
			}
		} else if (!background.equals(other.background)) {
			return false;
		}
		if (fontColor == null) {
			if (other.fontColor != null) {
				return false;
			}
		} else if (!fontColor.equals(other.fontColor)) {
			return false;
		}
		if (fontSize == null) {
			if (other.fontSize != null) {
				return false;
			}
		} else if (!fontSize.equals(other.fontSize)) {
			return false;
		}
		if (horizontalLabelPosition != other.horizontalLabelPosition) {
			return false;
		}
		if (image == null) {
			if (other.image != null) {
				return false;
			}
		} else if (!image.equals(other.image)) {
			return false;
		}
		if (showAsImage == null) {
			if (other.showAsImage != null) {
				return false;
			}
		} else if (!showAsImage.equals(other.showAsImage)) {
			return false;
		}
		if (lineStyle != other.lineStyle) {
			return false;
		}
		if (lineWidth == null) {
			if (other.lineWidth != null) {
				return false;
			}
		} else if (!lineWidth.equals(other.lineWidth)) {
			return false;
		}
		if (outline == null) {
			if (other.outline != null) {
				return false;
			}
		} else if (!outline.equals(other.outline)) {
			return false;
		}
		if (primaryLabelVisible == null) {
			if (other.primaryLabelVisible != null) {
				return false;
			}
		} else if (!primaryLabelVisible.equals(other.primaryLabelVisible)) {
			return false;
		}
		if (verticalLabelPosition != other.verticalLabelPosition) {
			return false;
		}
		return true;
	}

}
