package com.neu.quickapp.mapper;

import com.neu.quickapp.pojo.CutomerCoupon;
import com.neu.quickapp.pojo.CutomerCouponExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CutomerCouponMapper {
    int countByExample(CutomerCouponExample example);

    int deleteByExample(CutomerCouponExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CutomerCoupon record);

    int insertSelective(CutomerCoupon record);

    List<CutomerCoupon> selectByExample(CutomerCouponExample example);

    CutomerCoupon selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CutomerCoupon record, @Param("example") CutomerCouponExample example);

    int updateByExample(@Param("record") CutomerCoupon record, @Param("example") CutomerCouponExample example);

    int updateByPrimaryKeySelective(CutomerCoupon record);

    int updateByPrimaryKey(CutomerCoupon record);
}