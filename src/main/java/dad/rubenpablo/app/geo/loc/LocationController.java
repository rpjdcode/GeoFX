package dad.rubenpablo.app.geo.loc;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class LocationController implements Initializable {

	private LocationModel model = new LocationModel();
	
    @FXML
    private Label callingCodeValueLabel;

    @FXML
    private Label cityValueLabel;

    @FXML
    private ImageView countryFlagImg;

    @FXML
    private Label countryValueLabel;

    @FXML
    private Label currencyValueLabel;

    @FXML
    private Label languageValueLabel;

    @FXML
    private Label latValueLabel;

    @FXML
    private Label longValueLabel;

    @FXML
    private Label timeZoneValueLabel;

    @FXML
    private GridPane view;

    @FXML
    private Label zipValueLabel;

    
    public LocationController() throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Location.fxml"));
    	loader.setController(this);
    	loader.load();
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		latValueLabel.textProperty().bind(model.latitudeProperty().asString());
		longValueLabel.textProperty().bind(model.longitudeProperty().asString());
		callingCodeValueLabel.textProperty().bind(model.callingCodeProperty());
		zipValueLabel.textProperty().bind(model.zipProperty());
		timeZoneValueLabel.textProperty().bind(model.timeZoneProperty());
		languageValueLabel.textProperty().bind(model.langProperty());
		currencyValueLabel.textProperty().bind(model.currencyProperty());
		countryValueLabel.textProperty().bind(model.locationProperty());
		cityValueLabel.textProperty().bind(model.cityProperty());
		countryFlagImg.imageProperty().bind(model.flagImageProperty());
		
	}
	
	public GridPane getView() {
		return view;
	}

	public LocationModel getModel() {
		return model;
	}
}
