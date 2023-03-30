package model;

import java.util.*;

public class Exam {
	private String id, topic;
	private List<Question> listQuestion;
	private OptionCreateExam optionCreateExam;
	private boolean[] check;

	public Exam(String id, OptionCreateExam optionCreateExam) {
		super();
		this.id = id;
		this.topic = topic;
		listQuestion = new ArrayList<>();
		this.optionCreateExam = optionCreateExam;
	}

	public OptionCreateExam getOptionCreateExam() {
		return optionCreateExam;
	}

	public void setOptionCreateExam(OptionCreateExam optionCreateExam) {
		this.optionCreateExam = optionCreateExam;
	}

	public void createExam(Systems systems) {
		listQuestion = optionCreateExam.createExam(systems);
		this.topic = optionCreateExam.getTopic();
		check = new boolean[listQuestion.size()];
	}

	public String getId() {
		return id;
	}

	public String getTopic() {
		return topic;
	}

	public List<Question> getListQuestion() {
		return listQuestion;
	}

	public void answer(Question question, Set<String> answers) {
		check[listQuestion.indexOf(question)] = question.answer(answers);
	}

	public double getPoint() {
		double pointForQues = (double) 10 / listQuestion.size();
		int countTrueAnswer = 0;
		for (int i = 0; i < check.length; i++) {
			if (check[i]) {
				countTrueAnswer++;
			}
		}

		return pointForQues * countTrueAnswer;
	}

	public boolean equalsId(String id2) {
		return this.id.equals(id2);
	}
}
