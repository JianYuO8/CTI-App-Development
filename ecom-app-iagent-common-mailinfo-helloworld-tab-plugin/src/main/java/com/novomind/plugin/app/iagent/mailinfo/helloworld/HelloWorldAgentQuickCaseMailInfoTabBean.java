package com.novomind.plugin.app.iagent.mailinfo.helloworld;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.slf4j.Logger;

import com.novomind.ecom.api.imail.common.frontend.mailinfo.AgentQuickCaseMailInfoViewContext;
import com.novomind.ecom.api.imail.common.frontend.mailinfo.MailInfoTab;
import com.novomind.ecom.common.api.frontend.CustomBean;
import com.novomind.ecom.common.api.frontend.CustomManagedBean;


@CustomManagedBean("HelloWorldAgentQuickCaseMailInfoTabBean")
public class HelloWorldAgentQuickCaseMailInfoTabBean implements CustomBean {

  @Inject
  private Logger log;


  @Inject
  MailInfoTab tab;


  @Inject
  private AgentQuickCaseMailInfoViewContext agentQuickCaseViewContext;

  
  public HelloWorldAgentQuickCaseMailInfoTabBean() {
  }

  @PostConstruct
  public void init() {
    log.debug("tab: " + tab);
    log.trace("agentQuickCaseViewContext:      " + agentQuickCaseViewContext);
  }

  
  public long getQuickCaseTicketId() {
    return agentQuickCaseViewContext.getTicket().getId();
  }

}