package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CreateRandomByTopic implements OptionCreateExam{
	private String topic;
	private int count;
	
	public CreateRandomByTopic(String topic, int count) {
		super();
		this.topic = topic;
		this.count = count;
	}

	@Override
	public List<Question> createExam(Systems systems) {
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
			if(!listQuestions.contains(ques)) {
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
