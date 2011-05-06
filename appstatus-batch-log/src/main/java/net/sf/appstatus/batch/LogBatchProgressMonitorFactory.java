package net.sf.appstatus.batch;

import net.sf.appstatus.core.batch.IBatch;
import net.sf.appstatus.core.batch.IBatchProgressMonitor;
import net.sf.appstatus.core.batch.IBatchProgressMonitorFactory;

public class LogBatchProgressMonitorFactory implements IBatchProgressMonitorFactory {

	public IBatchProgressMonitor getMonitor(String executionId, IBatch batch) {
		return new LogBatchProgressMonitor(executionId);
	}

}
