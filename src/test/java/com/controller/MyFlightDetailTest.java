package com.controller;

import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.exception.DatabaseException;

import dao.FlightDao;
@RunWith(PowerMockRunner.class)
@PrepareForTest({FlightDao.class,AddFlightDetail.class})
public class MyFlightDetailTest {

	static AddFlightDetail controller;
	@Mock HttpServletRequest request;
	@Mock HttpServletResponse response;
	@Mock RequestDispatcher dispatcher;
	@Mock HttpSession session;
	@BeforeClass
	public static void init() {
		controller= new AddFlightDetail();
	}
	
	@Test
	public void testDoPost() throws ServletException, IOException, DatabaseException {
		PowerMockito.when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
		PowerMockito.mockStatic(FlightDao.class);
		PowerMockito.when(FlightDao.insertFlight(anyObject())).thenReturn(11);
		PowerMockito.when(request.getSession(anyBoolean())).thenReturn(session);
		controller.doPost(request, response);
	//	verify(dispatcher,Mockito.atLeastOnce()).forward(request, response);
		verify(dispatcher).forward(request, response);
	}
}
