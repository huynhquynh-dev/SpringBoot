package com.laptrinhjavaweb.api.input;

import com.laptrinhjavaweb.dto.NewDto;

import java.util.ArrayList;
import java.util.List;

public class NewInput {

    private int page;
    private int limit;
    private List<NewDto> news = new ArrayList<>();

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public List<NewDto> getNews() {
        return news;
    }

    public void setNews(List<NewDto> news) {
        this.news = news;
    }
}
