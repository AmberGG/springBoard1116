package org.zerock.web;

import java.util.Iterator;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*-context.xml" })
public class SmemControllerTest {

	private static final Logger logger = LoggerFactory.getLogger(SmemControllerTest.class);
	
	
	
	@Inject
	private WebApplicationContext ctx;
	
	private MockMvc mockMVC;
	
	
	//�����̶� test�������� �Ź� ȣ��ǰ� ��¥ ������Ʈ�� �������.
	@Before
	public void setup(){
		
		this.mockMVC = MockMvcBuilders.webAppContextSetup(ctx).build();
		
	}
	
	@Test
	public void testDOA() throws Exception{
		ResultActions result = mockMVC.perform(MockMvcRequestBuilders
				.get("/smem/doA")
				.param("userid", "AAA")
				.param("userpw", "BBB")); //��Ŀ� ���� .get or .post
		
		MvcResult mvcResult = result.andReturn();
		
		Map<String, Object> map = mvcResult.getModelAndView().getModel();
		logger.info(""+map.get("vo"));
		
		logger.info(""+"-------------------------");
		
		Iterator<String> it = map.keySet().iterator();
		
		while(it.hasNext()){
			String key = it.next();
			logger.info(""+"KEY:"+key);
			logger.info(""+"VALUE:"+map.get(key));
			logger.info(""+"-------------------------");
		}
		
	}
	
	@Test
	public void testDOAA() throws Exception{
		ResultActions result = mockMVC.perform(MockMvcRequestBuilders
				.post("/smem/doAA")
				.param("userid", "AAA")
				.param("userpw", "BBB")); //��Ŀ� ���� .get or .post
		
		MvcResult mvcResult = result.andReturn();
		
		Map<String, Object> map = mvcResult.getModelAndView().getModel();
		logger.info(""+"AA"+map.get("vo"));
		
		logger.info(""+"AA-------------------------");
		
		Iterator<String> it = map.keySet().iterator();
		
		while(it.hasNext()){
			String key = it.next();
			logger.info(""+"AA KEY:"+key);
			logger.info(""+"AA VALUE:"+map.get(key));
			logger.info(""+"AA-------------------------");
		}
		
	}
	
}
