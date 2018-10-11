package co.uk.ocelotcr.SpellBreakHelper.Service;

import co.uk.ocelotcr.SpellBreakHelper.Repository.EquipmentRepository;
import co.uk.ocelotcr.SpellBreakHelper.Resource.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService {

    EquipmentRepository equipmentRepository;

    @Autowired
    public EquipmentService(EquipmentRepository equipmentRepository){
        this.equipmentRepository = equipmentRepository;

    }

    public Equipment getEquipmentById(int id){
        Optional<Equipment> byId = equipmentRepository.findById(new Integer(id));
        return byId.get();
    }

    public List<Equipment> getAllEquipment() {
        List<Equipment> equipmentList = new ArrayList<>();
        equipmentRepository.findAll().forEach(e-> equipmentList.add(e));
        return equipmentList;
    }

    public List<Equipment> getAllEquipmentByType(String type){
            return equipmentRepository.getAllByType(type);
    }

    public List<Equipment> getAllEquipmentByTier(String tier){
            return equipmentRepository.getAllByTier(tier);
    }

    public synchronized boolean addEquipment(Equipment equipment){
            equipmentRepository.save(equipment);
            return true;

    }
    public boolean updateEquipment(Equipment equipment){
        equipmentRepository.save(equipment);
        return true;
    }

    public void deleteEquipmentById(int id){
        equipmentRepository.delete(getEquipmentById(id));
    }

    public void deleteAllEquipment(){
        equipmentRepository.deleteAll();
    }



}
