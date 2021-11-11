package id.last_write_win.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.last_write_win.dto.DataDto;
import id.last_write_win.dto.DataListDto;
import id.last_write_win.service.DataService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.CoreMatchers.is;

@WebMvcTest(controllers = DataController.class)
@ActiveProfiles("test")
public class DataControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DataService dataService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldCreateNewData() throws Exception {

        given(dataService.outputDataDto(any(DataDto.class))).willAnswer((invocation) -> invocation.getArgument(0));

        DataDto data = new DataDto();
        List<DataListDto> dataListDto = new ArrayList<>();
        data.setId(1);
        data.setField("Data ke 1");
        dataListDto.add(new DataListDto(1, "Data ke 1.1"));
        dataListDto.add(new DataListDto(2, "Data ke 1.2"));
        dataListDto.add(new DataListDto(1, "Data ke 1.1s"));
        dataListDto.add(new DataListDto(3, "Data ke 1.3"));
        dataListDto.add(new DataListDto(2, "Data ke 1.2s"));
        data.setDataList(dataListDto);

        this.mockMvc.perform(post("/data")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(data)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.id", is(data.getId())))
                .andExpect(jsonPath("$.field", is(data.getField())))
                .andExpect(jsonPath("$.dataList.size()", is(data.getDataList().size())))
        ;
    }
}
