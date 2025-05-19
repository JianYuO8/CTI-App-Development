package com.novomind.ecom.app.iagent.common.mail;

import javax.inject.Inject;

import com.novomind.ecom.api.iagent.model.App;
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

import java.util.Objects;

import static com.novomind.ecom.api.iagent.frontend.tab.InfoTabBehavior.SelectionType;
import static com.novomind.ecom.api.iagent.frontend.tab.InfoTabBehavior.HighlightType;

@RoutingPlugin
@MailAgentPlugin
public class AgentMailInfoTab implements MailInfoTabProvider{

    @Inject
    private Logger log;

    @Inject
    private App app;

    @Override
    public MailInfoTab getMailInfoTab(MailInfoViewContext context) {
        if (Objects.nonNull(context)) {
            String displayName = CrmConstants.ISSUE_INFO_TAB_DISPLAY_NAME;
            InfoTabBehavior.SelectionType selectionType = InfoTabBehavior.SelectionType.SELECTED;
            boolean fullscreen = false;
            if (Objects.nonNull(app)) {
                CrmAPIBean crmTrainingApiBean = new CrmAPIBean(app, log);
                displayName = crmTrainingApiBean.getTabHeading();
                fullscreen = crmTrainingApiBean.getTabFullscreen();
                if (fullscreen) {
                    selectionType = InfoTabBehavior.SelectionType.SELECTED_FULLSCREEN;
                }
            }

            return new
                    MailInfoTab(CrmConstants.ISSUE_INFO_TAB_NAME,
                    displayName,
                    context.getViewUrl(CrmConstants.ISSUE_INFO_TAB_VIEW_URL))
                    .setBehavior(new InfoTabBehavior(selectionType));
        } else {
            log.warn("MailInfoTab could not be displayed. Reason: context=null");
        }
        return null;
    }
}
