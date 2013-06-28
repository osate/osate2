package edu.uah.rsesc.aadl.age.editor;

import org.eclipse.graphiti.ui.editor.DefaultUpdateBehavior;
import org.eclipse.graphiti.ui.editor.DiagramEditor;

public class AgeDiagramEditor extends DiagramEditor {
	public static final String DIAGRAM_EDITOR_ID = "edu.uah.rsesc.aadl.age.editor.AgeDiagramEditor";
	public static final String EXTENSION = ".aadl_diagram";
	
	public AgeDiagramEditor() {
	}
	
	@Override
	protected DefaultUpdateBehavior createUpdateBehavior() {
		return new AgeUpdateBehavior(this);
	}
}
