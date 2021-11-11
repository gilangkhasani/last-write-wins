package id.last_write_win.controller;

import id.last_write_win.service.DataService;
import id.last_write_win.dto.DataDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gpk
 */
@RestController
@RequestMapping("/data")
public class DataController {
    private final DataService dataService;

    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @PostMapping()
    public ResponseEntity<DataDto> list(@RequestBody DataDto inputDataDto) {
        DataDto outputDataDto = dataService.outputDataDto(inputDataDto);
        return new ResponseEntity(outputDataDto, HttpStatus.OK);
    }
}
