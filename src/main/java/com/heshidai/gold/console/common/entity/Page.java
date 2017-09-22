package com.heshidai.gold.console.common.entity;

import java.util.List;

import com.heshidai.gold.console.module.sys.entity.Media;
import com.heshidai.gold.console.module.sys.entity.Orderinformation;

/**
 * 功能：基类page中包含公有翻页参数及保存查询到的结果以被页面遍历， 被子类继承后将增加不同的查询条件 。
 * 
 * @version 2016年12月28日下午8:59:57
 * @author baocheng.ren
 */
@SuppressWarnings("unused")
public class Page<T> {
	/**
	 * 每页显示条数默认为10条
	 */
	public static final int DEFAULT_SIZE = 10;

	/**
	 * 分页时中间显示多少页数
	 */
	public static final int DEFAULT_PAGER_RANGE = 7;

	/**
	 * 当前页码， 从1开始计
	 */
	private long page;

	/**
	 * 每页条数
	 */
	private int pagesize;

	/**
	 * 总条数
	 */
	private long totalElements;

	/**
	 * 当前页数据
	 */
	private List<T> datas;

	public Page() {
		// 设置默认值
		page = 1;
		pagesize = DEFAULT_SIZE;
	}

	/**
	 * 功能：获取当前页码
	 * 
	 * @version 2016年12月28日下午9:02:47
	 * @author baocheng.ren
	 * @return long
	 */
	public long getPage() {
		return page;
	}

	/**
	 * 功能：设置当前页码
	 * 
	 * @version 2016年12月28日下午9:03:00
	 * @author baocheng.ren
	 * @param page
	 *            分页类
	 */
	public void setPage(long page) {
		this.page = page;
	}

	/**
	 * 功能：获取每页显示条数
	 * 
	 * @version 2016年12月28日下午9:04:00
	 * @author baocheng.ren
	 * @return int
	 */
	public int getPagesize() {
		return pagesize;
	}

	/**
	 * 功能：设置每页显示条数
	 * 
	 * @version 2016年12月28日下午9:04:08
	 * @author baocheng.ren
	 * @param pagesize
	 *            条数
	 */
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	/**
	 * 功能：获取当前页数据
	 * 
	 * @version 2016年12月28日下午9:04:20
	 * @author baocheng.ren
	 * @return List<Object>
	 */
	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	


	/**
	 * 功能：设置当前页数据
	 * 
	 * @version 2016年12月28日下午9:04:27
	 * @author baocheng.ren
	 * @param list
	 *            数据
	 */

	/**
	 * 功能：获取总条数
	 * 
	 * @version 2016年12月28日下午9:04:54
	 * @author baocheng.ren
	 * @return long
	 */
	public long getTotalElements() {
		return totalElements;
	}

	/**
	 * 功能：设置总条数
	 * 
	 * @version 2016年12月28日下午9:05:07
	 * @author baocheng.ren
	 * @param totalElements
	 *            数据总数
	 */
	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}

	/**
	 * 功能：获取总页数
	 * 
	 * @version 2016年12月28日下午9:05:22
	 * @author baocheng.ren
	 * @return long
	 */
	public long getTotalPages() {
		if (totalElements == 0) {
			return 0;
		}

		long totalPages = totalElements / pagesize;
		if (totalElements % pagesize != 0) {
			totalPages++;
		}

		return totalPages;
	}

}