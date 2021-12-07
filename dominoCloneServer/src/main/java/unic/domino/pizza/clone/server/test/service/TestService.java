package unic.domino.pizza.clone.server.test.service;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unic.domino.pizza.clone.server.test.entity.Memo;
import unic.domino.pizza.clone.server.test.mapper.TestMapper;
import unic.domino.pizza.clone.server.test.repository.MemoRepository;
import unic.domino.pizza.clone.server.test.vo.TestVo;

@Service 
public class TestService { 
	
	@Autowired 
	public TestMapper mapper; 

	@Autowired 
	MemoRepository memoRepository;
	
	public List<TestVo> selectTest() { 
		
		IntStream.rangeClosed(1, 10).forEach(i -> { 
			Memo memo = Memo.builder() 
					.memoText("Sample..." + i) 
					.build(); //Create! 
			memoRepository.save(memo); 
			});
		
		return mapper.selectTest(); 
	}
}

