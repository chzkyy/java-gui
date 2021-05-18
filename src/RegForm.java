import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class RegForm extends JPanel implements ActionListener{
	
	private JPanel topPanel, midPanel, botPanel, genderPanel;
	private JLabel titleLbl, nameLbl, genderLbl, classLbl, raceLbl, bgLbl;
	private JTextField nameField, bgField;
	private JRadioButton maleBtn, femaleBtn;
	private JButton resetBtn, submitBtn;
	private ButtonGroup genderGroup;
	String[] pc = {"Select Class","Warrior","Mage","Thief"};
	JComboBox cs = new JComboBox(pc);
	String[] rc = {"Select Race","Human","Elf","Dwarf","Orc"};
	JComboBox race = new JComboBox(rc); 
		

	public RegForm() {
		setLayout(new BorderLayout());
		initComponent();
		addComponent();
		race.setSelectedItem("Select Class");
		cs.setSelectedItem("Select Race");
	}
	
	private void addComponent() {
		topPanel.add(titleLbl);
		
		midPanel.add(nameLbl);
		midPanel.add(nameField);
		midPanel.add(genderLbl);
		midPanel.add(genderPanel);
		
		midPanel.add(classLbl);
		midPanel.add(cs);
		midPanel.add(raceLbl);
		midPanel.add(race);
		midPanel.add(bgLbl);
		midPanel.add(bgField);
		
		
		botPanel.add(resetBtn);
		botPanel.add(submitBtn);
		
		genderGroup.add(maleBtn);
		genderGroup.add(femaleBtn);
		genderPanel.add(maleBtn);
		genderPanel.add(femaleBtn);
		
		add(topPanel, BorderLayout.NORTH);
		add(midPanel, BorderLayout.CENTER);
		add(botPanel, BorderLayout.SOUTH);
	}

	private void initComponent() {
		topPanel = initJPanel(new FlowLayout());
		midPanel = initJPanel(new GridLayout(5,2,10,30));
		midPanel.setBackground(new Color(0.5f, 0.2f, 0.9f));
		botPanel = initJPanel(new FlowLayout());
		genderPanel = initJPanel(new GridLayout(1,2));
		genderPanel.setBorder(new EmptyBorder(0,0,0,0));
		
		titleLbl = initJLabel("Bluejack Fantasy",40);
		titleLbl.setForeground(Color.WHITE);
		nameLbl = initJLabel("Name",20);
		genderLbl = initJLabel("Gender",20);
		raceLbl = initJLabel("Race", 20);
		classLbl = initJLabel("Class", 20);
		bgLbl = initJLabel("Background", 20);
		
		nameField = new JTextField();
		bgField = new JTextField();		
		
		maleBtn = initJRadioButton("Male");
		femaleBtn = initJRadioButton("Female");
		genderGroup = new ButtonGroup();
		
		resetBtn = initJButton("Reset");
		submitBtn = initJButton("Submit");	
				
	}

	private JPanel initJPanel(LayoutManager lm) {
		JPanel pnl = new JPanel(lm);
		pnl.setBackground(new Color(0f,0.9f,0.9f));
		pnl.setBorder(new EmptyBorder(10,10,10,10));
		return pnl;
	}

	private JLabel initJLabel(String st, Integer size) {
		JLabel lab = new JLabel(st);
		lab.setForeground(Color.WHITE);
		lab.setFont(new Font("Calibri", Font.PLAIN, size));
		return lab;
	}
	
	private JRadioButton initJRadioButton(String st) {
		JRadioButton radio = new JRadioButton(st);
		radio.setBackground(new Color(0.5f, 0.2f, 0.9f));
		radio.setFont(new Font("Calibri", Font.PLAIN, 20));
		radio.setForeground(Color.WHITE); 
		return radio;
	}
	
	private JButton initJButton(String st) {
		JButton btn = new JButton(st);
		btn.setBackground(new Color(0.6f, 0.5f,0.5f));
		btn.setForeground(Color.WHITE);
		btn.setPreferredSize(new Dimension(80,50));
		btn.setFont(new Font("Calibri", Font.PLAIN, 15));
		btn.addActionListener(this);
		return btn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == submitBtn) {
			validateData();
		}else {
			resetData();
		}
	}

	private void resetData() {
		int result = JOptionPane.showConfirmDialog(null,
				"Are you sure you want to reset?",
				"Reset form", JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.YES_OPTION) {
			nameField.setText("");
			genderGroup.clearSelection();
			cs.setSelectedItem("Select Class");
			race.setSelectedItem("Select Race");
			bgField.setText("");			
		}
	}

	private void validateData() {
		// TODO Auto-generated method stub
		String name = nameField.getText();
		String gender = (maleBtn.isSelected()) 
				? maleBtn.getText() : femaleBtn.getText();
		String bg = bgField.getText();
		cs.getSelectedItem();
		race.getSelectedItem();
		

		if(name.isEmpty()) {
			JOptionPane.showMessageDialog( null, "Name must be field!", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else if (name.length() < 2) {
			JOptionPane.showMessageDialog( null, "Name must contain 2 or more word", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else if (!maleBtn.isSelected() && !femaleBtn.isSelected()) {
			JOptionPane.showMessageDialog(null, "Gender must be Choose!", "Error", 
					JOptionPane.ERROR_MESSAGE);
		} else if (cs.getSelectedItem() == "Select Class") {
			JOptionPane.showMessageDialog(null, "Class must be Choose!", "Error", 
					JOptionPane.ERROR_MESSAGE);
		} else if (race.getSelectedItem() == "Select Race") {
			JOptionPane.showMessageDialog(null, "Race must be Choose!", "Error", 
					JOptionPane.ERROR_MESSAGE);
		} else if (bg.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Background must be field!", "Error", 
					JOptionPane.ERROR_MESSAGE);
		} else if (bg.length() > 100) {
			JOptionPane.showMessageDialog(null, "Background must not more 100 characters!", "Error", 
					JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Your character has been created!",
					"Character creation success", JOptionPane.INFORMATION_MESSAGE);
			nameField.setText("");
			genderGroup.clearSelection();
			cs.setSelectedItem("Select Class");
			race.setSelectedItem("Select Race");
			bgField.setText("");
		}
	}
}
