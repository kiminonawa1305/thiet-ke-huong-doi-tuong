package model;

import java.util.List;

public class HandmadeCreate implements OptionCreateExam {
	private String topic;

	@Override
	public List<Question> createExam(Systems systems) {
		System.out.println("HandmadeCreate");
		return null;
	}

	@Override
	public String getTopic() {
		return topic;
	}

}
