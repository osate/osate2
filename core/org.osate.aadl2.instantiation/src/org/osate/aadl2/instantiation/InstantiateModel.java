/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.aadl2.instantiation;

import static org.osate.aadl2.modelsupport.util.AadlUtil.getElementCount;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RollbackException;
import org.osate.aadl2.AbstractFeature;
import org.osate.aadl2.Access;
import org.osate.aadl2.AccessSpecification;
import org.osate.aadl2.AccessType;
import org.osate.aadl2.ArrayDimension;
import org.osate.aadl2.ArraySize;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentCategory;
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
import org.osate.aadl2.FeatureClassifier;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupType;
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
import org.osate.aadl2.PortSpecification;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.Prototype;
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
import org.osate.aadl2.modelsupport.FileNameConstants;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.MarkerAnalysisErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter;
import org.osate.aadl2.modelsupport.modeltraversal.TraverseWorkspace;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.util.Aadl2InstanceUtil;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.core.OsateCorePlugin;
import org.osgi.service.prefs.Preferences;

import com.google.common.base.Strings;

/**
 * This class implements the instantiation of an instance model from a root component implementation:
 * the component hierarchy with its features, modes and flow specifications, the system operation
 * modes, and the phases that turn the hierarchy into a complete instance model, which are the
 * connection instances, the end to end flows, the cached properties and the annex instances.
 * <p>
 * One instantiator serves one instantiation at a time. The classifier cache, the mode to SOM map and
 * the list of instance model roots are all per instantiation, so an instance of this class must not be
 * shared between concurrent instantiations.
 *
 * @author phf
 */
public class InstantiateModel {
	// Project properties that are set via a PropertyPage
	public static final String PREFS_QUALIFIER = "org.osate.aadl2.instantiation";
	public static final String PREF_SOM_LIMIT = "org.osate.aadl2.instantiation.som_limit";
	public static final String PREF_SOM_USE_WORKSPACE = "org.osate.aadl2.instantiation.som_use_workspace";

	/* The name for the single mode of a non-modal system */
	public static final String NORMAL_SOM_NAME = "No Modes";

	/* The properties that determine how a connection is expanded into connection instances */
	private static final String COMMUNICATION_PROPERTIES = "Communication_Properties";
	private static final String CONNECTION_PATTERN = "Connection_Pattern";
	private static final String CONNECTION_SET = "Connection_Set";

	protected AnalysisErrorReporterManager errManager;
	protected final IProgressMonitor monitor;

	/**
	 * A classifier for an instance object when it is a prototype in the
	 * declarative model. The classifier is the result of resolving the
	 * prototype. It's either the classifier that is instantiated as a
	 * subcomponent or feature group instance or the classifier referenced by a
	 * feature or subprogram call. If the classifier is anonymous, then its
	 * bindings are included also.
	 */
	protected HashMap<InstanceObject, InstantiatedClassifier> classifierCache;

	protected SCProperties scProps = new SCProperties();
	/**
	 * Maps mode instances to SOMs that contain this mode instance
	 */
	protected HashMap<ModeInstance, List<SystemOperationMode>> mode2som;

	/**
	 * The roots of the instance model in the order they were discovered. The first one is the system
	 * instance, the others are the instances of referenced classifiers created by
	 * {@link #instantiateFeatureClassifier(FeatureInstance, FeatureClassifier)}, which is the only place
	 * that adds a root to the instance resource. All of them go through the same phases, see
	 * {@link #fillSystemInstance(SystemInstance)}.
	 * <p>
	 * The list is emptied at the start of every {@link #fillSystemInstance(SystemInstance)} call. It has
	 * to be a field rather than a local because
	 * {@link #instantiateFeatureClassifier(FeatureInstance, FeatureClassifier)} appends to it from deep
	 * inside the recursion. That, and the classifier cache, is why one {@code InstantiateModel} must not
	 * be used for more than one instantiation at a time.
	 */
	private final List<InstantiationRoot> roots = new ArrayList<>();

	/**
	 * A root of the instance model, and whether it still has to be brought to its final connections. A
	 * root is populated as soon as it is discovered, because that is what discovers further roots, but
	 * the remaining phases run from the queue, and the flag keeps a root that is discovered late from
	 * being processed twice. Which roots still need their annexes is tracked by the index into
	 * {@link #roots} in {@link #fillSystemInstance(SystemInstance)}.
	 */
	private static final class InstantiationRoot {
		private final ComponentInstance root;
		private boolean connectionsFinalized;

		private InstantiationRoot(ComponentInstance root) {
			this.root = root;
		}
	}

	// Constructors

	/**
	 * Create an instantiator that reports to the workspace markers of the instance model file.
	 *
	 * @param pm the progress monitor
	 */
	public InstantiateModel(final IProgressMonitor pm) {
		classifierCache = new HashMap<>();
		mode2som = new HashMap<>();
		errManager = new AnalysisErrorReporterManager(
				new MarkerAnalysisErrorReporter.Factory(AadlConstants.INSTANTIATION_OBJECT_MARKER));
		monitor = pm;
	}

	/**
	 * Create an instantiator that reports to the given error manager.
	 *
	 * @param pm the progress monitor
	 * @param errMgr the error manager to report to
	 */
	public InstantiateModel(final IProgressMonitor pm, final AnalysisErrorReporterManager errMgr) {
		classifierCache = new HashMap<>();
		mode2som = new HashMap<>();
		errManager = errMgr;
		monitor = pm;
	}

	/**
	 * Stop the current instantiation if the user canceled it.
	 *
	 * @throws InterruptedException if the progress monitor reports cancellation
	 */
	private void checkCanceled() throws InterruptedException {
		if (monitor.isCanceled()) {
			throw new InterruptedException();
		}
	}

	// Methods
	/**
	 * Construct an instance model, save it on disk and return its root object. The instance model is
	 * created in a resource set of its own that also holds the component implementation.
	 *
	 * @param ci the component implementation to instantiate
	 * @param monitor the progress monitor
	 * @return the system instance
	 */
	public static SystemInstance buildInstanceModelFile(final ComponentImplementation ci, IProgressMonitor monitor)
			throws Exception {
		// add it to a resource; otherwise we cannot attach error messages to
		// the instance file
		URI instanceURI = getInstanceModelURI(ci);
		IFile file = OsateResourceUtil.toIFile(instanceURI);
		if (file != null && file.isAccessible()) {
			file.deleteMarkers(null, true, IResource.DEPTH_INFINITE);
		}
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource aadlResource = resourceSet.createResource(instanceURI);
		aadlResource.save(null);
		aadlResource.unload();

		// now instantiate the rest of the model
		final InstantiateModel instantiateModel = new InstantiateModel(monitor, new AnalysisErrorReporterManager(
				new MarkerAnalysisErrorReporter.Factory(AadlConstants.INSTANTIATION_OBJECT_MARKER)));
		return instantiateModel.createSystemInstance(
				(ComponentImplementation) resourceSet.getEObject(EcoreUtil.getURI(ci), true), aadlResource);
	}

	public static SystemInstance buildInstanceModelFile(ComponentImplementation ci) throws Exception {
		return buildInstanceModelFile(ci, new NullProgressMonitor());
	}

	public static SystemInstance instantiate(ComponentImplementation ci, AnalysisErrorReporterManager errorManager,
			IProgressMonitor monitor) throws Exception {
		URI instanceURI = getInstanceModelURI(ci);
		ResourceSet resourceSet = ci.eResource().getResourceSet();
		Resource aadlResource = resourceSet.createResource(instanceURI);

		// now instantiate the rest of the model
		final InstantiateModel instantiateModel = new InstantiateModel(monitor, errorManager);
		return instantiateModel.createSystemInstanceInt(ci, aadlResource, false);
	}

	/**
	 * Instantiate a component implementation. The instance model is created in the resource set
	 * containing the component implementation.
	 *
	 * @param ci The component implementation to instantiate.
	 * @param errorManager The error manager to use. Ignore errors if this is null.
	 * @return The root of the instance model.
	 * @throws Exception if something goes wrong.
	 */
	public static SystemInstance instantiate(ComponentImplementation ci, AnalysisErrorReporterManager errorManager)
			throws Exception {
		return instantiate(ci, errorManager != null ? errorManager : AnalysisErrorReporterManager.NULL_ERROR_MANANGER,
				new NullProgressMonitor());
	}

	/**
	 * Instantiate a component implementation without reporting errors.
	 * The instance model is created in the resource set
	 * containing the component implementation.
	 *
	 * @param ci The component implementation to instantiate.
	 * @return The root of the instance model.
	 * @throws Exception if something goes wrong.
	 */
	public static SystemInstance instantiate(ComponentImplementation ci) throws Exception {
		return instantiate(ci, AnalysisErrorReporterManager.NULL_ERROR_MANANGER);
	}

	/**
	 * Construct an instance model from an existing instance model file, save it on disk and return its
	 * root object.
	 *
	 * @param ires the instance model file to rebuild
	 * @return the system instance
	 */
	public static SystemInstance rebuildInstanceModelFile(final IResource ires) throws Exception {
		return rebuildInstanceModelFile(ires, new NullProgressMonitor());
	}

