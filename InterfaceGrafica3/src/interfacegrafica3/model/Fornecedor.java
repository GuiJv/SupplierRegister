/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfacegrafica3.model;

/**
 *
 * @author Guilherme J. Vinhas
 */
public class Fornecedor extends Pessoa {
    private int uf; // ID da UF (chave estrangeira)
    private String cnpj;
    private String inscricaoEstadual;
    private String nomeFantasia;
    private String categoria;

    public Fornecedor(String nome, String email, String endereco, String telefone, int id,
                      int uf, String cnpj, String inscricaoEstadual, String nomeFantasia, String categoria) {
        super(nome, email, endereco, telefone, id);
        this.uf = uf;
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
        this.nomeFantasia = nomeFantasia;
        this.categoria = categoria;
    }

    public Fornecedor(){
        
    }
    
    public int getUf() {
        return uf;
    }

    public void setUf(int uf) {
        this.uf = uf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}