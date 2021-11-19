package br.senai.sp.jandira.framegui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;

import br.senai.sp.jandira.model.Aluno;
import br.senai.sp.jandira.model.Periodos;
import br.senai.sp.jandira.repository.AlunosRepository;

public class FrameCadastroAlunos extends JFrame {

	private JPanel contentPane;
	private JTextField txtmatricula;
	private JTextField textnome;
	private int posicao = 0;

	public FrameCadastroAlunos() {

		String dias[] = { "domingo", "segunda", "terca", "quarta", "quinta", "sexta", "sabado" };

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtmatricula = new JTextField();
		txtmatricula.setBounds(80, 71, 90, 20);
		contentPane.add(txtmatricula);
		txtmatricula.setColumns(10);

		textnome = new JTextField();
		textnome.setColumns(10);
		textnome.setBounds(80, 40, 90, 20);
		contentPane.add(textnome);

		
	   
		JLabel lblnome = new JLabel("Nome");
		lblnome.setBounds(20, 43, 46, 14);
		contentPane.add(lblnome);

		JLabel lblmatricula = new JLabel("Matricula");
		lblmatricula.setBounds(20, 74, 100, 14);
		contentPane.add(lblmatricula);

		JButton btnNewButton_1 = new JButton("Exebir");
		btnNewButton_1.setBounds(80, 215, 89, 23);
		contentPane.add(btnNewButton_1);
		contentPane.setVisible(true);

		JLabel lblperiodo = new JLabel("Periodo");
		lblperiodo.setBounds(20, 114, 46, 14);
		contentPane.add(lblperiodo);

		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.setBounds(40, 164, 166, 33);
		contentPane.add(btnNewButton);

		JComboBox comboBoxperiodo = new JComboBox();
		/// vectory de lista em arrey
		DefaultComboBoxModel<String> periodomodel = new DefaultComboBoxModel<String>();

		for (Periodos p : Periodos.values()) {
			periodomodel.addElement(p.getdescricao());

		}
		comboBoxperiodo.setModel(periodomodel);
		comboBoxperiodo.setBounds(76, 110, 86, 22);
		contentPane.add(comboBoxperiodo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(269, 40, 135, 182);
		contentPane.add(scrollPane);
		
		JList listmodel = new JList(); 
		DefaultListModel<String> ListModel = new DefaultListModel<String>();
		listmodel.setModel(ListModel);

		scrollPane.setViewportView(listmodel);

		AlunosRepository turma = new AlunosRepository();

		btnNewButton.addActionListener(new ActionListener() {

			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Aluno aluno = new Aluno();
				aluno.setMatricula(txtmatricula.getText());
				aluno.setNome(textnome.getText());
				aluno.setPeriodo(obterperiodo(comboBoxperiodo.getSelectedIndex()));

				ListModel.addElement(aluno.getNome());
				
				



         if(posicao == turma.gettamanho()) {
        	 btnNewButton.setEnabled(false);
        	 JOptionPane.showMessageDialog(null, "A Turma se Esgoto");
         }
				
				
			}
		});
		
		listmodel.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
		 
				Aluno aluno= turma.listaraluno(listmodel.getSelectedIndex());
				textnome.setText(aluno.getNome());
				txtmatricula.setText(aluno.getMatricula());
				
				 comboBoxperiodo.setSelectedIndex(aluno.getPeriodo().ordinal());
				
				
				
			}
		});
		
		
		
		btnNewButton_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				for (Aluno aluno : turma.listartodos()) {
					System.out.println(aluno.getNome());
					System.out.println(aluno.getMatricula());
					System.out.println(aluno.getPeriodo());
					System.out.println("******************");

				}

			}
		});

	
			
			
			
		

	}

	private Periodos obterperiodo(int periodoselect) {

		// para descobrir o periodod do aluno

		if (periodoselect == 0) {
			return (Periodos.MANHA);
		} else if (periodoselect == 1) {
			return (Periodos.NOITE);
		} else if (periodoselect == 2) {
			return (Periodos.TARDE);
		} else if (periodoselect == 3) {
			return (Periodos.SABADO);
		} else {
			return (Periodos.ONLINE);
		}

	}
}
