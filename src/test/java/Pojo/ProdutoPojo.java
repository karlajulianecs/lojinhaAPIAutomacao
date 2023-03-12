package Pojo;

import java.util.List;

public class ProdutoPojo {
    private String produtoNome;
    private double produtoValor;
    private List<String> produtosCores;
    private List<ComponentePojo> componentes;


    public String getProdutoNome() {
        return produtoNome;
    }

    public void setProdutoNome(String produtoNome) {

        this.produtoNome = produtoNome;
    }

    public double getProdutoValor() {
        return produtoValor;
    }

    public void setProdutoValor(double produtoValor) {

        this.produtoValor = produtoValor;
    }

    public List<String> getProdutosCores() {

        return produtosCores;
    }

    public void setProdutosCores(List<String> produtosCores) {

        this.produtosCores = produtosCores;
    }

    public void setProdutoUrlMock(String produtoUrlMock) {
    }

    public List<ComponentePojo> getComponentes() {
        return componentes;
    }

    public void setComponentes(List<ComponentePojo> componentes) {

        this.componentes = componentes;
    }

}
