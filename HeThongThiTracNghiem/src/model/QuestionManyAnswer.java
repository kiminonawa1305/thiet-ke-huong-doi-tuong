package model;

import java.util.*;

public class QuestionManyAnswer  implements OptionQuestion{
	private Map<String, Boolean> listAnswer;
	
	public QuestionManyAnswer(Map<String, Boolean> listAnswer) {
		super();
		this.listAnswer = listAnswer;
	}
	
	@Override
	public boolean answer(Set<String> listAnswer) {
		// TODO Auto-generated method stub
		return false;
	}

	public Map<String, Boolean> getListAnswer() {
		return listAnswer;
	}
}
