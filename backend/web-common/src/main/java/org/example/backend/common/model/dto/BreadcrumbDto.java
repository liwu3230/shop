package org.example.backend.common.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2022/9/30 23:39
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BreadcrumbDto {

    private String name;

    private String router;

}
