package model;

import java.util.*;

public class QuestionManyAnswer implements OptionQuestion {
	private Map<String, Boolean> listAnswer;
	private int countTrueAnswer;

	public QuestionManyAnswer(Map<String, Boolean> listAnswer) {
		super();
		this.listAnswer = listAnswer;
		this.countTrueAnswer = 0;
		for (String key : listAnswer.keySet()) {
			if (listAnswer.get(key)) {
				this.countTrueAnswer++;
			}
		}
	}
	
	public QuestionManyAnswer() {
	}

	@Override
	public boolean answer(Set<String> answers) {
		int count = 0;
		for (String a : answers) {
			if (listAnswer.get(a)) {
				count++;
			}
		}

		return count == this.countTrueAnswer;
	}

	public Map<String, Boolean> getListAnswer() {
		return listAnswer;
	}
}
