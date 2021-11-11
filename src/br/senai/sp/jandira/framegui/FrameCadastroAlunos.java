package br.senai.sp.jandira.framegui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;

import br.senai.sp.jandira.model.Aluno;
import br.senai.sp.jandira.model.Periodos;
import br.senai.sp.jandira.repository.AlunosRepository;

public class FrameCadastroAlunos extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private int posicao = 0;

	public FrameCadastroAlunos() {

		String dias[] = { "domingo", "segunda", "terca", "quarta", "quinta", "sexta", "sabado" };

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(80, 71, 90, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(80, 40, 90, 20);
		contentPane.add(textField_1);

		JLabel lblnome = new JLabel("Nome");
		lblnome.setBounds(20, 43, 46, 14);
		contentPane.add(lblnome);

		JLabel lblmatricula = new JLabel("Matricula");
		lblmatricula.setBounds(20, 74, 100, 14);
		contentPane.add(lblmatricula);
		
		JButton btnNewButton_1 = new JButton("fala ai");
		btnNewButton_1.setBounds(80, 215, 89, 23);
		contentPane.add(btnNewButton_1);
		contentPane.setVisible(true);

		JLabel lblperiodo = new JLabel("Periodo");
		lblperiodo.setBounds(20, 114, 46, 14);
		contentPane.add(lblperiodo);

		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.setBounds(40, 164, 166, 33);
		contentPane.add(btnNewButton);

		JComboBox comboBox = new JComboBox();
		/// vectory de lista em arrey
		DefaultComboBoxModel<String> periodomodel = new DefaultComboBoxModel<String>(dias);

		for (Periodos p : Periodos.values()) {
			periodomodel.addElement(p.getdescricao());

		}
		comboBox.setModel(periodomodel);
		comboBox.setBounds(76, 110, 86, 22);
		contentPane.add(comboBox);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(255, 27, 142, 184);
		contentPane.add(scrollPane);
		
		AlunosRepository turma = new AlunosRepository();
	
		
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Aluno aluno = new Aluno();
				aluno.setMatricula(lblmatricula.getText());
				aluno.setNome(lblnome.getText());
			    turma.gravar(aluno, posicao);
				
				posicao++;
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				for(Aluno aluno : turma.listartodos()) {
					System.out.println(aluno.getMatricula());
					System.err.println(aluno.getNome());
					
					
				}
				
			}
		});

		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {};

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		
		scrollPane.setViewportView(list);
		
	
	}
}
