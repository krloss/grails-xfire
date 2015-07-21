package org.grails.xfire;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessResourceFailureException;

public class OpenSessionInViewFilter extends
	org.springframework.orm.hibernate4.support.OpenSessionInViewFilter {

	protected void closeSession(Session arg0, SessionFactory arg1) {
		arg0.flush();
		arg0.close();
	}

	protected Session getSession(SessionFactory arg0) throws DataAccessResourceFailureException {
		Session session = super.openSession(arg0);
		session.setFlushMode(FlushMode.AUTO);
		return session;
	}
}
