package Entidades;

public class Produto {

    private Integer codigo;
    private String Descricao;
    private Integer Qtd;
    private String Un;
    private String Categoria;
    private String Fabricante;
    private Double ValorCusto;
    private Double ValorRevenda;

    public Produto() {
    }

    public Produto(Integer codigo, String Descricao, String Un, String Categoria, String Fabricante, Double ValorCusto) {
        this.codigo = codigo;
        this.Descricao = Descricao;
        this.Un = Un;
        this.Categoria = Categoria;
        this.Fabricante = Fabricante;
        this.ValorCusto = ValorCusto;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public Integer getQtd() {
        return Qtd;
    }

    public void setQtd(Integer Qtd) {
        this.Qtd = Qtd;
    }

    public String getUn() {
        return Un;
    }

    public void setUn(String Un) {
        this.Un = Un;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public String getFabricante() {
        return Fabricante;
    }

    public void setFabricante(String Fabricante) {
        this.Fabricante = Fabricante;
    }

    public Double getValorCusto() {
        return ValorCusto;
    }

    public void setValorCusto(Double ValorCusto) {
        this.ValorCusto = ValorCusto;
    }

    public Double getValorRevenda() {
        return ValorRevenda;
    }

    public void setValorRevenda(Double ValorRevenda) {
        this.ValorRevenda = ValorRevenda;
    }
    
    

}
