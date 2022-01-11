package dad.rubenpablo.app.ipapi;

import java.io.IOException;

import dad.rubenpablo.app.ipapi.mapeo.PapiMessage;

public class Prueba {

	public static void main(String[] args) {
		PapiService servicio = new PapiService();
		
		try {
			PapiMessage res = servicio.obtainRequest("83.37.197.255");
			
			System.out.println(res.getHostname());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
