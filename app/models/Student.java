package models;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

import play.db.ebean.Model;

@Entity
public class Student extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	public Long id;

	public String name;
	public String address;
	public String gender;
	public String birthDate;
	public String department;

	
	
	@Version
	public Timestamp lastUpdate;

	public static Finder<Long, Student> find = new Finder<Long, Student>(
			Long.class, Student.class);

}
