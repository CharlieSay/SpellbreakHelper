package co.uk.ocelotcr.SpellBreakHelper.Repository;

import co.uk.ocelotcr.SpellBreakHelper.Resource.Equipment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepository extends CrudRepository<Equipment, Integer> {
    List<Equipment> getAllByType(String type);
    List<Equipment> getAllByTier(String tier);
}
