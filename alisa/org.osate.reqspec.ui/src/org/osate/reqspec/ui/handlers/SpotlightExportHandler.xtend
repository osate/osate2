package org.osate.reqspec.ui.handlers;

import com.google.inject.Inject
import java.io.ByteArrayInputStream
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.core.commands.IHandler
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IFolder
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IResource
import org.eclipse.core.runtime.IAdaptable
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.ui.handlers.HandlerUtil
import org.osate.aadl2.instance.ComponentInstance
import org.osate.aadl2.instance.InstanceObject
import org.osate.aadl2.instance.SystemInstance
import org.osate.categories.categories.Category
import org.osate.reqspec.reqSpec.Requirement
import org.osate.reqspec.ui.internal.ReqSpecActivator
import org.osate.reqspec.util.IReqspecGlobalReferenceFinder

import static extension org.eclipse.emf.ecore.util.EcoreUtil.*
import static extension org.eclipse.xtext.EcoreUtil2.*
import static extension org.osate.aadl2.modelsupport.resources.OsateResourceUtil.*

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see IHandler
 * @see AbstractHandler
 */
class SpotlightExportHandler extends AbstractHandler {
		@Inject IReqspecGlobalReferenceFinder reqSpecrefFinder
	val SPOTLIGHTEXT = "_spotlight.csv"
	val SPOTLIGHTFOLDER = "spotlight"
	val LINE_SEPARATOR = System.getProperty("line.separator")
	val COMMA = ","

	new (){
		ReqSpecActivator.instance.getInjector(ReqSpecActivator.ORG_OSATE_REQSPEC_REQSPEC).injectMembers(this)
	}
	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	override Object execute(ExecutionEvent event) throws ExecutionException {
		val window = HandlerUtil.getActiveWorkbenchWindowChecked(event)
		if (window != null){
			val selection = window.getSelectionService().getSelection() as IStructuredSelection
			val firstElement = selection.getFirstElement()
			var SystemInstance systemInstance = null
			
			if (firstElement instanceof IAdaptable){
				val project = 
					switch firstElement{
						SystemInstance : {
							systemInstance = ((firstElement as IAdaptable).getAdapter(SystemInstance)) as SystemInstance
							(systemInstance.eResource.convertToIResource as IFile).project
						}
						IFile : {
							val potentialFile = (firstElement as IAdaptable).getAdapter(IFile) as IFile
							if (potentialFile.name.endsWith(".aaxl2")){
								systemInstance = potentialFile.resource.contents.head as SystemInstance
								potentialFile.project
							}
						}
						InstanceObject : {
							val instanceObject = ((firstElement as IAdaptable).getAdapter(InstanceObject)) as InstanceObject
							systemInstance =  instanceObject.getContainerOfType(SystemInstance)
							(systemInstance.eResource.convertToIResource as IFile).project
						}
					}
				if (systemInstance == null){
					return null
				}
				
				val spotlightFolder = project.getSpotlightFolder();

				val spotlightRequirementsFile = spotlightFolder.getFile(systemInstance.name + SPOTLIGHTEXT)
				if (spotlightRequirementsFile.exists){
					spotlightRequirementsFile.delete(true,null)
				}
				val newSpotlightRequirementsFile = spotlightFolder.getFile(systemInstance.name  + SPOTLIGHTEXT)
				newSpotlightRequirementsFile.create(new ByteArrayInputStream(systemInstance.generateRequirementsList.bytes), false, null)

				project.refreshLocal(IResource.DEPTH_ONE, null)
			}
		}
		null
	}
	
	
	def String generateRequirementsList(SystemInstance systemInstance){
		systemInstance.getAllContents(true).filter(ComponentInstance).join(LINE_SEPARATOR, 
			[compInst |
					compInst.fullName + reqSpecrefFinder.getAllRequirements(compInst).filter[req | req.ssp].
							join(COMMA, LINE_SEPARATOR + compInst.fullName + COMMA, "", 
									[ name + COMMA + 
										if(it.changeUncertainty == null) {""} 
										else {it.changeUncertainty.volatility + COMMA + it.changeUncertainty.precedence}
									]
								)
			]
		)
	}
	
	def boolean isSsp(Requirement req){
		val ssp = (#["safety", "security", "performance"]).toSet
		val categories = req.category
		val iterator = categories.iterator
		while(iterator.hasNext){
			var nextCat = iterator.next as Category
			if (ssp.contains(nextCat.name.toLowerCase)) {
				return true
			}
		}
		false
	}
	
	
	def IFolder getSpotlightFolder(IProject project){
		if (project.exists() && !project.isOpen()) {
			project.open(null)
		}	
		val spotlightFolder = project.getFolder(SPOTLIGHTFOLDER);
		if (!spotlightFolder.exists()) {
			spotlightFolder.create(true,false,null)
		}
		spotlightFolder
	}
	
}
