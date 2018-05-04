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
