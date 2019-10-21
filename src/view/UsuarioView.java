package view;

//Importando os componentes
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
//Declarando a classe na janela
public class UsuarioView extends JFrame implements ActionListener{
	//atributos globais da classe
		JPanel painelTitulo;
		JPanel painelCadastro;
		JLabel titulo;
	    JLabel usuarioLabel;
	    JTextField usuarioField;
	    JLabel cargoLabel;
	    JTextField cargoField;
	    JLabel deptoLabel;
	    JTextField deptoField;
	    JLabel matriculaLabel;
	    JTextField matriculaField;
	    JLabel loginLabel;
	    JTextField loginField;
	    JLabel senhaLabel;
	    JTextField senhaField;
	    
	  //Inicia o painel dos botoes
	    JPanel painelBotoes;
	    JButton botaoSalvar;
	    JButton botaoCancelar;

	    public UsuarioView() { // construtor da view Usuario.
			super("Cadastro de usu�rio");
			
		                
		        criaFormulario();
		    	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    	this.setSize(580, 600);
		    	this.setVisible(true);
		    	this.setLocationRelativeTo(null);
  
	
 
      
  }
  
  private void criaFormulario() {
      
      setLayout(new BorderLayout());
      
//Inicia o painel de t�tulo        
      painelTitulo = new JPanel();
      painelTitulo.setLayout(new FlowLayout());
      
      titulo = new JLabel("Cadastro de Usu�rio");
      titulo.setFont(new Font("Arial", Font.BOLD, 14));
      
      painelTitulo.add(titulo);
      
//Inicia o painel dos campos digit�veis        
      JPanel painelCadastro = new JPanel();
      painelCadastro.setLayout(new FlowLayout());
      
                  
      painelCadastro = new JPanel();
      painelCadastro.setLayout(new FlowLayout());
      
      usuarioLabel = new JLabel("Nome do Usu�rio");
      usuarioField = new JTextField(40);
      painelCadastro.add(usuarioLabel);
      painelCadastro.add(usuarioField);
      
      cargoLabel = new JLabel("Cargo");
      cargoField = new JTextField(20);
      painelCadastro.add(cargoLabel);
      painelCadastro.add(cargoField);
      
      deptoLabel = new JLabel("Departamento");
      deptoField = new JTextField(20);
      painelCadastro.add(deptoLabel);
      painelCadastro.add(deptoField);
      
      matriculaLabel = new JLabel("Matr�cula");
      matriculaField = new JTextField(20);
      painelCadastro.add(matriculaLabel);
      painelCadastro.add(matriculaField);
      
      loginLabel = new JLabel("Login");
      loginField = new JTextField(10);
      painelCadastro.add(loginLabel);
      painelCadastro.add(loginField);
      
      senhaLabel = new JLabel("Senha");
      senhaField = new JTextField(10);
      painelCadastro.add(senhaLabel);
      painelCadastro.add(senhaField);
      
      
      
                  
      
//Inicia o painel dos botoes
      painelBotoes = new JPanel();
      painelBotoes.setLayout(new FlowLayout());
      
      botaoSalvar = new JButton("Salvar");
      botaoCancelar = new JButton("Cancelar");
      
      painelBotoes.add(botaoSalvar);
      painelBotoes.add(botaoCancelar);
      
      botaoSalvar.addActionListener(this);
      botaoSalvar.setActionCommand("salvar");
      botaoCancelar.addActionListener(this);
      botaoCancelar.setActionCommand("cancelar");
      
      add(painelTitulo, BorderLayout.NORTH);
      add(painelCadastro, BorderLayout.CENTER);
      add(painelBotoes, BorderLayout.SOUTH);
  }
/*
			@Override
			public void actionPerformed1(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equalsIgnoreCase("salvar")) {
					Usuario u = new Usuario();
					System.out.println("cliquei no botao salvar");
					//usuario
					u.setUsuario(usuarioField.getText());
					
					//cargo
					u.setCargo(cargField.getText());
					
					//departamento
					u.setDepartamento(dpField.getText());
					
					//matricula
					u.setMatricula( MatriculaField.getText());
					
					//login
					u.setLogin( loginField.getText());
				
					//senha
					u.setSenha( senhaField.getText());
					
      
      UsuarioController controleUsuario = new UsuarioController();
		try {
			if(controleUsuario.cadastrarUsuario(u) == true) {
				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao realizar cadastro!");
		}
	}
	else if(e.getActionCommand().equalsIgnoreCase("Cancelar")) {
		//tratar a a��o de cancelar 
			}
      	


	
}
  

*/	

}
	




