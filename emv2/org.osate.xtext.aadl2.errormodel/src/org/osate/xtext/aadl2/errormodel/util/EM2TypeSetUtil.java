package org.osate.xtext.aadl2.errormodel.util;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.Element;
import org.osate.aadl2.util.OsateDebug;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelFactory;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeMapping;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeMappingSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeUseContext;

public class EM2TypeSetUtil {
	
	
	/**
	 * return the root ErrorType of ErrorType et
	 * @param et ErrorType
	 * @return ErrorType root
	 */
	public static ErrorType rootType(ErrorType et){
		while (et.getSuperType() != null){
			et = EMV2Util.resolveAlias(et.getSuperType());
		}
		return et;
	}
	
	/**
	 * true if both error types are in the same type hierarchy
	 * @param et1 ErrorType
	 * @param et2 ErrorType
	 * @return boolean
	 */
	public static boolean inSameTypeHierarchy(ErrorType et1, ErrorType et2){
		return rootType(et1)== rootType(et2);//XXX assumes the root types are not aliases. Assured by rootType
	}
	
	/**
	 * true if error type t1 is same type as t2
	 * @param t1
	 * @param t2
	 * @return
	 */
	public static boolean isSame(ErrorType t1, ErrorType t2){
		return EMV2Util.resolveAlias(t1) == EMV2Util.resolveAlias(t2);
	}
	
	/**
	 * true if error type is an alias
	 * @param et
	 * @return
	 */
	public static boolean isAlias(ErrorType et){
		return et.getAliasedType()!=null;
	}
	
	/**
	 * true if error type set is an alias
	 * @param et
	 * @return
	 */
	public static boolean isAlias(TypeSet ts){
		return ts.getAliasedType()!=null;
	}
	
	/**
	 * true if super type contains type as subtype
	 * aliases are resolved before the error types are compared
	 * @param supertype
	 * @param type
	 * @return boolean
	 */
	public static boolean contains(ErrorType supertype, ErrorType type){
		if (supertype == null ) return false;
		if ( type == null) return true;
		ErrorType resolvedtype = EMV2Util.resolveAlias(type);
		ErrorType resolvedsupertype = EMV2Util.resolveAlias(supertype);
		while (type != null){
			if (type==supertype||type == resolvedsupertype
					|| resolvedtype == supertype || resolvedtype == resolvedsupertype){
				return true;
			}else {
				type = type.getSuperType();
			}
		}
		return false;
	}
	
	/**
	 * true if TypeToken constraint contains ErrorType type as one of its product elements
	 * aliases are resolved before the error types are compared
	 * @param constraint TypeToken
	 * @param type ErrorType
	 * @return
	 */
	public static boolean contains(TypeToken constraint, ErrorType type){
//		if (constraint == null ) return false;
//		if ( type == null) return true;
		if (constraint.isNoError()) return false;
		EList<ErrorType> tsetype = constraint.getType();
		for (ErrorType errorType : tsetype) {
			if( contains(errorType,type)) return true;
		}
		return false;
	}
	
	/**
	 * true if TypeToken constraint contains TypeToken token
	 * aliases are resolved before the error types are compared
	 * @param constraint TypeToken
	 * @param token TypeToken
	 * @return
	 */
	public static boolean contains(TypeToken constraint, TypeToken token){
//		if (constraint == null ) return false;
//		if ( token == null) return true;
		if (token.isNoError()) return true;
		if (constraint.isNoError()){
			if (token.isNoError()) return true;
			return false;
		}
		if (constraint.getType().size() != token.getType().size()) return false;
		for (ErrorType errorType : token.getType()) {
			if (!contains(constraint, errorType)) return false;
		}	
		return true;
	}
	
	
	
	/**
	 * true if TypeSet ts contains TypeToken token
	 * The type set can represent a constraint
	 * aliases are resolved before the error types are compared
	 * @param ts TypeSet
	 * @param token TypeToken
	 * @return boolean
	 */
	public static boolean contains(TypeSet ts, TypeToken token){
		if (ts == null ) return true;
		if ( token == null) return true;
		if (token.isNoError()) return true;
		ts = EMV2Util.resolveAlias(ts);
		int toksize = token.getType().size();
		for (TypeToken tselement : ts.getTypeTokens()) {
			if (tselement.getType().size() == toksize){
				if( contains(tselement,token)) return true;
			}
		}
		return false;
	}
	