	/**
	 * This method will construct an instance model, save it on disk and return
	 * its root object The method will make sure the declarative models are up
	 * to date.
	 *
	 * @param ires the instance model file to rebuild
	 * @param monitor the progress monitor
	 * @return the system instance
	 * @since 1.1
	 */
	public static SystemInstance rebuildInstanceModelFile(final IResource ires, final IProgressMonitor monitor)
			throws Exception {
		ires.deleteMarkers(null, true, IResource.DEPTH_INFINITE);
		ResourceSet rset = new ResourceSetImpl();
		Resource res = rset.getResource(OsateResourceUtil.toResourceURI(ires), true);
		SystemInstance target = (SystemInstance) res.getContents().get(0);
		ComponentImplementation ci = target.getComponentImplementation();
		URI uri = EcoreUtil.getURI(ci);
		res.getContents().clear();
		res.save(null);
		res.unload();
		ci = (ComponentImplementation) rset.getEObject(uri, true);
		if (ci == null) {
			// The root component instance doesn't exist anymore
			throw new RootMissingException();
		}
		final InstantiateModel instantiateModel = new InstantiateModel(monitor, new AnalysisErrorReporterManager(
				new MarkerAnalysisErrorReporter.Factory(AadlConstants.INSTANTIATION_OBJECT_MARKER)));
		return instantiateModel.createSystemInstance(ci, res);
	}

	/*
	 * This method will regenerate all instance models in the workspace
	 */
	public static void rebuildAllInstanceModelFiles(final IProgressMonitor monitor) throws Exception {
		HashSet<IFile> files = TraverseWorkspace.getInstanceModelFilesInWorkspace();
		List<URI> instanceRoots = new ArrayList<>();
		List<IResource> instanceIResources = new ArrayList<>();
		ResourceSet rset = new ResourceSetImpl();
		for (IFile iFile : files) {
			IResource ires = iFile;
			ires.deleteMarkers(null, true, IResource.DEPTH_INFINITE);
			Resource res = rset.getResource(OsateResourceUtil.toResourceURI(ires), true);
			SystemInstance target = (SystemInstance) res.getContents().get(0);
			ComponentImplementation ci = target.getComponentImplementation();
			URI uri = EcoreUtil.getURI(ci);
			instanceRoots.add(uri);
			instanceIResources.add(ires);
			res.getContents().clear();
			res.save(null);
			res.unload();
		}
		for (int i = 0; i < instanceRoots.size(); i++) {
			ComponentImplementation ci = (ComponentImplementation) rset.getEObject(instanceRoots.get(i), true);
			monitor.subTask("Reinstantiating " + ci.getName());
			final InstantiateModel instantiateModel = new InstantiateModel(new NullProgressMonitor(),
					new AnalysisErrorReporterManager(
							new MarkerAnalysisErrorReporter.Factory(AadlConstants.INSTANTIATION_OBJECT_MARKER)));
			Resource res = rset.getResource(OsateResourceUtil.toResourceURI(instanceIResources.get(i)), true);
			instantiateModel.createSystemInstance(ci, res);
		}
	}

	/**
	 * Create a system instance in the provided (empty) resource and save it.
	 *
	 * @param ci the component implementation to instantiate
	 * @param aadlResource the resource to create the instance model in
	 * @return the system instance
	 * @throws Exception if instantiation is canceled, which is an {@link InterruptedException}, or the
	 *             resource cannot be saved
	 */
	public SystemInstance createSystemInstance(final ComponentImplementation ci, final Resource aadlResource)
			throws Exception {
		SystemInstance result = createSystemInstanceInt(ci, aadlResource, true);

		checkCanceled();

		// We're done: Save the model.
		// We don't respond to a cancel at this point
		monitor.subTask("Saving instance model");
		aadlResource.save(null);

		return result;
	}

