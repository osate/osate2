/**
 * AADL-BA-FrontEnd
 * 
 * Copyright © 2011 Télécom ParisTech and CNRS
 * 
 * Télécom ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 1.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * http://www.eclipse.org/org/documents/epl-v10.php
 */

package fr.tpt.aadl.annex.behavior.utils;

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