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
package com.esofthead.mycollab.vaadin.ui;

import com.esofthead.mycollab.vaadin.AppContext;
import com.vaadin.ui.Button;

/**
 * 
 * @author MyCollab Ltd.
 * @since 4.3.3
 *
 */
public class ButtonI18nComp extends Button {
	private static final long serialVersionUID = 1L;

	private String key;

	public ButtonI18nComp(String key, Enum<?> caption, Button.ClickListener listener) {
		this.key = key;
		this.setCaption(AppContext.getMessage(caption));
		this.addClickListener(listener);
	}

	public String getKey() {
		return key;
	}
}
