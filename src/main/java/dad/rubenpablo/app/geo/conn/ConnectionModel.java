package dad.rubenpablo.app.geo.conn;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ConnectionModel {

	private StringProperty ipAddress = new SimpleStringProperty();
	private StringProperty isp = new SimpleStringProperty();
	private StringProperty type = new SimpleStringProperty();
	private IntegerProperty asn = new SimpleIntegerProperty();
	private StringProperty hostname = new SimpleStringProperty();
	
	public final StringProperty ipAddressProperty() {
		return this.ipAddress;
	}
	
	public final String getIpAddress() {
		return this.ipAddressProperty().get();
	}
	
	public final void setIpAddress(final String ipAddress) {
		this.ipAddressProperty().set(ipAddress);
	}
	
	public final StringProperty ispProperty() {
		return this.isp;
	}
	
	public final String getIsp() {
		return this.ispProperty().get();
	}
	
	public final void setIsp(final String isp) {
		this.ispProperty().set(isp);
	}
	
	public final StringProperty typeProperty() {
		return this.type;
	}
	
	public final String getType() {
		return this.typeProperty().get();
	}
	
	public final void setType(final String type) {
		this.typeProperty().set(type);
	}
	
	public final IntegerProperty asnProperty() {
		return this.asn;
	}
	
	public final Integer getAsn() {
		return this.asnProperty().get();
	}
	
	public final void setAsn(final Integer asn) {
		this.asnProperty().set(asn);
	}
	
	public final StringProperty hostnameProperty() {
		return this.hostname;
	}
	
	public final String getHostname() {
		return this.hostnameProperty().get();
	}
	
	public final void setHostname(final String hostname) {
		this.hostnameProperty().set(hostname);
	}
	
	
	
}
