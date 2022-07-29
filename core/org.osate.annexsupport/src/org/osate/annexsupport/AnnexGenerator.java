package org.osate.annexsupport;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;

/**
 * @since 5.0
 */
public interface AnnexGenerator {
	void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context);
}