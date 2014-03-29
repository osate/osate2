/*
 *
 * <copyright>
 * Copyright  2012 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 */
package org.osate.xtext.aadl2.serializer;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.NamedElement;
import org.osate.annexsupport.AnnexRegistry;
import org.osate.annexsupport.AnnexUnparser;
import org.osate.annexsupport.AnnexUnparserRegistry;
import org.osate.xtext.aadl2.services.Aadl2GrammarAccess;

import com.google.inject.Inject;

public class Aadl2SemanticSequencer extends AbstractAadl2SemanticSequencer {
	

	@Inject
	private Aadl2GrammarAccess grammarAccess;

	AnnexUnparserRegistry unparserregistry ;
	
	protected AnnexUnparserRegistry getAnnexUnparserRegistry(){
		if (unparserregistry == null){
			unparserregistry = (AnnexUnparserRegistry) AnnexRegistry
					.getRegistry(AnnexRegistry.ANNEX_UNPARSER_EXT_ID);
		}
		return unparserregistry;
	}

	
	@Override
	public void createSequence(EObject context, EObject semanticObject) {
		if (semanticObject instanceof DefaultAnnexLibrary){
			if(context == grammarAccess.getAnnexLibraryRule() ||
					context == grammarAccess.getDefaultAnnexLibraryRule()) {
				DefaultAnnexLibrary dal = (DefaultAnnexLibrary)semanticObject;
//				AnnexLibrary pal = dal.getParsedAnnexLibrary();
//				String annexName = ((NamedElement)semanticObject).getName();
//				AnnexUnparser atpr = getAnnexUnparserRegistry().getAnnexUnparser(annexName);
//				String text = dal.getSourceText();
//				// serialize if there is an unparser and the annex has been parsed
//				//otherwise use the original annex text
//				if (pal != null&&atpr != null){
//					text = atpr.unparseAnnexLibrary(pal, "  ");
//				}
//				DefaultAnnexLibrary tdal = Aadl2Factory.eINSTANCE.createDefaultAnnexLibrary();
//				tdal.setName(dal.getName());
//				tdal.setSourceText(text);  
//				sequence_DefaultAnnexLibrary(context, tdal);
				sequence_DefaultAnnexLibrary(context, dal);
				return; 
			}
		}
		if (Aadl2Package.eINSTANCE.getAnnexSubclause().isSuperTypeOf(semanticObject.eClass())){
			if(context == grammarAccess.getAnnexSubclauseRule() ||
					context == grammarAccess.getDefaultAnnexSubclauseRule()) {
				DefaultAnnexSubclause dasc = (DefaultAnnexSubclause)semanticObject;
//				AnnexSubclause pasc = dasc.getParsedAnnexSubclause();
//				String annexName = ((NamedElement)semanticObject).getName();
//				AnnexUnparser atpr = getAnnexUnparserRegistry().getAnnexUnparser(annexName);
//				String text = dasc.getSourceText();
//				// serialize if there is an unparser and the annex has been parsed
//				//otherwise use the original annex text
//				if (pasc != null&&atpr != null){
//					text = atpr.unparseAnnexSubclause(pasc, "  ");
//				}
//				DefaultAnnexSubclause tdasc = Aadl2Factory.eINSTANCE.createDefaultAnnexSubclause();
//				tdasc.setSourceText(text); 
//				sequence_DefaultAnnexSubclause(context, tdasc); 
				sequence_DefaultAnnexSubclause(context, dasc); 
				return; 
			}
		}
		super.createSequence(context, semanticObject);

	}
}
