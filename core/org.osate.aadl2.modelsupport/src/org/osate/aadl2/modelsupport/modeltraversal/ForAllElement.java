/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
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
package org.osate.aadl2.modelsupport.modeltraversal;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.util.AadlUtil;

/**
 * ForAllElement plays the role of an iterator object that supports traversal of
 * AADL models Encapsulates traversal algorithms over models. Each instance of
 * ForAllElement contains a resultList that holds all visited model objects as
 * result of the default action.
 * <p>
 * Processing of model elements is performed by the {@link #process(Element)}
 * method, which by default calls {@link #suchThat(Element)} to evaluate a
 * condition and then {@link #action(Element)} to perform an action. The default
 * condition is <code>true</code> and the default action is to add the visited
 * Element to a resultList. Subclasses can either override {@link #suchThat} and
 * or {@link #action} to get the desired filtering effects, or they can override
 * {@link #process} directly.
 * <p>
 * Traversals may append objects to a result list. The default implementation of
 * {@link #action} simply adds the visited object to the list. Many of the
 * traversals return this list as their result. Analysis are not required to do
 * anything with this list, however. This list can also be retreived using
 * {@link #getResultList()}.
 * <p>
 * For ease of anonymous invocation, traversals specify a preferred or default
 * traversal method at construction time using one of the constants
 * {@link #NO_DEFAULT}, {@link #PROCESS_BOTTOM_UP_COMPONENT_IMPL},
 * {@link #PROCESS_POST_ORDER_ALL}, {@link #PROCESS_PRE_ORDER_ALL},
 * {@link #PROCESS_TOP_DOWN_COMPONENT_CLASSIFIER}, or
 * {@link #PROCESS_TOP_DOWN_COMPONENT_IMPL}. This default traversal method is
 * used by the {@link #defaultTraversal(Element)} and
 * {@link #defaultTraversal(List)} methods. If no default is explicitly
 * specified, then {@link #PROCESS_PRE_ORDER_ALL} is used. If the default
 * traversal is {@link #NO_DEFAULT}, then the default traversal methods will
 * throw an {@link java.lang.UnsupportedOperationException}.
 * <p>
 * The default traversal can be run over all the declarative models in the
 * workspace using {@link #defaultTraversalAllDeclarativeModels()}. It can be
 * run over all the instance models in the workspace using
 * {@link #defaultTraversalAllInstances()}.
 * <p>
 * A traversal can cancel itself by calling {@link #cancelTraversal()}. The
 * traversal methods routinely invoke {@link #notCancelled()} to see if the
 * traversal has been cancelled. The end user of the traversal object can
 * determine if the traversal was cancelled by checking {@link #cancelled()}.
 * The result list is not in a well defined state when the traversal has been
 * cancelled.
 *
 * @author phf
 */
public class ForAllElement implements IProcessingMethod {
	/*
	 * ============================================================= Constants
	 * for specifying the default traversal algorithm
	 * =============================================================
	 */

	/**
	 * Constant indicating that there is no default traversal method. Attemps to
	 * use the default traversal method via {@link #defaultTraversal(Element)},
	 * {@link #defaultTraversal(List)}, etc. will fail with an
	 * {@link UnsupportedOperationException}.
	 */
	public static final int NO_DEFAULT = 0;

	/**
	 * Constant indicating the default traversal method is
	 * {@link #processBottomUpComponentImpl(ComponentImplementation)}.
	 */
	public static final int PROCESS_BOTTOM_UP_COMPONENT_IMPL = 1;

	/**
	 * Constant indicating the default traversal method is
	 * {@link #processPostOrderAll(Element)}.
	 */
	public static final int PROCESS_POST_ORDER_ALL = 2;

	/**
	 * Constant indicating the default traversal method is
	 * {@link #processPreOrderAll(Element)}.
	 */
	public static final int PROCESS_PRE_ORDER_ALL = 3;

	/**
	 * Constant indicating the default traversal method is
	 * {@link #processTopDownComponentClassifier(ComponentImplementation)}.
	 */
	public static final int PROCESS_TOP_DOWN_COMPONENT_CLASSIFIER = 4;

	/**
	 * Constant indicating the default traversal method is
	 * {@link #processTopDownComponentImpl(ComponentImplementation)}.
	 */
	public static final int PROCESS_TOP_DOWN_COMPONENT_IMPL = 5;

	private static final int LAST_TRAVERSAL_CONSTANT = 5;

	/**
	 * The default setting for the default traversal method. The current value
	 * for this is {@link #PROCESS_PRE_ORDER_ALL}.
	 */
	public static final int DEFAULT_DEFAULT_TRAVERSAL = PROCESS_PRE_ORDER_ALL;

	/*
	 * ============================================================= Instance
	 * variables =============================================================
	 */

	/** The error manager used by the traversal. */
	private final AnalysisErrorReporterManager errManager;

	/**
	 * This list is returned as the result value of the various traversal
	 * methods. An implementation may or may not use it. The default
	 * implementation of {@link #action(Element)} adds the visited model object
	 * to the list.
	 */
	protected final EList<Element> resultList = new BasicEList<Element>(200);

	/** The default traversal method. */
	private final AbstractTraversal defaultTraversalMethod;

	/** Was the traversal cancelled? */
	private boolean notCancelled = true;

	/*
	 * =============================================================
	 * Constructors
	 * =============================================================
	 */

	/**
	 * Create a new traversal that uses the given error manager and uses the
	 * given default traversal algorithm.
	 *
	 * @param defTraversal The default traversal algorithm. One of
	 *            {@link #NO_DEFAULT}, {@link #PROCESS_BOTTOM_UP_COMPONENT_IMPL}
	 *            , {@link #PROCESS_POST_ORDER_ALL},
	 *            {@link #PROCESS_PRE_ORDER_ALL},
	 *            {@link #PROCESS_TOP_DOWN_COMPONENT_CLASSIFIER}, or
	 *            {@link #PROCESS_TOP_DOWN_COMPONENT_IMPL}.
	 * @param errMgr The analysis error manager to use to report error results.
	 */
	public ForAllElement(final int defTraversal, final AnalysisErrorReporterManager errMgr) {
		if (defTraversal < 0 || defTraversal > LAST_TRAVERSAL_CONSTANT) {
			throw new IllegalArgumentException("Unknown default traversal");
		}
		defaultTraversalMethod = generateTraversal(defTraversal);
		errManager = errMgr;
	}

