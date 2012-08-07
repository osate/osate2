package fr.tpt.aadl.annex.behavior.texteditor;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.osate.annexsupport.TextPositionInfo;

import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorElement;
import fr.tpt.aadl.annex.behavior.utils.AadlBaLocationReference;

public class XtextAadlBaHyperlink implements AadlBaHyperlink // extends EObjectAtOffsetHelper ???
{
  
  // TODO: remove static map by reparsing the ba; only looking for the locationreference 
  private static Map<BehaviorAnnex, Map<AadlBaLocationReference, BehaviorElement>> 
  	_hyperlinkingPerAnnex = new HashMap<BehaviorAnnex, Map<AadlBaLocationReference, BehaviorElement>>() ;
  
  Map<AadlBaLocationReference, BehaviorElement> _links = new HashMap
        <AadlBaLocationReference, BehaviorElement>() ;
  
  public XtextAadlBaHyperlink(BehaviorAnnex ba) {
	  _hyperlinkingPerAnnex.put(ba, _links);
  }

  public static BehaviorElement getLinkedElement(BehaviorAnnex ba, int offset)
  {
	  Map<AadlBaLocationReference, BehaviorElement> links = _hyperlinkingPerAnnex.get(ba);
	  if(links!=null)
	  {
		  for(AadlBaLocationReference loc: links.keySet())
		  {
			  if(offset<= loc.getOffset()+loc.getLength() && offset>=loc.getOffset())
				  return links.get(loc) ;
		  }
	  }
	  return null;
  }
  
  @Override
  public BehaviorElement getLinkedElement(int offset)
  {
	for(AadlBaLocationReference loc: _links.keySet())
		if(offset<= loc.getOffset()+loc.getLength() && offset>=loc.getOffset())
			return _links.get(offset) ;
	return null;
  }

  @Override
  public void addToHyperlinking(AadlBaLocationReference location, BehaviorElement element) {
    _links.put(location, element) ;
  }

  public static AadlBaLocationReference  getSourceOffsetElement(BehaviorAnnex ba, int offset) {
	Map<AadlBaLocationReference, BehaviorElement> links = _hyperlinkingPerAnnex.get(ba);
	  if(links!=null)
	  {
		  for(AadlBaLocationReference loc: links.keySet())
		  {
			  if(offset<= loc.getOffset()+loc.getLength() && offset>=loc.getOffset())
				  return loc ;
		  }
	  }
	  return null;
  }
}
