package repositorios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import LogicaNegocio.AnuncioUcoServicio;

public class UCOMapsRepositorio {
	
	public static void crearAnuncio(AnuncioUcoServicio anuncio){
		try {

			URL url = new URL("http://localhost:8080/MANAGER_FITNESS/rest/Usuarios/42/"+"melisa"+"/rionegro/546/f@gmail.com/pas/1900-05-05");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			//conn.setRequestMethod("GET");
			//conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();

		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		  }

		}
}
