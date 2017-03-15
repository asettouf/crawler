package org.linkedin.crawler.models;

import java.util.List;

public abstract class Item extends NamedElement{
	protected String startDate;
	protected String endDate;
	protected String location;
	protected String duration;
	protected List<String> descriptionItems;
	
	
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public List<String> getDescriptionItems() {
		return descriptionItems;
	}
	public void setDescriptionItems(List<String> descriptionItems) {
		this.descriptionItems = descriptionItems;
	}
	public void addDescriptionItem(String descriptionItem){
		this.descriptionItems.add(descriptionItem);
	}
	
	

}
