package model;

import java.util.*;

public class Question {
	private String content, topic;
	private Level level;
	private OptionQuestion optionQuestion;
	private boolean[] listAnswer;
	private int point;
	private Set<String> answer;
	
	
	public Question(String content, String topic, Level level, OptionQuestion optionQuestion) {
		super();
		this.content = content;
		this.topic = topic;
		this.level = level;
		this.optionQuestion = optionQuestion;
	}

	public boolean answer(Set<String> answers) {
		return optionQuestion.answer(answers);
	}

	public String getContent() {
		return content;
	}

	public String getTopic() {
		return topic;
	}

	public Level getLevel() {
		return level;
	}
	
	public Set<String> getAnswer() {
		return answer;
	}
	public void setAnswer(Set<String> answer) {
		this.answer = answer;
	}

	public OptionQuestion getOptionQuestion() {
		return optionQuestion;
	}
	
	public void getPonit() {
		int sumQuestion = listAnswer.length;
		int count = 0;
		point = 0;
		for(int i = 0; i < sumQuestion; i++) {
			if(listAnswer[i]) {
				count++;
			}
		}
	}
	
}
