package dad.rubenpablo.app.geo.conn;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class ConnectionController implements Initializable {

	private ConnectionModel model = new ConnectionModel();
	
    @FXML
    private Label asnValueLabel;

    @FXML
    private Label hostValueLabel;

    @FXML
    private Label ipValueLabel;

    @FXML
    private Label ispValueLabel;

    @FXML
    private Label typeValueLabel;

    @FXML
    private GridPane view;

    public ConnectionController() throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Connection.fxml"));
    	loader.setController(this);
    	loader.load();
    }
    
    public GridPane getView() {
		return view;
	}
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		asnValueLabel.textProperty().bind(model.asnProperty().asString());
		ipValueLabel.textProperty().bind(model.ipAddressProperty());
		ispValueLabel.textProperty().bind(model.ispProperty());
		typeValueLabel.textProperty().bind(model.typeProperty());
		hostValueLabel.textProperty().bind(model.hostnameProperty());
		
	}
	
	public ConnectionModel getModel() {
		return model;
	}

}

