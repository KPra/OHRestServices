package com.kudva.oh.util.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kudva.oh.model.SMSData;
import com.kudva.oh.util.CommunicationUtilities;

@Service
public class CommunicationUtilitiesImpl implements CommunicationUtilities {
	@Override
	public String sendMessage(SMSData sms) throws Exception{
		String output;
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
			return output;
	}
}
