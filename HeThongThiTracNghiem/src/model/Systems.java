package model;

import java.util.*;

public class Systems {
	/**
	 * Danh sách các câu hỏi phân theeo chủ đề.
	 */
	private Map<String, List<Question>> listQuestionByTopic;
	private List<Exam> listExams;
	
	public Systems() {
		this.listQuestionByTopic = new HashMap<>();
		this.listExams = new ArrayList<>();
	}

	public void createExam(Exam exam) {
		exam.createExam(this);
		listExams.add(exam);
	}
}
