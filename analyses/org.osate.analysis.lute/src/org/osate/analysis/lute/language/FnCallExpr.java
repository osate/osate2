/*
Copyright (c) 2011, Rockwell Collins.
Developed with the sponsorship of the Defense Advanced Research Projects Agency (DARPA).

Permission is hereby granted, free of charge, to any person obtaining a copy of this data, 
including any software or models in source or binary form, as well as any drawings, specifications, 
and documentation (collectively "the Data"), to deal in the Data without restriction, including
without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, 
and/or sell copies of the Data, and to permit persons to whom the Data is furnished to do so, 
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or 
substantial portions of the Data.

THE DATA IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
IN NO EVENT SHALL THE AUTHORS, SPONSORS, DEVELOPERS, CONTRIBUTORS, OR COPYRIGHT HOLDERS BE LIABLE 
FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
ARISING FROM, OUT OF OR IN CONNECTION WITH THE DATA OR THE USE OR OTHER DEALINGS IN THE DATA.
 */

/**
 * <copyright>
 * Copyright  2013 by Carnegie Mellon University, all rights reserved.
 * 
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 * 
 * NO WARRANTY
 * 
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE ''DELIVERABLES'') ARE ON AN ''AS-IS'' BASIS.
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
 * </copyright>
 * 
 */

package org.osate.analysis.lute.language;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.BasicProperty;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.Connection;
import org.osate.aadl2.DataPort;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.EventDataPort;
import org.osate.aadl2.EventPort;
import org.osate.aadl2.Feature;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.NumberValue;
import org.osate.aadl2.Port;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.ReferenceValue;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.UnitsType;
import org.osate.aadl2.impl.ContainmentPathElementImpl;
import org.osate.aadl2.impl.NamedValueImpl;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.InstanceReferenceValue;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException;
import org.osate.aadl2.properties.PropertyLookupException;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.aadl2.util.OsateDebug;
import org.osate.analysis.lute.LuteConstants;
import org.osate.analysis.lute.LuteException;
import org.osate.xtext.aadl2.properties.util.EMFIndexRetrieval;
import org.osate.xtext.aadl2.properties.util.GetProperties;
import org.osate.xtext.aadl2.properties.util.PropertyUtils;


public class FnCallExpr extends Expr {
	final private String fn;
	final private List<Expr> args;
	private Environment evaluationEnvironment = null;
	private Val getProperty( final List<Val> p_argValues )
	{
		
		expectArgs( p_argValues, new int[] { 2, 3 } );
		Val arg0 = p_argValues.get(0);
		
		if (arg0 instanceof SetVal)
		{
			Collection<Val> arg0Set = arg0.getSet();
			ArrayList<Val> result = new ArrayList<Val>();
			Val tmp;
			Iterator<Val> iter = arg0Set.iterator();
			while (iter.hasNext())
			{
				Val v = iter.next();
				List<Val> newArgs = new ArrayList<Val>();
				newArgs.add(v);
				newArgs.add(p_argValues.get(1));
				if ( p_argValues.size() == 3 )
				{
					newArgs.add(p_argValues.get(2));
				}
				Val toAdd = getProperty(newArgs);
				if (toAdd != null)
				{
					result.add(toAdd);
				}
			}
			return new SetVal(result);
		}
		
		final NamedElement aadl = p_argValues.get( 0 ).getAADL();
		final String property = p_argValues.get( 1 ).getString();
		Val result = null;

		if ( p_argValues.size() == 2 ) {
			result = getProperty( aadl, property );
		}
		else if ( p_argValues.size() == 3 ) {
			final String unit = p_argValues.get( 2 ).getString();
			result = getProperty( aadl, property, unit );
		}
		//
		// DB: Allow null values to be returned when no property association is defined.
		//		if ( result == null ) {
		//			throw new LuteException( "Failed to find property " + property );
		//		}

		return result;
	}
	public List<Expr> getArgs ()
	{
		return this.args;
	}

	public FnCallExpr(String fn, List<Expr> args) {
		super();
		this.fn = fn;
		this.args = args;
	}

	private static ComponentInstance lookUp ( ComponentInstance ci, String refName)
	{
		ComponentInstance ret;
		ret = null;
		for (Element e : ci.getChildren())
		{
			if (e instanceof ComponentInstance)
			{
				ComponentInstance ne = (ComponentInstance) e;
				if (ne.getName().equalsIgnoreCase(refName))
				{
					ret = ne;
				}
			}
		}
		return ret;

	}

