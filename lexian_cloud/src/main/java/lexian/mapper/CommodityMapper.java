package lexian.mapper;

import lexian.entity.Commodity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommodityMapper {
    List<Commodity> getAllShopCommodity();
    void updateGood(Commodity updateGood);
}