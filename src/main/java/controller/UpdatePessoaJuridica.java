package controller;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import javafx.scene.control.ComboBox;
import java.util.Optional;
import java.util.ResourceBundle;
import util.TextFieldFormatter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import application.Main;
import classes.Cliente;
import dao.ClienteDAO;


public class UpdatePessoaJuridica implements Initializable {
    
    @FXML
    private TextField txtCNPJEmpresa;
    @FXML
    private TextField txtNomeFantasia;
    @FXML
    private TextField txtEmail;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnRetornarPJ;
    @FXML
    private Button btnBuscarCNPJ;
    @FXML
    private Button btnDeletar;

    @Override
        public void initialize(URL arg0, ResourceBundle arg1) {
            
        }

    public void changeScreenRetornar(ActionEvent event) {
        Main.changeScreen("relatoriocliente");

        txtCNPJEmpresa.setText("");
        txtNomeFantasia.setText("");
        txtEmail.setText("");
        
    }
    public void buscarCNPJ(ActionEvent event) {
         if (ClienteDAO.validacaoCliente(BigInteger.valueOf(Long.parseLong(txtCNPJEmpresa.getText())))){

            ClienteDAO.buscar(BigInteger.valueOf(Long.parseLong(txtCNPJEmpresa.getText())),txtNomeFantasia,txtEmail);     

        } else {
            Alert cadastro = new Alert(Alert.AlertType.INFORMATION);
            cadastro.setTitle("CNPJ não encontrado");
            cadastro.setHeaderText("Digite um numero de CNPJ válido!");
            cadastro.showAndWait();

            txtCNPJEmpresa.setText("");

        }
    }

    public void editarCNPJCliente(ActionEvent event) {
            Alert confirmacao = new Alert(AlertType.CONFIRMATION);
            confirmacao.setTitle("Confirmação de Informações");
            confirmacao.setHeaderText(null);
            confirmacao.setContentText("DESEJA ATUALIZAR O CADASTRO?");

            Optional<ButtonType> result = confirmacao.showAndWait();
            if (result.get() == ButtonType.OK){
                Cliente c = new Cliente();
                ClienteDAO daocli = new ClienteDAO();

                c.setCli_nome(txtNomeFantasia.getText());
                c.setEmail(txtEmail.getText());
                c.setCli_documento(BigInteger.valueOf(Long.parseLong(txtCNPJEmpresa.getText())));
               
                daocli.update(c);
                
                Alert cadastrado = new Alert(Alert.AlertType.INFORMATION);
                cadastrado.setTitle("Dados atualizado com sucesso");
                cadastrado.setHeaderText("Os dados foram atualizados com sucesso");
                cadastrado.showAndWait();

                txtCNPJEmpresa.setText("");
                txtNomeFantasia.setText("");
                txtEmail.setText("");
                
         }else{

         }
    }   

    public void deletarCNPJCliente(ActionEvent event) {
        Alert confirmacao = new Alert(AlertType.CONFIRMATION);
            confirmacao.setTitle("Confirmação de Informações");
            confirmacao.setHeaderText(null);
            confirmacao.setContentText("DESEJA DELETAR ESSES CAMPOS?");

        Optional<ButtonType> result = confirmacao.showAndWait();
         if (result.get() == ButtonType.OK){
            Cliente c = new Cliente();
            ClienteDAO daocli = new ClienteDAO();

            c.setCli_documento(BigInteger.valueOf(Long.parseLong(txtCNPJEmpresa.getText())));
           
            daocli.delete(c);
        
            Alert cadastrado = new Alert(Alert.AlertType.INFORMATION);
                cadastrado.setTitle("Dados deletados com sucesso");
                cadastrado.setHeaderText("Os dados foram deletados com sucesso");
                cadastrado.showAndWait();

                txtCNPJEmpresa.setText("");
                txtCNPJEmpresa.setText("");
                txtEmail.setText("");
            
        }else{

        }

  }
    @FXML
    private void mascaraCNPJCliente(){
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("##.###.###/####-##");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtCNPJEmpresa);
        tff.formatter();
    }
}