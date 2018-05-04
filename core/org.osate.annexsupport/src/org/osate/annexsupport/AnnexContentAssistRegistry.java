package org.osate.annexsupport;

import org.eclipse.core.runtime.IConfigurationElement;

public class AnnexContentAssistRegistry extends AnnexRegistry {

	protected AnnexContentAssistRegistry() {
		initialize(ANNEX_CONTENT_ASSIST_EXT_ID);
	}

	public AnnexContentAssist getAnnexContentAssist(String annexName) {
		return (AnnexContentAssist) extensions.get(annexName.toLowerCase());
	}

	@Override
	protected AnnexProxy createProxy(IConfigurationElement configElem) {
		return new AnnexContentAssistProxy(configElem);
	}

}
