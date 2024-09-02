package com.introduction.ProductServiceAug24.Services;

import com.introduction.ProductServiceAug24.DTO.FakeStoreProductDto;
import com.introduction.ProductServiceAug24.Models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements ProductService{

    @Override
    public Product getProduct(long id) {
        /*
        Get ID as input and call FakeStore API for product details
         */
        String url="https://fakestoreapi.com/products/"+id;
        //RestTemplate class allows for calling third party API URLs.
        // RestTemplate obj.getForObject(url,dto_object) receives data from API and parses it to DTO object.
        RestTemplate rest=new RestTemplate();
        // API call
        FakeStoreProductDto fake_dto=rest.getForObject(url, FakeStoreProductDto.class); // creates DTO object by converting API data to DTO format.
        return convertFakeProductToCustomProduct(fake_dto);
    }

    private Product convertFakeProductToCustomProduct(FakeStoreProductDto fake_dto) {
        Product product=new Product();
        product.setName(fake_dto.getTitle());
        product.setCategory(fake_dto.getCategory());
        product.setDescription(fake_dto.getDescription());
        return product;
    }
}
