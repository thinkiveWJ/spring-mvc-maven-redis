package beacool.entity.base;

import beacool.entity.PatientTemp;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/5/18.
 */
public class BasePage {
    private int pageNum;
    private int pageSize;
    private long start;
    private long end;
    private int pageSizeDefault = 20;

    public int getPageSizeDefault() {
        return pageSizeDefault;
    }

    public void setPageSizeDefault(int pageSizeDefault) {
        this.pageSizeDefault = pageSizeDefault;
    }

    @Override
    public String toString() {
        return "BasePage{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", start=" + start +
                ", end=" + end +
                ", pageSizeDefault=" + pageSizeDefault +
                ", list=" + list +
                '}';
    }

    private Object list;

    public Object getList() {
        return list;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public void setList(Object list) {
        this.list = list;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
