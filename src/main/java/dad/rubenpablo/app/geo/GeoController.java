package dad.rubenpablo.app.geo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;

import dad.rubenpablo.app.AlertGen;
import dad.rubenpablo.app.App;
import dad.rubenpablo.app.geo.conn.ConnectionController;
import dad.rubenpablo.app.geo.loc.LocationController;
import dad.rubenpablo.app.geo.sec.SecurityController;
import dad.rubenpablo.app.ipapi.mapeo.PapiMessage;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class GeoController implements Initializable{

	private GeoModel model = new GeoModel();
	
    @FXML
    private Button checkButton;

    @FXML
    private BorderPane connectionPane;

    @FXML
    private Tab connectionTab;

    @FXML
    private TextField ipText;

    @FXML
    private BorderPane locationPane;

    @FXML
    private Tab locationTab;

    @FXML
    private BorderPane securityPane;

    @FXML
    private Tab securityTab;

    @FXML
    private TabPane tabPane;

    @FXML
    private VBox view;
    
    private LocationController locaController = new LocationController();
    private ConnectionController conController = new ConnectionController();
    private SecurityController secController = new SecurityController();
    
    public GeoController() throws IOException {
    	FXMLLoader loader = new	FXMLLoader(getClass().getResource("/fxml/GeoMain.fxml"));
    	loader.setController(this);
    	loader.load();
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		model.ipProperty().bind(ipText.textProperty());
		locaController.getModel().refProperty().bind(model.ipInfoProperty());
		setLocalIp();
		
		locationPane.setTop(locaController.getView());
		connectionPane.setTop(conController.getView());
		securityPane.setTop(secController.getView());
		
	}
	

	private void setLocalIp() {
		Task<String> getIP = new Task<String>() {
			
			@Override
			protected String call() throws Exception {
				
				return App.getIpify().obtainIP();
			}
		};
		
		getIP.setOnSucceeded(e -> {
			try {
				ipText.setText(getIP.get());
				onCheckIPAction(null);
				
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ExecutionException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		getIP.setOnFailed(e -> {
			AlertGen error = new AlertGen(AlertType.ERROR, "Error de obtención de IP", "No se pudo obtener la IP pública de la red local. Detalles: " + e.getSource().getException().getMessage());
			error.getAlert().showAndWait();
		});
		
		new Thread(getIP).start();
		
	}
    
	/** Comprobación de IP a través de un método que lanza una tarea en segundo plano **/
    @FXML
    void onCheckIPAction(ActionEvent event) {
    	Task<PapiMessage> checkIP = new Task<PapiMessage>() {
			
			@Override
			protected PapiMessage call() throws Exception {
				return App.getIpapi().obtainRequest(model.getIp());
			}
		};
		
		checkIP.setOnSucceeded(e -> {
			try {
				PapiMessage ret = checkIP.get();
				model.setIpInfo(ret);
				locationModelChange();
				connectionModelChange();
				securityModelChange();
				System.out.println(ret);
				AlertGen exito = new AlertGen(AlertType.INFORMATION, "Comprobación realizada", "Se obtuvieron los detalles de la IP " + model.getIp());
				exito.getAlert().showAndWait();
			} catch (InterruptedException | ExecutionException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		checkIP.setOnFailed(e -> {
			AlertGen error = new AlertGen(AlertType.ERROR, "Error de comprobación", "Detalles: " + e.getSource().getException().getMessage());
			e.getSource().getException().printStackTrace();
			error.getAlert().showAndWait();
		});
		
		new Thread(checkIP).start();
		
		
    }
    
    private void locationModelChange() {
    	locaController.getModel().setLatitude(model.getIpInfo().getLatitude());
    	locaController.getModel().setLongitude(model.getIpInfo().getLongitude());
    	locaController.getModel().setLocation(model.getIpInfo().getCountryName());
    	locaController.getModel().setCountryFlag(model.getIpInfo().getLocation().getCountryFlag());
    	locaController.getModel().setCity(model.getIpInfo().getCity()+ " ("  +model.getIpInfo().getRegionName()+")");
    	locaController.getModel().setZip(model.getIpInfo().getZip());
    	locaController.getModel().setLang(model.getIpInfo().getLocation().getLanguages().get(0).getName() + " (" + model.getIpInfo().getCountryCode()+ ")");
    	locaController.getModel().setTimeZone(model.getIpInfo().getTimeZone().getCode());
    	locaController.getModel().setCallingCode(model.getIpInfo().getLocation().getCallingCode());
    	locaController.getModel().setCurrency(model.getIpInfo().getCurrency().getName() + " (" + model.getIpInfo().getCurrency().getSymbol()+")");
    	locaController.getModel().setFlagImage(new Image(getClass().getResourceAsStream("/imgs/flags/64x42/"+model.getIpInfo().getCountryCode()+".png")));
    }
    
    private void connectionModelChange() {
    	conController.getModel().setIpAddress(model.getIpInfo().getIp());
    	conController.getModel().setAsn(model.getIpInfo().getConnection().getAsn());
    	conController.getModel().setIsp(model.getIpInfo().getConnection().getIsp());
    	conController.getModel().setHostname(model.getIpInfo().getHostname());
    	conController.getModel().setType(model.getIpInfo().getType());
    	
    }
    
    private void securityModelChange() {
    	secController.getModel().setCrawler(model.getIpInfo().getSecurity().getIsCrawler());
    	secController.getModel().setProxy(model.getIpInfo().getSecurity().getIsProxy());
    	secController.getModel().setTor(model.getIpInfo().getSecurity().getIsTor());
    	secController.getModel().setThreatLevel(model.getIpInfo().getSecurity().getThreatLevel());
    	switch (model.getIpInfo().getSecurity().getThreatLevel()) {
		case "low":
			secController.getModel().setIconText("This IP is safe. No threats have been detected.");
			secController.getModel().setPotentialThreat("No threats have been detected for this IP address.");
			break;
		
		case "high":
			secController.getModel().setIconText("Definitive threats detected. This IP is unsafe.");
			secController.getModel().setPotentialThreat(model.getIpInfo().getSecurity().getThreatTypes().toString());
			break;
		default:
			break;
		}
    }
    
    public VBox getView() {
		return view;
	}

    public GeoModel getModel() {
		return model;
	}


}
