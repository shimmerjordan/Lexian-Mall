package lexian.mapper;

import lexian.entity.Activity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
//活动mapper
public interface ActivityMapper {

    /**
     * 获取全部活动信息
     * @return
     */
    List<Activity> getAllActivity();

    /**
     * 更新活动信息
     * @param map
     * @return
     */
    int updateActivity(Map<String,Object> map);

    /**
     * 删除活动信息
     * @param map
     * @return
     */
    int deleteActivity(Map<String,Object> map);

    /**
     *更新活动状态为0（已发布）
     * @param map
     * @return
     */
    int updateActivityStatus0(Map<String,Object> map);

    /**
     * 更新活动状态为1（操作）
     * @param map
     * @return
     */
    int updateActivityStatus1(Map<String,Object> map);

    /**
     *
     * @return
     */
    List<Activity> getIndexActivity();

    /**
     * 获取活动最大id
     * @return
     */
    int getMaxActivityId();

    /**
     * 插入活动信息
     * @param map
     * @return
     */
    int insertActivity(Map<String, Object> map);

    /**
     * 通过传入数据查询活动信息
     * @param map
     * @return
     */
    List<Activity> searchActivityByInformation(Map<String,Object>map);


}