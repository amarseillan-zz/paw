package zonaProp.model.publication;

import java.util.List;

public class ResultPage {
	List<Publication> publications;
	Long total;
	int pageSize;
	
	public ResultPage(List<Publication> publications, Long total, int pageSize) {
		super();
		this.publications = publications;
		this.total = total;
		this.pageSize = pageSize;
	}

	public List<Publication> getPublications() {
		return publications;
	}

	public int getPages() {
		return (int)(total/pageSize+((total%pageSize==0)?0:1));
	}	
	
}
