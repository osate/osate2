package EAnalysis.BinPacking;

public class AssignmentResult {
	public AssignmentProblem problem;

	public boolean success = false;

	public AssignmentResult() {
	}

	public AssignmentResult(AssignmentProblem p, boolean r) {
		problem = p;
		success = r;
	}
}
