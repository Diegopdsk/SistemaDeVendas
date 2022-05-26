package ManagedBean;


import DAO.EstoqueDao;
import Entidades.Produto;
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


@Named(value = "estoqueBean")
@ViewScoped
public class EstoqueBean implements Serializable{
    
    EstoqueDao estoqueDao = new EstoqueDao();
    Produto produto = new Produto();
    List<Produto> produtos;
    
    
    /* Construtor */
    public EstoqueBean() {
      produtos = null;
    }
    
   @PostConstruct
    public void init(){
        
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
        
        atualizarComponente("form");
        
       
        
    }
    
    public void buscar(){
        try {
            estoqueDao.buscar(produto);
        } catch (Exception e) {
            addMessage(e.getMessage());
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

    public EstoqueDao getEstoqueDao() {
        return estoqueDao;
    }

    public void setEstoqueDao(EstoqueDao estoqueDao) {
        this.estoqueDao = estoqueDao;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
    
    

    

    

   
    
    
}
