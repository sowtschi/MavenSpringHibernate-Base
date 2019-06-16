package com.steve.hibernate.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "version")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)

public class Version implements Serializable {

	private static final long serialVersionUID = -6757891519740438993L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vId;

	@NotBlank
	private String versionsTitle;

	@OneToMany(cascade = CascadeType.ALL)
	private List<QuestionVersionMapping> questionVersionMapping;

//	@Column(nullable = false, updatable = false)
//	@Temporal(TemporalType.TIMESTAMP)
//	@CreatedDate
//	private Date createdAt;
//
//	@Column(nullable = false)
//	@Temporal(TemporalType.TIMESTAMP)
//	@LastModifiedDate
//	private Date updatedAt;

	public String getVersionsTitle() {
		return versionsTitle;
	}

	public void setVersionsTitle(String versionsTitle) {
		this.versionsTitle = versionsTitle;
	}

	public Long getvId() {
		return vId;
	}

	public void setvId(Long vId) {
		this.vId = vId;
	}

}