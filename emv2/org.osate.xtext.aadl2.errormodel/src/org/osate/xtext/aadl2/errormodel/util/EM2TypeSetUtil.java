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
package org.osate.xtext.aadl2.errormodel.util;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeMappingSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeTransformationSet;

/**
 * @deprecated Use {@link EMV2TypeSetUtil} instead. Will be removed in 2.7.
 */
@Deprecated
public class EM2TypeSetUtil {

	/**
	 * return the root ErrorType of ErrorType et
	 * @param et ErrorType
	 * @return ErrorType root
	 */
	public static ErrorType rootType(ErrorType et) {
		return EMV2TypeSetUtil.rootType(et);
	}

	/**
	 * true if both error types are in the same type hierarchy
	 * @param et1 ErrorType
	 * @param et2 ErrorType
	 * @return boolean
	 */
	public static boolean inSameTypeHierarchy(ErrorType et1, ErrorType et2) {
		return EMV2TypeSetUtil.inSameTypeHierarchy(et1, et2);
	}

	/**
	 * true if error type t1 is same type as t2
	 * @param t1
	 * @param t2
	 * @return
	 */
	public static boolean isSame(ErrorType t1, ErrorType t2) {
		return EMV2TypeSetUtil.isSame(t1, t2);
	}

	public static boolean isSame(ErrorTypes t1, ErrorTypes t2) {
		return EMV2TypeSetUtil.isSame(t1, t2);
	}

	/**
	 * true if error type is an alias
	 * @param et
	 * @return
	 */
	public static boolean isAlias(ErrorType et) {
		return EMV2TypeSetUtil.isAlias(et);
	}

	/**
	 * true if error type set is an alias
	 * @param et
	 * @return
	 */
	public static boolean isAlias(TypeSet ts) {
		return EMV2TypeSetUtil.isAlias(ts);
	}

	/**
	 * true if super type contains type as subtype
	 * aliases are resolved before the error types are compared
	 * if either is null return false
	 * @param supertype
	 * @param type
	 * @return boolean
	 */
	public static boolean contains(ErrorType supertype, ErrorType type) {
		return EMV2TypeSetUtil.contains(supertype, type);
	}

	/**
	 * Dispatch on ErrorTypes
	 */
	public static boolean contains(ErrorTypes constraint, ErrorType type) {
		return EMV2TypeSetUtil.contains(constraint, type);
	}

	public static boolean contains(ErrorTypes constraint, TypeSet type) {
		return EMV2TypeSetUtil.contains(constraint, type);
	}

	public static boolean contains(TypeToken constraint, ErrorTypes type) {
		return EMV2TypeSetUtil.contains(constraint, type);
	}

	public static boolean contains(ErrorTypes constraint, TypeToken type) {
		return EMV2TypeSetUtil.contains(constraint, type);
	}

	public static boolean contains(ErrorTypes constraint, ErrorTypes type) {
		return EMV2TypeSetUtil.contains(constraint, type);
	}

	/**
	 * the constraint contains every element of the type set
	 * If typeset is empty return true
	 * @param constraint
	 * @param ts
	 * @return
	 */
	public static boolean contains(ErrorType constraint, TypeSet ts) {
		return EMV2TypeSetUtil.contains(constraint, ts);
	}

	/**
	 * typetoken could be a type product, while constraint is a single error type.
	 * In this case we do not have a match unless the token has only one element and it is contained.
	 * @param constraint ErrorType
	 * @param token TypeToken
	 * @return
	 */
	public static boolean contains(ErrorType constraint, TypeToken token) {
		return EMV2TypeSetUtil.contains(constraint, token);
	}

	/**
	 * true if TypeToken constraint has single element and it contains ErrorType type
	 * NoError constraint returns false
	 * aliases are resolved before the error types are compared
	 * @param constraint TypeToken
	 * @param type ErrorType
	 * @return
	 */
	public static boolean contains(TypeToken constraint, ErrorType type) {
		return EMV2TypeSetUtil.contains(constraint, type);
	}

	/**
	 * true if TypeToken constraint contains TypeToken token
	 * aliases are resolved before the error types are compared
	 * @param constraint TypeToken
	 * @param token TypeToken
	 * @return
	 */
	public static boolean contains(TypeToken constraint, TypeToken token) {
		return EMV2TypeSetUtil.contains(constraint, token);
	}

