package rjw.application.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Inheritance;
import javax.persistence.Version;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="WebFile", schema="dbo", uniqueConstraints=@UniqueConstraint(columnNames= "name"))
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "file_type", discriminatorType=DiscriminatorType.STRING)
public abstract class File implements Serializable, Comparable<File> {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="uid", insertable=false, updatable=false)
	private long uid;
	
	@ManyToOne 
	@OnDelete(action=OnDeleteAction.CASCADE) // @OnDelete is a Hibernate only annotation, not in JPA specification. This will delete all dependents when parent is removed.
	private ApplicationInstance application;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private Date created;
	
	@Column(nullable=false)
	private String createdBy;
	
	@Version
	@Column(nullable=false)
	private Date modified;
	
	@Column(nullable=false)
	private String modifiedBy;
	
	@ManyToOne(optional=true) 
	private Directory parent;
	
	@Column(name = "file_type",insertable=false, updatable=false)
	private String file_type;
	
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
	
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	
	public Directory getParent() {
		return parent;
	}
	public void setParent(Directory parent) {
		this.parent = parent;
	}
	
	public String getFileType() {
		return file_type;
	}
	public void setFileType(String fileType) {
		this.file_type = fileType;
	}
	
	public String toString() {
		return String.valueOf(getUid());
	}
	
	public int compareTo(File o) {
		if (o != null) {
			return (this.getName().compareTo(o.getName()));
		}
		return 0;
	}
	public ApplicationInstance getApplication() {
		return application;
	}
	public void setApplication(ApplicationInstance application) {
		this.application = application;
	}
}
