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

public class CadastroAgua2 implements Initializable {
    @FXML
    private TextField txtTarifa10agua;
    @FXML
    private TextField txtTarifa20agua;
    @FXML
    private TextField txtTarifa30agua;
    @FXML
    private TextField txtTarifa50agua;
    @FXML
    private TextField txtTarifaMais50agua;
    @FXML
    private TextField txtValorAgua1;
    @FXML
    private TextField txtValorAgua2;
    @FXML
    private TextField txtTarifa10esgoto;
    @FXML
    private TextField txtTarifa20esgoto;
    @FXML
    private TextField txtTarifa30esgoto;
    @FXML
    private TextField txtTarifa50esgoto;
    @FXML
    private TextField txtTarifaMais50esgoto;
    @FXML
    private TextField txtValorEsgoto1;
    @FXML
    private TextField txtValorEsgoto2;
    @FXML
    private TextField txtVencimento;
    @FXML
    private TextField txtTotalAgua;
    @FXML
    private TextField txtTotalEsgoto;
    @FXML
    private TextField txtTaxaRegulacao;
    @FXML
    private TextField txtMulta;
    @FXML
    private Button btnSalvarVoltarTelaInicial;
    @FXML
    private Button btnRetornarAgua2;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
    }

    public void changeScreenRetornar(ActionEvent event) {
        Main.changeScreen("agua1");
    }

    public void changeScreenVoltarTelaInicial(ActionEvent event) {
        Alert confirmacao = new Alert(AlertType.CONFIRMATION);
        confirmacao.setTitle("Confirmação de Cadastro");
        confirmacao.setHeaderText(null);
        confirmacao.setContentText("DESEJA ADICIONAR UM CADASTRO?");

        Optional<ButtonType> result = confirmacao.showAndWait();
        if (result.get() == ButtonType.OK){
            Main.changeScreen("main");

            Alert Alert = new Alert(AlertType.INFORMATION);
            Alert.setTitle("Confirmação de Cadastro");
            Alert.setHeaderText(null);
            Alert.setContentText("CADASTRO EFETUADO COM SUCESSO!");
            Alert.showAndWait();
        } else {
            
        }
    }
}