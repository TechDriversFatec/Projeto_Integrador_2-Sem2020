package controller;

import java.math.BigInteger;
import java.net.URL;
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
import application.Main;
import classes.Endereco;
import dao.EnderecoDAO;

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
    private ComboBox comboUF;
    @FXML
    private TextField txtHidrometro;
    @FXML
    private TextField txtTipoLigacao;
    @FXML
    private TextField txtCidade;
    @FXML
    private TextField txtComplemento;
    @FXML
    private Button btnRetornarAgua1;
    @FXML
    private Button btnSalvarContinuar;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub

        comboUF.getItems().add("AC");
        comboUF.getItems().add("AL");
        comboUF.getItems().add("AP");
        comboUF.getItems().add("AM");
        comboUF.getItems().add("BA");
        comboUF.getItems().add("CE");
        comboUF.getItems().add("ES");
        comboUF.getItems().add("GO");
        comboUF.getItems().add("MA");
        comboUF.getItems().add("MT");
        comboUF.getItems().add("MS");
        comboUF.getItems().add("MG");
        comboUF.getItems().add("PA");
        comboUF.getItems().add("PB");
        comboUF.getItems().add("PR");
        comboUF.getItems().add("PE");
        comboUF.getItems().add("PI");
        comboUF.getItems().add("RJ");
        comboUF.getItems().add("RN");
        comboUF.getItems().add("RS");
        comboUF.getItems().add("RO");
        comboUF.getItems().add("RR");
        comboUF.getItems().add("SC");
        comboUF.getItems().add("SP");
        comboUF.getItems().add("SE");
        comboUF.getItems().add("TO");
        comboUF.getItems().add("DF");
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
            Endereco e = new Endereco();
            EnderecoDAO dao = new EnderecoDAO();
            e.setEnd_cep(BigInteger.valueOf(Long.parseLong(txtCEP.getText())));
            e.setEnd_numero(BigInteger.valueOf(Long.parseLong(txtNumero.getText())));
            e.setEnd_rua(txtEndereco.getText());
            e.setEnd_estado(String.valueOf(comboUF.getValue()));
            e.setEnd_cidade(txtCidade.getText());
            e.setEnd_complemento(txtComplemento.getText());

            dao.create(e);

            Main.salvarIntalacaoEndereco(txtCEP, txtNumero);
            Main.salvarIntalacaoNumero(txtRGI);
            Main.salvarConta1(txtRGI, txtMesReferencia);
            Main.salvarAgua1(txtRGI, txtGR, txtMesReferencia, txtCodigoCliente, txtNumeroConta, txtLeituraAntData, 
            txtLeituraAtualData, txtLeituraAntNumero, txtLeituraAtualNumero, txtHidrometro, txtTipoLigacao);

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
            txtHidrometro.setText("");
            txtTipoLigacao.setText("");
            txtCidade.setText("");
            txtComplemento.setText("");

            Main.changeScreen("agua2");
        } else {
            
        }
    }
}