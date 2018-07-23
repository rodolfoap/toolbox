//package org.rap.prgtests;
//
//import org.eclipse.core.runtime.IProgressMonitor;
//import org.eclipse.core.runtime.IStatus;
//import org.eclipse.core.runtime.Status;
//import org.eclipse.core.runtime.jobs.Job;
//
//public class JobsHelloWorld {
//	public static void main(String[] args) {
//		Taski taski = new Taski("Example");
//		taski.schedule(1000);
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//}
//
//class Taski extends Job {
//	public Taski(String name) {
//		super(name);
//		System.out.println(">>> Constructor! <<< name=" + name);
//	}
//
//	@Override
//	protected synchronized IStatus run(final IProgressMonitor monitor) {
//		System.out.println(">>> run(); <<<");
//		return Status.OK_STATUS;
//	}
//}
