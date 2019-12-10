package org.lgj.ktp.util;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description = "JSON返回数据")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JSONResult<T> {
    public JSONResult() {
    }

    public JSONResult(Integer page, Integer pageSize, Integer totalCount, T data) {
        this.page = page;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.data = data;
    }

    public JSONResult(T data) {
        this.data = data;
    }

    /**
     * 消息
     */
    @ApiModelProperty(value = "消息", name = "message", dataType = "String")
    private Object message;

    /**
     * 当前页
     */
    @ApiModelProperty(value = "当前页", name = "page", dataType = "Integer")
    private Integer page = 1;

    /**
     * 分页大小
     */
    @ApiModelProperty(value = "分页大小", name = "pageSize", dataType = "Integer")
    private Integer pageSize = 10;

    /**
     * 总记录数
     */
    @ApiModelProperty(value = "总记录数", name = "totalCount", dataType = "Integer")
    private Integer totalCount;

    /**
     * 返回数据
     */
    @ApiModelProperty(value = "返回数据", name = "data", dataType = "Object")
    private T data;

    /**
     * 返回 消息
     */
    public Object getMessage() {
        return message;
    }

    /**
     * 设置 消息
     */
    public void setMessage(String  message) {
        this.message = message;
    }
    /**
     * 返回 当前页
     */
    public Integer getPage() {
        return page;
    }

    /**
     * 设置 当前页
     */
    public void setPage(Integer page) {
        this.page = page;
    }

    /**
     * 返回 分页大小
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * 设置 分页大小
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 返回 总记录数
     */
    public Integer getTotalCount() {
        return totalCount;
    }

    /**
     * 设置 总记录数
     */
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * 返回 返回数据
     */
    public T getData() {
        return data;
    }

    /**
     * 设置 返回数据
     */
    public void setData(T data) {
        this.data = data;
    }
}
