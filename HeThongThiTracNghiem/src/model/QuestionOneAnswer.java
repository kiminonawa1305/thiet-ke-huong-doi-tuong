package model;

import java.awt.RenderingHints.Key;
import java.util.*;

public class QuestionOneAnswer  implements OptionQuestion{
	private Map<String, Boolean> listAnswer;
	
	public QuestionOneAnswer(Map<String, Boolean> listAnswer) {
		super();
		this.listAnswer = listAnswer;
	}
	
	public QuestionOneAnswer() {
	}
	
	

	public Map<String, Boolean> getListAnswer() {
		return listAnswer;
	}

	@Override
	public boolean answer(Set<String> answers) {
		if(answers.size() != 0 && answers.size() == 1){
			return listAnswer.get(answers.toArray()[0]);
		}
		
		return false;
	}
}

