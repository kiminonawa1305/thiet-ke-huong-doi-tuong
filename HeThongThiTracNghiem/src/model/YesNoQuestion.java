package model;

import java.util.*;

public class YesNoQuestion implements OptionQuestion{
	public Map<String, Boolean> listAnswer;
	
	public YesNoQuestion(Map<String, Boolean> listAnswer) {
		super();
		this.listAnswer = listAnswer;
	}

	@Override
	public boolean answer(Set<String> listAnswer) {
		return false;
	}

	public Map<String, Boolean> getListAnswer() {
		return listAnswer;
	}
}
