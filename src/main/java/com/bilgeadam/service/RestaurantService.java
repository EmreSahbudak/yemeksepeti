package com.bilgeadam.service;

import com.bilgeadam.dto.request.RestaurantSaveRequestDto;
import com.bilgeadam.entity.Restaurant;
import com.bilgeadam.entity.jointable.JoinRestaurantOrderProduct;
import com.bilgeadam.mapper.IRestaurantMapper;
import com.bilgeadam.repository.IRestaurantRepository;
import com.bilgeadam.repository.joinrepo.IJoinRestaurantOrderProductRepostiory;
import com.bilgeadam.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService extends ServiceManager<Restaurant,Long> {

    private final IRestaurantRepository restaurantRepository;

    private final IJoinRestaurantOrderProductRepostiory joinRestaurantOrderProductRepostiory;

    public RestaurantService(IRestaurantRepository restaurantRepository,
                             IJoinRestaurantOrderProductRepostiory joinRestaurantOrderProductRepostiory) {
        super(restaurantRepository);
        this.restaurantRepository = restaurantRepository;
        this.joinRestaurantOrderProductRepostiory = joinRestaurantOrderProductRepostiory;
    }
    public String save(RestaurantSaveRequestDto dto){
        restaurantRepository.save(IRestaurantMapper.INSTANCE.toRestaurant(dto));
        return "Restaurant Save Success";
    }
    public List<JoinRestaurantOrderProduct> restaurantOrderProducts(){
        return joinRestaurantOrderProductRepostiory.restaurantOrderProducts();
    }




}