	/**
	 * Create a new traversal that uses
	 * {@link AnalysisErrorReporterManager#NULL_ERROR_MANANGER the null error
	 * mananger} and the given default traversal algorithm.
	 *
	 * @param defTraversal The default traversal algorithm. One of
	 *            {@link #NO_DEFAULT}, {@link #PROCESS_BOTTOM_UP_COMPONENT_IMPL}
	 *            , {@link #PROCESS_POST_ORDER_ALL},
	 *            {@link #PROCESS_PRE_ORDER_ALL},
	 *            {@link #PROCESS_TOP_DOWN_COMPONENT_CLASSIFIER}, or
	 *            {@link #PROCESS_TOP_DOWN_COMPONENT_IMPL}.
	 */
	public ForAllElement(final int defTraversal) {
		this(defTraversal, AnalysisErrorReporterManager.NULL_ERROR_MANANGER);
	}

	/**
	 * Create a new traversal that uses the given error manager and uses the
	 * {@link #DEFAULT_DEFAULT_TRAVERSAL default default traversal algorithm}.
	 *
	 * @param errMgr The analysis error manager to use to report error results.
	 */
	public ForAllElement(final AnalysisErrorReporterManager errMgr) {
		this(DEFAULT_DEFAULT_TRAVERSAL, errMgr);
	}

	/**
	 * Create a new traversal that uses
	 * {@link AnalysisErrorReporterManager#NULL_ERROR_MANANGER the null error
	 * mananger} the {@link #DEFAULT_DEFAULT_TRAVERSAL default default traversal
	 * algorithm}.
	 */
	public ForAllElement() {
		this(AnalysisErrorReporterManager.NULL_ERROR_MANANGER);
	}

	/*
	 * ============================================================= The basic
	 * processing framework
	 * =============================================================
	 */

	/**
	 * Process a single model object. This method is invoked on each model
	 * object by the traversal methods (e.g., {@link #processEList(EList)},
	 * {@link #processPreOrderAll(Element)}, etc.). The default implementation
	 * is
	 *
	 * <pre>
	 * protected void process(Element theElement) {
	 * 	if (suchThat(theElement)) {
	 * 		action(theElement);
	 * 	}
	 * }
	 * </pre>
	 * <P>
	 * But subclasses can reimplement this method to do anything.
	 *
	 * @see #action(Element)
	 * @see #suchThat(Element)
	 */
	protected void process(final Element theElement) {
		if (suchThat(theElement)) {
			action(theElement);
		}
	}

	/**
	 * Process a single model object. Delegates to {@link #process(Element)}.
	 * This method exists to satisfy the {@link IProcessingMethod} interface. I
	 * would have preferred to have a <code>process</code> method in the
	 * interface, but I cannot because the <code>ForAllElement.process</code>
	 * method is <code>protected</code>. If I put the method in an interface, I
	 * would have to make the method <code>public</code>, which could break
	 * existing code.
	 */
	@Override
	public final void processObject(final Element theElement) {
		if (theElement instanceof InstanceObject) {
			InstanceObject io = (InstanceObject) theElement;
			SystemInstance root = io.getSystemInstance();
			SystemOperationMode som = root.getCurrentSystemOperationMode();
			if (som == null || io.isActive(som)) {
				process(io);
			}
		} else {
			process(theElement);
		}
	}

	/**
	 * Processes a list of Elements by invoking {@link #process(Element)} on
	 * every element of the list in order. The default implementations of
	 * {@link #process(Element)}, {@link #suchThat}, and {@link #action} mean
	 * that by default this method just returns the input list of elements. It
	 * can be used to filter out elements by overriding
	 * {@link #suchThat(Element)}.
	 * <p>
	 * This method checks {@link #notCancelled()} after each element in the
	 * list, and terminates the processing if the traversal has been cancelled.
	 *
	 * @param list EList of Elements
	 * @return EList result list of objects that have been visited by any
	 *         traversal with the given ForAllElement
	 * @see #process(Element)
	 * @see #cancelTraversal()
	 * @see #notCancelled()
	 */
	public final EList<Element> processEList(final EList<? extends Element> list) {
		for (Iterator<? extends Element> it = list.iterator(); notCancelled() && it.hasNext();) {
			process(it.next());
		}
		return resultList;
	}

	/**
	 * Method used to filter out objects during traversal. Intended to be
	 * overridden. Used by the default implementation of
	 * {@link #process(Element)}:
	 *
	 * <pre>
	 * protected void process(Element theElement) {
	 * 	if (suchThat(theElement)) {
	 * 		action(theElement);
	 * 	}
	 * }
	 * </pre>
	 * <p>
	 * By default, this method returns <code>true</code>.
	 *
	 * @param obj The object to test
	 * @return Whether the object should be visited or not.
	 * @see #process(Element)
	 * @see #action(Element)
	 */
	protected boolean suchThat(Element obj) {
		return true;
	}

	/**
	 * Action to be performed on the currently visited model object. This method
	 * is intended to be overridden. This method is used by the default
	 * implementation of {@link #process(Element)}:
	 *
	 * <pre>
	 * protected void process(Element theElement) {
	 * 	if (suchThat(theElement)) {
	 * 		action(theElement);
	 * 	}
	 * }
	 * </pre>
	 * <p>
	 * By default, this method adds the object to {@link #resultList}. But this
	 * method can do anything.
	 *
	 * @param obj The object to visit.
	 * @see #suchThat(Element)
	 * @see #process(Element)
	 */
	protected void action(Element obj) {
		resultList.add(obj);
	}

