package unic.domino.pizza.clone.server.test.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import unic.domino.pizza.clone.server.test.vo.TestVo; 

@Repository 
@Mapper 
public interface TestMapper { 
	List<TestVo> selectTest(); 
}

