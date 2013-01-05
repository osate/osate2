package org.osate.xtext.aadl2.errormodel.util;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.xtext.aadl2.errormodel.errorModel.ElementTypeMapping;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelFactory;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;
import org.osate.xtext.aadl2.errormodel.errorModel.TokenTypeMapping;
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
			et = EM2Util.resolveAlias(et.getSuperType());
		}
		return et;
	}
	
	/**
	 * true if both error types are in teh same type hierarchy
	 * @param et1 ErrorType
	 * @param et2 ErrorType
	 * @return boolean
	 */
	public static boolean inSameTypeHierarchy(ErrorType et1, ErrorType et2){
		return isSame(rootType(et1), rootType(et2));
	}
	
	/**
	 * true if error type t1 is same type as t2
	 * aliases are resolved before the error types are compared
	 * @param t1
	 * @param t2
	 * @return
	 */
	public static boolean isSame(ErrorType t1, ErrorType t2){
		boolean result = EM2Util.resolveAlias(t1) == EM2Util.resolveAlias(t2);
		if (!result && EM2Util.resolveAlias(t1).getName().equalsIgnoreCase(EM2Util.resolveAlias(t2).getName())){
			System.out.println("ErrorType string comparison ok, but not object comparison "+t1.getName()+" == "+t2.getName());
		}
		return result;
		// XXX had to do string compare when ErrorTypeLibrary did not have a name
		// resulted in Xtext URI to ErrorType resolving to an element without container
		// ErrorTypeLibrary is now assigned a name
		//EM2Util.resolveAlias(t1).getName().equalsIgnoreCase(EM2Util.resolveAlias(t2).getName());
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
		type = EM2Util.resolveAlias(type);
		supertype = EM2Util.resolveAlias(supertype);
		while (type != null){
			if (isSame(type,supertype)){
				return true;
			} else {
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
		if (constraint.getType().size() != token.getType().size()) return false;
		for (ErrorType errorType : token.getType()) {
			if (!contains(constraint, errorType)) return false;
		}	
		return true;
	}
	
	
	
	/**
	 * true if TypeSet ts contains TypeToken token
	 * The type set can represent a constraint, i.e., product types, and Type matching are taken into account
	 * aliases are resolved before the error types are compared
	 * @param ts TypeSet
	 * @param token TypeToken
	 * @return boolean
	 */
	public static boolean contains(TypeSet ts, TypeToken token){
		if (ts == null ) return false;
		if ( token == null) return true;
		ts = EM2Util.resolveAlias(ts);
		int toksize = token.getType().size();
		for (TypeToken tselement : ts.getElementType()) {
			if (tselement.getType().size() == toksize){
				if( contains(tselement,token)) return true;
			}
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
		if (ts == null ) return false;
		if ( subts == null) return true;
		ts = EM2Util.resolveAlias(ts);
		subts = EM2Util.resolveAlias(subts);
		EList<TypeToken> subelements = subts.getElementType();
		for (TypeToken typeToken : subelements) {
			if (!contains(ts,typeToken)) return false;
		}
		return true;
	}
	
	/**
	 * generate all type tokens for a given typeset.
	 * Do so only for the top level error type identified by the type set elements
	 * For example, only do ValueError, not a separate token for each subtype.
	 * Use generateAllTypeToken if you want tokens for all leaf types.
	 * @param typeSet
	 * @return list of type tokens
	 */
	public static EList<TypeToken> generateTypeTokens(TypeSet typeSet){
//		EList<TypeToken> result = new BasicEList<TypeToken>() ; 
//		EList<TypeToken> typelist = typeSet.getElementType();
//		result.addAll(typelist);
//		return result;
		return typeSet.getElementType();
	}
	
	/**
	 * add type token for specified error type to newItems. Then add a token
	 * for each token in existing list with error type added.
	 * @param newItems list holding the newly added tokens
	 * @param et error type to be added as single token as well as tokens by combining it with existing tokens
	 * @param existing existing tokens to which error type et needs to be added
	 */
	protected static void addItemSet(EList<TypeToken> newItems, ErrorType et, boolean first){
		if (first){
			for (TypeToken typeToken : newItems) {
				typeToken.getType().add(et);
			}
		} else {
			for (TypeToken typeToken : newItems) {
				TypeToken tu = EcoreUtil.copy(typeToken);
				tu.getType().add(et);
				newItems.add(tu);
			}
		}
	}
	
	
	/**
	 * generate all type tokens for a given typeset.
	 * Do so for each leaf subtype.
	 * @param typeSet
	 * @return list of type tokens
	 */
	public static EList<TypeToken> generateAllTypeTokens(TypeSet typeSet){
		EList<TypeToken> result = new BasicEList<TypeToken>() ; 
		EList<TypeToken> newitems = new BasicEList<TypeToken>() ; 
		EList<TypeToken> typelist = typeSet.getElementType();
		for (TypeToken typeSetElement : typelist) {
			EList<ErrorType> elementtypes = typeSetElement.getType();
			for (ErrorType errorType : elementtypes) {
				EList<ErrorType> etlist = getAllLeafSubTypes( errorType);
				if (newitems.isEmpty()){
					// first/single type
					for (ErrorType subType : etlist) {
						TypeToken token = ErrorModelFactory.eINSTANCE.createTypeToken();
						token.getType().add(subType);
						newitems.add(token);
					}
				} else {
					// product type: add other type elements
					boolean copy = false;
					for (ErrorType subType : etlist) {
						addItemSet(newitems, subType, copy);
						copy = true;
					}
				}
			}
			result.addAll(newitems);
			newitems.clear();
		}
		return result;
	}
	
//	
//	public static EList<ErrorType> getAllLeafErrorTypes(EObject context){
//		return filterAllLeafErrorTypes(getAllErrorTypes(context));
//	}
	
	/**
	 * get list of subtypes of the given error type et excluding et itself
	 * Each any error type alias has been resolved
	 * @param context
	 * @param et
	 * @return
	 */
	public static EList<ErrorType> getAllLeafSubTypes( ErrorType et){
		EList<ErrorType> result = new UniqueEList<ErrorType>();
		EList<ErrorType> mysubs = et.getSubType();
		if (mysubs.isEmpty()) {
			result.add(EM2Util.resolveAlias(et));
			return result;
		}
		for (ErrorType errorType : mysubs) {
			addAllLeafSubTypes(result, errorType);
		}
		return result;
	}
	
	protected static void addAllLeafSubTypes(EList<ErrorType> result, ErrorType et){
		EList<ErrorType> mysubs = et.getSubType();
		if (mysubs.isEmpty()) {
			result.add(EM2Util.resolveAlias(et));
			return ;
		}
		for (ErrorType errorType : mysubs) {
			addAllLeafSubTypes(result, errorType);
		}
	}
	
	
	/**
	 * get all subtypes of ErrorType et in a new UniqueEList.
	 * The list does not include et itself
	 * any error type alias has been resolved
	 * @param et Error Type
	 * @return
	 */
	public static EList<ErrorType> getAllSubTypes(ErrorType et){
		EList<ErrorType> result = new UniqueEList<ErrorType>();
		EList<ErrorType> mysubs = et.getSubType();
		if (mysubs.isEmpty()) return result;
		for (ErrorType errorType : mysubs) {
			result.add(EM2Util.resolveAlias(et));
			addAllSubTypes(result, errorType);
		}
		return result;
	}
	
	protected static void addAllSubTypes(EList<ErrorType> result, ErrorType et){
		EList<ErrorType> mysubs = et.getSubType();
		if (mysubs.isEmpty()) return ;
		for (ErrorType errorType : mysubs) {
			result.add(EM2Util.resolveAlias(et));
			addAllSubTypes(result, errorType);
		}
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
			if (typeMapping instanceof TokenTypeMapping){
				TokenTypeMapping ttm = (TokenTypeMapping)typeMapping;
				TypeSet src = ttm.getSource();
				if (contains(src,token)){
					return ttm.getTarget();
				}
			} else {
				return mapTypes(token,tms);
			}
		}
		return token;
	}

	/**
	 * map types in a token one type at a time using TypeMappingSet
	 * It only maps individual element types based in ElementTypeMapping rules
	 * Otherwise no mapping occurs.
	 * A new token is returned and the original token is not modified.
	 * @param token TypeToken
	 * @param tms TypeMappingSet
	 * @return TypeToken
	 */
	public static TypeToken mapTypes(TypeToken token, TypeMappingSet tms){
		TypeToken resulttoken = ErrorModelFactory.eINSTANCE.createTypeToken();
		EList<ErrorType> typelist = token.getType();
		for (ErrorType errorType : typelist) {
			resulttoken.getType().add(mapType(errorType, tms));
		}
		return token;
	}
	
	/**
	 * map an error type into its target type using the type mapping set
	 * @param type ErrorType
	 * @param tms TypeMappingset
	 * @return ErrorType
	 */
	public static ErrorType mapType(ErrorType type, TypeMappingSet tms){
		EList<TypeMapping> tmlist = tms.getMapping();
		for (TypeMapping typeMapping : tmlist) {
			if (typeMapping instanceof ElementTypeMapping){
				ElementTypeMapping etm = (ElementTypeMapping)typeMapping;
				ErrorType src = etm.getSource();
				if (contains(src,type)){
					return etm.getTarget();
				}
			}
		}
		return type;
	}

}
