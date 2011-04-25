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
 *
 * $Id: AadlPropertyCheckSwitch.java,v 1.57 2010-04-02 17:48:10 jseibel Exp $
 */
package org.osate.aadl2.parser;



/**
 * Checks AADL model semantics relating to properites.  Assumes
 * that the model passes regular AADL semantic checking.
 *
 * @author aarong
 */
/*
 * XXX: Commented out entire class to remove error markers.  Not currently used in Aadl 2 beta.
 * Need to check if this should be used after implementing the Xtext parser.
 */
public final class AadlPropertyCheckSwitch /*extends AadlProcessingSwitch */{
//	private PropertyDefinition OVERFLOW_HANDLING_PROTOCOL_PD;
//	private PropertyDefinition QUEUE_SIZE_PD;
//	private PropertyDefinition QUEUE_PROCESSING_PROTOTOCOL_PD ;
//	private PropertyDefinition DEQUEUE_PROTOCOL_PD;
//	
//	/**
//     * create switch with Resource of AObject as target for markers
//     */
//    public AadlPropertyCheckSwitch(final AnalysisErrorReporterManager manager) {
//    	super(PROCESS_PRE_ORDER_ALL, manager);
//    	
//    	// TODO: Should really do something if these lookups fail...
//		OVERFLOW_HANDLING_PROTOCOL_PD =
//			OsateResourceManager.findPropertyDefinition(
//					AadlProperties.OVERFLOW_HANDLING_PROTOCOL); 
//		QUEUE_SIZE_PD =
//			OsateResourceManager.findPropertyDefinition(
//					AadlProperties.QUEUE_SIZE); 
//		QUEUE_PROCESSING_PROTOTOCOL_PD =
//			OsateResourceManager.findPropertyDefinition(
//					AadlProperties.QUEUE_PROCESSING_PROTOTOCOL); 
//		DEQUEUE_PROTOCOL_PD =
//			OsateResourceManager.findPropertyDefinition(
//					AadlProperties.DEQUEUE_PROTOCOL); 
//    }
//    
//    protected final void initSwitches() {
//		coreSwitch = new CoreSwitch() {
//			public Object caseAadlPackageSection(AadlPackageSection ps) {
//				checkPropertyAssocs(ps);
//				return DONE;
//			}
//			public Object caseMode(Mode m) {
//				checkPropertyAssocs(m);
//				return DONE;
//			}
//			public Object caseComponentClassifier(ComponentClassifier cc){
//				checkPropertyAssocs(cc);
//				return DONE;
//			}
//			public Object caseSubcomponent(Subcomponent sc){
//				checkPropertyAssocs(sc);
//				return DONE;
//			}
//			public Object caseFeature(Feature f){
//				checkPropertyAssocs(f);
//				return DONE;
//			}
//		};
//		
//		componentSwitch = new ComponentSwitch(){
//			/* replicated from Core instead of dropping through to core
//			 * the switch does not understand the type hierarchy across EMF packages
//			 */
//			public Object caseComponentClassifier(ComponentClassifier cc){
//				checkPropertyAssocs(cc);
//				return DONE;
//			}
//			public Object caseSubcomponent(Subcomponent sc){
//				checkPropertyAssocs(sc, true);
//				return DONE;
//			}
//			public Object caseThreadSubcomponent(ThreadSubcomponent ts) {
//				checkPropertyAssocs(ts);
//				return DONE;
//			}
//		};
//
//		featureSwitch = new FeatureSwitch(){
//			public Object casePortGroupType(PortGroupType f){
//				checkPropertyAssocs(f);
//				return DONE;
//			}
//			/* same as in core. The switch does not drop through */
//			public Object caseFeature(Feature f){
//				checkPropertyAssocs(f);
//				return DONE;
//			}
//		};
//		connectionSwitch = new ConnectionSwitch() {
//			/**
//			 * Add reference to refined connection
//			 */
//			public Object caseConnection(Connection conn) {
//				checkPropertyAssocs(conn);
//				return DONE;
//			}
//		};
//		propertySwitch = new PropertySwitch() {
//			public Object caseRangeValue(final RangeValue rv) {
//				final NumberValue deltaNV = rv.getDeltaValue();
//				if (deltaNV != null) {
//					final double delta = deltaNV.getScaledValue();
//					if (delta < 0) {
//						error(rv, "Range value has a negative delta component");
//					}
//				}
//				return DONE;
//			}
//			
//			public Object caseClassifierValue(ClassifierValue cv) {
//				final ComponentClassifier cc = cv.getComponentClassifier();
//				if (cc == null) {
//					return DONE;
//				}
//				final boolean good;
//				switch (cv.getValue().getValue()) {
//				case ComponentCategory.DATA:
//					good = cc instanceof DataClassifier;
//					break;
//				case ComponentCategory.SUBPROGRAM:
//					good = cc instanceof SubprogramClassifier;
//					break;
//				case ComponentCategory.THREAD:
//					good = cc instanceof ThreadClassifier;
//					break;
//				case ComponentCategory.THREAD_GROUP:
//					good = cc instanceof ThreadGroupClassifier;
//					break;
//				case ComponentCategory.PROCESS:
//					good = cc instanceof ProcessClassifier;
//					break;
//				case ComponentCategory.MEMORY:
//					good = cc instanceof MemoryClassifier;
//					break;
//				case ComponentCategory.PROCESSOR:
//					good = cc instanceof ProcessorClassifier;
//					break;
//				case ComponentCategory.BUS:
//					good = cc instanceof BusClassifier;
//					break;
//				case ComponentCategory.DEVICE:
//					good = cc instanceof DeviceClassifier;
//					break;
//				case ComponentCategory.SYSTEM:
//					good = cc instanceof SystemClassifier;
//					break;
//				default:
//					good = true;
//				}
//				
//				if (!good) {
//					error(cv, "Category of component classifier doesn't match the category of the classifier value");
//				}
//				return DONE;
//			}
//			
//			/**
//			 * Check that PropertyReference elements that are referenced
//			 * in boolean expressions have boolean type.
//			 */
//			public Object casePropertyReference(PropertyReference bopr) {
//				checkPropertyReference(bopr);
//				return DONE;
//			}
//
//			public Object casePropertyConstant(PropertyConstant pc) {
//				checkPropertyConstant(pc);
//				return DONE;
//			}
//
//			/**
//			 * Check ranges for correctness.
//			 */
//			public Object caseNumberType(NumberType nt) {
//				checkNumberType(nt);
//				return DONE;
//			}
//
//			public Object caseAadlinteger(final Aadlinteger ai) {
//				checkAadlinteger(ai);
//				return NOT_DONE; // Fall Trhough to NumberType
//			}
//
//			/**
//			 * check property definition
//			 */
//			public Object casePropertyDefinition(PropertyDefinition pd) {
//				checkPropertyDefinition(pd);
//				return DONE;
//			}
//		};
//		flowSwitch = new FlowSwitch() {
//			public Object caseFlowSpec(FlowSpec fs) {
//				checkPropertyAssocs(fs);
//				return DONE;
//			}
//			public Object caseFlowSequence(FlowSequence fs) {
//				checkPropertyAssocs(fs);
//				return DONE;
//			}
//		};
//	}
//
//	/**
//	 * Make sure that a PropertyReference object referenced as a
//	 * subclause of a boolean expression actually refers to a boolean-valued
//	 * property.  Also make sure that if the property reference is to a 
//	 * property definition, then the property holder or property definition 
//	 * that it is a part of should have a compatible applies to clause.
//	 */
//	protected void checkPropertyReference(final PropertyReference pr) {
//		final EObject parent = pr.eContainer();
//		final ReferencedProperty rp = pr.getReferencedProperty();
//		if (parent instanceof BooleanValue) {
//			final PropertyType pt = rp.getThePropertyType();
//			if (!(pt instanceof Aadlboolean) || rp.isList()) {
//				error(pr, "Not a reference to a boolean-valued property");
//			}
//		}
//		
//		if (rp instanceof PropertyDefinition) {
//			final PropertyDefinition refPD = (PropertyDefinition) rp;
//			/* Find the property making refernece to us.  It is either the PD
//			 * from a property association, or the enclosing PD if our use is
//			 * as a default value.
//			 */
//			PropertyDefinition pd = null;
//			EObject current = parent;
//			while (current != null) {
//				if (current instanceof PropertyAssociation) {
//					pd = ((PropertyAssociation) current).getPropertyDefinition();
//					break;
//				}
//				if (current instanceof PropertyDefinition) {
//					pd = (PropertyDefinition) current;
//					break;
//				}
//				current = current.eContainer();
//			}
//			
//			if (current == null) {
//				internalError("Couldn't find enclosing property association or property definition for property reference");
//			} else {
//				final List refAppliesTo = refPD.getAppliesto();
//				final List appliesTo = pd.getAppliesto();
//				if (!refAppliesTo.containsAll(appliesTo)) {
//					error(pr, "Referenced property definition does not apply to all the categories that the referring property applies to");
//				}
//
//				final List refAppliesToClass = new ArrayList();
//				for (final Iterator i = refPD.getAppliesToClassifier().iterator(); i.hasNext();) {
//					final ClassifierValue cv = (ClassifierValue) i.next();
//					refAppliesToClass.add(cv.getComponentClassifier());
//				}
//				final List appliesToClass = new ArrayList();
//				for (final Iterator i = pd.getAppliesToClassifier().iterator(); i.hasNext();) {
//					final ClassifierValue cv = (ClassifierValue) i.next();
//					appliesToClass.add(cv.getComponentClassifier());
//				}
//				if (!refAppliesToClass.containsAll(appliesToClass)) {
//					error(pr, "Referenced property definition does not apply to all the classifiers that the referring property applies to");
//				}
//				
//			}
//		}
//	}
//
//	public void checkProperties(EList pslist) {
//		this.processPreOrderAll(pslist);
//	}
//
//	/**
//	 * @param pn
//	 */
//	private void checkPropertyDefinition(final PropertyDefinition pn) {
//		// Check the access keyword
//		checkAccessKeyword(pn);
//
//		// Check the type correctness of the default value, if any
//		typeCheckPropertyValues(pn.getThePropertyType(), pn.isList(), pn.getDefaultpropertyValue());
//	}
//
//
//	private void checkPropertyConstant(final PropertyConstant pc) {
//		/* Check the type correctness of the values.  The parser enforces
//		 * some of this, but can't do it if the type is given by reference,
//		 * and it cannot check that a int or real is within range.
//		 */
//		typeCheckPropertyValues(pc.getThePropertyType(), pc.isList(), pc.getConstantValue());
//	}
//
//
//	/**
//	 * Check constraints on the use of the "access" keyword on property
//	 * definitions, as specified in SEction 10.1.2:
//	 *
//	 * <blockquote>The reserved word access is only permitted for property name
//	 * whose applies to property category list contains categories of
//	 * subcomponents that can be required or provided subcomponents. These
//	 * categories are data and bus. </blockquote>
//	 *
//	 * @param pn
//	 *            The property definition to check.
//	 */
//	private void checkAccessKeyword(final PropertyDefinition pn) {
//		// Access allowed only if applies to data/bus only.
//		if (pn.isAccess()) {
//			final EList appliesTo = pn.getAppliesto();
//
//			final boolean containsData =
//				appliesTo.contains(PropertyOwnerCategory.DATA_LITERAL);
//			final boolean containsBus =
//				appliesTo.contains(PropertyOwnerCategory.BUS_LITERAL);
//			final int size = appliesTo.size();
//			// Okay if set is {DATA}, {BUS}, {DATA, BUS}
//			final boolean okay =
//				((size == 1) && (containsBus || containsData))
//					|| ((size == 2) && containsBus && containsData);
//			if (!okay) {
//				error(pn,
//						"Access property only applies to data or bus");
//			}
//		}
//	}
//
//	private void checkPropertyAssocs(final PropertyHolder element) {
//		checkPropertyAssocs(element, false);
//	}
//
//	/**
//	 * check property associations for the aObject element
//	 * @param element aObject. It may not have a Properties object.
//	 */
//	private void checkPropertyAssocs(
//		final PropertyHolder element, final boolean isSubcomponent) {
//		final List assocs;
//		if (element instanceof Classifier) {
//			/* 15 February 2007: Not sure this what should really be done.
//			 * This breaks list +=> for one thing.  Taking this out for
//			 * the moment; it was put in on 6 Feb 2007.
//			 */
////			assocs = ((Classifier) element).getAllPropertyAssociation();
//			assocs = element.getPropertyAssociation();
//		} else {
//			assocs = element.getPropertyAssociation();
//		}
//		if (assocs == null) return;
//
//		// map: PropertyDeclaration -> set of mode-binding pairs
//		final Map propsToModes = new HashMap();
//		// 2 level map: PropertyDeclaration -> EList of propertry holders -> set of mode-binding pairs
//		final Map containedPropsToModes = new HashMap();
//		for (final Iterator iter = assocs.iterator(); iter.hasNext(); ) {
//			final PropertyAssociation pa = (PropertyAssociation) iter.next();
//			// check only if property name was resolved
//			final PropertyDefinition pd = pa.getPropertyDefinition();
//			if (pd != null)	{
//				/* This is where we should check constant property
//				 * associations, but it's too much work to do that.
//				 */
//				if (pa.isConstant()) {
//					warning(pa,
//							"Constant property associations are not checked");
//				}
//				
//				/* Check that the association follows the prop's  "applies to".
//				 * We don't check this for package sections because they are
//				 * allowed to declare assocations for any property.
//				 */
//				if (!(element instanceof AadlPackageSection)) {
//					checkAssociationAppliesTo(element, pa);
//				}
//
//				/* Check that this PA hasn't already associated a value with
//				 * the property (modulo modes).
//				 */
//				checkUniqueAssociation(element, propsToModes, pa);
//				checkUniqueContainedAssociation(element, containedPropsToModes, pa);
//				
//				// Check that the association has good "in modes"
//				checkInModes(element, pa);
//				
//				// Check that the assocation is type correct
//				typeCheckPropertyValues(pd.getThePropertyType(), pd.isList(), pa.getPropertyValue());
//
//				// Check access assocs: only allowed on bus data access features
//				checkAssociationAccess(element, pa);
//
//				// Check "list of" issues
//				checkListOf(pa);
//
//				// Check that Overflow_handling_protocol and Queue_size only
//				// appear on in event ports and in event data ports
//				checkPortProperties(element, pa);
//			}
//		}
//	}
//
//	private static class ModeBindingPair {
//		private final Mode mode;
//		private final ComponentClassifier binding;
//		
//		public ModeBindingPair(final Mode m, final ComponentClassifier cc) {
//			mode = m;
//			binding = cc;
//		}
//		
//		public boolean equals(final Object o) {
//			if (o instanceof ModeBindingPair) {
//				final ModeBindingPair mbp = (ModeBindingPair) o;
//				return ((mode == null && mbp.mode == null) || mode.equals(mbp.mode))
//					&& ((binding == null && mbp.binding == null) || binding.equals(mbp.binding));
//			} else {
//				return false;
//			}
//		}
//		
//		public int hashCode() {
//			final int hc1 = (mode == null) ? 0 : mode.hashCode();
//			final int hc2 = (binding == null) ? 0 : binding.hashCode();
//			return hc1 * 13 + hc2;
//		}
//		
//		public String toString() {
//			final String s1 = (mode == null) ? "none" : mode.getName();
//			final String s2 = (binding == null) ? "none" : binding.getQualifiedName();
//			return "(" + s1 + ", " + s2 + ")";
//		}
//	}
//	
//	private static final List NULL_LIST = Collections.singletonList(null);
//	
//	private static Set createPairs(final List modes, final List bindings) {
//		final Set pairs = new HashSet();
//		
//		final List modesList = (modes == null || modes.isEmpty()) ? NULL_LIST : modes;
//		final List bindingsList = (bindings == null || bindings.isEmpty()) ? NULL_LIST : bindings;		
//		for (final Iterator i = modesList.iterator(); i.hasNext();) {
//			final Mode mode = (Mode) i.next();
//			for (final Iterator j = bindingsList.iterator(); j.hasNext();) {
//				final ComponentClassifier binding = (ComponentClassifier) j.next();
//				pairs.add(new ModeBindingPair(mode, binding));
//			}
//		}
//		return pairs;
//	}
//	
//	private void checkUniqueAssociation(
//			final PropertyHolder ph, final Map propsToModes, final PropertyAssociation pa) {
//		if (pa.getAppliesTo() == null || pa.getAppliesTo().size() == 0) {
//			final PropertyDefinition pd = pa.getPropertyDefinition();
//			Set definedInModes = (Set) propsToModes.get(pd);
//			if (definedInModes == null) {
//				definedInModes = new HashSet();
//				propsToModes.put(pd, definedInModes);
//			}
//			checkForDuplicateAssociation(ph, pa, definedInModes);
//		}
//	}
//
//	private void checkUniqueContainedAssociation(
//			final PropertyHolder ph, 
//			final Map containedPropsToModes, final PropertyAssociation pa) {
//		final String appliesTo = unparseContainedAppliesToPath(pa);
//		if (appliesTo.length() > 0) {
//			final PropertyDefinition pd = pa.getPropertyDefinition();
//			Map subMap = (Map) containedPropsToModes.get(pd);
//			if (subMap == null) {
//				subMap = new HashMap();
//				containedPropsToModes.put(pd, subMap);
//			}
//			Set definedInModes = (Set) subMap.get(appliesTo);
//			if (definedInModes == null) {
//				definedInModes = new HashSet();
//				subMap.put(appliesTo, definedInModes);
//			}
//			checkForDuplicateAssociation(ph, pa, definedInModes);
//		}
//	}
//
//	/**
//	 * @param pa
//	 * @param definedInModes
//	 */
//	private void checkForDuplicateAssociation(
//			final PropertyHolder ph, 
//			final PropertyAssociation pa, Set definedInModes) {
//		final EList inModes = pa.getInModes();
//		final EList inBinding = pa.getInBinding();
//		final Set pairs = createPairs(inModes, inBinding);
//		final Set alreadyDefined = new HashSet();
//		for (final Iterator i = pairs.iterator(); i.hasNext(); ) {
//			final ModeBindingPair mbp = (ModeBindingPair) i.next();
//			if (definedInModes.contains(mbp)) {
//				alreadyDefined.add(mbp);
//			}
//		}
//		definedInModes.addAll(pairs);
//		
//		if (!alreadyDefined.isEmpty()) {
//			final String appliesTo = unparseContainedAppliesToPath(pa);
//			for (final Iterator i = alreadyDefined.iterator(); i.hasNext();) {
//				final ModeBindingPair mbp = (ModeBindingPair) i.next();
//				error(ph,
//						"\"" + ph.getName() + "\" has multiple property associations for \"" + 
//						pa.getPropertyDefinition().getQualifiedName() + "\"" +
//						((appliesTo.length() == 0) ? "" : (" applying to " + appliesTo)) +
//						((mbp.mode == null) ? "" : (" in mode " + mbp.mode.getName())) +
//						((mbp.binding == null) ? "" : (" in binding " + mbp.binding.getQualifiedName())));
//			}
//		}
//	}
//
//	private String unparseContainedAppliesToPath(final PropertyAssociation pa) {
//		final List appliesTo = pa.getAppliesTo();
//		final StringBuffer sb = new StringBuffer();
//		for (final Iterator i = appliesTo.iterator(); i.hasNext();) {
//			final NamedElement ne = (NamedElement) i.next();
//			sb.append(ne.getName());
//			if (i.hasNext()) sb.append('.');
//		}
//		return sb.toString();
//	}
//	
//	/**
//	 * Checks legality rule from Section 4.5 Subcomponents:
//	 *
//	 * <blockquote>If the subcomponent declaration contains an in_modes
//	 * statement and any of its property associations also contains an in_modes
//	 * statement, then the modes named in the property association must be a
//	 * subset of those named in the subcomponent declaration. </blockquote>
//	 *
//	 * @param element
//	 *            The property holder whose in_modes should be checked. This
//	 *            method is only interested in SubprogramSubcomponent,
//	 *            Subcomponent, Connection, and FlowSequence elements.
//	 *
//	 * @param pa
//	 *            The particular property association whose in_modes must be a
//	 *            subset of the modes in which <code>element</code> exists.
//	 */
//	private void checkInModes(final PropertyHolder element, final PropertyAssociation pa) {
//		final EList innerModes = pa.getInModes();
//		if (innerModes != null) {
//			EList outerModes = null;
//			if (element instanceof SubprogramSubcomponent) {
//				/* We need to treat SubprogramSubcomponents specially because
//				 * the modes they exist in are controlled by the CallSequence.
//				 */
//				final CallSequence cs = (CallSequence) element.eContainer();
//				outerModes = cs.getInModes();
//			} else if (element instanceof Subcomponent
//					|| element instanceof Connection
//					|| element instanceof FlowSequence) {
//				outerModes = ((ModeMember) element).getInModes();
//			}
//
//			if (outerModes != null) {
//				// Empty set means that no modes were declared, i.e., all modes
//				if (!outerModes.isEmpty()
//						&& !outerModes.containsAll(innerModes)) {
//					error(pa,
//							"Property association has more modes than its container");
//				}
//			}
//		}
//	}
//
//	/**
//	 * Check that non-list properties do not get associated with a list of
//	 * values:
//	 *
//	 * <blockquote>
//	 * If the property declaration for the associated property name
//	 * does not contain the reserved words list of, the property_value must be a
//	 * single_property_value. If the property declaration for the associated
//	 * property name contains the reserved words list of, the property_value can
//	 * be a single_property_value, which is interpreted to be a list of one
//	 * value.
//	 *
//	 * The property association operator +=> must only be used if the property
//	 * declaration for the associated property name contains the reserved words
//	 * list of.
//	 * </blockquote>
//	 *
//	 * @param pa
//	 */
//	private void checkListOf(final PropertyAssociation pa) {
//		final PropertyDefinition pn = pa.getPropertyDefinition();
//		if (pn == null)
//			return;
//		final EList value = pa.getPropertyValue();
//		if (!pn.isList()) {
//			// Must only have one value associated with the property
//			if (value == null || value.size() == 0) {
//				error(pa,
//						"Scalar properties must have a value");
//			} else if (value.size() > 1) {
//				error(pa,
//						"Scalar properties cannot be associated with a list");
//			}
//			if (pa.isAppend()) {
//				error(pa,
//						"Cannot append to a scalar property");
//			}
//		}
//	}
//
//	/**
//	 * Checks contraints on the <code>Overflow_Handling_Protocol</code>,
//	 * <code>Queue_Processing_Protocol</code>, <code>Dequeue_Protocol</code>,
//	 * <code>Queue_Size</code> properties as specificed in Section 8.1 Ports:
//	 *
//	 * <blockquote>The property names Overflow_Handling_Protocol,
//	 * Queue_Processing_Protocol, Dequeue_Protocol, and Queue_Size
//	 * may only appear in property associations for in event ports and in event
//	 * data ports. </blockquote>
//	 * 
//	 * <p>The <code>applies to</code> clause in the property definition
//	 * already makes sure they only appear on <code>event port</code> 
//	 * and <code>event data port</code> (and <code>subprogram</code> for all
//	 * but <code>Dequeue_Protocol</code>).  So here we check that the port 
//	 * is an <code>in port</code>.
//	 *
//	 * @param ph
//	 *            The property holder
//	 * @param pa
//	 *            The property association to check
//	 */
//	private void checkPortProperties(final PropertyHolder ph, final PropertyAssociation pa) {
//		if (ph instanceof EventPort || ph instanceof EventDataPort) {
//			final PropertyDefinition pd = pa.getPropertyDefinition();
//			if (pd == OVERFLOW_HANDLING_PROTOCOL_PD ||
//					pd == QUEUE_SIZE_PD ||
//					pd == QUEUE_PROCESSING_PROTOTOCOL_PD ||
//					pd == DEQUEUE_PROTOCOL_PD) {
//				final PortDirection dir = ((Port) ph).getAllDirection();
//				if (dir != PortDirection.IN_LITERAL) {
//					error(pa,
//							"Property \"" + pd.getName() +
//							"\" is only allowed on in event ports and in event data ports");
//				}
//			}
//		}
//	}
//
//	/**
//	 * Check constraints on the use of access property associations.
//	 *
//	 * <blockquote>The reserved word access is only permitted and is required
//	 * in property associations declared in required and provided access
//	 * subcomponent declarations and refinements </blockquote>
//	 *
//	 * @param element
//	 *            The property holder to check.
//	 * @param pa
//	 *            The property association to check.
//	 */
//	private void checkAssociationAccess(
//		final EObject element,
//		final PropertyAssociation pa) {
//		if (element instanceof ComponentAccess) {
//			if (!pa.isAccess()) {
//				error(pa,
//						"Property association for access features requires the keyword access before the value");
//			}
//		} else {
//			if (pa.isAccess()) {
//				error(pa,
//						"Property association should not use the keyword access before the value");
//			}
//		}
//	}
//
//	/**
//	 * Check constraints that property applies to the element it is associated
//	 * with per Section 10.3:
//	 *
//	 * <blockquote>The property named by a property association must list the
//	 * category of the component type, component implementation, subcomponent,
//	 * feature, connection, flow, or mode the property association is declared
//	 * for in its Property_Owner_Category list. </blockquote>
//	 */
//	private void checkAssociationAppliesTo(
//		final PropertyHolder element,
//		final PropertyAssociation pa) {
//		final PropertyDefinition pn = pa.getPropertyDefinition();
//		final EList appliesTo = pa.getAppliesTo();
//		if (appliesTo == null || appliesTo.size() == 0) {
//			final boolean applies = element.acceptsProperty(pn);
//			if (!applies) {
//				error(pa,
//						"Property "	+ pa.getQualifiedName() +
//						" only applies to " + unparseAppliesTo(pn));
////				error(pa,
////						"Property "	+ pa.getQualifiedName() +
////						" does not apply to " + element.eClass().getName());
//			}
//		} else {
//			// only the last value is interesing to us
//			final PropertyHolder ph = (PropertyHolder) appliesTo.get(appliesTo.size()-1);
//			final boolean applies = ph.acceptsProperty(pn);
//			if (!applies) {
//				error(pa,
//						"Property " + pa.getQualifiedName() +
//						" does not apply to named subcomponent");
//			}
//		}
//	}
//
//	/**
//	 * Check that a given list of PropertyValues are all of the given type.
//	 *
//	 * <blockquote>If a property expression list consists of a list of two or
//	 * more property expressions, all of those property expressions must be of
//	 * the same property type.
//	 *
//	 * In a property association, the type of the evaluated property expression
//	 * must match the property type of the named property.
//	 * </blockquote>
//	 *
//	 * @param pt
//	 *            The property type to check the values against
//	 * @param isList
//	 *            Whether to accept a list of values or not
//	 * @param values
//	 *            The values to check.
//	 */
//	private void typeCheckPropertyValues(
//			final PropertyType pt, final boolean isList, final EList values) {
//		if (pt != null && values != null) {
//			for (Iterator i = values.iterator(); i.hasNext();) {
//				final PropertyValue pv = (PropertyValue) i.next();
//				final String msg = pt.containsValue(isList, pv);
//				if (msg != PropertyType.VALUE_OKAY) {
//					error(pv,
//							"Property expression '" + pv.getValueAsString() +
//							"' has wrong type: " + msg);
//				}
//			}
//		}
//	}
//
//
//	/**
//	 * Check that a number type is well formed.  The range values (if any)
//	 * should be such that the lower bound is not greater than the upper bound.
//	 * Satisfies legality rule from Section 10.1.1:
//	 *
//	 * <blockquote>
//	 * The value of the first numeric literal that appears in a range of a
//	 * number_type must not be greater than the value of the second numeric
//	 * literal.
//	 * </blockquote>
//	 */
//	private void checkNumberType(final NumberType nt) {
//		/* NOTE: NumericResolver + Parser already make sure the bounds are
//		 * both reals or both integers, as appropriate.
//		 */
//		final NumberOrPropertyReference lowerref = nt.getLower();
//		final NumberOrPropertyReference upperref = nt.getUpper();
//		NumberValue lowerNV = null;
//		NumberValue upperNV = null;
//		if (lowerref != null) lowerNV = lowerref.getNumberValue();
//		if (upperref != null) upperNV = upperref.getNumberValue();
//		/* Both of lowerref and upperref should be set, or both should be null.
//		 * But even if both lowerref and upperref are non-null it is possible
//		 * for one of lowerNV or upperNV to be null because getNumberValue()
//		 * will return null if the NumberOrPropertyReference is a
//		 * PropertyReference whose ReferencedProperty is a property declaration
//		 * insteads of a property constant.  Thus, we must check both of
//		 * lowerNv and upperNV against null.
//		 */
//		if (lowerNV != null && upperNV != null) {
//			/* Check: (1) the bounds have units if the type has units;
//			 * (2) the lower bounds is <= the upper bound.
//			 */
//			if (nt.getTheUnitsType() != null) {
//				if (lowerNV.getUnitLiteral() == null) {
//					error(nt,
//							"lower bound is missing a unit");
//				}
//				if (upperNV.getUnitLiteral() == null) {
//					error(nt,
//							"upper bound is missing a unit");
//				}
//			}
//			final double lower = lowerNV.getScaledValue();
//			final double upper = upperNV.getScaledValue();
//			if (lower > upper) {
//				error(nt,
//						"Range lower bound is greater than range upper bound");
//			}
//		}
//	}
//
//	/**
//	 * Check that if an aadlinteger type has units that the units have only
//	 * integer multipliers.
//	 */
//	private void checkAadlinteger(final Aadlinteger ai) {
//		final UnitsType units = ai.getTheUnitsType();
//		if (units != null) {
//			for (Iterator i = units.getUnitLiteral().iterator(); i.hasNext();) {
//				final UnitLiteral ul = (UnitLiteral) i.next();
//				final NumberValue factor = ul.getFactor();
//				if (factor != null && !(factor instanceof IntegerValue)) {
//					error(ai,
//							"Integer type has unit (" + ul.getName() +
//							") with non-integer factor (" +
//							ul.getFactor().getValueString() + ")");
//				}
//			}
//		}
//	}
//
//	private static String unparseAppliesTo(final PropertyDefinition pd) {
//		final StringBuffer sb = new StringBuffer();
//		final EList at = pd.getAppliesto();
//		if (at.size() == PropertyOwnerCategory.VALUES.size()) {
//			sb.append("all");
//		} else {
//			for (final Iterator it = at.iterator(); it.hasNext();) {
//				final PropertyOwnerCategory pc = (PropertyOwnerCategory) it.next();
//				sb.append(pc.getUnparseName());
//				if (it.hasNext()) sb.append(", ");
//			}
//			final EList el = pd.getAppliesToClassifier();
//			for (final Iterator it = el.iterator(); it.hasNext();) {
//				final ClassifierValue cv = (ClassifierValue) it.next();
//				sb.append(", ");
//				sb.append(cv.getValue().getUnparseName());
//				final String qn = cv.getQualifiedClassifierName();
//				if (qn != null && qn.length() > 0) {
//					sb.append(' ');
//					sb.append(qn);
//				}
//			}
//		}
//		return sb.toString();
//	}
}

