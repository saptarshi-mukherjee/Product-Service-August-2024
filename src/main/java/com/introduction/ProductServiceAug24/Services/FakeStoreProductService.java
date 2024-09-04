package com.introduction.ProductServiceAug24.Services;

import com.introduction.ProductServiceAug24.DTO.FakeStoreProductDto;
import com.introduction.ProductServiceAug24.Exceptions.ProductLimitOutOfBoundsException;
import com.introduction.ProductServiceAug24.Exceptions.ProductNotFoundExceptions;
import com.introduction.ProductServiceAug24.Models.Categories;
import com.introduction.ProductServiceAug24.Models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    @Override
    public Product getProduct(long id) throws ProductNotFoundExceptions {
        /*
        Get ID as input and call FakeStore API for product details
         */
        String url="https://fakestoreapi.com/products/"+id;
        //RestTemplate class allows for calling third party API URLs.
        // RestTemplate obj.getForObject(url,dto_object) receives data from API and parses it to DTO object.
        RestTemplate rest=new RestTemplate();
        // API call
        FakeStoreProductDto fake_dto=rest.getForObject(url, FakeStoreProductDto.class); // creates DTO object by converting API data to DTO format.
        if(fake_dto==null) {
            throw new ProductNotFoundExceptions("Product not in inventory");
        }
        return convertFakeProductToCustomProduct(fake_dto);
    }

    @Override
    public List<Product> getProductList() {
        String url="https://fakestoreapi.com/products/category/jewelery";
        RestTemplate rest=new RestTemplate();
        FakeStoreProductDto[] fake_prod_list=rest.getForObject(url, FakeStoreProductDto[].class);
        List<Product>prod_list=new ArrayList<Product>();
        for(int i=0;i<fake_prod_list.length;i++) {
            prod_list.add(convertFakeProductToCustomProduct(fake_prod_list[i]));
        }
        return prod_list;
    }

    @Override
    public Categories getCategories() {
        String url="https://fakestoreapi.com/products/categories";
        RestTemplate rest=new RestTemplate();
        String[] fake_categories=rest.getForObject(url, String[].class);
        return convertFakeCategoriesToCustomCategories(fake_categories);
    }

    @Override
    public List<Product> getPopularProducts(int size) throws ProductLimitOutOfBoundsException {
        if(size<1) {
            throw new ProductLimitOutOfBoundsException("Too few products. Try higher number");
        }
        if(size>20) {
            throw new ProductLimitOutOfBoundsException("Too many products. Try lower number");
        }
        String url="https://fakestoreapi.com/products?limit="+size;
        RestTemplate rest=new RestTemplate();
        FakeStoreProductDto[] fake_prod=rest.getForObject(url, FakeStoreProductDto[].class);
        List<Product> products=new ArrayList<Product>();
        for(FakeStoreProductDto p : fake_prod)
            products.add(convertFakeProductToCustomProduct(p));
        return products;
    }

    private Categories convertFakeCategoriesToCustomCategories(String[] fake_category) {
        Categories category=new Categories();
        category.setCat1(fake_category[0]);
        category.setCat2(fake_category[1]);
        category.setCat3(fake_category[2]);
        category.setCat4(fake_category[3]);
        return category;
    }

    private Product convertFakeProductToCustomProduct(FakeStoreProductDto fake_dto) {
        Product product=new Product();
        product.setName(fake_dto.getTitle());
        product.setCategory(fake_dto.getCategory());
        product.setDescription(fake_dto.getDescription());
        product.setId(fake_dto.getId());
        return product;
    }
}
