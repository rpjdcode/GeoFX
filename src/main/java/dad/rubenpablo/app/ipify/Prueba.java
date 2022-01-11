package dad.rubenpablo.app.ipify;

import java.io.IOException;

public class Prueba {

	public static void main(String[] args) throws IOException {
		IpifyService servicio = new IpifyService();
		
		System.out.println("IP LOCAL: " + servicio.obtainIP());

	}

}
