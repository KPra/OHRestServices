package com.kudva.oh.sms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class SMSExample {

	@RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
	public ResponseEntity<String> createChannelEntry(@RequestBody SMSData sms){
		String output;
		try {
			URL url = new URL("http://smsgateway.me/api/v3/messages/send");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			
			OutputStream os = conn.getOutputStream();
			ObjectMapper mapper = new ObjectMapper();
			os.write(mapper.writeValueAsString(sms).getBytes());
			os.flush();
			
			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return new ResponseEntity<>("MalformedURLException", HttpStatus.BAD_REQUEST);
		} catch (ProtocolException e) {
			e.printStackTrace();
			return new ResponseEntity<>("ProtocolException", HttpStatus.BAD_REQUEST);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new ResponseEntity<>("JsonProcessingException", HttpStatus.BAD_REQUEST);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<>("IOException", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(output, HttpStatus.OK);
	}
}
