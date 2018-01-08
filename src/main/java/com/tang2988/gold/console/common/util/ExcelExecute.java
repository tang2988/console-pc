package com.tang2988.gold.console.common.util;

/**
 * 功能：Excel导入方法执行实现类，跟进不同业务实现此接口
 *
 * @version 2017年1月4日下午2:12:48
 * @author baocheng.ren
 */
public interface ExcelExecute {
    
    /**
     * 功能：跟进行数据的数组，和自定义的数组传递参数进行不同的业务操作的接口方法
     *
     * @version 2017年1月4日下午2:13:02
     * @author baocheng.ren
     * @param rowData 为excel的单行数据的数组表示。如第一列就是rowData[0]。需对此参数作非null判断
     * @param diyParams 自定义的传递的参数数组
     */
    public void execute(String[] rowData, String[] diyParams);
}
