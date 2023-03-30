package view;

import java.awt.BorderLayout;
import java.awt.MenuBar;
import java.time.chrono.JapaneseChronology;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.swing.*;

import control.ControlViewSystems;
import model.CreateFormExamThemes;
import model.CreateRandomByTopic;
import model.Exam;
import model.Level;
import model.OptionCreateExam;
import model.Question;
import model.QuestionManyAnswer;
import model.QuestionOneAnswer;
import model.Systems;
import model.YesNoQuestion;

public class ViewSystems extends JFrame {
	private JButton createExamButton;
	private JLabel idExamLabel;
	private JPanel contentPane;
	private Systems systems;
	private JMenuItem itemExam, itemCreateExam;
	private PanelExam panelExam;
	private ControlViewSystems controlViewSystems;

	public ViewSystems(Systems systems) {
		this.systems = systems;
		this.init();
		this.addEvent();
		this.setVisible(true);
	}

	public JButton getCreateExamButton() {
		return createExamButton;
	}

	public JLabel getIdExamLabel() {
		return idExamLabel;
	}

	public JPanel getContentPane() {
		return contentPane;
	}
	
	public JMenuItem getItemExam() {
		return itemExam;
	}

	public JMenuItem getItemCreateExam() {
		return itemCreateExam;
	}

