package org.osate.xtext.aadl2.errormodel.parsing

import com.google.inject.Inject
import com.google.inject.name.Named
import java.util.concurrent.atomic.AtomicReference
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.transaction.RecordingCommand
import org.eclipse.emf.transaction.TransactionalEditingDomain
import org.eclipse.xtext.Constants
import org.eclipse.xtext.serializer.ISerializer
import org.osate.aadl2.AnnexLibrary
import org.osate.aadl2.AnnexSubclause
import org.osate.aadl2.DefaultAnnexLibrary
import org.osate.aadl2.DefaultAnnexSubclause
import org.osate.aadl2.NamedElement
import org.osate.annexsupport.AnnexUnparser
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelFactory
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelGrammarRoot
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause

import static extension org.osate.aadl2.modelsupport.resources.OsateResourceUtil.convertToIResource

class EMV2AnnexUnparser implements AnnexUnparser {
	@Inject
	ISerializer serializer
	
	@Inject
	@Named(Constants.FILE_EXTENSIONS)
	String fakeResourceFileExtension

	override unparseAnnexLibrary(AnnexLibrary library, String indent) {
		// We are only called if it is the actual parsed annex, not the DefaultAnnexLibrary
		<DefaultAnnexLibrary>unparseAnnexRoot(library, [eml = library as ErrorModelLibrary], [parsedAnnexLibrary = library])
	}

	override unparseAnnexSubclause(AnnexSubclause subclause, String indent) {
		// We are only called if it is the actual parsed annex, not the DefaultAnnexLibrary
		<DefaultAnnexSubclause>unparseAnnexRoot(subclause, [emsc = subclause as ErrorModelSubclause], [parsedAnnexSubclause = subclause])
	}
	
	/**
	 * Unparses either an ErrorModelLibrary or ErrorModelSubclause and returns the resulting String.
	 * 
	 * @param <T> Either DefaultAnnexLibrary or DefaultAnnexSubclause
	 * @param annexRoot Either an ErrorModelLibrary or ErrorModelSubclause
	 * @param setAnnexRoot Lambda which attaches the annex root to the supplied ErrorModelGrammarRoot
	 * @param setAnnexRootOnDefault Lambda which attaches the annex root to the supplied DefaultAnnexLibrary or DefaultAnnexSubclause
	 */
	def private <T extends NamedElement> unparseAnnexRoot(NamedElement annexRoot, (ErrorModelGrammarRoot)=>void setAnnexRoot, (T)=>void setAnnexRootOnDefault) {
		/*
		 * In order for serialization to work, the serializer needs to find the appropriate parser rule for the supplied EObject.
		 * If we leave the ErrorModelLibrary contained within the DefaultAnnexLibrary or the ErrorModelSubclause contained within the
		 * DefaultAnnexSubclause, then the serializer can't determine the correct rule.  In order for the correct parser rule to be found
		 * the library or subclause must not be in a resource, it must be a top level object in a resource, or it must be in an
		 * ErrorModelGrammarRoot.  If it is not in a resource, then a NullPointerException is thrown.  If it is a top level object in a
		 * resource, then a RuntimeException is thrown complaining that the parser rule ErrorModelGrammarRoot is not valid for an
		 * ErrorModelLibrary or ErrorModelSubclause.  Therefore, the library or subclause is added to a new ErrorModelGrammarRoot which
		 * is added to a temporary and fake resource.  The resource is fake in the sense that it does not exist in the filesystem, only in
		 * memory.  After serializing the library or subclause, then it is re-attached to the parent DefaultAnnexLibrary or
		 * DefaultAnnexSubclause and the fake resource is descarded.  Before detaching, all proxies in the library or subclause need to be
		 * resolved.  Otherwise NullPointerExceptions will occur because the proxies cannot be resolved after it is attached to the
		 * temporary resource.
		 */
		val resourceSet = annexRoot.eResource.resourceSet
		val fakeResource = resourceSet.createResource(URI.createPlatformResourceURI(annexRoot.eResource.convertToIResource.project.name + "/fakeResourceForUnparsing", true).appendFileExtension(fakeResourceFileExtension))
		val parent = annexRoot.owner as T
		val text = new AtomicReference
		val domain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain("org.osate.aadl2.ModelEditingDomain")
		EcoreUtil.resolveAll(annexRoot)
		domain.commandStack.execute(new RecordingCommand(domain) {
			override protected doExecute() {
				fakeResource.contents.add(ErrorModelFactory.eINSTANCE.createErrorModelGrammarRoot => [setAnnexRoot.apply(it)])
				text.set(serializer.serialize(annexRoot))
				setAnnexRootOnDefault.apply(parent)
			}
		})
		fakeResource.unload
		resourceSet.resources.remove(fakeResource)
		text.get
	}
}