	/**
	 * Get the result list of the traversal. By default, this is the list of the
	 * all visited nodes, in the order they were visited. But the actual
	 * contents of this list depend on the implementation of
	 * {@link #process(Element)}.
	 */
	@Override
	public EList<Element> getResultList() {
		return resultList;
	}

	/*
	 * ============================================================= Handle
	 * traversal cancellation
	 * =============================================================
	 */

	/**
	 * Mark that the traversal should be cancelled. This should be called by a
	 * specific traversal implementation to halt the traversal. It is not
	 * <code>public</code> because there is no sense in outsiders calling this
	 * method.
	 *
	 * @see #cancelled()
	 * @see #notCancelled()
	 */
	protected final void cancelTraversal() {
		notCancelled = false;
	}

	/**
	 * Test if we are cancelled. Unlike {@link #cancelTraversal()}, this method
	 * is <code>public</code>: it is interesting for the user of the traversal
	 * to learn if the traversal was cancelled.
	 *
	 * @see #notCancelled
	 */
	@Override
	public final boolean cancelled() {
		return !notCancelled;
	}

	/**
	 * Test if we weren't cancelled. Unlike {@link #cancelTraversal()}, this
	 * method is <code>public</code>: it is interesting for the user of the
	 * traversal to learn if the traversal was cancelled.
	 * <p>
	 * Most the time it is more interesting to know that the traversal wasn't
	 * cancelled, than to know that it was cancelled.
	 *
	 * @see #cancelled()
	 */
	@Override
	public final boolean notCancelled() {
		return notCancelled;
	}

	/*
	 * ============================================================= Default
	 * traversal methods
	 * =============================================================
	 */

	/**
	 * Get the traversal object for the specified traversal type.
	 */
	private AbstractTraversal generateTraversal(final int traversal) {
		switch (traversal) {
		case NO_DEFAULT:
			return NullTraversal.prototype;
		case PROCESS_BOTTOM_UP_COMPONENT_IMPL:
			return new BottomUpComponentImplTraversal(this);
		case PROCESS_POST_ORDER_ALL:
			return new PostOrderTraversal(this);
		case PROCESS_PRE_ORDER_ALL:
			return new PreOrderTraversal(this);
		case PROCESS_TOP_DOWN_COMPONENT_CLASSIFIER:
			return new TopDownComponentClassifierTravseral(this);
		case PROCESS_TOP_DOWN_COMPONENT_IMPL:
			return new TopDownComponentImplTraversal(this);
		}
		return NullTraversal.prototype;
	}

	/**
	 * Execute the default traversal algorithm using the given root object. In
	 * case of instance models, takes into account the current mode when
	 * traversing the content hierarchy of model instances.
	 * <p>
	 * This method checks {@link #notCancelled()} after visiting each element,
	 * and terminates the processing if the traversal has been cancelled.
	 *
	 * @param obj The root object to start the traversal.
	 * @return The value of {@link #resultList}. The contents of this list
	 *         depend on the implementation of {@link #process}/{@link #action}.
	 * @see #cancelTraversal()
	 * @see #notCancelled()
	 * @see #process(Element)
	 */
	public final EList<Element> defaultTraversal(final Element obj) {
		defaultTraversalMethod.visitRoot(obj);
		return resultList;
	}

	/**
	 * Execute the default traversal algorithm using the given list of root
	 * objects. The traversal is run on each root node in the order they appear
	 * in the list. In case of instance models, takes into account the current
	 * mode when traversing the content hierarchy of model instances.
	 * <p>
	 * This method checks {@link #notCancelled()} after visiting each element,
	 * and terminates the processing if the traversal has been cancelled.
	 *
	 * @param objs List of root objects.
	 * @return The value of {@link #resultList}. The contents of this list
	 *         depend on the implementation of {@link #process}/{@link #action}.
	 * @see #defaultTraversalMethod
	 * @see #cancelTraversal()
	 * @see #notCancelled()
	 * @see #process(Element)
	 */
	public final EList<Element> defaultTraversal(final List<? extends Element> objs) {
		return defaultTraversalMethod.visitList(objs);
	}

	/**
	 * Perform the default traversal on all the declarative models in the
	 * workspace.
	 * <p>
	 * This method checks {@link #notCancelled()} after visiting each element,
	 * and terminates the processing if the traversal has been cancelled.
	 *
	 * @return The value of {@link #resultList}. The contents of this list
	 *         depend on the implementation of {@link #process}/{@link #action}.
	 * @see #defaultTraversalMethod
	 * @see #cancelTraversal()
	 * @see #notCancelled()
	 * @see #process(Element)
	 */
	public final EList defaultTraversalAllDeclarativeModels() {
		return defaultTraversalMethod.visitWorkspaceDeclarativeModels();
	}

	/**
	 * Perform the default traversal on all the instance models in the
	 * workspace. Not all traversal algorithsm support this operation: If the
	 * specified default traversal is {@link #PROCESS_BOTTOM_UP_COMPONENT_IMPL},
	 * {@link #PROCESS_TOP_DOWN_COMPONENT_CLASSIFIER}, or
	 * {@link #PROCESS_TOP_DOWN_COMPONENT_IMPL} then this will throw an
	 * {@link UnsupportedOperationException}.
	 * <p>
	 * This method checks {@link #notCancelled()} after visiting each element,
	 * and terminates the processing if the traversal has been cancelled.
	 *
	 * @return The value of {@link #resultList}. The contents of this list
	 *         depend on the implementation of {@link #process}/{@link #action}.
	 * @see #defaultTraversalMethod
	 * @see #cancelTraversal()
	 * @see #notCancelled()
	 * @see #process(Element)
	 */
	public final EList defaultTraversalAllInstances() {
		return defaultTraversalMethod.visitWorkspaceInstanceModels();
	}

	/*
	 * ============================================================= Prefix
	 * order traversal
	 * =============================================================
	 */

