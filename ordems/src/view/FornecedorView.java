package view;

//Importando os componentes
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;

import controller.FornecedorController;
import model.Fornecedor;
import model.TabelaFornecedor;

//Declarando a classe na janela
public class FornecedorView extends JFrame implements ActionListener{
	//atributos globais da classe
	JPanel painelTitulo;
	JPanel painelCadastro;
	JPanel fornecedorPainel;
	JLabel titulo;
	
	JRadioButton cnpjRadio;
	JRadioButton cpfRadio;
	ButtonGroup tipoGrupo;
	
    JLabel nm_fornecedorLabel;
    JTextField nm_fornecedorField;
    
    JLabel dataNascLabel;
    JTextField dataNascField;
    
    JTextField docField;
    
    JLabel rgieLabel;
    JTextField rgieField;

    JLabel celularLabel;
    JTextField celularField;
    
    JLabel fone_reLabel;
    JTextField fone_reField;
        
    JLabel emailLabel;
    JTextField emailField;
    
    JLabel pes_contatoLabel;
    JTextField pes_contatoField;
    
    JLabel cepLabel;
    JTextField cepField;
    
    JLabel enderecoLabel;
    JTextField enderecoField;
    
    JLabel numeroLabel;
    JTextField numeroField;
    
    JLabel complementoLabel;
    JTextField complementoField;
    
    JLabel bairroLabel;
    JTextField bairroField;
    
    JLabel cidadeLabel;
    JTextField cidadeField;
    
    JLabel estadoLabel;
    JTextField estadoField;
    
    
    //Inicia o painel dos botoes
    JPanel painelBotoes;
    JButton botaoSalvar;
    JButton botaoCancelar;
    JButton botaoEditar;
    JButton botaoExcluir;
    
    private JTable fornecedorTable;
    TabelaFornecedor tabelaFornecedor;
	private int id;

	public FornecedorView() { // construtor da view Fornecedor.
        super("Cadastro de Fornecedor");
        setType(Type.UTILITY);
                
        criaFormulario();
    	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	this.setSize(680, 600);
    	this.setVisible(true);
    	this.setLocationRelativeTo(null);
    }
    
    private void criaFormulario() {
        
        getContentPane().setLayout(new BorderLayout());
        
        //Inicia o painel de t�tulo    
        painelTitulo = new JPanel();
        painelTitulo.setLayout(new FlowLayout());
        
        titulo = new JLabel("Cadastro de Fornecedor");
        titulo.setFont(new Font("Arial", Font.BOLD, 14));
        
        painelTitulo.add(titulo);
        
        //Inicia o painel dos campos digit�veis        
        painelCadastro = new JPanel();
        
        //Inicia o painel dos botoes
        painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout());
        
        botaoSalvar = new JButton("Salvar");
        botaoEditar = new JButton("Editar");
        botaoExcluir = new JButton("Excluir");
        botaoCancelar = new JButton("Cancelar");
        
        getContentPane().add(painelCadastro, BorderLayout.WEST);
        
        JPanel fornecedorPainel = new JPanel();
        fornecedorPainel.setBorder(new LineBorder(Color.LIGHT_GRAY));
        fornecedorPainel.setLayout(null);
        
        pes_contatoField = new JTextField(20);
        pes_contatoField.setBounds(447, 137, 186, 20);
        fornecedorPainel.add(pes_contatoField);        
        pes_contatoLabel = new JLabel("Pessoa de Contato");
        pes_contatoLabel.setBounds(447, 125, 166, 14);
        fornecedorPainel.add(pes_contatoLabel);
        
        emailField = new JTextField(40);
        emailField.setBounds(10, 138, 427, 20);
        fornecedorPainel.add(emailField);        
        emailLabel = new JLabel("Email");
        emailLabel.setBounds(10, 126, 368, 14);
        fornecedorPainel.add(emailLabel);
        
