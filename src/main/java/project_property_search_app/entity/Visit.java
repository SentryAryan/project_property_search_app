package project_property_search_app.entity;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Visit {
	    private int visitId;
	    private int buyerId;
	    private int propertyId;
	    private Date visitDate;
	    private String status;
    
    public Visit() {}
    
	public Visit(int visitId, int buyerId, int propertyId, Date visitDate, String status) {
		super();
		this.visitId = visitId;
		this.buyerId = buyerId;
		this.propertyId = propertyId;
		this.visitDate = visitDate;
		this.status = status;
	}

	public int getVisitId() {
		return visitId;
	}

	public void setVisitId(int visitId) {
		this.visitId = visitId;
	}

	public int getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}

	public int getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Visit [visitId=" + visitId + ", buyerId=" + buyerId + ", propertyId=" + propertyId + ", visitDate="
				+ visitDate + ", status=" + status + "]";
	}
	
	public Object getBuyerUsername() {
		// TODO Auto-generated method stub
		return null;
	}
 
	public void setBuyerUsername(String buyerUsername) {
		// TODO Auto-generated method stub
	}
 
	public void setPropertyTitle(String propertyTitle) {
		// TODO Auto-generated method stub
	}
 
	public void setVisitDate(String visitDate2) {
		// TODO Auto-generated method stub
	}

	public void setMessage(String string) {
		// TODO Auto-generated method stub
		
	}

	
}




	