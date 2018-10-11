package co.uk.ocelotcr.SpellBreakHelper.Service;

import co.uk.ocelotcr.SpellBreakHelper.Config.Config;
import co.uk.ocelotcr.SpellBreakHelper.Resource.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImportService {

    private static final String CSV_URL = "/Users/charlie.say/PersonalProjects/SpellBreakHelper/src/main/resources/Test.csv";
    private String line = "";
    private String cvsSplitBy = ",";
    private Config config;

    @Autowired
    public ImportService(Config config){
        this.config = config;
    }


    public List<Equipment> extractData() throws IOException {
        List<Equipment> equipmentList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(CSV_URL));

        while ((line = br.readLine()) != null) {
            String[] values = line.split(cvsSplitBy);
            equipmentList.add(new Equipment(values[0],values[3],values[2],values[1]));
        }
        br.close();
        return equipmentList;
    }

}
