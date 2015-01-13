package org.osate.units.test;

import org.junit.Test;

public class Watchpersontest {
	private static String watchedLog;

//	@Rule
//	public TestRule watchman = new TestWatcher() {
//		@Override
//		public Statement apply(Statement base, Description description) {
//			return super.apply(base, description);
//		}
//
//		@Override
//		protected void succeeded(Description description) {
//			watchedLog += description.getDisplayName() + " " + "success!\n";
//		}
//
//		@Override
//		protected void failed(Throwable e, Description description) {
//			watchedLog += description.getDisplayName() + " " + e.getClass().getSimpleName() + "\n";
//		}
//
//		@Override
//		protected void skipped(AssumptionViolatedException e, Description description) {
//			watchedLog += description.getDisplayName() + " " + e.getClass().getSimpleName() + "\n";
//		}
//
//		@Override
//		protected void starting(Description description) {
//			super.starting(description);
//		}
//
//		@Override
//		protected void finished(Description description) {
//			super.finished(description);
//		}
//	};

	@Test
	public void fails() {
		System.out.println("hello me");
	}

	@Test
	public void succeeds() {
	}
}