	/**
	 * Does preorder processing of the model starting at the given node. In case
	 * of instance models, takes into account the current mode when traversing
	 * the content hierarchy of model instances.
	 * <p>
	 * This method checks {@link #notCancelled()} after visiting each element,
	 * and terminates the processing if the traversal has been cancelled.
	 *
	 * @param obj The root object of the traversal.
	 * @return The value of {@link #resultList}. The contents of this list
	 *         depend on the implementation of {@link #process}/{@link #action}.
	 * @see #cancelTraversal()
	 * @see #notCancelled()
	 * @see #process(Element)
	 */
	public final EList<Element> processPreOrderAll(final Element obj) {
		new PreOrderTraversal(this).visitRoot(obj);
		return resultList;
	}

	/**
	 * Does preorder processing of the model starting at the given root nodes.
	 * The subtree rooted at each node in the list is visited in its entirety
	 * before the next root node is visited. In case of instance models, takes
	 * into account the current mode when traversing the content hierarchy of
	 * model instances.
	 * <p>
	 * This method checks {@link #notCancelled()} after visiting each element,
	 * and terminates the processing if the traversal has been cancelled.
	 *
	 * @param objlist The roots nodes to be visited.
	 * @return The value of {@link #resultList}. The contents of this list
	 *         depend on the implementation of {@link #process}/{@link #action}.
	 * @see #cancelTraversal()
	 * @see #notCancelled()
	 * @see #process(Element)
	 */
	public final EList processPreOrderAll(final EList objlist) {
		return (new PreOrderTraversal(this)).visitList(objlist);
	}

	/**
	 * Process all AADL models in the AadlWorkspace in in prefix order. In case
	 * of instance models, takes into account the current mode when traversing
	 * the content hierarchy of model instances.
	 * <p>
	 * This method checks {@link #notCancelled()} after visiting each element,
	 * and terminates the processing if the traversal has been cancelled.
	 *
	 * @return The value of {@link #resultList}. The contents of this list
	 *         depend on the implementation of {@link #process}/{@link #action}.
	 * @see #cancelTraversal()
	 * @see #notCancelled()
	 * @see #process(Element)
	 */
	public final EList processPreOrderAll() {
		return (new PreOrderTraversal(this)).visitWorkspace();
	}

	/**
	 * Process all declarative AADL models in the AadlWorkspace in prefix order.
	 * <p>
	 * This method checks {@link #notCancelled()} after visiting each element,
	 * and terminates the processing if the traversal has been cancelled.
	 *
	 * @return The value of {@link #resultList}. The contents of this list
	 *         depend on the implementation of {@link #process}/{@link #action}.
	 * @see #cancelTraversal()
	 * @see #notCancelled()
	 * @see #process(Element)
	 */
	public final EList processPreOrderAllDeclarativeModels() {
		return (new PreOrderTraversal(this)).visitWorkspaceDeclarativeModels();
	}

	/**
	 * Process all AADL instance models in the AadlWorkspace in prefix order. In
	 * case of instance models, takes into account the current mode when
	 * traversing the content hierarchy of model instances.
	 * <p>
	 * This method checks {@link #notCancelled()} after visiting each element,
	 * and terminates the processing if the traversal has been cancelled.
	 *
	 * @return The value of {@link #resultList}. The contents of this list
	 *         depend on the implementation of {@link #process}/{@link #action}.
	 * @see #cancelTraversal()
	 * @see #notCancelled()
	 * @see #process(Element)
	 */
	public final EList processPreOrderAllInstances() {
		return (new PreOrderTraversal(this)).visitWorkspaceInstanceModels();
	}

	/**
	 * Visits all the {@link ComponentInstance} objects in the given instance
	 * model in prefix order. Takes into account the current mode when
	 * traversing the content hierarchy of model instances.
	 * <p>
	 * This method checks {@link #notCancelled()} after visiting each element,
	 * and terminates the processing if the traversal has been cancelled.
	 *
	 * @param obj The root object for the traversal.
	 * @return The value of {@link #resultList}. The contents of this list
	 *         depend on the implementation of {@link #process}/{@link #action}.
	 * @see #cancelTraversal()
	 * @see #notCancelled()
	 * @see #process(Element)
	 */
	public final EList<Element> processPreOrderComponentInstance(final ComponentInstance obj) {
		processObject(obj);
		final EList<Element> list = obj.getChildren();
		for (Iterator<Element> it = list.iterator(); notCancelled() && it.hasNext();) {
			final Element child = it.next();
			if (child instanceof ComponentInstance) {
				this.processPreOrderComponentInstance((ComponentInstance) child);
			}
		}
		return resultList;
	}

	/**
	 * Visits all the {@link ComponentInstance} objects of the given category in
	 * the given instance model in prefix order. Takes into account the current
	 * mode when traversing the content hierarchy of model instances.
	 * <p>
	 * This method checks {@link #notCancelled()} after visiting each element,
	 * and terminates the processing if the traversal has been cancelled.
	 *
	 * @param obj The root object for the traversal.
	 * @param cat The category of the component instances to visit.
	 * @return The value of {@link #resultList}. The contents of this list
	 *         depend on the implementation of {@link #process}/{@link #action}.
	 * @see #cancelTraversal()
	 * @see #notCancelled()
	 * @see #process(Element)
	 */
	public final EList<Element> processPreOrderComponentInstance(final ComponentInstance obj,
			final ComponentCategory cat) {
		// Only process if the category matches
		if (obj.getCategory() == cat) {
			processObject(obj);
		}
		// always scan the children
		final EList<?> list = obj.getChildren();
		for (Iterator<?> it = list.iterator(); notCancelled && it.hasNext();) {
			final Element child = (Element) it.next();
			if (child instanceof ComponentInstance) {
				final ComponentInstance ci = (ComponentInstance) child;
				this.processPreOrderComponentInstance(ci, cat);
			}
		}
		return resultList;
	}

