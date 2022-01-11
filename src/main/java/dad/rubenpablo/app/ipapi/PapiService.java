package dad.rubenpablo.app.ipapi;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import dad.rubenpablo.app.ipapi.mapeo.PapiMessage;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PapiService {

	private static final String BASE_URL = "http://ipapi.com/";
	
	
	private PapiInterface service;
	
	public PapiService() {
		
		ConnectionPool pool = new ConnectionPool(1, 5, TimeUnit.SECONDS);	
		
		OkHttpClient client = new OkHttpClient.Builder()
				.connectionPool(pool)
				.build();
		
		
		Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
				.client(client)
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		
		service = retrofit.create(PapiInterface.class);
	}
	
	public PapiMessage obtainRequest(String ip) throws IOException {
		Response<PapiMessage> response = null;
		
		response = service.ipCheck(ip).execute();
		
		return response.body();
	}
	
	
}
