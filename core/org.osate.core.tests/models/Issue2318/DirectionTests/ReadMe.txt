These tests check that the code at the end of CreateConnectionsSwtich.appendSegment()

	private void appendSegment(ConnectionInfo connInfo, final Connection newSegment, final ComponentInstance ci,
			final boolean goOpposite) {

properly sets the `opposite` flag when building the connections.

			