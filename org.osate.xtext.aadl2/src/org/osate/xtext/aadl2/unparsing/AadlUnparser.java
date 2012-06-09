/*
 *
 * <copyright>
 * Copyright  2011 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/cpl-v10.html.
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
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 *
 * </copyright>
 *
 *
 * @version $Id: AadlUnparser.java,v 1.100 2008-01-24 21:40:34 jseibel Exp $
 */
package org.osate.xtext.aadl2.unparsing;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.AbstractEnumerator;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.nodemodel.BidiTreeIterable;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.CompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.osate.aadl2.*;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.modelsupport.AadlConstants;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitch;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.util.Aadl2Switch;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.annexsupport.AnnexRegistry;
import org.osate.annexsupport.AnnexUnparser;
import org.osate.annexsupport.AnnexUnparserRegistry;
import org.osate.internal.workspace.AadlWorkspace;
import org.osate.xtext.aadl2.properties.resources.OsateResourceUtil;

/**
 * This class implements the converter from an AADL object model to textual
 * AADL. The generated text is made available as a string buffer.
 * 
 * @author phf
 */
public class AadlUnparser extends AadlProcessingSwitch {

	private static final String NONESTMT = "none ;";

	private static final String NEWLINE = AadlConstants.newlineChar;

	private UnparseText aadlText;

	
	protected static AadlUnparser unparser = null;
	
	public static AadlUnparser getAadlUnparser(){
		if (unparser == null){
			unparser = new AadlUnparser();
		}
		return unparser;
	}


	public AadlUnparser() {
		super( PROCESS_PRE_ORDER_ALL);
		aadlText = new UnparseText();
	}

