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
package org.osate.ge.fx;

import javafx.scene.layout.Region;
import javafx.scene.paint.Color;

// TODO: Rename
public class FolderNode extends Region implements Styleable {
	private final static double folderTabHeight = 9;
	private final static double folderMaxTabWidth = 100;
	private final static double folderTabOffsetAngle = 30.0;
	private final static double folderTopOfTabOffset = 0.3;

	private final javafx.scene.shape.Polygon poly = new javafx.scene.shape.Polygon();

	public FolderNode() {
		this.getChildren().addAll(poly);

		setLineWidth(2);
		setBackgroundColor(Color.WHITE);
		setOutlineColor(Color.BLACK);
	}

	@Override
	public void resize(double width, double height) {
		super.resize(width, height);

		// Width of tab
		final double widthOfTab = Math.min(folderMaxTabWidth, (int) (width * folderTopOfTabOffset));
//		// The tab start and end slope
		final double tabOffset = (int) (Math.ceil(Math.tan(Math.toRadians(folderTabOffsetAngle)) * folderTabHeight));

		poly.getPoints().setAll(0.0, height, 0.0, folderTabHeight, tabOffset, 0.0, widthOfTab, 0.0,
				widthOfTab + tabOffset, folderTabHeight, width, folderTabHeight, width, height);
	}

	@Override
	public final void setBackgroundColor(final Color value) {
		poly.setFill(value);
	}

	@Override
	public final void setOutlineColor(final Color value) {
		poly.setStroke(value);
	}

	@Override
	public final void setLineWidth(final double value) {
		poly.setStrokeWidth(value);
	}

// TODO: Should adjust tab size based on font size?
//	@Override
//	public final void setFontSize(final double size) {
//	}

	public static void main(final String[] args) {
		NodeApplication.run(new FolderNode());
	}
}
