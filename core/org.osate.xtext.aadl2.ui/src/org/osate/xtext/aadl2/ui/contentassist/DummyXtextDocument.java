/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.xtext.aadl2.ui.contentassist;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.BadPartitioningException;
import org.eclipse.jface.text.BadPositionCategoryException;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.Position;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.codetemplates.ui.contentassist.DummyDocument;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.IXtextDocumentContentObserver;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

@SuppressWarnings("restriction")
public class DummyXtextDocument extends DummyDocument implements IXtextDocument {

	public DummyXtextDocument(String content) {
		super(content);
	}

	@Override
	public boolean containsPositionCategory(String category) {
		return true;
	}

	@Override
	public void addPosition(Position position) throws BadLocationException {
	}

	@Override
	public void addPosition(String category, Position position)
			throws BadLocationException, BadPositionCategoryException {
	}

	@Override
	public String[] getPartitionings() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String[] getLegalContentTypes(String partitioning) throws BadPartitioningException {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getContentType(String partitioning, int offset, boolean preferOpenPartitions)
			throws BadLocationException, BadPartitioningException {
		throw new UnsupportedOperationException();
	}

	@Override
	public ITypedRegion getPartition(String partitioning, int offset, boolean preferOpenPartitions)
			throws BadLocationException, BadPartitioningException {
		throw new UnsupportedOperationException();
	}

	@Override
	public ITypedRegion[] computePartitioning(String partitioning, int offset, int length,
			boolean includeZeroLengthPartitions) throws BadLocationException, BadPartitioningException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setDocumentPartitioner(String partitioning, IDocumentPartitioner partitioner) {
		throw new UnsupportedOperationException();
	}

	@Override
	public IDocumentPartitioner getDocumentPartitioner(String partitioning) {
		throw new UnsupportedOperationException();
	}

	@Override
	public <T> T readOnly(IUnitOfWork<T, XtextResource> work) {
		throw new UnsupportedOperationException();
	}

	@Override
	public <T> T priorityReadOnly(IUnitOfWork<T, XtextResource> work) {
		throw new UnsupportedOperationException();
	}

	@Override
	public <T> T modify(IUnitOfWork<T, XtextResource> work) {
		throw new UnsupportedOperationException();
	}

	@Override
	public <T> T getAdapter(Class<T> adapterType) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void addModelListener(IXtextModelListener listener) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void removeModelListener(IXtextModelListener listener) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void addXtextDocumentContentObserver(IXtextDocumentContentObserver listener) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void removeXtextDocumentContentObserver(IXtextDocumentContentObserver listener) {
		throw new UnsupportedOperationException();
	}

}
