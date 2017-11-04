package org.cloudnote.core.query;

import org.cloudnote.core.entity.BaseIDEntity;
import org.cloudnote.util.system.ConversionObject;
import org.cloudnote.util.system.ObjectUtils;

public class BaseQueryPage<T extends BaseIDEntity> extends BaseQuryBean<T> {
	public static final Long DEFAULT_PAGE_SIZE = Long.valueOf(15L);
    public static final Long DEFAULT_MAX_PAGE_SIZE = Long.valueOf(Long.MAX_VALUE);
    private Integer currPage = null;
    private Long pageSize;
    private Long startIndex;
    private Long endIndex;
    private Integer recordCount;
    private Integer pageCount;

    public BaseQueryPage() {
        this.pageSize = DEFAULT_PAGE_SIZE;
        this.startIndex = null;
        this.endIndex = null;
        this.recordCount = null;
        this.pageCount = null;
    }

    public void setPageIndex(Integer pageIndex) {
        this.currPage = pageIndex;
    }

    public Integer getCurrPage() {
        if (ObjectUtils.isNull(this.currPage) || this.currPage.intValue() <= 0) {
            this.currPage = Integer.valueOf(1);
        }

        return this.currPage;
    }

    public void setCurrPage(Integer currPage) {
        if (ObjectUtils.isNull(currPage) || currPage.intValue() <= 0) {
            currPage = Integer.valueOf(1);
        }

        this.currPage = currPage;
    }

    public Long getPageSize() {
        if (ObjectUtils.isNull(this.pageSize) || this.pageSize.longValue() <= 0L) {
            this.pageSize = DEFAULT_PAGE_SIZE;
        }

        return this.pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public Long getStartIndex() {
        this.startIndex = Long.valueOf((long) (this.getCurrPage().intValue() - 1) * this.pageSize.longValue());
        return this.startIndex;
    }

    public void setStartIndex(Long startIndex) {
        this.startIndex = startIndex;
    }

    public Long getEndIndex() {
        this.startIndex = Long.valueOf((long) this.getCurrPage().intValue() * this.pageSize.longValue());
        return this.endIndex;
    }

    public void setEndIndex(Long endIndex) {
        this.endIndex = endIndex;
    }

    public Integer getRecordCount() {
        return this.recordCount;
    }

    public void setRecordCount(Integer recordCount) {
        this.recordCount = recordCount;
    }

    public Integer getPageCount() {
        if (ObjectUtils.isNull(this.pageCount) || this.pageCount.intValue() <= 0) {
            if (this.getRecordCount().intValue() <= 0) {
                this.pageCount = Integer.valueOf(0);
            } else if ((long) this.getRecordCount().intValue() % this.getPageSize().longValue() == 0L) {
                this.pageCount = ConversionObject.longToInteger(
                        Long.valueOf((long) this.getRecordCount().intValue() / this.getPageSize().longValue()));
            } else {
                this.pageCount = Integer.valueOf(ConversionObject
                        .longToInteger(
                                Long.valueOf((long) this.getRecordCount().intValue() / this.getPageSize().longValue()))
                        .intValue() + 1);
            }
        }

        return this.pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }
}
