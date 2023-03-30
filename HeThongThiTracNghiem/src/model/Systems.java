package model;

import java.util.*;

public class Systems {
	/**
	 * Danh sách các câu hỏi phân theeo chủ đề.
	 */
	private Map<String, Set<Question>> listQuestionByTopic;
	private List<Exam> listExams;

	public Systems() {
		this.listQuestionByTopic = new HashMap<>();
		this.listExams = new ArrayList<>();
	}

	public Map<String, Set<Question>> getListQuestionByTopic() {
		return listQuestionByTopic;
	}

	public List<Exam> getListExams() {
		return listExams;
	}

	public void createExam(String id, OptionCreateExam optionCreateExam) {
		Exam exam = new Exam(id, optionCreateExam);
		exam.createExam(this);
		listExams.add(exam);
	}

	public void addQuestion(Question question) {
		String topic = question.getTopic();

		if (listQuestionByTopic.containsKey(topic)) {
			listQuestionByTopic.get(topic).add(question);
		} else {
			Set<Question> list = new HashSet<>();
			list.add(question);
			listQuestionByTopic.put(topic, list);
		}
	}

	public Exam getExam(String id) {
		for (Exam exam : listExams) {
			if (exam.equalsId(id)) {
				return exam;
			}
		}

		return null;
	}

	public List<Question> getListQuestionByTopic(String topic) {
		List<Question> re = new ArrayList<>();
		for (Question ques : listQuestionByTopic.get(topic)) {
			re.add(ques);
		}

		return re;
	}
}
