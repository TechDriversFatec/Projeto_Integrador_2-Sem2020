package controller;

import dao.EnergiaDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import classes.Energia;

public class RelatorioEnergia implements Initializable {
    @FXML
    private TableView <Energia> TableAgua;
    @FXML
    private TableColumn <Energia, BigInteger> ClnNumInstalacao;
    @FXML
    private TableColumn <Energia, String> ClnMesReferencia;
    @FXML
    private TableColumn <Energia, BigInteger> ClnConsumo;
    @FXML
    private TableColumn <Energia, BigInteger> ClnNMedidor;
    @FXML
    private TableColumn <Energia, String> ClnBandeira;
    @FXML
    private TableColumn <Energia, String> ClnTensaoNominal;
    @FXML
    private TableColumn <Energia, BigDecimal> ClnValorTotal;


    private List<Energia> listEnergia;
    private ObservableList<Energia> observableListEnergia;
   
    
    @Override
    public void initialize(URL url, ResourceBundle resources) {
        
        carregarTableViewEnergia();
    }

    public void carregarTableViewEnergia(){
        ClnNumInstalacao.setCellValueFactory(new PropertyValueFactory<>("int_numero_instalacao"));
        ClnMesReferencia.setCellValueFactory(new PropertyValueFactory<>("cta_mes_referencia"));
        ClnConsumo.setCellValueFactory(new PropertyValueFactory<>("ene_consumo_conta_mes"));
        ClnNMedidor.setCellValueFactory(new PropertyValueFactory<>("ene_numero_medidor"));
        ClnBandeira.setCellValueFactory(new PropertyValueFactory<>("ene_tipo_bandeira"));
        ClnTensaoNominal.setCellValueFactory(new PropertyValueFactory<>("ene_tensao_nominal"));
        ClnValorTotal.setCellValueFactory(new PropertyValueFactory<>("ene_valor_total"));

        listEnergia =  EnergiaDAO.read();
        observableListEnergia = FXCollections.observableArrayList(listEnergia);
        TableAgua.setItems(observableListEnergia);
    }
}