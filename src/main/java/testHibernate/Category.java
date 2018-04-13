package testHibernate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Category {

	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	@OneToMany(mappedBy="category", cascade=CascadeType.ALL, fetch=FetchType.LAZY) // bidirection (cascade=CascadeType.ALL) // 연관 된 객체까지, persist delete
	// FetchType LAZY : 필요시에만 child class read, performance issue
	private Set<Product> products = new HashSet<Product>();
}
