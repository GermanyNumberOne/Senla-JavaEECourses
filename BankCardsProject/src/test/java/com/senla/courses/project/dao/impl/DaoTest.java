package com.senla.courses.project.dao.impl;

import com.senla.courses.project.testconfig.H2Config;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {H2Config.class})
class DaoTest {

}