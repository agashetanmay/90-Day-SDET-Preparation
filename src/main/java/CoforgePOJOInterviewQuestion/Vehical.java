package CoforgePOJOInterviewQuestion;

import java.util.Objects;

public class Vehical {
	
	private int serviceId;
	private String vehicalName;
	private boolean serviceStatus;
	
	public Vehical(int serviceId, String vehicalName, Boolean serviceStatus) {
		
		this.serviceId = serviceId;
		this.vehicalName = vehicalName;
		this.serviceStatus = serviceStatus;
	}
	
	public int getServiceId() {
		return serviceId;
	}
	public String getVehicalName() {
		return vehicalName;
	}
	public boolean getServiceStatus() {
		return serviceStatus;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	public void setVehicalName(String vehicalName) {
		this.vehicalName = vehicalName;
	}
	public void setServiceStatus(Boolean serviceStatus) {
		this.serviceStatus = serviceStatus;
	}
    
	@Override
	public String toString() {
		return "Vehical [serviceId=" + serviceId + ", vehicalName=" + vehicalName + ", serviceStatus=" + serviceStatus
				+ "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(serviceId, serviceStatus, vehicalName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehical other = (Vehical) obj;
		return serviceId == other.serviceId && serviceStatus == other.serviceStatus
				&& Objects.equals(vehicalName, other.vehicalName);
	}
	
	

}
