/**
 * This file is part of mycollab-servlet.
 *
 * mycollab-servlet is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * mycollab-servlet is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with mycollab-servlet.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.esofthead.mycollab.servlet;

import com.esofthead.mycollab.configuration.SiteConfiguration;
import com.esofthead.mycollab.i18n.LocalizationHelper;
import com.esofthead.mycollab.template.velocity.TemplateContext;
import com.esofthead.mycollab.template.velocity.TemplateEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author MyCollab Ltd.
 * @since 1.0
 * 
 */
@WebServlet(urlPatterns = "/error", name = "appExceptionHandlerServlet")
public class AppExceptionHandler extends GenericHttpServlet {
	private static final Logger LOG = LoggerFactory.getLogger(AppExceptionHandler.class);

	@Autowired
	private TemplateEngine templateEngine;

	@Override
	protected void onHandleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Integer status_code = (Integer) request
				.getAttribute("javax.servlet.error.status_code");
		String requestUri = (String) request
				.getAttribute("javax.servlet.error.request_uri");
		if (requestUri == null) {
			requestUri = "Unknown";
		}

		try {
			if ((status_code != null && status_code == 404) || ("404".equals(request.getParameter("param")))) {
				responsePage404(response);
			} else {
				responsePage500(response);
			}

			// Analyze the servlet exception
			Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
			if (throwable != null) {
				LOG.error("Error in servlet " + requestUri, throwable);
			}

		} catch (Exception e) {
			LOG.error("Error in servlet", e);
		}
	}

	private void responsePage404(HttpServletResponse response) throws IOException {
		String pageNotFoundTemplate = "templates/page/404Page.mt";
		TemplateContext context = new TemplateContext();

		Reader reader = LocalizationHelper.templateReader(pageNotFoundTemplate, response.getLocale());

		Map<String, String> defaultUrls = new HashMap<>();

		defaultUrls.put("cdn_url", SiteConfiguration.getCdnUrl());
		defaultUrls.put("app_url", SiteConfiguration.getAppUrl());
		context.put("defaultUrls", defaultUrls);

		StringWriter writer = new StringWriter();
		templateEngine.evaluate(context, writer, "log task", reader);

		String html = writer.toString();
		PrintWriter out = response.getWriter();
		out.println(html);
	}

	private void responsePage500(HttpServletResponse response) throws IOException {
		String errorPage = "templates/page/500Page.mt";
		TemplateContext context = new TemplateContext();

		Reader reader = LocalizationHelper.templateReader(errorPage,
				response.getLocale());
		Map<String, String> defaultUrls = new HashMap<>();

		defaultUrls.put("cdn_url", SiteConfiguration.getCdnUrl());
		defaultUrls.put("app_url", SiteConfiguration.getAppUrl());
		context.put("defaultUrls", defaultUrls);

		StringWriter writer = new StringWriter();
		templateEngine.evaluate(context, writer, "log task", reader);

		String html = writer.toString();
		PrintWriter out = response.getWriter();
		out.println(html);
	}
}
