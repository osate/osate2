package org.osate.alisa.workbench.generator

import org.eclipse.xtext.generator.OutputConfigurationProvider

class AlisaOutputConfigurationProvider extends OutputConfigurationProvider {
	public val ALISA_GEN = "./assure"
	override getOutputConfigurations(){
		super.outputConfigurations => [head.outputDirectory = ALISA_GEN
		]
	}
}