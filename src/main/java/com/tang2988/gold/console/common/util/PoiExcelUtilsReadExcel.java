package com.tang2988.gold.console.common.util;

import java.util.List;
import java.util.Set;

/**
 * 功能：文件路径读取excel类参数
 *
 * @version 2017年2月16日下午4:39:42
 * @author baocheng.ren
 */
public class PoiExcelUtilsReadExcel {
    
    private String excelPath;
    
    private int skipRows;
    
    private int columnCount;
    
    private int sheetNo;
    
    private Set<Integer> columnNumberForSkipValueValidateSet;
    
    private List<String> noneCellValuePositionList;
    
    public String getExcelPath() {
        return excelPath;
    }
    
    public void setExcelPath(String excelPath) {
        this.excelPath = excelPath;
    }
    
    public int getSkipRows() {
        return skipRows;
    }
    
    public void setSkipRows(int skipRows) {
        this.skipRows = skipRows;
    }
    
    public int getColumnCount() {
        return columnCount;
    }
    
    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
    }
    
    public int getSheetNo() {
        return sheetNo;
    }
    
    public void setSheetNo(int sheetNo) {
        this.sheetNo = sheetNo;
    }
    
    public Set<Integer> getColumnNumberForSkipValueValidateSet() {
        return columnNumberForSkipValueValidateSet;
    }
    
    public void setColumnNumberForSkipValueValidateSet(Set<Integer> columnNumberForSkipValueValidateSet) {
        this.columnNumberForSkipValueValidateSet = columnNumberForSkipValueValidateSet;
    }
    
    public List<String> getNoneCellValuePositionList() {
        return noneCellValuePositionList;
    }
    
    public void setNoneCellValuePositionList(List<String> noneCellValuePositionList) {
        this.noneCellValuePositionList = noneCellValuePositionList;
    }
    
}
