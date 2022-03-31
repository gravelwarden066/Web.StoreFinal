package com.project.web.store;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;


import com.project.web.store.models.Product;
import com.project.web.store.repository.ProductDao;
import com.project.web.store.services.ProductServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {
    @InjectMocks
    ProductServiceImp productServiceImp;

    @Mock
    ProductDao productDao;

    @Test
    public void testFindAllOrders(){
        List<Product> list = new ArrayList<Product>();
        Product product1 = new Product(1L,"test1",1,1);
        Product product2 = new Product(2L,"test2",2,2);
        Product product3 = new Product(3L,"test3",3,3);


        list.add(product1);
        list.add(product2);
        list.add(product3);

        when(productDao.findAll()).thenReturn(list);
        List<Product> productList = productServiceImp.getAllProducts();
        assertEquals(3, productList.size());
        verify(productDao, times(1)).findAll();
        System.out.println(productList);
    }


}