package rjw.application.model;

import java.util.List;



import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames= {"applicationType_uid", "name"}))  // applicationType_uid is default column name given by hibernate for apptype relationship below
public class ApplicationInstance {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	protected long uid;
	
	@ManyToOne
	@OnDelete(action=OnDeleteAction.CASCADE) // @OnDelete is a Hibernate only annotation, not in JPA specification. This will delete all dependents when parent is removed.
	private ApplicationType applicationType;
	
	private String name;
	
	private String costCenter;
	
	private boolean active;
	
	private int sessionTimeout;

	public ApplicationInstance() {
		setActive(true);
	}
	
	public ApplicationInstance(String name, String costCenter, ApplicationType applicationType) {
		setName(name);
		setCostCenter(costCenter);
		setActive(true);
		setApplicationType(applicationType);
	}

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public ApplicationType getApplicationType() {
		return applicationType;
	}

	public void setApplicationType(ApplicationType applicationType) {
		this.applicationType = applicationType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getSessionTimeout() {
		return sessionTimeout;
	}

	public void setSessionTimeout(int sessionTimeout) {
		this.sessionTimeout = sessionTimeout;
	}
}
