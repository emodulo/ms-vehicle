package br.com.emodulo.vehicle.adapter.in.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ApiResponse <T> {
    private List<T> data;
    private PaginationResponse pagination;

    public ApiResponse(List<T> data, PaginationResponse pagination) {
        this.data = data;
        this.pagination = pagination;
    }
}
