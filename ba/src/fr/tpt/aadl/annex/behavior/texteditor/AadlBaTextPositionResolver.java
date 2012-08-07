package fr.tpt.aadl.annex.behavior.texteditor;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.XtextResource;
import org.osate.aadl2.Element;
import org.osate.annexsupport.AnnexTextPositionResolver;
import org.osate.annexsupport.TextPositionInfo;

import fr.tpt.aadl.annex.behavior.AadlBaResolver;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorElement;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorState;
import fr.tpt.aadl.annex.behavior.aadlba.ElementHolder;
import fr.tpt.aadl.annex.behavior.utils.AadlBaLocationReference;

public class AadlBaTextPositionResolver implements AnnexTextPositionResolver{

	private BehaviorAnnex ba;
	
	private TextPositionInfo resolveBehaviorAnnexElementAt(int offset)
	{
		BehaviorElement e = XtextAadlBaHyperlink.getLinkedElement(ba, offset);
		
		if(e==null)
			return new TextPositionInfo(null, 0, 0);
		
		AadlBaLocationReference loc = XtextAadlBaHyperlink.getSourceOffsetElement(ba, offset);
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
		BehaviorElement e = XtextAadlBaHyperlink.getLinkedElement(ba, offset);
		
		if(e==null)
			return new TextPositionInfo(null, offset, 0);
		AadlBaLocationReference loc = XtextAadlBaHyperlink.getSourceOffsetElement(ba, offset);
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
