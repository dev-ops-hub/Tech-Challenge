package com.thales.airlab.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * Function as a EntityObject mapped to a database table.The @Id annotation specifies the primary key
 * of an entity and the @GeneratedValue provides for the specification of generation strategies for the
 * values of primary keys.
 *
 * Usage:
 *
 * 		QueryForm form = QueryForm( .. );
 *
 * @author Alex
 *
 * */

@Entity
public class QueryForm {

	@Id
	@GeneratedValue
	private Integer id;

	private String email;

	private String topic;

	private String message;

	//Default Constructor.
	protected QueryForm() {
	}

	//Constructor
	public QueryForm(String email, String topic, String message) {
		this.email = email;
		this.topic = topic;
		this.message = message;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	 @Override
	 public String toString() {

	        StringBuilder builder = new StringBuilder();
	        builder.append("email{email=").append(email).append(", topic=")
	                .append(topic).append('"')
	                .append(message).append("}");
	        return builder.toString();
	 }

}
