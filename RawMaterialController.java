package com.example.demo;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("RawMaterialStock")
public class RawMaterialController {
	@Autowired 
	private RMRepository rmRepository;
	@Autowired
	private WarehouseRepository warehouseRepository;
	
	@GetMapping("AddRM")
	public String addRM(@RequestBody RawNWare rw)
	{	RawMaterial rm = new RawMaterial();
		Warehouse w = new Warehouse();
		rm.setMatName(rw.getMatName());
		rm.setMatDesc(rw.getMatDesc());
		rm.setQtyAvailable(rw.getQtyAvailable());
		w.setName(rw.getWarename());
		w.setDescription(rw.getWaredescription());
		warehouseRepository.save(w);
		rm.setWarehouse(w);
		rmRepository.save(rm);
		return "RawMaterial has been added successfully.";
	}
	@GetMapping("FetchAllRawMaterials")
	public ResponseEntity<List<RawMaterial>> fetchAllRawMaterial()
	{	return ResponseEntity.ok(rmRepository.findAll());
	}
	@GetMapping("FetchById")
	public ResponseEntity<RawMaterial> fetchById(@RequestParam long id)
	{	Optional<RawMaterial> optrm = rmRepository.findById(id);
		if(optrm.isPresent())
			return ResponseEntity.ok(optrm.get());
		else
			return ResponseEntity.notFound().build();
	}
	@GetMapping("update")
	public String update(@RequestBody RMStockRequest rmStockRequest)
	{	Optional<RawMaterial> optfetchedrm = rmRepository.findById(rmStockRequest.getRawMaterialId());
		if(optfetchedrm.isPresent())
		{	RawMaterial rwm = optfetchedrm.get();
			rwm.setQtyAvailable(rwm.getQtyAvailable()+rmStockRequest.getQty());
			rmRepository.save(rwm);
			return "RawMaterial stock updated successfully.";
		}	else
				return "RawMaterial not found in the inventory.";
	}
}
