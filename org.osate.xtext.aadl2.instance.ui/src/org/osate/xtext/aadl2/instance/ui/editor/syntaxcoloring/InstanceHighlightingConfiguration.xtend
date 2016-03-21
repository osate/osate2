package org.osate.xtext.aadl2.instance.ui.editor.syntaxcoloring

import org.eclipse.swt.SWT
import org.eclipse.swt.graphics.RGB
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor
import org.eclipse.xtext.ui.editor.utils.TextStyle

class InstanceHighlightingConfiguration extends DefaultHighlightingConfiguration {
	val public static String NAME_ID = "NAME_ID"
	val public static String DECLARATIVE_ID = "DECLARATIVE_ID"
	
	override configure(IHighlightingConfigurationAcceptor acceptor) {
		super.configure(acceptor)
		acceptor.acceptDefaultHighlighting(NAME_ID, "Name", new TextStyle => [style = SWT.BOLD])
		acceptor.acceptDefaultHighlighting(DECLARATIVE_ID, "Declarative Reference", new TextStyle => [color = new RGB(128, 128, 128)])
	}
}