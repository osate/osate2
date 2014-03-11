package org.osate.annexsupport;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
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
	
//	public static AnnexParseResult getAnnexParseResult(EObject obj)	{
//		if (obj instanceof DefaultAnnexLibrary){
//			obj = ((DefaultAnnexLibrary)obj).getParsedAnnexLibrary();
//		} else if (obj instanceof DefaultAnnexSubclause){
//			obj = ((DefaultAnnexSubclause)obj).getParsedAnnexSubclause();
//		}
//		if (obj == null) return null;
//		// Find the Parseresult information
//		for(Adapter adapter : obj.eAdapters()) {
//			if(adapter instanceof AnnexParseResult) {
//				return (AnnexParseResult)adapter;
//			}
//		}
//		return null;
//	}
	
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
	 * returns the offset of the annex. The annex is assumed to be a DefaultAnnexSubclause or a DefaultAnnexLibrary
	 * @param asc
	 * @return
	 */
	public static int getAnnexOffset(EObject asc){
		INode node = NodeModelUtils.findActualNodeFor(asc);
		if (node != null){
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
	
	
//	/**
//	 * get the line number for a given model object in the core model
//	 * This method makes use of the Xtext parse tree.
//	 * @return line number
//	 */
//	public static int getLineNumberFor(EObject obj)	{
//		if (obj == null) return 0;
//		AnnexParseResult apr = AnnexUtil.getAnnexParseResult(obj);
//		if (apr != null){
//			obj = (EObject) apr.getTarget();
//		}
//		INode node = NodeModelUtils.findActualNodeFor(obj);
//		if (node != null){
//			return node.getStartLine();
//		}
//		return 0;
//	}
	
	
	public static List<DefaultAnnexLibrary> getAllDefaultAnnexLibraries(EObject root) {
		List<DefaultAnnexLibrary> result = new ArrayList<DefaultAnnexLibrary>();
		if (root instanceof AadlPackage){
			AadlPackage pack = (AadlPackage)root;
			addLibs(pack.getOwnedPublicSection(), result);
			addLibs(pack.getOwnedPrivateSection(),result);
		} else if (root instanceof PackageSection){
			addLibs((PackageSection)root, result);
		}
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
	 * add default annex subclauses of property set.
	 * @param property set
	 * @param result
	 */
	public static void addSubclauses(PropertySet propset,List<DefaultAnnexSubclause> result ){
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
			addSubclauses(pack.getOwnedPublicSection(), result);
			addSubclauses(pack.getOwnedPrivateSection(),result);
		} else if (root instanceof PackageSection){
			addSubclauses((PackageSection)root, result);
		} else if (root instanceof PropertySet){
			addSubclauses((PropertySet)root, result);
		}
		return result;
	}
	
	/**
	 * add default annex subclauses of packsec. Packsec can be null
	 * @param packsec
	 * @param result
	 */
	public static void addSubclauses(PackageSection packsec,List<DefaultAnnexSubclause> result ){
		if (packsec != null){
			EList<Classifier> classifiers = packsec.getOwnedClassifiers();
			for (Classifier cl : classifiers) {
					addSubclauses(cl,result);
			}
		}
	}
	
	public static void addSubclauses(Classifier cl, List<DefaultAnnexSubclause> result){
		EList<AnnexSubclause> subcs = cl.getOwnedAnnexSubclauses();
		for (AnnexSubclause annexSubclause : subcs) {
			if (annexSubclause instanceof DefaultAnnexSubclause)
				result.add((DefaultAnnexSubclause)annexSubclause);
		}

	}


}
