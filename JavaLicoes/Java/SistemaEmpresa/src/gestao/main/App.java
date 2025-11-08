package gestao.main;
import javax.swing.SwingUtilities;
import gestao.view.JanelaPrincipal;
import gestao.model.Empresa; 
import gestao.controller.EmpresaController; 


public class App {

    public static void main(String[] args) {
               SwingUtilities.invokeLater(() -> {
            
            Empresa model = new Empresa(); 

            JanelaPrincipal view = new JanelaPrincipal();
            
            EmpresaController controller = new EmpresaController(model, view); 

            view.setVisible(true);  
        });
    }
}