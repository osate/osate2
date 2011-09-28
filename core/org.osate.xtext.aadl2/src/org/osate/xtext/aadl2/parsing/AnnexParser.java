package org.osate.xtext.aadl2.parsing;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer;
import org.eclipse.xtext.linking.lazy.LazyLinker;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.DefaultAnnexSubclause;
//import org.osate.xtext.aadl2.errormodel.parsing.ErrorModelParserWrapper;


public class AnnexParser  extends LazyLinker {

//	private ErrorModelParserWrapper empr = new ErrorModelParserWrapper()  ;
	/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.xtext.linking.impl.AbstractCleaningLinker#afterModelLinked(org.eclipse.emf.ecore.EObject,
		 * org.eclipse.xtext.diagnostics.IDiagnosticConsumer)
		 */
		@Override
		protected void afterModelLinked(EObject model, IDiagnosticConsumer diagnosticsConsumer) {
			List<DefaultAnnexLibrary> all=EcoreUtil2.eAllOfType(model, DefaultAnnexLibrary.class);
			for (DefaultAnnexLibrary defaultAnnexLibrary : all) {
//				empr.getLibraryParser().parse(defaultAnnexLibrary,defaultAnnexLibrary.getSourceText());
			}
			List<DefaultAnnexSubclause> asl=EcoreUtil2.eAllOfType(model, DefaultAnnexSubclause.class);
			for (DefaultAnnexSubclause defaultAnnexSubclause : asl) {
//				empr.getSubclauseParser().parse(defaultAnnexSubclause,defaultAnnexSubclause.getSourceText());
			}
		}

}
