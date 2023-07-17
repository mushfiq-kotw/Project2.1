package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class RawMaterial {
	@Id
	@Column(name="rawMaterial_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long rawMaterialId;
	private String matName;
	private String matDesc;
	private Double qtyAvailable;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="warehouse_id")	
	private Warehouse warehouse;
	
	
	public String getMatName() {
		return matName;
	}
	public void setMatName(String matName) {
		this.matName = matName;
	}
	public String getMatDesc() {
		return matDesc;
	}
	public void setMatDesc(String matDesc) {
		this.matDesc = matDesc;
	}
	public Double getQtyAvailable() {
		return qtyAvailable;
	}
	public void setQtyAvailable(Double qtyAvailable) {
		this.qtyAvailable = qtyAvailable;
	}
	public long getRawMaterialId() {
		return rawMaterialId;
	}
	public void setRawMaterialId(long rawMaterialId) {
		this.rawMaterialId = rawMaterialId;
	}
	public Warehouse getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}
	
	
}
