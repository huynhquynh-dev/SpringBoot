package com.laptrinhjavaweb.api.output;

import com.laptrinhjavaweb.dto.NewDto;

import java.util.ArrayList;
import java.util.List;

public class NewOutput {

    private int page;
    private int totalPage;
    private List<NewDto> listResult = new ArrayList<>();

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<NewDto> getListResult() {
        return listResult;
    }

    public void setListResult(List<NewDto> listResult) {
        this.listResult = listResult;
    }
}