	/**
	 * true if TypeToken constraint contains TypeToken token
	 * aliases are resolved before the error types are compared
	 * @param constraint TypeToken
	 * @param token TypeToken
	 * @return
	 */
	public static boolean contains(List<TypeToken> constraint, TypeToken token) {
		return EMV2TypeSetUtil.contains(constraint, token);
	}

	/**
	 * type product contains typeelement as one of its elements
	 * @param typeProduct
	 * @param typeElement
	 * @return
	 */
	public static boolean containsElement(TypeToken typeProduct, ErrorTypes typeElement) {
		return EMV2TypeSetUtil.containsElement(typeProduct, typeElement);
	}

	/**
	 * true if TypeSet ts contains TypeToken token
	 * The type set can represent a constraint
	 * aliases are resolved before the error types are compared
	 * @param ts TypeSet
	 * @param token TypeToken
	 * @return boolean
	 */
	public static boolean contains(TypeSet ts, TypeToken token) {
		return EMV2TypeSetUtil.contains(ts, token);
	}

	/**
	 * true if TypeSet ts contains TypeToken token
	 * The type set can represent a constraint
	 * aliases are resolved before the error types are compared
	 * @param ts TypeSet
	 * @param token TypeToken
	 * @return boolean
	 */
	public static boolean contains(TypeToken token, TypeSet ts) {
		return EMV2TypeSetUtil.contains(token, ts);
	}

	/**
	 * true if TypeSet ts contains ErrorType et
	 * The type set can represent a constraint
	 * EMpty type set returns false
	 * aliases are resolved before the error types are compared
	 * @param ts TypeSet
	 * @param et ErrorType
	 * @return boolean
	 */
	public static boolean contains(TypeSet ts, ErrorType et) {
		return EMV2TypeSetUtil.contains(ts, et);
	}

	/**
	 * true if TypeSet ts contains TypeSet subts
	 * NoError is handled both NoError or subTS NoError returns true
	 * aliases are resolved before the error types are compared
	 * @param ts TypeSet
	 * @param subts TypeSet
	 * @return boolean
	 */
	public static boolean contains(TypeSet ts, TypeSet subts) {
		return EMV2TypeSetUtil.contains(ts, subts);
	}

	/**
	 * returns all tokens that are common to both type sets
	 * aliases are resolved before the error types are compared
	 * @param ts1 TypeSet
	 * @param ts2 TypeSet
	 * @return list TypeToken
	 */
	public static BasicEList<TypeToken> getTypeSetIntersection(TypeSet ts1, TypeSet ts2) {
		return EMV2TypeSetUtil.getTypeSetIntersection(ts1, ts2);
	}

	/**
	 * returns all subtypes of the token that are in TypeSet ts
	 * The type set can represent a constraint
	 * aliases are resolved before the error types are compared
	 * @param ts TypeSet
	 * @param token TypeToken
	 * @return list TypeToken
	 */
	public static Collection<TypeToken> getConstrainedTypeTokens(TypeSet ts, TypeToken token) {
		return EMV2TypeSetUtil.getConstrainedTypeTokens(ts, token);
	}

	/**
	 * adds a type token that has the subtype of each product element of the two tokens
	 * The subtype can be from the constraint or the token
	 * The TypeToken error type lists are assumed to be of the same size
	 * @param ts TypeSet
	 * @param token TypeToken
	 * @param result List of type tokens
	 */
	protected static void getConstrainedTypeTokens(TypeToken constraint, TypeToken token,
			Collection<TypeToken> result) {
		EMV2TypeSetUtil.getConstrainedTypeTokens(constraint, token, result);
	}

	/**
	 * add type token for specified error type to newItems. Then add a token
	 * for each token in existing list with error type added.
	 * @param newItems list holding the newly added tokens
	 * @param etlist error subtypes of the next product element to be added
	 * @return result list
	 */
	protected static EList<TypeToken> addItemSet(EList<TypeToken> newItems, EList<ErrorType> etlist) {
		return EMV2TypeSetUtil.addItemSet(newItems, etlist);
	}

	/**
	 * generate all type tokens for a given typeset.
	 * Do so for each leaf subtype.
	 * @param typeSet
	 * @return list of type tokens
	 */
	public static EList<TypeToken> generateAllLeafTypeTokens(TypeSet typeSet, List<ErrorModelLibrary> usetypes) {
		return EMV2TypeSetUtil.generateAllLeafTypeTokens(typeSet, usetypes);
	}

