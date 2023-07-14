package com.rays.auction;

import java.util.Set;

public class AuctionItem {

	private long id;
	private Set bids;
	private String description;
	private Bid succsessfulBid = null;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set getBids() {
		return bids;
	}

	public void setBids(Set bids) {
		this.bids = bids;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Bid getSuccsessfulBid() {
		return succsessfulBid;
	}

	public void setSuccsessfulBid(Bid succsessfulBid) {
		this.succsessfulBid = succsessfulBid;
	}

}
