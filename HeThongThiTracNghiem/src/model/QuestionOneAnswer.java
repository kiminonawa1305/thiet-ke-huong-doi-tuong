package model;

import java.awt.RenderingHints.Key;
import java.util.*;

public class QuestionOneAnswer  implements OptionQuestion{
	private Map<String, Boolean> listAnswer;
	
	public QuestionOneAnswer(Map<String, Boolean> listAnswer) {
		super();
		this.listAnswer = listAnswer;
	}
	
	@Override
	public boolean answer(Set<String> listAnswer) {
		for(String key : listAnswer) {
			if(!this.listAnswer.get(key)) {
				return false;
			}
		}
		
		return true;
	}

	public Map<String, Boolean> getListAnswer() {
		return listAnswer;
	}
}
