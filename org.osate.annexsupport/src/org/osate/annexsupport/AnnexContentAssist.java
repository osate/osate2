package org.osate.annexsupport;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

public interface AnnexContentAssist {
	public List<String> annexCompletionSuggestions(EObject defaultAnnex, int offset);
}
