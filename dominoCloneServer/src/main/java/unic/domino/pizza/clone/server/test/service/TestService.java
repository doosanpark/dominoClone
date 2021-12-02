package unic.domino.pizza.clone.server.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unic.domino.pizza.clone.server.test.mapper.TestMapper;
import unic.domino.pizza.clone.server.test.vo.TestVo;

@Service 
public class TestService { 
	
	@Autowired 
	public TestMapper mapper; 
	
	public List<TestVo> selectTest() { 
		return mapper.selectTest(); 
	} 
}