	@Override
	public Val eval(Environment env) {
		ArrayList<Val> argValues = new ArrayList<Val>();
		evaluationEnvironment = env;
		for (Expr arg : args) {
			argValues.add(arg.eval(env));
		}


		if ( fn.equalsIgnoreCase( LuteConstants.PROPERTY ) ) {
			return getProperty( argValues );


		} else if (fn.equalsIgnoreCase(LuteConstants.PROPERTY_EXISTS)) {
			expectArgs(2);
			InstanceObject aadl = (InstanceObject) argValues.get(0).getAADL();
			String property = argValues.get(1).getString();
			Val result = getProperty(aadl, property);
			return new BoolVal(result != null);

		}
		else if ( fn.equalsIgnoreCase( LuteConstants.NAME ) ) {
			expectArgs( argValues, 1 );
			NamedElement aadl = (NamedElement) argValues.get(0).getAADL();
			return new StringVal (aadl.getName());
		} 
		else if (fn.equalsIgnoreCase (LuteConstants.IS_OF_TYPE)) {
			expectArgs(2);
			Classifier cl;
			cl = null;
			NamedElement obj = argValues.get(0).getAADL();
			if (obj instanceof InstanceObject)
			{
				InstanceObject aadl = (InstanceObject) obj;
				cl = aadl.getComponentInstance().getComponentClassifier();
			}
			if (obj instanceof Subcomponent)
			{
				Subcomponent aadl = (Subcomponent) obj;
				cl = aadl.getClassifier();
			}
			if (obj instanceof Classifier)
			{
				cl = (Classifier)obj;
			}
			String typeString = argValues.get(1).getString();
			return new BoolVal(checkType(cl, typeString));

		}
		else if (fn.equalsIgnoreCase (LuteConstants.IS_EVENT_DATA_PORT)) {
			expectArgs(1);
			NamedElement aadl = (NamedElement) argValues.get(0).getAADL();
			if (aadl instanceof FeatureInstance)
			{
				aadl = ((FeatureInstance)aadl).getFeature();
			}

				if (aadl instanceof EventDataPort)
				{
					return new BoolVal(true);
				}
			return new BoolVal(false);
		}
		else if (fn.equalsIgnoreCase (LuteConstants.IS_DATA_PORT)) {
			expectArgs(1);
			NamedElement aadl = (NamedElement) argValues.get(0).getAADL();
			if (aadl instanceof FeatureInstance)
			{
				aadl = ((FeatureInstance)aadl).getFeature();
			}

				if (aadl instanceof DataPort)
				{
					return new BoolVal(true);
				}
			return new BoolVal(false);
		}
		else if (fn.equalsIgnoreCase (LuteConstants.IS_EVENT_PORT)) {
			expectArgs(1);
			NamedElement aadl = (NamedElement) argValues.get(0).getAADL();
			if (aadl instanceof FeatureInstance)
			{
				aadl = ((FeatureInstance)aadl).getFeature();
			}
				if (aadl instanceof EventPort)
				{
					return new BoolVal(true);
				}
//				if (aadl instanceof EventDataPort)
//				{
//					return new BoolVal(true);
//				}
			return new BoolVal(false);
		}
		else if ( fn.equalsIgnoreCase( LuteConstants.PROPERTY_CONSTANT ) ) {
			return getPropertyConstant( argValues );
		}
		
		else if ( fn.equalsIgnoreCase( LuteConstants.LENGTH ) ) {
			expectArgs( argValues, 1 );
			final String strVal = argValues.get(0).getString();
			
			return new IntVal( strVal.length() );
		} 
		else if (fn.equalsIgnoreCase(LuteConstants.IS_BOUND_TO)) {
			expectArgs(2);

			NamedElement s = (NamedElement) argValues.get(0).getAADL();
			NamedElement t = (NamedElement) argValues.get(1).getAADL();
			if (s instanceof InstanceObject && t instanceof InstanceObject){
			return new BoolVal(isBoundTo((InstanceObject)s, (InstanceObject)t));
			}
			throw new LuteException("Is Bound To called on non-instance object");

		} else if (fn.equalsIgnoreCase(LuteConstants.SOURCE)) {
			expectArgs(1);
			InstanceObject c = (InstanceObject) argValues.get(0).getAADL();
			if (c instanceof ConnectionInstance) {
				ConnectionInstance conn = (ConnectionInstance) c;
				return new AADLVal(conn.getSource());
			} else if (c instanceof Connection){
				Connection conn = (Connection) c;
				return new AADLVal(conn.getAllSource());
			}
			throw new LuteException("Source called on non-connection object");

		} else if (fn.equalsIgnoreCase(LuteConstants.DESTINATION)) {
			expectArgs(1);
			InstanceObject c = (InstanceObject) argValues.get(0).getAADL();
			if (c instanceof ConnectionInstance) {
				ConnectionInstance conn = (ConnectionInstance) c;
				return new AADLVal(conn.getDestination());
			} else if (c instanceof Connection){
				Connection conn = (Connection) c;
				return new AADLVal(conn.getAllDestination());
			}

			throw new LuteException("Destination called on non-connection object");

		} else if (fn.equalsIgnoreCase(LuteConstants.HAS_OUT_PORTS)) {
			expectArgs(1);
			InstanceObject c = (InstanceObject) argValues.get(0).getAADL();
			if (c instanceof ComponentInstance) {
				int fis = 0;
				ComponentInstance comp = (ComponentInstance) c;
				for (FeatureInstance fi : comp.getFeatureInstances())
				{
					if ( (fi.getCategory() != FeatureCategory.DATA_PORT) &&
							(fi.getCategory() != FeatureCategory.EVENT_DATA_PORT) &&
							(fi.getCategory() != FeatureCategory.EVENT_PORT))
					{
						continue;
					}

					if ((fi.getDirection() == DirectionType.OUT) ||
							(fi.getDirection() == DirectionType.IN_OUT) )
					{
						fis++;
					}

				}
				return new BoolVal(fis != 0);
			} else if (c instanceof Classifier){
				int fis = 0;
				Classifier cl = (Classifier) c;
				for (Feature f: cl.getAllFeatures()){
					if (f instanceof Port&&AadlUtil.isOutgoingFeature(f)){
						fis++;
					}
				}
				return new BoolVal(fis != 0);
			}

			throw new LuteException("has_out_ports called on non-connection object");

		} else if (fn.equalsIgnoreCase(LuteConstants.HAS_IN_PORTS)) {
			expectArgs(1);
			InstanceObject c = (InstanceObject) argValues.get(0).getAADL();
			if (c instanceof ComponentInstance) {
				int fis = 0;
				ComponentInstance comp = (ComponentInstance) c;
				for (FeatureInstance fi : comp.getFeatureInstances())
				{
					if ( (fi.getCategory() != FeatureCategory.DATA_PORT) &&
							(fi.getCategory() != FeatureCategory.EVENT_DATA_PORT) &&
							(fi.getCategory() != FeatureCategory.EVENT_PORT))
					{
						continue;
					}

					if ((fi.getDirection() == DirectionType.IN) ||
							(fi.getDirection() == DirectionType.IN_OUT) )
					{
						fis++;
					}

				} 
				return new BoolVal(fis != 0);
			} else if (c instanceof Classifier){
				int fis = 0;
				Classifier cl = (Classifier) c;
				for (Feature f: cl.getAllFeatures()){
					if (f instanceof Port&&AadlUtil.isIncomingFeature(f)){
						fis++;
					}
				}
				return new BoolVal(fis != 0);
			}

			throw new LuteException("has_in_ports called on non-connection object");

		} 
		else if (fn.equalsIgnoreCase(LuteConstants.RECORD_VALUE))
		{
			expectArgs(2);
			Val record = argValues.get(0);

			Val member = argValues.get(1);
			String memberString = ((StringVal)member).getString();
			Val returned = ((RecordVal)record).getValue(memberString);
			return returned; 
			
		} 
		else if (fn.equalsIgnoreCase(LuteConstants.MEMBER))
		{
			expectArgs(2);
			Val e = argValues.get(0);

			Collection<Val> set = argValues.get(1).getSet();
			return new BoolVal(set.contains(e));

		} 
		else if (fn.equalsIgnoreCase(LuteConstants.OWNER)) {
			expectArgs(1);
			NamedElement e = (NamedElement) argValues.get(0).getAADL();
			if (e.getOwner() instanceof NamedElement) {
				NamedElement owner = (NamedElement) e.getOwner();
				return new AADLVal(owner);
			}
			throw new LuteException("Owner not a NamedElement");

		}
		else if (fn.equalsIgnoreCase(LuteConstants.GET_FEATURE)) {
			expectArgs(2);
			NamedElement ne = null;
			NamedElement e = (NamedElement) argValues.get(0).getAADL();
			String str = (String) argValues.get(1).getString();
			
			if (argValues.get(0).getAADL() instanceof InstanceObject)
			{
				ne = AadlUtil.findNamedElementInList(((ComponentInstance)e).getFeatureInstances(), str);
			} else if (e instanceof Classifier){
				ne = AadlUtil.findNamedElementInList(((Classifier)e).getAllFeatures(), str);
			}
			if (ne != null)
			{
				return new AADLVal(ne);
			}
			
			throw new LuteException("Cannot find the feature");

		}
		else if (fn.equalsIgnoreCase(LuteConstants.ASSOCIATED_DATA))
		{
			NamedElement dataType = null;
			expectArgs(1);
			NamedElement io = (NamedElement) argValues.get(0).getAADL();
			Feature f = null;
			if (io instanceof FeatureInstance)
			{
				f = ((FeatureInstance)io).getFeature();
			} else if (io instanceof Feature){
				f = (Feature) io;
			}

			if (f instanceof DataPort)
			{
				dataType = ((DataPort)f).getDataFeatureClassifier();
			}
			if (f instanceof EventDataPort)
			{
				dataType = ((DataPort)f).getDataFeatureClassifier();
			}
			if (dataType != null)
			{
				return new AADLVal (dataType);
			}
			throw new LuteException("Cannot find the data type");

		}
		else if (fn.equalsIgnoreCase(LuteConstants.ASSOCIATED_CLASSIFIER))
		{
			Classifier cl = null;
			expectArgs(1);
			NamedElement io = (NamedElement) argValues.get(0).getAADL();
			Subcomponent s = null;
			if (io instanceof ComponentInstance)
			{
				s = ((ComponentInstance)io).getSubcomponent();
			} else if (io instanceof Feature){
				s = (Subcomponent) io;
			}

			if (s != null)
			{
				cl = s.getClassifier();
			}
			if (cl != null)
			{
				return new AADLVal (cl);
			}
			throw new LuteException("Object does not have classifier");

		}
		else if ( fn.equalsIgnoreCase( LuteConstants.DIVIDE ) ) {
			expectArgs( argValues, 2 );
			
			final Number left = getNumberValue( argValues.get( 0 ) );
			final Number right = getNumberValue( argValues.get( 1 ) );
			final Number result = NumberUtil.divide( left, right );
			
			return createNumberValue( result );
		}
		else if (fn.equalsIgnoreCase( LuteConstants.FIRST ) ) {
			expectArgs( argValues, 1 );
			final List<Val> set = argValues.get(0).getSet();
			
			if ( set.isEmpty() ) {
				throw new LuteException( "Set " + set + " is empty." );
			}
			
			return set.get( 0 );
		} 
		
		else if (fn.equalsIgnoreCase( LuteConstants.AT ) ) {
			expectArgs( argValues, 2 );
			final List<Val> set = argValues.get( 0 ).getSet();
			
			if ( set.isEmpty() ) {
				throw new LuteException( "Set " + set + " is empty." );
			}

			final Long index = argValues.get( 1 ).getInt();
			
			return set.get( index.intValue() );
		} 
		
		else if ( fn.equalsIgnoreCase( LuteConstants.LAST ) ) {
			expectArgs( argValues, 1 );
			final List<Val> set = argValues.get(0).getSet();
			
			if ( set.isEmpty() ) {
				throw new LuteException( "Set " + set + " is empty." );
			}
			
			return set.get( set.size() - 1 );
		} 
		else if ( fn.equalsIgnoreCase( LuteConstants.POWER ) ) {
			expectArgs( argValues, 2 );

			final Number left = getNumberValue( argValues.get( 0 ) );
			final Number right = getNumberValue( argValues.get( 1 ) );
			final Number result = NumberUtil.power( left, right );
			
			return createNumberValue( result );
		}
		else if (fn.equalsIgnoreCase(LuteConstants.IS_SUBCOMPONENT_OF)) {
			/*
			 * Is_Subcomponent_Of looks if the component is
			 * contained in the whole hierarchy and browse the whole
			 * component tree, trying to look for a parent.
			 * If you do not want to navigate through the component
			 * hierarchy, use the Is_Direct_Subcomponent_Of
			 * function instead.
			 */
			expectArgs(2);
			NamedElement sub = (NamedElement) argValues.get(0).getAADL();

			NamedElement top = (NamedElement) argValues.get(1).getAADL();
			while (sub.getOwner() instanceof InstanceObject) {
				InstanceObject owner = (InstanceObject) sub.getOwner();
				if (top.equals(owner)) {
					return new BoolVal(true);
				}
				sub = owner;
			}
			return new BoolVal(false);

		} 
		else if (fn.equalsIgnoreCase(LuteConstants.IS_DIRECT_SUBCOMPONENT_OF)) 
		{
			/*
			 * Is_Direct_Subcomponent_Of look if the component
			 * is directly a subcomponent of the other and does
			 * not look at the entire component hierarchy.
			 */
			expectArgs(2);
			NamedElement sub = (NamedElement) argValues.get(0).getAADL();

			NamedElement top = (NamedElement) argValues.get(1).getAADL();
			NamedElement owner = (NamedElement) sub.getOwner();
			if (top.equals(owner)) {
				return new BoolVal(true);
			}
			return new BoolVal(false);
		}
		else if ( fn.equalsIgnoreCase( LuteConstants.SUM ) ) {
			if (argValues.size() == 1) {
				Val arg = argValues.get(0);
				if (arg instanceof SetVal) {
					SetVal set = (SetVal) arg;
					
					return sum(set.getSet());
				}
					
				return arg;
			}
				
			return sum(argValues);
		} 
		else if ( fn.equalsIgnoreCase( LuteConstants.CONCAT ) ) {
			expectArgs( 2 );
			final String left = argValues.get(0).getString();
			final String right = argValues.get(1).getString();

			return new StringVal( left + right );
		} 
		else if (fn.equalsIgnoreCase(LuteConstants.MAX)) {
			if (argValues.size() == 1) {
				Val arg = argValues.get(0);
				if (arg instanceof SetVal) {
					SetVal set = (SetVal) arg;
					return max(set.getSet());
				} else {
					return arg;
				}
			} else {
				return max(argValues);
			}

		} else if (fn.equalsIgnoreCase(LuteConstants.MIN)) {
			if (argValues.size() == 1) {
				Val arg = argValues.get(0);
				if (arg instanceof SetVal) {
					SetVal set = (SetVal) arg;
					return min(set.getSet());
				} else {
					return arg;
				}
			} else {
				return min(argValues);
			}

		} else if (fn.equalsIgnoreCase(LuteConstants.CARDINAL)) 
		{
			expectArgs(1);
			Collection<Val> set = argValues.get(0).getSet();
			return new IntVal(set.size());

		} else if (fn.equalsIgnoreCase(LuteConstants.LOWER)) {
			expectArgs(1);
			RangeVal range = argValues.get(0).getRange();
			return range.getLower();

		} else if (fn.equalsIgnoreCase(LuteConstants.UPPER)) {
			expectArgs(1);
			RangeVal range = argValues.get(0).getRange();
			return range.getUpper();

		} else if (fn.equalsIgnoreCase(LuteConstants.EQUALS)) {
			expectArgs(2);
			Val left = argValues.get(0);
			Val right = argValues.get(1);
			if ((left == null) || (right == null))
			{
				OsateDebug.osateDebug("[FnCallExpr] one arg is null");
				return new BoolVal (false);
			}
			return new BoolVal(left.equals(right));

		} else if (fn.equalsIgnoreCase(LuteConstants.NOT_EQUALS)) {
			expectArgs(2);
			Val left = argValues.get(0);
			Val right = argValues.get(1);
			return new BoolVal(!left.equals(right));

		} 

		else if ( fn.equalsIgnoreCase( LuteConstants.GREATER_THAN ) ) {
			expectArgs( argValues, 2 );
			final Number left = getNumberValue( argValues.get(0) );
			final Number right = getNumberValue( argValues.get(1) );

			return new BoolVal( NumberUtil.isGreaterThan( left, right ) );
		} 
		
		else if ( fn.equalsIgnoreCase( LuteConstants.LESS_THAN )) {
			expectArgs( argValues, 2 );
			final Number left = getNumberValue( argValues.get(0) );
			final Number right = getNumberValue( argValues.get(1) );

			return new BoolVal( NumberUtil.isLessThan( left, right ) );
		} 

		else if ( fn.equalsIgnoreCase( LuteConstants.GREATER_THAN_OR_EQUALS ) ) {
			expectArgs( argValues, 2 );
			final Number left = getNumberValue( argValues.get(0) );
			final Number right = getNumberValue( argValues.get(1) );

			return new BoolVal( NumberUtil.isGreaterThanOrEqual( left, right ) );
		}
		
		else if ( fn.equalsIgnoreCase( LuteConstants.LESS_THAN_OR_EQUALS ) ) {
			expectArgs( argValues, 2 );
			final Number left = getNumberValue( argValues.get(0) );
			final Number right = getNumberValue( argValues.get(1) );

			return new BoolVal( NumberUtil.isLessThanOrEqual( left, right ) );
		} 
		
		else if (fn.equalsIgnoreCase( LuteConstants.PLUS ) ) {
			expectArgs( argValues, 2 );
			final Number left = getNumberValue( argValues.get(0) );
			final Number right = getNumberValue( argValues.get(1) );
			final Number result = NumberUtil.add( left, right );
			
			return createNumberValue( result );
		} 
		else if ( fn.equalsIgnoreCase( LuteConstants.MINUS ) ) {
			expectArgs( argValues, 2 );

			final Number left = getNumberValue( argValues.get(0) );
			final Number right = getNumberValue( argValues.get(1) );
			final Number result = NumberUtil.subtract( left, right );
			
			return createNumberValue( result );
		} else if ( fn.equalsIgnoreCase( LuteConstants.MULTIPLY ) ) {
			expectArgs( argValues, 2 );

			final Number left = getNumberValue( argValues.get(0) );
			final Number right = getNumberValue( argValues.get(1) );
			final Number result = NumberUtil.multiply( left, right );
			
			return createNumberValue( result );
		} else if (fn.equalsIgnoreCase("Hex")) {
			expectArgs(1);
			Long i = argValues.get(0).getInt();
			return new StringVal("16#" + i.toString(16) + "#");

		} else {
			FunctionDefinition fd = env.lookupFn(fn);
			return fd.eval(argValues);
		}
	}

