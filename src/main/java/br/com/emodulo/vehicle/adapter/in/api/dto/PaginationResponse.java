package br.com.emodulo.vehicle.adapter.in.api.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Getter
@Setter
public class PaginationResponse {
    private Integer page;
    private Integer pageSize;
    private Long totalElements;
    private Integer totalPages;

    public PaginationResponse(Integer page, Integer pageSize, Long totalElements, Integer totalPages) {
        this.page = page;
        this.pageSize = pageSize;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
    }

    public static PaginationResponse fromPage(Page<?> page){
        return new PaginationResponse(
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages()
        );
    }
}
