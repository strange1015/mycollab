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
package com.esofthead.mycollab.module.project.view.bug.components;

import com.esofthead.mycollab.module.project.i18n.BugI18nEnum;
import com.esofthead.mycollab.module.project.view.bug.BugDisplayWidget;
import com.esofthead.mycollab.module.project.view.parameters.BugFilterParameter;
import com.esofthead.mycollab.vaadin.AppContext;

/**
 * 
 * @author MyCollab Ltd.
 * @since 1.0
 * 
 */
public class MyBugListWidget extends BugDisplayWidget {
	private static final long serialVersionUID = 1L;

	public MyBugListWidget() {
		super(AppContext.getMessage(BugI18nEnum.WIDGET_MY_OPEN_BUGS_TITLE),
				true, BugRowDisplayHandler.class);
	}

	@Override
	protected BugFilterParameter constructMoreDisplayFilter() {
		return new BugFilterParameter(AppContext.getMessage(BugI18nEnum.WIDGET_MY_BUGS_TITLE),
				searchCriteria);
	}
}
