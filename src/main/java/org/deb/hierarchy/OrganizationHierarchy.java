package org.deb.hierarchy;

public class OrganizationHierarchy {

	private Employee ceo;
	
	public Employee getCeo() {
		return ceo;
	}

	public void setCeo(Employee ceo) {
		this.ceo = ceo;
	}

	/**
	 * 
	 * @param ceo
	 */
	public OrganizationHierarchy(Employee ceo){
		this.ceo = ceo;
	}

	/**
	 * 
	 * @param ceo
	 * @param e1
	 * @param e2
	 * @return
	 */
	public Employee getLowestCommonAncesstor(Employee ceo, Employee e1, Employee e2){
		
			if (e1==e2){
				return e1;
			}
			if (ceo != null && ceo.getSubordinates().contains(e1) && ceo.getSubordinates().contains(e2)) {
				return ceo;
			}
			
			if (e1.getSubordinates() != null && e1.getSubordinates().contains(e2)){
				return e1;
			}
			
			if (e2.getSubordinates() != null && e2.getSubordinates().contains(e1)){
				return e2;
			}
			
			return getLowestCommonAncesstor(ceo, e1.getBoss(), e2.getBoss());
	}
}
