package in.ineuron.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;



@Entity

public class Student {
	@Id
//	@GenericGenerator(name = "gen1",strategy = "increment")
//	@GeneratedValue(generator = "gen1")
//	@GenericGenerator(name = "gen1",strategy = "sequence")
//	@GeneratedValue(generator = "gen1")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)//Identity works with mysql
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@GenericGenerator(name="gen1",strategy = "in.ineuron.idgenerator.StudentGenerator")
	@GeneratedValue(generator = "gen1")
	private String sid;
	private String sname;
	private String saddress;
	private Integer sage;
	
	public Student() {
		System.out.println("Hibernate uses zero argument constructor internally");
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	public Integer getSage() {
		return sage;
	}
	public void setSage(Integer sage) {
		this.sage = sage;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", saddress=" + saddress + ", sage=" + sage + "]";
	}

}