	/**
	 * process a single model element. When true is returned do not recurse to the element's children.
	 * By Default, if suchThat is satisfied invoke the action and return true.
	 * Otherwise do not take an action and return false.
	 * This lets use visit the first layer of elements in the hierarchy that satisfy suchThat.
	 * Using the default action, this effectively lets us create a list of "leaf" elements,
	 * i.e., elements that satisfy suchThat.
	 * @param theElement
	 * @return Boolean true if children should not be visited
	 */
	protected boolean processStop(Element theElement) {
		if (suchThat(theElement)) {
			if (theElement instanceof NamedElement) {
				// { System.out.println(((NamedElement) theElement).getName());}
				action(theElement);
			}
			return true;
		}
		return false;
	}

	/**
	 * Modifies processPreOrderComponentInstance to stop processing down
	 * when a component with error model is found
	 * If the suchThat method returned true, it means an error model subclause was found
	 * and we stop traversing the model down
	 *
	 * Does preorder processing of Component Instance containment hierarchy
	 * Takes into account the current mode when traversing the content hierarchy
	 * of model instances The default implementation applies the suchThat
	 * condition and if true adds the element to the result list
	 *
	 * @param obj
	 *                 InstanceObject root object
	 * @return EList result list of objects that have been visited by any traversal with the given ForAllElement
	 *
	 */
	public final EList processPreOrderComponentInstanceStop(ComponentInstance obj) {
		if (!processStop(obj)) {
			EList list = obj.getChildren();
			for (Iterator it = list.iterator(); notCancelled() && it.hasNext();) {
				Object child = it.next();
				if (child instanceof ComponentInstance) {
					processPreOrderComponentInstanceStop((ComponentInstance) child);
				}
			}
		}
		return resultList;
	}

	/*
	 * ============================================================= Postfix
	 * order traversal
	 * =============================================================
	 */

	/**
	 * Does postorder processing of the model starting at the given node. In
	 * case of instance models, takes into account the current mode when
	 * traversing the content hierarchy of model instances.
	 * <p>
	 * This method checks {@link #notCancelled()} after visiting each element,
	 * and terminates the processing if the traversal has been cancelled.
	 *
	 * @param obj The root object of the traversal.
	 * @return The value of {@link #resultList}. The contents of this list
	 *         depend on the implementation of {@link #process}/{@link #action}.
	 * @see #cancelTraversal()
	 * @see #notCancelled()
	 * @see #process(Element)
	 */
	public final EList<Element> processPostOrderAll(final Element obj) {
		(new PostOrderTraversal(this)).visitRoot(obj);
		return resultList;
	}

	/**
	 * Does postorder processing of the model starting at the given root nodes.
	 * The subtree rooted at each node in the list is visited in its entirety
	 * before the next root node is visited. In case of instance models, takes
	 * into account the current mode when traversing the content hierarchy of
	 * model instances.
	 * <p>
	 * This method checks {@link #notCancelled()} after visiting each element,
	 * and terminates the processing if the traversal has been cancelled.
	 *
	 * @param objlist The roots nodes to be visited.
	 * @return The value of {@link #resultList}. The contents of this list
	 *         depend on the implementation of {@link #process}/{@link #action}.
	 * @see #cancelTraversal()
	 * @see #notCancelled()
	 * @see #process(Element)
	 */
	public final EList processPostOrderAll(final EList objlist) {
		return (new PostOrderTraversal(this)).visitList(objlist);
	}

	/**
	 * Process all AADL models in the AadlWorkspace in postfix order. In case of
	 * instance models, takes into account the current mode when traversing the
	 * content hierarchy of model instances.
	 * <p>
	 * This method checks {@link #notCancelled()} after visiting each element,
	 * and terminates the processing if the traversal has been cancelled.
	 *
	 * @return The value of {@link #resultList}. The contents of this list
	 *         depend on the implementation of {@link #process}/{@link #action}.
	 * @see #cancelTraversal()
	 * @see #notCancelled()
	 * @see #process(Element)
	 */
	public final EList processPostOrderAll() {
		return (new PostOrderTraversal(this)).visitWorkspace();
	}

	/**
	 * Process all declarative AADL models in the AadlWorkspace in postfix
	 * order.
	 * <p>
	 * This method checks {@link #notCancelled()} after visiting each element,
	 * and terminates the processing if the traversal has been cancelled.
	 *
	 * @return The value of {@link #resultList}. The contents of this list
	 *         depend on the implementation of {@link #process}/{@link #action}.
	 * @see #cancelTraversal()
	 * @see #notCancelled()
	 * @see #process(Element)
	 */
	public final EList processPostOrderAllDeclarativeModels() {
		return (new PostOrderTraversal(this)).visitWorkspaceDeclarativeModels();
	}

	/**
	 * Process all AADL instance models in the AadlWorkspace in postfix order.
	 * Takes into account the current mode when traversing the content hierarchy
	 * of model instances.
	 * <p>
	 * This method checks {@link #notCancelled()} after visiting each element,
	 * and terminates the processing if the traversal has been cancelled.
	 *
	 * @return The value of {@link #resultList}. The contents of this list
	 *         depend on the implementation of {@link #process}/{@link #action}.
	 * @see #cancelTraversal()
	 * @see #notCancelled()
	 * @see #process(Element)
	 */
	public final EList processPostOrderAllInstances() {
		return (new PostOrderTraversal(this)).visitWorkspaceInstanceModels();
	}

	/**
	 * Visits all the {@link ComponentInstance} objects in the given instance
	 * model in post fix order. Takes into account the current mode when
	 * traversing the content hierarchy of model instances.
	 * <p>
	 * This method checks {@link #notCancelled()} after visiting each element,
	 * and terminates the processing if the traversal has been cancelled.
	 *
	 * @param obj The root object for the traversal.
	 * @return The value of {@link #resultList}. The contents of this list
	 *         depend on the implementation of {@link #process}/{@link #action}.
	 * @see #cancelTraversal()
	 * @see #notCancelled()
	 * @see #process(Element)
	 */
	public final EList<Element> processPostOrderComponentInstance(final ComponentInstance obj) {
		final EList<Element> list = obj.getChildren();
		for (Iterator<Element> it = list.iterator(); notCancelled() && it.hasNext();) {
			final Element child = it.next();
			if (child instanceof ComponentInstance) {
				this.processPostOrderComponentInstance((ComponentInstance) child);
			}
		}
		if (notCancelled()) {
			processObject(obj);
		}
		return resultList;
	}

