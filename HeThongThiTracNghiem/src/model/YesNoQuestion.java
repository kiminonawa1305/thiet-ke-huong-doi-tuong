package model;

import java.util.*;

public class YesNoQuestion implements OptionQuestion{
	private Map<String, Boolean> listAnswer;
	private String trueAnswer;
	
	public YesNoQuestion(Map<String, Boolean> listAnswer) {
		super();
		this.listAnswer = listAnswer;
		for(String key : listAnswer.keySet()) {
			if(listAnswer.get(key)) {
				trueAnswer = key;
			}
		}
	}
	
	public YesNoQuestion() {
	}

	@Override
	public boolean answer(Set<String> answers) {
		if(answers.size() != 0 && answers.size() == 1){
			return listAnswer.get(answers.toArray()[0]);
		}
		
		return false;
	}

	public Map<String, Boolean> getListAnswer() {
		return listAnswer;
	}
}
