/* Created on Feb 20, 2006
 */
package org.osate.ui;

import org.osate.aadl2.Element;

/**
 * Abstract interface for objects that know how to open up and display
 * a particular AObject.  The intention is that AADL Editors be <em>adaptable</em>
 * to this class.  That is, they should implement {@link org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)}
 * so that it understands <code>GotoAObject.class</code>.  THis allows views
 * to trigger editors to focus on particular AObjects without having to know
 * what kind of editor the current editor is.
 * 
 * @author aarong
 */
public interface IGotoAObject {
	public void gotoAObject(Element obj);
}
