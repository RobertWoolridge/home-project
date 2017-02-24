package rjw.application.model;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;




@Entity
@DiscriminatorValue("DIR")
public class Directory extends File {

	
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<File> children;

	public Directory() {
	}
	
	public Set<File> getChildren() {
		if (children == null) {
			children = new TreeSet<File>();
		}
		return children;
	}

	public void setChildren(Set<File> children) {
		this.children = children;
	}

}
