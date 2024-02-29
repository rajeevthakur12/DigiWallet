package com.DigiWallet.service;

import com.DigiWallet.exception.LoginException;
import com.DigiWallet.model.UserLogin;

public interface UserLoginService {

	 public String login (UserLogin userLogin) throws LoginException;
		
		public String logout (String Key) throws LoginException;
}
