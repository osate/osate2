package org.osate.annexsupport;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.PropertySet;
import org.osate.xtext.aadl2.properties.util.EMFIndexRetrieval;

public class AnnexUtil {
	
	
	public static String getSourceText(EObject annexObj){
		if (annexObj instanceof DefaultAnnexLibrary){
			return ((DefaultAnnexLibrary)annexObj).getSourceText();
		}
		if (annexObj instanceof DefaultAnnexSubclause){
			return ((DefaultAnnexSubclause)annexObj).getSourceText();
		}
		if (annexObj instanceof AnnexLibrary){
			return ((DefaultAnnexLibrary)annexObj.eContainer()).getSourceText();
		}
		if (annexObj instanceof AnnexSubclause){
			return ((DefaultAnnexSubclause)annexObj.eContainer()).getSourceText();
		}
		return "";
	}

	/**
	 * return actual annex library or subclause for the given (Default) annex library or subclause.
	 * if the input is already the annex specific annex lib/subclause we return it.
	 * @param annexObj
	 * @return
	 */
	public static EObject getParsedAnnex(EObject annexObj){
		if (annexObj instanceof DefaultAnnexLibrary){
			return ((DefaultAnnexLibrary)annexObj).getParsedAnnexLibrary();
		}
		if (annexObj instanceof DefaultAnnexSubclause){
			return ((DefaultAnnexSubclause)annexObj).getParsedAnnexSubclause();
		}
		if (annexObj instanceof AnnexLibrary){
			return annexObj;
		}
		if (annexObj instanceof AnnexSubclause){
			return annexObj;
		}
		return null;
	}

	
	/**
	 * return the actual annex library if present. otherwise return the given (default) annex library
	 * @param annexObj AnnexLibrary (either default or actual
	 * @return AnnexLibrary
	 */
	public static AnnexLibrary getActualAnnexLibrary(AnnexLibrary annexObj){
		if (annexObj instanceof DefaultAnnexLibrary){
			return ((DefaultAnnexLibrary)annexObj).getParsedAnnexLibrary();
		}
		return annexObj;
	}
	
	/**
	 * return the actual annex subclause if present. otherwise return the given (default) annex subclause
	 * @param annexObj AnnexSubclause (either default or actual
	 * @return AnnexSubclause
	 */
	public static AnnexSubclause getActualAnnexSubclause(AnnexSubclause annexObj){
		if (annexObj instanceof DefaultAnnexSubclause){
			return ((DefaultAnnexSubclause)annexObj).getParsedAnnexSubclause();
		}
		return annexObj;
	}


	/**
	 * returns the offset of the annex. The annex is assumed to be a DefaultAnnexSubclause or a DefaultAnnexLibrary
	 * @param asc
	 * @return
	 */
	public static int getAnnexOffset(EObject asc){
		INode node = NodeModelUtils.findActualNodeFor(asc);
		ILeafNode annexTextNode = null;
		if (node != null){
			Iterable<ILeafNode> leafNodes = node.getLeafNodes();
			for (ILeafNode iLeafNode : leafNodes) {
				if (isAnnexLeaf(iLeafNode)){
					annexTextNode = iLeafNode;
				}
			}
			if (annexTextNode != null){
				int offset = annexTextNode.getOffset()+3;
				return offset;
			}
			int offset = node.getOffset();
			int nlength = node.getLength();
			int sourcelength = AnnexUtil.getSourceText(asc).length();
			// compensate for stripping {**
			offset = offset + (nlength-sourcelength-1)+3;
			return offset;
		} else {
			return 0;
		}
	}

	/**
	 * return the ILeafNode for the ANNEXTEXT if the offset points into an annex
	 * @param resource
	 * @param offset
	 * @return
	 */
	public static ILeafNode findAnnexLeafNode(XtextResource resource, int offset){
		IParseResult parseResult = resource.getParseResult();
		if (parseResult != null && parseResult.getRootNode() != null) {
			ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), offset);
			if (AnnexUtil.isAnnexLeaf(leaf)){
				return leaf;
			}
		}
		return null;
	}

