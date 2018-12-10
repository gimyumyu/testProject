package ������;

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
		super("���α׷��־��Ȱ����");

		// ȸ�����, ����, ��ȸ
		member = new JPanel(new BorderLayout());
		member.setBorder(new TitledBorder(new EtchedBorder(), "ȸ�����, ����, ��ȸ"));
		id = new JLabel("ȸ��ID");
		name = new JLabel("ȸ���̸�");
		phone = new JLabel("��ȭ��ȣ");
		gender = new JLabel("����");
		tf1 = new JTextField(13);
		tf2 = new JTextField(13);
		tf3 = new JTextField(13);
		male = new JRadioButton("��");
		female = new JRadioButton("��");
		bg.add(male);
		bg.add(female);
		add = new JButton("ȸ�����");
		del = new JButton("ȸ������");
		ser = new JButton("��üȸ����ȸ");
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

		// ������
		gugu = new JPanel(new FlowLayout());
		gugu.setBorder(new TitledBorder(new EtchedBorder(), "������"));
		show = new JButton("�����ܺ���");
		gugu.add(show);
		show.addActionListener(this);
		add(gugu, "Center");

		// ���
		result = new JPanel(new BorderLayout());
		result.setBorder(new TitledBorder(new EtchedBorder(), "���"));
		ta = new JTextArea(9, 15);
		result.add(ta);
		add(result, "South");

		// ��ư �׼Ǹ�����
		add.addActionListener(this);
		del.addActionListener(this);
		ser.addActionListener(this);

		setSize(800, 400);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("ȸ�����")) {
			int addbt = JOptionPane.showConfirmDialog(this, "ȸ���� ����Ͻðڽ��ϱ�?", "ȸ�����", JOptionPane.YES_NO_OPTION);
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
		if (e.getActionCommand().equals("ȸ������")) {
			int delbt = JOptionPane.showConfirmDialog(this, "ȸ���� �����Ͻðڽ��ϱ�?", "ȸ������", JOptionPane.YES_NO_OPTION);
			if (delbt == JOptionPane.YES_OPTION) {
				pt2.mapListRemove(tf1.getText());
			}
		}
		if (e.getActionCommand().equals("��üȸ����ȸ")) {
			ta.setText("ȸ��ID\tȸ���̸�\t��ȭ��ȣ\t����\n");
			String list = "";
			for (int i = 0; i < pt2.getMapList().size(); i++) {
				list += pt2.getMapList().get(i).getMemberID() + "\t" + pt2.getMapList().get(i).getName() + "\t"
						+ pt2.getMapList().get(i).getTel() + "\t" + pt2.getMapList().get(i).getGender() + "\n";
			}
			ta.append(list);
		}
		if (e.getActionCommand().equals("�����ܺ���")) {
			String gg = JOptionPane.showInputDialog(this, "����� ���ðڽ��ϱ�?", "�Է�", JOptionPane.OK_CANCEL_OPTION);
			ta.setText(String.valueOf(gg + "��\n"));
			ta.append(pt1.getGugudan(Integer.parseInt(gg)));
		}
	}

	public static void main(String[] args) {
		MainClass mc = new MainClass();
		mc.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
