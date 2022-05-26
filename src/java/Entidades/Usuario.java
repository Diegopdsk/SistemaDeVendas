
package Entidades;

import java.util.Objects;


public class Usuario {
    
    private String Matricula;
    private String Nome;
    private String Senha;
    private String permissao;
    
    public Usuario() {
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String Matricula) {
        this.Matricula = Matricula;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.Nome);
        hash = 97 * hash + Objects.hashCode(this.Senha);
        hash = 97 * hash + Objects.hashCode(this.permissao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.Nome, other.Nome)) {
            return false;
        }
        if (!Objects.equals(this.Senha, other.Senha)) {
            return false;
        }
        if (!Objects.equals(this.permissao, other.permissao)) {
            return false;
        }
        return true;
    }
    
    
    
}
