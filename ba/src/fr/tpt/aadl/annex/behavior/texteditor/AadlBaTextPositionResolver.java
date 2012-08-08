package fr.tpt.aadl.annex.behavior.texteditor;

import org.eclipse.emf.ecore.EObject;
import org.osate.annexsupport.AnnexTextPositionResolver;
import org.osate.annexsupport.TextPositionInfo;

import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorElement;
import fr.tpt.aadl.annex.behavior.aadlba.ElementHolder;
import fr.tpt.aadl.annex.behavior.utils.AadlBaLocationReference;

public class AadlBaTextPositionResolver implements AnnexTextPositionResolver{

	private BehaviorAnnex ba;
	
	private BehaviorElement getLinkedElement(int offset)
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
		BehaviorElement e = this.getLinkedElement(offset);
		
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
		BehaviorElement e = this.getLinkedElement(offset);
		
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
