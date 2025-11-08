package gestao.model;

public class Empresa {
	
	private Cliente [] clientes;
	private Funcionario [] funcionarios;
	private int numClientes;
	private int numFuncionarios;
	
	public String adicionarClientes(String nome, String email) {
		
		if (this.numClientes < this.clientes.length) {
			
			Cliente novoCliente = new Cliente(nome, email);
			this.clientes[this.numClientes] = novoCliente;
			this.numClientes++;
			
			return "Cliente adicionado com sucesso!";
			
		} else {
			
			return "Erro: Limite de clientes atingido.";
			
		}
	}


	public String exibirClientes() {
	
	if (this.numClientes == 0) {
		return "Nenhum cliente cadastrado.";
	} else {
		
		StringBuilder sb = new StringBuilder();
		sb.append("--- Lista de Clientes ---\n");
		
		for (int i = 0; i < this.numClientes; i++) {
			Cliente c = this.clientes[i];
			sb.append("Nome: " + c.getNome() + ", Email: " + c.getEmail() + "\n");
		}
		
		return sb.toString();
	}
}

	public String adicionarFuncionarios(String nome, String cargo, double salario) {
	
	if (this.numFuncionarios < this.funcionarios.length) {
		
		Funcionario novoFuncionario = new Funcionario(nome, cargo, salario);
		this.funcionarios[this.numFuncionarios] = novoFuncionario;
		this.numFuncionarios++;
		
		return "Funcionario adicionado com sucesso!";
		
	} else {
		
		return "Erro: Limite de Funcionario atingido.";
		
	}
}

	public String exibirFuncionarios() {
	
	if (this.numFuncionarios == 0) {
		return "Nenhum funcionario cadastrado.";
	} else {
		
		StringBuilder sb = new StringBuilder();
		sb.append("--- Lista de Funcionarios ---\n");
		
		for (int i = 0; i < this.numFuncionarios; i++) {
			Funcionario c = this.funcionarios[i];
			sb.append("Nome: " + c.getNome() + ", Cargo: " + c.getCargo() + ", Salário: R$ " + c.getSalario() + "\n");
		}
		
		return sb.toString();
	}
}


	public String calcularFolhaSalarial() {
		
		double totalSalario = 0.0;
		
		for (int i = 0; i < this.numFuncionarios; i++) {
			Funcionario f = this.funcionarios[i];
			totalSalario = totalSalario + f.getSalario();
		}
		
		return "Folha Salarial Total: R$ " + totalSalario;
	}
	
	public String exibirMediaSalarial() {
		
		if (this.numFuncionarios == 0) {
			return "Não é possível calcular: Nenhum funcionário cadastrado.";
		}
		
		double totalSalario = 0.0;
		for (int i = 0; i < this.numFuncionarios; i++) {
			Funcionario f = this.funcionarios[i];
			totalSalario += f.getSalario();
		}
		

		Calculadora calculadora = new Calculadora();
		
		double mediaSalarial = calculadora.dividir(totalSalario, this.numFuncionarios);
		
	
		return String.format("Média Salarial: R$ %.2f", mediaSalarial);
	}
	
	public Empresa () {
		this.clientes = new Cliente [5];
		this.funcionarios = new Funcionario [10];
		
		this.numClientes = 0;
		this.numFuncionarios = 0;
	}
}