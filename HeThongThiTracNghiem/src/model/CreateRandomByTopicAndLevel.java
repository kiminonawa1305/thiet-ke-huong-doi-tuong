package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CreateRandomByTopicAndLevel implements OptionCreateExam{
	private String topic;
	private int count;
	private Level level;
	
	public CreateRandomByTopicAndLevel(String topic, int count, Level level) {
		super();
		this.topic = topic;
		this.count = count;
		this.level = level;
	}

	@Override
	public List<Question> createExam(Systems systems) {
		System.out.println("CreateRandomByTopicAndLevel");
		System.out.println("CreateRandomByTopic");
		List<Question> listQuestions = new ArrayList<>();
		
		List<Question> list = systems.getListQuestionByTopic(topic);
		if(list.size() == 0) {
			JOptionPane.showMessageDialog(new JFrame(), "Không tìm thấy chủ đề", "Lỗi", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		
		Random random = new Random();
		while(count > 0) {
			Question ques = list.get(random.nextInt(list.size() - 1));
			System.out.println(ques);
			if(!listQuestions.contains(ques) && ques.getLevel().equals(level)) {
				listQuestions.add(ques);
				count--;
			}
		}
		
		return listQuestions;
		
	}

	@Override
	public String getTopic() {
		// TODO Auto-generated method stub
		return topic;
	}

}
