package com.chatbot.controller;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

import com.rivescript.Config;
import com.rivescript.RiveScript;


@ManagedBean(name = "controller")
public class BotController {
  
 private String humanMessage;
 private String botMessage="Hello Human , I am Ross .\n How can i help you ?";
 private String humanMessageDisplay;
 private RiveScript bot;

 public void onSend(ActionEvent event) {
	  String rivescriptFilePath = BotController.class.getClassLoader().getResource("rivescript").getFile();

	 bot = new RiveScript(Config.utf8());
	   
	  bot.loadDirectory(rivescriptFilePath);
	  bot.sortReplies();
	  this.botMessage =  bot.reply("user", humanMessage).replace("\n", "<br/>");
	  this.humanMessageDisplay = humanMessage;
	  this.humanMessage = null;
 }
 
 public String getHumanMessage() {
  return humanMessage;
 }
 
 public void setHumanMessage(String humanMessage) {
  this.humanMessage = humanMessage;
 }
 
 public String getBotMessage() {
  return botMessage;
 }
 
 public void setBotMessage(String botMessage) {
  this.botMessage = botMessage;
 }
 
 public String getHumanMessageDisplay() {
  return humanMessageDisplay;
 }
 
 public void setHumanMessageDisplay(String humanMessageDisplay) {
  this.humanMessageDisplay = humanMessageDisplay;
 }
}