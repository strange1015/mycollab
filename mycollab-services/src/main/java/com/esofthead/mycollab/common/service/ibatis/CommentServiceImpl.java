/**
 * This file is part of mycollab-services.
 *
 * mycollab-services is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * mycollab-services is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with mycollab-services.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.esofthead.mycollab.common.service.ibatis;

import com.esofthead.mycollab.cache.CacheUtils;
import com.esofthead.mycollab.common.ActivityStreamConstants;
import com.esofthead.mycollab.common.ModuleNameConstants;
import com.esofthead.mycollab.common.MonitorTypeConstants;
import com.esofthead.mycollab.common.dao.CommentMapper;
import com.esofthead.mycollab.common.dao.CommentMapperExt;
import com.esofthead.mycollab.common.domain.ActivityStreamWithBLOBs;
import com.esofthead.mycollab.common.domain.CommentWithBLOBs;
import com.esofthead.mycollab.common.domain.RelayEmailNotificationWithBLOBs;
import com.esofthead.mycollab.common.domain.criteria.CommentSearchCriteria;
import com.esofthead.mycollab.common.service.ActivityStreamService;
import com.esofthead.mycollab.common.service.CommentService;
import com.esofthead.mycollab.common.service.RelayEmailNotificationService;
import com.esofthead.mycollab.core.persistence.ICrudGenericDAO;
import com.esofthead.mycollab.core.persistence.ISearchableDAO;
import com.esofthead.mycollab.core.persistence.service.DefaultService;
import com.esofthead.mycollab.core.utils.BeanUtility;
import com.esofthead.mycollab.module.project.ProjectTypeConstants;
import com.esofthead.mycollab.module.project.service.MessageService;
import com.esofthead.mycollab.module.project.service.ProjectActivityStreamService;
import com.esofthead.mycollab.schedule.email.SendingRelayEmailNotificationAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author MyCollab Ltd.
 * @since 1.0
 */
@Service
public class CommentServiceImpl extends
        DefaultService<Integer, CommentWithBLOBs, CommentSearchCriteria> implements
        CommentService {

    private static final Logger LOG = LoggerFactory.getLogger(CommentServiceImpl.class);

    @Autowired
    protected CommentMapper commentMapper;

    @Autowired
    protected CommentMapperExt commentMapperExt;

    @Autowired
    private RelayEmailNotificationService relayEmailNotificationService;

    @Autowired
    private ActivityStreamService activityStreamService;

    @Override
    public ICrudGenericDAO<Integer, CommentWithBLOBs> getCrudMapper() {
        return commentMapper;
    }

    @Override
    public ISearchableDAO<CommentSearchCriteria> getSearchMapper() {
        return commentMapperExt;
    }

    @Override
    public Integer saveWithSession(CommentWithBLOBs record, String username) {
        return this.saveWithSession(record, username, null);
    }

    @Override
    public Integer saveWithSession(CommentWithBLOBs record, String username,
                               Class<? extends SendingRelayEmailNotificationAction> emailHandler) {
        Integer saveId = super.saveWithSession(record, username);

        if (ProjectTypeConstants.MESSAGE.equals(record.getType())) {
            CacheUtils
                    .cleanCaches(record.getSaccountid(), MessageService.class);
        }

        relayEmailNotificationService.saveWithSession(
                getRelayEmailNotification(record, username,
                        emailHandler), username);

        activityStreamService.saveWithSession(
                getActivityStream(record, username), username);

        return saveId;
    }

    private ActivityStreamWithBLOBs getActivityStream(CommentWithBLOBs record, String username) {
        ActivityStreamWithBLOBs activityStream = new ActivityStreamWithBLOBs();
        activityStream.setAction(ActivityStreamConstants.ACTION_COMMENT);
        activityStream.setCreateduser(username);
        activityStream.setSaccountid(record.getSaccountid());
        activityStream.setType(record.getType());
        activityStream.setTypeid(record.getTypeid());
        activityStream.setNamefield(record.getComment());
        activityStream.setExtratypeid(record.getExtratypeid());
        if (record.getType() != null && record.getType().startsWith("Project-")) {
            activityStream.setModule(ModuleNameConstants.PRJ);
            CacheUtils.cleanCaches(record.getSaccountid(),
                    ProjectActivityStreamService.class);
        } else if (record.getType() != null
                && record.getType().startsWith("Crm-")) {
            activityStream.setModule(ModuleNameConstants.CRM);
        } else {
            LOG.error("Can not define module type of bean {}",
                    BeanUtility.printBeanObj(record));
        }
        return activityStream;
    }

    private RelayEmailNotificationWithBLOBs getRelayEmailNotification(CommentWithBLOBs record,
                                                                      String username,
                                                                      Class<? extends SendingRelayEmailNotificationAction> emailHandler) {
        RelayEmailNotificationWithBLOBs relayEmailNotification = new RelayEmailNotificationWithBLOBs();
        relayEmailNotification.setSaccountid(record.getSaccountid());
        relayEmailNotification
                .setAction(MonitorTypeConstants.ADD_COMMENT_ACTION);
        relayEmailNotification.setChangeby(record.getCreateduser());
        relayEmailNotification.setChangecomment(record.getComment());
        relayEmailNotification.setType(record.getType());
        relayEmailNotification.setTypeid(record.getTypeid());
        if (emailHandler != null) {
            relayEmailNotification.setEmailhandlerbean(emailHandler.getName());
        }
        relayEmailNotification.setExtratypeid(record.getExtratypeid());
        return relayEmailNotification;
    }
}