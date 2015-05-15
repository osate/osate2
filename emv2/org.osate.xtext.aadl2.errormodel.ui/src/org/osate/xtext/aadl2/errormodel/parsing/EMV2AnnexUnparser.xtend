package org.osate.xtext.aadl2.errormodel.parsing

import com.google.inject.Guice
import com.google.inject.Inject
import com.google.inject.Injector
import com.google.inject.name.Named
import java.util.concurrent.atomic.AtomicReference
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.transaction.RecordingCommand
import org.eclipse.emf.transaction.TransactionalEditingDomain
import org.eclipse.xtext.Constants
import org.eclipse.xtext.serializer.ISerializer
import org.eclipse.xtext.serializer.impl.Serializer
import org.osate.aadl2.AnnexLibrary
import org.osate.aadl2.AnnexSubclause
import org.osate.aadl2.DefaultAnnexLibrary
import org.osate.aadl2.DefaultAnnexSubclause
import org.osate.aadl2.Element
import org.osate.annexsupport.AnnexUnparser
import org.osate.xtext.aadl2.errormodel.ErrorModelRuntimeModule
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelFactory
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary

import static extension org.osate.aadl2.modelsupport.resources.OsateResourceUtil.convertToIResource

class EMV2AnnexUnparser implements AnnexUnparser {
	@Inject
	ISerializer serializer
	
	@Inject
	@Named(Constants.FILE_EXTENSIONS)
	String fakeResourceFileExtension

	override unparseAnnexLibrary(AnnexLibrary library, String indent) {
		// We are only called if it is the actual parsed annex, not the DefaultAnnexLibrary
		/*
		 * In order for serialization to work, the serializer needs to find the appropriate parser rule for the supplied EObject.
		 * If we leave the ErrorModelLibrary contained within the DefaultAnnexLibrary, then the serializer can't determine the correct rule.
		 * In order for the correct parser rule to be found the library must not be in a resource, the library must be a top level
		 * object in a resource, or the library must be in an ErrorModelGrammarRoot.  If it is not in a resource, then a NullPointerException
		 * is thrown.  If the library is a top level object in a resource, then a RuntimeException is thrown complaining that the parser rule
		 * ErrorModelGrammarRoot is not valid for an ErrorModelLibrary.  Therefore, the library is added to a new ErrorModelGrammarRoot which
		 * is added to a temporary and fake resource.  The resource is fake in the sense that it does not exist in the filesystem, only in
		 * memory.  After serializing the library, then it is re-attached to the parent DefaultAnnexLibrary and the fake resource is discarded.
		 * Before detaching, all proxies in the library need to be resolved.  Otherwise NullPointerExceptions will occur because the proxies
		 * cannot be resolved after it is attached to the temporary resource.
		 */
		val resourceSet = library.eResource.resourceSet
		val fakeResource = resourceSet.createResource(URI.createPlatformResourceURI(library.eResource.convertToIResource.project.name + "/fakeResourceForUnparsing", true).appendFileExtension(fakeResourceFileExtension))
		val parent = library.owner as DefaultAnnexLibrary
		val text = new AtomicReference
		val domain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain("org.osate.aadl2.ModelEditingDomain")
		EcoreUtil.resolveAll(library)
		domain.commandStack.execute(new RecordingCommand(domain) {
			override protected doExecute() {
				fakeResource.contents.add(ErrorModelFactory.eINSTANCE.createErrorModelGrammarRoot => [eml = library as ErrorModelLibrary])
				text.set(serializer.serialize(library))
				parent.parsedAnnexLibrary = library
			}
		})
		fakeResource.unload
		resourceSet.resources.remove(fakeResource)
		text.get
	}

	override public String unparseAnnexSubclause(AnnexSubclause subclause, String indent) {
		// We are only called if it is the actual parsed annex, not the DefaultAnnexLibrary
		val Injector injector = Guice.createInjector(new ErrorModelRuntimeModule());
		val Serializer serializer = injector.getInstance(Serializer);
		val Element parent = subclause.getOwner();
		if (parent instanceof DefaultAnnexSubclause) {
			val DefaultAnnexSubclause dasc = parent as DefaultAnnexSubclause;
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