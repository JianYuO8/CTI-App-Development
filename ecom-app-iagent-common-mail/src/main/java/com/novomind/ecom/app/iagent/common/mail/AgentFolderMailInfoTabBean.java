package com.novomind.ecom.app.iagent.common.mail;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.slf4j.Logger;

import com.novomind.ecom.api.imail.common.frontend.mailinfo.MailInfoViewContext;
import com.novomind.ecom.api.imail.common.frontend.mailinfo.AgentBacklogMailInfoViewContext;
import com.novomind.ecom.api.imail.common.frontend.mailinfo.AgentDraftMailInfoViewContext;
import com.novomind.ecom.api.imail.common.frontend.mailinfo.AgentMailInfoViewContext;
import com.novomind.ecom.api.imail.common.frontend.mailinfo.AgentOutgoingMailInfoViewContext;
import com.novomind.ecom.api.imail.common.frontend.mailinfo.IncomingMailInfoViewContext;
import com.novomind.ecom.api.imail.common.frontend.mailinfo.MailInfoTab;
import com.novomind.ecom.api.imail.model.AgentDraftMessage;
import com.novomind.ecom.api.imail.model.AgentMessage;
import com.novomind.ecom.api.imail.model.BacklogMessage;
import com.novomind.ecom.api.imail.model.IncomingMessage;
import com.novomind.ecom.api.imail.model.OutgoingMessage;
import com.novomind.ecom.api.iagent.model.Account;
import com.novomind.ecom.common.api.frontend.CustomBean;
import com.novomind.ecom.common.api.frontend.CustomManagedBean;

@CustomManagedBean("AgentFolderMailInfoTabBean")
public class AgentFolderMailInfoTabBean implements CustomBean {

    @Inject
    private Logger log;

    @Inject
    MailInfoTab tab;

    @Inject
    private IncomingMailInfoViewContext incomingViewContext;

    @Inject
    private AgentMailInfoViewContext agentViewContext;

    @Inject
    private AgentDraftMailInfoViewContext agentDraftViewContext;

    @Inject
    private AgentOutgoingMailInfoViewContext agentOutgoingViewContext;

    @Inject
    private AgentBacklogMailInfoViewContext agentBacklogViewContext;

    public AgentFolderMailInfoTabBean() {
    }

    @PostConstruct
    public void init() {
        log.debug("tab: " + tab);
        log.trace("incomingViewContext:      " + incomingViewContext);
        log.trace("agentViewContext:         " + agentViewContext);
        log.trace("agentDraftViewContext:    " + agentDraftViewContext);
        log.trace("agentOutgoingViewContext: " + agentOutgoingViewContext);
        log.trace("agentBacklogViewContext:  " + agentBacklogViewContext);
    }

    public String getIncomingMessageSubject() {
        IncomingMessage incomingMessage = incomingViewContext != null ? incomingViewContext.getIncomingMessage() : null;
        return incomingMessage != null ? incomingMessage.getSubject() : "";
    }

    public String getIncomingAddress() {
        Account address = incomingViewContext != null ? incomingViewContext.getIncomingAccount() : null;
        return address != null ? address.getAddress() : "";
    }

    public String getAgentMessageSubject() {
        AgentMessage agentMessage = agentViewContext != null ? agentViewContext.getAgentMessage() : null;
        return agentMessage != null ? agentMessage.getSubject() : "";
    }

    public String getAgentDraftMessageSubject() {
        AgentDraftMessage agentDraftMessage = agentDraftViewContext != null ? agentDraftViewContext.getAgentDraftMessage() : null;
        return agentDraftMessage != null ? agentDraftMessage.getSubject() : "";
    }

    public String getAgentOutgoingMessageSubject() {
        OutgoingMessage agentOutgoingMessage = agentOutgoingViewContext != null ? agentOutgoingViewContext.getOutgoingMessage() : null;
        return agentOutgoingMessage != null ? agentOutgoingMessage.getSubject() : "";
    }

    public String getAgentBacklogMessageSubject() {
        BacklogMessage agentBacklogMessage = agentBacklogViewContext != null ? agentBacklogViewContext.getBacklogMessage() : null;
        return agentBacklogMessage != null ? agentBacklogMessage.getSubject() : "";
    }

    public String getIncomingMessageText() {
        IncomingMessage incomingMessage = incomingViewContext != null ? incomingViewContext.getIncomingMessage() : null;
        return incomingMessage != null ? incomingMessage.getText() : "";
    }

    public String getAgentMessageText() {
        AgentMessage agentMessage = agentViewContext != null ? agentViewContext.getAgentMessage() : null;
        return agentMessage != null ? agentMessage.getText() : "";
    }

    public String getAgentDraftMessageText() {
        AgentDraftMessage agentDraftMessage = agentDraftViewContext != null ? agentDraftViewContext.getAgentDraftMessage() : null;
        return agentDraftMessage != null ? agentDraftMessage.getText() : "";
    }

    public String getAgentOutgoingMessageText() {
        OutgoingMessage agentOutgoingMessage = agentOutgoingViewContext != null ? agentOutgoingViewContext.getOutgoingMessage() : null;
        return agentOutgoingMessage != null ? agentOutgoingMessage.getText() : "";
    }

    public String getAgentBacklogMessageText() {
        BacklogMessage agentBacklogMessage = agentBacklogViewContext != null ? agentBacklogViewContext.getBacklogMessage() : null;
        return agentBacklogMessage != null ? agentBacklogMessage.getText() : "";
    }

    public long getTicketId() {
        return incomingViewContext.getTicket().getId();
    }
}