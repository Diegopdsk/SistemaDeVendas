
package ManagedBean;

import DAO.UsuarioDao;
import Entidades.Usuario;
import java.io.Serializable;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.context.RequestContext;


@Named(value = "logarBean")
@ViewScoped
public class LogarBean implements Serializable{

   Usuario usuario;
    UsuarioDao usuariodao;
  
    public LogarBean() {
        usuario = new Usuario();
        usuariodao = new UsuarioDao();
    }
    
    @PostConstruct
    public void init(){
        
    }
    
    public void addMessage(String msg){
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,msg,null);
        FacesContext.getCurrentInstance().addMessage(null, message);
        atualizarComponente("msg"); // atualiza o componente de mensagens 
    }
    
    public void atualizarComponente(String id){
         RequestContext.getCurrentInstance().update(id);
    }
    
    public void Entrar(){
        try {
            if(usuariodao.logar(usuario)){
                
                System.out.println("Logado");
            }
            
        } catch (Exception e) {
            addMessage(e.getMessage());
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioDao getUsuariodao() {
        return usuariodao;
    }

    public void setUsuariodao(UsuarioDao usuariodao) {
        this.usuariodao = usuariodao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.usuario);
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
        final LogarBean other = (LogarBean) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
