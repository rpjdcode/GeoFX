package dad.rubenpablo.app.ipify;

import retrofit2.Call;
import retrofit2.http.GET;

interface IpifyInterface {

	@GET("?format=json")
	public Call<IpifyMessage> obtainIP();
}
