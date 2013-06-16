package org.osate.xtext.aadl2.errormodel.parsing;


import org.eclipse.xtext.serializer.impl.Serializer;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Element;
import org.osate.aadl2.PackageSection;
import org.osate.annexsupport.AnnexUnparser;
import org.osate.xtext.aadl2.errormodel.ErrorModelRuntimeModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class EMV2AnnexUnparser implements AnnexUnparser {
	
	public String unparseAnnexLibrary(AnnexLibrary library, String indent){
		Injector injector = Guice.createInjector(new  ErrorModelRuntimeModule());  
	    Serializer serializer = injector.getInstance(Serializer.class); 
	    Element parent = library.getOwner();
	    if (parent instanceof PackageSection){
	    	PackageSection parpack = (PackageSection)parent;
	    	parpack.getOwnedAnnexLibraries().remove(library);
			String text = serializer.serialize(library);
		parpack.getOwnedAnnexLibraries().add(library);
		return text;
	    } else return "no";
	}
	
	public String unparseAnnexSubclause(AnnexSubclause subclause, String indent){
//		Injector injector = Guice.createInjector(new  ErrorModelRuntimeModule());  
//	    Serializer serializer = injector.getInstance(Serializer.class);  	
//		String text = serializer.serialize(subclause);
		return "";//text;
	}

}