/**
 * determine whether the leaf node represents the ANNEXTEXT in the core grammar.
 * @param leaf
 * @return
 */
	public static boolean isAnnexLeaf(ILeafNode leaf){
		if (leaf == null) return false;
		EObject ge = leaf.getGrammarElement();
		if (ge instanceof RuleCall){
			AbstractRule rule = ((RuleCall)ge).getRule();
			if (rule.getName().equalsIgnoreCase("ANNEXTEXT")){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * return all default annex libraries in a package
	 * This includes both public and private sections
	 * @param pack AADL Package
	 * @return List<DefaultAnnexLibrary>
	 */
	public static List<DefaultAnnexLibrary> getAllDefaultAnnexLibraries(AadlPackage pack) {
		List<DefaultAnnexLibrary> result = new ArrayList<DefaultAnnexLibrary>();
			addLibs(pack.getOwnedPublicSection(), result);
			addLibs(pack.getOwnedPrivateSection(),result);
		return result;
	}
	
	/**
	 * return all default annex libraries in the public section of a package
	 * This includes both public sections
	 * @param pack AADL Package
	 * @return List<DefaultAnnexLibrary>
	 */
	public static List<DefaultAnnexLibrary> getAllPublicDefaultAnnexLibraries(AadlPackage pack) {
		List<DefaultAnnexLibrary> result = new ArrayList<DefaultAnnexLibrary>();
			addLibs(pack.getOwnedPublicSection(), result);
		return result;
	}
	
	/**
	 * return all default annex libraries in a package
	 * @param pack AADL PackageSectrion
	 * @return List<DefaultAnnexLibrary>
	 */
	public static List<DefaultAnnexLibrary> getAllDefaultAnnexLibraries(PackageSection root) {
		List<DefaultAnnexLibrary> result = new ArrayList<DefaultAnnexLibrary>();
			addLibs((PackageSection)root, result);
		return result;
	}
	
	public static List<AnnexLibrary> getAllActualAnnexLibraries(PackageSection root) {
		List<AnnexLibrary> result = new ArrayList<AnnexLibrary>();
			addActualLibs((PackageSection)root, result);
		return result;
	}
	
	/**
	 * return all actual annex libraries in the public and private section of a package
	 * Includes default annex library if the parsed actual is not present.
	 * @param pack AADL Package
	 * @return List<DefaultAnnexLibrary>
	 */
	public static List<DefaultAnnexLibrary> getAllActualAnnexLibraries(AadlPackage pack) {
		List<DefaultAnnexLibrary> result = new ArrayList<DefaultAnnexLibrary>();
			addLibs(pack.getOwnedPublicSection(), result);
			addLibs(pack.getOwnedPrivateSection(),result);
		return result;
	}
	/**
	 * return all actual annex libraries in the public section of a package
	 * Includes actual annex library if the parsed actual is not present.
	 * @param pack AADL Package
	 * @return List<DefaultAnnexLibrary>
	 */
	public static List<DefaultAnnexLibrary> getAllPublicActualAnnexLibraries(AadlPackage pack) {
		List<DefaultAnnexLibrary> result = new ArrayList<DefaultAnnexLibrary>();
			addLibs(pack.getOwnedPublicSection(), result);
		return result;
	}
	
	/**
	 * add default annex libraries of packsec. Packsec can be null
	 * @param packsec
	 * @param result
	 */
	public static void addLibs(PackageSection packsec,List<DefaultAnnexLibrary> result ){
		if (packsec != null){
			EList<AnnexLibrary> libs = packsec.getOwnedAnnexLibraries();
			for (AnnexLibrary annexLibrary : libs) {
				if (annexLibrary instanceof DefaultAnnexLibrary)
					result.add((DefaultAnnexLibrary)annexLibrary);
			}
		}
	}
	/**
	 * add actual annex libraries of packsec if present, otherwise default. Packsec can be null
	 * @param packsec
	 * @param result
	 */
	public static void addActualLibs(PackageSection packsec,List<AnnexLibrary> result ){
		if (packsec != null){
			EList<AnnexLibrary> libs = packsec.getOwnedAnnexLibraries();
			for (AnnexLibrary annexLibrary : libs) {
				if (annexLibrary instanceof DefaultAnnexLibrary)
					result.add(getActualAnnexLibrary(annexLibrary));
			}
		}
	}

	/**
	 * add default annex subclauses of property set.
	 * @param property set
	 * @param result
	 */
	public static void addDefaultSubclauses(PropertySet propset,List<DefaultAnnexSubclause> result ){
		if (propset != null){
			EList<AnnexSubclause> libs = propset.getOwnedAnnexSubclauses();
			for (AnnexSubclause annexSubclause : libs) {
				if (annexSubclause instanceof DefaultAnnexSubclause)
					result.add((DefaultAnnexSubclause)annexSubclause);
			}
		}
	}

	/**
	 * add default annex subclauses of property set.
	 * @param property set
	 * @param result
	 */
	public static void addActualSubclauses(PropertySet propset,List<DefaultAnnexSubclause> result ){
		if (propset != null){
			EList<AnnexSubclause> libs = propset.getOwnedAnnexSubclauses();
			for (AnnexSubclause annexSubclause : libs) {
				if (annexSubclause instanceof DefaultAnnexSubclause)
					result.add((DefaultAnnexSubclause)annexSubclause);
			}
		}
	}

	
	public static List<DefaultAnnexSubclause> getAllDefaultAnnexSubclauses(EObject root) {
		List<DefaultAnnexSubclause> result = new ArrayList<DefaultAnnexSubclause>();
		if (root instanceof AadlPackage){
			AadlPackage pack = (AadlPackage)root;
			addDefaultSubclauses(pack.getOwnedPublicSection(), result);
			addDefaultSubclauses(pack.getOwnedPrivateSection(),result);
		} else if (root instanceof PackageSection){
			addDefaultSubclauses((PackageSection)root, result);
		} else if (root instanceof PropertySet){
			addDefaultSubclauses((PropertySet)root, result);
		}
		return result;
	}
	
	/**
	 * add default annex subclauses of packsec. Packsec can be null
	 * @param packsec
	 * @param result
	 */
	public static void addDefaultSubclauses(PackageSection packsec,List<DefaultAnnexSubclause> result ){
		if (packsec != null){
			EList<Classifier> classifiers = packsec.getOwnedClassifiers();
			for (Classifier cl : classifiers) {
					addDefaultSubclauses(cl,result);
			}
		}
	}
	
	public static void addDefaultSubclauses(Classifier cl, List<DefaultAnnexSubclause> result){
		EList<AnnexSubclause> subcs = cl.getOwnedAnnexSubclauses();
		for (AnnexSubclause annexSubclause : subcs) {
			result.add((DefaultAnnexSubclause)annexSubclause);
		}
	}

	public static void addActualSubclauses(Classifier cl, List<AnnexSubclause> result){
		EList<AnnexSubclause> subcs = cl.getOwnedAnnexSubclauses();
		for (AnnexSubclause annexSubclause : subcs) {
			result.add(getActualAnnexSubclause(annexSubclause));
		}

	}


}