	public String toString ()
	{
		String res = "";
		res += fn + " with (";
		for (int i = 0 ; i < args.size() ; i++)
		{	
			res += " " + args.get(i);
			if (i < args.size() - 1)
			{
				res += " and ";
			}
		}
		res += ")";
		return res;
	}

	private IntVal max(Collection<Val> vals) {
		if (vals.isEmpty()) {
			throw new LuteException( "Max called with no arguments." );
		}
		
		Long  r = vals.iterator().next().getInt();
		
		for (Val v : vals) {
			if (v.getInt().compareTo(r) > 0) {
				r = v.getInt();
			}
		}
		
		return new IntVal(r);
	}
	
	private IntVal min(Collection<Val> vals) {
		if (vals.isEmpty()) {
			throw new LuteException( "Min called with no arguments." );
		}

		Long r = vals.iterator().next().getInt();
		for (Val v : vals) {
			if (v.getInt().compareTo(r) < 0) {
				r = v.getInt();
			}
		}
		return new IntVal(r);
	}
	private void expectArgs(int n) {
		if (!(args.size() == n)) {
			throw new LuteException("Function " + fn + " expects " + n + " arguments");
		}
	}

	private void expectArgs( 	final List<Val> p_values,
			int... p_allowedSizes ) {
		if ( p_values != null ) {
			for ( final Val value : p_values ) {
				if ( value == null ) {
					final StringBuilder message = new StringBuilder( "Function " );
					message.append( fn );
					message.append( " cannot handle null values." );

					throw new LuteException( message.toString() );
				}
			}
		}

		for ( final int expSize : p_allowedSizes ) {
			if ( p_values.size() == expSize ) {
				return;
			}
		}

		final StringBuilder message = new StringBuilder( "Function " );
		message.append( fn );
		message.append( " expects " );
		int ctr = 1;

		for ( final int expSize :  p_allowedSizes ) {
			message.append( expSize );

			if ( ctr < p_allowedSizes.length ) {
				message.append( " or " );
				ctr++;
			}
		}

		message.append( " arguments" );

		throw new LuteException( message.toString() );
	}