	/**
	 * Visits all the {@link ComponentInstance} objects that are of the given
	 * component category (e.g., system, data, thread, etc.) in the given
	 * instance model in post fix order. Takes into account the current mode
	 * when traversing the content hierarchy of model instances.
	 * <p>
	 * This method checks {@link #notCancelled()} after visiting each element,
	 * and terminates the processing if the traversal has been cancelled.
	 *
	 * @param obj The root object for the traversal.
	 * @param cat The category.
	 * @return The value of {@link #resultList}. The contents of this list
	 *         depend on the implementation of {@link #process}/{@link #action}.
	 * @see #cancelTraversal()
	 * @see #notCancelled()
	 * @see #process(Element)
	 */
	public final EList<Element> processPostOrderComponentInstance(final ComponentInstance obj,
			final ComponentCategory cat) {
		final EList<Element> list = obj.getChildren();
		for (Iterator<Element> it = list.iterator(); notCancelled() && it.hasNext();) {
			final Element child = it.next();
			if (child instanceof ComponentInstance) {
				this.processPostOrderComponentInstance((ComponentInstance) child);
			}
		}
		// Only process if the category matches
		if (notCancelled() && (obj.getCategory() == cat)) {
			processObject(obj);
		}
		return resultList;
	}

	/*
	 * ============================================================= Top down
	 * classifier traversal
	 * =============================================================
	 */

	/**
	 * Visits all the Component Classifiers used in subtree rooted at the given
	 * node in a prefix order. That is, given a component implementation, it
	 * <ol>
	 * <li>visits the component implementation
	 * <li>visits the component type
	 * <li>For each subcomponent (including subprogram subcomponents)
	 * <ul>
	 * <li>recursively visits the component implementation of the subcomponent,
	 * if the full component implementation is given.
	 * <li>visits the component type of the subcomponent, if given
	 * </ul>
	 * </ol>
	 * <p>
	 * A particular classifier may be visited more than once.
	 * <p>
	 * This method checks {@link #notCancelled()} after visiting each element,
	 * and terminates the processing if the traversal has been cancelled.
	 *
	 * @param root The root node.
	 * @return The value of {@link #resultList}. The contents of this list
	 *         depend on the implementation of {@link #process}/{@link #action}.
	 * @see #cancelTraversal()
	 * @see #notCancelled()
	 * @see #process(Element)
	 */
	public final EList<Element> processTopDownComponentClassifier(final ComponentImplementation root) {
		(new TopDownComponentClassifierTravseral(this)).visitRoot(root);
		return resultList;
	}

	/**
	 * Process all declarative AADL models in the AadlWorkspace according to the
	 * top-down component-classifier ordering; see
	 * {@link #processTopDownComponentClassifier(ComponentImplementation)} for more
	 * information.
	 * <p>
	 * This method checks {@link #notCancelled()} after visiting each element,
	 * and terminates the processing if the traversal has been cancelled.
	 *
	 * @return The value of {@link #resultList}. The contents of this list
	 *         depend on the implementation of {@link #process}/{@link #action}.
	 * @see #cancelTraversal()
	 * @see #notCancelled()
	 * @see #process(Element)
	 */
	public final EList processTopDownComponentClassifierAllDeclarativeModels() {
		return (new TopDownComponentClassifierTravseral(this)).visitWorkspaceDeclarativeModels();
	}

	/*
	 * ============================================================= Top down
	 * component implementation traversal
	 * =============================================================
	 */

	/**
	 * Visits all the Component Implementations used in the subtree rooted at
	 * the given node in a prefix order. That is, given a component
	 * implementation, it
	 * <ol>
	 * <li>visits the component implementation
	 * <li>For each subcomponent (including subprogram subcomponents) it
	 * recursively visits the component implementation of the subcomponent, if
	 * the full component implementation is given.
	 * </ol>
	 * <p>
	 * A particular classifier may be visited more than once.
	 * <p>
	 * This method checks {@link #notCancelled()} after visiting each element,
	 * and terminates the processing if the traversal has been cancelled.
	 *
	 * @param root The root node.
	 * @return The value of {@link #resultList}. The contents of this list
	 *         depend on the implementation of {@link #process}/{@link #action}.
	 * @see #cancelTraversal()
	 * @see #notCancelled()
	 * @see #process(Element)
	 */
	public final EList processTopDownComponentImpl(final ComponentImplementation root) {
		(new TopDownComponentImplTraversal(this)).visitRoot(root);
		return resultList;
	}

	/**
	 * Process all declarative AADL models in the AadlWorkspace according to the
	 * top-down component implementation ordering; see
	 * {@link #processTopDownComponentImpl(ComponentImplementation)} for more information.
	 * <p>
	 * This method checks {@link #notCancelled()} after visiting each element,
	 * and terminates the processing if the traversal has been cancelled.
	 *
	 * @return The value of {@link #resultList}. The contents of this list
	 *         depend on the implementation of {@link #process}/{@link #action}.
	 * @see #cancelTraversal()
	 * @see #notCancelled()
	 * @see #process(Element)
	 */
	public final EList processTopDownComponentImpl() {
		return (new TopDownComponentImplTraversal(this)).visitWorkspaceDeclarativeModels();
	}

	/*
	 * ============================================================= Top down
	 * component implementation traversal
	 * =============================================================
	 */

