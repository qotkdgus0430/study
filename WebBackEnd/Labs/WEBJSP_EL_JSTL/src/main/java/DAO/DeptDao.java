package DAO;

import java.util.ArrayList;
import java.util.List;

import DTO.Dept;

public class DeptDao {

	public List<Dept> getDeptList(){
		//DB 작업하고 4건 select 해서 작업했다는 가정하에
		List<Dept> list = new ArrayList<Dept>();
		
		list.add(new Dept(10, "AA", "AAA"));
		list.add(new Dept(20, "BB", "BBB"));
		list.add(new Dept(30, "CC", "CCC"));
		list.add(new Dept(40, "DD", "DDD"));
		
		return list;
	}
}