        cpfRadio = new JRadioButton("CPF");
        cpfRadio.setSelected(true);
        cpfRadio.setHorizontalAlignment(SwingConstants.RIGHT);
        cpfRadio.setBounds(6, 7, 50, 23);
        fornecedorPainel.add(cpfRadio);        
        cnpjRadio = new JRadioButton("CNPJ");
        cnpjRadio.setHorizontalAlignment(SwingConstants.RIGHT);
        cnpjRadio.setBounds(58, 7, 56, 23);
        fornecedorPainel.add(cnpjRadio);
        tipoGrupo = new ButtonGroup();
        
        tipoGrupo.add(cpfRadio);
        tipoGrupo.add(cnpjRadio);
        
        
        docField = new JTextField(20);
        docField.setBounds(114, 8, 199, 20);
        fornecedorPainel.add(docField);
        
        rgieLabel = new JLabel("RG/IE");
        rgieLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        rgieLabel.setBounds(323, 10, 50, 14);
        fornecedorPainel.add(rgieLabel);
        rgieField = new JTextField(20);
        rgieField.setBounds(373, 7, 186, 20);
        fornecedorPainel.add(rgieField);
        
        nm_fornecedorLabel = new JLabel("Nome");
        nm_fornecedorLabel.setBounds(10, 37, 338, 14);
        fornecedorPainel.add(nm_fornecedorLabel);
        nm_fornecedorField = new JTextField(40);
        nm_fornecedorField.setBounds(10, 51, 427, 20);
        fornecedorPainel.add(nm_fornecedorField);
        
        dataNascField = new JTextField(20);
        dataNascField.setBounds(447, 50, 186, 20);
        fornecedorPainel.add(dataNascField);        
        dataNascLabel = new JLabel("Data Nascimento");
        dataNascLabel.setBounds(447, 35, 156, 14);
        fornecedorPainel.add(dataNascLabel);
               
        fone_reField = new JTextField(20);
        fone_reField.setBounds(10, 95, 186, 20);
        fornecedorPainel.add(fone_reField);        
        JLabel fone_reLabel = new JLabel("Fone Fixo");
        fone_reLabel.setBounds(10, 82, 166, 14);
        fornecedorPainel.add(fone_reLabel);
        
        celularField = new JTextField(20);
        celularField.setBounds(206, 95, 186, 20);
        fornecedorPainel.add(celularField);        
        celularLabel = new JLabel("Celular");
        celularLabel.setBounds(206, 82, 162, 14);
        fornecedorPainel.add(celularLabel);
        
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
        panel.setLayout(null); 
        
        cepField = new JTextField(10);
        cepField.setBounds(10, 25, 155, 20);
        panel.add(cepField);        
        cepLabel = new JLabel("CEP");
        cepLabel.setBounds(10, 11, 86, 14);
        panel.add(cepLabel);
        
        enderecoField = new JTextField(40);
        enderecoField.setBounds(175, 25, 369, 20);
        panel.add(enderecoField);        
        enderecoLabel = new JLabel("Endere�o");
        enderecoLabel.setBounds(175, 11, 369, 14);
        panel.add(enderecoLabel);
        
        numeroField = new JTextField(10);
        numeroField.setBounds(554, 25, 79, 20);
        panel.add(numeroField);        
        numeroLabel = new JLabel("N�mero");
        numeroLabel.setBounds(554, 11, 65, 14);
        panel.add(numeroLabel);
        
        complementoField = new JTextField(20);
        complementoField.setBounds(10, 69, 155, 20);
        panel.add(complementoField);        
        complementoLabel = new JLabel("Complemento");
        complementoLabel.setBounds(10, 56, 127, 14);
        panel.add(complementoLabel);
        
        bairroField = new JTextField(20);
        bairroField.setBounds(175, 69, 180, 20);
        panel.add(bairroField);               
        bairroLabel = new JLabel("Bairro");
        bairroLabel.setBounds(175, 56, 166, 14);
        panel.add(bairroLabel);
        
