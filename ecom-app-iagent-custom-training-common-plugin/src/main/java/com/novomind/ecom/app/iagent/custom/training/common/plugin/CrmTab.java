package com.novomind.ecom.app.iagent.custom.training.common.plugin;

import javax.inject.Inject;

import com.novomind.ecom.api.iagent.frontend.chatinfo.ChatInfoTabProvider;
import com.novomind.ecom.api.iagent.model.App;
import org.slf4j.Logger;

import com.novomind.ecom.api.imail.common.frontend.mailinfo.MailInfoTab;
import com.novomind.ecom.api.imail.common.frontend.mailinfo.MailInfoTabProvider;
import com.novomind.ecom.api.imail.common.frontend.mailinfo.MailInfoViewContext;
import com.novomind.ecom.api.imail.routing.RoutingPlugin;
import com.novomind.ecom.api.iagent.frontend.tab.InfoTabBehavior;
import com.novomind.ecom.api.iagent.frontend.tab.InfoTabNotification;
import com.novomind.ecom.api.imail.agent.MailAgentPlugin;
import com.novomind.ecom.app.iagent.custom.training.shared.CrmConstants;

import java.util.Objects;

import static com.novomind.ecom.api.iagent.frontend.tab.InfoTabBehavior.SelectionType;
import static com.novomind.ecom.api.iagent.frontend.tab.InfoTabBehavior.HighlightType;

@RoutingPlugin
@MailAgentPlugin
public class CrmTab implements MailInfoTabProvider {
    @Inject
    private Logger log;

    @Inject
    private App app;

    @Override
    public MailInfoTab getMailInfoTab(MailInfoViewContext context) {
        log.trace("getMailInfoTabPath.default");

        return new MailInfoTab(CrmConstants.ISSUE_INFO_TAB_NAME, CrmConstants.ISSUE_INFO_TAB_DISPLAY_NAME, context.getViewUrl("/apps/crm/training/CrmCommon.xhtml"));
    }
}
