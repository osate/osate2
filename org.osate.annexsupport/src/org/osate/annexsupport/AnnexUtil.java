package org.osate.annexsupport;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.PackageSection;

public class AnnexUtil {
	
	public static AnnexParseResult getAnnexParseResult(EObject obj)	{
		// Find the Parseresult information
		for(Adapter adapter : obj.eAdapters()) {
			if(adapter instanceof AnnexParseResult) {
				return (AnnexParseResult)adapter;
			}
		}
		return null;
	}

	
	/**
	 * get the root element of the actual annex subclause/library for the given default annex subclause/library
	 * @param obj EObject DefaultAnnexSubclause or DefaultAnnexLibrary
	 * @return actual annex subclause or library or null
	 */
	public static EObject getAnnexRootElement(EObject obj)	{
		// Find the Parseresult information
		for(Adapter adapter : obj.eAdapters()) {
			if(adapter instanceof AnnexParseResult) {
				AnnexParseResult apr = (AnnexParseResult) adapter;
				if (apr.getParseResult() != null)
					return apr.getParseResult().getRootASTElement();
			}
		}
		return null;
	}

	
	/**
	 * get the line number for a given model object in the core model
	 * This method makes use of the Xtext parse tree.
	 * @return line number
	 */
	public static int getLineNumberFor(EObject obj)	{
		if (obj == null) return 0;
		AnnexParseResult apr = AnnexUtil.getAnnexParseResult(obj);
		if (apr != null){
			obj = (EObject) apr.getTarget();
		}
		INode node = NodeModelUtils.findActualNodeFor(obj);
		if (node != null){
			return node.getStartLine();
		}
		return 0;
	}
	
	
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

	
	public static List<DefaultAnnexSubclause> getAllDefaultAnnexSubclauses(EObject root) {
		List<DefaultAnnexSubclause> result = new ArrayList<DefaultAnnexSubclause>();
		if (root instanceof AadlPackage){
			AadlPackage pack = (AadlPackage)root;
			addSubclauses(pack.getOwnedPublicSection(), result);
			addSubclauses(pack.getOwnedPrivateSection(),result);
		} else if (root instanceof PackageSection){
			addSubclauses((PackageSection)root, result);
		} else if (root instanceof ComponentClassifier){
			
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
				if (cl instanceof ComponentClassifier){
					addSubclauses((ComponentClassifier)cl,result);
				}
			}
		}
	}
	
	public static void addSubclauses(ComponentClassifier cl, List<DefaultAnnexSubclause> result){
		EList<AnnexSubclause> subcs = cl.getOwnedAnnexSubclauses();
		for (AnnexSubclause annexSubclause : subcs) {
			if (annexSubclause instanceof DefaultAnnexSubclause)
				result.add((DefaultAnnexSubclause)annexSubclause);
		}

	}


}