	public void init() {
		this.setTitle("Hệ thống thi trắc nghiệm xin chào!");
		this.setSize(500, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		controlViewSystems = new ControlViewSystems(this);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menuHome = new JMenu("Home");
		itemExam = new JMenuItem("Thi");
		itemCreateExam = new JMenuItem("Tạo đề  thi");
		menuHome.add(itemExam);
		menuHome.addSeparator();
		menuHome.add(itemCreateExam);
		menuBar.add(menuHome);

		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		panelExam = new PanelExam(this);

		createExamButton = new JButton("Tạo đề thi của bạn!");

		contentPane.add(createExamButton);
		this.setJMenuBar(menuBar);
		this.setContentPane(contentPane);
	}
	
	public void addEvent() {
		this.itemCreateExam.addActionListener(controlViewSystems);
		this.itemExam.addActionListener(controlViewSystems);
		createExamButton.addActionListener(controlViewSystems);
	}

	public void createExam(OptionCreateExam optionCreateExam) {
		Random random = new Random();
		String id = random.nextInt(0, 99999999) + "";
		Exam exam = new Exam(id,  optionCreateExam);

		exam.createExam(systems);
		JOptionPane.showMessageDialog(this, id, "Mã đề thi của bạn là: ", JOptionPane.INFORMATION_MESSAGE);
	}

	public void chooseOptionCreate() {

	}

	public static void main(String[] args) {
		Map<String, Boolean> listAnswer1 = new HashMap<>();
		listAnswer1.put("Đáp án 1", true);
		listAnswer1.put("Đáp án 2", false);

		Map<String, Boolean> listAnswer2 = new HashMap<>();
		listAnswer2.put("Đáp án 1", true);
		listAnswer2.put("Đáp án 2", false);
		listAnswer2.put("Đáp án 3", false);
		listAnswer2.put("Đáp án 4", false);

		Map<String, Boolean> listAnswer3 = new HashMap<>();
		listAnswer3.put("Đáp án 1", true);
		listAnswer3.put("Đáp án 2", true);
		listAnswer3.put("Đáp án 3", false);
		listAnswer3.put("Đáp án 4", false);

		Question question1 = new Question("Câu hỏi 1", "Chủ đề 1", Level.DIFFICULT, new YesNoQuestion(listAnswer1));
		Question question2 = new Question("Câu hỏi 2", "Chủ đề 2", Level.MEDIUM, new QuestionManyAnswer(listAnswer3));
		Question question3 = new Question("Câu hỏi 3", "Chủ đề 3", Level.EASY, new QuestionOneAnswer(listAnswer2));
		Question question4 = new Question("Câu hỏi 4", "Chủ đề 4", Level.EASY, new QuestionManyAnswer(listAnswer3));
		Question question5 = new Question("Câu hỏi 5", "Chủ đề 1", Level.DIFFICULT, new QuestionOneAnswer(listAnswer2));
		Question question6 = new Question("Câu hỏi 6", "Chủ đề 1", Level.MEDIUM, new YesNoQuestion(listAnswer1));
		Question question7 = new Question("Câu hỏi 7", "Chủ đề 2", Level.DIFFICULT, new YesNoQuestion(listAnswer1));
		Question question8 = new Question("Câu hỏi 8", "Chủ đề 4", Level.MEDIUM, new QuestionManyAnswer(listAnswer3));
		Question question9 = new Question("Câu hỏi 9", "Chủ đề 1", Level.EASY, new QuestionOneAnswer(listAnswer2));
		Question question10 = new Question("Câu hỏi 10", "Chủ đề 3", Level.EASY, new QuestionManyAnswer(listAnswer2));
		Question question11 = new Question("Câu hỏi 11", "Chủ đề 3", Level.DIFFICULT, new QuestionOneAnswer(listAnswer2));
		Question question12 = new Question("Câu hỏi 12", "Chủ đề 2", Level.MEDIUM, new YesNoQuestion(listAnswer1));
		Question question13 = new Question("Câu hỏi 13", "Chủ đề 1", Level.DIFFICULT, new YesNoQuestion(listAnswer1));
		Question question14 = new Question("Câu hỏi 14", "Chủ đề 2", Level.MEDIUM, new QuestionManyAnswer(listAnswer3));
		Question question15 = new Question("Câu hỏi 15", "Chủ đề 3", Level.EASY, new QuestionOneAnswer(listAnswer2));
		Question question16 = new Question("Câu hỏi 16", "Chủ đề 4", Level.EASY, new QuestionManyAnswer(listAnswer3));
		Question question17 = new Question("Câu hỏi 17", "Chủ đề 1", Level.DIFFICULT, new QuestionOneAnswer(listAnswer2));
		Question question18 = new Question("Câu hỏi 18", "Chủ đề 1", Level.MEDIUM, new YesNoQuestion(listAnswer1));
		Question question19 = new Question("Câu hỏi 19", "Chủ đề 2", Level.DIFFICULT, new YesNoQuestion(listAnswer1));
		Question question20 = new Question("Câu hỏi 20", "Chủ đề 4", Level.MEDIUM, new QuestionManyAnswer(listAnswer3));
		Question question21 = new Question("Câu hỏi 21", "Chủ đề 1", Level.EASY, new QuestionOneAnswer(listAnswer2));
		Question question22 = new Question("Câu hỏi 22", "Chủ đề 3", Level.EASY, new QuestionManyAnswer(listAnswer3));
		Question question23 = new Question("Câu hỏi 23", "Chủ đề 3", Level.DIFFICULT, new QuestionOneAnswer(listAnswer2));
		Question question24 = new Question("Câu hỏi 24", "Chủ đề 2", Level.MEDIUM, new YesNoQuestion(listAnswer3));

		Systems systems = new Systems();
		systems.addQuestion(question1);
		systems.addQuestion(question2);
		systems.addQuestion(question3);
		systems.addQuestion(question4);
		systems.addQuestion(question5);
		systems.addQuestion(question6);
		systems.addQuestion(question7);
		systems.addQuestion(question8);
		systems.addQuestion(question9);
		systems.addQuestion(question10);
		systems.addQuestion(question11);
		systems.addQuestion(question12);
		systems.addQuestion(question13);
		systems.addQuestion(question14);
		systems.addQuestion(question15);
		systems.addQuestion(question16);
		systems.addQuestion(question17);
		systems.addQuestion(question18);
		systems.addQuestion(question19);
		systems.addQuestion(question20);
		systems.addQuestion(question21);
		systems.addQuestion(question22);
		systems.addQuestion(question23);
		systems.addQuestion(question24);
		
		systems.createExam("123", new CreateRandomByTopic("Chủ đề 1", 3));
		System.out.println(systems.getExam("123").getListQuestion());

		ViewSystems test = new ViewSystems(systems);
	}
	
	public void openFrameExam() {
		this.setContentPane(panelExam);
		this.validate();
	}
	
	public Exam getExem(String id) {
		return systems.getExam(id);
	}
}
