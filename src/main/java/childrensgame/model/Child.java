package childrensgame.model;

/**
 * Model class containing properties of child object  
 * 
 * @author Tom Ward
 * @version 1.0
 * 
 */
public class Child {
	
	private Integer id;
	private Boolean elminated;
	
	public Child(Integer id){
		
		this.id = id;
		this.elminated = false;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean isElminated() {
		return elminated;
	}

	public void setElminated(Boolean elminated) {
		this.elminated = elminated;
	}
	
	
	

}
