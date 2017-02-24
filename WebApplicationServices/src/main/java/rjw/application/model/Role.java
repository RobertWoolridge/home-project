package rjw.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames= {"application_uid", "name"}))  // application_uid is default column name given by hibernate for app relationship below
public class Role {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="uid", insertable=false, updatable=false)
	private long uid;
	
	@Column(nullable=false)
	private String name;
	
	@ManyToOne 
	@OnDelete(action=OnDeleteAction.CASCADE) // @OnDelete is a Hibernate only annotation, not in JPA specification. This will delete all dependents when parent is removed.
	private ApplicationInstance application;
	
	@ManyToOne
	private Role parent;

	private boolean deletable;
	
	public Role(String name, ApplicationInstance application) {
		setName(name);
		setApplication(application);
	}

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ApplicationInstance getApplication() {
		return application;
	}

	public void setApplication(ApplicationInstance application) {
		this.application = application;
	}

	public Role getParent() {
		return parent;
	}

	public void setParent(Role parent) {
		this.parent = parent;
	}

	public boolean isDeletable() {
		return deletable;
	}

	public void setDeletable(boolean deletable) {
		this.deletable = deletable;
	}
}
