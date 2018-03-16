package org.osate.ge.internal.ui.properties;

import java.util.Collection;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EObject;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.AadlModificationService.Modification;

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
	public <T extends EObject> void modify(final Function<BusinessObjectContext, T> bocToBoToModifyMapper,
			final BiConsumer<T, BusinessObjectContext> modifier) {
		final ImmutableList<Modification<BusinessObjectContext, T>> modifications = bocs.stream()
				.map(boc -> Modification.create(boc, bocToBoToModifyMapper, (boc2, liveBoToModify) -> {
					modifier.accept(liveBoToModify, boc2);
				})).collect(ImmutableList.toImmutableList());
		modificationService.modify(modifications);
	}

	@Override
	public <T extends EObject> void modify(final Class<T> c, final Consumer<T> modifier) {
		modify(boc -> c.cast(boc.getBusinessObject()), (bo, boc) -> modifier.accept(bo));
	}
}
