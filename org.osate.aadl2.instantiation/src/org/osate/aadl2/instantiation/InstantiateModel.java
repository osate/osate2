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

import static org.osate.aadl2.modelsupport.util.AadlUtil.getElementCount;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalCommandStack;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.osate.aadl2.AccessCategory;
import org.osate.aadl2.AccessSpecification;
import org.osate.aadl2.ArrayDimension;
import org.osate.aadl2.ArraySize;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentPrototype;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Context;
import org.osate.aadl2.DirectedFeature;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.FeaturePrototype;
import org.osate.aadl2.FeaturePrototypeActual;
import org.osate.aadl2.FeatureType;
import org.osate.aadl2.FlowEnd;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeBinding;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.ModeTransitionTrigger;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.Port;
import org.osate.aadl2.PortCategory;
import org.osate.aadl2.PortSpecification;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.TriggerPort;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.instance.InstanceFactory;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.ModeTransitionInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.instance.util.InstanceUtil;
import org.osate.aadl2.instance.util.InstanceUtil.InstantiatedClassifier;
import org.osate.aadl2.modelsupport.AadlConstants;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.MarkerAnalysisErrorReporter;
import org.osate.aadl2.modelsupport.modeltraversal.ForAllElement;
import org.osate.aadl2.modelsupport.modeltraversal.TraverseWorkspace;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.util.Aadl2InstanceUtil;
import org.osate.aadl2.util.Aadl2Util;
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

	private SCProperties scProps = new SCProperties();
	/**
	 * Maps mode instances to SOMs that contain this mode instance
	 */
	private HashMap<ModeInstance, List<SystemOperationMode>> mode2som;

	/*
	 * An error message that is filled by potential methods that
	 * instantiate the system and raises an error. This message
	 * is then show in the error dialog when an instantiation error
	 * is raised.
	 */
	private static String errorMessage = null;

	/*
	 * To keep under control the error messages and ease
	 * debug, we encapsulate the error message string
	 * and access it only through methods (setters and getters).
	 */
	public static void setErrorMessage(String s) {
		errorMessage = s;
	}

	public static String getErrorMessage() {
		return errorMessage;
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
	public InstantiateModel(final IProgressMonitor pm) {
		classifierCache = new HashMap<InstanceObject, InstantiatedClassifier>();
		mode2som = new HashMap<ModeInstance, List<SystemOperationMode>>();
		errManager = new AnalysisErrorReporterManager(
				new MarkerAnalysisErrorReporter.Factory(AadlConstants.INSTANTIATION_OBJECT_MARKER));
		monitor = pm;
	}

	public InstantiateModel(final IProgressMonitor pm, final AnalysisErrorReporterManager errMgr) {
		classifierCache = new HashMap<InstanceObject, InstantiatedClassifier>();
		mode2som = new HashMap<ModeInstance, List<SystemOperationMode>>();
		errManager = errMgr;
		monitor = pm;
	}

	// Methods
	/*
	 * This method will construct an instance model, save it on disk and return
	 * its root object The method makes sure that the system implementation is
	 * in the OSATE resource set and will create the instance model there as
	 * well. The Osate resource set is the shared resource set maintained by
	 * OsateResourceUtil. THe operation is performed in a transactional editing
	 * domain
	 * 
	 * @param si system implementation
	 * 
	 * @return SystemInstance or <code>null</code> if cancelled.
	 */
	public static SystemInstance buildInstanceModelFile(final ComponentImplementation ci, IProgressMonitor monitor)
			throws Exception {
		// add it to a resource; otherwise we cannot attach error messages to
		// the instance file
		ComponentImplementation ici = ci;
		EObject eobj = OsateResourceUtil.loadElementIntoResourceSet(ci);
		if (eobj instanceof ComponentImplementation) {
			ici = (ComponentImplementation) eobj;
		}
		URI instanceURI = OsateResourceUtil.getInstanceModelURI(ici);
		Resource aadlResource = OsateResourceUtil.getEmptyAaxl2Resource(instanceURI);// ,si);

		// now instantiate the rest of the model
		final InstantiateModel instantiateModel = new InstantiateModel(monitor, new AnalysisErrorReporterManager(
				new MarkerAnalysisErrorReporter.Factory(AadlConstants.INSTANTIATION_OBJECT_MARKER)));
		SystemInstance root = instantiateModel.createSystemInstance(ici, aadlResource);
		if (root == null) {
			errorMessage = InstantiateModel.getErrorMessage();
		}
		return root;
	}

	public static SystemInstance buildInstanceModelFile(ComponentImplementation ci) throws Exception {
		return buildInstanceModelFile(ci, new NullProgressMonitor());
	}

	/*
	 * This method will construct an instance model, save it on disk and return
	 * its root object The method will make sure the declarative models are up
	 * to date. The Osate resource set is the shared resource set maintained by
	 * OsateResourceUtil
	 * 
	 * @param si system implementation
	 * 
	 * @return SystemInstance or <code>null</code> if cancelled.
	 */
	public static SystemInstance rebuildInstanceModelFile(final IResource ires) throws Exception {
		ires.deleteMarkers(null, true, IResource.DEPTH_INFINITE);
		Resource res = OsateResourceUtil.getResource(ires);
		SystemInstance target = (SystemInstance) res.getContents().get(0);
		ComponentImplementation ci = target.getComponentImplementation();
		URI uri = EcoreUtil.getURI(ci);
		res.getContents().clear();
		res.save(null);
		res.unload();
		OsateResourceUtil.refreshResourceSet();
		ci = (ComponentImplementation) OsateResourceUtil.getResourceSet().getEObject(uri, true);
		final InstantiateModel instantiateModel = new InstantiateModel(new NullProgressMonitor(),
				new AnalysisErrorReporterManager(
						new MarkerAnalysisErrorReporter.Factory(AadlConstants.INSTANTIATION_OBJECT_MARKER)));
		SystemInstance root = instantiateModel.createSystemInstance(ci, res);

		return root;
	}

	/*
	 * This method will regenerate all instance models in the workspace
	 */
	public static void rebuildAllInstanceModelFiles() throws Exception {
		HashSet<IFile> files = TraverseWorkspace.getInstanceModelFilesInWorkspace();
		List<URI> instanceRoots = new ArrayList<URI>();
		List<IResource> instanceIResources = new ArrayList<IResource>();
		for (IFile iFile : files) {
			IResource ires = iFile;
			ires.deleteMarkers(null, true, IResource.DEPTH_INFINITE);
			Resource res = OsateResourceUtil.getResource(ires);
			SystemInstance target = (SystemInstance) res.getContents().get(0);
			ComponentImplementation ci = target.getComponentImplementation();
			URI uri = EcoreUtil.getURI(ci);
			instanceRoots.add(uri);
			instanceIResources.add(ires);
			res.getContents().clear();
			res.save(null);
			res.unload();
		}
		OsateResourceUtil.refreshResourceSet();
		for (int i = 0; i < instanceRoots.size(); i++) {
			ComponentImplementation ci = (ComponentImplementation) OsateResourceUtil.getResourceSet()
					.getEObject(instanceRoots.get(i), true);
			final InstantiateModel instantiateModel = new InstantiateModel(new NullProgressMonitor(),
					new AnalysisErrorReporterManager(
							new MarkerAnalysisErrorReporter.Factory(AadlConstants.INSTANTIATION_OBJECT_MARKER)));
			Resource res = OsateResourceUtil.getResource(instanceIResources.get(i));
			instantiateModel.createSystemInstance(ci, res);
		}
	}

	/**
	 * create a system instance into the provided (empty) resource and save it
	 * This is performed as a transactional operation
	 * @param ci
	 * @param aadlResource
	 * @return
	 * @throws RollbackException
	 * @throws InterruptedException
	 */
	@SuppressWarnings("unchecked")
	public SystemInstance createSystemInstance(final ComponentImplementation ci, final Resource aadlResource)
			throws Exception {
		List<SystemInstance> resultList;
		SystemInstance result;

		result = null;

		final TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.osate.aadl2.ModelEditingDomain");
		// We execute this command on the command stack because otherwise, we will not
		// have write permissions on the editing domain.
		Command cmd = new RecordingCommand(domain) {
			public SystemInstance instance;

			@Override
			protected void doExecute() {
				try {
					instance = createSystemInstanceInt(ci, aadlResource);
				} catch (InterruptedException e) {
					// Do nothing. Will be thrown after execute.
				}
			}

			@Override
			public List<SystemInstance> getResult() {
				return Collections.singletonList(instance);
			}
		};

		((TransactionalCommandStack) domain.getCommandStack()).execute(cmd, null);
		if (monitor.isCanceled()) {
			throw new InterruptedException();
		}
		resultList = (List<SystemInstance>) cmd.getResult();
		result = resultList.get(0);

		return result;
	}

	/*
	 * instantiate SystemImpl as root of instance tree and save the model
	 * 
	 * @param si SystemImpl the root of the system instance
	 * 
	 * @param aadlResource the Resource to store the instance model in
	 * 
	 * @return SystemInstance or <code>null</code> if canceled.
	 */
	public SystemInstance createSystemInstanceInt(ComponentImplementation ci, Resource aadlResource)
			throws InterruptedException {
		SystemInstance root = InstanceFactory.eINSTANCE.createSystemInstance();
		final String instanceName = ci.getTypeName() + "_" + ci.getImplementationName()
				+ WorkspacePlugin.INSTANCE_MODEL_POSTFIX;

		root.setComponentImplementation(ci);
		root.setName(instanceName);
		root.setCategory(ci.getCategory());
		aadlResource.getContents().add(root);
		// Needed to save the root object because we may attach warnings to the
		// IResource as we build it.
		try {
			aadlResource.save(null);

			try {
				fillSystemInstance(root);
			} catch (InterruptedException e) {
				throw e;
			} catch (Exception e) {
				InstantiateModel.setErrorMessage(e.getMessage());
				e.printStackTrace();
				return null;
			}
			// We're done: Save the model.
			// We don't respond to a cancel at this point

			monitor.subTask("Saving instance model");

			aadlResource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
			setErrorMessage(e.getMessage());
			return null;
		} catch (NullPointerException npe) {
			npe.printStackTrace();
			setErrorMessage(npe.getMessage());

			npe.getMessage();
			return null;
		} catch (InterruptedException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			errorMessage = e.getMessage();

			e.getMessage();
			return null;
		}
		return root;
	}

	/**
	 * Will in fill instance model under system instance but not save it
	 * @param root
	 */
	public void fillSystemInstance(SystemInstance root) throws InterruptedException {
		populateComponentInstance(root, 0);

		monitor.subTask("Creating system operation modes");
		createSystemOperationModes(root);

		new CreateConnectionsSwitch(monitor, errManager, classifierCache).processPreOrderAll(root);
		if (monitor.isCanceled()) {
			throw new InterruptedException();
		}

		new CreateEndToEndFlowsSwitch(monitor, errManager, classifierCache).processPreOrderAll(root);
		if (monitor.isCanceled()) {
			throw new InterruptedException();
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
		EList<Property> propertyDefinitionList = getAllUsedPropertyDefinitions(root);
		CacheContainedPropertyAssociationsSwitch ccpas = new CacheContainedPropertyAssociationsSwitch(classifierCache,
				scProps, monitor, errManager);
		ccpas.processPostOrderAll(root);
		if (monitor.isCanceled()) {
			throw new InterruptedException();
		}

		final CachePropertyAssociationsSwitch cpas = new CachePropertyAssociationsSwitch(monitor, errManager,
				propertyDefinitionList, classifierCache, scProps, mode2som);
		cpas.processPreOrderAll(root);
		if (monitor.isCanceled()) {
			throw new InterruptedException();
		}
		// handle connection patterns
		processConnections(root);

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
	protected void populateComponentInstance(ComponentInstance ci, int index) throws InterruptedException {
		ComponentImplementation impl = getComponentImplementation(ci);
		ComponentType type = getComponentType(ci);
		if (ci.getContainingComponentInstance() instanceof SystemInstance) {
			monitor.subTask("Creating instances in " + ci.getName());
		}

		/*
		 * add modes & transitions. Must do this before adding subcomponents
		 * because we need to know what are the ModeInstances when processing
		 * modal subcomponents.
		 */
		if (impl != null) {
			fillModesAndTransitions(ci, impl.getAllModes(), impl.getAllModeTransitions());
		} else if (type != null) {
			fillModesAndTransitions(ci, type.getAllModes(), type.getAllModeTransitions());
		}
		if (impl != null) {
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
			instantiateFlowSpecs(ci);
		}
		return;
	}

	private void fillModesAndTransitions(ComponentInstance ci, List<Mode> modes, List<ModeTransition> modetrans)
			throws InterruptedException {
		for (Mode m : modes) {
			if (monitor.isCanceled()) {
				throw new InterruptedException();
			}
			ModeInstance mi = InstanceFactory.eINSTANCE.createModeInstance();

			mi.setMode(m);
			mi.setName(m.getName());
			mi.setInitial(m.isInitial());
			mi.setDerived(m.isDerived());
			if (m.isDerived()) {
				Subcomponent sub = ci.getSubcomponent();
				ComponentInstance parentci = ci.getContainingComponentInstance();

				for (ModeBinding mb : sub.getOwnedModeBindings()) {
					if (monitor.isCanceled()) {
						throw new InterruptedException();
					}
					if (mb.getDerivedMode() == m || mb.getDerivedMode() == null
							&& mb.getParentMode().getName().equalsIgnoreCase(m.getName())) {
						mi.getParents().add(parentci.findModeInstance(mb.getParentMode()));
					}
				}
			}
			ci.getModeInstances().add(mi);
		}
		for (ModeTransition m : modetrans) {
			if (monitor.isCanceled()) {
				throw new InterruptedException();
			}
			ModeTransitionInstance mti = InstanceFactory.eINSTANCE.createModeTransitionInstance();
			Mode srcmode = m.getSource();
			Mode dstmode = m.getDestination();
			ModeInstance srcI = ci.findModeInstance(srcmode);
			ModeInstance dstI = ci.findModeInstance(dstmode);

			mti.setSource(srcI);
			mti.setDestination(dstI);
			mti.setModeTransition(m);
			List<ModeTransitionTrigger> triggers = m.getOwnedTriggers();
			String eventName = "";
			if (!triggers.isEmpty()) {
				TriggerPort tp = triggers.get(0).getTriggerPort();
				if (tp instanceof Port) {
					Context o = triggers.get(0).getContext();
					if (o instanceof Subcomponent) {
						eventName = ((Subcomponent) o).getName() + ".";
					}
				}
				eventName += tp.getName();
			}
			mti.setName(srcmode.getName() + "." + (!eventName.equals("") ? eventName + "." : "") + dstmode.getName());
			ci.getModeTransitionInstances().add(mti);
		}
	}

	/*
	 * @param ci
	 * 
	 * @param impl
	 */
	protected void instantiateSubcomponents(final ComponentInstance ci, ComponentImplementation impl)
			throws InterruptedException {
		for (final Subcomponent sub : impl.getAllSubcomponents()) {
			if (monitor.isCanceled()) {
				throw new InterruptedException();
			}
			if (hasSubcomponentInstance(ci, sub)) {
				errManager.error(ci, "Cyclic containment dependency: Subcomponent '" + sub.getName()
						+ "' has already been instantiated as enclosing component.");
			} else {
				final EList<ArrayDimension> dims = sub.getArrayDimensions();
				Stack<Long> indexStack = new Stack<Long>();

				if (dims.isEmpty()) {
					instantiateSubcomponent(ci, sub, sub, indexStack, 0);
				} else {
					final int dimensions = dims.size();
					class ArrayInstantiator {
						void process(int dim, Stack<Long> indexStack) throws InterruptedException {
							// index starts with one
							ArraySize arraySize = dims.get(dim).getSize();
							long count = getElementCount(arraySize, ci);

							for (int i = 1; i <= count; i++) {
								if (monitor.isCanceled()) {
									throw new InterruptedException();
								}
								if (dim + 1 < dimensions) {
									indexStack.push(Long.valueOf(i));
									process(dim + 1, indexStack);
									indexStack.pop();
								} else {
									instantiateSubcomponent(ci, sub, sub, indexStack, i);
								}
							}
						}
					}
					new ArrayInstantiator().process(0, indexStack);
				}
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
			if (psc == sub) {
				return true;
			}
			parent = (ComponentInstance) parent.eContainer();
		}
		return false;
	}

	protected String indexStackToString(Stack<Long> indexStack) {
		String result = "";
		for (int i = 0; i < indexStack.size(); i++) {
			result = result + "_" + indexStack.get(i);
		}
		return result;
	}

	protected void instantiateSubcomponent(final ComponentInstance parent, final ModalElement mm,
			final Subcomponent sub, Stack<Long> indexStack, int index) throws InterruptedException {
		final ComponentInstance newInstance = InstanceFactory.eINSTANCE.createComponentInstance();
		final ComponentClassifier cc;
		final InstantiatedClassifier ic;

		newInstance.setSubcomponent(sub);
		newInstance.setCategory(sub.getCategory());
		newInstance.setName(sub.getName());
		newInstance.getIndices().addAll(indexStack);
		newInstance.getIndices().add(new Long(index));
		parent.getComponentInstances().add(newInstance);
		ic = getInstantiatedClassifier(newInstance);
		if (ic == null) {
			cc = null;
		} else {
			cc = (ComponentClassifier) ic.classifier;
		}
		if (cc == null) {
			errManager.warning(newInstance, "Instantiated subcomponent doesn't have a component classifier");
		} else {
//			if (cc instanceof ComponentType) {
//				if (sub instanceof SystemSubcomponent || sub instanceof ProcessSubcomponent
//						|| sub instanceof ThreadGroupSubcomponent) {
//					errManager.warning(newInstance, "Instantiated subcomponent has a component type only");
//				}
//			}
			newInstance.setCategory(cc.getCategory());
		}

		for (Mode mode : mm.getAllInModes()) {
			if (monitor.isCanceled()) {
				throw new InterruptedException();
			}
			ModeInstance mi = parent.findModeInstance(mode);

			if (mi != null) {
				newInstance.getInModes().add(mi);
			}
		}
		populateComponentInstance(newInstance, index);
	}

	/**
	 * same method but with different name exists in createEndToEndFlowSwitch.
	 * It adds the flow instances on demand when ETEF is created
	 * @param ci
	 */
	private void instantiateFlowSpecs(ComponentInstance ci) throws InterruptedException {
		for (FlowSpecification spec : getComponentType(ci).getAllFlowSpecifications()) {
			if (monitor.isCanceled()) {
				throw new InterruptedException();
			}
			FlowSpecificationInstance speci = ci.createFlowSpecification();
			speci.setName(spec.getName());
			speci.setFlowSpecification(spec);
			FlowEnd inend = spec.getAllInEnd();
			if (inend != null) {
				Feature srcfp = inend.getFeature();
				Context srcpg = inend.getContext();
				if (srcpg == null) {
					FeatureInstance fi = ci.findFeatureInstance(srcfp);
					if (fi != null) {
						speci.setSource(fi);
					}
				} else if (srcpg instanceof FeatureGroup) {
					FeatureInstance pgi = ci.findFeatureInstance((FeatureGroup) srcpg);
					if (pgi != null) {
						FeatureInstance fi = pgi.findFeatureInstance(srcfp);
						if (fi != null) {
							speci.setSource(fi);
						}
					}
				}
			}
			FlowEnd outend = spec.getAllOutEnd();
			if (outend != null) {
				Feature dstfp = outend.getFeature();
				Context dstpg = outend.getContext();
				if (dstpg == null) {
					FeatureInstance fi = ci.findFeatureInstance(dstfp);
					if (fi != null) {
						speci.setDestination(fi);
					}
				} else if (dstpg instanceof FeatureGroup) {
					FeatureInstance pgi = ci.findFeatureInstance((FeatureGroup) dstpg);
					if (pgi != null) {
						FeatureInstance fi = pgi.findFeatureInstance(dstfp);
						if (fi != null) {
							speci.setDestination(fi);
						}
					}
				}
			}
			for (Mode mode : spec.getAllInModes()) {
				if (monitor.isCanceled()) {
					throw new InterruptedException();
				}
				ModeInstance mi = ci.findModeInstance(mode);
				if (mi != null) {
					speci.getInModes().add(mi);
				}
			}

			for (ModeTransition mt : spec.getInModeTransitions()) {
				if (monitor.isCanceled()) {
					throw new InterruptedException();
				}
				ModeTransitionInstance ti = ci.findModeTransitionInstance(mt);

				if (ti != null) {
					speci.getInModeTransitions().add(ti);
				}
			}
		}
	}

	/*
	 * Add feature instances to component instance
	 */
	protected void instantiateFeatures(final ComponentInstance ci) throws InterruptedException {
		for (final Feature feature : getInstantiatedClassifier(ci).classifier.getAllFeatures()) {
			if (monitor.isCanceled()) {
				throw new InterruptedException();
			}
			final EList<ArrayDimension> dims = feature.getArrayDimensions();

			if (dims.isEmpty()) {
				fillFeatureInstance(ci, feature, false, 0);
			} else {
				// feature dimension should always be one
				class ArrayInstantiator {
					void process(int dim) {
						ArraySize arraySize = dims.get(dim).getSize();
						long count = getElementCount(arraySize, ci);

						for (int i = 1; i <= count; i++) {
							fillFeatureInstance(ci, feature, false, i);
						}
					}
				}
				new ArrayInstantiator().process(0);
			}
		}
	}

	protected void fillFeatureInstance(ComponentInstance ci, Feature feature, boolean inverse, int index) {
		final FeatureInstance fi = InstanceFactory.eINSTANCE.createFeatureInstance();
		fi.setName(feature.getName());
		fi.setFeature(feature);
		// must add before prototype resolution in fillFeatureInstance
		ci.getFeatureInstances().add(fi);
		if (feature instanceof DirectedFeature) {
			fi.setDirection(((DirectedFeature) feature).getDirection());
		} else {
			fi.setDirection(DirectionType.IN_OUT);
		}
		filloutFeatureInstance(fi, feature, inverse, index);
	}

	/**
	 * fill in a feature within a feature group
	 * Take into account the inverse setting on enclosing feature group(s) in setting feature direction
	 * @param fgi
	 * @param feature
	 * @param inverse
	 * @param index
	 */
	protected void fillFeatureInstance(FeatureInstance fgi, Feature feature, boolean inverse, int index) {
		final FeatureInstance fi = InstanceFactory.eINSTANCE.createFeatureInstance();
		fi.setName(feature.getName());
		fi.setFeature(feature);
		fgi.getFeatureInstances().add(fi);
		// take into account inverse in setting direction of features inside feature groups
		if (feature instanceof DirectedFeature) {
			fi.setDirection(((DirectedFeature) feature).getDirection());
			DirectionType dir = ((DirectedFeature) feature).getDirection();

			if (inverse && dir != DirectionType.IN_OUT) {
				dir = (dir == DirectionType.IN) ? DirectionType.OUT : DirectionType.IN;
			}
			fi.setDirection(dir);
		} else {
			fi.setDirection(DirectionType.IN_OUT);
		}
		// must add before prototype resolution in fillFeatureInstance
		filloutFeatureInstance(fi, feature, inverse, index);
	}

	/**
	 * fill out the rest of the feature instance
	 * resolve any prototype first
	 * @param feature
	 * @param fi is feature instance of feature
	 * @param inverse
	 * @param index
	 */
	protected void filloutFeatureInstance(FeatureInstance fi, Feature feature, boolean inverse, int index) {
		fi.setIndex(index);

		// resolve feature prototype
		if (feature.getPrototype() instanceof FeaturePrototype) {
			FeaturePrototypeActual fpa = resolveFeaturePrototype(feature.getPrototype(), fi);

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
	 * expand out feature instances for elements of a port group
	 * 
	 * @param fi Feature Instance that is a port group
	 */
	protected void expandFeatureGroupInstance(Feature feature, FeatureInstance fi, boolean inverse) {
		if (feature instanceof FeatureGroup) {
			final FeatureGroup fg = (FeatureGroup) feature;
			FeatureType ft = ((FeatureGroup) feature).getFeatureType();
			if (Aadl2Util.isNull(ft)) {
				return;
			}

			inverse ^= fg.isInverse();

			InstantiatedClassifier ic = getInstantiatedClassifier(fi);
			if (ic.classifier == null) {
				errManager.error(fi, "Could not resolve feature group type of feature group prototype "
						+ fi.getInstanceObjectPath());
				return;
			} else if (ic.bindings != null && ic.bindings.isEmpty()) {
				// prototype has not been bound yet
				errManager.warning(fi, "Feature group prototype  of " + fi.getInstanceObjectPath()
						+ " is not bound yet to feature group type");
			}
			FeatureGroupType fgt = (FeatureGroupType) ic.classifier;

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
			instantiateFGFeatures(fi, fgFeatures, inverse);
		}
	}

	/**
	 * instantiate features in feature group take into account that they can be declared as arrays
	 */
	protected void instantiateFGFeatures(final FeatureInstance fgi, List<Feature> flist, final boolean inverse) {
		for (final Feature feature : flist) {
			final EList<ArrayDimension> dims = feature.getArrayDimensions();

			if (dims.isEmpty()) {
				fillFeatureInstance(fgi, feature, inverse, 0);
			} else {
				class ArrayInstantiator {
					void process(int dim) {
						ArraySize arraySize = dims.get(dim).getSize();
						long count = getElementCount(arraySize, fgi.getContainingComponentInstance());

						for (int i = 0; i < count; i++) {
							fillFeatureInstance(fgi, feature, inverse, i + 1);
						}
					}
				}
				new ArrayInstantiator().process(0);
			}
		}
	}

	// --------------------------------------------------------------------------------------------
	// Methods for connection sets and connection patterns
	// --------------------------------------------------------------------------------------------

	private void processConnections(SystemInstance root) throws InterruptedException {
		if (monitor.isCanceled()) {
			throw new InterruptedException();
		}
		EList<ComponentInstance> replicateConns = new UniqueEList<ComponentInstance>();
		List<ConnectionInstance> toRemove = new ArrayList<ConnectionInstance>();
		EList<ConnectionInstance> connilist = root.getAllConnectionInstances();
		for (ConnectionInstance conni : connilist) {
			// track all component instances that contain connection instances
			replicateConns.add(conni.getComponentInstance());

			PropertyAssociation setPA = getPA(conni, "Connection_Set");
			PropertyAssociation patternPA = getPA(conni, "Connection_Pattern");

			if (setPA == null && patternPA == null) {
				// OsateDebug.osateDebug("[InstantiateModel] processConnections");

				LinkedList<Integer> srcDims = new LinkedList<Integer>();
				LinkedList<Integer> dstDims = new LinkedList<Integer>();
				LinkedList<Integer> srcSizes = new LinkedList<Integer>();
				LinkedList<Integer> dstSizes = new LinkedList<Integer>();
				boolean done = false;

				analyzePath(conni.getContainingComponentInstance(), conni.getSource(), null, srcDims, srcSizes);
				analyzePath(conni.getContainingComponentInstance(), conni.getDestination(), null, dstDims, dstSizes);
				for (int d : srcDims) {
					if (d != 0) {
						done = true;
						if (interpretConnectionPatterns(conni, false, null, 0, srcSizes, 0, dstSizes, 0,
								new ArrayList<Long>(), new ArrayList<Long>())) {
							toRemove.add(conni);
						}
						break;
					}
				}
				if (!done) {
					for (int d : dstDims) {
						if (d != 0) {
							done = true;
							if (interpretConnectionPatterns(conni, false, null, 0, srcSizes, 0, dstSizes, 0,
									new ArrayList<Long>(), new ArrayList<Long>())) {
								toRemove.add(conni);
							}
							break;
						}
					}
				}
			} else if (patternPA != null) {
				boolean isOpposite = Aadl2InstanceUtil.isOpposite(conni);
				EcoreUtil.remove(patternPA);
				List<PropertyExpression> patterns = ((ListValue) patternPA.getOwnedValues().get(0).getOwnedValue())
						.getOwnedListElements();
				for (PropertyExpression pe : patterns) {
					List<PropertyExpression> pattern = ((ListValue) pe).getOwnedListElements();
					LinkedList<Integer> srcSizes = new LinkedList<Integer>();
					LinkedList<Integer> dstSizes = new LinkedList<Integer>();

					analyzePath(conni.getContainingComponentInstance(), conni.getSource(), null, null, srcSizes);
					analyzePath(conni.getContainingComponentInstance(), conni.getDestination(), null, null, dstSizes);
					if (srcSizes.size() == 0 && dstSizes.size() == 0) {
						errManager.warning(conni,
								"Connection pattern specified for connection that does not connect array elements.");
					} else {
						if (interpretConnectionPatterns(conni, isOpposite, pattern, 0, srcSizes, 0, dstSizes, 0,
								new ArrayList<Long>(), new ArrayList<Long>())) {
							toRemove.add(conni);
						}
					}
				}
			}
			// no else as we want both the pattern and the connection set evaluated
			if (setPA != null) {
				EcoreUtil.remove(setPA);
				// TODO-LW: modal conn set allowed?
				List<Long> srcIndices;
				List<Long> dstIndices;
				for (PropertyExpression pe : ((ListValue) setPA.getOwnedValues().get(0).getOwnedValue())
						.getOwnedListElements()) {
					RecordValue rv = (RecordValue) pe;

					srcIndices = getIndices(rv, "src");
					dstIndices = getIndices(rv, "dst");
					if (Aadl2InstanceUtil.isOpposite(conni)) {
						// flip indices since we are going in the opposite direction
						createNewConnection(conni, dstIndices, srcIndices);
					} else {
						createNewConnection(conni, srcIndices, dstIndices);
					}
				}
				toRemove.add(conni);
			}
		}
		for (ConnectionInstance conni : toRemove) {
			EcoreUtil.delete(conni);
		}
		replicateConnections(replicateConns);
	}

	private void replicateConnections(EList<ComponentInstance> replicateConns) {
		for (ComponentInstance ci : replicateConns) {
			if (isInArray(ci)) {
				doReplicateConnections(ci);
			}
		}
	}

	private boolean isInArray(ComponentInstance ci) {
		while (!(ci instanceof SystemInstance)) {
			if (!ci.getIndices().isEmpty()) {
				return true;
			}
			ci = ci.getContainingComponentInstance();
		}
		return false;
	}

	private ComponentInstance outermostArray(ComponentInstance ci) {
		ComponentInstance res = null;
		while (!(ci instanceof SystemInstance)) {
			if (!ci.getIndices().isEmpty()) {
				res = ci;
			}
			ci = ci.getContainingComponentInstance();
		}
		return res;
	}

	private void doReplicateConnections(ComponentInstance ci) {
		String origPath = getComponentInstanceNamePath(ci);
		ComponentInstance outermostParent = outermostArray(ci).getContainingComponentInstance();
		doReplicateConnections(ci, origPath, outermostParent);
	}

	private void doReplicateConnections(ComponentInstance ci, String origPath, ComponentInstance targetParent) {
		for (ComponentInstance targetci : targetParent.getComponentInstances()) {
			// do it only for sibling components. Misses out on enclosing arrays
			if (targetci.getConnectionInstances().isEmpty()) {
				// only if it does not yet have connection instances
				String targetpath = getComponentInstanceNamePath(targetci);
				// compare paths without indices
				if (origPath.equalsIgnoreCase(targetpath)) {
					for (ConnectionInstance conni : ci.getConnectionInstances()) {
						createNewConnection(conni, targetci);
					}
				} else if (origPath.startsWith(targetpath)) {
					doReplicateConnections(ci, origPath, targetci);
				}
			}
		}
	}

	private String getComponentInstanceNamePath(ComponentInstance ci) {
		if (ci instanceof SystemInstance) {
			return ci.getName();
		}
		final String path = getComponentInstanceNamePath(ci.getContainingComponentInstance());
		final String localname = ci.getName();

		return path + "." + localname;
	}

	private boolean interpretConnectionPatterns(ConnectionInstance conni, boolean isOpposite,
			List<PropertyExpression> patterns, int offset, List<Integer> srcSizes, int srcOffset,
			List<Integer> dstSizes, int dstOffset, List<Long> srcIndices, List<Long> dstIndices) {
		boolean result = true;
		if (patterns != null ? offset >= patterns.size()
				: srcOffset == srcSizes.size() && dstOffset == dstSizes.size()) {
			createNewConnection(conni, srcIndices, dstIndices);
			return result;
		}
		String patternName = "One_to_One";
		if (patterns == null) {
			// default one-to-one pattern
			if (!conni.isComplete()) {
				// outgoing or incoming only
				InstanceObject io = conni.getSource();
				if (io instanceof FeatureInstance && io.getContainingComponentInstance() instanceof SystemInstance) {
					if (srcSizes.isEmpty()) {
						patternName = isOpposite ? "All_to_One" : "One_To_All";
					}
				} else {
					if (dstSizes.isEmpty()) {
						patternName = isOpposite ? "One_To_All" : "All_to_One";
					}
				}
			}
		} else {
			NamedValue nv = (NamedValue) patterns.get(offset);
			EnumerationLiteral pattern = (EnumerationLiteral) nv.getNamedValue();
			patternName = pattern.getName();
		}

		if (!isOpposite && !patternName.equalsIgnoreCase("One_To_All") && (srcOffset >= srcSizes.size())) {
			errManager.error(conni, "Too few indices for connection source for "+conni.getFullName());
			return false;
		}
		if (!isOpposite && !patternName.equalsIgnoreCase("All_To_One") && (dstOffset >= dstSizes.size())) {
			errManager.error(conni, "Too few indices for connection destination for "+conni.getFullName());
			return false;
		}
		if (isOpposite && !patternName.equalsIgnoreCase("One_To_All") && (dstOffset >= dstSizes.size())) {
			//verbose exception message			
			errManager.error(conni, "Too few indices for connection source for "+conni.getFullName());
			return false;
		}
		if (isOpposite && !patternName.equalsIgnoreCase("All_To_One") && (srcOffset >= srcSizes.size())) {
			errManager.error(conni, "Too few indices for connection destination for "+conni.getFullName());
			return false;
		}
		if (patternName.equalsIgnoreCase("All_To_All")) {
			for (long i = 1; i <= srcSizes.get(srcOffset); i++) {
				srcIndices.add(i);
				for (long j = 1; j <= dstSizes.get(dstOffset); j++) {
					dstIndices.add(j);
					result &= interpretConnectionPatterns(conni, isOpposite, patterns, offset + 1, srcSizes,
							srcOffset + 1, dstSizes, dstOffset + 1, srcIndices, dstIndices);
					dstIndices.remove(dstOffset);
				}
				srcIndices.remove(srcOffset);
			}
		} else if ((!isOpposite && patternName.equalsIgnoreCase("One_To_All"))
				|| (isOpposite && patternName.equalsIgnoreCase("All_To_One"))) {
			for (long j = 1; j <= dstSizes.get(dstOffset); j++) {
				dstIndices.add(j);
				result &= interpretConnectionPatterns(conni, isOpposite, patterns, offset + 1, srcSizes, srcOffset,
						dstSizes, dstOffset + 1, srcIndices, dstIndices);
				dstIndices.remove(dstOffset);
			}
		} else if ((!isOpposite && patternName.equalsIgnoreCase("All_To_One"))
				|| (isOpposite && patternName.equalsIgnoreCase("One_To_All"))) {
			for (long i = 1; i <= srcSizes.get(srcOffset); i++) {
				srcIndices.add(i);
				result &= interpretConnectionPatterns(conni, isOpposite, patterns, offset + 1, srcSizes, srcOffset + 1,
						dstSizes, dstOffset, srcIndices, dstIndices);
				srcIndices.remove(srcOffset);
			}
		} else {
			if (!srcSizes.get(srcOffset).equals(dstSizes.get(dstOffset))) {
//verbose exception message			
				errManager.error(conni, "Array size mismatch (" + patternName + ") on connection "+
			          conni.getFullName()+" in "+conni.getContainingComponentInstance().getFullName()+
			           ": " + srcSizes.get(srcOffset)
						+ " at source "+  //("+conni.getSource().getFullName()+")
			            "and " + dstSizes.get(dstOffset) +
						" at destination." // ("+conni.getSource().getFullName()+")."
			            );
				return false;
			} else {
				if (patternName.equalsIgnoreCase("One_To_One")) {
					for (long i = 1; i <= srcSizes.get(srcOffset); i++) {
						srcIndices.add(i);
						dstIndices.add(i);
						result &= interpretConnectionPatterns(conni, isOpposite, patterns, offset + 1, srcSizes,
								srcOffset + 1, dstSizes, dstOffset + 1, srcIndices, dstIndices);
						srcIndices.remove(srcOffset);
						dstIndices.remove(dstOffset);
					}
				} else if (patternName.equalsIgnoreCase("Next")) {
					for (long i = 1; i <= srcSizes.get(srcOffset) - 1; i++) {
						srcIndices.add(i);
						dstIndices.add(i + 1);
						result &= interpretConnectionPatterns(conni, isOpposite, patterns, offset + 1, srcSizes,
								srcOffset + 1, dstSizes, dstOffset + 1, srcIndices, dstIndices);
						dstIndices.remove(dstOffset);
						srcIndices.remove(srcOffset);
					}
				} else if (patternName.equalsIgnoreCase("Previous")) {
					for (long i = 2; i <= srcSizes.get(srcOffset); i++) {
						srcIndices.add(i);
						dstIndices.add(i - 1);
						result &= interpretConnectionPatterns(conni, isOpposite, patterns, offset + 1, srcSizes,
								srcOffset + 1, dstSizes, dstOffset + 1, srcIndices, dstIndices);
						dstIndices.remove(dstOffset);
						srcIndices.remove(srcOffset);
					}
				} else if (patternName.equalsIgnoreCase("Cyclic_Next")) {
					for (long i = 1; i <= srcSizes.get(srcOffset); i++) {
						srcIndices.add(i);
						dstIndices.add(i == srcSizes.get(srcOffset) ? 1 : i + 1);
						result &= interpretConnectionPatterns(conni, isOpposite, patterns, offset + 1, srcSizes,
								srcOffset + 1, dstSizes, dstOffset + 1, srcIndices, dstIndices);
						dstIndices.remove(dstOffset);
						srcIndices.remove(srcOffset);
					}
				} else if (patternName.equalsIgnoreCase("Cyclic_Previous")) {
					for (long i = 1; i <= srcSizes.get(srcOffset); i++) {
						srcIndices.add(i);
						dstIndices.add(i == 1 ? srcSizes.get(srcOffset) : i - 1);
						result &= interpretConnectionPatterns(conni, isOpposite, patterns, offset + 1, srcSizes,
								srcOffset + 1, dstSizes, dstOffset + 1, srcIndices, dstIndices);
						dstIndices.remove(dstOffset);
						srcIndices.remove(srcOffset);
					}
				} else if (patternName.equalsIgnoreCase("Next_Next")) {
					for (long i = 1; i <= srcSizes.get(srcOffset) - 2; i++) {
						srcIndices.add(i);
						dstIndices.add(i + 2);
						result &= interpretConnectionPatterns(conni, isOpposite, patterns, offset + 1, srcSizes,
								srcOffset + 1, dstSizes, dstOffset + 1, srcIndices, dstIndices);
						dstIndices.remove(dstOffset);
						srcIndices.remove(srcOffset);
					}
				} else if (patternName.equalsIgnoreCase("Previous_Previous")) {
					for (long i = 3; i <= srcSizes.get(srcOffset); i++) {
						srcIndices.add(i);
						dstIndices.add(i - 2);
						result &= interpretConnectionPatterns(conni, isOpposite, patterns, offset + 1, srcSizes,
								srcOffset + 1, dstSizes, dstOffset + 1, srcIndices, dstIndices);
						dstIndices.remove(dstOffset);
						srcIndices.remove(srcOffset);
					}
				} else if (patternName.equalsIgnoreCase("Cyclic_Next_Next")) {
					for (long i = 1; i <= srcSizes.get(srcOffset); i++) {
						srcIndices.add(i);
						dstIndices
								.add(i == srcSizes.get(srcOffset) ? 2 : (i == srcSizes.get(srcOffset) - 1 ? 1 : i + 1));
						result &= interpretConnectionPatterns(conni, isOpposite, patterns, offset + 1, srcSizes,
								srcOffset + 1, dstSizes, dstOffset + 1, srcIndices, dstIndices);
						dstIndices.remove(dstOffset);
						srcIndices.remove(srcOffset);
					}
				} else if (patternName.equalsIgnoreCase("Cyclic_Previous_Previous")) {
					for (long i = 1; i <= srcSizes.get(srcOffset); i++) {
						srcIndices.add(i);
						dstIndices
								.add(i == 2 ? srcSizes.get(srcOffset) : (i == 1 ? srcSizes.get(srcOffset) - 1 : i - 1));
						result &= interpretConnectionPatterns(conni, isOpposite, patterns, offset + 1, srcSizes,
								srcOffset + 1, dstSizes, dstOffset + 1, srcIndices, dstIndices);
						dstIndices.remove(dstOffset);
						srcIndices.remove(srcOffset);
					}
				} else if (patternName.equalsIgnoreCase("Even_To_Even")) {
					for (long i = 2; i <= srcSizes.get(srcOffset); i = i + 2) {
						srcIndices.add(i);
						dstIndices.add(i);
						result &= interpretConnectionPatterns(conni, isOpposite, patterns, offset + 1, srcSizes,
								srcOffset + 1, dstSizes, dstOffset + 1, srcIndices, dstIndices);
						dstIndices.remove(dstOffset);
						srcIndices.remove(srcOffset);
					}
				} else if (patternName.equalsIgnoreCase("Odd_To_Odd")) {
					for (long i = 1; i <= srcSizes.get(srcOffset); i = i + 2) {
						srcIndices.add(i);
						dstIndices.add(i);
						result &= interpretConnectionPatterns(conni, isOpposite, patterns, offset + 1, srcSizes,
								srcOffset + 1, dstSizes, dstOffset + 1, srcIndices, dstIndices);
						dstIndices.remove(dstOffset);
						srcIndices.remove(srcOffset);
					}
				}
			}
		}
		return result;
	}

	private List<Long> getIndices(RecordValue rv, String field) {
		List<Long> indices = new ArrayList<Long>();
		for (BasicPropertyAssociation fv : rv.getOwnedFieldValues()) {
			if (fv.getProperty().getName().equalsIgnoreCase(field)) {
				ListValue lv = (ListValue) fv.getOwnedValue();
				EList<PropertyExpression> vlist = lv.getOwnedListElements();
//				for (int i = vlist.size()-1; i >=0; i--){
//				PropertyExpression elem = vlist.get(i);
				for (PropertyExpression elem : vlist) {
					indices.add(((IntegerLiteral) elem).getValue());
				}
			}
		}
		return indices;
	}

	private PropertyAssociation getPA(ConnectionInstance conni, String name) {
		for (PropertyAssociation pa : conni.getOwnedPropertyAssociations()) {
			if (pa.getProperty().getName().equalsIgnoreCase(name) && ((PropertySet) pa.getProperty().getOwner())
					.getName().equalsIgnoreCase("Communication_Properties")) {
				return pa;
			}
		}
		return null;
	}

	private void analyzePath(ComponentInstance container, ConnectionInstanceEnd end, LinkedList<String> names,
			LinkedList<Integer> dims, LinkedList<Integer> sizes) {
		InstanceObject current = end;
		while ((current != container) && !(current instanceof SystemInstance)) {// &&(current != null)) {
			int d = 0;

			if (names != null) {
				names.add(current.getName());
			}

			if (current instanceof ComponentInstance) {
				d = ((ComponentInstance) current).getSubcomponent().getArrayDimensions().size();
			} else if (current instanceof FeatureInstance && ((FeatureInstance) current).getIndex() != 0) {
				d = 1;
			}
			if (dims != null) {
				dims.add(d);
			}
			if (sizes != null && d != 0) {
				if (current instanceof ComponentInstance) {
					Subcomponent s = ((ComponentInstance) current).getSubcomponent();

					for (ArrayDimension ad : s.getArrayDimensions()) {
						ArraySize as = ad.getSize();

						sizes.add((int) getElementCount(as, current.getContainingComponentInstance()));
					}

				} else if (current instanceof FeatureInstance && ((FeatureInstance) current).getIndex() != 0) {
					Feature f = ((FeatureInstance) current).getFeature();
					ArraySize as = f.getArrayDimensions().get(0).getSize();

					sizes.add((int) getElementCount(as, current.getContainingComponentInstance()));
				}
			}
			current = (InstanceObject) current.getOwner();
		}
	}

	private void analyzePath(ComponentInstance container, ConnectionInstanceEnd end, LinkedList<String> names,
			LinkedList<Integer> dims, LinkedList<Integer> sizes, LinkedList<Long> indices) {
		InstanceObject current = end;
		while (current != container) {
			int d = 0;

			if (names != null) {
				names.add(current.getName());
			}
			if (current instanceof ComponentInstance) {
				EList<Long> idx = ((ComponentInstance) current).getIndices();
				if (!idx.isEmpty()) {
					indices.addAll(((ComponentInstance) current).getIndices());
				}
			} else if (current instanceof FeatureInstance) {
				long idx = ((FeatureInstance) current).getIndex();
				if (idx != 0) {
					indices.add(idx);
				}
			}
			if (current instanceof ComponentInstance) {
				d = ((ComponentInstance) current).getSubcomponent().getArrayDimensions().size();
			} else if (current instanceof FeatureInstance && ((FeatureInstance) current).getIndex() != 0) {
				d = 1;
			}
			if (dims != null) {
				dims.add(d);
			}
			if (sizes != null && d != 0) {
				if (current instanceof ComponentInstance) {
					Subcomponent s = ((ComponentInstance) current).getSubcomponent();

					for (ArrayDimension ad : s.getArrayDimensions()) {
						ArraySize as = ad.getSize();

						sizes.add((int) getElementCount(as, current.getContainingComponentInstance()));
					}

				} else if (current instanceof FeatureInstance && ((FeatureInstance) current).getIndex() != 0) {
					Feature f = ((FeatureInstance) current).getFeature();
					ArraySize as = f.getArrayDimensions().get(0).getSize();

					sizes.add((int) getElementCount(as, current.getContainingComponentInstance()));
				}
			}
			current = (InstanceObject) current.getOwner();
		}
	}

	/**
	 * create a copy of the connection instance with the specified indices for the source and the destination
	 * @param conni
	 * @param srcIndices
	 * @param dstIndices
	 */
	private void createNewConnection(ConnectionInstance conni, List<Long> srcIndices, List<Long> dstIndices) {
		LinkedList<String> names = new LinkedList<String>();
		LinkedList<Integer> dims = new LinkedList<Integer>();
		LinkedList<Integer> sizes = new LinkedList<Integer>();
		ConnectionInstance newConn = EcoreUtil.copy(conni);
		conni.getContainingComponentInstance().getConnectionInstances().add(newConn);
		ConnectionReference topConnRef = Aadl2InstanceUtil.getTopConnectionReference(newConn);
		analyzePath(conni.getContainingComponentInstance(), conni.getSource(), names, dims, sizes);
		if (srcIndices.size() != sizes.size() &&
		// filter out one side being an element without index (array of 1) (many to one mapping)
				!(sizes.size() == 0 && dstIndices.size() == 1)) {
			errManager.error(newConn,
					"Source indices " + srcIndices + " do not match source dimension " + sizes.size());
		}
		InstanceObject src = resolveConnectionInstancePath(newConn, topConnRef, names, dims, sizes, srcIndices, true);
		names.clear();
		dims.clear();
		sizes.clear();
		analyzePath(conni.getContainingComponentInstance(), conni.getDestination(), names, dims, sizes);
		if (dstIndices.size() != sizes.size() &&
		// filter out one side being an element without index (array of 1) (many to one mapping)
				!(sizes.size() == 0 && dstIndices.size() == 1)) {
			errManager.error(newConn, "For "+newConn.getConnectionReferences().get(0).getFullName()+
					" : "+newConn.getFullName()+
					", destination indices " + dstIndices + " do not match destination dimension " + sizes.size());
		}
		InstanceObject dst = resolveConnectionInstancePath(newConn, topConnRef, names, dims, sizes, dstIndices, false);
		if (src == null) {
			errManager.error(newConn, "Connection source not found");
		}
		if (dst == null) {
			errManager.error(newConn, "Connection destination not found");
		}

		String containerPath = conni.getContainingComponentInstance().getInstanceObjectPath();
		int len = containerPath.length() + 1;
		String srcPath = (src != null) ? src.getInstanceObjectPath() : "Source end not found";
		StringBuffer sb = new StringBuffer();
		int i = (srcPath.startsWith(containerPath)) ? len : 0;
		sb.append(srcPath.substring(i));
		sb.append(" --> ");
		String dstPath = (dst != null) ? dst.getInstanceObjectPath() : "Destination end not found";
		i = (dstPath.startsWith(containerPath)) ? len : 0;
		sb.append(dstPath.substring(i));

		ConnectionInstance duplicate = (ConnectionInstance) AadlUtil
				.findNamedElementInList(conni.getContainingComponentInstance().getConnectionInstances(), sb.toString());
		if (duplicate != null && duplicate != conni) { // conni will be removed later
			errManager.warning(newConn, "There is already another connection between the same endpoints");
		}
		newConn.setSource((ConnectionInstanceEnd) src);
		newConn.setDestination((ConnectionInstanceEnd) dst);
		newConn.setName(sb.toString());

	}

	/**
	 * create a copy of the connection instance with the specified indices for the source and the destination
	 * @param conni
	 * @param srcIndices
	 * @param dstIndices
	 * @return
	 */
	private void createNewConnection(ConnectionInstance conni, ComponentInstance targetComponent) {
		LinkedList<Long> indices = new LinkedList<Long>();
		LinkedList<String> names = new LinkedList<String>();
		LinkedList<Integer> dims = new LinkedList<Integer>();
		LinkedList<Integer> sizes = new LinkedList<Integer>();
		ConnectionInstance newConn = EcoreUtil.copy(conni);
		targetComponent.getConnectionInstances().add(newConn);
		ConnectionReference topConnRef = Aadl2InstanceUtil.getTopConnectionReference(newConn);
		analyzePath(conni.getContainingComponentInstance(), conni.getSource(), names, dims, sizes, indices);
		InstanceObject src = resolveConnectionInstancePath(newConn, topConnRef, names, dims, sizes, indices, true);
		names.clear();
		dims.clear();
		sizes.clear();
		indices.clear();
		analyzePath(conni.getContainingComponentInstance(), conni.getDestination(), names, dims, sizes, indices);
		InstanceObject dst = resolveConnectionInstancePath(newConn, topConnRef, names, dims, sizes, indices, false);
		if (src == null) {
			errManager.error(newConn, "Connection source not found");
		}
		if (dst == null) {
			errManager.error(newConn, "Connection destination not found");
		}

		String containerPath = targetComponent.getInstanceObjectPath();
		int len = containerPath.length() + 1;
		String srcPath = (src != null) ? src.getInstanceObjectPath() : "Source end not found";
		StringBuffer sb = new StringBuffer();
		int i = (srcPath.startsWith(containerPath)) ? len : 0;
		sb.append(srcPath.substring(i));
		sb.append(" --> ");
		String dstPath = (dst != null) ? dst.getInstanceObjectPath() : "Destination end not found";
		i = (dstPath.startsWith(containerPath)) ? len : 0;
		sb.append(dstPath.substring(i));

		newConn.setSource((ConnectionInstanceEnd) src);
		newConn.setDestination((ConnectionInstanceEnd) dst);
		newConn.setName(sb.toString());

	}

	/**
	 * resolve downgoing source or destination of the connection reference.
	 * we do so by re-retrieving the feature instance based on the existing connection instance end name.
	 * If the connection reference is up or down going we also fill in the other end.
	 * @param targetConnRef
	 * @param result
	 * @param name
	 * @param doSource
	 */
	private ConnectionInstanceEnd resolveConnectionReference(ConnectionReference targetConnRef,
			ConnectionReference outerConnRef, ComponentInstance target, boolean doSource, long idx, long fgidx) {
		ConnectionInstanceEnd src = targetConnRef.getSource();
		ConnectionInstanceEnd dst = targetConnRef.getDestination();
		if (doSource) {
			if (target.getName().equalsIgnoreCase(src.getName())) {
				// we point to a component instance, such as a bus or data component in an access connection
				targetConnRef.setSource(target);
			} else if (src instanceof FeatureInstance) {
				// re-resolve the source feature
				ConnectionInstanceEnd found = (ConnectionInstanceEnd) AadlUtil
						.findNamedElementInList(target.getFeatureInstances(), src.getName(), idx);
				if (found == null) {
					Element parent = src.getOwner();
					if (parent instanceof FeatureInstance) {
						found = (ConnectionInstanceEnd) AadlUtil.findNamedElementInList(target.getFeatureInstances(),
								((FeatureInstance) parent).getName(), fgidx);
					}
				}
				if (found != null) {
					targetConnRef.setSource(found);
				}

			}
			// now we need to resolve the upper end (destination)
			if (targetConnRef != outerConnRef) {
				// we need to fix the context of the connection reference
				ConnectionInstanceEnd outerSrc = outerConnRef.getSource();
				targetConnRef.setContext(outerSrc.getComponentInstance());
				// we are not at the top so we fix up the upper end of the connection reference
				if ((dst.getOwner() instanceof ComponentInstance)
						&& dst.getName().equalsIgnoreCase(outerSrc.getName())) {
					targetConnRef.setDestination(outerSrc);
				} else {
					// the outer source points to the enclosing feature group. reresolve the feature in this feature group
					ConnectionInstanceEnd found = (ConnectionInstanceEnd) AadlUtil.findNamedElementInList(
							((FeatureInstance) outerSrc).getFeatureInstances(), dst.getName(), idx);
					if (found == null) {
						Element parent = dst.getOwner();
						if (parent instanceof FeatureInstance) {
							found = (ConnectionInstanceEnd) AadlUtil.findNamedElementInList(
									target.getFeatureInstances(), ((FeatureInstance) parent).getName(), fgidx);
						}
					}
					if (found != null) {
						targetConnRef.setDestination(found);
					}
				}
			}
			return targetConnRef.getSource();
		} else {
			if (target.getName().equalsIgnoreCase(dst.getName())) {
				// we point to a component instance, such as a bus or data component in an access connection
				targetConnRef.setDestination(target);
			} else if (dst instanceof FeatureInstance) {
				// re-resolve the source feature
				ConnectionInstanceEnd found = (ConnectionInstanceEnd) AadlUtil
						.findNamedElementInList(target.getFeatureInstances(), dst.getName(), idx);
				if (found == null) {
					Element parent = dst.getOwner();
					if (parent instanceof FeatureInstance) {
						found = (ConnectionInstanceEnd) AadlUtil.findNamedElementInList(target.getFeatureInstances(),
								((FeatureInstance) parent).getName(), fgidx);
					}
				}
				if (found != null) {
					targetConnRef.setDestination(found);
				}
			}
			// now we need to resolve the upper end (source)
			if ((outerConnRef != null) && (targetConnRef != outerConnRef)) {
				// we need to fix the context of the connection reference
				ConnectionInstanceEnd outerDst = outerConnRef.getDestination();
				targetConnRef.setContext(outerDst.getComponentInstance());
				// we are not at the top so we fix up the upper end of the connection reference
				if ((src.getOwner() instanceof ComponentInstance)
						&& src.getName().equalsIgnoreCase(outerDst.getName())) {
					targetConnRef.setSource(outerDst);
				} else {
					// the outer source points to the enclosing feature group. reresolve the feature in this feature group
					ConnectionInstanceEnd found = (ConnectionInstanceEnd) AadlUtil.findNamedElementInList(
							((FeatureInstance) outerDst).getFeatureInstances(), src.getName(), idx);
					if (found == null) {
						Element parent = src.getOwner();
						if (parent instanceof FeatureInstance) {
							found = (ConnectionInstanceEnd) AadlUtil.findNamedElementInList(
									target.getFeatureInstances(), ((FeatureInstance) parent).getName(), fgidx);
						}
					}
					if (found != null) {
						targetConnRef.setSource(found);
					}
				}
			}
			return targetConnRef.getDestination();
		}
	}

	/**
	 * this method resolves the connection instance from the top connection reference down the source or the destination
	 * @param newconn Connection Instance whose paths need to be resolved
	 * @param topref Connection Reference going across components
	 * @param names sequence of names of the path bottom up
	 * @param dims Dimensions (bottom up) along the path
	 * @param sizes Sizes of each dimension bottom up
	 * @param indices The indices to be used for elements that are arrays
	 * @param doSource Go down the source path or the destination path
	 * @return ConnectionInstanceEnd the ultimate source/destination object (feature instance or component instance)
	 */
	private ConnectionInstanceEnd resolveConnectionInstancePath(ConnectionInstance newconn, ConnectionReference topref,
			List<String> names, List<Integer> dims, List<Integer> sizes, List<Long> indices, boolean doSource) {
		// the connection reference to be resolved
		ConnectionReference targetConnRef = topref;
		ConnectionReference outerConnRef = topref;
		ConnectionInstanceEnd resolutionContext = newconn.getContainingComponentInstance();
		// we have to process the indices backwards since we go top down
		// offset starts with the last element of the indices array
		int offset = indices.size() - 1;
		int count = dims.size() - 1;
		ConnectionInstanceEnd result = null;
		for (int nameidx = names.size() - 1; nameidx >= 0; nameidx--) {
			String name = names.get(nameidx);
			List<InstanceObject> owned = new ArrayList<InstanceObject>();
			int dim = dims.get(count);
			if (resolutionContext instanceof ComponentInstance) {
				// if nextConnRef is null it is because we are going to look up feature instances inside the last component instance
				owned.addAll(((ComponentInstance) resolutionContext).getComponentInstances());
				owned.addAll(((ComponentInstance) resolutionContext).getFeatureInstances());
			} else if (resolutionContext instanceof FeatureInstance) {
				owned.addAll(((FeatureInstance) resolutionContext).getFeatureInstances());
			}

			if (dim == 0) {
				resolutionContext = (ConnectionInstanceEnd) AadlUtil.findNamedElementInList(owned, name);
				// targetConnRef could be null once we are at the end and will resolve the feature name(s)
//				if (targetConnRef != null&& resolutionContext instanceof ComponentInstance){
//					result = resolveConnectionReference(targetConnRef, outerConnRef,(ComponentInstance)resolutionContext, doSource) ;
//				} else {
//					// the resolved feature has been found
//					result = resolutionContext;
//				}
			} else {
				// find the object based on its name and indices
				outer: for (InstanceObject io : owned) {
					if (io.getName().equalsIgnoreCase(name)) {
						try {
							if (io instanceof ComponentInstance) {
								// we need to deal with possibly more than one index
								int d = dim - 1;
								for (long i : ((ComponentInstance) io).getIndices()) {
									if (i != indices.get(offset - d)) {
										continue outer;
									}
									d--;
								}
							} else {
								// we have a feature that may have an index or zero index
								if (((FeatureInstance) io).getIndex() != indices.get(offset)) {
									continue outer;
								}
							}
						} catch (IndexOutOfBoundsException e) {
							errManager.warning(newconn, "Too few indices for connection end, using fist array element");
						}
						resolutionContext = (ConnectionInstanceEnd) io;
						break;
					}
				}
			}
			if (resolutionContext == null) {
				return null;
			}
			// resolve the connref
			if (targetConnRef != null && resolutionContext instanceof ComponentInstance) {
				int dimfeature = dims.get(0);
				int dimfg = 0;
				if (dims.size() > 1) {
					dimfg = dims.get(1);
				}
				result = resolveConnectionReference(targetConnRef, outerConnRef, (ComponentInstance) resolutionContext,
						doSource, dimfeature == 0 ? 0 : indices.get(0),
						dimfg == 0 ? 0 : (dimfeature == 0 ? indices.get(0) : indices.get(1)));
			} else {
				// the resolved feature has been found
				result = resolutionContext;
			}
			if (doSource) {
				if (targetConnRef != null && result instanceof FeatureInstance) {
					targetConnRef.setSource(result);
				}
				outerConnRef = targetConnRef;
				targetConnRef = Aadl2InstanceUtil.getPreviousConnectionReference(newconn, outerConnRef);
			} else {
				if (targetConnRef != null && result instanceof FeatureInstance) {
					targetConnRef.setDestination(result);
				}
				outerConnRef = targetConnRef;
				targetConnRef = Aadl2InstanceUtil.getNextConnectionReference(newconn, outerConnRef);
			}
			// reduce the offset by the processed indices of the element we just looked up
			offset -= dim;
			// reduce the index into the dims array to get the next number of dimensions
			count--;
			// now we need to update the connref pointers
		}
		return result;
	}

	// --------------------------------------------------------------------------------------------
	// Methods related to prototype resolution, wrapped InstanceUtil calls
	// --------------------------------------------------------------------------------------------

	protected InstantiatedClassifier getInstantiatedClassifier(InstanceObject iobj) {
		return getInstantiatedClassifier(iobj, 0, classifierCache);
	}

	protected InstantiatedClassifier getInstantiatedClassifier(InstanceObject iobj, int index,
			HashMap<InstanceObject, InstantiatedClassifier> classifierCache) {
		return InstanceUtil.getInstantiatedClassifier(iobj, index, classifierCache);
	}

	protected ComponentType getComponentType(ComponentInstance ci) {
		return getComponentType(ci, 0, classifierCache);
	}

	protected ComponentType getComponentType(ComponentInstance ci, int index,
			HashMap<InstanceObject, InstantiatedClassifier> classifierCache) {
		return InstanceUtil.getComponentType(ci, index, classifierCache);
	}

	protected ComponentImplementation getComponentImplementation(ComponentInstance ci) {
		return getComponentImplementation(ci, 0, classifierCache);
	}

	protected ComponentImplementation getComponentImplementation(ComponentInstance ci, int index,
			HashMap<InstanceObject, InstantiatedClassifier> classifierCache) {
		return InstanceUtil.getComponentImplementation(ci, index, classifierCache);
	}

	protected FeatureGroupType getFeatureGroupType(FeatureInstance fi) {
		return getFeatureGroupType(fi, 0, classifierCache);
	}

	protected FeatureGroupType getFeatureGroupType(FeatureInstance fi, int index,
			HashMap<InstanceObject, InstantiatedClassifier> classifierCache) {
		return InstanceUtil.getFeatureGroupType(fi, index, classifierCache);
	}

	protected FeaturePrototypeActual resolveFeaturePrototype(ComponentPrototype proto, FeatureInstance fi) {
		return resolveFeaturePrototype(proto, fi, classifierCache);
	}

	protected FeaturePrototypeActual resolveFeaturePrototype(ComponentPrototype proto, FeatureInstance fi,
			HashMap<InstanceObject, InstantiatedClassifier> classifierCache) {
		return InstanceUtil.resolveFeaturePrototype(proto, fi, classifierCache);
	}

	// --------------------------------------------------------------------------------------------
	// Methods related to properties
	// --------------------------------------------------------------------------------------------

	/**
	 * Get all property definitions that are used in the Aadl model. This
	 * includes the predeclared properties and any property definitions in user
	 * declared property sets.
	 *
	 * @param si System Implementation
	 * @return property definitions
	 */
	public EList<Property> getAllUsedPropertyDefinitions(SystemInstance root) throws InterruptedException {
		if (monitor.isCanceled()) {
			throw new InterruptedException();
		}
		EList<Property> result = new UniqueEList<Property>();

		addUsedProperties(root, root.getComponentImplementation(), result);
		TreeIterator<Element> it = EcoreUtil.getAllContents(Collections.singleton(root));
		// collect topdown component impl. do it and its type to find PA
		while (it.hasNext()) {
			Element elem = it.next();

			if (elem instanceof ComponentInstance) {
				InstantiatedClassifier ic = getInstantiatedClassifier((ComponentInstance) elem);
				if (ic != null) {
					if (ic.classifier.equals(root.getComponentImplementation())) {
						addUsedProperties(root, ic.classifier, result, false);
					} else {
						addUsedProperties(root, ic.classifier, result);
					}
				}
			} else if (elem instanceof FeatureInstance) {
				FeatureInstance fi = (FeatureInstance) elem;
				if (fi.getFeature() instanceof FeatureGroup) {
					FeatureGroupType fgt = getFeatureGroupType(fi);
					addUsedProperties(root, fgt, result);
				} else {
					Classifier c = fi.getFeature().getClassifier();
					addUsedProperties(root, c, result);
				}
			} else if (elem instanceof ConnectionInstance) {
				ConnectionInstance ci = (ConnectionInstance) elem;
				addUsedPropertyDefinitions(ci.getContainingClassifier(), result);

				for (ConnectionReference cr : ci.getConnectionReferences()) {
					addUsedPropertyDefinitions(cr.getConnection(), result);
				}
			}
		}
		return result;
	}

	private void addUsedProperties(SystemInstance root, Classifier cc, EList<Property> result) {
		addUsedProperties(root, cc, result, true);
	}

	private void addUsedProperties(SystemInstance root, Classifier cc, EList<Property> result, boolean showError) {

		if (cc instanceof ComponentImplementation) {
			ComponentImplementation impl = (ComponentImplementation) cc;
			List<ComponentImplementation> extendedComponentImpls = new ArrayList<ComponentImplementation>();
			while (impl != null) {
				extendedComponentImpls.add(impl);
				addUsedPropertyDefinitions(impl, result);
				impl = impl.getExtended();
				if (extendedComponentImpls.contains(impl)) {
					if (showError) {
						errManager.error(root, "Circular extension: Component '" + impl.getName()
								+ "' directly or indirectly extends itself.");
					}
					break;
				}
			}
			cc = ((ComponentImplementation) cc).getType();
		}
		List<Classifier> extendedClassifiers = new ArrayList<Classifier>();
		while (cc != null) {
			extendedClassifiers.add(cc);
			addUsedPropertyDefinitions(cc, result);
			cc = cc.getExtended();
			if (extendedClassifiers.contains(cc)) {
				if (showError) {
					errManager.error(root, "Circular extension: Classifier '" + cc.getName()
							+ "' directly or indirectly extends itself.");
				}
				break;
			}
		}

	}

	/**
	 * find all property associations and add its property definition to the
	 * results
	 *
	 * @param root Element whose subtree is being searched
	 * @param result EList holding the used property definitions
	 * @return List holding the used property definitions
	 */
	private void addUsedPropertyDefinitions(Element root, List<Property> result) {
//		OsateDebug.osateDebug ("[InstantiateModel] addUsedPropertyDefinitions=" + root);

		TreeIterator<Element> it = EcoreUtil.getAllContents(Collections.singleton(root));
		while (it.hasNext()) {
			EObject ao = it.next();
			// OsateDebug.osateDebug ("[InstantiateModel] ao=" + ao);

			if (ao instanceof PropertyAssociation) {
				// OsateDebug.osateDebug ("[InstantiateModel] ao=" + ao);

				Property pd = ((PropertyAssociation) ao).getProperty();
				// OsateDebug.osateDebug ("[InstantiateModel] pd=" + pd);

				if (pd != null) {
//					OsateDebug.osateDebug ("[InstanceModel] AddUsedProperty " + pd + " to " + root);
					result.add(pd);
				}
			}
		}
	}

	// --------------------------------------------------------------------------------------------
	// Methods related to system operation modes
	// --------------------------------------------------------------------------------------------

	/*
	 * Processing switch that gathers up all the component instances that have
	 * modes.
	 */
	private static final class ModeSearch extends ForAllElement {
		public boolean hasModalComponents = false;

		@Override
		protected void action(final Element o) {
			final List<ModeInstance> modes = ((ComponentInstance) o).getModeInstances();
			if (!modes.isEmpty() && !modes.get(0).isDerived()) {
				hasModalComponents = true;
				resultList.add(o);
			}
		}
	}

	/*
	 * Create the system operation mode objects for the instance model.
	 */
	protected void createSystemOperationModes(SystemInstance root) throws InterruptedException {
		/*
		 * Get an prefix list of all the components in the system. This way we
		 * can easily test if the component exists in the SOM being built.
		 */
		final ModeSearch modeSearch = new ModeSearch();
		final List<Element> allInstances = modeSearch.processPreOrderComponentInstance(root);
		if (modeSearch.hasModalComponents) {
			final ComponentInstance[] instances = allInstances.toArray(new ComponentInstance[0]);
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
	protected void enumerateSystemOperationModes(final SystemInstance root, final ComponentInstance[] instances)
			throws InterruptedException {
		final LinkedList<ComponentInstance> skipped = new LinkedList<ComponentInstance>();
		final List<ModeInstance> currentModes = new ArrayList<ModeInstance>();
		final EList<ModeInstance> modes = instances[0].getModeInstances();

		if (!modes.isEmpty()) {
			for (ModeInstance mi : modes) {
				if (monitor.isCanceled()) {
					throw new InterruptedException();
				}
				if (!mi.isDerived()) {
					List<ModeInstance> nextModes = new ArrayList<ModeInstance>(currentModes);

					nextModes.add(mi);
					for (ComponentInstance child : instances[0].getComponentInstances()) {
						for (ModeInstance childMode : child.getModeInstances()) {
							if (monitor.isCanceled()) {
								throw new InterruptedException();
							}
							if (childMode.isDerived() && childMode.getParents().contains(mi)) {
								nextModes.add(childMode);
							}
						}
					}
					enumerateSystemOperationModes(root, instances, 1, skipped, nextModes);
				}
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
	protected void enumerateSystemOperationModes(SystemInstance root, ComponentInstance[] instances,
			int currentInstance, LinkedList<ComponentInstance> skipped, List<ModeInstance> modeState)
			throws InterruptedException {
		if (monitor.isCanceled()) {
			throw new InterruptedException();
		}
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
			ComponentInstance ci = instances[currentInstance];

			if (!skipped.contains(ci.eContainer()) && existsGiven(modeState, ci.getInModes())) {
				EList<ModeInstance> modes = ci.getModeInstances();

				if (modes != null && modes.size() > 0) {
					// Modal component
					for (ModeInstance mi : modes) {
						if (monitor.isCanceled()) {
							throw new InterruptedException();
						}
						List<ModeInstance> nextModes = new ArrayList<ModeInstance>(modeState);

						nextModes.add(mi);
						for (ComponentInstance child : ci.getComponentInstances()) {
							for (ModeInstance childMode : child.getModeInstances()) {
								if (monitor.isCanceled()) {
									throw new InterruptedException();
								}
								if (childMode.isDerived() && childMode.getParents().contains(mi)) {
									nextModes.add(childMode);
								}
							}
						}
						enumerateSystemOperationModes(root, instances, currentInstance + 1, skipped, nextModes);
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

	private boolean existsGiven(final List<ModeInstance> modeState, final List<ModeInstance> inModes)
			throws InterruptedException {
		if (inModes != null && inModes.size() > 0) {
			for (ModeInstance mi : inModes) {
				if (monitor.isCanceled()) {
					throw new InterruptedException();
				}
				if (modeState.contains(mi)) {
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
	private SystemOperationMode createSOM(final List<ModeInstance> modeInstances) throws InterruptedException {
		final SystemOperationMode som;

		som = InstanceFactory.eINSTANCE.createSystemOperationMode();
		for (ModeInstance mi : modeInstances) {
			if (monitor.isCanceled()) {
				throw new InterruptedException();
			}
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
