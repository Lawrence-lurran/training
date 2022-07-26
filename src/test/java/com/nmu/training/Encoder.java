package com.nmu.training;

import com.nmu.training.domain.entity.UserDO;
import com.nmu.training.mapper.UserMapper;
import com.nmu.training.util.ReadExcelUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2022/7/26 8:39 下午
 */
@SpringBootTest
public class Encoder {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserMapper userMapper;

    @Test
    void name() {
    }

    @Test
    public void encoder() throws FileNotFoundException {


//fileName可以定位为 String fileName =“你的路径” ，下面这样写是为了上传至服务器,如果感兴趣可以看我的服务器上传讲解
        String fileName = "/Users/lurran/Downloads/信息统计表.xlsx";
//fileName = filePath + File.separator + fileName;
//根据路径生成 FileInputStream字节流
        FileInputStream inputStream = new FileInputStream(new File(fileName));
//通过ExcelUtils工具将Excel数据存入到list中，工具代码下面细讲,这一步读取Excel已经完成了，如果不想进行插入数据库操作，可以直接拿着list用啦。
        List<UserDO> list = ReadExcelUtil.createExcel(inputStream,false);
        for (UserDO userDO : list) {
            String username = userDO.getUsername();
            String encodePassword=bCryptPasswordEncoder.encode(username);
            userDO.setPassword(encodePassword);
            System.out.println(userDO);
            int insert = userMapper.insert(userDO);
            System.out.println(insert);
        }


//以上读取Excel完成，list就是数据,下面进行插入数据库的操作
//定义Excel第一行的属性




    }
}
