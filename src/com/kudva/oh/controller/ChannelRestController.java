package com.kudva.oh.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kudva.oh.model.ChannelInfo;

@RestController
public class ChannelRestController {
	
	@RequestMapping(value = "/channel", method = RequestMethod.POST)
	public ResponseEntity<ChannelInfo> createChannelEntry(@RequestBody ChannelInfo channelInfo){
		System.out.println("writing to file!!");
		return new ResponseEntity<ChannelInfo>(channelInfo, HttpStatus.OK);
	}
	
	@GetMapping("/channels")
	public String getCustomers() {
		System.out.println("Working!");
		return "working";
	}
}
