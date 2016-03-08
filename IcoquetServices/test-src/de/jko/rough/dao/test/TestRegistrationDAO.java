package de.jko.rough.dao.test;

import org.junit.Test;

import de.jko.icoquet.dao.RegisterDAO;
import de.jko.icoquet.service.data.Registration;

public class TestRegistrationDAO
{
	@Test
	public void testRegistration()
	{
		RegisterDAO dao = new RegisterDAO();
		Registration registration = new Registration("juppzupp", "jupp.zupp@yahoo.ed", "secret", "secret");
		dao.registerUser(registration);
	}
}