	/**
	 * true if TypeSet ts contains ErrorType et
	 * The type set can represent a constraint
	 * aliases are resolved before the error types are compared
	 * @param ts TypeSet
	 * @param et ErrorType
	 * @return boolean
	 */
	public static boolean contains(TypeSet ts, ErrorType et){
		if (ts == null ) return false;
		if ( et == null) return true;
		ts = EMV2Util.resolveAlias(ts);
		for (TypeToken tselement : ts.getTypeTokens()) {
				if( contains(tselement,et)) return true;
		}
		return false;
	}
	
	/**
	 * true if TypeSet ts contains TypeSet subts
	 * The type set can represent a constraint, i.e., product types, and Type matching are taken into account
	 * aliases are resolved before the error types are compared
	 * @param ts TypeSet
	 * @param subts TypeSet
	 * @return boolean
	 */
	public static boolean contains(TypeSet ts, TypeSet subts){
		if (ts == null ) return true;
		if ( subts == null) return true;
		ts = EMV2Util.resolveAlias(ts);
		subts = EMV2Util.resolveAlias(subts);
		EList<TypeToken> subelements = subts.getTypeTokens();
		for (TypeToken typeToken : subelements) {
			if (!contains(ts,typeToken)) return false;
		}
		return true;
	}

	
	
	/**
	 * returns all subtypes of the token that are in TypeSet ts 
	 * The type set can represent a constraint
	 * aliases are resolved before the error types are compared
	 * @param ts TypeSet
	 * @param token TypeToken
	 * @return list TypeToken
	 */
	public static Collection<TypeToken> getConstrainedTypeTokens(TypeSet ts, TypeToken token){
		BasicEList<TypeToken> result = new BasicEList<TypeToken>();
		if (token == null) return result;
		if (ts == null ) {
			result.add(token);
			return result;
		}
		ts = EMV2Util.resolveAlias(ts);
		int toksize = token.getType().size();
		for (TypeToken tselement : ts.getTypeTokens()) {
			if (tselement.getType().size() == toksize){
				getConstrainedTypeTokens(tselement, token, result);
			}
		}
		return result;
	}
	
	/**
	 * adds a type token that has the subtype of each product element of the two tokens
	 * The subtype can be from the constraint or the token
	 * The TypeToken error type lists are assumed to be of the same size
	 * @param ts TypeSet
	 * @param token TypeToken
	 * @param result List of type tokens
	 */
	protected static void getConstrainedTypeTokens(TypeToken constraint, TypeToken token, Collection<TypeToken> result){
		int toksize = token.getType().size();
		EList<ErrorType> toklist = token.getType();
		EList<ErrorType> conlist = constraint.getType();
		TypeToken tt = ErrorModelFactory.eINSTANCE.createTypeToken();
		for (int i = 0 ; i < toksize; i++) {
			ErrorType toktype = toklist.get(i);
			ErrorType contype = conlist.get(i);
			if (contains(toktype,contype)){
				tt.getType().add(contype);
			} else if (contains(contype, toktype)){
				tt.getType().add(toktype);
			} else {
				return ;
			}
		}
		result.add(tt);
		return ;
	}
	
	
	/**
	 * add type token for specified error type to newItems. Then add a token
	 * for each token in existing list with error type added.
	 * @param newItems list holding the newly added tokens
	 * @param etlist error subtypes of the next product element to be added 
	 * @return result list
	 */
	protected static EList<TypeToken> addItemSet(EList<TypeToken> newItems, EList<ErrorType> etlist){
		EList<TypeToken> result = new BasicEList<TypeToken>();
		for (TypeToken typeToken : newItems) {
			for (ErrorType et : etlist){
				TypeToken tu = EcoreUtil.copy(typeToken);
				tu.getType().add(et);
				result.add(tu);
			}
		}
			return result;
	}
	
	
	/**
	 * generate all type tokens for a given typeset.
	 * Do so for each leaf subtype.
	 * @param typeSet
	 * @return list of type tokens
	 */
	public static EList<TypeToken> generateAllLeafTypeTokens(TypeSet typeSet, TypeUseContext tuc){
		EList<TypeToken> result = new BasicEList<TypeToken>() ; 
		if (typeSet == null){
			return result;
		}
		EList<TypeToken> typelist = typeSet.getTypeTokens();
		for (TypeToken typeSetElement : typelist) {
			// add all leaf nodes
			EList<TypeToken> newitems = new BasicEList<TypeToken>() ; 
			EList<ErrorType> elementtypes = typeSetElement.getType();
			for (ErrorType errorType : elementtypes) {
				// elements of a product type
				EList<ErrorType> etlist = getAllLeafSubTypes( errorType,tuc);
				if (newitems.isEmpty()){
					// first/single type: add all leaves
					for (ErrorType subType : etlist) {
						TypeToken token = ErrorModelFactory.eINSTANCE.createTypeToken();
						token.getType().add(subType);
						newitems.add(token);
					}
				} else {
					// product type: add other type elements from the product type
						newitems = addItemSet(newitems, etlist);
				}
			}
			result.addAll(newitems);
			newitems.clear();
		}
		return result;
	}
	

