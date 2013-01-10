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

package org.osate.validation.lute;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.impl.NamedValueImpl;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.InstanceReferenceValue;
import org.osate.aadl2.properties.PropertyLookupException;
import org.osate.xtext.aadl2.properties.util.EMFIndexRetrieval;
import org.osate.xtext.aadl2.properties.util.PropertyUtils;

public class FnCallExpr extends Expr {
	final private String fn;
	final private List<Expr> args;

	public FnCallExpr(String fn, List<Expr> args) {
		super();
		this.fn = fn;
		this.args = args;
	}

	@Override
	public Val eval(Environment env) {
		ArrayList<Val> argValues = new ArrayList<Val>();
		for (Expr arg : args) {
			argValues.add(arg.eval(env));
		}
		
		if (fn.equals("Property")) {
			expectArgs(2);
			InstanceObject aadl = argValues.get(0).getAADL();
			String property = argValues.get(1).getString();
			Val result = getProperty(aadl, property);
			if (result == null) { 
				throw new LuteException("Failed to find property " + property);
			}
			return result;
			
		} else if (fn.equals("Property_Exists")) {
			expectArgs(2);
			InstanceObject aadl = argValues.get(0).getAADL();
			String property = argValues.get(1).getString();
			Val result = getProperty(aadl, property);
			return new BoolVal(result != null);
			
		} else if (fn.equals("Is_Bound_To")) {
			expectArgs(2);
			System.out.println( argValues.get(0));
			System.out.println( argValues.get(1));
			InstanceObject s = argValues.get(0).getAADL();
			InstanceObject t = argValues.get(1).getAADL();
			return new BoolVal(isBoundTo(s, t));
			
		} else if (fn.equals("Source")) {
			expectArgs(1);
			InstanceObject c = argValues.get(0).getAADL();
			if (c instanceof ConnectionInstance) {
				ConnectionInstance conn = (ConnectionInstance) c;
				return new AADLVal(conn.getSource());
			}
			throw new LuteException("Source called on non-connection object");
			
		} else if (fn.equals("Destination")) {
			expectArgs(1);
			InstanceObject c = argValues.get(0).getAADL();
			if (c instanceof ConnectionInstance) {
				ConnectionInstance conn = (ConnectionInstance) c;
				return new AADLVal(conn.getDestination());
			}

			throw new LuteException("Destination called on non-connection object");
			
		} else if (fn.equals("Member")) {
			expectArgs(2);
			Val e = argValues.get(0);
			//System.out.println (" e1 = " + e.getClass() );
			//System.out.println (" e2 = " + argValues.get(1).getClass() );

			Collection<Val> set = argValues.get(1).getSet();
			return new BoolVal(set.contains(e));
			
		} else if (fn.equals("Owner")) {
			expectArgs(1);
			InstanceObject e = argValues.get(0).getAADL();
			if (e.getOwner() instanceof InstanceObject) {
				InstanceObject owner = (InstanceObject) e.getOwner();
				return new AADLVal(owner);
			}
			throw new LuteException("Owner called on un-owned object");
			
		} else if (fn.equals("Is_Subcomponent_Of")) {
			/*
			 * Is_Subcomponent_Of looks if the component is
			 * contained in the whole hierarchy and browse the whole
			 * component tree, trying to look for a parent.
			 * If you do not want to navigate through the component
			 * hierarchy, use the Is_Direct_Subcomponent_Of
			 * function instead.
			 */
			expectArgs(2);
			InstanceObject sub = argValues.get(0).getAADL();

			InstanceObject top = argValues.get(1).getAADL();
			while (sub.getOwner() instanceof InstanceObject) {
				InstanceObject owner = (InstanceObject) sub.getOwner();
				if (top.equals(owner)) {
					return new BoolVal(true);
				}
				sub = owner;
			}
			return new BoolVal(false);
			
		} 
		else if (fn.equals("Is_Direct_Subcomponent_Of")) 
		{
			/*
			 * Is_Direct_Subcomponent_Of look if the component
			 * is directly a subcomponent of the other and does
			 * not look at the entire component hierarchy.
			 */
			expectArgs(2);
			InstanceObject sub = argValues.get(0).getAADL();

			InstanceObject top = argValues.get(1).getAADL();
			if (sub.getOwner() instanceof InstanceObject) {
				InstanceObject owner = (InstanceObject) sub.getOwner();
				if (top.equals(owner)) {
					return new BoolVal(true);
				}
			}
			return new BoolVal(false);
		}
		else if (fn.equals("Sum")) {
			BigInteger retInt = new BigInteger("0");
			SetVal sv = (SetVal) argValues.get(0);
			Iterator<Val> iter = sv.getSet().iterator();
			while (iter.hasNext())
			{
				Val tmp = iter.next();
				retInt = retInt.add(tmp.getInt());
			}
			
			return new IntVal(retInt);
		}
		else if (fn.equals("Max")) {
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
			
		} else if (fn.equals("Min")) {
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
			
		} else if (fn.equals("Cardinal")) 
		{
			expectArgs(1);
			Collection<Val> set = argValues.get(0).getSet();
			return new IntVal(set.size());
			
		} else if (fn.equals("Lower")) {
			expectArgs(1);
			RangeVal range = argValues.get(0).getRange();
			return range.getLower();
			
		} else if (fn.equals("Upper")) {
			expectArgs(1);
			RangeVal range = argValues.get(0).getRange();
			return range.getUpper();
			
		} else if (fn.equals("=")) {
			expectArgs(2);
			Val left = argValues.get(0);
			Val right = argValues.get(1);
			return new BoolVal(left.equals(right));
			
		} else if (fn.equals("!=")) {
			expectArgs(2);
			Val left = argValues.get(0);
			Val right = argValues.get(1);
			return new BoolVal(!left.equals(right));
			
		} else if (fn.equals(">")) {
			expectArgs(2);
			BigInteger left = argValues.get(0).getInt();
			BigInteger right = argValues.get(1).getInt();
			return new BoolVal(left.compareTo(right) > 0);
			
		} else if (fn.equals("<")) {
			expectArgs(2);
			BigInteger left = argValues.get(0).getInt();
			BigInteger right = argValues.get(1).getInt();
			return new BoolVal(left.compareTo(right) < 0);
			
		} else if (fn.equals(">=")) {
			expectArgs(2);
			BigInteger left = argValues.get(0).getInt();
			BigInteger right = argValues.get(1).getInt();
			return new BoolVal(left.compareTo(right) >= 0);
			
		} else if (fn.equals("<=")) {
			expectArgs(2);
			BigInteger left = argValues.get(0).getInt();
			BigInteger right = argValues.get(1).getInt();
			return new BoolVal(left.compareTo(right) <= 0);
			
		} else if (fn.equals("+")) {
			expectArgs(2);
			BigInteger left = argValues.get(0).getInt();
			BigInteger right = argValues.get(1).getInt();
			return new IntVal(left.add(right));
			
		} else if (fn.equals("-")) {
			expectArgs(2);
			BigInteger left = argValues.get(0).getInt();
			BigInteger right = argValues.get(1).getInt();
			return new IntVal(left.subtract(right));
			
		} else if (fn.equals("*")) {
			expectArgs(2);
			BigInteger left = argValues.get(0).getInt();
			BigInteger right = argValues.get(1).getInt();
			return new IntVal(left.multiply(right));
			
		} else {
			FunctionDefinition fd = env.lookupFn(fn);
			return fd.eval(argValues);
		}
	}
	