	private boolean checkType(Classifier aadl, String typeName)
	{
		boolean r;
		//OsateDebug.osateDebug("aadl comp" + aadl.getComponentInstance().getComponentClassifier());
		//OsateDebug.osateDebug("type=" + typeName);
		r = aadl.getName().toLowerCase().contains(typeName.toLowerCase());
		//OsateDebug.osateDebug("return " + r);
		return r;
	}



//	private Val getProperty(InstanceObject aadl, String propName) 
//	{
//		PropertyExpression expr;
//		Property property = EMFIndexRetrieval.getPropertyDefinitionInWorkspace(aadl,propName);
//		if (property == null)
//		{
//			return null;
//		}
//		try {
//			if (! property.isList())
//			{
//				expr = PropertyUtils.getSimplePropertyValue(aadl, property);
//			}
//			else
//			{
//				expr = PropertyUtils.getSimplePropertyListValue(aadl, property);
//			}
//			Val res = AADLPropertyValueToValue(expr);
//			return res;
//		} catch (PropertyLookupException e)
//		{
//			e.printStackTrace();
//			return (new StringVal (""));
//		}
//	}

	private Val AADLPropertyValueToValue(PropertyExpression expr) {
		//OsateDebug.osateDebug("expr=" + expr);
		if (expr == null) {
			return null;
		} else if (expr instanceof BooleanLiteral) {
			BooleanLiteral lit = (BooleanLiteral) expr;
			return new BoolVal(lit.getValue());
		} else if (expr instanceof StringLiteral) {
			StringLiteral lit = (StringLiteral) expr;
			return new StringVal(lit.getValue());
		} else if (expr instanceof IntegerLiteral) {
			IntegerLiteral lit = (IntegerLiteral) expr;
			// FIXME: JD
			// the getScaledValue method can raise some issues
			// when using size.
			//return new IntVal((long) lit.getScaledValue());

			return new IntVal((long) lit.getValue());
		} else if (expr instanceof RangeValue) {
			RangeValue range = (RangeValue) expr;
			return new RangeVal(
					AADLPropertyValueToValue(range.getMinimumValue()),
					AADLPropertyValueToValue(range.getMaximumValue()),
					AADLPropertyValueToValue(range.getDelta())
					);
		} else if (expr instanceof InstanceReferenceValue) {
			InstanceReferenceValue irv = (InstanceReferenceValue) expr;
			return new AADLVal(irv.getReferencedInstanceObject());
		}
		else if (expr instanceof NamedValue) {
			NamedValueImpl nv = (NamedValueImpl)expr;

			if (nv.getNamedValue() instanceof EnumerationLiteral)
			{
				EnumerationLiteral el = (EnumerationLiteral) nv.getNamedValue();
				Val res = new StringVal (el.getName().toLowerCase());
				return res;
			}
			throw new LuteException("NamedValue not implemented now " + nv );
		}
		else if (expr instanceof ListValue) {
			ListValue lv = (ListValue) expr;
			ArrayList<Val> list = new ArrayList<Val>();
			for (PropertyExpression pe : lv.getOwnedListElements()) {
				list.add(AADLPropertyValueToValue(pe));
			}
			return new SetVal(list);
		} 
		else if (expr instanceof ReferenceValue) {
			String refName;
			ComponentInstance ref;

			ref = null;

			ReferenceValue rv = (ReferenceValue) expr;

			ContainmentPathElementImpl cpei = (ContainmentPathElementImpl)rv.getChildren().get(0);
			NamedElement ne = cpei.getNamedElement();

			refName = ne.getName();
			Element e = cpei.getOwner();
			while ((e != null) && (! ( e instanceof SystemInstance)))
			{
				if (e instanceof ComponentInstance)
				{
					ComponentInstance ci = (ComponentInstance)e;

					ref = lookUp (ci, refName);
					break;
				}
				e = e.getOwner();
			}

			return new AADLVal(ref);
		}else 
		{

			throw new LuteException("Unknown AADL property value " + expr + " ("+expr.getOwner()+")on " + expr.getContainingClassifier());
		}
	}

