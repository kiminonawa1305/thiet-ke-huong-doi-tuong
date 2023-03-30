package view;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;

import model.Question;
import model.QuestionManyAnswer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.*;

public class PanelQuestion extends JPanel {
	private Set<String> answer;
	private Question question;
	private List<JToggleButton> listButtonAnswer;

	public PanelQuestion(Question question) {
		super();
		this.question = question;
		this.answer = new HashSet<>();
		this.init();
	}

	public void init() {
		this.setLayout(new BorderLayout());
		this.setBackground(Color.decode("#ffffcc"));

		JPanel panelAnswer = new JPanel(new FlowLayout(10));
		panelAnswer.setBackground(Color.decode("#ffffcc"));
		JLabel label = new JLabel(question.getContent());
		Map<String, Boolean> listAnswer = question.getOptionQuestion().getListAnswer();
		if (question.getOptionQuestion() instanceof QuestionManyAnswer) {
			listButtonAnswer = new ArrayList<>();

			for (String key : listAnswer.keySet()) {
				JCheckBox box = new JCheckBox(key);
				box.setBackground(Color.decode("#ffffcc"));
				box.setPreferredSize(new Dimension(700, 30));
				panelAnswer.add(box);
				listButtonAnswer.add((JToggleButton) box);
			}
		} else {
			ButtonGroup group = new ButtonGroup();
			listButtonAnswer = new ArrayList<>();

			for (String key : listAnswer.keySet()) {
				JRadioButton box = new JRadioButton(key);
				box.setBackground(Color.decode("#ffffcc"));
				box.setPreferredSize(new Dimension(700, 30));
				group.add(box);
				panelAnswer.add(box);
				listButtonAnswer.add((JToggleButton) box);
			}
		}

		this.add(label, BorderLayout.NORTH);
		this.add(panelAnswer, BorderLayout.CENTER);
	}

	public Set<String> answer() {
		answer.removeAll(answer);
		for (JToggleButton button : listButtonAnswer) {
			if (button.isSelected()) {
				answer.add(button.getText());
			}
		}
		return answer;
	}

	public Set<String> getAnswer() {
		return answer;
	}

	public Question getQuestion() {
		return question;
	}

	public List<JToggleButton> getListButtonAnswer() {
		return listButtonAnswer;
	}
}
