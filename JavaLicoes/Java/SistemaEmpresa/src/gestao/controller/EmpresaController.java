package gestao.controller;

import gestao.model.Empresa;
import gestao.view.JanelaPrincipal;

public class EmpresaController {

	private Empresa model;
	private JanelaPrincipal view;

	public EmpresaController(Empresa model, JanelaPrincipal view) {
		this.model = model;
		this.view = view;

		view.getAdicionarClientesButton().addActionListener(e -> adicionarCliente());
		view.getExibirClientesButton().addActionListener(e -> exibirClientes());
		view.getAdicionarFuncionarioButton().addActionListener(e -> adicionarFuncionario());
		view.getExibirFuncionariosButton().addActionListener(e -> exibirFuncionarios());
		view.getCalcularFolhaSalarialButton().addActionListener(e -> calcularFolhaSalarial());
		view.getExibirMediaSalarialButton().addActionListener(e -> exibirMediaSalarial());
	}
    
	private void adicionarCliente() {
        try {
            String nome = view.getNomeField();
            String email = view.getEmailField();

            if (nome.trim().isEmpty() || email.trim().isEmpty()) {
                view.setExibirTudo("Erro: Preencha todos os campos do Cliente.");
                return;
            }

            String resultado = model.adicionarClientes(nome, email);
            view.setExibirTudo(resultado);
            
            if (resultado.contains("sucesso")) {
                view.limparCamposCliente();
            }

        } catch (Exception ex) {
            view.setExibirTudo("Erro inesperado ao adicionar cliente: " + ex.getMessage());
        }
	}

	private void exibirClientes() {
		String lista = model.exibirClientes();
		view.setExibirTudo(lista);
	}
    
	private void adicionarFuncionario() {
        try {
            String nome = view.getNomeFuncionarioField();
            String cargo = view.getCargoFuncionarioField(); 
            String salarioStr = view.getSalarioFuncionarioField();

            if (nome.trim().isEmpty() || cargo.trim().isEmpty() || salarioStr.trim().isEmpty()) {
                view.setExibirTudo("Erro: Preencha todos os campos do Funcionário.");
                return;
            }
            
            double salario = Double.parseDouble(salarioStr);
            
            if (salario < 0) {
                 view.setExibirTudo("Erro: O salario deve ser um valor positivo.");
                 return;
            }

            String resultado = model.adicionarFuncionarios(nome, cargo, salario);

            view.setExibirTudo(resultado);

            if (resultado.contains("sucesso")) {
                view.limparCamposFuncionario();
            }

        } catch (NumberFormatException e) {
            view.setExibirTudo("Erro: O salario deve ser um numero valido (ex: 5000.00).");
        } catch (Exception ex) {
             view.setExibirTudo("Erro inesperado ao adicionar funcionario: " + ex.getMessage());
        }
	}

	private void exibirFuncionarios() {
		String lista = model.exibirFuncionarios();
		view.setExibirTudo(lista);
	}

	private void calcularFolhaSalarial() {
		String resultado = model.calcularFolhaSalarial();
		view.setExibirTudo(resultado);
	}

	private void exibirMediaSalarial() {
		String resultado = model.exibirMediaSalarial();
		view.setExibirTudo(resultado);
	}
}