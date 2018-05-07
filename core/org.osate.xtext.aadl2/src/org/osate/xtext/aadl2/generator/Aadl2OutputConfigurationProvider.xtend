package org.osate.xtext.aadl2.generator

import org.eclipse.xtext.generator.OutputConfiguration
import org.eclipse.xtext.generator.OutputConfigurationProvider

class Aadl2OutputConfigurationProvider extends OutputConfigurationProvider {

	public static val AADLBIN_OUTPUT = "AALDBIN_OUTPUT"

	override getOutputConfigurations() {
		val aadlbinOutput = new OutputConfiguration(AADLBIN_OUTPUT) => [
			description = "Binary Data Folder"
			outputDirectory = "./.aadlbin-gen"
			overrideExistingResources = true
			createOutputDirectory = true
			cleanUpDerivedResources = true
			setDerivedProperty = true
			keepLocalHistory = false
		]
		(super.outputConfigurations + #[aadlbinOutput]).toSet
	}

}