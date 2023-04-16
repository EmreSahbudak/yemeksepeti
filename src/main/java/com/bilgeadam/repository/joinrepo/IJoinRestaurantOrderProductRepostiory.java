package com.bilgeadam.repository.joinrepo;

import com.bilgeadam.entity.jointable.JoinRestaurantOrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJoinRestaurantOrderProductRepostiory extends JpaRepository<JoinRestaurantOrderProduct,Long> {

    @Query(value = "select o.order_id, r.restaurant_name, p.product_name, p.cost from tblorder as o\n" +
            "inner join restaurant as r on r.restaurant_id= o.restaurant_id \n" +
            "inner join order_products_id as op on o.order_id=op.order_order_id\n" +
            "inner join product as p on p.product_id=op.products_id where r.restaurant_id=2", nativeQuery = true)
    List<JoinRestaurantOrderProduct> restaurantOrderProducts();
}
