/**
 * This file is part of mycollab-mobile.
 *
 * mycollab-mobile is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * mycollab-mobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with mycollab-mobile.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.esofthead.mycollab.mobile.module.project.view.bug;

import com.esofthead.mycollab.common.domain.CommentWithBLOBs;
import com.esofthead.mycollab.common.i18n.GenericI18Enum;
import com.esofthead.mycollab.common.service.CommentService;
import com.esofthead.mycollab.eventmanager.EventBusFactory;
import com.esofthead.mycollab.mobile.module.project.CurrentProjectVariables;
import com.esofthead.mycollab.mobile.module.project.view.settings.ProjectMemberSelectionField;
import com.esofthead.mycollab.mobile.shell.events.ShellEvent;
import com.esofthead.mycollab.mobile.ui.AbstractMobilePageView;
import com.esofthead.mycollab.mobile.ui.GridFormLayoutHelper;
import com.esofthead.mycollab.module.project.ProjectTypeConstants;
import com.esofthead.mycollab.module.project.i18n.BugI18nEnum;
import com.esofthead.mycollab.module.project.i18n.OptionI18nEnum.BugStatus;
import com.esofthead.mycollab.module.tracker.domain.BugWithBLOBs;
import com.esofthead.mycollab.module.tracker.domain.SimpleBug;
import com.esofthead.mycollab.module.tracker.service.BugService;
import com.esofthead.mycollab.spring.ApplicationContextUtil;
import com.esofthead.mycollab.vaadin.AppContext;
import com.esofthead.mycollab.vaadin.ui.AbstractBeanFieldGroupEditFieldFactory;
import com.esofthead.mycollab.vaadin.ui.AdvancedEditBeanForm;
import com.esofthead.mycollab.vaadin.ui.GenericBeanForm;
import com.esofthead.mycollab.vaadin.ui.IFormLayoutFactory;
import com.vaadin.ui.*;

import java.util.GregorianCalendar;

/**
 * 
 * @author MyCollab Ltd.
 * @since 4.5.2
 */

/*
 * TODO: Add support BugVersion when it's ready in the next version
 */

@SuppressWarnings("serial")
class ReOpenView extends AbstractMobilePageView {
	private final SimpleBug bug;
	private final EditForm editForm;
	private final BugReadView callbackForm;

	ReOpenView(final BugReadView callbackForm, final SimpleBug bug) {
		this.setCaption("Reopen ["
				+ CurrentProjectVariables.getProject().getShortname() + "-"
				+ bug.getBugkey() + "]");
		this.bug = bug;
		this.callbackForm = callbackForm;

		this.editForm = new EditForm();
		this.editForm.setBean(bug);

		constructUI();
	}

	private void constructUI() {
		VerticalLayout contentLayout = new VerticalLayout();
		contentLayout.setWidth("100%");
		contentLayout.addComponent(this.editForm);

		final Button reOpenBtn = new Button(
				AppContext.getMessage(GenericI18Enum.BUTTON_REOPEN),
				new Button.ClickListener() {
					@Override
					public void buttonClick(final Button.ClickEvent event) {

						if (editForm.validateForm()) {
							ReOpenView.this.bug.setStatus(BugStatus.ReOpened
									.name());

							// Save bug status and assignee
							final BugService bugService = ApplicationContextUtil
									.getSpringBean(BugService.class);
							bugService.updateSelectiveWithSession(
									ReOpenView.this.bug,
									AppContext.getUsername());

							// Save comment
							final String commentValue = editForm.commentArea.getValue();
							if (commentValue != null
									&& !commentValue.trim().equals("")) {
								final CommentWithBLOBs comment = new CommentWithBLOBs();
								comment.setComment(commentValue);
								comment.setCreatedtime(new GregorianCalendar()
										.getTime());
								comment.setCreateduser(AppContext.getUsername());
								comment.setSaccountid(AppContext.getAccountId());
								comment.setType(ProjectTypeConstants.BUG);
								comment.setTypeid("" + bug.getId());
								comment.setExtratypeid(CurrentProjectVariables
										.getProjectId());

								final CommentService commentService = ApplicationContextUtil
										.getSpringBean(CommentService.class);
								commentService.saveWithSession(comment,
										AppContext.getUsername());
							}
							ReOpenView.this.callbackForm.previewItem(bug);
							EventBusFactory.getInstance().post(
									new ShellEvent.NavigateBack(this, null));
						}

					}
				});
		reOpenBtn.setStyleName("save-btn");
		this.setRightComponent(reOpenBtn);

		this.setContent(contentLayout);
	}

	private static class EditForm extends AdvancedEditBeanForm<BugWithBLOBs> {
		private static final long serialVersionUID = 1L;
		private TextArea commentArea;

		public EditForm() {
			this.addStyleName("editview-layout");
		}

		@Override
		public void setBean(final BugWithBLOBs newDataSource) {
			this.setFormLayoutFactory(new FormLayoutFactory());
			this.setBeanFormFieldFactory(new EditFormFieldFactory(EditForm.this));
			super.setBean(newDataSource);
		}

		static class FormLayoutFactory implements IFormLayoutFactory {
			private static final long serialVersionUID = 1L;
			private GridFormLayoutHelper informationLayout;

			@Override
			public ComponentContainer getLayout() {
				this.informationLayout = new GridFormLayoutHelper(1, 3, "100%",
						"140px", Alignment.TOP_LEFT);
				this.informationLayout.getLayout().setWidth("100%");
				this.informationLayout.getLayout().setMargin(false);

				return informationLayout.getLayout();
			}

			@Override
			public void attachField(final Object propertyId,
					final Field<?> field) {
				if (propertyId.equals("resolution")) {
					this.informationLayout.addComponent(field,
							AppContext.getMessage(BugI18nEnum.FORM_RESOLUTION),
							0, 0);
				} else if (propertyId.equals("assignuser")) {
					this.informationLayout
							.addComponent(field, AppContext
									.getMessage(GenericI18Enum.FORM_ASSIGNEE),
									0, 1);
				} else if (propertyId.equals("comment")) {
					this.informationLayout.addComponent(field,
							AppContext.getMessage(BugI18nEnum.FORM_COMMENT), 0,
							2);
				}
			}
		}

		private class EditFormFieldFactory extends AbstractBeanFieldGroupEditFieldFactory<BugWithBLOBs> {
			private static final long serialVersionUID = 1L;

			public EditFormFieldFactory(GenericBeanForm<BugWithBLOBs> form) {
				super(form);
			}

			@Override
			protected Field<?> onCreateField(final Object propertyId) {
				if (propertyId.equals("resolution")) {
					return BugResolutionComboBox.getInstanceForValidBugWindow();
				} else if (propertyId.equals("assignuser")) {
					return new ProjectMemberSelectionField();
				} else if (propertyId.equals("comment")) {
					EditForm.this.commentArea = new TextArea();
					EditForm.this.commentArea.setNullRepresentation("");
					return EditForm.this.commentArea;
				}

				return null;
			}
		}
	}
}
