package dad.rubenpablo.app;

import java.io.IOException;

import dad.rubenpablo.app.geo.GeoController;
import dad.rubenpablo.app.ipapi.PapiService;
import dad.rubenpablo.app.ipify.IpifyService;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	private GeoController geoController;
	private static PapiService ipapi = new PapiService();;
	private static IpifyService ipify = new IpifyService();
	
	
	public static PapiService getIpapi() {
		return ipapi;
	}

	public static void setIpapi(PapiService ipapi) {
		App.ipapi = ipapi;
	}

	public static IpifyService getIpify() {
		return ipify;
	}

	public static void setIpify(IpifyService ipify) {
		App.ipify = ipify;
	}

	@Override
	public void init() throws IOException {
		geoController = new GeoController();
	}
	
	@Override
	public void stop() {
		
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Scene escena = new Scene(geoController.getView());
		
		primaryStage.setTitle("GeoFX");
		primaryStage.setScene(escena);
		primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/imgs/icons/Globe-icon.png")));
		primaryStage.show();

	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
