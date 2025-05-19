package com.novomind.plugin.app.iagent.mailinfo.helloworld;

import javax.inject.Inject;

import org.slf4j.Logger;

import com.novomind.ecom.api.imail.common.frontend.mailinfo.AgentBacklogMailInfoViewContext;
import com.novomind.ecom.api.imail.common.frontend.mailinfo.AgentDraftMailInfoViewContext;
import com.novomind.ecom.api.imail.common.frontend.mailinfo.AgentMailInfoViewContext;
import com.novomind.ecom.api.imail.common.frontend.mailinfo.AgentOutgoingMailInfoViewContext;
import com.novomind.ecom.api.imail.common.frontend.mailinfo.AgentQuickCaseMailInfoViewContext;
import com.novomind.ecom.api.imail.common.frontend.mailinfo.ArchiveAccessMailInfoViewContext;
import com.novomind.ecom.api.imail.common.frontend.mailinfo.BacklogMailInfoViewContext;
import com.novomind.ecom.api.imail.common.frontend.mailinfo.ExternalReplyMailInfoViewContext;
import com.novomind.ecom.api.imail.common.frontend.mailinfo.MailInfoTab;
import com.novomind.ecom.api.imail.common.frontend.mailinfo.MailInfoTabProvider;
import com.novomind.ecom.api.imail.common.frontend.mailinfo.MailInfoViewContext;
import com.novomind.ecom.api.imail.common.frontend.mailinfo.OutgoingMailInfoViewContext;
import com.novomind.ecom.api.imail.common.frontend.mailinfo.SearchResultMailInfoViewContext;
import com.novomind.ecom.api.imail.routing.RoutingPlugin;
import com.novomind.ecom.api.iagent.frontend.tab.InfoTabBehavior;
import com.novomind.ecom.api.iagent.frontend.tab.InfoTabNotification;
import com.novomind.ecom.api.imail.agent.MailAgentPlugin;

import static com.novomind.ecom.api.iagent.frontend.tab.InfoTabBehavior.SelectionType;
import static com.novomind.ecom.api.iagent.frontend.tab.InfoTabBehavior.HighlightType;

/**
 * A <code>HelloWorldMailInfoTab</code> is a <code>MailAgentPlugin</code> and
 * <code>RoutingPlugin</code> at the same time and demonstrates the usage of the
 * interface <code>MailInfoTabProvider</code> to apply additional mail info tabs
 * to the mail info view in the iAGENT Supervisor and agent GUI.
 */

@RoutingPlugin
@MailAgentPlugin
public class HelloWorldMailInfoTab implements MailInfoTabProvider {
  
  @Inject
  private Logger log;

  /* The name of the tab must be unique. */
  private String name        = "Sender";
  
  /* The displayName of the tab will be used as label for the tab
   * and should be localized according the application user's language */
  private String displayName = "Details";


  public HelloWorldMailInfoTab() {
  }


  /* This is the default case */
  @Override
  public MailInfoTab getMailInfoTab(MailInfoViewContext context) {
    log.trace("getMailInfoTabPath.default");

    return new MailInfoTab(name, displayName + " (ID: " + context.getTicketId() + ")", context.getViewUrl("/mailinfo/helloworld/helloWorld.xhtml"));
  }


  /* This method will be called on mail info views on backlog folders */
  @Override
  public MailInfoTab getMailInfoTab(BacklogMailInfoViewContext context) {
    return new MailInfoTab(name, displayName, context.getViewUrl("/mailinfo/helloworld/helloWorldBacklog.xhtml"))
              .setBehavior(new InfoTabBehavior(HighlightType.RED));
  }


  /* This method will be called on mail info views on outgoing folders */
  @Override
  public MailInfoTab getMailInfoTab(OutgoingMailInfoViewContext context) {
    return new MailInfoTab(name, displayName + " (Out)", context.getViewUrl("/mailinfo/helloworld/helloWorldOutgoing.xhtml"))
              .setBehavior(new InfoTabBehavior(InfoTabNotification.withCount(47), SelectionType.SELECTED_FULLSCREEN, HighlightType.RED));
  }


  /* This method will be called on mail info views on the 2nd-level-reply folder, that only exists in the iAGENT Supervisor */
  @Override
  public MailInfoTab getMailInfoTab(ExternalReplyMailInfoViewContext context) {
    return new MailInfoTab(name, displayName, context.getViewUrl("/mailinfo/helloworld/helloWorldExternalReply.xhtml"))
              .setBehavior(new InfoTabBehavior(InfoTabNotification.EXCLAMATION_MARK_RED, SelectionType.SELECTED_FULLSCREEN, null));
  }


  /* This method will be called on mail info views on the agent folder */
  @Override
  public MailInfoTab getMailInfoTab(AgentMailInfoViewContext context) {
    return new MailInfoTab(name, displayName, context.getViewUrl("/mailinfo/helloworld/helloWorldAgent.xhtml"));
  }


  /* This method will be called on mail info views on the personal resubmit/2nd-Level-folder of an agent. This context only exists in the iAGENT agent frontend */
  @Override
  public MailInfoTab getMailInfoTab(AgentBacklogMailInfoViewContext context) {
    return new MailInfoTab(name, displayName, context.getViewUrl("/mailinfo/helloworld/helloWorldAgentBacklog.xhtml"))
              .setBehavior(new InfoTabBehavior(InfoTabNotification.withCount(39)));
  }

  /* This method will be called on mail info views on the agent's draft folder, that only exists in the iAGENT agent frontend */
  @Override
  public MailInfoTab getMailInfoTab(AgentDraftMailInfoViewContext context) {
    return null; // example: do not show tab for this view
    //return new MailInfoTab(name, displayName, context.getViewUrl("/mailinfo/helloworld/helloWorldAgentDraft.xhtml"));
  }


  /* This method will be called on mail info views on the agents sent folder, that only exists in the iAGENT agent frontend */
  @Override
  public MailInfoTab getMailInfoTab(AgentOutgoingMailInfoViewContext context) {
    return new MailInfoTab(name, displayName, context.getViewUrl("/mailinfo/helloworld/helloWorldAgentOutgoing.xhtml"));
  }


  /* This method will be called on mail info views on quick case tabs, that only exists in the iAGENT agent frontend */
  @Override
  public MailInfoTab getMailInfoTab(AgentQuickCaseMailInfoViewContext context) {
    return new MailInfoTab(name, displayName + " QC: " + context.getTicketId(), context.getViewUrl("/mailinfo/helloworld/helloWorldAgentQuickCase.xhtml"));
  }


  /* This method will be called on mail info views on search results */
  @Override
  public MailInfoTab getMailInfoTab(SearchResultMailInfoViewContext context) {
    return new MailInfoTab(name, displayName, context.getViewUrl("/mailinfo/helloworld/helloWorldSearchResult.xhtml"));
  }


  /* This method will be called on mail info views on other views accessing messages directly on the message archive */
  @Override
  public MailInfoTab getMailInfoTab(ArchiveAccessMailInfoViewContext context) {
    return new MailInfoTab(name, displayName, context.getViewUrl("/mailinfo/helloworld/helloWorldArchiveAccess.xhtml"));
  }


}