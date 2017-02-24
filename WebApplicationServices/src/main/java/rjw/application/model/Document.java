package rjw.application.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import rjw.application.model.File;


@Entity
@DiscriminatorValue("DOC")
public class Document extends File {

	private static final long serialVersionUID = 1L;
	
	private String title;
	private String type;
	private String keywords;
	private String author;
	private String category;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
}
