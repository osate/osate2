package org.osate.ge.internal.ui.properties;

import java.util.Collection;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EObject;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.services.AadlModificationService;

import com.google.common.collect.ImmutableList;

class AgeBusinessObjectSelection implements BusinessObjectSelection {
	private final ImmutableList<BusinessObjectContext> bocs;
	private final AadlModificationService modificationService;

	public AgeBusinessObjectSelection(final Collection<? extends BusinessObjectContext> bocs,
			final AadlModificationService modificationService) {
		this.bocs = ImmutableList.copyOf(bocs);
		this.modificationService = Objects.requireNonNull(modificationService, "modificationService must not be null");
	}

	@Override
	public final <T> Stream<T> boStream(final Class<T> c) {
		return bocs.stream().map(boc -> c.cast(boc.getBusinessObject()));
	}

	@Override
	public final Stream<BusinessObjectContext> bocStream() {
		return bocs.stream();
	}

	@Override
	public <T extends EObject> void modify(final BiConsumer<T, BusinessObjectContext> modifier,
			final Function<BusinessObjectContext, T> bocToBoToModifyMapper) {
		for (final BusinessObjectContext tmpBoc : bocs) {
			final T boToModify = bocToBoToModifyMapper.apply(tmpBoc);

			modificationService.modify(boToModify, (resource, liveBoToModify) -> {
				modifier.accept(liveBoToModify, tmpBoc);
				return null;
			});
		}
	}

	@Override
	public <T extends EObject> void modify(final Class<T> c, final Consumer<T> modifier) {
		for (final BusinessObjectContext tmpBoc : bocs) {
			final T boToModify = c.cast(tmpBoc.getBusinessObject());

			modificationService.modify(boToModify, (resource, liveBoToModify) -> {
				modifier.accept(liveBoToModify);
				return null;
			});
		}
	}
}
