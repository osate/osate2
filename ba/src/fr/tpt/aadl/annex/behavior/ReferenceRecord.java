package fr.tpt.aadl.annex.behavior;

import java.util.ArrayList;

import edu.cmu.sei.aadl.aadl2.Element;
import edu.cmu.sei.aadl.parser.ParserReferenceType;

public class ReferenceRecord {
	static long serialNumber=0;
	
	long uniqueID = serialNumber++;
	
	ParserReferenceType rType;
	Element referencingObject;
	String [] labels;
	ArrayList<Object> resolvedObjects = null;
	
	// This list is to store the objects resolved
	// so far that would need to be added to the 
	// resolved reference.
	public ArrayList<Object> getResolvedObjects(){
		if (resolvedObjects == null){
			resolvedObjects = new ArrayList<Object>();
		}
		return resolvedObjects;
	}

	public void setReferenceType (ParserReferenceType rt){
		rType = rt;
	}
	
	public ParserReferenceType getReferenceType(){
		return rType;
	}
	
	public void setReferencingObject(Element e){
		referencingObject = e;
	}
	
	public Element getReferencingObject(){
		return referencingObject;
	}
	
	public void setLabels(String [] l){
		labels = l;
	}
	
	public String [] getLabels(){
		return labels;
	}
	
	public ReferenceRecord(){
		
	}
	
	public ReferenceRecord(ParserReferenceType type, Element rObject, String[] l){
		rType=type;
		referencingObject = rObject;
		labels=l;
	}
	
	public ReferenceRecord(Element rObject, String[] l){
		referencingObject = rObject;
		labels=l;
	}

	public ReferenceRecord(ParserReferenceType type, String[] l){
		rType = type;
		labels=l;
	}
	
	public ReferenceRecord(String[] l){
		labels=l;
	}
}