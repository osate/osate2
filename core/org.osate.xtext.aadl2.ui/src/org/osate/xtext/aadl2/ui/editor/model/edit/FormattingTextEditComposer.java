package org.osate.xtext.aadl2.ui.editor.model.edit;

import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.ui.editor.model.edit.DefaultTextEditComposer;

public class FormattingTextEditComposer extends DefaultTextEditComposer {

	@Override
	protected SaveOptions getSaveOptions() {
		return SaveOptions.newBuilder().format().getOptions();
	}

}
