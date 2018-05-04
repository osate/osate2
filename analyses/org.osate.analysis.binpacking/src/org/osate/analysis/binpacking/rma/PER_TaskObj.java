package org.osate.analysis.binpacking.rma;

/**
 * Task object for RMA analysis.  Originally from package
 * <code>rapt.QAplugins.performance</code> in the ArchE
 * project. 
 * 
 * @author cshelton
 */
public class PER_TaskObj {
	private int taskID = -1;

	private int taskPriority = -1;

	private double executionTime = -1;

	private double taskPeriod = -1;

	private double taskDeadline = -1;

	private double blockingTime = -1;

	public PER_TaskObj(int id) {
		taskID = id;
		executionTime = 0;
		blockingTime = 0;
	}

	public PER_TaskObj(int id, int priority, double exec_time, double period, double deadline, double blocking_time) {
		taskID = id;
		taskPriority = priority;
		executionTime = exec_time;
		taskPeriod = period;
		taskDeadline = deadline;
		blockingTime = blocking_time;
	}

	public int getID() {
		return taskID;
	}

	public int getPriority() {
		return taskPriority;
	}

	public double getExecutionTime() {
		return executionTime;
	}

	public double getPeriod() {
		return taskPeriod;
	}

	public double getUtilization() {
		return executionTime / taskPeriod;
	}

	public double getDeadline() {
		return taskDeadline;
	}

	public double getBlockingTime() {
		return blockingTime;
	}

	public void setPriority(int priorityValue) {
		taskPriority = priorityValue;
	}

	public void setExecutionTime(double execTimeValue) {
		executionTime = execTimeValue;
	}

	public void setPeriod(double periodValue) {
		taskPeriod = periodValue;
	}

	public void setDeadline(double deadlineValue) {
		taskDeadline = deadlineValue;
	}

	public void setBlockingTime(double blockingValue) {
		blockingTime = blockingValue;
	}

	public String toString() {
		return new String("Task: ID = " + taskID + " Priority = " + taskPriority + " Execution Time = " + executionTime
				+ " Period = " + taskPeriod + " Deadline = " + taskDeadline);
	}
}