	private boolean isBoundTo(InstanceObject s, InstanceObject t) {
		if (t instanceof ComponentInstance) {
			ComponentInstance platform = (ComponentInstance) t;
			if (platform.getCategory() == ComponentCategory.PROCESSOR) {
				return checkBinding(s, "actual_processor_binding", t);
			} else if (platform.getCategory() == ComponentCategory.VIRTUAL_PROCESSOR) {
				return checkBinding(s, "actual_processor_binding", t);
			} else if (platform.getCategory() == ComponentCategory.MEMORY) {
				return checkBinding(s, "actual_memory_binding", t);
			} else if (platform.getCategory() == ComponentCategory.BUS) {
				return checkBinding(s, "actual_connection_binding", t);
			}
		}
		throw new LuteException("Invalid arguments to is_bound_to");
	}

	private boolean checkBinding(InstanceObject s, String bindingPropertyName, InstanceObject t) {
		Property bindingProperty = EMFIndexRetrieval.getPropertyDefinitionInWorkspace(s,bindingPropertyName);
		PropertyExpression bindings = PropertyUtils.getSimplePropertyValue(s, bindingProperty);
		if (bindings instanceof ListValue) {
			ListValue list = (ListValue) bindings;
			for (PropertyExpression binding : list.getOwnedListElements()) {
				if (binding instanceof InstanceReferenceValue) {
					InstanceReferenceValue irv = (InstanceReferenceValue) binding;
					if (t.equals(irv.getReferencedInstanceObject())) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public List<InstanceObject> getRelatedComponents ()
	{
		ArrayList<InstanceObject> ret = new ArrayList<InstanceObject>();
		for (Expr e : args)
		{
			ret.addAll(e.getRelatedComponents());
			if(evaluationEnvironment != null)
			{
				ret.addAll(e.eval(evaluationEnvironment).getRelatedComponents());
			}
		}
		return ret;
	}


	private Val getProperty	(final NamedElement p_aadlElement, final String p_propertyName)
	{
		return getProperty( p_aadlElement, p_propertyName, null );
	}

	private Val getProperty (final NamedElement p_aadlElement, final String p_propertyName, final String p_unit ) {
		final Property propDef = getPropertyDefinition( p_aadlElement, p_propertyName );

		try {
			if ( propDef.isList() ) {
				final List<Val> list = new ArrayList<Val>();

				for ( final PropertyExpression propExprIter : p_aadlElement.getPropertyValueList( propDef ) ) {
					list.add( AADLPropertyValueToValue( p_aadlElement, propExprIter, p_unit ) );
				}

				return new SetVal( list );
			}

			final PropertyExpression propExpr = PropertyUtils.getSimplePropertyValue( p_aadlElement, propDef );

			return AADLPropertyValueToValue( p_aadlElement, propExpr, p_unit );
		}
		catch ( final PropertyNotPresentException p_ex ) {
			return null;
		}
		catch (PropertyDoesNotApplyToHolderException applyException)
		{ 
			throw new LuteException ("Property " + p_propertyName + " does not apply on component" + p_aadlElement.getName());
		}
	}


	private Property getPropertyDefinition( final EObject p_context,
			final String p_propertyName ) {
		final Property propDef = GetProperties.lookupPropertyDefinition( p_context, null, p_propertyName );

		if ( propDef == null ) {
			throw new LuteException( "Property " + p_propertyName + " is not defined." );
		}

		return propDef;
	}

	private UnitLiteral findUnitLiteral( 	final PropertyExpression p_propExpr,
			final String p_unit ) {
		if ( p_unit == null ) {
			return null;
		}


		EObject propContainer = p_propExpr.eContainer();

		while ( propContainer != null && !( propContainer instanceof PropertyAssociation ) && !( propContainer instanceof PropertyConstant ) ) {
			propContainer = propContainer.eContainer();
		}

		final UnitLiteral unitLit;

		if ( propContainer instanceof PropertyAssociation ) {
			unitLit = GetProperties.findUnitLiteral( ( (PropertyAssociation) propContainer ).getProperty(), p_unit );
		}
		else if ( propContainer instanceof PropertyConstant ) {
			final PropertyExpression propExpr = ( (PropertyConstant) propContainer ).getConstantValue();

			if ( ! ( propExpr instanceof NumberValue ) ) {
				throw new LuteException( "Property constant expression " + propExpr + " has no unit." );
			}

			final NumberValue numberVal = (NumberValue) propExpr;
			final UnitLiteral constantUnit = numberVal.getUnit();

			if ( constantUnit == null ) {
				throw new LuteException( "Property constant value " + propExpr + " has no unit." );
			}

			unitLit = GetProperties.findUnitLiteral( p_propExpr, ( (UnitsType) constantUnit.getOwner() ).getQualifiedName(), p_unit );
		}
		else {
			throw new LuteException( "Unknown unit " + p_unit );
		}

		return unitLit;
	}

	private Val AADLPropertyValueToValue (final NamedElement aadlElement, final PropertyExpression p_expr, final String p_unit ) {
		if ( p_expr == null ) {
			return null;
		} 

		if ( p_expr instanceof BooleanLiteral) {
			final BooleanLiteral lit = (BooleanLiteral) p_expr;

			return new BoolVal(lit.getValue());
		}

		if ( p_expr instanceof StringLiteral) {
			final StringLiteral lit = (StringLiteral) p_expr;

			return new StringVal(lit.getValue());
		}

		if ( p_expr instanceof NumberValue ) {
			final UnitLiteral unitLit;

			if ( p_unit == null ) {
				unitLit = null;
			}
			else {
				unitLit = findUnitLiteral( p_expr, p_unit );

				if ( unitLit == null ) {
					throw new LuteException( "Unknown unit: " + p_unit );
				}
			}

			if ( p_expr instanceof IntegerLiteral ) {
				final IntegerLiteral lit = (IntegerLiteral) p_expr;
				final long value;

				if ( unitLit == null ) {
					value = (long) lit.getScaledValue();
				}
				else {
					value = (long) lit.getScaledValue( unitLit );
				}

				return new IntVal( value );
			}

			if ( p_expr instanceof RealLiteral ) {
				final RealLiteral lit = (RealLiteral) p_expr;
				final double value;

				if ( unitLit == null ) {
					value = lit.getScaledValue();
				}
				else {
					value = lit.getScaledValue( unitLit );
				}

				return new RealVal( value );
			}
		}

		if ( p_expr instanceof RangeValue) {
			RangeValue range = (RangeValue) p_expr;

			return new RangeVal(
					AADLPropertyValueToValue( aadlElement, range.getMinimumValue(), p_unit ),
					AADLPropertyValueToValue( aadlElement, range.getMaximumValue(), p_unit ),
					AADLPropertyValueToValue( aadlElement, range.getDelta(), p_unit )
					);
		}

		if ( p_expr instanceof InstanceReferenceValue ) {
			final InstanceReferenceValue irv = (InstanceReferenceValue) p_expr;

			return new AADLVal( getReferencedObject( irv ) );
		}

		if ( p_expr instanceof ReferenceValue ) {
			ComponentInstance refCI;
			final ReferenceValue refValue = (ReferenceValue) p_expr;
			ComponentInstance ci = (ComponentInstance)aadlElement;
			PropertyExpression irv = ((ReferenceValue) refValue).instantiate(ci);
			refCI = null;
			if (irv instanceof InstanceReferenceValue)
			{
				refCI = (ComponentInstance) ((InstanceReferenceValue)irv).getReferencedInstanceObject();
			
			}
			return new AADLVal ( refCI );
		}

		if ( p_expr instanceof ListValue ) {
			final List<Val> values = new ArrayList<Val>();

			for ( final PropertyExpression propExprIter : ( (ListValue) p_expr ).getOwnedListElements() ) {
				values.add( AADLPropertyValueToValue( aadlElement, propExprIter, p_unit ) );
			}

			return new SetVal( values );
		}

		if (p_expr instanceof NamedValue)
		{
			NamedValue nv = (NamedValue) p_expr;
			String ret = null;
			if (nv.getNamedValue() instanceof EnumerationLiteral)
			{
				EnumerationLiteral el = (EnumerationLiteral) nv.getNamedValue();
				ret = el.getName();
			}
			if (ret != null)
			{
				return new StringVal (ret);	
			}		
		}
		
		if (p_expr instanceof RecordValue)
		{
			RecordValue rv = (RecordValue) p_expr;
			RecordVal returnedValue = new RecordVal();
			
			EList<BasicPropertyAssociation> fields = rv.getOwnedFieldValues();
			for (BasicPropertyAssociation propertyAssociation : fields) {
				BasicProperty prop = propertyAssociation.getProperty();
				String fieldnamename = prop.getName().toLowerCase();
				returnedValue.add (fieldnamename, AADLPropertyValueToValue(aadlElement, propertyAssociation.getValue(),null));
			}
			
			return 	returnedValue;
		}
		throw new LuteException( "Unknown AADL property value " + p_expr );
	}


	private NamedElement getReferencedObject( final InstanceReferenceValue p_propertyValue ) {
		return p_propertyValue.getReferencedInstanceObject() ;
	}

	private NamedElement getReferencedObject( final ReferenceValue p_propertyValue ) {
		return p_propertyValue.getContainmentPathElements().get( 0 ).getNamedElement();
		//									PropertyExpression irv = ((ReferenceValue) elem).instantiate(ci);

	}

	
	private Val getPropertyConstant( final List<Val> p_argValues ) {
		expectArgs( p_argValues, new int[] { 1, 2 } );

		final String property = p_argValues.get( 0 ).getString();
		Val result = null;
		
		if ( p_argValues.size() == 1 ) {
			result = getPropertyConstant( property );
		}
		else if ( p_argValues.size() == 2 ) {
			final String unit = p_argValues.get( 1 ).getString();
			result = getPropertyConstant( property, unit );
		}
//
		// DB: Allow null values to be returned when no property association is defined.
//		if ( result == null ) {
//			throw new LuteException( "Failed to find property " + property );
//		}
		
		return result;
	}
	
	private Val getPropertyConstant( final String p_propertyName )
	{
		final PropertyConstant propConst = EMFIndexRetrieval.getPropertyConstantInWorkspace( OsateResourceUtil.getResourceSet(), p_propertyName );
		if (propConst != null)
		{
			return AADLPropertyValueToValue( null, propConst.getConstantValue(), null );
		}
		return null;
	}
	
	
	private Val getPropertyConstant( 	final String p_propertyName,
										final String p_unit ) {
		final PropertyConstant propConst = EMFIndexRetrieval.getPropertyConstantInWorkspace( OsateResourceUtil.getResourceSet(), p_propertyName );
		
		return AADLPropertyValueToValue( null, propConst.getConstantValue(), p_unit );
	}
	
	private Number getNumberValue( final Val p_value ) {
		if ( p_value instanceof IntVal ) {
			return p_value.getInt();
		}

		return p_value == null ? null : p_value.getReal();
	}
	
	private Val createNumberValue( final Number p_value ) {
//		if ( p_value instanceof BigInteger ) {
//			return new IntVal( ( (BigInteger) p_value ).longValue() );
//		}

		if ( p_value instanceof Long ) {
			return new IntVal( (Long) p_value );
		}

		if ( p_value instanceof Integer ) {
			return new IntVal( (Integer) p_value );
		}

//		if ( p_value instanceof BigDecimal ) {
//			return new RealVal( ( (BigDecimal) p_value ).doubleValue() );
//		}

		if ( p_value instanceof Double ) {
			return new RealVal( (Double) p_value );
		}

		if ( p_value instanceof Float ) {
			return new RealVal( (Float) p_value );
		}
		
		throw new LuteException( "Unknown number type " + p_value );
	}
	
	private RealVal sum(Collection<Val> vals) {
		if (vals.isEmpty()) {
			throw new LuteException( "Sum called with no arguments." );
		}
		
		Number total = Double.valueOf( 0.0 );
		
		for ( final Val value : vals ) {
			final Number valueToAdd = getNumberValue( value );
			
			total = NumberUtil.add( total, valueToAdd );
		}
		
//		if ( total instanceof BigDecimal ) {
//			return new RealVal( ( (BigDecimal) total );
//		}

		return new RealVal( total.doubleValue() );
	}
}
