package com.demo.am.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Model implements Serializable {
	
	
    private static final long serialVersionUID = 1L;

//    @Column(name = "created_by")
//    private Long createdBy;
//
//    @CreatedDate
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "created_date", nullable = false, updatable = false)
//    private Date createdDate;
//
//    @Column(name = "modified_by")
//    private Long modifiedBy;
//
//    @LastModifiedDate
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "modified_date", nullable = false)
//    private Date modifiedDate;

    @Column(name = "status", columnDefinition = "SMALLINT")
    private Boolean Status;

}
