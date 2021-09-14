package com.ecomindo.onboarding.poc.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import com.ecomindo.onboarding.poc.dto.OptionsDTO;
import com.ecomindo.onboarding.poc.model.ShirtsModel;

@DataJpaTest
public class ShirtsDaoMockJPATest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ShirtsDao shirtsDao;

    @BeforeEach
    public void init() {
        // given
        ShirtsModel shirt1 = new ShirtsModel("productCode1", "name1", 1, 10.0, "desc1");
        entityManager.persist(shirt1);

        ShirtsModel shirt2 = new ShirtsModel("productCode2", "name2", 2, 20.0, "desc2");
        entityManager.persist(shirt2);

        entityManager.flush();
    }

    @Test
    public void test_findByProductCode() {
        ShirtsModel result = shirtsDao.findByProductCode("productCode1");

        assertThat(result.getProductCode()).isEqualTo("productCode1");
    }

    @Test
    public void test_deleteById() {
        ShirtsModel data = shirtsDao.findByProductCode("productCode1");
        shirtsDao.deleteById(data.getId());

        ShirtsModel result = shirtsDao.findByProductCode("productCode1");
        assertThat(result).isEqualTo(null);
    }

    @Test
    public void test_findByid() {
        ShirtsModel result = shirtsDao.findById(1);
        assertThat(result.getProductCode()).isEqualTo("productCode1");
    }

    @Test
    public void test_findDDLid() {
        List<OptionsDTO> result = shirtsDao.findDDLid();
        assertThat(result.size()).isEqualTo(2);
    }
}