	/**
	 * generate all type tokens for a given typeset.
	 * Do so for each leaf subtype.
	 * @param typeSet
	 * @return list of type tokens
	 */
	public static EList<TypeToken> flattenTypesetElements(TypeSet typeSet, List<ErrorModelLibrary> usetypes) {
		return EMV2TypeSetUtil.flattenTypesetElements(typeSet);
	}

	/**
	 * Get all error types that are direct subtypes of et or any of its aliases.
	 * If et is an alias we only find subtypes of the alias or its aliases
	 * We look for any error type accessible in the TypeUseContext, i.e., subclause, type library, type mapping/xform set
	 * @param et
	 * @param tuc
	 * @return
	 */
	public static EList<ErrorType> getSubTypes(ErrorType et, List<ErrorModelLibrary> usetypes) {
		return EMV2TypeSetUtil.getSubTypes(et, usetypes);
	}

	/**
	 * get list of leaf subtypes of the given error type et excluding et itself
	 * Each any error type alias has been resolved
	 * @param context
	 * @param et
	 * @return
	 */
	public static EList<ErrorType> getAllLeafSubTypes(ErrorType et, List<ErrorModelLibrary> usetypes) {
		return EMV2TypeSetUtil.getAllLeafSubTypes(et, usetypes);
	}

	public static EList<ErrorType> getAllLeafSubTypes(ErrorType et, ErrorModelLibrary el) {
		return EMV2TypeSetUtil.getAllLeafSubTypes(et, el);
	}

	/**
	 * map a TypeToken into a target type token according to the TypeMappingSet.
	 * The original token is not modified.
	 * The result token is currently that from the mapping rule and is not expected to be modified
	 * @param token TypeToken
	 * @param tms TypeMappingSet
	 * @return result TypeToken or null if no mapping
	 */
	public static TypeToken mapTypeToken(TypeToken token, TypeMappingSet tms) {
		return EMV2TypeSetUtil.mapTypeToken(token, tms);
	}

	public static TypeToken mapTypeToken(ErrorTypes token, TypeMappingSet tms) {
		return EMV2TypeSetUtil.mapTypeToken(token, tms);
	}

	/**
	 * map a TypeToken from the target type token to the first type token in the source type set according to the TypeMappingSet.
	 * The original token is not modified.
	 * The result token is currently that from the mapping rule and is not expected to be modified
	 * @param token TypeToken
	 * @param tms TypeMappingSet
	 * @return result TypeToken or null if no mapping found
	 */
	public static TypeToken reverseMapTypeToken(TypeToken token, TypeMappingSet tms) {
		return EMV2TypeSetUtil.reverseMapTypeToken(token, tms);
	}

	/**
	 * map a TypeToken into a target type token according to the TypeTransformationSet.
	 * The original token is not modified.
	 * The result token is currently that from the mapping rule and is not expected to be modified
	 * @param token TypeToken
	 * @param tts TypeTransformationSet
	 * @return result TypeToken
	 */
	public static TypeToken mapTypeToken(TypeToken token, TypeTransformationSet tts) {
		return EMV2TypeSetUtil.mapTypeToken(token, tts);
	}

	/**
	 * map a TypeToken into a target type token according to the TypeTransformationSet.
	 * The original token is not modified.
	 * The result token is currently that from the mapping rule and is not expected to be modified
	 * @param srctoken TypeToken
	 * @param contributortoken TypeToken
	 * @param tts TypeTransformationSet
	 * @return result TypeToken
	 */
	public static TypeToken mapTypeToken(TypeToken srctoken, TypeToken contributortoken, TypeTransformationSet tts) {
		return EMV2TypeSetUtil.mapTypeToken(srctoken, contributortoken, tts);
	}

	public static TypeSet reverseMapTypeTokenToContributor(TypeToken targettoken, TypeTransformationSet tts) {
		return EMV2TypeSetUtil.reverseMapTypeTokenToContributor(targettoken, tts);
	}

	public static TypeSet reverseMapTypeTokenToSource(TypeToken targettoken, TypeTransformationSet tts) {
		return EMV2TypeSetUtil.reverseMapTypeTokenToSource(targettoken, tts);
	}

	public static boolean isNoError(ErrorTypes type) {
		return EMV2TypeSetUtil.isNoError(type);
	}

	public static boolean isNoError(TypeSet type) {
		return EMV2TypeSetUtil.isNoError(type);
	}
}
