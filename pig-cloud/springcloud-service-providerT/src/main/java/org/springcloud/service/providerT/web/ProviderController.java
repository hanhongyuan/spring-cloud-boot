package org.springcloud.service.providerT.web;


import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lengleng
 * @since 2017-08-19
 */
@SuppressWarnings("unused")
@RestController
public class ProviderController {
    @GetMapping("/test")
    public String test() {
//        int i = 1/ 0;
        return "PROVIDER-server2";
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String uploadFile(MultipartFile file) throws Exception{
        byte[] bytes = file.getBytes();
        File fileTosave = new File(file.getOriginalFilename());
        FileCopyUtils.copy(bytes,fileTosave);
        return fileTosave.getAbsolutePath();
    }
}
