package zonaProp.transfer.forms;


import javax.servlet.http.HttpServletRequest;

import zonaProp.transfer.bussiness.Comment;

@Deprecated
public class VisitForm {

	private HttpServletRequest req;

	public VisitForm(HttpServletRequest req) {
		this.req = req;
	}

	public Comment toBussiness(){
		return new Comment(req.getParameter("name"),req.getParameter("email"),req.getParameter("phone"),req.getParameter("comment"));
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
