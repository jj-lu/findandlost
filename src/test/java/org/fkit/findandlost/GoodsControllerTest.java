package org.fkit.findandlost;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class GoodsControllerTest {
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mvc;
	
	@Before
	public void setupMockMvc() {
		mvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	
	@Test
	@Transactional
	public void insertGoods() throws Exception {
		String json = "{\"g_name\":\"学生证\",\"g_type\":\"证件\",\"g_ltime\":\"2019-11-21\",\"g_title\":\"今天丢失了学生证\",\"u_id\":\"1\"}";
		mvc.perform(MockMvcRequestBuilders.post("/insertGoods").contentType(MediaType.APPLICATION_JSON_UTF8).accept(MediaType.APPLICATION_JSON_UTF8).content(json.getBytes()))
		.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
	}
	
	
	
	

}
