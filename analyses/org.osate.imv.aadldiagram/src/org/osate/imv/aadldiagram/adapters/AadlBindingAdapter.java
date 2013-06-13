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
package org.osate.imv.aadldiagram.adapters;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.zest.layouts.LayoutRelationship;
import org.osate.imv.aadldiagram.aadlfigures.AadlFigureFactory;
import org.osate.imv.aadldiagram.bindingdecorations.BindingDecorationType;
import org.osate.imv.aadldiagram.draw2d.SelectableMevBindingFigure;
import org.osate.imv.aadldiagram.layout.GraphLayoutBinding;
import org.osate.imv.aadldiagram.visitors.AadlAdapterVisitor;


public class AadlBindingAdapter extends AbstractAadlElementAdapter {

	public static final int HIGLIGHTED_LINE_WIDTH = 3;
	public static final int NORMAL_LINE_WIDTH = 1;

	private SelectableMevBindingFigure figure;

	private IAadlElementAdapter processAdapter;
	private IAadlElementAdapter boundResourceAdapter;

	private BindingDecorationType decorationType;

	/**
	 * Used by the auto-layout algorithms.
	 */
	private LayoutRelationship layoutItem;

	public AadlBindingAdapter(Object process, BindingDecorationType decorationType, ILabelProvider labelProvider, IAadlElementAdapter processAdapter, IAadlElementAdapter boundResourceAdapter) {
		super(process, labelProvider);
 
		this.processAdapter 		= processAdapter;
		this.boundResourceAdapter 	= boundResourceAdapter;
		this.decorationType 		= decorationType;
		
	}


	public SelectableMevBindingFigure getFigure() {
		if(figure == null) {
			// Build figure.
			figure = AadlFigureFactory.getInstance().buildFigure(this);
			figure.addMouseListener(this);
			figure.addMouseMotionListener(this);
			figure.addFigureListener(this);
		}

		return figure;
	}


	@Override
	public void accept(AadlAdapterVisitor visitor) {
		visitor.visitAadlBindingAdapter(this);
	}
 
	@Override
	public void highlight(boolean highlight, Color highlightColor) {
		super.highlight(highlight, highlightColor);
		// Since this is a connection, the line width will be increased when the connection
		// is highlighted.
		this.getFigure().setLineStyle(SWT.LINE_DASH);
		if(highlight)
			this.getFigure().setLineWidth(HIGLIGHTED_LINE_WIDTH);
		else
			this.getFigure().setLineWidth(NORMAL_LINE_WIDTH);
	}

	@Override
	public LayoutRelationship getLayoutItem() {
		return new GraphLayoutBinding(this);
	}

	@Override
	public void setSelected(boolean selected) {
		super.setSelected(selected);
		this.getFigure().setSelected(selected);
	}

	public IAadlElementAdapter getProcessAdapter() {
		return processAdapter;
	}

	public void setSourceAdapter(IAadlElementAdapter pa) {
		this.processAdapter = pa;
	}

	public IAadlElementAdapter getBoundResourceAdapter() {
		return boundResourceAdapter;
	}

	public void setDestinationAdapter(IAadlElementAdapter bra) {
		this.boundResourceAdapter = bra;
	}

	public BindingDecorationType getDecorationType() {
		return decorationType;
	}

	public void setDecorationType(BindingDecorationType decorationType) {
		this.decorationType = decorationType;
	}

	@Override
	public void mousePressed(MouseEvent me) {
		super.mousePressed(me);
		this.getFigure().mousePressed(me);
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		super.mouseReleased(me);
		this.getFigure().mouseReleased(me);
	}

	@Override
	public void mouseDragged(MouseEvent me) {
		super.mouseDragged(me);
		this.getFigure().mouseDragged(me);
	}

	@Override
	public void mouseMoved(MouseEvent me) {
		super.mouseMoved(me);
		this.getFigure().mouseMoved(me);
	}

	@Override
	public void mouseExited(MouseEvent me) {
		super.mouseExited(me);
		this.getFigure().mouseExited(me);
	}

	@Override
	public ConnectionAnchor getConnectionAnchor(Connection connection) {
		return null; // Since this is a connection, it does not return a connection anchor.
	}
}
