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

import java.util.Arrays;
import java.util.Collection;

import com.esofthead.mycollab.common.TableViewField;
import com.esofthead.mycollab.vaadin.ui.table.AbstractPagedBeanTable;
import com.esofthead.mycollab.vaadin.ui.table.CustomizedTableWindow;

/**
 * 
 * @author MyCollab Ltd.
 * @since 1.0
 * 
 */
public class LeadListCustomizeWindow extends CustomizedTableWindow {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	public LeadListCustomizeWindow(String viewId, AbstractPagedBeanTable table) {
		super(viewId, table);
	}

	@Override
	protected Collection<TableViewField> getAvailableColumns() {
		return Arrays.asList(LeadTableFieldDef.accountName(),
				LeadTableFieldDef.assignedUser(), LeadTableFieldDef.department(),
				LeadTableFieldDef.email(), LeadTableFieldDef.phoneoffice(),
				LeadTableFieldDef.fax(), LeadTableFieldDef.industry(),
				LeadTableFieldDef.leadSource(), LeadTableFieldDef.mobile(),
				LeadTableFieldDef.name(), LeadTableFieldDef.status(),
				LeadTableFieldDef.title(), LeadTableFieldDef.website());
	}

}
