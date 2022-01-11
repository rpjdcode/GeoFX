package dad.rubenpablo.app.geo.loc;

import dad.rubenpablo.app.ipapi.mapeo.PapiMessage;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

public class LocationModel {

	private ObjectProperty<PapiMessage> ref = new SimpleObjectProperty<PapiMessage>();
	
	private DoubleProperty latitude = new SimpleDoubleProperty();
	private DoubleProperty longitude = new SimpleDoubleProperty();
	private StringProperty location = new SimpleStringProperty();
	private StringProperty countryFlag = new SimpleStringProperty();
	private StringProperty city = new SimpleStringProperty();
	private StringProperty zip = new SimpleStringProperty();
	private StringProperty lang = new SimpleStringProperty();
	private StringProperty timeZone = new SimpleStringProperty();
	private StringProperty callingCode = new SimpleStringProperty();
	private StringProperty currency = new SimpleStringProperty();
	
	private ObjectProperty<Image> flagImage = new SimpleObjectProperty<Image>();
	
	public final DoubleProperty latitudeProperty() {
		return this.latitude;
	}
	
	public final double getLatitude() {
		return this.latitudeProperty().get();
	}
	
	public final void setLatitude(final double latitude) {
		this.latitudeProperty().set(latitude);
	}
	
	public final DoubleProperty longitudeProperty() {
		return this.longitude;
	}
	
	public final double getLongitude() {
		return this.longitudeProperty().get();
	}
	
	public final void setLongitude(final double longitude) {
		this.longitudeProperty().set(longitude);
	}
	
	public final StringProperty locationProperty() {
		return this.location;
	}
	
	public final String getLocation() {
		return this.locationProperty().get();
	}
	
	public final void setLocation(final String location) {
		this.locationProperty().set(location);
	}
	
	public final StringProperty countryFlagProperty() {
		return this.countryFlag;
	}
	
	public final String getCountryFlag() {
		return this.countryFlagProperty().get();
	}
	
	public final void setCountryFlag(final String countryFlag) {
		this.countryFlagProperty().set(countryFlag);
	}
	
	public final StringProperty cityProperty() {
		return this.city;
	}
	
	public final String getCity() {
		return this.cityProperty().get();
	}
	
	public final void setCity(final String city) {
		this.cityProperty().set(city);
	}
	
	public final StringProperty zipProperty() {
		return this.zip;
	}
	
	public final String getZip() {
		return this.zipProperty().get();
	}
	
	public final void setZip(final String zip) {
		this.zipProperty().set(zip);
	}
	
	public final StringProperty langProperty() {
		return this.lang;
	}
	
	public final String getLang() {
		return this.langProperty().get();
	}
	
	public final void setLang(final String lang) {
		this.langProperty().set(lang);
	}
	
	public final StringProperty timeZoneProperty() {
		return this.timeZone;
	}
	
	public final String getTimeZone() {
		return this.timeZoneProperty().get();
	}
	
	public final void setTimeZone(final String timeZone) {
		this.timeZoneProperty().set(timeZone);
	}
	
	public final StringProperty callingCodeProperty() {
		return this.callingCode;
	}
	
	public final String getCallingCode() {
		return this.callingCodeProperty().get();
	}
	
	public final void setCallingCode(final String callingCode) {
		this.callingCodeProperty().set(callingCode);
	}
	
	public final StringProperty currencyProperty() {
		return this.currency;
	}
	
	public final String getCurrency() {
		return this.currencyProperty().get();
	}
	
	public final void setCurrency(final String currency) {
		this.currencyProperty().set(currency);
	}

	public final ObjectProperty<PapiMessage> refProperty() {
		return this.ref;
	}
	

	public final PapiMessage getRef() {
		return this.refProperty().get();
	}
	
	public final void setRef(final PapiMessage ref) {
		this.refProperty().set(ref);
	}

	public final ObjectProperty<Image> flagImageProperty() {
		return this.flagImage;
	}
	

	public final Image getFlagImage() {
		return this.flagImageProperty().get();
	}
	

	public final void setFlagImage(final Image flagImage) {
		this.flagImageProperty().set(flagImage);
	}
	
	
	
	
}
