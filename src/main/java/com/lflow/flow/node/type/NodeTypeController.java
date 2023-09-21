package com.lflow.flow.node.type;

import com.lflow.commons.http.Result;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Title: NodeTypeController
 * @Package com.lflow.controller
 * @Author: Lee YiFan
 * @CreateTime: 2023/9/19 18:13
 */

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class NodeTypeController {
    private final NodeTypeService nodeTypeService;
    private static final List<String> MENU = Arrays.asList("基础", "运算", "解析", "网络", "数据库", "子流程");

    @GetMapping("/node/type")
    public Result<Document> getNodeType() {
        Document result = nodeTypeService.findAll();
        return Result.of(result);
    }
}
