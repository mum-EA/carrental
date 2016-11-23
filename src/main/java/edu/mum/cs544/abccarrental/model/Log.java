package edu.mum.cs544.abccarrental.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Log {

	@Id
	@SequenceGenerator(name = "logSequence", sequenceName = "logSequence")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "logSequence")
	private int logId;
	private String user;
	@Temporal(TemporalType.TIMESTAMP)
	private Date timeStamp;
	
	
}
