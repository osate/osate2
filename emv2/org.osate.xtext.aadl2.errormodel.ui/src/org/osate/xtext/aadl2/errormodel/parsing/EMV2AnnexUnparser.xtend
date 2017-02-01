package org.osate.xtext.aadl2.errormodel.parsing

import com.google.inject.Inject
import org.eclipse.xtext.serializer.ISerializer
import org.osate.aadl2.AnnexLibrary
import org.osate.aadl2.AnnexSubclause
import org.osate.annexsupport.AnnexUnparser
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause

class EMV2AnnexUnparser implements AnnexUnparser {
	@Inject
	ISerializer serializer
	
	override unparseAnnexLibrary(AnnexLibrary library, String indent) {
		// We are only called if it is the actual parsed annex, not the DefaultAnnexLibrary
		serializer.serialize(library)
	}

	override unparseAnnexSubclause(AnnexSubclause subclause, String indent) {
		// We are only called if it is the actual parsed annex, not the DefaultAnnexLibrary
		(subclause as ErrorModelSubclause).name = "unnamed_subclause"
		serializer.serialize(subclause)
	}
}