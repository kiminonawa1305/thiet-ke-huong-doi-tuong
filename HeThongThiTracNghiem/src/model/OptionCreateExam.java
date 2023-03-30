package model;

import java.util.List;
import java.util.Set;

public interface OptionCreateExam {
	public List<Question> createExam(Systems systems);

	public String getTopic();
}
