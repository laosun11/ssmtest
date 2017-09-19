package ssmtest.scy.service;

import java.util.List;
import java.util.Map;

import ssmtest.scy.pojo.User;

public interface UserService {
	//增加
	int add(User user);
	//删除
	int delete(String id);
	//修改
	int update(User user);
	//根据id查询
	User findById(String id);
	//查询全部
	List<User> find(Map<String, Object> params);
	void save(User u);
}
