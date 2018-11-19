package org.osate.ge.errormodel.util;

import org.osate.aadl2.AadlPackage;
import org.osate.ge.GraphicalAnnexUtil;
import org.osate.ge.graphics.ArrowBuilder;
import org.osate.ge.graphics.Color;
import org.osate.ge.graphics.ConnectionBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;

public class ErrorModelGeUtil {
	public static ErrorModelLibrary getOrCreateErrorModelLibrary(final AadlPackage pkg) {
		return (ErrorModelLibrary) GraphicalAnnexUtil.getOrCreateParsedAnnexLibrary(pkg, EMV2Util.ErrorModelAnnexName,
				ErrorModelPackage.eINSTANCE.getErrorModelLibrary());
	}

	public static ErrorModelLibrary getErrorModelLibrary(final AadlPackage pkg) {
		return (ErrorModelLibrary) GraphicalAnnexUtil.getFirstParsedAnnexLibrary(pkg, EMV2Util.ErrorModelAnnexName,
				ErrorModelPackage.eINSTANCE.getErrorModelLibrary());
	}

	public static final Style topCenteredLabelStyle = StyleBuilder.create().labelsTop().labelsHorizontalCenter()
			.build();

	public static final Style centeredStyle = StyleBuilder.create().labelsCenter().build();

	public static final Style transitionConnectionStyle = StyleBuilder.create().backgroundColor(Color.BLACK).build();
	public static final Graphic transitionConnectionGraphic = ConnectionBuilder.create()
			.destinationTerminator(ArrowBuilder.create().small().filled().build()).build();
}
