package com.rays.auction;

public class Bid {

	private long id;
	private int amount;
	private String timestamp;
	private long ItemId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public long getItemId() {
		return ItemId;
	}

	public void setItemId(long itemId) {
		ItemId = itemId;
	}

}
