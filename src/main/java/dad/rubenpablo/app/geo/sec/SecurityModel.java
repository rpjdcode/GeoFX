package dad.rubenpablo.app.geo.sec;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SecurityModel {

	private BooleanProperty proxy = new SimpleBooleanProperty();
	private BooleanProperty tor = new SimpleBooleanProperty();
	private BooleanProperty crawler = new SimpleBooleanProperty();
	private StringProperty iconText = new SimpleStringProperty();
	private StringProperty threatLevel = new SimpleStringProperty();
	private StringProperty potentialThreat = new SimpleStringProperty();
	
	public final BooleanProperty proxyProperty() {
		return this.proxy;
	}
	
	public final boolean isProxy() {
		return this.proxyProperty().get();
	}
	
	public final void setProxy(final boolean proxy) {
		this.proxyProperty().set(proxy);
	}
	
	public final BooleanProperty torProperty() {
		return this.tor;
	}
	
	public final boolean isTor() {
		return this.torProperty().get();
	}
	
	public final void setTor(final boolean tor) {
		this.torProperty().set(tor);
	}
	
	public final BooleanProperty crawlerProperty() {
		return this.crawler;
	}
	
	public final boolean isCrawler() {
		return this.crawlerProperty().get();
	}
	
	public final void setCrawler(final boolean crawler) {
		this.crawlerProperty().set(crawler);
	}
	
	public final StringProperty iconTextProperty() {
		return this.iconText;
	}
	
	public final String getIconText() {
		return this.iconTextProperty().get();
	}
	
	public final void setIconText(final String iconText) {
		this.iconTextProperty().set(iconText);
	}
	
	public final StringProperty threatLevelProperty() {
		return this.threatLevel;
	}
	
	public final String getThreatLevel() {
		return this.threatLevelProperty().get();
	}
	
	public final void setThreatLevel(final String threatLevel) {
		this.threatLevelProperty().set(threatLevel);
	}
	
	public final StringProperty potentialThreatProperty() {
		return this.potentialThreat;
	}
	
	public final String getPotentialThreat() {
		return this.potentialThreatProperty().get();
	}
	
	public final void setPotentialThreat(final String potentialThreat) {
		this.potentialThreatProperty().set(potentialThreat);
	}
	
	
	
}
