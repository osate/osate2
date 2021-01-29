package org.osate.analysis.resource.budgets.internal.busload.model;

public interface Visitor<S> {
	public interface StateTransformer<S> {
		public S transformState(S oldState, ModelElement child);
	}

	public static final class Identity<S> implements StateTransformer<S> {
		@SuppressWarnings("rawtypes")
		private static final Identity IDENTITY = new Identity();

		private Identity() {
			super();
		}

		@Override
		public S transformState(final S oldState, final ModelElement child) {
			return oldState;
		}

		@SuppressWarnings("unchecked")
		public static <S> Identity<S> of() {
			return IDENTITY;
		}
	}

	// NB. short for "State Primed," i.e. S'
	public static final class Primed<S> {
		public final S state;
		public final StateTransformer<S> transformer;

		private Primed(final S state, final StateTransformer<S> transformer) {
			this.state = state;
			this.transformer = transformer;
		}

		public static <S> Primed<S> identity(final S state) {
			return new Primed<S>(state, Identity.of());
		}

		public static <S> Primed<S> val(final S state, final StateTransformer<S> transformer) {
			return new Primed<S>(state, transformer);
		}
	}
}
