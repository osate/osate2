package org.osate.aadl2.ide.metamodeldescriptor;

import org.eclipse.sphinx.emf.metamodel.AbstractMetaModelDescriptor;

/**
 * Implementation of {@link org.eclipse.sphinx.emf.metamodel.IMetaModelDescriptor IMetaModelDescriptor} 
 * for the Aadl meta-model (XMI files).
 */
public class AaxlMMDescriptor extends AbstractMetaModelDescriptor {

	/**
	 * The id of the content type for aaxl files.
	 */
	public static final String CONTENT_TYPE_ID = "org.osate.aadl2.aaxlFiles"; //$NON-NLS-1$

	private static final String ID = "org.osate.aadl2.aaxl.metamodel.descriptor"; //$NON-NLS-1$
	private static final String NAMESPACE = "http://aadl.info/AADL/2.0"; //$NON-NLS-1$
	private static final String NS_SUB_PKG = "instance"; //$NON-NLS-1$
	private static final String NAME = "Extended AAXL"; //$NON-NLS-1$

	/**
	 * Singleton instance.
	 */
	public static final AaxlMMDescriptor INSTANCE = new AaxlMMDescriptor();

 
	private AaxlMMDescriptor() {
		super(ID, NAMESPACE, NS_SUB_PKG, NAME);
	}

	@Override
	public String getDefaultContentTypeId() {
		return CONTENT_TYPE_ID;
	}

}
