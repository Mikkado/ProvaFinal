package Classe;

public class Produto {
    String nome;
    String codigo;
    double valor;
    int qtddEstoque;


    Produto produto;

    //getteres e setteres
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public int getQtddEstoque() {
        return qtddEstoque;
    }
    public void setQtddEstoque(int qtddEstoque) {
        this.qtddEstoque = qtddEstoque;
    }

    public void subtrairEstoque (int subtrairEstoque){
        this.qtddEstoque -= subtrairEstoque; 
    }

    //construtor

    public Produto(String nome, String codigo, double valor, int qtddEstoque) {
        this.nome = nome;
        this.codigo = codigo;
        this.valor = valor;
        this.qtddEstoque = qtddEstoque;
    }

    
    public Produto() {
    }

    // toString

    
    @Override
    public String toString() {
        return "\nProduto:  \nNome: " + nome +  "\nCódigo: " + codigo + " \nQuantidade em Estoque: " + qtddEstoque
                + " \nvalor por unidade: $" + valor + ".\n\n";
    }
}