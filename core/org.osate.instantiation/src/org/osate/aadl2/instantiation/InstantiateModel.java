/*
 * Created on Jan 30, 2004
 *
 * <copyright>
 * Copyright  2004 by Carnegie Mellon University, all rights reserved.
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
 * $Id: InstantiateModel.java,v 1.190 2010-05-12 20:09:29 lwrage Exp $
 *
 */
package org.osate.aadl2.instantiation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalCommandStack;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.osate.aadl2.AccessCategory;
import org.osate.aadl2.AccessSpecification;
import org.osate.aadl2.ArrayDimension;
import org.osate.aadl2.ArraySize;
import org.osate.aadl2.ArraySizeProperty;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Context;
import org.osate.aadl2.DirectedFeature;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupPrototype;
import org.osate.aadl2.FeatureGroupPrototypeActual;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.FeaturePrototype;
import org.osate.aadl2.FeaturePrototypeActual;
import org.osate.aadl2.FeatureType;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.ModeTransitionTrigger;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PortCategory;
import org.osate.aadl2.PortSpecification;
import org.osate.aadl2.ProcessSubcomponent;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.SystemSubcomponent;
import org.osate.aadl2.ThreadGroupSubcomponent;
import org.osate.aadl2.TriggerPort;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceFactory;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.ModeTransitionInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.ForAllElement;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.properties.InstanceUtil;
import org.osate.aadl2.properties.InstanceUtil.InstantiatedClassifier;
import org.osate.aadl2.util.Aadl2ResourceImpl;
import org.osate.workspace.WorkspacePlugin;

/**
 * This class implements the instantiation of models from a root system impl.
 * The class also contains a switch for performing checks on semantic
 * constraints that must be satisfied for certain analyes on instance models.
 * Although there is a method that invokes these checks, it is best for each
 * analysis method to invoke those checks that are relevant for its processing.
 * 
 * @author phf
 */
public class InstantiateModel {
	/* The name for the single mode of a non-modal system */
	public static final String NORMAL_SOM_NAME = "No Modes";

	private final AnalysisErrorReporterManager errManager;
	private final IProgressMonitor monitor;

	/**
	 * A classifier for an instance object when it is a prototype in the
	 * declarative model. The classifier is the result of resolving the
	 * prototype. It's either the classifier that is instantiated as a
	 * subcomponent or feature group instance or the classifier referenced by a
	 * feature or subprogram call. If the classifier is anonymous, then its
	 * bindings are included also.
	 */
	private HashMap<InstanceObject, InstantiatedClassifier> classifierCache;

	/**
	 * Maps mode instances to SOMs that contain this mode instance
	 */
	private HashMap<ModeInstance, List<SystemOperationMode>> mode2som;

	/*
	 * Processing switch that gathers up all the component instances that have
	 * modes.
	 */
	private static final class ModeSearch extends ForAllElement {
		public boolean hasModalComponents = false;

		protected void action(final Element o) {
			final List<ModeInstance> modes = ((ComponentInstance) o).getModeInstances();
			if (modes != null && !modes.isEmpty()) {
				hasModalComponents = true;
			}
			resultList.add(o);
		}
	}

	// Constructors

	/*
	 * Create an instantiate object. Tracks who to report errors to - the
	 * resource that contains si. It also holds on to the property definition
	 * filter to be used for caching properties in the instance model
	 * 
	 * @param pm
	 * 
	 * @param errMgr
	 */
	public InstantiateModel(final IProgressMonitor pm, final AnalysisErrorReporterManager errMgr) {
		classifierCache = new HashMap<InstanceObject, InstantiatedClassifier>();
		mode2som = new HashMap<ModeInstance, List<SystemOperationMode>>();
		errManager = errMgr;
		monitor = pm;
	}

	// Methods

