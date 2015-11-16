/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 *
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 *
 * See COPYRIGHT file for full details.
 */

package org.osate.assure.ui.views;

	import org.eclipse.jface.viewers.TreeViewer;
	import org.eclipse.jface.viewers.ViewerCell;
	import org.eclipse.swt.SWT;
	import org.eclipse.swt.graphics.Point;
	import org.eclipse.swt.widgets.Event;
	import org.eclipse.swt.widgets.Listener;
import org.osate.assure.assure.ClaimResult;


	public class AssureTooltipListener implements Listener {
	    private String tooltip = "";
	    private TreeViewer treeViewer;

	    public static void createAndRegister(TreeViewer treeViewer) {
	    	AssureTooltipListener instance = new AssureTooltipListener(treeViewer);
	        treeViewer.getControl().addListener(SWT.MouseHover, instance);
	        treeViewer.getControl().addListener(SWT.MouseMove, instance);
	    }

	    private AssureTooltipListener(TreeViewer treeViewer) {
	        this.treeViewer = treeViewer;
	    }

	    @Override
	    public void handleEvent(Event event) {
	        switch (event.type) {
	        case SWT.MouseMove:
	            ViewerCell cell = treeViewer.getCell(new Point(event.x, event.y));
	            if (cell != null && cell.getElement() instanceof ClaimResult) {
	                ClaimResult claim = (ClaimResult) cell.getElement();
	                tooltip = claim.getTarget().getTitle();
	            }
	            break;

	        case SWT.MouseHover:
	            treeViewer.getControl().setToolTipText(tooltip);
	            break;
	        }
	    }
	}
