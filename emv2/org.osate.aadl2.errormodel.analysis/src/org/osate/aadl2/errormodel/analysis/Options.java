package org.osate.aadl2.errormodel.analysis;

import org.osate2.aadl2.errormodel.analysis.prism.ModelType;

/**
 * Options for the PRISM tool. This is just a static
 * class to access the options values.
 * @author jdelange
 *
 */
public class Options {

	/*
	 * The type of model we are suppose to generate
	 */
	private static ModelType modelType = ModelType.DTMC;

	public static ModelType getModelType() {
		return modelType;
	}

	public static void setModelType(ModelType mt) {
		// OsateDebug.osateDebug("[Options] setModelType, argument=" + mt);
		modelType = mt;
	}

}
