package com.neu.quickapp.mapper;

import com.neu.quickapp.pojo.WalletBill;
import com.neu.quickapp.pojo.WalletBillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WalletBillMapper {
    int countByExample(WalletBillExample example);

    int deleteByExample(WalletBillExample example);

    int insert(WalletBill record);

    int insertSelective(WalletBill record);

    List<WalletBill> selectByExample(WalletBillExample example);

    int updateByExampleSelective(@Param("record") WalletBill record, @Param("example") WalletBillExample example);

    int updateByExample(@Param("record") WalletBill record, @Param("example") WalletBillExample example);
}