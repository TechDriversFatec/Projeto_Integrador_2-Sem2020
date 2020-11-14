package controller;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import util.TextFieldFormatter;
import application.Main;
import classes.Energia;
import dao.EnergiaDAO;

public class CadastroEnergia2 implements Initializable {
    @FXML
    private TextField txtContaMes;
    @FXML
    private TextField txtNumeroInstalacao;
    @FXML
    private TextField txtConsumo;
    @FXML
    private TextField txtDataVencimento;
    @FXML
    private TextField txtTotalPagar;
    @FXML
    private TextField txtConstMulti;
    @FXML
    private TextField txtNRmedidor;
    @FXML
    private TextField txtLeituraAnterior;
    @FXML
    private TextField txtLeituraAtual;
    @FXML
    private TextField txtDataLeituraAnterior;
    @FXML
    private TextField txtDataLeituraAtual;
    @FXML
    private ComboBox comboBandeirasTarifarias;
    @FXML
    private Button btnRetornarEnergia;
    @FXML
    private Button btnVoltarTelaIncial;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub

        comboBandeirasTarifarias.getItems().add("Verde");
        comboBandeirasTarifarias.getItems().add("Amarela");
        comboBandeirasTarifarias.getItems().add("Vermelha");
    }

    public void changeScreenRetornar(ActionEvent event) {
        Main.changeScreen("energia1");
    }

    public void changeScreenVoltarTelaInicial(ActionEvent event) {
         if(txtContaMes.getText().equals("") || txtNumeroInstalacao.getText().equals("") || txtDataVencimento.getText().equals("") || txtTotalPagar.getText().equals("") || txtConstMulti.getText().equals("") || txtNRmedidor.getText().equals("") || txtLeituraAnterior.getText().equals("") || txtLeituraAtual.getText().equals("") || txtDataLeituraAnterior.getText().equals("") || txtDataLeituraAtual.getText().equals("") || comboBandeirasTarifarias.getValue().equals("")) {
            
            Alert Alert = new Alert(AlertType.INFORMATION);
            Alert.setTitle("Campos Obrigatórios Vazios");
            Alert.setHeaderText(null);
            Alert.setContentText("PREENCHA OS CAMPOS COM *");
            Alert.showAndWait(); 
        }
        else {
            Alert confirmacao = new Alert(AlertType.CONFIRMATION);
            confirmacao.setTitle("Confirmação de Cadastro");
            confirmacao.setHeaderText(null);
            confirmacao.setContentText("DESEJA ADICIONAR UM CADASTRO?");

            Optional<ButtonType> result = confirmacao.showAndWait();
            if (result.get() == ButtonType.OK){
                String NumeroInstalacao = txtNumeroInstalacao.getText();

                Main.salvarIntalacaoNumero(NumeroInstalacao);
                Main.salvarConta1(NumeroInstalacao, txtContaMes);
                Main.salvarConta2(txtDataVencimento);
                Main.salvarEnergia2(txtContaMes, txtNumeroInstalacao, txtConsumo, txtTotalPagar, txtConstMulti, txtNRmedidor, txtLeituraAnterior, txtLeituraAtual, txtDataLeituraAnterior, txtDataLeituraAtual, comboBandeirasTarifarias);

                
                
                txtContaMes.setText("");
                txtNumeroInstalacao.setText("");
                txtConsumo.setText("");
                txtDataVencimento.setText("");
                txtTotalPagar.setText("");
                txtConstMulti.setText("");
                txtNRmedidor.setText("");
                txtLeituraAnterior.setText("");
                txtLeituraAtual.setText("");
                txtDataLeituraAnterior.setText("");
                txtDataLeituraAtual.setText("");

                Alert Alert = new Alert(AlertType.INFORMATION);
                Alert.setTitle("Confirmação de Cadastro");
                Alert.setHeaderText(null);
                Main.changeScreen("main");
                Alert.setContentText("CADASTRO EFETUADO COM SUCESSO!");
                Alert.showAndWait();
            } else {
            }    
        }
    }

    // Mascaras
    @FXML
    private void mascaraVencimento(){
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("##/##/####");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtDataVencimento);
        tff.formatter();
    }
    @FXML
    private void mascaraDataAnt(){
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("##/##/####");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtDataLeituraAnterior);
        tff.formatter();
    }
    @FXML
    private void mascaraDataAtual(){
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("##/##/####");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtDataLeituraAtual);
        tff.formatter();
    }
}