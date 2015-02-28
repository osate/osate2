package org.osate.xtext.aadl2.errormodel.parsing;

//import org.eclipse.xtext.parsetree.reconstr.Serializer;
import org.eclipse.xtext.serializer.impl.Serializer;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.Element;
import org.osate.annexsupport.AnnexUnparser;
import org.osate.xtext.aadl2.errormodel.ErrorModelRuntimeModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class EMV2AnnexUnparser implements AnnexUnparser {

	@Override
	public String unparseAnnexLibrary(AnnexLibrary library, String indent) {
		// We are only called if it is the actual parsed annex, not the DefaultAnnexLibrary
		Injector injector = Guice.createInjector(new ErrorModelRuntimeModule());
		Serializer serializer = injector.getInstance(Serializer.class);
		Element parent = library.getOwner();
		if (parent instanceof DefaultAnnexLibrary) {
			DefaultAnnexLibrary dal = (DefaultAnnexLibrary) parent;
			// this still needs to be debugged. We are getting an error an EMV2
//	    	dal.setParsedAnnexLibrary(null);
//			String text = serializer.serialize(library);
//		    dal.setParsedAnnexLibrary(library);
//		    return text;
			return dal.getSourceText();
		} else {
			return "<no string>";
		}
	}

	@Override
	public String unparseAnnexSubclause(AnnexSubclause subclause, String indent) {
		// We are only called if it is the actual parsed annex, not the DefaultAnnexLibrary
		Injector injector = Guice.createInjector(new ErrorModelRuntimeModule());
		Serializer serializer = injector.getInstance(Serializer.class);
		Element parent = subclause.getOwner();
		if (parent instanceof DefaultAnnexSubclause) {
			DefaultAnnexSubclause dasc = (DefaultAnnexSubclause) parent;
			// this still needs to be debugged. We are getting an error an EMV2
//	    	dasc.setParsedAnnexSubclause(null);
//			String text = serializer.serialize(subclause);
//			dasc.setParsedAnnexSubclause(subclause);
//			return text;
			return dasc.getSourceText();
		} else {
			return "<no string>";
		}
	}

}