	/**
	 * Get all error types that are direct subtypes of et or any of its aliases.
	 * If et is an alias we only find subtypes of the alias or its aliases
	 * We look for any error type accessible in the TypeUseContext, i.e., subclause, type library, type mapping/xform set
	 * @param et
	 * @param tuc
	 * @return
	 */
	public static EList<ErrorType> getSubTypes(ErrorType et, TypeUseContext tuc){
		UniqueEList<ErrorType> result = new UniqueEList<ErrorType>();
		ErrorType resolvedet = EMV2Util.resolveAlias(et);
		for (ErrorModelLibrary etl : EMV2Util.getUseTypes(tuc)) {
			EList<ErrorType> typeslist = etl.getTypes();
			for (ErrorType suberrortype : typeslist) {
				// check if type is a subtype or an alias for which we need to check for subtypes
				ErrorType resolvedSubErrorType = EMV2Util.resolveAlias(suberrortype);
				if (resolvedSubErrorType == resolvedet){
					// subtype is an alias of ET. need to look for its subtypes
					EList<ErrorType> aliasresult = getSubTypes(suberrortype, tuc);
					result.addAll(aliasresult);
				}
				if (suberrortype.getSuperType() == et){
					result.add(suberrortype);
				}
				ErrorType aliasedsubtype = suberrortype;
				while (isAlias(aliasedsubtype)){
					// see if the alias origin is a subtype
					ErrorType sub = aliasedsubtype.getAliasedType();
					if (sub.getSuperType() == et){
						result.add(sub);
					} else {
						aliasedsubtype = sub;
					}
				}
			}
		}
		return result;
	}
	
	/**
	 * get list of leaf subtypes of the given error type et excluding et itself
	 * Each any error type alias has been resolved
	 * @param context
	 * @param et
	 * @return
	 */
	public static EList<ErrorType> getAllLeafSubTypes( ErrorType et, TypeUseContext tuc){
		EList<ErrorType> result = new UniqueEList<ErrorType>();
		EList<ErrorType> removeMe = new UniqueEList<ErrorType>();
		for (ErrorModelLibrary etl : EMV2Util.getUseTypes(tuc)) {
			EList<ErrorType> typeslist = etl.getTypes();
			for (ErrorType errorType : typeslist) {
				ErrorType set = EMV2Util.resolveAlias(errorType);
				if ( contains(et, set)){
					result.add(set);
				} 
				if (set.getSuperType() != null){
					removeMe.add(set.getSuperType());
				}
			}
		}
		result.removeAll(removeMe);
		return result;
	}
	
	
	
	/**
	 * map a TypeToken into a target type token according to the TypeMappingSet.
	 * The original token is not modified.
	 * The result token is currently that from the mapping rule and is not expected to be modified
	 * @param token TypeToken
	 * @param tms TypeMappingSet
	 * @return result TypeToken
	 */
	public static TypeToken mapTypeToken(TypeToken token, TypeMappingSet tms){
		EList<TypeMapping> tmlist = tms.getMapping();
		for (TypeMapping typeMapping : tmlist) {
			TypeSet src = typeMapping.getSource();
			if (contains(src,token)){
				return typeMapping.getTarget();
			}
		}
		return token;
	}


}
