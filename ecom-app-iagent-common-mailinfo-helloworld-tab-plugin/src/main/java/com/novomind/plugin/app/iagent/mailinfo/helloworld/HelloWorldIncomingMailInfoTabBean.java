package com.novomind.plugin.app.iagent.mailinfo.helloworld;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.slf4j.Logger;

import com.novomind.ecom.api.imail.common.frontend.mailinfo.IncomingMailInfoViewContext;
import com.novomind.ecom.api.imail.common.frontend.mailinfo.MailInfoTab;
import com.novomind.ecom.api.imail.model.IncomingMessage;
import com.novomind.ecom.common.api.frontend.CustomBean;
import com.novomind.ecom.common.api.frontend.CustomManagedBean;


@CustomManagedBean("HelloWorldIncomingMailInfoTabBean")
public class HelloWorldIncomingMailInfoTabBean implements CustomBean {

  @Inject
  private Logger log;


  @Inject
  MailInfoTab tab;


  @Inject
  private IncomingMailInfoViewContext incomingViewContext;

  
  public HelloWorldIncomingMailInfoTabBean() {
  }

  @PostConstruct
  public void init() {
    log.debug("tab: " + tab + " -> " + (tab != null ? tab.getUrl() : ""));
    log.trace("incomingViewContext:  " + incomingViewContext);
  }


  public String getIncomingMessageSubject() {
    IncomingMessage incomingMessage = incomingViewContext.getIncomingMessage();
    return incomingMessage != null ? incomingMessage.getSubject() : "";
  }


  public String getIncomingMessageText() {
    IncomingMessage incomingMessage = incomingViewContext.getIncomingMessage();
    return incomingMessage != null ? incomingMessage.getText() : "";
  }

}