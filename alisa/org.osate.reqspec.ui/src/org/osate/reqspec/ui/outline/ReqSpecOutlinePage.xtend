package org.osate.reqspec.ui.outline;

import org.eclipse.jface.viewers.ColumnViewerToolTipSupport
import org.eclipse.xtext.ui.editor.outline.impl.OutlinePage

public class ReqSpecOutlinePage extends OutlinePage {
	
	override configureTree() {
		super.configureTree
		ColumnViewerToolTipSupport.enableFor(treeViewer)
	}
}