	/**
	 * Visits all the component implementations in the subtree rooted at the
	 * given node in reverse containment order. That is, a component
	 * implementation is visited before all the component implementations that
	 * reference it.
	 * <p>
	 * This method checks {@link #notCancelled()} after visiting each element,
	 * and terminates the processing if the traversal has been cancelled.
	 *
	 * @return The value of {@link #resultList}. The contents of this list
	 *         depend on the implementation of {@link #process}/{@link #action}.
	 * @see #cancelTraversal()
	 * @see #notCancelled()
	 * @see #process(Element)
	 */
	public final EList processBottomUpComponentImpl(final ComponentImplementation root) {
		(new BottomUpComponentImplTraversal(this)).visitRoot(root);
		return resultList;
	}

	/**
	 * Visits all the component implementations in the workspace in reverse
	 * containment order. That is, a component implementation is visited before
	 * all the component implementations that reference it.
	 * <p>
	 * This method checks {@link #notCancelled()} after visiting each element,
	 * and terminates the processing if the traversal has been cancelled.
	 *
	 * @return The value of {@link #resultList}. The contents of this list
	 *         depend on the implementation of {@link #process}/{@link #action}.
	 * @see #cancelTraversal()
	 * @see #notCancelled()
	 * @see #process(Element)
	 */
	public final EList<?> processBottomUpComponentImpl() {
		return (new BottomUpComponentImplTraversal(this)).visitWorkspaceDeclarativeModels();
	}

	/*
	 * ============================================================= All
	 * component implementations
	 * =============================================================
	 */

	/**
	 * Visits all component implementations in the workspace.
	 * <p>
	 * This method checks {@link #notCancelled()} after visiting each element,
	 * and terminates the processing if the traversal has been cancelled.
	 *
	 * @return The value of {@link #resultList}. The contents of this list
	 *         depend on the implementation of {@link #process}/{@link #action}.
	 * @see #cancelTraversal()
	 * @see #notCancelled()
	 * @see #process(Element)
	 */
	public final EList processAllComponentImpl() {
		return processEList(AadlUtil.getAllComponentImpl());
	}

	/*
	 * ============================================================= Batch
	 * processing methods
	 * =============================================================
	 */

	/**
	 * Run a series of traversals over a set of resources, recording those that
	 * passed and those that failed. Each traversal is run over the all the
	 * resources before the next analysis is run. Only those resources that pass
	 * analysis <code>j</code> are analyzed by analysis <code>j+1</code>.
	 * Pass/fail is determined by whether the the number of errors on the
	 * resource increased after an analysis was run. Errors are determined by
	 * checking the error count (via
	 * {@link edu.cmu.sei.aadl.model.pluginsupport.ErrorReporter#getNumErrors()}
	 * ) on the error reporter associated with each Resource. The union of the
	 * returned set with the elements added to <code>outputBad</code> equals
	 * <code>inputResourceSet</code>.
	 *
	 * @param inputResourceSet Set of resources to analyse. The analysis is run
	 *            on each resource in turn. The resources are assumed to be AADL
	 *            Object models, that is the {@link Resource#getContents()}
	 *            returns a one-element list whose element is an
	 *            {@link edu.cmu.sei.aadl.model.core.AadlSpec} object.
	 * @param switches The analyses to run, as an array of length >= 1. Each
	 *            analysis is invoked using its
	 *            {@link #defaultTraversal(Element) default traversal}
	 * @param outputBad Set that is modified by the method to include all
	 *            elements of <code>inputResourceSet</code> that fail the series
	 *            analyses.
	 * @return An unmodifiable set of those elements of
	 *         <code>inputResourceSet</code> that pass <em>all</em> the
	 *         analyses.
	 */
	public static Set<Resource> processResources(final Set<? extends Resource> inputResourceSet,
			final ForAllElement[] switches, final Set<? super Resource> outputBad) {
		if (switches.length == 0) {
			throw new IllegalArgumentException("Array of switches is zero-length");
		}
		Set<Resource> currentInput = new HashSet<Resource>(inputResourceSet);
		for (int i = 0; i < switches.length; i++) {
			currentInput = switches[i].processResources(currentInput, outputBad);
		}
		/*
		 * Must go through loop at least once, so currentInput will never alias
		 * inputResourceSet, although it may be a clone of it. Return value of
		 * processResources(...) is already unmodifiable.
		 */
		return currentInput;
	}

	/**
	 * Run a series of traversals over a set of resources, recording those that
	 * passed and those that failed. Each traversal is run over the all the
	 * resources before the next analysis is run. This method differs from
	 * {@link #processResources(Set, ForAllElement[], Set)} in that all the
	 * traversals are run over all the resources regardless of whether a
	 * previous traversal failed. Errors are determined by checking the error
	 * count (via
	 * {@link edu.cmu.sei.aadl.model.pluginsupport.ErrorReporter#getNumErrors()}
	 * ) on the error reporter associated with each Resource. The union of the
	 * returned set with the elements added to <code>outputBad</code> equals
	 * <code>inputResourceSet</code>.
	 *
	 * @param inputResourceSet Set of resources to analyse. The analysis is run
	 *            on each resource in turn. The resources are assumed to be AADL
	 *            Object models, that is the {@link Resource#getContents()}
	 *            returns a one-element list whose element is an
	 *            {@link edu.cmu.sei.aadl.model.core.AadlSpec} object.
	 * @param switches The analyses to run, as an array of length >= 1. Each
	 *            analysis is invoked using its
	 *            {@link #defaultTraversal(Element) default traversal}
	 * @param outputBad Set that is modified by the method to include all
	 *            elements of <code>inputResourceSet</code> that fail the series
	 *            analyses.
	 * @return An unmodifiable set of those elements of
	 *         <code>inputResourceSet</code> that pass <em>all</em> the
	 *         analyses.
	 */
	public static Set<Resource> processResourcesIgnoreFailure(final Set<? extends Resource> inputResourceSet,
			final ForAllElement[] switches, final Set<? super Resource> outputBad) {
		if (switches.length == 0) {
			throw new IllegalArgumentException("Array of switches is zero-length");
		}
		final Set<Resource> bad = new HashSet<Resource>();
		for (int i = 0; i < switches.length; i++) {
			switches[i].processResources(inputResourceSet, bad);
		}
		final Set<Resource> result = new HashSet<Resource>(inputResourceSet);
		result.removeAll(bad);
		outputBad.addAll(bad);
		return Collections.unmodifiableSet(result);
	}

