package com.kudva.oh.util;

import com.kudva.oh.model.SMSData;

public interface CommunicationUtilities {
	public String sendMessage(SMSData sms) throws Exception;
}
