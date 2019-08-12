package com.fossils.fossils.controller;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fossils.fossils.entity.User;
import com.fossils.fossils.service.UserService;

@RestController
public class LoginController {

	@Autowired
	UserService userService;

	@GetMapping(path = "/api/login")
	public boolean validateLogin(@RequestParam String credentials) {

		System.out.println("Credentials : " + credentials);

		// Decode value
		byte[] base64decodedBytes = Base64.getDecoder().decode(credentials);

		// Encoded Value
		String encodeValue = "";
		try {
			encodeValue = new String(base64decodedBytes, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (!encodeValue.isEmpty()) {
			String cre[] = encodeValue.split(":");
			String userName = cre[0];
			String password = cre[1];

			User user = userService.findByUsernameAndPassword(userName, password);
			if (user == null) {
				System.out.println("No user found!");
				return false;
			} else {
				return true;
			}

		}

		return false;

	}
}
