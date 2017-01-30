import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import org.json.JSONObject;

public class Test {
	public static void main(String[] args) throws IOException{
		// Date d = new Date();
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		// System.out.println(sdf.format(d));

		JSONObject object = new JSONObject();
		object.put("channelNo", "123");
		object.put("channelName", "pogo");
		object.put("channelCategory", "cartoons");
		object.put("date", new Date().toString());

		URL url = new URL("http://localhost:8080/OHRestServices/channel");
		HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
		httpcon.setDoOutput(true);
		httpcon.setRequestMethod("POST");
		httpcon.setRequestProperty("Accept", "application/json");
		httpcon.setRequestProperty("Content-Type", "application/json");
		httpcon.setRequestProperty("Accept", "application/json");

		OutputStreamWriter output = new OutputStreamWriter(httpcon.getOutputStream());
		output.write(object.toString());
		output.flush();
		httpcon.connect();
		String output1 = httpcon.getResponseMessage();
		System.out.println(output1);
	}
}
