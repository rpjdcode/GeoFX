package dad.rubenpablo.app.geo;

import dad.rubenpablo.app.ipapi.mapeo.PapiMessage;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GeoModel {

	private StringProperty ip = new SimpleStringProperty();
	private ObjectProperty<PapiMessage> ipInfo = new SimpleObjectProperty<PapiMessage>();
	
	public final StringProperty ipProperty() {
		return this.ip;
	}
	
	public final String getIp() {
		return this.ipProperty().get();
	}
	
	public final void setIp(final String ip) {
		this.ipProperty().set(ip);
	}
	
	public final ObjectProperty<PapiMessage> ipInfoProperty() {
		return this.ipInfo;
	}
	
	public final PapiMessage getIpInfo() {
		return this.ipInfoProperty().get();
	}
	
	public final void setIpInfo(final PapiMessage ipInfo) {
		this.ipInfoProperty().set(ipInfo);
	}
	
	
	
}
