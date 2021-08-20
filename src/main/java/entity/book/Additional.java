package entity.book;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Additional {
    @JsonProperty("pageCount")
    private int pageCount;
    @JsonProperty("size")
    private Size size;

    public Additional(){};

    public Additional(int pageCount, Size size) {
        this.pageCount = pageCount;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Additional{" +
                "pageCount=" + pageCount +
                ", size=" + size +
                '}';
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}
