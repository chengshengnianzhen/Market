package com.example.market.db;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Table;

/**
 * Author: chsh-nianzhen
 *
 * Time: 2014年9月26日13:44:21
 */
// 建议加上注解， 混淆后表名不受影响
@Table(name = "question")
public class question extends EntityBase {

    @Column(column = "userId") // 建议加上注解， 混淆后列名不受影响
    public int userId;

    @Column(column = "name")
    private String name;

    @Column(column = "number")
    private String number;
    
    @Column(column = "content")
    private String content;
    
    @Column(column = "time")
    private String time;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
    
	
}
