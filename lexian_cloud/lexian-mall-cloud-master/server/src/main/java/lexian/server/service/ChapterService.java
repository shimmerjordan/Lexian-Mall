package lexian.server.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lexian.server.dto.PageDTO;
import lexian.server.mapper.ChapterMapper;
import lexian.server.model.Chapter;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author neu
 * @date 2020/6/11
 **/
@Service
public class ChapterService {
    @Autowired
    private ChapterMapper chapterMapper;

    public PageDTO<Chapter> queryAll(Integer page,Integer size) {
        PageHelper.startPage(page,size);
        val queryWrapper = Wrappers.<Chapter>lambdaQuery();
        val list =  chapterMapper.selectList(queryWrapper);
        PageInfo<Chapter> pageInfo = new PageInfo<Chapter>(list);
        PageDTO pageDTO = new PageDTO();
        pageDTO.setList(list);
        pageDTO.setPage(page);
        pageDTO.setSize(size);
        pageDTO.setTotal(pageInfo.getTotal());
        return pageDTO;
    }
}
