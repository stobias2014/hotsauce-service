package com.tobias.saul.hotsauceservice.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component("prototype")
public class Hotsauce {
	
	@Id
	@Column(name = "hotsauce_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long hotsauceId;
	private String name;
	@Column(name = "scoville_level")
	private int scovilleLevel;
	private BigDecimal price;
	
	public Hotsauce() {}
	
	

	public Hotsauce(Long hotsauceId, String name, int scovilleLevel, BigDecimal price) {
		super();
		this.hotsauceId = hotsauceId;
		this.name = name;
		this.scovilleLevel = scovilleLevel;
		this.price = price;
	}



	public Hotsauce(String name, int scovilleLevel, BigDecimal price) {
		this.name = name;
		this.scovilleLevel = scovilleLevel;
		this.price = price;
	}

	public Long getHotsauceId() {
		return hotsauceId;
	}

	public void setHotsauceId(Long hotsauceId) {
		this.hotsauceId = hotsauceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScovilleLevel() {
		return scovilleLevel;
	}

	public void setScovilleLevel(int scovilleLevel) {
		this.scovilleLevel = scovilleLevel;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hotsauceId == null) ? 0 : hotsauceId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + scovilleLevel;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hotsauce other = (Hotsauce) obj;
		if (hotsauceId == null) {
			if (other.hotsauceId != null)
				return false;
		} else if (!hotsauceId.equals(other.hotsauceId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (scovilleLevel != other.scovilleLevel)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Hotsauce: [hotsauceId=" + hotsauceId + ", name=" + name + ", scovilleLevel=" + scovilleLevel + ", price="
				+ price + "]";
	}
	
}