        cidadeField = new JTextField(20);
        cidadeField.setBounds(365, 69, 179, 20);
        panel.add(cidadeField);        
        cidadeLabel = new JLabel("Cidade");
        cidadeLabel.setBounds(365, 56, 166, 14);
        panel.add(cidadeLabel);
        
        estadoLabel = new JLabel("Estado");
        estadoLabel.setBounds(554, 56, 65, 14);
        panel.add(estadoLabel);
        estadoField = new JTextField(10);
        estadoField.setBounds(554, 69, 79, 20);
        panel.add(estadoField);
        
        //Criando a Tabela com os dados do banco
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportBorder(new LineBorder(Color.LIGHT_GRAY));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        GroupLayout gl_painelCadastro = new GroupLayout(painelCadastro);
        gl_painelCadastro.setHorizontalGroup(
        	gl_painelCadastro.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, gl_painelCadastro.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_painelCadastro.createParallelGroup(Alignment.LEADING)
        				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
        				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
        				.addComponent(fornecedorPainel, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 643, GroupLayout.PREFERRED_SIZE))
        			.addGap(18))
        );
        gl_painelCadastro.setVerticalGroup(
        	gl_painelCadastro.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, gl_painelCadastro.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(fornecedorPainel, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
        			.addContainerGap())
        );

        
        tabelaFornecedor = new TabelaFornecedor();
        fornecedorTable = new JTable(tabelaFornecedor);
        
             
        scrollPane.setViewportView(fornecedorTable);
        
        painelCadastro.setLayout(gl_painelCadastro);
        
        getContentPane().add(painelBotoes, BorderLayout.SOUTH);
        
        painelBotoes.add(botaoSalvar);        
        painelBotoes.add(botaoEditar);
        painelBotoes.add(botaoExcluir);
        painelBotoes.add(botaoCancelar);
		        
        botaoSalvar.addActionListener(this);
        botaoSalvar.setActionCommand("salvar");
		
        botaoEditar.addActionListener(this);
        botaoEditar.setActionCommand("editar");
		
        botaoExcluir.addActionListener(this);
        botaoExcluir.setActionCommand("excluir");
		
        botaoCancelar.addActionListener(this);
        botaoCancelar.setActionCommand("cancelar");

    }
    
    //m�todo para limpar tela
    private void limpaCampos() {

		nm_fornecedorField.setText("");
		docField.setText("");
		rgieField.setText("");
		fone_reField.setText("");			
		celularField.setText("");
		emailField.setText("");
		pes_contatoField.setText("");
		cepField.setText("");
		enderecoField.setText("");
		numeroField.setText("");
		complementoField.setText("");
		bairroField.setText("");
		cidadeField.setText("");
		estadoField.setText("");
    	
		this.painelCadastro.repaint();
		this.fornecedorPainel.repaint();
    }
   
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equalsIgnoreCase("salvar")) {
			
			Fornecedor f = new Fornecedor();
			
			//Tratar a a��o de salvar o cliente
			
			//Trata o radio do tipo de cliente
			if(cpfRadio.isSelected()) {
				f.setTipo(0);
			}
			else {
				f.setTipo(1);
			}
			//Tipo
			System.out.println("Tipo: " +f.getTipo());
			//nome
			f.setNm_fornecedor(nm_fornecedorField.getText());			
			//documento
			f.setDoc_num(docField.getText());			
			//RGIE
			f.setRg_ie(rgieField.getText());
			//fone fixo
			f.setFone_re(fone_reField.getText());
			//celular
			f.setCelular(celularField.getText());
			//email
			f.setEmail(emailField.getText());
			//pessoa contato
			f.setPes_contato(pes_contatoField.getText());
			//Logradouro
			f.getEndereco().setCep(cepField.getText());
			//Logradouro
			f.getEndereco().setLogradouro(enderecoField.getText());
			//numero
			f.getEndereco().setNumero(numeroField.getText());
			//complemento
			f.getEndereco().setComplemento(complementoField.getText());
			//bairro
			f.getEndereco().setBairro(bairroField.getText());
			//cidade
			f.getEndereco().setCidade(cidadeField.getText());
			//estado
			f.getEndereco().setEstado(estadoField.getText());
			
			Object[] opcoes = {"Salvar como novo cadastro", "Atualizar", "Limpar todos campos"};
	
			
			int op = JOptionPane.showOptionDialog(null, "Escolha uma op��o para continuar", "Aviso",
			          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
			              null, opcoes, opcoes[0]);
				
				if(op == 0) { //salvar um novo cliente
					FornecedorController controleCliente = new FornecedorController();
					try {
						if(controleCliente.cadastrarFornecedor(f) == true) {
							JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
							tabelaFornecedor.addTodos();
							limpaCampos();
							this.repaint();
						}
						}
					 catch (SQLException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Ops, houve um erro ao efetuar o cadastro!");
					}
				}
				else if(op == 1) { //ATUALIZAR O CLIENTE
					f.setId(this.id);
					FornecedorController controleFornecedor = new FornecedorController();
					try {
						if(controleFornecedor.atualizarFornecedor(f) == true) {
							JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
							tabelaFornecedor.addTodos();
							limpaCampos();
							this.repaint();
						}
					} catch (HeadlessException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Ops, houve um ao efetuar o cadastro!");
					}				
					
				}
				else {
					cpfRadio.setEnabled(true);
					
					
					nm_fornecedorField.setText("");
					docField.setText("");
					rgieField.setText("");
					fone_reField.setText("");			
					celularField.setText("");
					emailField.setText("");
					pes_contatoField.setText("");
					cepField.setText("");
					enderecoField.setText("");
					numeroField.setText("");
					complementoField.setText("");
					bairroField.setText("");
					cidadeField.setText("");
					estadoField.setText("");
					
				}
		
		}
		else if (e.getActionCommand().equalsIgnoreCase("cancelar")) {
		
				dispose();
		}
		else if(e.getActionCommand().equals("excluir")) {
			//tratar a exclus�o
			int linha = fornecedorTable.getSelectedRow();
			Fornecedor f = tabelaFornecedor.getFornecedor(linha);
			
			FornecedorController controleFornecedor = new FornecedorController();
			try {
				controleFornecedor.removerFornecedor(f.getId());
				JOptionPane.showMessageDialog(null, " Cadastro exclu�do com sucesso!");
				tabelaFornecedor.addTodos();
				this.repaint();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro ao efetuar a exclus�o");
			}
			
			
		}
		else if(e.getActionCommand().equals("editar")) {
			JOptionPane.showMessageDialog(null, "Deseja realmente editar o cadastro?");
			int linha = fornecedorTable.getSelectedRow();
			Fornecedor f = tabelaFornecedor.getFornecedor(linha);
			
			//preencher os campos com os dados do cliente selecionado
			if(f.getTipo() == 0) cpfRadio.setEnabled(true);
			else cnpjRadio.setEnabled(true);
			
			this.id =f.getId(); 
			nm_fornecedorField.setText(f.getNm_fornecedor());
			docField.setText(f.getDoc_num());
			rgieField.setText(f.getRg_ie());
			fone_reField.setText(f.getFone_re());			
			celularField.setText(f.getCelular());
			emailField.setText(f.getEmail());
			pes_contatoField.setText(f.getPes_contato());
			cepField.setText(f.getEndereco().getCep());
			enderecoField.setText(f.getEndereco().getLogradouro());
			numeroField.setText(f.getEndereco().getNumero());
			complementoField.setText(f.getEndereco().getComplemento());
			bairroField.setText(f.getEndereco().getBairro());
			cidadeField.setText(f.getEndereco().getCidade());
			estadoField.setText(f.getEndereco().getEstado());
			
			
		
			
		}
			
		}
	}

