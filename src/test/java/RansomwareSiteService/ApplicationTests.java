/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package RansomwareSiteService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private RansomwareSiteRepository ransomwareSiteRepository;

	@Before
	public void deleteAllBeforeTests() throws Exception {
		ransomwareSiteRepository.deleteAll();
		ransomwareSiteRepository.save(new RansomwareSite("Illinois", "208.100.26.251", "dyoravdkiavfkbkx.pw", "http://dyoravdkiavfkbkx.pw/userinfo.php", "Locky", 41.876148, -87.652071));
		ransomwareSiteRepository.save(new RansomwareSite("California", "107.154.158.80", "www.equilibriumm.com", "http://www.equilibriumm.com/KlfhsYYs", "GlobeImposter", 37.53244, -122.248835));
	}

	@Test
	public void shouldReturnRepositoryIndex() throws Exception {

		mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk()).andExpect(
				jsonPath("$._links.ransomwareSites").exists());
	}


	@Test
	public void shouldRetrieveAllEntities() throws Exception {
		mockMvc.perform(get("/ransomwareSites")).andDo(print()).andExpect(status().isOk()).andExpect(
				jsonPath("$[1]").exists());
		mockMvc.perform(get("/ransomwareSites")).andExpect(status().isOk()).andExpect(
				jsonPath("$[0].county").value("Illinois")).andExpect(
				jsonPath("$[1].county").value("California"));
	}
}