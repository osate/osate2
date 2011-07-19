/**
 * <copyright>
 * Copyright  2008 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 *
 * $Id: Aadl2ResourceImpl.java,v 1.13 2011-04-11 13:35:56 lwrage Exp $
 */
package org.osate.aadl2.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLParserPoolImpl;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource </b> associated with the package.
 * <!-- end-user-doc -->
 * @see org.osate.aadl2.util.Aadl2ResourceFactoryImpl
 * @generated
 */
public class Aadl2ResourceImpl extends XMIResourceImpl {

	static final XMLParserPoolImpl parserPool = new XMLParserPoolImpl();

	/**
	 * remember whether the file has just been parsed and needs to be name resolved
	 */
	private boolean justParsed = false;

	/**
	 * Flag to indicate the resource is a plug-in property set that has been
	 * shadowed by a property set with the same name in the workspace.
	 */
	private boolean isShadowed = false;

	/**
	 * remember whether the file has just been saved by CoreEditor (or Graphical editor)
	 */
	private boolean justSaved = false;

	/**
	 * Creates an instance of the resource.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param uri the URI of the new resource.
	 * @generated
	 */
	public Aadl2ResourceImpl(URI uri) {
		super(uri);
	}

	/**
	 * Set the just parsed flag value
	 */
	public void setJustParsed(boolean b) {
		justParsed = b;
	}

	public void setShadowed(final boolean s) {
		isShadowed = s;
	}

	public boolean getJustParsed() {
		return justParsed;
	}

	/**
	 * Get the just saved flag value
	 * 
	 * @return true if just saved.
	 */
	public boolean getJustSaved() {
		return justSaved;
	}

	/**
	 * Set the just saved flag value
	 */
	public void setJustSaved(boolean b) {
		justSaved = b;
	}

	public void save() {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put(XMLResource.OPTION_ENCODING, "UTF-8");
		options.put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.FALSE);
		options.put(XMLResource.OPTION_CONFIGURATION_CACHE, Boolean.TRUE);
		options.put(XMLResource.OPTION_USE_FILE_BUFFER, Boolean.TRUE);
		save(options);
	}

	public void save(Map<?, ?> options) {
		try {
			super.save(options);
		} catch (IOException e1) {
			setJustSaved(false);

		}
	}

	public void load() throws IOException {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put(XMLResource.OPTION_ENCODING, "UTF-8");
		options.put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);
		options.put(XMLResource.OPTION_DISABLE_NOTIFY, Boolean.TRUE);
		options.put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, Boolean.FALSE);
		options.put(XMLResource.OPTION_USE_PARSER_POOL, parserPool);
		load(options);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl#useUUIDs()
	 */
	@Override
	protected boolean useUUIDs() {
		return true;
	}
} //Aadl2ResourceImpl
