package id.last_write_win.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author gpk
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataListDto {
    private Integer id;
    private String field;
}
