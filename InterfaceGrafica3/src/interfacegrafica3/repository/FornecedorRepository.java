/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfacegrafica3.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import interfacegrafica3.model.Fornecedor;
/**
 *
 * @author Guilherme J. Vinhas
 */
public class FornecedorRepository implements Crud<Fornecedor> {
    
    public FornecedorRepository() {
    }

    @Override
    public boolean inserir(Connection connection, Fornecedor fornecedor) {
        PreparedStatement stmt = null;
        try {
            String comando = "INSERT INTO cadastro_fornecedor(nome, endereco, email, telefone, uf, cnpj, inscricao_estadual, nome_fantasia, categoria) " +
                             "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = connection.prepareStatement(comando);
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getEndereco());
            stmt.setString(3, fornecedor.getEmail());
            stmt.setString(4, fornecedor.getTelefone());
            stmt.setInt(5, fornecedor.getUf());
            stmt.setString(6, fornecedor.getCnpj());
            stmt.setString(7, fornecedor.getInscricaoEstadual());
            stmt.setString(8, fornecedor.getNomeFantasia());
            stmt.setString(9, fornecedor.getCategoria());
            stmt.executeUpdate();
            stmt.close();
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao inserir fornecedor: " + ex.getMessage(),
                    "Erro ao inserir",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
    }

    @Override
    public boolean atualizar(Connection connection, Fornecedor fornecedor) {
        PreparedStatement stmt = null;
        System.out.println(fornecedor);
        try {
            String comando = "UPDATE cadastro_fornecedor SET " +
                             "nome = ?, endereco = ?, email = ?, telefone = ?, uf = ?, cnpj = ?, inscricao_estadual = ?, nome_fantasia = ?, categoria = ? " +
                             "WHERE id = ?";
            stmt = connection.prepareStatement(comando);
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getEndereco());
            stmt.setString(3, fornecedor.getEmail());
            stmt.setString(4, fornecedor.getTelefone());
            stmt.setInt(5, fornecedor.getUf());
            stmt.setString(6, fornecedor.getCnpj());
            stmt.setString(7, fornecedor.getInscricaoEstadual());
            stmt.setString(8, fornecedor.getNomeFantasia());
            stmt.setString(9, fornecedor.getCategoria());
            stmt.setInt(10, fornecedor.getId());
            stmt.executeUpdate();
            stmt.close();
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao atualizar fornecedor: " + ex.getMessage(),
                    "Erro ao atualizar",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }        
    }

    @Override
    public boolean deletar(Connection connection, Fornecedor fornecedor) {
        PreparedStatement stmt = null;
        try {
            String comando = "DELETE FROM cadastro_fornecedor " +
                             "WHERE id = ?";
            stmt = connection.prepareStatement(comando);
            stmt.setInt(1, fornecedor.getId());
            stmt.executeUpdate();
            stmt.close();
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao excluir fornecedor: " + ex.getMessage(),
                    "Erro ao excluir",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }        
    }

    @Override
    public Fornecedor selecionar(Connection connection, String operador, int id) {
        try {
            Fornecedor fornecedor = new Fornecedor();
            PreparedStatement stmt = null;
            String comando = "SELECT * FROM cadastro_fornecedor WHERE id " + 
                             operador + " ? ";
            if (operador.equals("<"))
                comando += " ORDER BY id DESC";
            stmt = connection.prepareStatement(comando);
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();
            if (res != null) {
                while (res.next()) {
                    fornecedor.setId(res.getInt("id"));
                    fornecedor.setNome(res.getString("nome"));
                    fornecedor.setEndereco(res.getString("endereco"));
                    fornecedor.setTelefone(res.getString("telefone"));
                    fornecedor.setEmail(res.getString("email"));
                    fornecedor.setUf(res.getInt("uf"));
                    fornecedor.setCnpj(res.getString("cnpj"));
                    fornecedor.setInscricaoEstadual(res.getString("inscricao_estadual"));
                    fornecedor.setNomeFantasia(res.getString("nome_fantasia"));
                    fornecedor.setCategoria(res.getString("categoria"));                    
                    break;
                }
            }
            return fornecedor;
        } catch (Exception ex) {
            return null;
        }
    }
}