	@SuppressWarnings("unchecked")
	public SystemInstance createSystemInstance(final SystemImplementation si, final Resource aadlResource) {
		final TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.osate.aadl2.ModelEditingDomain");
		// We execute this command on the command stack because otherwise, we will not
		//  have write permissions on the editing domain.
		Command cmd = new RecordingCommand(domain) {
			public SystemInstance instance;

			protected void doExecute() {
				instance = createSystemInstanceInt(si, aadlResource);
			}

			public List<SystemInstance> getResult() {
				return Collections.singletonList(instance);
			}
		};

		try {
			((TransactionalCommandStack) domain.getCommandStack()).execute(cmd, null);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ((List<SystemInstance>) cmd.getResult()).get(0);
	}

	/*
	 * instantiate SystemImpl as root of instance tree
	 * 
	 * @param si SystemImpl the root of the system instance
	 * 
	 * @param aadlResource the Resource to store the instance model in
	 * 
	 * @return SystemInstance or <code>null</code> if canceled.
	 */
	public SystemInstance createSystemInstanceInt(SystemImplementation si, Resource aadlResource) {
		SystemInstance root = InstanceFactory.eINSTANCE.createSystemInstance();
		final String instanceName = si.getTypeName() + "_" + si.getImplementationName() 
				+ WorkspacePlugin.INSTANCE_MODEL_POSTFIX;

		root.setSystemImplementation(si);
		root.setName(instanceName);
		root.setCategory(ComponentCategory.SYSTEM);
		aadlResource.getContents().add(root);
		// Needed to save the root object because we may attach warnings to the
		// IResource as we build it.
		try {
			aadlResource.save(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		createXSystemInstance(root);
		// We're done: Save the model.
		// We don't respond to a cancel at this point

		monitor.subTask("Saving instance model");

		try {
			aadlResource.save(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return root;
	}

	/** 
	 * Will create instance model under systeminstance but not save it
	 * @param root
	 */
	public void createXSystemInstance(SystemInstance root) {
		this.populateComponentInstance(root, 0);
		if (monitor.isCanceled()) {
			return;
		}

		monitor.subTask("Creating system operation modes");
		this.createSystemOperationModes(root);
		if (monitor.isCanceled()) {
			return;
		}

		new CreateConnectionsSwitch(monitor, errManager, classifierCache).processPreOrderAll(root);
		if (monitor.isCanceled()) {
			return;
		}

		new CreateEndToEndFlowsSwitch(monitor, errManager, classifierCache).processPreOrderAll(root);
		if (monitor.isCanceled()) {
			return;
		}

		/*
		 * XXX: Currently, there are no annexes that use instantiation. If a
		 * case is found, then this code needs to be moved elsewhere, such as
		 * the UI action code that calls the regular instantiator. If this code
		 * were to be left here, it would case a circular plugin dependency. The
		 * annex plugin currently depends on the instance plugin because
		 * AnnexInstantiationController needs to use InstanceUtil. Uncommenting
		 * this code and leaving it in place would cause the instance plugin to
		 * depend on the annex plugin.
		 */
//		// instantiation of annexes
//		monitor.subTask("Instantiating annexes");
//		AnnexInstantiationController aic = new AnnexInstantiationController();
//		aic.instantiateAllAnnexes(root);
//		if (monitor.isCanceled()) {
//			return null;
//		}

		/*
		 * We now cache the property associations. First we cache the contained
		 * property associations. In a second pass we cache regular property
		 * associations and evaluate all properties.
		 */
		// we could also use getAllPropertyDefinition(as), which returns all declared property definitions
		// retrieving that set is faster, but it may contain property definitions that are not used;
		// this in that case the caching of those properties would be slower
		EList<Property> propertyDefinitionList = AadlUtil.getAllUsedPropertyDefinition(root.getSystemImplementation());
		CacheContainedPropertyAssociationsSwitch ccpas = new CacheContainedPropertyAssociationsSwitch(classifierCache,
				monitor, errManager);
		ccpas.processPostOrderAll(root);
		if (monitor.isCanceled()) {
			return;
		}

		final CachePropertyAssociationsSwitch cpas = new CachePropertyAssociationsSwitch(monitor, errManager, root,
				propertyDefinitionList, classifierCache, mode2som);
		cpas.processPreOrderAll(root);
		if (monitor.isCanceled()) {
			return;
		}

//		OsateResourceManager.save(aadlResource);
//		OsateResourceManager.getResourceSet().setPropagateNameChange(oldProp);
		// Run some checks over the model.
//		final SOMIterator soms = new SOMIterator(root);
//		while (soms.hasNext()) {
//			final SystemOperationMode som = soms.nextSOM();
//			monitor.subTask("Checking model semantics for mode " + som.getName());
//			final CheckInstanceSemanticsSwitch semanticsSwitch = new CheckInstanceSemanticsSwitch(som, soms
//					.getSOMasModeBindings(), cpas.getSemanticConnectionProperties(), errManager);
//			semanticsSwitch.processPostOrderAll(root);
//		}
		return;
	}

	// --------------------------------------------------------------------------------------------
	// Methods for instantiating the component hierarchy
	// --------------------------------------------------------------------------------------------

	/*
	 * Fill in modes, transitions, subcomponent instances, features, flow specs.
	 */
	protected void populateComponentInstance(ComponentInstance ci, int index) {
		ComponentImplementation impl = InstanceUtil.getComponentImplementation(ci, 0, classifierCache);
		ComponentType type = InstanceUtil.getComponentType(ci, 0, classifierCache);
		if (ci.getContainingComponentInstance() instanceof SystemInstance)
			monitor.subTask("Creating instances in " + ci.getName());

		/*
		 * add modes & transitions. Must do this before adding subcomponents
		 * because we need to know what are the ModeInstances when processing
		 * modal subcomponents.
		 */
		if (impl != null) {
			EList<Mode> modes = impl.getAllModes();
			for (Iterator<Mode> it = modes.iterator(); it.hasNext();) {
				Mode m = it.next();
				ModeInstance mi = InstanceFactory.eINSTANCE.createModeInstance();
				mi.setMode(m);
				mi.setName(m.getName());
				mi.setInitial(m.isInitial());
				ci.getModeInstances().add(mi);
			}
			EList<ModeTransition> modetrans = impl.getAllModeTransitions();
			for (Iterator<ModeTransition> it = modetrans.iterator(); it.hasNext();) {
				ModeTransition m = it.next();
				ModeTransitionInstance mti = InstanceFactory.eINSTANCE.createModeTransitionInstance();
				Mode srcmode = m.getSource();
				Mode dstmode = m.getDestination();
				ModeInstance srcI = ci.findModeInstance(srcmode);
				ModeInstance dstI = ci.findModeInstance(dstmode);
				mti.setSource(srcI);
				mti.setDestination(dstI);
				mti.setModeTransition(m);
				EList<ModeTransitionTrigger> triggers = m.getOwnedTriggers();
				String eventName = "";
				if (!triggers.isEmpty()) {
					if (triggers.get(0) instanceof TriggerPort) {
						Context o = ((TriggerPort) triggers.get(0)).getContext();
						if (o instanceof Subcomponent) {
							eventName = ((Subcomponent) o).getName() + ".";
						}
						eventName = eventName + ((TriggerPort) triggers.get(0)).getPort().getName();
					} else {
						eventName = ((NamedElement) triggers.get(0)).getName();
					}
				}
				mti.setName(srcmode.getName() + "." + (!eventName.equals("") ? eventName + "." : "")
						+ dstmode.getName());
				ci.getModeTransitionInstances().add(mti);
			}
			if (monitor.isCanceled()) {
				return;
			}

			// Recursively add subcomponents
			instantiateSubcomponents(ci, impl);

			// TODO now add subprogram calls
			// EList callseqlist = compimpl.getXAllCallSequence();
			// for (Iterator it = callseqlist.iterator(); it.hasNext();) {
			// CallSequence cseq = (CallSequence) it.next();
			//				
			// EList calllist = cseq.getCall();
			// for (Iterator iit = calllist.iterator(); iit.hasNext();) {
			// final SubprogramSubcomponent call =
			// (SubprogramSubcomponent) iit.next();
			// instantiateSubcomponent(ci, cseq, call);
			// }
			// }
		}

		// do it only if subcomponent has type
		if (type != null) {
			instantiateFeatures(ci);
			if (monitor.isCanceled()) {
				return;
			}
		}

		return;
	}

	/*
	 * @param ci
	 * 
	 * @param impl
	 */
	protected void instantiateSubcomponents(final ComponentInstance ci, ComponentImplementation impl) {
		for (final Subcomponent sub : impl.getAllSubcomponents()) {
			if (hasSubcomponentInstance(ci, sub)) {
				errManager.error(ci, "Cyclic containment dependency: Subcomponent '" + sub.getName()
						+ "' has already been instantiated as enclosing component.");
			} else {
				final EList<ArrayDimension> dims = sub.getArrayDimensions();

				if (dims.isEmpty()) {
					instantiateSubcomponent(ci, sub, sub, 0);
				} else {
					final int dimensions = dims.size();
					class ArrayInstantiator {
						void process(int dim) {
							ArraySize arraySize = dims.get(dim).getSize();
							long count = getElementCount(arraySize);

							for (long i = 0; i < count; i++) {
								if (dim + 1 < dimensions) {
									process(dim + 1);
								} else {
									instantiateSubcomponent(ci, sub, sub, 0);
								}
							}
						}
					}
					new ArrayInstantiator().process(0);
				}
			}
			if (monitor.isCanceled()) {
				return;
			}
		}
	}

	/*
	 * check to see if the specified subcomponent already exists as component
	 * instance in the ancestry
	 */
	private boolean hasSubcomponentInstance(ComponentInstance ci, Subcomponent sub) {
		ComponentInstance parent = ci;
		while (parent != null && !(parent instanceof SystemInstance)) {
			Subcomponent psc = parent.getSubcomponent();
			if (psc == sub)
				return true;
			parent = (ComponentInstance) parent.eContainer();
		}
		return false;
	}

	protected void instantiateSubcomponent(final ComponentInstance parent, final ModalElement mm,
			final Subcomponent sub, int index) {
		final ComponentInstance newInstance = InstanceFactory.eINSTANCE.createComponentInstance();
		final ComponentClassifier cc;
		final InstantiatedClassifier ic;

		newInstance.setSubcomponent(sub);
		newInstance.setName(sub.getName());
		newInstance.setCategory(sub.getCategory());
		parent.getComponentInstances().add(newInstance);

		ic = getInstantiatedClassifier(newInstance, 0);
		if (ic == null) {
			cc = null;
		} else {
			cc = (ComponentClassifier) ic.classifier;
		}
		if (cc == null) {
			errManager.warning(newInstance, "Instantiated subcomponent doesn't have a component classifier");
		} else if (cc instanceof ComponentType) {
			if (sub instanceof SystemSubcomponent || sub instanceof ProcessSubcomponent
					|| sub instanceof ThreadGroupSubcomponent) {
				errManager.warning(newInstance, "Instantiated subcomponent has a component type only");
			}
		}

		EList<Mode> inmodesList = mm.getAllInModes();
		if (!inmodesList.isEmpty()) {
			for (Iterator<Mode> it = inmodesList.iterator(); it.hasNext();) {
				final Mode mode = it.next();
				final ModeInstance mi = parent.findModeInstance(mode);
				if (mi != null)
					newInstance.getInModes().add(mi);
			}
		}
		populateComponentInstance(newInstance, index);
	}

	/*
	 * Add feature instances to component instance
	 */
	protected void instantiateFeatures(final ComponentInstance ci) {
		for (final Feature feature : getInstantiatedClassifier(ci, 0).classifier.getAllFeatures()) {
			final EList<ArrayDimension> dims = feature.getArrayDimensions();

			if (dims.isEmpty()) {
				final FeatureInstance fi = InstanceFactory.eINSTANCE.createFeatureInstance();

				// must add before prototype resolution in fillFeatureInstance
				ci.getFeatureInstances().add(fi);
				if (feature instanceof DirectedFeature) {
					fi.setDirection(((DirectedFeature) feature).getDirection());
				} else {
					fi.setDirection(DirectionType.IN_OUT);
				}
				fillFeatureInstance(feature, fi, false);
			} else {
				final int dimensions = dims.size();
				class ArrayInstantiator {
					void process(int dim) {
						ArraySize arraySize = dims.get(dim).getSize();
						long count = getElementCount(arraySize);

						for (long i = 0; i < count; i++) {
							if (dim + 1 < dimensions) {
								process(dim + 1);
							} else {
								final FeatureInstance fi = InstanceFactory.eINSTANCE.createFeatureInstance();

								// must add before prototype resolution in fillFeatureInstance
								ci.getFeatureInstances().add(fi);
								if (feature instanceof DirectedFeature) {
									fi.setDirection(((DirectedFeature) feature).getDirection());
								} else {
									fi.setDirection(DirectionType.IN_OUT);
								}
								fillFeatureInstance(feature, fi, false);
							}
						}
					}
				}
				new ArrayInstantiator().process(0);
			}
		}
	}

	protected void fillFeatureInstance(Feature feature, FeatureInstance fi, boolean inverse) {
		fi.setName(feature.getName());
		fi.setFeature(feature);
		// resolve feature prototype
		if (feature.getPrototype() instanceof FeaturePrototype) {
			FeaturePrototypeActual fpa = InstanceUtil.resolveFeaturePrototype(feature.getPrototype(), fi,
					classifierCache);

			if (fpa instanceof AccessSpecification) {
				AccessCategory ac = ((AccessSpecification) fpa).getCategory();

				switch (ac) {
				case BUS:
					fi.setCategory(FeatureCategory.BUS_ACCESS);
					break;
				case DATA:
					fi.setCategory(FeatureCategory.DATA_ACCESS);
					break;
				case SUBPROGRAM:
					fi.setCategory(FeatureCategory.SUBPROGRAM_ACCESS);
					break;
				case SUBPROGRAM_GROUP:
					fi.setCategory(FeatureCategory.SUBPROGRAM_GROUP_ACCESS);
					break;
				default:
					;
				}
			} else if (fpa instanceof PortSpecification) {
				PortCategory pc = ((PortSpecification) fpa).getCategory();

				switch (pc) {
				case DATA:
					fi.setCategory(FeatureCategory.DATA_PORT);
					break;
				case EVENT:
					fi.setCategory(FeatureCategory.EVENT_PORT);
					break;
				case EVENT_DATA:
					fi.setCategory(FeatureCategory.EVENT_DATA_PORT);
					break;
				default:
					;
				}
			}
		} else {
			fi.setCategory(feature);
		}

		// in case of feature groups we also create feature instances for
		// their contained features
		// We do this because the semantic connection may go to one of
		// them when we unfold feature group connections of ultimate sources
		// and destinations
		if (feature instanceof FeatureGroup) {
			expandFeatureGroupInstance(feature, fi, inverse);
		}
	}

	/*
	 * expand out feature instances for elements of a prort group
	 * 
	 * @param fi Feature Instance that is a port group
	 */
	protected void expandFeatureGroupInstance(Feature feature, FeatureInstance fi, boolean inverse) {
		if (feature instanceof FeatureGroup) {
			final FeatureGroup fg = (FeatureGroup) feature;
			FeatureType ft = ((FeatureGroup) feature).getFeatureType();

			inverse ^= fg.isInverse();

			while (ft instanceof FeatureGroupPrototype ) {
				FeatureGroupPrototype fgp = (FeatureGroupPrototype) ft;
				FeatureGroupPrototypeActual fgr = InstanceUtil.resolveFeatureGroupPrototype(fgp, fi, classifierCache);
				if (fgr != null) {
					ft = fgr.getFeatureType();
					if (ft == null) {
						errManager.error(fi, "Could not resolve feature group type of feature group prototype " + fi.getInstanceObjectPath());
						return;
					}
				} else {
					// prototype has not been bound yet
					errManager.warning(fi, "Feature group prototype  of " + fi.getInstanceObjectPath()+" is not bound yet to feature group type");
					return;
				}
			}
			FeatureGroupType fgt = (FeatureGroupType) ft;

			List<Feature> localFeatures = fgt.getOwnedFeatures();
			final FeatureGroupType inverseFgt = fgt.getInverse();
			final FeatureGroupType baseFgt;
			FeatureGroupType parentFgt;
			List<Feature> fgFeatures;

			if (localFeatures.isEmpty() && inverseFgt != null) {
				baseFgt = inverseFgt;
				localFeatures = inverseFgt.getOwnedFeatures();
				inverse = !inverse;
			} else {
				baseFgt = fgt;
			}
			parentFgt = baseFgt.getExtended();
			// feature group types cannot be extensions of inverse feature group types
			if (parentFgt != null) {
				fgFeatures = parentFgt.getAllFeatures();

				for (Feature f : localFeatures) {
					Feature rf = f.getRefined();
					if (rf != null && !fgFeatures.remove(rf)) {
						errManager.internalError("Inconsistent refines reference " + rf.getName());
					}
					fgFeatures.add(f);
				}
			} else {
				fgFeatures = localFeatures;
			}
			if (fgFeatures.isEmpty()) {
				errManager.warning(fi, "Feature group " + fi.getInstanceObjectPath() + " has no features");
				return;
			}
			for (Feature fgf : fgFeatures) {
				FeatureInstance fgfi = InstanceFactory.eINSTANCE.createFeatureInstance();

				fi.getFeatureInstances().add(fgfi);
				if (fgf instanceof DirectedFeature) {
					DirectionType dir = ((DirectedFeature) fgf).getDirection();

					if (inverse && dir != DirectionType.IN_OUT) {
						dir = (dir == DirectionType.IN) ? DirectionType.OUT : DirectionType.IN;
					}
					fgfi.setDirection(dir);
				} else {
					fi.setDirection(DirectionType.IN_OUT);
				}
				fillFeatureInstance(fgf, fgfi, inverse);
			}
		}
	}

	// --------------------------------------------------------------------------------------------
	// Methods related to prototype resolution
	// --------------------------------------------------------------------------------------------

	protected InstantiatedClassifier getInstantiatedClassifier(InstanceObject iobj, int index) {
		return InstanceUtil.getInstantiatedClassifier(iobj, index, classifierCache);
	}

	// --------------------------------------------------------------------------------------------
	// Methods related to arrays
	// --------------------------------------------------------------------------------------------

	private long getElementCount(ArraySize as) {
		long result = 0L;
		if (as == null) {
			return result;
		}
		if (as.getSizeProperty() == null) {
			result = as.getSize();
		} else {
			ArraySizeProperty asp = as.getSizeProperty();
			if (asp instanceof PropertyConstant) {
				PropertyConstant pc = (PropertyConstant) asp;
				PropertyExpression cv = pc.getConstantValue();
				if (cv instanceof IntegerLiteral) {
					result = ((IntegerLiteral) cv).getValue();
				}
			}
		}
		return result;
	}

	// --------------------------------------------------------------------------------------------
	// Methods related to system operation modes
	// --------------------------------------------------------------------------------------------

	/*
	 * Create the system operation mode objects for the instance model.
	 */
	protected void createSystemOperationModes(SystemInstance root) {
		/*
		 * Get an prefix list of all the components in the system. This way we
		 * can easily test if the component exists in the SOM being built.
		 */
		final ModeSearch modeSearch = new ModeSearch();
		final List<Element> allInstances = modeSearch.processPreOrderComponentInstance(root);
		if (modeSearch.hasModalComponents) {
			final ComponentInstance[] instances = (ComponentInstance[]) allInstances.toArray(new ComponentInstance[0]);
			enumerateSystemOperationModes(root, instances);
		} else {
			/*
			 * We have no modal elements, but we need to create a special SOM to
			 * represent our single normal operating state.
			 */
			final SystemOperationMode som = InstanceFactory.eINSTANCE.createSystemOperationMode();
			som.setName(NORMAL_SOM_NAME);
			root.getSystemOperationModes().add(som);
		}
	}

	/*
	 * Recursively enumerate all the system operation modes given an array of
	 * component instances that are modal. The system operation mode objects are
	 * created and added to the given system instance object.
	 * 
	 * @param root The system instance object to which the SOMs are attached.
	 * 
	 * @param instances An array of component instances that should be all the
	 * modal components in <code>root</code>.
	 * 
	 * @param currentInstance The index of the component instance in
	 * <code>instances</code> that is to have its modes enumerated
	 * 
	 * @param modeState A list used as a dynamic workspace by the method. Should
	 * initially be empty. When <code>currentInstance</code> equals the lenght
	 * of <code>instances</code>, this list holds the modal instances that
	 * should be turned into a System Operation Mode object.
	 */
	protected void enumerateSystemOperationModes(final SystemInstance root, final ComponentInstance[] instances) {
		final LinkedList<ComponentInstance> skipped = new LinkedList<ComponentInstance>();
		final LinkedList<ModeInstance> currentModes = new LinkedList<ModeInstance>();
		final EList<ModeInstance> modes = instances[0].getModeInstances();
		if (modes != null && modes.size() > 0) {
			for (final Iterator<ModeInstance> i = modes.iterator(); i.hasNext();) {
				currentModes.addLast(i.next());
				enumerateSystemOperationModes(root, instances, 1, skipped, currentModes);
				currentModes.removeLast();
			}
		} else {
			enumerateSystemOperationModes(root, instances, 1, skipped, currentModes);
		}
	}

	/*
	 * Recursively enumerate all the system operation modes given an array of
	 * component instances that are modal. The system operation mode objects are
	 * created and added to the given system instance object.
	 * 
	 * @param root The system instance object to which the SOMs are attached.
	 * 
	 * @param instances An array of component instances that should be all the
	 * modal components in <code>root</code>.
	 * 
	 * @param currentInstance The index of the component instance in
	 * <code>instances</code> that is to have its modes enumerated
	 * 
	 * @param modeState A list used as a dynamic workspace by the method. Should
	 * initially be empty. When <code>currentInstance</code> equals the lenght
	 * of <code>instances</code>, this list holds the modal instances that
	 * should be turned into a System Operation Mode object.
	 */
	protected void enumerateSystemOperationModes(final SystemInstance root, final ComponentInstance[] instances,
			final int currentInstance, final LinkedList<ComponentInstance> skipped,
			final LinkedList<ModeInstance> modeState) {
		if (currentInstance == instances.length) {
			// Completed an SOM
			root.getSystemOperationModes().add(createSOM(modeState));
		} else {
			/*
			 * First test if the current component exists given the currently
			 * selected modes. Component exists if it's parent is not skipped
			 * and component exists in the currently selected mode of its
			 * parent.
			 */
			final ComponentInstance ci = instances[currentInstance];
			if (!skipped.contains(ci.eContainer()) && existsGiven(modeState, ci.getInModes())) {
				final EList<ModeInstance> modes = ci.getModeInstances();
				if (modes != null && modes.size() > 0) {
					// Modal component
					for (final Iterator<ModeInstance> i = modes.iterator(); i.hasNext();) {
						modeState.addLast(i.next());
						enumerateSystemOperationModes(root, instances, currentInstance + 1, skipped, modeState);
						modeState.removeLast();
					}
				} else {
					// non-modal component
					enumerateSystemOperationModes(root, instances, currentInstance + 1, skipped, modeState);
				}
			} else {
				// Skip the current component, it doesn't exist under the
				// modeState
				skipped.addLast(ci);
				enumerateSystemOperationModes(root, instances, currentInstance + 1, skipped, modeState);
				skipped.removeLast();
			}
		}
	}

	private boolean existsGiven(final List<ModeInstance> modeState, final List<ModeInstance> inModes) {
		if (inModes != null && inModes.size() > 0) {
			for (final Iterator<ModeInstance> i = inModes.iterator(); i.hasNext();) {
				if (modeState.contains(i.next())) {
					return true;
				}
			}
			return false;
		} else {
			return true;
		}
	}

	/*
	 * Create a SystemOperationMode given a list of mode instances.
	 */
	private SystemOperationMode createSOM(final List<ModeInstance> modeInstances) {
		final SystemOperationMode som = InstanceFactory.eINSTANCE.createSystemOperationMode();
		for (ModeInstance mi : modeInstances) {
			List<SystemOperationMode> soms = mode2som.get(mi);
			if (soms == null) {
				soms = new ArrayList<SystemOperationMode>();
				mode2som.put(mi, soms);
			}
			soms.add(som);
			som.getCurrentModes().add(mi);
		}
		som.setName(som.toString());
		return som;
	}

}