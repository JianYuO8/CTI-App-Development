package com.novomind.plugin.app.iagent.mailinfo.helloworld;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.slf4j.Logger;

import com.novomind.ecom.api.imail.common.frontend.mailinfo.BacklogMailInfoViewContext;
import com.novomind.ecom.api.imail.common.frontend.mailinfo.ExternalReplyMailInfoViewContext;
import com.novomind.ecom.api.imail.common.frontend.mailinfo.IncomingMailInfoViewContext;
import com.novomind.ecom.api.imail.common.frontend.mailinfo.MailInfoTab;
import com.novomind.ecom.api.imail.common.frontend.mailinfo.OutgoingMailInfoViewContext;
import com.novomind.ecom.api.imail.model.BacklogMessage;
import com.novomind.ecom.api.imail.model.ExternalReplyMessage;
import com.novomind.ecom.api.imail.model.IncomingMessage;
import com.novomind.ecom.api.imail.model.OutgoingMessage;
import com.novomind.ecom.common.api.frontend.CustomBean;
import com.novomind.ecom.common.api.frontend.CustomManagedBean;


@CustomManagedBean("HelloWorldBacklogMailInfoTabBean")
public class HelloWorldBacklogMailInfoTabBean implements CustomBean {

  @Inject
  private Logger log;


  @Inject
  MailInfoTab tab;


  @Inject
  private IncomingMailInfoViewContext incomingViewContext;
  
  @Inject
  private BacklogMailInfoViewContext backlogViewContext;

  @Inject
  private OutgoingMailInfoViewContext outgoingViewContext;

  @Inject
  private ExternalReplyMailInfoViewContext externalViewContext;


  
  public HelloWorldBacklogMailInfoTabBean() {
  }

  @PostConstruct
  public void init() {
    log.debug("tab: " + tab + " -> " + (tab != null ? tab.getUrl() : ""));
    log.trace("incomingViewContext: " + incomingViewContext);
    log.trace("backlogViewContext:  " + backlogViewContext);
    log.trace("outgoingViewContext: " + outgoingViewContext);
    log.trace("externalViewContext: " + externalViewContext);
  }


  public String getIncomingMessageSubject() {
    IncomingMessage incomingMessage = incomingViewContext != null ? incomingViewContext.getIncomingMessage() : null;
    return incomingMessage != null ? incomingMessage.getSubject() : "";
  }


  public String getBacklogMessageSubject() {
    BacklogMessage backlogMessage = backlogViewContext != null ? backlogViewContext.getBacklogMessage() : null;
    return backlogMessage != null ? backlogMessage.getSubject() : "";
  }


  public String getOutgoingMessageSubject() {
    OutgoingMessage outgoingMessage = outgoingViewContext != null ? outgoingViewContext.getOutgoingMessage() : null;
    return outgoingMessage != null ? outgoingMessage.getSubject() : "";
  }


  public String getExternalReplyMessageSubject() {
    ExternalReplyMessage externalReplyMessage = externalViewContext != null ? externalViewContext.getExternalReplyMessage() : null;    
    return externalReplyMessage != null ? externalReplyMessage.getSubject() : "";
  }


  public String getIncomingMessageText() {
    IncomingMessage incomingMessage = incomingViewContext != null ? incomingViewContext.getIncomingMessage() : null;
    return incomingMessage != null ? incomingMessage.getText() : "";
  }


  public String getBacklogMessageText() {
    BacklogMessage backlogMessage = backlogViewContext != null ? backlogViewContext.getBacklogMessage() : null;
    return backlogMessage != null ? backlogMessage.getText() : "";
  }


  public String getOutgoingMessageText() {
    OutgoingMessage outgoingMessage = outgoingViewContext != null ? outgoingViewContext.getOutgoingMessage() : null;
    return outgoingMessage != null ? outgoingMessage.getText() : "";
  }


  public String getExternalReplyMessageText() {
    ExternalReplyMessage externalReplyMessage = externalViewContext != null ? externalViewContext.getExternalReplyMessage() : null;    
    return externalReplyMessage != null ? externalReplyMessage.getText() : "";
  }

}