/*
 *
 * <copyright>
 * Copyright 2012 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/cpl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 *
 * </copyright>
 */
package org.osate.imv.aadldiagram.bindingdecorations;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.swt.SWT;

public class BindingDecoration extends Figure implements RotatableDecoration {

	private static final Dimension SIZE = new Dimension(20, 20);


	private float rotationDegrees;
	private BindingDecorationType decorationType;

	/**
	 * Constructs a PortConnectionDecoration.
	 */
	public BindingDecoration(BindingDecorationType decorationType) {
		this.decorationType = decorationType;
		this.getBounds().setSize(SIZE);
	}

	/**
	 * Sets the location of this figure.
	 *
	 * @param p The location
	 */
	public void setLocation(Point p)
	{
		this.getBounds().setLocation(p.x - (int)(SIZE.width / 2.0f), p.y - (int)(SIZE.height / 2.0f));
	}

	/**
	 * Sets the reference point used to determine the rotation angle.
	 *
	 * @param p
	 *            The reference point
	 */
	public void setReferencePoint(Point ref)
	{
		Point pt = Point.SINGLETON;
		pt.setLocation(ref);
		pt.negate().translate(getBounds().getLocation());
		rotationDegrees = (float)Math.toDegrees(Math.atan2(pt.y, pt.x));
		this.repaint();
	}

	public void paintFigure(Graphics g) 
	{

		// Configure GC.
		g.setForegroundColor(ColorConstants.black);
		g.setLineWidth (5);
		g.setLineStyle(SWT.LINE_SOLID);

		
		g.setAntialias(SWT.ON);

		// Transform GC
		g.translate(this.getBounds().getCenter());
		g.rotate(this.rotationDegrees);

		switch(this.decorationType)
		{
			default:
			{
				this.paintDefaultBindingDecoration(g);
				break;
			}

		}
	}


	protected void paintDefaultBindingDecoration(Graphics g) {
		int x = 0;
		int h = 5;
		int[] points = {-20, 20, 0, 0, 20, 20};
		//g.drawLine(x, h, x, -h);
		x = -4;
		//g.drawLine(x, h, x, -h);
		//g.drawLine(x, h, x -50, h - 50);
		//g.rotate(90);
		//g.drawLine(x, h, x -50, h - 50);
		g.rotate(-90);
		g.drawPolyline(points);

		//g.drawPolyline({-20,0,20}, {20,0,20}, 3);
	}

}
