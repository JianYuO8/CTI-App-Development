package com.novomind.ecom.app.iagent.custom.training.core.plugin;

import java.io.IOException;

import javax.inject.Inject;

import com.novomind.ecom.api.iagent.model.App;
import com.novomind.ecom.app.iagent.custom.training.common.plugin.CrmAPIBean;
import org.slf4j.Logger;

import com.novomind.ecom.api.iagent.exception.WrongTypeException;
import com.novomind.ecom.api.imail.core.CorePlugin;
import com.novomind.ecom.api.imail.core.IncomingMessageReceivedEventListener;
import com.novomind.ecom.api.imail.core.event.IncomingMessageReceivedEvent;
import com.novomind.ecom.api.imail.exception.PermanentMessagingException;
import com.novomind.ecom.api.imail.exception.TemporaryMessagingException;
import com.novomind.ecom.app.iagent.custom.training.shared.CrmConstants;

@CorePlugin
public class TrainingIncomingMessageReceivedEventListener implements IncomingMessageReceivedEventListener {

    @Inject
    private Logger log;

    @Inject
    private App app;

    @Override
    public void incomingMessageReceived(IncomingMessageReceivedEvent incomingMessageReceivedEvent) throws PermanentMessagingException, TemporaryMessagingException {
        if (incomingMessageReceivedEvent == null) {
            log.warn("The contact id could not be stored. Reason: incomingMessageReceivedEvent = null");
            return;
        }
        String logTicketId = String.valueOf(incomingMessageReceivedEvent.getTicketId());

        try {
            if (incomingMessageReceivedEvent.getTicketStorage() != null) {
                String callingNumber = incomingMessageReceivedEvent.getTicketStorage().getString(CrmConstants.ISSUE_PROPERTY_CALLING_NUMBER);
                incomingMessageReceivedEvent.getTicketStorage().setString(CrmConstants.ISSUE_PROPERTY_CONTACT_PHONE, callingNumber);
                if (callingNumber != null) {
                    if (app != null) {
                        CrmAPIBean crmApiBean = new CrmAPIBean(app, log);
                        String contactId = crmApiBean.getCrmContactIdFromPhone(callingNumber);
                        if (contactId != null) {
                            incomingMessageReceivedEvent.getTicketStorage().setString(CrmConstants.ISSUE_PROPERTY_CONTACT_ID, contactId);
                        } else {
                            log.info("[{}] Contact Phone {} has no contact id .", logTicketId, callingNumber);
                        }
                        log.info("[{}] Contact id = {} stored as ticket property.", logTicketId, contactId);
                    } else {
                        log.info("[{}] No App in ticket.", logTicketId);
                    }
                } else {
                    log.info("[{}] No Contact Phone in ticket.", logTicketId);
                }
            } else {
                log.warn("The contact id could not be stored. Reason: TicketStorage = null");
            }
        } catch (WrongTypeException | IOException e) {
            log.error("[{}] Ticket property could not be stored.", logTicketId, e);
        }
    }


}
