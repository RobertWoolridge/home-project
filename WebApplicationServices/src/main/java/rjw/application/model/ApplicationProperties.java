package rjw.application.model;

import java.util.Map;
import java.util.TreeMap;

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
public class ApplicationProperties {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="uid", insertable=false, updatable=false)
	private long uid;
	
	@Column(nullable=false)
	private String name;
	
	@ManyToOne 
	@OnDelete(action=OnDeleteAction.CASCADE) // @OnDelete is a Hibernate only annotation, not in JPA specification. This will delete all dependents when parent is removed.
	private ApplicationInstance application;
	
//	@Column(nullable=false)
//	private Map<String, String> properties;

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public ApplicationInstance getApplication() {
		return application;
	}

	public void setApplication(ApplicationInstance application) {
		this.application = application;
	}

//	public Map<String, String> getProperties() {
//		if (properties == null) {
//			properties = new TreeMap<String, String>();
//		}
//		return properties;
//	}
//
//	public void setProperties(Map<String, String> properties) {
//		this.properties = properties;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
