package org.osate.aadl2.ide.metamodeldescriptor;

import org.eclipse.sphinx.emf.metamodel.AbstractMetaModelDescriptor;

/**
 * Implementation of {@link org.eclipse.sphinx.emf.metamodel.IMetaModelDescriptor IMetaModelDescriptor} 
 * for the Aadl meta-model.
 */
public class AadlMMDescriptor extends AbstractMetaModelDescriptor {

	/**
	 * The id of the content type for aadl files.
	 */
	public static final String CONTENT_TYPE_ID = "org.osate.aadl2.aadlFiles"; //$NON-NLS-1$

	private static final String ID = "org.osate.aadl2.metamodel.descriptor"; //$NON-NLS-1$
	private static final String NAMESPACE = "http://aadl.info/AADL/2.0"; //$NON-NLS-1$
	private static final String NAME = "Extended AADL"; //$NON-NLS-1$

	/**
	 * Singleton instance.
	 */
	public static final AadlMMDescriptor INSTANCE = new AadlMMDescriptor();

 
	private AadlMMDescriptor() {
		super(ID, NAMESPACE, NAME);
	}

	@Override
	public String getDefaultContentTypeId() {
		return CONTENT_TYPE_ID;
	}

}
