package edu.uah.rsesc.aadl.age.ui.editor;

import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.graphiti.ui.editor.DiagramEditor;

import edu.uah.rsesc.aadl.age.diagrams.common.util.impl.DefaultPropertyService;

public class AgeDiagramEditor extends DiagramEditor {
	public static final String DIAGRAM_EDITOR_ID = "edu.uah.rsesc.aadl.age.editor.AgeDiagramEditor";
	public static final String EXTENSION = ".aadl_diagram";
	
	public AgeDiagramEditor() {
	}
	
	protected DiagramBehavior createDiagramBehavior() {
		return new AgeDiagramBehavior(this, new DefaultPropertyService());
	}
}