	protected final void initSwitches() {

		/* here we are creating the various unparse switches */

		aadl2Switch = new Aadl2Switch<String>() {



			public String caseAadlPackage(AadlPackage object) {
					processComments(object);
					aadlText.addOutputNewline("package " + object.getName());
					process(object.getOwnedPublicSection());
					process(object.getOwnedPrivateSection());
					processOptionalSection(object.getOwnedPropertyAssociations(),"properties",AadlConstants.emptyString);
					aadlText.addOutputNewline("end " + object.getName() + ";");
				return DONE;
			}

			public String casePrivatePackageSection(PrivatePackageSection object) {
				processComments(object);
				aadlText.addOutputNewline("private");
				return null;
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see edu.cmu.sei.aadl.model.core.util.CoreSwitch#caseAadlPublic(edu.cmu.sei.aadl.model.core.AadlPublic)
			 */
			public String casePublicPackageSection(PublicPackageSection object) {
				processComments(object);
				aadlText.addOutputNewline("public");
				return null;
			}

			public String casePackageSection(PackageSection object) {
				if (!object.getImportedUnits().isEmpty()){
					aadlText.addOutput("with ");
					processRefEList(object.getImportedUnits(), ",", object);
					aadlText.addOutputNewline(";");
				}
				processEList(object.getOwnedPackageRenames());
				processEList(object.getOwnedFeatureGroupTypeRenames());
				processEList(object.getOwnedComponentTypeRenames());
				aadlText.incrementIndent();
				processEList(object.getOwnedClassifiers(), NEWLINE);
				processEList(object.getOwnedAnnexLibraries(), NEWLINE);
				aadlText.decrementIndent();
				return DONE;
			}
			
			public String casePackageRename(PackageRename object) {
				processComments(object);
				aadlText.addOutputNewline((object.getName()== null? "renames ":object.getName()+" renames ")
						+(object.isRenameAll()?"":"package ")
						+object.getRenamedPackage().getName()
						+(object.isRenameAll()?"::all;":";"));
				return DONE;
			}
			
			public String caseComponentTypeRename(ComponentTypeRename object) {
				processComments(object);
				aadlText.addOutputNewline((object.getName()== null? "renames ":object.getName()+" renames ")
						          +object.getCategory().getName()+" "+AadlUtil.getClassifierName(object.getRenamedComponentType(),object)+";");
				return DONE;
			}
			
			public String caseFeatureGroupTypeRename(FeatureGroupTypeRename object) {
				processComments(object);
				aadlText.addOutputNewline((object.getName()== null? "renames ":object.getName()+" renames ")
				                     +AadlUtil.getClassifierName(object.getRenamedFeatureGroupType(),object)+";");
				return DONE;
			}
			

			/**
			 * outputs the content of a component implementation It picks up
			 * after the superclass case. It returns done as processing is
			 * complete.
			 */
			public String caseComponentImplementation(ComponentImplementation object) {
				aadlText.addOutputNewline(object.getName());
				aadlText.incrementIndent();
				if (object.getExtended()!=null) {
					aadlText.addOutputNewline("extends "
							+ AadlUtil.getClassifierName( object
									.getExtended(),object));
				}
				processOptionalSection(object.getOwnedPrototypes(), "prototypes", AadlConstants.emptyString);
				processOptionalSection(object.getOwnedSubcomponents(), "subcomponents", AadlConstants.emptyString);
				if (object instanceof ThreadImplementation){
					processOptionalSection(((ThreadImplementation)object).getOwnedSubprogramCallSequences(),"calls",AadlConstants.emptyString);
				} else if (object instanceof SubprogramImplementation){
					processOptionalSection(((SubprogramImplementation)object).getOwnedSubprogramCallSequences(),"calls",AadlConstants.emptyString);
				}
				processOptionalSection(object.getOwnedConnections(), "connections", AadlConstants.emptyString);
				processOptionalSection(object.getOwnedEndToEndFlows(), "flows", AadlConstants.emptyString);
				processOptionalSection(object.getOwnedModes(), "modes", AadlConstants.emptyString);
				processOptionalSection(object.getOwnedPropertyAssociations(), "properties", AadlConstants.emptyString);
				processEList(object.getOwnedAnnexSubclauses());
				aadlText.decrementIndent();
				aadlText.addOutput("end ");
				aadlText.addOutputNewline(object.getName() + ";");
				return DONE;
			}

			/**
			 * Add the common part of component types
			 */
			public String caseComponentType(ComponentType object) {
				aadlText.addOutputNewline(object.getName());
				aadlText.incrementIndent();
				if (object.getExtended()!=null) {
					aadlText.addOutputNewline("extends "
							+ AadlUtil.getClassifierName(object.getExtended(),object));
				}
				processOptionalSection(object.getOwnedPrototypes(), "prototypes", AadlConstants.emptyString);
				processOptionalSection(object.getOwnedFeatures(), "features", AadlConstants.emptyString);
				processOptionalSection(object.getOwnedFlowSpecifications(),"flows",AadlConstants.emptyString);
				processOptionalSection(object.getOwnedPropertyAssociations(),"properties",AadlConstants.emptyString);
				processEList(object.getOwnedAnnexSubclauses());
				aadlText.decrementIndent();
				aadlText.addOutputNewline("end " + object.getName() + ";");
				return DONE;
			}


			/*
			 * (non-Javadoc)
			 * 
			 * @see edu.cmu.sei.aadl.model.core.util.CoreSwitch#caseMode(edu.cmu.sei.aadl.model.core.Mode)
			 */
			public String caseMode(Mode object) {
				processComments(object);
				aadlText.addOutput(object.getName() + ": ");
				if (object.isInitial())
					aadlText.addOutput("initial mode ");
				else
					aadlText.addOutput("mode ");
				processCurlyList(object.getOwnedPropertyAssociations());
				aadlText.addOutputNewline(";");
				return DONE;
			}

			/**
			 * unparse mode transitions
			 */
			public String caseModeTransition(ModeTransition object) {
				processComments(object);
				aadlText.addOutput(object.getName() + ": ");
				String s = (object.getSource().getName());
				aadlText.addOutput(s + " -[ ");
				EList<ModeTransitionTrigger> l = object.getOwnedTriggers();
				boolean first = true;
				for (ModeTransitionTrigger modeTransitionTrigger : l) {
					if (!first) {
						aadlText.addOutput(", ");
					}
					first = false;
					s = AadlUtil.getModeTransitionTriggerName(modeTransitionTrigger);
					aadlText.addOutputNewline(" ]-> " + s + ";");
				}
				s = (object.getDestination().getName());
				aadlText.addOutputNewline(" ]-> " + s + ";");
				return DONE;
			}

			/**
			 * Does the bulk of subcomponent declarations
			 */
			public String caseSubcomponent(Subcomponent object) {
				aadlText.addOutput(" "+AadlUtil.getSubcomponentTypeName(object.getSubcomponentType(),object));
				processOptionalEList(object.getOwnedPrototypeBindings(), ",");
				processEList(object.getArrayDimensions(), AadlConstants.emptyString);
				processCurlyList(object.getOwnedPropertyAssociations());
				processModalElement(object);
				aadlText.addOutputNewline(";");
				return DONE;
			}
			
			public String caseArrayDimension(ArrayDimension object){
				aadlText.addOutput("[");
				process(object.getSize());
				aadlText.addOutput("]");
				return DONE;
			}
			
			public String caseArraySize(ArraySize object){
				if (object.getSizeProperty()!= null){
					aadlText.addOutput(AadlUtil.getPropertySetElementName((NamedElement) object.getSizeProperty()));
				} else {
					aadlText.addOutput(Long.toString(object.getSize()));
				}
				return DONE;
			}

			/**
			 * unparses annex library
			 * 
			 * @param al
			 *            AnnexLibrary object
			 */
			public String caseAnnexLibrary(AnnexLibrary al) {
				AnnexUnparserRegistry registry = (AnnexUnparserRegistry) AnnexRegistry
						.getRegistry(AnnexRegistry.ANNEX_UNPARSER_EXT_ID);
				String annexName = al.getName();
				AnnexUnparser unparser = registry.getAnnexUnparser(annexName);

				if (unparser != null) {
					processComments(al);
					aadlText.addOutputNewline("annex " + annexName + " {**");
					aadlText.incrementIndent();
					aadlText.addOutput(unparser.unparseAnnexLibrary(al,
							aadlText.getIndentString()));
					aadlText.decrementIndent();
					aadlText.addOutputNewline("**};");
				}
				return DONE;
			}

			/**
			 * unparses default annex library
			 * 
			 * @param dal
			 *            DefaultAnnexLibrary object
			 */
			public String caseDefaultAnnexLibrary(DefaultAnnexLibrary dal) {
				AnnexUnparserRegistry registry = (AnnexUnparserRegistry) AnnexRegistry
						.getRegistry(AnnexRegistry.ANNEX_UNPARSER_EXT_ID);
				String annexName = dal.getName();
				AnnexUnparser unparser = registry.getAnnexUnparser("*");

				if (unparser != null) {
					processComments(dal);
					aadlText.addOutput("annex " + annexName + " {**");
					aadlText.incrementIndent();
					aadlText.addOutput(unparser.unparseAnnexLibrary(dal,
							aadlText.getIndentString()));
					aadlText.decrementIndent();
					aadlText.addOutputNewline("**};");
				}
				return DONE;
			}

			/**
			 * unparses annex subclause
			 * 
			 * @param as
			 *            AnnexSubclause object
			 */
			public String caseAnnexSubclause(AnnexSubclause as) {
				AnnexUnparserRegistry registry = (AnnexUnparserRegistry) AnnexRegistry
						.getRegistry(AnnexRegistry.ANNEX_UNPARSER_EXT_ID);
				String annexName = as.getName();
				AnnexUnparser unparser = registry.getAnnexUnparser(annexName);

				if (unparser != null) {
					processComments(as);
					aadlText.addOutputNewline("annex " + annexName + " {**");
					aadlText.incrementIndent();
					aadlText.addOutput(unparser.unparseAnnexSubclause(as,
							aadlText.getIndentString()));
					aadlText.decrementIndent();
					aadlText.addOutputNewline("**};");
				}
				return DONE;
			}

			/**
			 * unparses defaultannex subclause
			 * 
			 * @param das
			 *            DefaultAnnexSubclause object
			 */
			public String caseDefaultAnnexSubclause(DefaultAnnexSubclause das) {
				AnnexUnparserRegistry registry = (AnnexUnparserRegistry) AnnexRegistry
						.getRegistry(AnnexRegistry.ANNEX_UNPARSER_EXT_ID);
				String annexName = das.getName();
				AnnexUnparser unparser = registry.getAnnexUnparser("*");

				if (unparser != null) {
					processComments(das);
					aadlText.addOutputNewline("annex " + annexName + " {**");
					aadlText.incrementIndent();
					aadlText.addOutputNewline(unparser.unparseAnnexSubclause(
							das, aadlText.getIndentString()));
					aadlText.decrementIndent();
					aadlText.addOutputNewline("**};");
				}
				return DONE;
			}

			/**
			 * Fills in category name lets super class fill in the rest.
			 */
			public String caseBusImplementation(BusImplementation object) {
				processComments(object);
				aadlText.addOutput("bus implementation ");
				return null;
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see edu.cmu.sei.aadl.model.component.util.ComponentSwitch#caseBusSubcomponent(edu.cmu.sei.aadl.model.component.BusSubcomponent)
			 */
			public String caseBusSubcomponent(BusSubcomponent object) {
				processComments(object);
				aadlText.addOutput((object.getRefined() == null ?(object.getName() + ": "):
					(object.getRefined().getName() +": refined to "))
						+ "bus");
				return null;
			}

			/**
			 * Fills in category name lets super class fill in the rest.
			 */
			public String caseBusType(BusType object) {
				processComments(object);
				aadlText.addOutput("bus ");
				return null;
			}

			/**
			 * Fills in category name lets super class fill in the rest.
			 */
			public String caseDataImplementation(DataImplementation object) {
				processComments(object);
				aadlText.addOutput("data implementation ");
				return null;
			}

			/**
			 * Fills in identifier & category name lets super class fill in the
			 * rest.
			 */
			public String caseDataSubcomponent(DataSubcomponent object) {
				processComments(object);
				aadlText.addOutput((object.getRefined() == null ?(object.getName() + ": "):
					(object.getRefined().getName() +": refined to "))
						+ "data");
				return null;
			}

			/**
			 * Fills in category name lets super class fill in the rest.
			 */
			public String caseDataType(DataType object) {
				processComments(object);
				aadlText.addOutput("data ");
				return null;
			}

			/**
			 * Fills in category name lets super class fill in the rest.
			 */
			public String caseDeviceImplementation(DeviceImplementation object) {
				processComments(object);
				aadlText.addOutput("device implementation ");
				return null;
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see edu.cmu.sei.aadl.model.component.util.ComponentSwitch#caseDeviceSubcomponent(edu.cmu.sei.aadl.model.component.DeviceSubcomponent)
			 */
			public String caseDeviceSubcomponent(DeviceSubcomponent object) {
				processComments(object);
				aadlText.addOutput((object.getRefined() == null ?(object.getName() + ": "):
					(object.getRefined().getName() +": refined to "))
						+ "device");
				return null;
			}

			/**
			 * Fills in category name lets super class fill in the rest.
			 */
			public String caseDeviceType(DeviceType object) {
				processComments(object);
				aadlText.addOutput("device ");
				return null;
			}

			/**
			 * Fills in category name lets super class fill in the rest.
			 */
			public String caseMemoryImplementation(MemoryImplementation object) {
				processComments(object);
				aadlText.addOutput("memory implementation ");
				return null;
			}

			/**
			 * Fills in category name lets super class fill in the rest.
			 */
			public String caseMemorySubcomponent(MemorySubcomponent object) {
				processComments(object);
				aadlText.addOutput((object.getRefined() == null ?(object.getName() + ": "):
					(object.getRefined().getName() +": refined to "))
						+ "memory");
				return null;
			}

			/**
			 * Fills in category name lets super class fill in the rest.
			 */
			public String caseMemoryType(MemoryType object) {
				processComments(object);
				aadlText.addOutput("memory ");
				return null;
			}

			/**
			 * Fills in category name lets super class fill in the rest.
			 */
			public String caseProcessImplementation(ProcessImplementation object) {
				processComments(object);
				aadlText.addOutput("process implementation ");
				return null;
			}

			/**
			 * Fills in category name lets super class fill in the rest.
			 */
			public String caseVirtualProcessorImplementation(VirtualProcessorImplementation object) {
				processComments(object);
				aadlText.addOutput("virtual processor implementation ");
				return null;
			}

			/**
			 * Fills in category name lets super class fill in the rest.
			 */
			public String caseVirtualProcessorSubcomponent(VirtualProcessorSubcomponent object) {
				processComments(object);
				aadlText.addOutput((object.getRefined() == null ?(object.getName() + ":"):
					(object.getRefined().getName() +" refined to"))
						+ " virtual processor");
				return null;
			}

			/**
			 * Fills in category name lets super class fill in the rest.
			 */
			public String caseVirtualProcessorType(VirtualProcessorType object) {
				processComments(object);
				aadlText.addOutput("virtual processor ");
				return null;
			}


			/**
			 * Fills in category name lets super class fill in the rest.
			 */
			public String caseVirtualBusImplementation(VirtualBusImplementation object) {
				processComments(object);
				aadlText.addOutput("virtual bus implementation ");
				return null;
			}

			/**
			 * Fills in category name lets super class fill in the rest.
			 */
			public String caseVirtualBusSubcomponent(VirtualBusSubcomponent object) {
				processComments(object);
				aadlText.addOutput((object.getRefined() == null ?(object.getName() + ":"):
					(object.getRefined().getName() +" refined to"))
						+ " virtual bus");
				return null;
			}

			/**
			 * Fills in category name lets super class fill in the rest.
			 */
			public String caseVirtualBusType(VirtualBusType object) {
				processComments(object);
				aadlText.addOutput("virtual bus ");
				return null;
			}

			/**
			 * Fills in category name lets super class fill in the rest.
			 */
			public String caseAbstractImplementation(AbstractImplementation object) {
				processComments(object);
				aadlText.addOutput("abstract implementation ");
				return null;
			}

			/**
			 * Fills in category name lets super class fill in the rest.
			 */
			public String caseAbstractSubcomponent(AbstractSubcomponent object) {
				processComments(object);
				aadlText.addOutput((object.getRefined() == null ?(object.getName() + ": "):
					(object.getRefined().getName() +": refined to "))
						+ "abstract");
				return null;
			}

			/**
			 * Fills in category name lets super class fill in the rest.
			 */
			public String caseAbstractType(AbstractType object) {
				processComments(object);
				aadlText.addOutput("abstract ");
				return null;
			}

			/**
			 * Fills in category name lets super class fill in the rest.
			 */
			public String caseProcessorImplementation(ProcessorImplementation object) {
				processComments(object);
				aadlText.addOutput("processor implementation ");
				return null;
			}

			/**
			 * Fills in category name lets super class fill in the rest.
			 */
			public String caseProcessorSubcomponent(ProcessorSubcomponent object) {
				processComments(object);
				aadlText.addOutput((object.getRefined() == null ?(object.getName() + ": "):
					(object.getRefined().getName() +": refined to "))
						+ "processor");
				return null;
			}

			/**
			 * Fills in category name lets super class fill in the rest.
			 */
			public String caseProcessorType(ProcessorType object) {
				processComments(object);
				aadlText.addOutput("processor ");
				return null;
			}
			/**
			 * Fills in identifier & category name lets super class fill in the
			 * rest.
			 */
			public String caseProcessSubcomponent(ProcessSubcomponent object) {
				processComments(object);
				aadlText.addOutput((object.getRefined() == null ?(object.getName() + ": "):
					(object.getRefined().getName() +": refined to "))
								+ "process");
				return null;
			}

			/**
			 * Fills in category name lets super class fill in the rest.
			 */
			public String caseProcessType(ProcessType object) {
				processComments(object);
				aadlText.addOutput("process ");
				return null;
			}


			/**
			 * Fills in category name lets super class fill in the rest.
			 */
			public String caseSystemImplementation(SystemImplementation object) {
				processComments(object);
				aadlText.addOutput("system implementation ");
				return null;
			}

			/**
			 * Fills in identifier & category name lets super class fill in the
			 * rest.
			 */
			public String caseSystemSubcomponent(SystemSubcomponent object) {
				processComments(object);
				aadlText.addOutput((object.getRefined() == null ?(object.getName() + ": "):
					(object.getRefined().getName() +": refined to "))
						+ "system");
				return null;
			}

			/**
			 * Fills in category name lets super class fill in the rest.
			 */
			public String caseSystemType(SystemType object) {
				processComments(object);
				aadlText.addOutput("system ");
				return null;
			}

			/**
			 * Fills in category name lets super class fill in the rest.
			 */
			public String caseThreadGroupImplementation(ThreadGroupImplementation object) {
				processComments(object);
				aadlText.addOutput("thread group implementation ");
				return null;
			}

			/**
			 * Fills in category name lets super class fill in the rest.
			 */
			public String caseThreadGroupSubcomponent(
					ThreadGroupSubcomponent object) {
				processComments(object);
				aadlText.addOutput((object.getRefined() == null ?(object.getName() + ": "):
					(object.getRefined().getName() +": refined to "))
						+ "thread group");
				return null;
			}

			/**
			 * Fills in category name lets super class fill in the rest.
			 */
			public String caseThreadGroupType(ThreadGroupType object) {
				processComments(object);
				aadlText.addOutput("thread group ");
				return null;
			}

			/**
			 * Fills in category name lets super class fill in the rest.
			 */
			public String caseThreadImplementation(ThreadImplementation object) {
				processComments(object);
				aadlText.addOutput("thread implementation ");
				return null;
			}

			/**
			 * Fills in identifier & category name lets super class fill in the
			 * rest.
			 */
			public String caseThreadSubcomponent(ThreadSubcomponent object) {
				processComments(object);
				aadlText.addOutput((object.getRefined() == null ?(object.getName() + ": "):
					(object.getRefined().getName() +": refined to "))
						+ "thread");
				return null;
			}

			/**
			 * Fills in category name lets super class fill in the rest.
			 */
			public String caseThreadType(ThreadType object) {
				processComments(object);
				aadlText.addOutput("thread ");
				return null;
			}

			/**
			 * Fills in category name lets super class fill in the rest.
			 */
			public String caseSubprogramImplementation(SubprogramImplementation object) {
				processComments(object);
				aadlText.addOutput("subprogram implementation ");
				return null;
			}

			/**
			 * Fills in category name lets super class fill in the rest.
			 */
			public String caseSubprogramType(SubprogramType object) {
				processComments(object);
				aadlText.addOutput("subprogram ");
				return null;
			}
			/*
			 * (non-Javadoc)
			 * 
			 */
			public String caseSubprogramSubcomponent(SubprogramSubcomponent object) {
				processComments(object);
				aadlText.addOutput((object.getRefined() == null ?(object.getName() + ": "):
					(object.getRefined().getName() +": refined to "))
						+ "subprogram");
				return null;
			}

			/**
			 * Fills in category name lets super class fill in the rest.
			 */
			public String caseSubprogramGroupImplementation(SubprogramGroupImplementation object) {
				processComments(object);
				aadlText.addOutput("subprogram group implementation ");
				return null;
			}

			/**
			 * Fills in category name lets super class fill in the rest.
			 */
			public String caseSubprogramGroupType(SubprogramGroupType object) {
				processComments(object);
				aadlText.addOutput("subprogram group ");
				return null;
			}
			/*
			 * (non-Javadoc)
			 * 
			 */
			public String caseSubprogramGroupSubcomponent(SubprogramGroupSubcomponent object) {
				processComments(object);
				aadlText.addOutput((object.getRefined() == null ?(object.getName() + ": "):
					(object.getRefined().getName() +": refined to "))
						+ "subprogram group");
				return null;
			}

			
			
			/**
			 * Prototypes
			 */

			/**
			 * Fills in category name lets super class fill in the rest.
			 */
			public String caseSubprogramPrototype(SubprogramPrototype object) {
				processComments(object);
				aadlText.addOutput((object.getRefined() == null ?(object.getName() + ":"):
						(object.getRefined().getName() +" refined to"))
						+ " subprogram");
				return null;
			}

			/**
			 * Fills in category name lets super class fill in the rest.
			 */
			public String caseSystemPrototype(SystemPrototype object) {
				processComments(object);
				aadlText.addOutput((object.getRefined() == null ?(object.getName() + ":"):
						(object.getRefined().getName() +" refined to"))
						+ " system");
				return null;
			}

			/**
			 * Fills in category name lets super class fill in the rest.
			 */
			public String caseAbstractPrototype(AbstractPrototype object) {
				processComments(object);
				aadlText.addOutput((object.getRefined() == null ?(object.getName() + ":"):
						(object.getRefined().getName() +" refined to"))
						+ " abstract");
				return null;
			}

			/**
			 * Fills in category name lets super class fill in the rest.
			 */
			public String caseProcessPrototype(ProcessPrototype object) {
				processComments(object);
				aadlText.addOutput((object.getRefined() == null ?(object.getName() + ":"):
						(object.getRefined().getName() +" refined to"))
						+ " process");
				return null;
			}

			/**
			 * Fills in category name lets super class fill in the rest.
			 */
			public String caseThreadGroupPrototype(ThreadGroupPrototype object) {
				processComments(object);
				aadlText.addOutput((object.getRefined() == null ?(object.getName() + ":"):
						(object.getRefined().getName() +" refined to"))
						+ " thread group");
				return null;
			}

			/**
			 * Fills in category name lets super class fill in the rest.
			 */
			public String caseThreadPrototype(ThreadPrototype object) {
				processComments(object);
				aadlText.addOutput((object.getRefined() == null ?(object.getName() + ":"):
						(object.getRefined().getName() +" refined to"))
						+ " thread");
				return null;
			}

			/**
			 * Fills in category name lets super class fill in the rest.
			 */
			public String caseProcessorPrototype(ProcessorPrototype object) {
				processComments(object);
				aadlText.addOutput((object.getRefined() == null ?(object.getName() + ":"):
						(object.getRefined().getName() +" refined to"))
						+ " processor");
				return null;
			}

			/**
			 * Fills in category name lets super class fill in the rest.
			 */
			public String caseMemoryPrototype(MemoryPrototype object) {
				processComments(object);
				aadlText.addOutput((object.getRefined() == null ?(object.getName() + ":"):
						(object.getRefined().getName() +" refined to"))
						+ " memory");
				return null;
			}

			/**
			 * Fills in category name lets super class fill in the rest.
			 */
			public String caseBusPrototype(BusPrototype object) {
				processComments(object);
				aadlText.addOutput((object.getRefined() == null ?(object.getName() + ":"):
						(object.getRefined().getName() +" refined to"))
						+ " bus");
				return null;
			}

			/**
			 * Fills in category name lets super class fill in the rest.
			 */
			public String caseDevicePrototype(DevicePrototype object) {
				processComments(object);
				aadlText.addOutput((object.getRefined() == null ?(object.getName() + ":"):
						(object.getRefined().getName() +" refined to"))
						+ " device");
				return null;
			}

			/**
			 * Fills in category name lets super class fill in the rest.
			 */
			public String caseVirtualProcessorPrototype(VirtualProcessorPrototype object) {
				processComments(object);
				aadlText.addOutput((object.getRefined() == null ?(object.getName() + ":"):
						(object.getRefined().getName() +" refined to"))
						+ " virtual processor");
				return null;
			}

			/**
			 * Fills in category name lets super class fill in the rest.
			 */
			public String caseVirtualBusPrototype(VirtualBusPrototype object) {
				processComments(object);
				aadlText.addOutput((object.getRefined() == null ?(object.getName() + ":"):
						(object.getRefined().getName() +" refined to"))
						+ " virtual bus");
				return null;
			}

			/**
			 * Fills in category name lets super class fill in the rest.
			 */
			public String caseSubprogramGroupPrototype(SubprogramGroupPrototype object) {
				processComments(object);
				aadlText.addOutput((object.getRefined() == null ?(object.getName() + ":"):
						(object.getRefined().getName() +" refined to"))
						+ " subprogram group");
				return null;
			}
			

			/**
			 * Does the bulk of prototype declarations
			 */
			public String caseComponentPrototype(ComponentPrototype object) {
				aadlText.addOutput(AadlUtil.getClassifierName(object.getConstrainingClassifier(),object));
				if (object.isArray()){
					aadlText.addOutput("[] ");
				} else {
					aadlText.addOutput(" ");
				}
				processCurlyList(object.getOwnedPropertyAssociations());
				aadlText.addOutputNewline(";");
				return DONE;
			}

			public String caseFeatureGroupPrototype(FeatureGroupPrototype object) {
				processComments(object);
				aadlText.addOutput((object.getRefined() == null ?(object.getName() + ":"):
						(object.getRefined().getName() +" refined to"))
						+ " feature group");
				aadlText.addOutput(AadlUtil.getClassifierName(object.getConstrainingFeatureGroupType(),object));
				aadlText.addOutput(" ");
				processCurlyList(object.getOwnedPropertyAssociations());
				aadlText.addOutputNewline(";");
				return DONE;
			}

			/**
			 * Does the bulk of feature prototype declarations
			 */
			public String caseFeaturePrototype(FeaturePrototype object) {
				processComments(object);
				aadlText.addOutput((object.getRefined() == null ?(object.getName() + ":"):
						(object.getRefined().getName() +" refined to"))
						+ " feature");
				aadlText.addOutput(AadlUtil.getClassifierName(object.getConstrainingClassifier(),object));
				aadlText.addOutput(" ");
				processCurlyList(object.getOwnedPropertyAssociations());
				aadlText.addOutputNewline(";");
				return DONE;
			}

			/**
			 * Does the  prototype binding 
			 */
			public String caseComponentPrototypeBinding(ComponentPrototypeBinding object) {
				processComments(object);
				aadlText.addOutput(object.getFormal().getName()+" => ");
				if (object.getActuals().size() == 1){
					process(object.getActuals().get(0));
				} else {
					processOptionalEList(object.getActuals(), ",");
				}
				return DONE;
			}
			
			/**
			 * Does the  prototype actual 
			 */
			public String caseComponentPrototypeActual(ComponentPrototypeActual object) {
				processComments(object);
				aadlText.addOutput(object.getCategory().getName()+" ");
				SubcomponentType sct = object.getSubcomponentType();
				if (sct instanceof Classifier){
					aadlText.addOutput(AadlUtil.getClassifierName((Classifier)sct,object));
				} else {
					aadlText.addOutput(((NamedElement)sct).getName());
				}
				processOptionalEList(object.getBindings(), ",");
				return DONE;
			}


			/**
			 * Does the  feature group prototype binding 
			 */
			public String caseFeatureGroupPrototypeBinding(FeatureGroupPrototypeBinding object) {
				processComments(object);
				aadlText.addOutput(object.getFormal().getName()+" => feature group ");
				process(object.getActual());
				return DONE;
			}
			
			public String caseFeatureGroupPrototypeActual(FeatureGroupPrototypeActual object) {
				FeatureType sct = object.getFeatureType();
				if (sct instanceof Classifier){
					aadlText.addOutput(AadlUtil.getClassifierName((Classifier)sct,object));
				} else {
					aadlText.addOutput(((NamedElement)sct).getName());
				}
				processOptionalEList(object.getBindings(), ",");
				return DONE;
			}

			/**
			 * Does the  feature prototype binding 
			 */
			public String caseFeaturePrototypeBinding(FeaturePrototypeBinding object) {
				processComments(object);
				aadlText.addOutput(object.getFormal().getName()+" => ");
				process(object.getActual());
				return DONE;
			}
			
			public String casePortSpecification(PortSpecification object) {
				aadlText.addOutput(object.getDirection().getName()+" "+object.getCategory().getName()+" port ");
				Classifier sct = object.getClassifier();
				if (sct != null){
					aadlText.addOutput(AadlUtil.getClassifierName((Classifier)sct,object));
				}
				return DONE;
			}

			public String caseAccessSpecification(AccessSpecification object) {
				aadlText.addOutput(object.getKind().getName()+" "+object.getCategory().getName()+" access ");
				Classifier sct = object.getClassifier();
				if (sct != null){
					aadlText.addOutput(AadlUtil.getClassifierName((Classifier)sct,object));
				}
				return DONE;
			}

			public String caseFeaturePrototypeReference(FeaturePrototypeReference object) {
				aadlText.addOutput(object.getDirection().getName()+" feature "+object.getPrototype().getName());
				return DONE;
			}
			
			/**
			 * call sequence processing.
			 */
			public String caseSubprogramCallSequence(SubprogramCallSequence object) {
				processComments(object);
				
				String n = object.getName();
				aadlText.addOutput(n + ": ");
				EList<CallSpecification> list = object.getOwnedCallSpecifications();
				if (list != null && !list.isEmpty()) {
					aadlText.addOutputNewline(" {");
					aadlText.incrementIndent();
					processEList(list);
					aadlText.addOutput("}");
					aadlText.decrementIndent();
				}
				aadlText.addOutput(" ");
				processCurlyList(object.getOwnedPropertyAssociations());
				processModalElement(object);
				aadlText.addOutputNewline(";");
				return DONE;
			}

			/**
			 * subprogram call processing.
			 */
			public String caseSubprogramCall(
					SubprogramCall object) {
				processComments(object);
				aadlText.addOutput(object.getName() + ": "
						+ "subprogram ");
				CallContext cxt = object.getContext();
				String s = AadlUtil.getClassifierOrLocalName((NamedElement)cxt, object);
				if (!s.isEmpty()){
					aadlText.addOutput(s+".");
				}
				CalledSubprogram cs = object.getCalledSubprogram();
				aadlText.addOutput(AadlUtil.getClassifierOrLocalName((NamedElement)cs, object));
				processCurlyList(object.getOwnedPropertyAssociations());
				aadlText.addOutputNewline(";");
				return DONE;
			}
			
			public String caseProcessorCall(
					ProcessorCall object) {
				processComments(object);
				aadlText.addOutput(object.getName() + ": "
						+ "subprogram processor."+object.getSubprogramAccessName());
				processCurlyList(object.getOwnedPropertyAssociations());
				aadlText.addOutputNewline(";");
				return DONE;
			}

			public String casePortConnection(PortConnection object) {
				processComments(object);
				if (object.getRefined()!=null) {
					aadlText.addOutput(object.getRefined().getName()+": refined to "
							+ "port ");
				} else {
					aadlText.addOutput(object.getName() + ": "+ "port ");
					aadlText.addOutput(AadlUtil.getConnectionEndName(object.getSource()) + (object.isBidirectional()?" <-> ":" -> "));
					aadlText.addOutput(AadlUtil.getConnectionEndName(object.getDestination()));
				}
				processCurlyList(object.getOwnedPropertyAssociations());
				processModalPath(object);
				aadlText.addOutputNewline(";");
				return DONE;
			}


			public String caseFeatureGroupConnection(FeatureGroupConnection object) {
				processComments(object);
				if (object.getRefined()!=null) {
					aadlText.addOutput(object.getRefined().getName()+": refined to "
							+ "feature group ");
				} else {
					aadlText.addOutput(object.getName() + ": "+ "feature group ");
					aadlText.addOutput(AadlUtil.getConnectionEndName(object.getSource()) + (object.isBidirectional()?" <-> ":" -> "));
					aadlText.addOutput(AadlUtil.getConnectionEndName(object.getDestination()));
				}
				processCurlyList(object.getOwnedPropertyAssociations());
				processModalPath(object);
				aadlText.addOutputNewline(";");
				return DONE;
			}

			public String caseParameterConnection(ParameterConnection object) {
				processComments(object);
				if (object.getRefined()!=null) {
					aadlText.addOutput(object.getRefined().getName()+": refined to "
							+ "parameter ");
				} else {
					aadlText.addOutput(object.getName() + ": "+ "parameter ");
					aadlText.addOutput(AadlUtil.getConnectionEndName(object.getSource()) + (object.isBidirectional()?" <-> ":" -> "));
					aadlText.addOutput(AadlUtil.getConnectionEndName(object.getDestination()));
				}
				processCurlyList(object.getOwnedPropertyAssociations());
				processModalPath(object);
				aadlText.addOutputNewline(";");
				return DONE;
			}

			public String caseAccessConnection(AccessConnection object) {
				processComments(object);
				if (object.getRefined()!=null) {
					aadlText.addOutput(object.getRefined().getName()+": refined to "
							+object.getAccessCategory().getName()+ " access ");
				} else {
					aadlText.addOutput(object.getName() + ": "+object.getAccessCategory().getName()+ " access ");
					aadlText.addOutput(AadlUtil.getConnectionEndName(object.getSource()) + (object.isBidirectional()?" <-> ":" -> "));
					aadlText.addOutput(AadlUtil.getConnectionEndName(object.getDestination()));
				}
				processCurlyList(object.getOwnedPropertyAssociations());
				processModalPath(object);
				aadlText.addOutputNewline(";");
				return DONE;
			}

			/**
			 * bus access
			 */
			public String caseBusAccess(BusAccess object) {
				String d;
				processComments(object);
				if (object.getKind() == AccessType.REQUIRED)
					d = "requires";
				else
					d = "provides";
				aadlText.addOutput(object.getName() + ": "
						+ (object.getRefined() != null ? "refined to " : "") + d
						+ " bus access ");

				aadlText.addOutput(AadlUtil.getSubcomponentTypeName(object.getBusFeatureClassifier(), object));
				processCurlyList(object.getOwnedPropertyAssociations());
				aadlText.addOutputNewline(";");
				return DONE;
			}

			/**
			 *  subprogram access
			 */
			public String caseSubprogramAccess(SubprogramAccess object) {
				String d;
				processComments(object);
				if (object.getKind() == AccessType.REQUIRED)
					d = "requires";
				else
					d = "provides";
				aadlText.addOutput(object.getName() + ": "
						+ (object.getRefined() != null ? "refined to " : "") + d
						+ " subprogram access ");

				aadlText.addOutput(AadlUtil.getSubcomponentTypeName(object.getSubprogramFeatureClassifier(), object));
				processCurlyList(object.getOwnedPropertyAssociations());
				aadlText.addOutputNewline(";");
				return DONE;
			}

			/**
			 *  subprogram group access
			 */
			public String caseSubprogramGroupAccess(SubprogramGroupAccess object) {
				String d;
				processComments(object);
				if (object.getKind() == AccessType.REQUIRED)
					d = "requires";
				else
					d = "provides";
				aadlText.addOutput(object.getName() + ": "
						+ (object.getRefined() != null ? "refined to " : "") + d
						+ " subprogram group access ");

				aadlText.addOutput(AadlUtil.getSubcomponentTypeName(object.getSubprogramGroupFeatureClassifier(), object));
				processCurlyList(object.getOwnedPropertyAssociations());
				aadlText.addOutputNewline(";");
				return DONE;
			}

			/**
			 * data access
			 */
			public String caseDataAccess(DataAccess object) {
				String d;
				processComments(object);
				if (object.getKind() == AccessType.REQUIRED)
					d = "requires";
				else
					d = "provides";
				aadlText.addOutput(object.getName() + ": "
						+ (object.getRefined() != null ? "refined to " : "") + d
						+ " data access ");
				aadlText.addOutput(AadlUtil.getSubcomponentTypeName(object.getDataFeatureClassifier(), object));
				processCurlyList(object.getOwnedPropertyAssociations());
				aadlText.addOutputNewline(";");
				return DONE;
			}

			public String caseDataPort(DataPort object) {
				processComments(object);
				aadlText.addOutput((object.getRefined() == null ?(object.getName() + ": "):
					(object.getRefined().getName() +": refined to "))
								+ object.getDirection().getName()
								+ " data port ");
				aadlText.addOutput(AadlUtil.getSubcomponentTypeName(object.getDataFeatureClassifier(), object));
				return null;
			}

			/**
			 * Does the name and category. Port handles the rest
			 */
			public String caseEventDataPort(EventDataPort object) {
				String name = object.getName();
				Classifier ct = object.getContainingClassifier();
				if ((ct instanceof ThreadType)
						&& name.equalsIgnoreCase("error")) {
					return DONE;
				}
				processComments(object);
				aadlText.addOutput((object.getRefined() == null ?(object.getName() + ": "):
					(object.getRefined().getName() +": refined to "))
						+ object.getDirection().getName()
						+ " event data port ");
				aadlText.addOutput(AadlUtil.getSubcomponentTypeName(object.getDataFeatureClassifier(), object));
				return null;
			}

			/**
			 * Does the name and category. Port handles the rest
			 */
			public String caseEventPort(EventPort object) {
				String name = object.getName();
				Classifier ct = object.getContainingClassifier();
				if ((ct instanceof ThreadType)
						&& (name.equalsIgnoreCase("complete"))) {
					return DONE;
				}
				processComments(object);
				aadlText.addOutput((object.getRefined() == null ?(object.getName() + ": "):
					(object.getRefined().getName() +": refined to "))
						+ object.getDirection().getName()
						+ " event port ");
				return null;
			}

			/**
			 * Does the common part of port
			 */
			public String casePort(Port object) {
				processEList(object.getArrayDimensions(), AadlConstants.emptyString);
				processCurlyList(object.getOwnedPropertyAssociations());
				aadlText.addOutputNewline(";");
				return DONE;
			}

			/**
			 * Does the parameter
			 */
			public String caseParameter(Parameter object) {
				processComments(object);
				aadlText.addOutput((object.getRefined() == null ?(object.getName() + ": "):
					(object.getRefined().getName() +": refined to "))
						+ object.getDirection() + " parameter ");
				aadlText.addOutput(AadlUtil.getSubcomponentTypeName(object.getDataFeatureClassifier(), object));
				processCurlyList(object.getOwnedPropertyAssociations());
				aadlText.addOutputNewline(";");
				return DONE;
			}

			/**
			 * Does the port group
			 */
			public String caseFeatureGroup(FeatureGroup object) {
				processComments(object);
				aadlText.addOutput((object.getRefined() == null ?(object.getName() + ": "):
					(object.getRefined().getName() +": refined to "))
						+ "feature group ");
				if (object.isInverse()){
					aadlText.addOutput("inverse of ");
				}
				aadlText.addOutput(AadlUtil.getFeatureTypeName(object.getFeatureType(), object));
				processCurlyList(object.getOwnedPropertyAssociations());
				aadlText.addOutputNewline(";");
				return DONE;
			}

			/**
			 * Add the common part of component types
			 */
			public String caseFeatureGroupType(FeatureGroupType object) {
				processComments(object);
				aadlText.addOutput("feature group ");
				aadlText.addOutputNewline(object.getName());
				aadlText.incrementIndent();
				if (object.getExtended() != null) {
					aadlText.addOutput(" extends "+AadlUtil.getClassifierName(object.getExtended(), object));
				}
				processOptionalSection(object.getOwnedPrototypes(), "prototypes", AadlConstants.emptyString);
				EList<Feature> features = object.getOwnedFeatures();
				String invName = AadlUtil.getClassifierName(object.getInverse(),object);
				if (!(invName != null && (object.getOwnedFeatures() == null || features
						.isEmpty()))) {
					processOptionalSection(features, "features", NONESTMT);
				}
				if (invName != null && !invName.isEmpty())
					aadlText.addOutputNewline("inverse of "
							+ invName);
				processSection(object.getOwnedPropertyAssociations(),"properties",object.isNoProperties());
				processEList(object.getOwnedAnnexSubclauses());
				aadlText.decrementIndent();
				aadlText.addOutputNewline("end " + object.getName() + ";");
				return DONE;
			}


			/**
			 * Handles all provides, requires, and parameters
			 */
			public String caseAbstractFeature(AbstractFeature object) {
				processComments(object);
				aadlText.addOutput((object.getRefined() == null ?(object.getName() + ": "):
					(object.getRefined().getName() +": refined to "))
						+ "feature ");
				aadlText.addOutput(AadlUtil.getFeaturePrototypeName(object.getFeaturePrototype(), object));
				processCurlyList(object.getOwnedPropertyAssociations());
				aadlText.addOutputNewline(";");
				return DONE;
			}

			/**
			 * Handles flow  spec
			 */
			public String caseFlowSpecification(FlowSpecification object) {
				processComments(object);
				aadlText.addOutput(object.getName() + ": ");
				if (object.getRefined() != null)
					aadlText.addOutput("refined to ");
				aadlText.addOutput("flow "+object.getKind().getName()+" ");
				if (object.getRefined() == null){
					FlowEnd inend = object.getInEnd();
					FlowEnd outend = object.getOutEnd(); 
					if (inend != null && outend != null){
					aadlText.addOutput(AadlUtil.getFlowEndName(inend) + " -> "
							+ AadlUtil.getFlowEndName(outend));
					} else if (inend != null){
						aadlText.addOutput(AadlUtil.getFlowEndName(inend));
					} else {
						aadlText.addOutput(AadlUtil.getFlowEndName(outend));
					}
					}
				processCurlyList(object.getOwnedPropertyAssociations());
				aadlText.addOutputNewline(";");
				return DONE;
			}


			/**
			 * Handles flow implementation
			 */
			public String caseFlowImplementation(FlowImplementation object) {
				processComments(object);
				// add location counter
				
				aadlText.addOutput(object.getName() + ": ");
				aadlText.addOutput("flow "+object.getKind().getName()+" ");
				FlowSpecification fps = object.getSpecification();
				FlowEnd inend = fps.getInEnd();
				boolean doArrow = false;
				if (inend != null){
					aadlText.addOutput(AadlUtil.getFlowEndName(inend));
					doArrow = true;
				}
				EList<FlowSegment> fel = object.getOwnedFlowSegments();
				aadlText.incrementIndent();
				boolean even = true;
				for (FlowSegment flowSegment : fel) {
					aadlText.addOutput((doArrow?" -> ":"") + AadlUtil.getFlowSegmentName(flowSegment));
					doArrow = true;
					even = !even;
					if (even) {
						aadlText.addOutputNewline("");
					}
				}
				FlowEnd outend = fps.getInEnd();
				if (outend != null){
					aadlText.addOutput((doArrow?" -> ":"") + AadlUtil.getFlowEndName(fps.getOutEnd()));
				}
				processCurlyList(object.getOwnedPropertyAssociations());
				processModalElement(object);
				aadlText.decrementIndent();
				aadlText.addOutputNewline(";");
				return DONE;
			}


			/**
			 * Handles flow ETEF
			 */
			public String caseEndToEndFlow(EndToEndFlow object) {
				processComments(object);
				aadlText.addOutput(object.getName() + ": ");
				if (object.getRefined() != null)
					aadlText.addOutput("refined to ");
				aadlText.addOutput("end to end flow ");
				if (object.getRefined() == null) {
					EList<EndToEndFlowSegment> fel = object.getOwnedEndToEndFlowSegments();
					Iterator<EndToEndFlowSegment> it = fel.iterator();
					EndToEndFlowSegment flowSegment = (EndToEndFlowSegment) it.next();
					aadlText.addOutput(AadlUtil.getFlowSegmentName(flowSegment));
					aadlText.incrementIndent();
					while (it.hasNext()) {
						flowSegment = (EndToEndFlowSegment) it.next();
						aadlText.addOutput(" -> " + AadlUtil.getFlowSegmentName(flowSegment));
						if (it.hasNext()) {
							flowSegment = (EndToEndFlowSegment) it.next();
							aadlText.addOutputNewline(" -> "
									+ AadlUtil.getFlowSegmentName(flowSegment));
						}
					}
				}
				processCurlyList(object.getOwnedPropertyAssociations());
				processModalElement(object);
				aadlText.decrementIndent();
				aadlText.addOutputNewline(";");
				return DONE;
			}

			public String casePropertySet(PropertySet object) {
					processComments(object);
					aadlText.addOutputNewline("property set "
							+ object.getName() + " is");
					aadlText.incrementIndent();
					processEList(object.getOwnedMembers());
					aadlText.decrementIndent();
					aadlText.addOutputNewline("end " + object.getName() + ";");
				return DONE;
			}


			public String caseAadlBoolean(AadlBoolean object) {
				processComments(object);
				if (object.getName() != null)
					aadlText.addOutput(object.getName() + ": type ");
				aadlText.addOutput("aadlboolean ");
				if (object.getName() != null)
					aadlText.addOutputNewline(";");
				return DONE;
			}

			public String caseAadlString(AadlString object) {
				processComments(object);
				if (object.getName() != null)
					aadlText.addOutput(object.getName() + ": type ");
				aadlText.addOutput("aadlstring ");
				if (object.getName() != null)
					aadlText.addOutputNewline(";");
				return DONE;
			}

			public String caseAadlInteger(AadlInteger object) {
				processComments(object);
				boolean isDecl = false;
				if (object.getName() != null && object.getName().length() > 0){
					aadlText.addOutput(object.getName() + ": type ");
					isDecl = true;
				}
				aadlText.addOutput("aadlinteger ");
				if (object.getRange() != null) {
					process(object.getRange());
				}
				if (object.getUnitsType() != null){
					aadlText.addOutput(" units ");
					processRef(object.getUnitsType());
				}
				if (isDecl)
					aadlText.addOutputNewline(";");
				return DONE;
			}

			public String caseAadlReal(AadlReal object) {
				processComments(object);
				boolean isDecl = false;
				if (object.getName() != null && object.getName().length() > 0){
					aadlText.addOutput(object.getName() + ": type ");
					isDecl = true;
				}
				aadlText.addOutput("aadlreal ");
				if (object.getRange() != null) {
					process(object.getRange());
				}
				if (object.getUnitsType() != null)
					processRef(object.getUnitsType());
				if (isDecl)
					aadlText.addOutputNewline(";");
				return DONE;
			}

			public String caseEnumerationType(EnumerationType object) {
				processComments(object);
				boolean isDecl = false;
				if (object.getName() != null && object.getName().length() > 0){
					aadlText.addOutput(object.getName() + ": type ");
					isDecl = true;
				}
				aadlText.addOutput(" enumeration (");
				processEList(object.getOwnedLiterals(), ", ");
				aadlText.addOutput(")");
				if (isDecl)
					aadlText.addOutputNewline(";");
				return DONE;
			}

			public String caseUnitsType(UnitsType object) {
				processComments(object);
				boolean isDecl = false;
				if (object.getName() != null && object.getName().length() > 0){
					aadlText.addOutput(object.getName() + ": type ");
					isDecl = true;
				}
				aadlText.addOutput(" units (");
				processEList(object.getOwnedLiterals(), ", ");
				aadlText.addOutput(")");
				if (isDecl)
					aadlText.addOutputNewline(";");
				return DONE;
			}

			public String caseEnumerationLiteral(EnumerationLiteral object) {
				aadlText.addOutput(object.getName());
				return DONE;
			}

			public String caseUnitLiteral(UnitLiteral object) {
				aadlText.addOutput(object.getName());
				if (object.getBaseUnit() != null && object.getFactor() != null) {
					aadlText.addOutput(" => " + object.getBaseUnit().getName()
							+ " * " + getNumberValueAsString(object.getFactor()));
				}
				return DONE;
			}

			public String caseReferenceType(ReferenceType object) {
				processComments(object);
				boolean isDecl = false;
				if (object.getName() != null && object.getName().length() > 0){
					aadlText.addOutput(object.getName() + ": type ");
					isDecl = true;
				}
				aadlText.addOutput(" reference");
				EList<MetaclassReference> catlist = object.getNamedElementReferences();
				if (catlist.size() > 0) {
					aadlText.addOutput("(");
					processEList(catlist, ", ");
					aadlText.addOutput(")");
				}
				if (isDecl)
					aadlText.addOutputNewline(";");
				return DONE;
			}

			public String caseReferenceValue(ReferenceValue object) {
				aadlText.addOutput("reference(");
				processEList(object.getContainmentPathElements(),".");
				aadlText.addOutput(")");
				return DONE;
			}

			public String caseClassifierType(ClassifierType object) {
				processComments(object);
				boolean isDecl = false;
				if (object.getName() != null && object.getName().length() > 0){
					aadlText.addOutput(object.getName() + ": type ");
					isDecl = true;
				}
				aadlText.addOutput(" classifier");
				EList<MetaclassReference> catlist = object.getClassifierReferences();
				if (catlist.size() > 0) {
					aadlText.addOutput("(");
					processEList(catlist, ", ");
					aadlText.addOutput(")");
				}
				if (isDecl)
					aadlText.addOutputNewline(";");
				return DONE;
			}

			public String caseClassifierValue(ClassifierValue object) {
						aadlText.addOutput("classifier("+AadlUtil.getClassifierName(object.getClassifier(),object)+")");
				return DONE;
			}

			public String caseMetaclassReference(MetaclassReference object) {
				processEList(object.getMetaclassNames(), " ");
				return DONE;
			}

			public String caseModalPropertyValue(ModalPropertyValue object) {
				process(object.getOwnedValue());
				processModalElement(object);
				return DONE;
			}

			public String casePropertyAssociation(PropertyAssociation object) {
				processComments(object);
				aadlText.addOutput(AadlUtil.getPropertySetElementName(object.getProperty()));
				aadlText.addOutput(object.isAppend() ? " +=> " : " => ");
				final EList<ModalPropertyValue> pl = object.getOwnedValues();
//				boolean didParens = false;
//				if (pl.size() > 1 || (pl.size()==1 && !((ModalPropertyValue)pl.get(0)).getInModes().isEmpty())){
//					aadlText.addOutput("(");
//					didParens = true;
//				}
				processEList(pl, ", ");
//				if (didParens)
//					aadlText.addOutput(")");
				EList<ContainedNamedElement> atl = object.getAppliesTos();

				if (atl.size() > 0) {
					aadlText.addOutput(" applies to ");
					processEList(atl, ".");
				}
				// processInBinding(object);
				EList<Classifier> ibl = object.getInBindings();
				if (ibl.size() > 0) {
					aadlText.addOutput(" in binding (");
					processRefEList(ibl, ",",object);
					aadlText.addOutput(")");
				}
				aadlText.addOutputNewline(";");
				return DONE;
			}
			
			public String caseContainedNamedElement(ContainedNamedElement object){
				processEList(object.getContainmentPathElements(),".");
				return DONE;
			}
			
			public String caseContainmentPathElement(ContainmentPathElement object){
				aadlText.addOutput(object.getNamedElement().getName()); 
				if (!object.getArrayRanges().isEmpty()){
					processEList(object.getArrayRanges()," ");
				}
				return DONE;
			}


			public String casePropertyConstant(PropertyConstant object) {
				processComments(object);
				aadlText.addOutput(object.getName() + ": constant ");
				if (object.getPropertyType() != null)
					processRef(object.getPropertyType());
				PropertyExpression pe = object.getConstantValue();
				if (pe != null) {
					aadlText.addOutput(" => ");
					process(pe);
				}
				aadlText.addOutputNewline(";");
				return DONE;
			}

			public String caseProperty(Property object) {
				processComments(object);
				aadlText.addOutput(object.getName() + ": ");
				if (object.isInherit())
					aadlText.addOutput("inherit ");
				if (object.getPropertyType() != null)
					processRef(object.getPropertyType());
				PropertyExpression pe = object.getDefaultValue();
				if (pe != null) {
					aadlText.addOutput(" => ");
					process(pe);
				}
				aadlText.addOutput(" applies to (");
				processEList(object.getAppliesTos(),",");
				aadlText.addOutputNewline(");");
				return DONE;
			}
			

			public String caseBasicProperty(BasicProperty object) {
				processComments(object);
				aadlText.addOutput(object.getName() + ": ");
				if (object.getPropertyType() != null)
					processRef(object.getPropertyType());
				aadlText.addOutputNewline(";");
				return DONE;
			}

			
			public String caseListType(ListType object){
				aadlText.addOutput("list of ");
				process(object.getElementType());
				return DONE;
			}
			
			public String caseListValue(ListValue object){
				aadlText.addOutput("(");
				processEList(object.getOwnedListElements(),", ");
				aadlText.addOutput(")");
				return DONE;
			}

			public String caseOperation(Operation object) {
				EList<PropertyExpression> el = object.getOwnedPropertyExpressions();
				OperationKind ok = object.getOp();
				boolean doparens = false;
				if (object.getOwner() instanceof Operation){
					if (((Operation)object.getOwner()).getOp() != OperationKind.OR){
						aadlText.addOutput("(");
						doparens = true;}
				}
				if (ok == OperationKind.NOT){
					aadlText.addOutput("not ");
					process(el.get(0));
				} else {
					processEList(el, " "+ok.getName()+" " );
				}
				if (doparens){
					aadlText.addOutput(")");
				}
				return DONE;
			}

			public String caseBooleanLiteral(BooleanLiteral object) {
				aadlText.addOutput(object.getValue()?"true":"false");
				return DONE;
			}

			public String caseStringLiteral(StringLiteral object) {
				String s = object.getValue();
				if (s.startsWith("\"") && s.endsWith("\"")) {
					aadlText.addOutput(s);
				} else {
					aadlText.addOutput("\"" + s + "\"");
				}
				return DONE;
			}

			public String caseNumberValue(NumberValue object) {
					aadlText.addOutput(getNumberValueAsString(object));
					UnitLiteral us = object.getUnit();
					if (us != null )
						aadlText.addOutput(" " + us.getName());
				return DONE;
			}

			public String caseNamedValue(NamedValue object) {
				AbstractNamedValue anv = object.getNamedValue();
				if (anv instanceof EnumerationLiteral){
					aadlText.addOutput(((EnumerationLiteral) anv).getName());
				} else {
					processRef((NamedElement)anv);
				}
				return DONE;
			}

			public String caseRangeType(RangeType object) {
				if (object.getName() != null && object.getName().length() > 0)
					aadlText.addOutput(object.getName() + ": type");
				aadlText.addOutput(" range of ");
				if (object.getNumberType() != null)
					processRef(object.getNumberType());
				if (object.getName() != null)
					aadlText.addOutputNewline(";");
				return DONE;
			}

			public String caseRangeValue(RangeValue object) {
				PropertyExpression min = object.getMinimum();
				PropertyExpression max = object.getMaximum();
				PropertyExpression delta = object.getDelta();
				if (min != null) {
					process(min);
				} else {
					aadlText.addOutput("-- ** no minimum value **");
				}
				aadlText.addOutput(" .. ");
				if (max != null) {
					process(max);
				} else {
					aadlText.addOutput("-- ** no maximum value **");
				}
				if (delta != null) {
					aadlText.addOutput(" delta ");
					process(delta);
				}
				return DONE;
			}

			public String caseArrayRange(ArrayRange object) {
				if (object == null) return DONE;
				aadlText.addOutput("["+Long.toString(object.getLowerBound()));
				long ub = object.getUpperBound();
				if (ub != 0L) {
					aadlText.addOutput(" .. "+Long.toString(ub));
				}
				aadlText.addOutput("]");
				return DONE;
			}

			public String caseNumericRange(NumericRange object) {
				if (object == null) return DONE;
				PropertyExpression min = object.getLowerBound();
				PropertyExpression max = object.getUpperBound();
				if (min != null) {
					process(min);
				} else {
					aadlText.addOutput("-- ** no minimum value **");
				}
				aadlText.addOutput(" .. ");
				if (max != null) {
					process(max);
				} else {
					aadlText.addOutput("-- ** no maximum value **");
				}
				return DONE;
			}
			

			public String caseRecordType(RecordType object) {
				if (object.getName() != null && object.getName().length() > 0)
					aadlText.addOutput(object.getName() + ": type");
				aadlText.addOutputNewline(" record (");
				processEList(object.getOwnedFields());
				aadlText.addOutput(")");
				if (object.getName() != null)
					aadlText.addOutputNewline(";");
				return DONE;
			}
			
			public String caseRecordValue(RecordValue object) {
				aadlText.incrementIndent();
				aadlText.addOutputNewline("[");
				processEList(object.getOwnedFieldValues());
				aadlText.decrementIndent();
				aadlText.addOutput("]");
				return DONE;
			}
			
			public String caseBasicPropertyAssociation(BasicPropertyAssociation object) {
				aadlText.addOutput(object.getProperty().getName() + "=> ");
				process(object.getOwnedValue());
				aadlText.addOutputNewline(";");
				return DONE;
			}

		};

	}

	/**
	 * Set the model name as the name of the object and unparse the (sub)-model
	 * 
	 * @param obj
	 *            Element
	 */
	private void unparse(Element obj) {
		process(obj);
	}
	
	private void processRef(NamedElement propref){
		if (propref.getName() != null){
			aadlText.addOutput(AadlUtil.getPropertySetElementName(propref));
		} else {
			process(propref);
		}
	}

	/**
	 * returns the unparsed output as a single String
	 * 
	 * @return String
	 */
	public String getOutput() {
		return aadlText.getParseOutput();
	}


	/**
	 * Does processing of list with separators and parens if not empty
	 * 
	 * @param list
	 * @param separator
	 */
	public void processOptionalEList(EList list, String separator) {
		if (list.size() > 0) {
			aadlText.addOutput("(");
			processEList(list, ",");
			aadlText.addOutput(")");
		}
	}
	
	/**
	 * Does processing of list with separators
	 * 
	 * @param list
	 * @param separator
	 */
	public void processEList(EList list, String separator) {
		boolean first = true;
		for (Iterator it = list.iterator(); it.hasNext();) {
			if (!first) {
				if (separator == AadlConstants.newlineChar) {
					aadlText.addOutputNewline(AadlConstants.emptyString);
				} else {
					aadlText.addOutput(separator);
				}
			}
			first = false;
			Object o = it.next();
			if (o instanceof Element)
				process((Element) o);
			else if (o instanceof AbstractEnumerator)
				aadlText.addOutput(((AbstractEnumerator) o).getName()
						.toLowerCase());
			else if (o instanceof String)
				aadlText.addOutput((String)o);
			else
				aadlText.addOutput("processEList: oh my, oh my!!");
		}
	}

	
	/**
	 * Does processing of list with separators
	 * 
	 * @param list
	 * @param separator
	 */
	public void processRefEList(EList list, String separator, Element context) {
		boolean first = true;
		for (Iterator it = list.iterator(); it.hasNext();) {
			if (!first) {
				if (separator == AadlConstants.newlineChar) {
					aadlText.addOutputNewline(AadlConstants.emptyString);
				} else {
					aadlText.addOutput(separator);
				}
			}
			first = false;
			Object obj = it.next();
			if (obj instanceof Classifier){
				aadlText.addOutput(AadlUtil.getClassifierName((Classifier)obj, context));
			} else if (obj instanceof NamedElement) {
				aadlText.addOutput(((NamedElement)obj).getName());

			}
		}
	}

	/**
	 * unparse curly (property) list
	 */
	public void processCurlyList(EList<PropertyAssociation> list) {
		// process property associations
		if (list == null || list.isEmpty() )
			return;
		if (list != null && !list.isEmpty()) {
			aadlText.addOutputNewline(" {");
			aadlText.incrementIndent();
			processEList(list);
			aadlText.addOutput("}");
			aadlText.decrementIndent();
		}
	}

	private void processComments(final Element obj) {
		if (obj != null) {
			EList<Comment> el = obj.getOwnedComments();
			if (!el.isEmpty()){
				for (Comment comment : el) {
					String str = comment.getBody();
					if (!str.startsWith("--") ) {
						str = "--" +(str.startsWith(" ") ? "" : " ") + str;
					}
					aadlText.addOutputNewline(str);
				}
			} else {
				// see if there are comments in the parse tree
				processComment(obj);
			}
		}
	}

	/**
	 * unparse modes of ModalElement 
	 * 
	 * @param mm
	 *            modal element
	 */
	public void processModalElement(ModalElement mm) {
		EList<Mode> list = mm.getAllInModes();
		if (!list.isEmpty()) {
			aadlText.addOutput(" in modes (");
			processEList(list, ",");
			aadlText.addOutput(")");
		}
	}
	
	/**
	 * unparse modes of ModalElement 
	 * 
	 * @param mm
	 *            modal element
	 */
	public void processModalPath(ModalPath mm) {
		EList<ModeFeature> list = mm.getInModeOrTransitions();
		if (!list.isEmpty()) {
			aadlText.addOutput(" in modes (");
			processEList(list, ",");
			aadlText.addOutput(")");
		}
	}

	/**
	 * Does processing of list as optional section without separators
	 * 
	 * @param list
	 *            to be processed
	 * @param sectionName
	 *            section
	 * @param emptyOption
	 *            shown with section name if empty list
	 */
	public void processOptionalSection(EList list, String sectionName,
			String emptyOption) {
		if (list == null)
			return;
		if (!list.isEmpty()) {
			aadlText.addOutputNewline(sectionName);
			aadlText.incrementIndent();
			processEList(list);
			aadlText.decrementIndent();
		} else if (emptyOption != null && emptyOption.length() > 0) {
			aadlText.addOutputNewline(sectionName + " " + emptyOption);
		}
	}

	/**
	 * Does processing of list as section without separators
	 * 
	 * @param list
	 *            to be processed
	 * @param sectionName
	 *            section
	 * @param emptyOption
	 *            shown with section name if empty list
	 */
	public void processSection(EList list, String sectionName,
			Boolean doNone) {
		if (list == null)
			return;
		if (!list.isEmpty()) {
			aadlText.addOutputNewline(sectionName);
			aadlText.incrementIndent();
			processEList(list);
			aadlText.decrementIndent();
		} else if (doNone) {
			aadlText.addOutputNewline(sectionName+" " + NONESTMT);
		}
	}

	public boolean hasDeclaredFeatures(EList ftl) {
		for (Iterator it = ftl.iterator(); it.hasNext();) {
			Feature f = (Feature) it.next();
			String n = f.getName();
			if (!(n.equalsIgnoreCase("error") || n.equalsIgnoreCase("dispatch") || n
					.equalsIgnoreCase("complete"))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Unparses the aadl spec and returns it as string
	 * 
	 * @param as
	 *            AadlSpec or any other Element in the Aadl grammar
	 */
	public String doUnparse(Element as) {
		this.unparse(as);
		return this.getOutput();
	}

	
	private String getNumberValueAsString(NumberValue nv){
		if (nv instanceof IntegerLiteral){
			return Long.toString(((IntegerLiteral)nv).getValue());
		} else {
			return Double.toString(((RealLiteral)nv).getValue());
		}
	}


	public void doUnparseToFile(IResource aaxlFile) {
		IPath path = aaxlFile.getFullPath();
		IPath txtpath = path.removeFileExtension().addFileExtension("aadl");
		Resource res = OsateResourceUtil.getResource(aaxlFile);
		EList<EObject> rl = res.getContents();
		doUnparseToFile((Element)rl.get(0), txtpath);
	}

	/**
	 * unparse the AADL model into the specified file. The model must be a
	 * declarative model.
	 * 
	 * @param obj
	 *            Element. If it is an Instance object nothing is unparsed.
	 * @param path
	 *            The file path to unparse to.
	 */
	public IFile doUnparseToFile(Element obj, IPath path) {
		aadlText = new UnparseText();
		Element root = obj.getElementRoot();
		if (root instanceof InstanceObject) {
			return null;
		}

		String s = this.doUnparse(root);
		if (path != null) {
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			if (file != null) {
				final InputStream input = new ByteArrayInputStream(s.getBytes());
				try {
					if (file.exists()) {
						file.setContents(input, true, true, null);
					} else {
						AadlUtil.makeSureFoldersExist(path);
						file.create(input, true, null);
					}
					file.deleteMarkers(null, true, IResource.DEPTH_INFINITE);
				} catch (final CoreException e) {
				}
			}
			return file;
		}
		return null;
	}


	/**
	 * Used to unparse to files outside the scope of Eclipse.
	 */
	public void doUnparseToExternalFile(Element obj, File file) {
		Element root = obj.getElementRoot();
		if (root instanceof InstanceObject)
			return;

		String s = doUnparse(root);
		if (file != null) {
			try {
				FileOutputStream os = new FileOutputStream(file);
				os.write(s.getBytes());
				os.flush();
				os.close();
			} catch (Exception e) {
			}
		}
	}
	
	public void doUnparseToFile(Element obj) {
		IResource aaxlFile = OsateResourceUtil.convertToIResource(obj
				.eResource());
		IPath path = AadlWorkspace.getAadlWorkspace().getAadlProject(aaxlFile)
				.getAadlPath((IFile) aaxlFile);
		doUnparseToFile(obj, path);
	}

	public void doUnparseToFile(Resource res) {
		IResource aaxlFile = OsateResourceUtil.convertToIResource(res);
		IPath path = AadlWorkspace.getAadlWorkspace().getAadlProject(aaxlFile)
				.getAadlPath((IFile) aaxlFile);
		doUnparseToFile((Element)res.getContents().get(0), path);
	}
	
	public void processComment(EObject o){
		INode node = NodeModelUtils.findActualNodeFor(o);
		INode n2 = NodeModelUtils.getNode(o);
		if (n2 == null) return;
		BidiTreeIterator<INode> ti = n2.getAsTreeIterable().iterator();
		while (ti.hasNext()) {
			INode next = ti.next();
			if (next instanceof CompositeNode && next != n2) return;
			if (isCommentNode(next)){
				String str = next.getText();
				if (!str.startsWith("--") ) {
					str = "--" +(str.startsWith(" ") ? "" : " ") + str;
				}
				if (str.endsWith("\r\n")){
					str = str.substring(0,str.length()-2);
				}
				aadlText.addOutputNewline(str);
			}
		}
	}
	
	public boolean isCommentNode(INode node) {
		if (node instanceof ILeafNode && ((ILeafNode) node).isHidden()
				&& node.getGrammarElement() instanceof AbstractRule)
			return isComment((AbstractRule) node.getGrammarElement());
		return false;
	}

	public boolean isComment(AbstractRule rule) {
		return rule != null && ("ML_COMMENT".equals(rule.getName()) || "SL_COMMENT".equals(rule.getName()));
	}

}
