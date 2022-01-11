package dad.rubenpablo.app.ipapi;

import dad.rubenpablo.app.ipapi.mapeo.PapiMessage;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface PapiInterface {
	
	@GET("ip_api.php")
	public Call<PapiMessage> ipCheck(@Query("ip") String ip);
}
