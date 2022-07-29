package org.osate.annexsupport;

import org.eclipse.core.runtime.IConfigurationElement;

/**
 * @since 5.0
 */
public class AnnexGeneratorRegistry extends AnnexRegistry {
	protected AnnexGeneratorRegistry() {
		initialize(ANNEX_GENERATOR_EXT_ID);
	}

	public AnnexGenerator getAnnexGenerator(String annexName) {
		return (AnnexGenerator) extensions.get(annexName.toLowerCase());
	}

	@Override
	protected AnnexProxy createProxy(IConfigurationElement configElem) {
		return new AnnexGeneratorProxy(configElem);
	}
}