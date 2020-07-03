package lexian.sevice.controller;

import com.github.pagehelper.util.StringUtil;
import com.google.common.collect.Maps;
import lexian.server.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


/**
 * @author neu
 * @date 2020/6/11
 **/
@RestController
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    @PostMapping(value = "/queryAll")
    public Map<String, Object> queryAll(Integer page, Integer size) {
        Map<String, Object> resultMap = Maps.newHashMap();
        if (page == null || page == 0 || size == null || size == 0) {
            throw new RuntimeException("页码不正确");
        }
        resultMap.put("list", chapterService.queryAll(page,size));
        return resultMap;
    }
}