	private IntVal max(Collection<Val> vals) {
		if (vals.isEmpty()) {
			throw new LuteException("Max called with no arguments");
		}
		BigInteger r = vals.iterator().next().getInt();
		for (Val v : vals) {
			if (v.getInt().compareTo(r) > 0) {
				r = v.getInt();
			}
		}
		return new IntVal(r);
	}
	
	private IntVal min(Collection<Val> vals) {
		if (vals.isEmpty()) {
			throw new LuteException("Min called with no arguments");
		}
		BigInteger r = vals.iterator().next().getInt();
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
	
	private Val getProperty(InstanceObject aadl, String propName) {
		Property property = EMFIndexRetrieval.getPropertyDefinitionInWorkspace(propName);
		if (property == null) return null;
		try {
			PropertyExpression expr = PropertyUtils.getSimplePropertyValue(aadl, property);
			return AADLPropertyValueToValue(expr);
		} catch (PropertyLookupException e) {
			return null;
		}
	}

	private Val AADLPropertyValueToValue(PropertyExpression expr) {
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
			return new IntVal((long) lit.getScaledValue());
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
				return new StringVal (el.getName());
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
		} else 
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
		Property bindingProperty = EMFIndexRetrieval.getPropertyDefinitionInWorkspace(bindingPropertyName);
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
}
