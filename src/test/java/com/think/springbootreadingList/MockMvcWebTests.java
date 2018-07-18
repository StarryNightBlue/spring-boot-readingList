/**
 * @author StarryNight
 * @date 2018年5月9日 
 */
package com.think.springbootreadingList;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author StarryNight
 * @data 2018年5月9日 下午3:43:27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootReadingListApplication.class)
// @SpringApplicationConfiguration(classes=SpringBootReadingListApplication.class)
@WebAppConfiguration // 开启web 上下文测试
public class MockMvcWebTests {

	@Autowired
	private WebApplicationContext webContext;// 注入WebApplicationContext

	private MockMvc mockMvc;

	@Before
	public void setupMockMvc() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webContext).build();// 设置MockMvc
	}

	@Test
	public void homePage() throws Exception {
		mockMvc.perform(get("/readingList"))
			.andExpect(status().isOk())
			.andExpect(view().name("readingList"))
			.andExpect(model().attributeExists("books"))
			.andExpect(model().attribute("books", is(empty())));
	}
}
