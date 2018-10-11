package co.uk.ocelotcr.SpellBreakHelper.Controller;


import co.uk.ocelotcr.SpellBreakHelper.Resource.Equipment;
import co.uk.ocelotcr.SpellBreakHelper.Service.EquipmentService;
import co.uk.ocelotcr.SpellBreakHelper.Service.ImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = "/equipment")
public class EquipmentController {

    EquipmentService equipmentService;
    ImportService importService;


    @Autowired
    public EquipmentController(EquipmentService equipmentService, ImportService importService) {
        this.equipmentService = equipmentService;
        this.importService = importService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Equipment> getEquipmentById(@PathVariable("id") Integer id){
        Equipment equipmentById = equipmentService.getEquipmentById(id);
        return ResponseEntity.ok().body(equipmentById);
    }
//
//    @GetMapping("{name}")
//    public ResponseEntity<Equipment> getEquipmentByName(@PathVariable("name")String name){
//        Equipment equipmentByName = equipmentService.getEquipmentByName(name);
//        return ResponseEntity.ok().body(equipmentByName);
//    }
//
//    @GetMapping("{tier}")
//    public ResponseEntity<List<Equipment>> getAllEquipmentByTier(@PathVariable("tier")String tier){
//        List<Equipment> equipmentList = equipmentService.getAllEquipmentByTier(tier);
//        return ResponseEntity.ok().body(equipmentList);
//    }
//
//    @GetMapping("{type}")
//    public ResponseEntity<List<Equipment>> getAllEquipmentByType(@PathVariable("type")String type){
//        List<Equipment> equipmentList = equipmentService.getAllEquipmentByType(type);
//        return ResponseEntity.ok().body(equipmentList);
//    }

    @GetMapping("/all")
    public ResponseEntity<List<Equipment>> getAllEquipment(){
        List<Equipment> equipmentList = equipmentService.getAllEquipment();
        return ResponseEntity.ok().body(equipmentList);
    }

    @PostMapping("/addCSV")
    public ResponseEntity<Void> insertCSV(){
        List<Equipment> equipmentList = null;
        try {
           equipmentList = importService.extractData();
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        if (equipmentList != null) {
            for (Equipment equipment : equipmentList){
                postNewEquipment(equipment);
            }
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> postNewEquipment(@RequestBody Equipment equipment) {
        boolean flag = equipmentService.addEquipment(equipment);
        if (flag == false) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Equipment> updateEquipment(@RequestBody Equipment equipment) {
        equipmentService.updateEquipment(equipment);
        return new ResponseEntity<>(equipment, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteEquipment(@PathVariable int id){
        equipmentService.deleteEquipmentById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllEquipment(){
        equipmentService.deleteAllEquipment();
        return ResponseEntity.ok().build();
    }

}
