package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
	private List<PanelQuestion> listPanelQuestion;
	private CardLayout layout;
	private JButton next, previous, submit;
	private ControlViewInterfaceExam controlViewInterfaceExam;
	private int ques = 0;
	private PanelQuestion nowQuestion;

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
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setSize(700, 500);
		this.setLocationRelativeTo(null);

		controlViewInterfaceExam = new ControlViewInterfaceExam(this);

		this.contentPane = new JPanel(new BorderLayout());
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
		listPanelQuestion = new ArrayList<>();

		createPanelQuestion();

		this.contentPane.add(center, BorderLayout.CENTER);
		this.contentPane.add(control, BorderLayout.SOUTH);
		this.setContentPane(contentPane);
	}

	public void createPanelQuestion() {
		List<Question> listQuestions = exam.getListQuestion();
		for (int i = 0; i < listQuestions.size(); i++) {
			PanelQuestion panelQuestion = new PanelQuestion(listQuestions.get(i));

			JButton button = new JButton((i + 1) + "");
			button.addActionListener(controlViewInterfaceExam);
			listButtonQuestion.add(button);

			center.add((i + 1) + "", panelQuestion);
			control.add(listButtonQuestion, BorderLayout.CENTER);

			listPanelQuestion.add(panelQuestion);
		}

		nowQuestion = listPanelQuestion.get(ques);
	}

	public void answer() {

	}

	public void showQuestion(int index) {
		if (index == exam.getListQuestion().size()) {
			next.setText("Submit");
		} else {
			next.setText("Next");
		}

		if (index == 1) {
			previous.setActionCommand("First");
		} else {
			previous.setActionCommand("Previous");
		}

		exam.answer(listPanelQuestion.get(ques).getQuestion(), listPanelQuestion.get(ques).answer());
		ques = index - 1;

		layout.show(center, index + "");
	}

	public void next() {
		exam.answer(listPanelQuestion.get(ques).getQuestion(), listPanelQuestion.get(ques).answer());

		layout.next(center);
		ques++;

		if (ques == 5) {
			next.setText("Submit");
		}

		previous.setActionCommand("Previous");
	}

	public void submit() {
		exam.answer(listPanelQuestion.get(ques).getQuestion(), listPanelQuestion.get(ques).answer());
		JOptionPane.showMessageDialog(this, "Điểm số của bạn là: " + exam.getPoint(), "Bạn đã hoàn thành bài thi",
				JOptionPane.INFORMATION_MESSAGE);
	}
	

	public void previous() {
		exam.answer(listPanelQuestion.get(ques).getQuestion(), listPanelQuestion.get(ques).answer());
		ques--;
		nowQuestion = listPanelQuestion.get(ques);

		if (ques < 5) {
			next.setText("Next");
		}

		if (ques == 0) {
			previous.setActionCommand("First");
		}
	}
}
