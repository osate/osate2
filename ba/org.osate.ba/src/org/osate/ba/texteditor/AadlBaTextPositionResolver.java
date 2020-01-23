/**
 * AADL-BA-FrontEnd
 * 
 * Copyright © 2013 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 2.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * https://www.eclipse.org/legal/epl-2.0/
 */

package org.osate.ba.texteditor;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.Element ;
import org.osate.annexsupport.AnnexTextPositionResolver;
import org.osate.annexsupport.TextPositionInfo;
import org.osate.ba.aadlba.BehaviorAnnex ;
import org.osate.ba.aadlba.ElementHolder ;
import org.osate.ba.utils.AadlBaLocationReference ;


public class AadlBaTextPositionResolver implements AnnexTextPositionResolver{

	private BehaviorAnnex ba;
	
	private Element getLinkedElement(int offset)
	  {

		  for(AadlBaLocationReference loc: ba.getLinks().keySet())
		  {
			  if(offset<= loc.getOffset()+loc.getLength() && offset>=loc.getOffset())
				  return ba.getLinks().get(loc) ;
		  }

		  return null;
	  }
	
	private AadlBaLocationReference  getSourceOffsetElement(int offset) {

		if(ba.getLinks()!=null)
		{
			for(AadlBaLocationReference loc: ba.getLinks().keySet())
			{
				if(offset<= loc.getOffset()+loc.getLength() && offset>=loc.getOffset())
					return loc ;
			}
		}
		return null;
	  }
	
	private TextPositionInfo resolveBehaviorAnnexElementAt(int offset)
	{
		Element e = this.getLinkedElement(offset);
		
		if(e==null)
			return new TextPositionInfo(null, 0, 0);
		
		AadlBaLocationReference loc = this.getSourceOffsetElement(offset);
		TextPositionInfo positionInfo;
		if(e instanceof ElementHolder)
		{
			ElementHolder beh = (ElementHolder) e;
			positionInfo = new TextPositionInfo(beh.getElement(), loc.getOffset(), loc.getLength());
		}
		else
		{
			positionInfo = new TextPositionInfo(e, loc.getOffset(), loc.getLength());
		}
		return positionInfo;
	}

	private TextPositionInfo resolveBehaviorAnnexCrossReferencedElementAt(int offset)
	{
		Element e = this.getLinkedElement(offset);
		
		if(e==null)
			return new TextPositionInfo(null, offset, 0);
		AadlBaLocationReference loc = this.getSourceOffsetElement(offset);
		TextPositionInfo positionInfo;
		if(e instanceof ElementHolder)
		{
			ElementHolder beh = (ElementHolder) e;
			positionInfo = new TextPositionInfo(beh.getElement(), loc.getOffset(), loc.getLength());
		}
		else
		{
			positionInfo = new TextPositionInfo(e, loc.getOffset(), loc.getLength());
		}
		return positionInfo;
	}
	
	@Override
	public TextPositionInfo resolveElementAt(EObject annexRoot, int offset) {
		if(annexRoot instanceof BehaviorAnnex)
		{
			ba = (BehaviorAnnex) annexRoot;
			return this.resolveBehaviorAnnexElementAt(offset);
		}
		return null;
	}

	@Override
	public TextPositionInfo resolveCrossReferencedElementAt(EObject annexRoot,
			int offset) {
		
		if(annexRoot instanceof BehaviorAnnex)
		{
			ba = (BehaviorAnnex) annexRoot;
			return resolveBehaviorAnnexCrossReferencedElementAt(offset);
		}
		return null;
	}

}
