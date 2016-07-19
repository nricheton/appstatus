package net.sf.appstatus.web.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import net.sf.appstatus.core.AppStatus;
import net.sf.appstatus.web.IPage;
import net.sf.appstatus.web.StatusWebHandler;

public class RadiatorTest {

	/**
	 * https://sourceforge.net/apps/mantisbt/appstatus/view.php?id=70
	 *
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	@Test
	public void testNoBatchs() throws UnsupportedEncodingException, IOException {

		final AppStatus appStatus = new AppStatus();

		final StatusWebHandler statusWeb = new StatusWebHandler();
		statusWeb.setAppStatus(appStatus);
		statusWeb.setApplicationName("test");
		final Map<String, IPage> pages = new HashMap<String, IPage>();
		final RadiatorPage page = new RadiatorPage();
		pages.put(page.getId(), page);
		statusWeb.setPages(pages);
		statusWeb.init();

		final HttpServletRequest servlet = Mockito.mock(HttpServletRequest.class);
		final HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
		final HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
		final Writer responseWriter = new StringWriter();
		Mockito.when(response.getWriter()).thenReturn(new PrintWriter(responseWriter));
		page.doGet(statusWeb, request, response);

		Assert.assertTrue(responseWriter.toString().contains("btn-success"));
	}

	@Test
	public void testMaintenance() throws UnsupportedEncodingException, IOException {

		final AppStatus appStatus = new AppStatus();

		// Maintenance is on
		appStatus.setMaintenance(true);

		final StatusWebHandler statusWeb = new StatusWebHandler();
		statusWeb.setAppStatus(appStatus);
		statusWeb.setApplicationName("test");
		final Map<String, IPage> pages = new HashMap<String, IPage>();
		final RadiatorPage page = new RadiatorPage();
		pages.put(page.getId(), page);
		statusWeb.setPages(pages);
		statusWeb.init();

		final HttpServletRequest servlet = Mockito.mock(HttpServletRequest.class);
		final HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
		final HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

		final Writer responseWriter = new StringWriter();
		Mockito.when(response.getWriter()).thenReturn(new PrintWriter(responseWriter));

		page.doGet(statusWeb, request, response);

		Assert.assertTrue(responseWriter.toString().contains("btn-info"));

	}

}
