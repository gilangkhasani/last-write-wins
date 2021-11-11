package id.last_write_win.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 *
 * @author gpk
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataDto {
    private Integer id;
    private String field;
    private List<DataListDto> dataList;
}
