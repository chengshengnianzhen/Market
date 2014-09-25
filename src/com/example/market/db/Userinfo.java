package com.example.market.db;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Table;

/**
 * Author: chsh-nianzhen
 *
 * Time: 2014��9��24��14:31:10
 */
// �������ע�⣬ �������������Ӱ��
@Table(name = "Userinfo", execAfterTableCreated = "CREATE UNIQUE INDEX index_name ON parent(userId)")
public class Userinfo extends EntityBase {

    @Column(column = "userId") // �������ע�⣬ ��������������Ӱ��
    public int userId;

    @Column(column = "username")
    private String username;

    @Column(column = "password")
    private String password;
    
    @Column(column = "isnetwork")
    private boolean isnetwork;
    
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isIsnetwork() {
		return isnetwork;
	}

	public void setIsnetwork(boolean isnetwork) {
		this.isnetwork = isnetwork;
	}
}
