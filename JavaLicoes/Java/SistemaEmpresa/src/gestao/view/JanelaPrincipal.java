package gestao.view;
import java.awt.BorderLayout;
import java.awt.GridLayout; 
import java.awt.FlowLayout; 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel; 
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane; 
import javax.swing.JTabbedPane; 


public class JanelaPrincipal extends JFrame {

	

	// CLIENTE
	private JTextField emailField;
	private JTextField nomeField;
	private JButton adicionarClientes;

	// FUNCIONARIO
	private JTextField nomeFuncionarioField;
	private JTextField cargoFuncionarioField;
	private JTextField salarioFuncionarioField;
	private JButton adicionarFuncionario;

	// BOTÕES 
	private JButton exibirClientes;
	private JButton exibirFuncionarios;
	private JButton calcularFolhaSalarial;
	private JButton exibirMediaSalarial;

	// SAIDA
	private JTextArea exibirTudo;


	 
	public JanelaPrincipal() {

		setTitle("Sistema de Gestão de Empresa");
		setSize(600, 500); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout()); 
		setLocationRelativeTo(null); 

		JTabbedPane painelDeAbas = new JTabbedPane();
		
		JPanel abaClientes = new JPanel(new GridLayout(3, 2, 5, 5)); 

		nomeField = new JTextField();
		emailField = new JTextField();
		adicionarClientes = new JButton("Adicionar Cliente");

		abaClientes.add(new JLabel("Nome:"));
		abaClientes.add(nomeField);
		abaClientes.add(new JLabel("Email:"));
		abaClientes.add(emailField);
		abaClientes.add(new JLabel()); 
		abaClientes.add(adicionarClientes);

		
		JPanel abaFuncionarios = new JPanel(new GridLayout(4, 2, 5, 5));

		nomeFuncionarioField = new JTextField();
		cargoFuncionarioField = new JTextField();
		salarioFuncionarioField = new JTextField();
		adicionarFuncionario = new JButton("Adicionar Funcionário");

		
		abaFuncionarios.add(new JLabel("Nome:"));
		abaFuncionarios.add(nomeFuncionarioField);
		abaFuncionarios.add(new JLabel("Cargo:"));
		abaFuncionarios.add(cargoFuncionarioField);
		abaFuncionarios.add(new JLabel("Salário:"));
		abaFuncionarios.add(salarioFuncionarioField);
		abaFuncionarios.add(new JLabel()); 
		abaFuncionarios.add(adicionarFuncionario);

	
		JPanel abaAcoes = new JPanel(new FlowLayout()); 


		exibirClientes = new JButton("Exibir Clientes");
		exibirFuncionarios = new JButton("Exibir Funcionários");
		calcularFolhaSalarial = new JButton("Calcular Folha");
		exibirMediaSalarial = new JButton("Exibir Média");

		
		abaAcoes.add(exibirClientes);
		abaAcoes.add(exibirFuncionarios);
		abaAcoes.add(calcularFolhaSalarial);
		abaAcoes.add(exibirMediaSalarial);

		
		painelDeAbas.addTab("Cadastro de Clientes", abaClientes);
		painelDeAbas.addTab("Cadastro de Funcionários", abaFuncionarios);
		painelDeAbas.addTab("Ações e Relatórios", abaAcoes);



		
		add(painelDeAbas, BorderLayout.NORTH);

		exibirTudo = new JTextArea();
		exibirTudo.setEditable(false); 
		JScrollPane scrollPane = new JScrollPane(exibirTudo);

	
		add(scrollPane, BorderLayout.CENTER);
	}


	public String getEmailField() {
		return emailField.getText();
	}

	public String getNomeField() {
		return nomeField.getText();
	}

	public String getNomeFuncionarioField() {
		return nomeFuncionarioField.getText();
	}

	public String getCargoFuncionarioField() {
		return cargoFuncionarioField.getText();
	}

	public String getSalarioFuncionarioField() {
		return salarioFuncionarioField.getText();
	}

	public JButton getAdicionarClientesButton() {
		return adicionarClientes;
	}

	public JButton getAdicionarFuncionarioButton() {
		return adicionarFuncionario;
	}

	public JButton getExibirClientesButton() {
		return exibirClientes;
	}

	public JButton getExibirFuncionariosButton() {
		return exibirFuncionarios;
	}

	public JButton getCalcularFolhaSalarialButton() {
		return calcularFolhaSalarial;
	}

	public JButton getExibirMediaSalarialButton() {
		return exibirMediaSalarial;
	}


	public void setExibirTudo(String texto) {
		exibirTudo.setText(texto);
	}

	
	public void limparCamposCliente() {
		nomeField.setText("");
		emailField.setText("");
	}

	public void limparCamposFuncionario() {
		nomeFuncionarioField.setText("");
		cargoFuncionarioField.setText("");
		salarioFuncionarioField.setText("");
	}
}