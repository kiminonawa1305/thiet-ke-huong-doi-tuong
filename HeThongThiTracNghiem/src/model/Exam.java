package model;

import java.util.List;

public class Exam {
	private String id, topic;
	private List<Question> listQuestion;
	private OptionCreateExam optionCreateExam;
	public Exam(String id, String topic, List<Question> listQuestion, OptionCreateExam optionCreateExam) {
		super();
		this.id = id;
		this.topic = topic;
		this.listQuestion = listQuestion;
		this.optionCreateExam = optionCreateExam;
	}
	public OptionCreateExam getOptionCreateExam() {
		return optionCreateExam;
	}
	public void setOptionCreateExam(OptionCreateExam optionCreateExam) {
		this.optionCreateExam = optionCreateExam;
	}
	
	public void createExam(Systems systems) {
		optionCreateExam.createExam(systems);
//		listQuestion = optionCreateExam.createExam(systems);
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
}
