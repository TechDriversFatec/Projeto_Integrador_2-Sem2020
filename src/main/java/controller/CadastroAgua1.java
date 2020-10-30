package controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import application.Main;

public class CadastroAgua1 implements Initializable {
    @FXML
    private TextField txtRGI;
    @FXML
    private TextField txtGR;
    @FXML
    private TextField txtMesReferencia;
    @FXML
    private TextField txtEndereco;
    @FXML
    private TextField txtCEP;
    @FXML
    private TextField txtConsumo;
    @FXML
    private TextField txtNumero;
    @FXML
    private TextField txtCodigoCliente;
    @FXML
    private TextField txtNumeroConta;
    @FXML
    private TextField txtLeituraAntData;
    @FXML
    private TextField txtLeituraAtualData;
    @FXML
    private TextField txtLeituraAntNumero;
    @FXML
    private TextField txtLeituraAtualNumero;
    @FXML
    private TextField txtUf;
    @FXML
    private TextField txtHidrometro;
    @FXML
    private TextField txtTipoLigacao;
    @FXML
    private TextField txtCidade;
    @FXML
    private Button btnRetornarAgua1;
    @FXML
    private Button btnSalvarContinuar;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
    }

    public void changeScreenRetornar(ActionEvent event) {
        Main.changeScreen("tipoconta");
    }

    public void changeScreenContinuar(ActionEvent event) {
            Alert confirmacao = new Alert(AlertType.CONFIRMATION);
        confirmacao.setTitle("Confirmação de Informações");
        confirmacao.setHeaderText(null);
        confirmacao.setContentText("CONFIRMA ESSAS INFORMAÇÕES?");

        Optional<ButtonType> result = confirmacao.showAndWait();
        if (result.get() == ButtonType.OK){
            
            txtRGI.setText("");
            txtGR.setText("");
            txtMesReferencia.setText("");
            txtEndereco.setText("");
            txtCEP.setText("");
            txtConsumo.setText("");
            txtNumero.setText("");
            txtCodigoCliente.setText("");
            txtNumeroConta.setText("");
            txtLeituraAntData.setText("");
            txtLeituraAntNumero.setText("");
            txtLeituraAtualData.setText("");
            txtLeituraAtualNumero.setText("");
            txtUf.setText("");
            txtHidrometro.setText("");
            txtTipoLigacao.setText("");
            txtCidade.setText("");

            Main.changeScreen("agua2");
        } else {
            
        }
    }
}