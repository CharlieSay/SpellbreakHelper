package co.uk.ocelotcr.SpellBreakHelper.Service;

import co.uk.ocelotcr.SpellBreakHelper.Config.Config;
import co.uk.ocelotcr.SpellBreakHelper.Resource.Equipment;
import org.junit.Test;
import org.mockito.Mock;

import java.io.IOException;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ImportServiceTest {

    ImportService importService;
    @Mock
    Config config;

    @Test
    public void should_AtleastWork(){
        config = mock(Config.class);

        when(config.getDatabasePwd()).thenReturn("busted29");
        when(config.getDatabaseUsername()).thenReturn("root");
        when(config.getDatabaseURL()).thenReturn("jdbc:mysql://127.0.0.1:3306");

        importService = new ImportService(config);

        try {
            List<Equipment> equipmentList = importService.extractData();
            for (Equipment equipment : equipmentList){
                System.out.println(equipment.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}