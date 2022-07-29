package org.osate.annexsupport;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;

/**
 * @since 5.0
 */
public class AnnexGeneratorProxy extends AnnexProxy implements AnnexGenerator {
	private AnnexGenerator generator = null;

	AnnexGeneratorProxy(IConfigurationElement configElem) {
		super(configElem);
	}

	private AnnexGenerator getGenerator() {
		if (generator == null) {
			try {
				generator = (AnnexGenerator) configElem.createExecutableExtension(ATT_CLASS);
			} catch (CoreException e) {
				AnnexPlugin.logError("Failed to instantiate " + annexName + " generator " + className + " in type: "
						+ id + " in plugin " + configElem.getDeclaringExtension().getContributor().getName(), e);
			}
		}
		return generator;
	}

	@Override
	public void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		getGenerator().doGenerate(resource, fsa, context);
	}
}