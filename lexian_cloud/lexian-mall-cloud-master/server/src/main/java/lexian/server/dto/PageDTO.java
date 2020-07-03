package lexian.server.dto;

import lombok.Data;

import java.util.List;

/**
 * @author neu
 * @date 2020/6/11
 **/
@Data
public class PageDTO<T> {
    private int page;
    private Long total;
    private Integer size;
    private List<T> list;
}
