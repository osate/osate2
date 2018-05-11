package org.osate.annexsupport;

import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.ecore.EObject;

public class AnnexContentAssistProxy extends AnnexProxy implements AnnexContentAssist {

	/** The annex resolver instance. */
	private AnnexContentAssist contentAssist = null;

	protected AnnexContentAssistProxy(IConfigurationElement configElem) {
		super(configElem);
		// TODO Auto-generated constructor stub
	}

	private AnnexContentAssist getContentAssist() {
		if (contentAssist != null) {
			return contentAssist;
		}
		try {
			contentAssist = (AnnexContentAssist) configElem.createExecutableExtension(ATT_CLASS);
		} catch (Exception e) {
			AnnexPlugin.logError("Failed to instantiate " + annexName + " content assist " + className + " in type: "
					+ id + " in plugin " + configElem.getDeclaringExtension().getContributor().getName(), e);
		}
		return contentAssist;
	}

	@Override
	public List<String> annexCompletionSuggestions(EObject defaultAnnex, int offset) {
		contentAssist = getContentAssist();
		return contentAssist.annexCompletionSuggestions(defaultAnnex, offset);
	}

}
