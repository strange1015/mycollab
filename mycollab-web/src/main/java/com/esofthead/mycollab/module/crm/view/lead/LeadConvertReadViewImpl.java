/**
 * This file is part of mycollab-web.
 *
 * mycollab-web is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * mycollab-web is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with mycollab-web.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.esofthead.mycollab.module.crm.view.lead;

import com.esofthead.mycollab.common.i18n.GenericI18Enum;
import com.esofthead.mycollab.core.arguments.NumberSearchField;
import com.esofthead.mycollab.core.arguments.SearchField;
import com.esofthead.mycollab.core.arguments.StringSearchField;
import com.esofthead.mycollab.eventmanager.EventBusFactory;
import com.esofthead.mycollab.module.crm.CrmTypeConstants;
import com.esofthead.mycollab.module.crm.domain.*;
import com.esofthead.mycollab.module.crm.domain.criteria.ActivitySearchCriteria;
import com.esofthead.mycollab.module.crm.events.AccountEvent;
import com.esofthead.mycollab.module.crm.events.ContactEvent;
import com.esofthead.mycollab.module.crm.events.OpportunityEvent;
import com.esofthead.mycollab.module.crm.i18n.LeadI18nEnum;
import com.esofthead.mycollab.module.crm.service.AccountService;
import com.esofthead.mycollab.module.crm.service.ContactService;
import com.esofthead.mycollab.module.crm.service.OpportunityService;
import com.esofthead.mycollab.module.crm.ui.CrmAssetsManager;
import com.esofthead.mycollab.module.crm.ui.components.*;
import com.esofthead.mycollab.module.crm.view.activity.ActivityRelatedItemListComp;
import com.esofthead.mycollab.schedule.email.crm.LeadRelayEmailNotificationAction;
import com.esofthead.mycollab.security.RolePermissionCollections;
import com.esofthead.mycollab.spring.ApplicationContextUtil;
import com.esofthead.mycollab.vaadin.AppContext;
import com.esofthead.mycollab.vaadin.events.HasPreviewFormHandlers;
import com.esofthead.mycollab.vaadin.mvp.ViewComponent;
import com.esofthead.mycollab.vaadin.ui.*;
import com.esofthead.mycollab.vaadin.ui.grid.GridFormLayoutHelper;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.vaadin.maddon.layouts.MVerticalLayout;

import static com.esofthead.mycollab.module.crm.ui.components.CrmPreviewFormControlsGenerator.BACK_BTN_PRESENTED;
import static com.esofthead.mycollab.module.crm.ui.components.CrmPreviewFormControlsGenerator.NAVIGATOR_BTN_PRESENTED;

/**
 *
 * @author MyCollab Ltd.
 * @since 3.0
 *
 */
@ViewComponent
public class LeadConvertReadViewImpl extends AbstractPreviewItemComp<SimpleLead> implements LeadConvertReadView {
    private static final long serialVersionUID = 1L;

    private static final Logger LOG = LoggerFactory.getLogger(LeadConvertReadViewImpl.class);

    private LeadCampaignListComp associateCampaignList;
    private ActivityRelatedItemListComp associateActivityList;
    private CrmCommentDisplay commentList;
    private LeadHistoryLogList historyLogList;

    private PeopleInfoComp peopleInfoComp;
    private DateInfoComp dateInfoComp;

    public LeadConvertReadViewImpl() {
        super(CrmAssetsManager.getAsset(CrmTypeConstants.LEAD));
    }

    @Override
    protected AdvancedPreviewBeanForm<SimpleLead> initPreviewForm() {
        return new AdvancedPreviewBeanForm<>();
    }

    @Override
    protected ComponentContainer createButtonControls() {
        CrmPreviewFormControlsGenerator<SimpleLead> controlsButton = new CrmPreviewFormControlsGenerator<>(
                previewForm);
        return controlsButton.createButtonControls(BACK_BTN_PRESENTED
                | NAVIGATOR_BTN_PRESENTED, RolePermissionCollections.CRM_LEAD);
    }

    @Override
    protected ComponentContainer createBottomPanel() {
        TabSheetLazyLoadComponent tabTaskDetail = new TabSheetLazyLoadComponent();
        tabTaskDetail.addTab(commentList, AppContext.getMessage(GenericI18Enum.TAB_COMMENT, 0), FontAwesome.COMMENTS);
        tabTaskDetail.addTab(historyLogList, AppContext.getMessage(GenericI18Enum.TAB_HISTORY), FontAwesome.HISTORY);
        return tabTaskDetail;
    }

    @Override
    public void previewItem(SimpleLead item) {
        this.beanItem = item;
        previewLayout.setTitle(initFormTitle());
        displayConvertLeadInfo(item);

        onPreviewItem();
    }

    @Override
    protected void onPreviewItem() {
        commentList.loadComments("" + beanItem.getId());
        historyLogList.loadHistory(beanItem.getId());
        displayActivities();
        displayCampaigns();

        dateInfoComp.displayEntryDateTime(beanItem);
        peopleInfoComp.displayEntryPeople(beanItem);

        previewItemContainer.selectTab(CrmTypeConstants.DETAIL);
    }

    @Override
    protected String initFormTitle() {
        return AppContext.getMessage(LeadI18nEnum.VIEW_CONVERTED_LEAD_TITLE);
    }

