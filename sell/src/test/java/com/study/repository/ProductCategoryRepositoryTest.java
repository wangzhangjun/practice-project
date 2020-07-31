package com.study.repository;

import com.study.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void findOneTest() {
        ProductCategory productCategory = productCategoryRepository.findOne(1);
        System.out.println(productCategory.toString());
    }

    @Test
    @Transactional  //这个注解在测试中表示只是想测试这个功能，测试数据直接回滚，不会插入到数据库中，但是在service中表示当数据出错时，才回滚。
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory("女何最爱",3);
        ProductCategory result = productCategoryRepository.save(productCategory);
        Assert.assertNotNull(result);
//        Assert.assertNotEquals(null, result);//这两个都是判断返回值不为Null
    }

    @Test
    public void findByCategoryTypeIn() {
        List<Integer> list = Arrays.asList(2, 3, 4);

        List<ProductCategory> productCategoryList = productCategoryRepository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0, productCategoryList.size());
    }
}