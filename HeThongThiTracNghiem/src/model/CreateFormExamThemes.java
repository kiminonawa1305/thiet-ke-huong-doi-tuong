package model;

import java.util.List;
import java.util.Set;

public class CreateFormExamThemes implements OptionCreateExam{
	private Exam exam;

	public CreateFormExamThemes(Exam exam) {
		super();
		this.exam = exam;
	}


	@Override
	public List<Question> createExam(Systems systems) {
		System.out.println("CreateFormExamThemes");
		return null;
	}


	@Override
	public String getTopic() {
		// TODO Auto-generated method stub
		return exam.getTopic();
	}
}
