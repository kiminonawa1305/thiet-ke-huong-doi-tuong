package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import control.ControlViewInterfaceExam;
import model.Exam;
import model.Level;
import model.Question;
import model.QuestionManyAnswer;
import model.QuestionOneAnswer;
import model.YesNoQuestion;

public class ViewInterfaceExam extends JFrame {
	private Exam exam;
	private JPanel contentPane, control, center, listButtonQuestion;
	private CardLayout layout;
	private JButton next, previous, submit;
	private ControlViewInterfaceExam controlViewInterfaceExam;
	private int ques = 0;
	
	public JButton getNext() {
		return next;
	}

	public JButton getPrevious() {
		return previous;
	}

	public JButton getSubmit() {
		return submit;
	}

	public ViewInterfaceExam(Exam exam) {
		this.exam = exam;
		this.init();
		this.setVisible(true);
	}
	
	public Exam getExam() {
		return exam;
	}
	
	public void init() {
		this.setTitle("Đề thi: " + this.exam.getId());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(700, 500);
		this.setLocationRelativeTo(null);

		controlViewInterfaceExam = new ControlViewInterfaceExam(this);
		
		layout = new CardLayout();
		center = new JPanel(layout);
		control = new JPanel(new BorderLayout());
		listButtonQuestion = new JPanel();
		submit = new JButton("Submit");
		next = new JButton("Next");
		next.addActionListener(controlViewInterfaceExam);
		previous = new JButton("Previous");
		previous.setActionCommand("First");
		previous.addActionListener(controlViewInterfaceExam);
		control.add(previous, BorderLayout.WEST);
		control.add(next, BorderLayout.EAST);
		
		createPanelQuestion();

		this.contentPane = new JPanel(new BorderLayout());
		this.contentPane.add(center, BorderLayout.CENTER);
		this.contentPane.add(control, BorderLayout.SOUTH);
		this.setContentPane(contentPane);
	}

	public void createPanelQuestion() {
		List<Question> listQuestions = exam.getListQuestion();
		for (int i = 0; i < listQuestions.size(); i++) {
			JPanel panelQuestion = new JPanel(new BorderLayout());
			panelQuestion.setBackground(Color.decode("#ffffcc"));
			JPanel panelAnswer = new JPanel(new FlowLayout(10));
			panelAnswer.setBackground(Color.decode("#ffffcc"));

			Question question = listQuestions.get(i);
			JLabel label = new JLabel(question.getContent());
			Map<String, Boolean> listAnswer = question.getOptionQuestion().getListAnswer();
			ButtonGroup group = new ButtonGroup();
			if (question.getOptionQuestion().getClass() == new QuestionManyAnswer(null).getClass()) {
				for (String key : listAnswer.keySet()) {
					JCheckBox box = new JCheckBox(key);
					box.setBackground(Color.decode("#ffffcc"));
					box.setPreferredSize(new Dimension(700, 30));
					panelAnswer.add(box);
				}
			} else {
				for (String key : listAnswer.keySet()) {
					JCheckBox box = new JCheckBox(key);
					box.setBackground(Color.decode("#ffffcc"));
					box.setPreferredSize(new Dimension(700, 30));
					group.add(box);
					panelAnswer.add(box);
				}
			}
			
			JButton button = new JButton((i + 1) + "");
			button.addActionListener(controlViewInterfaceExam);
			listButtonQuestion.add(button);
			
			panelQuestion.add(label, BorderLayout.NORTH);
			panelQuestion.add(panelAnswer, BorderLayout.CENTER);
			center.add((i + 1) + "", panelQuestion);
			control.add(listButtonQuestion, BorderLayout.CENTER);
		}
		
	}

	public static void main(String[] args) {
		Map<String, Boolean> listAnswer1 = new HashMap<>();
		listAnswer1.put("Đáp án đúng", true);
		listAnswer1.put("Đáp án sai", false);

		Map<String, Boolean> listAnswer2 = new HashMap<>();
		listAnswer2.put("Đáp án đúng", true);
		listAnswer2.put("Đáp án sai", false);
		listAnswer2.put("Đáp án sai", false);
		listAnswer2.put("Đáp án sai", false);

		Map<String, Boolean> listAnswer3 = new HashMap<>();
		listAnswer3.put("Đáp án đúng", true);
		listAnswer3.put("Đáp án đúng", true);
		listAnswer3.put("Đáp án sai", false);
		listAnswer3.put("Đáp án sai", false);

		Question question1 = new Question("What is the capital of France?", "Geography", Level.DIFFICULT,
				new YesNoQuestion(listAnswer1));
		Question question2 = new Question("What is the largest planet in the solar system?", "Astronomy", Level.MEDIUM,
				new QuestionManyAnswer(listAnswer3));
		Question question3 = new Question("What is the chemical symbol for gold?", "Chemistry", Level.EASY,
				new QuestionOneAnswer(listAnswer2));
		Question question4 = new Question("What is the highest mountain in the world?", "Geography", Level.EASY,
				new QuestionManyAnswer(listAnswer3));
		Question question5 = new Question("What is the boiling point of water?", "Science", Level.DIFFICULT,
				new QuestionOneAnswer(listAnswer2));
		Question question6 = new Question("What is the name of the smallest planet in the solar system?", "Astronomy",
				Level.MEDIUM, new YesNoQuestion(listAnswer1));

		List<Question> list = new ArrayList<>();
		list.add(question1);
		list.add(question2);
		list.add(question3);
		list.add(question4);
		list.add(question5);
		list.add(question6);

		ViewInterfaceExam test = new ViewInterfaceExam(new Exam("21130416", null, list, null));
	}
	
	public void showQuestion(int index) {
		if(index == exam.getListQuestion().size()) {
			next.setText("Submit");
		}else {
			next.setText("Next");
		}
		
		if(index == 1) {
			previous.setActionCommand("First");
		}else {
			previous.setActionCommand("Previous");
		}
		
		ques = index - 1;
		
		layout.show(center, index + "");
	}

	public void next() {
		layout.next(center);
		ques++;
		if(ques == 5) {
			next.setText("Submit");
		}
		
		previous.setActionCommand("Previous");
	}
	
	public void submit() {
		JOptionPane.showMessageDialog(this, "", "Bạn đã hoàn thành bài thi", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void previous() {
		layout.previous(center);
		ques--;
		
		if(ques < 5) {
			next.setText("Next");
		}
		
		if(ques == 0) {
			previous.setActionCommand("First");
		}
	}
}