	/**
	 * Instantiate a component implementation as the root of an instance tree.
	 *
	 * @param ci the component implementation to instantiate
	 * @param aadlResource the resource to store the instance model in
	 * @param save whether to save the resource before filling in the instance model
	 * @return the system instance
	 * @throws InterruptedException if instantiation is canceled
	 * @throws UncheckedIOException if the initial instance model cannot be saved
	 */
	public SystemInstance createSystemInstanceInt(ComponentImplementation ci, Resource aadlResource, boolean save)
			throws InterruptedException {
		SystemInstance root = InstanceFactory.eINSTANCE.createSystemInstance();
		final String instanceName = ci.getTypeName() + "_" + ci.getImplementationName()
				+ FileNameConstants.INSTANCE_MODEL_POSTFIX;

		root.setComponentImplementation(ci);
		root.setClassifier(ci);
		root.setName(instanceName);
		root.setCategory(ci.getCategory());
		aadlResource.getContents().add(root);
		// Needed to save the root object because we may attach warnings to the
		// IResource as we build it.
		var origErrManager = errManager;
		try {
			if (save) {
				aadlResource.save(null);
			}
			// collect errors in list and transfer to original error manager later
			// property associations can be added with an error but could then be removed
			// see issue #2929
			errManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory);
			fillSystemInstance(root);
			var errors = ((QueuingAnalysisErrorReporter) errManager.getReporter(aadlResource)).getErrors();
			// the finally block restores errManager, the messages below go to the original one
			errManager = origErrManager;
			for (var msg : errors) {
				if (msg.where.eResource() != null) {
					// keep only errors referring to elements that are still in the instance model
					switch (msg.kind) {
					case QueuingAnalysisErrorReporter.ERROR -> errManager.error(msg.where, msg.message, msg.attributes,
							msg.values);
					case QueuingAnalysisErrorReporter.WARNING -> errManager.warning(msg.where, msg.message,
							msg.attributes, msg.values);
					case QueuingAnalysisErrorReporter.INFO -> errManager.info(msg.where, msg.message, msg.attributes,
							msg.values);
					default -> {
						// a message of any other kind is dropped, as it was before
					}
					}
				}
			}
		} catch (IOException e) {
			throw new UncheckedIOException("Exception while saving the initial instance model", e);
		} finally {
			errManager = origErrManager;
		}
		return root;
	}

	/**
	 * Fill in the instance model under a system instance, but do not save it.
	 *
	 * @param root the system instance to fill in
	 * @throws InterruptedException if instantiation is canceled
	 */
	public void fillSystemInstance(SystemInstance root) throws InterruptedException {
		roots.clear();
		// enqueue before populating, so that referenced classifier roots are discovered behind this one
		roots.add(new InstantiationRoot(root));
		populateComponentInstance(root, 0);

		monitor.subTask("Creating system operation modes");
		URI resourceURI = root.eResource().getURI();
		final int somLimit;
		if (resourceURI.isPlatformResource()) {
			somLimit = getSOMLimit(OsateResourceUtil.toIFile(resourceURI).getProject());
		} else {
			somLimit = OsateCorePlugin.MAX_SOM_DEFAULT;
		}
		createSystemOperationModes(root, somLimit);

		/*
		 * Bring every root to its final connections and cached properties before any annex is
		 * instantiated. Otherwise an annex on one root could observe another root whose connections are
		 * still the provisional ones created before expansion. The queue can grow while we work on it, so
		 * use indexed access and re-establish the barrier if annex instantiation discovers another root.
		 */
		AnnexInstantiationController aic = new AnnexInstantiationController(errManager);
		int annexed = 0;
		while (annexed < roots.size()) {
			for (int i = 0; i < roots.size(); i++) {
				finalizeConnections(roots.get(i));
			}
			final int fixedPoint = roots.size();
			monitor.subTask("Instantiating annexes");
			while (annexed < fixedPoint) {
				aic.instantiateAllAnnexes(roots.get(annexed++).root);
				checkCanceled();
			}
		}
	}

	/**
	 * Create the connection instances of a root, expand them into the final connection set, then
	 * validate the result, build the end to end flows over it, and cache the properties on it.
	 * <p>
	 * The expansion of arrays, {@code Connection_Pattern} and {@code Connection_Set} replaces the
	 * provisional connection instances and deletes them. It has to happen before validation and before
	 * end to end flow creation, because a flow refers to connection instances without containing them
	 * and would silently lose a deleted one.
	 * <p>
	 * Does nothing if the root already went through this phase.
	 */
	private void finalizeConnections(InstantiationRoot pending) throws InterruptedException {
		if (pending.connectionsFinalized) {
			return;
		}
		pending.connectionsFinalized = true;
		final ComponentInstance root = pending.root;

		new CreateConnectionsSwitch(monitor, errManager, classifierCache).processPreOrderAll(root);
		checkCanceled();

		/*
		 * The expansion needs Connection_Pattern and Connection_Set on the provisional connections, but
		 * the remaining properties have to be cached on the final connections. Split the used property
		 * definitions and run the same caching mechanism twice, so that the values the expansion sees are
		 * the ones full property caching would have produced for them.
		 */
		final EList<Property> usedProperties = getAllUsedPropertyDefinitions(root);
		final List<Property> structuralProperties = new ArrayList<>();
		final List<Property> remainingProperties = new ArrayList<>();
		for (Property property : usedProperties) {
			if (isStructuralConnectionProperty(property)) {
				structuralProperties.add(property);
			} else {
				remainingProperties.add(property);
			}
		}

		cacheStructuralConnectionProperties(root, structuralProperties);
		// handle arrays, connection patterns, and connection sets
		processConnections(root);
		checkCanceled();

		final ValidateConnectionsSwitch vcs = new ValidateConnectionsSwitch(monitor, errManager, classifierCache);
		vcs.processPreOrderAll(root);
		vcs.postProcess();
		checkCanceled();

		new CreateEndToEndFlowsSwitch(monitor, errManager, classifierCache).processPreOrderAll(root);
		checkCanceled();

		cacheProperties(root, remainingProperties);
	}

	/**
	 * The URI of the instance model file of a component implementation.
	 *
	 * @param ci the component implementation
	 * @return the URI of its instance model file
	 */
	public static URI getInstanceModelURI(ComponentImplementation ci) {
		Resource res = ci.eResource();
		URI modeluri = res.getURI();
		String last = modeluri.lastSegment();
		String filename = last.substring(0, last.indexOf('.'));
		URI path = modeluri.trimSegments(1);
		URI instanceURI = path.appendSegment(FileNameConstants.AADL_INSTANCES_DIR)
				.appendSegment(filename + "_" + ci.getTypeName() + "_" + ci.getImplementationName()
						+ FileNameConstants.INSTANCE_MODEL_POSTFIX);
		instanceURI = instanceURI.appendFileExtension(FileNameConstants.INSTANCE_FILE_EXT);
		return instanceURI;
	}

	/**
	 * @since 3.0
	 */
	protected void cacheProperties(ComponentInstance root) throws InterruptedException {
		// we could also use getAllPropertyDefinition(as), which returns all declared property definitions
		// retrieving that set is faster, but it may contain property definitions that are not used;
		// this in that case the caching of those properties would be slower
		cacheProperties(root, getAllUsedPropertyDefinitions(root));
	}

	private void cacheProperties(ComponentInstance root, List<Property> propertyDefinitionList)
			throws InterruptedException {
		/*
		 * We now cache the property associations. First we cache the contained
		 * property associations. In a second pass we cache regular property
		 * associations and evaluate all properties.
		 */
		CacheContainedPropertyAssociationsSwitch ccpas = new CacheContainedPropertyAssociationsSwitch(classifierCache,
				scProps, monitor, errManager);
		ccpas.processPostOrderAll(root);
		checkCanceled();

		final CachePropertyAssociationsSwitch cpas = new CachePropertyAssociationsSwitch(monitor, errManager,
				propertyDefinitionList, classifierCache, scProps, mode2som);
		cpas.processPreOrderAll(root);
		checkCanceled();
	}

	/**
	 * Cache {@code Connection_Pattern} and {@code Connection_Set} on the provisional connection
	 * instances of a root. {@link #processConnections(ComponentInstance)} reads them from there to
	 * expand the connections into the final connection set.
	 * <p>
	 * This uses the same two switches and the same lookup contexts as full property caching, restricted
	 * to those two property definitions, so the resolved values are the ones full property caching would
	 * have produced. The contained associations go into a separate cache because the one used by full
	 * caching must not hold associations recorded for connection instances that the expansion deletes.
	 */
	private void cacheStructuralConnectionProperties(ComponentInstance root, List<Property> structuralProperties)
			throws InterruptedException {
		if (structuralProperties.isEmpty()) {
			return;
		}
		SCProperties structuralScProps = new SCProperties();
		new CacheContainedPropertyAssociationsSwitch(classifierCache, structuralScProps, monitor, errManager,
				structuralProperties).processPostOrderAll(root);
		checkCanceled();

		new CachePropertyAssociationsSwitch(monitor, errManager, structuralProperties, classifierCache,
				structuralScProps, mode2som).processPreOrderAll(root);
		checkCanceled();
	}

	/**
	 * Is this one of the properties that determine how many connection instances a connection expands
	 * into? Uses the same test as {@link #getPA(ConnectionInstance, String)}, which is what reads the
	 * cached values.
	 */
	private static boolean isStructuralConnectionProperty(Property property) {
		return (CONNECTION_PATTERN.equalsIgnoreCase(property.getName())
				|| CONNECTION_SET.equalsIgnoreCase(property.getName()))
				&& property.getOwner() instanceof PropertySet ps
				&& COMMUNICATION_PROPERTIES.equalsIgnoreCase(ps.getName());
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
		 * Add modes. Must do this before adding subcomponents
		 * because we need to know what are the ModeInstances when processing
		 * modal subcomponents.
		 */
		if (impl != null) {
			fillModes(ci, impl.getAllModes());
		} else if (type != null) {
			fillModes(ci, type.getAllModes());
		}
		if (impl != null) {
			// Recursively add subcomponents
			instantiateSubcomponents(ci, impl);

			// TODO subprogram calls are not instantiated
		}

		// do it only if subcomponent has type
		if (type != null) {
			instantiateFeatures(ci);
		}
		/*
		 * Add mode transitions. Must do this after adding subcomponents
		 * because we need reference subcomponent features as triggers.
		 */
		if (impl != null) {
			fillModeTransitions(ci, impl.getAllModeTransitions());
		} else if (type != null) {
			fillModeTransitions(ci, type.getAllModeTransitions());
		}
		if (type != null) {
			instantiateFlowSpecs(ci);
		}
	}

	private void fillModes(ComponentInstance ci, List<Mode> modes) throws InterruptedException {
		for (Mode m : modes) {
			checkCanceled();
			ModeInstance mi = InstanceFactory.eINSTANCE.createModeInstance();
			/*
			 * Used to add the mode instance to the component instance at the end of the loop,
			 * but moved it here so that we can report errors on it.
			 */
			ci.getModeInstances().add(mi);

			mi.setMode(m);
			mi.setName(m.getName());
			mi.setInitial(m.isInitial());
			/*
			 * If ci is the root object, ignore derived. This means that we are instantiating an implementation that
			 * contains derived modes. In this case, treat the derived modes as normal modes since there is no
			 * containing component to provide a parent mode.
			 */
			if (m.isDerived() && !(ci instanceof SystemInstance)) {
				mi.setDerived(true);
				Subcomponent sub = ci.getSubcomponent();
				ComponentInstance parentci = ci.getContainingComponentInstance();

				final EList<ModeBinding> ownedModeBindings = sub.getOwnedModeBindings();
				if (ownedModeBindings == null || ownedModeBindings.isEmpty()) {
					// Implicit mode map, must find modes of the same name in the containing component
					parentci.getModeInstances()
							.stream()
							.filter(pmi -> pmi.getName().equalsIgnoreCase(m.getName()))
							.findFirst()
							.ifPresentOrElse(mi.getParents()::add, () -> errManager.error(mi,
									"Required mode '" + m.getName() + "' not found in containing component"));
				} else {
					for (ModeBinding mb : ownedModeBindings) {
						checkCanceled();
						if (mb.getDerivedMode() == m || mb.getDerivedMode() == null
								&& mb.getParentMode().getName().equalsIgnoreCase(m.getName())) {
							mi.getParents().add(parentci.findModeInstance(mb.getParentMode()));
						}
					}
				}
			}
		}
	}

	/**
	 * Add a mode transition instance for every mode transition, with its triggers resolved.
	 *
	 * @param ci the component instance to add the mode transition instances to
	 * @param transitions the mode transitions of its classifier
	 * @throws InterruptedException if instantiation is canceled
	 */
	protected void fillModeTransitions(ComponentInstance ci, List<ModeTransition> transitions)
			throws InterruptedException {
		for (ModeTransition mt : transitions) {
			checkCanceled();
			ModeTransitionInstance mti = InstanceFactory.eINSTANCE.createModeTransitionInstance();
			Mode srcmode = mt.getSource();
			Mode dstmode = mt.getDestination();
			ModeInstance srcI = ci.findModeInstance(srcmode);
			ModeInstance dstI = ci.findModeInstance(dstmode);

			mti.setSource(srcI);
			mti.setDestination(dstI);
			mti.setModeTransition(mt);
			List<ModeTransitionTrigger> triggers = mt.getOwnedTriggers();

			if (!Strings.isNullOrEmpty(mt.getName())) {
				mti.setName(mt.getName());
			} else {
				String eventName = "";

				if (!triggers.isEmpty()) {
					TriggerPort tp = triggers.get(0).getTriggerPort();

					if (tp instanceof Port && triggers.get(0).getContext() instanceof Subcomponent subcomponent) {
						eventName = subcomponent.getName() + "_";
					}
					eventName += tp.getName();
				}
				mti.setName(
						srcmode.getName() + "_" + (!eventName.equals("") ? eventName + "_" : "") + dstmode.getName());
			}

			// add only triggers that are ports
			for (ModeTransitionTrigger t : triggers) {
				TriggerPort tp = t.getTriggerPort();

				if (tp instanceof Port port) {
					FeatureInstance porti = null;
					Context ctx = t.getContext();

					if (ctx instanceof Subcomponent subcomponent) {
						ComponentInstance subi = ci.findSubcomponentInstance(subcomponent);
						porti = subi.findFeatureInstance(port);
					} else if (ctx instanceof FeatureGroup featureGroup) {
						FeatureInstance fgi = ci.findFeatureInstance(featureGroup);
						porti = fgi.findFeatureInstance(port);
					} else if (ctx == null) {
						porti = ci.findFeatureInstance(port);
					}
					if (porti != null) {
						mti.getTriggers().add(porti);
					}
				}
			}
			ci.getModeTransitionInstances().add(mti);
		}
	}

	/**
	 * Add a component instance for every subcomponent, one per array element for a subcomponent that is
	 * an array.
	 *
	 * @param ci the component instance to add the subcomponent instances to
	 * @param impl the implementation the subcomponents are declared in
	 * @throws InterruptedException if instantiation is canceled
	 */
	protected void instantiateSubcomponents(final ComponentInstance ci, ComponentImplementation impl)
			throws InterruptedException {
		for (final Subcomponent sub : impl.getAllSubcomponents()) {
			checkCanceled();
			if (hasSubcomponentInstance(ci, sub)) {
				errManager.error(ci, "Cyclic containment dependency: Subcomponent '" + sub.getName()
						+ "' has already been instantiated as enclosing component.");
			} else {
				final EList<ArrayDimension> dims = sub.getArrayDimensions();
				List<Long> indexStack = new ArrayList<>();

				if (dims.isEmpty()) {
					instantiateSubcomponent(ci, sub, sub, indexStack, 0);
				} else {
					final int dimensions = dims.size();
					class ArrayInstantiator {
						void process(int dim, List<Long> indexStack) throws InterruptedException {
							// index starts with one
							ArraySize arraySize = dims.get(dim).getSize();
							long count = getElementCount(arraySize, ci);

							for (int i = 1; i <= count; i++) {
								checkCanceled();
								if (dim + 1 < dimensions) {
									indexStack.add(Long.valueOf(i));
									process(dim + 1, indexStack);
									indexStack.removeLast();
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

	protected String indexStackToString(List<Long> indexStack) {
		String result = "";
		for (int i = 0; i < indexStack.size(); i++) {
			result = result + "_" + indexStack.get(i);
		}
		return result;
	}

	protected void instantiateSubcomponent(final ComponentInstance parent, final ModalElement mm,
			final Subcomponent sub, List<Long> indexStack, int index) throws InterruptedException {
		final ComponentInstance newInstance = InstanceFactory.eINSTANCE.createComponentInstance();
		final ComponentClassifier cc;
		final InstantiatedClassifier ic;

		newInstance.setSubcomponent(sub);
		// Issue 961: Set the category for real later (below); set it here now in case something goes wrong
		newInstance.setCategory(sub.getCategory());
		newInstance.setName(sub.getName());
		newInstance.getIndices().addAll(indexStack);
		newInstance.getIndices().add(Long.valueOf(index));
		parent.getComponentInstances().add(newInstance);
		ic = getInstantiatedClassifier(newInstance);
		if (ic == null) {
			cc = null;
		} else {
			cc = (ComponentClassifier) ic.getClassifier();
		}
		if (cc == null) {
			errManager.warning(newInstance, "Instantiated subcomponent doesn't have a component classifier");
		} else {
			newInstance.setClassifier(cc);

			/*
			 * From Issue 961:
			 *
			 * I think the category can be determined as follows:
			 *
			 * If the classifier is not abstract then use its category (and maybe check that the subcomponent either has the same category or is abstract).
			 * If the classifier is abstract then use the category from the subcomponent.
			 *
			 * Only if both are abstract the component instance should be abstract.
			 * If both are not abstract then they must have the same category. If the categories are different, validation should already have reported an
			 * error, and we don't instantiate models with errors. It can't hurt if the instantiator checks again, though.
			 */
			final ComponentCategory classifierCategory = cc.getCategory();
			final ComponentCategory subcomponentCategory = sub.getCategory();
			if (classifierCategory != ComponentCategory.ABSTRACT) {
				newInstance.setCategory(cc.getCategory());
				if (subcomponentCategory != ComponentCategory.ABSTRACT && subcomponentCategory != classifierCategory) {
					errManager.warning(newInstance,
							"Subcomponent's category and its classifier's category do not match");
				}
			} else {
				newInstance.setCategory(subcomponentCategory);
			}
		}

		for (Mode mode : mm.getAllInModes()) {
			checkCanceled();
			ModeInstance mi = parent.findModeInstance(mode);

			if (mi != null) {
				newInstance.getInModes().add(mi);
			}
		}
		populateComponentInstance(newInstance, index);
	}

	/**
	 * Add a flow specification instance for every flow specification of the component type.
	 * <p>
	 * {@code CreateEndToEndFlowsSwitch} has a method of its own for this, which adds flow specification
	 * instances on demand while an end to end flow is created.
	 *
	 * @param ci the component instance to add the flow specification instances to
	 * @throws InterruptedException if instantiation is canceled
	 */
	private void instantiateFlowSpecs(ComponentInstance ci) throws InterruptedException {
		for (FlowSpecification spec : getComponentType(ci).getAllFlowSpecifications()) {
			checkCanceled();
			FlowSpecificationInstance speci = ci.createFlowSpecification();
			speci.setName(spec.getName());
			speci.setFlowSpecification(spec);
			FlowEnd inend = spec.getAllInEnd();
			if (inend != null) {
				FeatureInstance fi = findFeatureInstance(ci, inend);
				if (fi != null) {
					speci.setSource(fi);
				}
			}
			FlowEnd outend = spec.getAllOutEnd();
			if (outend != null) {
				FeatureInstance fi = findFeatureInstance(ci, outend);
				if (fi != null) {
					speci.setDestination(fi);
				}
			}
			for (Mode mode : spec.getAllInModes()) {
				checkCanceled();
				ModeInstance mi = ci.findModeInstance(mode);
				if (mi != null) {
					speci.getInModes().add(mi);
				}
			}

			for (ModeTransition mt : spec.getInModeTransitions()) {
				checkCanceled();
				ModeTransitionInstance ti = ci.findModeTransitionInstance(mt);

				if (ti != null) {
					speci.getInModeTransitions().add(ti);
				}
			}
		}
	}

	private FeatureInstance findFeatureInstance(ComponentInstance ci, FlowEnd end) {
		if (end.getContext() == null) {
			return ci.findFeatureInstance(end.getFeature());
		} else {
			FeatureInstance ctx = findFeatureInstance(ci, end.getContext());
			return ctx.findFeatureInstance(end.getFeature());
		}
	}

	/*
	 * Add feature instances to component instance
	 */
	protected void instantiateFeatures(final ComponentInstance ci) throws InterruptedException {
		for (final Feature feature : getInstantiatedClassifier(ci).getClassifier().getAllFeatures()) {
			checkCanceled();
			final EList<ArrayDimension> dims = feature.getArrayDimensions();
			boolean arrayAllowed = canBeArray(feature);
			if (dims.isEmpty() || !arrayAllowed) {
				var fi = fillFeatureInstance(ci, feature, false, 0);
				if (!dims.isEmpty() && !arrayAllowed) {
					errManager.warning(fi, "No array allowed here, instantiated as a single feature");
				}
			} else {
				class ArrayInstantiator {
					void process(int dim) throws InterruptedException {
						ArraySize arraySize = dims.get(dim).getSize();
						long count = getElementCount(arraySize, ci);

						for (int i = 1; i <= count; i++) {
							var fi = fillFeatureInstance(ci, feature, false, i);
							if (i == 1 && dims.size() > 1) {
								errManager.warning(fi,
										"Feature array can have at most one dimension. Dimensions >1 ignored.");
							}
						}
					}
				}
				new ArrayInstantiator().process(0);
			}
		}
	}

	/**
	 * @since 3.0
	 */
	protected FeatureInstance fillFeatureInstance(ComponentInstance ci, Feature feature, boolean inverse, int index)
			throws InterruptedException {
		final FeatureInstance fi = InstanceFactory.eINSTANCE.createFeatureInstance();
		fi.setName(feature.getName());
		fi.setFeature(feature);
		// must add before prototype resolution in fillFeatureInstance
		ci.getFeatureInstances().add(fi);

		// take into account inverse in setting direction of features inside feature groups
		fi.setDirection(getDirection(feature, inverse));

		filloutFeatureInstance(fi, feature, inverse, index);
		return fi;
	}

	/**
	 * fill in a feature within a feature group
	 * Take into account the inverse setting on enclosing feature group(s) in setting feature direction
	 * @param fgi the feature group instance to add the feature instance to
	 * @param feature the feature to instantiate
	 * @param inverse whether the enclosing feature group(s) invert the direction of the feature
	 * @param index the index of the feature instance, zero if the feature is not an array
	 * @return the new feature instance
	 * @throws InterruptedException if instantiation is canceled
	 * @since 3.0
	 */
	protected FeatureInstance fillFeatureInstance(FeatureInstance fgi, Feature feature, boolean inverse, int index)
			throws InterruptedException {
		final FeatureInstance fi = InstanceFactory.eINSTANCE.createFeatureInstance();
		fi.setName(feature.getName());
		fi.setFeature(feature);
		fgi.getFeatureInstances().add(fi);

		// take into account inverse in setting direction of features inside feature groups
		fi.setDirection(getDirection(feature, inverse));

		// must add before prototype resolution in fillFeatureInstance
		filloutFeatureInstance(fi, feature, inverse, index);
		return fi;
	}

	private DirectionType getDirection(Feature feature, boolean inverse) {
		DirectionType dir;
		if (feature instanceof DirectedFeature directedFeature) {
			dir = directedFeature.getDirection();
		} else {
			Access access = (Access) feature;
			dir = access.getKind() == AccessType.PROVIDES ? DirectionType.OUT : DirectionType.IN;
		}
		if (inverse && dir != DirectionType.IN_OUT) {
			dir = (dir == DirectionType.IN) ? DirectionType.OUT : DirectionType.IN;
		}
		return dir;
	}

	/**
	 * Fill out the rest of a feature instance, resolving a feature prototype first.
	 *
	 * @param fi the feature instance of {@code feature}
	 * @param feature the feature that was instantiated
	 * @param inverse whether the enclosing feature group(s) invert the direction of the feature
	 * @param index the index of the feature instance, zero if the feature is not an array
	 * @throws InterruptedException if instantiation is canceled
	 */
	protected void filloutFeatureInstance(FeatureInstance fi, Feature feature, boolean inverse, int index)
			throws InterruptedException {
		fi.setIndex(index);

		/*
		 * A feature that is declared with a feature prototype takes its category from the actual the
		 * prototype is bound to. The prototype is reached through AbstractFeature. Feature.getPrototype()
		 * is not the way there: it is declared to return a ComponentPrototype, which a FeaturePrototype
		 * never is, and it is null for this shape.
		 */
		FeatureCategory prototypeCategory = null;
		if (feature instanceof AbstractFeature af && af.getFeaturePrototype() != null) {
			prototypeCategory = featureCategory(
					InstanceUtil.resolveFeaturePrototype(af.getFeaturePrototype(), fi, classifierCache));
		}
		if (prototypeCategory != null) {
			fi.setCategory(prototypeCategory);
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
		} else {
			FeatureClassifier fc = feature.getAllFeatureClassifier();
			if (fc != null) {
				instantiateFeatureClassifier(fi, fc);
			}
		}
	}

	/**
	 * The feature category determined by a feature prototype actual, or {@code null} if the actual does
	 * not determine one. Null also covers a prototype that is not bound in this context, in which case
	 * the category comes from the feature declaration.
	 * <p>
	 * A virtual bus access becomes a bus access, which is what a feature declared as a virtual bus
	 * access instantiates to as well, because {@link FeatureCategory} has no separate literal for it.
	 */
	private static FeatureCategory featureCategory(FeaturePrototypeActual actual) {
		if (actual instanceof AccessSpecification access) {
			return switch (access.getCategory()) {
			case BUS, VIRTUAL_BUS -> FeatureCategory.BUS_ACCESS;
			case DATA -> FeatureCategory.DATA_ACCESS;
			case SUBPROGRAM -> FeatureCategory.SUBPROGRAM_ACCESS;
			case SUBPROGRAM_GROUP -> FeatureCategory.SUBPROGRAM_GROUP_ACCESS;
			};
		}
		if (actual instanceof PortSpecification port) {
			return switch (port.getCategory()) {
			case DATA -> FeatureCategory.DATA_PORT;
			case EVENT -> FeatureCategory.EVENT_PORT;
			case EVENT_DATA -> FeatureCategory.EVENT_DATA_PORT;
			};
		}
		return null;
	}

	/*
	 * expand out feature instances for elements of a port group
	 *
	 * @param fi Feature Instance that is a port group
	 */
	protected void expandFeatureGroupInstance(Feature feature, FeatureInstance fi, boolean inverse)
			throws InterruptedException {
		if (feature instanceof FeatureGroup fg) {
			FeatureType ft = fg.getFeatureType();
			if (Aadl2Util.isNull(ft)) {
				return;
			}

			inverse ^= fg.isInverse();

			InstantiatedClassifier ic = getInstantiatedClassifier(fi);
			if (ic.getClassifier() == null) {
				errManager.error(fi, "Could not resolve feature group type of feature group prototype "
						+ fi.getInstanceObjectPath());
				return;
			} else if (ic.getBindings() != null && ic.getBindings().isEmpty()) {
				// prototype has not been bound yet
				errManager.warning(fi, "Feature group prototype of " + fi.getInstanceObjectPath()
						+ " is not bound yet to feature group type");
			}
			FeatureGroupType fgt = (FeatureGroupType) ic.getClassifier();

			List<Feature> localFeatures = fgt.getOwnedFeatures();
			final FeatureGroupType inverseFgt = fgt.getInverse();
			final FeatureGroupType baseFgt;
			FeatureGroupType parentFgt;
			List<Feature> fgFeatures;

			// Issue #818: Don't infer the features if the inverse feature group extends another feature group
			if (localFeatures.isEmpty() && inverseFgt != null && fgt.getExtended() == null) {
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
	 * Add a feature instance for every feature of a feature group type. A feature declared inside a
	 * feature group type cannot be an array, so an array declaration is reported and the feature is
	 * instantiated as a single feature.
	 *
	 * @param fgi the feature group instance to add the feature instances to
	 * @param flist the features of its feature group type
	 * @param inverse whether the enclosing feature group(s) invert the direction of the features
	 * @throws InterruptedException if instantiation is canceled
	 */
	protected void instantiateFGFeatures(final FeatureInstance fgi, List<Feature> flist, final boolean inverse)
			throws InterruptedException {
		for (final Feature feature : flist) {
			if (hasFeatureInstance(fgi, feature)) {
				errManager.error(fgi, "Cyclic containment dependency: Feature '" + feature.getName()
						+ "' has already been instantiated as enclosing feature group.");
			} else {
				final EList<ArrayDimension> dims = feature.getArrayDimensions();
				var fi = fillFeatureInstance(fgi, feature, inverse, 0);
				if (!dims.isEmpty()) {
					errManager.warning(fi, "No array allowed here, instantiated as a single feature");
				}
			}
		}
	}

	private boolean canBeArray(Feature f) {
		if (f.getOwner() instanceof Feature) {
			return false;
		} else if (f.getOwner() instanceof ComponentType ct) {
			/*
			 * Exhaustive on purpose: this list has to agree with the one the validator enforces, so a new
			 * component category should not compile until it has been decided for here as well.
			 */
			return switch (ct.getCategory()) {
			case ABSTRACT, DEVICE, MEMORY, PROCESSOR, SYSTEM, THREAD -> true;
			case BUS, DATA, PROCESS, SUBPROGRAM, SUBPROGRAM_GROUP, THREAD_GROUP, VIRTUAL_BUS, VIRTUAL_PROCESSOR -> false;
			};
		}
		return false;
	}

	/*
	 * check to see if the specified feature already exists as feature
	 * instance in the ancestry
	 */
	private boolean hasFeatureInstance(FeatureInstance fi, Feature f) {
		EObject parent = fi;
		while (parent instanceof FeatureInstance featureInstance) {
			if (featureInstance.getFeature() == f) {
				return true;
			}
			parent = parent.eContainer();
		}
		return false;
	}

	/**
	 * Give a feature instance the component instance of its classifier, as a root of its own in the
	 * instance resource. Features that name the same classifier share one root.
	 *
	 * @param fi the feature instance
	 * @param fc the classifier of its feature
	 * @throws InterruptedException if instantiation is canceled
	 * @since 3.0
	 */
	protected void instantiateFeatureClassifier(FeatureInstance fi, FeatureClassifier fc) throws InterruptedException {
		final ComponentInstance newInstance = InstanceFactory.eINSTANCE.createComponentInstance();
		final ComponentClassifier cc;
		final InstantiatedClassifier ic;

		ic = getInstantiatedClassifier(fi);

		if (ic == null) {
			cc = null;
		} else {
			cc = (ComponentClassifier) ic.getClassifier();
		}
		if (cc == null) {
			errManager.warning(fi, "No classifier for prototype '" + ((Prototype) fc).getName() + "'");
		} else {
			var contents = fi.eResource().getContents();
			boolean duplicate = false;
			if (!ic.hasBindings()) {
				for (var obj : contents) {
					if (obj instanceof ComponentInstance ci) {
						if (ci.getName().equalsIgnoreCase(cc.getQualifiedName())) {
							duplicate = true;
							fi.setType(ci);
							break;
						}
					}
				}
			}
			if (!duplicate) {
				newInstance.setClassifier(cc);
				newInstance.setName(cc.getQualifiedName() + (ic.hasBindings() ? "*" : ""));
				newInstance.setCategory(cc.getCategory());
				classifierCache.put(newInstance, ic);
				contents.add(newInstance);
				fi.setType(newInstance);
				/*
				 * Only establish the hierarchy, which is what discovers further referenced classifiers, and
				 * hand the new root to the common pipeline. Creating its connections, validating them,
				 * building its flows, or instantiating its annexes here would run those phases for this root
				 * before any root has its final connections.
				 */
				populateComponentInstance(newInstance, 0);
				roots.add(new InstantiationRoot(newInstance));
			}
		}
	}

	// --------------------------------------------------------------------------------------------
	// Methods for connection sets and connection patterns
	// --------------------------------------------------------------------------------------------

	private void processConnections(ComponentInstance root) throws InterruptedException {
		checkCanceled();
		EList<ComponentInstance> replicateConns = new UniqueEList<>();
		List<ConnectionInstance> toRemove = new ArrayList<>();
		EList<ConnectionInstance> connilist = root.getAllConnectionInstances();
		for (ConnectionInstance conni : connilist) {
			// track all component instances that contain connection instances
			replicateConns.add(conni.getComponentInstance());

			PropertyAssociation setPA = getPA(conni, CONNECTION_SET);
			PropertyAssociation patternPA = getPA(conni, CONNECTION_PATTERN);

			if (setPA == null && patternPA == null) {
				LinkedList<Integer> srcDims = new LinkedList<>();
				LinkedList<Integer> dstDims = new LinkedList<>();
				LinkedList<Integer> srcSizes = new LinkedList<>();
				LinkedList<Integer> dstSizes = new LinkedList<>();
				boolean done = false;

				boolean srcPathAnalyzed = analyzePath(conni.getContainingComponentInstance(), conni.getSource(), null,
						srcDims, srcSizes);
				boolean dstPathAnalyzed = analyzePath(conni.getContainingComponentInstance(), conni.getDestination(), null,
						dstDims, dstSizes);
				if (!srcPathAnalyzed || !dstPathAnalyzed) {
					continue;
				}
				for (int d : srcDims) {
					if (d != 0) {
						done = true;
						if (interpretConnectionPatterns(conni, false, null, 0, srcSizes, 0, dstSizes, 0,
								new ArrayList<>(), new ArrayList<>())) {
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
									new ArrayList<>(), new ArrayList<>())) {
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
				boolean pathError = false;
				for (PropertyExpression pe : patterns) {
					List<PropertyExpression> pattern = ((ListValue) pe).getOwnedListElements();
					LinkedList<Integer> srcSizes = new LinkedList<>();
					LinkedList<Integer> dstSizes = new LinkedList<>();

					boolean srcPathAnalyzed = analyzePath(conni.getContainingComponentInstance(), conni.getSource(), null,
							null, srcSizes);
					boolean dstPathAnalyzed = analyzePath(conni.getContainingComponentInstance(), conni.getDestination(),
							null, null, dstSizes);
					if (!srcPathAnalyzed || !dstPathAnalyzed) {
						pathError = true;
						break;
					}
					if (srcSizes.size() == 0 && dstSizes.size() == 0) {
						errManager.warning(conni,
								"Connection pattern specified for connection that does not connect array elements.");
					} else {
						if (interpretConnectionPatterns(conni, isOpposite, pattern, 0, srcSizes, 0, dstSizes, 0,
								new ArrayList<>(), new ArrayList<>())) {
							toRemove.add(conni);
						}
					}
				}
				if (pathError) {
					continue;
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
			// A default pattern pairs dimensions one-to-one. If only one end has dimensions,
			// every element on that end maps to the one scalar end.
			if (srcSizes.isEmpty()) {
				patternName = isOpposite ? "All_to_One" : "One_To_All";
			} else if (dstSizes.isEmpty()) {
				patternName = isOpposite ? "One_To_All" : "All_to_One";
			}
		} else {
			NamedValue nv = (NamedValue) patterns.get(offset);
			EnumerationLiteral pattern = (EnumerationLiteral) nv.getNamedValue();
			patternName = pattern.getName();
		}

		if (!isOpposite && !patternName.equalsIgnoreCase("One_To_All") && (srcOffset >= srcSizes.size())) {
			errManager.error(conni, "Too few indices for connection source for " + conni.getFullName());
			return false;
		}
		if (!isOpposite && !patternName.equalsIgnoreCase("All_To_One") && (dstOffset >= dstSizes.size())) {
			errManager.error(conni, "Too few indices for connection destination for " + conni.getFullName());
			return false;
		}
		if (isOpposite && !patternName.equalsIgnoreCase("One_To_All") && (dstOffset >= dstSizes.size())) {
			errManager.error(conni, "Too few indices for connection source for " + conni.getFullName());
			return false;
		}
		if (isOpposite && !patternName.equalsIgnoreCase("All_To_One") && (srcOffset >= srcSizes.size())) {
			errManager.error(conni, "Too few indices for connection destination for " + conni.getFullName());
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
				errManager.error(conni,
						"Array size mismatch (" + patternName + ") on connection " + conni.getFullName() + " in "
								+ conni.getContainingComponentInstance().getFullName() + ": " + srcSizes.get(srcOffset)
								+ " at source and " + dstSizes.get(dstOffset) + " at destination.");
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
				} else {
					/*
					 * A pattern this method does not know expands into nothing. Report it and keep the
					 * connection: returning the initial true would tell the caller that the connection was
					 * expanded, and the caller would delete it without a replacement.
					 */
					errManager.error(conni, "Unsupported connection pattern '" + patternName + "' on connection "
							+ conni.getFullName());
					return false;
				}
			}
		}
		return result;
	}

	private List<Long> getIndices(RecordValue rv, String field) {
		List<Long> indices = new ArrayList<>();
		for (BasicPropertyAssociation fv : rv.getOwnedFieldValues()) {
			if (fv.getProperty().getName().equalsIgnoreCase(field)) {
				ListValue lv = (ListValue) fv.getOwnedValue();
				EList<PropertyExpression> vlist = lv.getOwnedListElements();
				for (PropertyExpression elem : vlist) {
					indices.add(((IntegerLiteral) elem).getValue());
				}
			}
		}
		return indices;
	}

	private PropertyAssociation getPA(ConnectionInstance conni, String name) {
		for (PropertyAssociation pa : conni.getOwnedPropertyAssociations()) {
			if (pa.getProperty().getName().equalsIgnoreCase(name)
					&& ((PropertySet) pa.getProperty().getOwner()).getName()
							.equalsIgnoreCase(COMMUNICATION_PROPERTIES)) {
				return pa;
			}
		}
		return null;
	}

	/**
	 * Returns the instance objects from {@code end} up to, but excluding, {@code container}. A
	 * connection end path is relative to its containing component instance, so reaching any other root
	 * is an error rather than a successful stopping condition.
	 */
	private List<InstanceObject> getConnectionEndPath(ComponentInstance container, ConnectionInstanceEnd end) {
		if (container == null) {
			String endPath = end == null ? "<null>" : end.getInstanceObjectPath();
			String message = "Cannot analyze connection end '" + endPath + "' without a containing component instance";
			if (end == null) {
				errManager.internalError(message);
			} else {
				errManager.error(end, message);
			}
			return null;
		}
		List<InstanceObject> path = new ArrayList<>();
		InstanceObject current = end;
		while (current != container) {
			if (current == null || !(current.getOwner() instanceof InstanceObject owner)) {
				String endPath = end == null ? "<null>" : end.getInstanceObjectPath();
				errManager.error(container, "Connection end '" + endPath + "' is not contained in component instance '"
						+ container.getInstanceObjectPath() + "'");
				return null;
			}
			path.add(current);
			current = owner;
		}
		return path;
	}

	private boolean analyzePath(ComponentInstance container, ConnectionInstanceEnd end, LinkedList<String> names,
			LinkedList<Integer> dims, LinkedList<Integer> sizes) {
		List<InstanceObject> path = getConnectionEndPath(container, end);
		if (path == null) {
			return false;
		}
		for (InstanceObject current : path) {
			int d = 0;

			if (names != null) {
				names.add(current.getName());
			}

			if (current instanceof ComponentInstance componentInstance) {
				d = componentInstance.getSubcomponent().getArrayDimensions().size();
			} else if (current instanceof FeatureInstance featureInstance && featureInstance.getIndex() != 0) {
				d = 1;
			}
			if (dims != null) {
				dims.add(d);
			}
			if (sizes != null && d != 0) {
				if (current instanceof ComponentInstance componentInstance) {
					Subcomponent s = componentInstance.getSubcomponent();

					for (ArrayDimension ad : s.getArrayDimensions()) {
						ArraySize as = ad.getSize();

						sizes.add((int) getElementCount(as, current.getContainingComponentInstance()));
					}

				} else if (current instanceof FeatureInstance featureInstance && featureInstance.getIndex() != 0) {
					Feature f = featureInstance.getFeature();
					ArraySize as = f.getArrayDimensions().get(0).getSize();

					sizes.add((int) getElementCount(as, current.getContainingComponentInstance()));
				}
			}
		}
		return true;
	}

	private boolean analyzePath(ComponentInstance container, ConnectionInstanceEnd end, LinkedList<String> names,
			LinkedList<Integer> dims, LinkedList<Integer> sizes, LinkedList<Long> indices) {
		List<InstanceObject> path = getConnectionEndPath(container, end);
		if (path == null) {
			return false;
		}
		for (InstanceObject current : path) {
			int d = 0;

			if (names != null) {
				names.add(current.getName());
			}
			if (current instanceof ComponentInstance componentInstance) {
				d = componentInstance.getSubcomponent().getArrayDimensions().size();
				if (d != 0) {
					indices.addAll(componentInstance.getIndices());
				}
			} else if (current instanceof FeatureInstance featureInstance) {
				long idx = featureInstance.getIndex();
				if (idx != 0) {
					d = 1;
					indices.add(idx);
				}
			}
			if (dims != null) {
				dims.add(d);
			}
			if (sizes != null && d != 0) {
				if (current instanceof ComponentInstance componentInstance) {
					Subcomponent s = componentInstance.getSubcomponent();

					for (ArrayDimension ad : s.getArrayDimensions()) {
						ArraySize as = ad.getSize();

						sizes.add((int) getElementCount(as, current.getContainingComponentInstance()));
					}

				} else if (current instanceof FeatureInstance featureInstance && featureInstance.getIndex() != 0) {
					Feature f = featureInstance.getFeature();
					ArraySize as = f.getArrayDimensions().get(0).getSize();

					sizes.add((int) getElementCount(as, current.getContainingComponentInstance()));
				}
			}
		}
		return true;
	}

	/**
	 * Create a copy of the connection instance with the specified indices for the source and the
	 * destination.
	 *
	 * @param conni the connection instance to copy
	 * @param srcIndices the indices of the source end
	 * @param dstIndices the indices of the destination end
	 */
	private void createNewConnection(ConnectionInstance conni, List<Long> srcIndices, List<Long> dstIndices) {
		ComponentInstance container = conni.getContainingComponentInstance();
		LinkedList<String> names = new LinkedList<>();
		LinkedList<Integer> dims = new LinkedList<>();
		LinkedList<Integer> sizes = new LinkedList<>();
		ConnectionInstance newConn = EcoreUtil.copy(conni);
		newConn.setSource(null);
		newConn.setDestination(null);
		ConnectionReference topConnRef = Aadl2InstanceUtil.getTopConnectionReference(newConn);
		if (!analyzePath(container, conni.getSource(), names, dims, sizes)) {
			return;
		}
		if (srcIndices.size() != sizes.size() &&
		// filter out one side being an element without index (array of 1) (many to one mapping)
				!(sizes.size() == 0 && dstIndices.size() == 1)) {
			errManager.error(container,
					"Source indices " + srcIndices + " do not match source dimension " + sizes.size());
		}
		InstanceObject src = resolveConnectionInstancePath(newConn, topConnRef, container, container, names, dims, sizes,
				srcIndices, true);
		names.clear();
		dims.clear();
		sizes.clear();
		if (!analyzePath(container, conni.getDestination(), names, dims, sizes)) {
			return;
		}
		if (dstIndices.size() != sizes.size() &&
		// filter out one side being an element without index (array of 1) (many to one mapping)
				!(sizes.size() == 0 && dstIndices.size() == 1)) {
			errManager.error(container,
					"For " + newConn.getConnectionReferences().get(0).getFullName() + " : " + newConn.getFullName()
							+ ", destination indices " + dstIndices + " do not match destination dimension "
							+ sizes.size());
		}
		InstanceObject dst = resolveConnectionInstancePath(newConn, topConnRef, container, container, names, dims, sizes,
				dstIndices, false);
		if (src == null) {
			errManager.error(container, "Connection source not found");
		}
		if (dst == null) {
			errManager.error(container, "Connection destination not found");
		}
		if (src == null || dst == null) {
			return;
		}

		String containerPath = container.getInstanceObjectPath();
		int len = containerPath.length() + 1;
		String srcPath = src.getInstanceObjectPath();
		StringBuilder sb = new StringBuilder();
		int i = (srcPath.startsWith(containerPath)) ? len : 0;
		sb.append(srcPath.substring(i));
		sb.append(" --> ");
		String dstPath = dst.getInstanceObjectPath();
		i = (dstPath.startsWith(containerPath)) ? len : 0;
		sb.append(dstPath.substring(i));

		ConnectionInstance duplicate = (ConnectionInstance) AadlUtil
				.findNamedElementInList(container.getConnectionInstances(), sb.toString());
		if (duplicate != null && duplicate != conni) { // conni will be removed later
			errManager.warning(container, "There is already another connection between the same endpoints");
		}
		newConn.setSource((ConnectionInstanceEnd) src);
		newConn.setDestination((ConnectionInstanceEnd) dst);
		alignConnectionReferenceEndpoints(newConn);
		newConn.setName(sb.toString());
		container.getConnectionInstances().add(newConn);

	}

	/**
	 * Create a copy of the connection instance in another element of the array the connection instance
	 * belongs to.
	 *
	 * @param conni the connection instance to copy
	 * @param targetComponent the component instance the copy belongs to
	 */
	private void createNewConnection(ConnectionInstance conni, ComponentInstance targetComponent) {
		LinkedList<Long> indices = new LinkedList<>();
		LinkedList<String> names = new LinkedList<>();
		LinkedList<Integer> dims = new LinkedList<>();
		LinkedList<Integer> sizes = new LinkedList<>();
		ConnectionInstance newConn = EcoreUtil.copy(conni);
		newConn.setSource(null);
		newConn.setDestination(null);
		ConnectionReference topConnRef = Aadl2InstanceUtil.getTopConnectionReference(newConn);
		if (!analyzePath(conni.getContainingComponentInstance(), conni.getSource(), names, dims, sizes, indices)) {
			return;
		}
		InstanceObject src = resolveConnectionInstancePath(newConn, topConnRef, targetComponent, targetComponent, names,
				dims, sizes, indices, true);
		names.clear();
		dims.clear();
		sizes.clear();
		indices.clear();
		if (!analyzePath(conni.getContainingComponentInstance(), conni.getDestination(), names, dims, sizes, indices)) {
			return;
		}
		InstanceObject dst = resolveConnectionInstancePath(newConn, topConnRef, targetComponent, targetComponent, names,
				dims, sizes, indices, false);
		if (src == null) {
			errManager.error(targetComponent, "Connection source not found");
		}
		if (dst == null) {
			errManager.error(targetComponent, "Connection destination not found");
		}
		if (src == null || dst == null) {
			return;
		}

		String containerPath = targetComponent.getInstanceObjectPath();
		int len = containerPath.length() + 1;
		String srcPath = src.getInstanceObjectPath();
		StringBuilder sb = new StringBuilder();
		int i = (srcPath.startsWith(containerPath)) ? len : 0;
		sb.append(srcPath.substring(i));
		sb.append(" --> ");
		String dstPath = dst.getInstanceObjectPath();
		i = (dstPath.startsWith(containerPath)) ? len : 0;
		sb.append(dstPath.substring(i));

		relocateConnectionReferenceContexts(newConn, conni.getContainingComponentInstance(), targetComponent);
		newConn.setSource((ConnectionInstanceEnd) src);
		newConn.setDestination((ConnectionInstanceEnd) dst);
		alignConnectionReferenceEndpoints(newConn);
		newConn.setName(sb.toString());
		targetComponent.getConnectionInstances().add(newConn);

	}

	/**
	 * Keep the ends of a copied connection's reference chain aligned with the ends that were resolved
	 * for the copy. Re-resolving from a declaration that names a feature group can otherwise leave the
	 * reference at the group, and a failed nested lookup can leave it in the original array element.
	 *
	 * @param connection the copied connection whose source and destination have been resolved
	 */
	private void alignConnectionReferenceEndpoints(ConnectionInstance connection) {
		List<ConnectionReference> references = connection.getConnectionReferences();
		if (!references.isEmpty()) {
			references.get(0).setSource(connection.getSource());
			references.get(references.size() - 1).setDestination(connection.getDestination());
		}
	}

	/**
	 * Point the connection references of a replicated connection instance at the array element that now
	 * contains them. The copy keeps the contexts of the element it was copied from. Resolving the
	 * endpoints gives every enclosed connection reference a context in the target element, but nothing
	 * updates the context of the reference that goes across in the copied element.
	 *
	 * @param newConn the copy of the connection instance
	 * @param origComponent the component instance that contains the original connection instance
	 * @param targetComponent the component instance that will contain the copy
	 */
	private void relocateConnectionReferenceContexts(ConnectionInstance newConn, ComponentInstance origComponent,
			ComponentInstance targetComponent) {
		for (ConnectionReference connRef : newConn.getConnectionReferences()) {
			ComponentInstance relocated = relocateComponentInstance(connRef.getContext(), origComponent,
					targetComponent);
			if (relocated != null) {
				connRef.setContext(relocated);
			}
		}
	}

	/**
	 * Find the component instance in the target element that corresponds to a component instance in the
	 * element the connection instance was copied from.
	 *
	 * @param original the component instance to relocate
	 * @param origComponent the root of the subtree the original belongs to
	 * @param targetComponent the root of the subtree to relocate into
	 * @return the corresponding component instance, or null if the original is neither
	 *         <code>origComponent</code> nor contained in it, or if it has no counterpart
	 */
	private ComponentInstance relocateComponentInstance(ComponentInstance original, ComponentInstance origComponent,
			ComponentInstance targetComponent) {
		if (original == null) {
			return null;
		}
		if (original == origComponent) {
			return targetComponent;
		}
		ComponentInstance parent = relocateComponentInstance(original.getContainingComponentInstance(), origComponent,
				targetComponent);
		if (parent == null) {
			return null;
		}
		for (ComponentInstance candidate : parent.getComponentInstances()) {
			if (candidate.getName().equalsIgnoreCase(original.getName())
					&& candidate.getIndices().equals(original.getIndices())) {
				return candidate;
			}
		}
		return null;
	}

	/**
	 * resolve downgoing source or destination of the connection reference.
	 * we do so by re-retrieving the feature instance based on the existing connection instance end name.
	 * If the connection reference is up or down going we also fill in the other end.
	 * @param targetConnRef the connection reference to resolve
	 * @param outerConnRef the connection reference one level up
	 * @param target the component instance to resolve the end in
	 * @param doSource whether to resolve the source end or the destination end
	 * @param idx the index of the feature instance to resolve to
	 * @param fgidx the index of the enclosing feature group instance to resolve to
	 * @return the resolved end
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
				if (found == null && src.getOwner() instanceof FeatureInstance parent) {
					found = (ConnectionInstanceEnd) AadlUtil.findNamedElementInList(target.getFeatureInstances(),
							parent.getName(), fgidx);
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
					if (found == null && dst.getOwner() instanceof FeatureInstance parent) {
						found = (ConnectionInstanceEnd) AadlUtil.findNamedElementInList(target.getFeatureInstances(),
								parent.getName(), fgidx);
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
				if (found == null && dst.getOwner() instanceof FeatureInstance parent) {
					found = (ConnectionInstanceEnd) AadlUtil.findNamedElementInList(target.getFeatureInstances(),
							parent.getName(), fgidx);
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
					if (found == null && src.getOwner() instanceof FeatureInstance parent) {
						found = (ConnectionInstanceEnd) AadlUtil.findNamedElementInList(target.getFeatureInstances(),
								parent.getName(), fgidx);
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
	 * @param resolutionRoot component instance from which the path is resolved
	 * @param diagnosticTarget resource-backed object used for diagnostics
	 * @param names sequence of names of the path bottom up
	 * @param dims Dimensions (bottom up) along the path
	 * @param sizes Sizes of each dimension bottom up
	 * @param indices The indices to be used for elements that are arrays
	 * @param doSource Go down the source path or the destination path
	 * @return ConnectionInstanceEnd the ultimate source/destination object (feature instance or component instance)
	 */
	private ConnectionInstanceEnd resolveConnectionInstancePath(ConnectionInstance newconn, ConnectionReference topref,
			ComponentInstance resolutionRoot, Element diagnosticTarget, List<String> names, List<Integer> dims,
			List<Integer> sizes, List<Long> indices, boolean doSource) {
		// the connection reference to be resolved
		ConnectionReference targetConnRef = topref;
		ConnectionReference outerConnRef = topref;
		ConnectionInstanceEnd resolutionContext = resolutionRoot;
		// we have to process the indices backwards since we go top down
		// offset starts with the last element of the indices array
		int offset = indices.size() - 1;
		int count = dims.size() - 1;
		ConnectionInstanceEnd result = null;
		for (int nameidx = names.size() - 1; nameidx >= 0; nameidx--) {
			String name = names.get(nameidx);
			List<InstanceObject> owned = new ArrayList<>();
			int dim = dims.get(count);
			if (resolutionContext instanceof ComponentInstance componentContext) {
				// if nextConnRef is null it is because we are going to look up feature instances inside the last component instance
				owned.addAll(componentContext.getComponentInstances());
				owned.addAll(componentContext.getFeatureInstances());
			} else if (resolutionContext instanceof FeatureInstance featureContext) {
				owned.addAll(featureContext.getFeatureInstances());
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
							if (io instanceof ComponentInstance componentInstance) {
								// we need to deal with possibly more than one index
								int d = dim - 1;
								for (long i : componentInstance.getIndices()) {
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
							errManager.warning(diagnosticTarget,
									"Too few indices for connection end, using first array element");
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
	 * @param root the root of the instance model to collect from
	 * @return the used property definitions
	 * @throws InterruptedException if instantiation is canceled
	 * @since 3.0
	 */
	public EList<Property> getAllUsedPropertyDefinitions(ComponentInstance root) throws InterruptedException {
		checkCanceled();
		EList<Property> result = new UniqueEList<>();

		addUsedProperties(root, root.getClassifier(), result);
		TreeIterator<Element> it = EcoreUtil.getAllContents(Collections.singleton(root));
		// collect topdown component impl. do it and its type to find PA
		while (it.hasNext()) {
			Element elem = it.next();

			if (elem instanceof ComponentInstance componentInstance) {
				InstantiatedClassifier ic = getInstantiatedClassifier(componentInstance);
				if (ic != null && ic.getClassifier() != null) {
					if (ic.getClassifier().equals(root.getClassifier())) {
						addUsedProperties(root, ic.getClassifier(), result, false);
					} else {
						addUsedProperties(root, ic.getClassifier(), result);
					}
				}
			} else if (elem instanceof FeatureInstance fi) {
				if (fi.getFeature() instanceof FeatureGroup) {
					FeatureGroupType fgt = getFeatureGroupType(fi);
					addUsedProperties(root, fgt, result);
				} else {
					Classifier c = fi.getFeature().getClassifier();
					addUsedProperties(root, c, result);
				}
			} else if (elem instanceof ConnectionInstance ci) {
				addUsedPropertyDefinitions(ci.getContainingClassifier(), result);

				for (ConnectionReference cr : ci.getConnectionReferences()) {
					addUsedPropertyDefinitions(cr.getConnection(), result);
				}
			}
		}
		return result;
	}

	private void addUsedProperties(InstanceObject root, Classifier cc, EList<Property> result) {
		addUsedProperties(root, cc, result, true);
	}

	private void addUsedProperties(InstanceObject root, Classifier cc, EList<Property> result, boolean showError) {

		if (cc instanceof ComponentImplementation implementation) {
			ComponentImplementation impl = implementation;
			List<ComponentImplementation> extendedComponentImpls = new ArrayList<>();
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
			cc = implementation.getType();
		}
		List<Classifier> extendedClassifiers = new ArrayList<>();
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
	protected void addUsedPropertyDefinitions(Element root, List<Property> result) {
		TreeIterator<Element> it = EcoreUtil.getAllContents(Collections.singleton(root));
		while (it.hasNext()) {
			EObject ao = it.next();
			if (ao instanceof PropertyAssociation propertyAssociation) {
				Property pd = propertyAssociation.getProperty();
				if (pd != null) {
					result.add(pd);
				}
			}
		}
	}

	// --------------------------------------------------------------------------------------------
	// Methods related to system operation modes
	// --------------------------------------------------------------------------------------------

	/*
	 * Create the system operation mode objects for the instance model.
	 */
	protected void createSystemOperationModes(final SystemInstance root, final int limit) throws InterruptedException {
		class SOMBuilder {

			class Node {
				ComponentInstance ci;
				Node parentNode;
				State state;

				Node(ComponentInstance ci, Node parentNode) {
					this.ci = ci;
					this.parentNode = parentNode;
				}
			}

			class State {
				boolean active;
				// mode is ignored if !active
				ModeInstance mode;

				State(boolean active) {
					this.active = active;
				}
			}

			ArrayList<Node> workState = new ArrayList<>();

			int modalCount;

			int createSoms() throws InterruptedException {
				Node rootNode = new Node(null, null);
				rootNode.state = new State(true);
				initWorkState(root, rootNode);
				modalCount = workState.size();
				if (modalCount == 0) {
					/*
					 * We have no modal components, but we need to create a special SOM to
					 * represent our single normal operating state.
					 */
					final SystemOperationMode som = InstanceFactory.eINSTANCE.createSystemOperationMode();
					som.setName(NORMAL_SOM_NAME);
					root.getSystemOperationModes().add(som);
					return 0;
				} else {
					return enumerateSoms(0, 0);
				}
			}

			protected int enumerateSoms(int depth, int index) throws InterruptedException {

				checkCanceled();

				Node node = workState.get(depth);
				State parentState = node.parentNode.state;
				Iterator<ModeInstance> modes = parentState.active ? getActiveModes(node.ci, parentState.mode)
						: Collections.emptyIterator();
				boolean active = parentState.active && modes.hasNext();

				State state = new State(active);
				node.state = state;

				if (depth + 1 == modalCount) {
					// here we add one or more SOMs
					if (active) {
						while (modes.hasNext()) {
							checkCanceled();
							state.mode = modes.next();
							root.getSystemOperationModes().add(createSOM(index + 1));
							if (index < 0 || ++index >= limit) {
								return -1;
							}
						}
					} else {
						root.getSystemOperationModes().add(createSOM(index + 1));
						if (index < 0 || ++index >= limit) {
							return -1;
						}
					}
				} else {
					if (active) {
						while (modes.hasNext()) {
							state.mode = modes.next();
							index = enumerateSoms(depth + 1, index);
							if (index < 0) {
								return -1;
							}
						}
					} else {
						index = enumerateSoms(depth + 1, index);
					}
				}
				node.state = null;
				return index;
			}

			protected Iterator<ModeInstance> getActiveModes(ComponentInstance ci, ModeInstance parentMode) {
				List<ModeInstance> modes = ci.getModeInstances();
				if (parentMode == null) {
					// system instance
					return modes.iterator();
				} else if (!ci.getInModes().isEmpty() && !ci.getInModes().contains(parentMode)) {
					// component not active in parent mode
					return Collections.emptyIterator();
				} else {
					// limit derived modes to mapping
					return modes.stream()
							.filter(mi -> !mi.isDerived() || mi.getParents().contains(parentMode))
							.iterator();
				}
			}

			protected void initWorkState(ComponentInstance ci, Node parentNode) throws InterruptedException {
				checkCanceled();
				if (!ci.getModeInstances().isEmpty()) {
					parentNode = new Node(ci, parentNode);
					workState.add(parentNode);
				}
				for (ComponentInstance sub : ci.getComponentInstances()) {
					initWorkState(sub, parentNode);
				}
			}

			protected SystemOperationMode createSOM(int somNo) throws InterruptedException {
				final SystemOperationMode som;

				som = InstanceFactory.eINSTANCE.createSystemOperationMode();
				for (Node node : workState) {
					checkCanceled();
					if (!node.state.active) {
						continue;
					}
					ModeInstance mi = node.state.mode;
					mode2som.computeIfAbsent(mi, key -> new ArrayList<>()).add(som);
					som.getCurrentModes().add(mi);
				}
				som.setName("som_" + somNo);
				return som;
			}
		}

		int index = new SOMBuilder().createSoms();
		if (index < 0) {
			errManager.warning(root,
					"List of system operation modes is incomplete (see project property 'Instantiation')");
		}
	}

	private int getSOMLimit(final IProject project) {
		final IScopeContext context = new ProjectScope(project);
		final Preferences prefs = context.getNode(PREFS_QUALIFIER);

		int somLimit = -1;
		if (!prefs.getBoolean(PREF_SOM_USE_WORKSPACE, true)) {
			somLimit = prefs.getInt(PREF_SOM_LIMIT, -1);
		}
		// It's possible the above may have failed for some reason, in which case we revert to the workspace preferences
		if (somLimit == -1) {
			somLimit = OsateCorePlugin.getDefault().getSOMLimit();
		}
		return somLimit;
	}
}
