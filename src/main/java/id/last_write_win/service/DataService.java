package id.last_write_win.service;

import id.last_write_win.dto.DataDto;
import id.last_write_win.dto.DataListDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author gpk
 */
@Service
public class DataService {

    public DataDto outputDataDto(DataDto inputDataDto){
        Map<Integer, DataListDto> map =  new LinkedHashMap<>();
        for(DataListDto data : inputDataDto.getDataList()) {
            if(!map.containsKey(data.getId())){
                map.put(data.getId(), data);
            } else {
                map.replace(data.getId(), data);
            }
        }
        List<DataListDto> list = new ArrayList<>(map.values());
        inputDataDto.setDataList(list);
        return inputDataDto;
    }
}
