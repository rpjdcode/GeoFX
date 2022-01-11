package dad.rubenpablo.app.geo.sec;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class SecurityController implements Initializable{

	private SecurityModel model = new SecurityModel();
	
    @FXML
    private CheckBox crawlerCheck;

    @FXML
    private Label iconTextValueLabel;

    @FXML
    private Label potentialValueLabel;

    @FXML
    private CheckBox proxyCheck;

    @FXML
    private Label threatLevelValueLabel;

    @FXML
    private CheckBox torCheck;

    @FXML
    private GridPane view;
    
    public SecurityController() throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Security.fxml"));
    	loader.setController(this);
    	loader.load();
    }
    
    public GridPane getView() {
		return view;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		crawlerCheck.selectedProperty().bind(model.crawlerProperty());
		torCheck.selectedProperty().bind(model.torProperty());
		proxyCheck.selectedProperty().bind(model.proxyProperty());
		potentialValueLabel.textProperty().bind(model.potentialThreatProperty());
		threatLevelValueLabel.textProperty().bind(model.threatLevelProperty());
		iconTextValueLabel.textProperty().bind(model.iconTextProperty());
		
	}
	
	public SecurityModel getModel() {
		return model;
	}

}
