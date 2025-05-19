package com.novomind.plugin.app.iagent.mailinfo.helloworld;

import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.slf4j.Logger;

import com.novomind.ecom.api.imail.common.frontend.mailinfo.MailInfoTab;
import com.novomind.ecom.api.imail.common.frontend.mailinfo.SearchResultMailInfoViewContext;
import com.novomind.ecom.api.imail.model.BacklogMessage;
import com.novomind.ecom.api.imail.model.IncomingMessage;
import com.novomind.ecom.api.imail.model.SentMessage;
import com.novomind.ecom.common.api.frontend.CustomBean;
import com.novomind.ecom.common.api.frontend.CustomManagedBean;


@CustomManagedBean("HelloWorldSearchResultMailInfoTabBean")
public class HelloWorldSearchResultMailInfoTabBean implements CustomBean {

  @Inject
  private Logger log;


  @Inject
  MailInfoTab tab;


  @Inject
  private SearchResultMailInfoViewContext searchResultViewContext;


  public HelloWorldSearchResultMailInfoTabBean() {
  }


  @PostConstruct
  public void init() {
    log.debug("tab: " + tab + " -> " + (tab != null ? tab.getUrl() : ""));
    log.trace("searchResultViewContext: " + searchResultViewContext);
  }


  public String getIncomingMessageSubject() {
    IncomingMessage incomingMessage = searchResultViewContext != null ? searchResultViewContext.getIncomingMessage() : null;
    return incomingMessage != null ? incomingMessage.getSubject() : "";
  }


  public String getBacklogMessageSubject() {
    Optional<BacklogMessage> backlogMessage = searchResultViewContext != null ? searchResultViewContext.getBacklogMessage() : null;
    return backlogMessage != null && backlogMessage.isPresent() ? backlogMessage.get().getSubject() : "";
  }


  public String getSentMessageSubject() {
    Optional<SentMessage> sentMessage = searchResultViewContext != null ? searchResultViewContext.getSentMessage() : null;    
    return sentMessage != null && sentMessage.isPresent() ? sentMessage.get().getSubject() : "";
  }


  public String getIncomingMessageText() {
    IncomingMessage incomingMessage = searchResultViewContext != null ? searchResultViewContext.getIncomingMessage() : null;
    return incomingMessage != null ? incomingMessage.getText() : "";
  }


  public String getBacklogMessageText() {
    Optional<BacklogMessage> backlogMessage = searchResultViewContext != null ? searchResultViewContext.getBacklogMessage() : null;
    return backlogMessage != null && backlogMessage.isPresent() ? backlogMessage.get().getText() : "";
  }


  public String getSentMessageText() {
    Optional<SentMessage> sentMessage = searchResultViewContext != null ? searchResultViewContext.getSentMessage() : null;
    return sentMessage != null && sentMessage.isPresent() ? sentMessage.get().getText() : "";
  }

}