package dao;

import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import controller.ClienteController;
import model.Cliente;
import dao.Conexao;

public class ClienteDAO {
	//metodo inserir
	//metodo consultar
	//deletar 
	//atualizar
	//metodos sempre recebem objeto
	Connection conn = null;
	PreparedStatement st = null;
	
	
	public void inserir(Cliente cliente) throws SQLException {
				
		conn = (Connection) Conexao.getConexao();
		
		if(conn != null) {
			st = (PreparedStatement) conn.prepareStatement(
					"INSERT INTO cliente"
					+ "(usuario_id, nm_cliente, tipo_cliente, doc_num, rg_ie, celular, fone_re, email, pes_contato, cep, endereco, numero, complemento, bairro, cidade, estado) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		}
		
		st.setInt(1, 1006); //mudar aqui para associar o id do usu�rio		
		st.setString(2, cliente.getNome());
		st.setInt(3, cliente.getTipo());
		st.setString(4, cliente.getDocumento());
		st.setString(5, cliente.getRgie());
		st.setString(6, cliente.getTelefonecel());
		st.setString(7, cliente.getTelefoneres());
		st.setString(8, cliente.getEmail());
		st.setString(9, cliente.getPessoa());
		st.setString(10, cliente.getEndereco().getCep());
		st.setString(11, cliente.getEndereco().getLogradouro());
		st.setString(12, cliente.getEndereco().getNumero());
		st.setString(13, cliente.getEndereco().getComplemento());
		st.setString(14, cliente.getEndereco().getBairro());
		st.setString(15, cliente.getEndereco().getCidade());
		st.setString(16, cliente.getEndereco().getEstado());
		
		st.execute();
		
		conn.close();
	//----------------	
		
	}
	
	
	/*public void consultar() throws SQLException {
		
		conn = (Connection) Conexao.getConexao();
		
		if(conn != null) {
			st = (PreparedStatement) conn.prepareStatement(
					"SELECT * FROM cliente");
		}
		

		
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
            Cliente cliente = new Cliente();
            
            
            
            System.out.println(rs.getInt("id_cliente"));
            System.out.println(rs.getString("nm_cliente"));

            cliente.setId(rs.getInt("id_cliente"));
            cliente.setNome(rs.getString("nm_cliente"));
            cliente.setTelefonecel(rs.getString("celular"));
            cliente.setEmail(rs.getString("email"));
            cliente.setDocumento(rs.getString("documento"));
            cliente.getEndereco().set
            cliente.add(cliente);
           
        }
		
		System.out.println("Resultado da consulta" + rs);
		
		conn.close();
	//----------------	
		
	}*/
	
	
	//metodo consultar
	public ArrayList<Cliente> getClientes() {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
        try {
            conn = (Connection) Conexao.getConexao();
            
            if(conn != null) {
    			st = (PreparedStatement) conn.prepareStatement(
    					"SELECT * FROM cliente");
    			
    			rs = st.executeQuery();
                while (rs.next()) {
                    Cliente cliente = new Cliente();
     
                    cliente.setId(rs.getInt("id_cliente"));
                    cliente.setNome(rs.getString("nm_cliente"));
                    cliente.setTelefonecel(rs.getString("celular"));
                    cliente.setEmail(rs.getString("email"));
                    
                    listaClientes.add(cliente);
                }
                Conexao.fechaConexao(conn);
    		}
            else {
            	System.out.println("Conex�o falhou!");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar Cliente" + e.getMessage());
        }
        return listaClientes;
    }
	
	
 
    public Cliente getClienteById(int id_cliente) {
    	Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Cliente cliente = null;
        
        try {
            conn = (Connection) Conexao.getConexao();
            
            if(conn != null) {
    			st = (PreparedStatement) conn.prepareStatement(
    					"SELECT * FROM cliente WHERE id_cliente = ?");
    			st.setInt(1, id_cliente);
    			
    			rs = st.executeQuery();
                while (rs.next()) {
                    cliente = new Cliente();
     
                    //PREENCHER TODOS OS DADOS DO CLIENTE
                    cliente.setId(rs.getInt("id_cliente"));
                    cliente.setNome(rs.getString("nm_cliente"));
                    cliente.setTelefonecel(rs.getString("celular"));
                    cliente.setEmail(rs.getString("email"));
                    
                }
                Conexao.fechaConexao(conn);
    		}
            else {
            	System.out.println("Conex�o falhou!");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar Cliente" + e.getMessage());
        }
        return cliente;
    }
    
    public Cliente getClienteByDocumento(int documento) {
    	Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Cliente cliente = null;
        
        try {
            conn = (Connection) Conexao.getConexao();
            
            if(conn != null) {
    			st = (PreparedStatement) conn.prepareStatement(
    					"SELECT * FROM cliente WHERE documento = ?");
    			st.setInt(1, documento);
    			
    			rs = st.executeQuery();
                while (rs.next()) {
                    cliente = new Cliente();
     
                    
                    //PREENCHER TODOS OS DADOS DO CLIENTE
                    cliente.setId(rs.getInt("id_cliente"));
                    cliente.setNome(rs.getString("nm_cliente"));
                    cliente.setTelefonecel(rs.getString("celular"));
                    cliente.setEmail(rs.getString("email"));
                    
                }
                Conexao.fechaConexao(conn);
    		}
            else {
            	System.out.println("Conex�o falhou!");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar Cliente" + e.getMessage());
        }
        return cliente;
    }
    

}


