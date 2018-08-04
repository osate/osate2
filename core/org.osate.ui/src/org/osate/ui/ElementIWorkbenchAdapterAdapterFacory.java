package org.osate.ui;

import java.net.URL;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.model.IWorkbenchAdapter;
import org.osate.aadl2.instance.provider.InstanceItemProviderAdapterFactory;
import org.osate.aadl2.provider.Aadl2ItemProviderAdapterFactory;

public class ElementIWorkbenchAdapterAdapterFacory implements IAdapterFactory {

	private static ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory();

	static {
		adapterFactory.addAdapterFactory(new Aadl2ItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new InstanceItemProviderAdapterFactory());
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getAdapter(Object adaptableObject, Class<T> adapterType) {
		return (T) new IWorkbenchAdapter() {

			@Override
			public Object[] getChildren(Object o) {
				ITreeItemContentProvider contentProvider = (ITreeItemContentProvider) adapterFactory.adapt(o,
						ITreeItemContentProvider.class);
				return contentProvider == null ? null : contentProvider.getChildren(o).toArray();
			}

			@Override
			public ImageDescriptor getImageDescriptor(Object o) {
				IItemLabelProvider labelProvider = (IItemLabelProvider) adapterFactory.adapt(o,
						IItemLabelProvider.class);
				return labelProvider == null ? null
						: ImageDescriptor.createFromURL((URL) labelProvider.getImage(o));
			}

			@Override
			public String getLabel(Object o) {
				IItemLabelProvider labelProvider = (IItemLabelProvider) adapterFactory.adapt(o,
						IItemLabelProvider.class);
				return labelProvider == null ? null : labelProvider.getText(o);
			}

			@Override
			public Object getParent(Object o) {
				ITreeItemContentProvider contentProvider = (ITreeItemContentProvider) adapterFactory.adapt(o,
						ITreeItemContentProvider.class);
				return contentProvider == null ? null : contentProvider.getParent(o);
			}

		};
	}

	@Override
	public Class<?>[] getAdapterList() {
		Class<?>[] result = { IWorkbenchAdapter.class };
		return result;
	}
}
