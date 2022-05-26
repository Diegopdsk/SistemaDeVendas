package ManagedBean;


import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;


@Named(value = "usuarioBean")
@ViewScoped
public class UsuarioBean implements Serializable{

   
    Map<String,Integer> Usuarios;
    
    
    /* Construtor */
    public UsuarioBean() {
      
    }
    
   @PostConstruct
    public void init(){
        buscar();
        buscarAcoes();
    }
    
    /* Métodos */
    public void  salvar(){
        if(isAcaoRegistrada()==true){ // verifica se a ação, cuja compra será registrada, já está na lista de compras de ações
            addMessage("Infelzimente a ação já está registrada");
            RequestContext.getCurrentInstance().execute("PF('dl_registrar').hide();"); // fechar o dialogo
            return;
        }
        try {
            
        } catch (Exception e) {
            addMessage(e.getMessage());
            RequestContext.getCurrentInstance().execute("PF('dl_registrar').hide();"); // fechar o dialogo
            return;
        }   
        RequestContext.getCurrentInstance().execute("PF('dl_registrar').hide();"); // fechar o dialogo
        addMessage("Compra registrada com sucesso!");// adicionar a mensagem de sucesso do registro
        
        buscar();
        atualizarComponente("form");
        
       
        
    }
    
    public void buscar(){
        try {
            
        } catch (Exception e) {
            addMessage(e.getMessage());
        }
    }
    
    public void buscarAcoes(){
        try {
            
        } catch (Exception ex) {
            addMessage(ex.getMessage());
        }
    }
    
    public void deletar(){
        try{
           
        }catch(Exception e){
            addMessage(e.getMessage());
            return;
        }
        addMessage("Registro de compra removido com sucesso!");
        
        buscar();
        atualizarComponente("form");
    }
    
    public boolean isAcaoRegistrada(){
        return true;
    }
    
    public void onRowEdit(RowEditEvent event){ // invocado ao editar um registro
       
        try {
           
        } catch (Exception e) {
            addMessage(e.getMessage());
            return;
        }
        addMessage("Quantidade de compras alterada com sucesso!");
    }
    
    public void onRowCancel(RowEditEvent event){ // invocado ao cancelar a edição de um registro
        addMessage("Edição cancelada!");
    }
    
     public void addMessage(String msg){
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,msg,null);
        FacesContext.getCurrentInstance().addMessage(null, message);
        atualizarComponente("msg"); // atualiza o componente de mensagens 
    }
    public void atualizarComponente(String id){
         RequestContext.getCurrentInstance().update(id);
    }
    
    /* Getters & Setters */

    public Map<String, Integer> getUsuarios() {
        return Usuarios;
    }

    public void setUsuarios(Map<String, Integer> Usuarios) {
        this.Usuarios = Usuarios;
    }

   
    
    
}
