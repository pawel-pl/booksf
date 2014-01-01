package interview;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestResult {

    int studentId;
    Date testDate;
    int testScore;

    public Map<Integer, Double> getFinalScores(List<TestResult> resultList) {

	Map<Integer, Double> finalScores = new HashMap<Integer, Double>();
	for (TestResult result : resultList) {
	    if (finalScores.containsKey(result.studentId)) {
		finalScores.put(result.studentId, finalScores.get(result.studentId) + result.testScore);
	    } else {
		finalScores.put(result.studentId, Double.valueOf(result.testScore));
	    }

	}
	
	return finalScores;
    }
}