    @Override
    protected void initRelatedComponents() {
        associateCampaignList = new LeadCampaignListComp();

        commentList = new CrmCommentDisplay(CrmTypeConstants.LEAD, LeadRelayEmailNotificationAction.class);
        historyLogList = new LeadHistoryLogList();
        associateActivityList = new ActivityRelatedItemListComp(false);

        CssLayout navigatorWrapper = previewItemContainer.getNavigatorWrapper();
        MVerticalLayout basicInfo = new MVerticalLayout().withWidth("100%").withStyleName("basic-info");

        dateInfoComp = new DateInfoComp();
        basicInfo.addComponent(dateInfoComp);

        peopleInfoComp = new PeopleInfoComp();
        basicInfo.addComponent(peopleInfoComp);

        navigatorWrapper.addComponentAsFirst(basicInfo);

        previewItemContainer.addTab(previewContent, CrmTypeConstants.DETAIL, "About");
        previewItemContainer.addTab(associateCampaignList, CrmTypeConstants.CAMPAIGN,
                "Campaigns");
        previewItemContainer.addTab(associateActivityList, CrmTypeConstants.ACTIVITY,
                "Activities");
    }

    @Override
    protected IFormLayoutFactory initFormLayoutFactory() {
        return new DynaFormLayout(CrmTypeConstants.LEAD,
                LeadDefaultDynaFormLayoutFactory.getForm());
    }

    @Override
    protected AbstractBeanFieldGroupViewFieldFactory<SimpleLead> initBeanFormFieldFactory() {
        return new LeadReadFormFieldFactory(previewForm);
    }

    protected void displayCampaigns() {
        associateCampaignList.displayCampaigns(beanItem);
    }


    protected void displayActivities() {
        ActivitySearchCriteria criteria = new ActivitySearchCriteria();
        criteria.setSaccountid(new NumberSearchField(AppContext.getAccountId()));
        criteria.setType(new StringSearchField(SearchField.AND,
                CrmTypeConstants.LEAD));
        criteria.setTypeid(new NumberSearchField(beanItem.getId()));
        associateActivityList.setSearchCriteria(criteria);
    }

    @Override
    public SimpleLead getItem() {
        return beanItem;
    }

    @Override
    public HasPreviewFormHandlers<SimpleLead> getPreviewFormHandlers() {
        return previewForm;
    }

    @Override
    public IRelatedListHandlers<SimpleActivity> getRelatedActivityHandlers() {
        return associateActivityList;
    }

    @Override
    public IRelatedListHandlers<SimpleCampaign> getRelatedCampaignHandlers() {
        return associateCampaignList;
    }

    @Override
    public void displayConvertLeadInfo(final SimpleLead lead) {
        previewForm.removeAllComponents();

        Label header = new Label("Conversion Details");
        header.addStyleName("h2");
        previewForm.addComponent(header);

        GridFormLayoutHelper layoutHelper = new GridFormLayoutHelper(1, 3);
        layoutHelper.getLayout().setWidth("100%");
        layoutHelper.getLayout().setMargin(false);
        layoutHelper.getLayout().addStyleName("colored-gridlayout");

        LOG.debug("Display associate account");
        AccountService accountService = ApplicationContextUtil
                .getSpringBean(AccountService.class);
        final SimpleAccount account = accountService.findAccountAssoWithConvertedLead(lead.getId(),
                        AppContext.getAccountId());
        if (account != null) {
            Button accountLink = new Button(account.getAccountname(),
                    new Button.ClickListener() {
                        private static final long serialVersionUID = 1L;

                        @Override
                        public void buttonClick(ClickEvent event) {
                            EventBusFactory.getInstance().post(
                                    new AccountEvent.GotoRead(this, account.getId()));

                        }
                    });
            accountLink.setIcon(CrmAssetsManager.getAsset(CrmTypeConstants.ACCOUNT));
            accountLink.setStyleName("link");
            layoutHelper.addComponent(accountLink, "Account", 0, 0);
        } else {
            layoutHelper.addComponent(new Label(""), "Account", 0, 0);
        }

        LOG.debug("Display associate contact");
        ContactService contactService = ApplicationContextUtil
                .getSpringBean(ContactService.class);
        final SimpleContact contact = contactService
                .findContactAssoWithConvertedLead(lead.getId(),
                        AppContext.getAccountId());
        if (contact != null) {
            Button contactLink = new Button(contact.getContactName(),
                    new Button.ClickListener() {
                        private static final long serialVersionUID = 1L;

                        @Override
                        public void buttonClick(ClickEvent event) {
                            EventBusFactory.getInstance().post(
                                    new ContactEvent.GotoRead(this, contact.getId()));

                        }
                    });
            contactLink.setIcon(CrmAssetsManager.getAsset(CrmTypeConstants.CONTACT));
            contactLink.setStyleName("link");
            layoutHelper.addComponent(contactLink, "Contact", 0, 1);
        } else {
            layoutHelper.addComponent(new Label(""), "Contact", 0, 1);
        }

        LOG.debug("Display associate opportunity");
        OpportunityService opportunityService = ApplicationContextUtil
                .getSpringBean(OpportunityService.class);
        final SimpleOpportunity opportunity = opportunityService
                .findOpportunityAssoWithConvertedLead(lead.getId(),
                        AppContext.getAccountId());
        if (opportunity != null) {
            Button opportunityLink = new Button(opportunity.getOpportunityname(),
                    new Button.ClickListener() {
                        private static final long serialVersionUID = 1L;

                        @Override
                        public void buttonClick(ClickEvent event) {
                            EventBusFactory.getInstance().post(
                                    new OpportunityEvent.GotoRead(this, opportunity.getId()));

                        }
                    });
            opportunityLink.setIcon(CrmAssetsManager.getAsset(CrmTypeConstants.OPPORTUNITY));
            opportunityLink.setStyleName("link");
            layoutHelper.addComponent(opportunityLink, "Opportunity", 0, 2);
        } else {
            layoutHelper.addComponent(new Label(""), "Opportunity", 0, 2);
        }

        previewForm.addComponent(layoutHelper.getLayout());
        previewLayout.addBody(previewContent);

        this.addComponent(previewItemContainer);
    }
}
