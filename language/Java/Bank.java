import org.apache.commons.lang3.builder.*;

 class Bank{
	String name;
	String address;

	public boolean equals(Object o){
		return EqualsBuilder.reflectionEquals(this,o);
	}
	public int hashCode(){
		return HashCodeBuilder.reflectionHashCode(this);
	}
}









