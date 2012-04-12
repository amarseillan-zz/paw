package transfer.forms;


import javax.servlet.http.HttpServletRequest;

import transfer.bussiness.Visit;

public class VisitForm {

	private HttpServletRequest req;

	public VisitForm(HttpServletRequest req) {
		this.req = req;
	}

	public Visit toBussiness(){
		return new Visit(req.getParameter("name"),req.getParameter("email"),req.getParameter("phone"),req.getParameter("comment"));
	}

	public String getName() {
		return req.getParameter("name");
	}

	public String getEmail() {
		return req.getParameter("email");
	}

	public String getPhone() {
		return req.getParameter("phone");
	}

	public String getComment() {
		return req.getParameter("comment");
	}

}
