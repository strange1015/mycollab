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
package com.esofthead.mycollab.module.project.view.bug;

import com.esofthead.mycollab.core.MyCollabException;
import com.esofthead.mycollab.core.arguments.NumberSearchField;
import com.esofthead.mycollab.module.project.CurrentProjectVariables;
import com.esofthead.mycollab.module.project.i18n.BugI18nEnum;
import com.esofthead.mycollab.module.project.view.parameters.BugFilterParameter;
import com.esofthead.mycollab.module.project.view.parameters.BugScreenData;
import com.esofthead.mycollab.module.tracker.domain.criteria.BugSearchCriteria;
import com.esofthead.mycollab.vaadin.AppContext;
import com.esofthead.mycollab.vaadin.mvp.PresenterResolver;
import com.esofthead.mycollab.vaadin.mvp.ScreenData;
import com.esofthead.mycollab.vaadin.ui.AbstractPresenter;
import com.vaadin.ui.ComponentContainer;

/**
 * @author MyCollab Ltd.
 * @since 1.0
 */
public class BugPresenter extends AbstractPresenter<BugContainer> {
    private static final long serialVersionUID = 1L;

    public BugPresenter() {
        super(BugContainer.class);
    }

    @Override
    public void go(ComponentContainer container, ScreenData<?> data) {
        super.go(container, data, false);
    }

    @Override
    protected void onGo(ComponentContainer container, ScreenData<?> data) {
        TrackerContainer trackerContainer = (TrackerContainer) container;
        trackerContainer.gotoSubView(AppContext.getMessage(BugI18nEnum.TAB_BUG));

        view.removeAllComponents();

        AbstractPresenter<?> presenter;

        if (data instanceof BugScreenData.Add
                || data instanceof BugScreenData.Edit) {
            presenter = PresenterResolver.getPresenter(BugAddPresenter.class);
        } else if (data instanceof BugScreenData.Read) {
            presenter = PresenterResolver.getPresenter(BugReadPresenter.class);
        } else if (data == null || data instanceof BugScreenData.Search) {
            BugSearchCriteria criteria = new BugSearchCriteria();
            criteria.setProjectId(new NumberSearchField(CurrentProjectVariables
                    .getProjectId()));
            data = new BugScreenData.Search(new BugFilterParameter("All Bugs",
                    criteria));
            presenter = PresenterResolver.getPresenter(BugListPresenter.class);
        } else {
            throw new MyCollabException("Do not support screen data");
        }

        presenter.go(view, data);
    }

}