	/**
	 * Run the {@link #defaultTraversal(Element) default traversal} over a set
	 * of resources, recording those that passed and those that failed.
	 * Pass/fail is determined by whether the the number of errors on the
	 * resource&mdash;as determined by error manager associated with the
	 * traversal object&mdash;increased after the analysis was run. The union of
	 * the return value and the elements added to <code>outputBad</code> equals
	 * <code>inputResourceSet</code>.
	 *
	 * @param inputResourceSet Set of resources to analyse. The analysis is run
	 *            on each resource in turn. The resources are assumed to be AADL
	 *            Object models, that is the {@link Resource#getContents()}
	 *            returns a one-element list whose element is an
	 *            {@link edu.cmu.sei.aadl.model.core.AadlSpec} object.
	 * @param outputBad Set that is modified by the method to include all
	 *            elements of <code>inputResourceSet</code> that fail the
	 *            analysis.
	 * @return An unmodifiable set of those elements of
	 *         <code>inputResourceSet</code> that pass <em>all</em> the
	 *         analyses.
	 */
	public final Set<Resource> processResources(final Set<? extends Resource> inputResourceSet,
			final Set<? super Resource> outputBad) {
		final Set<Resource> good = new HashSet<Resource>();
		for (final Resource r : inputResourceSet) {
			final EList<EObject> rc = r.getContents();
			final AnalysisErrorReporter errReporter = errManager.getReporter(r);
			final int errCountBefore = errReporter.getNumErrors();

			if (!rc.isEmpty()) {
				EObject o = rc.get(0);
				this.defaultTraversal((Element) o);
			}

			if (errReporter.getNumErrors() > errCountBefore) {
				outputBad.add(r);
			} else {
				good.add(r);
			}
		}
		return Collections.unmodifiableSet(good);
	}

	/**
	 * Run a series of traversals over a tree rooted at a given Element. If a
	 * particular traversal fails, i.e., it generates errors in the error
	 * reporter, then the subsequent traversals are not performed.
	 *
	 * @param root The Element that is the root of the tree to traverse.
	 * @param switches The analyses to run, as an array of length >= 1. Each
	 *            analysis is invoked using its
	 *            {@link #defaultTraversal(Element) default traversal}
	 * @return The index of the last traversal to be successfully run. So if all
	 *         the traversals were successful this value will be
	 *         <code>switches.length-1</code>. If none of the traversals were
	 *         successful, this value is <code>-1</code>.
	 */
	public static int processTree(final Element root, final ForAllElement[] switches) {
		if (switches.length == 0) {
			throw new IllegalArgumentException("Array of switches is zero-length");
		}
		final Resource rsrc = root.eResource();
		int lastSuccessful = -1;
		boolean failed = false;
		for (int i = 0; !failed && i < switches.length; i++) {
			final AnalysisErrorReporter errReporter = switches[i].getErrorManager().getReporter(rsrc);
			final int beforeCount = errReporter.getNumErrors();
			switches[i].defaultTraversal(root);
			if (errReporter.getNumErrors() > beforeCount) {
				failed = true;
			} else {
				lastSuccessful = i;
			}
		}
		return lastSuccessful;
	}

	/**
	 * Run a series of traversals over a tree rooted at a given Element. All
	 * traversals are run over the tree regardless of whether a previous
	 * traversal failed.
	 *
	 * @param root The Element that is the root of the tree to traverse.
	 * @param switches The analyses to run, as an array of length >= 1. Each
	 *            analysis is invoked using its
	 *            {@link #defaultTraversal(Element) default traversal}
	 */
	public static void processTreeIgnoreFailure(final Element root, final ForAllElement[] switches) {
		if (switches.length == 0) {
			throw new IllegalArgumentException("Array of switches is zero-length");
		}
		for (int i = 0; i < switches.length; i++) {
			switches[i].defaultTraversal(root);
		}
	}

	/*
	 * ============================================================= Error
	 * reporting methods
	 * =============================================================
	 */

	/**
	 * Get the analysis error reporter manager associated with this traversal.
	 * @return the error manager
	 */
	public final AnalysisErrorReporterManager getErrorManager() {
		return errManager;
	}

	/**
	 * Report an internal error.
	 *
	 * @param message The error message.
	 */
	public final void internalError(final String message) {
		errManager.internalError(message);
	}

	/**
	 * Report an internal error.
	 *
	 * @param e The exception causing the error.
	 */
	public final void internalError(final Exception e) {
		errManager.internalError(e);
	}

	/**
	 * Report an error on an Element (AADL object model object) using the error
	 * reporter associated with that object's {@link Resource}.
	 *
	 * @param obj the object to which the marker is pointing
	 * @param msg the message as string
	 */
	public final void error(final Element obj, final String msg) {
		errManager.error(obj, msg);
	}

	public final void error(final Element obj, final String msg, final String[] attrs, final Object[] values) {
		errManager.error(obj, msg, attrs, values);
	}

	/**
	 * Report a warning on an Element (AADL object model object) using the error
	 * reporter associated with that object's {@link Resource}.
	 *
	 * @param obj the object to which the marker is pointing
	 * @param msg the message as string
	 */
	public final void warning(final Element obj, final String msg) {
		errManager.warning(obj, msg);
	}

	public final void warning(final Element obj, final String msg, final String[] attrs, final Object[] values) {
		errManager.warning(obj, msg, attrs, values);
	}

	/**
	 * Report an information message on an Element (AADL object model object)
	 * using the error reporter associated with that object's {@link Resource}.
	 *
	 * @param obj the object to which the marker is pointing
	 * @param msg the message as string
	 */
	public final void info(final Element obj, final String msg) {
		errManager.info(obj, msg);
	}

	public final void info(final Element obj, final String msg, final String[] attrs, final Object[] values) {
		errManager.info(obj, msg, attrs, values);
	}
}
