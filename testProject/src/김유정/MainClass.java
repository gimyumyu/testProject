package 김유정;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;
import java.util.Enumeration;

public class MainClass extends JFrame implements ActionListener {
	ProgTest1 pt1 = new ProgTest1();
	ProgTest2 pt2 = new ProgTest2();
	JPanel member, member2, member3, gugu, result;
	JLabel id, name, phone, gender;
	JTextField tf1, tf2, tf3;
	JButton add, del, ser, show;
	JRadioButton male, female;
	ButtonGroup bg = new ButtonGroup();
	JTextArea ta;

	MainClass() {
		super("프로그래밍언어활용평가");

		// 회원등록, 삭제, 조회
		member = new JPanel(new BorderLayout());
		member.setBorder(new TitledBorder(new EtchedBorder(), "회원등록, 삭제, 조회"));
		id = new JLabel("회원ID");
		name = new JLabel("회원이름");
		phone = new JLabel("전화번호");
		gender = new JLabel("성별");
		tf1 = new JTextField(13);
		tf2 = new JTextField(13);
		tf3 = new JTextField(13);
		male = new JRadioButton("남");
		female = new JRadioButton("여");
		bg.add(male);
		bg.add(female);
		add = new JButton("회원등록");
		del = new JButton("회원삭제");
		ser = new JButton("전체회원조회");
		member2 = new JPanel(new FlowLayout());
		member2.add(id);		member2.add(tf1);
		member2.add(name);		member2.add(tf2);
		member2.add(phone);		member2.add(tf3);
		member2.add(gender);		member2.add(male);		member2.add(female);
		member3 = new JPanel(new FlowLayout());
		member3.add(add);		member3.add(del);		member3.add(ser);
		member.add(member2, "North");
		member.add(member3, "South");
		add(member, "North");

		// 구구단
		gugu = new JPanel(new FlowLayout());
		gugu.setBorder(new TitledBorder(new EtchedBorder(), "구구단"));
		show = new JButton("구구단보기");
		gugu.add(show);
		show.addActionListener(this);
		add(gugu, "Center");

		// 결과
		result = new JPanel(new BorderLayout());
		result.setBorder(new TitledBorder(new EtchedBorder(), "결과"));
		ta = new JTextArea(9, 15);
		result.add(ta);
		add(result, "South");

		// 버튼 액션리스너
		add.addActionListener(this);
		del.addActionListener(this);
		ser.addActionListener(this);

		setSize(800, 400);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("회원등록")) {
			int addbt = JOptionPane.showConfirmDialog(this, "회원을 등록하시겠습니까?", "회원등록", JOptionPane.YES_NO_OPTION);
			if (addbt == JOptionPane.YES_OPTION) {
				String str = "";
				Enumeration<AbstractButton> enums = bg.getElements();
				while (enums.hasMoreElements()) {
					AbstractButton ab = enums.nextElement();
					JRadioButton jb = (JRadioButton) ab;
					if (jb.isSelected())
						str = jb.getText();
				}
				pt2.mapListAdd(tf1.getText(), tf2.getText(), tf3.getText(), str);
			}
		}
		if (e.getActionCommand().equals("회원삭제")) {
			int delbt = JOptionPane.showConfirmDialog(this, "회원을 삭제하시겠습니까?", "회원삭제", JOptionPane.YES_NO_OPTION);
			if (delbt == JOptionPane.YES_OPTION) {
				pt2.mapListRemove(tf1.getText());
			}
		}
		if (e.getActionCommand().equals("전체회원조회")) {
			ta.setText("회원ID\t회원이름\t전화번호\t성별\n");
			String list = "";
			for (int i = 0; i < pt2.getMapList().size(); i++) {
				list += pt2.getMapList().get(i).getMemberID() + "\t" + pt2.getMapList().get(i).getName() + "\t"
						+ pt2.getMapList().get(i).getTel() + "\t" + pt2.getMapList().get(i).getGender() + "\n";
			}
			ta.append(list);
		}
		if (e.getActionCommand().equals("구구단보기")) {
			String gg = JOptionPane.showInputDialog(this, "몇단을 보시겠습니까?", "입력", JOptionPane.OK_CANCEL_OPTION);
			ta.setText(String.valueOf(gg + "단\n"));
			ta.append(pt1.getGugudan(Integer.parseInt(gg)));
		}
	}

	public static void main(String[] args) {
		MainClass mc = new MainClass();
		mc.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
