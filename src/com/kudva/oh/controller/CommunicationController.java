package com.kudva.oh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.kudva.oh.model.SMSData;
import com.kudva.oh.util.CommunicationUtilities;

@RestController
public class CommunicationController {

	@Autowired
	CommunicationUtilities communicationUtilities;

	@RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
	public ResponseEntity<String> createChannelEntry(@RequestBody SMSData sms) {
		String output;
		try {
			output = communicationUtilities.sendMessage(sms);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("there is an exception : " + e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(output, HttpStatus.OK);
	}
}
