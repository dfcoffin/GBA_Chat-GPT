package com.reminetworks.chatgpt.controllers;

import com.reminetworks.chatgpt.services.ChatGptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author Donald F. Coffin, Green Button Alliance, Inc.
 */

@RestController
public class ChatGptController
{
	@Autowired
	private ChatGptService chatGptService;

	//Making use of @RequestParam to extract the query from the URL.
	@GetMapping("/chat")
	public ResponseEntity<String>getAnswer(@RequestParam("query") String query) throws IOException
	{
		if(chatGptService.chatService(query)!=null)
			return new ResponseEntity<>(chatGptService.chatService(query),HttpStatus.OK);

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
