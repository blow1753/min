import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Project {

	Vector v;
	Vector cols;
	DefaultTableModel model;
	JTable tab;
	JScrollPane pane;

	public Project() {
		JFrame f1 = new JFrame("epic7");
		JFrame f2 = new JFrame("�� ȸ");
		JPanel p1 = new JPanel();
		JLabel lb1 = new JLabel(" ");
		JLabel lb2 = new JLabel(" ");
		JLabel imagelb1 = new JLabel();
		JLabel imagelb2 = new JLabel();
		JButton btn1 = new JButton("��ȸ");
		JButton btn2 = new JButton("��ü ��ȸ");
		JButton btn3 = new JButton("ó������");
		JButton btn4 = new JButton("�ӵ���ȸ");
		ImageIcon imageIcon1 = new ImageIcon("C:\\Users\\user\\Pictures\\epic7.jpg");

		String[] area = { "���", "����", "������", "����", "���ɻ�", "���" };
		String[] type = { "�־Ʊ�", "�θ���", "ó���", "����", "���ڱ�", "�ݿ��", "������", "�־��", "õ����", "���ر�", "������", "õĪ��" };

		JComboBox<String> box1 = new JComboBox(area);
		JComboBox<String> box2 = new JComboBox(type);

		f1.getContentPane().setLayout(null);

		// f1������

		f1.add(box1);
		f1.add(box2);
		f1.add(btn1);
		f1.add(btn2);
		f1.add(lb1);
		f1.add(lb2);
		// ����̹��� 1
		imagelb1.setIcon(new ImageIcon("C:\\Users\\user\\Pictures\\11.png"));
		imagelb1.setBounds(0, 0, 400, 300);
		// imagelb2.setIcon(new ImageIcon("C:\\Users\\user\\Pictures\\12224.jpg"));
		// imagelb2.setBounds(0,330, 800, 300);
		//
		f1.getContentPane().add(imagelb1);
		f2.getContentPane().add(imagelb2);
//�Ӽ�/���ڸ�
		box1.setBounds(120, 10, 120, 30);
		box2.setBounds(120, 45, 120, 30);

//�Ϲ���ȸ��ư
		btn1.setBounds(250, 10, 100, 65);
//		btn1.setBorderPainted(false);
//		btn1.setContentAreaFilled(false);
//		btn1.setFocusPainted(false);
//��ü��ȸ ��/����/����/��
		btn2.setBounds(260, 220, 120, 40);
		btn4.setBounds(120,180,120,40);

		cols = getColumn();
		model = new DefaultTableModel(cols, 0) {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		};
		tab = new JTable(model);
		pane = new JScrollPane(tab);

		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.setNumRows(0);
				String boxset1 = (String) box1.getSelectedItem();
				System.out.println(boxset1);
				String boxset2 = (String) box2.getSelectedItem();
				epic7 dao = new epic7();
				v = dao.getList(boxset1, boxset2);
				System.out.println(boxset2);
				System.out.println("v=" + v);
				model.setDataVector(v, cols);
				f2.add(pane);

				tab.getColumnModel().getColumn(0).setPreferredWidth(0);
				tab.getColumnModel().getColumn(1).setPreferredWidth(0);
				tab.getColumnModel().getColumn(2).setPreferredWidth(0);
				tab.getColumnModel().getColumn(3).setPreferredWidth(100);
				tab.getColumnModel().getColumn(4).setPreferredWidth(0);
				tab.getColumnModel().getColumn(5).setPreferredWidth(50);
				tab.getColumnModel().getColumn(6).setPreferredWidth(200);

				f1.setVisible(false);
				f2.setVisible(true);
			}
		});

		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.setNumRows(0);
				String boxset1 = (String) box1.getSelectedItem();
				System.out.println(boxset1);
				String boxset2 = (String) box2.getSelectedItem();
				epic7 dao = new epic7();
				v = dao.getList();
				System.out.println(boxset2);
				System.out.println("v=" + v);
				model.setDataVector(v, cols);
				f2.add(pane);
				f1.setVisible(false);
				f2.setVisible(true);
			}
		});
		
//�Ӽ����ڸ� txt
		lb1.setBounds(10, 10, 150, 30);
		lb2.setBounds(10, 50, 150, 30);
//�̹���
		Image image = imageIcon1.getImage();
		f1.setIconImage(image);
		f1.setSize(400, 300);
		f1.setResizable(false);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setLocationRelativeTo(null);
		f1.setVisible(true);

		// f2������

		p1.add(btn3);
		f2.add(btn3, BorderLayout.SOUTH);
		// bet.setBounds(120, 45, 120, 30);
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f1.setVisible(true);
				f2.setVisible(false);
			}
		});
//2��°������
		Image image2 = imageIcon1.getImage();
		f2.setIconImage(image2);
		f2.setSize(800, 700);
		f2.setVisible(false);
		f2.setResizable(false);
		f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f2.setLocationRelativeTo(null);
		
		

	}

	public Vector getColumn() {
		Vector col = new Vector();
		col.add("ID");
		col.add("NAME");
		col.add("CLASS");
		col.add("ATTRIBUTE");
		col.add("CONSTELLATION");
		col.add("SPECIALTY");
		col.add("SPEED");

		return col;
	}


	public static void main(String[] args) {
		new Project();
	}

}