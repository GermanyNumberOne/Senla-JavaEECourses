package com.dao.api;

import com.testconfig.H2Config;
import com.testconfig.TestConfig;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {H2Config.class})
class DaoTest {

}